package hz0;

import com.bytedance.android.livesdk.revenue.interactivity.PublicScreenMessageType;
import com.bytedance.android.livesdk.revenue.service.room.c;
import com.bytedance.android.scope.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements gz0.b, o {
    public final c a;
    public final com.bytedance.android.livesdk.revenue.service.interactivity.a b;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public a(c r2, com.bytedance.android.livesdk.revenue.service.interactivity.a r3) {
        Intrinsics.checkNotNullParameter(r2, "roomService");
        Intrinsics.checkNotNullParameter(r3, "interactivityRoomService");
        this.a = r2;
        this.b = r3;
    }

    @Override // gz0.b
    public final void t0(PublicScreenMessageType r9, String r10, Integer r12, boolean r13, boolean r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r9, "type");
        Intrinsics.checkNotNullParameter(r10, "content");
        this.b.t0(r9, r10, r12, r13, r14, r15);
    }
}
