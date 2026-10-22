package com.larus.bmhome.chat.list.cell.video;

import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.JsonObject;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.require.MainBotServiceDelegate;
import com.larus.bmhome.chat.search.VideoInfo;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.common.apphost.AppHost;
import com.larus.flow.video.bean.CommonVideoModel;
import com.larus.im.bean.message.ItemData;
import com.larus.im.bean.message.ItemShowType;
import com.larus.im.bean.message.Message;
import com.larus.platform.model.video.business.VideoFeedProviderDelegate;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.platform.uimodel.MediaEntityContainer;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import tx9.o3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class j implements Function3 {
    public final /* synthetic */ AwemeVideoListCell a;
    public final /* synthetic */ Message b;

    public /* synthetic */ j(AwemeVideoListCell r1, Message r2) {
        this.a = r1;
        this.b = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v22, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.util.ArrayList] */
    public final Object invoke(Object r38, Object r39, Object r40) {
        AwemeVideoListCell r1 = this.a;
        Message r2 = this.b;
        pi8.l r3 = (pi8.l) r38;
        oi8.k r4 = (oi8.k) r39;
        oi8.c r5 = (oi8.c) r40;
        int r6 = AwemeVideoListCell.j;
        Intrinsics.checkNotNullParameter(r3, "callbackData");
        Intrinsics.checkNotNullParameter(r4, "searchListData");
        ItemData r7 = r3.a;
        int r8 = AwemeVideoListCell$b.a[r7.getSearchItemType().ordinal()];
        if (r8 == 1) goto L9;
        if (r8 != 2) goto L108;
        r1.e = false;
        r7.setItemShowType(ItemShowType.ITEM_SHOW_TYPE_NONE);
    L108:
        return Unit.INSTANCE;
    L9:
        if ((r7 instanceof VideoInfo) == false) goto L113;
        int r9 = r3.b;
        VideoInfo r10 = (VideoInfo) r7;
        r1.getClass();
        ?? r11 = 0;
        Integer r12 = null;
        if (com.larus.bmhome.chat.bean.d.z0(r2) == false) goto L62;
        RecyclerView r13 = ((BaseMessageListCell) r1).b;
        if (r13 == null) goto L16;
        Object r14 = r13.getTag(2131384073);
    L18:
        if (TypeIntrinsics.isMutableSet(r14) == false) goto L20;
        Set r15 = (Set) r14;
    L21:
        Integer r16 = Integer.valueOf(r9);
        ChatControlTrace r17 = ChatControlTrace.b;
        Triple r18 = new Triple(r2, r16, "onShowOnboardingCard");
        if (r15 != null) goto L24;
    L26:
        boolean r19 = false;
    L27:
        if (r19 == false) goto L62;
        r15.add(r18);
        ChatControlTrace r20 = ChatControlTrace.b;
        String r110 = r2.getMessageId();
        String r111 = r2.getSenderId();
        long r112 = r9 + 1;
        String r25 = r10.getItemShowType().getType();
        de8.c r21 = (de8.c) r1.g.getValue();
        if (r21 == null) goto L31;
        long r113 = r21.n;
    L32:
        String r27 = com.larus.im.bean.message.a.x(r2);
        Long r24 = Long.valueOf(r112);
        r20.getClass();
        com.larus.bmhome.chat.trace.a r114 = (com.larus.bmhome.chat.trace.a) ChatControlTrace.C.get(Long.valueOf(r113));
        if (r114 == null) goto L60;
        if (r110 == null) goto L41;
        String r115 = StringsKt.removeSuffix(r110, ":fake_message:1");
        if (r115 == null) goto L41;
        if (StringsKt.contains(r110, "local-", true) == false) goto L40;
        r115 = null;
    L40:
        String r116 = r115;
    L42:
        String r22 = r114.a;
        if (r22 != null) goto L45;
    L48:
        boolean r23 = true;
    L49:
        if (r23 == true) goto L52;
        r111 = r114.a;
    L52:
        if (r111 == null) goto L54;
        Long r26 = StringsKt.toLongOrNull(r111);
    L55:
        String r117 = r114.g;
        if (r117 == null) goto L58;
        Long r118 = StringsKt.toLongOrNull(r117);
    L59:
        String r119 = r114.j;
        String r120 = r114.k;
        String r28 = String.valueOf(0);
        o3.e(r26, r20.h(r113), r118, r119, r116, null, "", "video_card", r120, null, r24, r25, r28, r27, null, 786529);
        goto L62
    L58:
        r118 = null;
        goto L59
    L54:
        r26 = null;
        goto L55
    L45:
        if (r22.length() == 0) goto L48;
        r23 = false;
    L41:
        r116 = null;
        goto L42
    L60:
        FLogger.a.d("ChatControlTrace", "onShowOnboardingCard chatKey not found");
        goto L62
    L31:
        r113 = 0;
        goto L32
    L24:
        if (r15.contains(r18) == true) goto L26;
        r19 = true;
        goto L27
    L20:
        r15 = null;
        goto L21
    L16:
        r14 = null;
    L62:
        if (MainBotServiceDelegate.b.b() == false) goto L64;
    L93:
        List<VideoInfo> r29 = r10.getVideoInfoList();
        if (r29 == null) goto L102;
        List<VideoInfo> r30 = r29;
        r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r30, 10));
        Iterator r31 = r30.iterator();
    L97:
        if (r31.hasNext() == false) goto L102;
        String r32 = ((VideoInfo) r31.next()).getItemId();
        if (r32 != null) goto L101;
        r32 = "";
    L101:
        r11.add(new pr9.a(r32, false, 14));
    L102:
        if (r11 != 0) goto L104;
        r11 = CollectionsKt.emptyList();
    L104:
        qr9.c r33 = VideoFeedProviderDelegate.b.b();
        if (r33 == null) goto L108;
        r33.b(r11);
        goto L108
    L64:
        if (9 == r2.getContentType()) goto L93;
        List<VideoInfo> r34 = r10.getVideoInfoList();
        if (r34 == null) goto L72;
        List<VideoInfo> r35 = r34;
        List r36 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r35, 10));
        Iterator r37 = r35.iterator();
    L70:
        if (r37.hasNext() == false) goto L73;
        VideoInfo r41 = (VideoInfo) r37.next();
        r36.add(new MediaEntity(null, r41.getItemId(), null, null, null, null, null, null, null, null, null, null, r41.getSourceFrom(), null, null, null, 0, null, null, null, null, null, null, null, 16773117, null));
    L73:
        ArrayList r42 = new ArrayList(r36);
        JsonObject r43 = r4.d();
        if ((r43 instanceof JsonObject) == false) goto L76;
        JsonObject r44 = r43;
    L77:
        if (r44 == null) goto L79;
        String r121 = r44.toString();
    L80:
        Boolean r45 = r4.b();
        if (r45 == null) goto L83;
        boolean r46 = r45.booleanValue();
    L84:
        if (r46 == true) goto L86;
    L88:
        boolean r122 = false;
    L89:
        MediaEntityContainer r47 = new MediaEntityContainer(null, r42, null, null, r122, 0, 0, r121, 109, null);
        CommonVideoModel r48 = new CommonVideoModel(null);
        r48.setLoadMoreContainer(r47);
        MediaEntity r49 = (MediaEntity) CollectionsKt.getOrNull(r42, 0);
        if (r49 == null) goto L92;
        r12 = r49.getSource_from();
    L92:
        r48.setSource(r12);
        r48.requestPreloadVideoByItemIds(r47, new l(r42, r10, r1));
        goto L108
    L86:
        if (AppHost.a.isOversea() == true) goto L88;
        r122 = true;
        goto L89
    L83:
        r46 = false;
        goto L84
    L79:
        r121 = null;
        goto L80
    L76:
        r44 = null;
        goto L77
    L72:
        r36 = CollectionsKt.emptyList();
        goto L73
    L113:
        return Unit.INSTANCE;
    }
}
