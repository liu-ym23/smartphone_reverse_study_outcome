package z51;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.r;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static w71.b a(DataCenter r4) {
        IRoomContextService r0 = k.f(IRoomContextService.class);
        ViewModel r1 = null;
        if (r0 == null) goto L9;
        r r5 = r0.getRoomExpService(r4, 0);
        if (r5 == null) goto L9;
        j r6 = r5.s();
        if (r6 == null) goto L9;
        ViewModel r7 = (ViewModel) r6.getValue();
    L11:
        if ((r7 instanceof w71.b) == false) goto L15;
        r1 = r7;
    L15:
        return (w71.b) r1;
    L9:
        r7 = null;
        goto L11
    }

    public static w71.a b(DataCenter r4) {
        IRoomContextService r0 = k.f(IRoomContextService.class);
        ViewModel r1 = null;
        if (r0 == null) goto L9;
        r r5 = r0.getRoomExpService(r4, 0);
        if (r5 == null) goto L9;
        j r6 = r5.s();
        if (r6 == null) goto L9;
        ViewModel r7 = (ViewModel) r6.getValue();
    L11:
        if ((r7 instanceof w71.a) == false) goto L15;
        r1 = r7;
    L15:
        return (w71.a) r1;
    L9:
        r7 = null;
        goto L11
    }

    public static final r d(DataContext r1) {
        Intrinsics.checkNotNullParameter(r1, "dataContext");
        IRoomContextService r0 = k.f(IRoomContextService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRoomExpService(r1);
    }

    public static /* synthetic */ r e(DataCenter r2) {
        return c(r2, 0);
    }

    public static final o g(DataContext r1) {
        Intrinsics.checkNotNullParameter(r1, "dataContext");
        IRoomContextService r0 = k.f(IRoomContextService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRoomDataContext(r1);
    }

    public static final r c(DataCenter r1, long r2) {
        IRoomContextService r0 = k.f(IRoomContextService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRoomExpService(r1, r2);
    }

    public static final o f(DataCenter r1, long r2) {
        IRoomContextService r0 = k.f(IRoomContextService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRoomDataContext(r1, r2);
    }

    public static /* synthetic */ o h(DataCenter r2, int r3) {
        if ((r3 & 1) == 0) goto L6;
        r2 = null;
    L6:
        return f(r2, 0);
    }
}
