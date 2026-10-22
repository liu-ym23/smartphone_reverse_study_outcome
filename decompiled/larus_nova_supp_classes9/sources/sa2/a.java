package sa2;

import android.widget.TextView;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.CleanStrategy;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.ConflictStrategy;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.DiscardReason;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.test.c;
import f52.i;
import f52.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends j<String> {
    public static int o;
    public final String n;

    /* JADX INFO: renamed from: sa2.a$a, reason: collision with other inner class name */
    public static final class C0278a {
    }

    static {
    }

    public a(c r19) {
        Intrinsics.checkNotNullParameter(r19, "event");
        String r1 = r19.a;
        if (r1 != null) goto L5;
        StringBuilder r2 = new StringBuilder("TestPSTopView_");
        int r3 = o;
        o = r3 + 1;
        r2.append(r3);
        r1 = r2.toString();
    L5:
        f52.a r4 = new f52.a(r19.b);
        long r5 = r19.d;
        int r6 = r19.e;
        int r7 = r19.f;
        Integer r8 = Integer.valueOf(r19.g);
        if (r8.intValue() <= 0) goto L8;
        boolean r9 = true;
    L9:
        if (r9 == true) goto L12;
        r8 = null;
    L12:
        if (r8 == null) goto L14;
        int r10 = r8.intValue();
    L15:
        long r11 = r19.h;
        ConflictStrategy r13 = r19.i;
        ConflictStrategy r14 = r19.j;
        ConflictStrategy r15 = r19.k;
        boolean r16 = r19.l;
        String r0 = r19.c;
        if (r0 != null) goto L18;
        r0 = "这是一个测试视图";
    L18:
        super(r1, r4, r5, r6, r7, r10, r11, r13, r14, r15, r16, null, r0, 2048);
        this.n = "id=" + this.a + " priority=" + getType().getPriority();
        return;
    L14:
        r10 = 30;
        goto L15
    L8:
        r9 = false;
        goto L9
    }

    @Override // f52.c
    public final void a(DiscardReason r3) {
        Intrinsics.checkNotNullParameter(r3, "reason");
        i.a("on TestPSTopView discard. reason=" + r3 + ". " + this.n);
    }

    @Override // f52.c
    public final void h(f52.b r3) {
        Intrinsics.checkNotNullParameter(r3, "container");
        i.a("on TestPSTopView show. " + this.n);
        ((TextView) r3.c(this).findViewById(2131367794)).setText((CharSequence) this.m);
    }

    @Override // f52.c
    public final CleanStrategy i(f52.b r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        i.a("on TestPSTopView show finish. " + this.n);
        return CleanStrategy.REMOVE_WRAP_VIEW;
    }

    @Override // f52.c
    public final CleanStrategy b(f52.b r2, f52.c r3) {
        Intrinsics.checkNotNullParameter(r2, "container");
        if (r3 == null) goto L6;
        i.a("on TestPSTopView interrupt. triggerId=" + r3.getId() + " triggerType=" + r3.getType() + ' ' + this.n + ". ");
    L6:
        return CleanStrategy.REMOVE_WRAP_VIEW;
    }
}
