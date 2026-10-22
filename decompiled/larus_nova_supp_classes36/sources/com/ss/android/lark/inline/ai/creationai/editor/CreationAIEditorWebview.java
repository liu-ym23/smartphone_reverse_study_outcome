package com.ss.android.lark.inline.ai.creationai.editor;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.webkit.ConsoleMessage;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.framework.utils.x;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.inline.ai.creationai.c0;
import com.ss.android.lark.inline.ai.ui.f0;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 X2\u00020\u00012\u00020\u0002:\u0002XYB)\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\rB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0010J\u0006\u0010)\u001a\u00020*J*\u00101\u001a\u00020*2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0012J\u0010\u00105\u001a\u00020*2\b\u00106\u001a\u0004\u0018\u000107J\u0006\u00108\u001a\u00020*J\u0010\u00109\u001a\u00020*2\b\u0010:\u001a\u0004\u0018\u00010;J\u0006\u0010<\u001a\u00020*J\u001c\u0010=\u001a\u0004\u0018\u00010>2\b\u0010\u0007\u001a\u0004\u0018\u00010?2\u0006\u0010@\u001a\u00020$H\u0016J\u0012\u0010=\u001a\u0004\u0018\u00010>2\u0006\u0010\u0007\u001a\u00020?H\u0016J\u001c\u0010A\u001a\u0004\u0018\u00010>2\b\u0010\u0007\u001a\u0004\u0018\u00010?2\u0006\u0010@\u001a\u00020$H\u0002J\b\u0010B\u001a\u00020*H\u0014J\b\u0010C\u001a\u00020*H\u0014J\b\u0010D\u001a\u00020*H\u0016J\b\u0010E\u001a\u00020*H\u0016J\b\u0010F\u001a\u00020*H\u0016J\u0010\u0010G\u001a\u00020*2\u0006\u0010H\u001a\u00020IH\u0002J\u0010\u0010J\u001a\u00020*2\u0006\u0010H\u001a\u00020IH\u0002J\u0012\u0010O\u001a\u00020\u001b2\b\u0010P\u001a\u0004\u0018\u00010QH\u0016J\u0018\u0010R\u001a\u00020\u001b2\u0006\u0010S\u001a\u00020$2\u0006\u0010@\u001a\u00020$H\u0016J\u0010\u0010T\u001a\u00020*2\u0006\u0010@\u001a\u00020$H\u0016J\b\u0010U\u001a\u00020$H\u0016J\u0012\u0010V\u001a\u00020*2\b\u0010W\u001a\u0004\u0018\u00010&H\u0016R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001cR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u000e\u0010K\u001a\u00020LX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020NX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/editor/CreationAIEditorWebview;", "Lcom/ss/android/lark/inline/ai/creationai/editor/NSCLarkWebViewV1;", "Lcom/ss/android/lark/inline/ai/api/ui/IViewHeightProvider;", "context", "Landroid/content/Context;", "config", "Lcom/ss/android/lark/inline/ai/api/creationai/CreationAIConfig;", "callback", "Lcom/ss/android/lark/inline/ai/api/creationai/ICreationAIOpCallback;", "iRenderGone", "Lcom/ss/android/lark/inline/ai/creationai/editor/IRenderGone;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/inline/ai/api/creationai/CreationAIConfig;Lcom/ss/android/lark/inline/ai/api/creationai/ICreationAIOpCallback;Lcom/ss/android/lark/inline/ai/creationai/editor/IRenderGone;)V", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mTag", "", "getMTag", "()Ljava/lang/String;", "setMTag", "(Ljava/lang/String;)V", "mWebViewId", "creationAIEditorBridge", "Lcom/ss/android/lark/inline/ai/creationai/editor/CreationAIEditorBridge;", "mPageFinished", "", "Ljava/lang/Boolean;", "mBridge", "Lcom/bytedance/ee/larkwebview/bridge/Bridge;", "getMBridge", "()Lcom/bytedance/ee/larkwebview/bridge/Bridge;", "mBridge$delegate", "Lkotlin/Lazy;", "contentHeight", "", "onHeightChangeListener", "Lcom/ss/android/lark/inline/ai/api/ui/IViewHeightProvider$OnHeightChangedListener;", "mILarkWebViewContext", "Lcom/bytedance/ee/larkwebview/base/interfaces/ILarkWebViewContext;", "init", "", "subscribe", "Lio/reactivex/disposables/Disposable;", "getSubscribe", "()Lio/reactivex/disposables/Disposable;", "setSubscribe", "(Lio/reactivex/disposables/Disposable;)V", "loadTemplate", "bgColor", "padding", "mode", "renderAIContent", "aiPreviewData", "Lcom/ss/android/lark/inline/ai/creationai/editor/AIPreviewData;", "reset", "onMessage", "data", "", "hide", "startActionMode", "Landroid/view/ActionMode;", "Landroid/view/ActionMode$Callback;", "type", "commonStartActionMode", "onAttachedToWindow", "onDetachedFromWindow", "onResume", "onPause", "destroy", "initSettings", "webView", "Landroid/webkit/WebView;", "setUserAgent", "disableScrollBarRunnable", "Ljava/lang/Runnable;", "gestureDetector", "Landroid/view/GestureDetector;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "startNestedScroll", "axes", "stopNestedScroll", "getViewHeight", "setOnHeightChangeListener", "listener", "Companion", "CreationAIEditorLarkWebChromeClient", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class CreationAIEditorWebview extends NSCLarkWebViewV1 implements wlb.g {
    public static final /* synthetic */ int H0 = 0;
    public String M;
    public String N;
    public com.ss.android.lark.inline.ai.creationai.editor.a O;
    public final vlb.a P;
    public final vlb.b Q;
    public final l R;
    public final Lazy S;
    public int T;
    public wlb.g.a U;
    public final j V;
    public Disposable W;
    public final com.ss.android.lark.inline.ai.creationai.editor.e k0;
    public final GestureDetector p0;

    public static final class a {
    }

    public static final class b extends ws5.b {
        public final String d;

        public b(j r1) {
            super(r1);
            this.d = "CreationAIChromeClient";
        }

        public final boolean onConsoleMessage(ConsoleMessage r4) {
            Intrinsics.checkNotNullParameter(r4, "cm");
            if (r4.messageLevel().ordinal() <= ConsoleMessage.MessageLevel.LOG.ordinal()) goto L7;
            Log.i(this.d, "onConsoleMessage== cm.message(): " + r4 + ".message(), cm.lineNumber(): " + r4.lineNumber() + " , cm.sourceId(): " + r4.sourceId());
            return true;
        L7:
            return true;
        }

        public final void onProgressChanged(WebView r4, int r5) {
            super.onProgressChanged(r4, r5);
            String r0 = this.d;
            StringBuilder r1 = new StringBuilder("onProgressChanged: ");
            r1.append(r5);
            r1.append(", url: ");
            if (r4 == null) goto L5;
            String r6 = r4.getUrl();
        L6:
            r1.append(r6);
            Log.i(r0, r1.toString());
            return;
        L5:
            r6 = null;
            goto L6
        }
    }

    public static final class c implements k {
        public final /* synthetic */ CreationAIEditorWebview a;

        @Override // com.ss.android.lark.inline.ai.creationai.editor.k
        public final void onPageFinished() {
            CreationAIEditorWebview r0 = this.a;
            int r1 = CreationAIEditorWebview.H0;
            r0.getClass();
        }

        public c(CreationAIEditorWebview r1) {
            this.a = r1;
        }
    }

    public static final class d {
        public d() {
        }
    }

    public static final class e implements com.ss.android.lark.inline.ai.creationai.editor.a.i {
        public final /* synthetic */ CreationAIEditorWebview a;

        public e(CreationAIEditorWebview r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.inline.ai.creationai.editor.a.i
        public final void a(AIConversation r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
            Integer r3 = r2.getContentHeight();
            if (r3 == null) goto L8;
            int r4 = r3.intValue();
            CreationAIEditorWebview r0 = this.a;
            r0.T = r4;
            wlb.g.a r1 = r0.U;
            if (r1 == null) goto L9;
            r1.b(f0.a(r4));
            return;
        L9:
            return;
        }
    }

    static {
    }

    private final at5.a getMBridge() {
        return (at5.a) this.S.getValue();
    }

    @Override // wlb.g
    public int getViewHeight() {
        return f0.a(this.T);
    }

    public final void destroy() {
        getMBridge().b();
        com.ss.android.lark.inline.ai.creationai.editor.a r0 = this.O;
        if (r0 == null) goto L5;
        r0.e.removeCallbacks(r0.h);
    L5:
        super.destroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void p() {
        this.N = UUID.randomUUID().toString();
        this.M = "creationAIEditorWebview";
        this.M += this.N;
        boolean r0 = LarkKVStorage.f(com.ss.android.lark.inline.ai.logic.b.a, "debug_config", new n6c.b(LarkContext.getApplication().getSharedPreferences("debug_config", 0))).getBoolean("ai_roadster_debug", false);
        Log.i(this.M, "Native init webViewId = " + this.N + " ,  debug = " + r0);
        WebSettings r1 = getSettings();
        r1.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        r1.setLoadWithOverviewMode(true);
        r1.setUseWideViewPort(true);
        r1.setSupportZoom(true);
        r1.setJavaScriptEnabled(true);
        r1.setDomStorageEnabled(true);
        r1.setSupportMultipleWindows(true);
        r1.setJavaScriptCanOpenWindowsAutomatically(true);
        r1.setCacheMode(-1);
        r1.setAllowFileAccess(true);
        r1.setAllowContentAccess(true);
        r1.setDatabaseEnabled(true);
        setUserAgent(this);
        setBackgroundColor(0);
        setWebViewClient(new com.ss.android.lark.inline.ai.creationai.editor.d(this.V, this.R, this.Q, new c(this)));
        setWebChromeClient(new b(this.V));
        com.ss.android.lark.inline.ai.creationai.editor.a r2 = new com.ss.android.lark.inline.ai.creationai.editor.a(this, this.Q, new d());
        this.O = r2;
        r2.a.getBridge().c("biz.creationAI.render", new com.ss.android.lark.inline.ai.creationai.editor.a.c(r2));
        r2.a.getBridge().c("biz.creationAI.renderComplete", new com.ss.android.lark.inline.ai.creationai.editor.a.C0102a(r2));
        r2.a.getBridge().c("biz.creationAI.openLink", new com.ss.android.lark.inline.ai.creationai.editor.a.b(r2));
        r2.a.getBridge().c("biz.creationAI.openProfile", new com.ss.android.lark.inline.ai.creationai.editor.a.d());
        r2.a.getBridge().c("biz.creationAI.sendMessageToDocs", new com.ss.android.lark.inline.ai.creationai.editor.a.f(r2));
        r2.a.getBridge().c("biz.creationAI.onMessageFromDocs", new com.ss.android.lark.inline.ai.creationai.editor.a.h(r2));
        r2.a.getBridge().c("biz.util.logger", new com.ss.android.lark.inline.ai.creationai.editor.a.g());
        r2.a.getBridge().c("biz.creationAI.reset", new com.ss.android.lark.inline.ai.creationai.editor.a.j(r2));
        com.ss.android.lark.inline.ai.creationai.editor.a r3 = this.O;
        if (r3 == null) goto L6;
        r3.i = new e(this);
        return;
    }

    public final String getMTag() {
        return this.M;
    }

    public final Disposable getSubscribe() {
        return this.W;
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.webkit.WebView*/.onDetachedFromWindow();
    }

    public final void onPause() {
        super.onPause();
    }

    public final void onResume() {
        super.onResume();
    }

    public CreationAIEditorWebview(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    private final void setUserAgent(WebView r14) {
        int r0 = com.bytedance.ee.larkwebview.util.h.a;
        String r1 = com.bytedance.ee.larkwebview.util.h.a(r14.getContext());
        if (TextUtils.isEmpty(r1) == false) goto L5;
        r1 = "Mozilla/5.0 (Linux; Android 10.0; FRD-AL00 Build/HUAWEIFRD-AL00; wv) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.2883.91 Mobile Safari/537.36";
    L5:
        int r2 = com.ss.android.lark.inline.ai.utils.a.a;
        List r3 = CollectionsKt.listOf(new String[]{r1, "CreationAI creationAIEditorWebview", "mWebViewId/" + this.N, com.ss.android.lark.inline.ai.utils.a.a(r14.getContext())});
        ArrayList r4 = new ArrayList();
        Iterator r5 = r3.iterator();
    L7:
        if (r5.hasNext() == false) goto L18;
        Object r6 = r5.next();
        String r7 = (String) r6;
        if (r7 != null) goto L11;
    L14:
        boolean r8 = true;
    L16:
        if ((!r8) == false) goto L7;
        r4.add(r6);
        goto L7
    L11:
        if (StringsKt.isBlank(r7) == true) goto L14;
        r8 = false;
        goto L16
    L18:
        r14.getSettings().setUserAgentString(CollectionsKt.joinToString$default(r4, " ", null, null, 0, null, null, 62, null));
        Log.i(this.M, "initSettings: ua = " + r14.getSettings().getUserAgentString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.inline.ai.creationai.editor.NSCLarkWebViewV1
    public final boolean onTouchEvent(MotionEvent r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        this.p0.onTouchEvent(r4);
        int r0 = r4.getAction();
        if (r0 == 0) goto L12;
        if (r0 != 1) goto L9;
    L11:
        removeCallbacks(this.k0);
        postDelayed(this.k0, 2000);
    L14:
        return super.onTouchEvent(r4);
    L9:
        if (r0 == 3) goto L11;
    L12:
        removeCallbacks(this.k0);
        setVerticalScrollBarEnabled(true);
        setHorizontalScrollBarEnabled(true);
        goto L14
    }

    public final void setMTag(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.M = r2;
    }

    @Override // wlb.g
    public void setOnHeightChangeListener(wlb.g.a r1) {
        this.U = r1;
    }

    public final void setSubscribe(Disposable r1) {
        this.W = r1;
    }

    public final ActionMode startActionMode(ActionMode.Callback r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        return o(r2, -1);
    }

    @Override // com.ss.android.lark.inline.ai.creationai.editor.NSCLarkWebViewV1
    public final void stopNestedScroll(int r3) {
        Log.i("LarkWebView", "stopNestedScroll");
        super.stopNestedScroll(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CreationAIEditorWebview(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, gt5.d.b);
        this.M = "CreationAIEditorWebview";
        this.S = LazyKt.lazy(new CreationAIEditorWebview$mBridge$2(this));
        this.V = new j(this);
        this.k0 = new com.ss.android.lark.inline.ai.creationai.editor.e(this);
        this.p0 = new GestureDetector(getContext(), new f(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ActionMode o(ActionMode.Callback r4, int r5) {
        vlb.a r0 = this.P;
        if (r0 == null) goto L5;
        FragmentActivity r1 = r0.getActivity();
    L7:
        if (r1 != null) goto L9;
    L19:
        Log.w("LarkWebView", "startActionMode while not active !");
        return null;
    L9:
        if (r1.isFinishing() == true) goto L19;
        Log.i("LarkWebView", " start actionMode");     // Catch: Exception -> L16
        if (x.a() == false) goto L15;
        return super.startActionMode(r4, r5);
    L15:
        return super/*android.webkit.WebView*/.startActionMode(r4);
    L16:
        e = move-exception;
        Log.e("LarkWebView", " start actionMode exception ", e);
        return null;
    L5:
        r1 = null;
        goto L7
    }

    public final ActionMode startActionMode(ActionMode.Callback r1, int r2) {
        return o(r1, r2);
    }

    @Override // com.ss.android.lark.inline.ai.creationai.editor.NSCLarkWebViewV1
    public final boolean startNestedScroll(int r3, int r4) {
        Log.i("LarkWebView", "startNestedScroll");
        return super.startNestedScroll(r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CreationAIEditorWebview(FragmentActivity r2, vlb.a r3, vlb.b r4, c0 r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "config");
        Intrinsics.checkNotNullParameter(r4, "callback");
        Intrinsics.checkNotNullParameter(r5, "iRenderGone");
        this(r2, null);
        this.P = r3;
        this.Q = r4;
        this.R = r5;
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setScrollBarStyle(0);
    }
}
