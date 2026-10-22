package vo1;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.android.live.browser.d0;
import com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.CommonIconModel$loadHybridComponent$1;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.behavior.m;
import com.lynx.tasm.q1;
import java.util.Map;
import javax.xml.transform.Transformer;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements com.bytedance.android.anniex.ui.e {
    public final /* synthetic */ d0 a;
    public final /* synthetic */ String b;

    public final void b(AnnieXLynxView r1, String r2) {
    }

    public final void c(AnnieXLynxView r1) {
    }

    public final void e(AnnieXLynxView r1) {
    }

    public final void f(AnnieXLynxView r1) {
    }

    public final void g(AnnieXLynxView r1, LynxError r2) {
    }

    public final void j(AnnieXLynxView r1, JSONObject r2) {
    }

    public final void k(AnnieXLynxView r1, String r2) {
    }

    public final void l(q1.b r1) {
    }

    public final void m(AnnieXLynxView r1, JSONObject r2) {
    }

    public final void o(q1.b r1) {
    }

    public final void onModuleMethodInvoked(String r1, String r2, int r3) {
    }

    public final void onTimingSetup(Map<String, Object> r1) {
    }

    public final void onTimingUpdate(Map<String, Object> r1, Map<String, Long> r2, String r3) {
    }

    public final void p(AnnieXLynxView r1) {
    }

    public final void q(AnnieXLynxView r1, String r2) {
    }

    public final String shouldRedirectImageUrl(String r1) {
        return null;
    }

    public final void a(TemplateBundle r2) {
        Intrinsics.checkNotNullParameter(r2, "templateBundle");
        Intrinsics.checkNotNullParameter(r2, "templateBundle");
    }

    public c(CommonIconModel$loadHybridComponent$1.a r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void d(Uri r1, AnnieXLynxView r2) {
        if (r2 == null) goto L10;
        d0 r3 = this.a;
        if (r3 == null) goto L6;
        r3.g(r2);
    L6:
        d0 r4 = this.a;
        if (r4 == null) goto L11;
        r4.d(r2);
        return;
    L11:
        return;
    }

    public final void n(Uri r2, AnnieXLynxView r3) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        Intrinsics.checkNotNullParameter(r2, "uri");
        if (r3 == null) goto L8;
        d0 r4 = this.a;
        if (r4 == null) goto L9;
        r4.e(r3, this.b);
        return;
    L9:
        return;
    }

    public final void onLoadFail(Uri r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        Intrinsics.checkNotNullParameter(r3, "e");
        com.bytedance.android.anniex.ui.e.b.b(r2, r3);
        d0 r4 = this.a;
        if (r4 == null) goto L6;
        r4.a();
        return;
    }

    public final void onTemplateReady(String r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "resFrom");
        Intrinsics.checkNotNullParameter(r1, "resFrom");
    }

    public final void loadImage(Context r1, String r2, String r3, float r4, float r5, Transformer r6, m.a r7) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r7, "handler");
        com.bytedance.android.anniex.ui.e.b.a(r1, r7);
    }
}
