package p0b;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chameleon.jsbauth.AuthErrorCode;
import com.ss.android.lark.chameleon.jsbauth.AuthSuccessCode;
import com.ss.android.lark.chameleon.jsbauth.JsbAuthResult;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.officewebview.bridge.Message;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements Runnable {
    public final /* synthetic */ a a;
    public final /* synthetic */ Message b;
    public final /* synthetic */ JsbAuthResult c;

    public b(a r1, Message r2, JsbAuthResult r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        a r1 = this.a;
        Message r2 = this.b;
        JsbAuthResult r3 = this.c;
        r1.getClass();
        JSONObject r4 = new JSONObject();
        String r5 = r2.getExtra();     // Catch: Exception -> L8
        if (r5 == null) goto L10;
        String r6 = new JSONObject(r5).optString("chameleonJsbAuthToken");     // Catch: Exception -> L8
    L11:
        String r7 = BuildConfig.FLAVOR;
        if (r6 != null) goto L14;
        r6 = BuildConfig.FLAVOR;
    L14:
        String r8 = r2.getApiName();
        if (r8 != null) goto L17;
        r8 = BuildConfig.FLAVOR;
    L17:
        String r9 = r1.b.getUrl();
        if (r9 != null) goto L20;
        r9 = BuildConfig.FLAVOR;
    L20:
        String r10 = r1.c.get(r6);
        if (r10 != null) goto L23;
        r10 = BuildConfig.FLAVOR;
    L23:
        String r11 = r1.b.getChameleonConfig().getBizName();
        if (r11 != null) goto L26;
        r11 = BuildConfig.FLAVOR;
    L26:
        r4.put("auth_url", r10);
        r4.put("web_view_url", r9);
        r4.put("api_name", r8);
        r4.put("is_main_frame", Intrinsics.areEqual(r9, r10));
        r4.put("passed", r3.getPassed());
        AuthErrorCode r12 = r3.getErrorCode();
        if (r12 == null) goto L29;
        int r13 = r12.getCode();
    L33:
        r4.put("result_code", r13);
        AuthErrorCode r14 = r3.getErrorCode();
        if (r14 == null) goto L39;
        String r15 = r14.getMsg();
        if (r15 == null) goto L39;
        r7 = r15;
    L42:
        r4.put("auth_message", r7);
        r4.put(ChameleonOpenTracker.ParamKey.APP_NAME, r11);
        String r16 = r4.toString();
        if (r3.getPassed() == true) goto L49;
        j.e("CML_TAG_JsbAuthManager", "jab auth: " + r16);
        u1b.b.b("webapp_jsb_auth_result_dev", r4);
        return;
    L49:
        return;
    L39:
        AuthSuccessCode r17 = r3.getSuccessCode();
        if (r17 == null) goto L42;
        r7 = r17.getMsg();
        goto L42
    L29:
        AuthSuccessCode r18 = r3.getSuccessCode();
        if (r18 == null) goto L32;
        r13 = r18.getCode();
        goto L33
    L32:
        r13 = 0;
    L10:
        r6 = null;
    L8:
        e = move-exception;
        j.d("CML_TAG_JsbAuthManager", e);
        goto L10
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
}
