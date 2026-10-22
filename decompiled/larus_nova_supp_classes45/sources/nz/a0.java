package nz;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.broadcast.api.AskExplainSettingApi;
import com.bytedance.android.live.broadcast.api.ReplaySettingApi;
import com.bytedance.android.live.broadcast.api.UpdateRoomInfoApi;
import com.bytedance.android.live.broadcast.api.model.d1;
import com.bytedance.android.live.broadcast.api.model.e1;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a0 {
    public static final /* synthetic */ int a = 0;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ Function1 a;
        public final /* synthetic */ Function1 b;

        public a(Function1 r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            Response r3 = (Response) r2;
            if (r3 != null) goto L5;
        L9:
            this.b.invoke(new Throwable());
            return;
        L5:
            if (((BaseResponse) r3).statusCode != 0) goto L9;
            com.bytedance.android.live.broadcast.api.model.o r4 = (com.bytedance.android.live.broadcast.api.model.o) ((BaseResponse) r3).data;
            if (r4 == null) goto L11;
            Unit r5 = (Unit) this.a.invoke(r4);
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public b(Function1 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Function1 r0 = this.a;
            r0.invoke((Throwable) r2);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public c(Function1 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Response r3 = (Response) r2;
            if (r3 == null) goto L10;
            e1 r4 = (e1) ((BaseResponse) r3).data;
            if (r4 == null) goto L11;
            d1 r5 = r4.a();
            if (r5 == null) goto L12;
            Unit r6 = (Unit) this.a.invoke(r5);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public d(Function1 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Function1 r0 = this.a;
            r0.invoke((Throwable) r2);
        }
    }

    public a0() {
    }

    static {
    }

    public static void a(FragmentActivity r2, Function1 r3, Function1 r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "onSuccess");
        Intrinsics.checkNotNullParameter(r4, "onFailure");
        ((ObservableSubscribeProxy) ((AskExplainSettingApi) com.bytedance.android.live.network.c.b().e(AskExplainSettingApi.class)).querySetting().compose(RxUtil.rxSchedulerHelper()).as(AutoDispose.bind(r2))).subscribe(new a(r3, r4), new b(r4));
    }

    public static void b(FragmentActivity r7, int r8, int r9, long r11, Function1 r12, Function1 r13) {
        Intrinsics.checkNotNullParameter(r7, "activity");
        Intrinsics.checkNotNullParameter(r12, "onSuccess");
        Intrinsics.checkNotNullParameter(r13, "onFailure");
        if (r11 > 0) goto L5;
        return;
    L5:
        ((ObservableSubscribeProxy) ((UpdateRoomInfoApi) com.bytedance.android.live.network.c.b().e(UpdateRoomInfoApi.class)).updateRoomInfo(r11, "", 0, r8, r9).compose(RxUtil.rxSchedulerHelper()).as(AutoDispose.bind(r7))).subscribe(new d0(r12), new e0(r13));
    }

    public static void c(FragmentActivity r3, int r4, boolean r5, long r6, Function1 r8, Function1 r9) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r8, "onSuccess");
        Intrinsics.checkNotNullParameter(r9, "onFailure");
        if (r6 != 0) goto L5;
        Observable<Response<e1>> r7 = ((ReplaySettingApi) com.bytedance.android.live.network.c.b().e(ReplaySettingApi.class)).updateSetting(r4, r5);
    L6:
        ((ObservableSubscribeProxy) r7.compose(RxUtil.rxSchedulerHelper()).as(AutoDispose.bind(r3))).subscribe(new c(r8), new d(r9));
        return;
    L5:
        r7 = ((ReplaySettingApi) com.bytedance.android.live.network.c.b().e(ReplaySettingApi.class)).updateSetting(r4, r5, r6);
        goto L6
    }
}
