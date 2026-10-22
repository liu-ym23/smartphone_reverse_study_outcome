package m92;

import android.content.Context;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.openplatform.api.utils.SchemaInfo;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.pin.container.PinType;
import com.bytedance.android.livesdk.interactivity.api.settings.config.z;
import com.bytedance.android.livesdk.interactivity.pin.business.microapp.PinMicroAppHighlightPageItemView;
import com.bytedance.android.livesdk.interactivity.pin.business.microapp.api.MicroAppHighlightRequest;
import com.bytedance.android.livesdk.interactivity.pin.business.microapp.api.MicroAppHighlightResponseData;
import com.bytedance.android.livesdk.interactivity.pin.business.microapp.api.PinMicroAppApi;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.BuildConfig;
import g42.h;
import g42.j;
import g42.k;
import g42.l;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g extends g42.a {

    public static final class a<T, R> implements Function {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object apply(Object r10) {
            Response r11 = (Response) r10;
            Intrinsics.checkNotNullParameter(r11, "response");
            MicroAppHighlightResponseData r0 = (MicroAppHighlightResponseData) ((BaseResponse) r11).data;
            String r1 = null;
            if (r0 == null) goto L5;
            HighlightItem r2 = r0.item;
        L6:
            if (r2 == null) goto L8;
            HighlightItem.e r3 = r2.getMicroAppData();
        L9:
            String r4 = ((BaseResponse) r11).logId;
            boolean r5 = false;
            if (r3 == null) goto L17;
            j r6 = new j(true, r2, r4);
            MicroAppHighlightResponseData r13 = (MicroAppHighlightResponseData) ((BaseResponse) r11).data;
            if (r13 != null) goto L14;
        L15:
            r5 = true;
        L16:
            r6.a = r5;
            return r6;
        L14:
            if (r13.skipReview == 1) goto L16;
        L17:
            int r7 = j.f;
            RequestError r14 = ((BaseResponse) r11).error;
            if (r14 == null) goto L20;
            r1 = r14.prompts;
        L20:
            j r15 = new j(false, r2, r4);
            r15.b = r1;
            return r15;
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
            MicroAppHighlightResponseData r0 = (MicroAppHighlightResponseData) ((BaseResponse) r5).data;
            String r1 = null;
            if (r0 == null) goto L5;
            HighlightItem r2 = r0.item;
        L6:
            if (r2 == null) goto L8;
            HighlightItem.e r3 = r2.getMicroAppData();
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
        public c() {
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
        }

        @Override // g42.d
        public final void c(HighlightItem r3, Map<String, String> r4) {
            Intrinsics.checkNotNullParameter(r3, "item");
            Intrinsics.checkNotNullParameter(r4, "map");
            HighlightItem.e r0 = r3.getMicroAppData();
            String r1 = null;
            if (r0 == null) goto L5;
            String r2 = r0.c();
        L6:
            HighlightItem.e r5 = r3.getMicroAppData();
            if (r5 == null) goto L9;
            r1 = r5.f();
        L9:
            i(r4, r2, r1);
            return;
        L5:
            r2 = null;
            goto L6
        }

        @Override // g42.d
        public final void d(h<?> r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r2, "event");
            Intrinsics.checkNotNullParameter(r3, "map");
            g42.d.a.a(r2, r3);
            Object r4 = r2.b;
            if ((r4 instanceof i42.a) == true) goto L5;
            r4 = null;
        L5:
            i42.a r5 = (i42.a) r4;
            if (r5 == null) goto L9;
            i(r3, r5.c, r5.d);
            return;
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

        public static void i(Map r2, String r3, String r4) {
            if (r3 != null) goto L4;
            return;
        L4:
            if (r4 != null) goto L6;
            return;
        L6:
            r2.put("pin_type", "microapp");
            r2.put("mp_id", r3);
            Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L21
            SchemaInfo.s.getClass();     // Catch: Throwable -> L21
            SchemaInfo r6 = SchemaInfo.b.b(r4);     // Catch: Throwable -> L21
            String r0 = BuildConfig.FLAVOR;
            if (r6 == null) goto L12;
            String r1 = r6.f();     // Catch: Throwable -> L21
            if (r1 == null) goto L12;
        L13:
            r2.put("path", r1);     // Catch: Throwable -> L21
            if (r6 == null) goto L19;
            String r7 = r6.g();     // Catch: Throwable -> L21
            if (r7 == null) goto L19;
            r0 = r7;
        L19:
            r2.put("query", r0);     // Catch: Throwable -> L21
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L21
            return;
        L12:
            r1 = BuildConfig.FLAVOR;
        L21:
            th = move-exception;
            Result.Companion r8 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    @Override // g42.f
    public final Integer k() {
        return 4;
    }

    @Override // g42.a, g42.f
    public final void p(HighlightItem r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
    }

    public g() {
        super("PinMicroAPPProcessor", PinType.MicroApp);
    }

    @Override // g42.f
    public final boolean b(HighlightItem r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        z.a.getClass();
        if (z.a.b().d() == false) goto L7;
        return false;
    L7:
        return s(r2);
    }

    @Override // g42.f
    public final String c(HighlightItem r3) {
        Intrinsics.checkNotNullParameter(r3, "item");
        HighlightItem.e r4 = r3.getMicroAppData();
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
        r3.n(PinType.MicroApp, new c());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // g42.f
    public final Observable<j> j(h<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "pinEvent");
        RoomContext r0 = r();
        if (r0 != null) goto L5;
        return null;
    L5:
        T r6 = r5.b;
        if ((r6 instanceof i42.a) == false) goto L9;
        MicroAppHighlightRequest r1 = new MicroAppHighlightRequest();
        r1.actionType = 1;
        r1.roomId = ((Room) r0.getRoom().getValue()).getRoomId();
        i42.a r7 = (i42.a) r6;
        r1.msgId = r7.a;
        r1.setCommenterId(r7.b);
        PinMicroAppApi.a.getClass();
        return ((PinMicroAppApi) com.bytedance.android.live.network.c.b().e(PinMicroAppApi.class)).pin(r1.toRequestFieldMap()).map(a.a);
    L9:
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
        if (r0 != null) goto L5;
        return null;
    L5:
        T r6 = r5.b;
        if ((r6 instanceof HighlightItem.e) == false) goto L9;
        MicroAppHighlightRequest r1 = new MicroAppHighlightRequest();
        r1.actionType = 2;
        r1.roomId = ((Room) r0.getRoom().getValue()).getRoomId();
        HighlightItem.e r7 = (HighlightItem.e) r6;
        r1.msgId = r7.getMessageId();
        r1.setCommenterId("0");
        r1.pinId = r7.getPinId();
        PinMicroAppApi.a.getClass();
        return ((PinMicroAppApi) com.bytedance.android.live.network.c.b().e(PinMicroAppApi.class)).pin(r1.toRequestFieldMap()).map(b.a);
    L9:
        return null;
    }

    @Override // g42.f
    public final g42.e o(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        return new PinMicroAppHighlightPageItemView(r5, null, 6, 0);
    }

    @Override // g42.f
    public final com.bytedance.android.livesdk.wrds.syncdata.highlight.b q(HighlightItem r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        return r2.getMicroAppData();
    }

    @Override // g42.a, g42.f
    public final boolean i(h<?> r3, HighlightItem r4) {
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "item");
        Object r5 = r3.b;
        String r1 = null;
        if ((r5 instanceof i42.a) == true) goto L5;
        r5 = null;
    L5:
        i42.a r6 = (i42.a) r5;
        if (r6 == null) goto L8;
        String r7 = r6.c;
    L9:
        HighlightItem.e r8 = r4.getMicroAppData();
        if (r8 == null) goto L13;
        r1 = r8.c();
    L13:
        return Intrinsics.areEqual(r7, r1);
    L8:
        r7 = null;
        goto L9
    }
}
