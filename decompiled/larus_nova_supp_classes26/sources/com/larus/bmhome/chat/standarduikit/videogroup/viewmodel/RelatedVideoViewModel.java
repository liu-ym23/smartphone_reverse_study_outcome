package com.larus.bmhome.chat.standarduikit.videogroup.viewmodel;

import android.content.Context;
import android.os.Bundle;
import androidx.collection.LruCache;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.require.MainBotServiceDelegate;
import com.larus.bmhome.chat.standarduikit.videogroup.view.RelatedVideoView;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.common.apphost.AppHost;
import com.larus.im.FlowRuntime;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.CachedVideosPreloadFrom;
import com.larus.platform.api.FirstFramePreloadVideoData;
import com.larus.platform.api.InnerVideoPreloadScene;
import com.larus.platform.api.OuterFallbackInfo;
import com.larus.platform.api.PrefetchRecommendVideoParam;
import com.larus.platform.api.r2;
import com.larus.platform.api.v;
import com.larus.platform.api.v4;
import com.larus.platform.model.video.business.EnterVideoMethod;
import com.larus.platform.model.video.business.VideoFeedProviderDelegate;
import com.larus.platform.service.z2;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.platform.uimodel.MediaEntityContainer;
import com.larus.platform.uimodel.VideoParam;
import com.larus.search.api.event.HybridEventParams;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.t0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import zn8.l;
import zn8.q;
import zn8.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class RelatedVideoViewModel {
    public static final /* synthetic */ int e = 0;
    public com.larus.bmhome.chat.standarduikit.videogroup.viewmodel.a a;
    public e b;
    public String c;
    public final Lazy d;

    public static final class a {
    }

    public static final class b implements s {
        public final /* synthetic */ RelatedVideoViewModel a;

        @Override // zn8.s
        public final void a() {
            e r0 = this.a.b;
            if (r0 == null) goto L6;
            r0.a();
            return;
        }

        public b(RelatedVideoViewModel r1) {
            this.a = r1;
        }

        @Override // zn8.s
        public final void b(Context r10, q r11) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "videoData");
            FlowRuntime.a().isOversea();
            com.larus.platform.service.q r0 = com.larus.platform.service.q.a;
            Bundle r12 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("link_url", r11.c), TuplesKt.to("enable_bottom_share_style", String.valueOf(z2.a.S2()))});
            e r1 = this.a.b;
            if (r1 == null) goto L5;
            String r4 = r1.getCurrentPage();
        L6:
            e r2 = this.a.b;
            if (r2 == null) goto L9;
            String r5 = r2.getChatType();
        L10:
            r0.e(r10, r12, new HybridEventParams("message_markdown_image", r4, r5, null, 120));
            return;
        L9:
            r5 = null;
            goto L10
        L5:
            r4 = null;
            goto L6
        }

        @Override // zn8.s
        public final void c(RelatedVideoView r45, int r46, int r47, q r48) {
            Intrinsics.checkNotNullParameter(r45, "widgetContainer");
            Intrinsics.checkNotNullParameter(r48, "videoData");
            RelatedVideoViewModel r2 = this.a;
            int r3 = RelatedVideoViewModel.e;
            r2.getClass();
            FLogger.a.i("RelatedVideoViewModel", "mobCardShow onExpose videoItem?.cardId.toString() = " + r48.a);
            ri8.c r4 = ri8.c.a;
            String r5 = r48.a;
            String r6 = r2.a.a();
            e r7 = r2.b;
            if (r7 == null) goto L5;
            String r8 = r7.getConversationId();
        L6:
            Message r9 = r2.a.c;
            if (r9 == null) goto L9;
            String r10 = r9.getReplyId();
        L10:
            e r11 = r2.b;
            if (r11 == null) goto L13;
            String r12 = r11.getCurrentPage();
        L14:
            e r13 = r2.b;
            if (r13 == null) goto L17;
            String r14 = r13.b();
        L18:
            e r15 = r2.b;
            if (r15 == null) goto L21;
            String r16 = r15.getBotId();
        L22:
            String r17 = ri8.c.h(r46, r47);
            String r0 = r48.b;
            Message r18 = r2.a.c;
            if (r18 == null) goto L25;
            String r21 = com.larus.bmhome.chat.bean.d.x(r18).getReqId();
        L26:
            Integer r19 = r2.a.d;
            String r39 = EnterVideoMethod.FLOW_CLICK_RECOMMEND_VIDEO_CARD.getValue();
            com.larus.bmhome.chat.standarduikit.videogroup.viewmodel.a r20 = r2.a;
            r20.getClass();
            LruCache<String, wc9.e> r22 = ko8.a.a;
            ri8.c.n(null, r5, r6, r8, r10, r12, r14, r19, 1, "recommend", "within_text", "video", r16, r17, "single_card", null, r0, r21, null, null, null, null, null, null, null, null, ko8.a.c(r20.c), null, null, null, null, null, null, null, null, r39, null, null, -67338239, 55);
            return;
        L25:
            r21 = null;
            goto L26
        L21:
            r16 = null;
            goto L22
        L17:
            r14 = null;
            goto L18
        L13:
            r12 = null;
            goto L14
        L9:
            r10 = null;
            goto L10
        L5:
            r8 = null;
            goto L6
        }

        @Override // zn8.s
        public final void d(Context r93, RelatedVideoView r94, SimpleDraweeView r95, final int r96, final int r97, final q r98) {
            Intrinsics.checkNotNullParameter(r93, "context");
            Intrinsics.checkNotNullParameter(r94, "widgetContainer");
            Intrinsics.checkNotNullParameter(r95, "animationView");
            Intrinsics.checkNotNullParameter(r98, "videoData");
            final RelatedVideoViewModel r11 = this.a;
            int r2 = RelatedVideoViewModel.e;
            r11.getClass();
            FlowRuntime.a().isOversea();
            final boolean r4 = false;
            final boolean r3 = false;
            t0.a(new d(r3, r4, r98, r11, r96, r97));
            if (AppHost.a.isOversea() == false) goto L17;
            String r1 = r98.c;
            if (r1 == null) goto L170;
            IFlowSdkDepend r5 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r5 == null) goto L171;
            r5.L();
            com.larus.home.impl.sdk.t0 r6 = com.larus.home.impl.sdk.t0.a;
            Pair[] r7 = new Pair[4];
            r7[0] = TuplesKt.to(MusicAppletPage.KEY_MESSAGE_ID, r11.a.a());
            Message r8 = r11.a.c;
            if (r8 == null) goto L11;
            String r9 = r8.getSectionId();
        L12:
            r7[1] = TuplesKt.to("section_id", r9);
            e r10 = r11.b;
            if (r10 == null) goto L15;
            String r12 = r10.getBotId();
        L16:
            r7[2] = TuplesKt.to("bot_id", r12);
            r7[3] = TuplesKt.to("video_id", r98.b);
            r6.i(r93, r1, MapsKt.mapOf(r7));
            return;
        L15:
            r12 = null;
            goto L16
        L11:
            r9 = null;
            goto L12
        L171:
            return;
        L170:
            return;
        L17:
            List<q> r13 = r11.a.b;
            ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
            Iterator<T> r15 = r13.iterator();
        L19:
            if (r15.hasNext() == false) goto L21;
            q r16 = (q) r15.next();
            r14.add(new MediaEntity(null, r16.b, null, null, null, null, null, null, null, null, null, null, r16.p, null, null, null, 0, null, null, null, null, null, null, r16.d, 8384509, null));
            goto L19
        L21:
            ArrayList r17 = new ArrayList(r14);
            MediaEntityContainer r18 = new MediaEntityContainer(null, r17, null, null, false, 0, 0, null, 253, null);
            if (r11.a.e == false) goto L24;
            VideoParam.RecommendType r19 = VideoParam.RecommendType.Search;
        L25:
            Integer r20 = r98.n;
            if (r20 == null) goto L28;
            int r21 = r20.intValue();
        L29:
            Integer r110 = r98.o;
            if (r110 == null) goto L32;
            int r111 = r110.intValue();
        L33:
            if (r21 <= 0) goto L36;
            if (r111 <= 0) goto L36;
            Pair r22 = TuplesKt.to(Integer.valueOf(r21), Integer.valueOf(r111));
        L48:
            int r55 = ((Number) r22.component1()).intValue();
            int r54 = ((Number) r22.component2()).intValue();
            List<q> r23 = r11.a.b;
            ArrayList r24 = new ArrayList();
            Iterator<T> r25 = r23.iterator();
        L50:
            if (r25.hasNext() == false) goto L54;
            String r112 = ((q) r25.next()).b;
            if (r112 == null) goto L50;
            r24.add(r112);
            goto L50
        L54:
            String r26 = r11.a.a();
            if (r19 == VideoParam.RecommendType.Search) goto L57;
        L84:
            v4 r27 = null;
        L85:
            MediaEntity r28 = (MediaEntity) CollectionsKt.firstOrNull(r17);
            if (r28 == null) goto L88;
            Integer r43 = r28.getSource_from();
        L89:
            e r29 = r11.b;
            if (r29 == null) goto L92;
            String r44 = r29.getBotId();
        L93:
            String r45 = r11.a.a();
            e r30 = r11.b;
            if (r30 == null) goto L96;
            String r46 = r30.getConversationId();
        L98:
            if (o0.d(r98.m) == false) goto L102;
            String r31 = r98.m;
            if (r31 == null) goto L104;
        L105:
            String r50 = r31;
        L106:
            e r32 = r11.b;
            if (r32 == null) goto L109;
            boolean r33 = Intrinsics.areEqual(r32.d(), Boolean.TRUE);
        L110:
            if (r33 == false) goto L112;
            EnterVideoMethod r34 = EnterVideoMethod.COLLECTION_VIDEO_PAGE;
        L113:
            String r49 = r34.getValue();
            Map r52 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("enter_method", "click_video_card"), TuplesKt.to("previous_page", "chat")});
            String r51 = MainBotServiceDelegate.b.a();
            Message r35 = r11.a.c;
            if (r35 == null) goto L116;
            String r58 = r35.getSectionId();
        L117:
            Message r36 = r11.a.c;
            if (r36 == null) goto L120;
            String r59 = com.larus.bmhome.chat.bean.d.x(r36).getReqId();
        L121:
            e r37 = r11.b;
            if (r37 == null) goto L124;
            String r60 = r37.getChatType();
        L125:
            String r67 = EnterVideoMethod.FLOW_CLICK_RECOMMEND_VIDEO_CARD.getValue();
            String r38 = r98.b;
            Message r39 = r11.a.c;
            if (r39 == null) goto L128;
            String r65 = r39.getReplyId();
        L129:
            if (r27 == null) goto L131;
            ArrayList r40 = r27.b;
        L132:
            if (r27 == null) goto L134;
            Map r113 = r27.a;
        L135:
            if (r27 == null) goto L137;
            Boolean r114 = Boolean.valueOf(r27.c);
        L138:
            LinkedHashMap r115 = new LinkedHashMap();
            Iterator r116 = CollectionsKt.filterNotNull(r17).iterator();
        L140:
            if (r116.hasNext() == false) goto L145;
            String r41 = ((MediaEntity) r116.next()).getItem_id();
            if (r41 == null) goto L140;
            r115.put(r41, "414");
            goto L140
        L145:
            if (r27 == null) goto L154;
            ArrayList r42 = r27.b;
            if (r42 == null) goto L154;
            List r47 = CollectionsKt.filterNotNull(r42);
            if (r47 == null) goto L154;
            Iterator r48 = r47.iterator();
        L152:
            if (r48.hasNext() == false) goto L154;
            r115.put((String) r48.next(), "416");
        L154:
            Unit r53 = Unit.INSTANCE;
            FirstFramePreloadVideoData r56 = new FirstFramePreloadVideoData(r40, r113, r114, r115);
            com.larus.bmhome.chat.standarduikit.videogroup.viewmodel.a r57 = r11.a;
            r57.getClass();
            LruCache<String, wc9.e> r61 = ko8.a.a;
            VideoParam r62 = new VideoParam(r17, r18, r43, r44, r45, r46, null, 0, r49, r50, r51, r52, null, r54, r55, null, false, r58, r59, r60, r19, false, null, null, r65, null, r67, r38, ko8.a.c(r57.c), null, null, null, null, null, "normal_video", "1", "1", null, null, null, null, null, r56, r11.b(false, r98, null), false, 0, null, null, -488533952, 124899);
            IFlowSdkDepend r63 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r63 == null) goto L173;
            r2 r64 = r63.A0();
            if (r64 == null) goto L174;
            r64.r(r93, r62, r95, null);
            return;
        L174:
            return;
        L173:
            return;
        L137:
            r114 = null;
            goto L138
        L134:
            r113 = null;
            goto L135
        L131:
            r40 = null;
            goto L132
        L128:
            r65 = null;
            goto L129
        L124:
            r60 = null;
            goto L125
        L120:
            r59 = null;
            goto L121
        L116:
            r58 = null;
            goto L117
        L112:
            r34 = EnterVideoMethod.SEARCH_VIDEO_PAGE;
            goto L113
        L109:
            r33 = false;
        L104:
            r50 = "";
            goto L106
        L102:
            r31 = r98.g;
            if (r31 != null) goto L105;
        L96:
            r46 = null;
            goto L98
        L92:
            r44 = null;
            goto L93
        L88:
            r43 = null;
            goto L89
        L57:
            if (o0.d(r26) == false) goto L84;
            if (r26 != null) goto L60;
            String r117 = "";
        L61:
            Message r66 = r11.a.c;
            if (r66 == null) goto L66;
            Map r68 = r66.getExt();
            if (r68 == null) goto L66;
            String r118 = (String) r68.get("req_id");
        L67:
            e r69 = r11.b;
            if (r69 == null) goto L70;
            Boolean r119 = r69.h(r11.a.c);
        L71:
            LruCache<String, wc9.e> r70 = ko8.a.a;
            String r120 = ko8.a.c(r11.a.c);
            String r121 = (String) CollectionsKt.firstOrNull(r24);
            e r71 = r11.b;
            if (r71 == null) goto L74;
            String r210 = r71.j();
        L75:
            String r211 = InnerVideoPreloadScene.RelatedVideo.getSceneValue();
            Message r72 = r11.a.c;
            if (r72 == null) goto L78;
            String r212 = r72.getSenderId();
        L79:
            v r73 = new v(r117, r119, r118, 1, 0, r120, r121, r24, r211, r212, r210, null, null, 6144);
            IFlowSdkDepend r74 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r74 == null) goto L84;
            r2 r75 = r74.A0();
            if (r75 == null) goto L84;
            r27 = r75.d(r73, false);
            goto L85
        L78:
            r212 = null;
            goto L79
        L74:
            r210 = null;
            goto L75
        L70:
            r119 = null;
        L66:
            r118 = null;
            goto L67
        L60:
            r117 = r26;
        L36:
            Integer r76 = r98.h;
            if (r76 == null) goto L39;
            int r77 = r76.intValue();
        L40:
            Integer r122 = r98.i;
            if (r122 == null) goto L43;
            int r123 = r122.intValue();
        L44:
            if (r77 <= 0) goto L47;
            if (r123 <= 0) goto L47;
            r22 = TuplesKt.to(Integer.valueOf(r77), Integer.valueOf(r123));
        L47:
            r22 = TuplesKt.to(10, 10);
            goto L48
        L43:
            r123 = 0;
            goto L44
        L39:
            r77 = 0;
            goto L40
        L32:
            r111 = 0;
            goto L33
        L28:
            r21 = 0;
            goto L29
        L24:
            r19 = VideoParam.RecommendType.Non;
            goto L25
        }
    }

    static {
    }

    public RelatedVideoViewModel() {
        this.a = new com.larus.bmhome.chat.standarduikit.videogroup.viewmodel.a(new l(false, false, false, 0), CollectionsKt.emptyList(), null, null, false);
        this.d = LazyKt.lazy(new com.larus.bmhome.chat.standarduikit.videogroup.viewmodel.b(this));
    }

    public final void a(com.larus.bmhome.chat.standarduikit.videogroup.viewmodel.a r9, e r10) {
        Intrinsics.checkNotNullParameter(r9, "vmData");
        this.a = r9;
        this.b = r10;
        q r11 = (q) CollectionsKt.firstOrNull(r9.b);
        if (r11 == null) goto L43;
        List<q> r12 = this.a.b;
        ArrayList r0 = new ArrayList();
        Iterator<T> r13 = r12.iterator();
    L6:
        if (r13.hasNext() == false) goto L10;
        String r1 = ((q) r13.next()).b;
        if (r1 == null) goto L6;
        r0.add(r1);
        goto L6
    L10:
        PrefetchRecommendVideoParam r14 = b(true, r11, new OuterFallbackInfo(r0, 1));
        if (r14 == null) goto L17;
        IFlowSdkDepend r2 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r2 == null) goto L33;
        r2 r3 = r2.A0();
        if (r3 == null) goto L33;
        r3.g(r14);
    L33:
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new RelatedVideoViewModel$bindData$1$1(r11, null), 2, null);
        return;
    L17:
        List<q> r15 = this.a.b;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator<T> r16 = r15.iterator();
        int r5 = 0;
    L19:
        if (r16.hasNext() == false) goto L30;
        Object r6 = r16.next();
        int r7 = r5 + 1;
        if (r5 >= 0) goto L23;
        CollectionsKt.throwIndexOverflow();
    L23:
        String r8 = ((q) r6).b;
        if (r8 != null) goto L26;
        r8 = "";
    L26:
        pr9.a r17 = new pr9.a(r8, false, 14);
        if (r5 != 0) goto L29;
        r17.d = true;
    L29:
        r4.add(r17);
        r5 = r7;
        goto L19
    L30:
        qr9.c r18 = VideoFeedProviderDelegate.b.b();
        if (r18 == null) goto L33;
        r18.b(r4);
        goto L33
    }

    public final PrefetchRecommendVideoParam b(boolean r36, q r37, OuterFallbackInfo r38) {
        if (r37 != null) goto L5;
        return null;
    L5:
        Message r3 = this.a.c;
        if (r3 != null) goto L8;
        return null;
    L8:
        AppHost.Companion r4 = AppHost.a;
        if (r4.isOversea() == false) goto L12;
        return null;
    L12:
        if (r4.isPlugin() == false) goto L14;
        return null;
    L14:
        boolean r5 = this.a.e;
        String r6 = r3.getMessageId();
        if (r6 != null) goto L17;
    L20:
        boolean r7 = true;
    L21:
        if (r7 == false) goto L24;
        return null;
    L24:
        if (Intrinsics.areEqual(r3.getMessageId(), this.c) == false) goto L27;
        if (r36 == false) goto L27;
        return null;
    L27:
        if (r5 == false) goto L29;
        VideoParam.RecommendType r8 = VideoParam.RecommendType.Search;
    L31:
        if (r8 == VideoParam.RecommendType.Search) goto L33;
        return null;
    L33:
        List<q> r9 = this.a.b;
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r11 = r9.iterator();
    L35:
        if (r11.hasNext() == false) goto L37;
        q r12 = (q) r11.next();
        r10.add(new MediaEntity(null, r12.b, null, null, null, null, null, null, null, null, null, null, r12.p, null, null, null, 0, null, null, null, null, null, null, null, 16773117, null));
        goto L35
    L37:
        ArrayList r2 = new ArrayList(r10);
        this.c = this.a.a();
        CachedVideosPreloadFrom r13 = CachedVideosPreloadFrom.BIND_PULL_API;
        String r14 = r3.getReplyId();
        String r15 = r3.getMessageId();
        String r1 = r37.b;
        if (r1 != null) goto L40;
        r1 = "";
    L40:
        List r16 = CollectionsKt.listOf(r1);
        ArrayList r17 = new ArrayList();
        Iterator r18 = r2.iterator();
    L42:
        if (r18.hasNext() == false) goto L49;
        MediaEntity r19 = (MediaEntity) r18.next();
        if (r19 == null) goto L46;
        String r20 = r19.getItem_id();
    L47:
        if (r20 == null) goto L42;
        r17.add(r20);
        goto L42
    L46:
        r20 = null;
        goto L47
    L49:
        com.larus.bmhome.chat.standarduikit.videogroup.viewmodel.a r21 = this.a;
        boolean r22 = r21.e;
        e r23 = this.b;
        if (r23 == null) goto L52;
        boolean r24 = Intrinsics.areEqual(r23.h(r21.c), Boolean.TRUE);
    L53:
        e r25 = this.b;
        if (r25 == null) goto L56;
        String r110 = r25.j();
    L58:
        return new PrefetchRecommendVideoParam(r15, r14, Boolean.valueOf(r22), r16, 0, r13, r17, new c(this), Boolean.valueOf(r24), r110, false, null, r38, false, null, 27648, null);
    L56:
        r110 = null;
        goto L58
    L52:
        r24 = false;
        goto L53
    L29:
        r8 = VideoParam.RecommendType.Non;
        goto L31
    L17:
        if (r6.length() == 0) goto L20;
        r7 = false;
        goto L21
    }
}
