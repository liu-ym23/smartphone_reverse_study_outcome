package com.larus.bot.impl.feature.edit.feature.accesspermission;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.bot.impl.databinding.LarusDialogBotPublicPermissionBinding;
import com.larus.bot.impl.feature.edit.view.BotAccessPermissionItem;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import v19.o5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0010\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010'\u001a\u00020\u0007H\u0016J&\u0010(\u001a\u0004\u0018\u00010\u000e2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u000e2\b\u0010-\u001a\u0004\u0018\u00010$H\u0016J\u0010\u00100\u001a\u00020\u00192\u0006\u00101\u001a\u00020\u0007H\u0002J\b\u00102\u001a\u00020\u0019H\u0002J\u0017\u00103\u001a\u0004\u0018\u00010\u00192\u0006\u00101\u001a\u00020\u0007H\u0002¢\u0006\u0002\u00104J\u0010\u00105\u001a\u00020\u00192\u0006\u00106\u001a\u000207H\u0016J>\u00108\u001a\u00020\u001926\u0010\u001e\u001a2\u0012\u0013\u0012\u00110 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110$¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u00190\u001fJ\b\u00109\u001a\u00020\u0019H\u0002J\u0010\u0010:\u001a\u00020\u00192\u0006\u00106\u001a\u000207H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0012\u0010\u0014R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR@\u0010\u001e\u001a4\u0012\u0013\u0012\u00110 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110$¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/accesspermission/BotPublicPermissionBSDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/bot/impl/databinding/LarusDialogBotPublicPermissionBinding;", "scene", "", "getScene", "()I", "scene$delegate", "Lkotlin/Lazy;", "behavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/view/View;", "behaviorCallback", "com/larus/bot/impl/feature/edit/feature/accesspermission/BotPublicPermissionBSDialog$behaviorCallback$1", "Lcom/larus/bot/impl/feature/edit/feature/accesspermission/BotPublicPermissionBSDialog$behaviorCallback$1;", "isPublicStatus", "", "()Z", "isPublicStatus$delegate", "isChosen", "onTouchOutside", "Lkotlin/Function0;", "", "getOnTouchOutside", "()Lkotlin/jvm/functions/Function0;", "setOnTouchOutside", "(Lkotlin/jvm/functions/Function0;)V", "resultCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "requestKey", "Landroid/os/Bundle;", "result", "currentStatus", "getTheme", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "onViewCreated", "view", "handleItemSelected", "status", "handleConfirm", "setupPrivateStatusUI", "(I)Lkotlin/Unit;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "setResultCallback", "setPublicBotText", "onCancel", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotPublicPermissionBSDialog extends BottomSheetDialogFragment {
    public static final /* synthetic */ int m = 0;
    public LarusDialogBotPublicPermissionBinding d;
    public final Lazy e;
    public BottomSheetBehavior<View> f;
    public final b g;
    public final Lazy h;
    public boolean i;
    public Function0<Unit> j;
    public Function2<? super String, ? super Bundle, Unit> k;
    public int l;

    public static final class a {
    }

    public static final class b extends BottomSheetBehavior.BottomSheetCallback {
        public final /* synthetic */ BotPublicPermissionBSDialog a;

        public final void onSlide(View r1, float r2) {
            Intrinsics.checkNotNullParameter(r1, "bottomSheet");
        }

        public b(BotPublicPermissionBSDialog r1) {
            this.a = r1;
        }

        public final void onStateChanged(View r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "bottomSheet");
            if (r3 != 1) goto L8;
            BottomSheetBehavior<View> r4 = this.a.f;
            if (r4 == null) goto L9;
            r4.setState(4);
            return;
        L9:
            return;
        }
    }

    static {
    }

    public final int getTheme() {
        return 2131954335;
    }

    public BotPublicPermissionBSDialog() {
        this.e = LazyKt.lazy(new j(this));
        this.g = new b(this);
        this.h = LazyKt.lazy(new k(this));
        this.l = 1;
    }

    public static void S90(BotPublicPermissionBSDialog r1) {
        r1.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void T90(int r5) {
        LarusDialogBotPublicPermissionBinding r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r5 != 1) goto L7;
        r0.d.setItemSelected(true);
        r0.f.setItemSelected(false);
        r0.c.setItemSelected(false);
    L14:
        Unit r6 = Unit.INSTANCE;
        return;
    L7:
        if (r5 != 2) goto L9;
        r0.d.setItemSelected(false);
        r0.f.setItemSelected(false);
        r0.c.setItemSelected(true);
        goto L14
    L9:
        if (r5 != 3) goto L14;
        r0.d.setItemSelected(false);
        r0.f.setItemSelected(true);
        r0.c.setItemSelected(false);
        goto L14
    }

    public final void onCancel(DialogInterface r3) {
        Intrinsics.checkNotNullParameter(r3, "dialog");
        super/*androidx.fragment.app.DialogFragment*/.onCancel(r3);
        o5.a(this, "public_permission_cancel_request", com.larus.utils.f.c(new Pair[0]));
        Function2<? super String, ? super Bundle, Unit> r0 = this.k;
        if (r0 == null) goto L6;
        r0.invoke("public_permission_cancel_request", com.larus.utils.f.c(new Pair[0]));
        return;
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L9
        super/*androidx.fragment.app.DialogFragment*/.onDismiss(r2);     // Catch: Throwable -> L9
        if (this.i == true) goto L7;
        Function0<Unit> r3 = this.j;     // Catch: Throwable -> L9
        if (r3 == null) goto L7;
        r3.invoke();     // Catch: Throwable -> L9
    L7:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L9:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r3, r4);
        Dialog r5 = getDialog();
        if (r5 == null) goto L5;
        r5.setOnShowListener(new l(this));
    L5:
        this.i = false;
        LarusDialogBotPublicPermissionBinding r6 = this.d;
        if (r6 == null) goto L10;
        r6.h.setOnClickListener(new m(this));
        LarusDialogBotPublicPermissionBinding r7 = this.d;
        if (r7 == null) goto L10;
        e1.d(r7.d, new n(this));
        e1.d(r7.f, new o(this));
        e1.d(r7.c, new p(this));
        e1.d(r7.b, new q(this));
    L10:
        T90(this.l);
        int r8 = dv8.a.a;
        com.larus.platform.service.o.a.b("bot_visible_status_confirmation_show", com.larus.utils.f.c(new Pair[0]));
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        View r13 = r10.inflate(2131562039, r11, false);
        int r14 = 2131364539;
        if (ViewBindings.findChildViewById(r13, 2131364539) == null) goto L27;
        r14 = 2131367647;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r13, 2131367647);
        if (r2 == null) goto L27;
        r14 = 2131374656;
        BotAccessPermissionItem r3 = (BotAccessPermissionItem) ViewBindings.findChildViewById(r13, 2131374656);
        if (r3 == null) goto L27;
        r14 = 2131374657;
        BotAccessPermissionItem r4 = (BotAccessPermissionItem) ViewBindings.findChildViewById(r13, 2131374657);
        if (r4 == null) goto L27;
        r14 = 2131374658;
        View r5 = ViewBindings.findChildViewById(r13, 2131374658);
        if (r5 == null) goto L27;
        r14 = 2131374659;
        BotAccessPermissionItem r6 = (BotAccessPermissionItem) ViewBindings.findChildViewById(r13, 2131374659);
        if (r6 == null) goto L27;
        r14 = 2131374660;
        View r7 = ViewBindings.findChildViewById(r13, 2131374660);
        if (r7 == null) goto L27;
        r14 = 2131376107;
        ImageView r8 = (ImageView) ViewBindings.findChildViewById(r13, 2131376107);
        if (r8 == null) goto L27;
        r14 = 2131376297;
        if (((ImageView) ViewBindings.findChildViewById(r13, 2131376297)) == null) goto L27;
        r14 = 2131383029;
        if (ViewBindings.findChildViewById(r13, 2131383029) == null) goto L27;
        r14 = 2131388772;
        if (((TextView) ViewBindings.findChildViewById(r13, 2131388772)) == null) goto L27;
        ScrollView r15 = (ScrollView) r13;
        this.d = new LarusDialogBotPublicPermissionBinding(r15, r2, r3, r4, r5, r6, r7, r8);
        return r15;
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r14)));
    }
}
