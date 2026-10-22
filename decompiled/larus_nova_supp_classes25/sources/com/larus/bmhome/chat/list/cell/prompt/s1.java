package com.larus.bmhome.chat.list.cell.prompt;

import android.view.View;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.layout.item.PromptSpan;
import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class s1 implements View.OnAttachStateChangeListener {
    public final View a;
    public final ICoreInputAbility b;
    public final va8.o c;
    public final Function0<Message> d;
    public final Function1<Boolean, Unit> e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public final r1 j;

    public final void a() {
        Message r0 = (Message) this.d.invoke();
        String r1 = null;
        boolean r2 = false;
        if (r0 != null) goto L5;
    L25:
        boolean r3 = false;
    L26:
        if (r3 == false) goto L38;
        va8.o r4 = this.c;
        if (r4 == null) goto L30;
        r1 = r4.u7();
    L30:
        if (r1 != null) goto L32;
    L33:
        r2 = true;
    L34:
        if (r2 == true) goto L39;
        this.i = true;
        b(this.a.isAttachedToWindow());
        c(true, true);
        return;
    L39:
        return;
    L32:
        if (StringsKt.isBlank(r1) == false) goto L34;
    L38:
        return;
    L5:
        if (com.larus.bmhome.chat.bean.d.W0(r0) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L25;
        Map r5 = r0.getBusinessExt();
        if (r5 == null) goto L16;
        String r6 = (String) r5.get("next_pulse_scene");
        if (r6 == null) goto L16;
        Integer r7 = StringsKt.toIntOrNull(r6);
        if (r7 == null) goto L16;
    L20:
        if (r7 == null) goto L25;
        if (r7.intValue() != 10) goto L25;
        r3 = true;
    L16:
        String r8 = (String) com.larus.bmhome.chat.bean.d.x(r0).get("next_pulse_scene");
        if (r8 == null) goto L19;
        r7 = StringsKt.toIntOrNull(r8);
        goto L20
    L19:
        r7 = null;
        goto L20
    }

    public final boolean e() {
        Message r0 = (Message) this.d.invoke();
        if (r0 == null) goto L31;
        Integer r3 = null;
        if (com.larus.bmhome.chat.bean.d.W0(r0) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L33;
        Map r2 = r0.getBusinessExt();
        if (r2 == null) goto L18;
        String r4 = (String) r2.get("next_pulse_scene");
        if (r4 == null) goto L18;
        Integer r5 = StringsKt.toIntOrNull(r4);
        if (r5 == null) goto L18;
        r3 = r5;
    L21:
        if (r3 != null) goto L24;
    L25:
        if (r3 != null) goto L28;
        return false;
    L28:
        if (r3.intValue() != 11) goto L32;
    L29:
        return true;
    L32:
        return false;
    L24:
        if (r3.intValue() == 12) goto L29;
    L18:
        String r1 = (String) com.larus.bmhome.chat.bean.d.x(r0).get("next_pulse_scene");
        if (r1 == null) goto L21;
        r3 = StringsKt.toIntOrNull(r1);
        goto L21
    L33:
        return false;
    L31:
        return false;
    }

    public final boolean d() {
        if (e() == false) goto L5;
    L6:
        va8.o r0 = this.c;
        if (r0 == null) goto L9;
        String r1 = r0.u7();
    L11:
        if (r1 != null) goto L13;
    L16:
        boolean r2 = true;
    L17:
        if (r2 == true) goto L21;
        return true;
    L21:
        return false;
    L13:
        if (StringsKt.isBlank(r1) == true) goto L16;
        r2 = false;
        goto L17
    L9:
        r1 = null;
        goto L11
    L5:
        if (this.i == true) goto L6;
        return false;
    }

    public final void f() {
        if (e() == true) goto L7;
        if (this.i == true) goto L7;
    L9:
        boolean r0 = false;
    L10:
        b(r0);
        c(d(), false);
        return;
    L7:
        if (this.a.isAttachedToWindow() == false) goto L9;
        r0 = true;
        goto L10
    }

    public final void b(boolean r3) {
        if (this.g != r3) goto L5;
        return;
    L5:
        if (r3 == false) goto L9;
        ICoreInputAbility r0 = this.b;
        if (r0 == null) goto L12;
        r0.QG(this.j);
    L12:
        this.g = r3;
        return;
    L9:
        ICoreInputAbility r1 = this.b;
        if (r1 == null) goto L12;
        r1.Vs(this.j);
        goto L12
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        f();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        b(false);
        this.a.animate().cancel();
        this.a.setAlpha(1.0f);
    }

    public final void c(boolean r9, boolean r10) {
        this.a.animate().cancel();
        boolean r0 = true;
        View r1 = null;
        if (r9 == true) goto L5;
    L16:
        this.f = r9;
        float r6 = 0.0f;
        if (r9 == false) goto L24;
        if (r10 == true) goto L20;
    L22:
        lf8.a.e(this.a);
        this.a.setAlpha(1.0f);
        this.e.invoke(Boolean.TRUE);
        return;
    L20:
        if (this.a.isShown() == false) goto L22;
        this.a.animate().alpha(0.0f).setDuration(150).withEndAction(new q1(this)).start();
        return;
    L24:
        if (this.h == false) goto L47;
        Object r11 = this.a.getParent();
        if ((r11 instanceof View) == false) goto L29;
        r1 = (View) r11;
    L29:
        if (r1 != null) goto L31;
    L33:
        r0 = false;
    L34:
        if (r0 == false) goto L36;
        r6 = this.a.getAlpha();
    L36:
        lf8.a.f(this.a);
        this.h = false;
        this.e.invoke(Boolean.FALSE);
        View r12 = this.a;
        if (r10 == true) goto L40;
        r6 = 1.0f;
    L40:
        r12.setAlpha(r6);
        if (r10 == false) goto L46;
        this.a.animate().alpha(1.0f).setDuration(150).start();
        return;
    L46:
        return;
    L31:
        if (r1.getVisibility() != 0) goto L33;
    L47:
        return;
    L5:
        if (this.f == true) goto L16;
        Object r3 = this.a.getParent();
        if ((r3 instanceof View) == false) goto L9;
        View r4 = (View) r3;
    L10:
        if (r4 != null) goto L12;
    L14:
        boolean r5 = false;
    L15:
        this.h = r5;
        goto L16
    L12:
        if (r4.getVisibility() != 0) goto L14;
        r5 = true;
        goto L15
    L9:
        r4 = null;
        goto L10
    }

    public s1(PromptSpan r2, ICoreInputAbility r3, va8.o r4, d0 r5, e0 r6) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r5, "source");
        Intrinsics.checkNotNullParameter(r6, "onVisibilityChanged");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.j = new r1(this);
        r2.addOnAttachStateChangeListener(this);
        if (r2.isAttachedToWindow() == false) goto L6;
        f();
        return;
    }
}
