package com.bytedance.ies.xelement.input;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.inputmethod.BaseInputConnection;
import com.bytedance.ai.event.MessageIndication;
import com.lynx.base.log.LynxLog;
import com.lynx.xelement.input.LynxEditTextView;
import com.lynx.xelement.input.LynxUIBaseInput;
import com.obric.oui.badge.OBadgeView;
import com.obric.oui.forms.OBoxInputView;
import com.obric.oui.stepper.OSteppers;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6442b;

    public /* synthetic */ f(Object r5, int r10) {
        this.f6441a = r10;
        this.f6442b = r5;
    }

    private final void a(Editable r5) {
    }

    private final void b(CharSequence r5, int r10, int r11, int r12) {
    }

    private final void c(CharSequence r5, int r10, int r11, int r12) {
    }

    private final void d(CharSequence r5, int r10, int r11, int r12) {
    }

    private final void e(CharSequence r5, int r10, int r11, int r12) {
    }

    private final void f(CharSequence r5, int r10, int r11, int r12) {
    }

    private final void g(CharSequence r5, int r10, int r11, int r12) {
    }

    private final void h(CharSequence r5, int r10, int r11, int r12) {
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r11) {
        boolean r5 = true;
        LynxEditText r10 = null;
        Boolean r12 = null;
        r12 = null;
        int r13 = 0;
        Object r14 = this.f6442b;
        switch(this.f6441a) {
            case 0: goto L56;
            case 1: goto L54;
            case 2: goto L92;
            case 3: goto L52;
            case 4: goto L30;
            default: goto L4;
        };
    L4:
        LynxUIBaseInput r15 = (LynxUIBaseInput) r14;
        r15.m();
        if (LynxUIBaseInput.b(r15) == null) goto L90;
        if (r11 == null) goto L91;
        com.lynx.tasm.r r16 = r15.getLynxContext().g;
        com.lynx.animax.i r17 = new com.lynx.animax.i(r15.getSign(), "input");
        r17.a("value", r11.toString());
        if (((LynxEditTextView) LynxUIBaseInput.b(r15)).isFocused() == false) goto L10;
        int r18 = ((LynxEditTextView) LynxUIBaseInput.b(r15)).getSelectionStart();
    L12:
        if (((LynxEditTextView) LynxUIBaseInput.b(r15)).isFocused() == false) goto L14;
        int r19 = ((LynxEditTextView) LynxUIBaseInput.b(r15)).getSelectionEnd();
    L15:
        r17.a("selectionStart", Integer.valueOf(r18));
        r17.a("selectionEnd", Integer.valueOf(r19));
        LynxEditTextView r20 = (LynxEditTextView) LynxUIBaseInput.b(r15);
        if (r20 != null) goto L18;
    L28:
        r17.a("isComposing", r12);
        r16.b(r17);
        return;
    L18:
        if (r20.f11196c == true) goto L20;
        LynxLog.b(3, "LynxEditText", "InputConnection has not been initialized yet ");
        po.e r21 = null;
    L21:
        if (r21 == null) goto L28;
        int r22 = po.e.f21376a;
        Intrinsics.checkNotNullParameter(r11, MessageIndication.CONTENT_TYPE_TEXT);
        int r23 = BaseInputConnection.getComposingSpanStart(r11);
        int r110 = BaseInputConnection.getComposingSpanEnd(r11);
        if (r23 == (-1)) goto L26;
        if (r110 == (-1)) goto L26;
    L27:
        r12 = Boolean.valueOf(r5);
    L26:
        r5 = false;
        goto L27
    L20:
        r21 = r20.f11195b;
        goto L21
    L14:
        r19 = -1;
        goto L15
    L10:
        r18 = -1;
        goto L12
    L91:
        return;
    L90:
        return;
    L30:
        if (r11 != null) goto L32;
        String r111 = null;
    L33:
        OSteppers r24 = (OSteppers) r14;
        if (r111 != null) goto L36;
    L37:
        r24.getOnValueChangeListener();
    L38:
        if (r11 != null) goto L88;
    L47:
        OSteppers.o(r24, r13);     // Catch: Exception -> L49
    L50:
        int r112 = OSteppers.f14557w;
        r24.p();
        return;
    L49:
        Intrinsics.checkNotNullParameter("OSteppers", "tag");
        Intrinsics.checkNotNullParameter("input type error", "msg");
        Log.e("OSteppers", "input type error", null);
        goto L50
    L88:
        String r113 = r11.toString();     // Catch: Exception -> L49
        if (r113 == null) goto L47;
        Integer r114 = StringsKt.toIntOrNull(r113);     // Catch: Exception -> L49
        if (r114 == null) goto L47;
        r13 = r114.intValue();     // Catch: Exception -> L49
        goto L47
    L36:
        if (StringsKt.isBlank(r111) == false) goto L38;
    L32:
        r111 = r11.toString();
        goto L33
    L52:
        Intrinsics.checkNotNullParameter(r11, "s");
        OBoxInputView r25 = (OBoxInputView) r14;
        r25.getEditText().post(new com.obric.oui.forms.b(r25, r13));
        return;
    L54:
        LynxTextAreaView r26 = (LynxTextAreaView) r14;
        boolean r115 = r26.f6420x;
        r26.f6420x = true;
        LynxTextAreaView.s(r26);
        r26.f6420x = r115;
        r26.v();
        return;
    L56:
        LynxBaseInputView r27 = (LynxBaseInputView) r14;
        if (r27.s == false) goto L80;
        if (r27.f6420x == true) goto L80;
        if (r11 == null) goto L80;
        com.lynx.tasm.r r116 = r27.getLynxContext().g;
        com.lynx.animax.i r28 = new com.lynx.animax.i(r27.getSign(), "input");
        r28.a("value", r11.toString());
        LynxEditText r29 = r27.f6402a;
        if (r29 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r29 = null;
    L64:
        r28.a("cursor", Integer.valueOf(r29.getSelectionEnd()));
        r28.a("textLength", Integer.valueOf(r11.toString().length()));
        LynxEditText r30 = r27.f6402a;
        if (r30 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r30 = null;
    L68:
        if (r30.a() == null) goto L70;
        Boolean r117 = Boolean.valueOf(l.a(r11));
    L71:
        r28.a("isComposing", r117);
        LynxEditText r118 = r27.f6402a;
        if (r118 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r118 = null;
    L75:
        if (r118.getMPasting() == false) goto L77;
        String r119 = "paste";
    L78:
        r28.a("inputType", r119);
        r116.b(r28);
        goto L80
    L77:
        r119 = "normal";
        goto L78
    L70:
        r117 = null;
    L80:
        if (r27.f6420x == false) goto L82;
        r27.f6420x = false;
    L82:
        LynxEditText r120 = r27.f6402a;
        if (r120 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L86:
        r10.setMPasting(false);
        return;
    L85:
        r10 = r120;
        goto L86
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r10, int r11, int r12, int r13) {
        switch(this.f6441a) {
            case 0: goto L59;
            case 1: goto L7;
            case 2: goto L58;
            case 3: goto L5;
            case 4: goto L4;
            default: goto L4;
        };
    L4:
        return;
    L5:
        Intrinsics.checkNotNullParameter(r10, "s");
        return;
    L7:
        LynxTextAreaView r14 = (LynxTextAreaView) this.f6442b;
        if (r14.f6420x == true) goto L60;
        if (r13 == 0) goto L61;
        LynxEditText r15 = r14.M;
        Object r16 = null;
        if (r15 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r15 = null;
    L13:
        Editable r17 = r15.getText();
        if (r17 == null) goto L64;
        int r5 = r14.O;
        int r18 = r14.T;
        int r19 = 0;
        if ((r5 & r18) != r18) goto L35;
        int r20 = r11 + r12;
        Object[] r21 = r17.getSpans(r11, r20, we.b.class);
        int r22 = r21.length;
        int r23 = 0;
    L19:
        if (r23 >= r22) goto L30;
        Object r24 = r21[r23];
        if (r24 != null) goto L29;
        if (r17.getSpanStart(null) != r11) goto L27;
        if (r17.getSpanEnd(null) != r20) goto L27;
    L31:
        if (r24 == null) goto L35;
        throw new ClassCastException();
    L27:
        r23 = r23 + 1;
        goto L19
    L29:
        throw new ClassCastException();
    L30:
        r24 = null;
    L35:
        int r25 = r14.O;
        int r26 = r14.S;
        if ((r25 & r26) != r26) goto L62;
        int r110 = r12 + r11;
        Object[] r27 = r17.getSpans(r11, r110, se.b.class);
        int r28 = r27.length;
    L38:
        if (r19 >= r28) goto L45;
        Object r29 = r27[r19];
        se.b r30 = (se.b) r29;
        if (r17.getSpanStart(r30) != r11) goto L44;
        if (r17.getSpanEnd(r30) != r110) goto L44;
        r16 = r29;
    L44:
        r19 = r19 + 1;
    L45:
        se.b r111 = (se.b) r16;
        if (r111 == null) goto L63;
        r14.f6420x = true;
        r17.delete(r17.getSpanStart(r111), r17.getSpanEnd(r111));
        r14.f6420x = true;
        r17.insert(r11, r111.f21890b + r111.f21889a);
        return;
    L63:
        return;
    L62:
        return;
    L64:
        return;
    L61:
        return;
    L60:
        return;
    L58:
        return;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r5, int r10, int r11, int r12) {
        switch(this.f6441a) {
            case 0: goto L40;
            case 1: goto L15;
            case 2: goto L7;
            case 3: goto L5;
            case 4: goto L4;
            default: goto L4;
        };
    L4:
        return;
    L5:
        Intrinsics.checkNotNullParameter(r5, "s");
        return;
    L7:
        OBadgeView r13 = (OBadgeView) this.f6442b;
        com.obric.oui.badge.b r14 = r13.f11975i;
        String r15 = null;
        if (r14 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r14 = null;
    L10:
        if (r5 == null) goto L13;
        r15 = r5.toString();
    L13:
        r14.d(r15);
        r13.requestLayout();
        r13.invalidate();
        return;
    L15:
        LynxTextAreaView r16 = (LynxTextAreaView) this.f6442b;
        int r17 = r16.O;
        int r18 = r16.S;
        if ((r17 & r18) != r18) goto L35;
        if (r16.Q == false) goto L35;
        if (r16.f6420x == true) goto L35;
        if (r11 != 0) goto L35;
        if (r12 != 1) goto L35;
        if (TextUtils.isEmpty(r5) == true) goto L35;
        if (r5 != null) goto L28;
    L30:
        if (r5 == null) goto L35;
        if (r5.charAt(r10) != '#') goto L35;
    L33:
        r16.getLynxContext().g.b(new com.lynx.animax.i(r16.getSign(), "mention"));
        goto L35
    L28:
        if (r5.charAt(r10) != '@') goto L30;
    L35:
        if (r16.s == false) goto L37;
        return;
    L37:
        if (r16.f6420x == false) goto L42;
        r16.f6420x = false;
        return;
    L42:
        return;
    }
}
