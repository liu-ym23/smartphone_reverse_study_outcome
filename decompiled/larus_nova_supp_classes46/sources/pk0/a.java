package pk0;

import android.os.SystemClock;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.livelink.multilink.pipeline.LinkPipelineManager;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdk.chatroom.model.IApplyResult;
import com.bytedance.android.livesdk.chatroom.model.LinkFinishResult;
import com.bytedance.android.livesdk.chatroom.model.g1;
import com.bytedance.android.livesdk.chatroom.model.interact.t2;
import com.bytedance.android.livesdk.link.model.bridge.i0;
import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends vb6.b implements wb6.a {
    public final com.bytedance.android.live.liveinteract.plantform.utils.l b;
    public final fc6.a c;
    public final bn0.b d;

    /* JADX INFO: renamed from: pk0.a$a, reason: collision with other inner class name */
    public static final class C0251a {
    }

    static {
    }

    public a(fc6.a r2, bn0.b r3) {
        Intrinsics.checkNotNullParameter(r2, "hostService");
        Intrinsics.checkNotNullParameter(r3, "multiLinkRoomScope");
        this.c = r2;
        this.d = r3;
        this.b = (com.bytedance.android.live.liveinteract.plantform.utils.l) hc6.b.a(r3, Reflection.getOrCreateKotlinClass(com.bytedance.android.live.liveinteract.plantform.utils.l.class));
    }

    public final void F(long r19, String r21, com.bytedance.android.live.livelink.multilink.pipeline.d r22) {
        LinkMonitor.a("LinkApiM", "leaveChannel", String.valueOf(r21), null, null, false, 120);
        InteractLinkFullLinkMonitor.v(r21);
        Intrinsics.checkNotNullParameter(i97.a.a, "$this$elapsedRealtime");
        long r2 = SystemClock.elapsedRealtime();
        int r4 = wb6.b.a;
        if (r21 != null) goto L5;
        String r5 = "";
    L6:
        Intrinsics.checkNotNullParameter(r5, "reqFrom");
        an0.b r6 = an0.b.a;
        uz0.e r7 = new uz0.e();
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "$this$beforeConfigureRequest");
        Map r8 = r7.e;
        Intrinsics.checkNotNullParameter(r8, "fieldsMap");
        String r9 = Long.valueOf(r19).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r9 == null) goto L9;
        r8.put("room_id", r9);
    L9:
        Intrinsics.checkNotNullParameter("request_source", "$this$setTo");
        r8.put("request_source", r5);
        Intrinsics.checkNotNullParameter(r7, "$this$afterConfigureRequest");
        Observable r10 = com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).L4(INetworkService.Biz.MultiLink, "/webcast/linkmic_audience/leave/", TypesJVMKt.getJavaType(Reflection.typeOf(g1.class)), Extra.class, ((uz0.a) r7).d, ((uz0.a) r7).a, ((uz0.a) r7).b, ((uz0.a) r7).c, r7.e, r7.f, r7.g);
        int r11 = com.bytedance.revenue.platform.api.core.rx.p.a;
        com.bytedance.revenue.platform.api.core.rx.f.a(r10.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new k(r21, r2, r22), new l(r21, r2, r22)), ((vb6.b) this).a);
        return;
    L5:
        r5 = r21;
        goto L6
    }

    public final void i0(long r17, Map r19, LinkPipelineManager.j r20) {
        LinkMonitor.a("LinkApiM", "startJoinChannel", null, null, null, false, 124);
        Intrinsics.checkNotNullParameter(i97.a.a, "$this$elapsedRealtime");
        long r1 = SystemClock.elapsedRealtime();
        int r3 = wb6.b.a;
        Intrinsics.checkNotNullParameter(r19, "params");
        an0.b r4 = an0.b.a;
        uz0.e r5 = new uz0.e();
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "$this$beforeConfigureRequest");
        Map r6 = r5.e;
        Intrinsics.checkNotNullParameter(r6, "fieldsMap");
        String r7 = Long.valueOf(r17).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r7 == null) goto L5;
        r6.put("room_id", r7);
    L5:
        Iterator r8 = r19.entrySet().iterator();
    L7:
        if (r8.hasNext() == false) goto L11;
        Map.Entry r9 = (Map.Entry) r8.next();
        String r10 = (String) r9.getKey();
        String r11 = (String) r9.getValue();
        Intrinsics.checkNotNullParameter(r10, "$this$setTo");
        if (r11 == null) goto L7;
        r6.put(r10, r11);
        goto L7
    L11:
        Intrinsics.checkNotNullParameter(r5, "$this$afterConfigureRequest");
        Observable r12 = com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).L4(INetworkService.Biz.MultiLink, "/webcast/linkmic_audience/join_channel/", TypesJVMKt.getJavaType(Reflection.typeOf(i0.class)), Extra.class, ((uz0.a) r5).d, ((uz0.a) r5).a, ((uz0.a) r5).b, ((uz0.a) r5).c, r5.e, r5.f, r5.g);
        int r13 = com.bytedance.revenue.platform.api.core.rx.p.a;
        com.bytedance.revenue.platform.api.core.rx.f.a(r12.subscribeOn(Schedulers.io()).flatMap(f.a).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(r20, r1), new h(r20, r1)), ((vb6.b) this).a);
    }

    public final void p0(long r22, String r24, com.bytedance.android.live.livelink.multilink.pipeline.e r25) {
        LinkMonitor.a("LinkApiM", "notifyJoinRtc", null, null, null, false, 124);
        Intrinsics.checkNotNullParameter(i97.a.a, "$this$elapsedRealtime");
        long r7 = SystemClock.elapsedRealtime();
        int r0 = wb6.b.a;
        if (r24 != null) goto L5;
        String r1 = "";
    L6:
        Intrinsics.checkNotNullParameter(r1, "token");
        an0.b r2 = an0.b.a;
        uz0.e r3 = new uz0.e();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "$this$beforeConfigureRequest");
        Map r4 = r3.e;
        Intrinsics.checkNotNullParameter(r4, "fieldsMap");
        String r5 = Long.valueOf(r22).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r5 == null) goto L9;
        r4.put("room_id", r5);
    L9:
        Intrinsics.checkNotNullParameter("token", "$this$setTo");
        r4.put("token", r1);
        Intrinsics.checkNotNullParameter(r3, "$this$afterConfigureRequest");
        Observable r6 = com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).L4(INetworkService.Biz.MultiLink, "/webcast/linkmic_audience/notify_join_rtc/", TypesJVMKt.getJavaType(Reflection.typeOf(Unit.class)), Extra.class, ((uz0.a) r3).d, ((uz0.a) r3).a, ((uz0.a) r3).b, ((uz0.a) r3).c, r3.e, r3.f, r3.g);
        int r8 = com.bytedance.revenue.platform.api.core.rx.p.a;
        com.bytedance.revenue.platform.api.core.rx.f.a(r6.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new m(this, r25, r7, r24), new n(this, r25, r7)), ((vb6.b) this).a);
        return;
    L5:
        r1 = r24;
        goto L6
    }

    public final void C(long r21, String r23, String r24, com.bytedance.live.bizlink.impl.platform.manager.a.m r25) {
        LinkMonitor.a("LinkApiM", "permit", null, null, null, false, 124);
        Intrinsics.checkNotNullParameter(i97.a.a, "$this$elapsedRealtime");
        long r2 = SystemClock.elapsedRealtime();
        if (r23 == null) goto L7;
        Long r4 = StringsKt.toLongOrNull(r23);
        if (r4 == null) goto L7;
        long r5 = r4.longValue();
    L8:
        int r6 = wb6.b.a;
        if (r24 != null) goto L11;
        String r7 = "";
    L12:
        Intrinsics.checkNotNullParameter(r7, "secToUid");
        an0.b r8 = an0.b.a;
        uz0.e r9 = new uz0.e();
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "$this$beforeConfigureRequest");
        Map r10 = r9.e;
        Intrinsics.checkNotNullParameter(r10, "fieldsMap");
        String r11 = Long.valueOf(r21).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r11 == null) goto L15;
        r10.put("room_id", r11);
    L15:
        String r12 = Long.valueOf(r5).toString();
        Intrinsics.checkNotNullParameter("to_user_id", "$this$setTo");
        if (r12 == null) goto L18;
        r10.put("to_user_id", r12);
    L18:
        Intrinsics.checkNotNullParameter("to_user_open_id", "$this$setTo");
        if (r23 == null) goto L21;
        r10.put("to_user_open_id", r23);
    L21:
        Intrinsics.checkNotNullParameter("sec_to_user_id", "$this$setTo");
        r10.put("sec_to_user_id", r7);
        Intrinsics.checkNotNullParameter(r9, "$this$afterConfigureRequest");
        Observable r0 = com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).L4(INetworkService.Biz.MultiLink, "/webcast/linkmic_audience/permit/", TypesJVMKt.getJavaType(Reflection.typeOf(t2.class)), Extra.class, ((uz0.a) r9).d, ((uz0.a) r9).a, ((uz0.a) r9).b, ((uz0.a) r9).c, r9.e, r9.f, r9.g);
        int r13 = com.bytedance.revenue.platform.api.core.rx.p.a;
        com.bytedance.revenue.platform.api.core.rx.f.a(r0.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new o(r25, r2), new p(r25, r2)), ((vb6.b) this).a);
        return;
    L11:
        r7 = r24;
    L7:
        r5 = 0;
        goto L8
    }

    public final void R(long r20, String r22, Map r23, LinkPipelineManager.f r24) {
        Intrinsics.checkNotNullParameter(r22, "anchorIdStr");
        LinkMonitor.a("LinkApiM", "startApply", null, null, null, false, 124);
        Intrinsics.checkNotNullParameter(i97.a.a, "$this$elapsedRealtime");
        long r2 = SystemClock.elapsedRealtime();
        Long r4 = StringsKt.toLongOrNull(r22);
        if (r4 == null) goto L5;
        long r5 = r4.longValue();
    L6:
        int r6 = wb6.b.a;
        Intrinsics.checkNotNullParameter(r22, "anchorOpenId");
        Intrinsics.checkNotNullParameter(r23, "params");
        an0.b r7 = an0.b.a;
        uz0.e r8 = new uz0.e();
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "$this$beforeConfigureRequest");
        Map r9 = r8.e;
        Intrinsics.checkNotNullParameter(r9, "fieldsMap");
        String r10 = Long.valueOf(r20).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r10 == null) goto L9;
        r9.put("room_id", r10);
    L9:
        String r11 = Long.valueOf(r5).toString();
        Intrinsics.checkNotNullParameter("anchor_id", "$this$setTo");
        if (r11 == null) goto L12;
        r9.put("anchor_id", r11);
    L12:
        Intrinsics.checkNotNullParameter("anchor_open_id", "$this$setTo");
        r9.put("anchor_open_id", r22);
        Iterator r0 = r23.entrySet().iterator();
    L14:
        if (r0.hasNext() == false) goto L18;
        Map.Entry r12 = (Map.Entry) r0.next();
        String r13 = (String) r12.getKey();
        String r14 = (String) r12.getValue();
        Intrinsics.checkNotNullParameter(r13, "$this$setTo");
        if (r14 == null) goto L14;
        r9.put(r13, r14);
        goto L14
    L18:
        Intrinsics.checkNotNullParameter(r8, "$this$afterConfigureRequest");
        Observable r1 = com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).L4(INetworkService.Biz.MultiLink, "/webcast/linkmic_audience/apply/", TypesJVMKt.getJavaType(Reflection.typeOf(IApplyResult.class)), Extra.class, ((uz0.a) r8).d, ((uz0.a) r8).a, ((uz0.a) r8).b, ((uz0.a) r8).c, r8.e, r8.f, r8.g);
        int r15 = com.bytedance.revenue.platform.api.core.rx.p.a;
        com.bytedance.revenue.platform.api.core.rx.f.a(r1.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(r24, r2), new c(r24, r2)), ((vb6.b) this).a);
        return;
    L5:
        r5 = 0;
        goto L6
    }

    public final void y(long r18, String r20, Map r21, com.bytedance.android.live.livelink.multilink.pipeline.c r22) {
        LinkMonitor.a("LinkApiM", "startFinish", null, null, null, false, 124);
        Intrinsics.checkNotNullParameter(i97.a.a, "$this$elapsedRealtime");
        long r1 = SystemClock.elapsedRealtime();
        int r3 = wb6.b.a;
        if (r20 != null) goto L5;
        String r4 = "";
    L6:
        Intrinsics.checkNotNullParameter(r4, "reqSource");
        Intrinsics.checkNotNullParameter(r21, "extraParams");
        an0.b r5 = an0.b.a;
        uz0.e r6 = new uz0.e();
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "$this$beforeConfigureRequest");
        Map r7 = r6.e;
        Intrinsics.checkNotNullParameter(r7, "fieldsMap");
        String r8 = Long.valueOf(r18).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r8 == null) goto L9;
        r7.put("room_id", r8);
    L9:
        Intrinsics.checkNotNullParameter("request_source", "$this$setTo");
        r7.put("request_source", r4);
        Iterator r9 = r21.entrySet().iterator();
    L11:
        if (r9.hasNext() == false) goto L15;
        Map.Entry r10 = (Map.Entry) r9.next();
        String r11 = (String) r10.getKey();
        String r12 = (String) r10.getValue();
        Intrinsics.checkNotNullParameter(r11, "$this$setTo");
        if (r12 == null) goto L11;
        r7.put(r11, r12);
        goto L11
    L15:
        Intrinsics.checkNotNullParameter(r6, "$this$afterConfigureRequest");
        Observable r13 = com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).L4(INetworkService.Biz.MultiLink, "/webcast/linkmic_audience/finish/", TypesJVMKt.getJavaType(Reflection.typeOf(LinkFinishResult.class)), Extra.class, ((uz0.a) r6).d, ((uz0.a) r6).a, ((uz0.a) r6).b, ((uz0.a) r6).c, r6.e, r6.f, r6.g);
        int r14 = com.bytedance.revenue.platform.api.core.rx.p.a;
        com.bytedance.revenue.platform.api.core.rx.f.a(r13.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(r22, r1), new e(r22, r1)), ((vb6.b) this).a);
        return;
    L5:
        r4 = r20;
        goto L6
    }

    public final void M(long r21, String r23, String r24, String r25, com.bytedance.live.bizlink.impl.platform.manager.a.i r26) {
        LinkMonitor.a("LinkApiM", "kickOut", null, null, null, false, 124);
        Intrinsics.checkNotNullParameter(i97.a.a, "$this$elapsedRealtime");
        long r2 = SystemClock.elapsedRealtime();
        Long r4 = StringsKt.toLongOrNull(r23);
        if (r4 == null) goto L5;
        long r5 = r4.longValue();
    L6:
        int r6 = wb6.b.a;
        if (r24 != null) goto L9;
        String r7 = "";
    L10:
        Intrinsics.checkNotNullParameter(r7, "secToUid");
        Intrinsics.checkNotNullParameter(r25, "reqFrom");
        an0.b r8 = an0.b.a;
        uz0.e r9 = new uz0.e();
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "$this$beforeConfigureRequest");
        Map r10 = r9.e;
        Intrinsics.checkNotNullParameter(r10, "fieldsMap");
        String r11 = Long.valueOf(r21).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r11 == null) goto L13;
        r10.put("room_id", r11);
    L13:
        String r12 = Long.valueOf(r5).toString();
        Intrinsics.checkNotNullParameter("to_user_id", "$this$setTo");
        if (r12 == null) goto L16;
        r10.put("to_user_id", r12);
    L16:
        Intrinsics.checkNotNullParameter("to_user_open_id", "$this$setTo");
        r10.put("to_user_open_id", r23);
        Intrinsics.checkNotNullParameter("sec_to_user_id", "$this$setTo");
        r10.put("sec_to_user_id", r7);
        Intrinsics.checkNotNullParameter("request_source", "$this$setTo");
        r10.put("request_source", r25);
        Intrinsics.checkNotNullParameter(r9, "$this$afterConfigureRequest");
        Observable r0 = com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).L4(INetworkService.Biz.MultiLink, "/webcast/linkmic_audience/kick_out/", TypesJVMKt.getJavaType(Reflection.typeOf(Unit.class)), Extra.class, ((uz0.a) r9).d, ((uz0.a) r9).a, ((uz0.a) r9).b, ((uz0.a) r9).c, r9.e, r9.f, r9.g);
        int r13 = com.bytedance.revenue.platform.api.core.rx.p.a;
        com.bytedance.revenue.platform.api.core.rx.f.a(r0.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new i(r26, r2), new j(r26, r2)), ((vb6.b) this).a);
        return;
    L9:
        r7 = r24;
        goto L10
    L5:
        r5 = 0;
        goto L6
    }

    public final void f0(long r19, String r21, String r22, int r23, int r24, Map r25, LinkPipelineManager.k r26) {
        Intrinsics.checkNotNullParameter(r22, "toUserIdString");
        LinkMonitor.a("LinkApiM", "startReply", null, null, null, false, 124);
        Intrinsics.checkNotNullParameter(i97.a.a, "$this$elapsedRealtime");
        long r2 = SystemClock.elapsedRealtime();
        int r4 = wb6.b.a;
        if (r21 != null) goto L5;
        String r5 = "";
    L6:
        Intrinsics.checkNotNullParameter(r5, "secToUserId");
        Intrinsics.checkNotNullParameter(r22, "toUserId");
        Intrinsics.checkNotNullParameter(r22, "toOpenId");
        Intrinsics.checkNotNullParameter(r25, "params");
        an0.b r6 = an0.b.a;
        uz0.e r7 = new uz0.e();
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "$this$beforeConfigureRequest");
        uz0.b r8 = new uz0.b(r7.e);
        r8.a("room_id", Long.valueOf(r19).toString());
        r8.a("sec_to_user_id", r5);
        r8.a("to_user_id", r22);
        r8.a("to_open_id", r22);
        r8.a("reply_type", Integer.valueOf(r23).toString());
        r8.a("link_type", Integer.valueOf(r24).toString());
        Iterator r0 = r25.entrySet().iterator();
    L8:
        if (r0.hasNext() == false) goto L10;
        Map.Entry r9 = (Map.Entry) r0.next();
        r8.a((String) r9.getKey(), (String) r9.getValue());
        goto L8
    L10:
        Intrinsics.checkNotNullParameter(r7, "$this$afterConfigureRequest");
        Observable r1 = com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).L4(INetworkService.Biz.MultiLink, "/webcast/linkmic_audience/reply/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.livesdk.chatroom.model.interact.m.class)), Extra.class, ((uz0.a) r7).d, ((uz0.a) r7).a, ((uz0.a) r7).b, ((uz0.a) r7).c, r7.e, r7.f, r7.g);
        int r10 = com.bytedance.revenue.platform.api.core.rx.p.a;
        com.bytedance.revenue.platform.api.core.rx.f.a(r1.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new q(r26, r2), new r(r26, r2)), ((vb6.b) this).a);
        return;
    L5:
        r5 = r21;
        goto L6
    }
}
