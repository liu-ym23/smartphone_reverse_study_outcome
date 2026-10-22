package com.larus.share.impl.view;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.platform.service.z2;
import com.larus.share.impl.databinding.LarusDialogFragmentLongImageShareBinding;
import com.larus.share.impl.panel.SharePanelAdapter;
import com.larus.share.impl.panel.SharePanelItemDecoration;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 ?2\u00020\u0001:\u0001?B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020 2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010!\u001a\u00020\u001cH\u0016J&\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020#2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u0010/\u001a\u00020\nH\u0002J\b\u00100\u001a\u00020\u001cH\u0002J\b\u00101\u001a\u00020\u001cH\u0002J\u0018\u00102\u001a\u0002032\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u00020\nH\u0002J\b\u00106\u001a\u00020\u001cH\u0002J\u001c\u00107\u001a\u0004\u0018\u0001032\u0006\u00108\u001a\u00020.2\b\u00109\u001a\u0004\u0018\u000103H\u0002J\u0012\u0010:\u001a\u0004\u0018\u0001032\u0006\u00108\u001a\u00020.H\u0002J\u001c\u0010;\u001a\u00020.2\b\u0010<\u001a\u0004\u0018\u00010.2\b\u0010=\u001a\u0004\u0018\u00010>H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0010\u0010\fR\u001b\u0010\u0012\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0013\u0010\fR\u001b\u0010\u0015\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0016\u0010\fR\u001b\u0010\u0018\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u0019\u0010\f¨\u0006@"}, d2 = {"Lcom/larus/share/impl/view/LongImageShareDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "shareContext", "Lcom/larus/share/impl/view/LongImageShareContext;", "<init>", "(Lcom/larus/share/impl/view/LongImageShareContext;)V", "()V", "binding", "Lcom/larus/share/impl/databinding/LarusDialogFragmentLongImageShareBinding;", "screenWidth", "", "getScreenWidth", "()I", "screenWidth$delegate", "Lkotlin/Lazy;", "qrCodeSize", "getQrCodeSize", "qrCodeSize$delegate", "qrCodePaddingEnd", "getQrCodePaddingEnd", "qrCodePaddingEnd$delegate", "qrCodePaddingBottom", "getQrCodePaddingBottom", "qrCodePaddingBottom$delegate", "qrCodeMarginBottom", "getQrCodeMarginBottom", "qrCodeMarginBottom$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onStart", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "", "getDialogThemeResId", "setupTitleBar", "setupLongImage", "scaleBitmap", "Landroid/graphics/Bitmap;", "bitmap", "targetWidth", "setupSharePanel", "replaceQRCode", "url", "imageBitmap", "regenerateQRCode", "getAIGCMetadataCheckSceneStr", "channel", "trackNode", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class LongImageShareDialogFragment extends DialogFragment {
    public static final /* synthetic */ int k = 0;
    public final j d;
    public LarusDialogFragmentLongImageShareBinding e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;

    public static final class a {
    }

    static {
    }

    public LongImageShareDialogFragment() {
        this(null);
        dismissAllowingStateLoss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Exception -> L10
        Throwable r0 = DialogFragmentLancet.sLastShowStack;     // Catch: Exception -> L10
        if (r0 == null) goto L17;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Exception -> L10
        return;
    L17:
        return;
    L10:
        e = move-exception;
        FLogger.a.e("LongImageShareDialogFragment", "no argument constructor, dismiss failed", e);
    }

    public final int S90() {
        return ((Number) this.g.getValue()).intValue();
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L8;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L9;
        r1.setLayout(-1, -1);
        r1.setWindowAnimations(2131954385);
        return;
    L9:
        return;
    }

    public LongImageShareDialogFragment(j r1) {
        this.d = r1;
        this.f = LazyKt.lazy(new k());
        this.g = LazyKt.lazy(new l());
        this.h = LazyKt.lazy(new m());
        this.i = LazyKt.lazy(new n());
        this.j = LazyKt.lazy(new o());
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        if (r4 != null) goto L5;
    L17:
        j r5 = this.d;
        if (r5 == null) goto L24;
        com.larus.bmhome.share.panel.e r6 = r5.d;
        if (r6 == null) goto L24;
        boolean r1 = true;
        if (r6.a != true) goto L24;
    L25:
        if (r1 == false) goto L27;
        int r7 = 2131953415;
    L28:
        setStyle(0, r7);
        return;
    L27:
        r7 = 2131953414;
    L24:
        r1 = false;
        goto L25
    L5:
        if (z2.a.optDialogDismiss() == false) goto L17;
        FLogger.a.i("LongImageShareDialogFragment", "UI mode changed during recreation, dismissing dialog");
        dismissAllowingStateLoss();     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Exception -> L14
        Throwable r8 = DialogFragmentLancet.sLastShowStack;     // Catch: Exception -> L14
        if (r8 == null) goto L34;
        com.bytedance.crash.d.d(r8, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Exception -> L14
        return;
    L34:
        return;
    L14:
        e = move-exception;
        FLogger.a.e("LongImageShareDialogFragment", "no argument constructor, dismiss failed", e);
    }

    public final Dialog onCreateDialog(Bundle r4) {
        Context r0 = requireContext();
        j r1 = this.d;
        if (r1 == null) goto L9;
        com.larus.bmhome.share.panel.e r2 = r1.d;
        if (r2 == null) goto L9;
        if (r2.a != true) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L12;
        int r5 = 2131953415;
    L13:
        Dialog r6 = new Dialog(r0, r5);
        r6.requestWindowFeature(1);
        return r6;
    L12:
        r5 = 2131953414;
    L9:
        r3 = false;
        goto L10
    }

    public final void onViewCreated(View r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r13, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r13, r14);
        LarusDialogFragmentLongImageShareBinding r15 = this.e;
        if (r15 == null) goto L21;
        ImageView r16 = r15.b;
        if (r16 == null) goto L21;
        e1.d(r16, new p(this));
        j r1 = this.d;
        if (r1 == null) goto L13;
        com.larus.bmhome.share.panel.e r2 = r1.d;
        if (r2 == null) goto L13;
        if (r2.a != true) goto L13;
        boolean r3 = true;
    L14:
        if (r3 == true) goto L19;
        boolean r4 = v19.h.a;
        if (v19.h.a(null) == true) goto L19;
        int r5 = 2131241520;
    L20:
        r16.setImageResource(r5);
    L19:
        r5 = 2131241521;
    L13:
        r3 = false;
    L21:
        int r17 = (int) (((double) ((Number) this.f.getValue()).intValue()) * 0.1d);
        LarusDialogFragmentLongImageShareBinding r6 = this.e;
        if (r6 == null) goto L36;
        CardView r7 = r6.c;
        if (r7 == null) goto L36;
        j r8 = this.d;
        if (r8 == null) goto L36;
        r7.removeAllViews();
        Bitmap r9 = r8.c.b;
        if (r9 == null) goto L36;
        FLogger.a.i("LongImageShareDialogFragment", "setupLongImage: shareBitmap is not null");
        ImageView r10 = new ImageView(r8.a);
        if (r8.c.u == false) goto L35;
        int r11 = ((Number) this.f.getValue()).intValue() - (r17 * 2);
        if (r9.getWidth() == r11) goto L35;
        r9 = Bitmap.createScaledBitmap(r9, r11, (int) (r9.getHeight() * (r11 / r9.getWidth())), true);
        Intrinsics.checkNotNull(r9);
    L35:
        r10.setImageBitmap(r9);
        r7.addView(r10, new FrameLayout.LayoutParams(-2, -2));
    L36:
        LarusDialogFragmentLongImageShareBinding r18 = this.e;
        if (r18 == null) goto L47;
        RecyclerView r19 = r18.d;
        if (r19 == null) goto L48;
        final j r12 = this.d;
        if (r12 == null) goto L49;
        List<jr9.a> r20 = com.larus.share.impl.util.e.b(com.larus.share.impl.util.e.d(com.larus.share.impl.util.e.a, r12.b, false, null, false, 7), Boolean.valueOf(r12.d.a));
        if ((true ^ ((ArrayList) r20).isEmpty()) == false) goto L45;
        SharePanelAdapter r21 = new SharePanelAdapter(r12.a, this, new LongImageShareDialogFragment$setupSharePanel$1$1$sharePanelAdapter$1(r12, this), r12.c, Boolean.valueOf(r12.d.a), false, 64);
        r21.setData(r20);
        r19.setAdapter(r21);
        r19.setLayoutManager(new LinearLayoutManager(r12.a, 0, false));
        r19.addItemDecoration(new SharePanelItemDecoration(r12.a, false));
        r19.setVisibility(0);
        return;
    L45:
        FLogger.a.i("LongImageShareDialogFragment", "setupSharePanel: shareItems is empty");
        r19.setVisibility(8);
        return;
    L49:
        return;
    L48:
        return;
    }

    public final void show(FragmentManager r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r3, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, this, r0) == false) goto L12;
    L7:
        j r4 = this.d;
        if (r4 == null) goto L14;
        com.larus.share.impl.e r5 = com.larus.share.impl.a.a;
        com.larus.bmhome.share.panel.e r6 = r4.d;
        com.larus.share.impl.a.r(r6.d, r6.e, r6.f);
        return;
    L14:
        return;
    L12:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L6:
        super.show(r2, r3);
        goto L7
    }

    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        ConstraintLayout r7 = r4.inflate(2131562074, r5, false);
        int r8 = 2131367000;
        ImageView r9 = (ImageView) ViewBindings.findChildViewById(r7, 2131367000);
        if (r9 == null) goto L25;
        r8 = 2131379195;
        CardView r0 = ViewBindings.findChildViewById(r7, 2131379195);
        if (r0 == null) goto L25;
        r8 = 2131386112;
        RecyclerView r1 = ViewBindings.findChildViewById(r7, 2131386112);
        if (r1 == null) goto L25;
        r8 = 2131386144;
        if (((TextView) ViewBindings.findChildViewById(r7, 2131386144)) == null) goto L25;
        r8 = 2131386146;
        if (((RelativeLayout) ViewBindings.findChildViewById(r7, 2131386146)) == null) goto L25;
        this.e = new LarusDialogFragmentLongImageShareBinding(r7, r9, r0, r1);
        Context r10 = getContext();
        if (r10 == null) goto L19;
        Dialog r11 = getDialog();
        if (r11 == null) goto L19;
        Window r12 = r11.getWindow();
        if (r12 == null) goto L19;
        r12.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(r10, R.color.transparent)));
    L19:
        LarusDialogFragmentLongImageShareBinding r13 = this.e;
        if (r13 != null) goto L26;
        return null;
    L26:
        return r13.a;
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r7.getResources().getResourceName(r8)));
    }
}
