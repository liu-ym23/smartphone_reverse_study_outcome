package com.larus.ugc.feed.impl.mapper;

import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.AiBeautifyUserContent;
import com.larus.platform.api.creation.AudioResource;
import com.larus.platform.api.creation.AuthorInfo;
import com.larus.platform.api.creation.AwemeAnchor;
import com.larus.platform.api.creation.CreationCommunityInfo;
import com.larus.platform.api.creation.CreationDynamicInfo;
import com.larus.platform.api.creation.CreationLikeInfo;
import com.larus.platform.api.creation.CreationPublishExtra;
import com.larus.platform.api.creation.OptionItem;
import com.larus.platform.api.creation.Resource;
import com.larus.platform.api.creation.TplDetail;
import com.larus.platform.api.creation.TplInfo;
import com.larus.platform.api.creation.UnwatermarkedVideoInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationImage;
import com.larus.platform.api.creation.UserCreationMusic;
import com.larus.platform.api.creation.UserCreationRefContent;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.platform.api.creation.UserCreationUserAvatar;
import com.larus.platform.api.creation.VideoContentFromChat;
import com.larus.platform.api.creation.VideoInfo;
import com.larus.platform.api.creation.VideoResource;
import com.larus.platform.api.creation.VideoUserContent;
import com.larus.platform.creation.CreationMultiReferenceLogEvent;
import com.larus.ugc.feed.api.model.AiBeautifyUserContentKmp;
import com.larus.ugc.feed.api.model.AudioResourceKmp;
import com.larus.ugc.feed.api.model.AuthorInfoKmp;
import com.larus.ugc.feed.api.model.AwemeAnchorKmp;
import com.larus.ugc.feed.api.model.CommonCreationFeedDataKmp;
import com.larus.ugc.feed.api.model.CreationCommunityInfoKmp;
import com.larus.ugc.feed.api.model.CreationDynamicInfoKmp;
import com.larus.ugc.feed.api.model.CreationLikeInfoKmp;
import com.larus.ugc.feed.api.model.CreationPublishExtraKmp;
import com.larus.ugc.feed.api.model.ImageInfoKmp;
import com.larus.ugc.feed.api.model.OptionItemKmp;
import com.larus.ugc.feed.api.model.ResourceKmp;
import com.larus.ugc.feed.api.model.TplDetailKmp;
import com.larus.ugc.feed.api.model.TplInfoKmp;
import com.larus.ugc.feed.api.model.UnwatermarkedVideoInfoKmp;
import com.larus.ugc.feed.api.model.UserCreationContentKmp;
import com.larus.ugc.feed.api.model.UserCreationImageKmp;
import com.larus.ugc.feed.api.model.UserCreationKmp;
import com.larus.ugc.feed.api.model.UserCreationMusicKmp;
import com.larus.ugc.feed.api.model.UserCreationRefContentKmp;
import com.larus.ugc.feed.api.model.UserCreationTrackParamsKmp;
import com.larus.ugc.feed.api.model.UserCreationUserAvatarKmp;
import com.larus.ugc.feed.api.model.VideoContentFromChatKmp;
import com.larus.ugc.feed.api.model.VideoInfoKmp;
import com.larus.ugc.feed.api.model.VideoResourceKmp;
import com.larus.ugc.feed.api.model.VideoUserContentKmp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c {
    public static final CommonCreationFeedDataKmp a(zp9.c r7) {
        boolean r1 = r7.d();
        Map<String, String> r2 = r7.f();
        List<UserCreation> r0 = r7.c();
        if (r0 == null) goto L7;
        List r3 = CollectionsKt.filterNotNull(r0);
        if (r3 == null) goto L7;
        List<UserCreationKmp> r4 = c(r3);
    L8:
        List<List<UserCreation>> r5 = r7.b();
        if (r5 == null) goto L22;
        List<List<UserCreation>> r6 = r5;
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r9 = r6.iterator();
    L12:
        if (r9.hasNext() == false) goto L24;
        List r10 = (List) r9.next();
        if (r10 == null) goto L18;
        List r11 = CollectionsKt.filterNotNull(r10);
        if (r11 == null) goto L18;
        List<UserCreationKmp> r12 = c(r11);
    L19:
        if (r12 != null) goto L21;
        r12 = CollectionsKt.emptyList();
    L21:
        r8.add(r12);
    L18:
        r12 = null;
    L24:
        return new CommonCreationFeedDataKmp(r1, r2, r4, r8, r7.e());
    L22:
        r8 = null;
    L7:
        r4 = null;
        goto L8
    }

    public static final UserCreationKmp b(UserCreation r48) {
        Intrinsics.checkNotNullParameter(r48, "<this>");
        String r3 = r48.a;
        int r4 = r48.b;
        Integer r5 = r48.c;
        Integer r6 = r48.d;
        UserCreationContent r2 = r48.e;
        if (r2 == null) goto L89;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        UserCreationImage r8 = r2.a;
        if (r8 == null) goto L23;
        Intrinsics.checkNotNullParameter(r8, "<this>");
        ImageInfo r10 = r8.a;
        if (r10 == null) goto L9;
        ImageInfoKmp r22 = a.a(r10);
    L10:
        String r11 = r8.b;
        String r12 = r8.c;
        OptionItem r13 = r8.d;
        if (r13 == null) goto L13;
        OptionItemKmp r25 = a.c(r13);
    L14:
        OptionItem r14 = r8.e;
        if (r14 == null) goto L17;
        OptionItemKmp r26 = a.c(r14);
    L18:
        OptionItem r9 = r8.f;
        if (r9 == null) goto L21;
        OptionItemKmp r27 = a.c(r9);
    L22:
        UserCreationImageKmp r15 = new UserCreationImageKmp(r22, r11, r12, r25, r26, r27);
    L24:
        UserCreationMusic r16 = r2.b;
        if (r16 == null) goto L31;
        Intrinsics.checkNotNullParameter(r16, "<this>");
        String r17 = r16.a;
        String r18 = r16.b;
        String r19 = r16.c;
        ImageInfo r110 = r16.d;
        if (r110 == null) goto L29;
        ImageInfoKmp r28 = a.a(r110);
    L30:
        UserCreationMusicKmp r111 = new UserCreationMusicKmp(r17, r18, r19, r28, r16.e, r16.f, r16.g, r16.h, r16.i, r16.j);
    L32:
        UserCreationUserAvatar r7 = r2.c;
        if (r7 == null) goto L47;
        Intrinsics.checkNotNullParameter(r7, "<this>");
        ImageInfo r20 = r7.a;
        if (r20 == null) goto L37;
        ImageInfoKmp r23 = a.a(r20);
    L38:
        String r21 = r7.b;
        String r24 = r7.c;
        OptionItem r29 = r7.d;
        if (r29 == null) goto L41;
        OptionItemKmp r210 = a.c(r29);
    L42:
        OptionItem r30 = r7.e;
        if (r30 == null) goto L45;
        OptionItemKmp r211 = a.c(r30);
    L46:
        UserCreationUserAvatarKmp r112 = new UserCreationUserAvatarKmp(r23, r21, r24, r210, r211);
    L48:
        AiBeautifyUserContent r31 = r2.d;
        if (r31 == null) goto L55;
        Intrinsics.checkNotNullParameter(r31, "<this>");
        ImageInfo r32 = r31.a;
        if (r32 == null) goto L53;
        ImageInfoKmp r212 = a.a(r32);
    L54:
        AiBeautifyUserContentKmp r113 = new AiBeautifyUserContentKmp(r212, r31.b, r31.c, r31.d, r31.e);
    L56:
        VideoUserContent r33 = r2.e;
        if (r33 == null) goto L83;
        Intrinsics.checkNotNullParameter(r33, "<this>");
        VideoInfo r34 = r33.a;
        if (r34 == null) goto L61;
        Intrinsics.checkNotNullParameter(r34, "<this>");
        VideoInfoKmp r213 = new VideoInfoKmp(r34.a, r34.b, r34.c, r34.d, r34.e, r34.f);
    L62:
        ImageInfo r0 = r33.b;
        if (r0 == null) goto L65;
        ImageInfoKmp r214 = a.a(r0);
    L66:
        String r1 = r33.c;
        String r35 = r33.d;
        OptionItem r36 = r33.e;
        if (r36 == null) goto L69;
        OptionItemKmp r215 = a.c(r36);
    L70:
        UnwatermarkedVideoInfo r37 = r33.f;
        if (r37 == null) goto L77;
        Intrinsics.checkNotNullParameter(r37, "<this>");
        VideoInfo r38 = r37.a;
        if (r38 == null) goto L75;
        Intrinsics.checkNotNullParameter(r38, "<this>");
        VideoInfoKmp r114 = new VideoInfoKmp(r38.a, r38.b, r38.c, r38.d, r38.e, r38.f);
    L76:
        UnwatermarkedVideoInfoKmp r216 = new UnwatermarkedVideoInfoKmp(r114, r37.b);
    L78:
        OptionItem r39 = r33.g;
        if (r39 == null) goto L81;
        OptionItemKmp r217 = a.c(r39);
    L82:
        VideoUserContentKmp r115 = new VideoUserContentKmp(r213, r214, r1, r35, r215, r216, r217, r33.h);
    L84:
        VideoContentFromChat r40 = r2.f;
        if (r40 == null) goto L87;
        Intrinsics.checkNotNullParameter(r40, "<this>");
        VideoContentFromChatKmp r116 = new VideoContentFromChatKmp(r40.a, r40.b);
    L88:
        UserCreationContentKmp r41 = new UserCreationContentKmp(r15, r111, r112, r113, r115, r116);
    L90:
        Long r42 = r48.f;
        AuthorInfo r43 = r48.g;
        if (r43 == null) goto L93;
        AuthorInfoKmp r44 = new AuthorInfoKmp(r43.a, r43.b, r43.c);
    L94:
        CreationDynamicInfo r45 = r48.h;
        if (r45 == null) goto L109;
        Intrinsics.checkNotNullParameter(r45, "<this>");
        Integer r117 = r45.a;
        Integer r118 = r45.b;
        String r119 = r45.c;
        String r120 = r45.d;
        TplInfo r46 = r45.e;
        if (r46 == null) goto L107;
        Intrinsics.checkNotNullParameter(r46, "<this>");
        String r47 = r46.a;
        TplDetail r49 = r46.b;
        if (r49 == null) goto L101;
        TplDetailKmp r50 = a.d(r49);
    L102:
        TplDetail r51 = r46.c;
        if (r51 == null) goto L105;
        TplDetailKmp r52 = a.d(r51);
    L106:
        TplInfoKmp r121 = new TplInfoKmp(r47, r50, r52);
    L108:
        CreationDynamicInfoKmp r122 = new CreationDynamicInfoKmp(r117, r118, r119, r120, r121);
    L110:
        String r123 = r48.i;
        Integer r124 = r48.j;
        CreationCommunityInfo r53 = r48.k;
        if (r53 == null) goto L117;
        Intrinsics.checkNotNullParameter(r53, "<this>");
        CreationLikeInfo r54 = r53.a;
        if (r54 == null) goto L115;
        Intrinsics.checkNotNullParameter(r54, "<this>");
        CreationLikeInfoKmp r55 = new CreationLikeInfoKmp(r54.a, r54.b);
    L116:
        CreationCommunityInfoKmp r125 = new CreationCommunityInfoKmp(r55, r53.b);
    L118:
        Boolean r126 = r48.l;
        Long r127 = r48.m;
        UserCreationTrackParams r56 = r48.n;
        if (r56 == null) goto L121;
        UserCreationTrackParamsKmp r218 = new UserCreationTrackParamsKmp(r56.a, r56.b, r56.c, r56.d, r56.e, r56.f, r56.g);
    L122:
        UserCreationRefContent r57 = r48.o;
        if (r57 == null) goto L168;
        Intrinsics.checkNotNullParameter(r57, "<this>");
        List<ImageInfo> r58 = r57.a;
        if (r58 == null) goto L134;
        List<ImageInfo> r59 = r58;
        ArrayList r60 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r59, 10));
        Iterator<T> r61 = r59.iterator();
    L128:
        if (r61.hasNext() == false) goto L135;
        ImageInfo r62 = (ImageInfo) r61.next();
        if (r62 == null) goto L132;
        ImageInfoKmp r63 = a.a(r62);
    L133:
        r60.add(r63);
        goto L128
    L132:
        r63 = null;
    L135:
        Boolean r64 = r57.b;
        List<Resource> r65 = r57.c;
        if (r65 == null) goto L166;
        List<Resource> r66 = r65;
        ArrayList r67 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r66, 10));
        Iterator r68 = r66.iterator();
    L139:
        if (r68.hasNext() == false) goto L165;
        Resource r69 = (Resource) r68.next();
        if (r69 == null) goto L163;
        Intrinsics.checkNotNullParameter(r69, "<this>");
        Integer r128 = r69.a;
        if (r128 == null) goto L145;
        int r219 = r128.intValue();
    L146:
        ImageInfo r129 = r69.b;
        if (r129 == null) goto L149;
        ImageInfoKmp r220 = a.a(r129);
    L150:
        VideoResource r130 = r69.c;
        if (r130 == null) goto L157;
        Intrinsics.checkNotNullParameter(r130, "<this>");
        String r70 = r130.a;
        String r131 = r130.b;
        String r132 = r130.c;
        Double r133 = r130.d;
        String r71 = r130.e;
        String r72 = r130.f;
        Boolean r73 = r130.g;
        ImageInfo r134 = r130.h;
        if (r134 == null) goto L155;
        ImageInfoKmp r410 = a.a(r134);
    L156:
        VideoResourceKmp r221 = new VideoResourceKmp(r70, r131, r132, r133, r71, r72, r73, r410);
    L158:
        AudioResource r74 = r69.d;
        if (r74 == null) goto L161;
        Intrinsics.checkNotNullParameter(r74, "<this>");
        AudioResourceKmp r222 = new AudioResourceKmp(r74.a, r74.b, r74.c, r74.d, r74.e);
    L162:
        ResourceKmp r135 = new ResourceKmp(r219, r220, r221, r222, r69.e);
    L164:
        r67.add(r135);
        r68 = r68;
        r124 = r124;
        r123 = r123;
        r122 = r122;
        r44 = r44;
        r42 = r42;
        r41 = r41;
        goto L139
    L161:
        r222 = null;
        goto L162
    L155:
        r410 = null;
        goto L156
    L157:
        r221 = null;
        goto L158
    L149:
        r220 = null;
        goto L150
    L145:
        r219 = 0;
        goto L146
    L163:
        r68 = r68;
        r41 = r41;
        r42 = r42;
        r44 = r44;
        r122 = r122;
        r123 = r123;
        r124 = r124;
        r135 = null;
        goto L164
    L165:
        UserCreationContentKmp r411 = r41;
        Long r412 = r42;
        AuthorInfoKmp r413 = r44;
        CreationDynamicInfoKmp r414 = r122;
        String r415 = r123;
        Integer r416 = r124;
    L167:
        UserCreationRefContentKmp r75 = new UserCreationRefContentKmp(r60, r64, r67);
    L169:
        CreationPublishExtra r76 = r48.p;
        if (r76 == null) goto L172;
        CreationPublishExtraKmp r223 = new CreationPublishExtraKmp(r76.a, r76.b, r76.c);
    L173:
        AwemeAnchor r77 = r48.q;
        if (r77 == null) goto L176;
        AwemeAnchorKmp r78 = new AwemeAnchorKmp(r77.a, r77.b);
    L178:
        return new UserCreationKmp(r3, r4, r5, r6, r411, r412, r413, r414, r415, r416, r125, r126, r127, r218, r75, r223, r78);
    L176:
        r78 = null;
        goto L178
    L172:
        r223 = null;
        goto L173
    L166:
        r411 = r41;
        r412 = r42;
        r413 = r44;
        r414 = r122;
        r415 = r123;
        r416 = r124;
        r67 = null;
        goto L167
    L134:
        r60 = null;
        goto L135
    L168:
        r411 = r41;
        r412 = r42;
        r413 = r44;
        r414 = r122;
        r415 = r123;
        r416 = r124;
        r75 = null;
        goto L169
    L121:
        r218 = null;
        goto L122
    L115:
        r55 = null;
        goto L116
    L117:
        r125 = null;
        goto L118
    L105:
        r52 = null;
        goto L106
    L101:
        r50 = null;
        goto L102
    L107:
        r121 = null;
        goto L108
    L109:
        r122 = null;
        goto L110
    L93:
        r44 = null;
        goto L94
    L87:
        r116 = null;
        goto L88
    L81:
        r217 = null;
        goto L82
    L75:
        r114 = null;
        goto L76
    L77:
        r15 = r15;
        r111 = r111;
        r112 = r112;
        r113 = r113;
        r216 = null;
        goto L78
    L69:
        r215 = null;
        goto L70
    L65:
        r214 = null;
        goto L66
    L61:
        r213 = null;
        goto L62
    L83:
        r3 = r3;
        r15 = r15;
        r111 = r111;
        r112 = r112;
        r113 = r113;
        r115 = null;
        goto L84
    L53:
        r212 = null;
        goto L54
    L55:
        r113 = null;
        goto L56
    L45:
        r211 = null;
        goto L46
    L41:
        r210 = null;
        goto L42
    L37:
        r23 = null;
        goto L38
    L47:
        r112 = null;
        goto L48
    L29:
        r28 = null;
        goto L30
    L31:
        r111 = null;
        goto L32
    L21:
        r27 = null;
        goto L22
    L17:
        r26 = null;
        goto L18
    L13:
        r25 = null;
        goto L14
    L9:
        r22 = null;
        goto L10
    L23:
        r15 = null;
        goto L24
    L89:
        r3 = r3;
        r4 = r4;
        r5 = r5;
        r6 = r6;
        r41 = null;
        goto L90
    }

    public static final List<UserCreationKmp> c(List<UserCreation> r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        List<UserCreation> r3 = r2;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r0.add(b((UserCreation) r4.next()));
        goto L4
    L6:
        return r0;
    }

    public static final UserCreation d(UserCreationKmp r40) {
        Intrinsics.checkNotNullParameter(r40, "<this>");
        String r3 = r40.getCreationId();
        int r4 = r40.getUserCreationType();
        Integer r5 = r40.getStatus();
        Integer r6 = r40.getPrivateStatus();
        UserCreationContentKmp r2 = r40.getContent();
        if (r2 == null) goto L89;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        UserCreationImageKmp r8 = r2.getImageContent();
        if (r8 == null) goto L23;
        Intrinsics.checkNotNullParameter(r8, "<this>");
        ImageInfoKmp r10 = r8.getImageInfo();
        if (r10 == null) goto L9;
        ImageInfo r22 = a.f(r10);
    L10:
        String r23 = r8.getDisplayContent();
        String r24 = r8.getPrompt();
        OptionItemKmp r11 = r8.getRatio();
        if (r11 == null) goto L13;
        OptionItem r25 = a.g(r11);
    L14:
        OptionItemKmp r12 = r8.getStyles();
        if (r12 == null) goto L17;
        OptionItem r26 = a.g(r12);
    L18:
        OptionItemKmp r9 = r8.getModel();
        if (r9 == null) goto L21;
        OptionItem r27 = a.g(r9);
    L22:
        UserCreationImage r13 = new UserCreationImage(r22, r23, r24, r25, r26, r27);
    L24:
        UserCreationMusicKmp r14 = r2.getMusicContent();
        if (r14 == null) goto L31;
        Intrinsics.checkNotNullParameter(r14, "<this>");
        String r28 = r14.getVideoModel();
        String r29 = r14.getTitle();
        String r210 = r14.getLyric();
        ImageInfoKmp r15 = r14.getCover();
        if (r15 == null) goto L29;
        ImageInfo r211 = a.f(r15);
    L30:
        UserCreationMusic r16 = new UserCreationMusic(r28, r29, r210, r211, r14.getShareInfo(), r14.getCoverMainColor(), r14.getCaptionsResult(), r14.getVid(), r14.getGenre(), r14.getMakeReplicaParams());
    L32:
        UserCreationUserAvatarKmp r17 = r2.getUserAvatarContent();
        if (r17 == null) goto L47;
        Intrinsics.checkNotNullParameter(r17, "<this>");
        ImageInfoKmp r18 = r17.getImageInfo();
        if (r18 == null) goto L37;
        ImageInfo r212 = a.f(r18);
    L38:
        String r213 = r17.getDisplayContent();
        String r214 = r17.getPrompt();
        OptionItemKmp r19 = r17.getRatio();
        if (r19 == null) goto L41;
        OptionItem r215 = a.g(r19);
    L42:
        OptionItemKmp r20 = r17.getModel();
        if (r20 == null) goto L45;
        OptionItem r216 = a.g(r20);
    L46:
        UserCreationUserAvatar r110 = new UserCreationUserAvatar(r212, r213, r214, r215, r216);
    L48:
        AiBeautifyUserContentKmp r21 = r2.getAiBeautifyUserContent();
        if (r21 == null) goto L55;
        Intrinsics.checkNotNullParameter(r21, "<this>");
        ImageInfoKmp r111 = r21.getImageInfo();
        if (r111 == null) goto L53;
        ImageInfo r217 = a.f(r111);
    L54:
        AiBeautifyUserContent r112 = new AiBeautifyUserContent(r217, r21.getMultiSelectorList(), r21.getDisplayContent(), r21.getPrompt(), r21.getRedirectSchema());
    L56:
        VideoUserContentKmp r30 = r2.getVideoUserContent();
        if (r30 == null) goto L83;
        Intrinsics.checkNotNullParameter(r30, "<this>");
        VideoInfoKmp r113 = r30.getVideoInfo();
        if (r113 == null) goto L61;
        VideoInfo r218 = a.i(r113);
    L62:
        ImageInfoKmp r114 = r30.getCoverImage();
        if (r114 == null) goto L65;
        ImageInfo r219 = a.f(r114);
    L66:
        String r220 = r30.getDisplayContent();
        String r221 = r30.getPrompt();
        OptionItemKmp r115 = r30.getRatio();
        if (r115 == null) goto L69;
        OptionItem r222 = a.g(r115);
    L70:
        UnwatermarkedVideoInfoKmp r116 = r30.getUnwatermarkedVideoInfo();
        if (r116 == null) goto L77;
        Intrinsics.checkNotNullParameter(r116, "<this>");
        VideoInfoKmp r117 = r116.getVideoInfo();
        if (r117 == null) goto L75;
        VideoInfo r1 = a.i(r117);
    L76:
        UnwatermarkedVideoInfo r223 = new UnwatermarkedVideoInfo(r1, r116.getCoverImageUrl());
    L78:
        OptionItemKmp r7 = r30.getModel();
        if (r7 == null) goto L81;
        OptionItem r224 = a.g(r7);
    L82:
        VideoUserContent r118 = new VideoUserContent(r218, r219, r220, r221, r222, r223, r224, r30.getInternalResources());
    L84:
        VideoContentFromChatKmp r31 = r2.getVideoContentFromChat();
        if (r31 == null) goto L87;
        Intrinsics.checkNotNullParameter(r31, "<this>");
        VideoContentFromChat r119 = new VideoContentFromChat(r31.getTaskId(), r31.isExtendVideo());
    L88:
        UserCreationContent r32 = new UserCreationContent(r13, r16, r110, r112, r118, r119);
    L90:
        Long r33 = r40.getUsageCount();
        AuthorInfoKmp r34 = r40.getAuthorInfo();
        if (r34 == null) goto L93;
        AuthorInfo r35 = new AuthorInfo(r34.getName(), r34.getUid(), r34.getAvatarUrl());
    L94:
        CreationDynamicInfoKmp r36 = r40.getDynamicInfo();
        if (r36 == null) goto L109;
        Intrinsics.checkNotNullParameter(r36, "<this>");
        Integer r120 = r36.getPromptStartPos();
        Integer r121 = r36.getPromptEndPos();
        String r122 = r36.getActionButtonName();
        String r123 = r36.getMsgId();
        TplInfoKmp r37 = r36.getTplInfo();
        if (r37 == null) goto L107;
        Intrinsics.checkNotNullParameter(r37, "<this>");
        String r124 = r37.getTplType();
        TplDetailKmp r125 = r37.getTplDetailForNoAvatar();
        if (r125 == null) goto L101;
        TplDetail r38 = a.h(r125);
    L102:
        TplDetailKmp r39 = r37.getTplDetailForHasAvatar();
        if (r39 == null) goto L105;
        TplDetail r41 = a.h(r39);
    L106:
        TplInfo r126 = new TplInfo(r124, r38, r41);
    L108:
        CreationDynamicInfo r127 = new CreationDynamicInfo(r120, r121, r122, r123, r126);
    L110:
        String r128 = r40.getCreationTraceInfo();
        Integer r129 = r40.getContentSource();
        CreationCommunityInfoKmp r42 = r40.getCommunityInfo();
        if (r42 == null) goto L117;
        Intrinsics.checkNotNullParameter(r42, "<this>");
        CreationLikeInfoKmp r43 = r42.getLikeInfo();
        if (r43 == null) goto L115;
        Intrinsics.checkNotNullParameter(r43, "<this>");
        CreationLikeInfo r130 = new CreationLikeInfo(r43.getLikeCount(), r43.getLikeStatus());
    L116:
        CreationCommunityInfo r131 = new CreationCommunityInfo(r130, r42.getCommentCount());
    L118:
        Boolean r132 = r40.isFavorite();
        Long r133 = r40.getCreateTime();
        UserCreationTrackParamsKmp r44 = r40.getClientTrackParams();
        if (r44 == null) goto L121;
        UserCreationTrackParams r45 = new UserCreationTrackParams(r44.getLogId(), r44.getPageIndex(), r44.getPosition(), r44.getTabId(), r44.getTabName(), r44.getTabType(), r44.getBotId());
    L122:
        UserCreationRefContentKmp r46 = r40.getRefContent();
        if (r46 == null) goto L163;
        Intrinsics.checkNotNullParameter(r46, "<this>");
        List<ImageInfoKmp> r47 = r46.getRefImages();
        if (r47 == null) goto L134;
        List<ImageInfoKmp> r48 = r47;
        ArrayList r134 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r48, 10));
        Iterator<T> r49 = r48.iterator();
    L128:
        if (r49.hasNext() == false) goto L135;
        ImageInfoKmp r135 = (ImageInfoKmp) r49.next();
        if (r135 == null) goto L132;
        ImageInfo r136 = a.f(r135);
    L133:
        r134.add(r136);
        goto L128
    L132:
        r136 = null;
    L135:
        Boolean r50 = r46.getDisablePuzzle();
        List<ResourceKmp> r51 = r46.getRefResources();
        if (r51 == null) goto L161;
        List<ResourceKmp> r52 = r51;
        ArrayList r137 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r52, 10));
        Iterator r53 = r52.iterator();
    L139:
        if (r53.hasNext() == false) goto L162;
        ResourceKmp r54 = (ResourceKmp) r53.next();
        if (r54 == null) goto L159;
        Intrinsics.checkNotNullParameter(r54, "<this>");
        Integer r225 = Integer.valueOf(r54.getResourceType());
        ImageInfoKmp r226 = r54.getImageInfo();
        if (r226 == null) goto L145;
        ImageInfo r227 = a.f(r226);
    L146:
        VideoResourceKmp r55 = r54.getVideoInfo();
        if (r55 == null) goto L153;
        Intrinsics.checkNotNullParameter(r55, "<this>");
        String r310 = r55.getVid();
        String r311 = r55.getDownloadUrl();
        String r312 = r55.getDownloadFilehash();
        Double r313 = r55.getDuration();
        String r314 = r55.getVideoType();
        String r315 = r55.getVideoModel();
        Boolean r316 = r55.getWithAudio();
        ImageInfoKmp r56 = r55.getCoverImage();
        if (r56 == null) goto L151;
        ImageInfo r317 = a.f(r56);
    L152:
        VideoResource r228 = new VideoResource(r310, r311, r312, r313, r314, r315, r316, r317);
    L154:
        AudioResourceKmp r57 = r54.getAudioInfo();
        if (r57 == null) goto L157;
        Intrinsics.checkNotNullParameter(r57, "<this>");
        AudioResource r229 = new AudioResource(r57.getVid(), r57.getVideoModel(), r57.getAudioType(), r57.getDuration(), r57.getFileName());
    L158:
        Resource r58 = new Resource(r225, r227, r228, r229, r54.isAvatar());
    L160:
        r137.add(r58);
        r53 = r53;
        goto L139
    L157:
        r229 = null;
        goto L158
    L151:
        r317 = null;
        goto L152
    L153:
        r228 = null;
        goto L154
    L145:
        r227 = null;
        goto L146
    L159:
        r53 = r53;
        r58 = null;
    L162:
        UserCreationRefContent r0 = new UserCreationRefContent(r134, r50, r137);
    L164:
        CreationPublishExtraKmp r59 = r40.getPublishExtra();
        if (r59 == null) goto L167;
        CreationPublishExtra r60 = new CreationPublishExtra(r59.isNewPublish(), r59.getPublicRefImage(), r59.getCaption());
    L168:
        AwemeAnchorKmp r61 = r40.getAwemeAnchor();
        if (r61 == null) goto L171;
        AwemeAnchor r230 = new AwemeAnchor(r61.getAnchorId(), r61.getAnchorName());
    L172:
        UserCreation r231 = new UserCreation(r3, r4, r5, r6, r32, r33, r35, r127, r128, r129, r131, r132, r133, r45, r0, r60, r230);
        UserCreationRefContentKmp r62 = r40.getRefContent();
        if (r62 == null) goto L289;
        List<ResourceKmp> r63 = r62.getRefResources();
        if (r63 == null) goto L289;
        List r64 = CollectionsKt.filterNotNull(r63);
        Set<String> r65 = cq9.b.a;
        CreationMultiReferenceLogEvent r66 = CreationMultiReferenceLogEvent.FEED_DECODED;
        Boolean r67 = Boolean.TRUE;
        List r68 = r64;
        boolean r69 = r68 instanceof Collection;
        if (r69 == true) goto L179;
    L181:
        Iterator r70 = r68.iterator();
        int r138 = 0;
    L183:
        if (r70.hasNext() == false) goto L192;
        if (((ResourceKmp) r70.next()).getResourceType() != 1) goto L187;
        boolean r139 = true;
    L188:
        if (r139 == false) goto L183;
        r138 = r138 + 1;
        if (r138 >= 0) goto L183;
        CollectionsKt.throwCountOverflow();
        goto L183
    L187:
        r139 = false;
        goto L188
    L192:
        int r232 = r138;
    L194:
        if (r69 == true) goto L196;
    L198:
        Iterator r140 = r68.iterator();
        int r141 = 0;
    L200:
        if (r140.hasNext() == false) goto L209;
        if (((ResourceKmp) r140.next()).getResourceType() != 2) goto L204;
        boolean r142 = true;
    L205:
        if (r142 == false) goto L200;
        r141 = r141 + 1;
        if (r141 >= 0) goto L200;
        CollectionsKt.throwCountOverflow();
        goto L200
    L204:
        r142 = false;
        goto L205
    L209:
        int r233 = r141;
    L211:
        if (r69 == true) goto L213;
    L215:
        Iterator r143 = r68.iterator();
        int r144 = 0;
    L217:
        if (r143.hasNext() == false) goto L226;
        if (((ResourceKmp) r143.next()).getResourceType() != 3) goto L221;
        boolean r145 = true;
    L222:
        if (r145 == false) goto L217;
        r144 = r144 + 1;
        if (r144 >= 0) goto L217;
        CollectionsKt.throwCountOverflow();
        goto L217
    L221:
        r145 = false;
        goto L222
    L226:
        int r234 = r144;
    L227:
        if (r69 == true) goto L229;
    L231:
        Iterator r71 = r68.iterator();
        int r146 = 0;
    L233:
        if (r71.hasNext() == false) goto L246;
        ResourceKmp r147 = (ResourceKmp) r71.next();
        if (r147.getResourceType() != 1) goto L237;
    L241:
        boolean r148 = false;
    L242:
        if (r148 == false) goto L233;
        r146 = r146 + 1;
        if (r146 >= 0) goto L233;
        CollectionsKt.throwCountOverflow();
        goto L233
    L237:
        if (r147.getResourceType() == 2) goto L241;
        if (r147.getResourceType() == 3) goto L241;
        r148 = true;
        goto L242
    L246:
        int r235 = r146;
    L247:
        ArrayList r72 = new ArrayList();
        Iterator r149 = r68.iterator();
    L249:
        if (r149.hasNext() == false) goto L256;
        Object r150 = r149.next();
        if (((ResourceKmp) r150).getResourceType() != 2) goto L253;
        boolean r151 = true;
    L254:
        if (r151 == false) goto L249;
        r72.add(r150);
        goto L249
    L253:
        r151 = false;
        goto L254
    L256:
        Iterator r73 = r72.iterator();
        double r236 = 0.0d;
    L258:
        if (r73.hasNext() == false) goto L266;
        VideoResourceKmp r74 = ((ResourceKmp) r73.next()).getVideoInfo();
        if (r74 == null) goto L264;
        Double r75 = r74.getDuration();
        if (r75 == null) goto L264;
        double r152 = r75.doubleValue();
    L265:
        r236 = r236 + r152;
    L264:
        r152 = 0.0d;
        goto L265
    L266:
        ArrayList r76 = new ArrayList();
        Iterator r77 = r68.iterator();
    L268:
        if (r77.hasNext() == false) goto L275;
        Object r78 = r77.next();
        if (((ResourceKmp) r78).getResourceType() != 3) goto L272;
        boolean r153 = true;
    L273:
        if (r153 == false) goto L268;
        r76.add(r78);
        goto L268
    L272:
        r153 = false;
        goto L273
    L275:
        Iterator r79 = r76.iterator();
        double r237 = 0.0d;
    L277:
        if (r79.hasNext() == false) goto L285;
        AudioResourceKmp r80 = ((ResourceKmp) r79.next()).getAudioInfo();
        if (r80 == null) goto L283;
        Double r81 = r80.getDuration();
        if (r81 == null) goto L283;
        double r82 = r81.doubleValue();
    L284:
        r237 = r237 + r82;
    L283:
        r82 = 0.0d;
        goto L284
    L285:
        cq9.a r83 = new cq9.a(r232, r233, r234, r235, r236, r237, Integer.valueOf(r64.size()));
        UserCreationTrackParamsKmp r84 = r40.getClientTrackParams();
        if (r84 == null) goto L288;
        r84.getLogId();
    L288:
        cq9.b.a(r66, r67, "creation_feed", "ref_resources", r83, null, null, null, 464);
        goto L289
    L229:
        if (r68.isEmpty() == false) goto L231;
        r235 = 0;
        goto L247
    L213:
        if (r68.isEmpty() == false) goto L215;
        r234 = 0;
        goto L227
    L196:
        if (r68.isEmpty() == false) goto L198;
        r233 = 0;
        goto L211
    L179:
        if (r68.isEmpty() == false) goto L181;
        r232 = 0;
    L289:
        return r231;
    L171:
        r230 = null;
        goto L172
    L167:
        r60 = null;
        goto L168
    L161:
        r137 = null;
        goto L162
    L134:
        r134 = null;
        goto L135
    L163:
        r132 = r132;
        r133 = r133;
        r0 = null;
        goto L164
    L121:
        r45 = null;
        goto L122
    L115:
        r130 = null;
        goto L116
    L117:
        r131 = null;
        goto L118
    L105:
        r41 = null;
        goto L106
    L101:
        r38 = null;
        goto L102
    L107:
        r35 = r35;
        r126 = null;
        goto L108
    L109:
        r35 = r35;
        r127 = null;
        goto L110
    L93:
        r35 = null;
        goto L94
    L87:
        r119 = null;
        goto L88
    L81:
        r224 = null;
        goto L82
    L75:
        r1 = null;
        goto L76
    L77:
        r223 = null;
        goto L78
    L69:
        r222 = null;
        goto L70
    L65:
        r219 = null;
        goto L66
    L61:
        r218 = null;
        goto L62
    L83:
        r118 = null;
        goto L84
    L53:
        r217 = null;
        goto L54
    L55:
        r112 = null;
        goto L56
    L45:
        r216 = null;
        goto L46
    L41:
        r215 = null;
        goto L42
    L37:
        r212 = null;
        goto L38
    L47:
        r110 = null;
        goto L48
    L29:
        r211 = null;
        goto L30
    L31:
        r16 = null;
        goto L32
    L21:
        r27 = null;
        goto L22
    L17:
        r26 = null;
        goto L18
    L13:
        r25 = null;
        goto L14
    L9:
        r22 = null;
        goto L10
    L23:
        r13 = null;
        goto L24
    L89:
        r32 = null;
        goto L90
    }

    public static final List<UserCreation> e(List<UserCreationKmp> r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        List<UserCreationKmp> r3 = r2;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r0.add(d((UserCreationKmp) r4.next()));
        goto L4
    L6:
        return r0;
    }
}
