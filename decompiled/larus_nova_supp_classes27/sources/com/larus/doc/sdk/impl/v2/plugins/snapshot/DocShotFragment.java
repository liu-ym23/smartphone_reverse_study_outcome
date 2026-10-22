package com.larus.doc.sdk.impl.v2.plugins.snapshot;

import android.R;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.larus.utils.logger.FLogger;
import com.larus.utils.u;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n39.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 22\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u001a\u001a\u00020\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018J\u0018\u0010\u001c\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001e\u001a\u00020\u001fJ\u0012\u0010 \u001a\u00020\u00192\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J&\u0010#\u001a\u0004\u0018\u00010\u00052\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010(\u001a\u00020\u0019H\u0016J\b\u0010)\u001a\u00020\u0019H\u0016J\b\u0010*\u001a\u00020\u0019H\u0002J\u0010\u0010+\u001a\u00020\u00192\b\u0010,\u001a\u0004\u0018\u00010-J\u0006\u0010.\u001a\u00020\u0019J\u0010\u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u000201H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/snapshot/DocShotFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "mSnapShotView", "Landroid/view/View;", "mActivity", "Landroidx/fragment/app/FragmentActivity;", "snapshotPresenter", "Lcom/larus/doc/sdk/impl/v2/plugins/snapshot/DocShotPresenter;", "mWebView", "Landroid/webkit/WebView;", "mDocUrl", "", "mListener", "Lcom/larus/doc/sdk/api/IDocSnapshotResultListener;", "mInputViewHeight", "", "Ljava/lang/Integer;", "mBgDrawable", "Landroid/graphics/drawable/Drawable;", "mJustShowLoading", "", "dismissListener", "Lkotlin/Function0;", "", "setDismissListener", "listener", "setArgs", "activity", "params", "Lcom/larus/doc/sdk/impl/v2/plugins/snapshot/DocShotParams;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "onResume", "onRequestSnapshot", "docShotReady", "data", "Lcom/larus/doc/sdk/impl/v2/plugins/snapshot/DocShotModel;", "docShotH5Exit", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocShotFragment extends DialogFragment {
    public static final Companion Companion = null;
    private static final String TAG = "DocShotFragment";
    private Function0<Unit> dismissListener;
    private FragmentActivity mActivity;
    private Drawable mBgDrawable;
    private String mDocUrl;
    private Integer mInputViewHeight;
    private boolean mJustShowLoading;
    private h mListener;
    private View mSnapShotView;
    private WebView mWebView;
    private DocShotPresenter snapshotPresenter;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/snapshot/DocShotFragment$Companion;", "", "<init>", "()V", "TAG", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public void onDismiss(DialogInterface r1) {
        com_larus_doc_sdk_impl_v2_plugins_snapshot_DocShotFragment_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_onDismiss(this, r1);
    }

    public void onStart() {
        com_larus_doc_sdk_impl_v2_plugins_snapshot_DocShotFragment_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_onStart(this);
    }

    private final void onRequestSnapshot() {
        FLogger r0 = FLogger.a;
        r0.i(TAG, "onRequestSnapshot()... ");
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L7;
        Lifecycle r2 = r1.getLifecycle();
        if (r2 == null) goto L7;
        Lifecycle.State r3 = r2.getCurrentState();
    L9:
        if (r3 == Lifecycle.State.RESUMED) goto L12;
        r0.w(TAG, "onRequestSnapshot, activity is not RESUMED");
        return;
    L12:
        FragmentActivity r4 = getActivity();
        if (r4 == null) goto L21;
        DocShotPresenter r5 = new DocShotPresenter(r4, this.mInputViewHeight);
        this.snapshotPresenter = r5;
        r5.setOnBackPressListener(new DocShotFragment$onRequestSnapshot$1$1(this));
        DocShotPresenter r6 = this.snapshotPresenter;
        if (r6 == null) goto L17;
        r6.setSnapShotResultListener(new DocShotFragment$onRequestSnapshot$1$2(this));
    L17:
        DocShotPresenter r7 = this.snapshotPresenter;
        if (r7 == null) goto L22;
        r7.startDocShot(this.mWebView);
        return;
    L22:
        return;
    L21:
        return;
    L7:
        r3 = null;
        goto L9
    }

    public final void docShotH5Exit() {
        FLogger.a.i(TAG, "onScreenShotExit");
        DocShotPresenter r0 = this.snapshotPresenter;
        if (r0 == null) goto L6;
        r0.docShotH5Exit();
        return;
    }

    public void com_larus_doc_sdk_impl_v2_plugins_snapshot_DocShotFragment__onStart$___twin___() {
        super.onStart();
        Dialog r0 = getDialog();
        WindowManager.LayoutParams r1 = null;
        if (r0 == null) goto L5;
        Window r2 = r0.getWindow();
    L6:
        if (r2 == null) goto L9;
        r1 = r2.getAttributes();
    L9:
        if (r1 == null) goto L11;
        r1.width = -1;
    L11:
        if (r1 == null) goto L13;
        r1.height = -1;
    L13:
        if (r2 == null) goto L15;
        r2.setAttributes(r1);
    L15:
        if (r2 == null) goto L17;
        r2.addFlags(512);
    L17:
        if (r2 == null) goto L20;
        r2.setBackgroundDrawableResource(R.color.transparent);
        return;
    L20:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        View r0 = this.mSnapShotView;
        if (r0 == null) goto L11;
        View r1 = r0.findViewById(2131369351);
        if (r1 == null) goto L12;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if (r2 == null) goto L10;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
        r3.bottomMargin = u.b(getActivity());
        r1.setLayoutParams(r3);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L12:
        return;
    }

    public DocShotFragment() {
    }

    public static final /* synthetic */ h access$getMListener$p(DocShotFragment r0) {
        return r0.mListener;
    }

    public static void com_larus_doc_sdk_impl_v2_plugins_snapshot_DocShotFragment_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_onStart(DocShotFragment r1) {
        if ((r1 instanceof DialogFragment) == false) goto L5;
        PopupOrDialogVisibilityTracker.bindDialogFragment(r1);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(r1);
    L5:
        r1.com_larus_doc_sdk_impl_v2_plugins_snapshot_DocShotFragment__onStart$___twin___();
    }

    public void com_larus_doc_sdk_impl_v2_plugins_snapshot_DocShotFragment__onDismiss$___twin___(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        DocShotPresenter r0 = this.snapshotPresenter;
        if (r0 == null) goto L5;
        r0.onBackPressed();
    L5:
        super.onDismiss(r2);
        Function0<Unit> r3 = this.dismissListener;
        if (r3 == null) goto L9;
        r3.invoke();
        return;
    }

    public final void docShotReady(DocShotModel r3) {
        DocShotPresenter r0 = this.snapshotPresenter;
        if (r0 == null) goto L9;
        if (r3 == null) goto L6;
        boolean r1 = r3.success;
    L7:
        r0.docShotReady(r1, r3);
        return;
    L6:
        r1 = false;
        goto L7
    }

    public void onCreate(Bundle r3) {
        setStyle(1, 2131953744);
        super.onCreate(r3);
    }

    public final void setDismissListener(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.dismissListener = r2;
    }

    public static final /* synthetic */ void access$setSnapshotPresenter$p(DocShotFragment r0, DocShotPresenter r1) {
        r0.snapshotPresenter = r1;
    }

    public static void com_larus_doc_sdk_impl_v2_plugins_snapshot_DocShotFragment_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_onDismiss(DocShotFragment r1, DialogInterface r2) {
        r1.com_larus_doc_sdk_impl_v2_plugins_snapshot_DocShotFragment__onDismiss$___twin___(r2);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(r1.getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(r1);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(r1);
        return;
    L5:
        th = move-exception;
        if ((r1 instanceof DialogFragment) == false) goto L9;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(r1.getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(r1);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(r1);
    L9:
        throw th;
    }

    public final void setArgs(FragmentActivity r2, DocShotParams r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        this.mActivity = r2;
        this.mWebView = r3.getWebView();
        this.mDocUrl = r3.getUrl();
        this.mInputViewHeight = r3.getInputViewHeight();
        this.mListener = r3.getListener();
        this.mBgDrawable = r3.getBgDrawable();
        this.mJustShowLoading = r3.getJustShowLoading();
    }

    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131562127, r3, false);
        this.mSnapShotView = r5;
        if (r5 == null) goto L7;
        View r6 = r5.findViewById(2131369351);
        if (r6 == null) goto L7;
        r6.setBackground(this.mBgDrawable);
    L7:
        Dialog r7 = getDialog();
        if (r7 == null) goto L13;
        Window r8 = r7.getWindow();
        if (r8 == null) goto L13;
        r8.requestFeature(1);
    L13:
        if (this.mJustShowLoading == true) goto L16;
        onRequestSnapshot();
    L16:
        return this.mSnapShotView;
    }
}
