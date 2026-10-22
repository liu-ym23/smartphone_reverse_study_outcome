package qa;

import com.bytedance.android.anniex.lite.flow.base.c;
import java.util.Map;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b extends c {
    public final StateFlowImpl b;
    public final b1 c;
    public final b1 d;
    public final StateFlowImpl e;
    public final MutableSharedFlow<Map<String, Object>> f;

    public b() {
        StateFlowImpl r1 = j1.a(null);
        this.b = r1;
        this.c = e.b(r1);
        this.d = e.b(j1.a(null));
        StateFlowImpl r10 = j1.a(null);
        this.e = r10;
        e.b(r10);
        MutableSharedFlow<Map<String, Object>> r0 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.f = r0;
        e.a(r0);
    }
}
