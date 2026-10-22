package g3a;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.av_call.model.RealtimePageMode;
import com.larus.utils.u;
import com.larus.voicecall.impl.component.content.RealtimeContentComponent;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class p implements w3a.i {
    public final /* synthetic */ RealtimeContentComponent a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RealtimePageMode.values().length];
            r0[RealtimePageMode.HALF_SCREEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[RealtimePageMode.FULL_SCREEN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public p(RealtimeContentComponent r1) {
        this.a = r1;
    }

    @Override // w3a.i
    public final void a(w3a.h r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if ((r5 instanceof w3a.a) == false) goto L17;
        RealtimePageMode r6 = ((w3a.a) r5).a;
        int r7 = a.a[r6.ordinal()];
        if (r7 != 1) goto L7;
        int r8 = u.b(RealtimeContentComponent.h3(this.a));
        ConstraintLayout r0 = this.a.s.a.findViewById(2131383805);
        if (r0 == null) goto L20;
        r0.setPadding(0, 0, 0, r8);
        return;
    L20:
        return;
    L7:
        if (r7 != 2) goto L12;
        int r9 = u.c(RealtimeContentComponent.h3(this.a));
        int r1 = u.b(RealtimeContentComponent.h3(this.a));
        ConstraintLayout r2 = this.a.s.a.findViewById(2131383805);
        if (r2 == null) goto L18;
        r2.setPadding(0, r9, 0, r1);
        return;
    L18:
        return;
    L12:
        throw new NoWhenBranchMatchedException();
    }
}
