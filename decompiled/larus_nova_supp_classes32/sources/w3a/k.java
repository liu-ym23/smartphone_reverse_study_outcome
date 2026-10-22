package w3a;

import com.larus.av_call.constant.ThemeType;
import com.larus.av_call.databinding.LarusFragmentInstantCallBaseBinding;
import com.larus.av_call.model.RealtimePageMode;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class k implements t1a.c {
    public static final /* synthetic */ int g = 0;
    public final e3a.b a;
    public final e3a.a b;
    public LarusFragmentInstantCallBaseBinding c;
    public g d;
    public final CopyOnWriteArrayList<i> e;
    public int f;

    public static final class a {
    }

    static {
    }

    public final void a(g r4) {
        Intrinsics.checkNotNullParameter(r4, "newState");
        LarusFragmentInstantCallBaseBinding r0 = this.c;
        if (r0 == null) goto L6;
        this.d.a(r0, this.b);
        this.d = r4;
        r4.b(r0);
        return;
    }

    public final void c(i r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.e.add(r2);
    }

    @Deprecated(message = "please add business func， like onRealtimeScaleModeChange(), do not call triggerEvent() directly")
    public final void d(h r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        Iterator<i> r0 = this.e.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().a(r3);
        goto L4
    }

    public k(e3a.b r2, e3a.a r3) {
        Intrinsics.checkNotNullParameter(r2, "runtimeData");
        Intrinsics.checkNotNullParameter(r3, "argumentData");
        this.a = r2;
        this.b = r3;
        this.d = b.a;
        this.e = new CopyOnWriteArrayList();
    }

    public final void b(RealtimePageMode r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "realtimePageMode");
        e3a.b r0 = this.a;
        if (((h88.b) r0).i != ThemeType.IMMERS_BOT) goto L7;
        FLogger.a.i("RealtimeCallViewStateManager", "onRealtimeScaleModeChange ThemeType.IMMERS_BOT not support half page");
        return;
    L7:
        if (this.b.x1 == true) goto L17;
        if (r5 != RealtimePageMode.HALF_SCREEN) goto L17;
        if (AppHost.a.isDebug() == true) goto L15;
        FLogger.a.e("RealtimeCallViewStateManager", "onRealtimeScaleModeChange RealtimePageMode:" + r5 + ", but not support half page");
        return;
    L15:
        throw new RuntimeException("current not support half page");
    L17:
        if (((h88.b) r0).u == r5) goto L19;
    L22:
        r0.getClass();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        ((h88.b) r0).u = r5;
        this.f = r6;
        d(new w3a.a(r5, r6));
        return;
    L19:
        if (r6 != this.f) goto L22;
        FLogger.a.e("RealtimeCallViewStateManager", "onRealtimeScaleModeChange RealtimePageMode:" + r5 + " lastPaddingTop=" + this.f);
    }
}
