package z00;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.broadcast.api.LocationApiForSaas;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m {
    public static final /* synthetic */ int a = 0;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public a(Function1 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            u00.d r3 = ((u00.f) ((BaseResponse) ((Response) r2)).data).a();
            if (r3 == null) goto L8;
            u00.e r4 = r3.a();
            if (r4 == null) goto L8;
            String r5 = r4.a();
            if (r5 == null) goto L8;
        L9:
            this.a.invoke(r5);
            return;
        L8:
            r5 = "";
            goto L9
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r3) {
            int r0 = m.a;
            ALogger.stacktrace(6, "PreviewLocationWidgetForSaas", ((Throwable) r3).getStackTrace());
        }
    }

    static {
    }

    public static void a(LocationManager r18, String r19, l r21) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19, 3000L, Float.valueOf(3000.0f), r21};
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(100001);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(100001, "android/location/LocationManager", "requestLocationUpdates", r18, r1, "void", r11);     // Catch: Exception -> L21
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L21
    L17:
        if (r4.a == false) goto L19;
        return;
    L19:
        r18.requestLocationUpdates(r19, 3000, 3000.0f, r21);
        return;
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public static void b(Context r5, Location r6, Function1 r7) {
        Observable r8 = ((LocationApiForSaas) com.bytedance.android.live.network.c.b().e(LocationApiForSaas.class)).getLocationDesc(r6.getLongitude(), r6.getLatitude()).compose(RxUtil.rxSchedulerHelper());
        if (r8 != null) goto L5;
        return;
    L5:
        if ((r5 instanceof FragmentActivity) == true) goto L7;
        r5 = null;
    L7:
        ObservableSubscribeProxy r9 = (ObservableSubscribeProxy) r8.as(AutoDispose.bind((FragmentActivity) r5));
        if (r9 == null) goto L12;
        r9.subscribe(new a(r7), b.a);
        return;
    }
}
