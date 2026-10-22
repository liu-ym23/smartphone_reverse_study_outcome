package l92;

import android.content.Context;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.pin.container.PinType;
import com.bytedance.android.livesdk.interactivity.api.settings.config.z;
import com.bytedance.android.livesdk.interactivity.pin.business.im.PinImHighlightPageItemView;
import com.bytedance.android.livesdk.interactivity.pin.business.im.api.ImHighlightRequest;
import com.bytedance.android.livesdk.interactivity.pin.business.im.api.ImHighlightResponseData;
import com.bytedance.android.livesdk.interactivity.pin.business.im.api.PinImApi;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import g42.k;
import g42.l;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j extends g42.a {

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
            ImHighlightResponseData r0 = (ImHighlightResponseData) ((BaseResponse) r6).data;
            String r1 = null;
            if (r0 == null) goto L5;
            HighlightItem r2 = r0.item;
        L6:
            if (r2 == null) goto L8;
            HighlightItem.d r3 = r2.getImData();
        L9:
            String r4 = ((BaseResponse) r6).logId;
            if (r3 != null) goto L17;
            int r7 = g42.j.f;
            RequestError r8 = ((BaseResponse) r6).error;
            if (r8 == null) goto L15;
            r1 = r8.prompts;
        L15:
            g42.j r9 = new g42.j(false, r2, r4);
            r9.b = r1;
            return r9;
        L17:
            return new g42.j(true, r2, r4);
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
            ImHighlightResponseData r0 = (ImHighlightResponseData) ((BaseResponse) r5).data;
            String r1 = null;
            if (r0 == null) goto L5;
            HighlightItem r2 = r0.item;
        L6:
            if (r2 == null) goto L8;
            HighlightItem.d r3 = r2.getImData();
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

    public static final class c implements g42.d {
        public final /* synthetic */ j a;

        public c(j r1) {
            this.a = r1;
        }

        @Override // g42.d
        public final void a(HighlightItem r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r3, "map");
            g42.d.a.d(this, r2, r3);
        }

        @Override // g42.d
        public final void b(HighlightItem r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r3, "map");
            g42.d.a.g(this, r2, r3);
            j.u(this.a, r2, r3);
        }

        @Override // g42.d
        public final void c(HighlightItem r3, Map<String, String> r4) {
            Intrinsics.checkNotNullParameter(r3, "item");
            Intrinsics.checkNotNullParameter(r4, "map");
            Intrinsics.checkNotNullParameter(r3, "item");
            Intrinsics.checkNotNullParameter(r4, "map");
        }

        @Override // g42.d
        public final void d(g42.h<?> r3, Map<String, String> r4) {
            Intrinsics.checkNotNullParameter(r3, "event");
            Intrinsics.checkNotNullParameter(r4, "map");
            g42.d.a.a(r3, r4);
            this.a.getClass();
            Object r5 = r3.b;
            if ((r5 instanceof h42.a) == true) goto L5;
            r5 = null;
        L5:
            h42.a r6 = (h42.a) r5;
            if (r6 == null) goto L11;
            r4.put("message_type", String.valueOf(r6.d));
            r4.put("is_uplevel", "1");
            Map<String, String> r7 = r6.e;
            if (r7 == null) goto L12;
            r4.putAll(r7);
            return;
        L12:
            return;
        }

        @Override // g42.d
        public final void e(HighlightItem r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r3, "map");
            g42.d.a.b(this, r2, r3);
            j.u(this.a, r2, r3);
        }

        @Override // g42.d
        public final void f(HighlightItem r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r3, "map");
            g42.d.a.c(this, r2, r3);
            j.u(this.a, r2, r3);
        }

        @Override // g42.d
        public final void g(HighlightItem r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r3, "map");
            g42.d.a.e(this, r2, r3);
            j.u(this.a, r2, r3);
        }

        @Override // g42.d
        public final void h(HighlightItem r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r3, "map");
            g42.d.a.f(this, r2, r3);
            j.u(this.a, r2, r3);
        }
    }

    @Override // g42.f
    public final Integer k() {
        return 5;
    }

    @Override // g42.a, g42.f
    public final void p(HighlightItem r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
    }

    public j() {
        super("PinImProcessor", PinType.Im);
    }

    @Override // g42.f
    public final boolean b(HighlightItem r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        z.a.getClass();
        if (z.a.b().c() == false) goto L7;
        return false;
    L7:
        return s(r2);
    }

    @Override // g42.f
    public final String c(HighlightItem r3) {
        Intrinsics.checkNotNullParameter(r3, "item");
        HighlightItem.d r4 = r3.getImData();
        if (r4 == null) goto L6;
        String r5 = String.valueOf(r4.getMessageId());
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
        r3.n(this.c, new c(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // g42.f
    public final Observable<g42.j> j(g42.h<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "pinEvent");
        RoomContext r0 = r();
        if (r0 != null) goto L5;
        return null;
    L5:
        T r6 = r5.b;
        if ((r6 instanceof h42.a) == false) goto L9;
        ImHighlightRequest r1 = new ImHighlightRequest();
        h42.a r7 = (h42.a) r6;
        r1.scene = r7.a;
        r1.actionType = 1;
        r1.roomId = ((Room) r0.getRoom().getValue()).getRoomId();
        r1.msgId = r7.b;
        r1.commenterId = r7.c;
        PinImApi.a.getClass();
        return ((PinImApi) com.bytedance.android.live.network.c.b().e(PinImApi.class)).pin(r1.toRequestFieldMap()).map(a.a);
    L9:
        return null;
    }

    @Override // g42.a, g42.f
    public final String l(com.bytedance.android.livesdk.interactivity.api.message.model.a r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        return String.valueOf(r3.getMessageId());
    }

    @Override // g42.f
    public final Observable<k> n(l<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "unpinEvent");
        RoomContext r0 = r();
        if (r0 != null) goto L5;
        return null;
    L5:
        T r6 = r5.b;
        if ((r6 instanceof HighlightItem.d) == false) goto L9;
        ImHighlightRequest r1 = new ImHighlightRequest();
        HighlightItem.d r7 = (HighlightItem.d) r6;
        r1.scene = r7.getScene();
        r1.actionType = 2;
        r1.roomId = ((Room) r0.getRoom().getValue()).getRoomId();
        r1.msgId = r7.getMessageId();
        r1.commenterId = 0;
        r1.pinId = r7.getPinId();
        PinImApi.a.getClass();
        return ((PinImApi) com.bytedance.android.live.network.c.b().e(PinImApi.class)).pin(r1.toRequestFieldMap()).map(b.a);
    L9:
        return null;
    }

    @Override // g42.f
    public final g42.e o(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        return new PinImHighlightPageItemView(r5, null, 6, 0);
    }

    @Override // g42.f
    public final com.bytedance.android.livesdk.wrds.syncdata.highlight.b q(HighlightItem r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        return r2.getImData();
    }

    public static final void u(j r3, HighlightItem r4, Map r5) {
        r3.getClass();
        r5.put("message_type", "2");
        r5.put("is_uplevel", "1");
        Map r6 = r4.getBuriedPoint();
        if (r6 == null) goto L22;
        LinkedHashMap r7 = new LinkedHashMap();
        Iterator r0 = r6.entrySet().iterator();
    L6:
        if (r0.hasNext() == false) goto L15;
        Map.Entry r1 = (Map.Entry) r0.next();
        if (r1.getKey() != null) goto L10;
    L12:
        boolean r2 = false;
    L13:
        if (r2 == false) goto L6;
        r7.put(r1.getKey(), r1.getValue());
        goto L6
    L10:
        if (r1.getValue() == null) goto L12;
        r2 = true;
        goto L13
    L15:
        r5.putAll(r6);
        return;
    }
}
