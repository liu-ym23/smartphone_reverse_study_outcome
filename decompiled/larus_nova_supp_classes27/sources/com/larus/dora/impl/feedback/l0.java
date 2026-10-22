package com.larus.dora.impl.feedback;

import android.text.Editable;
import android.text.TextWatcher;
import androidx.core.content.ContextCompat;
import com.larus.dora.impl.databinding.DoragFeedbackFragmentBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class l0 implements TextWatcher {
    public boolean a;
    public final /* synthetic */ DoraGFeedbackFragment b;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public l0(DoraGFeedbackFragment r1) {
        this.b = r1;
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
    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r6) {
        if (this.a == false) goto L5;
        return;
    L5:
        this.a = true;
        if (r6 == null) goto L18;
        DoraGFeedbackFragment r0 = this.b;
        int r1 = r6.length();
        int r2 = r0.h;
        if (r1 <= r2) goto L10;
        r6.replace(r2, r1, "");
    L10:
        int r3 = r6.length();
        DoragFeedbackFragmentBinding r4 = r0.f;
        Intrinsics.checkNotNull(r4);
        r4.o.setText(String.valueOf(r3));
        if (r1 <= r2) goto L13;
        int r5 = ContextCompat.getColor(r0.requireContext(), 2131101300);
    L14:
        DoragFeedbackFragmentBinding r7 = r0.f;
        Intrinsics.checkNotNull(r7);
        if (r7.o.getTextColors().getDefaultColor() == r5) goto L17;
        DoragFeedbackFragmentBinding r8 = r0.f;
        Intrinsics.checkNotNull(r8);
        r8.o.setTextColor(r5);
    L17:
        r0.X90().getFeedbackContentFlow().setValue(r6.toString());
        goto L18
    L13:
        r5 = ContextCompat.getColor(r0.requireContext(), 2131103683);
    L18:
        this.a = false;
    }
}
