package com.ss.android.lark.feed.shared.data.utils;

import com.bytedance.lark.pb.feed.v1.Digest;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final /* synthetic */ class k {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[Digest.Element.Tag.values().length];
        r0[Digest.Element.Tag.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
    L11:
        r0[Digest.Element.Tag.EMOJI.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
    L15:
        r0[Digest.Element.Tag.TEXT_WITH_EMOJIS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
    L6:
        a = r0;
    }
}
