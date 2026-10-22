package com.larus.doc.sdk.impl.v2.plugins.snapshot;

import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.google.gson.JsonObject;
import com.larus.dora.api.model.FlowDoraConnectReason;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.ss.android.lark.chameleon.util.SafeJSExecutor;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n39.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 :2\u00020\u0001:\u000389:B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bH\u0002J\u0010\u0010\u001e\u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001dJ\u000e\u0010 \u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u001bJ\u001a\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020\u000bH\u0016J\b\u0010&\u001a\u00020\u000fH\u0016J\u0012\u0010'\u001a\u00020\u000f2\b\u0010(\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010)\u001a\u00020\u000fH\u0002J\b\u0010*\u001a\u00020\u000fH\u0016J\u001c\u0010+\u001a\u00020\u000f2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0012\u0010.\u001a\u00020\u000f2\b\u0010/\u001a\u0004\u0018\u00010-H\u0016J\b\u00100\u001a\u00020\u000fH\u0016J\b\u00101\u001a\u00020\u000fH\u0016J\u001a\u00102\u001a\u00020\u000f2\u0006\u00103\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010\u0012H\u0003J\b\u00104\u001a\u00020\u000fH\u0002J\u0010\u00105\u001a\u00020\u000f2\u0006\u00106\u001a\u000207H\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/snapshot/DocShotPresenter;", "Lcom/larus/doc/sdk/impl/v2/plugins/snapshot/IDocShotPresenter;", "mActivity", "Landroidx/fragment/app/FragmentActivity;", "mInputViewHeight", "", "<init>", "(Landroidx/fragment/app/FragmentActivity;Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "mIsActive", "Landroidx/lifecycle/MutableLiveData;", "", "mH5QuitShotTimeoutRunnable", "Ljava/lang/Runnable;", "setIsActive", "", "isActive", "mWebView", "Landroid/webkit/WebView;", "mLastScrollY", "isBackPressed", "()Z", "setBackPressed", "(Z)V", "mJsReadyTime", "", "mSnapshotResultListener", "Lcom/larus/doc/sdk/api/IDocSnapshotResultListener;", "mOnBackPressListener", "Lcom/larus/doc/sdk/impl/v2/plugins/snapshot/DocShotPresenter$OnBackPressListener;", "setOnBackPressListener", "listener", "setSnapShotResultListener", "docShotReady", FlowDoraConnectReason.SUCCESS, "docShotModel", "Lcom/larus/doc/sdk/impl/v2/plugins/snapshot/DocShotModel;", "onBackPressed", "docShotH5Exit", "startDocShot", "webView", "scrollToLastPosition", "docShotNotSupport", "docShotFail", "errorInfo", "", "docShotSuccess", "path", "shareDocShot", "saveDocShot", "notifyJScreenShot", "state", "onShareDoc", "onSaveDocBitmap", "callback", "Lcom/larus/doc/sdk/impl/v2/plugins/snapshot/DocShotPresenter$ISaveDocCallback;", "ISaveDocCallback", "OnBackPressListener", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocShotPresenter implements IDocShotPresenter {
    public static final Companion Companion = null;
    public static final int SCREEN_SHOT_END = 1;
    public static final int SCREEN_SHOT_START = 0;
    private static final String TAG = "DocShotPresenter";
    private boolean isBackPressed;
    private final FragmentActivity mActivity;
    private Runnable mH5QuitShotTimeoutRunnable;
    private final Integer mInputViewHeight;
    private final MutableLiveData<Boolean> mIsActive;
    private long mJsReadyTime;
    private int mLastScrollY;
    private OnBackPressListener mOnBackPressListener;
    private h mSnapshotResultListener;
    private WebView mWebView;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/snapshot/DocShotPresenter$Companion;", "", "<init>", "()V", "TAG", "", "SCREEN_SHOT_START", "", "SCREEN_SHOT_END", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/snapshot/DocShotPresenter$ISaveDocCallback;", "", "onSaveDocFinished", "", FlowDoraConnectReason.SUCCESS, "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface ISaveDocCallback {
        void onSaveDocFinished(boolean r1);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/snapshot/DocShotPresenter$OnBackPressListener;", "", "onBack", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface OnBackPressListener {
        void onBack();
    }

    static {
        Companion = new Companion(null);
    }

    @Override // com.larus.doc.sdk.impl.v2.plugins.snapshot.IDocShotPresenter
    public void docShotNotSupport() {
        setIsActive(false);
        scrollToLastPosition();
        notifyJScreenShot(1, this.mWebView);
    }

    @Override // com.larus.doc.sdk.impl.v2.plugins.snapshot.IDocShotPresenter
    public boolean onBackPressed() {
        setIsActive(false);
        FLogger.a.i(TAG, "onBackPressed()...");
        this.isBackPressed = true;
        notifyJScreenShot(1, this.mWebView);
        OnBackPressListener r1 = this.mOnBackPressListener;
        if (r1 == null) goto L5;
        r1.onBack();
    L5:
        return false;
    }

    private final void onShareDoc() {
        FLogger.a.d(TAG, "onShareDoc()...");
    }

    private final void scrollToLastPosition() {
        WebView r0 = this.mWebView;
        if (r0 == null) goto L6;
        r0.scrollTo(0, this.mLastScrollY);
        return;
    }

    @Override // com.larus.doc.sdk.impl.v2.plugins.snapshot.IDocShotPresenter
    public void docShotH5Exit() {
        Runnable r0 = this.mH5QuitShotTimeoutRunnable;
        if (r0 == null) goto L5;
        t0.a.removeCallbacks(r0);
    L5:
        this.mH5QuitShotTimeoutRunnable = null;
    }

    @Override // com.larus.doc.sdk.impl.v2.plugins.snapshot.IDocShotPresenter
    public void saveDocShot() {
        onSaveDocBitmap(new AnonymousClass1());
    }

    public final boolean isBackPressed() {
        return this.isBackPressed;
    }

    @Override // com.larus.doc.sdk.impl.v2.plugins.snapshot.IDocShotPresenter
    public void shareDocShot() {
        onShareDoc();
    }

    private final void onSaveDocBitmap(ISaveDocCallback r3) {
        FLogger.a.i(TAG, "onSaveDocBitmap()....");
        new ArrayList().add("android.permission.WRITE_EXTERNAL_STORAGE");
    }

    private final void setIsActive(boolean r2) {
        this.mIsActive.setValue(Boolean.valueOf(r2));
    }

    @Override // com.larus.doc.sdk.impl.v2.plugins.snapshot.IDocShotPresenter
    public void docShotSuccess(String r4) {
        scrollToLastPosition();
        FLogger.a.i(TAG, "docShotSuccess()..");
        notifyJScreenShot(1, this.mWebView);
        if (r4 == null) goto L8;
        h r0 = this.mSnapshotResultListener;
        if (r0 == null) goto L9;
        r0.onSnapshotSuccess(r4);
        return;
    L9:
        return;
    }

    public final void setBackPressed(boolean r1) {
        this.isBackPressed = r1;
    }

    public final void setOnBackPressListener(OnBackPressListener r1) {
        this.mOnBackPressListener = r1;
    }

    public final void setSnapShotResultListener(h r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.mSnapshotResultListener = r2;
    }

    @Override // com.larus.doc.sdk.impl.v2.plugins.snapshot.IDocShotPresenter
    public void startDocShot(WebView r3) {
        setIsActive(true);
        this.isBackPressed = false;
        if (r3 == null) goto L6;
        this.mLastScrollY = r3.getScrollY();
        notifyJScreenShot(0, r3);
        r3.scrollTo(0, 0);
        return;
    }

    public DocShotPresenter(FragmentActivity r2, Integer r3) {
        Intrinsics.checkNotNullParameter(r2, "mActivity");
        this.mActivity = r2;
        this.mInputViewHeight = r3;
        this.mIsActive = new MutableLiveData();
    }

    private final void notifyJScreenShot(int r3, WebView r4) {
        if (r4 == null) goto L5;
        JsonObject r0 = new JsonObject();
        r0.addProperty("state", Integer.valueOf(r3));
        SafeJSExecutor.execJS(r4, "javascript:window.native.screenshot", r0, null);
        this.mWebView = r4;
        return;
    }

    @Override // com.larus.doc.sdk.impl.v2.plugins.snapshot.IDocShotPresenter
    public void docShotFail(String r3, DocShotModel r4) {
        FLogger.a.i(TAG, "docShotFail, errorInfo=" + r3);
        setIsActive(false);
        scrollToLastPosition();
        h r5 = this.mSnapshotResultListener;
        if (r5 == null) goto L7;
        if (r3 != null) goto L6;
        r3 = "Unknown fail reason";
    L6:
        r5.onSnapshotFail(r3);
    L7:
        notifyJScreenShot(1, this.mWebView);
    }

    @Override // com.larus.doc.sdk.impl.v2.plugins.snapshot.IDocShotPresenter
    public void docShotReady(boolean r4, DocShotModel r5) {
        this.mJsReadyTime = System.currentTimeMillis();
        FLogger r0 = FLogger.a;
        r0.i(TAG, "docShotReady()...success = " + r4 + ", backPressed = " + this.isBackPressed);
        if (this.isBackPressed == false) goto L6;
        r0.i(TAG, "docShotReady()... has back pressed");
        return;
    L6:
        docShotFail("client-side long screenshot is no longer supported", r5);
    }
}
