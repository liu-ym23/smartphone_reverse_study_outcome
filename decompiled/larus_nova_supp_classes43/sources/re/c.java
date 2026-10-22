package re;

import com.bytedance.android.livesdkapi.room.handler.ILiveRoomMessageHandler;
import com.bytedance.android.tools.pbadapter.annotation.GenProtoDecoders;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@GenProtoDecoders
public final class c implements td.c {
    public final ILiveRoomMessageHandler a;

    public c(ILiveRoomMessageHandler r10) {
        Intrinsics.checkNotNullParameter(r10, "realHandler");
        this.a = r10;
    }

    @Override // td.c
    public final void b(td.a r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        ILiveRoomMessageHandler r0 = this.a;
        Intrinsics.checkNotNullParameter(r10, "$this$convert2Live");
        r0.removeListener(com.bytedance.android.ec.adapter.impl.converter.c.f.b.b(r10));
    }

    @Override // td.c
    public final void a(int r10, td.a r11) {
        Intrinsics.checkNotNullParameter(r11, "listener");
        ILiveRoomMessageHandler r0 = this.a;
        Intrinsics.checkNotNullParameter(r11, "$this$convert2Live");
        r0.addListener(r10, com.bytedance.android.ec.adapter.impl.converter.c.f.b.a(r11));
    }
}
