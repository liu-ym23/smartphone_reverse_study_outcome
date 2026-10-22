package x98;

import com.larus.avlink.liveai.model.LiveAiEventScene;
import com.larus.avlink.n1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public int a;
    public c b;
    public final MutableSharedFlow<Integer> c;

    /* JADX INFO: renamed from: x98.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0094a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[LiveAiEventScene.values().length];
            r0[LiveAiEventScene.MANUAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[LiveAiEventScene.AUTO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public a() {
        MutableSharedFlow<Integer> r0 = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6, null);
        r0.tryEmit(Integer.valueOf(this.a));
        this.c = r0;
    }

    public final void a(b r6) {
        n1.d("DoraLiveAiMachine", "start process event " + r6);
        int r0 = r6.getType();
        boolean r1 = false;
        if (r0 == 0) goto L35;
        Boolean r2 = null;
        if (r0 != 2) goto L7;
        LiveAiEventScene r3 = r6.b;
        if (r3 != null) goto L18;
        int r4 = -1;
    L20:
        if (r4 == 1) goto L24;
        if (r4 != 2) goto L43;
        this.a = 1;
        this.c.tryEmit(1);
        return;
    L43:
        return;
    L24:
        c r5 = this.b;
        if (r5 == null) goto L27;
        r1 = r5.a(r6);
    L27:
        if (r1 == true) goto L29;
        return;
    L29:
        c r7 = this.b;
        if (r7 == null) goto L33;
        r7.c(r6);
        r2 = Boolean.TRUE;
    L33:
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L40;
        this.a = 1;
        this.c.tryEmit(1);
        return;
    L40:
        return;
    L18:
        r4 = C0094a.a[r3.ordinal()];
        goto L20
    L7:
        if (r0 != 5) goto L42;
        c r8 = this.b;
        if (r8 == null) goto L13;
        r8.b(r6);
        r2 = Boolean.FALSE;
    L13:
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L37;
        this.a = 2;
        this.c.tryEmit(2);
        return;
    L37:
        return;
    L42:
        return;
    L35:
        this.a = 0;
        this.c.tryEmit(0);
    }

    public final void b(b r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        n1.e("DoraLiveAiMachine", "receive event: " + r3);
        a(r3);
    }
}
