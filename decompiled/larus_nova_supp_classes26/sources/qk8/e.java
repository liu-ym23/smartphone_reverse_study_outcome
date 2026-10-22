package qk8;

import android.view.animation.Interpolator;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.bmhome.chat.layout.holder.helper.LongClickSource;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.o;
import kc8.j;
import kc8.y;
import kc8.z;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e implements d {
    public final Function0<kc8.b> a;
    public Function0<Unit> b;

    @Override // qk8.d
    public final void e() {
        Function0<Unit> r0 = this.b;
        if (r0 == null) goto L6;
        r0.invoke();
        return;
    }

    public final kc8.b i() {
        return (kc8.b) this.a.invoke();
    }

    @Override // qk8.d
    public final void U1() {
        kc8.b r0 = i();
        if (r0 == null) goto L12;
        y r1 = r0.a;
        if (r1 == null) goto L13;
        j r2 = r1.r;
        if (r2 == null) goto L14;
        Function0 r3 = r2.f;
        if (r3 == null) goto L15;
        r3.invoke();
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    @Override // qk8.d
    public final int g() {
        kc8.b r0 = i();
        if (r0 == null) goto L9;
        y r1 = r0.a;
        if (r1 == null) goto L9;
        Function0 r2 = r1.E;
        if (r2 == null) goto L9;
        return ((Number) r2.invoke()).intValue();
    L9:
        return 0;
    }

    public e(rk8.d r2) {
        Intrinsics.checkNotNullParameter(r2, "blockDependConfigGetter");
        this.a = r2;
    }

    @Override // qk8.d
    public final void c(sk8.a r5) {
        Intrinsics.checkNotNullParameter(r5, "params");
        int r1 = sk8.b.a;
        Intrinsics.checkNotNullParameter(r5, "params");
        o r0 = o.a;
        JSONObject r2 = new JSONObject();
        if (Intrinsics.areEqual(r5.b, "folded") == false) goto L5;
        String r3 = "fold";
    L6:
        r2.put("to_status", r3);
        r2.put("fold_scope", "cot_preamble");
        r2.put(MusicAppletPage.KEY_MESSAGE_ID, r5.a);
        r2.put(MusicAppletPage.KEY_CONVERSATION_ID, r5.c);
        r2.put("current_page", "chat");
        Unit r6 = Unit.INSTANCE;
        r0.reportEvent("content_fold_click", r2);
        return;
    L5:
        r3 = "unfold";
        goto L6
    }

    @Override // qk8.d
    public final void d(ow8.a r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        kc8.b r0 = i();
        if (r0 == null) goto L14;
        y r1 = r0.a;
        if (r1 == null) goto L15;
        z r2 = r1.A;
        if (r2 != null) goto L9;
        return;
    L9:
        if ((r3 instanceof CustomMarkdownTextView) == false) goto L11;
        AppCompatTextView r4 = (CustomMarkdownTextView) r3;
    L12:
        r2.a(r4);
        return;
    L11:
        r4 = null;
        goto L12
    L15:
        return;
    }

    @Override // qk8.d
    public final void b(boolean r2, Message r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        kc8.b r0 = i();
        if (r0 == null) goto L12;
        y r1 = r0.a;
        if (r1 == null) goto L13;
        j r4 = r1.r;
        if (r4 == null) goto L14;
        Function2 r5 = r4.g;
        if (r5 == null) goto L15;
        r5.invoke(Boolean.valueOf(r2), r3);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    @Override // qk8.d
    public final void f(ow8.a r3, st8.a r4) {
        kc8.b r0 = i();
        if (r0 == null) goto L14;
        y r1 = r0.a;
        if (r1 == null) goto L15;
        z r2 = r1.A;
        if (r2 != null) goto L9;
        return;
    L9:
        if ((r3 instanceof CustomMarkdownTextView) == false) goto L11;
        AppCompatTextView r5 = (CustomMarkdownTextView) r3;
    L12:
        r2.b(r5, r4, LongClickSource.Content);
        return;
    L11:
        r5 = null;
        goto L12
    L15:
        return;
    }

    @Override // qk8.d
    public final void a(int r3, int r4, Interpolator r5) {
        Intrinsics.checkNotNullParameter(r5, "animationInterpolator");
        if (r4 != 0) goto L11;
        kc8.b r6 = i();
        if (r6 == null) goto L19;
        y r7 = r6.a;
        if (r7 == null) goto L20;
        Function2 r8 = r7.G;
        if (r8 == null) goto L21;
        Unit r9 = (Unit) r8.invoke(0, Integer.valueOf(r3));
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L11:
        kc8.b r1 = i();
        if (r1 == null) goto L23;
        y r2 = r1.a;
        if (r2 == null) goto L24;
        Function4 r10 = r2.H;
        if (r10 == null) goto L25;
        Unit r11 = (Unit) r10.invoke(0, Integer.valueOf(r3), r5, Integer.valueOf(r4));
        return;
    L25:
        return;
    L24:
        return;
    }

    @Override // qk8.d
    public final void h(Message r2, st8.a r3, ow8.a r4) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "anchorView");
        kc8.b r5 = i();
        if (r5 == null) goto L14;
        y r6 = r5.a;
        if (r6 == null) goto L15;
        z r7 = r6.A;
        if (r7 != null) goto L9;
        return;
    L9:
        if ((r4 instanceof CustomMarkdownTextView) == false) goto L11;
        AppCompatTextView r8 = (CustomMarkdownTextView) r4;
    L12:
        r7.b(r8, r3, LongClickSource.Content);
        return;
    L11:
        r8 = null;
        goto L12
    L15:
        return;
    }
}
