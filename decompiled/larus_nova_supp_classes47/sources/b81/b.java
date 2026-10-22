package b81;

import android.os.Bundle;
import com.bytedance.android.live.room.api.screenrotation.entrance.EntranceChecker;
import com.bytedance.android.live.room.api.screenrotation.entrance.judge.JudgeInit;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b extends EntranceChecker {
    public final Bundle g;

    @Override // com.bytedance.android.live.room.api.screenrotation.entrance.EntranceChecker
    public final void e() {
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.entrance.EntranceChecker
    public final void f() {
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.entrance.EntranceChecker
    public final List<com.bytedance.android.live.room.api.screenrotation.entrance.a> g() {
        return JudgeInit.b(this.e, this.f, this.g);
    }

    public b(RoomContext r2, DataCenter r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r4, "playFragArgs");
        super(r2, r3);
        this.g = r4;
    }
}
