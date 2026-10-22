package com.larus.business.markdown.impl.markwon.custom.title;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.larus.business.markdown.api.FullScreenDetailType;
import com.larus.business.markdown.api.model.CodeBlockConfig;
import com.larus.business.markdown.api.model.TableConfig;
import com.larus.business.markdown.api.model.TitleStyle;
import com.larus.business.markdown.impl.markwon.core.spans.codeblock.g;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.ext.tables.n;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.commonmark.node.Node;
import org.commonmark.node.Text;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002JH\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000eJ6\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000eR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006 "}, d2 = {"Lcom/larus/business/markdown/impl/markwon/custom/title/MarkwonCustomTitleManager;", "", "()V", "marginCodeLastButtonToEndAdjuster", "", "getMarginCodeLastButtonToEndAdjuster", "()I", "marginCodeLastButtonToEndAdjuster$delegate", "Lkotlin/Lazy;", "getCodeBlockTitleStyleConfig", "Lcom/larus/business/markdown/impl/markwon/custom/title/CodeBlockTitleStyleConfig;", "titleStyle", "Lcom/larus/business/markdown/api/model/TitleStyle;", "isTableContentStreamingFinished", "", "node", "Lio/noties/markwon/ext/tables/TableTitle;", "visitCodeBlock", "", "contentMaxWidth", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "info", "", "code", "Lorg/commonmark/node/Node;", "context", "Landroid/content/Context;", "customMarkDownInfo", "Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "isFinished", "visitTableTitle", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f5233a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f5234b = null;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5235a = null;

        static {
            int[] r0 = new int[TitleStyle.values().length];
            r0[TitleStyle.LARGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[TitleStyle.NORMAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f5235a = r0;
        }
    }

    static {
        f5233a = new c();
        f5234b = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MarkwonCustomTitleManager$marginCodeLastButtonToEndAdjuster$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
    }

    private c() {
    }

    private final int a() {
        return ((Number) ZeusTransformUtils.preCheckCast(f5234b.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    private final com.larus.business.markdown.impl.markwon.custom.title.a a(TitleStyle r18) {
        if (r18 != null) goto L5;
        int r1 = -1;
    L7:
        if (r1 == (-1)) goto L17;
        if (r1 != 1) goto L11;
        int r5 = com.larus.business.markdown.impl.common.utils.e.a((Number) ZeusTransformUtils.preCheckCast(9, Number.class, "com.obric.memorydata.plugin"));
        int r6 = ZeusTransformUtils.mapRes(R.drawable.copy_button_large, "drawable", "copy_button_large");
        int r0 = ZeusTransformUtils.mapRes(R.drawable.fullscreen_button_large, "drawable", "fullscreen_button_large");
        int r9 = com.larus.business.markdown.impl.common.utils.e.a((Number) ZeusTransformUtils.preCheckCast(7, Number.class, "com.obric.memorydata.plugin"));
        return new com.larus.business.markdown.impl.markwon.custom.title.a(r5, r6, Integer.valueOf(r0), com.larus.business.markdown.impl.common.utils.e.a((Number) ZeusTransformUtils.preCheckCast(7, Number.class, "com.obric.memorydata.plugin")), r9, com.larus.business.markdown.impl.common.utils.e.a((Number) ZeusTransformUtils.preCheckCast(7, Number.class, "com.obric.memorydata.plugin")), com.larus.business.markdown.impl.common.utils.e.a((Number) ZeusTransformUtils.preCheckCast(7, Number.class, "com.obric.memorydata.plugin")), com.larus.business.markdown.impl.common.utils.e.a((Number) ZeusTransformUtils.preCheckCast(7, Number.class, "com.obric.memorydata.plugin")), com.larus.business.markdown.impl.common.utils.e.a((Number) ZeusTransformUtils.preCheckCast(7, Number.class, "com.obric.memorydata.plugin")), com.larus.business.markdown.impl.common.utils.e.a((Number) ZeusTransformUtils.preCheckCast(7, Number.class, "com.obric.memorydata.plugin")), com.larus.business.markdown.impl.common.utils.e.a((Number) ZeusTransformUtils.preCheckCast(7, Number.class, "com.obric.memorydata.plugin")), com.larus.business.markdown.impl.common.utils.e.a((Number) ZeusTransformUtils.preCheckCast(8, Number.class, "com.obric.memorydata.plugin")));
    L11:
        if (r1 == 2) goto L17;
        throw new NoWhenBranchMatchedException();
    L17:
        return new com.larus.business.markdown.impl.markwon.custom.title.a(com.larus.business.markdown.impl.common.utils.e.a((Number) ZeusTransformUtils.preCheckCast(6, Number.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.drawable.copy_button, "drawable", "copy_button"), null, 0, 0, com.larus.business.markdown.impl.common.utils.e.a((Number) ZeusTransformUtils.preCheckCast(4, Number.class, "com.obric.memorydata.plugin")), 0, 0, 0, 0, 0, com.larus.business.markdown.impl.common.utils.e.a((Number) ZeusTransformUtils.preCheckCast(12, Number.class, "com.obric.memorydata.plugin")));
    L5:
        r1 = a.f5235a[r18.ordinal()];
        goto L7
    }

    private final boolean a(n r6) {
        Node r5 = r6.parent;
        String r0 = null;
        if (r5 == null) goto L7;
        Node r7 = r5.next;
        if (r7 == null) goto L7;
        Node r8 = r7.lastChild;
    L8:
        boolean r2 = true;
    L10:
        if (r8 == null) goto L18;
        if (r8.next == null) goto L14;
        r8 = null;
        r2 = false;
    L14:
        if (r8 != null) goto L15;
        r8 = null;
        goto L10
    L15:
        r8 = r8.parent;
        goto L10
    L18:
        if (r6.parent.next == null) goto L36;
        Node r9 = r6.parent;
        if (r9 == null) goto L24;
        Node r10 = r9.next;
        if (r10 == null) goto L24;
        Node r11 = r10.lastChild;
    L26:
        if (ZeusTransformUtils.instanceOf(r11, Text.class) == false) goto L28;
        Text r12 = (Text) ZeusTransformUtils.preCheckCast(r11, Text.class, "com.obric.memorydata.plugin");
    L29:
        if (r12 == null) goto L32;
        r0 = r12.getLiteral();
    L32:
        if (Intrinsics.areEqual(r0, "|") == false) goto L43;
        if (r2 == true) goto L36;
        return true;
    L43:
        return true;
    L28:
        r12 = null;
    L24:
        r11 = null;
    L36:
        return false;
    L7:
        r8 = null;
        goto L8
    }

    public final void a(int r34, io.noties.markwon.n r35, String r36, String r37, Node r38, Context r39, com.larus.business.markdown.api.model.c r40, boolean r41) {
        io.noties.markwon.n r14 = (io.noties.markwon.n) ZeusTransformUtils.wrapperContextForParams(r35, io.noties.markwon.n.class, "com.obric.memorydata.plugin");
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r39, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "visitor");
        Intrinsics.checkNotNullParameter(r37, "code");
        Intrinsics.checkNotNullParameter(r38, "node");
        Intrinsics.checkNotNullParameter(r15, "context");
        Intrinsics.checkNotNullParameter(r40, "customMarkDownInfo");
        if (Intrinsics.areEqual(r36, "STDOUT") == false) goto L5;
        return;
    L5:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r37, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L270;
        r14.e(r38);
        int r3 = r14.f();
        if (r41 == false) goto L13;
    L16:
        boolean r7 = true;
    L17:
        CodeBlockConfig r4 = r40.q();
        if (r4 != null) goto L20;
    L22:
        boolean r5 = false;
    L24:
        if (r5 == true) goto L246;
        int r310 = r3;
        String r16 = " ";
        io.noties.markwon.n r27 = r14;
    L195:
        int r6 = 0;
    L196:
        int r0 = r27.f();
        CodeBlockConfig r8 = r40.q();
        if (r8 != null) goto L199;
    L201:
        int r9 = r6;
    L202:
        if (r9 == 0) goto L215;
        StringBuilder r10 = new StringBuilder();
        Map r11 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        List r12 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r37, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"\n"}, false, 0, 6, null);
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r17 = 1;
    L205:
        if (r13.hasNext() == false) goto L214;
        String r18 = (String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.memorydata.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L209;
        int r19 = 1;
    L210:
        if (r19 == 0) goto L212;
        String r110 = r16;
        r10.append(r110);
        r11.put(Integer.valueOf(r10.length() - 1), Integer.valueOf(r17));
        r10.append(r18);
        r10.append("\n");
        r17 = r17 + 1;
    L213:
        r16 = r110;
        goto L205
    L212:
        r110 = r16;
        goto L213
    L209:
        r19 = r6;
        goto L210
    L214:
        r27.b().b(com.larus.business.markdown.impl.markwon.core.spans.codeblock.d.d(), Integer.valueOf(r12.size()));
        r27.b().b(com.larus.business.markdown.impl.markwon.core.spans.codeblock.d.e(), r11);
        r27.c().a(r27.a().c().a(r36, r10.toString()));
    L216:
        r27.d();
        r27.c().a(Typography.nbsp);
        r27.b().b(CoreProps.k, r36);
        r27.b().b(com.larus.business.markdown.impl.markwon.core.spans.codeblock.d.a(), Integer.valueOf(r310));
        r27.b().b(com.larus.business.markdown.impl.markwon.core.spans.codeblock.d.b(), Integer.valueOf(r27.f()));
        CodeBlockConfig r1 = r40.q();
        if (r1 == null) goto L221;
        Integer r20 = r1.getCodeContentSize();
        if (r20 == null) goto L221;
        int r21 = ((Number) ZeusTransformUtils.preCheckCast(r20, Number.class, "com.obric.memorydata.plugin")).intValue();
        r27.c().a(new AbsoluteSizeSpan(r21), r0, r27.f(), 17);
    L221:
        CodeBlockConfig r22 = r40.q();
        if (r22 != null) goto L224;
    L226:
        int r23 = r6;
    L227:
        if (r23 == 0) goto L229;
        io.noties.markwon.scrollable.b r24 = new io.noties.markwon.scrollable.b(0.0f);
        r27.b().b(com.larus.business.markdown.impl.markwon.core.spans.codeblock.d.c(), r24);
        int r25 = r310;
        io.noties.markwon.n r26 = r27;
        r26.a(r25, r24);
    L230:
        r26.b(r38, r25);
        r26.f(r38);
        return;
    L229:
        r25 = r310;
        r26 = r27;
        goto L230
    L224:
        if (r22.getEnableScroll() != true) goto L226;
        r23 = 1;
        goto L227
    L215:
        r27.c().a(r27.a().c().a(r36, r37));
        goto L216
    L199:
        if (r8.getEnableLineNumber() != true) goto L201;
        r9 = 1;
        goto L202
    L246:
        CodeBlockConfig r28 = r40.q();     // Catch: Exception -> L189
        if (r28 != null) goto L28;
        boolean r111 = true;
    L31:
        if (r111 == false) goto L36;
        CodeBlockConfig r29 = r40.q();     // Catch: Exception -> L189
        if (r29 == null) goto L36;
        String r30 = r29.getCodeCopyTitle();     // Catch: Exception -> L189
        if (r30 == null) goto L36;
    L37:
        CodeBlockConfig r31 = r40.q();     // Catch: Exception -> L189
        if (r31 == null) goto L40;
        TitleStyle r32 = r31.getTitleStyle();     // Catch: Exception -> L189
    L41:
        com.larus.business.markdown.impl.markwon.custom.title.a r112 = a(r32);     // Catch: Exception -> L189
        SpannableStringBuilder r33 = new SpannableStringBuilder((CharSequence) ZeusTransformUtils.preCheckCast(r36 + "\r " + r30, CharSequence.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L189
        int r42 = r112.a();     // Catch: Exception -> L189
        CodeBlockConfig r43 = r40.q();     // Catch: Exception -> L189
        if (r43 == null) goto L44;
        int r44 = r43.getCodeTitleSize();     // Catch: Exception -> L189
    L45:
        int r210 = r112.f() + r112.g();     // Catch: Exception -> L189
        if (r36 == null) goto L48;
        int r211 = r36.length();     // Catch: Exception -> L189
    L49:
        int r212 = r211 + 2;     // Catch: Exception -> L189
        int r213 = r212 + r30.length();     // Catch: Exception -> L189
        CodeBlockConfig r45 = r40.q();     // Catch: Exception -> L189
        if (r45 == null) goto L55;
        if (r45.getEnablePreviewButton() != true) goto L55;
        boolean r46 = true;
    L56:
        if (r46 == false) goto L67;
        if (r36 != null) goto L59;
        r310 = r3;
        int r47 = 0;
        boolean r48 = false;
    L65:
        if (r48 == false) goto L68;
        int r49 = 1;
    L69:
        if (r49 != 0) goto L236;
        SpannableStringBuilder r113 = r33;
        String r114 = " ";
        boolean r214 = r7;
        r27 = r14;
        int r115 = r310;
    L99:
        if (r111 == true) goto L250;
        Context r116 = r15;
        r310 = r115;
        boolean r117 = r214;
        int r50 = 0;
        String r118 = r114;
        r113 = r113;
    L121:
        Integer r51 = r112.c();     // Catch: Exception -> L187
        CodeBlockConfig r52 = r40.q();     // Catch: Exception -> L187
        if (r52 != null) goto L124;
        boolean r53 = true;
    L128:
        int r54 = r50;
    L129:
        if (r54 == 0) goto L150;
        if (r51 == null) goto L150;
        r113.insert(r113.length(), (CharSequence) ZeusTransformUtils.preCheckCast(r118, CharSequence.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L148
        int r55 = r113.length();     // Catch: Exception -> L148
        int r56 = r55 - 1;     // Catch: Exception -> L148
        int r119 = r112.h();     // Catch: Exception -> L148
        int r215 = r112.i();     // Catch: Exception -> L148
        Drawable r57 = ContextCompat.getDrawable(r116, r51.intValue());     // Catch: Exception -> L148
        if (r57 == null) goto L135;
        int r58 = r57.getIntrinsicWidth();     // Catch: Exception -> L187
    L136:
        r210 = r210 + ((r58 + r119) + r215);
        int r59 = r51.intValue();     // Catch: Exception -> L148
        r16 = r118;
        int r120 = r50;
        SpannableStringBuilder r60 = r113;
        r60.setSpan(new io.noties.markwon.core.spans.a.d(r116, r59, r42, r119, r215, 1, r117), r56, r55, 33);     // Catch: Exception -> L146
        if (r36 != null) goto L142;
        String r61 = "";
    L143:
        r60.setSpan(new b(r61, r37, r37, FullScreenDetailType.CODE_BLOCK, r117, false, 32, null), r56, r55, 17);     // Catch: Exception -> L185
    L151:
        r60.insert(r60.length(), (CharSequence) ZeusTransformUtils.preCheckCast("\r\n", CharSequence.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L185
        r60.setSpan(new ForegroundColorSpan(ContextCompat.getColor(r116, ZeusTransformUtils.mapRes(R.color.neutral_70, TypedValues.Custom.S_COLOR, "neutral_70"))), 0, r60.length(), 17);     // Catch: Exception -> L183
        r60.setSpan(new AbsoluteSizeSpan(r44, true), 0, r60.length(), 17);     // Catch: Exception -> L183
        int r62 = r112.l();     // Catch: Exception -> L185
        if (r36 == null) goto L157;
        int r63 = r36.length();     // Catch: Exception -> L185
    L158:
        int r64 = r63 + 1;     // Catch: Exception -> L185
        CharSequence r65 = (CharSequence) ZeusTransformUtils.preCheckCast(r60, CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L185
        Pair[] r66 = new Pair[2];     // Catch: Exception -> L185
        int r121 = 0;
    L181:
        e = e;
        r6 = r121;
    L193:
        Log.e("MarkwonExt", "visitCodeBlock error:" + e.getLocalizedMessage());
        goto L196
    L161:
        if (r36 == null) goto L163;
        int r122 = r36.length();     // Catch: Exception -> L185
    L164:
        Pair r67 = new Pair(0, Integer.valueOf(r122));     // Catch: Exception -> L185
        r121 = 0;
        r66[0] = r67;     // Catch: Exception -> L181
        r66[1] = new Pair(Integer.valueOf(r212), Integer.valueOf(r213));     // Catch: Exception -> L185
        r60.setSpan(new io.noties.markwon.core.spans.a.f(r65, r34, CollectionsKt.listOf(r66), ((r27.a().a().c() + r62) + r210) - a(), r42), r63, r64, 33);     // Catch: Exception -> L185
        int r68 = r60.length() - 2;     // Catch: Exception -> L185
        r60.setSpan(new io.noties.markwon.core.spans.a.e(r62, r42), r68, r68 + 1, 33);     // Catch: Exception -> L185
        r27.c().a((CharSequence) ZeusTransformUtils.preCheckCast(r60, CharSequence.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L185
        CodeBlockConfig r69 = r40.q();     // Catch: Exception -> L185
        if (r69 == null) goto L195;
        if (r69.getEnableTitleBottomLine() == false) goto L195;
        CodeBlockConfig r70 = r40.q();     // Catch: Exception -> L185
        if (r70 == null) goto L195;
        Integer r71 = r70.getTitleBottomLineColor();     // Catch: Exception -> L185
        if (r71 == null) goto L195;
        int r72 = r71.intValue();     // Catch: Exception -> L185
        SpannableStringBuilder r73 = new SpannableStringBuilder((CharSequence) ZeusTransformUtils.preCheckCast("\r\n", CharSequence.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L185
        r6 = 0;
        r73.setSpan(new g(r116, r27.a().a().c(), com.larus.business.markdown.impl.common.utils.e.a((Number) ZeusTransformUtils.preCheckCast(1, Number.class, "com.obric.memorydata.plugin")), r72), 0, r73.length(), 17);     // Catch: Exception -> L179
        r27.c().a((CharSequence) ZeusTransformUtils.preCheckCast(r73, CharSequence.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L179
    L179:
        e = e;
        goto L193
    L163:
        r122 = 0;
        goto L164
    L157:
        r63 = 0;
    L183:
        e = e;
        r6 = 0;
    L185:
        e = e;
    L192:
        r6 = 0;
        goto L193
    L142:
        r61 = r36;
    L146:
        e = e;
        r6 = r120;
    L187:
        e = e;
        r6 = r50;
        r16 = r118;
        goto L193
    L135:
        r58 = r50;
    L148:
        e = e;
        r16 = r118;
        r6 = r50;
    L150:
        r60 = r113;
        r16 = r118;
        goto L151
    L124:
        r53 = true;
        if (r52.getEnableCodeFullScreenButton() != true) goto L128;
        r54 = 1;
        goto L129
    L250:
        int r74 = r112.b();     // Catch: Exception -> L118
        int r75 = r112.f();     // Catch: Exception -> L118
        int r76 = r112.g();     // Catch: Exception -> L118
        r113.insert(r113.length(), (CharSequence) ZeusTransformUtils.preCheckCast(r114, CharSequence.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L118
        int r77 = r113.length();     // Catch: Exception -> L118
        int r78 = r77 - 1;     // Catch: Exception -> L118
        r116 = r15;
        Drawable r79 = ContextCompat.getDrawable(r116, r74);     // Catch: Exception -> L118
        if (r79 == null) goto L106;
        int r80 = r79.getIntrinsicWidth();     // Catch: Exception -> L104
    L107:
        r210 = r210 + ((r80 + r75) + r76);
        r310 = r115;
        r118 = r114;
        r113.setSpan(new io.noties.markwon.core.spans.a.d(r116, r74, r42, r75, r76, 1, r214), r78, r77, 33);     // Catch: Exception -> L116
        if (r36 != null) goto L113;
        String r81 = "";
    L114:
        r117 = r214;
        r50 = 0;
        r113.setSpan(new io.noties.markwon.core.spans.a.c(r81, r37, r117, false), r78, r77, 17);     // Catch: Exception -> L187
        goto L121
    L113:
        r81 = r36;
    L116:
        e = e;
        r16 = r118;
    L104:
        e = e;
        r16 = r114;
        r310 = r115;
        goto L192
    L106:
        r80 = 0;
    L118:
        e = e;
        r310 = r115;
        r16 = r114;
        goto L192
    L236:
        int r82 = ZeusTransformUtils.mapRes(R.drawable.preview_button_large, "drawable", "preview_button_large");     // Catch: Exception -> L93
        int r83 = r112.d();     // Catch: Exception -> L93
        int r216 = r112.e();     // Catch: Exception -> L93
        r33.insert(r33.length(), (CharSequence) ZeusTransformUtils.preCheckCast(" ", CharSequence.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L93
        int r123 = r33.length();     // Catch: Exception -> L93
        int r84 = r123 - 1;     // Catch: Exception -> L93
        Drawable r217 = ContextCompat.getDrawable(r15, r82);     // Catch: Exception -> L93
        if (r217 != null) goto L232;
        int r218 = 0;
    L78:
        r210 = r210 + ((r218 + r83) + r216);
        r27 = r14;
        r113 = r33;
        r214 = r7;
        r113.setSpan(new io.noties.markwon.core.spans.a.d(r15, r82, r42, r83, r216, 1, r214), r84, r123, 33);     // Catch: Exception -> L89
        if (r36 != null) goto L84;
        String r85 = "";
    L85:
        r115 = r310;
        r114 = " ";
        r113.setSpan(new b(r85, r37, r37, FullScreenDetailType.CODE_BLOCK, r214, true), r84, r123, 17);     // Catch: Exception -> L104
        goto L99
    L84:
        r85 = r36;
    L89:
        e = e;
        r16 = " ";
    L91:
        e = e;
    L95:
        r16 = " ";
        goto L192
    L232:
        r218 = r217.getIntrinsicWidth();     // Catch: Exception -> L75
    L75:
        e = e;
    L191:
        r16 = " ";
        r27 = r14;
    L93:
        e = e;
        r27 = r14;
    L96:
        e = e;
        r27 = r14;
        r16 = " ";
        r6 = r47;
    L68:
        r49 = r47;
        goto L69
    L59:
        r310 = r3;
        r47 = 0;
        r48 = StringsKt.startsWith$default(r36, "html", false, 2, null);     // Catch: Exception -> L62
    L62:
        e = e;
        r16 = " ";
        r6 = 0;
        r27 = r14;
        goto L193
    L67:
        r310 = r3;
        r44 = r44;
        r47 = 0;
    L55:
        r46 = false;
        goto L56
    L48:
        r211 = 0;
        goto L49
    L44:
        r44 = 0;
        goto L45
    L40:
        r32 = null;
    L36:
        r30 = "";
        goto L37
    L28:
        r111 = r28.getEnableCodeCopyButton();     // Catch: Exception -> L189
    L189:
        e = e;
        r310 = r3;
        goto L191
    L20:
        if (r4.getEnableCodeHeader() != true) goto L22;
        r5 = true;
        goto L24
    L13:
        if (r38.next != null) goto L16;
        r7 = false;
        goto L17
    L270:
        return;
    L7:
        r2 = false;
        goto L8
    }

    public final void a(Context r33, int r34, io.noties.markwon.n r35, n r36, com.larus.business.markdown.api.model.c r37, boolean r38) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r33, Context.class, "com.obric.memorydata.plugin");
        io.noties.markwon.n r12 = (io.noties.markwon.n) ZeusTransformUtils.wrapperContextForParams(r35, io.noties.markwon.n.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r12, "visitor");
        Intrinsics.checkNotNullParameter(r36, "node");
        Intrinsics.checkNotNullParameter(r37, "customMarkDownInfo");
        TableConfig r13 = r37.r();
        if (r13 != null) goto L6;
        return;
    L6:
        if (r38 == false) goto L8;
    L11:
        boolean r11 = true;
    L53:
    L50:
        e = move-exception;
        Log.e("MarkwonExt", "visitTableTitle error:" + e.getLocalizedMessage());
        return;
    L13:
        if (r13.getEnableTableHeader() == false) goto L55;
        int r10 = r12.f();     // Catch: Exception -> L50
        com.larus.business.markdown.impl.markwon.custom.title.a r0 = a(TitleStyle.LARGE);     // Catch: Exception -> L50
        String r9 = r13.getTableTitle();     // Catch: Exception -> L50
        SpannableStringBuilder r8 = new SpannableStringBuilder((CharSequence) ZeusTransformUtils.preCheckCast(r9 + '\r', CharSequence.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L50
        int r7 = r0.a();     // Catch: Exception -> L50
        Integer r4 = r13.getTableTitleSize();     // Catch: Exception -> L50
        if (r4 == null) goto L17;
        int r6 = r4.intValue();     // Catch: Exception -> L50
    L18:
        boolean r5 = r13.getEnableCopyButton();     // Catch: Exception -> L50
        TableConfig r14 = r37.r();     // Catch: Exception -> L50
        if (r14 != null) goto L21;
    L23:
        boolean r15 = false;
    L24:
        if (r15 == false) goto L26;
        String r16 = r36.c();     // Catch: Exception -> L50
    L28:
        if (r5 == false) goto L34;
        r8.insert(r8.length(), (CharSequence) ZeusTransformUtils.preCheckCast(" ", CharSequence.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L50
        int r17 = r0.b();     // Catch: Exception -> L50
        int r18 = r0.f();     // Catch: Exception -> L50
        int r19 = r0.g();     // Catch: Exception -> L50
        int r20 = r8.length();     // Catch: Exception -> L50
        int r110 = r20 - 1;     // Catch: Exception -> L50
        Drawable r111 = ContextCompat.getDrawable(r2, r17);     // Catch: Exception -> L50
        if (r111 == null) goto L32;
        int r112 = r111.getIntrinsicWidth();     // Catch: Exception -> L50
    L33:
        int r113 = (r112 + r18) + r19;     // Catch: Exception -> L50
        int r29 = r10;
        boolean r39 = r11;
        io.noties.markwon.core.spans.a.d r114 = new io.noties.markwon.core.spans.a.d(r2, r17, r7, r18, r19, 1, r11);     // Catch: Exception -> L50
        SpannableStringBuilder r115 = r8;
        r115.setSpan(r114, r110, r20, 33);     // Catch: Exception -> L50
        boolean r116 = r39;
        String r117 = r16;
        r115.setSpan(new io.noties.markwon.core.spans.a.c(r36.a(), r117, r116, false), r110, r20, 17);     // Catch: Exception -> L50
    L35:
        int r21 = ZeusTransformUtils.mapRes(R.drawable.markdown_download_button, "drawable", "markdown_download_button");     // Catch: Exception -> L50
        r115.insert(r115.length(), (CharSequence) ZeusTransformUtils.preCheckCast(" ", CharSequence.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L50
        int r1 = r115.length();     // Catch: Exception -> L50
        int r118 = r1 - 1;     // Catch: Exception -> L50
        int r22 = r0.j();     // Catch: Exception -> L50
        int r23 = r0.k();     // Catch: Exception -> L50
        Drawable r24 = ContextCompat.getDrawable(r2, r21);     // Catch: Exception -> L50
        if (r24 == null) goto L38;
        int r25 = r24.getIntrinsicWidth();     // Catch: Exception -> L50
    L39:
        int r119 = r113 + ((r25 + r22) + r23);     // Catch: Exception -> L50
        String r120 = r117;
        SpannableStringBuilder r3 = r115;
        r3.setSpan(new io.noties.markwon.core.spans.a.d(r2, r21, r7, r22, r23, 1, r116), r118, r1, 33);     // Catch: Exception -> L50
        r3.setSpan(new io.noties.markwon.core.spans.a.c(r36.a(), r120, r116, true), r118, r1, 17);     // Catch: Exception -> L50
        boolean r26 = r13.getEnableFullScreenButton();     // Catch: Exception -> L50
        Integer r27 = r0.c();     // Catch: Exception -> L50
        if (r26 == false) goto L47;
        if (r27 == null) goto L47;
        r3.insert(r3.length(), (CharSequence) ZeusTransformUtils.preCheckCast(" ", CharSequence.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L50
        int r28 = r3.length();     // Catch: Exception -> L50
        int r121 = r28 - 1;     // Catch: Exception -> L50
        int r30 = r0.h();     // Catch: Exception -> L50
        int r31 = r0.i();     // Catch: Exception -> L50
        Context r122 = r2;
        Drawable r32 = ContextCompat.getDrawable(r122, r27.intValue());     // Catch: Exception -> L50
        if (r32 == null) goto L45;
        int r40 = r32.getIntrinsicWidth();     // Catch: Exception -> L50
    L46:
        r3.setSpan(new io.noties.markwon.core.spans.a.d(r122, r27.intValue(), r7, r30, r31, 1, r116), r121, r28, 33);     // Catch: Exception -> L50
        r3.setSpan(new b(r36.a(), r36.b(), r120, FullScreenDetailType.TABLE_BLOCK, r116, false, 32, null), r121, r28, 17);     // Catch: Exception -> L50
        r119 = r119 + ((r40 + r30) + r31);     // Catch: Exception -> L50
    L48:
        r3.insert(r3.length(), (CharSequence) ZeusTransformUtils.preCheckCast("\r\n", CharSequence.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L50
        r3.setSpan(new ForegroundColorSpan(ContextCompat.getColor(r122, ZeusTransformUtils.mapRes(R.color.neutral_70, TypedValues.Custom.S_COLOR, "neutral_70"))), 0, r3.length(), 17);     // Catch: Exception -> L50
        r3.setSpan(new AbsoluteSizeSpan(r6, true), 0, r3.length(), 17);     // Catch: Exception -> L50
        int r41 = r0.l();     // Catch: Exception -> L50
        int r42 = r9.length();     // Catch: Exception -> L50
        r3.setSpan(new io.noties.markwon.core.spans.a.f((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"), r34, CollectionsKt.listOf(new Pair(0, Integer.valueOf(r9.length()))), (r12.a().a().c() + r41) + r119, r7), r42, r42 + 1, 33);     // Catch: Exception -> L50
        int r43 = r3.length() - 2;     // Catch: Exception -> L50
        r3.setSpan(new io.noties.markwon.core.spans.a.e(r41, r7), r43, r43 + 1, 33);     // Catch: Exception -> L50
        r12.c().a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L50
        r12.b().b(f.a(), Integer.valueOf(r29));     // Catch: Exception -> L50
        r12.b().b(f.b(), Integer.valueOf(r12.f()));     // Catch: Exception -> L50
        r12.b((Node) ZeusTransformUtils.preCheckCast(r36, Node.class, "com.obric.memorydata.plugin"), r29);     // Catch: Exception -> L50
        return;
    L45:
        r40 = 0;
    L47:
        r122 = r2;
        goto L48
    L38:
        r25 = 0;
        goto L39
    L32:
        r112 = 0;
        goto L33
    L34:
        r29 = r10;
        r117 = r16;
        r116 = r11;
        r115 = r8;
        r113 = 0;
        goto L35
    L26:
        r16 = r36.b();     // Catch: Exception -> L50
        goto L28
    L21:
        if (r14.getCopyExcelStyle() != true) goto L23;
        r15 = true;
        goto L24
    L17:
        r6 = 0;
        goto L18
    L55:
        return;
    L8:
        if (a(r36) == true) goto L11;
        r11 = false;
        goto L53
    }
}
