package com.larus.bmhome.instruction;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.chat.common.databinding.LarusLayoutInstructionEditorContainerBinding;
import com.larus.image.loader.ImageLoaderKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class o implements b2 {
    public final Function0<LarusLayoutInstructionEditorContainerBinding> a;

    @Override // com.larus.bmhome.instruction.b2
    public final ScrollView a() {
        LarusLayoutInstructionEditorContainerBinding r0 = (LarusLayoutInstructionEditorContainerBinding) this.a.invoke();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.e;
    }

    @Override // com.larus.bmhome.instruction.b2
    public final ConstraintLayout c() {
        LarusLayoutInstructionEditorContainerBinding r0 = (LarusLayoutInstructionEditorContainerBinding) this.a.invoke();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.j;
    }

    @Override // com.larus.bmhome.instruction.b2
    public final AppCompatTextView e() {
        LarusLayoutInstructionEditorContainerBinding r0 = (LarusLayoutInstructionEditorContainerBinding) this.a.invoke();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b;
    }

    @Override // com.larus.bmhome.instruction.b2
    public final LinearLayout f() {
        LarusLayoutInstructionEditorContainerBinding r0 = (LarusLayoutInstructionEditorContainerBinding) this.a.invoke();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.i;
    }

    @Override // com.larus.bmhome.instruction.b2
    public final ConstraintLayout g() {
        LarusLayoutInstructionEditorContainerBinding r0 = (LarusLayoutInstructionEditorContainerBinding) this.a.invoke();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a;
    }

    @Override // com.larus.bmhome.instruction.b2
    public final ConstraintLayout h() {
        LarusLayoutInstructionEditorContainerBinding r0 = (LarusLayoutInstructionEditorContainerBinding) this.a.invoke();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.k;
    }

    @Override // com.larus.bmhome.instruction.b2
    public final AppCompatImageView i() {
        LarusLayoutInstructionEditorContainerBinding r0 = (LarusLayoutInstructionEditorContainerBinding) this.a.invoke();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c;
    }

    @Override // com.larus.bmhome.instruction.b2
    public final View j() {
        LarusLayoutInstructionEditorContainerBinding r0 = (LarusLayoutInstructionEditorContainerBinding) this.a.invoke();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d;
    }

    @Override // com.larus.bmhome.instruction.b2
    public final SimpleDraweeView k() {
        LarusLayoutInstructionEditorContainerBinding r0 = (LarusLayoutInstructionEditorContainerBinding) this.a.invoke();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.h;
    }

    public o(x r2) {
        Intrinsics.checkNotNullParameter(r2, "bindingProvider");
        this.a = r2;
    }

    @Override // com.larus.bmhome.instruction.b2
    public final void d(Drawable r2) {
        LarusLayoutInstructionEditorContainerBinding r0 = (LarusLayoutInstructionEditorContainerBinding) this.a.invoke();
        if (r0 == null) goto L8;
        AppCompatImageView r1 = r0.c;
        if (r1 == null) goto L9;
        r1.setImageDrawable(r2);
        return;
    L9:
        return;
    }

    @Override // com.larus.bmhome.instruction.b2
    public final void b(String r3, Integer r4) {
        LarusLayoutInstructionEditorContainerBinding r0 = (LarusLayoutInstructionEditorContainerBinding) this.a.invoke();
        if (r0 == null) goto L10;
        SimpleDraweeView r1 = r0.h;
        if (r1 == null) goto L11;
        ImageLoaderKt.u(r1, r3, null);
        if (r4 == null) goto L12;
        r1.setColorFilter(r4.intValue());
        return;
    L12:
        return;
    L11:
        return;
    }
}
