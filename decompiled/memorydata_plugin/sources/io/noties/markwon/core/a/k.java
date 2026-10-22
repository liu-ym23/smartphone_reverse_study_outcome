package io.noties.markwon.core.a;

import android.text.style.LeadingMarginSpan;
import androidx.exifinterface.media.ExifInterface;
import com.larus.business.markdown.api.model.ListStyle;
import com.larus.business.markdown.api.model.OrderedSymbol;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.core.spans.ListMarginInfo;
import io.noties.markwon.core.spans.p;
import io.noties.markwon.t;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.Node;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0016J*\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\bH\u0002J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\bH\u0002J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\bH\u0002J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lio/noties/markwon/core/factory/ListItemSpanFactory2;", "Lio/noties/markwon/core/factory/ListItemSpanFactory;", "listMarginInfo", "Lio/noties/markwon/core/spans/ListMarginInfo;", "listStyle", "Lcom/larus/business/markdown/api/model/ListStyle;", "(Lio/noties/markwon/core/spans/ListMarginInfo;Lcom/larus/business/markdown/api/model/ListStyle;)V", "getListItemLevel", "", "props", "Lio/noties/markwon/RenderProps;", "getSpans", "", "configuration", "Lio/noties/markwon/MarkwonConfiguration;", "blockQuoteConfig", "Lcom/larus/business/markdown/api/model/BlockQuoteConfig;", "node", "Lorg/commonmark/node/Node;", "getSymbolText", "", "orderedSymbol", "Lcom/larus/business/markdown/api/model/OrderedSymbol;", "number", "intToAlphabet", "num", "intToRoman", "isNodeInQuote", "", "Companion", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class k extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16421a = null;
    private static final String[] d = null;
    private static final String[] e = null;
    private static final String[] f = null;
    private static final String[] g = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ListMarginInfo f16422b;
    private final ListStyle c;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\n"}, d2 = {"Lio/noties/markwon/core/factory/ListItemSpanFactory2$Companion;", "", "()V", "cValues", "", "", "[Ljava/lang/String;", "iValues", "mValues", "xValues", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16423a = null;

        static {
            int[] r0 = new int[OrderedSymbol.values().length];
            r0[OrderedSymbol.DECIMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[OrderedSymbol.LOWERCASE_ALPHABET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[OrderedSymbol.LOWERCASE_ROMAN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f16423a = r0;
        }
    }

    static {
        f16421a = new a(null);
        d = new String[]{"", "M", "MM", "MMM"};
        e = new String[]{"", "C", "CC", "CCC", "CD", com.tom_roush.pdfbox.pdmodel.a.c.a.f16161b, "DC", "DCC", "DCCC", "CM"};
        f = new String[]{"", "X", "XX", "XXX", "XL", com.tom_roush.pdfbox.pdmodel.a.d.i.u, "LX", "LXX", "LXXX", "XC"};
        g = new String[]{"", "I", "II", "III", "IV", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "VI", "VII", "VIII", "IX"};
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public k(ListMarginInfo r1, ListStyle r2) {
        this.f16422b = r1;
        this.c = r2;
    }

    public /* synthetic */ k(ListMarginInfo r2, ListStyle r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    private final int a(t r4) {
        t r3 = (t) ZeusTransformUtils.wrapperContextForParams(r4, t.class, "com.obric.memorydata.plugin");
        Object r5 = r3.a(CoreProps.c, -1);
        Intrinsics.checkNotNullExpressionValue(r5, "props.get(CoreProps.LIST_ITEM_REAL_LEVEL, -1)");
        int r6 = ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).intValue();
        if (r6 == 0) goto L6;
        if (r6 == (-1)) goto L6;
        return r6;
    L6:
        Integer r7 = CoreProps.f16409b.b(r3);
        Intrinsics.checkNotNullExpressionValue(r7, "BULLET_LIST_ITEM_LEVEL.require(props)");
        return ((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    private final String a(int r4) {
        StringBuilder r3 = new StringBuilder();
        int r5 = Math.max(1, r4);
    L3:
        if (r5 <= 0) goto L5;
        int r6 = r5 - 1;
        r3.insert(0, String.valueOf((char) (((r6 % 26) + 1) + 96)));
        r5 = r6 / 26;
        goto L3
    L5:
        String r7 = r3.toString();
        Intrinsics.checkNotNullExpressionValue(r7, "stringBuilder.toString()");
        return r7;
    }

    private final String a(OrderedSymbol r2, int r3) {
        int r4 = b.f16423a[r2.ordinal()];
        if (r4 != 1) goto L5;
    L11:
        Object r1 = Integer.valueOf(r3);
    L13:
        return r1 + ". ";
    L5:
        if (r4 != 2) goto L7;
        r1 = a(r3);
        goto L13
    L7:
        if (r4 != 3) goto L11;
        r1 = b(r3);
        goto L13
    }

    private final boolean a(Node r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, BlockQuote.class) == false) goto L8;
        return true;
    L8:
        r3 = r3.parent;
        if (r3 == null) goto L13;
        if (ZeusTransformUtils.instanceOf(r3, BlockQuote.class) == false) goto L8;
        return true;
    L13:
        return false;
    }

    private final String b(int r3) {
        if (r3 != 0) goto L5;
        return "";
    L5:
        String r2 = d[r3 / 1000] + e[(r3 % 1000) / 100] + f[(r3 % 100) / 10] + g[r3 % 10];
        Locale r4 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(r4, "getDefault()");
        Objects.requireNonNull(r2, "null cannot be cast to non-null type java.lang.String");
        String r5 = r2.toLowerCase(r4);
        Intrinsics.checkNotNullExpressionValue(r5, "(this as java.lang.String).toLowerCase(locale)");
        return r5;
    }

    @Override // io.noties.markwon.core.a.j, io.noties.markwon.w
    public Object a(io.noties.markwon.i r3, t r4) {
        t r5 = (t) ZeusTransformUtils.wrapperContextForParams(r4, t.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "configuration");
        Intrinsics.checkNotNullParameter(r5, "props");
        return a(r3, r5, null, null);
    }

    public final Object a(io.noties.markwon.i r11, t r12, com.larus.business.markdown.api.model.a r13, Node r14) {
        t r15 = (t) ZeusTransformUtils.wrapperContextForParams(r12, t.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "configuration");
        Intrinsics.checkNotNullParameter(r15, "props");
        ListStyle r0 = this.c;
        int r2 = 0;
        if (r0 != null) goto L5;
        r0 = new ListStyle(null, false, 3, null);
    L5:
        int r8 = a(r11, r15, this.f16422b);
        Boolean r3 = CoreProps.e.b(r15);
        Intrinsics.checkNotNullExpressionValue(r3, "LIST_ITEM_REAL_SELF.require(props)");
        boolean r9 = ((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        if (CoreProps.ListItemType.BULLET != CoreProps.f16408a.b(r15)) goto L15;
        io.noties.markwon.core.spans.d r4 = new io.noties.markwon.core.spans.d(r11.a(), this.f16422b, a(r15), r8, r9);
        r4.f16461a = r0.getSymbolStrategy();
        if (a(r14) == false) goto L14;
        if (r13 == null) goto L13;
        Integer r10 = r13.h();
        if (r10 == null) goto L13;
        r2 = r10.intValue();
    L13:
        r4.a(r2);
    L14:
        Object r16 = ZeusTransformUtils.preCheckCast(r4, LeadingMarginSpan.class, "com.obric.memorydata.plugin");
    L24:
        return (LeadingMarginSpan) r16;
    L15:
        OrderedSymbol r1 = r0.getSymbolStrategy().b(a(r15));
        Integer r17 = CoreProps.d.b(r15);
        Intrinsics.checkNotNullExpressionValue(r17, "ORDERED_LIST_ITEM_NUMBER.require(props)");
        String r7 = a(r1, ((Number) ZeusTransformUtils.preCheckCast(r17, Number.class, "com.obric.memorydata.plugin")).intValue());
        p r18 = new p(r11.a(), this.f16422b, r7, r8, r9);
        if (a(r14) == false) goto L22;
        if (r13 == null) goto L21;
        Integer r19 = r13.g();
        if (r19 == null) goto L21;
        r2 = r19.intValue();
    L21:
        r18.a(r2);
    L22:
        r16 = ZeusTransformUtils.preCheckCast(r18, LeadingMarginSpan.class, "com.obric.memorydata.plugin");
        goto L24
    }
}
