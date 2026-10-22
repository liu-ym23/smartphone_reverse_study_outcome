package com.bytedance.android.livesdk.dispatch.utils;

import am2.x;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.qo;
import com.bytedance.android.livesdk.dispatch.DispatchContext;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class DispatchLogUtil {
    public static final Lazy a = null;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/dispatch/utils/DispatchLogUtil$InstanceType;", "", "", "module", "Ljava/lang/String;", "getModule", "()Ljava/lang/String;", "action", "getAction", "FOLLOW", "UNFOLLOW", "DISLIKE", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum InstanceType extends Enum<InstanceType> {
        public static final InstanceType DISLIKE = null;
        public static final InstanceType FOLLOW = null;
        public static final InstanceType UNFOLLOW = null;
        public static final /* synthetic */ InstanceType[] a = null;
        private final String action;
        private final String module;

        static {
            InstanceType r1 = new InstanceType("FOLLOW", 0, "User", "follow");
            FOLLOW = r1;
            InstanceType r2 = new InstanceType("UNFOLLOW", 1, "User", "unfollow");
            UNFOLLOW = r2;
            InstanceType r3 = new InstanceType("DISLIKE", 2, "Dislike", "dislike");
            DISLIKE = r3;
            a = new InstanceType[]{r1, r2, r3};
        }

        public static InstanceType valueOf(String r1) {
            return (InstanceType) r27.a.a(InstanceType.class, r1);
        }

        public static InstanceType[] values() {
            return (InstanceType[]) a.clone();
        }

        public final String getAction() {
            return this.action;
        }

        public final String getModule() {
            return this.module;
        }

        public InstanceType(String r1, int r2, String r3, String r4) {
            super(r1, r2);
            this.module = r3;
            this.action = r4;
        }
    }

    static {
        a = LazyKt.lazy(DispatchLogUtil$isDebug$2.INSTANCE);
    }

    public static void a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "msg");
        if (((Boolean) a.getValue()).booleanValue() == false) goto L6;
        ALogger.e("DispatchLogUtil", r1);
        return;
    }

    public static void c(String r1) {
        Intrinsics.checkNotNullParameter(r1, "msg");
        if (((Boolean) a.getValue()).booleanValue() == false) goto L8;
        int r0 = a.a;
        if (qo.a.getValue().booleanValue() == false) goto L9;
        f2.c(r1, 0);
        return;
    L9:
        return;
    }

    public static void d(int r2, InstanceType r3) {
        Intrinsics.checkNotNullParameter(r3, "instanceType");
        f(r2, r3.getModule(), r3.getAction(), null);
    }

    public static void b(long r6, String r8, String r9) {
        Intrinsics.checkNotNullParameter("User", "module");
        Intrinsics.checkNotNullParameter(r8, "action");
        Intrinsics.checkNotNullParameter(r9, "fullSchema");
        long r3 = System.currentTimeMillis() - r6;
        u.l().sendLog("livesdk_schema_dispatcher", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("module", "User"), TuplesKt.to("action", r8), TuplesKt.to("type", "dispatch"), TuplesKt.to("duration", String.valueOf(r3)), TuplesKt.to("scheme", r9)}), new Object[]{Room.class, x.class});
        a("module 是 User  action 是 " + r8 + " duration 是 " + r3);
    }

    public static void e(int r12, String r13, DispatchContext r14) {
        Intrinsics.checkNotNullParameter(r13, "key");
        long r0 = System.currentTimeMillis();
        RoomContext.a r2 = RoomContext.Companion;
        RoomContext r7 = RoomContext.a.c(r2, null, 0, 3);
        DataContext r15 = r14;
        if (r7 == null) goto L11;
        j r8 = r7.getDispatchContext();
        r15 = r14;
        if (r8 == null) goto L11;
        DataContext r9 = (DataContext) r8.getValue();
        r15 = r14;
        if (r9 == null) goto L11;
        r15 = r9;
    L11:
        if ((r15 instanceof DispatchContext) == true) goto L13;
        return;
    L13:
        if (r12 != 1) goto L15;
        ((DispatchContext) r15).getLogStartTime().put(r13, Long.valueOf(r0));
    L15:
        Long r16 = ((DispatchContext) r15).getLogStartTime().get(r13);
        if (r16 == null) goto L18;
        long r10 = r16.longValue();
    L19:
        if (r12 == 0) goto L23;
        if (r12 == 1) goto L23;
        long r1 = r0 - r10;
    L24:
        u.l().sendLog("livesdk_schema_dispatcher_trace", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("path", r13), TuplesKt.to("type", String.valueOf(r12)), TuplesKt.to("duration", String.valueOf(r1))}), new Object[]{Room.class, x.class});
        RoomContext r17 = RoomContext.a.c(r2, null, 0, 3);
        if (r17 == null) goto L29;
        m r18 = r17.getRoom();
        if (r18 == null) goto L29;
        Room r19 = (Room) r18.getValue();
    L30:
        String r3 = k.n(IUserService.class).user().n();
        int r4 = com.bytedance.android.live.core.monitor.trace.e.m;
        com.bytedance.android.live.core.monitor.trace.e.a r5 = com.bytedance.android.live.core.monitor.trace.e.b.a(r13, "live_dispatch_handle");
        r5.c = "webcast_client_community";
        r5.h = Integer.valueOf(r12);
        r5.i = r13;
        if (r19 == null) goto L33;
        String r6 = String.valueOf(r19.id);
    L34:
        r5.e = r6;
        r5.g = r3;
        if (r19 == null) goto L37;
        String r110 = r19.getAnchorId();
    L38:
        r5.f = r110;
        com.bytedance.android.live.core.monitor.trace.c.b(r5.a(), null);
        a("path: " + r13 + "  type:  " + r12 + "  duration: " + r1);
        if (r12 != 4) goto L42;
        c("执行 ".concat(r13));
        return;
    L42:
        if (r12 != 6) goto L45;
        c(r13.concat(" 回调成功"));
        return;
    L45:
        if (r12 != 8) goto L51;
        c(r13.concat(" 回调失败"));
        return;
    L51:
        return;
    L37:
        r110 = null;
        goto L38
    L33:
        r6 = null;
    L29:
        r19 = null;
    L23:
        r1 = 0;
        goto L24
    L18:
        r10 = System.currentTimeMillis();
        goto L19
    }

    public static void f(int r1, String r2, String r3, DispatchContext r4) {
        Intrinsics.checkNotNullParameter(r2, "module");
        Intrinsics.checkNotNullParameter(r3, "action");
        e(r1, r2 + '/' + r3, r4);
    }
}
