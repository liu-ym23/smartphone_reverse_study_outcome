package com.larus.voice_setting.voice.dialog;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.utils.e1;
import com.larus.voice_setting.impl.databinding.LarusDialogAuthorizeUgcVoiceBinding;
import com.larus.voice_setting.impl.databinding.LarusItemAuthorizeUgcVoiceBinding;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tx9.w2;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J&\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u001e\u001a\u00020\bH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/larus/voice_setting/voice/dialog/UgcVoiceAuthorizeDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "bind", "Lcom/larus/voice_setting/impl/databinding/LarusDialogAuthorizeUgcVoiceBinding;", "authorizeSuccess", "Lkotlin/Function0;", NameKeys.UnloadStrategy_No_Strategy, "getAuthorizeSuccess", "()Lkotlin/jvm/functions/Function0;", "setAuthorizeSuccess", "(Lkotlin/jvm/functions/Function0;)V", "enterFrom", NameKeys.UnloadStrategy_No_Strategy, "context", "Landroid/content/Context;", "getTheme", NameKeys.UnloadStrategy_No_Strategy, "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UgcVoiceAuthorizeDialog extends BottomSheetDialogFragment {
    public static final /* synthetic */ int h = 0;
    public LarusDialogAuthorizeUgcVoiceBinding d;
    public Function0<Unit> e;
    public String f;
    public Context g;

    public static final class a {
    }

    static {
    }

    public final int getTheme() {
        return 2131951931;
    }

    public UgcVoiceAuthorizeDialog() {
        this.e = new o();
    }

    public final void onCreate(Bundle r2) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r2);
        Bundle r3 = getArguments();
        if (r3 == null) goto L5;
        String r4 = r3.getString("authorize_enter_from");
    L6:
        this.f = r4;
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r9, r10);
        this.g = requireContext();
        BottomSheetDialog r11 = getDialog();
        if ((r11 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r12 = r11;
    L6:
        if (r12 == null) goto L8;
        View r13 = r12.findViewById(2131368870);
    L9:
        int r14 = com.larus.utils.m0.a;
        Context r15 = this.g;
        if (r15 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("context");
        r15 = null;
    L12:
        int r16 = com.larus.utils.m0.a(r15);
        com.larus.utils.i0.a.getClass();
        int r17 = ((r16 - com.larus.utils.i0.g()) - com.larus.utils.i0.e()) - i5.c0();
        if (r13 == null) goto L15;
        ViewGroup.LayoutParams r2 = r13.getLayoutParams();
        r2.height = r17;
        r13.setLayoutParams(r2);
        BottomSheetBehavior r3 = BottomSheetBehavior.from(r13);
        r13.setBackgroundResource(R.color.transparent);
        r3.setState(3);
        r3.setPeekHeight(r17);
    L15:
        LarusDialogAuthorizeUgcVoiceBinding r18 = this.d;
        if (r18 == null) goto L54;
        AppCompatImageView r19 = r18.f.b;
        Context r4 = this.g;
        if (r4 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("context");
        r4 = null;
    L20:
        Context r5 = this.g;
        if (r5 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("context");
        r5 = null;
    L23:
        r19.setColorFilter(ContextCompat.getColor(r4, v19.c.b(2130972079, r5, 2131103136)));
        LarusItemAuthorizeUgcVoiceBinding r110 = r18.d;
        TextView r6 = r110.d;
        Context r7 = this.g;
        if (r7 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("context");
        r7 = null;
    L26:
        r6.setText(r7.getText(2131911062));
        TextView r8 = r110.c;
        Context r20 = this.g;
        if (r20 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("context");
        r20 = null;
    L29:
        r8.setText(r20.getText(2131911063));
        AppCompatImageView r21 = r110.b;
        if (r21 == null) goto L32;
        r21.setImageResource(v19.c.b(2130971911, r21.getContext(), 2131242419));
    L32:
        AppCompatImageView r111 = r110.b;
        Context r22 = this.g;
        if (r22 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("context");
        r22 = null;
    L35:
        Context r23 = this.g;
        if (r23 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("context");
        r23 = null;
    L38:
        r111.setColorFilter(ContextCompat.getColor(r22, v19.c.b(2130972079, r23, 2131103136)));
        LarusItemAuthorizeUgcVoiceBinding r112 = r18.e;
        TextView r24 = r112.d;
        Context r25 = this.g;
        if (r25 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("context");
        r25 = null;
    L41:
        r24.setText(r25.getText(2131911064));
        TextView r26 = r112.c;
        Context r27 = this.g;
        if (r27 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("context");
        r27 = null;
    L44:
        r26.setText(r27.getText(2131911065));
        AppCompatImageView r28 = r112.b;
        if (r28 == null) goto L47;
        r28.setImageResource(v19.c.b(2130971912, r28.getContext(), 2131242422));
    L47:
        AppCompatImageView r113 = r112.b;
        Context r29 = this.g;
        if (r29 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("context");
        r29 = null;
    L50:
        Context r30 = this.g;
        if (r30 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("context");
        r30 = null;
    L53:
        r113.setColorFilter(ContextCompat.getColor(r29, v19.c.b(2130972079, r30, 2131103136)));
        e1.d(r18.c, new p(this));
        e1.d(r18.b, new q(this));
    L54:
        w2.c(this.f, null, null, 14);
        return;
    L8:
        r13 = null;
        goto L9
    L5:
        r12 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        LarusDialogAuthorizeUgcVoiceBinding r4 = LarusDialogAuthorizeUgcVoiceBinding.a(r1, r2);
        this.d = r4;
        return r4.a;
    }
}
