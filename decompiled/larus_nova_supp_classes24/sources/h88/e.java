package h88;

import androidx.appcompat.widget.AppCompatImageView;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.functions.Function0;
import v19.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e extends d {
    public final String e;

    @Override // h88.d
    public final void d(boolean r1) {
    }

    @Override // h88.d
    public final void c() {
        b(this.c);
    }

    public final AppCompatImageView e() {
        AppCompatImageView r0 = this.a;
        if ((r0 instanceof AppCompatImageView) == true) goto L7;
        return null;
    L7:
        return r0;
    }

    public e() {
        this.e = "LLMVideoButtonState";
    }

    @Override // h88.d
    public String getType() {
        return this.e;
    }

    @Override // h88.d
    public final void a(boolean r3) {
        if (this.c == false) goto L7;
        if (r3 == true) goto L7;
        FLogger.a.w(getType(), "llm video btn is selected, can't not set disabled");
        return;
    L7:
        super.a(r3);
    }

    @Override // h88.d
    public final void b(boolean r3) {
        super.b(r3);
        b r0 = null;
        if (r3 == false) goto L27;
        AppCompatImageView r4 = e();
        if (r4 == null) goto L7;
        int r1 = j0.a;
        r4.setContentDescription(j0.d(2131900497));
    L7:
        boolean r5 = h.a;
        if (h.a(null) == false) goto L12;
        AppCompatImageView r6 = e();
        if (r6 == null) goto L15;
        r6.setImageResource(2131241786);
    L15:
        Function0<? extends b> r7 = this.d;
        if (r7 == null) goto L18;
        r0 = (b) r7.invoke();
    L18:
        if (r0 == null) goto L22;
        boolean r8 = r0.r;
        boolean r2 = true;
        if (r8 != true) goto L22;
    L23:
        if (r2 == false) goto L39;
        AppCompatImageView r9 = e();
        if (r9 == null) goto L40;
        r9.setImageResource(2131242275);
        return;
    L40:
        return;
    L39:
        return;
    L22:
        r2 = false;
        goto L23
    L12:
        AppCompatImageView r10 = e();
        if (r10 == null) goto L15;
        r10.setImageResource(2131241787);
        goto L15
    L27:
        AppCompatImageView r11 = e();
        if (r11 == null) goto L30;
        int r12 = j0.a;
        r11.setContentDescription(j0.d(2131900499));
    L30:
        boolean r13 = h.a;
        if (h.a(null) == false) goto L35;
        AppCompatImageView r14 = e();
        if (r14 == null) goto L42;
        r14.setImageResource(2131242280);
        return;
    L42:
        return;
    L35:
        AppCompatImageView r15 = e();
        if (r15 == null) goto L44;
        r15.setImageResource(2131242277);
        return;
    }
}
