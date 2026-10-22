package y81;

import android.view.View;
import com.bytedance.android.live.base.model.message.m5;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends c {
    public static final /* synthetic */ int O = 0;
    public final Integer N;

    /* JADX INFO: renamed from: y81.a$a, reason: collision with other inner class name */
    public static final class C0349a {
    }

    static {
    }

    @Override // y81.b, u81.d
    public final Integer b() {
        return this.N;
    }

    @Override // y81.c, u81.d
    public final void g(w81.a r7) {
        Long r0 = null;
        if (r7 == null) goto L5;
        tlc.d r1 = r7.a;
    L7:
        if ((r1 instanceof m5) == true) goto L9;
        r1 = null;
    L9:
        m5 r2 = (m5) r1;
        StringBuilder r3 = new StringBuilder("process holder binding, status: ");
        if (r2 == null) goto L12;
        r0 = r2.getStatus();
    L12:
        r3.append(r0);
        r3.append(", curStatus: ");
        r3.append(this.l);
        r3.append(", showStatus: ");
        r3.append(this.k);
        ALogger.d("AnchorTrafficSupportHolder", r3.toString());
        if (r2 != null) goto L15;
        return;
    L15:
        Boolean r8 = r7.b;
        if (r8 == null) goto L18;
        boolean r9 = r8.booleanValue();
    L19:
        this.c = r9;
        Long r10 = r2.getStatus();
        if (r10 != null) goto L22;
    L32:
        Long r12 = r2.getStatus();
        if (r12 != null) goto L35;
    L44:
        Long r13 = r2.getStatus();
        int r4 = 0;
        if (r13 != null) goto L47;
    L60:
        i(0);
        return;
    L47:
        if (((int) r13.longValue()) != 1) goto L60;
        if (this.k != 1) goto L60;
        Long r14 = r2.getNumber();
        if (r14 == null) goto L54;
        this.m = (int) r14.longValue();
    L54:
        if (this.l != 2) goto L56;
        this.l = 1;
        p();
    L56:
        Long r15 = r2.getNumber();
        if (r15 == null) goto L59;
        r4 = (int) r15.longValue();
    L59:
        n(r4);
        this.l = 1;
        return;
    L35:
        if (((int) r12.longValue()) != 2) goto L44;
        if (this.k != 1) goto L44;
        this.l = 2;
        Long r16 = r2.getNumber();
        if (r16 == null) goto L43;
        int r17 = (int) r16.longValue();
        if (r17 <= this.m) goto L43;
        this.m = r17;
    L43:
        n(this.m);
        l();
        return;
    L22:
        if (((int) r10.longValue()) != 1) goto L32;
        if (this.k != 0) goto L32;
        if (this.o == true) goto L32;
        this.l = 1;
        m();
        Long r18 = r2.getNumber();
        if (r18 == null) goto L62;
        int r19 = (int) r18.longValue();
        if (r19 <= 0) goto L63;
        this.m = r19;
        return;
    L63:
        return;
    L62:
        return;
    L18:
        r9 = true;
        goto L19
    L5:
        r1 = null;
        goto L7
    }

    public a(DataCenter r2, View r3, int r4, View r5, Integer r6) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "itemView");
        Intrinsics.checkNotNullParameter(r5, "parentView");
        super(r2, r3, r4, r5);
        this.N = r6;
    }
}
