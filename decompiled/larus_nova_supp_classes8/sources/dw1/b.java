package dw1;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.feed.drawerfeed.singledraw.viewholder.RoomSingleDrawViewHolder;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ RoomSingleDrawViewHolder a;

    public b(RoomSingleDrawViewHolder r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Long r4 = (Long) r3;
        Room r0 = this.a.c;
        if (r0 == null) goto L5;
        Long r1 = Long.valueOf(r0.id);
    L7:
        if ((!Intrinsics.areEqual(r4, r1)) == false) goto L12;
        RoomSingleDrawViewHolder r5 = this.a;
        if (r5.o == false) goto L13;
        UtilityKotlinExtentionsKt.t(r5.l);
        UtilityKotlinExtentionsKt.t(r5.k);
        r5.l.pauseAnimation();
        r5.o = false;
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r1 = null;
        goto L7
    }
}
