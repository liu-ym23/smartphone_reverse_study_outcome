package uzb;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import java.net.URL;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class i implements h.a {
    public final /* synthetic */ URLSpan a;
    public final /* synthetic */ Activity b;
    public final /* synthetic */ JSONObject c;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r9) {
        Activity r10 = this.b;
        String r0 = this.a.getURL();
        JSONObject r1 = this.c;
        if (r1 != null) goto L5;
    L35:
        boolean r11 = false;
    L36:
        if (r11 == false) goto L39;
        return;
    L39:
        if (TextUtils.isEmpty(this.a.getURL()) == true) goto L48;
        Activity r12 = this.b;
        Intent r2 = new Intent("android.intent.action.VIEW", UriProtector.parse(this.a.getURL()));     // Catch: Exception -> L46
        if ((r12 instanceof Activity) == true) goto L44;
        r2.addFlags(268435456);     // Catch: Exception -> L46
    L44:
        r12.startActivity(r2);     // Catch: Exception -> L46
        return;
    L46:
        e = move-exception;
        PassportLog.b("RichTextUtil", "open url error " + e.getMessage());
        return;
    L48:
        PassportLog.b("RichTextUtil", "subtitleLinkText href is empty");
        return;
    L5:
        if (TextUtils.isEmpty(r0) == true) goto L35;
        PassportLog.d("RichTextUtil", "url: " + r0);     // Catch: Exception -> L33
        String r3 = new URL(r0).getHost();     // Catch: Exception -> L33
        if (r1.containsKey(r3) == false) goto L16;
        Object r4 = r1.get(r3);     // Catch: Exception -> L33
        if ((r4 instanceof JSONObject) == false) goto L16;
        AtomicReference<syb.b> r5 = com.ss.android.lark.passport.flow.core.router.a.c;     // Catch: Exception -> L33
        if (com.ss.android.lark.passport.flow.core.router.a.C0085a.a(r10, r3, (JSONObject) r4).a() == false) goto L16;
    L32:
        r11 = true;
    L16:
        if (TextUtils.equals(r3, r1.getString("next_step")) == false) goto L24;
        JSONObject r6 = r1.getJSONObject("step_data");     // Catch: Exception -> L33
        if (r6 != null) goto L21;
        r6 = r1.getJSONObject("step_info");     // Catch: Exception -> L33
    L21:
        AtomicReference<syb.b> r7 = com.ss.android.lark.passport.flow.core.router.a.c;     // Catch: Exception -> L33
        if (com.ss.android.lark.passport.flow.core.router.a.C0085a.a(r10, r3, r6).a() == true) goto L32;
    L24:
        String r8 = r1.getString("next_step");     // Catch: Exception -> L33
        if (TextUtils.isEmpty(r8) == true) goto L35;
        JSONObject r13 = r1.getJSONObject("step_data");     // Catch: Exception -> L33
        if (r13 != null) goto L30;
        r13 = r1.getJSONObject("step_info");     // Catch: Exception -> L33
    L30:
        AtomicReference<syb.b> r14 = com.ss.android.lark.passport.flow.core.router.a.c;     // Catch: Exception -> L33
        if (com.ss.android.lark.passport.flow.core.router.a.C0085a.a(r10, r8, r13).a() == false) goto L35;
    L33:
        e = move-exception;
        PassportLog.b("RichTextUtil", "error " + e.getMessage());
        goto L35
    }

    public i(URLSpan r1, FragmentActivity r2) {
        this.a = r1;
        this.b = r2;
        this.c = null;
    }
}
