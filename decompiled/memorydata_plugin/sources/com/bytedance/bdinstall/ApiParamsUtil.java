package com.bytedance.bdinstall;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.bdinstall.intf.IParamFilter;
import com.bytedance.bdinstall.service.INewUserModeService;
import com.bytedance.bdinstall.service.ServiceManager;
import com.bytedance.bdinstall.util.LocalConstants;
import com.bytedance.bdinstall.util.NetworkStatusProvider;
import com.bytedance.bdinstall.util.OptionsForCommonParamProxy;
import com.bytedance.bdinstall.util.RomUtils;
import com.bytedance.bdinstall.util.SystemPropertiesWithCache;
import com.bytedance.bdinstall.util.UIUtils;
import com.bytedance.common.utility.NetworkUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class ApiParamsUtil {
    private final IBDInstallApi installApi;
    private final Map<String, String> sCustomParam;
    private IExtraParams sExtraParams;
    private final Map<String, String> sL0OnlyParams;
    private NetworkStatusProvider sNetworkProvider;
    private int sParamCount;
    private volatile boolean sStarted;

    /* JADX INFO: renamed from: com.bytedance.bdinstall.ApiParamsUtil$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$bdinstall$Level = null;

        static {
            int[] r0 = new int[Level.values().length];
            $SwitchMap$com$bytedance$bdinstall$Level = r0;
            r0[Level.L0.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$bytedance$bdinstall$Level[Level.L1.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public ApiParamsUtil(IBDInstallApi r3) {
        IBDInstallApi r4 = (IBDInstallApi) ZeusTransformUtils.wrapperContextForParams(r3, IBDInstallApi.class, "com.obric.memorydata.plugin");
        this.sStarted = false;
        this.sParamCount = 36;
        this.sCustomParam = new ConcurrentHashMap();
        this.sL0OnlyParams = new ConcurrentHashMap();
        this.installApi = r4;
    }

    private void addCommonParam(Map<String, String> r2) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        if (RomUtils.isHarmonyUI() == false) goto L5;
        String r3 = "harmony";
    L6:
        r1.put("os", r3);
    L11:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        if (RomUtils.isHarmonyUI() == false) goto L16;
        r1.put("sub_os_api", String.valueOf(SystemPropertiesWithCache.get("hw_sc.build.os.apiversion")));     // Catch: Throwable -> L11
        return;
    L16:
        return;
    L5:
        r3 = "android";
        goto L6
    }

    private static void copyMap(Map<String, String> r4, Map<String, String> r5, boolean r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L25;
        return;
    L25:
        if (r7.isEmpty() == true) goto L42;
        Iterator r9 = r7.entrySet().iterator();     // Catch: Exception -> L24
    L7:
        if (r9.hasNext() == false) goto L44;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L24
        if (r0 == null) goto L7;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L24
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.getValue(), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L24
        if (TextUtils.isEmpty(r2) == true) goto L7;
        if (TextUtils.isEmpty(r1) == true) goto L7;
        if (r6 == false) goto L21;
        if (r8.containsKey(r2) == true) goto L7;
    L21:
        r8.put(r2, r1);     // Catch: Exception -> L24
        goto L7
    L44:
        return;
    L42:
        return;
    }

    private boolean started(Context r3, InstallOptions r4, boolean r5, InstallInfo r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r5 == false) goto L10;
        boolean r8 = this.sStarted;
        if (r8 == true) goto L9;
        r8 = LocalConstants.getCommonSp(r7, r4).getBoolean(Api.KEY_STARTED, false);
        if (r8 == false) goto L9;
        this.sStarted = true;
    L9:
        return r8;
    L10:
        if (r6 == null) goto L17;
        if (TextUtils.isEmpty(r6.getDid()) == true) goto L17;
        if (TextUtils.isEmpty(r6.getIid()) == true) goto L17;
        return true;
    L17:
        return false;
    }

    public void addCustomParamsWithLevel(String r2, String r3, Level r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r3) == true) goto L19;
        int r5 = AnonymousClass1.$SwitchMap$com$bytedance$bdinstall$Level[r4.ordinal()];
        if (r5 != 1) goto L12;
        Map<String, String> r1 = this.sL0OnlyParams;
    L16:
        r1.put(r2, r3);
        return;
    L12:
        if (r5 != 2) goto L20;
        r1 = this.sCustomParam;
        goto L16
    L20:
        return;
    }

    public String appendNetParams(Context r10, StringBuilder r11, String r12, boolean r13, Level r14) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        String r15 = r11.toString();
        if (TextUtils.isEmpty(r15) == false) goto L5;
        return r15;
    L5:
        Uri r16 = Uri.parse(r15);
        Set<String> r0 = r16.getQueryParameterNames();
        Uri.Builder r17 = r16.buildUpon();
        LinkedHashMap r8 = new LinkedHashMap(this.sParamCount);
        appendParamsToMap(r3, r13, r12, r8, r14);
        Iterator<Map.Entry<String, String>> r18 = r8.entrySet().iterator();
    L7:
        if (r18.hasNext() == false) goto L13;
        Map.Entry r19 = (Map.Entry) ZeusTransformUtils.preCheckCast(r18.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r110 = (String) ZeusTransformUtils.preCheckCast(r19.getKey(), String.class, "com.obric.memorydata.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r19.getValue(), String.class, "com.obric.memorydata.plugin");
        if (r0.contains(r110) == true) goto L7;
        if (TextUtils.isEmpty(r2) == true) goto L7;
        r17.appendQueryParameter(r110, (String) ZeusTransformUtils.preCheckCast(r19.getValue(), String.class, "com.obric.memorydata.plugin"));
        goto L7
    L13:
        r11.delete(0, r11.length());
        r11.append(r17.build().toString());
        this.sParamCount = r8.size();
        return r11.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void appendParamsToMap(Context r8, boolean r9, String r10, Map<String, String> r11, Level r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Map<String, String> r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        if (r14 != null) goto L5;
        return;
    L5:
        r14.put("device_platform", "android");
        addCommonParam(r14);
        if (r9 == false) goto L8;
        r14.put(Api.KEY_SSMIX, "a");
    L8:
        r14.put(Api.KEY_RTICKET, String.valueOf(System.currentTimeMillis()));
        InstallOptions r15 = this.installApi.getInstallOptions();
        AppContext r0 = this.installApi.getAppContext();
        String r2 = Cdid.get(r15);
        if (TextUtils.isEmpty(r2) == false) goto L15;
        if (r0 == 0) goto L15;
        if (r0.isMainInstance() == false) goto L15;
        r2 = Cdid.getMainInstanceCdid(r13);
    L15:
        if (TextUtils.isEmpty(r2) == true) goto L17;
        r14.put(Cdid.KEY_CDID, r2);
    L17:
        HashMap<String, String> r3 = null;
        if (r15 == null) goto L20;
        OptionsForCommonParamProxy r4 = new OptionsForCommonParamProxy(r15);
    L21:
        if (r4 != null) goto L24;
        if (r0 == 0) goto L24;
        r4 = new OptionsForCommonParamProxy(r0);
    L24:
        if (r4 == null) goto L40;
        String r5 = r4.getChannel();
        if (TextUtils.isEmpty(r5) == true) goto L29;
        r14.put("channel", r5);
    L29:
        if (r10 != null) goto L32;
        r10 = String.valueOf(r4.getAid());
    L32:
        r14.put("aid", r10);
        String r16 = r4.getAppName();
        if (r16 == null) goto L35;
        r14.put(Api.KEY_APP_NAME, r16);
    L36:
        r14.put("version_code", String.valueOf(r4.getVersionCode()));
        String r17 = r4.getVersion();
        if (r17 == null) goto L39;
        r14.put("version_name", r17);
    L39:
        r14.put("manifest_version_code", String.valueOf(r4.getManifestVersionCode()));
        r14.put("update_version_code", String.valueOf(r4.getUpdateVersionCode()));
        goto L40
    L35:
        DrLog.ysnp(new IllegalArgumentException("app_name is null"));
    L40:
        if (r15 == null) goto L42;
        IAbContext r18 = r15.getAbContext();
    L43:
        if (r18 == null) goto L46;
        r0 = r18;
    L46:
        if (r0 == 0) goto L62;
        String r19 = r0.getAbVersion();
        if (TextUtils.isEmpty(r19) == true) goto L50;
        r14.put(Api.KEY_AB_VERSION, r19);
    L50:
        String r110 = r0.getAbClient();
        if (TextUtils.isEmpty(r110) == true) goto L53;
        r14.put(Api.KEY_AB_CLIENT, r110);
    L53:
        String r111 = r0.getAbGroup();
        if (TextUtils.isEmpty(r111) == true) goto L56;
        r14.put(Api.KEY_AB_GROUP, r111);
    L56:
        String r112 = r0.getAbFeature();
        if (TextUtils.isEmpty(r112) == true) goto L59;
        r14.put(Api.KEY_AB_FEATURE, r112);
    L59:
        long r6 = r0.getAbFlag();
        if (r6 <= 0) goto L62;
        r14.put(Api.KEY_ABFLAG, String.valueOf(r6));
    L62:
        if (r15 == null) goto L66;
        INewUserModeService r113 = (INewUserModeService) ZeusTransformUtils.preCheckCast(ServiceManager.getService(INewUserModeService.class, String.valueOf(r15.getAid())), INewUserModeService.class, "com.obric.memorydata.plugin");
        if (r113 == null) goto L66;
        r113.mapCustomParams(r14);
    L66:
        String r114 = UIUtils.getScreenResolution(r13);
        if (TextUtils.isEmpty(r114) == true) goto L69;
        r14.put("resolution", r114);
    L69:
        int r115 = UIUtils.getDpi(r13);
        if (r115 <= 0) goto L73;
        r14.put(Api.KEY_DPI, String.valueOf(r115));
    L73:
        if (Build.BRAND.equals("Pico") == false) goto L75;
        String r116 = RomUtils.getProductName();
    L76:
        r14.put(Api.KEY_DEVICE_TYPE, r116);
        r14.put("device_brand", Build.BRAND);
        r14.put(Api.KEY_LANGUAGE, Locale.getDefault().getLanguage());
        r14.put("os_api", String.valueOf(Build.VERSION.SDK_INT));
        String r1 = Build.VERSION.RELEASE;     // Catch: Exception -> L133
        if (r1 != null) goto L80;
    L82:
        r14.put("os_version", r1);     // Catch: Exception -> L133
        goto L83
    L80:
        if (r1.length() <= 10) goto L82;
        r1 = r1.substring(0, 10);     // Catch: Exception -> L133
    L83:
        NetworkStatusProvider r7 = this.sNetworkProvider;
        if (r7 == null) goto L88;
        String r20 = r7.getNetworkType().name();
        if (TextUtils.isEmpty(r20) == true) goto L92;
        r14.put(Api.KEY_AC, r20);
        StringBuilder r21 = new StringBuilder();
        String r22 = "NetworkStatusProvider network type is ";
    L91:
        DrLog.d(r21.append(r22).append(r20).toString());
    L92:
        copyMap(this.sCustomParam, r14, false);
        if (r12 != Level.L0) goto L134;
        copyMap(this.sL0OnlyParams, r14, false);
    L134:
        IExtraParams r117 = this.sExtraParams;     // Catch: Exception -> L101
        if (r117 == null) goto L99;
        r3 = r117.getExtraParams(r12);     // Catch: Exception -> L101
    L99:
        copyMap(r3, r14, true);     // Catch: Exception -> L101
    L103:
        boolean r118 = Utils.isMainProcess(r13);
        InstallInfo r23 = this.installApi.getInstallInfo();
        if (started(r13, r15, r118, r23) == false) goto L129;
        if (r23 == null) goto L127;
        if (TextUtils.isEmpty(r23.getEDid()) == true) goto L110;
        r14.put(Api.KEY_ENCRYPT_DID, r23.getEDid());
    L110:
        if (TextUtils.isEmpty(r23.getEIid()) == true) goto L113;
        r14.put(Api.KEY_ENCRYPT_IID, r23.getEIid());
    L113:
        if (TextUtils.isEmpty(r23.getIid()) == true) goto L116;
        r14.put("iid", r23.getIid());
    L116:
        if (TextUtils.isEmpty(r23.getDid()) == true) goto L119;
        r14.put("device_id", r23.getDid());
    L119:
        if (TextUtils.isEmpty(r23.getEgdi()) == true) goto L122;
        r14.put(Api.KEY_KLINK_EGDI, r23.getEgdi());
    L122:
        if (r12 != Level.L0) goto L127;
        String r24 = r23.getOpenUdid();
        if (TextUtils.isEmpty(r24) == true) goto L127;
        r14.put("openudid", r24);
    L127:
        if (r12 != Level.L0) goto L129;
        ApiParamsForFlavor.addSstParams(r13, r14, r118, r15);
    L129:
        ApiParamsForFlavor.addCommonParams(r118, r13, r15);
        IParamFilter r25 = this.installApi.getParamsFilter();
        if (r25 == null) goto L138;
        r25.filterCommonParams(r14);
        return;
    L138:
        return;
    L101:
        e = move-exception;
        DrLog.ysnp(e);
        goto L103
    L88:
        r20 = NetworkUtils.f(r13);
        if (TextUtils.isEmpty(r20) == true) goto L92;
        r14.put(Api.KEY_AC, r20);
        r21 = new StringBuilder();
        r22 = "NetworkUtils network type is ";
        goto L91
    L75:
        r116 = Build.MODEL;
        goto L76
    L42:
        r18 = null;
        goto L43
    L20:
        r4 = null;
        goto L21
    }

    public void removeCustomParamsWithLevel(String r2, Level r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return;
    L7:
        int r4 = AnonymousClass1.$SwitchMap$com$bytedance$bdinstall$Level[r3.ordinal()];
        if (r4 != 1) goto L10;
        Map<String, String> r1 = this.sL0OnlyParams;
    L14:
        r1.remove(r2);
        return;
    L10:
        if (r4 != 2) goto L16;
        r1 = this.sCustomParam;
        goto L14
    }

    public void setExtraParams(IExtraParams r3) {
        IExtraParams r4 = (IExtraParams) ZeusTransformUtils.wrapperContextForParams(r3, IExtraParams.class, "com.obric.memorydata.plugin");
        if (this.sExtraParams != null) goto L7;
        if (r4 == null) goto L8;
        this.sExtraParams = r4;
        return;
    L8:
        return;
    }

    public void setNetworkProvider(NetworkStatusProvider r1) {
        this.sNetworkProvider = r1;
    }
}
