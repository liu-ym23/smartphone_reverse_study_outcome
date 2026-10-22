package lcb;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.DomainSettings;
import com.bytedance.lark.pb.basic.v1.InitSDKRequest;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ InitSDKRequest.EnvType b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ d e;

    public final void a() {
        Map<String, DomainSettings.Pair> r4 = null;
        if (TextUtils.equals(this.a, "absent_user") == true) goto L22;
        if (TextUtils.isEmpty(this.a) == true) goto L22;
        Map<String, DomainSettings.Pair> r0 = (Map) ((HashMap) this.e.e).get(this.a);
        if (CollectionUtils.isNotEmpty(r0) == false) goto L10;
        Log.i("GlobalDomainConfigService", "write user domain cache from fetched cache");
        r4 = r0;
    L10:
        if (r4 != null) goto L38;
        Log.i("GlobalDomainConfigService", "write user domain cache from no one");
        return;
    L38:
        Iterator<String> r1 = r4.keySet().iterator();     // Catch: Exception -> L19
    L15:
        if (r1.hasNext() == false) goto L17;
        String r5 = r1.next();     // Catch: Exception -> L19
        String r6 = r5 + "_" + this.a;     // Catch: Exception -> L19
        this.e.getClass();     // Catch: Exception -> L19
        kcb.a.b("DYNAMIC_DOMAIN_MMKV_USER_ID").putStringSet(r6, new LinkedHashSet(r4.get(r5).domains));     // Catch: Exception -> L19
        goto L15
    L17:
        Log.i("GlobalDomainConfigService", "write user domain cache success");     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        Log.e("GlobalDomainConfigService", "write user domain cache failed", e, true);
        return;
    L22:
        if (CollectionUtils.isNotEmpty(this.e.d) == false) goto L24;
        r4 = this.e.d;
        Log.i("GlobalDomainConfigService", "write common domain cache from default cache");
    L24:
        if (r4 != null) goto L36;
        Log.i("GlobalDomainConfigService", "write common domain cache from no one");
        return;
    L36:
        Iterator<String> r2 = r4.keySet().iterator();     // Catch: Exception -> L33
    L29:
        if (r2.hasNext() == false) goto L31;
        String r7 = r2.next();     // Catch: Exception -> L33
        String r8 = this.b.getValue() + "_" + this.c + "_" + this.d + "_" + r7;     // Catch: Exception -> L33
        this.e.getClass();     // Catch: Exception -> L33
        kcb.a.b("DYNAMIC_DOMAIN_MMKV_V5_ID").putStringSet(r8, new LinkedHashSet(r4.get(r7).domains));     // Catch: Exception -> L33
        String r9 = this.b.getValue() + "_" + this.c + "_" + r7;     // Catch: Exception -> L33
        this.e.getClass();     // Catch: Exception -> L33
        kcb.a.b("DYNAMIC_DOMAIN_MMKV_V4_ID").putStringSet(r9, new LinkedHashSet(r4.get(r7).domains));     // Catch: Exception -> L33
        this.e.getClass();     // Catch: Exception -> L33
        d.uf().putStringSet(r7, new LinkedHashSet(r4.get(r7).domains));     // Catch: Exception -> L33
        goto L29
    L31:
        Log.i("GlobalDomainConfigService", "write common domain cache success");     // Catch: Exception -> L33
        return;
    L33:
        e = move-exception;
        Log.e("GlobalDomainConfigService", "write common domain cache failed", e, true);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(d r1, String r2, InitSDKRequest.EnvType r3, String r4, String r5) {
        this.e = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
