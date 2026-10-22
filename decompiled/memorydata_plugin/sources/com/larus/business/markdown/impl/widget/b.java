package com.larus.business.markdown.impl.widget;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.ext.tables.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.ext.gfm.strikethrough.Strikethrough;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TableBody;
import org.commonmark.ext.gfm.tables.TableCell;
import org.commonmark.ext.gfm.tables.TableHead;
import org.commonmark.ext.gfm.tables.TableRow;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.BulletList;
import org.commonmark.node.Code;
import org.commonmark.node.Document;
import org.commonmark.node.Emphasis;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.Heading;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.HtmlInline;
import org.commonmark.node.Image;
import org.commonmark.node.IndentedCodeBlock;
import org.commonmark.node.Link;
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.node.ListItem;
import org.commonmark.node.Node;
import org.commonmark.node.OrderedList;
import org.commonmark.node.Paragraph;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.StrongEmphasis;
import org.commonmark.node.Text;
import org.commonmark.node.ThematicBreak;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\rH\u0002J \u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010J\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\f\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\u0013\u001a\u00020\u0012*\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006J\f\u0010\u0015\u001a\u0004\u0018\u00010\u0006*\u00020\u0006J\u0012\u0010\u0016\u001a\u00020\u0012*\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006J\u0012\u0010\u0018\u001a\u00020\u0012*\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006J\u0012\u0010\u0019\u001a\u00020\u0012*\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006J\n\u0010\u001a\u001a\u00020\u0012*\u00020\u0006¨\u0006\u001b"}, d2 = {"Lcom/larus/business/markdown/impl/widget/WidgetUtils;", "", "()V", "checkNodeSame", "", "oldNode", "Lorg/commonmark/node/Node;", "newNode", "checkTreeSame", "oldRoot", "newRoot", "handleHtmlInlineNode", "node", "Lorg/commonmark/node/HtmlInline;", "preorderTraversal", "nodeList", "", "resetTree", "", "appendChildMod", "child", "copy", "insertAfterMod", "sibling", "insertBeforeMod", "prependChildMod", "unlinkMod", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f5271a = null;

    static {
        f5271a = new b();
    }

    private b() {
    }

    private final boolean b(Node r5, Node r6) {
        TableCell r4 = null;
        BulletList r7 = null;
        Code r8 = null;
        Emphasis r9 = null;
        FencedCodeBlock r10 = null;
        Heading r11 = null;
        HtmlInline r12 = null;
        HtmlBlock r13 = null;
        Image r14 = null;
        IndentedCodeBlock r15 = null;
        Link r16 = null;
        OrderedList r17 = null;
        StrongEmphasis r18 = null;
        Text r19 = null;
        LinkReferenceDefinition r20 = null;
        io.noties.markwon.d.a r21 = null;
        io.noties.markwon.ext.tasklist.b r22 = null;
        io.noties.markwon.d.b r23 = null;
        n r24 = null;
        if (r5 == null) goto L7;
        Class<?> r0 = r5.getClass();
        if (r0 == null) goto L7;
        String r1 = r0.getCanonicalName();
    L8:
        if (r6 == null) goto L12;
        Class<?> r2 = r6.getClass();
        if (r2 == null) goto L12;
        String r3 = r2.getCanonicalName();
    L14:
        if (Intrinsics.areEqual(r1, r3) == true) goto L17;
        return false;
    L17:
        if (ZeusTransformUtils.instanceOf(r5, BlockQuote.class) == false) goto L20;
        return true;
    L20:
        if (ZeusTransformUtils.instanceOf(r5, BulletList.class) == false) goto L39;
        if (ZeusTransformUtils.instanceOf(r5, BulletList.class) == false) goto L24;
        BulletList r25 = (BulletList) ZeusTransformUtils.preCheckCast(r5, BulletList.class, "com.obric.memorydata.plugin");
    L25:
        if (r25 != null) goto L28;
        return false;
    L28:
        if (ZeusTransformUtils.instanceOf(r6, BulletList.class) == false) goto L30;
        r7 = (BulletList) ZeusTransformUtils.preCheckCast(r6, BulletList.class, "com.obric.memorydata.plugin");
    L30:
        if (r7 != null) goto L33;
        return false;
    L33:
        if (r25.getBulletMarker() == r7.getBulletMarker()) goto L35;
        return false;
    L35:
        if (r25.isTight() == r7.isTight()) goto L37;
        return false;
    L37:
        return true;
    L24:
        r25 = null;
        goto L25
    L39:
        if (ZeusTransformUtils.instanceOf(r5, Code.class) == false) goto L55;
        if (ZeusTransformUtils.instanceOf(r5, Code.class) == false) goto L43;
        Code r26 = (Code) ZeusTransformUtils.preCheckCast(r5, Code.class, "com.obric.memorydata.plugin");
    L44:
        if (r26 != null) goto L47;
        return false;
    L47:
        if (ZeusTransformUtils.instanceOf(r6, Code.class) == false) goto L49;
        r8 = (Code) ZeusTransformUtils.preCheckCast(r6, Code.class, "com.obric.memorydata.plugin");
    L49:
        if (r8 != null) goto L51;
        return false;
    L51:
        String r27 = r26.getLiteral();
        String r28 = r8.getLiteral();
    L53:
        return Intrinsics.areEqual(r27, r28);
    L43:
        r26 = null;
        goto L44
    L55:
        if (ZeusTransformUtils.instanceOf(r5, Document.class) == false) goto L58;
        return true;
    L58:
        if (ZeusTransformUtils.instanceOf(r5, Emphasis.class) == false) goto L72;
        if (ZeusTransformUtils.instanceOf(r5, Emphasis.class) == false) goto L62;
        Emphasis r29 = (Emphasis) ZeusTransformUtils.preCheckCast(r5, Emphasis.class, "com.obric.memorydata.plugin");
    L63:
        if (r29 != null) goto L66;
        return false;
    L66:
        if (ZeusTransformUtils.instanceOf(r6, Emphasis.class) == false) goto L68;
        r9 = (Emphasis) ZeusTransformUtils.preCheckCast(r6, Emphasis.class, "com.obric.memorydata.plugin");
    L68:
        if (r9 != null) goto L70;
        return false;
    L70:
        r27 = r29.getOpeningDelimiter();
        r28 = r9.getOpeningDelimiter();
        goto L53
    L62:
        r29 = null;
        goto L63
    L72:
        if (ZeusTransformUtils.instanceOf(r5, FencedCodeBlock.class) == false) goto L97;
        if (ZeusTransformUtils.instanceOf(r5, FencedCodeBlock.class) == false) goto L76;
        FencedCodeBlock r30 = (FencedCodeBlock) ZeusTransformUtils.preCheckCast(r5, FencedCodeBlock.class, "com.obric.memorydata.plugin");
    L77:
        if (r30 != null) goto L80;
        return false;
    L80:
        if (ZeusTransformUtils.instanceOf(r6, FencedCodeBlock.class) == false) goto L82;
        r10 = (FencedCodeBlock) ZeusTransformUtils.preCheckCast(r6, FencedCodeBlock.class, "com.obric.memorydata.plugin");
    L82:
        if (r10 != null) goto L85;
        return false;
    L85:
        if (r30.getFenceChar() == r10.getFenceChar()) goto L87;
        return false;
    L87:
        if (r30.getFenceLength() == r10.getFenceLength()) goto L89;
        return false;
    L89:
        if (r30.getFenceIndent() == r10.getFenceIndent()) goto L91;
        return false;
    L91:
        if (Intrinsics.areEqual(r30.getInfo(), r10.getInfo()) == true) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(r30.getLiteral(), r10.getLiteral()) == true) goto L95;
        return false;
    L95:
        return true;
    L76:
        r30 = null;
        goto L77
    L97:
        if (ZeusTransformUtils.instanceOf(r5, HardLineBreak.class) == false) goto L100;
        return true;
    L100:
        if (ZeusTransformUtils.instanceOf(r5, Heading.class) == false) goto L117;
        if (ZeusTransformUtils.instanceOf(r5, Heading.class) == false) goto L104;
        Heading r31 = (Heading) ZeusTransformUtils.preCheckCast(r5, Heading.class, "com.obric.memorydata.plugin");
    L105:
        if (r31 != null) goto L108;
        return false;
    L108:
        if (ZeusTransformUtils.instanceOf(r6, Heading.class) == false) goto L110;
        r11 = (Heading) ZeusTransformUtils.preCheckCast(r6, Heading.class, "com.obric.memorydata.plugin");
    L110:
        if (r11 != null) goto L113;
        return false;
    L113:
        if (r31.getLevel() == r11.getLevel()) goto L115;
        return false;
    L115:
        return true;
    L104:
        r31 = null;
        goto L105
    L117:
        if (ZeusTransformUtils.instanceOf(r5, ThematicBreak.class) == false) goto L120;
        return true;
    L120:
        if (ZeusTransformUtils.instanceOf(r5, HtmlInline.class) == false) goto L134;
        if (ZeusTransformUtils.instanceOf(r5, HtmlInline.class) == false) goto L124;
        HtmlInline r32 = (HtmlInline) ZeusTransformUtils.preCheckCast(r5, HtmlInline.class, "com.obric.memorydata.plugin");
    L125:
        if (r32 != null) goto L128;
        return false;
    L128:
        if (ZeusTransformUtils.instanceOf(r6, HtmlInline.class) == false) goto L130;
        r12 = (HtmlInline) ZeusTransformUtils.preCheckCast(r6, HtmlInline.class, "com.obric.memorydata.plugin");
    L130:
        if (r12 != null) goto L132;
        return false;
    L132:
        r27 = r32.getLiteral();
        r28 = r12.getLiteral();
        goto L53
    L124:
        r32 = null;
        goto L125
    L134:
        if (ZeusTransformUtils.instanceOf(r5, HtmlBlock.class) == false) goto L148;
        if (ZeusTransformUtils.instanceOf(r5, HtmlBlock.class) == false) goto L138;
        HtmlBlock r33 = (HtmlBlock) ZeusTransformUtils.preCheckCast(r5, HtmlBlock.class, "com.obric.memorydata.plugin");
    L139:
        if (r33 != null) goto L142;
        return false;
    L142:
        if (ZeusTransformUtils.instanceOf(r6, HtmlBlock.class) == false) goto L144;
        r13 = (HtmlBlock) ZeusTransformUtils.preCheckCast(r6, HtmlBlock.class, "com.obric.memorydata.plugin");
    L144:
        if (r13 != null) goto L146;
        return false;
    L146:
        r27 = r33.getLiteral();
        r28 = r13.getLiteral();
        goto L53
    L138:
        r33 = null;
        goto L139
    L148:
        if (ZeusTransformUtils.instanceOf(r5, Image.class) == false) goto L167;
        if (ZeusTransformUtils.instanceOf(r5, Image.class) == false) goto L152;
        Image r34 = (Image) ZeusTransformUtils.preCheckCast(r5, Image.class, "com.obric.memorydata.plugin");
    L153:
        if (r34 != null) goto L156;
        return false;
    L156:
        if (ZeusTransformUtils.instanceOf(r6, Image.class) == false) goto L158;
        r14 = (Image) ZeusTransformUtils.preCheckCast(r6, Image.class, "com.obric.memorydata.plugin");
    L158:
        if (r14 != null) goto L161;
        return false;
    L161:
        if (Intrinsics.areEqual(r34.getDestination(), r14.getDestination()) == true) goto L163;
        return false;
    L163:
        if (Intrinsics.areEqual(r34.getTitle(), r14.getTitle()) == true) goto L165;
        return false;
    L165:
        return true;
    L152:
        r34 = null;
        goto L153
    L167:
        if (ZeusTransformUtils.instanceOf(r5, IndentedCodeBlock.class) == false) goto L181;
        if (ZeusTransformUtils.instanceOf(r5, IndentedCodeBlock.class) == false) goto L171;
        IndentedCodeBlock r35 = (IndentedCodeBlock) ZeusTransformUtils.preCheckCast(r5, IndentedCodeBlock.class, "com.obric.memorydata.plugin");
    L172:
        if (r35 != null) goto L175;
        return false;
    L175:
        if (ZeusTransformUtils.instanceOf(r6, IndentedCodeBlock.class) == false) goto L177;
        r15 = (IndentedCodeBlock) ZeusTransformUtils.preCheckCast(r6, IndentedCodeBlock.class, "com.obric.memorydata.plugin");
    L177:
        if (r15 != null) goto L179;
        return false;
    L179:
        r27 = r35.getLiteral();
        r28 = r15.getLiteral();
        goto L53
    L171:
        r35 = null;
        goto L172
    L181:
        if (ZeusTransformUtils.instanceOf(r5, Link.class) == false) goto L200;
        if (ZeusTransformUtils.instanceOf(r5, Link.class) == false) goto L185;
        Link r36 = (Link) ZeusTransformUtils.preCheckCast(r5, Link.class, "com.obric.memorydata.plugin");
    L186:
        if (r36 != null) goto L189;
        return false;
    L189:
        if (ZeusTransformUtils.instanceOf(r6, Link.class) == false) goto L191;
        r16 = (Link) ZeusTransformUtils.preCheckCast(r6, Link.class, "com.obric.memorydata.plugin");
    L191:
        if (r16 != null) goto L194;
        return false;
    L194:
        if (Intrinsics.areEqual(r36.getDestination(), r16.getDestination()) == true) goto L196;
        return false;
    L196:
        if (Intrinsics.areEqual(r36.getTitle(), r16.getTitle()) == true) goto L198;
        return false;
    L198:
        return true;
    L185:
        r36 = null;
        goto L186
    L200:
        if (ZeusTransformUtils.instanceOf(r5, ListItem.class) == false) goto L203;
        return true;
    L203:
        if (ZeusTransformUtils.instanceOf(r5, OrderedList.class) == false) goto L222;
        if (ZeusTransformUtils.instanceOf(r5, OrderedList.class) == false) goto L207;
        OrderedList r37 = (OrderedList) ZeusTransformUtils.preCheckCast(r5, OrderedList.class, "com.obric.memorydata.plugin");
    L208:
        if (r37 != null) goto L211;
        return false;
    L211:
        if (ZeusTransformUtils.instanceOf(r6, OrderedList.class) == false) goto L213;
        r17 = (OrderedList) ZeusTransformUtils.preCheckCast(r6, OrderedList.class, "com.obric.memorydata.plugin");
    L213:
        if (r17 != null) goto L216;
        return false;
    L216:
        if (r37.getOriginalStartNumber() == r17.getOriginalStartNumber()) goto L218;
        return false;
    L218:
        if (r37.getDelimiter() == r17.getDelimiter()) goto L220;
        return false;
    L220:
        return true;
    L207:
        r37 = null;
        goto L208
    L222:
        if (ZeusTransformUtils.instanceOf(r5, Paragraph.class) == false) goto L225;
        return true;
    L225:
        if (ZeusTransformUtils.instanceOf(r5, SoftLineBreak.class) == false) goto L228;
        return true;
    L228:
        if (ZeusTransformUtils.instanceOf(r5, StrongEmphasis.class) == false) goto L242;
        if (ZeusTransformUtils.instanceOf(r5, StrongEmphasis.class) == false) goto L232;
        StrongEmphasis r38 = (StrongEmphasis) ZeusTransformUtils.preCheckCast(r5, StrongEmphasis.class, "com.obric.memorydata.plugin");
    L233:
        if (r38 != null) goto L236;
        return false;
    L236:
        if (ZeusTransformUtils.instanceOf(r6, StrongEmphasis.class) == false) goto L238;
        r18 = (StrongEmphasis) ZeusTransformUtils.preCheckCast(r6, StrongEmphasis.class, "com.obric.memorydata.plugin");
    L238:
        if (r18 != null) goto L240;
        return false;
    L240:
        r27 = r38.getOpeningDelimiter();
        r28 = r18.getOpeningDelimiter();
        goto L53
    L232:
        r38 = null;
        goto L233
    L242:
        if (ZeusTransformUtils.instanceOf(r5, Text.class) == false) goto L256;
        if (ZeusTransformUtils.instanceOf(r5, Text.class) == false) goto L246;
        Text r39 = (Text) ZeusTransformUtils.preCheckCast(r5, Text.class, "com.obric.memorydata.plugin");
    L247:
        if (r39 != null) goto L250;
        return false;
    L250:
        if (ZeusTransformUtils.instanceOf(r6, Text.class) == false) goto L252;
        r19 = (Text) ZeusTransformUtils.preCheckCast(r6, Text.class, "com.obric.memorydata.plugin");
    L252:
        if (r19 != null) goto L254;
        return false;
    L254:
        r27 = r39.getLiteral();
        r28 = r19.getLiteral();
        goto L53
    L246:
        r39 = null;
        goto L247
    L256:
        if (ZeusTransformUtils.instanceOf(r5, LinkReferenceDefinition.class) == false) goto L277;
        if (ZeusTransformUtils.instanceOf(r5, LinkReferenceDefinition.class) == false) goto L260;
        LinkReferenceDefinition r40 = (LinkReferenceDefinition) ZeusTransformUtils.preCheckCast(r5, LinkReferenceDefinition.class, "com.obric.memorydata.plugin");
    L261:
        if (r40 != null) goto L264;
        return false;
    L264:
        if (ZeusTransformUtils.instanceOf(r6, LinkReferenceDefinition.class) == false) goto L266;
        r20 = (LinkReferenceDefinition) ZeusTransformUtils.preCheckCast(r6, LinkReferenceDefinition.class, "com.obric.memorydata.plugin");
    L266:
        if (r20 != null) goto L269;
        return false;
    L269:
        if (Intrinsics.areEqual(r40.getLabel(), r20.getLabel()) == true) goto L271;
        return false;
    L271:
        if (Intrinsics.areEqual(r40.getDestination(), r20.getDestination()) == true) goto L273;
        return false;
    L273:
        if (Intrinsics.areEqual(r40.getTitle(), r20.getTitle()) == true) goto L275;
        return false;
    L275:
        return true;
    L260:
        r40 = null;
        goto L261
    L277:
        if (ZeusTransformUtils.instanceOf(r5, io.noties.markwon.d.a.class) == false) goto L291;
        if (ZeusTransformUtils.instanceOf(r5, io.noties.markwon.d.a.class) == false) goto L281;
        io.noties.markwon.d.a r41 = (io.noties.markwon.d.a) ZeusTransformUtils.preCheckCast(r5, io.noties.markwon.d.a.class, "com.obric.memorydata.plugin");
    L282:
        if (r41 != null) goto L285;
        return false;
    L285:
        if (ZeusTransformUtils.instanceOf(r6, io.noties.markwon.d.a.class) == false) goto L287;
        r21 = (io.noties.markwon.d.a) ZeusTransformUtils.preCheckCast(r6, io.noties.markwon.d.a.class, "com.obric.memorydata.plugin");
    L287:
        if (r21 != null) goto L289;
        return false;
    L289:
        r27 = r41.a();
        r28 = r21.a();
        goto L53
    L281:
        r41 = null;
        goto L282
    L291:
        if (ZeusTransformUtils.instanceOf(r5, io.noties.markwon.ext.tasklist.b.class) == false) goto L308;
        if (ZeusTransformUtils.instanceOf(r5, io.noties.markwon.ext.tasklist.b.class) == false) goto L295;
        io.noties.markwon.ext.tasklist.b r42 = (io.noties.markwon.ext.tasklist.b) ZeusTransformUtils.preCheckCast(r5, io.noties.markwon.ext.tasklist.b.class, "com.obric.memorydata.plugin");
    L296:
        if (r42 != null) goto L299;
        return false;
    L299:
        if (ZeusTransformUtils.instanceOf(r6, io.noties.markwon.ext.tasklist.b.class) == false) goto L301;
        r22 = (io.noties.markwon.ext.tasklist.b) ZeusTransformUtils.preCheckCast(r6, io.noties.markwon.ext.tasklist.b.class, "com.obric.memorydata.plugin");
    L301:
        if (r22 != null) goto L304;
        return false;
    L304:
        if (r42.a() == r22.a()) goto L306;
        return false;
    L306:
        return true;
    L295:
        r42 = null;
        goto L296
    L308:
        if (ZeusTransformUtils.instanceOf(r5, TableBlock.class) == false) goto L311;
        return true;
    L311:
        if (ZeusTransformUtils.instanceOf(r5, io.noties.markwon.d.b.class) == false) goto L325;
        if (ZeusTransformUtils.instanceOf(r5, io.noties.markwon.d.b.class) == false) goto L315;
        io.noties.markwon.d.b r43 = (io.noties.markwon.d.b) ZeusTransformUtils.preCheckCast(r5, io.noties.markwon.d.b.class, "com.obric.memorydata.plugin");
    L316:
        if (r43 != null) goto L319;
        return false;
    L319:
        if (ZeusTransformUtils.instanceOf(r6, io.noties.markwon.d.b.class) == false) goto L321;
        r23 = (io.noties.markwon.d.b) ZeusTransformUtils.preCheckCast(r6, io.noties.markwon.d.b.class, "com.obric.memorydata.plugin");
    L321:
        if (r23 != null) goto L323;
        return false;
    L323:
        r27 = r43.a();
        r28 = r23.a();
        goto L53
    L315:
        r43 = null;
        goto L316
    L325:
        if (ZeusTransformUtils.instanceOf(r5, n.class) == false) goto L344;
        if (ZeusTransformUtils.instanceOf(r5, n.class) == false) goto L329;
        n r44 = (n) ZeusTransformUtils.preCheckCast(r5, n.class, "com.obric.memorydata.plugin");
    L330:
        if (r44 != null) goto L333;
        return false;
    L333:
        if (ZeusTransformUtils.instanceOf(r6, n.class) == false) goto L335;
        r24 = (n) ZeusTransformUtils.preCheckCast(r6, n.class, "com.obric.memorydata.plugin");
    L335:
        if (r24 != null) goto L338;
        return false;
    L338:
        if (Intrinsics.areEqual(r44.a(), r24.a()) == true) goto L340;
        return false;
    L340:
        if (Intrinsics.areEqual(r44.b(), r24.b()) == true) goto L342;
        return false;
    L342:
        return true;
    L329:
        r44 = null;
        goto L330
    L344:
        if (ZeusTransformUtils.instanceOf(r5, Strikethrough.class) == false) goto L347;
        return true;
    L347:
        if (ZeusTransformUtils.instanceOf(r5, TableBody.class) == false) goto L350;
        return true;
    L350:
        if (ZeusTransformUtils.instanceOf(r5, TableCell.class) == false) goto L369;
        if (ZeusTransformUtils.instanceOf(r5, TableCell.class) == false) goto L354;
        TableCell r45 = (TableCell) ZeusTransformUtils.preCheckCast(r5, TableCell.class, "com.obric.memorydata.plugin");
    L355:
        if (r45 != null) goto L358;
        return false;
    L358:
        if (ZeusTransformUtils.instanceOf(r6, TableCell.class) == false) goto L360;
        r4 = (TableCell) ZeusTransformUtils.preCheckCast(r6, TableCell.class, "com.obric.memorydata.plugin");
    L360:
        if (r4 != null) goto L363;
        return false;
    L363:
        if (r45.isHeader() == r4.isHeader()) goto L365;
        return false;
    L365:
        if (r45.getAlignment() == r4.getAlignment()) goto L367;
        return false;
    L367:
        return true;
    L354:
        r45 = null;
        goto L355
    L369:
        if (ZeusTransformUtils.instanceOf(r5, TableHead.class) == false) goto L372;
        return true;
    L372:
        if (ZeusTransformUtils.instanceOf(r5, TableRow.class) == false) goto L374;
        return true;
    L374:
        return false;
    L12:
        r3 = null;
    L7:
        r1 = null;
        goto L8
    }

    public final boolean a(Node r4, Node r5) {
        if (r4 != null) goto L7;
        if (r5 != null) goto L7;
        return true;
    L7:
        if (r4 == null) goto L28;
        if (r5 == null) goto L28;
        if (b(r4, r5) == true) goto L13;
        return false;
    L13:
        Node r6 = r4.firstChild;
        Node r7 = r5.firstChild;
    L14:
        if (r6 != null) goto L19;
        if (r7 != null) goto L19;
        return true;
    L19:
        if (a(r6, r7) == false) goto L20;
        if (r6 == null) goto L24;
        r6 = r6.next;
    L25:
        if (r7 != null) goto L26;
        r7 = null;
        goto L14
    L26:
        r7 = r7.next;
        goto L14
    L24:
        r6 = null;
        goto L25
    L20:
        return false;
    L28:
        return false;
    }
}
