package com.larus.bmhome.chat.layout.item;

import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.require.MainBotServiceDelegate;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.model.video.business.EnterVideoMethod;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.platform.uimodel.MediaEntityContainer;
import com.larus.platform.uimodel.VideoParam;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class j4 implements Function1 {
    public final /* synthetic */ l4 a;
    public final /* synthetic */ com.larus.bmhome.chat.list.cell.video.u b;
    public final /* synthetic */ Function0 c;

    public /* synthetic */ j4(l4 r1, com.larus.bmhome.chat.list.cell.video.u r2, com.larus.bmhome.chat.list.cell.video.p r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r61) {
        l4 r1 = this.a;
        com.larus.bmhome.chat.list.cell.video.u r2 = this.b;
        Function0 r3 = this.c;
        Intrinsics.checkNotNullParameter((View) r61, "it");
        ArrayList<MediaEntity> r4 = r1.w;
        Intrinsics.checkNotNull(r4);
        MediaEntity r5 = (MediaEntity) ListProtector.get(r4, 0);
        String r6 = r2.e;
        if (r6 != null) goto L5;
        String r12 = "";
    L6:
        ArrayList<MediaEntity> r9 = r1.w;
        MediaEntityContainer r10 = r1.y;
        if (r9 == null) goto L11;
        MediaEntity r8 = (MediaEntity) ListProtector.get(r9, 0);
        if (r8 == null) goto L11;
        Integer r11 = r8.getSource_from();
    L12:
        Message r13 = r1.x;
        if (r13 == null) goto L15;
        String r14 = r13.getMessageId();
    L16:
        Message r15 = r1.x;
        if (r15 == null) goto L19;
        String r16 = r15.getConversationId();
    L20:
        String r17 = r1.z;
        if (r5 == null) goto L23;
        String r18 = r5.getMedia_url();
    L24:
        if (r18 != null) goto L26;
        String r19 = "";
    L28:
        if (r2.c == false) goto L30;
        EnterVideoMethod r7 = EnterVideoMethod.COLLECTION_VIDEO_PAGE;
    L31:
        String r110 = r7.getValue();
        Pair[] r20 = new Pair[5];
        r20[0] = TuplesKt.to("enter_method", "click_video_card");
        r20[1] = TuplesKt.to("previous_page", "chat");
        r20[2] = TuplesKt.to("bot_id", r12);
        Message r21 = r1.x;
        if (r21 == null) goto L35;
        String r22 = r21.getMessageId();
        if (r22 == null) goto L35;
    L36:
        r20[3] = TuplesKt.to("message_id", r22);
        Message r23 = r1.x;
        if (r23 == null) goto L40;
        String r24 = r23.getConversationId();
        if (r24 == null) goto L40;
    L41:
        r20[4] = TuplesKt.to("conversation_id", r24);
        Map r25 = MapsKt.mutableMapOf(r20);
        String r111 = MainBotServiceDelegate.b.a();
        if (r5 == null) goto L46;
        Integer r26 = r5.getMedia_width();
        if (r26 == null) goto L46;
        int r27 = r26.intValue();
    L47:
        if (r5 == null) goto L51;
        Integer r28 = r5.getMedia_height();
        if (r28 == null) goto L51;
        int r29 = r28.intValue();
    L52:
        Message r30 = r1.x;
        if (r30 == null) goto L55;
        String r210 = r30.getSectionId();
    L56:
        Message r31 = r1.x;
        if (r31 == null) goto L59;
        String r33 = r31.getReplyId();
    L60:
        Message r32 = r1.x;
        if (r32 != null) goto L63;
    L65:
        boolean r34 = false;
    L66:
        if (r34 == false) goto L68;
        VideoParam.RecommendType r35 = VideoParam.RecommendType.Search;
    L69:
        VideoParam r36 = new VideoParam(r9, r10, r11, r12, r14, r16, r17, 0, r110, r19, r111, r25, null, r29, r27, null, false, r210, null, null, r35, false, null, null, r33, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, 0, null, null, -17985408, 131071);
        IFlowSdkDepend r37 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r37 == null) goto L74;
        com.larus.platform.api.r2 r38 = r37.A0();
        if (r38 == null) goto L74;
        r38.p(r1.getContext(), "", r36);
    L74:
        r3.invoke();
        return Unit.INSTANCE;
    L68:
        r35 = VideoParam.RecommendType.Non;
        goto L69
    L63:
        if (com.larus.bmhome.chat.bean.d.x(r32).getEnableVideoRecommend() != true) goto L65;
        r34 = true;
        goto L66
    L59:
        r33 = null;
        goto L60
    L55:
        r210 = null;
    L51:
        r29 = 10;
    L46:
        r27 = 10;
    L40:
        r24 = "";
    L35:
        r22 = "";
        goto L36
    L30:
        r7 = EnterVideoMethod.SEARCH_VIDEO_PAGE;
        goto L31
    L26:
        r19 = r18;
        goto L28
    L23:
        r18 = null;
        goto L24
    L19:
        r16 = null;
        goto L20
    L15:
        r14 = null;
    L11:
        r11 = null;
        goto L12
    L5:
        r12 = r6;
        goto L6
    }
}
