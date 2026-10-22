package com.bytedance.android.livesdk.interactivity.pin.business.qa;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.ICommentService;
import com.bytedance.android.livesdk.interactivity.api.pin.container.PinType;
import com.bytedance.android.livesdk.interactivity.api.settings.config.z;
import com.bytedance.android.livesdk.interactivity.pin.business.qa.api.AnswerHighlightRequest;
import com.bytedance.android.livesdk.interactivity.pin.business.qa.api.AnswerHighlightResponseData;
import com.bytedance.android.livesdk.interactivity.pin.business.qa.api.PinAnswerApi;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import g42.j;
import g42.k;
import g42.l;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class PinAnswerProcessor extends g42.a {

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
            HighlightItem r0 = ((AnswerHighlightResponseData) ((BaseResponse) r6).data).item;
            String r1 = null;
            if (r0 == null) goto L5;
            HighlightItem.a r2 = r0.getAnswerData();
        L6:
            String r3 = ((BaseResponse) r6).logId;
            if (r2 != null) goto L14;
            int r4 = j.f;
            RequestError r7 = ((BaseResponse) r6).error;
            if (r7 == null) goto L12;
            r1 = r7.prompts;
        L12:
            j r8 = new j(false, r0, r3);
            r8.b = r1;
            return r8;
        L14:
            return new j(true, r0, r3);
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
            HighlightItem r0 = ((AnswerHighlightResponseData) ((BaseResponse) r5).data).item;
            String r1 = null;
            if (r0 == null) goto L5;
            HighlightItem.a r2 = r0.getAnswerData();
        L6:
            String r3 = ((BaseResponse) r5).logId;
            if (r2 == null) goto L9;
            int r6 = k.d;
            return k.a.a(r3);
        L9:
            int r7 = k.d;
            RequestError r8 = ((BaseResponse) r5).error;
            if (r8 == null) goto L12;
            r1 = r8.prompts;
        L12:
            k r9 = new k(false, r3);
            r9.a = r1;
            return r9;
        L5:
            r2 = null;
            goto L6
        }
    }

    public static final class c implements g42.d {
        public final /* synthetic */ PinAnswerProcessor a;
        public final /* synthetic */ g42.c b;

        public c(PinAnswerProcessor r1, g42.c r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // g42.d
        public final void a(HighlightItem r5, Map<String, String> r6) {
            Intrinsics.checkNotNullParameter(r5, "item");
            Intrinsics.checkNotNullParameter(r6, "map");
            g42.d.a.d(this, r5, r6);
            Map<String, HighlightItem> r7 = this.b.o();
            int r1 = 0;
            if (r7.isEmpty() == true) goto L15;
            Iterator<Map.Entry<String, HighlightItem>> r8 = r7.entrySet().iterator();
            int r0 = 0;
        L7:
            if (r8.hasNext() == false) goto L14;
            if (r8.next().getValue().getDataType() != this.a.c.getDataType()) goto L11;
            boolean r2 = true;
        L12:
            if (r2 == false) goto L7;
            r0 = r0 + 1;
            goto L7
        L11:
            r2 = false;
            goto L12
        L14:
            r1 = r0;
        L15:
            r6.put("reply_num", String.valueOf(r1));
        }

        @Override // g42.d
        public final void b(HighlightItem r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r3, "map");
            g42.d.a.g(this, r2, r3);
        }

        @Override // g42.d
        public final void c(HighlightItem r3, Map<String, String> r4) {
            Intrinsics.checkNotNullParameter(r3, "item");
            Intrinsics.checkNotNullParameter(r4, "map");
            Intrinsics.checkNotNullParameter(r3, "item");
            Intrinsics.checkNotNullParameter(r4, "map");
        }

        @Override // g42.d
        public final void d(g42.h<?> r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r2, "event");
            Intrinsics.checkNotNullParameter(r3, "map");
            g42.d.a.a(r2, r3);
        }

        @Override // g42.d
        public final void e(HighlightItem r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r3, "map");
            g42.d.a.b(this, r2, r3);
        }

        @Override // g42.d
        public final void f(HighlightItem r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r3, "map");
            g42.d.a.c(this, r2, r3);
        }

        @Override // g42.d
        public final void g(HighlightItem r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r3, "map");
            g42.d.a.e(this, r2, r3);
        }

        @Override // g42.d
        public final void h(HighlightItem r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r3, "map");
            g42.d.a.f(this, r2, r3);
        }
    }

    @Override // g42.f
    public final Integer k() {
        return 1;
    }

    public PinAnswerProcessor() {
        super("PinAnswerProcessor", PinType.Answer);
    }

    @Override // g42.f
    public final boolean b(HighlightItem r9) {
        Intrinsics.checkNotNullParameter(r9, "item");
        z.a.getClass();
        if (z.a.b().b() == false) goto L6;
        return false;
    L6:
        if (s(r9) == false) goto L55;
        int r0 = com.bytedance.android.livesdk.interactivity.common.utils.g.a;
        RoomContext.a r1 = RoomContext.Companion;
        Long r2 = null;
        RoomContext r6 = RoomContext.a.c(r1, null, 0, 3);
        if (r6 != null) goto L11;
    L23:
        boolean r3 = false;
    L25:
        if (r3 == false) goto L56;
        g42.c r4 = this.b;
        if (r4 == null) goto L29;
        DataCenter r5 = r4.getDataCenter();
    L31:
        if (com.bytedance.android.livesdk.interactivity.common.utils.h.b(com.bytedance.android.live.core.utils.z.e(r5, false)) == false) goto L53;
        g42.c r7 = this.b;
        if (r7 == null) goto L51;
        Map<String, HighlightItem> r8 = r7.o();
        if (r8 == null) goto L51;
        HighlightItem r10 = r8.get(c(r9));
        if (r10 == null) goto L51;
        HighlightItem.a r11 = r10.getAnswerData();
        if (r11 == null) goto L51;
        if (r11.b != true) goto L51;
        HighlightItem.a r13 = r9.getAnswerData();
        if (r13 == null) goto L46;
        Long r14 = Long.valueOf(r13.c());
    L47:
        HighlightItem.a r15 = r10.getAnswerData();
        if (r15 == null) goto L50;
        r2 = Long.valueOf(r15.c());
    L50:
        boolean r16 = Intrinsics.areEqual(r14, r2);
    L52:
        if (r16 == true) goto L53;
        return false;
    L46:
        r14 = null;
    L51:
        r16 = true;
    L53:
        return true;
    L29:
        r5 = null;
        goto L31
    L56:
        return false;
    L11:
        if (((Boolean) r6.isAnchor().getValue()).booleanValue() == true) goto L24;
        RoomContext r17 = RoomContext.a.c(r1, null, 0, 3);
        if (r17 == null) goto L19;
        m r18 = r17.getRoom();
        if (r18 == null) goto L19;
        Room r19 = (Room) r18.getValue();
        if (r19 == null) goto L19;
        String r20 = r19.getAnchorAbValue("live_answer_on_wall");
    L21:
        if (TextUtils.equals("1", r20) == false) goto L23;
    L19:
        r20 = null;
    L24:
        r3 = true;
        goto L25
    L55:
        return false;
    }

    @Override // g42.f
    public final String c(HighlightItem r3) {
        Intrinsics.checkNotNullParameter(r3, "item");
        HighlightItem.a r4 = r3.getAnswerData();
        if (r4 == null) goto L6;
        String r5 = String.valueOf(r4.b());
        if (r5 == null) goto L6;
        return r5;
    L6:
        return "0";
    }

    @Override // g42.a, g42.f
    public final void e(g42.c r3) {
        Intrinsics.checkNotNullParameter(r3, "pinContainer");
        Intrinsics.checkNotNullParameter(r3, "pinContainer");
        this.b = r3;
        t(j42.b.class, new PinAnswerProcessor$onCreate$1(this));
        t(j42.a.class, new PinAnswerProcessor$onCreate$2(this));
        r3.n(PinType.All, new c(this, r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // g42.f
    public final Observable<j> j(g42.h<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "pinEvent");
        RoomContext r0 = r();
        if (r0 != null) goto L6;
        return null;
    L6:
        if ((r5 instanceof j42.d) == false) goto L12;
        j42.c r6 = (j42.c) ((j42.d) r5).b;
        AnswerHighlightRequest r1 = new AnswerHighlightRequest();
        r1.scene = "answer_highlight";
        r1.actionType = 1;
        r1.roomId = ((Room) r0.getRoom().getValue()).getRoomId();
        r1.question = r6.b;
        r1.answer = r6.f;
        r1.nickName = r6.d;
        r1.setCommenterId(r6.c);
        r1.questionMsgId = r6.a;
        r1.answerMsgId = r6.e;
        Long r7 = r6.g;
        if (r7 == null) goto L10;
        r1.answerId = r7.longValue();
    L10:
        PinAnswerApi.a.getClass();
        return ((PinAnswerApi) com.bytedance.android.live.network.c.b().e(PinAnswerApi.class)).pin(r1.toRequestFieldMap()).map(a.a);
    L12:
        return null;
    }

    @Override // g42.a, g42.f
    public final String l(com.bytedance.android.livesdk.interactivity.api.message.model.a r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        return String.valueOf(r3.G());
    }

    @Override // g42.f
    public final Observable<k> n(l<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "unpinEvent");
        RoomContext r0 = r();
        if (r0 != null) goto L6;
        return null;
    L6:
        if ((r5 instanceof j42.e) == false) goto L20;
        HighlightItem.a r6 = (HighlightItem.a) ((j42.e) r5).b;
        AnswerHighlightRequest r1 = new AnswerHighlightRequest();
        r1.scene = "answer_highlight";
        r1.actionType = 2;
        r1.roomId = ((Room) r0.getRoom().getValue()).getRoomId();
        String r2 = r6.i();
        String r3 = BuildConfig.FLAVOR;
        if (r2 != null) goto L10;
        r2 = BuildConfig.FLAVOR;
    L10:
        r1.question = r2;
        r1.answer = r6.a();
        String r4 = r6.h();
        if (r4 == null) goto L14;
        r3 = r4;
    L14:
        r1.nickName = r3;
        Long r7 = r6.f();
        if (r7 == null) goto L17;
        long r8 = r7.longValue();
    L18:
        r1.setCommenterId(String.valueOf(r8));
        r1.answerId = r6.b();
        r1.questionMsgId = r6.j();
        r1.answerMsgId = r6.c();
        PinAnswerApi.a.getClass();
        return ((PinAnswerApi) com.bytedance.android.live.network.c.b().e(PinAnswerApi.class)).pin(r1.toRequestFieldMap()).map(b.a);
    L17:
        r8 = 0;
        goto L18
    L20:
        return null;
    }

    @Override // g42.f
    public final g42.e o(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        return new PinAnswerHighlightPageItemView(r5, null, 6, 0);
    }

    @Override // g42.f
    public final com.bytedance.android.livesdk.wrds.syncdata.highlight.b q(HighlightItem r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        return r2.getAnswerData();
    }

    public static final void u(PinAnswerProcessor r11, String r13, j42.b r14, Long r15) {
        g42.c r0 = r11.b;
        if (r0 == null) goto L5;
        DataCenter r1 = r0.getDataCenter();
    L6:
        if (r1 == null) goto L19;
        IRoom r2 = com.bytedance.android.live.core.utils.z.o(r1);
        if (r2 == null) goto L20;
        long r4 = System.currentTimeMillis();
        if (r15 == null) goto L13;
        boolean r3 = true;
    L14:
        if (r3 == false) goto L16;
        String r5 = "edit answer";
    L17:
        String r9 = r5;
        RxUtilKt.c(((ICommentService) jc1.k.n(ICommentService.class)).sendCommentChat(r2, r13).subscribeOn(Schedulers.io()).subscribe(new h(r11, r9, r4, r14, r13, r15), new i(r11, r9)), r11.a);
        return;
    L16:
        r5 = "pin answer";
        goto L17
    L13:
        r3 = false;
        goto L14
    L20:
        return;
    L19:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
