package x92;

import android.os.SystemClock;
import android.view.View;
import com.bytedance.android.live.base.model.message.b4;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.l;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.m;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.pin.PublicScreenPinType;
import com.bytedance.android.livesdk.interactivity.api.settings.config.u0;
import com.bytedance.android.livesdk.interactivity.publicscreen.pin.c;
import com.bytedance.android.livesdk.interactivity.publicscreen.viewholder.RoomIntroViewHolder;
import com.bytedance.android.livesdkapi.message.HoverInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import ec2.p1;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import o72.d;
import r52.a4;
import u42.b;
import u42.e;
import u42.h;
import u42.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements b {
    public final PublicScreenPinType a;
    public Long b;
    public boolean c;
    public final boolean d;
    public f<?> e;
    public final DataCenter f;
    public final HoverInfo g;

    @Override // u42.b
    public final void b() {
        this.c = true;
    }

    @Override // u42.b
    public final int getPriority() {
        if (((u0) a4.a.getValue()).b() == false) goto L9;
        HoverInfo r0 = this.g;
        if (r0 == null) goto L7;
        long r1 = r0.priority;
    L11:
        return (int) r1;
    L7:
        r1 = 0;
        goto L11
    L9:
        return 0;
    }

    @Override // u42.b
    public final long h() {
        Long r0 = this.b;
        if (r0 == null) goto L25;
        long r2 = SystemClock.elapsedRealtime() - r0.longValue();
        if (((u0) a4.a.getValue()).b() == false) goto L22;
        HoverInfo r1 = this.g;
        long r4 = 0;
        if (r1 == null) goto L9;
        long r6 = r1.duration;
    L11:
        if (r6 > 0) goto L28;
        if (r1 == null) goto L15;
        long r7 = r1.durationInvolveDisplayTime;
    L16:
        long r8 = r7 - r2;
        if (r1 == null) goto L20;
        r4 = r1.durationThreshold;
    L20:
        if (r8 < r4) goto L25;
        return r8;
    L15:
        r7 = 0;
        goto L16
    L28:
        return r6;
    L9:
        r6 = 0;
        goto L11
    L22:
        d.a.getClass();
        p1 r3 = p1.a;
        if ((((d) r3.getValue()).b() - r2) < 3000) goto L25;
        return ((d) r3.getValue()).c();
    L25:
        return -1;
    }

    @Override // u42.b
    public final boolean a() {
        return this.c;
    }

    @Override // u42.b
    public final boolean e() {
        return this.d;
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
    public final void c(e r19) {
        Intrinsics.checkNotNullParameter(r19, "pinContext");
        u42.f.a("RoomIntroPinHandler onPin");
        b4 r2 = this.e.b;
        e52.a r4 = null;
        if ((r2 instanceof b4) == true) goto L5;
        r2 = null;
    L5:
        b4 r5 = r2;
        if (r5 != null) goto L8;
        return;
    L8:
        RoomIntroViewHolder.a r3 = RoomIntroViewHolder.w;
        View r6 = r19.b;
        g52.e r11 = r19.d;
        j<l> r7 = m.a(null);
        if (r7 == null) goto L13;
        l r8 = (l) r7.getValue();
        if (r8 == null) goto L13;
        r4 = r8.getTextConfig();
    L13:
        DataCenter r9 = this.f;
        r3.getClass();
        RoomIntroViewHolder.a.a(r5, r6, null, null, null, null, r11, false, r4, null, null, null, r9);
        long r1 = r19.a;
        d.a.getClass();
        RoomIntroViewHolder.a.d(RangesKt.coerceAtMost(r1, ((d) p1.a.getValue()).b()));
    }

    @Override // u42.b
    public final void d(f<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.e = r2;
    }

    @Override // u42.b
    public final void f(h r3) {
        Intrinsics.checkNotNullParameter(r3, "unpinContext");
        u42.f.a("RoomIntroPinHandler onUnpin. evict=" + r3.a);
        RoomIntroViewHolder.w.getClass();
        Disposable r4 = RoomIntroViewHolder.p;
        if (r4 == null) goto L5;
        r4.dispose();
    L5:
        RoomIntroViewHolder.q = false;
    }

    @Override // u42.b
    public final void g(Long r1) {
        this.b = r1;
    }

    @Override // u42.b
    public final View i(c.b r2) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.a(2131567396);
    }

    @Override // u42.b
    public final long j(i r3) {
        Intrinsics.checkNotNullParameter(r3, "updatePinContext");
        Intrinsics.checkNotNullParameter(r3, "updatePinContext");
        return 0;
    }

    public a(f<?> r2, DataCenter r3, HoverInfo r4) {
        Intrinsics.checkNotNullParameter(r2, "message");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.a = PublicScreenPinType.ROOM_INTRO;
        this.d = true;
    }
}
