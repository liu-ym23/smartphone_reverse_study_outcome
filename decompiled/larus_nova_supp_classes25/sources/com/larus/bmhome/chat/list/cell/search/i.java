package com.larus.bmhome.chat.list.cell.search;

import android.view.View;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.layout.holder.helper.b1;
import com.larus.bmhome.chat.layout.holder.helper.n2;
import com.larus.bmhome.chat.layout.holder.helper.p2;
import com.larus.bmhome.chat.search.ArticleInfo;
import com.larus.bmhome.chat.search.CardType;
import com.larus.bmhome.chat.search.MoreInfo;
import com.larus.bmhome.chat.search.VideoInfo;
import com.larus.bmhome.chat.search.factory.SearchHolderAttachBizType;
import com.larus.bmhome.video.Content;
import com.larus.bmhome.video.ItemType;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.SearchImageInfo;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.OuterFallbackInfo;
import com.larus.platform.api.PrefetchRecommendVideoParam;
import com.larus.platform.api.r2;
import com.larus.platform.model.video.business.VideoFeedProviderDelegate;
import com.larus.utils.e1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import pi8.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class i implements Function3 {
    public final /* synthetic */ SearchListCell a;
    public final /* synthetic */ Message b;
    public final /* synthetic */ BotModel c;

    public /* synthetic */ i(SearchListCell r1, Message r2, BotModel r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v8, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.util.ArrayList] */
    public final Object invoke(Object r24, Object r25, Object r26) {
        final SearchListCell r12 = this.a;
        final Message r13 = this.b;
        final BotModel r10 = this.c;
        pi8.k r1 = (pi8.k) r24;
        final oi8.k r9 = (oi8.k) r25;
        final oi8.c r11 = (oi8.c) r26;
        int r2 = SearchListCell.o;
        Intrinsics.checkNotNullParameter(r1, "callbackData");
        Intrinsics.checkNotNullParameter(r9, "searchListData");
        boolean r14 = false;
        if ((r1 instanceof pi8.e) == false) goto L17;
        final pi8.e r15 = (pi8.e) r1;
        r12.getClass();
        String r3 = r15.a.getThumbUrl();
        if (r3 != null) goto L7;
    L8:
        r14 = true;
    L9:
        if (r14 == false) goto L11;
        r15.c.setOnClickListener(null);
        r15.c.setOnLongClickListener(null);
    L152:
        return Unit.INSTANCE;
    L11:
        Pair r4 = SearchListCell.o(com.larus.bmhome.chat.search.a.a(r13), r15.b);
        final int r5 = ((Number) r4.component1()).intValue();
        final int r6 = ((Number) r4.component2()).intValue();
        e1.d(r15.c, new b(r13, r12, r5, r6, r15, r11, r10));
        SearchImageInfo r7 = r15.a;
        q0 r8 = lf8.a.b(r12);
        q0 r16 = lf8.a.b(r12);
        if (r16 == null) goto L14;
        q0.a r17 = r16.getProvider();
    L15:
        b1.a(new n2(r13, r8, r17, r7, SearchListCell.u(r13)), r15.c);
        goto L152
    L14:
        r17 = null;
        goto L15
    L7:
        if (r3.length() != 0) goto L9;
    L17:
        if ((r1 instanceof pi8.f) == false) goto L28;
        pi8.f r18 = (pi8.f) r1;
        final ArticleInfo r19 = r18.a;
        final View r110 = r18.c;
        final ChatParam r111 = r12.t();
        final int r20 = r18.b;
        q0 r21 = lf8.a.b(r12);
        q0 r22 = lf8.a.b(r12);
        if (r22 == null) goto L21;
        q0.a r23 = r22.getProvider();
    L22:
        b1.a(new com.larus.bmhome.chat.layout.holder.helper.o(r13, r21, r23, SearchListCell.u(r13), null, null, null, DoraCallStateCode.DOUBAO_CMD_12), r110);
        Pair r27 = SearchListCell.o(com.larus.bmhome.chat.search.a.a(r13), r20);
        final int r28 = ((Number) r27.component1()).intValue();
        final int r29 = ((Number) r27.component2()).intValue();
        e1.d(r110, new e(r13, r111, r28, r29, r19, r11, r10, r20, r12, r110));
        q0 r30 = lf8.a.b(r12);
        q0 r31 = lf8.a.b(r12);
        if (r31 == null) goto L25;
        q0.a r32 = r31.getProvider();
    L26:
        b1.a(new com.larus.bmhome.chat.layout.holder.helper.o(r13, r30, r32, SearchListCell.u(r13), null, null, null, DoraCallStateCode.DOUBAO_CMD_12), r110);
        goto L152
    L25:
        r32 = null;
        goto L26
    L21:
        r23 = null;
        goto L22
    L28:
        if ((r1 instanceof s) == false) goto L100;
        final s r0 = (s) r1;
        r12.getClass();
        Pair r33 = SearchListCell.o(com.larus.bmhome.chat.search.a.a(r13), r0.b);
        final int r34 = ((Number) r33.component1()).intValue();
        final int r35 = ((Number) r33.component2()).intValue();
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new SearchListCell$bindVideoItem$1(r0, null), 2, null);
        VideoInfo r36 = r0.a;
        if (r0.e != SearchHolderAttachBizType.RichVideoCardDoubleColumn) goto L32;
        boolean r37 = true;
    L34:
        if (r0.b != 0) goto L36;
        boolean r38 = true;
    L37:
        if (r38 == false) goto L77;
        if (r37 == false) goto L77;
        List<VideoInfo> r39 = r36.getVideoInfoList();
        if (r39 == null) goto L48;
        ArrayList r40 = new ArrayList();
        Iterator r41 = r39.iterator();
    L44:
        if (r41.hasNext() == false) goto L49;
        String r42 = ((VideoInfo) r41.next()).getItemId();
        if (r42 == null) goto L44;
        r40.add(r42);
    L49:
        PrefetchRecommendVideoParam r43 = r12.r(true, r0, r36, r13, new OuterFallbackInfo(r40, 4));
        if (r43 == null) goto L57;
        IFlowSdkDepend r44 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r44 == null) goto L76;
        r2 r45 = r44.A0();
        if (r45 == null) goto L76;
        r45.g(r43);
    L76:
        r12.m = r13.getMessageId();
        goto L77
    L57:
        if (Intrinsics.areEqual(r13.getMessageId(), r12.m) == true) goto L76;
        List<VideoInfo> r46 = r0.a.getVideoInfoList();
        if (r46 == null) goto L76;
        List<VideoInfo> r47 = r46;
        ArrayList r48 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r47, 10));
        Iterator r49 = r47.iterator();
        int r50 = 0;
    L62:
        if (r49.hasNext() == false) goto L73;
        Object r51 = r49.next();
        int r52 = r50 + 1;
        if (r50 >= 0) goto L66;
        CollectionsKt.throwIndexOverflow();
    L66:
        String r53 = ((VideoInfo) r51).getItemId();
        if (r53 != null) goto L69;
        r53 = "";
    L69:
        Iterator r210 = r49;
        pr9.a r54 = new pr9.a(r53, false, 14);
        if (r50 >= 4) goto L72;
        r54.d = true;
    L72:
        r48.add(r54);
        r49 = r210;
        r50 = r52;
        goto L62
    L73:
        qr9.c r55 = VideoFeedProviderDelegate.b.b();
        if (r55 == null) goto L76;
        r55.b(r48);
        goto L76
    L48:
        r40 = null;
    L77:
        e1.d(r0.c, new f(r13, r12, r34, r35, r0, r11, r10, r9));
        int r56 = com.larus.bmhome.chat.search.a.a;
        if (r11 == null) goto L87;
        oi8.e r57 = r11.c();
        if (r57 == null) goto L87;
        Integer r58 = r57.a();
        int r59 = CardType.Video.value;
        if (r58 == null) goto L87;
        if (r58.intValue() != r59) goto L87;
        boolean r112 = true;
    L88:
        if (r112 == false) goto L94;
        q0 r60 = lf8.a.b(r12);
        q0 r61 = lf8.a.b(r12);
        if (r61 == null) goto L92;
        q0.a r62 = r61.getProvider();
    L93:
        b1.a(new p2(r13, r60, r62, SearchListCell.u(r13)), r0.c);
        goto L152
    L92:
        r62 = null;
        goto L93
    L94:
        q0 r63 = lf8.a.b(r12);
        q0 r64 = lf8.a.b(r12);
        if (r64 == null) goto L97;
        q0.a r65 = r64.getProvider();
    L98:
        b1.a(new com.larus.bmhome.chat.layout.holder.helper.o(r13, r63, r65, SearchListCell.u(r13), null, null, null, DoraCallStateCode.DOUBAO_CMD_12), r0.c);
        goto L152
    L97:
        r65 = null;
    L87:
        r112 = false;
        goto L88
    L36:
        r38 = false;
        goto L37
    L32:
        r37 = false;
        goto L34
    L100:
        if ((r1 instanceof pi8.h) == false) goto L105;
        pi8.h r66 = (pi8.h) r1;
        final MoreInfo r67 = r66.a;
        View r68 = r66.c;
        r12.getClass();
        View r69 = r68.findViewById(2131365048);
        if (r69 == null) goto L152;
        e1.d(r69, new c(r67, r10, r12));
        goto L152
    L105:
        if ((r1 instanceof pi8.g) == false) goto L154;
        final pi8.g r70 = (pi8.g) r1;
        r12.getClass();
        Integer r71 = r70.a.getItemType();
        int r72 = ItemType.VIDEO.getValue();
        if (r71 != null) goto L110;
    L112:
        String r73 = "ugc_graphic";
    L113:
        final String r113 = r73;
        int r74 = r70.b;
        final int r75 = r74 / 2;
        final int r76 = r74 % 2;
        Map r77 = r13.getExt();
        if (r77 == null) goto L116;
        List r114 = null;
        String r115 = (String) r77.getOrDefault("rich_media_type", null);
    L117:
        com.larus.bmhome.chat.search.b r78 = r9.e();
        if (r78 == null) goto L135;
        com.larus.bmhome.chat.search.b.C0073b r79 = r78.d();
        if (r79 == null) goto L135;
        List<Content> r80 = r79.a();
        if (r80 == null) goto L135;
        ArrayList r81 = new ArrayList();
        Iterator r82 = r80.iterator();
    L125:
        if (r82.hasNext() == false) goto L129;
        String r83 = ((Content) r82.next()).getItemId();
        if (r83 == null) goto L125;
        r81.add(r83);
        goto L125
    L129:
        ?? r84 = new ArrayList();
        Iterator r85 = r81.iterator();
    L131:
        if (r85.hasNext() == false) goto L136;
        Object r86 = r85.next();
        if ((!Intrinsics.areEqual((String) r86, r70.a.getItemId())) == false) goto L131;
        r84.add(r86);
    L136:
        if (r84 != 0) goto L138;
        r84 = CollectionsKt.emptyList();
    L138:
        Map r87 = r13.getExt();
        if (r87 == null) goto L143;
        String r116 = (String) r87.get("text_area_ugc_gid_list");
        if (r116 == null) goto L143;
        List r88 = StringsKt.split$default(r116, new String[]{","}, false, 0, 6, null);
    L144:
        if (r88 != null) goto L146;
        r88 = CollectionsKt.emptyList();
    L146:
        final ArrayList r89 = new ArrayList();
        r89.addAll((Collection) r84);
        r89.addAll(r88);
        final String r117 = r115;
        e1.d(r70.c, new p(r13, r12, r75, r76, r70, r11, r10, r89, r113, r117));
        q0 r90 = lf8.a.b(r12);
        q0 r91 = lf8.a.b(r12);
        if (r91 == null) goto L149;
        q0.a r92 = r91.getProvider();
    L150:
        b1.a(new com.larus.bmhome.chat.layout.holder.helper.o(r13, r90, r92, SearchListCell.u(r13), null, null, null, DoraCallStateCode.DOUBAO_CMD_12), r70.c);
        goto L152
    L149:
        r92 = null;
    L143:
        r88 = r114;
    L135:
        r84 = r114;
        goto L136
    L116:
        r114 = null;
        r115 = null;
        goto L117
    L110:
        if (r71.intValue() != r72) goto L112;
        r73 = "ugc_video";
        goto L113
    L154:
        throw new NoWhenBranchMatchedException();
    }
}
