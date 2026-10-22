package gb2;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;
import vh7.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final IRoom a = null;

    static {
        a = f.c(IRoom.class);
    }

    public static /* synthetic */ boolean b(DataCenter r1) {
        return a(r1, false);
    }

    public static /* synthetic */ boolean d(DataCenter r1) {
        return c(r1, true);
    }

    public static final IRoom e(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$room");
        return (IRoom) r2.get("data_room", a);
    }

    public static final boolean a(DataCenter r2, boolean r3) {
        Boolean r4 = Boolean.valueOf(r3);
        if (r2 == null) goto L14;
        Object r1 = null;
        Object r5 = r2.get("data_is_anchor", null);
        if ((r5 instanceof Boolean) == false) goto L9;
        r1 = r5;
    L9:
        Boolean r6 = (Boolean) r1;
        if (r6 == null) goto L14;
        r4 = r6;
    L14:
        return r4.booleanValue();
    }

    public static final boolean c(DataCenter r2, boolean r3) {
        Boolean r4 = Boolean.valueOf(r3);
        if (r2 == null) goto L14;
        Object r1 = null;
        Object r5 = r2.get("data_is_portrait", null);
        if ((r5 instanceof Boolean) == false) goto L9;
        r1 = r5;
    L9:
        Boolean r6 = (Boolean) r1;
        if (r6 == null) goto L14;
        r4 = r6;
    L14:
        return r4.booleanValue();
    }
}
