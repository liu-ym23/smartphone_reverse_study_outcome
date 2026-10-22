package mr1;

import com.bytedance.android.livesdk.room.data.EndReason;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import is2.g;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jm1.h;
import kotlin.jvm.internal.Intrinsics;
import ls2.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements g {
    public final List<h> a;

    public final String businessTypeV2() {
        return "VSRoomLifeCycleObserver";
    }

    public final Map<String, Object> getEnvData() {
        return null;
    }

    public final Map<String, Object> getPropertyParams() {
        return null;
    }

    public final String getSpm() {
        return null;
    }

    public final boolean isIgnored() {
        return false;
    }

    public final void onRoomBackgroundV2() {
        List<h> r0 = this.a;
        if (r0 == null) goto L8;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        ((h) r1.next()).onRoomBackgroundV2();
        goto L6
    L10:
        return;
    }

    public a(List<? extends h> r1) {
        this.a = r1;
    }

    public final void onOrientationChangeV2(int r3) {
        List<h> r0 = this.a;
        if (r0 == null) goto L8;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        ((h) r1.next()).onOrientationChangeV2(r3);
        goto L6
    L10:
        return;
    }

    public final void onRoomPrepareV2(boolean r3) {
        List<h> r0 = this.a;
        if (r0 == null) goto L8;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        ((h) r1.next()).onRoomPrepareV2(r3);
        goto L6
    L10:
        return;
    }

    public final void onRoomEnterV2(Room r3, ls2.a r4) {
        Intrinsics.checkNotNullParameter(r3, "room");
        Intrinsics.checkNotNullParameter(r4, "enterExtra");
        List<h> r0 = this.a;
        if (r0 == null) goto L8;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        ((h) r1.next()).K0(r3, r4);
        goto L6
    L10:
        return;
    }

    public final void onRoomPreloadV2(Room r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "room");
        List<h> r4 = this.a;
        if (r4 == null) goto L8;
        Iterator<T> r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        ((h) r5.next()).b(r2);
        goto L6
    L10:
        return;
    }

    public final void onRoomExitV2(long r8, String r10, boolean r11, Room r12, e r13, boolean r14, EndReason r15) {
        Intrinsics.checkNotNullParameter(r10, "userId");
        Intrinsics.checkNotNullParameter(r13, "error");
        Intrinsics.checkNotNullParameter(r15, "reason");
        List<h> r16 = this.a;
        if (r16 == null) goto L8;
        Iterator<T> r17 = r16.iterator();
    L6:
        if (r17.hasNext() == false) goto L10;
        ((h) r17.next()).a(r8, r11, r12, r14, r13);
        goto L6
    L10:
        return;
    }
}
