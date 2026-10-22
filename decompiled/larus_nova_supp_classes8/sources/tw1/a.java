package tw1;

import am2.x;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.feed.dislike.DislikeApi;
import com.bytedance.android.livesdk.g;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.open.OpenRoom;
import com.bytedance.android.livesdkapi.depend.model.open.OpenUser;
import com.bytedance.android.livesdkapi.feed.CommonCallback;
import com.bytedance.android.livesdkapi.feed.EnterParams;
import com.bytedance.android.livesdkapi.feed.IDislikeRepository;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements IDislikeRepository {
    public Disposable a;

    /* JADX INFO: renamed from: tw1.a$a, reason: collision with other inner class name */
    public static final class C0418a<T> implements Consumer {
        public final /* synthetic */ CommonCallback a;

        public C0418a(CommonCallback r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Response r2 = (Response) r1;
            this.a.onSuccess();
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ CommonCallback a;

        public b(CommonCallback r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            CommonCallback r0 = this.a;
            r0.onFailed((Throwable) r2);
        }
    }

    public final void detach() {
        this.a.dispose();
    }

    public a() {
        this.a = new CompositeDisposable();
    }

    public final boolean dislike(EnterParams r18, OpenRoom r19, CommonCallback r20) {
        Intrinsics.checkNotNullParameter(r18, "enterParams");
        Intrinsics.checkNotNullParameter(r19, "openRoom");
        Intrinsics.checkNotNullParameter(r20, "callback");
        if (((Boolean) g.a.getValue()).booleanValue() == true) goto L5;
        return false;
    L5:
        LinkedHashMap r1 = new LinkedHashMap();
        o r5 = u.l().c(x.class);
        String r6 = (String) r5.getMap().get("enter_from_merge");
        String r8 = "";
        if (r6 != null) goto L8;
        r6 = "";
    L8:
        r1.put("enter_from_merge", r6);
        String r7 = (String) r5.getMap().get("enter_method");
        if (r7 != null) goto L11;
        r7 = "";
    L11:
        r1.put("enter_method", r7);
        r1.put("room_id", String.valueOf(r19.getId()));
        OpenUser r9 = r19.getOwner();
        if (r9 == null) goto L15;
        String r10 = r9.getOpenId();
        if (r10 == null) goto L15;
    L16:
        r1.put("anchor_id", r10);
        r1.put("action_type", "click");
        String r11 = r19.getResId();
        if (r11 != null) goto L19;
        r11 = "";
    L19:
        r1.put("request_id", r11);
        String r12 = r19.getLogPb();
        if (r12 != null) goto L22;
        r12 = "";
    L22:
        r1.put("log_pb", r12);
        OpenUser r13 = r19.getOwner();
        if (r13 == null) goto L28;
        String r14 = r13.getOpenId();
        if (r14 == null) goto L28;
        r8 = r14;
    L28:
        r1.put("to_user_id", r8);
        r1.put("room_in_or_out", "out");
        r1.put("is_ad", "no_ad");
        u.l().sendLog("livesdk_dislike", r1, new Object[0]);
        String r15 = r18.getEnterFromMerge();
        String r16 = r18.getEnterMethod();
        DislikeApi r17 = (DislikeApi) com.bytedance.android.live.network.c.b().e(DislikeApi.class);
        long r21 = r19.getId();
        OpenUser r2 = r19.getOwner();
        if (r2 == null) goto L31;
        String r110 = r2.getOpenId();
    L32:
        OpenUser r3 = r19.getOwner();
        if (r3 == null) goto L35;
        String r111 = r3.getOpenId();
    L36:
        this.a = r17.dislikeRoomSaasLegacy(r21, r110, r111, r19.getResId(), "", r15, r16, 1).compose(RxUtil.rxSchedulerHelper()).subscribe(new C0418a(r20), new b(r20));
        return true;
    L35:
        r111 = null;
        goto L36
    L31:
        r110 = null;
    L15:
        r10 = "";
        goto L16
    }
}
