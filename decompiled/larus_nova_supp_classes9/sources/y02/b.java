package y02;

import com.bytedance.android.livesdk.gift.platform.core.utils.recorder.ErrorNo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class b<T> implements f<T> {
    public final List<e> a;
    public String b;

    public final void e() {
        if (((ArrayList) this.a).size() != 0) goto L5;
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a r0 = com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d;
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.d r2 = new com.bytedance.android.livesdk.gift.platform.core.utils.recorder.d(ErrorNo.NO_CONSUMER, this.b + " no consumer");
        r0.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.a("110", this + " triggerNewMessageArrived mListeners.size = 0", "-1", r2);
    L5:
        Iterator r1 = ((ArrayList) this.a).iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((e) r1.next()).b();
        goto L7
    }

    public b() {
        this.a = new ArrayList();
        this.b = "BaseMsgQueue";
    }

    @Override // y02.f
    public final void c(com.bytedance.android.livesdk.gift.platform.business.tray2.manager.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (((ArrayList) this.a).contains(r2) == true) goto L6;
        ((ArrayList) this.a).add(r2);
        return;
    }
}
