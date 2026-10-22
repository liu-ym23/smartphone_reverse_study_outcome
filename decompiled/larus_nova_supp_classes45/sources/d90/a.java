package d90;

import android.content.Context;
import com.bytedance.android.livesdk.ability.AbilityCenter;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class a extends d {
    public final IAbilityCenter j;

    public final RoomContext b() {
        MiddlewareRoomContext r0 = this.e;
        if ((r0 instanceof RoomContext) == true) goto L6;
        r0 = null;
    L6:
        return (RoomContext) r0;
    }

    @Override // d90.d, h70.b
    public IAbilityCenter a() {
        return this.j;
    }

    public a(Context r2, DataCenter r3, AbilityCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "abilityCenter");
        super(r2, r3, r4);
        this.j = r4;
    }
}
