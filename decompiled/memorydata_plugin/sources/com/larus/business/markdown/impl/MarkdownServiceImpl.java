package com.larus.business.markdown.impl;

import android.app.Application;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.larus.business.markdown.api.depend.d;
import com.larus.business.markdown.api.model.c;
import com.larus.business.markdown.api.model.h;
import com.larus.business.markdown.api.model.j;
import com.larus.business.markdown.impl.common.utils.b;
import com.larus.business.markdown.impl.markwon.e;
import com.larus.business.markdown.impl.markwon.f;
import com.larus.business.markdown.impl.markwon.g;
import com.larus.business.markdown.impl.widget.MarkdownMultiWidgetHelper;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.core.spans.p;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.i;
import org.commonmark.node.Node;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016JE\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0016¢\u0006\u0002\u0010\u001bJZ\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\b\u0010 \u001a\u0004\u0018\u00010!2\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0016H\u0016J@\u0010\u001c\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00142\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0016H\u0016Jp\u0010$\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010 \u001a\u0004\u0018\u00010!2\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u000b\u0018\u00010(H\u0017JL\u0010*\u001a\u0004\u0018\u00010&2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u000b\u0018\u00010(H\u0017JJ\u0010,\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010&2\u000e\u00102\u001a\n\u0012\u0004\u0012\u000204\u0018\u000103H\u0017Jx\u00105\u001a\b\u0012\u0004\u0012\u00020&032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u00106\u001a\u00020&2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u00107\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010/\u001a\u0002002\u000e\u00108\u001a\n\u0012\u0004\u0012\u00020&\u0018\u0001032\u000e\u00102\u001a\n\u0012\u0004\u0012\u000204\u0018\u0001032\u0006\u00109\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000eH\u0017J\u0010\u0010:\u001a\u00020\u00172\u0006\u0010;\u001a\u00020\u001dH\u0016J\u0010\u0010<\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u0010=\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0016J\u0012\u0010A\u001a\u00020\u000b2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016JU\u0010D\u001a\u00020\u000b2K\u0010E\u001aG\u0012\u0013\u0012\u00110G¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(J\u0012\u0013\u0012\u00110\u0017¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(K\u0012\u0013\u0012\u00110\u001a¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(L\u0012\u0004\u0012\u00020\u000b0FH\u0016J\u0010\u0010D\u001a\u00020\u000b2\u0006\u0010E\u001a\u00020MH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/larus/business/markdown/impl/MarkdownServiceImpl;", "Lcom/larus/business/markdown/api/MarkdownService;", "()V", "markdownConfigManager", "Lcom/larus/business/markdown/impl/common/MarkdownConfigManager;", "getMarkdownConfigManager", "()Lcom/larus/business/markdown/impl/common/MarkdownConfigManager;", "markdownConfigManager$delegate", "Lkotlin/Lazy;", "prepareDeferred", "Lkotlinx/coroutines/Deferred;", "", "clearMarkdownDrawableCachePool", "createCacheMarkwonStruct", "Lcom/larus/business/markdown/api/model/IMarkwonStruct;", "context", "Landroid/content/Context;", "maxContentWidth", "", "customMarkDownInfo", "Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "payload", "", "", "", "finished", "", "(Landroid/content/Context;Ljava/lang/Integer;Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;Ljava/util/Map;Z)Lcom/larus/business/markdown/api/model/IMarkwonStruct;", "createMarkdownContent", "Lcom/larus/business/markdown/api/model/MarkdownContent;", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "markwonStructCache", "reuseCharSequence", "", "textView", "Lcom/larus/business/markdown/api/view/text/IMarkdownTextView;", "createMarkdownContentFromNode", "node", "Lorg/commonmark/node/Node;", "callBack", "Lkotlin/Function1;", "Lcom/larus/business/markdown/api/model/MarkwonPerformance;", "createMarkdownNode", Params.CONTENT, "createMarkdownWidget", "isLastNode", "rootNode", "viewGroup", "Landroid/view/ViewGroup;", "lastNode", "widgetHandlerList", "", "Lcom/larus/business/markdown/api/widget/IMarkdownWidgetHandler;", "createMarkdownWidgets", "markdownRootNode", "lastFinishedStatus", "lastNodeList", "forceUpdateAndIgnoreNew", "formatCopyText", "markdownContent", "getNodeReportName", CommonConsts.APM_INNER_EVENT_COST_INIT, "Landroid/app/Application;", "config", "Lcom/larus/business/markdown/api/depend/IMarkdownConfig;", "registerInjectParser", "injectParser", "Lio/noties/markwon/inject/IInjectParser;", "registerLinkResolver", "resolver", "Lkotlin/Function3;", "Landroid/view/View;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "view", "link", "isFromWiki", "Lcom/larus/business/markdown/api/depend/LinkResolverWithStyle;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MarkdownServiceImpl implements com.larus.business.markdown.api.a {
    private final Lazy markdownConfigManager$delegate;
    private ar<Unit> prepareDeferred;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1})
    public static final class a<T> implements Comparator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f5168a;

        public a(e r1) {
            this.f5168a = r1;
        }

        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            LeadingMarginSpan r5 = (LeadingMarginSpan) ZeusTransformUtils.preCheckCast(r4, LeadingMarginSpan.class, "com.obric.memorydata.plugin");
            Comparable r6 = (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(this.f5168a.a().getSpanStart(r5)), Comparable.class, "com.obric.memorydata.plugin");
            LeadingMarginSpan r7 = (LeadingMarginSpan) ZeusTransformUtils.preCheckCast(r3, LeadingMarginSpan.class, "com.obric.memorydata.plugin");
            return ComparisonsKt.compareValues(r6, (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(this.f5168a.a().getSpanStart(r7)), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.larus.business.markdown.impl.MarkdownServiceImpl$createMarkdownContent$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.larus.business.markdown.impl.MarkdownServiceImpl$createMarkdownContent$1", f = "MarkdownServiceImpl.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ ar<Unit> $deferred;
        int label;

        AnonymousClass1(ar<Unit> r3, Continuation<? super AnonymousClass1> r4) {
            ar<Unit> r5 = (ar) ZeusTransformUtils.wrapperContextForParams(r3, ar.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.$deferred = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$deferred, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            ar<Unit> r6 = this.$deferred;
            Continuation<? super Unit> r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r6.a(r2) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.business.markdown.impl.MarkdownServiceImpl$createMarkdownContent$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.larus.business.markdown.impl.MarkdownServiceImpl$createMarkdownContent$2", f = "MarkdownServiceImpl.kt", i = {}, l = {122}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ ar<Unit> $deferred;
        int label;

        AnonymousClass2(ar<Unit> r3, Continuation<? super AnonymousClass2> r4) {
            ar<Unit> r5 = (ar) ZeusTransformUtils.wrapperContextForParams(r3, ar.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.$deferred = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.$deferred, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            ar<Unit> r6 = this.$deferred;
            Continuation<? super Unit> r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r6.a(r2) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.business.markdown.impl.MarkdownServiceImpl$createMarkdownContentFromNode$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.larus.business.markdown.impl.MarkdownServiceImpl$createMarkdownContentFromNode$1", f = "MarkdownServiceImpl.kt", i = {}, l = {234}, m = "invokeSuspend", n = {}, s = {})
    static final class C09791 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ ar<Unit> $deferred;
        int label;

        C09791(ar<Unit> r3, Continuation<? super C09791> r4) {
            ar<Unit> r5 = (ar) ZeusTransformUtils.wrapperContextForParams(r3, ar.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.$deferred = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C09791(this.$deferred, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C09791) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C09791.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            ar<Unit> r6 = this.$deferred;
            Continuation<? super Unit> r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r6.a(r2) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.business.markdown.impl.MarkdownServiceImpl$createMarkdownNode$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.larus.business.markdown.impl.MarkdownServiceImpl$createMarkdownNode$1", f = "MarkdownServiceImpl.kt", i = {}, l = {149}, m = "invokeSuspend", n = {}, s = {})
    static final class C09801 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ ar<Unit> $deferred;
        int label;

        C09801(ar<Unit> r3, Continuation<? super C09801> r4) {
            ar<Unit> r5 = (ar) ZeusTransformUtils.wrapperContextForParams(r3, ar.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.$deferred = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C09801(this.$deferred, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C09801) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C09801.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            ar<Unit> r6 = this.$deferred;
            Continuation<? super Unit> r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r6.a(r2) != r0) goto L12;
            return r0;
        }
    }

    public MarkdownServiceImpl() {
        this.markdownConfigManager$delegate = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkdownServiceImpl$markdownConfigManager$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ com.larus.business.markdown.impl.common.a access$getMarkdownConfigManager(MarkdownServiceImpl r0) {
        return r0.getMarkdownConfigManager();
    }

    private final com.larus.business.markdown.impl.common.a getMarkdownConfigManager() {
        return (com.larus.business.markdown.impl.common.a) ZeusTransformUtils.preCheckCast(this.markdownConfigManager$delegate.getValue(), com.larus.business.markdown.impl.common.a.class, "com.obric.memorydata.plugin");
    }

    public void clearMarkdownDrawableCachePool() {
        getMarkdownConfigManager().d().a();
        getMarkdownConfigManager().e().a();
    }

    @Override // com.larus.business.markdown.api.a
    public com.larus.business.markdown.api.model.e createCacheMarkwonStruct(Context r3, Integer r4, c r5, Map<String, ? extends Object> r6, boolean r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r5, "customMarkDownInfo");
        com.larus.business.markdown.impl.common.a r2 = getMarkdownConfigManager();
        if (r7 == false) goto L5;
        g r10 = f.a(r8, r2, r4, r5, r9);
    L7:
        return (com.larus.business.markdown.api.model.e) ZeusTransformUtils.preCheckCast(r10, com.larus.business.markdown.api.model.e.class, "com.obric.memorydata.plugin");
    L5:
        r10 = f.b(r8, r2, r4, r5, r9);
        goto L7
    }

    @Override // com.larus.business.markdown.api.a
    public h createMarkdownContent(Context r15, int r16, String r17, boolean r18, c r19, com.larus.business.markdown.api.model.e r20, CharSequence r21, Map<String, ? extends Object> r22) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r15, Context.class, "com.obric.memorydata.plugin");
        com.larus.business.markdown.api.model.e r8 = (com.larus.business.markdown.api.model.e) ZeusTransformUtils.wrapperContextForParams(r20, com.larus.business.markdown.api.model.e.class, "com.obric.memorydata.plugin");
        CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r21, CharSequence.class, "com.obric.memorydata.plugin");
        Map<String, ? extends Object> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r22, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r17, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r19, "customMarkDownInfo");
        ar<Unit> r0 = this.prepareDeferred;     // Catch: Exception -> L12
        boolean r3 = false;
        if (r0 != null) goto L6;
    L8:
        if (r3 == false) goto L10;
        i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r0, null), Function2.class, "com.obric.memorydata.plugin"), 1, null);     // Catch: Exception -> L12
    L10:
        return (h) ZeusTransformUtils.preCheckCast(e.f5244a.a(r2, getMarkdownConfigManager(), r16, r17, r18, r19, r8, r9, r10), h.class, "com.obric.memorydata.plugin");
    L6:
        if (r0.q_() == true) goto L8;
        r3 = true;
    L12:
        e = move-exception;
        d r1 = com.larus.business.markdown.api.depend.e.a();
        if (r1 == null) goto L17;
        r1.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"), "[ErrorParseMd]text: " + r17);
    L17:
        return e.f5244a.a(getMarkdownConfigManager(), r17);
    }

    public h createMarkdownContent(com.larus.business.markdown.api.c.a.a r10, String r11, boolean r12, c r13, Map<String, ? extends Object> r14) {
        com.larus.business.markdown.api.c.a.a r4 = (com.larus.business.markdown.api.c.a.a) ZeusTransformUtils.wrapperContextForParams(r10, com.larus.business.markdown.api.c.a.a.class, "com.obric.memorydata.plugin");
        Map<String, ? extends Object> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r13, "customMarkDownInfo");
        ar<Unit> r15 = this.prepareDeferred;     // Catch: Exception -> L12
        boolean r0 = false;
        if (r15 != null) goto L6;
    L8:
        if (r0 == false) goto L10;
        i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r15, null), Function2.class, "com.obric.memorydata.plugin"), 1, null);     // Catch: Exception -> L12
    L10:
        return (h) ZeusTransformUtils.preCheckCast(e.f5244a.a(getMarkdownConfigManager(), r4, r11, r12, r13, r8), h.class, "com.obric.memorydata.plugin");
    L6:
        if (r15.q_() == true) goto L8;
        r0 = true;
    L12:
        e = move-exception;
        d r16 = com.larus.business.markdown.api.depend.e.a();
        if (r16 == null) goto L17;
        r16.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"), "[ErrorParseMd]text: " + r11);
    L17:
        return e.f5244a.a(getMarkdownConfigManager(), r11);
    }

    @Override // com.larus.business.markdown.api.a
    public h createMarkdownContentFromNode(Context r16, int r17, Node r18, boolean r19, c r20, CharSequence r21, Map<String, ? extends Object> r22, com.larus.business.markdown.api.model.e r23, Function1<? super com.larus.business.markdown.api.model.i, Unit> r24) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r16, Context.class, "com.obric.memorydata.plugin");
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r21, CharSequence.class, "com.obric.memorydata.plugin");
        Map<String, ? extends Object> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r22, Map.class, "com.obric.memorydata.plugin");
        com.larus.business.markdown.api.model.e r10 = (com.larus.business.markdown.api.model.e) ZeusTransformUtils.wrapperContextForParams(r23, com.larus.business.markdown.api.model.e.class, "com.obric.memorydata.plugin");
        Function1<? super com.larus.business.markdown.api.model.i, Unit> r11 = (Function1) ZeusTransformUtils.wrapperContextForParams(r24, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r18, "node");
        Intrinsics.checkNotNullParameter(r20, "customMarkDownInfo");
        ar<Unit> r0 = this.prepareDeferred;     // Catch: Exception -> L12
        boolean r3 = false;
        if (r0 != null) goto L6;
    L8:
        if (r3 == false) goto L10;
        i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new C09791(r0, null), Function2.class, "com.obric.memorydata.plugin"), 1, null);     // Catch: Exception -> L12
    L10:
        return (h) ZeusTransformUtils.preCheckCast(e.f5244a.a(r2, getMarkdownConfigManager(), r17, r18, r19, r20, r8, r9, r10, r11), h.class, "com.obric.memorydata.plugin");
    L6:
        if (r0.q_() == true) goto L8;
        r3 = true;
    L12:
        e = move-exception;
        d r1 = com.larus.business.markdown.api.depend.e.a();
        if (r1 == null) goto L17;
        r1.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"), "[ErrorParseMd]node: " + r18);
    L17:
        return e.f5244a.a(getMarkdownConfigManager(), "");
    }

    @Override // com.larus.business.markdown.api.a
    public Node createMarkdownNode(Context r12, String r13, boolean r14, c r15, com.larus.business.markdown.api.model.e r16, Function1<? super com.larus.business.markdown.api.model.i, Unit> r17) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
        com.larus.business.markdown.api.model.e r9 = (com.larus.business.markdown.api.model.e) ZeusTransformUtils.wrapperContextForParams(r16, com.larus.business.markdown.api.model.e.class, "com.obric.memorydata.plugin");
        Function1<? super com.larus.business.markdown.api.model.i, Unit> r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r17, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r13, Params.CONTENT);
        ar<Unit> r5 = this.prepareDeferred;     // Catch: Exception -> L12
        boolean r7 = false;
        if (r5 != null) goto L6;
    L8:
        if (r7 == false) goto L10;
        i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new C09801(r5, null), Function2.class, "com.obric.memorydata.plugin"), 1, null);     // Catch: Exception -> L12
    L10:
        return e.f5244a.a(r4, getMarkdownConfigManager(), b.f5175a.a(r13, r14), r14, r15, r9, r10);
    L6:
        if (r5.q_() == true) goto L8;
        r7 = true;
    L12:
        e = move-exception;
        d r3 = com.larus.business.markdown.api.depend.e.a();
        if (r3 == null) goto L17;
        r3.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"), "createMarkdownNode");
    L17:
        return (Node) ZeusTransformUtils.preCheckCast(null, Node.class, "com.obric.memorydata.plugin");
    }

    public void createMarkdownWidget(Context r11, int r12, boolean r13, Node r14, ViewGroup r15, Node r16, List<? extends com.larus.business.markdown.api.d.b> r17) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        List<? extends com.larus.business.markdown.api.d.b> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r14, "rootNode");
        Intrinsics.checkNotNullParameter(r15, "viewGroup");
        MarkdownMultiWidgetHelper.f5267a.a(r3, r12, r13, r14, r15, r16, r9);
    }

    public List<Node> createMarkdownWidgets(Context r16, int r17, Node r18, boolean r19, boolean r20, c r21, ViewGroup r22, List<? extends Node> r23, List<? extends com.larus.business.markdown.api.d.b> r24, boolean r25, com.larus.business.markdown.api.model.e r26) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r16, Context.class, "com.obric.memorydata.plugin");
        List<? extends Node> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r23, List.class, "com.obric.memorydata.plugin");
        List<? extends com.larus.business.markdown.api.d.b> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r24, List.class, "com.obric.memorydata.plugin");
        com.larus.business.markdown.api.model.e r12 = (com.larus.business.markdown.api.model.e) ZeusTransformUtils.wrapperContextForParams(r26, com.larus.business.markdown.api.model.e.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r18, "markdownRootNode");
        Intrinsics.checkNotNullParameter(r21, "customMarkDownInfo");
        Intrinsics.checkNotNullParameter(r22, "viewGroup");
        List<Node> r14 = com.larus.business.markdown.impl.widget.a.f5269a.a(r18, r21);
        com.larus.business.markdown.impl.widget.a.f5269a.a(getMarkdownConfigManager(), r3, r17, r14, r5, r19, r20, r21, r22, r10, r25, r12, r18.originText);
        return r14;
    }

    public String formatCopyText(h r8) {
        h r7 = (h) ZeusTransformUtils.wrapperContextForParams(r8, h.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "markdownContent");
        SpannableStringBuilder r9 = r7.a();
        int r1 = r9.length();
        StringBuilder r2 = new StringBuilder(r9.subSequence(0, r1));
        if (ZeusTransformUtils.instanceOf(r7, e.class) == false) goto L5;
        e r10 = (e) ZeusTransformUtils.preCheckCast(r7, e.class, "com.obric.memorydata.plugin");
    L6:
        if (r10 == null) goto L28;
        Object[] r11 = ((Spanned) ZeusTransformUtils.preCheckCast(r10.a(), Spanned.class, "com.obric.memorydata.plugin")).getSpans(0, r9.length(), LeadingMarginSpan.class);
        Intrinsics.checkExpressionValueIsNotNull(r11, "getSpans(start, end, T::class.java)");
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(ArraysKt.toList(r11), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new a(r10), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L9:
        if (r12.hasNext() == false) goto L28;
        LeadingMarginSpan r4 = (LeadingMarginSpan) ZeusTransformUtils.preCheckCast(r12.next(), LeadingMarginSpan.class, "com.obric.memorydata.plugin");
        boolean r6 = true;
        if (ZeusTransformUtils.instanceOf(r4, p.class) == true) goto L12;
        if (ZeusTransformUtils.instanceOf(r4, io.noties.markwon.core.spans.d.class) == false) goto L9;
        int r5 = r10.a().getSpanStart(r4);
        if (r5 < 0) goto L25;
        if (r5 >= r1) goto L25;
    L26:
        if (r6 == false) goto L9;
        r2.insert(r5 + 0, "- ");
    L25:
        r6 = false;
        goto L26
    L12:
        int r13 = r10.a().getSpanStart(r4);
        if (r13 < 0) goto L16;
        if (r13 >= r1) goto L16;
    L17:
        if (r6 == false) goto L9;
        r2.insert(r13 + 0, ((p) ZeusTransformUtils.preCheckCast(r4, p.class, "com.obric.memorydata.plugin")).g);
    L16:
        r6 = false;
    L28:
        String r14 = r2.toString();
        Intrinsics.checkNotNullExpressionValue(r14, "copyText.toString()");
        return StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L5:
        r10 = null;
        goto L6
    }

    public String getNodeReportName(Node r1) {
        Intrinsics.checkNotNullParameter(r1, "node");
        return com.larus.business.markdown.impl.markwon.d.f5242a.a(r1);
    }

    @Override // com.larus.business.markdown.api.a
    public void init(Application r11, com.larus.business.markdown.api.depend.c r12) {
        Application r13 = (Application) ZeusTransformUtils.wrapperContextForParams(r11, Application.class, "com.obric.memorydata.plugin");
        com.larus.business.markdown.api.depend.c r14 = (com.larus.business.markdown.api.depend.c) ZeusTransformUtils.wrapperContextForParams(r12, com.larus.business.markdown.api.depend.c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r14, "config");
        com.larus.business.markdown.api.a.f5138a.a(r13);
        getMarkdownConfigManager().a(r14);
        b r0 = b.f5175a;
        com.larus.business.markdown.api.depend.h r2 = r14.a();
        if (r2 == null) goto L5;
        j r3 = r2.p();
    L6:
        r0.a(r3);
        if (this.prepareDeferred == null) goto L19;
        return;
    L19:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        this.prepareDeferred = i.b(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new MarkdownServiceImpl$init$1$1(r13, r14, this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);     // Catch: Throwable -> L11
        Object r10 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r15 = Result.m1424exceptionOrNullimpl(r10);
        if (r15 == null) goto L21;
        d r16 = com.larus.business.markdown.api.a.f5138a.c();
        if (r16 == null) goto L22;
        r16.a(r15, "latexPluginDelegate init");
        return;
    L22:
        return;
    L21:
        return;
    L11:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L13
    L5:
        r3 = null;
        goto L6
    }

    public void registerInjectParser(io.noties.markwon.b.a r3) {
        io.noties.markwon.b.a r4 = (io.noties.markwon.b.a) ZeusTransformUtils.wrapperContextForParams(r3, io.noties.markwon.b.a.class, "com.obric.memorydata.plugin");
        getMarkdownConfigManager().a(r4);
    }

    @Override // com.larus.business.markdown.api.a
    public void registerLinkResolver(com.larus.business.markdown.api.depend.i r3) {
        com.larus.business.markdown.api.depend.i r4 = (com.larus.business.markdown.api.depend.i) ZeusTransformUtils.wrapperContextForParams(r3, com.larus.business.markdown.api.depend.i.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "resolver");
        getMarkdownConfigManager().a(r4);
    }

    public void registerLinkResolver(Function3<? super View, ? super String, ? super Boolean, Unit> r3) {
        Function3<? super View, ? super String, ? super Boolean, Unit> r4 = (Function3) ZeusTransformUtils.wrapperContextForParams(r3, Function3.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "resolver");
        getMarkdownConfigManager().a(r4);
    }
}
