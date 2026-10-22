package com.larus.business.markdown.impl.markwon;

import android.app.Application;
import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.commonmark.node.Node;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 X2\u00020\u0001:\u0001XB}\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012(\b\u0002\u0010\u000e\u001a\"\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000fj\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005¢\u0006\u0002\u0010\u0014J*\u00108\u001a\u000209\"\u0004\b\u0000\u0010:2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020=0<2\f\u0010>\u001a\b\u0012\u0004\u0012\u0002H:0?H\u0002J\u0010\u0010@\u001a\u0002092\u0006\u0010A\u001a\u00020\u0017H\u0016J\u0010\u0010B\u001a\u0002092\u0006\u0010A\u001a\u00020\u0017H\u0016J\u0010\u0010C\u001a\u0002092\u0006\u0010A\u001a\u00020\u0017H\u0016J.\u0010D\u001a\u0002092\u0006\u0010E\u001a\u00020\u00102\u0006\u0010F\u001a\u00020\u00102\f\u0010G\u001a\b\u0012\u0004\u0012\u0002090H2\u0006\u0010I\u001a\u00020JH\u0016J\u000e\u0010K\u001a\b\u0012\u0004\u0012\u00020L0\u0018H\u0016J\u000e\u0010M\u001a\b\u0012\u0004\u0012\u00020N0\u0018H\u0016J\u000e\u0010O\u001a\b\u0012\u0004\u0012\u00020P0\u0018H\u0016J\u001a\u0010Q\u001a\u0002092\u0006\u0010A\u001a\u00020\u00172\b\u0010R\u001a\u0004\u0018\u00010SH\u0016J\u001a\u0010T\u001a\u0002092\u0006\u0010A\u001a\u00020\u00172\b\u0010R\u001a\u0004\u0018\u00010UH\u0016J\u001a\u0010V\u001a\u0002092\u0006\u0010A\u001a\u00020\u00172\b\u0010R\u001a\u0004\u0018\u00010WH\u0016R \u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00180\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR!\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00100\u00188VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"R\u0014\u0010\u0013\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u001dR\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0016\u0010\f\u001a\u0004\u0018\u00010\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0016\u0010\b\u001a\u0004\u0018\u00010\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R4\u0010\u000e\u001a\"\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000fj\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u001b\u00101\u001a\u0002028VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b5\u0010$\u001a\u0004\b3\u00104R \u00106\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u0002070\u00180\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/MarkwonContent;", "Lcom/larus/business/markdown/api/model/MarkdownContent;", "markdown", "Landroid/text/SpannableStringBuilder;", "hasTable", "", "hasHtml", "hasCodeBlock", "node", "Lorg/commonmark/node/Node;", "markwonStruct", "Lcom/larus/business/markdown/api/model/IMarkwonStruct;", "markwonPerformance", "Lcom/larus/business/markdown/api/model/MarkwonPerformance;", "nodeInfo", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "isFinished", "(Landroid/text/SpannableStringBuilder;ZZZLorg/commonmark/node/Node;Lcom/larus/business/markdown/api/model/IMarkwonStruct;Lcom/larus/business/markdown/api/model/MarkwonPerformance;Ljava/util/HashMap;Z)V", "customCitationClickSpanMap", "Ljava/util/WeakHashMap;", "Landroid/view/View;", "", "Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/CustomCitationClickSpan;", "fullScreenDetailClickSpanMap", "Lcom/larus/business/markdown/impl/markwon/custom/title/FullScreenDetailClickSpan;", "getHasCodeBlock", "()Z", "getHasHtml", "getHasTable", "imageUrls", "getImageUrls", "()Ljava/util/List;", "imageUrls$delegate", "Lkotlin/Lazy;", "getMarkdown", "()Landroid/text/SpannableStringBuilder;", "setMarkdown", "(Landroid/text/SpannableStringBuilder;)V", "getMarkwonPerformance", "()Lcom/larus/business/markdown/api/model/MarkwonPerformance;", "getMarkwonStruct", "()Lcom/larus/business/markdown/api/model/IMarkwonStruct;", "getNode", "()Lorg/commonmark/node/Node;", "getNodeInfo", "()Ljava/util/HashMap;", "readText", "", "getReadText", "()Ljava/lang/CharSequence;", "readText$delegate", "viewCodeCopyClickSpanMap", "Lio/noties/markwon/core/spans/codeblock/CodeCopyClickSpan;", "appendSpannedIndex", "", ExifInterface.GPS_DIRECTION_TRUE, "spanIndexList", "", "Lcom/larus/business/markdown/impl/markwon/SpannedIndex;", "clazz", "Ljava/lang/Class;", "clearCodeCopySpanClickListener", "view", "clearCustomCitationSpansListener", "clearFullScreenDetailSpanClickListener", "findCustomLinkSpan", "queryKey", "queryValue", "callback", "Lkotlin/Function0;", "onClick", "Landroid/view/View$OnClickListener;", "getCopyInfoSpans", "Lcom/larus/business/markdown/api/model/ICodeCopyInfoSpan;", "getCustomCitationSpans", "Lcom/larus/business/markdown/api/model/ICustomCitationSpan;", "getFormulaSpans", "Lio/noties/markwon/image/AsyncDrawableSpan;", "setCodeCopySpanClickListener", "listener", "Lcom/larus/business/markdown/api/model/CodeCopySpanClickListener;", "setCustomCitationSpansListener", "Lcom/larus/business/markdown/api/model/CitationSpanClickListener;", "setFullScreenDetailSpanClickListener", "Lcom/larus/business/markdown/api/FullScreenDetailSpanClickListener;", "Companion", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class e implements com.larus.business.markdown.api.model.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5244a = null;
    private static final Object p = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SpannableStringBuilder f5245b;
    private final boolean c;
    private final boolean d;
    private final boolean e;
    private final Node f;
    private final com.larus.business.markdown.api.model.e g;
    private final com.larus.business.markdown.api.model.i h;
    private final HashMap<String, Integer> i;
    private final boolean j;
    private final WeakHashMap<View, List<Object>> k;
    private final WeakHashMap<View, List<com.larus.business.markdown.impl.markwon.core.spans.codeblock.f>> l;
    private final WeakHashMap<View, List<Object>> m;
    private final Lazy n;
    private final Lazy o;

    @Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J`\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0017JH\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0017H\u0007Jx\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00172\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0018\u00010\u001eJ`\u0010\u001a\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00172\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0018\u00010\u001eH\u0007JR\u0010!\u001a\u00020\u001c2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0018\u00010\u001eJ\u0010\u0010\"\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0002J \u0010#\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0016\u0010$\u001a\u00020%2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rJ)\u0010&\u001a\u0002H'\"\u0004\b\u0000\u0010'2\u0006\u0010\b\u001a\u00020\t2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0)H\u0002¢\u0006\u0002\u0010*J \u0010+\u001a\u00020 2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020-H\u0002J\u001a\u0010+\u001a\u00020 2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010,\u001a\u00020-H\u0002J \u00100\u001a\u00020\u000f\"\u0004\b\u0000\u0010'*\u0002012\f\u00102\u001a\b\u0012\u0004\u0012\u0002H'03H\u0002R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/MarkwonContent$Companion;", "", "()V", "locker", "create", "Lcom/larus/business/markdown/impl/markwon/MarkwonContent;", "context", "Landroid/content/Context;", "markdownConfigManager", "Lcom/larus/business/markdown/impl/common/MarkdownConfigManager;", "maxContentWidth", "", Params.CONTENT, "", "finished", "", "customMarkDownInfo", "Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "markwonStructCache", "Lcom/larus/business/markdown/api/model/IMarkwonStruct;", "reuseCharSequence", "", "payload", "", "markdownTextView", "Lcom/larus/business/markdown/api/view/text/IMarkdownTextView;", "createFromNode", "node", "Lorg/commonmark/node/Node;", "callBack", "Lkotlin/Function1;", "Lcom/larus/business/markdown/api/model/MarkwonPerformance;", "", "createNode", "optLatexInLineContent", "optimizeContent", "raw", "Lcom/larus/business/markdown/api/model/MarkdownContent;", "synchronizedHandle", ExifInterface.GPS_DIRECTION_TRUE, "execute", "Lkotlin/Function0;", "(Lcom/larus/business/markdown/impl/common/MarkdownConfigManager;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "updateImageSize", "imageSize", "Landroid/graphics/Rect;", "textView", "Landroid/widget/TextView;", "hasSpanned", "Landroid/text/Spanned;", "clazz", "Ljava/lang/Class;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        private final <T> T a(com.larus.business.markdown.impl.common.a r2, Function0<? extends T> r3) {
            Function0 r1 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
            if (r2.a().m() == true) goto L15;
            Object r4 = e.e();
            monitor-enter(r4);
            T r5 = (T) r1.invoke();
            monitor-exit(r4);
            return r5;
        L10:
            th = move-exception;
            throw th;
        L15:
            return (T) r1.invoke();
        }

        public static final /* synthetic */ String a(a r0, String r1) {
            return r0.a(r1);
        }

        public static final /* synthetic */ String a(a r0, String r1, boolean r2, com.larus.business.markdown.impl.common.a r3) {
            return r0.a(r1, r2, r3);
        }

        private final String a(String r14) {
            if (StringsKt.endsWith$default((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin"), '\\', false, 2, null) == false) goto L5;
            int r13 = r14.length() - 1;
            Objects.requireNonNull(r14, "null cannot be cast to non-null type java.lang.String");
            String r15 = r14.substring(0, r13);
            Intrinsics.checkNotNullExpressionValue(r15, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        L6:
            int r4 = StringsKt.lastIndexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin"), "\\(", 0, false, 6, null);
            int r5 = StringsKt.lastIndexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin"), ")", 0, false, 6, null);
            int r6 = StringsKt.lastIndexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin"), "\\[", 0, false, 6, null);
            int r0 = StringsKt.lastIndexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin"), "]", 0, false, 6, null);
            if (r5 >= r4) goto L10;
            Objects.requireNonNull(r14, "null cannot be cast to non-null type java.lang.String");
            r15 = r14.substring(0, r4);
        L9:
            Intrinsics.checkNotNullExpressionValue(r15, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        L12:
            return r15;
        L10:
            if (r0 >= r6) goto L12;
            Objects.requireNonNull(r14, "null cannot be cast to non-null type java.lang.String");
            r15 = r14.substring(0, r6);
            goto L9
        L5:
            r15 = r14;
            goto L6
        }

        private final String a(String r6, boolean r7, com.larus.business.markdown.impl.common.a r8) {
            if (StringsKt.endsWith$default(r6, "\n", false, 2, null) == false) goto L5;
        L11:
            int r5 = r6.length() - 1;
        L12:
            Objects.requireNonNull(r6, "null cannot be cast to non-null type java.lang.String");
            String r9 = r6.substring(0, r5);
            Intrinsics.checkNotNullExpressionValue(r9, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        L14:
            if (r8.a().c() == false) goto L18;
            if (r7 == true) goto L19;
            StringBuilder r10 = new StringBuilder(r6);
            com.larus.business.markdown.impl.common.c.f5173a.a(r10);
            String r11 = r10.toString();
            Intrinsics.checkNotNullExpressionValue(r11, "{\n                val op….toString()\n            }");
            return r11;
        L19:
            return r9;
        L18:
            return r9;
        L5:
            if (StringsKt.endsWith$default(r6, "\r", false, 2, null) == true) goto L11;
            if (StringsKt.endsWith$default(r6, "\r\n", false, 2, null) == false) goto L10;
            r5 = r6.length() - 2;
            goto L12
        L10:
            r9 = r6;
            goto L14
        }

        private final void a(Context r2, int r3, Rect r4) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            if (r3 > 0) goto L5;
        L6:
            r3 = ZeusTransformUtils.getResources(r1, "com.obric.memorydata.plugin").getDisplayMetrics().widthPixels;
        L7:
            r4.set(0, 0, r3, (r3 * 2) / 3);
            return;
        L5:
            if (r3 != Integer.MAX_VALUE) goto L7;
            goto L6
        }

        private final void a(TextView r2, Rect r3) {
            if (r2 != null) goto L5;
            return;
        L5:
            if (ZeusTransformUtils.instanceOf(r2, com.larus.business.markdown.api.c.a.a.class) == false) goto L7;
            int r1 = ((com.larus.business.markdown.api.c.a.a) ZeusTransformUtils.preCheckCast(r2, com.larus.business.markdown.api.c.a.a.class, "com.obric.memorydata.plugin")).getMarkdownWidth();
        L8:
            if (r1 > 0) goto L10;
        L11:
            r1 = r2.getWidth();
        L12:
            int r4 = Math.max(0, (r1 - r2.getPaddingStart()) - r2.getPaddingEnd());
            r3.set(0, 0, r4, (r4 * 2) / 3);
            return;
        L10:
            if (r1 != Integer.MAX_VALUE) goto L12;
        L7:
            r1 = r2.getMaxWidth();
            goto L8
        }

        public static final /* synthetic */ void a(a r2, Context r3, int r4, Rect r5) {
            r2.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4, r5);
        }

        public static final /* synthetic */ void a(a r0, TextView r1, Rect r2) {
            r0.a(r1, r2);
        }

        private final <T> boolean a(Spanned r2, Class<T> r3) {
            Spanned r1 = (Spanned) ZeusTransformUtils.wrapperContextForParams(r2, Spanned.class, "com.obric.memorydata.plugin");
            boolean r0 = false;
            Object[] r4 = r1.getSpans(0, r1.length(), r3);
            Intrinsics.checkNotNullExpressionValue(r4, "getSpans(0, length, clazz)");
            if (r4.length != 0) goto L6;
            r0 = true;
        L6:
            return !r0;
        }

        public static final /* synthetic */ boolean a(a r2, Spanned r3, Class r4) {
            return r2.a((Spanned) ZeusTransformUtils.wrapperContextForParams(r3, Spanned.class, "com.obric.memorydata.plugin"), r4);
        }

        public final com.larus.business.markdown.api.model.h a(com.larus.business.markdown.impl.common.a r51, String r52) {
            Intrinsics.checkNotNullParameter(r51, "markdownConfigManager");
            Intrinsics.checkNotNullParameter(r52, Params.CONTENT);
            SpannableStringBuilder r9 = new SpannableStringBuilder((CharSequence) ZeusTransformUtils.preCheckCast(r52, CharSequence.class, "com.obric.memorydata.plugin"));
            Application r0 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.larus.business.markdown.api.a.f5138a.a(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L5;
            g r1 = f.a((Context) ZeusTransformUtils.preCheckCast(r0, Context.class, "com.obric.memorydata.plugin"), r51, null, new com.larus.business.markdown.api.model.c(com.larus.business.markdown.impl.common.utils.e.a((Number) ZeusTransformUtils.preCheckCast(12, Number.class, "com.obric.memorydata.plugin")), null, null, null, false, false, null, 0, 0, null, 0.0f, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, null), null, 2, null);
        L6:
            boolean r4 = false;
            boolean r5 = false;
            boolean r6 = false;
            Node r7 = null;
            return (com.larus.business.markdown.api.model.h) ZeusTransformUtils.preCheckCast(new e(r9, r4, r5, r6, r7, (com.larus.business.markdown.api.model.e) ZeusTransformUtils.preCheckCast(r1, com.larus.business.markdown.api.model.e.class, "com.obric.memorydata.plugin"), null, null, false, 464, null), com.larus.business.markdown.api.model.h.class, "com.obric.memorydata.plugin");
        L5:
            r1 = null;
            goto L6
        }

        public final e a(Context r14, final com.larus.business.markdown.impl.common.a r15, final int r16, final String r17, final boolean r18, final com.larus.business.markdown.api.model.c r19, com.larus.business.markdown.api.model.e r20, CharSequence r21, Map<String, ? extends Object> r22) {
            final Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.memorydata.plugin");
            final com.larus.business.markdown.api.model.e r1 = (com.larus.business.markdown.api.model.e) ZeusTransformUtils.wrapperContextForParams(r20, com.larus.business.markdown.api.model.e.class, "com.obric.memorydata.plugin");
            final CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r21, CharSequence.class, "com.obric.memorydata.plugin");
            final Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r22, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r15, "markdownConfigManager");
            Intrinsics.checkNotNullParameter(r17, Params.CONTENT);
            Intrinsics.checkNotNullParameter(r19, "customMarkDownInfo");
            return (e) ZeusTransformUtils.preCheckCast(a(r15, (Function0) ZeusTransformUtils.preCheckCast(new MarkwonContent$Companion$create$2(r1, r18, r3, r15, r16, r19, r7, r17, r9), Function0.class, "com.obric.memorydata.plugin")), e.class, "com.obric.memorydata.plugin");
        }

        public final e a(Context r15, final com.larus.business.markdown.impl.common.a r16, final int r17, final Node r18, final boolean r19, final com.larus.business.markdown.api.model.c r20, CharSequence r21, Map<String, ? extends Object> r22, com.larus.business.markdown.api.model.e r23, Function1<? super com.larus.business.markdown.api.model.i, Unit> r24) {
            final Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r15, Context.class, "com.obric.memorydata.plugin");
            final CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r21, CharSequence.class, "com.obric.memorydata.plugin");
            final Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r22, Map.class, "com.obric.memorydata.plugin");
            final com.larus.business.markdown.api.model.e r1 = (com.larus.business.markdown.api.model.e) ZeusTransformUtils.wrapperContextForParams(r23, com.larus.business.markdown.api.model.e.class, "com.obric.memorydata.plugin");
            final Function1 r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r24, Function1.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r16, "markdownConfigManager");
            Intrinsics.checkNotNullParameter(r18, "node");
            Intrinsics.checkNotNullParameter(r20, "customMarkDownInfo");
            return (e) ZeusTransformUtils.preCheckCast(a(r16, (Function0) ZeusTransformUtils.preCheckCast(new MarkwonContent$Companion$createFromNode$2(r1, r19, r3, r16, r17, r20, r7, r18, r9, r10), Function0.class, "com.obric.memorydata.plugin")), e.class, "com.obric.memorydata.plugin");
        }

        @Deprecated(message = "尽量使用不包含TextView的同名类")
        public final e a(final com.larus.business.markdown.impl.common.a r10, com.larus.business.markdown.api.c.a.a r11, final String r12, final boolean r13, final com.larus.business.markdown.api.model.c r14, Map<String, ? extends Object> r15) {
            final com.larus.business.markdown.api.c.a.a r3 = (com.larus.business.markdown.api.c.a.a) ZeusTransformUtils.wrapperContextForParams(r11, com.larus.business.markdown.api.c.a.a.class, "com.obric.memorydata.plugin");
            final Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r10, "markdownConfigManager");
            Intrinsics.checkNotNullParameter(r12, Params.CONTENT);
            Intrinsics.checkNotNullParameter(r14, "customMarkDownInfo");
            return (e) ZeusTransformUtils.preCheckCast(a(r10, (Function0) ZeusTransformUtils.preCheckCast(new MarkwonContent$Companion$create$1(r3, r10, r12, r13, r14, r8), Function0.class, "com.obric.memorydata.plugin")), e.class, "com.obric.memorydata.plugin");
        }

        public final Node a(Context r12, final com.larus.business.markdown.impl.common.a r13, final String r14, final boolean r15, final com.larus.business.markdown.api.model.c r16, com.larus.business.markdown.api.model.e r17, Function1<? super com.larus.business.markdown.api.model.i, Unit> r18) {
            final Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
            final com.larus.business.markdown.api.model.e r1 = (com.larus.business.markdown.api.model.e) ZeusTransformUtils.wrapperContextForParams(r17, com.larus.business.markdown.api.model.e.class, "com.obric.memorydata.plugin");
            final Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r18, Function1.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r13, "markdownConfigManager");
            Intrinsics.checkNotNullParameter(r14, Params.CONTENT);
            return (Node) ZeusTransformUtils.preCheckCast(a(r13, (Function0) ZeusTransformUtils.preCheckCast(new MarkwonContent$Companion$createNode$1(r1, r15, r3, r13, r16, r14, r7), Function0.class, "com.obric.memorydata.plugin")), Node.class, "com.obric.memorydata.plugin");
        }
    }

    static {
        f5244a = new a(null);
        p = new Object();
    }

    public e(SpannableStringBuilder r3, boolean r4, boolean r5, boolean r6, Node r7, com.larus.business.markdown.api.model.e r8, com.larus.business.markdown.api.model.i r9, HashMap<String, Integer> r10, boolean r11) {
        com.larus.business.markdown.api.model.e r12 = (com.larus.business.markdown.api.model.e) ZeusTransformUtils.wrapperContextForParams(r8, com.larus.business.markdown.api.model.e.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "markdown");
        this.f5245b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r12;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = new WeakHashMap();
        this.l = new WeakHashMap();
        this.m = new WeakHashMap();
        this.n = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new MarkwonContent$readText$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.o = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new MarkwonContent$imageUrls$2(this), Function0.class, "com.obric.memorydata.plugin"));
    }

    public /* synthetic */ e(SpannableStringBuilder r15, boolean r16, boolean r17, boolean r18, Node r19, com.larus.business.markdown.api.model.e r20, com.larus.business.markdown.api.model.i r21, HashMap r22, boolean r23, int r24, DefaultConstructorMarker r25) {
        com.larus.business.markdown.api.model.e r1 = (com.larus.business.markdown.api.model.e) ZeusTransformUtils.wrapperContextForParams(r20, com.larus.business.markdown.api.model.e.class, "com.obric.memorydata.plugin");
        if ((r24 & 16) == 0) goto L5;
        Node r9 = null;
    L7:
        if ((r24 & 32) == 0) goto L9;
        com.larus.business.markdown.api.model.e r10 = null;
    L11:
        if ((r24 & 64) == 0) goto L13;
        com.larus.business.markdown.api.model.i r11 = null;
    L15:
        if ((r24 & 128) == 0) goto L17;
        HashMap r12 = null;
    L19:
        if ((r24 & 256) == 0) goto L21;
        boolean r13 = true;
    L22:
        this(r15, r16, r17, r18, r9, r10, r11, r12, r13);
        return;
    L21:
        r13 = r23;
        goto L22
    L17:
        r12 = r22;
        goto L19
    L13:
        r11 = r21;
        goto L15
    L9:
        r10 = r1;
        goto L11
    L5:
        r9 = r19;
        goto L7
    }

    public static final /* synthetic */ void a(e r2, List r3, Class r4) {
        r2.a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    private final <T> void a(List<h> r9, Class<T> r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Object[] r12 = a().getSpans(0, a().length(), r10);
        Intrinsics.checkNotNullExpressionValue(r12, "spans");
        int r0 = r12.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L14;
        int r3 = a().getSpanStart(r12[r1]);
        int r4 = a().getSpanEnd(r12[r1]);
        if (r3 < 0) goto L8;
        if (r3 > r4) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == false) goto L13;
        if (r4 > a().length()) goto L13;
        Object r6 = r12[r1];
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlin.Any");
        r11.add(new h(r6, r3, r4));
    L13:
        r1 = r1 + 1;
    L8:
        r5 = false;
        goto L9
    }

    public static final /* synthetic */ Object e() {
        return p;
    }

    @Override // com.larus.business.markdown.api.model.h
    public SpannableStringBuilder a() {
        return this.f5245b;
    }

    public final boolean b() {
        return this.c;
    }

    public final boolean c() {
        return this.e;
    }

    public com.larus.business.markdown.api.model.e d() {
        return this.g;
    }
}
