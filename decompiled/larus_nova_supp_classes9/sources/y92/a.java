package y92;

import android.os.SystemClock;
import android.view.View;
import com.bytedance.android.live.base.model.message.d4;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.pin.PublicScreenPinType;
import com.bytedance.android.livesdk.interactivity.publicscreen.pin.c;
import com.bytedance.android.livesdk.interactivity.publicscreen.viewholder.RoomNoticeViewHolder;
import com.bytedance.android.livesdk.interactivity.textmessage.model.c0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import u42.b;
import u42.e;
import u42.h;
import u42.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements b {
    public final PublicScreenPinType a;
    public Long b;
    public boolean c;
    public final long d;
    public f<?> e;

    @Override // u42.b
    public final void b() {
        this.c = true;
    }

    @Override // u42.b
    public final boolean e() {
        return false;
    }

    @Override // u42.b
    public final int getPriority() {
        return 0;
    }

    @Override // u42.b
    public final long h() {
        d4 r0 = this.e.b;
        if ((r0 instanceof d4) == true) goto L5;
        r0 = null;
    L5:
        d4 r1 = r0;
        if (r1 != null) goto L8;
        return -1;
    L8:
        Long r3 = this.b;
        if (r3 == null) goto L14;
        long r5 = RangesKt.coerceAtLeast(r1.i(), 30000) - (SystemClock.elapsedRealtime() - r3.longValue());
        if (r5 >= 3000) goto L13;
        return -1;
    L13:
        return r5;
    L14:
        return -1;
    }

    @Override // u42.b
    public final boolean a() {
        return this.c;
    }

    @Override // u42.b
    public final f<?> getMessage() {
        return this.e;
    }

    @Override // u42.b
    public final Long getShowTimestamp() {
        return this.b;
    }

    @Override // u42.b
    public PublicScreenPinType getType() {
        return this.a;
    }

    @Override // u42.b
    public final void c(e r6) {
        Intrinsics.checkNotNullParameter(r6, "pinContext");
        u42.f.a("RoomNoticePinHandler onPin");
        d4 r0 = this.e.b;
        if ((r0 instanceof d4) == true) goto L5;
        r0 = null;
    L5:
        d4 r1 = r0;
        if (r1 != null) goto L8;
        return;
    L8:
        View r2 = r6.b;
        boolean r3 = a0.d(r6.c, false);
        int r4 = RoomNoticeViewHolder.d;
        RoomNoticeViewHolder.a.a(r1, r2, r3, r6.d, false);
    }

    @Override // u42.b
    public final void d(f<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.e = r2;
    }

    @Override // u42.b
    public final void f(h r2) {
        Intrinsics.checkNotNullParameter(r2, "unpinContext");
        u42.f.a("RoomNoticePinHandler onUnpin");
    }

    @Override // u42.b
    public final void g(Long r1) {
        this.b = r1;
    }

    @Override // u42.b
    public final View i(c.b r2) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        int r0 = RoomNoticeViewHolder.d;
        return r2.a(2131567397);
    }

    @Override // u42.b
    public final long j(i r6) {
        Intrinsics.checkNotNullParameter(r6, "updatePinContext");
        u42.f.a("RoomNoticePinHandler onUpdate");
        View r0 = r6.b;
        f<?> r1 = r6.a;
        if ((r1 instanceof c0) == false) goto L5;
        boolean r2 = a0.d(r6.c, false);
        int r3 = RoomNoticeViewHolder.d;
        c0 r4 = (c0) r1;
        RoomNoticeViewHolder.a.a(r4.b, r0, r2, r6.d, true);
        return RangesKt.coerceAtLeast(r4.b.i(), 3000);
    L5:
        return 0;
    }

    public a(long r2, f<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "message");
        this.d = r2;
        this.e = r4;
        this.a = PublicScreenPinType.ROOM_NOTICE;
    }
}
