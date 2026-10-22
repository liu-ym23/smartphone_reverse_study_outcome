package bd2;

import android.os.Message;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.network.response.BaseListResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.kickout.api.BannedApiV2;
import com.bytedance.android.livesdk.service.l;
import com.bytedance.common.utility.collection.WeakHandler;
import dd2.c;
import dd2.d;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements WeakHandler.IHandler {
    public bd2.b a;
    public final WeakHandler b;

    /* JADX INFO: renamed from: bd2.a$a, reason: collision with other inner class name */
    public class C0005a implements Consumer<Response<Void>> {
        public final /* synthetic */ int a;
        public final /* synthetic */ a b;

        public final void accept(Object r2) throws Exception {
            Response r3 = (Response) r2;
            WeakHandler r4 = this.b.b;
            if (r4 == null) goto L6;
            Message r5 = r4.obtainMessage(this.a);
            this.b.b.sendMessage(r5);
            return;
        }

        public C0005a(a r1, int r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class b implements Consumer<Throwable> {
        public final /* synthetic */ int a;
        public final /* synthetic */ a b;

        public final void accept(Object r3) throws Exception {
            Throwable r4 = (Throwable) r3;
            if ((r4 instanceof Exception) == false) goto L8;
            WeakHandler r0 = this.b.b;
            if (r0 == null) goto L9;
            Message r1 = r0.obtainMessage(this.a);
            r1.obj = r4;
            this.b.b.sendMessage(r1);
            return;
        L9:
            return;
        }

        public b(a r1, int r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public a() {
        this.b = new WeakHandler(this);
    }

    public final void handleMsg(Message r3) {
        int r0 = r3.what;
        if (r0 != 1) goto L5;
        Object r4 = r3.obj;
        if ((r4 instanceof Exception) == false) goto L30;
        this.a.x3(true, (Exception) r4);
        return;
    L30:
        this.a.C2(true);
        return;
    L5:
        if (r0 != 2) goto L7;
        Object r5 = r3.obj;
        if ((r5 instanceof Exception) == false) goto L26;
        this.a.x3(false, (Exception) r5);
        return;
    L26:
        this.a.C2(false);
        return;
    L7:
        if (r0 != 3) goto L39;
        bd2.b r1 = this.a;
        if (r1 == null) goto L12;
        r1.hideLoading();
    L12:
        Object r6 = r3.obj;
        if ((r6 instanceof Exception) == false) goto L17;
        Exception r7 = (Exception) r6;
        bd2.b r2 = this.a;
        if (r2 == null) goto L32;
        r2.H3(null, r7);
        return;
    L32:
        return;
    L17:
        c r8 = (c) r6;
        if (r8 == null) goto L34;
        bd2.b r9 = this.a;
        if (r9 == null) goto L22;
        r9.H3(r8, null);
    L22:
        boolean r10 = ((Extra) ((d) ((BaseListResponse) r8).extra)).hasMore;
        return;
    L34:
        return;
    }

    public final void a(boolean r3, long r4, String r6, String r7) {
        if (r3 == false) goto L4;
        l.d().getClass();
        Observable<Response<Void>> r5 = ((BannedApiV2) com.bytedance.android.live.network.c.b().e(BannedApiV2.class)).kickOut(r4, r6, r7);
    L5:
        if (r3 == false) goto L7;
        int r8 = 1;
    L8:
        r5.compose(RxUtil.rxSchedulerHelper()).subscribe(new C0005a(this, r8), new b(this, r8));
        return;
    L7:
        r8 = 2;
        goto L8
    L4:
        l.d().getClass();
        r5 = ((BannedApiV2) com.bytedance.android.live.network.c.b().e(BannedApiV2.class)).unKickOut(r4, r6, r7);
        goto L5
    }
}
