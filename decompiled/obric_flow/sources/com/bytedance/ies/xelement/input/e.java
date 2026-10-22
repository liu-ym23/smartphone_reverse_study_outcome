package com.bytedance.ies.xelement.input;

import android.text.Editable;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.inputmethod.BaseInputConnection;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements InputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f6439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LynxBaseInputView f6440c;

    public e(LynxBaseInputView r5) {
        this.f6440c = r5;
        this.f6438a = 140;
        this.f6439b = "";
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence r18, int r19, int r20, Spanned r21, int r22, int r23) {
        CharSequence r5 = r18;
        Intrinsics.checkNotNullParameter(r5, "source");
        Intrinsics.checkNotNullParameter(r21, "dest");
        boolean r10 = StringsKt.isBlank(this.f6439b);
        LynxEditText r11 = null;
        LynxBaseInputView r12 = this.f6440c;
        if (r10 == true) goto L24;
        String r13 = this.f6439b.toString();
        int r14 = LynxBaseInputView.L;
        r12.getClass();
        if ((r5 instanceof Spannable) == false) goto L14;
        LynxEditText r15 = r12.f6402a;
        if (r15 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r15 = null;
    L10:
        if (r15.a() == null) goto L14;
        boolean r16 = true;
        if (l.a((Spannable) r5) != true) goto L14;
    L15:
        SpannableStringBuilder r17 = new SpannableStringBuilder();
        Matcher r24 = Pattern.compile(r13).matcher(r5);
        int r110 = r18.length();
        int r111 = 0;
    L17:
        if (r24.find() == false) goto L19;
        int r112 = r24.start();
        int r113 = r24.end();
        r17.append(r5.subSequence(r111, r112));
        r17.append("");
        r111 = r113;
        goto L17
    L19:
        if (r111 >= r110) goto L21;
        r17.append(r5.subSequence(r111, r110));
    L21:
        if (r16 == false) goto L23;
        BaseInputConnection.setComposingSpans(r17);
    L23:
        int r25 = r17.length();
        r5 = r17;
    L25:
        int r114 = this.f6438a - (r21.length() - (r23 - r22));
        if (r114 <= 0) goto L28;
        CharSequence r26 = this.f6440c.b(r5, r19, r25, r21, r22, r23);
        if (r114 < (r26.length() - r19)) goto L59;
        return r26;
    L59:
        Iterator r27 = Regex.findAll$default(new Regex("(?:[🌀-🗿]|[🤀-🧿]|[😀-🙏]|[🚀-\u1f6ff]|[☀-⛿]️?|[✀-➿]️?|Ⓜ️?|[🇦-🇿]{1,2}|[🅰🅱🅾🅿🆎🆑-🆚]️?|[#*0-9]️?⃣|[↔-↙↩-↪]️?|[⬅-⬇⬛⬜⭐⭕]️?|[⤴⤵]️?|[〰〽]️?|[㊗㊙]️?|[🈁🈂🈚🈯🈲-🈺🉐🉑]️?|[‼⁉]️?|[▪▫▶◀◻-◾]️?|[©®]️?|[™ℹ]️?|🀄️?|🃏️?|[⌚⌛⌨⏏⏩-⏳⏸-⏺]️?)"), r26, 0, 2, null).iterator();
    L61:
        if (r27.hasNext() == false) goto L74;
        MatchResult r28 = (MatchResult) r27.next();
        int r29 = r114 + r19;
        if (r28.getRange().getFirst() > r29) goto L61;
        if ((r28.getValue().length() + r28.getRange().getFirst()) <= r29) goto L61;
        CharSequence r30 = r26.subSequence(r19, r28.getRange().getFirst());
        if (r12.f6419w == true) goto L69;
    L72:
        return r30;
    L69:
        if (r12.f6402a != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L71:
        r12.getLynxContext().g.b(new com.lynx.animax.i(r12.getSign(), "length"));
        goto L72
    L74:
        return r26.subSequence(r19, r114 + r19);
    L28:
        if (r12.f6419w == false) goto L41;
        LynxEditText r31 = r12.f6402a;
        if (r31 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r31 = null;
    L32:
        Editable r32 = r31.getText();
        if (r32 == null) goto L41;
        if (r32.length() != r12.f6403b) goto L41;
        if (r12.f6402a != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L39:
        r12.getLynxContext().g.b(new com.lynx.animax.i(r12.getSign(), "length"));
    L41:
        if (r12.s == false) goto L50;
        LynxEditText r33 = r12.f6402a;
        if (r33 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r33 = null;
    L45:
        com.lynx.tasm.r r34 = r12.getLynxContext().g;
        com.lynx.animax.i r35 = new com.lynx.animax.i(r12.getSign(), "input");
        r35.a("value", String.valueOf(r33.getText()));
        r35.a("cursor", Integer.valueOf(r33.getSelectionEnd()));
        r35.a("textLength", Integer.valueOf(String.valueOf(r33.getText()).length()));
        if (r33.getMPasting() == false) goto L48;
        String r36 = "paste";
    L49:
        r35.a("inputType", r36);
        r34.b(r35);
        goto L50
    L48:
        r36 = "normal";
    L50:
        LynxEditText r37 = r12.f6402a;
        if (r37 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L54:
        r11.setMPasting(false);
        return "";
    L53:
        r11 = r37;
    L14:
        r16 = false;
        goto L15
    L24:
        r25 = r20;
        goto L25
    }
}
