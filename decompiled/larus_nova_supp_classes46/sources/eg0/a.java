package eg0;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdk.chatroom.model.g1;
import com.bytedance.android.livesdk.chatroom.model.interact.j0;
import com.bytedance.android.livesdk.chatroom.model.l1;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Observable b(long r10, String r12) {
        an0.b r0 = an0.b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Map r2 = ((uz0.a) r1).b;
        Intrinsics.checkNotNullParameter(r2, "queriesMap");
        String r11 = Long.valueOf(r10).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r11 == null) goto L5;
        r2.put("room_id", r11);
    L5:
        Intrinsics.checkNotNullParameter("request_source", "$this$setTo");
        if (r12 == null) goto L8;
        r2.put("request_source", r12);
    L8:
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return f.a(INetworkService.class).x0(INetworkService.Biz.MultiLink, "/webcast/linkmic_audience/leave/", TypesJVMKt.getJavaType(Reflection.typeOf(g1.class)), Extra.class, ((uz0.a) r1).d, ((uz0.a) r1).a, ((uz0.a) r1).b, ((uz0.a) r1).c);
    }

    public static Observable c(long r10, int r12, int r13) {
        an0.b r0 = an0.b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Map r2 = ((uz0.a) r1).b;
        Intrinsics.checkNotNullParameter(r2, "queriesMap");
        String r11 = Long.valueOf(r10).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r11 == null) goto L5;
        r2.put("room_id", r11);
    L5:
        String r14 = Integer.valueOf(r12).toString();
        Intrinsics.checkNotNullParameter("position", "$this$setTo");
        if (r14 == null) goto L8;
        r2.put("position", r14);
    L8:
        String r15 = Integer.valueOf(r13).toString();
        Intrinsics.checkNotNullParameter("lock_status", "$this$setTo");
        if (r15 == null) goto L11;
        r2.put("lock_status", r15);
    L11:
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return f.a(INetworkService.class).x0(INetworkService.Biz.MultiLink, "/webcast/linkmic_audience/lock_position/", TypesJVMKt.getJavaType(Reflection.typeOf(l1.class)), Extra.class, ((uz0.a) r1).d, ((uz0.a) r1).a, ((uz0.a) r1).b, ((uz0.a) r1).c);
    }

    public static Observable a(long r4, int r6, boolean r7, int r8, String r9, int r10, Integer r11, Integer r12) {
        Intrinsics.checkNotNullParameter(r9, "supportedScene");
        an0.b r0 = an0.b.a;
        uz0.c r2 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "$this$beforeConfigureRequest");
        uz0.f r1 = new uz0.f(((uz0.a) r2).b);
        r1.a("room_id", Long.valueOf(r4).toString());
        Integer r5 = 4;
        r1.a("linkmic_vendor", r5.toString());
        r1.a("linkmic_layout", Integer.valueOf(r6).toString());
        r1.a("passive_start", String.valueOf(r7));
        r1.a("scene", Integer.valueOf(r8).toString());
        r1.a("supported_scenes", r9);
        r1.a("source", Integer.valueOf(r10).toString());
        if (r11 == null) goto L5;
        r1.a("ui_layout", Integer.valueOf(r11.intValue()).toString());
    L5:
        if (r12 == null) goto L7;
        r1.a("init_type", Integer.valueOf(r12.intValue()).toString());
    L7:
        Intrinsics.checkNotNullParameter(r2, "$this$afterConfigureRequest");
        return f.a(INetworkService.class).x0(INetworkService.Biz.MultiLink, "/webcast/linkmic_audience/init/v2/", TypesJVMKt.getJavaType(Reflection.typeOf(j0.class)), Extra.class, ((uz0.a) r2).d, ((uz0.a) r2).a, ((uz0.a) r2).b, ((uz0.a) r2).c);
    }
}
