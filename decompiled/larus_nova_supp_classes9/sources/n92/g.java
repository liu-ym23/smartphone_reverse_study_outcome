package n92;

import android.content.Context;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.pin.container.PinType;
import com.bytedance.android.livesdk.interactivity.api.settings.config.z;
import com.bytedance.android.livesdk.interactivity.common.utils.LiveHighlightAppLogger;
import com.bytedance.android.livesdk.interactivity.pin.business.video.PinVideoHighlightPageItemView;
import com.bytedance.android.livesdk.interactivity.pin.business.video.api.PinVideoApi;
import com.bytedance.android.livesdk.interactivity.pin.business.video.api.VideoHighlightRequest;
import com.bytedance.android.livesdk.interactivity.pin.business.video.api.VideoHighlightResponseData;
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

        public final Object apply(Object r5) {
            Response r6 = (Response) r5;
            Intrinsics.checkNotNullParameter(r6, "response");
            VideoHighlightResponseData r0 = (VideoHighlightResponseData) ((BaseResponse) r6).data;
            String r1 = null;
            if (r0 == null) goto L5;
            HighlightItem r2 = r0.item;
        L6:
            if (r2 == null) goto L8;
            HighlightItem.f r3 = r2.getVideoData();
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
            VideoHighlightResponseData r0 = (VideoHighlightResponseData) ((BaseResponse) r5).data;
            String r1 = null;
            if (r0 == null) goto L5;
            HighlightItem r2 = r0.item;
        L6:
            if (r2 == null) goto L8;
            HighlightItem.f r3 = r2.getVideoData();
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
        public final void b(HighlightItem r3, Map<String, String> r4) {
            Intrinsics.checkNotNullParameter(r3, "item");
            Intrinsics.checkNotNullParameter(r4, "map");
            r4.put("video_id", String.valueOf(r3.getItemId()));
            IInteractService r0 = jc1.k.f(IInteractService.class);
            if (r0 == null) goto L7;
            String r1 = r0.getCurrentFunctionType();
            if (r1 == null) goto L7;
            r4.put("function_type", r1);
        L7:
            String r2 = jc1.k.n(IInteractService.class).getFunctionType2();
            if (r2 == null) goto L10;
            r4.put("function_type2", r2);
        L10:
            HighlightItem.f r5 = r3.getVideoData();
            if (r5 == null) goto L13;
            String r6 = r5.d();
        L14:
            r4.put("send_user_type", r6);
            return;
        L13:
            r6 = BuildConfig.FLAVOR;
            goto L14
        }

        @Override // g42.d
        public final void c(HighlightItem r3, Map<String, String> r4) {
            Intrinsics.checkNotNullParameter(r3, "item");
            Intrinsics.checkNotNullParameter(r4, "map");
            Intrinsics.checkNotNullParameter(r3, "item");
            Intrinsics.checkNotNullParameter(r4, "map");
        }

        @Override // g42.d
        public final void d(h<?> r2, Map<String, String> r3) {
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
        return 3;
    }

    public g() {
        super("PinVideoProcessor", PinType.Video);
    }

    @Override // g42.f
    public final boolean b(HighlightItem r5) {
        Intrinsics.checkNotNullParameter(r5, "item");
        z.a.getClass();
        if (z.a.b().f() == false) goto L5;
        return false;
    L5:
        kjc.c r0 = new kjc.c();
        if (1 != kjc.a.a()) goto L9;
        return true;
    L9:
        if (r0.b == true) goto L12;
        return false;
    L12:
        if (((Boolean) r0.a.a).booleanValue() == true) goto L14;
        return false;
    L14:
        if (s(r5) == false) goto L18;
        return true;
    L18:
        return false;
    }

    @Override // g42.f
    public final String c(HighlightItem r3) {
        Intrinsics.checkNotNullParameter(r3, "item");
        HighlightItem.f r4 = r3.getVideoData();
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
        r3.n(this.c, new c());
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
        if ((r6 instanceof k42.e) == false) goto L9;
        VideoHighlightRequest r1 = new VideoHighlightRequest();
        k42.e r7 = (k42.e) r6;
        r1.scene = r7.a;
        r1.actionType = 1;
        r1.roomId = ((Room) r0.getRoom().getValue()).getRoomId();
        r1.itemId = r7.b;
        r1.msgId = r7.c;
        r1.nickname = r7.d;
        r1.commenterId = r7.e;
        PinVideoApi.a.getClass();
        return ((PinVideoApi) com.bytedance.android.live.network.c.b().e(PinVideoApi.class)).pin(r1.toRequestFieldMap()).map(a.a);
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
        if ((r6 instanceof HighlightItem.f) == false) goto L12;
        VideoHighlightRequest r1 = new VideoHighlightRequest();
        HighlightItem.f r7 = (HighlightItem.f) r6;
        String r2 = r7.getScene();
        if (r2 != null) goto L10;
        r2 = "video_highlight";
    L10:
        r1.scene = r2;
        r1.actionType = 2;
        r1.roomId = ((Room) r0.getRoom().getValue()).getRoomId();
        r1.itemId = r7.b();
        r1.msgId = r7.getMessageId();
        r1.nickname = r7.c();
        r1.videoPinId = r7.g();
        r1.commenterId = "0";
        PinVideoApi.a.getClass();
        return ((PinVideoApi) com.bytedance.android.live.network.c.b().e(PinVideoApi.class)).pin(r1.toRequestFieldMap()).map(b.a);
    L12:
        return null;
    }

    @Override // g42.f
    public final g42.e o(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        return new PinVideoHighlightPageItemView(r5, null, 6, 0);
    }

    @Override // g42.a, g42.f
    public final void p(HighlightItem r3) {
        Intrinsics.checkNotNullParameter(r3, "item");
        String r0 = String.valueOf(r3.getItemId());
        HighlightItem.f r4 = r3.getVideoData();
        if (r4 == null) goto L5;
        String r5 = r4.d();
    L6:
        LiveHighlightAppLogger.d(r0, r5);
        return;
    L5:
        r5 = BuildConfig.FLAVOR;
        goto L6
    }

    @Override // g42.f
    public final com.bytedance.android.livesdk.wrds.syncdata.highlight.b q(HighlightItem r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        return r2.getVideoData();
    }
}
