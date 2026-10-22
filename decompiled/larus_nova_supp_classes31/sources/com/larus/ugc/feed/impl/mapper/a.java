package com.larus.ugc.feed.impl.mapper;

import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.Icon;
import com.larus.platform.api.creation.OptionItem;
import com.larus.platform.api.creation.TplDetail;
import com.larus.platform.api.creation.VideoInfo;
import com.larus.ugc.feed.api.model.IconKmp;
import com.larus.ugc.feed.api.model.ImageInfoKmp;
import com.larus.ugc.feed.api.model.ImageKmp;
import com.larus.ugc.feed.api.model.OptionItemKmp;
import com.larus.ugc.feed.api.model.TplDetailKmp;
import com.larus.ugc.feed.api.model.VideoInfoKmp;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static final ImageInfoKmp a(ImageInfo r12) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        Image r1 = r12.a;
        if (r1 == null) goto L5;
        ImageKmp r3 = b(r1);
    L6:
        Image r2 = r12.b;
        if (r2 == null) goto L9;
        ImageKmp r4 = b(r2);
    L10:
        Image r5 = r12.c;
        if (r5 == null) goto L13;
        ImageKmp r6 = b(r5);
    L14:
        Image r7 = r12.d;
        if (r7 == null) goto L17;
        ImageKmp r8 = b(r7);
    L18:
        String r9 = r12.e;
        String r10 = r12.f;
        String r11 = r12.g;
        Image r13 = r12.h;
        if (r13 == null) goto L21;
        ImageKmp r14 = b(r13);
    L22:
        Image r15 = r12.i;
        if (r15 == null) goto L25;
        ImageKmp r16 = b(r15);
    L26:
        Image r17 = r12.j;
        if (r17 == null) goto L29;
        ImageKmp r18 = b(r17);
    L31:
        return new ImageInfoKmp(r3, r4, r6, r8, r9, r10, r11, r14, r16, r18);
    L29:
        r18 = null;
        goto L31
    L25:
        r16 = null;
        goto L26
    L21:
        r14 = null;
        goto L22
    L17:
        r8 = null;
        goto L18
    L13:
        r6 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public static final ImageKmp b(Image r8) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        return new ImageKmp(r8.a, r8.b, r8.c, r8.d);
    }

    public static final OptionItemKmp c(OptionItem r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return new OptionItemKmp(r2.a, r2.b);
    }

    public static final TplDetailKmp d(TplDetail r14) {
        Intrinsics.checkNotNullParameter(r14, "<this>");
        Integer r2 = r14.a;
        String r3 = r14.b;
        String r4 = r14.c;
        Integer r5 = r14.d;
        String r6 = r14.e;
        Icon r1 = r14.f;
        if (r1 == null) goto L5;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        IconKmp r8 = new IconKmp(r1.a, r1.b);
    L6:
        Icon r7 = r14.g;
        if (r7 == null) goto L9;
        Intrinsics.checkNotNullParameter(r7, "<this>");
        IconKmp r0 = new IconKmp(r7.a, r7.b);
    L11:
        return new TplDetailKmp(r2, r3, r4, r5, r6, r8, r0, r14.h, r14.i, r14.j, r14.k);
    L9:
        r0 = null;
        goto L11
    L5:
        r8 = null;
        goto L6
    }

    public static final Image e(ImageKmp r9) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        return new Image(r9.getUrl(), r9.getUrlV2(), r9.getWidth(), r9.getHeight(), 16);
    }

    public static final ImageInfo f(ImageInfoKmp r12) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        ImageKmp r1 = r12.getImageOrigin();
        if (r1 == null) goto L5;
        Image r3 = e(r1);
    L6:
        ImageKmp r2 = r12.getImageThumb();
        if (r2 == null) goto L9;
        Image r4 = e(r2);
    L10:
        ImageKmp r5 = r12.getImagePre();
        if (r5 == null) goto L13;
        Image r6 = e(r5);
    L14:
        ImageKmp r7 = r12.getImageRef();
        if (r7 == null) goto L17;
        Image r8 = e(r7);
    L18:
        String r9 = r12.getKey();
        String r10 = r12.getRequestId();
        String r11 = r12.getImageTips();
        ImageKmp r13 = r12.getPrivateImage();
        if (r13 == null) goto L21;
        Image r14 = e(r13);
    L22:
        ImageKmp r15 = r12.getRawImage();
        if (r15 == null) goto L25;
        Image r16 = e(r15);
    L26:
        ImageKmp r17 = r12.getRawThumbImage();
        if (r17 == null) goto L29;
        Image r18 = e(r17);
    L31:
        return new ImageInfo(r3, r4, r6, r8, r9, r10, r11, r14, r16, r18);
    L29:
        r18 = null;
        goto L31
    L25:
        r16 = null;
        goto L26
    L21:
        r14 = null;
        goto L22
    L17:
        r8 = null;
        goto L18
    L13:
        r6 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public static final OptionItem g(OptionItemKmp r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return new OptionItem(r2.getId(), r2.getDisplayContent());
    }

    public static final TplDetail h(TplDetailKmp r14) {
        Intrinsics.checkNotNullParameter(r14, "<this>");
        Integer r2 = r14.getCreateType();
        String r3 = r14.getTagType();
        String r4 = r14.getButtonType();
        Integer r5 = r14.getActionType();
        String r6 = r14.getButtonName();
        IconKmp r1 = r14.getButtonIcon();
        if (r1 == null) goto L5;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Icon r8 = new Icon(r1.getLightModeUrl(), r1.getDarkModeUrl());
    L6:
        IconKmp r7 = r14.getButtonMiniIcon();
        if (r7 == null) goto L9;
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Icon r0 = new Icon(r7.getLightModeUrl(), r7.getDarkModeUrl());
    L11:
        return new TplDetail(r2, r3, r4, r5, r6, r8, r0, r14.getButtonDesc(), r14.getSendQuery(), r14.getPromptStartPos(), r14.getPromptEndPos());
    L9:
        r0 = null;
        goto L11
    L5:
        r8 = null;
        goto L6
    }

    public static final VideoInfo i(VideoInfoKmp r8) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        return new VideoInfo(r8.getVid(), r8.getDownloadUrl(), r8.getDownloadFilehash(), r8.getDuration(), r8.getVideoType(), r8.getVideoModel());
    }
}
