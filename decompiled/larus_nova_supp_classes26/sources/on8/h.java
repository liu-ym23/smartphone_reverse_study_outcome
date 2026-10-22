package on8;

import android.view.View;
import androidx.collection.LruCache;
import com.larus.bmhome.chat.api.q0;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ContentCover;
import com.larus.im.bean.message.block.ImageDetailStruct;
import com.larus.im.bean.message.block.UgcItem;
import com.larus.im.bean.message.block.UrlStruct;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.CachedVideosPreloadFrom;
import com.larus.platform.api.FirstFramePreloadVideoData;
import com.larus.platform.api.InnerVideoPreloadScene;
import com.larus.platform.api.PrefetchRecommendVideoParam;
import com.larus.platform.api.r2;
import com.larus.platform.api.v;
import com.larus.platform.api.v4;
import com.larus.platform.model.video.business.EnterVideoMethod;
import com.larus.platform.uimodel.ArticleParam;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.platform.uimodel.MediaEntityContainer;
import com.larus.platform.uimodel.VideoParam;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kc8.y;
import kc8.z;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import xc8.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h implements b {
    public final Message a;
    public final List<UgcItem> b;
    public final boolean c;
    public final boolean d;
    public final kc8.b e;
    public final Lazy f;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // on8.b
    public final void a(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        kc8.b r0 = this.e;
        if (r0 == null) goto L14;
        y r1 = r0.a;
        if (r1 == null) goto L15;
        z r2 = r1.A;
        if (r2 != null) goto L9;
        return;
    L9:
        if ((r4 instanceof st8.a) == false) goto L11;
        st8.a r5 = (st8.a) r4;
    L12:
        z.a.a(r2, null, r5, 4);
        return;
    L11:
        r5 = null;
        goto L12
    L15:
        return;
    }

    @Override // on8.b
    public final void b(View r2, final int r3, final int r4, final UgcItem r5) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r5, "item");
        ExposeXTrackerExtKt.b(r2, new e(this, r5, r3, r4));
    }

    @Override // on8.b
    public final void c(View r35, int r36, int r37, pr8.c r38) {
        Intrinsics.checkNotNullParameter(r35, "anchor");
        Intrinsics.checkNotNullParameter(r38, "item");
        int r2 = qr8.a.a;
        int r12 = r36 % r37;
        qr8.a.b(r38.e, r38.a, r38.k, r36, r12, this.a, false, null, 960);
        int r3 = r36 / r37;
        String r14 = r38.a;
        boolean r4 = true;
        int r5 = r36 + 1;
        Message r6 = this.a;
        Integer r7 = null;
        if (r6 == null) goto L5;
        String r29 = r6.getReplyId();
    L6:
        Message r8 = this.a;
        if (r8 == null) goto L9;
        String r19 = com.larus.bmhome.chat.bean.d.x(r8).getReqId();
    L10:
        VideoParam.RecommendType r31 = VideoParam.RecommendType.Search;
        String r21 = String.valueOf(r3 + 1);
        String r22 = String.valueOf(r12 + 1);
        Message r9 = this.a;
        if (r9 == null) goto L13;
        String r26 = r9.getMessageId();
    L14:
        kc8.b r10 = this.e;
        if (r10 == null) goto L23;
        y r11 = r10.a;
        if (r11 == null) goto L23;
        Function0 r13 = r11.l;
        if (r13 == null) goto L23;
        BotModel r15 = (BotModel) r13.invoke();
        if (r15 == null) goto L23;
        String r27 = r15.getBotId();
    L24:
        Message r16 = this.a;
        if (r16 == null) goto L27;
        String r28 = r16.getSectionId();
    L28:
        ArticleParam r17 = new ArticleParam(r14, "chat_first_card", Integer.valueOf(r5), null, 1, r19, "normal_video", r21, r22, "mixed", "recommend", "no_text", r26, r27, r28, r29, null, r31, 65544, null);
        Map<String, CopyOnWriteArrayList<com.larus.bmhome.video.g>> r18 = com.larus.bmhome.video.e.a;
        String r20 = r38.a;
        if (r20 != null) goto L31;
        r20 = "";
    L31:
        String r23 = r38.k;
        Integer r24 = r38.l;
        if (r24 != null) goto L34;
    L42:
        String r25 = "414";
    L43:
        com.larus.bmhome.video.e.b("Search", CollectionsKt.listOf(new com.larus.bmhome.video.g(r20, r23, r25)));
        IFlowSdkDepend r30 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r30 == null) goto L49;
        r2 r32 = r30.A0();
        if (r32 == null) goto L50;
        r32.m(r35.getContext(), r17, r35);
        return;
    L50:
        return;
    L49:
        return;
    L34:
        if (r24.intValue() != 0) goto L37;
        r4 = false;
    L37:
        if (r4 == false) goto L39;
        r7 = r24;
    L39:
        if (r7 == null) goto L42;
        r25 = r7.toString();
        if (r25 != null) goto L43;
    L27:
        r28 = null;
    L23:
        r27 = null;
        goto L24
    L13:
        r26 = null;
        goto L14
    L9:
        r19 = null;
        goto L10
    L5:
        r29 = null;
        goto L6
    }

    @Override // on8.b
    public final void d(View r66, int r67, int r68, pr8.c r69) {
        Intrinsics.checkNotNullParameter(r66, "anchor");
        Intrinsics.checkNotNullParameter(r69, "item");
        int r2 = qr8.a.a;
        int r12 = r67 % r68;
        qr8.a.b(r69.e, r69.a, r69.k, r67, r12, this.a, false, null, 960);
        List<UgcItem> r3 = this.b;
        Iterator<UgcItem> r4 = r3.iterator();
        int r6 = 0;
    L4:
        if (r4.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(r4.next().getItemId(), r69.a) == true) goto L10;
        r6 = r6 + 1;
    L10:
        int r5 = RangesKt.coerceAtLeast(r6, 0);
        Iterator<T> r7 = this.b.iterator();
    L12:
        if (r7.hasNext() == false) goto L16;
        Object r8 = r7.next();
        if (Intrinsics.areEqual(((UgcItem) r8).getItemId(), r69.a) == false) goto L12;
    L17:
        UgcItem r9 = (UgcItem) r8;
        List<UgcItem> r10 = r3;
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<T> r13 = r10.iterator();
    L19:
        if (r13.hasNext() == false) goto L21;
        UgcItem r14 = (UgcItem) r13.next();
        r11.add(new MediaEntity(null, r14.getItemId(), null, null, null, null, null, null, null, null, null, null, r14.getSource(), null, null, null, 0, null, null, null, null, null, null, null, 16773117, null));
        goto L19
    L21:
        ArrayList r15 = new ArrayList(r11);
        MediaEntityContainer r16 = new MediaEntityContainer(null, r15, null, null, false, 0, 0, null, 253, null);
        int r17 = r67 / r68;
        ArrayList r18 = new ArrayList();
        Iterator<T> r19 = r10.iterator();
    L23:
        if (r19.hasNext() == false) goto L27;
        String r110 = ((UgcItem) r19.next()).getItemId();
        if (r110 == null) goto L23;
        r18.add(r110);
        goto L23
    L27:
        HashMap r111 = new HashMap();
        Iterator<T> r20 = r10.iterator();
    L29:
        if (r20.hasNext() == false) goto L48;
        UgcItem r112 = (UgcItem) r20.next();
        String r21 = r112.getItemId();
        if (r21 == null) goto L29;
        Integer r113 = r112.getRecChannelId();
        if (r113 != null) goto L35;
    L44:
        String r22 = "414";
    L45:
        r111.put(r21, r22);
        goto L29
    L35:
        if (r113.intValue() == 0) goto L37;
        boolean r23 = true;
    L38:
        if (r23 == true) goto L41;
        r113 = null;
    L41:
        if (r113 == null) goto L44;
        r22 = r113.toString();
        if (r22 != null) goto L45;
    L37:
        r23 = false;
        goto L38
    L48:
        if (this.c == false) goto L50;
        VideoParam.RecommendType r24 = VideoParam.RecommendType.Search;
    L51:
        Message r25 = this.a;
        String r114 = r69.k;
        boolean r26 = this.d;
        Lazy r115 = com.larus.bmhome.video.b.a;
        int r116 = ((Number) com.larus.bmhome.video.b.a().getFirst()).intValue();
        Intrinsics.checkNotNullParameter(r18, "itemIds");
        Intrinsics.checkNotNullParameter(r24, "recommendType");
        if (r25 != null) goto L54;
    L53:
        ArrayList r33 = r18;
    L65:
        v4 r27 = null;
    L66:
        Message r28 = this.a;
        String r117 = r69.a;
        boolean r118 = this.c;
        final boolean r119 = this.d;
        VideoParam.RecommendType r34 = r24;
        ArrayList r29 = r33;
        Intrinsics.checkNotNullParameter(r29, "itemIds");
        if (r28 == null) goto L81;
        if (r117 == null) goto L81;
        String r1 = r28.getMessageId();
        if (r1 != null) goto L74;
    L77:
        boolean r30 = true;
    L78:
        if (r30 == true) goto L81;
        if (r118 == false) goto L81;
        CachedVideosPreloadFrom r120 = CachedVideosPreloadFrom.BIND_PULL_API;
        String r121 = r28.getMessageId();
        String r31 = r28.getReplyId();
        List r122 = CollectionsKt.listOf(r117);
        kc8.b r123 = this.e;
        if (r123 == null) goto L89;
        y r124 = r123.a;
        if (r124 == null) goto L89;
        q0 r125 = r124.x;
        if (r125 == null) goto L89;
        List<Message> r126 = r125.getCurrentList();
    L90:
        PrefetchRecommendVideoParam r57 = new PrefetchRecommendVideoParam(r121, r31, Boolean.TRUE, r122, Integer.valueOf(r5), r120, r29, new c(r119), Boolean.valueOf(m.b(r28, r126)), null, true, 0, null, false, null, 29184, null);
    L91:
        Message r32 = this.a;
        if (r32 == null) goto L94;
        String r127 = r32.getSenderId();
    L95:
        Message r35 = this.a;
        if (r35 == null) goto L98;
        String r128 = r35.getMessageId();
    L99:
        Message r36 = this.a;
        if (r36 == null) goto L102;
        String r129 = r36.getConversationId();
    L103:
        String r210 = EnterVideoMethod.FLOW_CLICK_RECOMMEND_VIDEO_CARD.getValue();
        boolean r37 = false;
        Map r211 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("enter_method", "click_video_card"), TuplesKt.to("previous_page", "chat")});
        Message r38 = this.a;
        if (r38 == null) goto L106;
        String r39 = r38.getSectionId();
    L107:
        String r40 = r69.k;
        LruCache<String, wc9.e> r41 = ko8.a.a;
        de8.c r42 = (de8.c) this.f.getValue();
        if (r42 == null) goto L110;
        long r130 = r42.n;
    L111:
        String r310 = ko8.a.e(r130);
        Message r43 = this.a;
        if (r43 == null) goto L114;
        String r44 = r43.getReplyId();
    L115:
        String r49 = String.valueOf(r17 + 1);
        String r50 = String.valueOf(r12 + 1);
        String r131 = r69.a;
        int r132 = r67 + 1;
        Integer r45 = r69.l;
        if (r45 != null) goto L118;
    L128:
        String r47 = "414";
    L129:
        if (r9 == null) goto L137;
        ContentCover r46 = r9.getCover();
        if (r46 == null) goto L137;
        ImageDetailStruct r48 = r46.getOriginCover();
        if (r48 == null) goto L137;
        UrlStruct r51 = r48.getImageOri();
        if (r51 == null) goto L137;
        String r52 = r51.getUrl();
    L138:
        if (r52 != null) goto L140;
        r52 = "";
    L140:
        String r212 = r52;
        if (r9 == null) goto L151;
        ContentCover r53 = r9.getCover();
        if (r53 == null) goto L151;
        ImageDetailStruct r54 = r53.getOriginCover();
        if (r54 == null) goto L151;
        UrlStruct r55 = r54.getImageOri();
        if (r55 == null) goto L151;
        Long r56 = r55.getWidth();
        if (r56 == null) goto L151;
        int r213 = (int) r56.longValue();
    L152:
        if (r9 == null) goto L162;
        ContentCover r58 = r9.getCover();
        if (r58 == null) goto L162;
        ImageDetailStruct r59 = r58.getOriginCover();
        if (r59 == null) goto L162;
        UrlStruct r60 = r59.getImageOri();
        if (r60 == null) goto L162;
        Long r61 = r60.getHeight();
        if (r61 == null) goto L162;
        int r214 = (int) r61.longValue();
    L164:
        if (r27 == null) goto L166;
        ArrayList r62 = r27.b;
    L167:
        if (r27 == null) goto L169;
        Map r63 = r27.a;
    L170:
        if (r27 == null) goto L172;
        Boolean r133 = Boolean.valueOf(r27.c);
    L173:
        if (r27 == null) goto L175;
        Map r64 = r27.d;
    L176:
        String r311 = r39;
        String r312 = r44;
        VideoParam r65 = new VideoParam(r15, r16, null, r127, r128, r129, null, r5, r210, r212, null, r211, null, r214, r213, null, false, r311, r40, r310, r34, false, null, null, r312, null, "chat_first_card", r131, null, 1, Integer.valueOf(r132), null, null, r47, "normal_video", r49, r50, "mixed", "recommend", "no_text", null, null, new FirstFramePreloadVideoData(r62, r63, r133, r64), r57, false, 0, null, null, -1830710204, 124673);
        IFlowSdkDepend r70 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r70 == null) goto L196;
        r2 r71 = r70.A0();
        if (r71 == null) goto L197;
        r71.r(r66.getContext(), r65, r66, null);
        return;
    L197:
        return;
    L196:
        return;
    L175:
        r64 = null;
        goto L176
    L172:
        r133 = null;
        goto L173
    L169:
        r63 = null;
        goto L170
    L166:
        r62 = null;
    L162:
        r214 = 10;
    L151:
        r213 = 10;
    L137:
        r52 = null;
        goto L138
    L118:
        if (r45.intValue() == 0) goto L120;
        r37 = true;
    L120:
        if (r37 == true) goto L123;
        r45 = null;
    L123:
        if (r45 == null) goto L128;
        String r72 = r45.toString();
        if (r72 == null) goto L128;
        r47 = r72;
        goto L129
    L114:
        r44 = null;
        goto L115
    L110:
        r130 = 0;
        goto L111
    L106:
        r39 = null;
        goto L107
    L102:
        r129 = null;
        goto L103
    L98:
        r128 = null;
        goto L99
    L94:
        r127 = null;
    L89:
        r126 = null;
        goto L90
    L74:
        if (r1.length() == 0) goto L77;
        r30 = false;
    L81:
        r57 = null;
        goto L91
    L54:
        String r134 = r25.getMessageId();
        if (r134 == null) goto L53;
        if (r24 != VideoParam.RecommendType.Search) goto L53;
        LruCache<String, wc9.e> r135 = ko8.a.a;
        r33 = r18;
        v r73 = new v(r134, Boolean.valueOf(r26), r114, r116, r5, ko8.a.c(r25), (String) CollectionsKt.getOrNull(r18, r5), r33, InnerVideoPreloadScene.ChatFirstCard.getSceneValue(), r25.getSenderId(), null, 0, r111, 1024);
        IFlowSdkDepend r74 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r74 == null) goto L65;
        r2 r75 = r74.A0();
        if (r75 == null) goto L65;
        r27 = r75.d(r73, true);
        goto L66
    L50:
        r24 = VideoParam.RecommendType.Non;
        goto L51
    L16:
        r8 = null;
        goto L17
    L9:
        r6 = -1;
        goto L10
    }

    public h(Message r2, List<UgcItem> r3, boolean r4, boolean r5, kc8.b r6) {
        Intrinsics.checkNotNullParameter(r3, "items");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = LazyKt.lazy(new d(this));
    }
}
