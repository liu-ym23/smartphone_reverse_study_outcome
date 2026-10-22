package z61;

import com.bytedance.android.live.room.api.messagewindow.process.MsgWindowAdjustSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b extends o70.b {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final h71.a e;
    public final MsgWindowAdjustSource f;

    public b() {
        this(false, false, false, false, new h71.a(), MsgWindowAdjustSource.UNKNOWN);
    }

    public final String toString() {
        return "MsgWindowPositionAdjustEvent(isShown=" + this.e.a + ", adjustTopMargin=" + this.a + ", adjustBottomMargin=" + this.b + ", adjustRightMargin=" + this.c + ", adjustLeftMargin=" + this.d + ", topMargin=" + this.e.b + ", bottomMargin=" + this.e.d + ", rightMargin=" + this.e.c + ", leftMargin=" + this.e.e + ", source=" + this.f.getDescription() + ')';
    }

    public b(boolean r2, boolean r3, boolean r4, boolean r5, h71.a r6, MsgWindowAdjustSource r7) {
        Intrinsics.checkNotNullParameter(r6, "adjustConfig");
        Intrinsics.checkNotNullParameter(r7, "source");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
