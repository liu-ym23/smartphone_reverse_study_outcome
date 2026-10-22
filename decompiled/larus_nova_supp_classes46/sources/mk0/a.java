package mk0;

import android.os.SystemClock;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.livelink.guestlink.pipeline.GuestLinkPipeLineManager;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.revenue.platform.api.core.rx.p;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends lb6.b implements mb6.b {

    /* JADX INFO: renamed from: mk0.a$a, reason: collision with other inner class name */
    public static final class C0238a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ long a;

        public b(long r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            jy0.b.d("GuestLinkApiManager", "guestLinkSendSignal success duration: " + dc6.a.a(this.a) + ", logId: " + ((ExtraResponse) r4).logId);
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            jy0.b.b("GuestLinkApiManager", "guestLinkSendSignal failed", r4);
            com.bytedance.live.kmp.util.a.b(r4);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ mb6.b.d b;

        public d(long r1, mb6.b.d r3) {
            this.a = r1;
            this.b = r3;
        }

        public final void accept(Object r4) {
            ExtraResponse r5 = (ExtraResponse) r4;
            jy0.b.d("GuestLinkApiManager", "leaveChannel success duration: " + dc6.a.a(this.a) + ", logId: " + r5.logId);
            mb6.b.d r0 = this.b;
            if (r0 == null) goto L6;
            r0.q(dc6.a.a(this.a), r5);
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ mb6.b.d a;
        public final /* synthetic */ long b;

        public e(mb6.b.d r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            jy0.b.b("GuestLinkApiManager", "leaveChannel failed", r5);
            com.bytedance.live.kmp.util.a.b(r5);
            mb6.b.d r0 = this.a;
            if (r0 == null) goto L6;
            r0.i(dc6.a.a(this.b), r5);
            return;
        }
    }

    static {
    }

    public a() {
    }

    public final void D(long r22, long r24, long r26) {
        jy0.b.d("GuestLinkApiManager", "leaveChannel, roomId: " + r22 + ", channelId: " + r24 + ", isBackground: " + r26);
        Intrinsics.checkNotNullParameter(i97.a.a, "$this$elapsedRealtime");
        long r7 = SystemClock.elapsedRealtime();
        int r0 = mb6.a.a;
        Long r1 = Long.valueOf(r26);
        an0.b r5 = an0.b.a;
        uz0.e r6 = new uz0.e();
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "$this$beforeConfigureRequest");
        Map r8 = r6.e;
        Intrinsics.checkNotNullParameter(r8, "fieldsMap");
        String r3 = Long.valueOf(r24).toString();
        Intrinsics.checkNotNullParameter("channel_id", "$this$setTo");
        if (r3 == null) goto L5;
        r8.put("channel_id", r3);
    L5:
        if (r1 == null) goto L9;
        String r2 = r1.toString();
        Intrinsics.checkNotNullParameter("is_background", "$this$setTo");
        if (r2 == null) goto L9;
        r8.put("is_background", r2);
    L9:
        String r4 = Long.valueOf(r22).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r4 == null) goto L12;
        r8.put("room_id", r4);
    L12:
        Intrinsics.checkNotNullParameter(r6, "$this$afterConfigureRequest");
        Observable r9 = com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).L4(INetworkService.Biz.MultiLink, "/webcast/linkmic_audience/guest_link_send_signal/", TypesJVMKt.getJavaType(Reflection.typeOf(Unit.class)), Extra.class, ((uz0.a) r6).d, ((uz0.a) r6).a, ((uz0.a) r6).b, ((uz0.a) r6).c, r6.e, r6.f, r6.g);
        int r10 = p.a;
        com.bytedance.revenue.platform.api.core.rx.f.a(r9.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(r7), c.a), ((lb6.b) this).a);
    }

    public final void B(long r22, long r24, String r26, mb6.b.d r27) {
        Intrinsics.checkNotNullParameter(r26, "source");
        jy0.b.d("GuestLinkApiManager", "leaveChannel, roomId: " + r22 + ", channelId: " + r24 + ", source: " + r26);
        Intrinsics.checkNotNullParameter(i97.a.a, "$this$elapsedRealtime");
        long r7 = SystemClock.elapsedRealtime();
        int r2 = mb6.a.a;
        an0.b r3 = an0.b.a;
        uz0.e r9 = new uz0.e();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r9, "$this$beforeConfigureRequest");
        Map r4 = r9.e;
        Intrinsics.checkNotNullParameter(r4, "fieldsMap");
        String r5 = Long.valueOf(r22).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r5 == null) goto L5;
        r4.put("room_id", r5);
    L5:
        String r6 = Long.valueOf(r24).toString();
        Intrinsics.checkNotNullParameter("channel_id", "$this$setTo");
        if (r6 == null) goto L8;
        r4.put("channel_id", r6);
    L8:
        if (r26 == null) goto L10;
        Intrinsics.checkNotNullParameter("request_source", "$this$setTo");
        r4.put("request_source", r26);
    L10:
        Intrinsics.checkNotNullParameter(r9, "$this$afterConfigureRequest");
        Observable r0 = com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).L4(INetworkService.Biz.MultiLink, "/webcast/linkmic_audience/guest_link_leave_channel/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.livesdk.multilink.base.model.guestlink.d.class)), Extra.class, ((uz0.a) r9).d, ((uz0.a) r9).a, ((uz0.a) r9).b, ((uz0.a) r9).c, r9.e, r9.f, r9.g);
        int r8 = p.a;
        com.bytedance.revenue.platform.api.core.rx.f.a(r0.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(r7, r27), new e(r27, r7)), ((lb6.b) this).a);
    }

    public final void v(long r23, long r25, int r27, com.bytedance.android.live.livelink.guestlink.pipeline.a r28) {
        jy0.b.d("GuestLinkApiManager", "joinChannel, roomId: " + r23 + ", channelId: " + r25);
        Intrinsics.checkNotNullParameter(i97.a.a, "$this$elapsedRealtime");
        long r6 = SystemClock.elapsedRealtime();
        int r1 = mb6.a.a;
        long r8 = (long) r27;
        an0.b r2 = an0.b.a;
        uz0.e r10 = new uz0.e();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r10, "$this$beforeConfigureRequest");
        Map r3 = r10.e;
        Intrinsics.checkNotNullParameter(r3, "fieldsMap");
        String r4 = Long.valueOf(r23).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r4 == null) goto L5;
        r3.put("room_id", r4);
    L5:
        String r5 = Long.valueOf(r25).toString();
        Intrinsics.checkNotNullParameter("channel_id", "$this$setTo");
        if (r5 == null) goto L8;
        r3.put("channel_id", r5);
    L8:
        String r7 = Long.valueOf(r8).toString();
        Intrinsics.checkNotNullParameter("link_type", "$this$setTo");
        if (r7 == null) goto L11;
        r3.put("link_type", r7);
    L11:
        Intrinsics.checkNotNullParameter(r10, "$this$afterConfigureRequest");
        Observable r9 = com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).L4(INetworkService.Biz.MultiLink, "/webcast/linkmic_audience/guest_link_join_linked_channel/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.livesdk.multilink.base.model.guestlink.c.class)), Extra.class, ((uz0.a) r10).d, ((uz0.a) r10).a, ((uz0.a) r10).b, ((uz0.a) r10).c, r10.e, r10.f, r10.g);
        int r11 = p.a;
        com.bytedance.revenue.platform.api.core.rx.f.a(r9.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(r6, r28), new g(r28, r6)), ((lb6.b) this).a);
    }

    public final void m(long r24, long r26, long r28, long r30, GuestLinkPipeLineManager.b r32) {
        jy0.b.d("GuestLinkApiManager", "enterChannel, roomId: " + r24 + ", curChannelId: " + r26 + ", toChannelId: " + r28 + ", enterType: " + r30);
        Intrinsics.checkNotNullParameter(i97.a.a, "$this$elapsedRealtime");
        long r9 = SystemClock.elapsedRealtime();
        int r0 = mb6.a.a;
        an0.b r1 = an0.b.a;
        uz0.e r11 = new uz0.e();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r11, "$this$beforeConfigureRequest");
        Map r2 = r11.e;
        Intrinsics.checkNotNullParameter(r2, "fieldsMap");
        String r3 = Long.valueOf(r24).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r3 == null) goto L5;
        r2.put("room_id", r3);
    L5:
        String r4 = Long.valueOf(r26).toString();
        Intrinsics.checkNotNullParameter("cur_channel_id", "$this$setTo");
        if (r4 == null) goto L8;
        r2.put("cur_channel_id", r4);
    L8:
        String r5 = Long.valueOf(r28).toString();
        Intrinsics.checkNotNullParameter("to_channel_id", "$this$setTo");
        if (r5 == null) goto L11;
        r2.put("to_channel_id", r5);
    L11:
        String r6 = Long.valueOf(r30).toString();
        Intrinsics.checkNotNullParameter("enter_type", "$this$setTo");
        if (r6 == null) goto L14;
        r2.put("enter_type", r6);
    L14:
        Intrinsics.checkNotNullParameter(r11, "$this$afterConfigureRequest");
        Observable r7 = com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).L4(INetworkService.Biz.MultiLink, "/webcast/linkmic_audience/guest_link_enter_channel/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.livesdk.multilink.base.model.guestlink.b.class)), Extra.class, ((uz0.a) r11).d, ((uz0.a) r11).a, ((uz0.a) r11).b, ((uz0.a) r11).c, r11.e, r11.f, r11.g);
        int r8 = p.a;
        com.bytedance.revenue.platform.api.core.rx.f.a(r7.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new mk0.b(r9, r32, r30), new mk0.c(r32, r9, r30)), ((lb6.b) this).a);
    }

    public final void t(long r23, long r25, String r27, String r28, GuestLinkPipeLineManager.f r29) {
        Intrinsics.checkNotNullParameter(r27, "source");
        Intrinsics.checkNotNullParameter(r28, "requestSource");
        jy0.b.d("GuestLinkApiManager", "finishChannel, roomId: " + r23 + ", channelId: " + r25 + ", source: " + r27 + ", requestSource: " + r28);
        Intrinsics.checkNotNullParameter(i97.a.a, "$this$elapsedRealtime");
        long r8 = SystemClock.elapsedRealtime();
        int r0 = mb6.a.a;
        an0.b r1 = an0.b.a;
        uz0.e r3 = new uz0.e();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "$this$beforeConfigureRequest");
        Map r2 = r3.e;
        Intrinsics.checkNotNullParameter(r2, "fieldsMap");
        String r4 = Long.valueOf(r23).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r4 == null) goto L5;
        r2.put("room_id", r4);
    L5:
        String r5 = Long.valueOf(r25).toString();
        Intrinsics.checkNotNullParameter("channel_id", "$this$setTo");
        if (r5 == null) goto L8;
        r2.put("channel_id", r5);
    L8:
        if (r28 == null) goto L10;
        Intrinsics.checkNotNullParameter("request_source", "$this$setTo");
        r2.put("request_source", r28);
    L10:
        Intrinsics.checkNotNullParameter(r3, "$this$afterConfigureRequest");
        Observable r6 = com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).L4(INetworkService.Biz.MultiLink, "/webcast/linkmic_audience/guest_link_channel_finish/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.livesdk.multilink.base.model.guestlink.a.class)), Extra.class, ((uz0.a) r3).d, ((uz0.a) r3).a, ((uz0.a) r3).b, ((uz0.a) r3).c, r3.e, r3.f, r3.g);
        int r7 = p.a;
        com.bytedance.revenue.platform.api.core.rx.f.a(r6.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new mk0.d(r8, r29, r28), new mk0.e(r29, r8)), ((lb6.b) this).a);
    }
}
