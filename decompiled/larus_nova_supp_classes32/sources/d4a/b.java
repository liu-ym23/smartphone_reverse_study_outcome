package d4a;

import com.larus.audio.call.mgr.AVKitCoreStates;
import com.larus.audio.call.mgr.AVKitDuplexState;
import com.larus.audio.call.mgr.MajorState;
import com.larus.audio.call.plugins.c1;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b implements c1 {
    public static final b a = null;
    public static final MutableSharedFlow<Pair<Integer, Integer>> b = null;
    public static final MutableSharedFlow<Pair<Pair<MajorState, Integer>, Pair<MajorState, Integer>>> c = null;
    public static final StateFlowImpl d = null;

    public b() {
    }

    static {
        a = new b();
        b = SharedFlowKt.MutableSharedFlow$default(1, 1, null, 4, null);
        c = SharedFlowKt.MutableSharedFlow$default(1, 1, null, 4, null);
        d = j1.a(TuplesKt.to(new AVKitDuplexState(new AVKitCoreStates.Invalid(), new AVKitCoreStates.Invalid()), -1));
    }

    public final MutableSharedFlow W() {
        return c;
    }

    public final MutableSharedFlow i1() {
        return b;
    }

    public final i1<Pair<AVKitDuplexState, Integer>> y() {
        return d;
    }
}
