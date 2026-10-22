package com.ss.android.lark.chat.utils;

import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.webkit.URLUtil;
import com.ss.android.lark.coremdbiz.facade.node.MarkdownInfo;
import com.ss.android.lark.widget.codeblock.preview.CodeBlockV2Info;
import com.ss.android.lark.widget.columns.entity.ColumnsInfo;
import com.ss.android.lark.widget.richtext.Image;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextElementCreator;
import com.ss.android.lark.widget.richtext.genv2.RichTextGenerateUtils2;
import com.ss.android.lark.widget.span.AtInfo;
import com.ss.android.lark.widget.span.AtUserGroupInfo;
import com.ss.android.lark.widget.span.EmojiconInfo;
import com.ss.android.lark.widget.span.HRInfo;
import com.ss.android.lark.widget.span.ImageGalleryInfo;
import com.ss.android.lark.widget.span.ImageInfo;
import com.ss.android.lark.widget.span.KeyIconUrlInfo;
import com.ss.android.lark.widget.span.MediaInfo;
import com.ss.android.lark.widget.span.PrefixInfo;
import com.ss.android.lark.widget.span.PrefixSpan;
import com.ss.android.lark.widget.span.RichUrlInfo;
import com.ss.android.lark.widget.span.SpanInfo;
import com.ss.android.lark.widget.span.SpecialLinkUrlInfo;
import com.ss.android.lark.widget.span.UrlInfo;
import com.ss.android.lark.widget.table.entity.TableInfo;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class l0 implements RichTextGenerateUtils2.a, com.ss.android.lark.keyboard.edittext2.utils.f.a {
    public static final l0 a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[PrefixSpan.Type.values().length];
            r0[PrefixSpan.Type.QUOTE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L27:
            r0[PrefixSpan.Type.LEFT_MARGIN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L37:
            r0[PrefixSpan.Type.LIST_NUM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L29:
            r0[PrefixSpan.Type.FILL_CIRCLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L31:
            r0[PrefixSpan.Type.HOLLOW_CIRCLE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L23:
            r0[PrefixSpan.Type.FILL_RECT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L10:
            a = r0;
            int[] r1 = new int[SpecialLinkUrlInfo.LinkType.values().length];
            r1[SpecialLinkUrlInfo.LinkType.PossibleLink.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L33:
            r1[SpecialLinkUrlInfo.LinkType.CustomLink.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L13:
            b = r1;
        }
    }

    static {
        a = new l0();
    }

    public l0() {
    }

    public static RichTextElement.AnchorProperty g(UrlInfo r3) {
        String r0 = StringsKt.trim(((SpanInfo) r3).text.substring(1)).toString();
        String r1 = r3.content;
        String r4 = r3.href;
        if (URLUtil.isNetworkUrl(r1) == false) goto L10;
        int r2 = com.ss.android.lark.keyboard.edittext2.utils.a.a;
        Intrinsics.checkNotNull(r4);
        if (com.ss.android.lark.keyboard.edittext2.utils.a.a(r4) == true) goto L9;
        r1 = r4;
    L9:
        r4 = r1;
    L10:
        if (r4 != null) goto L12;
        r4 = BuildConfig.FLAVOR;
    L12:
        RichTextElement.AnchorProperty r5 = RichTextElementCreator.a(r0, r4);
        r5.setDisplayTitle(r0);
        return r5;
    }

    public final RichTextElement a(Object r11) {
        Intrinsics.checkNotNullParameter(r11, "span");
        if ((r11 instanceof com.ss.android.lark.widget.light.span.p) == true) goto L5;
        return null;
    L5:
        Object r12 = ((com.ss.android.lark.widget.light.span.p) r11).b;
        if ((r12 instanceof RichUrlInfo) == false) goto L9;
        RichTextElement.AnchorProperty r0 = g((UrlInfo) r12);
        r0.setLocalIconRes(((RichUrlInfo) r12).mLocalImageResId);
        return RichTextElementCreator.h(r0);
    L9:
        if ((r12 instanceof KeyIconUrlInfo) == false) goto L11;
        RichTextElement.AnchorProperty r1 = g((UrlInfo) r12);
        KeyIconUrlInfo r13 = (KeyIconUrlInfo) r12;
        r1.setIconKey(r13.iconKey);
        r1.setFaviconUrl(r13.faviconUrl);
        r1.setColorIcon(r13.isColorIcon);
        r1.setLocalIconRes(r13.placeHolderRes);
        return RichTextElementCreator.h(r1);
    L11:
        boolean r2 = r12 instanceof SpecialLinkUrlInfo;
        int r3 = -1;
        boolean r4 = true;
        String r5 = BuildConfig.FLAVOR;
        if (r2 == false) goto L28;
        SpecialLinkUrlInfo r14 = (SpecialLinkUrlInfo) r12;
        String r6 = ((SpanInfo) r14).text;
        if (r6 == null) goto L17;
        r5 = r6;
    L17:
        RichTextElement.AnchorProperty r7 = RichTextElementCreator.a(r5, ((UrlInfo) r14).href);
        SpecialLinkUrlInfo.LinkType r15 = r14.linkType;
        if (r15 == null) goto L21;
        r3 = a.b[r15.ordinal()];
    L21:
        if (r3 == 1) goto L25;
        if (r3 != 2) goto L161;
        r7.setCustom(true);
    L161:
        return RichTextElementCreator.h(r7);
    L25:
        r7.setScene(RichTextElement.AnchorProperty.Scene.COPY_PASTE_TEXT);
        goto L161
    L28:
        if ((r12 instanceof UrlInfo) == false) goto L35;
        UrlInfo r16 = (UrlInfo) r12;
        String r8 = ((SpanInfo) r16).text;
        if (r8 == null) goto L33;
        r5 = r8;
    L33:
        RichTextElement.AnchorProperty r17 = RichTextElementCreator.a(r5, r16.href);
        r17.setCustom(true);
        return RichTextElementCreator.h(r17);
    L35:
        if ((r12 instanceof EmojiconInfo) == false) goto L38;
        String r18 = ((EmojiconInfo) r12).key;
        Map r9 = RichTextElementCreator.a;
        Intrinsics.checkNotNullParameter(r18, "emojiKey");
        RichTextElement.EmotionProperty r10 = new RichTextElement.EmotionProperty();
        r10.setKey(r18);
        return RichTextElementCreator.h(r10);
    L38:
        if ((r12 instanceof CodeBlockV2Info) == false) goto L41;
        CodeBlockV2Info r19 = (CodeBlockV2Info) r12;
        RichTextElement.CodeBlockV2Property r20 = new RichTextElement.CodeBlockV2Property();
        r20.setLineContents(r19.getLineContents());
        r20.setLanguage(RichTextElement.CodeBlockV2Property.Language.fromValue(r19.getLanguageValue()));
        r20.setWordWrap(r19.getWordWrap());
        r20.setVersion(r19.getVersion());
        return RichTextElementCreator.h(r20);
    L41:
        if ((r12 instanceof ImageInfo) == false) goto L44;
        ImageInfo r110 = (ImageInfo) r12;
        RichTextElement.ImageProperty r21 = RichTextElementCreator.c(r110.url, r110.token, r110.width, r110.height, false, r110.resourceCleanScene);
        r21.setOriginKey(r110.key);
        return RichTextElementCreator.h(r21);
    L44:
        if ((r12 instanceof MediaInfo) == false) goto L67;
        MediaInfo r111 = (MediaInfo) r12;
        RichTextElement.MediaProperty r22 = new RichTextElement.MediaProperty();
        r22.setDuration(r111.durationMills);
        String r23 = r111.key;
        if (r23 != null) goto L48;
        r23 = BuildConfig.FLAVOR;
    L48:
        r22.setKey(r23);
        String r24 = r111.url;
        if (r24 != null) goto L51;
        r24 = BuildConfig.FLAVOR;
    L51:
        r22.setUrl(r24);
        String r25 = r111.cryptoToken;
        if (r25 != null) goto L54;
        r25 = BuildConfig.FLAVOR;
    L54:
        r22.setCryptoToken(r25);
        String r26 = r111.originPath;
        if (r26 != null) goto L57;
        r26 = BuildConfig.FLAVOR;
    L57:
        r22.setOriginPath(r26);
        String r27 = r111.mimeType;
        if (r27 == null) goto L61;
        r5 = r27;
    L61:
        r22.setMime(r5);
        r22.setResourceCleanScene(r111.resourceCleanScene);
        r22.setWidth(r111.width);
        r22.setHeight(r111.height);
        Image r28 = new Image();
        r28.setKey(r111.originImageInfo.key);
        r28.setUrls(CollectionsKt.listOf(r111.originImageInfo.url));
        r28.setWidth(r111.originImageInfo.width);
        r28.setHeight(r111.originImageInfo.height);
        r28.setToken(r111.originImageInfo.token);
        r28.setResourceCleanScene(r111.resourceCleanScene);
        if (r111.resourceCleanScene != null) goto L65;
        r4 = false;
    L65:
        r28.setResourceIsCleaned(r4);
        r22.setOriginImage(r28);
        return RichTextElementCreator.h(r22);
    L67:
        if ((r12 instanceof AtInfo) == false) goto L70;
        AtInfo r112 = (AtInfo) r12;
        RichTextElement.AtProperty r29 = new RichTextElement.AtProperty();
        r29.setUserId(r112.userId);
        r29.setOriginUserName(BuildConfig.FLAVOR);
        r29.setContent(((SpanInfo) r112).text);
        r29.setOutChatUser(r112.isOutChatUser);
        r29.setAnonymous(r112.isAnonymous);
        return RichTextElementCreator.h(r29);
    L70:
        if ((r12 instanceof HRInfo) == false) goto L73;
        return RichTextElementCreator.h(new RichTextElement.HRProperty());
    L73:
        if ((r12 instanceof TableInfo) == false) goto L97;
        TableInfo r113 = (TableInfo) r12;
        int r30 = r113.getRowSpan() * r113.getColumnSpan();
        String r31 = BuildConfig.FLAVOR;
        int r32 = 0;
    L75:
        if (r32 >= r30) goto L95;
        HashMap r33 = r113.getTableCellPropertyMap();
        if (r33 == null) goto L81;
        TableInfo.TableCellPropertyWrapper r34 = (TableInfo.TableCellPropertyWrapper) r33.get(Integer.valueOf(r32));
        if (r34 == null) goto L81;
        Layout r35 = r34.getLayout();
    L82:
        if (r35 == null) goto L85;
        CharSequence r36 = r35.getText();
        if (r36 == null) goto L85;
    L87:
        if (r36.length() <= 0) goto L89;
        boolean r37 = true;
    L90:
        if (r37 == false) goto L94;
        r31 = r31 + r36;
        if (r32 == (r30 - 1)) goto L94;
        r31 = r31 + '\n';
    L94:
        r32 = r32 + 1;
        goto L75
    L89:
        r37 = false;
    L85:
        r36 = BuildConfig.FLAVOR;
    L81:
        r35 = null;
        goto L82
    L95:
        RichTextElement.TextProperty r114 = new RichTextElement.TextProperty();
        r114.setContent(r31);
        return RichTextElementCreator.h(r114);
    L97:
        if ((r12 instanceof ColumnsInfo) == false) goto L119;
        ColumnsInfo r115 = (ColumnsInfo) r12;
        int r38 = r115.getColumnsSize();
        String r39 = BuildConfig.FLAVOR;
        int r40 = 0;
    L99:
        if (r40 >= r38) goto L117;
        HashMap r41 = r115.getColumnsContentLayout();
        if (r41 == null) goto L103;
        Layout r42 = (Layout) r41.get(Integer.valueOf(r40));
    L104:
        if (r42 == null) goto L107;
        CharSequence r43 = r42.getText();
        if (r43 == null) goto L107;
    L109:
        if (r43.length() <= 0) goto L111;
        boolean r44 = true;
    L112:
        if (r44 == false) goto L116;
        r39 = r39 + r43;
        if (r40 == (r38 - 1)) goto L116;
        r39 = r39 + '\n';
    L116:
        r40 = r40 + 1;
        goto L99
    L111:
        r44 = false;
    L107:
        r43 = BuildConfig.FLAVOR;
        goto L109
    L103:
        r42 = null;
        goto L104
    L117:
        RichTextElement.TextProperty r116 = new RichTextElement.TextProperty();
        r116.setContent(r39);
        return RichTextElementCreator.h(r116);
    L119:
        if ((r12 instanceof AtUserGroupInfo) == false) goto L122;
        AtUserGroupInfo r117 = (AtUserGroupInfo) r12;
        RichTextElement.AtUserGroupProperty r45 = new RichTextElement.AtUserGroupProperty();
        r45.setUserGroupId(r117.getUserGroupId());
        r45.setDefaultGroupName(r117.getUserGroupName());
        r45.setDisplayName(r117.getUserGroupName());
        r45.setPermissionStatus(r117.getPermissionStatus());
        return RichTextElementCreator.h(r45);
    L122:
        if ((r12 instanceof PrefixInfo) == false) goto L145;
        PrefixInfo r118 = (PrefixInfo) r12;
        PrefixSpan.Type r46 = r118.prefixParams.getType();
        if (r46 == null) goto L127;
        r3 = a.a[r46.ordinal()];
    L127:
        if (r3 == 1) goto L143;
        if (r3 != 2) goto L130;
        return null;
    L130:
        if (r3 == 3) goto L142;
        RichTextElement.LIProperty r47 = new RichTextElement.LIProperty();
        r47.setFloor(r118.prefixParams.j);
        r47.setListNum("- ");
        RichTextElement.ULProperty r48 = new RichTextElement.ULProperty();
        int r119 = a.a[r118.prefixParams.getType().ordinal()];
        if (r119 != 4) goto L134;
        RichTextElement.ULProperty.Type r120 = RichTextElement.ULProperty.Type.DISC;
    L141:
        r48.setType(r120);
        RichTextElement r121 = RichTextElementCreator.h(r47);
        r121.getElementExtra().getFloorInfo().setFloorProperty(r48);
        return r121;
    L134:
        if (r119 != 5) goto L136;
        r120 = RichTextElement.ULProperty.Type.CIRCLE;
        goto L141
    L136:
        if (r119 == 6) goto L138;
        r120 = RichTextElement.ULProperty.Type.NONE;
        goto L141
    L138:
        r120 = RichTextElement.ULProperty.Type.SQUARE;
        goto L141
    L142:
        RichTextElement.LIProperty r49 = new RichTextElement.LIProperty();
        PrefixSpan.b r122 = r118.prefixParams;
        r49.setFloor(r122.j);
        r49.setListNum(r122.g);
        RichTextElement r50 = RichTextElementCreator.h(r49);
        RichTextElement.OLProperty r51 = new RichTextElement.OLProperty();
        r51.setStart(r122.k);
        r51.setType(RichTextElement.OLProperty.Type.forType(r122.l.getValue()));
        r50.getElementExtra().getFloorInfo().setFloorProperty(r51);
        return r50;
    L143:
        Map r123 = RichTextElementCreator.a;
        return RichTextElementCreator.h(new RichTextElement.QuoteProperty());
    L145:
        if ((r12 instanceof ImageGalleryInfo) == false) goto L148;
        RichTextElement r52 = new RichTextElement();
        r52.setProperty(new RichTextElement.ImageGalleryProperty());
        r52.setTag(RichTextElement.RichTextTag.IMAGE_GALLERY);
        return r52;
    L148:
        if ((r12 instanceof MarkdownInfo) == false) goto L177;
        RichTextElement.MarkdownProperty r53 = new RichTextElement.MarkdownProperty();
        r53.setContent(((MarkdownInfo) r12).getContent());
        return RichTextElementCreator.h(r53);
    L177:
        return null;
    }

    public final List<jec.c> b(Object r9) {
        Intrinsics.checkNotNullParameter(r9, "span");
        if ((r9 instanceof com.ss.android.lark.widget.light.span.p) == false) goto L5;
        Object r10 = ((com.ss.android.lark.widget.light.span.p) r9).b;
        if ((r10 instanceof ImageGalleryInfo) == false) goto L13;
        ArrayList r11 = ((ImageGalleryInfo) r10).getImageInfo();
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator r12 = r11.iterator();
    L10:
        if (r12.hasNext() == false) goto L15;
        ImageInfo r1 = (ImageInfo) r12.next();
        RichTextElement.ImageProperty r2 = RichTextElementCreator.c(r1.url, r1.token, r1.width, r1.height, false, r1.resourceCleanScene);
        r2.setOriginKey(r1.key);
        r2.setAlt(((SpanInfo) r1).text);
        r0.add(new jec.c(RichTextElementCreator.h(r2), new ArrayList()));
        goto L10
    L15:
        return r0;
    L13:
        return CollectionsKt.emptyList();
    L5:
        return CollectionsKt.emptyList();
    }

    public final boolean d(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "span");
        if ((r2 instanceof com.ss.android.lark.widget.light.span.p) == true) goto L7;
        return false;
    L7:
        return ((com.ss.android.lark.widget.light.span.p) r2).b instanceof PrefixInfo;
    }

    public final void e(Spanned r8, List<Object> r9) {
        Intrinsics.checkNotNullParameter(r8, "editable");
        Intrinsics.checkNotNullParameter(r9, "spans");
        int r2 = 0;
        com.ss.android.lark.widget.light.span.p[] r0 = (com.ss.android.lark.widget.light.span.p[]) r8.getSpans(0, r8.length(), com.ss.android.lark.widget.light.span.p.class);
        Intrinsics.checkNotNull(r0);
        ArrayList r1 = new ArrayList();
        int r3 = r0.length;
    L3:
        if (r2 >= r3) goto L11;
        com.ss.android.lark.widget.light.span.p r4 = r0[r2];
        String r5 = r8.subSequence(r8.getSpanStart(r4), r8.getSpanEnd(r4)).toString();
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "what");
        if (r4.d == false) goto L7;
        boolean r6 = Intrinsics.areEqual(r5, r4.c);
    L8:
        if (r6 == false) goto L10;
        r1.add(r4);
    L10:
        r2 = r2 + 1;
        goto L3
    L7:
        r6 = true;
        goto L8
    L11:
        ((ArrayList) r9).addAll(r1);
    }

    public final RichTextGenerateUtils2.OverlappingResult f(RichTextGenerateUtils2.b r6, RichTextGenerateUtils2.b r7) {
        Intrinsics.checkNotNullParameter(r6, "first");
        Intrinsics.checkNotNullParameter(r7, "second");
        Object r2 = r6.a;
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.ss.android.lark.widget.light.span.RichTextTagHolder");
        Object r3 = ((com.ss.android.lark.widget.light.span.p) r2).b;
        Object r4 = r7.a;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.ss.android.lark.widget.light.span.RichTextTagHolder");
        Object r5 = ((com.ss.android.lark.widget.light.span.p) r4).b;
        if ((r3 instanceof PrefixInfo) == true) goto L5;
    L14:
        Intrinsics.checkNotNullParameter(r6, "first");
        Intrinsics.checkNotNullParameter(r7, "second");
        return RichTextGenerateUtils2.OverlappingResult.KEEP_FIRST;
    L5:
        if ((r5 instanceof PrefixInfo) == false) goto L14;
        PrefixSpan.Type r8 = ((PrefixInfo) r3).prefixParams.getType();
        PrefixSpan.Type r9 = PrefixSpan.Type.QUOTE;
        if (r8 != r9) goto L11;
        return RichTextGenerateUtils2.OverlappingResult.KEEP_FIRST;
    L11:
        if (((PrefixInfo) r5).prefixParams.getType() != r9) goto L14;
        return RichTextGenerateUtils2.OverlappingResult.KEEP_SECOND;
    }

    public final boolean c(Spannable r1, Object r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "editable");
        Intrinsics.checkNotNullParameter(r2, "span");
        Intrinsics.checkNotNullParameter(r1, "editable");
        Intrinsics.checkNotNullParameter(r2, "span");
        return false;
    }
}
