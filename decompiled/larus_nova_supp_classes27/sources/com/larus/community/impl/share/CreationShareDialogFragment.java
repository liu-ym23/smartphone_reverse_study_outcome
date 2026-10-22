package com.larus.community.impl.share;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.keva.Keva;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.api.IShareService;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.bmhome.tipoff.TipOffDialogParams;
import com.larus.common_ui.widget.roundlayout.RoundLinearLayout;
import com.larus.community.impl.databinding.LarusCommunityPictureShareDialogLayoutBinding;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.home.impl.sdk.b1;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatService;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.m0;
import com.larus.utils.o0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.v1;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001;B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020 H\u0002J\u000e\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020\tJ\b\u0010'\u001a\u00020 H\u0002J\u0018\u0010\n\u001a\u00020 2\u0006\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020/H\u0002J\u0012\u00100\u001a\u00020 2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u00102\u001a\u00020 H\u0002J\b\u00103\u001a\u00020 H\u0016J\u0010\u00104\u001a\u00020 2\u0006\u00105\u001a\u000206H\u0016J\b\u00107\u001a\u00020 H\u0016J\b\u00108\u001a\u00020 H\u0002J\b\u00109\u001a\u00020 H\u0002J\b\u0010:\u001a\u00020 H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010(\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0016\u001a\u0004\b*\u0010+R\u000e\u00101\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/larus/community/impl/share/CreationShareDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/community/impl/databinding/LarusCommunityPictureShareDialogLayoutBinding;", "sharePanelView", "Lcom/larus/bmhome/share/panel/AbsSharePanelView;", "creationImageShareModel", "Lcom/larus/platform/model/creation/CreationImageShareModel;", "compositeBitmap", "Landroid/graphics/Bitmap;", "waitingJob", "Lkotlinx/coroutines/Job;", "pageChangeCallback", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "cache", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "getCache", "()Lcom/bytedance/keva/Keva;", "cache$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "getTheme", "", "initView", "bindShareModel", "shareModel", "buildSharePanelView", "frescoCloseableHolder", "Lcom/larus/community/impl/share/FrescoCloseableHolder;", "getFrescoCloseableHolder", "()Lcom/larus/community/impl/share/FrescoCloseableHolder;", "frescoCloseableHolder$delegate", "imageShareModel", "isPuzzle", "", "onCreate", "currentPosition", "buildSharePreviewContent", "onStart", "onCancel", "dialog", "Landroid/content/DialogInterface;", "onDestroyView", "releaseSharePreviewContent", "releaseBitmapResources", "onDestroy", "ImageShareCallback", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationShareDialogFragment extends BottomSheetDialogFragment {
    public static final /* synthetic */ int m = 0;
    public LarusCommunityPictureShareDialogLayoutBinding d;
    public com.larus.bmhome.share.panel.a e;
    public sq9.j f;
    public Bitmap g;
    public Job h;
    public CreationShareDialogFragment$buildSharePreviewContent$1$callback$1 i;
    public final Lazy j;
    public final Lazy k;
    public int l;

    public static final class a implements com.larus.bmhome.share.panel.d {
        public final String a;
        public final String b;
        public final WeakReference<CreationShareDialogFragment> c;

        public final void f() {
        }

        public final void onDismiss() {
            CreationShareDialogFragment r0 = this.c.get();
            if (r0 == null) goto L13;
            r0.dismissAllowingStateLoss();     // Catch: Exception -> L6
            return;
        L6:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r1 = DialogFragmentLancet.sLastShowStack;
            if (r1 == null) goto L14;
            com.bytedance.crash.d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L14:
            return;
        }

        public final void e(Function0<Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "callback");
        }

        public a(String r2, String r3, CreationShareDialogFragment r4) {
            Intrinsics.checkNotNullParameter(r4, "shareDialog");
            this.a = r2;
            this.b = r3;
            this.c = new WeakReference(r4);
        }

        public final boolean d(String r3, String r4, Boolean r5) {
            if (z2.a.getCreationShareSettings().b() == true) goto L5;
            return true;
        L5:
            if (Intrinsics.areEqual(r3, "image") == true) goto L7;
        L11:
            boolean r6 = false;
        L13:
            return !r6;
        L7:
            if (Intrinsics.areEqual(r4, "save_image") == false) goto L11;
            if (Intrinsics.areEqual(r5, Boolean.TRUE) == false) goto L11;
            r6 = true;
            goto L13
        }

        public final boolean b(Context r310, DialogFragment r40, View r41, jr9.a r42) {
            Intrinsics.checkNotNullParameter(r42, "shareItemConfig");
            CreationShareDialogFragment r3 = this.c.get();
            IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r0 == null) goto L55;
            r0.D0();
            b1 r1 = b1.a;
            r1.c("creation_gallery_share_save");
            if (r3 == null) goto L55;
            sq9.j r4 = r3.f;
            if (r4 == null) goto L55;
            String r5 = r4.c;
            if (r5 == null) goto L55;
            r1.d(r5);
        L55:
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L46
            if (Intrinsics.areEqual(r42.b(), "report") == false) goto L44;
            IAIChatService.Companion r6 = IAIChatService.a;     // Catch: Throwable -> L46
            if (o0.d(this.a) == true) goto L18;
            String r7 = String.valueOf(this.b);     // Catch: Throwable -> L46
            Intrinsics.checkNotNullParameter(r7, "entityId");     // Catch: Throwable -> L46
            TipOffDialogParams r8 = new TipOffDialogParams(2, r7, null, null, "", "", 0, null, null, null, null, null, null, null, null);     // Catch: Throwable -> L46
            r8.g = 0;     // Catch: Throwable -> L46
            TipOffDialogParams r9 = r8;
        L20:
            Fragment r10 = r6.g8(r9);     // Catch: Throwable -> L46
            if (r3 == null) goto L33;
            FragmentManager r11 = r3.getParentFragmentManager();     // Catch: Throwable -> L46
            if (r11 == null) goto L33;
            if ((r10 instanceof Fragment) == false) goto L27;
            Fragment r12 = r10;
        L28:
            LandscapeRestrictionOperation r13 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Throwable -> L46
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r12, null, r13);     // Catch: Throwable -> L46
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r11, r12, r13) == true) goto L33;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L52 Throwable -> L46
        L32:
            r10.show(r11, null);     // Catch: Throwable -> L46
            goto L33
        L27:
            r12 = null;
        L33:
            if (r3 != null) goto L53;
        L41:
            if (r3 == null) goto L58;
            return true;
        L58:
            return false;
        L53:
            r3.dismissAllowingStateLoss();     // Catch: Exception -> L36 Throwable -> L46
        L36:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L46
            Throwable r14 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L46
            if (r14 == null) goto L41;
            com.bytedance.crash.d.d(r14, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L46
            goto L41
        L18:
            String r15 = String.valueOf(this.a);     // Catch: Throwable -> L46
            Intrinsics.checkNotNullParameter(r15, "entityId");     // Catch: Throwable -> L46
            r9 = new TipOffDialogParams(8, r15, null, null, "", "", 0, null, null, null, null, null, null, null, null);     // Catch: Throwable -> L46
            r9.g = 0;     // Catch: Throwable -> L46
            goto L20
        L44:
            Object r16 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L46
        L48:
            Throwable r17 = Result.exceptionOrNull-impl(r16);
            if (r17 == null) goto L51;
            FLogger.a.e("ShareDialogFragment", "save image error state ", r17);
        L51:
            return false;
        L46:
            th = move-exception;
            Result.Companion r18 = Result.Companion;
            r16 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L48
        }
    }

    public static final class b extends BottomSheetBehavior.BottomSheetCallback {
        public boolean a;
        public VelocityTracker b;
        public long c;
        public final /* synthetic */ CreationShareDialogFragment d;

        public b(CreationShareDialogFragment r1) {
            this.d = r1;
        }

        public final void onSlide(View r7, float r8) {
            Intrinsics.checkNotNullParameter(r7, "bottomSheet");
            if (this.a == false) goto L10;
            VelocityTracker r9 = this.b;
            if (r9 == null) goto L11;
            long r0 = System.currentTimeMillis();
            if ((r0 - this.c) <= 16) goto L12;
            r9.computeCurrentVelocity(1000);
            this.c = r0;
            return;
        L12:
            return;
        L11:
            return;
        }

        public final void onStateChanged(View r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "bottomSheet");
            if (r4 != 1) goto L5;
            this.a = true;
            this.b = VelocityTracker.obtain();
            this.c = System.currentTimeMillis();
            return;
        L5:
            if (r4 != 2) goto L7;
            this.a = false;
            VelocityTracker r5 = this.b;
            if (r5 == null) goto L25;
            r5.recycle();
        L25:
            this.b = null;
            return;
        L7:
            if (r4 != 3) goto L9;
            this.a = false;
            VelocityTracker r6 = this.b;
            if (r6 == null) goto L21;
            r6.recycle();
        L21:
            this.b = null;
            return;
        L9:
            if (r4 == 5) goto L28;
            return;
        L28:
            this.d.dismissAllowingStateLoss();     // Catch: Exception -> L14
            return;
        L14:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r7 = DialogFragmentLancet.sLastShowStack;
            if (r7 == null) goto L30;
            com.bytedance.crash.d.d(r7, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public final int getTheme() {
        return 2131954335;
    }

    public final void T90() {
        Job r0 = this.h;
        this.h = null;
        if (r0 != null) goto L6;
        this.g = null;
        return;
    L6:
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
        if (r0.isCompleted() == true) goto L9;
        r0.invokeOnCompletion(new c(this));
    L10:
        this.g = null;
        return;
    L9:
        ((m) this.k.getValue()).b();
        goto L10
    }

    public final void onDestroyView() {
        LarusCommunityPictureShareDialogLayoutBinding r0 = this.d;
        if (r0 == null) goto L5;
        ViewPager2 r1 = r0.e;
    L6:
        CreationShareDialogFragment$buildSharePreviewContent$1$callback$1 r2 = this.i;
        if (r2 == null) goto L10;
        if (r1 == null) goto L10;
        r1.unregisterOnPageChangeCallback(r2);
    L10:
        this.i = null;
        if (r1 == null) goto L13;
        RecyclerView.Adapter r3 = r1.getAdapter();
    L15:
        if ((r3 instanceof CreationShareImagePagerAdapter) == false) goto L17;
        CreationShareImagePagerAdapter r4 = (CreationShareImagePagerAdapter) r3;
    L18:
        if (r4 == null) goto L20;
        r4.y2();
    L20:
        if (r1 == null) goto L22;
        r1.setAdapter(null);
    L22:
        LarusCommunityPictureShareDialogLayoutBinding r5 = this.d;
        if (r5 == null) goto L27;
        CreationShareSegmentedControlView r6 = r5.c;
        if (r6 == null) goto L27;
        r6.setOnSelectionChangedListener(null);
    L27:
        com.larus.bmhome.share.panel.a r7 = this.e;
        if (r7 == null) goto L30;
        r7.b();
    L30:
        LarusCommunityPictureShareDialogLayoutBinding r8 = this.d;
        if (r8 == null) goto L35;
        FrameLayout r9 = r8.d;
        if (r9 == null) goto L35;
        r9.removeAllViews();
    L35:
        this.e = null;
        this.d = null;
        T90();
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        return;
    L17:
        r4 = null;
        goto L18
    L13:
        r3 = null;
        goto L15
    L5:
        r1 = null;
        goto L6
    }

    public CreationShareDialogFragment() {
        this.j = LazyKt.lazy(new com.larus.community.impl.share.a());
        this.k = LazyKt.lazy(new com.larus.community.impl.share.b());
    }

    public final void onDestroy() {
        T90();
        super/*androidx.fragment.app.Fragment*/.onDestroy();
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L9;
        FrameLayout r1 = (FrameLayout) r0.findViewById(2131368870);
        if (r1 == null) goto L10;
        int r2 = m0.a;
        int r3 = (int) (((double) m0.a(getContext())) * 0.8d);
        r1.getLayoutParams().height = r3;
        CreationViewPagerBottomSheetBehavior r4 = new CreationViewPagerBottomSheetBehavior();
        CoordinatorLayout.LayoutParams r5 = r1.getLayoutParams();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        r5.setBehavior(r4);
        r4.setState(3);
        r4.setPeekHeight(r3);
        r4.setHideable(true);
        r4.setBottomSheetCallback(new b(this));
        return;
    L10:
        return;
    }

    public static void S90(CreationShareDialogFragment r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void onCancel(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        super/*androidx.fragment.app.DialogFragment*/.onCancel(r2);
        S90(this);
    }

    public final void onCreate(Bundle r3) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r3);
        if (r3 == null) goto L6;
        FLogger.a.i("ShareDialogFragment", "UI mode changed during recreation, dismissing dialog");
        S90(this);
        return;
    }

    /* JADX WARN: Type inference failed for: r0v20, types: [androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback, com.larus.community.impl.share.CreationShareDialogFragment$buildSharePreviewContent$1$callback$1] */
    public final void onViewCreated(View r64, Bundle r65) {
        Intrinsics.checkNotNullParameter(r64, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r64, r65);
        LarusCommunityPictureShareDialogLayoutBinding r0 = this.d;
        if (r0 == null) goto L162;
        e1.d(r0.b, new d(this));
        sq9.j r1 = this.f;
        String r2 = null;
        if (r1 != null) goto L7;
    L45:
        FLogger r3 = FLogger.a;
        r3.i("ShareDialogFragment", "buildSharePreviewContent start");
        final sq9.j r6 = this.f;
        if (r6 == null) goto L158;
        LarusCommunityPictureShareDialogLayoutBinding r7 = this.d;
        if (r7 == null) goto L52;
        ViewPager2 r8 = r7.e;
        if (r8 == null) goto L52;
        r8.setAdapter(new CreationShareImagePagerAdapter(r6, LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner())));
    L52:
        String r9 = r6.e;
        int r10 = 1;
        if (r9 != null) goto L55;
    L58:
        boolean r11 = true;
    L59:
        if (r11 == true) goto L148;
        z2 r12 = z2.a;
        v1 r13 = r12.getCreationShareSettings().a();
        if (r13 != null) goto L63;
    L65:
        boolean r14 = false;
    L66:
        if (r14 == false) goto L148;
        v1 r15 = r12.getCreationShareSettings().a();
        if (r15 != null) goto L71;
    L73:
        boolean r16 = false;
    L74:
        if (r16 == true) goto L76;
        v1 r4 = r12.getCreationShareSettings().a();
        if (r4 != null) goto L89;
    L91:
        boolean r5 = false;
    L92:
        if (r5 == false) goto L94;
    L93:
        int r17 = 1;
    L95:
        if (r17 != 1) goto L97;
        boolean r18 = true;
    L98:
        r3.i("ShareDialogFragment", "compositeBitmap start");
        Job r20 = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new CreationShareDialogFragment$compositeBitmap$job$1(this, r6, r12.getImageEditUploadConfig().b, null), 3, null);
        this.h = r20;
        if (r18 == false) goto L103;
        com.larus.bmhome.share.panel.a r110 = this.e;
        if (r110 == null) goto L103;
        r110.d(new com.larus.bmhome.share.panel.b(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, r20, false, false, null, false, null, null, 66584575), r6.g);
    L103:
        r3.i("ShareDialogFragment", "compositeBitmap end");
        int r21 = i.a;
        sq9.i r22 = r6.k;
        if (r22 == null) goto L106;
        String r23 = r22.a;
    L107:
        if (r22 == null) goto L109;
        String r111 = r22.b;
    L110:
        if (r22 == null) goto L112;
        r2 = r22.c;
    L112:
        JSONObject r112 = new JSONObject();
        Intrinsics.checkNotNullParameter(r112, "params");
        if (r18 == true) goto L160;
        r10 = 0;
    L160:
        r112.putOpt("is_puzzle", Integer.valueOf(r10));     // Catch: JSONException -> L126
        if (r111 == null) goto L120;
        r112.put("message_id", r111);     // Catch: JSONException -> L126
    L120:
        r112.put("sub_type", "image2image");     // Catch: JSONException -> L126
        if (r23 == null) goto L123;
        r112.put(DoraObricDeviceHomeViewModel.PARAM_ENTER_FROM, r23);     // Catch: JSONException -> L126
    L123:
        if (r2 == null) goto L128;
        r112.put("creator_id", r2);     // Catch: JSONException -> L126
    L128:
        TrackParams r24 = new TrackParams().merge(r112);
        by7.a r25 = new by7.a("ai_creation_view_menu_show");
        r25.a.merge(r24);
        r25.b();
        this.l = r17;
        LarusCommunityPictureShareDialogLayoutBinding r26 = this.d;
        if (r26 == null) goto L133;
        ViewPager2 r27 = r26.e;
        if (r27 == null) goto L133;
        r27.setCurrentItem(r17, false);
    L133:
        LarusCommunityPictureShareDialogLayoutBinding r28 = this.d;
        if (r28 == null) goto L138;
        CreationShareSegmentedControlView r30 = r28.c;
        if (r30 == null) goto L138;
        r30.setSelectedPosition(r17);
    L138:
        ?? r31 = new CreationShareDialogFragment$buildSharePreviewContent$1$callback$1(this, r6);
        this.i = r31;
        LarusCommunityPictureShareDialogLayoutBinding r32 = this.d;
        if (r32 == null) goto L143;
        ViewPager2 r33 = r32.e;
        if (r33 == null) goto L143;
        r33.registerOnPageChangeCallback(r31);
    L143:
        LarusCommunityPictureShareDialogLayoutBinding r34 = this.d;
        if (r34 == null) goto L158;
        CreationShareSegmentedControlView r35 = r34.c;
        if (r35 == null) goto L158;
        r35.setOnSelectionChangedListener(new f(this, r6));
    L126:
        e = move-exception;
        FLogger.a.e("CreationShareEventHelper", "error in mobImageEditFunctionShow " + e.getLocalizedMessage());
        goto L128
    L109:
        r111 = null;
        goto L110
    L106:
        r23 = null;
        goto L107
    L97:
        r18 = false;
    L94:
        r17 = 0;
        goto L95
    L89:
        if (r4.a() != 1) goto L91;
        r5 = true;
        goto L92
    L76:
        if (((Keva) this.j.getValue()).getInt("share_image_last_choice", -1) != (-1)) goto L85;
        v1 r36 = r12.getCreationShareSettings().a();
        if (r36 != null) goto L80;
    L82:
        boolean r37 = false;
    L83:
        if (r37 == false) goto L94;
    L80:
        if (r36.a() != 1) goto L82;
        r37 = true;
        goto L83
    L85:
        r17 = ((Keva) this.j.getValue()).getInt("share_image_last_choice", -1);
        goto L95
    L71:
        if (r15.d() != true) goto L73;
        r16 = true;
        goto L74
    L63:
        if (r13.c() != true) goto L65;
        r14 = true;
    L148:
        LarusCommunityPictureShareDialogLayoutBinding r38 = this.d;
        if (r38 == null) goto L153;
        ViewPager2 r40 = r38.e;
        if (r40 == null) goto L153;
        r40.setCurrentItem(0);
    L153:
        LarusCommunityPictureShareDialogLayoutBinding r41 = this.d;
        if (r41 == null) goto L158;
        CreationShareSegmentedControlView r42 = r41.c;
        if (r42 == null) goto L158;
        e1.o(r42);
        goto L158
    L55:
        if (r9.length() == 0) goto L58;
        r11 = false;
    L158:
        FLogger.a.i("ShareDialogFragment", "buildSharePreviewContent end");
        return;
    L7:
        if (r1.h != ShareScene.VIDEO_VIEWER) goto L9;
        com.larus.bmhome.share.panel.b r43 = new com.larus.bmhome.share.panel.b(null, null, null, null, r1.c, r1.n, r1.p, null, null, null, null, null, null, null, null, null, true, false, null, null, false, false, r1.o, false, null, null, 62848911);
    L10:
        com.larus.bmhome.share.panel.b r44 = r43;
        ShareServiceDelegate r45 = ShareServiceDelegate.b;
        Context r46 = requireContext();
        ShareScene r47 = r1.h;
        com.larus.bmhome.share.panel.h r113 = r1.g;
        if (r113 == null) goto L25;
        sq9.i r48 = r1.k;
        if (r48 == null) goto L15;
        String r50 = r48.a;
    L17:
        if (Intrinsics.areEqual(r50, "download") == false) goto L19;
        String r114 = "click_download";
    L20:
        sq9.j r51 = this.f;
        if (r51 == null) goto L23;
        String r52 = r51.d;
    L24:
        com.larus.bmhome.share.panel.h r115 = com.larus.bmhome.share.panel.h.a(r113, null, null, r114, null, Boolean.valueOf(o0.d(r52)), null, null, -1, -2057);
    L27:
        if (r1.f == null) goto L32;
        final WeakReference r53 = new WeakReference(this);
        com.larus.bmhome.share.panel.d r116 = r1.f;
        if (r116 == null) goto L31;
        r116.e(new e(r53));
    L31:
        com.larus.bmhome.share.panel.d r117 = r1.f;
    L37:
        com.larus.bmhome.share.panel.a r54 = IShareService.a.a(r45, r46, r47, r44, true, r115, r117, null, 640);
        this.e = r54;
        if (r54 == null) goto L40;
        r54.setVisibility(0);
    L40:
        LarusCommunityPictureShareDialogLayoutBinding r55 = this.d;
        if (r55 == null) goto L45;
        FrameLayout r56 = r55.d;
        if (r56 == null) goto L45;
        r56.addView(this.e, new FrameLayout.LayoutParams(-1, -2));
        goto L45
    L32:
        String r118 = r1.a;
        com.larus.bmhome.share.panel.h r57 = r1.g;
        if (r57 == null) goto L35;
        String r58 = r57.h;
    L36:
        r117 = new a(r118, r58, this);
        goto L37
    L35:
        r58 = null;
        goto L36
    L23:
        r52 = null;
        goto L24
    L19:
        r114 = null;
        goto L20
    L15:
        r50 = null;
        goto L17
    L25:
        r115 = null;
        goto L27
    L9:
        r43 = new com.larus.bmhome.share.panel.b(r1.c, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r1.l, true, true, r1.q, null, false, false, r1.o, false, null, null, 62423038);
        goto L10
    }

    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        View r10 = r7.inflate(2131561976, r8, false);
        int r11 = 2131363762;
        AppCompatImageView r2 = ViewBindings.findChildViewById(r10, 2131363762);
        if (r2 == null) goto L15;
        r11 = 2131373876;
        if (ViewBindings.findChildViewById(r10, 2131373876) == null) goto L15;
        r11 = 2131385762;
        CreationShareSegmentedControlView r3 = (CreationShareSegmentedControlView) ViewBindings.findChildViewById(r10, 2131385762);
        if (r3 == null) goto L15;
        r11 = 2131386114;
        FrameLayout r4 = (FrameLayout) ViewBindings.findChildViewById(r10, 2131386114);
        if (r4 == null) goto L15;
        r11 = 2131392567;
        ViewPager2 r5 = ViewBindings.findChildViewById(r10, 2131392567);
        if (r5 == null) goto L15;
        RoundLinearLayout r12 = (RoundLinearLayout) r10;
        this.d = new LarusCommunityPictureShareDialogLayoutBinding(r12, r2, r3, r4, r5);
        return r12;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }
}
