package com.ss.android.lark.language.loader;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.ApkUtil;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.compress.utils.IOUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class BaseLanguageLoader {
    public static final /* synthetic */ int f = 0;
    public final KVRepo a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;

    public static final class a {
    }

    static {
    }

    public abstract Map<String, Integer> a();

    public LinkedHashMap<Locale, Integer> b() {
        LinkedHashMap<Locale, Integer> r2 = new LinkedHashMap();
        int r6 = ApkUtil.getAppVersionCode(com.larksuite.framework.utils.b.a.getApplicationContext());
        int r7 = this.a.getInt("sp_version_code_for_build_language", -1);
        if (r6 <= r7) goto L5;
        Log.i("LaunchLocaleWatch", "version update, curVersionCode: " + r6 + ", lastVersionCode: " + r7);
        this.a.putInt("sp_version_code_for_build_language", r6);
        List r8 = new ArrayList();
    L13:
        if ((!r8.isEmpty()) == false) goto L15;
        Log.i("LaunchLocaleWatch", "get language config hit cache, config: " + r8);
    L31:
        Iterator r0 = r8.iterator();
    L33:
        if (r0.hasNext() == false) goto L37;
        String r3 = (String) r0.next();
        String r9 = (String) ListProtector.get(StringsKt.split$default(r3, new String[]{"-"}, false, 0, 6, null), 0);
        String r4 = (String) ListProtector.get(StringsKt.split$default(r3, new String[]{"-"}, false, 0, 6, null), 1);
        Integer r5 = (Integer) ((Map) this.b.getValue()).get(r3);
        if (r5 == null) goto L33;
        r2.put(new Locale(r9, r4), Integer.valueOf(r5.intValue()));
        goto L33
    L37:
        return r2;
    L15:
        long r10 = System.currentTimeMillis();
        InputStream r14 = com.larksuite.framework.utils.b.a.getAssets().open("lark_settings");     // Catch: Throwable -> L23 Exception -> L25
        String r12 = new JSONObject(new String(IOUtils.toByteArray(r14), StandardCharsets.UTF_8)).getJSONObject("client_build_language_config").getString("client_build_language_list");     // Catch: Exception -> L21 Throwable -> L38
        this.a.putString("sp_client_build_language_list", r12);     // Catch: Exception -> L21 Throwable -> L38
        Intrinsics.checkNotNull(r12);     // Catch: Exception -> L21 Throwable -> L38
        List r11 = StringsKt.split$default(r12, new String[]{","}, false, 0, 6, null);     // Catch: Exception -> L21 Throwable -> L38
        Log.i("LaunchLocaleWatch", "parse language config success, config: " + r11);     // Catch: Exception -> L21 Throwable -> L38
        if (r14 == null) goto L20;
        r14.close();
    L20:
        Log.i("LaunchLocaleWatch", "parse language config cost " + (System.currentTimeMillis() - r10) + " ms.");
        r8 = r11;
    L21:
        e = e;
    L27:
        Log.e("LaunchLocaleWatch", "parse language config failed, error: " + e.getMessage());     // Catch: Throwable -> L38
        this.a.putInt("sp_version_code_for_build_language", 0);     // Catch: Throwable -> L38
        if (r14 == null) goto L30;
        r14.close();
    L30:
        Log.i("LaunchLocaleWatch", "parse language config cost " + (System.currentTimeMillis() - r10) + " ms.");
        r8 = new ArrayList();
    L38:
        th = th;
    L39:
        if (r14 == null) goto L41;
        r14.close();
    L41:
        Log.i("LaunchLocaleWatch", "parse language config cost " + (System.currentTimeMillis() - r10) + " ms.");
        throw th;
    L25:
        e = e;
        r14 = null;
    L23:
        th = th;
        r14 = null;
        goto L39
    L5:
        String r13 = this.a.getString("sp_client_build_language_list", "");
        if (r13 != null) goto L9;
        r8 = new ArrayList();
        goto L13
    L9:
        if (TextUtils.isEmpty(r13) == true) goto L11;
        r8 = StringsKt.split$default(r13, new String[]{","}, false, 0, 6, null);
        goto L13
    L11:
        r8 = new ArrayList();
        goto L13
    }

    public BaseLanguageLoader(KVRepo r2) {
        Intrinsics.checkNotNullParameter(r2, "globalCoreKVRepo");
        this.a = r2;
        this.b = LazyKt.lazy(new BaseLanguageLoader$localeMap$2(this));
        this.c = LazyKt.lazy(new BaseLanguageLoader$locale2NameMap$2(this));
        this.d = LazyKt.lazy(new BaseLanguageLoader$localeList$2(this));
        this.e = LazyKt.lazy(new BaseLanguageLoader$resourceMap$2(this));
    }
}
