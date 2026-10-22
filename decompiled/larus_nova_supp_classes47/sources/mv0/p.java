package mv0;

import com.bytedance.android.livesdk.api.IRoomModuleService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p implements l71.d {
    public static final p a = null;

    public p() {
    }

    static {
        a = new p();
    }

    @Override // l71.d
    public final Long a(long r2) {
        IRoomModuleService r0 = jc1.k.f(IRoomModuleService.class);
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.chatroom.room.backend.g r1 = r0.getLiveRoomBackendUtils();
        if (r1 == null) goto L7;
        return Long.valueOf(r1.a(r2));
    L7:
        return null;
    }

    @Override // l71.d
    public final void b(long r15, DataCenter r17, Class r18, Function0 r19, Function3 r20, CompositeDisposable r22, boolean r23, boolean r24) {
        IRoomModuleService r0 = jc1.k.f(IRoomModuleService.class);
        if (r0 == null) goto L8;
        com.bytedance.android.livesdk.chatroom.room.backend.g r1 = r0.getLiveRoomBackendUtils();
        if (r1 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.room.backend.g.a.a(r1, r15, MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, r17, 0, 2), r18, r19, null, r20, null, null, r22, r23, r24, 2048);
        return;
    L9:
        return;
    }
}
