package com.ss.android.lark.inline.ai.ui.richtext;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.webkit.ConsoleMessage;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.libarchive.Archive;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.FileUtils;
import com.larksuite.framework.utils.x;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import com.ss.android.lark.inline.ai.ui.f0;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 R2\u00020\u00012\u00020\u0002:\u0002RSB)\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\rB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0010J\u0006\u0010)\u001a\u00020*J*\u00101\u001a\u00020*2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0012J\u0010\u00105\u001a\u00020*2\b\u00106\u001a\u0004\u0018\u000107J\u0006\u00108\u001a\u00020*J\u001c\u00109\u001a\u0004\u0018\u00010:2\b\u0010\u0007\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020$H\u0016J\u0012\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010\u0007\u001a\u00020;H\u0016J\u001c\u0010=\u001a\u0004\u0018\u00010:2\b\u0010\u0007\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020$H\u0002J\b\u0010>\u001a\u00020*H\u0014J\b\u0010?\u001a\u00020*H\u0014J\b\u0010@\u001a\u00020*H\u0016J\b\u0010A\u001a\u00020*H\u0016J\b\u0010B\u001a\u00020*H\u0016J\u0010\u0010C\u001a\u00020*2\u0006\u0010D\u001a\u00020EH\u0002J\u0010\u0010F\u001a\u00020*2\u0006\u0010D\u001a\u00020EH\u0002J\u0012\u0010I\u001a\u00020\u001b2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\u0018\u0010L\u001a\u00020\u001b2\u0006\u0010M\u001a\u00020$2\u0006\u0010<\u001a\u00020$H\u0016J\u0010\u0010N\u001a\u00020*2\u0006\u0010<\u001a\u00020$H\u0016J\b\u0010O\u001a\u00020$H\u0016J\u0012\u0010P\u001a\u00020*2\b\u0010Q\u001a\u0004\u0018\u00010&H\u0016R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001cR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u000e\u0010G\u001a\u00020HX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006T"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/richtext/RichtextPreviewWebview;", "Lcom/ss/android/lark/inline/ai/ui/richtext/NSCLarkWebView;", "Lcom/ss/android/lark/inline/ai/api/ui/IViewHeightProvider;", "context", "Landroid/content/Context;", "config", "Lcom/ss/android/lark/inline/ai/api/ui/InlineAIConfig;", "callback", "Lcom/ss/android/lark/inline/ai/api/ui/IOperationCallback;", "iRenderGone", "Lcom/ss/android/lark/inline/ai/ui/richtext/IRenderGone;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/inline/ai/api/ui/InlineAIConfig;Lcom/ss/android/lark/inline/ai/api/ui/IOperationCallback;Lcom/ss/android/lark/inline/ai/ui/richtext/IRenderGone;)V", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mTag", "", "getMTag", "()Ljava/lang/String;", "setMTag", "(Ljava/lang/String;)V", "mWebViewId", "richtextPreviewBridge", "Lcom/ss/android/lark/inline/ai/ui/richtext/RichtextPreviewBridge;", "mPageFinished", "", "Ljava/lang/Boolean;", "mBridge", "Lcom/bytedance/ee/larkwebview/bridge/Bridge;", "getMBridge", "()Lcom/bytedance/ee/larkwebview/bridge/Bridge;", "mBridge$delegate", "Lkotlin/Lazy;", "contentHeight", "", "onHeightChangeListener", "Lcom/ss/android/lark/inline/ai/api/ui/IViewHeightProvider$OnHeightChangedListener;", "mILarkWebViewContext", "Lcom/bytedance/ee/larkwebview/base/interfaces/ILarkWebViewContext;", "init", "", "subscribe", "Lio/reactivex/disposables/Disposable;", "getSubscribe", "()Lio/reactivex/disposables/Disposable;", "setSubscribe", "(Lio/reactivex/disposables/Disposable;)V", "loadTemplate", "bgColor", "padding", "mode", "renderAIContent", "aiPreviewData", "Lcom/ss/android/lark/inline/ai/ui/richtext/AIPreviewData;", "hide", "startActionMode", "Landroid/view/ActionMode;", "Landroid/view/ActionMode$Callback;", "type", "commonStartActionMode", "onAttachedToWindow", "onDetachedFromWindow", "onResume", "onPause", "destroy", "initSettings", "webView", "Landroid/webkit/WebView;", "setUserAgent", "disableScrollBarRunnable", "Ljava/lang/Runnable;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "startNestedScroll", "axes", "stopNestedScroll", "getViewHeight", "setOnHeightChangeListener", "listener", "Companion", "RichtextPreviewLarkWebChromeClient", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class RichtextPreviewWebview extends NSCLarkWebView implements wlb.g {
    public static final /* synthetic */ int V0 = 0;
    public final k H0;
    public Disposable L0;
    public final j P0;
    public String Q;
    public String R;
    public com.ss.android.lark.inline.ai.ui.richtext.g S;
    public final wlb.h T;
    public final wlb.e U;
    public final com.ss.android.lark.inline.ai.ui.richtext.b V;
    public final Lazy W;
    public int k0;
    public wlb.g.a p0;

    public static final class a {
    }

    public static final class b extends ws5.b {
        public final String d;

        public b(k r1) {
            super(r1);
            this.d = "RichtextPreviewLarkWebChromeClient";
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

    public static final class c implements com.ss.android.lark.inline.ai.ui.richtext.a {
        public final /* synthetic */ RichtextPreviewWebview a;

        @Override // com.ss.android.lark.inline.ai.ui.richtext.a
        public final void onPageFinished() {
            RichtextPreviewWebview r0 = this.a;
            int r1 = RichtextPreviewWebview.V0;
            r0.getClass();
        }

        public c(RichtextPreviewWebview r1) {
            this.a = r1;
        }
    }

    public static final class d implements NSCLarkWebView.b {
        public final /* synthetic */ RichtextPreviewWebview a;

        public d(RichtextPreviewWebview r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.inline.ai.ui.richtext.NSCLarkWebView.b
        public final void setEnable(boolean r4) {
            Log.i(this.a.getMTag(), "IEnableCallback enable = " + r4);
            this.a.setMEnable(r4);
        }
    }

    public static final class e implements com.ss.android.lark.inline.ai.ui.richtext.g.InterfaceC0111g {
        public final /* synthetic */ RichtextPreviewWebview a;

        public e(RichtextPreviewWebview r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.inline.ai.ui.richtext.g.InterfaceC0111g
        public final void a(AIConversation r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
            Integer r3 = r2.getContentHeight();
            if (r3 == null) goto L8;
            int r4 = r3.intValue();
            RichtextPreviewWebview r0 = this.a;
            r0.k0 = r4;
            wlb.g.a r1 = r0.p0;
            if (r1 == null) goto L9;
            r1.b(f0.a(r4));
            return;
        L9:
            return;
        }
    }

    public static final class f<T, R> implements Function {
        public final /* synthetic */ RichtextPreviewWebview a;

        public f(RichtextPreviewWebview r1) {
            this.a = r1;
        }

        public final Object apply(Object r25) {
            Intrinsics.checkNotNullParameter((Boolean) r25, "it");
            int r0 = l.a;
            Context r2 = this.a.getContext();
            Intrinsics.checkNotNullParameter(r2, "context");
            Log.i("RichtextResLoader", "getRichtextRes  1");
            long r5 = System.currentTimeMillis();
            Intrinsics.checkNotNullParameter(r2, "context");
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
            Object r3 = Result.constructor-impl(l.c(new BufferedReader(new InputStreamReader(r2.getAssets().open("inlineai/current_revision")))));     // Catch: Throwable -> L5
        L7:
            Throwable r7 = Result.exceptionOrNull-impl(r3);
            if (r7 == null) goto L10;
            Log.i("RichtextResLoader", "getAssetVersion onFailure : " + r7);
        L10:
            com.ss.android.lark.inline.ai.ui.richtext.f r8 = new com.ss.android.lark.inline.ai.ui.richtext.f();
            if (Result.isFailure-impl(r3) == false) goto L13;
            r3 = r8;
        L13:
            String r13 = ((com.ss.android.lark.inline.ai.ui.richtext.f) r3).b;
            if (r13 != null) goto L16;
        L19:
            boolean r4 = true;
        L20:
            if (r4 == true) goto L71;
            VFSPath r12 = l.b();
            Intrinsics.checkNotNullParameter(r2, "context");
        L26:
            th = move-exception;
            Log.e("RichtextResLoader", "getResLocalVersion error", th);
        L28:
            com.ss.android.lark.inline.ai.ui.richtext.f r6 = new com.ss.android.lark.inline.ai.ui.richtext.f();
        L29:
            String r9 = r6.b;
            if (r9 != null) goto L32;
            r9 = "";
        L32:
            List r10 = StringsKt.split$default(r13, new char[]{'.'}, false, 0, 6, null);
            List r11 = StringsKt.split$default(r9, new char[]{'.'}, false, 0, 6, null);
            int r14 = Math.min(r10.size(), r11.size());
            int r15 = 0;
            int r16 = 0;
        L33:
            if (r15 >= r14) goto L40;
            r16 = ((String) ListProtector.get(r10, r15)).length() - ((String) ListProtector.get(r11, r15)).length();
            if (r16 != 0) goto L37;
            r16 = ((String) ListProtector.get(r10, r15)).compareTo((String) ListProtector.get(r11, r15));
        L37:
            if (r16 != 0) goto L40;
            r15 = r15 + 1;
        L40:
            if (r16 != 0) goto L42;
            r16 = r10.size() - r11.size();
        L42:
            Log.i("RichtextResLoader", "getRichtextRes   cost1 : " + (System.currentTimeMillis() - r5) + ",  localVersion: " + r9 + ",  assetVersion: " + r13 + ",  versionCompare: " + r16 + ",  resLocalDir: " + r12.getAbsolutePath());
            if (r16 <= 0) goto L45;
        L51:
            Log.i("RichtextResLoader", "replaceLocal");
            Intrinsics.checkNotNullParameter(r2, "context");
            VFSPath r17 = l.b();
            VFSFiles.b.getClass();
            FileUtils.f(VFSFiles.b(true).i(r17.getAbsolutePath()));
            Intrinsics.checkNotNullParameter(r2, "context");
            VFSPath r18 = r12;
            Intrinsics.checkNotNullParameter(r18, "dest");
            VFSPath r19 = l.b().subPath("inline_ai_preview.7z");
            com.suite.lark.component.storage.ext.b.delete(r19);
            l.a(r2, "inlineai/inline_ai_preview.7z", r19);
            String r20 = r19.getRealPath();
            String r21 = r18.getRealPath();
            Intrinsics.checkNotNullParameter(r21, "destFold1");
            if (TextUtils.isEmpty(r20) == false) goto L54;
        L63:
            int r22 = -1;
        L64:
            com.suite.lark.component.storage.ext.b.delete(r19);
            if (r22 != 0) goto L69;
        L66:
            Log.i("RichtextResLoader", "getRichtextRes   cost2 : " + (System.currentTimeMillis() - r5));
            return r18.subPath("inline_ai_preview").subPath("index.html").getAbsolutePath();
        L69:
            throw new IllegalAccessException("extract7z failed " + r22);
        L54:
            if (TextUtils.isEmpty(r21) == true) goto L63;
        L61:
            e = move-exception;
            Log.e("RichtextResLoader", "extractAll fails : " + e + "  message:" + e.getMessage());
            goto L63
        L57:
            if (StringsKt.endsWith$default(r21, "/", false, 2, null) == true) goto L59;
            r21 = r21 + File.separator;     // Catch: IOException -> L61
        L59:
            r22 = Archive.extractAll(r20, r21, null, 0);     // Catch: IOException -> L61
            goto L64
        L45:
            if (r9.length() != 0) goto L47;
            boolean r23 = true;
        L48:
            if (r23 == true) goto L51;
            r18 = r12;
            goto L66
        L47:
            r23 = false;
            goto L48
        L23:
            if (com.suite.lark.component.storage.ext.b.b(l.b().subPath("inline_ai_preview").subPath("current_revision")) == false) goto L28;
            VFSFiles.b.getClass();     // Catch: Throwable -> L26
            r6 = l.c(new BufferedReader(new PolarisFileReaderWrapper(VFSFiles.b(true).r(l.b().subPath("inline_ai_preview").subPath("current_revision"), false))));     // Catch: Throwable -> L26
            goto L29
        L71:
            throw new IllegalArgumentException("assetVersion is null");
        L16:
            if (r13.length() == 0) goto L19;
            r4 = false;
        L5:
            th = move-exception;
            Result.Companion r24 = Result.Companion;
            r3 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L7
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ RichtextPreviewWebview d;

        public g(String r1, String r2, String r3, RichtextPreviewWebview r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r5) {
            String r6 = MSkiaImageRegionDecoder.FILE_PREFIX + ((String) r5);
            yob.e.a().getClass();
            int r0 = com.ss.android.lark.language.service.impl.a.f;
            Locale r1 = com.ss.android.lark.language.service.impl.a.b.a.getLanguageSetting();
            if (r1 != null) goto L5;
            r1 = Locale.ENGLISH;
        L5:
            String r7 = r6 + "?locale=" + (r1.getLanguage() + '-' + r1.getCountry());
            String r2 = this.a;
            if (r2 == null) goto L8;
            r7 = r7 + "&bgColor=" + r2;
        L8:
            String r3 = this.b;
            if (r3 == null) goto L11;
            r7 = r7 + "&padding=" + r3;
        L11:
            String r4 = this.c;
            if (r4 == null) goto L14;
            r7 = r7 + "&mode=" + r4;
        L14:
            Log.i(this.d.getMTag(), "loadTemplate  loader = " + r7);
            com.ss.android.lark.inline.ai.ui.richtext.g r8 = this.d.S;
            if (r8 == null) goto L17;
            System.currentTimeMillis();
            r8.f.postDelayed(r8.h, 10000);
        L17:
            this.d.loadUrl(r7);
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ RichtextPreviewWebview a;

        public h(RichtextPreviewWebview r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            int r0 = zlb.a.d;
            if (r5 == null) goto L5;
            String r1 = r5.toString();
        L6:
            zlb.a.C0355a.e(404, r1, 0);
            Log.e(this.a.getMTag(), r5, true);
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    static {
    }

    private final at5.a getMBridge() {
        return (at5.a) this.W.getValue();
    }

    @Override // wlb.g
    public int getViewHeight() {
        return f0.a(this.k0);
    }

    public final void p() {
        Disposable r0 = this.L0;
        if (r0 != null) goto L5;
    L7:
        AIPreviewData r1 = new AIPreviewData("", null, null, null, null, null, null, null, 254, null);
        com.ss.android.lark.inline.ai.ui.richtext.g r2 = this.S;
        if (r2 == null) goto L12;
        amb.d r3 = r2.g;
        if (r3 == null) goto L12;
        r3.b();
    L12:
        com.ss.android.lark.inline.ai.ui.richtext.g r4 = this.S;
        if (r4 == null) goto L15;
        r4.a(r1);
    L15:
        com.ss.android.lark.inline.ai.ui.richtext.g r5 = this.S;
        if (r5 == null) goto L21;
        amb.d r6 = r5.g;
        if (r6 == null) goto L22;
        r6.b();
        return;
    L22:
        return;
    L21:
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        r0.dispose();
        goto L7
    }

    public final void destroy() {
        getMBridge().b();
        com.ss.android.lark.inline.ai.ui.richtext.g r0 = this.S;
        if (r0 == null) goto L5;
        r0.f.removeCallbacks(r0.h);
    L5:
        super.destroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void q() {
        this.R = UUID.randomUUID().toString();
        this.Q = "RichtextPreviewWebview";
        this.Q += this.R;
        boolean r0 = LarkKVStorage.f(com.ss.android.lark.inline.ai.logic.b.a, "debug_config", new n6c.b(LarkContext.getApplication().getSharedPreferences("debug_config", 0))).getBoolean("ai_roadster_debug", false);
        Log.i(this.Q, "Native init webViewId = " + this.R + " ,  debug = " + r0);
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
        setWebViewClient(new i(this.H0, this.V, this.U, new c(this)));
        setWebChromeClient(new b(this.H0));
        com.ss.android.lark.inline.ai.ui.richtext.g r2 = new com.ss.android.lark.inline.ai.ui.richtext.g(this, this.U, new d(this));
        this.S = r2;
        r2.a.getBridge().c("biz.render.AIContent", new com.ss.android.lark.inline.ai.ui.richtext.g.c(r2));
        r2.a.getBridge().c("biz.render.AIContent.complete", new com.ss.android.lark.inline.ai.ui.richtext.g.a(r2));
        amb.d r3 = new amb.d(r2.b);
        r2.g = r3;
        r2.a.getBridge().c("biz.selection.showMenu", r3);
        r2.a.getBridge().c("biz.selection.closeMenu", new amb.a(r3));
        r2.a.getBridge().c("biz.selection.longPress", new amb.b());
        r2.a.getBridge().c("biz.render.AIContent.openLink", new com.ss.android.lark.inline.ai.ui.richtext.g.b(r2));
        r2.a.getBridge().c("biz.selection.setScrollStatus", new amb.c(r2.c));
        if (new bmb.a().b.isCurrentEnable("ccm.knowledge.inline_ai_mention_all_enable") == false) goto L5;
        r2.a.getBridge().c("biz.render.AIContent.openProfile", new com.ss.android.lark.inline.ai.ui.richtext.g.d());
    L5:
        r2.a.getBridge().c("biz.inlineAI.sendMessageToDocs", new com.ss.android.lark.inline.ai.ui.richtext.g.f(r2));
        com.ss.android.lark.inline.ai.ui.richtext.g r4 = this.S;
        if (r4 == null) goto L9;
        r4.i = new e(this);
        return;
    }

    public final String getMTag() {
        return this.Q;
    }

    public final Disposable getSubscribe() {
        return this.L0;
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

    public RichtextPreviewWebview(Context r2) {
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
        List r3 = CollectionsKt.listOf(new String[]{r1, "inlineAI RichtextPreviewWebview", "mWebViewId/" + this.R, com.ss.android.lark.inline.ai.utils.a.a(r14.getContext())});
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
        Log.i(this.Q, "initSettings: ua = " + r14.getSettings().getUserAgentString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.inline.ai.ui.richtext.NSCLarkWebView
    public final boolean onTouchEvent(MotionEvent r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        int r0 = r4.getAction();
        if (r0 == 0) goto L12;
        if (r0 != 1) goto L9;
    L11:
        removeCallbacks(this.P0);
        postDelayed(this.P0, 2000);
    L14:
        return super.onTouchEvent(r4);
    L9:
        if (r0 == 3) goto L11;
    L12:
        removeCallbacks(this.P0);
        setVerticalScrollBarEnabled(true);
        goto L14
    }

    public final void setMTag(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.Q = r2;
    }

    @Override // wlb.g
    public void setOnHeightChangeListener(wlb.g.a r1) {
        this.p0 = r1;
    }

    public final void setSubscribe(Disposable r1) {
        this.L0 = r1;
    }

    public final ActionMode startActionMode(ActionMode.Callback r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        return o(r2, -1);
    }

    @Override // com.ss.android.lark.inline.ai.ui.richtext.NSCLarkWebView
    public final void stopNestedScroll(int r3) {
        Log.i("LarkWebView", "stopNestedScroll");
        super.stopNestedScroll(r3);
    }

    public RichtextPreviewWebview(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, gt5.d.b);
        this.Q = "RichtextPreviewWebview";
        this.W = LazyKt.lazy(new RichtextPreviewWebview$mBridge$2(this));
        this.H0 = new k(this);
        this.P0 = new j(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ActionMode o(ActionMode.Callback r4, int r5) {
        wlb.h r0 = this.T;
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

    @Override // com.ss.android.lark.inline.ai.ui.richtext.NSCLarkWebView
    public final boolean startNestedScroll(int r3, int r4) {
        Log.i("LarkWebView", "startNestedScroll");
        return super.startNestedScroll(r3, r4);
    }

    public final void r(String r5, String r6, String r7) {
        this.L0 = Single.just(Boolean.TRUE).map(new f(this)).subscribeOn(new ExecutorScheduler(CoreThreadPool.getDefault().getSingleScheduledThreadPool(this.Q), false)).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(r5, r6, r7, this), new h(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RichtextPreviewWebview(FragmentActivity r2, wlb.h r3, wlb.e r4, com.ss.android.lark.inline.ai.ui.richtext.b r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "config");
        Intrinsics.checkNotNullParameter(r4, "callback");
        Intrinsics.checkNotNullParameter(r5, "iRenderGone");
        this(r2, null);
        this.T = r3;
        this.U = r4;
        this.V = r5;
        setVerticalScrollBarEnabled(false);
        setScrollBarStyle(0);
    }
}
