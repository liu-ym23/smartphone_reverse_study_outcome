package com.larus.chat.gallery.impl.preview.toolbar;

import com.larus.chat.gallery.impl.preview.data.SourceType;
import com.larus.common.apphost.AppHost;
import com.larus.gallery.api.GalleryType;
import com.larus.platform.service.n0;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class k {
    public static final Map<SourceType, Set<ToolbarButtonType>> a = null;
    public static final int b = 0;

    public k() {
    }

    static {
        SourceType r1 = SourceType.USER_SEND;
        ToolbarButtonType r4 = ToolbarButtonType.SHARE;
        ToolbarButtonType r6 = ToolbarButtonType.DOWNLOAD;
        ToolbarButtonType r8 = ToolbarButtonType.MARK;
        SourceType r2 = SourceType.BOT_RESP;
        ToolbarButtonType[] r10 = {r4, r6, r8, ToolbarButtonType.VIEW_SOURCE};
        SourceType r3 = SourceType.CREATION_CARD;
        ToolbarButtonType r11 = ToolbarButtonType.PUBLISH;
        ToolbarButtonType r12 = ToolbarButtonType.SET_PRIVATE;
        ToolbarButtonType r13 = ToolbarButtonType.WATERMARK;
        ToolbarButtonType[] r14 = {r4, r6, r8, r11, r12, r13};
        SourceType r5 = SourceType.CREATION_RECORD;
        ToolbarButtonType r15 = ToolbarButtonType.DELETE;
        ToolbarButtonType[] r16 = {r4, r6, r8, r11, r12, r15, r13};
        SourceType r7 = SourceType.ALBUM;
        ToolbarButtonType r17 = ToolbarButtonType.CROP;
        a = MapsKt.mapOf(new Pair[]{TuplesKt.to(r1, SetsKt.setOf(new ToolbarButtonType[]{r4, r6, r8})), TuplesKt.to(r2, SetsKt.setOf(r10)), TuplesKt.to(r3, SetsKt.setOf(r14)), TuplesKt.to(r5, SetsKt.setOf(r16)), TuplesKt.to(r7, SetsKt.setOf(new ToolbarButtonType[]{r8, r17, ToolbarButtonType.SELECT})), TuplesKt.to(SourceType.ATTACHMENT, SetsKt.setOf(new ToolbarButtonType[]{r8, r17})), TuplesKt.to(SourceType.CAMERA_RESULT, SetsKt.setOf(new ToolbarButtonType[]{r8, r17, r6})), TuplesKt.to(SourceType.CLOUD_DRIVE, SetsKt.setOf(new ToolbarButtonType[]{r8, r4, r6, ToolbarButtonType.RENAME, ToolbarButtonType.MOVE, r15}))});
        b = 2131899725;
    }

    public static j a(j r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "item");
        if (r11 == false) goto L5;
        int r3 = 2131243174;
    L6:
        if (r11 == false) goto L8;
        int r4 = 2131243174;
    L9:
        if (r11 == false) goto L11;
        int r5 = 2131898861;
    L13:
        return j.a(r10, r3, r4, r5, false, false, MapsKt.plus(r10.i, TuplesKt.to("selected", Boolean.valueOf(r11))), 225);
    L11:
        r5 = b;
        goto L13
    L8:
        r4 = 2131243173;
        goto L9
    L5:
        r3 = 2131243173;
        goto L6
    }

    public static boolean b(ToolbarButtonType r3, SourceType r4, boolean r5, GalleryType r6, String r7, boolean r8) {
        Set<ToolbarButtonType> r9 = a.get(r4);
        if (r9 != null) goto L6;
        r9 = SetsKt.emptySet();
    L6:
        if (r3 != ToolbarButtonType.MORE) goto L9;
        return true;
    L9:
        if (r9.contains(r3) == true) goto L12;
    L48:
        return false;
    L12:
        if (r3 != ToolbarButtonType.VIEW_SOURCE) goto L21;
        if (r7 != null) goto L15;
    L18:
        boolean r10 = true;
    L19:
        if (r10 == false) goto L21;
    L15:
        if (StringsKt.isBlank(r7) == true) goto L18;
        r10 = false;
    L21:
        ToolbarButtonType r11 = ToolbarButtonType.PUBLISH;
        if (r3 == r11) goto L26;
        if (r3 == ToolbarButtonType.SET_PRIVATE) goto L26;
    L30:
        ToolbarButtonType r12 = ToolbarButtonType.MARK;
        if (r3 == r12) goto L35;
        if (r3 == ToolbarButtonType.CROP) goto L35;
    L37:
        if (r3 != r12) goto L39;
    L40:
        if (r8 == true) goto L48;
    L42:
        if (r3 != r11) goto L46;
        if (r5 == true) goto L48;
    L46:
        if (r3 != ToolbarButtonType.SET_PRIVATE) goto L50;
        if (r5 == false) goto L48;
        return true;
    L50:
        return true;
    L39:
        if (r3 != ToolbarButtonType.CROP) goto L42;
    L35:
        if (r6 != GalleryType.Video) goto L37;
    L26:
        if (AppHost.a.isOversea() == true) goto L48;
        if (n0.a.b() == false) goto L30;
        goto L30
    }
}
