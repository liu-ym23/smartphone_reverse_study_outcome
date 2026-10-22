package lcb;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.lark.pb.basic.v1.DomainSettings;
import com.bytedance.lark.pb.basic.v1.GetInitSettingsResponse;
import com.bytedance.lark.pb.basic.v1.InitSDKRequest;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.ApkUtil;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larksuite.framework.utils.j0;
import com.larksuite.framework.utils.z;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.dynamicconfig.v2.interfaces.IGlobalDomainConfigService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import com.suite.lark.platform.component.storage.file.LarkFileStorage;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;
import javax.inject.Singleton;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Singleton
public final class d extends c0c.b implements IGlobalDomainConfigService, mcb.b {
    public static final Object h = null;
    public final Object b;

    @Inject
    public j c;
    public Map<String, DomainSettings.Pair> d;
    public final Map<String, Map<String, DomainSettings.Pair>> e;
    public final Map<String, CopyOnWriteArrayList<mcb.a>> f;
    public final List<mcb.a> g;

    static {
        h = new Object();
    }

    public static com.ss.android.lark.storage.kv.repo.a uf() {
        return kcb.a.b("DYNAMIC_DOMAIN_MMKV_V3_ID");
    }

    @Override // com.ss.android.lark.dynamicconfig.v2.interfaces.IGlobalDomainConfigService
    public final String f0() {
        if (DevEnvUtil.isDebugMode(com.larksuite.framework.utils.b.a) == false) goto L7;
        String r0 = LarkAppContext.inst().buildConfig().getCommitId();
        if (TextUtils.equals(r0, kcb.a.a().getString("GIT_COMMIT_IT", BuildConfig.FLAVOR)) == true) goto L7;
        Log.i("GlobalDomainConfigService", "The GIT_COMMIT_ID of installation package has changed");
        kcb.a.a().putString("GIT_COMMIT_IT", r0);
        rf(true);
    L7:
        OutputStream r2 = null;
        String r4 = null;
        int r3 = 0;
    L9:
        if (r3 >= 5) goto L104;
        VFSPath r5 = LarkFileStorage.b().b(com.ss.android.lark.storage.f.d, new com.ss.android.lark.storage.d(new String[]{"core", "rust_config"}));
        Object r6 = h;
        monitor-enter(r6);
        VFSFile r7 = new VFSFile(r5);     // Catch: Throwable -> L101
        if (r7.exists() == true) goto L15;
        r7.mkdirs();     // Catch: Throwable -> L101
    L15:
        String r8 = kcb.a.a().getString("KEY_LARK_SETTING_VERSION_RECORD", BuildConfig.FLAVOR);     // Catch: Throwable -> L101
        String r9 = ApkUtil.getAppVersionName(com.larksuite.framework.utils.b.a);     // Catch: Throwable -> L101
        VFSFile r10 = new VFSFile(r5.subPath("lark_settings"));     // Catch: Throwable -> L101
        if (r10.exists() == true) goto L18;
    L125:
        r10.delete();     // Catch: Throwable -> L50 Exception -> L52 IOException -> L66
        r10.createNewFile();     // Catch: Throwable -> L50 Exception -> L52 IOException -> L66
        InputStream r11 = com.larksuite.framework.utils.b.a.getAssets().open("lark_settings");     // Catch: Throwable -> L50 Exception -> L52 IOException -> L66
    L127:
        OutputStream r12 = VFSFiles.b.E(r10);     // Catch: Throwable -> L44 Exception -> L46 IOException -> L48
    L121:
        byte[] r13 = new byte[ChameleonContainerUtils.MAX_URL_LENGTH];     // Catch: Exception -> L40 IOException -> L42 Throwable -> L88
    L26:
        int r14 = r11.read(r13);     // Catch: Exception -> L40 IOException -> L42 Throwable -> L88
        if (r14 <= (-1)) goto L29;
        r12.write(r13, 0, r14);     // Catch: Exception -> L40 IOException -> L42 Throwable -> L88
        goto L26
    L29:
        r12.flush();     // Catch: Exception -> L40 IOException -> L42 Throwable -> L88
        kcb.a.a().putString("KEY_LARK_SETTING_VERSION_RECORD", r9);     // Catch: Exception -> L40 IOException -> L42 Throwable -> L88
        Log.i("GlobalDomainConfigService", "finish loadConfigFileFromAssets version is " + r9);     // Catch: Exception -> L40 IOException -> L42 Throwable -> L88
        r12.close();     // Catch: Exception -> L32 Throwable -> L101
    L105:
        r11.close();     // Catch: Exception -> L36 Throwable -> L101
    L38:
        monitor-exit(r6);     // Catch: Throwable -> L101
    L39:
        boolean r15 = true;
    L82:
        if (r15 == true) goto L84;
        Log.e("GlobalDomainConfigService", "getSdkConfigDirPath load init config failed.");
        r4 = null;
    L86:
        if (TextUtils.isEmpty(r4) == false) goto L104;
        Log.i("GlobalDomainConfigService", "getSdkConfigDirPath auto retry times " + r3);
        r3 = r3 + 1;
        goto L9
    L84:
        r4 = r5.getAbsolutePath();
        goto L86
    L36:
        e = move-exception;
        Log.w("GlobalDomainConfigService", e);     // Catch: Throwable -> L101
        goto L38
    L32:
        e = move-exception;
        Log.w("GlobalDomainConfigService", e);     // Catch: Throwable -> L101
        goto L105
    L88:
        th = th;
        r2 = r12;
    L90:
        if (r2 != null) goto L123;
    L95:
        if (r11 == null) goto L132;
        r11.close();     // Catch: Exception -> L98 Throwable -> L101
    L133:
        throw th;     // Catch: Throwable -> L101
    L98:
        e = move-exception;
        Log.w("GlobalDomainConfigService", e);     // Catch: Throwable -> L101
        throw th;     // Catch: Throwable -> L101
    L132:
        throw th;     // Catch: Throwable -> L101
    L123:
        r2.close();     // Catch: Exception -> L93 Throwable -> L101
    L93:
        e = move-exception;
        Log.w("GlobalDomainConfigService", e);     // Catch: Throwable -> L101
    L42:
        IOException e = e;
    L68:
        Log.w("GlobalDomainConfigService", e);     // Catch: Throwable -> L88
        if (r12 != null) goto L111;
    L74:
        if (r11 != null) goto L117;
    L80:
        monitor-exit(r6);     // Catch: Throwable -> L101
        r15 = false;
        goto L82
    L117:
        r11.close();     // Catch: Exception -> L77 Throwable -> L101
    L77:
        e = e;
    L79:
        Log.w("GlobalDomainConfigService", e);     // Catch: Throwable -> L101
        goto L80
    L111:
        r12.close();     // Catch: Exception -> L72 Throwable -> L101
    L72:
        e = move-exception;
        Log.w("GlobalDomainConfigService", e);     // Catch: Throwable -> L101
    L40:
        Exception e2 = e;
    L54:
        Log.w("GlobalDomainConfigService", e2);     // Catch: Throwable -> L88
        if (r12 != null) goto L109;
    L60:
        if (r11 == null) goto L80;
        r11.close();     // Catch: Exception -> L63 Throwable -> L101
    L63:
        e = e;
        goto L79
    L109:
        r12.close();     // Catch: Exception -> L58 Throwable -> L101
    L58:
        e = move-exception;
        Log.w("GlobalDomainConfigService", e);     // Catch: Throwable -> L101
    L48:
        e = move-exception;
        e = e;
        r12 = null;
    L46:
        e = move-exception;
        e2 = e;
        r12 = null;
    L44:
        th = th;
    L66:
        e = move-exception;
        e = e;
        r11 = null;
        r12 = null;
    L52:
        e = move-exception;
        e2 = e;
        r11 = null;
        r12 = null;
    L50:
        th = th;
        r11 = null;
        goto L90
    L18:
        if (TextUtils.equals(r8, r9) == false) goto L125;
        Log.d("GlobalDomainConfigService", "ignore loadConfigFileFromAssets.");     // Catch: Throwable -> L101
        monitor-exit(r6);     // Catch: Throwable -> L101
    L101:
        th = move-exception;
        throw th;
    L104:
        return r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.util.Map<java.lang.String, com.bytedance.lark.pb.basic.v1.DomainSettings$Pair>] */
    /* JADX WARN: Type inference failed for: r0v14, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.util.Map] */
    @Override // com.ss.android.lark.dynamicconfig.v2.interfaces.IGlobalDomainConfigService
    public final void preload() {
        if (uf().b().length <= 0) goto L7;
        Log.i("GlobalDomainConfigService", "get default domain hit cache, will load from cache");
        ?? r0 = new HashMap();
        com.ss.android.lark.storage.kv.repo.a r1 = uf();
        String[] r2 = r1.b();
        int r3 = r2.length;
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L11;
        String r5 = r2[r4];
        r0.put(r5, new DomainSettings.Pair.Builder().alias(DomainSettings.Alias.UNKNOWN).domain(BuildConfig.FLAVOR).domains(new ArrayList(r1.getStringSet(r5, new HashSet()))).alias_str(r5).build());
        r4 = r4 + 1;
    L11:
        this.d = r0;
        return;
    L7:
        long r6 = System.currentTimeMillis();
        if (TextUtils.isEmpty(f0()) == false) goto L10;
        Log.e("GlobalDomainConfigService", "getSdkConfigDirPath failed, cannot get rust sdk config file.");
        r0 = 0;
        goto L11
    L10:
        Log.i("GlobalDomainConfigService", "FetchDomainV3 copy file cost " + (System.currentTimeMillis() - r6) + " ms.");
        r0 = tf(gcb.a.a().getEnv2Type(), gcb.a.a().getUserUnit(), gcb.a.a().getTenantBrand());
        goto L11
    }

    @Inject
    public d(j r2) {
        super(r2);
        this.b = new Object();
        this.d = new HashMap();
        this.e = new HashMap();
        this.f = new ConcurrentHashMap();
        this.g = new CopyOnWriteArrayList();
        h.a(this);
        Log.i("GlobalDomainConfigService", "GlobalDomainConfigService constructor called");
    }

    public static void rf(boolean r5) {
        VFSFile r1 = new VFSFile(LarkFileStorage.b().b(com.ss.android.lark.storage.f.d, new com.ss.android.lark.storage.d(new String[]{"core", "rust_config"})).subPath("lark_settings"));
        if (r1.exists() == false) goto L9;
        if (r5 == false) goto L6;
        r1.delete();
    L7:
        Log.i("GlobalDomainConfigService", "clearConfigFile");
        return;
    L6:
        r1.deleteOnExit();
        goto L7
    }

    @Override // com.ss.android.lark.dynamicconfig.v2.interfaces.IGlobalDomainConfigService
    public final void h0(Map<String, List<String>> r3) {
        Iterator r0 = ((CopyOnWriteArrayList) this.g).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((mcb.a) r0.next()).a(r3);
        goto L4
    }

    @Override // com.ss.android.lark.dynamicconfig.v2.interfaces.IGlobalDomainConfigService
    public final Map<String, List<String>> o0(String r8) {
        HashMap r0 = new HashMap();
        LinkedHashSet r1 = new LinkedHashSet();
        if (TextUtils.equals(r8, "absent_user") == true) goto L11;
        if (TextUtils.isEmpty(r8) == true) goto L11;
        Map r2 = (Map) ((HashMap) this.e).get(r8);
        if (CollectionUtils.isEmpty(r2) == true) goto L13;
        r1.addAll(r2.keySet());
    L13:
        String[] r3 = uf().b();
        if (r3 == null) goto L22;
        int r4 = r3.length;
        int r5 = 0;
    L16:
        if (r5 >= r4) goto L22;
        String r6 = r3[r5];
        if (r1.contains(r6) == true) goto L20;
        r1.add(r6);
    L20:
        r5 = r5 + 1;
    L22:
        if (CollectionUtils.isEmpty(r1) == true) goto L24;
    L26:
        Iterator r7 = r1.iterator();
    L28:
        if (r7.hasNext() == false) goto L32;
        String r9 = (String) r7.next();
        List<String> r10 = A(r8, r9);
        if (CollectionUtils.isNotEmpty(r10) == false) goto L28;
        r0.put(r9, r10);
        goto L28
    L32:
        return r0;
    L24:
        if (CollectionUtils.isEmpty(this.d) == true) goto L26;
        r1.addAll(this.d.keySet());
    L11:
        if (CollectionUtils.isEmpty(this.d) == true) goto L13;
        r1.addAll(this.d.keySet());
        goto L13
    }

    public static ArrayList sf(String r6, String r7) {
        ArrayList r2 = null;
        if (TextUtils.equals(r6, "absent_user") == false) goto L5;
    L14:
        int r8 = gcb.a.a().getEnvType().getValue();
        String r0 = gcb.a.a().getUserUnit();
        List r4 = vf(r7, r8, r0, gcb.a.a().getTenantBrand());
        if (CollectionUtils.isNotEmpty(r4) == false) goto L18;
        Log.i("GlobalDomainConfigService", "hitDomainV5 alias: " + r7);
        return new ArrayList(r4);
    L18:
        Set r9 = kcb.a.b("DYNAMIC_DOMAIN_MMKV_V4_ID").getStringSet(r8 + "_" + r0 + "_" + r7, null);
        if (CollectionUtils.isNotEmpty(r9) == false) goto L21;
        ArrayList r1 = new ArrayList(r9);
    L23:
        if (CollectionUtils.isNotEmpty(r1) == false) goto L26;
        String r10 = "getDomainCache(): hit DomainV4. Domain penetration may have occurred! alias: " + r7 + " , process is " + z.c(com.larksuite.framework.utils.b.a);
        Log.e("GlobalDomainConfigService", r10, new IllegalArgumentException(r10));
        return new ArrayList(r1);
    L26:
        Set r11 = uf().getStringSet(r7, null);
        if (CollectionUtils.isNotEmpty(r11) == false) goto L31;
        String r12 = "getDomainCache(): hit DomainV3. Domain penetration may have occurred! alias: " + r7 + " , process is " + z.c(com.larksuite.framework.utils.b.a);
        Log.e("GlobalDomainConfigService", r12, new IllegalArgumentException(r12));
        return new ArrayList(r11);
    L31:
        return new ArrayList();
    L21:
        r1 = null;
        goto L23
    L5:
        if (TextUtils.isEmpty(r6) == true) goto L14;
        Set r13 = kcb.a.b("DYNAMIC_DOMAIN_MMKV_USER_ID").getStringSet(r7 + "_" + r6, null);
        if (CollectionUtils.isNotEmpty(r13) == false) goto L11;
        r2 = new ArrayList(r13);
    L11:
        if (CollectionUtils.isEmpty(r2) == true) goto L31;
        Log.i("GlobalDomainConfigService", "hitUserDomain alias: " + r7);
        return new ArrayList(r2);
    }

    @Override // com.ss.android.lark.dynamicconfig.v2.interfaces.IGlobalDomainConfigService, mcb.b
    public final List<String> A(String r7, String r8) {
        Log.i("GlobalDomainConfigService", "getDomains, uid: " + j0.a(r7) + ", alias: " + r8);
        if (r8 != null) goto L7;
        Log.e("GlobalDomainConfigService", "getDomains alias is null");
        return null;
    L7:
        if (z.e(com.larksuite.framework.utils.b.a) == true) goto L14;
        ArrayList r2 = sf(r7, r8);
        if (CollectionUtils.isNotEmpty(r2) == false) goto L12;
        Log.i("GlobalDomainConfigService", "multi-process domain cache feature on " + r8 + ", get domain from KV cache");
        return r2;
    L12:
        Log.e("GlobalDomainConfigService", "multi-process domain cache feature on " + r8 + ", fetch KV cache failed");
    L14:
        if (TextUtils.equals(r7, "absent_user") == true) goto L24;
        if (TextUtils.isEmpty(r7) == true) goto L24;
        Map r3 = (Map) ((HashMap) this.e).get(r7);
        if (CollectionUtils.isNotEmpty(r3) == false) goto L28;
        DomainSettings.Pair r4 = (DomainSettings.Pair) r3.get(r8);
        if (r4 == null) goto L28;
        List<String> r5 = r4.domains;
    L30:
        if (CollectionUtils.isNotEmpty(r5) == false) goto L33;
        Log.i("GlobalDomainConfigService", "get domain from memory");
        return r5;
    L33:
        Log.w("GlobalDomainConfigService", "get domains config before remote config fetch success, will try load from KV cache, alias is ".concat(r8));
        ArrayList r9 = sf(r7, r8);
        if (CollectionUtils.isNotEmpty(r9) == false) goto L37;
        Log.i("GlobalDomainConfigService", "getdomain from KV cache");
        return r9;
    L37:
        Log.e("GlobalDomainConfigService", "domain cache feature on " + r8 + ", fetch KV cache failed");
        if (CollectionUtils.isEmpty(this.d) == false) goto L41;
        Log.i("GlobalDomainConfigService", "get domains config before default config fetch success , load it");
        preload();
    L41:
        if (CollectionUtils.isNotEmpty(this.d) == false) goto L45;
        DomainSettings.Pair r10 = this.d.get(r8);
        if (r10 == null) goto L45;
        List<String> r11 = r10.domains;
    L47:
        if (CollectionUtils.isNotEmpty(r11) == false) goto L50;
        Log.i("GlobalDomainConfigService", "get domain from default");
        return r11;
    L50:
        Log.e("GlobalDomainConfigService", "get alias pair empty, error key is ".concat(r8));
        return null;
    L45:
        r11 = new ArrayList();
    L28:
        r5 = new ArrayList();
    L24:
        if (CollectionUtils.isNotEmpty(this.d) == false) goto L28;
        DomainSettings.Pair r6 = this.d.get(r8);
        if (r6 == null) goto L28;
        r5 = r6.domains;
        goto L30
    }

    @Override // com.ss.android.lark.dynamicconfig.v2.interfaces.IGlobalDomainConfigService
    public final void Yb(String r5, jcb.a r6) {
        CopyOnWriteArrayList r0 = (CopyOnWriteArrayList) ((ConcurrentHashMap) this.f).get(r5);
        if (CollectionUtils.isEmpty(r0) == false) goto L6;
        Log.i("GlobalDomainConfigService", "remove domain observer failed, domainSettingChangedObservers is empty.");
        return;
    L6:
        Log.i("GlobalDomainConfigService", "remove domain observer, uid: " + j0.a(r5) + ", observer: " + r6.hashCode() + ", result: " + r0.remove(r6));
    }

    @Override // com.ss.android.lark.dynamicconfig.v2.interfaces.IGlobalDomainConfigService, mcb.b
    public final String e0(String r1, String r2) {
        List<String> r3 = A(r1, r2);
        if (CollectionUtils.isNotEmpty(r3) == true) goto L5;
        return null;
    L5:
        return (String) ListProtector.get(r3, 0);
    }

    @Override // com.ss.android.lark.dynamicconfig.v2.interfaces.IGlobalDomainConfigService
    public final void sd(String r4, jcb.a r5) {
        CopyOnWriteArrayList r0 = (CopyOnWriteArrayList) ((ConcurrentHashMap) this.f).get(r4);
        Object r1 = this.b;
        monitor-enter(r1);
        if (r0 != null) goto L6;
        CopyOnWriteArrayList r2 = new CopyOnWriteArrayList();     // Catch: Throwable -> L10
        r2.add(r5);     // Catch: Throwable -> L10
        ((ConcurrentHashMap) this.f).put(r4, r2);     // Catch: Throwable -> L10
    L7:
        monitor-exit(r1);     // Catch: Throwable -> L10
        Log.i("GlobalDomainConfigService", "add domain observer success, uid: " + j0.a(r4) + ", observer: " + r5.hashCode());
        return;
    L6:
        r0.add(r5);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public static Map tf(int r12, String r13, String r14) {
        long r0 = System.currentTimeMillis();
        String r2 = com.ss.android.lark.sdk.a.a();
        HashMap<String, a> r3 = a.j;
        if (gcb.a.a().isPrivateKA() == false) goto L6;
        String r15 = "biz_domain_config";
    L13:
        Object r16 = a.k;
        monitor-enter(r16);
        HashMap<String, a> r17 = a.j;     // Catch: Throwable -> L60
        if (r17.containsKey(r15) == false) goto L20;
        a r18 = r17.get(r15);     // Catch: Throwable -> L60
        monitor-exit(r16);     // Catch: Throwable -> L60
    L23:
        String r19 = r18.g();
        JSONObject r110 = JSON.parseObject(r19);
        ArrayList r4 = new ArrayList();
        if (r110 != null) goto L26;
        Log.e("DefaultDomainConfigHandler", "parseDomainConfig failed with " + r19);
    L37:
        GetInitSettingsResponse r111 = new GetInitSettingsResponse.Builder().domain_settings(new DomainSettings.Builder().pairs(r4).build()).build();
        if (r111 != null) goto L40;
        Log.e("DefaultDomainConfigHandler", "getDefaultDomainConfig get static config failed, of key " + r18.i);
    L40:
        Log.i("GlobalDomainConfigService", "parser domain form lark_settings cost " + (System.currentTimeMillis() - r0) + " ms.");
        if (r111 != null) goto L44;
        Log.e("GlobalDomainConfigService", "GetInitSettingsResponse decode failed.");
        return null;
    L44:
        Log.i("GlobalDomainConfigService", "parser domain form lark_settings total cost " + (System.currentTimeMillis() - r0) + " ms.");
        DomainSettings r112 = r111.domain_settings;     // Catch: Exception -> L49
        if (r112 == null) goto L51;
        List r113 = r112.pairs;     // Catch: Exception -> L49
    L52:
        if (r113 != null) goto L55;
        Log.e("GlobalDomainConfigService", "get default config error , contextId : " + r2 + " , process : " + z.c(com.larksuite.framework.utils.b.a));
        rf(false);
        return null;
    L55:
        Log.i("GlobalDomainConfigService", "get default config success , contextId : " + r2 + " , process : " + z.c(com.larksuite.framework.utils.b.a));
        HashMap r114 = new HashMap();
        Iterator r115 = r113.iterator();
    L57:
        if (r115.hasNext() == false) goto L59;
        DomainSettings.Pair r116 = (DomainSettings.Pair) r115.next();
        r114.put(r116.alias_str, r116);
        goto L57
    L59:
        return r114;
    L51:
        r113 = null;
    L49:
        e = move-exception;
        Log.e("GlobalDomainConfigService", "request failed context id : " + r2, e);
        rf(false);
        goto L51
    L26:
        Iterator r117 = r110.keySet().iterator();
    L28:
        if (r117.hasNext() == false) goto L37;
        String r6 = (String) r117.next();
        ArrayList r7 = new ArrayList();
        JSONArray r8 = r110.getJSONArray(r6);     // Catch: Exception -> L34
        int r9 = r8.size();     // Catch: Exception -> L34
        int r10 = 0;
    L31:
        if (r10 >= r9) goto L36;
        r7.add(r8.getString(r10));     // Catch: Exception -> L34
        r10 = r10 + 1;
    L36:
        r4.add(new DomainSettings.Pair.Builder().alias_str(r6).domains(r7).alias(DomainSettings.Alias.UNKNOWN).domain(BuildConfig.FLAVOR).build());
    L34:
        e = move-exception;
        Log.e("DefaultDomainConfigHandler", "parseDomainConfig error, domain key is " + r6, e);
        goto L36
    L20:
        a r5 = new a(r15);     // Catch: Throwable -> L60
        r17.put(r15, r5);     // Catch: Throwable -> L60
        monitor-exit(r16);     // Catch: Throwable -> L60
        r18 = r5;
    L60:
        th = move-exception;
        throw th;
    L6:
        if (r12 != 2) goto L8;
        String r118 = "staging";
    L12:
        r15 = r118 + "_" + r13 + "_" + r14 + "_biz_domain_config";
        goto L13
    L8:
        if (r12 == 3) goto L10;
        r118 = "release";
        goto L12
    L10:
        r118 = "pre_release";
        goto L12
    }

    public static List vf(String r1, int r2, String r3, String r4) {
        Set r5 = kcb.a.b("DYNAMIC_DOMAIN_MMKV_V5_ID").getStringSet(r2 + "_" + r3 + "_" + r4 + "_" + r1, null);
        if (CollectionUtils.isNotEmpty(r5) == true) goto L5;
        return null;
    L5:
        return new ArrayList(r5);
    }

    @Override // com.ss.android.lark.dynamicconfig.v2.interfaces.IGlobalDomainConfigService
    public final List<String> p0(String r11, int r12, String r13, String r14) {
        String r0 = r12 + "_" + r13 + "_" + r14 + "_" + r11;
        List<String> r2 = vf(r11, r12, r13, r14);
        Log.i("GlobalDomainConfigService", "fullEnvUnitBrand lookup, key=" + r0 + ", firstResult=" + r2);
        if (CollectionUtils.isEmpty(r2) == false) goto L19;
        Log.i("GlobalDomainConfigService", "fullEnvUnitBrand lookup miss, trigger fallback, key=" + r0);
        Map r3 = tf(r12, r13, r14);
        if (r3 != null) goto L16;
    L14:
        List<String> r4 = vf(r11, r12, r13, r14);
        Log.i("GlobalDomainConfigService", "fullEnvUnitBrand lookup after fallback, key=" + r0 + ", secondResult=" + r4);
        return r4;
    L16:
        HashMap r5 = (HashMap) r3;     // Catch: Exception -> L12
        Iterator r6 = r5.keySet().iterator();     // Catch: Exception -> L12
    L8:
        if (r6.hasNext() == false) goto L10;
        String r7 = (String) r6.next();     // Catch: Exception -> L12
        uf().putStringSet(r7, new LinkedHashSet(((DomainSettings.Pair) r5.get(r7)).domains));     // Catch: Exception -> L12
        kcb.a.b("DYNAMIC_DOMAIN_MMKV_V4_ID").putStringSet(r12 + "_" + r13 + "_" + r7, new LinkedHashSet(((DomainSettings.Pair) r5.get(r7)).domains));     // Catch: Exception -> L12
        kcb.a.b("DYNAMIC_DOMAIN_MMKV_V5_ID").putStringSet(r12 + "_" + r13 + "_" + r14 + "_" + r7, new LinkedHashSet(((DomainSettings.Pair) r5.get(r7)).domains));     // Catch: Exception -> L12
        goto L8
    L10:
        Log.i("GlobalDomainConfigService", "write lark_settings domain success");     // Catch: Exception -> L12
    L12:
        e = move-exception;
        Log.e("GlobalDomainConfigService", "write lark_settings domain failed", e, true);
        goto L14
    L19:
        return r2;
    }

    @Override // com.ss.android.lark.dynamicconfig.v2.interfaces.IGlobalDomainConfigService
    public final void K0(final String r8, InitSDKRequest.EnvType r9, String r10, String r11, DomainSettings r12) {
        Log.i("GlobalDomainConfigService", "real updateDomainSetting, uid: " + j0.a(r8) + ", envType: " + r9 + ", unit:" + r10 + ", brand:" + r11);
        if (r12 != null) goto L6;
        Log.e("GlobalDomainConfigService", "updateDomainSetting domainSettings is null");
        return;
    L6:
        List r13 = r12.pairs;
        if (r13 != null) goto L10;
        Log.e("GlobalDomainConfigService", "updateDomainSetting pairs is null");
        return;
    L10:
        HashMap r0 = new HashMap();
        final HashMap r1 = new HashMap();
        Iterator r14 = r13.iterator();
    L12:
        if (r14.hasNext() == false) goto L14;
        DomainSettings.Pair r2 = (DomainSettings.Pair) r14.next();
        r0.put(r2.alias_str, r2);
        r1.put(r2.alias_str, r2.domains);
        goto L12
    L14:
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new b(this, r8, r1));
        if (TextUtils.equals(r8, "absent_user") == false) goto L17;
    L20:
        this.d = r0;
        String r3 = "absent_user";
    L22:
        if (z.e(com.larksuite.framework.utils.b.a) == false) goto L27;
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new c(this, r3, r9, r10, r11));
        return;
    L27:
        return;
    L17:
        if (TextUtils.isEmpty(r8) == true) goto L20;
        ((HashMap) this.e).put(r8, r0);
        r3 = r8;
        goto L22
    }
}
