package com.bytedance.android.livesdk.dislike.sharefans.widget;

import am2.x;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.livesdk.dislike.sharefans.api.ShareFansRoom;
import com.bytedance.android.livesdk.dislike.sharefans.api.ShareRoomResponse;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/dislike/sharefans/widget/ShareFansWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShareFansWidget extends LiveRecyclableWidget {
    public static final /* synthetic */ int b = 0;
    public final CompositeDisposable a;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.dislike.sharefans.widget.ShareFansWidget$onLoad$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lmt1/a;", "p1", "", "invoke", "(Lmt1/a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<mt1.a, Unit> {
        public AnonymousClass1(ShareFansWidget r8) {
            super(1, r8, ShareFansWidget.class, "onDislikeMenuEvent", "onDislikeMenuEvent(Lcom/bytedance/android/livesdk/dislike/event/DislikeMenuEvent;)V", 0);
        }

        public final void invoke(mt1.a r13) {
            ShareFansWidget r0 = (ShareFansWidget) ((CallableReference) this).receiver;
            int r1 = ShareFansWidget.b;
            r0.getClass();
            if (r13 != null) goto L5;
            return;
        L5:
            if (r13.getType() != 5) goto L59;
            pt1.a r2 = r13.e;
            if (r2 == null) goto L54;
            o r3 = u.l().c(x.class);
            Room r4 = r2.a;
            if (r4 == null) goto L13;
            String r5 = r4.getOwnerUserIdString();
            if (r5 == null) goto L13;
        L14:
            String r6 = r5;
            Room r7 = r2.a;
            if (r7 == null) goto L22;
            User r8 = r7.getOwner();
            if (r8 == null) goto L22;
            String r9 = r8.getCastSecUid();
            if (r9 == null) goto L22;
            String r10 = r9;
        L23:
            Room r11 = r2.a;
            if (r11 == null) goto L26;
            long r12 = r11.getRoomId();
        L27:
            if (r3 == null) goto L34;
            Map r14 = r3.getMap();
            if (r14 == null) goto L34;
            String r15 = (String) r14.get("enter_from_merge");
            if (r15 == null) goto L34;
            String r16 = r15;
        L35:
            if (r3 == null) goto L42;
            Map r17 = r3.getMap();
            if (r17 == null) goto L42;
            String r18 = (String) r17.get("enter_method");
            if (r18 == null) goto L42;
            String r19 = r18;
        L43:
            ot1.a r20 = new ot1.a(r6, r10, r12, r16, r19, 1);
            ShareFansRoom r21 = (ShareFansRoom) com.bytedance.android.live.network.c.b().e(ShareFansRoom.class);
            if (r21 == null) goto L55;
            Observable<e<ShareRoomResponse>> r22 = r21.shareFansRoom(r20.a, r20.b, r20.c, r20.d, r20.e, r20.f);
            if (r22 == null) goto L56;
            Observable r23 = r22.compose(RxUtil.rxSchedulerHelper());
            if (r23 == null) goto L57;
            Disposable r110 = r23.subscribe(new com.bytedance.android.livesdk.dislike.sharefans.widget.a(r13), b.a);
            if (r110 == null) goto L58;
            RxUtilKt.c(r110, r0.a);
            return;
        L58:
            return;
        L57:
            return;
        L56:
            return;
        L55:
            return;
        L42:
            r19 = "";
        L34:
            r16 = "";
            goto L35
        L26:
            r12 = 0;
        L22:
            r10 = "";
        L13:
            r5 = "0";
            goto L14
        L54:
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((mt1.a) r1);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final void onInit(Object[] r1) {
    }

    public final void onUnload() {
        this.a.clear();
    }

    public ShareFansWidget() {
        this.a = new CompositeDisposable();
    }

    public final void onLoad(Object[] r3) {
        AnonymousClass1 r0 = new AnonymousClass1(this);
        RxUtilKt.c(xs2.b.a().b(mt1.a.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(r0)), this.a);
    }
}
