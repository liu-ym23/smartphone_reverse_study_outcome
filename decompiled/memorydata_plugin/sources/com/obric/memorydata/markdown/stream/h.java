package com.obric.memorydata.markdown.stream;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.util.Patterns;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.larus.business.markdown.impl.markwon.MarkdownTextView;
import com.obric.memorydata.markdown.custom.MarkdownKeyReplacer;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.core.spans.CustomLinkSpan;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.ah;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.cu;
import org.commonmark.node.Node;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 72\u00020\u0001:\u000278B7\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010\"\u001a\u00020 2\b\b\u0002\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020 J6\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020\n2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u000e2\u001a\b\u0002\u0010)\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00100\tJb\u0010&\u001a\u0004\u0018\u00010\u001a2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00132\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020.2\b\b\u0002\u00100\u001a\u0002012\n\b\u0002\u00102\u001a\u0004\u0018\u0001032\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u00104\u001a\u000205J\u0006\u00106\u001a\u00020 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/obric/memorydata/markdown/stream/MarkdownTextViewUpdater;", "", "targetView", "Landroid/widget/TextView;", "renderStrategy", "Lcom/obric/memorydata/markdown/stream/RenderStrategy;", "customInfo", "Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "payload", "", "", "<init>", "(Landroid/widget/TextView;Lcom/obric/memorydata/markdown/stream/RenderStrategy;Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;Ljava/util/Map;)V", "struct", "Lcom/larus/business/markdown/api/model/IMarkwonStruct;", "lastNodeList", "", "Lorg/commonmark/node/Node;", "viewScope", "Lkotlinx/coroutines/CoroutineScope;", "getViewScope", "()Lkotlinx/coroutines/CoroutineScope;", "cursorManager", "Lcom/obric/memorydata/markdown/stream/BlinkingCursorManager;", "activeJob", "Ljava/util/concurrent/atomic/AtomicReference;", "Lkotlinx/coroutines/Job;", "typewriterJob", "isFirstRender", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isReleased", "resetRenderState", "", "blinkJob", "blink", "cursorConfig", "Lcom/obric/memorydata/markdown/stream/StreamingCursorConfig;", "stopBlink", "render", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "externalStruct", "keyInfoMap", AILabCheckPermissionTask.KEY_SOURCE, "Lcom/obric/memorydata/markdown/stream/StreamSource;", "scope", "timeoutMs", "", "typewriterDelayMs", "chunkSize", "", "hook", "Lcom/obric/memorydata/markdown/stream/StreamingCallbackHook;", "firstRenderAll", "", "release", "Companion", "MarkdownTextViewStrategy", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10021a = null;
    private static final Regex n = null;
    private static final Regex o = null;
    private static final Regex p = null;
    private static final Regex q = null;
    private static final Regex r = null;
    private static final Regex s = null;
    private static final char[] t = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextView f10022b;
    private final j c;
    private final com.larus.business.markdown.api.model.c d;
    private final Map<String, Object> e;
    private volatile com.larus.business.markdown.api.model.e f;
    private volatile List<? extends Node> g;
    private final al h;
    private com.obric.memorydata.markdown.stream.a i;
    private final AtomicReference<bx> j;
    private final AtomicReference<bx> k;
    private final AtomicBoolean l;
    private final AtomicBoolean m;

    @Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016H\u0007J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J<\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0011\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u001a\b\u0002\u0010%\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050&0\u0016H\u0002J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050&2\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J\u001e\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\u00052\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00050+H\u0002J&\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u001d2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00050+H\u0002J$\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00050&2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00050&2\u0006\u00101\u001a\u00020\u001dH\u0002J\u0010\u00102\u001a\u00020\u001b2\u0006\u00103\u001a\u00020\u001bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/obric/memorydata/markdown/stream/MarkdownTextViewUpdater$Companion;", "", "<init>", "()V", "TAG", "", "OL_REGEX", "Lkotlin/text/Regex;", "HL_REGEX", "BQ_REGEX", "UL_REGEX", "HR_REGEX", "FENCE_REGEX", "INLINE_SPECIALS", "", "bind", "Lcom/obric/memorydata/markdown/stream/MarkdownTextViewUpdater;", "textView", "Lcom/larus/business/markdown/impl/markwon/MarkdownTextView;", "customInfo", "Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "payload", "", "sourceFlowFromText", "Lcom/obric/memorydata/markdown/stream/StreamSources$FlowSource;", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "delayMs", "", "chunkSize", "", "postRender", "", "Landroid/widget/TextView;", "markdown", "Landroid/text/SpannableStringBuilder;", "finished", "", "keyInfoMap", "", "tokenizeMarkdown", "tokenizeLine", "line", "out", "", "tokenizeInline", "s", "startIdx", "groupTokens", "tokens", "size", "computeTimeoutMillis", "hint", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        private final long a(long r7) {
            return RangesKt.coerceIn(r7, 30000, 600000);
        }

        public static final /* synthetic */ long a(a r0, long r1) {
            return r0.a(r1);
        }

        public static /* synthetic */ h a(a r38, MarkdownTextView r39, com.larus.business.markdown.api.model.c r40, Map r41, int r42, Object r43) {
            Map<String, ? extends Object> r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r41, Map.class, "com.obric.memorydata.plugin");
            if ((r42 & 2) == 0) goto L5;
            com.larus.business.markdown.api.model.c r1 = new com.larus.business.markdown.api.model.c(0, null, null, null, false, false, null, 0, 0, null, 0.0f, null, 0, 0, null, Integer.valueOf(MathKt.roundToInt(TypedValue.applyDimension(2, 8, Resources.getSystem().getDisplayMetrics()))), Integer.valueOf(MathKt.roundToInt(TypedValue.applyDimension(2, 4, Resources.getSystem().getDisplayMetrics()))), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -98305, null);
        L7:
            if ((r42 & 4) == 0) goto L10;
            r0 = null;
        L10:
            return r38.a(r39, r1, r0);
        L5:
            r1 = r40;
            goto L7
        }

        public static final /* synthetic */ List a(a r0, String r1) {
            return r0.a(r1);
        }

        public static final /* synthetic */ List a(a r2, List r3, int r4) {
            return r2.a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
        }

        private final List<String> a(String r12) {
            int r3 = 0;
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == true) goto L8;
            ArrayList r1 = new ArrayList(r12.length() / 4);
            int r4 = r12.length();
        L10:
            if (r3 >= r4) goto L16;
            int r5 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin"), '\n', r3, false, 4, null);
            if (r5 >= 0) goto L14;
            r5 = r4;
        L14:
            String r6 = r12.substring(r3, r5);
            Intrinsics.checkNotNullExpressionValue(r6, "substring(...)");
            a(r6, (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"));
            r1.add("\n");
            r3 = r5 + 1;
            goto L10
        L16:
            return (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
        L8:
            return CollectionsKt.emptyList();
        L5:
            r0 = false;
            goto L6
        }

        private final List<String> a(List<String> r8, int r9) {
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
            if (r7.isEmpty() == true) goto L5;
            boolean r2 = true;
            ArrayList r10 = new ArrayList(((r7.size() + r9) - 1) / r9);
            StringBuilder r1 = new StringBuilder();
            Iterator r11 = r7.iterator();
        L7:
            int r4 = 0;
        L9:
            if (r11.hasNext() == false) goto L14;
            r1.append((String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin"));
            r4 = r4 + 1;
            if (r4 < r9) goto L9;
            r10.add(r1.toString());
            r1.setLength(0);
            goto L7
        L14:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L17;
            r2 = false;
        L17:
            if (r2 == false) goto L20;
            r10.add(r1.toString());
        L20:
            return (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin");
        L5:
            return CollectionsKt.emptyList();
        }

        private final void a(TextView r12, SpannableStringBuilder r13, boolean r14, Map<String, ? extends List<String>> r15) {
            Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.memorydata.plugin");
            int r2 = 0;
            CustomLinkSpan[] r16 = (CustomLinkSpan[]) ZeusTransformUtils.preCheckCast(r13.getSpans(0, r13.length(), CustomLinkSpan.class), CustomLinkSpan[].class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNull(r16);
            int r1 = r16.length;
        L3:
            if (r2 >= r1) goto L8;
            CustomLinkSpan r3 = r16[r2];
            if (Patterns.WEB_URL.matcher((CharSequence) ZeusTransformUtils.preCheckCast(r3.getURL(), CharSequence.class, "com.obric.memorydata.plugin")).matches() == false) goto L7;
            r13.removeSpan(r3);
            RunLog.INSTANCE.debug("MarkdownViewUpdater", "remove span: " + r3);
        L7:
            r2 = r2 + 1;
            goto L3
        L8:
            List<String> r4 = (List) ZeusTransformUtils.preCheckCast(r11.getOrDefault("url", CollectionsKt.emptyList()), List.class, "com.obric.memorydata.plugin");
            float r17 = 1;
            com.obric.memorydata.markdown.custom.k.f9995a.a((Spannable) ZeusTransformUtils.preCheckCast(r13, Spannable.class, "com.obric.memorydata.plugin"), r4, Integer.valueOf(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, TypedValues.Custom.S_COLOR, "oui_basic_text_1"))), MathKt.roundToInt(TypedValue.applyDimension(1, r17, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r17, Resources.getSystem().getDisplayMetrics())), Integer.valueOf(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, TypedValues.Custom.S_COLOR, "oui_basic_text_1"))), false);
            r12.setText((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin"));
            if (r14 == false) goto L15;
            s.b(r12, new r(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r12.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, TypedValues.Custom.S_COLOR, "oui_basic_text_1")), MathKt.roundToInt(TypedValue.applyDimension(1, r17, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r17, Resources.getSystem().getDisplayMetrics()))));
            return;
        }

        public static final /* synthetic */ void a(a r2, TextView r3, SpannableStringBuilder r4, boolean r5, Map r6) {
            r2.a(r3, r4, r5, (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin"));
        }

        private final void a(String r5, int r6, List<String> r7) {
            List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
            int r8 = r5.length();
        L3:
            if (r6 >= r8) goto L38;
            char r0 = r5.charAt(r6);
            if (CharsKt.isWhitespace(r0) == true) goto L6;
            if (ArraysKt.contains(h.h(), r0) == true) goto L9;
            int r1 = r6;
        L31:
            if (r1 >= r8) goto L37;
            if (CharsKt.isWhitespace(r5.charAt(r1)) == true) goto L37;
            if (ArraysKt.contains(h.h(), r5.charAt(r1)) == true) goto L37;
            r1 = r1 + 1;
        L37:
            String r9 = r5.substring(r6, r1);
            Intrinsics.checkNotNullExpressionValue(r9, "substring(...)");
            r4.add(r9);
            r6 = r1;
            goto L3
        L9:
            int r2 = r6 + 1;
            if (r2 < r8) goto L12;
        L17:
            if (r2 < r8) goto L19;
        L23:
            if (r2 >= r8) goto L29;
            if (r0 != '!') goto L29;
            if (r5.charAt(r2) != '[') goto L29;
            String r3 = "![";
        L16:
            r4.add(r3);
            r6 = r6 + 2;
        L29:
            r4.add(String.valueOf(r0));
            r6 = r2;
            goto L3
        L19:
            if (r0 != '_') goto L23;
            if (r5.charAt(r2) != '_') goto L23;
            r3 = "__";
            goto L16
        L12:
            if (r0 != '*') goto L17;
            if (r5.charAt(r2) != '*') goto L17;
            r3 = "**";
            goto L16
        L6:
            r4.add(String.valueOf(r0));
            r6 = r6 + 1;
            goto L3
        }

        private final void a(String r7, List<String> r8) {
            List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
            MatchResult r0 = Regex.find$default(h.c(), (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), 0, 2, null);
            if (r0 == null) goto L6;
            r9.add(r0.getValue());
            h.f10021a.a(r7, r0.getValue().length(), r9);
            return;
        L6:
            MatchResult r1 = Regex.find$default(h.d(), (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), 0, 2, null);
            if (r1 == null) goto L11;
            r9.add(r1.getValue());
            h.f10021a.a(r7, r1.getValue().length(), r9);
            return;
        L11:
            if (StringsKt.startsWith$default(r7, "> ", false, 2, null) == false) goto L14;
            r9.add("> ");
            a(r7, 2, r9);
            return;
        L14:
            MatchResult r2 = Regex.find$default(h.e(), (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), 0, 2, null);
            if (r2 == null) goto L19;
            r9.add(r2.getValue());
            h.f10021a.a(r7, r2.getValue().length(), r9);
            return;
        L19:
            if (h.f().matches((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L21;
        L25:
            r9.add(r7);
            return;
        L21:
            if (h.g().matches((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L25;
            a(r7, 0, r9);
        }

        @JvmStatic
        public final h a(MarkdownTextView r8, com.larus.business.markdown.api.model.c r9, Map<String, ? extends Object> r10) {
            Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, "textView");
            Intrinsics.checkNotNullParameter(r9, "customInfo");
            b r7 = new b(r9, r5);
            return new h((TextView) ZeusTransformUtils.preCheckCast(r8, TextView.class, "com.obric.memorydata.plugin"), (j) ZeusTransformUtils.preCheckCast(r7, j.class, "com.obric.memorydata.plugin"), r9, r5, null);
        }
    }

    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJD\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00150\u0005H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J2\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\u001f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/memorydata/markdown/stream/MarkdownTextViewUpdater$MarkdownTextViewStrategy;", "Lcom/obric/memorydata/markdown/stream/RenderStrategy;", "customInfo", "Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "payload", "", "", "", "<init>", "(Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;Ljava/util/Map;)V", "struct", "Lcom/larus/business/markdown/api/model/IMarkwonStruct;", "render", "", "textView", "Landroid/widget/TextView;", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "finished", "", "externalStruct", "keyInfoMap", "", "renderToSpanned", "", "ensureStruct", "service", "Lcom/larus/business/markdown/api/MarkdownService;", "ctx", "Landroid/content/Context;", "maxWidth", "", "release", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.larus.business.markdown.api.model.c f10024a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<String, Object> f10025b;
        private volatile com.larus.business.markdown.api.model.e c;

        public b(com.larus.business.markdown.api.model.c r3, Map<String, ? extends Object> r4) {
            Map<String, Object> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "customInfo");
            this.f10024a = r3;
            this.f10025b = r5;
        }

        private final void a(com.larus.business.markdown.api.a r9, Context r10, int r11, boolean r12, com.larus.business.markdown.api.model.e r13) {
            com.larus.business.markdown.api.a r2 = (com.larus.business.markdown.api.a) ZeusTransformUtils.wrapperContextForParams(r9, com.larus.business.markdown.api.a.class, "com.obric.memorydata.plugin");
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
            com.larus.business.markdown.api.model.e r14 = (com.larus.business.markdown.api.model.e) ZeusTransformUtils.wrapperContextForParams(r13, com.larus.business.markdown.api.model.e.class, "com.obric.memorydata.plugin");
            if (r14 == null) goto L7;
            this.c = r14;
            return;
        L7:
            if (this.c != null) goto L10;
            this.c = r2.createCacheMarkwonStruct(r3, Integer.valueOf(r11), this.f10024a, this.f10025b, r12);
            return;
        }

        @Override // com.obric.memorydata.markdown.stream.j
        public void a() {
            this.c = null;
        }

        @Override // com.obric.memorydata.markdown.stream.j
        public void a(TextView r23, String r24, boolean r25, com.larus.business.markdown.api.model.e r26, Map<String, ? extends List<String>> r27) {
            com.larus.business.markdown.api.model.e r5 = (com.larus.business.markdown.api.model.e) ZeusTransformUtils.wrapperContextForParams(r26, com.larus.business.markdown.api.model.e.class, "com.obric.memorydata.plugin");
            Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r27, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r23, "textView");
            Intrinsics.checkNotNullParameter(r24, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
            Intrinsics.checkNotNullParameter(r9, "keyInfoMap");
            if (ZeusTransformUtils.instanceOf(r23, MarkdownTextView.class) == true) goto L6;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MarkdownViewUpdater", "MarkdownTextViewStrategy requires MarkdownTextView", null, 4, null);
            return;
        L6:
            com.larus.business.markdown.api.a r19 = com.obric.memorydata.markdown.a.f9973a.b();
            if (r19 != null) goto L9;
            return;
        L9:
            Context r20 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((MarkdownTextView) ZeusTransformUtils.preCheckCast(r23, MarkdownTextView.class, "com.obric.memorydata.plugin")).getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            int r21 = ((MarkdownTextView) ZeusTransformUtils.preCheckCast(r23, MarkdownTextView.class, "com.obric.memorydata.plugin")).getMarkdownWidth();
            Intrinsics.checkNotNull(r20);
            a(r19, r20, r21, r25, r5);
            Node r13 = com.larus.business.markdown.api.a.b.a(r19, r20, r24, r25, this.f10024a, this.c, null, 32, null);
            if (r13 != null) goto L12;
            return;
        L12:
            com.larus.business.markdown.api.model.h r0 = com.larus.business.markdown.api.a.b.a(r19, r20, r21, r13, r25, this.f10024a, ((MarkdownTextView) ZeusTransformUtils.preCheckCast(r23, MarkdownTextView.class, "com.obric.memorydata.plugin")).getText(), this.f10025b, this.c, null, 256, null);
            a.a(h.f10021a, r23, r0.a(), r25, r9);
        }
    }

    static {
        f10021a = new a(null);
        n = new Regex("^\\s{0,3}(\\d+)([.)]) ");
        o = new Regex("^\\s{0,3}(#{1,6}) ");
        p = new Regex("^> ");
        q = new Regex("^(- |\\* )");
        r = new Regex("^(---|\\*\\*\\*|___)\\s*$");
        s = new Regex("^```.*");
        t = new char[]{'*', '_', '`', '[', ']', '(', ')', 65288, 65289, '!', '|'};
    }

    private h(TextView r4, j r5, com.larus.business.markdown.api.model.c r6, Map<String, ? extends Object> r7) {
        j r8 = (j) ZeusTransformUtils.wrapperContextForParams(r5, j.class, "com.obric.memorydata.plugin");
        Map<String, Object> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        this.f10022b = r4;
        this.c = r8;
        this.d = r6;
        this.e = r9;
        this.h = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.b().a(), CoroutineContext.class, "com.obric.memorydata.plugin")).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")));
        this.j = new AtomicReference(null);
        this.k = new AtomicReference(null);
        this.l = new AtomicBoolean(true);
        this.m = new AtomicBoolean(false);
        r4.addOnAttachStateChangeListener((View.OnAttachStateChangeListener) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), View.OnAttachStateChangeListener.class, "com.obric.memorydata.plugin"));
    }

    public /* synthetic */ h(TextView r2, j r3, com.larus.business.markdown.api.model.c r4, Map r5, DefaultConstructorMarker r6) {
        this(r2, (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin"), r4, (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ j a(h r0) {
        return r0.c;
    }

    public static /* synthetic */ bx a(h r12, l r13, al r14, long r15, long r17, int r19, o r20, com.larus.business.markdown.api.model.e r21, p r22, boolean r23, int r24, Object r25) {
        l r1 = (l) ZeusTransformUtils.wrapperContextForParams(r13, l.class, "com.obric.memorydata.plugin");
        al r3 = (al) ZeusTransformUtils.wrapperContextForParams(r14, al.class, "com.obric.memorydata.plugin");
        o r4 = (o) ZeusTransformUtils.wrapperContextForParams(r20, o.class, "com.obric.memorydata.plugin");
        com.larus.business.markdown.api.model.e r2 = (com.larus.business.markdown.api.model.e) ZeusTransformUtils.wrapperContextForParams(r21, com.larus.business.markdown.api.model.e.class, "com.obric.memorydata.plugin");
        if ((r24 & 4) == 0) goto L5;
        long r5 = 60000;
    L7:
        if ((r24 & 8) == 0) goto L9;
        long r7 = 16;
    L11:
        if ((r24 & 16) == 0) goto L13;
        int r9 = 1;
    L15:
        if ((r24 & 32) == 0) goto L18;
        r4 = null;
    L18:
        if ((r24 & 64) == 0) goto L21;
        r2 = null;
    L21:
        if ((r24 & 128) == 0) goto L23;
        p r10 = p.f10032a.a();
    L25:
        if ((r24 & 256) == 0) goto L27;
        boolean r0 = false;
    L29:
        return r12.a(r1, r3, r5, r7, r9, r4, r2, r10, r0);
    L27:
        r0 = r23;
        goto L29
    L23:
        r10 = r22;
        goto L25
    L13:
        r9 = r19;
        goto L15
    L9:
        r7 = r17;
        goto L11
    L5:
        r5 = r15;
        goto L7
    }

    public static /* synthetic */ void a(h r1, String r2, com.larus.business.markdown.api.model.e r3, Map r4, int r5, Object r6) {
        com.larus.business.markdown.api.model.e r7 = (com.larus.business.markdown.api.model.e) ZeusTransformUtils.wrapperContextForParams(r3, com.larus.business.markdown.api.model.e.class, "com.obric.memorydata.plugin");
        Map<String, ? extends List<String>> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r7 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r8 = MapsKt.emptyMap();
    L8:
        r1.a(r2, r7, r8);
    }

    public static final /* synthetic */ TextView b(h r0) {
        return r0.f10022b;
    }

    public static final /* synthetic */ Regex c() {
        return o;
    }

    public static final /* synthetic */ Regex d() {
        return n;
    }

    public static final /* synthetic */ Regex e() {
        return q;
    }

    public static final /* synthetic */ Regex f() {
        return r;
    }

    public static final /* synthetic */ Regex g() {
        return s;
    }

    public static final /* synthetic */ char[] h() {
        return t;
    }

    private final void i() {
        bx r0 = (bx) ZeusTransformUtils.preCheckCast(this.j.getAndSet(null), bx.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        bx.a.a(r0, null, 1, null);
    L5:
        bx r1 = (bx) ZeusTransformUtils.preCheckCast(this.k.getAndSet(null), bx.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L8;
        bx.a.a(r1, null, 1, null);
    L8:
        com.obric.memorydata.markdown.stream.a r2 = this.i;
        if (r2 == null) goto L11;
        r2.a();
    L11:
        this.i = null;
        this.l.set(true);
    }

    public final al a() {
        return this.h;
    }

    public final bx a(l r20, al r21, long r22, long r24, int r26, o r27, com.larus.business.markdown.api.model.e r28, p r29, boolean r30) {
        l r1 = (l) ZeusTransformUtils.wrapperContextForParams(r20, l.class, "com.obric.memorydata.plugin");
        al r3 = (al) ZeusTransformUtils.wrapperContextForParams(r21, al.class, "com.obric.memorydata.plugin");
        o r11 = (o) ZeusTransformUtils.wrapperContextForParams(r27, o.class, "com.obric.memorydata.plugin");
        com.larus.business.markdown.api.model.e r12 = (com.larus.business.markdown.api.model.e) ZeusTransformUtils.wrapperContextForParams(r28, com.larus.business.markdown.api.model.e.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r3, "scope");
        Intrinsics.checkNotNullParameter(r29, "cursorConfig");
        if ((!this.m.get()) == false) goto L10;
        i();
        bx r2 = kotlinx.coroutines.i.a(this.h, null, null, (Function2) ZeusTransformUtils.preCheckCast(new MarkdownTextViewUpdater$render$job$1(r3, new MarkdownStreamEngine(r1, a.a(f10021a, r22), (n) ZeusTransformUtils.preCheckCast(new e(this.f10022b, this.c, r26, r24, r11, r12, r29, this.l, this.k, this.h, this.m, r30), n.class, "com.obric.memorydata.plugin"), (ah) ZeusTransformUtils.preCheckCast(ba.b(), ah.class, "com.obric.memorydata.plugin"), null, 16, null), null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        if (this.j.compareAndSet(null, r2) == true) goto L8;
        bx.a.a(r2, null, 1, null);
        return (bx) ZeusTransformUtils.preCheckCast(this.j.get(), bx.class, "com.obric.memorydata.plugin");
    L8:
        return r2;
    L10:
        throw new IllegalStateException("Updater has been released".toString());
    }

    public final void a(String r18, com.larus.business.markdown.api.model.e r19, Map<String, ? extends List<String>> r20) {
        com.larus.business.markdown.api.model.e r7 = (com.larus.business.markdown.api.model.e) ZeusTransformUtils.wrapperContextForParams(r19, com.larus.business.markdown.api.model.e.class, "com.obric.memorydata.plugin");
        Map<String, ? extends List<String>> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r18, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r1, "keyInfoMap");
        if ((!this.m.get()) == false) goto L7;
        i();
        this.c.a(this.f10022b, MarkdownKeyReplacer.a(MarkdownKeyReplacer.f9975a, r18, r1, false, false, null, false, 52, null).a(), true, r7, r1);
        return;
    L7:
        throw new IllegalStateException("Updater has been released".toString());
    }

    public final void b() {
        if (this.m.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        bx r0 = (bx) ZeusTransformUtils.preCheckCast(this.k.getAndSet(null), bx.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L8;
        bx.a.a(r0, null, 1, null);
    L8:
        bx r1 = (bx) ZeusTransformUtils.preCheckCast(this.j.getAndSet(null), bx.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L11;
        bx.a.a(r1, null, 1, null);
    L11:
        com.obric.memorydata.markdown.stream.a r2 = this.i;
        if (r2 == null) goto L14;
        r2.a();
    L14:
        this.i = null;
        am.a(this.h, null, 1, null);
        this.f = null;
        this.g = null;
        this.c.a();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MarkdownViewUpdater", "MarkdownViewUpdater released", false, 4, null);
    }
}
