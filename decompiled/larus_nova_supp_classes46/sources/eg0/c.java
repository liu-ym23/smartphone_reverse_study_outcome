package eg0;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdk.chatroom.model.interact.UpdateLinkTypeApplyResponse;
import com.bytedance.android.livesdk.chatroom.model.interact.UpdateLinkTypeReplyResponse;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public c() {
    }

    static {
    }

    public static Observable b(long r10, String r12, String r13, int r14) {
        Intrinsics.checkNotNullParameter(r12, "userId");
        Intrinsics.checkNotNullParameter(r13, "userIdString");
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
        Intrinsics.checkNotNullParameter("to_user_id", "$this$setTo");
        if (r12 == null) goto L8;
        r2.put("to_user_id", r12);
    L8:
        Intrinsics.checkNotNullParameter("to_user_open_id", "$this$setTo");
        if (r13 == null) goto L11;
        r2.put("to_user_open_id", r13);
    L11:
        String r15 = Integer.valueOf(r14).toString();
        Intrinsics.checkNotNullParameter("reply_type", "$this$setTo");
        if (r15 == null) goto L14;
        r2.put("reply_type", r15);
    L14:
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return f.a(INetworkService.class).x0(INetworkService.Biz.MultiLink, "/webcast/linkmic_audience/update_link_type/reply/", TypesJVMKt.getJavaType(Reflection.typeOf(UpdateLinkTypeReplyResponse.class)), Extra.class, ((uz0.a) r1).d, ((uz0.a) r1).a, ((uz0.a) r1).b, ((uz0.a) r1).c);
    }

    public static Observable a(long r10, String r12, String r13, int r14, String r15) {
        Intrinsics.checkNotNullParameter(r12, "userId");
        Intrinsics.checkNotNullParameter(r13, "userIdString");
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
        Intrinsics.checkNotNullParameter("to_user_id", "$this$setTo");
        if (r12 == null) goto L8;
        r2.put("to_user_id", r12);
    L8:
        Intrinsics.checkNotNullParameter("to_user_open_id", "$this$setTo");
        if (r13 == null) goto L11;
        r2.put("to_user_open_id", r13);
    L11:
        String r16 = Integer.valueOf(r14).toString();
        Intrinsics.checkNotNullParameter("link_type", "$this$setTo");
        if (r16 == null) goto L14;
        r2.put("link_type", r16);
    L14:
        String r17 = String.valueOf(false);
        Intrinsics.checkNotNullParameter("is_chorus", "$this$setTo");
        if (r17 == null) goto L17;
        r2.put("is_chorus", r17);
    L17:
        if (r15 == null) goto L19;
        Intrinsics.checkNotNullParameter("request_source", "$this$setTo");
        r2.put("request_source", r15);
    L19:
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return f.a(INetworkService.class).x0(INetworkService.Biz.MultiLink, "/webcast/linkmic_audience/update_link_type/apply/", TypesJVMKt.getJavaType(Reflection.typeOf(UpdateLinkTypeApplyResponse.class)), Extra.class, ((uz0.a) r1).d, ((uz0.a) r1).a, ((uz0.a) r1).b, ((uz0.a) r1).c);
    }
}
