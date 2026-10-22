package com.larus.dora.impl.guide.widget;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.dora.impl.databinding.LarusDoraGuideBindDeviceDialogBinding;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import g49.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ;2\u00020\u0001:\u0002:;B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010,\u001a\u00020\u001aH\u0016J&\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u001a\u00103\u001a\u00020)2\u0006\u00104\u001a\u00020.2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u00105\u001a\u00020)H\u0002J\u0010\u00106\u001a\u00020)2\u0006\u00107\u001a\u000208H\u0016J\b\u00109\u001a\u00020)H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/larus/dora/impl/guide/widget/DoraGuideBottomSheetDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "listener", "Lcom/larus/dora/impl/guide/widget/DoraGuideBottomSheetDialogFragment$InteractionListener;", "getListener", "()Lcom/larus/dora/impl/guide/widget/DoraGuideBottomSheetDialogFragment$InteractionListener;", "setListener", "(Lcom/larus/dora/impl/guide/widget/DoraGuideBottomSheetDialogFragment$InteractionListener;)V", "avatarUrl", "", "getAvatarUrl", "()Ljava/lang/String;", "setAvatarUrl", "(Ljava/lang/String;)V", "title", "getTitle", "setTitle", "subtitle", "getSubtitle", "setSubtitle", "confirmText", "getConfirmText", "setConfirmText", "avatarHeightResId", "", "getAvatarHeightResId", "()Ljava/lang/Integer;", "setAvatarHeightResId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "canCancel", "", "getCanCancel", "()Z", "setCanCancel", "(Z)V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraGuideBindDeviceDialogBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getTheme", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "setupView", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onDestroyView", "InteractionListener", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraGuideBottomSheetDialogFragment extends BottomSheetDialogFragment {
    public static final /* synthetic */ int l = 0;
    public b d;
    public String e;
    public String f;
    public String g;
    public String h;
    public Integer i;
    public boolean j;
    public LarusDoraGuideBindDeviceDialogBinding k;

    public static final class a {
    }

    public interface b {
        void onClose();

        void onConfirm();

        void onDismiss();
    }

    static {
    }

    public final int getTheme() {
        return 2131951935;
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        this.k = null;
    }

    public DoraGuideBottomSheetDialogFragment() {
    }

    public final void onCreate(Bundle r1) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r1);
        setCancelable(this.j);
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L7
        super/*androidx.fragment.app.DialogFragment*/.onDismiss(r2);     // Catch: Throwable -> L7
        d.d("DoraGuideBottomSheetDialogFragment", "onDismiss");     // Catch: Throwable -> L7
        b r3 = this.d;     // Catch: Throwable -> L7
        if (r3 == null) goto L5;
        r3.onDismiss();     // Catch: Throwable -> L7
    L5:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L7:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r3, r4);
        d.d("DoraGuideBottomSheetDialogFragment", "onViewCreated: title=" + this.f + ", subtitle=" + this.g);
        LarusDoraGuideBindDeviceDialogBinding r5 = this.k;
        if (r5 == null) goto L16;
        String r6 = this.e;
        if (r6 != null) goto L7;
    L10:
        boolean r7 = true;
    L11:
        if (r7 == true) goto L15;
        ImageLoaderKt.u(r5.b, this.e, "dora_guide");
        Integer r8 = this.i;
        if (r8 == null) goto L15;
        int r9 = r8.intValue();
        ViewGroup.LayoutParams r0 = r5.b.getLayoutParams();
        r0.height = getResources().getDimensionPixelSize(r9);
        r5.b.setLayoutParams(r0);
    L15:
        r5.f.setText(this.f);
        r5.e.setText(this.g);
        r5.d.setText(this.h);
        goto L16
    L7:
        if (r6.length() == 0) goto L10;
        r7 = false;
    L16:
        LarusDoraGuideBindDeviceDialogBinding r10 = this.k;
        if (r10 == null) goto L20;
        e1.d(r10.c, new k59.a(this));
        e1.d(r10.d, new k59.b(this));
        return;
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        LarusDoraGuideBindDeviceDialogBinding r4 = LarusDoraGuideBindDeviceDialogBinding.a(r1, r2);
        this.k = r4;
        return r4.a;
    }
}
