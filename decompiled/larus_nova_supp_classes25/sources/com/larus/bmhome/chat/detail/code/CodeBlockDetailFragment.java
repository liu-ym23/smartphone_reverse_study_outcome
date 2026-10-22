package com.larus.bmhome.chat.detail.code;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.detail.AbstractCommonDetailFragment;
import com.larus.bmhome.chat.detail.code.artifact.request.CodeNodeContent;
import com.larus.bmhome.chat.detail.code.view.PreviewSwitchButton;
import com.larus.bmhome.chat.font.FontLevel;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.bmhome.web.AiChatHostWebService;
import com.larus.bmhome.web.IAiChatHostWebService;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.mainbot.impl.databinding.LarusFragmentCodeBlockDetailBinding;
import com.larus.mainbot.impl.databinding.LarusPageDeepResearchErrorBinding;
import com.larus.mainbot.impl.databinding.LarusPageDeepResearchLoadingBinding;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 \u0090\u00012\u00020\u00012\u00020\u0002:\u0002\u0090\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u00106\u001a\u000207H\u0002J\b\u0010@\u001a\u000207H\u0002J\b\u0010A\u001a\u000207H\u0002J\n\u0010L\u001a\u0004\u0018\u00010MH\u0016J\b\u0010N\u001a\u00020OH\u0016J\b\u0010P\u001a\u00020OH\u0016J\n\u0010Q\u001a\u0004\u0018\u00010\u0018H\u0014J\f\u0010T\u001a\u00020'*\u00020'H\u0002J\b\u0010U\u001a\u000207H\u0002J\u0012\u0010V\u001a\u0002072\b\u0010W\u001a\u0004\u0018\u00010XH\u0016J\b\u0010Y\u001a\u000207H\u0002J&\u0010Z\u001a\u0004\u0018\u00010[2\u0006\u0010\\\u001a\u00020]2\b\u0010^\u001a\u0004\u0018\u00010M2\b\u0010W\u001a\u0004\u0018\u00010XH\u0016J\u001a\u0010_\u001a\u0002072\u0006\u0010`\u001a\u00020[2\b\u0010W\u001a\u0004\u0018\u00010XH\u0016J\b\u0010a\u001a\u000207H\u0002J\u0010\u0010b\u001a\u0002072\u0006\u0010c\u001a\u00020dH\u0002J\u001a\u0010e\u001a\u0002072\b\u0010f\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J\u001a\u0010g\u001a\u00020\u00182\b\u0010f\u001a\u0004\u0018\u00010\u00182\u0006\u0010h\u001a\u00020\u0012H\u0002J\b\u0010i\u001a\u000207H\u0016J\u0006\u0010j\u001a\u00020\u0018J\b\u0010k\u001a\u000207H\u0002J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010l\u001a\u00020\u0012H\u0016J\b\u0010m\u001a\u000207H\u0002J\u0012\u0010n\u001a\u0002072\b\b\u0002\u0010\u001f\u001a\u00020\u0012H\u0002J\b\u0010o\u001a\u000207H\u0002J\b\u0010p\u001a\u000207H\u0002J\u0010\u0010q\u001a\u0002072\u0006\u0010r\u001a\u00020'H\u0002J0\u0010s\u001a\u0002072\b\b\u0002\u0010t\u001a\u00020\u00122\b\b\u0002\u0010u\u001a\u00020\u00122\b\b\u0002\u0010v\u001a\u00020\u00122\b\b\u0002\u0010w\u001a\u00020\u0012H\u0002J\u0010\u0010x\u001a\u0002072\u0006\u0010y\u001a\u00020'H\u0002J\b\u0010z\u001a\u000207H\u0002J$\u0010{\u001a\u0004\u0018\u00010|2\u0006\u0010}\u001a\u00020~2\u0007\u0010\u007f\u001a\u00030\u0080\u00012\u0007\u0010\u0081\u0001\u001a\u00020'H\u0002J\t\u0010\u0082\u0001\u001a\u00020\u0012H\u0016J\t\u0010\u0083\u0001\u001a\u000207H\u0003J\t\u0010\u0084\u0001\u001a\u000207H\u0002J\u001b\u0010\u0085\u0001\u001a\u0002072\u0007\u0010\u0086\u0001\u001a\u00020\u00182\u0007\u0010\u0087\u0001\u001a\u00020\u0012H\u0002J\t\u0010\u0088\u0001\u001a\u000207H\u0002J\t\u0010\u0089\u0001\u001a\u000207H\u0002J\t\u0010\u008a\u0001\u001a\u00020\u0012H\u0016J\t\u0010\u008b\u0001\u001a\u00020\u0018H\u0016J\u000b\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0010H\u0016J\t\u0010\u008d\u0001\u001a\u00020\u0018H\u0016J\u000b\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0018H\u0016J\t\u0010\u008f\u0001\u001a\u000207H\u0016R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0014\u001a\u0004\u0018\u00010\u0018@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0004\n\u0002\u0010%R\u0012\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0004\n\u0002\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010.\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00101\u001a\u0002028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u000e\u001a\u0004\b3\u00104R\u001d\u00108\u001a\u0004\u0018\u0001098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\u000e\u001a\u0004\b:\u0010;R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010B\u001a\u00020C8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010\u000e\u001a\u0004\bD\u0010ER\u001b\u0010G\u001a\u00020H8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bK\u0010\u000e\u001a\u0004\bI\u0010JR\u0010\u0010R\u001a\u0004\u0018\u00010SX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0091\u0001"}, d2 = {"Lcom/larus/bmhome/chat/detail/code/CodeBlockDetailFragment;", "Lcom/larus/bmhome/chat/detail/AbstractCommonDetailFragment;", "Lcom/larus/bmhome/chat/detail/code/ICodeBlockDetailFragmentAbility;", "dependency", "Lcom/larus/bmhome/chat/detail/code/ICodeBlockParamProvider;", "<init>", "(Lcom/larus/bmhome/chat/detail/code/ICodeBlockParamProvider;)V", "getDependency", "()Lcom/larus/bmhome/chat/detail/code/ICodeBlockParamProvider;", "viewModel", "Lcom/larus/bmhome/chat/detail/code/CodeBlockDetailViewModel;", "getViewModel", "()Lcom/larus/bmhome/chat/detail/code/CodeBlockDetailViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "binding", "Lcom/larus/mainbot/impl/databinding/LarusFragmentCodeBlockDetailBinding;", "enableScroll", "", "isCodeRefreshing", "value", "isCodeFinished", "setCodeFinished", "(Z)V", "", "threadId", "setThreadId", "(Ljava/lang/String;)V", "showPreviewButton", "isGeneralAgent", "generalAgentChatId", "isInPreview", "waitToPreview", "codeRenderScene", "Lcom/larus/bmhome/chat/detail/code/CodeRenderScene;", "codeArtifactId", "", "Ljava/lang/Long;", "codeArtifactVersion", "", "Ljava/lang/Integer;", "deepResearchId", "deepResearchResourceId", "isUserTouch", "eventExtra", "", "", "singleCodeRefreshThreadExecutor", "Ljava/util/concurrent/ExecutorService;", "singleCodeRefreshThreadDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "getSingleCodeRefreshThreadDispatcher", "()Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "singleCodeRefreshThreadDispatcher$delegate", "shutdownSingleCodeRefreshThreadExecutor", "", "codeBlockDetailPreviewAbility", "Lcom/larus/bmhome/chat/detail/code/preview/ICodeBlockDetailPreviewAbility;", "getCodeBlockDetailPreviewAbility", "()Lcom/larus/bmhome/chat/detail/code/preview/ICodeBlockDetailPreviewAbility;", "codeBlockDetailPreviewAbility$delegate", "codeLoadingCoverAnimator", "Landroid/animation/ValueAnimator;", "isInLoadingDotAnim", "startLoadingDotAnim", "stopLoadingDotAnim", "deepResearchCodeHelper", "Lcom/larus/bmhome/chat/detail/code/DeepResearchFetchCodeHelper;", "getDeepResearchCodeHelper", "()Lcom/larus/bmhome/chat/detail/code/DeepResearchFetchCodeHelper;", "deepResearchCodeHelper$delegate", "codeArtifactRenderHelper", "Lcom/larus/bmhome/chat/detail/code/artifact/request/CodeArtifactRenderHelper;", "getCodeArtifactRenderHelper", "()Lcom/larus/bmhome/chat/detail/code/artifact/request/CodeArtifactRenderHelper;", "codeArtifactRenderHelper$delegate", "getMarkDownTextViewContainer", "Landroid/view/ViewGroup;", "getMarkdownTextSize", "", "getLineSpacingMult", "getCopyContentType", "codeLoadingDot", "Landroidx/appcompat/widget/AppCompatImageView;", "adjustDotBottom", "createCodeLoadingViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "attachPreviewComponent", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "onViewCreated", "view", "fetchCodeArtifactCode", "processCodeArtifactRender", "codeNodeContent", "Lcom/larus/bmhome/chat/detail/code/artifact/request/CodeNodeContent;", "refreshCodeWithCodeCheck", "realText", "processStreamingCodeUpdate", "isBlockFinished", "onDestroy", "getMsgId", "initTitleBar", "isInPreviewTab", "refreshButtonState", "changeTab", "refreshChangeLineStatus", "initViewModel", "setCodeLoadingPlaceholderMarginTop", "marginTop", "refreshMarkDownTextView", "useAsync", "scrollToBottomIfNeeded", "isCodeToBeFinished", "useGradientCover", "startCodeLoadingCoverAnim", "oldHeight", "scrollCodeTabToBottom", "getNewMarkdownContent", "Lcom/larus/business/markdown/api/model/MarkdownContent;", "context", "Landroid/content/Context;", "markDownTextView", "Lcom/larus/bmhome/view/textview/impl/CustomMarkdownTextView;", "maxContentWidth", "enableScrollDefault", "initListener", "fetchDeepResearchCode", "refreshCode", "code", "isFinished", "onCodeCompleted", "onCodeFail", "autoLogEnterPage", "getCurrentPageName", "getBinding", "getCode", "getLanguage", "onCodePreviewReady", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class CodeBlockDetailFragment extends AbstractCommonDetailFragment implements l0 {
    public static final /* synthetic */ int k0 = 0;
    public final m0 A;
    public final Lazy B;
    public LarusFragmentCodeBlockDetailBinding C;
    public boolean D;
    public volatile boolean E;
    public boolean F;
    public boolean G;
    public String H;
    public String I;
    public boolean J;
    public boolean K;
    public CodeRenderScene L;
    public Long M;
    public Integer N;
    public String O;
    public String P;
    public boolean Q;
    public Map<String, ? extends Object> R;
    public ExecutorService S;
    public final Lazy T;
    public final Lazy U;
    public ValueAnimator V;
    public boolean W;
    public final Lazy X;
    public final Lazy Y;
    public AppCompatImageView Z;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CodeRenderScene.values().length];
            r0[CodeRenderScene.DeepSearch.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[CodeRenderScene.CodeArtifact.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class c implements n0 {
        public final /* synthetic */ CodeBlockDetailFragment a;

        @Override // com.larus.bmhome.chat.detail.code.n0
        public final void b() {
        }

        @Override // com.larus.bmhome.chat.detail.code.n0
        public final void a() {
            CodeBlockDetailFragment r0 = this.a;
            int r1 = CodeBlockDetailFragment.k0;
            m0 r2 = r0.A;
            if (r2 == null) goto L5;
            r2.g(true);
        L5:
            r0.F = true;
            AppCompatImageView r3 = this.a.Z;
            if (r3 == null) goto L8;
            r3.setVisibility(8);
        L8:
            this.a.va0();
            this.a.na0();
        }

        @Override // com.larus.bmhome.chat.detail.code.n0
        public final void d() {
            CodeBlockDetailFragment r0 = this.a;
            int r1 = CodeBlockDetailFragment.k0;
            r0.qc();
        }

        public c(CodeBlockDetailFragment r1) {
            this.a = r1;
        }

        @Override // com.larus.bmhome.chat.detail.code.n0
        public final void c(String r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r3, "code");
            CodeBlockDetailFragment r0 = this.a;
            int r1 = CodeBlockDetailFragment.k0;
            r0.qa0(r3, r4);
        }
    }

    public static final class d implements com.larus.bmhome.chat.detail.code.artifact.request.b {
        public final /* synthetic */ CodeBlockDetailFragment a;

        public final void b() {
            LarusFragmentCodeBlockDetailBinding r0 = this.a.C;
            if (r0 == null) goto L7;
            View r1 = r0.d;
            if (r1 == null) goto L7;
            e1.x(r1);
        L7:
            LarusFragmentCodeBlockDetailBinding r2 = this.a.C;
            if (r2 == null) goto L14;
            LarusPageDeepResearchLoadingBinding r3 = r2.n;
            if (r3 == null) goto L14;
            LinearLayout r4 = r3.a;
            if (r4 == null) goto L14;
            e1.x(r4);
        L14:
            LarusFragmentCodeBlockDetailBinding r5 = this.a.C;
            if (r5 == null) goto L22;
            LarusPageDeepResearchErrorBinding r6 = r5.m;
            if (r6 == null) goto L23;
            ConstraintLayout r7 = r6.a;
            if (r7 == null) goto L24;
            e1.o(r7);
            return;
        L24:
            return;
        L23:
            return;
        }

        @Override // com.larus.bmhome.chat.detail.code.artifact.request.b
        public final void onError() {
            LarusFragmentCodeBlockDetailBinding r0 = this.a.C;
            if (r0 == null) goto L9;
            LarusPageDeepResearchLoadingBinding r1 = r0.n;
            if (r1 == null) goto L9;
            LinearLayout r2 = r1.a;
            if (r2 == null) goto L9;
            e1.o(r2);
        L9:
            LarusFragmentCodeBlockDetailBinding r3 = this.a.C;
            if (r3 == null) goto L17;
            LarusPageDeepResearchErrorBinding r4 = r3.m;
            if (r4 == null) goto L18;
            ConstraintLayout r5 = r4.a;
            if (r5 == null) goto L19;
            e1.x(r5);
            return;
        L19:
            return;
        L18:
            return;
        }

        public d(CodeBlockDetailFragment r1) {
            this.a = r1;
        }

        @Override // com.larus.bmhome.chat.detail.code.artifact.request.b
        public final void a(CodeNodeContent r4) {
            Intrinsics.checkNotNullParameter(r4, "codeNodeContent");
            LarusFragmentCodeBlockDetailBinding r0 = this.a.C;
            if (r0 == null) goto L9;
            LarusPageDeepResearchLoadingBinding r1 = r0.n;
            if (r1 == null) goto L9;
            LinearLayout r2 = r1.a;
            if (r2 == null) goto L9;
            e1.o(r2);
        L9:
            LarusFragmentCodeBlockDetailBinding r3 = this.a.C;
            if (r3 == null) goto L16;
            LarusPageDeepResearchErrorBinding r5 = r3.m;
            if (r5 == null) goto L16;
            ConstraintLayout r6 = r5.a;
            if (r6 == null) goto L16;
            e1.o(r6);
        L16:
            LarusFragmentCodeBlockDetailBinding r7 = this.a.C;
            if (r7 == null) goto L21;
            View r8 = r7.d;
            if (r8 == null) goto L21;
            e1.o(r8);
        L21:
            CodeBlockDetailFragment r9 = this.a;
            r9.getClass();
            String r10 = r4.getContent();
            if (r10 != null) goto L24;
            r10 = "";
        L24:
            r9.qa0(r10, true);
            if (Intrinsics.areEqual(r4.getLanguage(), "html") == false) goto L28;
            r9.G = true;
            r9.ma0();
            r9.qc();
            return;
        }
    }

    public static final class e implements PreviewSwitchButton.a {
        public final /* synthetic */ CodeBlockDetailFragment a;

        public e(CodeBlockDetailFragment r1) {
            this.a = r1;
        }

        @Override // com.larus.bmhome.chat.detail.code.view.PreviewSwitchButton.a
        public final void a(boolean r2) {
            CodeBlockDetailFragment r0 = this.a;
            r0.J = r2;
            r0.ia0(r2);
        }
    }

    public static final class f implements IIMCallback<Message> {
        public final /* synthetic */ CodeBlockDetailFragment a;

        public final boolean mustInMain() {
            return true;
        }

        public f(CodeBlockDetailFragment r1) {
            this.a = r1;
        }

        public final void onFailure(IIMError r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
        }

        public final void onSuccess(Object r2) {
            Message r3 = (Message) r2;
            Intrinsics.checkNotNullParameter(r3, "result");
            com.larus.bmhome.chat.detail.i r0 = this.a.e;
            if (r0 == null) goto L5;
            r0.j(r3);
        L5:
            final CodeBlockDetailFragment r4 = this.a;
            t0.c(new d0(r4));
        }
    }

    public static final class g implements IIMCallback<Message> {
        public final /* synthetic */ AppCompatImageView a;

        public final boolean mustInMain() {
            return true;
        }

        public g(AppCompatImageView r1) {
            this.a = r1;
        }

        public final void onFailure(IIMError r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            Intrinsics.checkNotNullParameter(r2, "error");
            this.a.setEnabled(false);
            this.a.setAlpha(0.5f);
        }

        public final /* bridge */ /* synthetic */ void onSuccess(Object r1) {
            Message r2 = (Message) r1;
        }
    }

    public static final class h implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public h(i r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    public CodeBlockDetailFragment() {
        this(null);
    }

    public final boolean S90() {
        return true;
    }

    @Override // com.larus.bmhome.chat.detail.AbstractCommonDetailFragment
    public final String ca0() {
        return "code";
    }

    @Override // com.larus.bmhome.chat.detail.AbstractCommonDetailFragment
    public final float da0() {
        return 1.1f;
    }

    public final String k() {
        return "code_full_screen_page";
    }

    @Override // com.larus.bmhome.chat.detail.AbstractCommonDetailFragment
    public final ViewGroup fa0() {
        LarusFragmentCodeBlockDetailBinding r0 = this.C;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.j;
    }

    public final void ka0() {
        LarusFragmentCodeBlockDetailBinding r0 = this.C;
        if (r0 == null) goto L9;
        LarusPageDeepResearchErrorBinding r1 = r0.m;
        if (r1 == null) goto L9;
        ConstraintLayout r2 = r1.a;
        if (r2 == null) goto L9;
        e1.d(r2, new q(this));
    L9:
        com.larus.bmhome.chat.detail.code.artifact.request.a r3 = (com.larus.bmhome.chat.detail.code.artifact.request.a) this.Y.getValue();
        LifecycleCoroutineScope r4 = LifecycleOwnerKt.getLifecycleScope(this);
        Long r5 = this.M;
        if (r5 == null) goto L12;
        long r6 = r5.longValue();
    L13:
        r3.b(r4, r6, this.N, new d(this));
        return;
    L12:
        r6 = 0;
        goto L13
    }

    @Override // com.larus.bmhome.chat.detail.code.l0
    public final void ky() {
        if (this.K == false) goto L6;
        ia0(true);
        return;
    }

    public final void na0() {
        if (this.G == false) goto L7;
        com.larus.bmhome.chat.detail.code.preview.j r0 = (com.larus.bmhome.chat.detail.code.preview.j) this.U.getValue();
        if (r0 == null) goto L7;
        r0.Rj();
    L7:
        Context r1 = getContext();
        if (r1 == null) goto L11;
        String r2 = r1.getString(2131901463);
        if (r2 == null) goto L11;
    L13:
        if (this.J == true) goto L16;
        t19.s r3 = t19.s.a;
        Context r4 = getContext();
        r3.getClass();
        t19.s.c(r4, r2);
        return;
    L16:
        return;
    L11:
        r2 = "";
        goto L13
    }

    public final void oa0() {
        boolean r1 = false;
        if (this.F == true) goto L5;
    L10:
        boolean r0 = true;
    L11:
        LarusFragmentCodeBlockDetailBinding r3 = this.C;
        float r4 = 1.0f;
        if (r3 == null) goto L19;
        AppCompatImageView r5 = r3.e;
        if (r5 == null) goto L19;
        if (r0 == false) goto L17;
        float r6 = 0.5f;
    L18:
        r5.setAlpha(r6);
        r5.setEnabled(!r0);
        goto L19
    L17:
        r6 = 1.0f;
    L19:
        int r2 = b.a[this.L.ordinal()];
        if (r2 == 1) goto L44;
        if (r2 != 2) goto L24;
    L49:
        r1 = true;
    L50:
        FLogger r7 = FLogger.a;
        StringBuilder r8 = new StringBuilder("isShareButtonDisabled = ");
        r8.append(r1);
        r8.append(" codeRenderScene = ");
        r8.append(this.L);
        r8.append(" message?.messageStatusLocal = ");
        m0 r9 = this.A;
        if (r9 == null) goto L53;
        Integer r10 = r9.k();
    L54:
        r8.append(r10);
        r7.d("CodeBlockDetailFragment", r8.toString());
        LarusFragmentCodeBlockDetailBinding r11 = this.C;
        if (r11 == null) goto L62;
        AppCompatImageView r12 = r11.v;
        if (r12 == null) goto L63;
        if (r1 == false) goto L60;
        r4 = 0.5f;
    L60:
        r12.setAlpha(r4);
        r12.setEnabled(!r1);
        com.larus.im.d.e().m(this.g, new g(r12));
        return;
    L63:
        return;
    L62:
        return;
    L53:
        r10 = null;
        goto L54
    L24:
        if (this.F == false) goto L49;
        if (this.J == true) goto L38;
        m0 r13 = this.A;
        if (r13 == null) goto L30;
        boolean r14 = Intrinsics.areEqual(r13.isStreaming(), Boolean.TRUE);
    L31:
        if (r14 == false) goto L38;
        m0 r15 = this.A;
        if (r15 == null) goto L35;
        boolean r16 = Intrinsics.areEqual(r15.isFinished(), Boolean.FALSE);
    L36:
        if (r16 == true) goto L49;
    L35:
        r16 = false;
        goto L36
    L30:
        r14 = false;
    L38:
        if (this.g.length() != 0) goto L40;
        boolean r17 = true;
    L41:
        if (r17 == false) goto L50;
    L40:
        r17 = false;
        goto L41
    L44:
        if (this.F == false) goto L49;
        if (this.J == true) goto L50;
        if (this.E == false) goto L50;
    L5:
        if (this.J == true) goto L10;
        if (this.E == true) goto L10;
        r0 = false;
        goto L11
    }

    public final void qc() {
        m0 r0 = this.A;
        if (r0 == null) goto L5;
        r0.g(true);
    L5:
        this.F = true;
        oa0();
        if (this.G == true) goto L8;
        return;
    L8:
        com.larus.bmhome.chat.detail.code.preview.j r1 = (com.larus.bmhome.chat.detail.code.preview.j) this.U.getValue();
        if (r1 == null) goto L12;
        r1.qc();
    L12:
        if (this.J == true) goto L15;
        this.K = true;
        return;
    }

    public final void ua0() {
        if (this.W == false) goto L5;
        return;
    L5:
        AlphaAnimation r0 = new AlphaAnimation(1.0f, 0.0f);
        r0.setDuration(400);
        r0.setRepeatMode(2);
        r0.setRepeatCount(-1);
        AppCompatImageView r1 = this.Z;
        if (r1 == null) goto L8;
        r1.startAnimation(r0);
    L8:
        this.W = true;
    }

    public final void va0() {
        AppCompatImageView r0 = this.Z;
        if (r0 == null) goto L5;
        r0.clearAnimation();
    L5:
        this.W = false;
    }

    @Override // com.larus.bmhome.chat.detail.AbstractCommonDetailFragment
    public final float ga0() {
        return we8.a.a(i5.m(), false);
    }

    public final void ja0() {
        Context r0 = requireContext();
        LarusFragmentCodeBlockDetailBinding r1 = this.C;
        if (r1 == null) goto L5;
        FrameLayout r2 = r1.j;
    L6:
        AppCompatImageView r3 = new AppCompatImageView(r0);
        r3.setId(2131367083);
        FrameLayout.LayoutParams r4 = new FrameLayout.LayoutParams(r3.getResources().getDimensionPixelSize(v19.c.b(2130971546, null, 2131167462)), r3.getResources().getDimensionPixelSize(v19.c.b(2130971546, null, 2131167462)));
        r4.setMarginStart(r3.getResources().getDimensionPixelSize(v19.c.b(2130971485, null, 2131167340)));
        int r5 = i5.J();
        if (this.p == true) goto L10;
        Lazy r6 = we8.e.a;
        r5 = r5 + c7.b(Integer.valueOf((we8.e.d - FontLevel.STANDARD.getValue()) * 3));
    L10:
        r4.bottomMargin = r5;
        r4.gravity = 8388691;
        r3.setLayoutParams(r4);
        r3.setVisibility(0);
        r3.setImageDrawable(ContextCompat.getDrawable(r0, v19.c.b(2130971754, r0, 2131241509)));
        this.Z = r3;
        if (r2 == null) goto L14;
        Intrinsics.checkNotNull(r3);
        r2.addView(r3);
        return;
    L14:
        return;
    L5:
        r2 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.ViewGroup, com.larus.bmhome.chat.detail.code.view.PreviewSwitchButton] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void ma0() {
        oa0();
        pa0();
        LarusFragmentCodeBlockDetailBinding r0 = this.C;
        if (r0 == null) goto L14;
        TextView r1 = r0.g;
        Bundle r2 = getArguments();
        if (r2 == null) goto L9;
        String r3 = r2.getString("key_code_block_title");
        if (r3 == null) goto L9;
    L10:
        r1.setText(r3);
        if (this.G == false) goto L15;
        ?? r4 = r0.s;
        r4.setVisibility(0);
        r4.setState(this.J);
        ia0(this.J);
        r4.setOnStateChangeListener(new e(this));
        return;
    L15:
        return;
    L9:
        r3 = this.i;
        goto L10
    }

    @Override // com.larus.bmhome.chat.detail.AbstractCommonDetailFragment
    public final void onDestroy() {
        super.onDestroy();
        AppCompatImageView r0 = this.Z;
        if (r0 == null) goto L5;
        r0.clearAnimation();
    L5:
        ValueAnimator r1 = this.V;
        if (r1 == null) goto L9;
        r1.cancel();
    L9:
        if (this.L != CodeRenderScene.DeepSearch) goto L14;
        h0 r2 = (h0) this.X.getValue();
        com.larus.im.internal.research.d.a r3 = r2.d;
        if (r3 == null) goto L13;
        r3.a();
    L13:
        ((Handler) r2.e.getValue()).removeCallbacksAndMessages(null);
        r2.c = null;
    L14:
        ExecutorService r4 = this.S;
        if (r4 == null) goto L17;
        r4.shutdownNow();
    L17:
        this.S = null;
        m0 r5 = this.A;
        if (r5 == null) goto L21;
        r5.onDestroy();
        return;
    }

    public final void pa0() {
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.D == false) goto L16;
        LarusFragmentCodeBlockDetailBinding r1 = this.C;
        if (r1 == null) goto L11;
        AppCompatImageView r2 = r1.e;
        if (r2 == null) goto L11;
        r2.setBackground(null);
    L11:
        LarusFragmentCodeBlockDetailBinding r3 = this.C;
        if (r3 == null) goto L28;
        AppCompatImageView r4 = r3.e;
        if (r4 == null) goto L29;
        r4.setBackground(ContextCompat.getDrawable(r0, v19.c.b(2130971728, r0, 2131241378)));
        return;
    L29:
        return;
    L28:
        return;
    L16:
        LarusFragmentCodeBlockDetailBinding r5 = this.C;
        if (r5 == null) goto L21;
        AppCompatImageView r6 = r5.e;
        if (r6 == null) goto L21;
        r6.setBackground(null);
    L21:
        LarusFragmentCodeBlockDetailBinding r7 = this.C;
        if (r7 == null) goto L31;
        AppCompatImageView r8 = r7.e;
        if (r8 == null) goto L32;
        r8.setBackground(ContextCompat.getDrawable(r0, v19.c.b(2130971727, r0, 2131241375)));
        return;
    L32:
        return;
    }

    @Override // com.larus.bmhome.chat.detail.code.l0
    public final boolean Vo() {
        return this.J;
    }

    @Override // com.larus.bmhome.chat.detail.AbstractCommonDetailFragment
    public final boolean Z90() {
        return this.D;
    }

    @Override // com.larus.bmhome.chat.detail.code.l0
    public final LarusFragmentCodeBlockDetailBinding d0() {
        return this.C;
    }

    @Override // com.larus.bmhome.chat.detail.code.l0
    public final String getCode() {
        return this.j;
    }

    @Override // com.larus.bmhome.chat.detail.code.l0
    public final String getLanguage() {
        return this.i;
    }

    @Override // com.larus.bmhome.chat.detail.code.l0
    public final boolean jW() {
        return this.F;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [com.larus.bmhome.chat.detail.code.g] */
    /* JADX WARN: Type inference failed for: r0v15, types: [com.larus.bmhome.chat.detail.code.b0] */
    /* JADX WARN: Type inference failed for: r0v16, types: [com.larus.bmhome.chat.detail.code.a0] */
    /* JADX WARN: Type inference failed for: r0v17, types: [com.larus.bmhome.chat.detail.code.z] */
    public CodeBlockDetailFragment(m0 r2) {
        super(r2);
        this.A = r2;
        this.B = LazyKt.lazy(new u(this));
        this.D = z2.a.getMarkdownOptimizeConfig().i;
        this.L = CodeRenderScene.Default;
        this.T = LazyKt.lazy(new v(this));
        this.U = LazyKt.lazy(new w(this));
        this.X = LazyKt.lazy(new x(this));
        this.Y = LazyKt.lazy(new y());
        if (r2 == 0) goto L5;
        r2.f(new z(this));
    L5:
        if (r2 == 0) goto L7;
        r2.h(new a0(this));
    L7:
        if (r2 == 0) goto L9;
        r2.b(new b0(this));
    L9:
        if (r2 == 0) goto L12;
        r2.l(new com.larus.bmhome.chat.detail.code.g(this));
        return;
    }

    public static void ha0(DialogFragment r1) {
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

    public final void ia0(boolean r3) {
        if (this.J == r3) goto L10;
        this.J = r3;
        LarusFragmentCodeBlockDetailBinding r0 = this.C;
        if (r0 == null) goto L10;
        PreviewSwitchButton r1 = r0.s;
        if (r1 == null) goto L10;
        r1.setState(r3);
    L10:
        if (r3 == false) goto L24;
        this.K = false;
        com.larus.bmhome.chat.detail.code.preview.j r4 = (com.larus.bmhome.chat.detail.code.preview.j) this.U.getValue();
        if (r4 == null) goto L14;
        r4.B30(0);
    L14:
        LarusFragmentCodeBlockDetailBinding r5 = this.C;
        if (r5 == null) goto L19;
        NestedScrollView r6 = r5.i;
        if (r6 == null) goto L19;
        r6.setVisibility(8);
    L19:
        LarusFragmentCodeBlockDetailBinding r7 = this.C;
        if (r7 == null) goto L37;
        TextView r8 = r7.b;
        if (r8 == null) goto L37;
        r8.setVisibility(8);
    L37:
        oa0();
        return;
    L24:
        com.larus.bmhome.chat.detail.code.preview.j r9 = (com.larus.bmhome.chat.detail.code.preview.j) this.U.getValue();
        if (r9 == null) goto L27;
        r9.B30(8);
    L27:
        LarusFragmentCodeBlockDetailBinding r10 = this.C;
        if (r10 == null) goto L32;
        NestedScrollView r11 = r10.i;
        if (r11 == null) goto L32;
        r11.setVisibility(0);
    L32:
        LarusFragmentCodeBlockDetailBinding r12 = this.C;
        if (r12 == null) goto L37;
        TextView r13 = r12.b;
        if (r13 == null) goto L37;
        r13.setVisibility(0);
        goto L37
    }

    @Override // com.larus.bmhome.chat.detail.AbstractCommonDetailFragment
    public final void onCreate(Bundle r6) {
        super.onCreate(r6);
        Bundle r7 = getArguments();
        boolean r0 = true;
        if (r7 != null) goto L5;
    L7:
        boolean r8 = false;
    L8:
        if (r8 == false) goto L10;
        this.D = true;
    L10:
        s1a.a.a(this, this, l0.class);
        Bundle r9 = getArguments();
        if (r9 != null) goto L13;
    L15:
        boolean r10 = false;
    L16:
        if (r10 == false) goto L18;
        this.L = CodeRenderScene.DeepSearch;
    L26:
        Bundle r11 = getArguments();
        if (r11 == null) goto L30;
        String r12 = r11.getString("is_general_agent");
        if (r12 == null) goto L30;
    L31:
        this.H = r12;
        Bundle r13 = getArguments();
        Map<String, ? extends Object> r2 = null;
        if (r13 == null) goto L34;
        String r14 = r13.getString("chat_id");
    L35:
        this.I = r14;
        Bundle r15 = getArguments();
        if (r15 != null) goto L38;
    L42:
        boolean r16 = false;
    L43:
        this.G = r16;
        CodeRenderScene r17 = this.L;
        CodeRenderScene r3 = CodeRenderScene.CodeArtifact;
        if (r17 != r3) goto L47;
        this.G = false;
    L47:
        if (this.G == true) goto L49;
        if (r17 == r3) goto L49;
    L50:
        Bundle r18 = getArguments();
        if (r18 != null) goto L53;
    L57:
        boolean r19 = false;
    L58:
        this.J = r19;
        CodeRenderScene r20 = this.L;
        if (r20 == CodeRenderScene.DeepSearch) goto L69;
        if (r20 == r3) goto L69;
        Bundle r21 = getArguments();
        if (r21 == null) goto L65;
        r0 = r21.getBoolean("key_is_code_finished", true);
    L65:
        m0 r22 = this.A;
        if (r22 == null) goto L68;
        r22.g(r0);
    L68:
        this.F = r0;
    L73:
        Bundle r23 = getArguments();
        if (r23 == null) goto L76;
        Integer r24 = Integer.valueOf(r23.getInt("key_artifact_code_version"));
    L77:
        this.N = r24;
        Bundle r25 = getArguments();
        if (r25 == null) goto L80;
        Long r26 = Long.valueOf(r25.getLong("key_artifact_code_code_id"));
    L81:
        this.M = r26;
        Bundle r27 = getArguments();
        if (r27 == null) goto L84;
        String r28 = r27.getString("key_thread_id");
    L85:
        m0 r1 = this.A;
        if (r1 == null) goto L88;
        r1.i(r28);
    L88:
        Bundle r29 = getArguments();
        if (r29 == null) goto L91;
        String r30 = r29.getString("key_deep_research_id");
    L92:
        this.O = r30;
        Bundle r31 = getArguments();
        if (r31 == null) goto L95;
        String r32 = r31.getString("key_deep_research_resource_id");
    L96:
        this.P = r32;
        Bundle r33 = getArguments();
        if (r33 == null) goto L99;
        Serializable r34 = r33.getSerializable("key_event_extra");
    L101:
        if ((r34 instanceof Map) == false) goto L103;
        r2 = (Map) r34;
    L103:
        this.R = r2;
        return;
    L99:
        r34 = null;
        goto L101
    L95:
        r32 = null;
        goto L96
    L91:
        r30 = null;
        goto L92
    L84:
        r28 = null;
        goto L85
    L80:
        r26 = null;
        goto L81
    L76:
        r24 = null;
    L69:
        m0 r35 = this.A;
        if (r35 == null) goto L72;
        r35.g(false);
    L72:
        this.F = false;
        goto L73
    L53:
        if (r18.getBoolean("key_is_to_preview") == false) goto L57;
        if (this.G == false) goto L57;
        r19 = true;
    L49:
        k1a.b.a(this, new com.larus.bmhome.chat.detail.code.h(this));
        goto L50
    L38:
        if (r15.getBoolean("key_can_code_be_previewed") == false) goto L42;
        AiChatHostWebService.a.getClass();
        if (((IAiChatHostWebService) AiChatHostWebService.b.getValue()) == null) goto L42;
        r16 = true;
        goto L43
    L34:
        r14 = null;
    L30:
        r12 = "0";
        goto L31
    L18:
        Bundle r36 = getArguments();
        if (r36 != null) goto L21;
    L23:
        boolean r37 = false;
    L24:
        if (r37 == false) goto L26;
        this.L = CodeRenderScene.CodeArtifact;
        goto L26
    L21:
        if (r36.getBoolean("key_is_from_code_artifact") != true) goto L23;
        r37 = true;
        goto L24
    L13:
        if (r9.getBoolean("key_is_from_deep_research") != true) goto L15;
        r10 = true;
        goto L16
    L5:
        if (r7.getBoolean("key_code_block_default_no_wrap") != true) goto L7;
        r8 = true;
        goto L8
    }

    public final void ta0(int r4) {
        LarusFragmentCodeBlockDetailBinding r0 = this.C;
        if (r0 == null) goto L14;
        TextView r1 = r0.h;
        if (r1 == null) goto L15;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
    L10:
        if (r3 == null) goto L12;
        r3.topMargin = r4;
        r1.setLayoutParams(r3);
    L12:
        r1.setVisibility(0);
        return;
    L9:
        r3 = null;
        goto L10
    L15:
        return;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.bmhome.chat.detail.code.i] */
    @Override // com.larus.bmhome.chat.detail.AbstractCommonDetailFragment
    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        ma0();
        ((CodeBlockDetailViewModel) this.B.getValue()).getShareDetailData().observe(getViewLifecycleOwner(), new h(new i(this)));
        LarusFragmentCodeBlockDetailBinding r5 = this.C;
        if (r5 == null) goto L9;
        e1.d(r5.c, new j(this));
        e1.d(r5.e, new k(this));
        e1.d(r5.v, new l(this));
        LarusFragmentCodeBlockDetailBinding r6 = this.C;
        if (r6 == null) goto L9;
        NestedScrollView r7 = r6.i;
        if (r7 == null) goto L9;
        r7.setOnTouchListener(new m(this));
    L9:
        CodeRenderScene r8 = this.L;
        int r9 = b.a[r8.ordinal()];
        boolean r10 = false;
        if (r9 == 1) goto L25;
        if (r9 != 2) goto L14;
        ka0();
    L43:
        com.larus.im.d.e().m(this.g, new f(this));
        return;
    L14:
        if (this.F == true) goto L43;
        if (this.g.length() <= 0) goto L18;
        r10 = true;
    L18:
        if (r10 == false) goto L43;
        m0 r11 = this.A;
        if (r11 == null) goto L22;
        r11.m();
    L22:
        ja0();
        ua0();
        goto L43
    L25:
        if (this.L != CodeRenderScene.DeepSearch) goto L42;
        String r12 = this.P;
        if (r12 != null) goto L30;
    L33:
        boolean r13 = true;
    L34:
        if (r13 == true) goto L42;
        h0 r14 = (h0) this.X.getValue();
        if (r14.a.length() != 0) goto L39;
        r10 = true;
    L39:
        if (r10 == true) goto L42;
        r14.b = SystemClock.elapsedRealtime();
        com.larus.im.e r15 = com.larus.im.c.a;
        com.larus.im.internal.research.a.a.a(r14.a, new k0(r14));
        goto L42
    L30:
        if (StringsKt.isBlank(r12) == true) goto L33;
        r13 = false;
    L42:
        ja0();
        ua0();
        goto L43
    }

    public final void qa0(String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.j = r4;
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.r = r4;
        String r6 = ba0(this.i, r4, !r5);
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        this.k = r6;
        sa0(true, true, r5, true);
    }

    public final void ra0(String r15, boolean r16) {
        boolean r10 = true;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L30
        if (r15 != null) goto L6;
    L9:
        boolean r3 = true;
    L10:
        if (r3 == true) goto L34;
        String r4 = this.j;     // Catch: Throwable -> L30
        int r12 = StringsKt.lastIndexOf$default(r15, StringsKt.trim(r4.substring(0, RangesKt.coerceAtMost(50, r4.length()))).toString(), 0, false, 6, null);     // Catch: Throwable -> L30
        if (r12 != (-1)) goto L21;
        m0 r0 = this.A;     // Catch: Throwable -> L30
        if (r0 == null) goto L17;
        r0.g(true);     // Catch: Throwable -> L30
    L17:
        this.F = true;     // Catch: Throwable -> L30
        AppCompatImageView r1 = this.Z;     // Catch: Throwable -> L30
        if (r1 == null) goto L20;
        r1.setVisibility(8);     // Catch: Throwable -> L30
    L20:
        va0();     // Catch: Throwable -> L30
        na0();     // Catch: Throwable -> L30
        goto L34
    L21:
        int r5 = StringsKt.indexOf$default(r15, "```", r12, false, 4, null);     // Catch: Throwable -> L30
        if (r5 != (-1)) goto L25;
        r5 = r15.length();     // Catch: Throwable -> L30
    L25:
        if (r5 != r15.length()) goto L27;
        if (r16 == true) goto L27;
    L28:
        FLogger.a.d("CodeBlockDetailFragment", "endIndex = " + r5 + " currentMarkdownCode = " + StringsKt.trim(r15.substring(r12, r5)).toString());     // Catch: Throwable -> L30
        String r6 = StringsKt.trim(r15.substring(r12, r5)).toString();     // Catch: Throwable -> L30
    L36:
        if (r6.length() == 0) goto L39;
        r10 = false;
    L39:
        if (r10 == false) goto L41;
        return;
    L41:
        qa0(r6, this.F);
        return;
    L27:
        qc();     // Catch: Throwable -> L30
    L34:
        r6 = "";
        goto L36
    L6:
        if (r15.length() == 0) goto L9;
        r3 = false;
    L30:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        Throwable r8 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
        if (r8 == null) goto L34;
        FLogger.a.e("CodeBlockDetailFragment", r8.toString());
        goto L34
    }

    public final lw8.l la0(Context r34, CustomMarkdownTextView r35, int r36) {
        gw8.c.a.getClass();
        gw8.c r2 = gw8.c.a.b();
        if (r2 != null) goto L7;
        return null;
    L7:
        return gw8.c.b.a(r2, r35.getContext(), r36, this.k, true, new lw8.d(0, null, null, false, null, 0, null, 0.0f, null, 0, 0, null, null, null, null, null, aa0(r34, this.D), null, null, null, null, null, null, null, -2097153, 31), null, r35.getText(), 160);
    }

    public final View onCreateView(LayoutInflater r28, ViewGroup r29, Bundle r30) {
        Intrinsics.checkNotNullParameter(r28, "inflater");
        ConstraintLayout r1 = r28.inflate(2131562356, r29, false);
        int r2 = 2131362392;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r1, 2131362392);
        if (r6 == null) goto L70;
        r2 = 2131363779;
        AppCompatImageView r7 = ViewBindings.findChildViewById(r1, 2131363779);
        if (r7 == null) goto L70;
        r2 = 2131363815;
        View r8 = ViewBindings.findChildViewById(r1, 2131363815);
        if (r8 == null) goto L70;
        r2 = 2131365460;
        AppCompatImageView r9 = ViewBindings.findChildViewById(r1, 2131365460);
        if (r9 == null) goto L70;
        ConstraintLayout r3 = r1;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r1, 2131367081);
        if (r11 == null) goto L68;
        TextView r12 = (TextView) ViewBindings.findChildViewById(r1, 2131367084);
        if (r12 == null) goto L67;
        NestedScrollView r13 = ViewBindings.findChildViewById(r1, 2131367085);
        if (r13 == null) goto L66;
        FrameLayout r14 = (FrameLayout) ViewBindings.findChildViewById(r1, 2131367812);
        if (r14 == null) goto L65;
        FrameLayout r15 = (FrameLayout) ViewBindings.findChildViewById(r1, 2131367813);
        if (r15 == null) goto L64;
        LinearLayout r16 = (LinearLayout) ViewBindings.findChildViewById(r1, 2131379567);
        if (r16 == null) goto L63;
        View r4 = ViewBindings.findChildViewById(r1, 2131381799);
        if (r4 == null) goto L62;
        LarusPageDeepResearchErrorBinding r17 = LarusPageDeepResearchErrorBinding.a(r4);
        View r5 = ViewBindings.findChildViewById(r1, 2131381803);
        if (r5 == null) goto L61;
        LarusPageDeepResearchLoadingBinding r18 = LarusPageDeepResearchLoadingBinding.a(r5);
        ConstraintLayout r19 = ViewBindings.findChildViewById(r1, 2131382930);
        if (r19 == null) goto L60;
        ProgressBar r20 = (ProgressBar) ViewBindings.findChildViewById(r1, 2131382931);
        if (r20 == null) goto L59;
        TextView r21 = (TextView) ViewBindings.findChildViewById(r1, 2131382932);
        if (r21 != null) goto L33;
        r2 = 2131382932;
        goto L70
    L33:
        if (((LinearLayout) ViewBindings.findChildViewById(r1, 2131382933)) == null) goto L57;
        FrameLayout r22 = (FrameLayout) ViewBindings.findChildViewById(r1, 2131382935);
        if (r22 == null) goto L56;
        PreviewSwitchButton r23 = (PreviewSwitchButton) ViewBindings.findChildViewById(r1, 2131382966);
        if (r23 == null) goto L55;
        FrameLayout r24 = (FrameLayout) ViewBindings.findChildViewById(r1, 2131382967);
        if (r24 == null) goto L54;
        FrameLayout r25 = (FrameLayout) ViewBindings.findChildViewById(r1, 2131382993);
        if (r25 == null) goto L53;
        AppCompatImageView r26 = ViewBindings.findChildViewById(r1, 2131386061);
        if (r26 != null) goto L45;
        r2 = 2131386061;
        goto L70
    L45:
        if (ViewBindings.findChildViewById(r1, 2131388812) == null) goto L51;
        this.C = new LarusFragmentCodeBlockDetailBinding(r3, r6, r7, r8, r9, r3, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
        if (r3 == null) goto L49;
        r3.setTag(2131377847, this);
        return r3;
    L49:
        return null;
    L51:
        r2 = 2131388812;
        goto L70
    L53:
        r2 = 2131382993;
        goto L70
    L54:
        r2 = 2131382967;
        goto L70
    L55:
        r2 = 2131382966;
        goto L70
    L56:
        r2 = 2131382935;
        goto L70
    L57:
        r2 = 2131382933;
        goto L70
    L59:
        r2 = 2131382931;
        goto L70
    L60:
        r2 = 2131382930;
        goto L70
    L61:
        r2 = 2131381803;
        goto L70
    L62:
        r2 = 2131381799;
        goto L70
    L63:
        r2 = 2131379567;
        goto L70
    L64:
        r2 = 2131367813;
        goto L70
    L65:
        r2 = 2131367812;
        goto L70
    L66:
        r2 = 2131367085;
        goto L70
    L67:
        r2 = 2131367084;
        goto L70
    L68:
        r2 = 2131367081;
    L70:
        throw new NullPointerException("Missing required view with ID: ".concat(r1.getResources().getResourceName(r2)));
    }

    public final void sa0(boolean r19, boolean r20, boolean r21, boolean r22) {
        boolean r0 = true;
        this.E = true;
        oa0();
        Ref.LongRef r3 = new Ref.LongRef();
        r3.element = SystemClock.elapsedRealtime();
        Context r8 = getContext();
        if (r8 == null) goto L43;
        CustomMarkdownTextView r6 = this.f;
        if (r6 == null) goto L46;
        int r9 = (r6.getMarkdownWidth() - r6.getPaddingStart()) - r6.getPaddingEnd();
        if (r19 == false) goto L11;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new CodeBlockDetailFragment$refreshMarkDownTextView$1$1(r21, this, r3, r19, r20, r6, r22, r8, r9, null), 3, null);
        return;
    L11:
        lw8.l r1 = la0(r8, r6, r9);
        FLogger r2 = FLogger.a;
        r2.d("CodeBlockDetailFragment", "getNewMarkdownContent cost[" + (SystemClock.elapsedRealtime() - r3.element) + "], useAsync[" + r19 + ']');
        if (r20 == true) goto L14;
    L16:
        r0 = false;
    L17:
        int r10 = r6.getMeasuredHeight();
        if (r22 == false) goto L20;
        ta0(r10);
    L20:
        r3.element = SystemClock.elapsedRealtime();
        r6.C(r1, null, null, null);
        r2.d("CodeBlockDetailFragment", "setMarkdown cost[" + (SystemClock.elapsedRealtime() - r3.element) + "], useAsync[" + r19 + ']');
        if (r0 == false) goto L28;
        LarusFragmentCodeBlockDetailBinding r4 = this.C;
        if (r4 == null) goto L28;
        NestedScrollView r5 = r4.i;
        if (r5 == null) goto L28;
        r5.post(new n(r5));
    L28:
        if (r22 == false) goto L33;
        CustomMarkdownTextView r7 = this.f;
        if (r7 == null) goto L33;
        r7.post(new com.larus.bmhome.chat.detail.code.f(r7, this, r10));
    L33:
        this.E = false;
        oa0();
        if (r21 == false) goto L38;
        va0();
        AppCompatImageView r11 = this.Z;
        if (r11 == null) goto L44;
        r11.setVisibility(8);
        return;
    L44:
        return;
    L38:
        AppCompatImageView r12 = this.Z;
        if (r12 == null) goto L41;
        r12.setVisibility(0);
    L41:
        ua0();
        return;
    L14:
        if (this.Q == true) goto L16;
    L46:
        return;
    }
}
