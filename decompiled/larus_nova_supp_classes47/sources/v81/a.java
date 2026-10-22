package v81;

import com.bytedance.android.live.room.incentiveinfo.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import u81.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class a implements f {
    public final List<f.a> a;

    @Override // u81.f
    public final int a() {
        return ((ArrayList) this.a).size();
    }

    public a() {
        this.a = new ArrayList();
    }

    @Override // u81.f
    public final boolean b(f.a r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        Iterator r0 = ((ArrayList) this.a).iterator();
        if (r0.hasNext() == true) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual((f.a) r0.next(), r3) == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // u81.f
    public final boolean c(f.a r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        List<f.a> r0 = this.a;
        if (r0 != null) goto L5;
    L13:
        return false;
    L5:
        if (((ArrayList) r0).isEmpty() == true) goto L13;
        Iterator r1 = ((ArrayList) this.a).iterator();
    L9:
        if (r1.hasNext() == false) goto L13;
        if (Intrinsics.areEqual((f.a) r1.next(), r3) == false) goto L9;
        r1.remove();
        return true;
    }

    public final boolean d(e r5) {
        Intrinsics.checkNotNullParameter(r5, "callback");
        List<f.a> r0 = this.a;
        boolean r1 = false;
        if (r0 != null) goto L5;
        return false;
    L5:
        Iterator r2 = ((ArrayList) r0).iterator();
    L7:
        if (r2.hasNext() == false) goto L11;
        if (Intrinsics.areEqual((f.a) r2.next(), r5) == false) goto L7;
        r1 = true;
    L11:
        if (r1 == true) goto L14;
        ((ArrayList) this.a).add(r5);
    L14:
        return !r1;
    }
}
