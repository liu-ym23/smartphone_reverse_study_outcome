package fc;

import com.bytedance.lynx.service.monitor.LynxMonitorService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f16889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f16890c;

    public a(String r5, String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r5, LynxMonitorService.KEY_CHANNEL);
        Intrinsics.checkNotNullParameter(r10, "bundlePath");
        this.f16888a = r5;
        this.f16889b = r10;
        this.f16890c = r11;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r10 = (a) r5;
        if (Intrinsics.areEqual(this.f16888a, r10.f16888a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f16889b, r10.f16889b) == true) goto L15;
        return false;
    L15:
        if (this.f16890c == r10.f16890c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f16888a.hashCode() * 31;
        int r10 = kk.a.b(this.f16889b, r5, 31);
        return Boolean.hashCode(this.f16890c) + r10;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("RLChannelBundleModel(channel=");
        r5.append(this.f16888a);
        r5.append(", bundlePath=");
        r5.append(this.f16889b);
        r5.append(", valid=");
        return androidx.constraintlayout.motion.widget.a.w(r5, this.f16890c, ')');
    }
}
