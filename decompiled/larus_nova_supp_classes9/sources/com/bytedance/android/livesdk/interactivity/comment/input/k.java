package com.bytedance.android.livesdk.interactivity.comment.input;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.message.t5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.log.j0;
import gd0.r;
import io.reactivex.functions.Consumer;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ VideoCommentPreviewFragment a;
    public final /* synthetic */ long b;

    public k(VideoCommentPreviewFragment r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r8) {
        Response r9 = (Response) r8;
        t5 r0 = vh7.f.c(t5.class);
        long r1 = 0;
        if (r9 == null) goto L9;
        com.bytedance.android.livesdk.interactivity.api.comment.data.g r3 = (com.bytedance.android.livesdk.interactivity.api.comment.data.g) ((BaseResponse) r9).data;
        if (r3 == null) goto L9;
        Long r4 = r3.b();
        if (r4 == null) goto L9;
        long r5 = r4.longValue();
    L10:
        r0.setItemId(r5);
        if (r9 == null) goto L17;
        com.bytedance.android.livesdk.interactivity.api.comment.data.g r6 = (com.bytedance.android.livesdk.interactivity.api.comment.data.g) ((BaseResponse) r9).data;
        if (r6 == null) goto L17;
        Long r7 = r6.c();
        if (r7 == null) goto L17;
        long r10 = r7.longValue();
    L18:
        r0.setItemType(r10);
        String r11 = null;
        if (r9 == null) goto L23;
        com.bytedance.android.livesdk.interactivity.api.comment.data.g r13 = (com.bytedance.android.livesdk.interactivity.api.comment.data.g) ((BaseResponse) r9).data;
        if (r13 == null) goto L23;
        String r14 = r13.e();
    L24:
        r0.setTitle(r14);
        if (r9 == null) goto L29;
        com.bytedance.android.livesdk.interactivity.api.comment.data.g r15 = (com.bytedance.android.livesdk.interactivity.api.comment.data.g) ((BaseResponse) r9).data;
        if (r15 == null) goto L29;
        IBaseUser r16 = r15.f();
    L30:
        r0.setBaseUser(r16);
        if (r9 == null) goto L37;
        com.bytedance.android.livesdk.interactivity.api.comment.data.g r17 = (com.bytedance.android.livesdk.interactivity.api.comment.data.g) ((BaseResponse) r9).data;
        if (r17 == null) goto L37;
        Long r18 = r17.b();
        if (r18 == null) goto L37;
        String r19 = String.valueOf(r18.longValue());
    L38:
        r0.setItemIdStr(r19);
        if (r9 == null) goto L45;
        com.bytedance.android.livesdk.interactivity.api.comment.data.g r20 = (com.bytedance.android.livesdk.interactivity.api.comment.data.g) ((BaseResponse) r9).data;
        if (r20 == null) goto L45;
        Long r21 = r20.c();
        if (r21 == null) goto L45;
        r11 = String.valueOf(r21.longValue());
    L45:
        r0.setItemTypeStr(r11);
        r0.setMessageMethod("WebcastVideoShareMessage");
        if (r9 == null) goto L52;
        com.bytedance.android.livesdk.interactivity.api.comment.data.g r23 = (com.bytedance.android.livesdk.interactivity.api.comment.data.g) ((BaseResponse) r9).data;
        if (r23 == null) goto L52;
        Long r24 = r23.d();
        if (r24 == null) goto L52;
        r1 = r24.longValue();
    L52:
        m0 r25 = vh7.f.c(m0.class);
        r25.setRoomId(this.b);
        r25.setMessageId(r1);
        if (r9 == null) goto L59;
        com.bytedance.android.livesdk.interactivity.api.comment.data.g r26 = (com.bytedance.android.livesdk.interactivity.api.comment.data.g) ((BaseResponse) r9).data;
        if (r26 == null) goto L59;
        a5 r27 = r26.a();
        if (r27 == null) goto L59;
        r25.setDisplayText(r27);
    L59:
        r25.setShowMsg(true);
        r25.setMethod("WebcastVideoShareMessage");
        r0.setBaseMessage(r25);
        r0.setPin(this.a.s);
        r r28 = this.a.g;
        if (r28 == null) goto L62;
        r28.e(r0);
    L62:
        VideoCommentPreviewFragment r29 = this.a;
        Map<String, String> r2 = r29.V90();
        if (r29.s == false) goto L65;
        String r30 = "on";
    L66:
        r2.put("pin_status", r30);
        j0.l().sendLog("livesdk_video_comment_send_success", r2, new Object[0]);
        return;
    L65:
        r30 = "off";
    L37:
        r19 = null;
    L29:
        r16 = null;
    L23:
        r14 = null;
    L17:
        r10 = 0;
    L9:
        r5 = 0;
        goto L10
    }
}
