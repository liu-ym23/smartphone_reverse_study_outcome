package com.bytedance.android.livesdk.dislike;

import androidx.core.app.NotificationManagerCompat;
import com.bytedance.android.annie.util.ThreadUtils;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener;
import com.bytedance.android.livesdk.notification.notificationsetting.api.NotificationSettingStatusApi;
import com.bytedance.android.livesdkapi.live.NotificationSettingCallBack;
import io.reactivex.functions.Consumer;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class x {
    public static final LinkedList<SoftReference<Runnable>> a = null;

    public static final class a extends IHostAppMonitorListener.Stub {
        public a() {
        }

        public final void appEnterBackground(boolean r3, boolean r4) {
            if (r3 == true) goto L8;
        L3:
            LinkedList<SoftReference<Runnable>> r5 = x.a;
            LinkedList<SoftReference<Runnable>> r6 = x.a;
            if (r6.isEmpty() == true) goto L14;
            Runnable r7 = r6.pop().get();
            if (r7 == null) goto L3;
            ThreadUtils.a().postDelayed(r7, 1000);
            goto L3
        L14:
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ NotificationSettingCallBack d;

        public b(long r1, String r3, String r4, NotificationSettingCallBack r5) {
            this.a = r1;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }

        public final void accept(Object r5) {
            if (((cn2.c) ((BaseResponse) ((Response) r5)).data).a() == 0) goto L5;
            return;
        L5:
            if (this.a != 1) goto L7;
            f2.i(s1.getContext(), s1.B(2131920765), 0);
            HashMap r6 = bn2.k.a;
            bn2.k.d("on", this.b, this.c);
        L8:
            NotificationSettingCallBack r7 = this.d;
            if (r7 == null) goto L13;
            r7.onSuccess(this.b, this.a);
            return;
        L13:
            return;
        L7:
            HashMap r8 = bn2.k.a;
            bn2.k.d("off", this.b, this.c);
            goto L8
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ NotificationSettingCallBack a;

        public c(NotificationSettingCallBack r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            CustomApiServerException r6 = (Throwable) r5;
            boolean r0 = r6 instanceof CustomApiServerException;
            if (r0 == true) goto L5;
        L7:
            if (r0 == true) goto L9;
        L11:
            NotificationSettingCallBack r7 = this.a;
            if (r7 == null) goto L15;
            r7.onFailure();
            return;
        L15:
            return;
        L9:
            if (r6.getErrorCode() != 30002) goto L11;
            f2.i(s1.getContext(), s1.B(2131920766), 0);
            goto L11
        L5:
            if (r6.getErrorCode() != 20010) goto L7;
            f2.i(s1.getContext(), s1.B(2131920749), 0);
            goto L7
        }
    }

    @JvmStatic
    public static final long a(long r7) {
        if (r7 != 0) goto L6;
        return 1;
    L6:
        if (r7 != 3) goto L9;
        return 1;
    L9:
        if (r7 != 2) goto L12;
        return 1;
    L12:
        if (r7 == 1) goto L14;
        return 1;
    L14:
        return 3;
    }

    static {
        a r0 = new a();
        a = new LinkedList();
        IHostApp r1 = jc1.k.f(IHostApp.class);
        if (r1 == null) goto L6;
        r1.registerLiveLifeCycleListener(r0);
        return;
    }

    @JvmStatic
    public static final void b(String r8, long r9, String r11, NotificationSettingCallBack r12) {
        Intrinsics.checkNotNullParameter(r8, "uid");
        if (r9 == 1) goto L10;
        if (r9 == 3) goto L10;
        if (r12 == null) goto L17;
        r12.onFailure();
        return;
    L17:
        return;
    L10:
        if (NotificationManagerCompat.from(jc1.a.b()).areNotificationsEnabled() == true) goto L15;
        if (r9 != 1) goto L15;
        if (r12 == null) goto L18;
        r12.onFailure();
        return;
    L18:
        return;
    L15:
        ((NotificationSettingStatusApi) com.bytedance.android.live.network.c.b().e(NotificationSettingStatusApi.class)).updateFollowPushStatus(r8, r8.toString(), (int) r9).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(r9, r8, r11, r12), new c(r12));
    }
}
