package k92;

import android.content.Context;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.pin.container.PinType;
import com.bytedance.android.livesdk.interactivity.api.settings.config.z;
import com.bytedance.android.livesdk.interactivity.pin.business.common.PinCommonPictureTextView;
import com.bytedance.android.livesdk.interactivity.pin.business.common.api.CommonPictureTextHighlightRequest;
import com.bytedance.android.livesdk.interactivity.pin.business.common.api.CommonPictureTextHighlightResponse;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightDataCommonPictureText;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import g42.e;
import g42.h;
import g42.j;
import g42.k;
import g42.l;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends g42.a {

    /* JADX INFO: renamed from: k92.a$a, reason: collision with other inner class name */
    public static final class C0242a<T, R> implements Function {
        public static final C0242a a = null;

        static {
            a = new C0242a();
        }

        public C0242a() {
        }

        public final Object apply(Object r2) {
            Response r3 = (Response) r2;
            Intrinsics.checkNotNullParameter(r3, "response");
            int r0 = k.d;
            CommonPictureTextHighlightResponse r1 = (CommonPictureTextHighlightResponse) ((BaseResponse) r3).data;
            if (r1 == null) goto L6;
            r1.getItem();
        L6:
            return k.a.a(((BaseResponse) r3).logId);
        }
    }

    @Override // g42.f
    public final Observable<j> j(h<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "pinEvent");
        return null;
    }

    @Override // g42.f
    public final Integer k() {
        return null;
    }

    public a() {
        super("PinCommonPictureTextProcessor", PinType.CommonPictureText);
    }

    @Override // g42.f
    public final boolean b(HighlightItem r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        z.a.getClass();
        if (z.a.b().e() == false) goto L7;
        return false;
    L7:
        return s(r2);
    }

    @Override // g42.f
    public final String c(HighlightItem r3) {
        Intrinsics.checkNotNullParameter(r3, "item");
        HighlightDataCommonPictureText r4 = r3.getCommonPictureTextData();
        if (r4 == null) goto L6;
        String r5 = String.valueOf(r4.getPinId());
        if (r5 == null) goto L6;
        return r5;
    L6:
        return "0";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // g42.f
    public final Observable<k> n(l<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "unpinEvent");
        if ((r4 instanceof f42.b) == false) goto L13;
        f42.a r5 = (f42.a) ((f42.b) r4).b;
        CommonPictureTextHighlightRequest r0 = new CommonPictureTextHighlightRequest();
        r0.setScene(r5.a);
        r0.setActionType(2);
        RoomContext r1 = r();
        if (r1 == null) goto L11;
        m r2 = r1.getRoom();
        if (r2 == null) goto L11;
        Room r3 = (Room) r2.getValue();
        if (r3 == null) goto L11;
        long r6 = r3.id;
    L12:
        r0.setRoomId(r6);
        r0.setPinId(r5.b);
        return r0.request().map(C0242a.a);
    L11:
        r6 = 0;
        goto L12
    L13:
        return null;
    }

    @Override // g42.f
    public final e o(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        return new PinCommonPictureTextView(r5, null, 6, 0);
    }

    @Override // g42.f
    public final com.bytedance.android.livesdk.wrds.syncdata.highlight.b q(HighlightItem r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        return r2.getCommonPictureTextData();
    }
}
