package com.larus.bmhome.double_post.fragment;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.larus.bmhome.video.Content;
import com.larus.im.bean.message.Message;
import com.larus.platform.uimodel.VideoParam;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class s implements ip8.e {
    public final /* synthetic */ AwemeDoublePostFragment a;
    public final /* synthetic */ RecyclerView b;

    @Override // ip8.e
    public final void a(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r4, "view");
        AwemeDoublePostFragment r5 = this.a;
        int r0 = AwemeDoublePostFragment.A;
        AwemeDoublePostViewModel.loadMoreData$default(r5.Z90(), null, false, 3, null);
        this.a.getClass();
    }

    public s(AwemeDoublePostFragment r1, RecyclerView r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // ip8.e
    public final void c(View r25, Content r26) {
        Intrinsics.checkNotNullParameter(r25, "view");
        FragmentActivity r1 = this.a.getActivity();
        if (r1 == null) goto L52;
        if (r26 == null) goto L53;
        int r12 = this.a.i.I2(r26);
        if (r12 >= 0) goto L9;
    L49:
        FLogger.a.i("AwemeDoublePostFragment", "clickData: can't find data[" + r26.getItemId() + ", " + r26.getItemType() + "] with index(" + r12 + ')');
        return;
    L9:
        if (r12 >= this.a.i.getItemCount()) goto L49;
        StaggeredGridLayoutManager.LayoutParams r3 = r25.getLayoutParams();
        ArrayList r5 = null;
        if ((r3 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L14;
        StaggeredGridLayoutManager.LayoutParams r4 = r3;
    L16:
        if (r4 == null) goto L18;
        int r14 = r4.getSpanIndex();
    L19:
        int r6 = r12 / this.a.Y90();
        VideoParam.RecommendType r7 = VideoParam.RecommendType.Search;
        int r8 = com.larus.bmhome.double_post.utils.h.a;
        String r9 = AwemeDoublePostFragment.U90(this.a);
        Message r10 = this.a.t;
        if (r10 != null) goto L22;
    L24:
        boolean r11 = false;
    L25:
        if (r11 == false) goto L27;
        r7 = VideoParam.RecommendType.AwemeFeed;
    L27:
        VideoParam.RecommendType r19 = r7;
        Message r13 = this.a.t;
        if (r13 == null) goto L30;
        String r18 = r13.getReplyId();
    L31:
        Message r15 = this.a.t;
        if (r15 == null) goto L34;
        String r17 = r15.getMessageId();
    L35:
        AwemeDoublePostFragment r16 = this.a;
        String r20 = r16.u;
        List r21 = r16.Z90().getReplyItemIdList();
        if (r21 == null) goto L38;
        r5 = (ArrayList) CollectionsKt.toCollection(r21, new ArrayList());
    L38:
        com.larus.bmhome.double_post.utils.h.b(r1, r25, r26, r12, r9, new com.larus.bmhome.double_post.utils.h.a(r17, r18, r19, "mixed", r20, r5, 8), Integer.valueOf(r6), Integer.valueOf(r14), AwemeDoublePostFragment.U90(this.a), 64);
        this.a.getClass();
        int r2 = qr8.a.a;
        Integer r22 = r26.getItemType();
        String r23 = r26.getItemId();
        String r24 = r26.getRequestId();
        Message r27 = this.a.t;
        Integer r110 = r26.getImprIndex();
        Message r28 = this.a.t;
        if (r28 != null) goto L41;
    L43:
        boolean r111 = false;
    L44:
        String r112 = this.a.u;
        if (r27 == null) goto L51;
        com.larus.platform.service.o.a.reportEvent("click_card", qr8.a.a(r22, r23, r24, r12, r14, r27, r110, r111, true, r112));
        return;
    L51:
        return;
    L41:
        if (com.larus.bmhome.chat.bean.d.W(r28) != true) goto L43;
        r111 = true;
        goto L44
    L34:
        r17 = null;
        goto L35
    L30:
        r18 = null;
        goto L31
    L22:
        if (com.larus.bmhome.chat.bean.d.W(r10) != true) goto L24;
        r11 = true;
        goto L25
    L18:
        r14 = 0;
        goto L19
    L14:
        r4 = null;
        goto L16
    L53:
        return;
    }

    @Override // ip8.e
    public final void b(View r8, final Content r9, float r10, float r11) {
        Intrinsics.checkNotNullParameter(r8, "view");
        u r0 = this.a.w;
        if (r0 == null) goto L5;
        r0.x();
    L5:
        int r1 = com.larus.bmhome.double_post.utils.h.a;
        AwemeDoublePostFragment r2 = this.a;
        Message r3 = r2.t;
        if (r3 == null) goto L8;
        com.larus.bmhome.chat.bean.d.W(r3);
    L8:
        final AwemeDoublePostFragment r4 = this.a;
        final RecyclerView r5 = this.b;
        com.larus.bmhome.double_post.utils.h.c(r2, r8, r9, r10, r11, new p(r4, r5, r9));
        this.a.getClass();
        com.larus.platform.service.o r12 = com.larus.platform.service.o.a;
        JSONObject r13 = new JSONObject();
        AwemeDoublePostFragment r14 = this.a;
        String r6 = null;
        if (r9 == null) goto L11;
        String r7 = r9.getItemId();
    L12:
        r13.put("video_id", r7);
        if (r9 == null) goto L15;
        String r15 = r9.getRequestId();
    L16:
        r13.put("req_id", r15);
        Message r16 = r14.t;
        if (r16 == null) goto L19;
        r6 = r16.getReplyId();
    L19:
        r13.put("reply_id", r6);
        r13.put("search_id", r14.u);
        Unit r17 = Unit.INSTANCE;
        r12.reportEvent("video_card_feedback_show", r13);
        return;
    L15:
        r15 = null;
        goto L16
    L11:
        r7 = null;
        goto L12
    }
}
