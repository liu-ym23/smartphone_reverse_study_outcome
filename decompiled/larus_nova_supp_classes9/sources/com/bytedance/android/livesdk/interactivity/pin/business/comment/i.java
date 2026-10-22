package com.bytedance.android.livesdk.interactivity.pin.business.comment;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.pin.container.PinType;
import com.bytedance.android.livesdk.interactivity.pin.business.comment.api.ChatHighlightRequest;
import com.bytedance.android.livesdk.interactivity.pin.business.comment.api.ChatHighlightResponseData;
import com.bytedance.android.livesdk.interactivity.pin.business.comment.api.PinCommentApi;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import com.bytedance.android.livesdkapi.depend.model.live.CommentPinContent;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.BuildConfig;
import g42.j;
import g42.k;
import g42.l;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i extends g42.a {

    public static final class a<T, R> implements Function {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object apply(Object r5) {
            Response r6 = (Response) r5;
            Intrinsics.checkNotNullParameter(r6, "response");
            ChatHighlightResponseData r0 = (ChatHighlightResponseData) ((BaseResponse) r6).data;
            String r1 = null;
            if (r0 == null) goto L5;
            HighlightItem r2 = r0.item;
        L6:
            if (r2 == null) goto L8;
            HighlightItem.c r3 = r2.getCommentData();
        L9:
            String r4 = ((BaseResponse) r6).logId;
            if (r3 != null) goto L17;
            int r7 = j.f;
            RequestError r8 = ((BaseResponse) r6).error;
            if (r8 == null) goto L15;
            r1 = r8.prompts;
        L15:
            j r9 = new j(false, r2, r4);
            r9.b = r1;
            return r9;
        L17:
            return new j(true, r2, r4);
        L8:
            r3 = null;
            goto L9
        L5:
            r2 = null;
            goto L6
        }
    }

    public static final class b<T, R> implements Function {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object apply(Object r4) {
            Response r5 = (Response) r4;
            Intrinsics.checkNotNullParameter(r5, "response");
            ChatHighlightResponseData r0 = (ChatHighlightResponseData) ((BaseResponse) r5).data;
            String r1 = null;
            if (r0 == null) goto L5;
            HighlightItem r2 = r0.item;
        L6:
            if (r2 == null) goto L8;
            HighlightItem.c r3 = r2.getCommentData();
        L9:
            String r6 = ((BaseResponse) r5).logId;
            if (r3 == null) goto L12;
            int r7 = k.d;
            return k.a.a(r6);
        L12:
            int r8 = k.d;
            RequestError r9 = ((BaseResponse) r5).error;
            if (r9 == null) goto L15;
            r1 = r9.prompts;
        L15:
            k r10 = new k(false, r6);
            r10.a = r1;
            return r10;
        L8:
            r3 = null;
            goto L9
        L5:
            r2 = null;
            goto L6
        }
    }

    @Override // g42.f
    public final Integer k() {
        return 2;
    }

    public i() {
        super("PinCommentProcessor", PinType.Comment);
    }

    @Override // g42.f
    public final boolean b(HighlightItem r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        return s(r2);
    }

    @Override // g42.f
    public final String c(HighlightItem r3) {
        Intrinsics.checkNotNullParameter(r3, "item");
        HighlightItem.c r4 = r3.getCommentData();
        if (r4 == null) goto L6;
        String r5 = String.valueOf(r4.getMessageId());
        if (r5 == null) goto L6;
        return r5;
    L6:
        return "0";
    }

    @Override // g42.a, g42.f
    public final g42.e g(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        AttributeSet r3 = null;
        return new PinCommentPSHighlightView(r5, r3, 6, 0);
    }

    @Override // g42.f
    public final Observable<j> j(g42.h<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "pinEvent");
        RoomContext r0 = r();
        if (r0 != null) goto L6;
        return null;
    L6:
        if ((r5 instanceof e42.a) == false) goto L22;
        CommentPinContent r6 = (CommentPinContent) ((e42.a) r5).b;
        ChatHighlightRequest r1 = new ChatHighlightRequest();
        String r2 = r6.getScene();
        if (r2 != null) goto L10;
    L13:
        boolean r3 = true;
    L14:
        if (r3 == false) goto L16;
        String r4 = "comment_highlight";
    L17:
        r1.scene = r4;
        r1.actionType = 1;
        r1.preId = r6.getId();
        r1.roomId = ((Room) r0.getRoom().getValue()).getRoomId();
        String r7 = r6.getContent();
        if (r7 != null) goto L20;
        r7 = BuildConfig.FLAVOR;
    L20:
        r1.content = r7;
        r1.msgId = r6.getCommentMsgId();
        r1.setCommenterId(r6.getCommenterId());
        r1.commenterNickname = r6.getNickName();
        r1.chatId = r6.getId();
        r1.contentType = r6.getContentType();
        PinCommentApi.a.getClass();
        return ((PinCommentApi) com.bytedance.android.live.network.c.b().e(PinCommentApi.class)).pin(r1.toRequestFieldMap()).map(a.a);
    L16:
        r4 = r6.getScene();
        goto L17
    L10:
        if (r2.length() == 0) goto L13;
        r3 = false;
        goto L14
    L22:
        return null;
    }

    @Override // g42.a, g42.f
    public final String l(com.bytedance.android.livesdk.interactivity.api.message.model.a r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        return String.valueOf(r3.H());
    }

    @Override // g42.f
    public final Observable<k> n(l<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "unpinEvent");
        RoomContext r0 = r();
        if (r0 != null) goto L6;
        return null;
    L6:
        if ((r5 instanceof e42.b) == false) goto L15;
        HighlightItem.c r6 = (HighlightItem.c) ((e42.b) r5).b;
        ChatHighlightRequest r1 = new ChatHighlightRequest();
        String r2 = r6.getScene();
        if (r2 != null) goto L10;
        r2 = "comment_highlight";
    L10:
        r1.scene = r2;
        r1.actionType = 2;
        r1.roomId = ((Room) r0.getRoom().getValue()).getRoomId();
        String r3 = r6.d();
        if (r3 != null) goto L13;
        r3 = BuildConfig.FLAVOR;
    L13:
        r1.content = r3;
        r1.msgId = r6.getMessageId();
        r1.setCommenterId(r6.b());
        r1.commenterNickname = r6.e();
        r1.chatId = r6.a();
        r1.preId = r6.f();
        PinCommentApi.a.getClass();
        return ((PinCommentApi) com.bytedance.android.live.network.c.b().e(PinCommentApi.class)).pin(r1.toRequestFieldMap()).map(b.a);
    L15:
        return null;
    }

    @Override // g42.f
    public final g42.e o(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        return new PinCommentHighlightPageItemView(r5, null, 6, 0);
    }

    @Override // g42.f
    public final com.bytedance.android.livesdk.wrds.syncdata.highlight.b q(HighlightItem r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        return r2.getCommentData();
    }
}
