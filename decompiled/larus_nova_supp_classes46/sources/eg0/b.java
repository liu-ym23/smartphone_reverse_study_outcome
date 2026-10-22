package eg0;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdk.chatroom.model.h1;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Observable a(String r10, long r11) {
        an0.b r0 = an0.b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Map r2 = ((uz0.a) r1).b;
        Intrinsics.checkNotNullParameter(r2, "queriesMap");
        if (r10 == null) goto L5;
        Intrinsics.checkNotNullParameter("keys", "$this$setTo");
        r2.put("keys", r10);
    L5:
        String r12 = Long.valueOf(r11).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r12 == null) goto L8;
        r2.put("room_id", r12);
    L8:
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return f.a(INetworkService.class).x0(INetworkService.Biz.MultiLink, "/webcast/linkmic_audience/get_audience_settings/", TypesJVMKt.getJavaType(Reflection.typeOf(h1.class)), Extra.class, ((uz0.a) r1).d, ((uz0.a) r1).a, ((uz0.a) r1).b, ((uz0.a) r1).c);
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
        if (r12 == null) goto L7;
        Intrinsics.checkNotNullParameter("token", "$this$setTo");
        r2.put("token", r12);
    L7:
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return f.a(INetworkService.class).x0(INetworkService.Biz.MultiLink, "/webcast/linkmic_audience/notify_join_rtc/", TypesJVMKt.getJavaType(Reflection.typeOf(Unit.class)), Extra.class, ((uz0.a) r1).d, ((uz0.a) r1).a, ((uz0.a) r1).b, ((uz0.a) r1).c);
    }
}
