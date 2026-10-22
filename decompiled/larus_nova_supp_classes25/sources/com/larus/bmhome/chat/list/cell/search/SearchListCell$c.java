package com.larus.bmhome.chat.list.cell.search;

import com.larus.bmhome.chat.search.SearchBoxStyle;
import com.larus.im.bean.message.ItemType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public /* synthetic */ class SearchListCell$c {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[ItemType.values().length];
        r0[ItemType.TYPE_CARD_VIDEO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L23
    L43:
        r0[ItemType.TYPE_CARD_MORE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L24
    L57:
        r0[ItemType.TYPE_CARD_IMAGE_TEXT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L25
    L45:
        r0[ItemType.TYPE_CARD_IMAGE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L26
    L47:
        r0[ItemType.TYPE_CARD_SKELETON.ordinal()] = 5;     // Catch: NoSuchFieldError -> L27
    L35:
        r0[ItemType.TYPE_CARD_MIXED_MEDIA.ordinal()] = 6;     // Catch: NoSuchFieldError -> L28
    L14:
        a = r0;
        int[] r1 = new int[SearchBoxStyle.values().length];
        r1[SearchBoxStyle.singleRowNormal.ordinal()] = 1;     // Catch: NoSuchFieldError -> L29
    L53:
        r1[SearchBoxStyle.singleRowTiny.ordinal()] = 2;     // Catch: NoSuchFieldError -> L30
    L39:
        r1[SearchBoxStyle.doubleColumnVideo.ordinal()] = 3;     // Catch: NoSuchFieldError -> L31
    L51:
        r1[SearchBoxStyle.singleRowVideoNew.ordinal()] = 4;     // Catch: NoSuchFieldError -> L32
    L37:
        r1[SearchBoxStyle.doubleColumnImage.ordinal()] = 5;     // Catch: NoSuchFieldError -> L33
    L49:
        r1[SearchBoxStyle.doubleColumnMixedMedia.ordinal()] = 6;     // Catch: NoSuchFieldError -> L34
    L21:
        b = r1;
    }
}
