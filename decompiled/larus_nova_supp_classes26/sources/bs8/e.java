package bs8;

import com.larus.bmhome.taskskill.model.PcDevice;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e {
    public final List<PcDevice> a;
    public final List<PcDevice> b;

    public e() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "GroupedDeviceCollection(availableDevices=" + this.a + ", notAvailableDevices=" + this.b + ')';
    }

    public final List<PcDevice> a() {
        return CollectionsKt.plus(this.a, this.b);
    }

    public /* synthetic */ e(int r2) {
        this(CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }

    public e(List<PcDevice> r2, List<PcDevice> r3) {
        Intrinsics.checkNotNullParameter(r2, "availableDevices");
        Intrinsics.checkNotNullParameter(r3, "notAvailableDevices");
        this.a = r2;
        this.b = r3;
    }
}
