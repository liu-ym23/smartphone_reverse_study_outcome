package ra2;

import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui.ConfrontMsgView;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui.GroupMsgView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i implements qa2.l {
    public final /* synthetic */ ConfrontMsgView a;

    @Override // qa2.l
    public final void a() {
        GroupMsgView r0 = this.a.b;
        Boolean r1 = null;
        if (r0 == null) goto L5;
        Boolean r2 = r0.getImgLoadStatus();
    L6:
        Boolean r3 = Boolean.FALSE;
        if (Intrinsics.areEqual(r2, r3) == true) goto L13;
        GroupMsgView r4 = this.a.c;
        if (r4 == null) goto L12;
        r1 = r4.getImgLoadStatus();
    L12:
        if (Intrinsics.areEqual(r1, r3) == true) goto L13;
        return;
    L13:
        pa2.a r5 = this.a.d;
        if (r5 == null) goto L18;
        r5.a();
        return;
    L18:
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // qa2.l
    public final void b() {
        GroupMsgView r0 = this.a.b;
        Boolean r1 = null;
        if (r0 == null) goto L5;
        Boolean r2 = r0.getImgLoadStatus();
    L6:
        Boolean r3 = Boolean.TRUE;
        if (Intrinsics.areEqual(r2, r3) == false) goto L17;
        GroupMsgView r4 = this.a.c;
        if (r4 == null) goto L12;
        r1 = r4.getImgLoadStatus();
    L12:
        if (Intrinsics.areEqual(r1, r3) == false) goto L18;
        pa2.a r5 = this.a.d;
        if (r5 == null) goto L19;
        r5.b();
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // qa2.l
    public final void c() {
        GroupMsgView r0 = this.a.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getBattleEnd() != true) goto L40;
        GroupMsgView r1 = this.a.c;
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.getBattleEnd() != true) goto L42;
        GroupMsgView r2 = this.a.b;
        if (r2 == null) goto L13;
        r2.setBattleEnd(false);
    L13:
        GroupMsgView r3 = this.a.c;
        if (r3 == null) goto L16;
        r3.setBattleEnd(false);
    L16:
        ConfrontMsgView r4 = this.a;
        int r5 = r4.q;
        if (r5 != r4.n) goto L26;
        GroupMsgView r6 = r4.b;
        if (r6 == null) goto L21;
        r6.n();
    L21:
        GroupMsgView r7 = this.a.c;
        if (r7 == null) goto L24;
        r7.n();
    L24:
        this.a.getClass();
        return;
    L26:
        if (r5 != r4.p) goto L33;
        GroupMsgView r8 = r4.b;
        if (r8 == null) goto L30;
        r8.i();
    L30:
        GroupMsgView r9 = this.a.c;
        if (r9 == null) goto L44;
        r9.i();
        return;
    L44:
        return;
    L33:
        if (r5 != 0) goto L36;
        r4.post(r4.h);
        return;
    L36:
        if (r5 != r4.o) goto L47;
        r4.post(r4.i);
        return;
    L47:
        return;
    L42:
        return;
    }

    @Override // qa2.l
    public final void d() {
        GroupMsgView r0 = this.a.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getWebpEntered() != true) goto L13;
        GroupMsgView r1 = this.a.c;
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.getWebpEntered() != true) goto L15;
        ConfrontMsgView r2 = this.a;
        r2.q = r2.o;
        r2.post(r2.i);
        return;
    L15:
        return;
    }

    @Override // qa2.l
    public final void e() {
        GroupMsgView r0 = this.a.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getEntered() != true) goto L13;
        GroupMsgView r1 = this.a.c;
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.getEntered() != true) goto L15;
        ConfrontMsgView r2 = this.a;
        r2.post(r2.h);
        return;
    L15:
        return;
    }

    @Override // qa2.l
    public final void onEnd() {
        ConfrontMsgView r0 = this.a;
        GroupMsgView r1 = r0.b;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.getDismissed() != true) goto L15;
        GroupMsgView r2 = r0.c;
        if (r2 != null) goto L9;
        return;
    L9:
        if (r2.getDismissed() != true) goto L17;
        pa2.a r3 = r0.d;
        if (r3 == null) goto L18;
        r3.onDismiss();
        return;
    L18:
        return;
    L17:
        return;
    }

    public i(ConfrontMsgView r1) {
        this.a = r1;
    }
}
