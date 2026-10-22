package to1;

import com.bytedance.android.livesdk.banner.InRoomBannerManager;
import com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.ActivityTopBannerViewIntent;
import com.bytedance.android.livesdk.utils.p4;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h extends z40.a<ActivityTopBannerViewIntent, com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a> {
    public h() {
    }

    public final void a(ActivityTopBannerViewIntent r5) {
        Intrinsics.checkNotNullParameter(r5, "input");
        DataCenter r6 = ((z40.a) this).b;
        Disposable r0 = null;
        if (r6 == null) goto L5;
        InRoomBannerManager r7 = (InRoomBannerManager) r6.get("data_in_room_banner_manager", null);
    L6:
        DataCenter r1 = ((z40.a) this).b;
        if (r1 == null) goto L9;
        IRoom r2 = (IRoom) r1.get("data_room", null);
    L10:
        if (r7 == null) goto L17;
        if (r2 == null) goto L13;
        Long r3 = Long.valueOf(r2.getRoomId());
    L14:
        int r4 = InRoomBannerManager.g;
        Observable r8 = r7.d(r3, 0);
        if (r8 == null) goto L17;
        r0 = r8.subscribe(new f(this, r2), new g(this, r2));
        goto L17
    L13:
        r3 = null;
    L17:
        p4 r9 = ((z40.a) this).c;
        if ((r9 instanceof p4) == false) goto L25;
        if (r9 == null) goto L24;
        p4 r10 = r9;
        if (r0 == null) goto L26;
        r10.b.add(r0);
        return;
    L26:
        return;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.utils.MVIWidgetPresenter<INTENT, STATE>");
    L25:
        return;
    L9:
        r2 = null;
        goto L10
    L5:
        r7 = null;
        goto L6
    }
}
