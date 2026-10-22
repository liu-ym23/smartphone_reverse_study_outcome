package ptb;

import com.ss.android.lark.officesdk.experiment.LaunchExperiment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public final LaunchExperiment a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof a) == true) goto L9;
        return false;
    L9:
        if (this.a == ((a) r4).a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "OfficeSDKLaunchExperiment(launchExperiment=" + this.a + ')';
    }

    public a() {
        this(LaunchExperiment.LAUNCH_ALL_AFTER);
    }

    public a(LaunchExperiment r2) {
        Intrinsics.checkNotNullParameter(r2, "launchExperiment");
        this.a = r2;
    }
}
