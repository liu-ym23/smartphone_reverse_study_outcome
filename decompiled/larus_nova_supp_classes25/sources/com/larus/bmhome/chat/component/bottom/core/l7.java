package com.larus.bmhome.chat.component.bottom.core;

import android.widget.EditText;
import android.widget.ImageView;
import com.larus.bmhome.chat.component.bottom.voice.a;
import com.larus.input.impl.databinding.LarusWidgetInputBinding;
import com.larus.platform.model.chat.MessageModifyStyle;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l7 implements Function0<Unit> {
    public final /* synthetic */ CoreInputComponent a;
    public final /* synthetic */ EditText b;
    public final /* synthetic */ LarusWidgetInputBinding c;
    public final /* synthetic */ Ref.ObjectRef<String> d;

    public l7(CoreInputComponent r1, EditText r2, LarusWidgetInputBinding r3, Ref.ObjectRef<String> r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final Object invoke() {
        CoreInputComponent r0 = this.a;
        EditText r1 = this.b;
        int r2 = CoreInputComponent.d3;
        r0.getClass();
        boolean r3 = true;
        if (CoreInputComponent.d5(r1) <= 1) goto L5;
        r0.h3();
    L7:
        if (this.a.k4().Y() == false) goto L57;
        int r4 = this.a.F4().getCurrentInputStatus();
        if (r4 != 3) goto L11;
    L17:
        boolean r5 = true;
    L18:
        if (r5 == true) goto L20;
    L41:
        com.larus.utils.e1.o(this.c.k);
        a r6 = this.a.Zd();
        if (r6 != null) goto L44;
    L46:
        boolean r7 = false;
    L47:
        if (r7 == true) goto L57;
        CoreInputComponent r8 = this.a;
        a r9 = r8.Zd();
        if (r9 != null) goto L51;
    L53:
        r3 = false;
    L54:
        if (r3 == false) goto L57;
        r8.z3();
        goto L57
    L51:
        if (r9.q40() != true) goto L53;
    L44:
        if (r6.DG() != true) goto L46;
        r7 = true;
        goto L47
    L20:
        if (this.a.r6(this.b) == false) goto L41;
        if (com.larus.utils.e1.r(this.c.k) == false) goto L24;
        this.a.F4().trackOnShowFullInputBoxButton((String) this.d.element);
    L24:
        ImageView r10 = this.a.P1;
        if (r10 != null) goto L27;
    L31:
        com.larus.utils.e1.x(this.c.k);
        CoreInputComponent r11 = this.a;
        a r12 = r11.Zd();
        if (r12 != null) goto L34;
    L36:
        r3 = false;
    L37:
        if (r3 == false) goto L40;
        r11.p3();
    L40:
        this.a.F4().setIsShowFullInputBox();
        goto L57
    L34:
        if (r12.q40() != true) goto L36;
    L27:
        if (r10.getVisibility() != 0) goto L29;
        boolean r13 = true;
    L30:
        if (r13 == true) goto L40;
    L29:
        r13 = false;
        goto L30
    L11:
        if (r4 == 4) goto L14;
    L16:
        r5 = false;
        goto L18
    L14:
        if (com.larus.platform.service.z2.a.messageModifyConfig().a != MessageModifyStyle.FULL_BOX) goto L16;
    L57:
        Ref.ObjectRef<String> r14 = this.d;
        r14.element = this.b.getText().toString();
        this.a.u6();
        this.a.E5();
        return Unit.INSTANCE;
    L5:
        r0.m3();
        goto L7
    }
}
