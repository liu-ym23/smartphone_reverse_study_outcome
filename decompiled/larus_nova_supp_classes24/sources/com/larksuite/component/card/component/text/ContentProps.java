package com.larksuite.component.card.component.text;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BÏ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\f\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b \u0010!J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0011\u0010F\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0011\u0010L\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0010HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u001fHÆ\u0003JÓ\u0001\u0010O\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00102\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÆ\u0001J\u0013\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010S\u001a\u00020THÖ\u0001J\t\u0010U\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0019\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b9\u0010,R\u0019\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b:\u00100R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>¨\u0006V"}, d2 = {"Lcom/larksuite/component/card/component/text/ContentProps;", "", "id", "", "tag", "atProps", "Lcom/larksuite/component/card/component/text/AtProps;", "linkProps", "Lcom/larksuite/component/card/component/text/LinkProps;", "emojProps", "Lcom/larksuite/component/card/component/text/EmojProps;", "plainTextProps", "Lcom/larksuite/component/card/component/text/PlainTextProps;", "textTagProps", "Lcom/larksuite/component/card/component/text/TagProps;", "listProps", "", "Lcom/larksuite/component/card/component/text/ListItem;", "codeBlockProps", "Lcom/larksuite/component/card/component/text/CardCodeBlockProps;", "imageProps", "Lcom/larksuite/component/card/component/image/ImageContentProps;", "personProps", "Lcom/larksuite/component/card/component/text/PersonProps;", "headingProps", "Lcom/larksuite/component/card/component/text/HeadingProps;", "codeSpanProps", "blockQuoteProps", "numberTagProps", "Lcom/larksuite/component/card/component/text/NumberTagProps;", "audioProps", "Lcom/larksuite/component/card/component/text/AudioProps;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/larksuite/component/card/component/text/AtProps;Lcom/larksuite/component/card/component/text/LinkProps;Lcom/larksuite/component/card/component/text/EmojProps;Lcom/larksuite/component/card/component/text/PlainTextProps;Lcom/larksuite/component/card/component/text/TagProps;Ljava/util/List;Lcom/larksuite/component/card/component/text/CardCodeBlockProps;Lcom/larksuite/component/card/component/image/ImageContentProps;Lcom/larksuite/component/card/component/text/PersonProps;Lcom/larksuite/component/card/component/text/HeadingProps;Lcom/larksuite/component/card/component/text/PlainTextProps;Ljava/util/List;Lcom/larksuite/component/card/component/text/NumberTagProps;Lcom/larksuite/component/card/component/text/AudioProps;)V", "getId", "()Ljava/lang/String;", "getTag", "getAtProps", "()Lcom/larksuite/component/card/component/text/AtProps;", "getLinkProps", "()Lcom/larksuite/component/card/component/text/LinkProps;", "getEmojProps", "()Lcom/larksuite/component/card/component/text/EmojProps;", "getPlainTextProps", "()Lcom/larksuite/component/card/component/text/PlainTextProps;", "getTextTagProps", "()Lcom/larksuite/component/card/component/text/TagProps;", "getListProps", "()Ljava/util/List;", "getCodeBlockProps", "()Lcom/larksuite/component/card/component/text/CardCodeBlockProps;", "getImageProps", "()Lcom/larksuite/component/card/component/image/ImageContentProps;", "getPersonProps", "()Lcom/larksuite/component/card/component/text/PersonProps;", "getHeadingProps", "()Lcom/larksuite/component/card/component/text/HeadingProps;", "getCodeSpanProps", "getBlockQuoteProps", "getNumberTagProps", "()Lcom/larksuite/component/card/component/text/NumberTagProps;", "getAudioProps", "()Lcom/larksuite/component/card/component/text/AudioProps;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "equals", "", "other", "hashCode", "", "toString", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class ContentProps {
    private final AtProps atProps;
    private final AudioProps audioProps;
    private final List<ContentProps> blockQuoteProps;
    private final CardCodeBlockProps codeBlockProps;
    private final PlainTextProps codeSpanProps;
    private final EmojProps emojProps;
    private final HeadingProps headingProps;
    private final String id;
    private final com.larksuite.component.card.component.image.a imageProps;
    private final LinkProps linkProps;
    private final List<ListItem> listProps;
    private final NumberTagProps numberTagProps;
    private final PersonProps personProps;
    private final PlainTextProps plainTextProps;
    private final String tag;
    private final TagProps textTagProps;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ContentProps copy$default(ContentProps r17, String r19, String r110, AtProps r20, LinkProps r21, EmojProps r22, PlainTextProps r23, TagProps r24, List r25, CardCodeBlockProps r26, com.larksuite.component.card.component.image.a r27, PersonProps r29, HeadingProps r210, PlainTextProps r30, List r31, NumberTagProps r32, AudioProps r33, int r34, Object r35) {
        if ((r34 & 1) == 0) goto L5;
        String r2 = r17.id;
    L7:
        if ((r34 & 2) == 0) goto L9;
        String r3 = r17.tag;
    L11:
        if ((r34 & 4) == 0) goto L13;
        AtProps r4 = r17.atProps;
    L15:
        if ((r34 & 8) == 0) goto L17;
        LinkProps r5 = r17.linkProps;
    L19:
        if ((r34 & 16) == 0) goto L21;
        EmojProps r6 = r17.emojProps;
    L23:
        if ((r34 & 32) == 0) goto L25;
        PlainTextProps r7 = r17.plainTextProps;
    L27:
        if ((r34 & 64) == 0) goto L29;
        TagProps r8 = r17.textTagProps;
    L31:
        if ((r34 & 128) == 0) goto L33;
        List r9 = r17.listProps;
    L35:
        if ((r34 & 256) == 0) goto L37;
        CardCodeBlockProps r10 = r17.codeBlockProps;
    L39:
        if ((r34 & 512) == 0) goto L41;
        com.larksuite.component.card.component.image.a r11 = r17.imageProps;
    L43:
        if ((r34 & 1024) == 0) goto L45;
        PersonProps r12 = r17.personProps;
    L47:
        if ((r34 & 2048) == 0) goto L49;
        HeadingProps r13 = r17.headingProps;
    L51:
        if ((r34 & 4096) == 0) goto L53;
        PlainTextProps r14 = r17.codeSpanProps;
    L55:
        if ((r34 & 8192) == 0) goto L57;
        List r15 = r17.blockQuoteProps;
    L58:
        List r36 = r15;
        if ((r34 & 16384) == 0) goto L61;
        NumberTagProps r16 = r17.numberTagProps;
    L63:
        if ((r34 & 32768) == 0) goto L65;
        AudioProps r1 = r17.audioProps;
    L67:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r36, r16, r1);
    L65:
        r1 = r33;
        goto L67
    L61:
        r16 = r32;
        goto L63
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r210;
        goto L51
    L45:
        r12 = r29;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r110;
        goto L11
    L5:
        r2 = r19;
        goto L7
    }

    public final String component1() {
        return this.id;
    }

    public final com.larksuite.component.card.component.image.a component10() {
        return this.imageProps;
    }

    public final PersonProps component11() {
        return this.personProps;
    }

    public final HeadingProps component12() {
        return this.headingProps;
    }

    public final PlainTextProps component13() {
        return this.codeSpanProps;
    }

    public final List<ContentProps> component14() {
        return this.blockQuoteProps;
    }

    public final NumberTagProps component15() {
        return this.numberTagProps;
    }

    public final AudioProps component16() {
        return this.audioProps;
    }

    public final String component2() {
        return this.tag;
    }

    public final AtProps component3() {
        return this.atProps;
    }

    public final LinkProps component4() {
        return this.linkProps;
    }

    public final EmojProps component5() {
        return this.emojProps;
    }

    public final PlainTextProps component6() {
        return this.plainTextProps;
    }

    public final TagProps component7() {
        return this.textTagProps;
    }

    public final List<ListItem> component8() {
        return this.listProps;
    }

    public final CardCodeBlockProps component9() {
        return this.codeBlockProps;
    }

    public final ContentProps copy(String r19, String r20, AtProps r21, LinkProps r22, EmojProps r23, PlainTextProps r24, TagProps r25, List<ListItem> r26, CardCodeBlockProps r27, com.larksuite.component.card.component.image.a r29, PersonProps r210, HeadingProps r30, PlainTextProps r31, List<ContentProps> r32, NumberTagProps r33, AudioProps r34) {
        Intrinsics.checkNotNullParameter(r20, "tag");
        return new ContentProps(r19, r20, r21, r22, r23, r24, r25, r26, r27, r29, r210, r30, r31, r32, r33, r34);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ContentProps) == true) goto L8;
        return false;
    L8:
        ContentProps r6 = (ContentProps) r5;
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tag, r6.tag) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.atProps, r6.atProps) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.linkProps, r6.linkProps) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.emojProps, r6.emojProps) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.plainTextProps, r6.plainTextProps) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.textTagProps, r6.textTagProps) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.listProps, r6.listProps) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.codeBlockProps, r6.codeBlockProps) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.imageProps, r6.imageProps) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.personProps, r6.personProps) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.headingProps, r6.headingProps) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.codeSpanProps, r6.codeSpanProps) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.blockQuoteProps, r6.blockQuoteProps) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.numberTagProps, r6.numberTagProps) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.audioProps, r6.audioProps) == true) goto L56;
        return false;
    L56:
        return true;
    }

    public int hashCode() {
        String r0 = this.id;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.tag.hashCode()) * 31;
        AtProps r4 = this.atProps;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        LinkProps r7 = this.linkProps;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        EmojProps r10 = this.emojProps;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        PlainTextProps r13 = this.plainTextProps;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        TagProps r16 = this.textTagProps;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r19 = (r15 + r17) * 31;
        List<ListItem> r20 = this.listProps;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        CardCodeBlockProps r23 = this.codeBlockProps;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        com.larksuite.component.card.component.image.a r26 = this.imageProps;
        if (r26 != null) goto L37;
        int r27 = 0;
    L38:
        int r29 = (r25 + r27) * 31;
        PersonProps r30 = this.personProps;
        if (r30 != null) goto L41;
        int r31 = 0;
    L42:
        int r32 = (r29 + r31) * 31;
        HeadingProps r33 = this.headingProps;
        if (r33 != null) goto L45;
        int r34 = 0;
    L46:
        int r35 = (r32 + r34) * 31;
        PlainTextProps r36 = this.codeSpanProps;
        if (r36 != null) goto L49;
        int r37 = 0;
    L50:
        int r38 = (r35 + r37) * 31;
        List<ContentProps> r39 = this.blockQuoteProps;
        if (r39 != null) goto L53;
        int r40 = 0;
    L54:
        int r41 = (r38 + r40) * 31;
        NumberTagProps r42 = this.numberTagProps;
        if (r42 != null) goto L57;
        int r43 = 0;
    L58:
        int r44 = (r41 + r43) * 31;
        AudioProps r45 = this.audioProps;
        if (r45 == null) goto L63;
        r1 = r45.hashCode();
    L63:
        return r44 + r1;
    L57:
        r43 = r42.hashCode();
        goto L58
    L53:
        r40 = r39.hashCode();
        goto L54
    L49:
        r37 = r36.hashCode();
        goto L50
    L45:
        r34 = r33.hashCode();
        goto L46
    L41:
        r31 = r30.hashCode();
        goto L42
    L37:
        r27 = r26.hashCode();
        goto L38
    L33:
        r24 = r23.hashCode();
        goto L34
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ContentProps(id=" + this.id + ", tag=" + this.tag + ", atProps=" + this.atProps + ", linkProps=" + this.linkProps + ", emojProps=" + this.emojProps + ", plainTextProps=" + this.plainTextProps + ", textTagProps=" + this.textTagProps + ", listProps=" + this.listProps + ", codeBlockProps=" + this.codeBlockProps + ", imageProps=" + this.imageProps + ", personProps=" + this.personProps + ", headingProps=" + this.headingProps + ", codeSpanProps=" + this.codeSpanProps + ", blockQuoteProps=" + this.blockQuoteProps + ", numberTagProps=" + this.numberTagProps + ", audioProps=" + this.audioProps + ')';
    }

    public final AtProps getAtProps() {
        return this.atProps;
    }

    public final AudioProps getAudioProps() {
        return this.audioProps;
    }

    public final List<ContentProps> getBlockQuoteProps() {
        return this.blockQuoteProps;
    }

    public final CardCodeBlockProps getCodeBlockProps() {
        return this.codeBlockProps;
    }

    public final PlainTextProps getCodeSpanProps() {
        return this.codeSpanProps;
    }

    public final EmojProps getEmojProps() {
        return this.emojProps;
    }

    public final HeadingProps getHeadingProps() {
        return this.headingProps;
    }

    public final String getId() {
        return this.id;
    }

    public final com.larksuite.component.card.component.image.a getImageProps() {
        return this.imageProps;
    }

    public final LinkProps getLinkProps() {
        return this.linkProps;
    }

    public final List<ListItem> getListProps() {
        return this.listProps;
    }

    public final NumberTagProps getNumberTagProps() {
        return this.numberTagProps;
    }

    public final PersonProps getPersonProps() {
        return this.personProps;
    }

    public final PlainTextProps getPlainTextProps() {
        return this.plainTextProps;
    }

    public final String getTag() {
        return this.tag;
    }

    public final TagProps getTextTagProps() {
        return this.textTagProps;
    }

    public ContentProps(String r4, String r5, AtProps r6, LinkProps r7, EmojProps r8, PlainTextProps r9, TagProps r10, List<ListItem> r11, CardCodeBlockProps r12, com.larksuite.component.card.component.image.a r13, PersonProps r14, HeadingProps r15, PlainTextProps r16, List<ContentProps> r17, NumberTagProps r19, AudioProps r110) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        this.id = r4;
        this.tag = r5;
        this.atProps = r6;
        this.linkProps = r7;
        this.emojProps = r8;
        this.plainTextProps = r9;
        this.textTagProps = r10;
        this.listProps = r11;
        this.codeBlockProps = r12;
        this.imageProps = r13;
        this.personProps = r14;
        this.headingProps = r15;
        this.codeSpanProps = r16;
        this.blockQuoteProps = r17;
        this.numberTagProps = r19;
        this.audioProps = r110;
    }

    public /* synthetic */ ContentProps(String r21, String r22, AtProps r23, LinkProps r24, EmojProps r25, PlainTextProps r26, TagProps r27, List r29, CardCodeBlockProps r210, com.larksuite.component.card.component.image.a r30, PersonProps r31, HeadingProps r32, PlainTextProps r33, List r34, NumberTagProps r35, AudioProps r36, int r37, DefaultConstructorMarker r38) {
        if ((r37 & 1) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r37 & 4) == 0) goto L9;
        AtProps r6 = null;
    L11:
        if ((r37 & 8) == 0) goto L13;
        LinkProps r7 = null;
    L15:
        if ((r37 & 16) == 0) goto L17;
        EmojProps r8 = null;
    L19:
        if ((r37 & 32) == 0) goto L21;
        PlainTextProps r9 = null;
    L23:
        if ((r37 & 64) == 0) goto L25;
        TagProps r10 = null;
    L27:
        if ((r37 & 128) == 0) goto L29;
        List r11 = null;
    L31:
        if ((r37 & 256) == 0) goto L33;
        CardCodeBlockProps r12 = null;
    L35:
        if ((r37 & 512) == 0) goto L37;
        com.larksuite.component.card.component.image.a r13 = null;
    L39:
        if ((r37 & 1024) == 0) goto L41;
        PersonProps r14 = null;
    L43:
        if ((r37 & 2048) == 0) goto L45;
        HeadingProps r15 = null;
    L47:
        if ((r37 & 4096) == 0) goto L49;
        PlainTextProps r16 = null;
    L51:
        if ((r37 & 8192) == 0) goto L53;
        List r17 = null;
    L55:
        if ((r37 & 16384) == 0) goto L57;
        NumberTagProps r19 = null;
    L59:
        if ((r37 & 32768) == 0) goto L61;
        AudioProps r110 = null;
    L62:
        this(r4, r22, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r19, r110);
        return;
    L61:
        r110 = r36;
        goto L62
    L57:
        r19 = r35;
        goto L59
    L53:
        r17 = r34;
        goto L55
    L49:
        r16 = r33;
        goto L51
    L45:
        r15 = r32;
        goto L47
    L41:
        r14 = r31;
        goto L43
    L37:
        r13 = r30;
        goto L39
    L33:
        r12 = r210;
        goto L35
    L29:
        r11 = r29;
        goto L31
    L25:
        r10 = r27;
        goto L27
    L21:
        r9 = r26;
        goto L23
    L17:
        r8 = r25;
        goto L19
    L13:
        r7 = r24;
        goto L15
    L9:
        r6 = r23;
        goto L11
    L5:
        r4 = r21;
        goto L7
    }
}
