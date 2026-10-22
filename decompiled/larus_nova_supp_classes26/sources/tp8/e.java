package tp8;

import com.larus.bmhome.inputarea.InputAreaBlockComponent;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class e implements f {
    public final /* synthetic */ int a;
    public final /* synthetic */ InputAreaBlockComponent b;
    public final /* synthetic */ AtomicBoolean c;

    public /* synthetic */ e(int r1, InputAreaBlockComponent r2, AtomicBoolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // tp8.f
    public final boolean finish(String r9) {
        int r0 = this.a;
        InputAreaBlockComponent r1 = this.b;
        AtomicBoolean r2 = this.c;
        int r3 = InputAreaBlockComponent.u;
        Intrinsics.checkNotNullParameter(r9, "reason");
        if (r0 == r1.t) goto L6;
        FLogger.a.d("InputAreaBlockComponent", "[finish] drop stale result, callbackGeneration=" + r0 + ", currentGeneration=" + r1.t + ", reason=" + r9);
        return false;
    L6:
        if (r2.compareAndSet(false, true) == true) goto L8;
        FLogger.a.d("InputAreaBlockComponent", "[finish] drop duplicate result, generation=" + r0 + ", reason=" + r9);
        return false;
    L8:
        r1.g0(r9);
        return true;
    }
}
