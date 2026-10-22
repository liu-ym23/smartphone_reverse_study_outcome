package oc;

import android.util.Log;
import android.view.View;
import com.obric.oui.push.NotificationLabel;
import he.i;
import o0.c;
import xd.g;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends c.AbstractC0128c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9773d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f9774e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ NotificationLabel f9775f;

    public a(NotificationLabel r8) {
        this.f9775f = r8;
        this.f9770a = -1;
        this.f9771b = -1;
    }

    @Override // o0.c.AbstractC0128c
    public final int a(View r8, int r10) {
        i.f(r8, "child");
        return r8.getLeft();
    }

    @Override // o0.c.AbstractC0128c
    public final int b(View r8, int r10, int r11) {
        i.f(r8, "child");
        float r12 = r8.getTop();
        float r13 = r11;
        if (r11 >= 0) goto L5;
        float r14 = 2.0f;
    L7:
        return (int) ((r13 / r14) + r12);
    L5:
        r14 = 10.0f;
        goto L7
    }

    @Override // o0.c.AbstractC0128c
    public final void e(View r8, int r10) {
        i.f(r8, "capturedChild");
        this.f9771b = r10;
        this.f9773d = r8.getTop();
        this.f9772c = r8.getLeft();
        this.f9774e = System.currentTimeMillis();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // o0.c.AbstractC0128c
    public final void h(View r10, float r11, float r12) {
        i.f(r10, "child");
        long r8 = System.currentTimeMillis() - this.f9774e;
        Integer r13 = Integer.valueOf(this.f9773d);
        Integer r14 = Integer.valueOf(this.f9772c);
        Integer r15 = Integer.valueOf(r10.getTop());
        double r16 = 2.0f;
        float r17 = (float) Math.sqrt(((float) Math.pow(r14.intValue() - Integer.valueOf(r10.getLeft()).intValue(), r16)) + ((float) Math.pow(r13.intValue() - r15.intValue(), r16)));
        NotificationLabel r18 = this.f9775f;
        c r19 = r18.getViewDragHelper();
        if (r19 == null) goto L5;
        int r20 = r19.f9589b;
    L7:
        if (r17 < r20) goto L9;
    L13:
        this.f9771b = this.f9770a;
        int r110 = r10.getHeight();
        float r21 = 0;
        if (r12 <= r21) goto L17;
    L27:
        boolean r111 = false;
    L28:
        if (r111 == false) goto L31;
        Log.i(r18.getTAG(), "should dismiss");
        g r22 = new g(Integer.valueOf(-r110), Boolean.TRUE, Boolean.FALSE);
    L34:
        int r112 = ((Number) r22.f13874a).intValue();
        boolean r113 = ((Boolean) r22.f13875b).booleanValue();
        boolean r23 = ((Boolean) r22.f13876m).booleanValue();
        r18.setDismissSettling(r113);
        r18.setOpenSettling(r23);
        c r24 = r18.getViewDragHelper();
        if (r24 != null) goto L37;
    L38:
        r18.setOpenSettling(false);
        r18.setDismissSettling(false);
    L39:
        r18.invalidate();
        return;
    L37:
        if (r24.q(this.f9772c, r112) == true) goto L39;
    L31:
        if (r10.getTop() > this.f9773d) goto L33;
        Log.i(r18.getTAG(), "should move to origin position");
        Integer r114 = Integer.valueOf(this.f9773d);
        Boolean r115 = Boolean.FALSE;
        r22 = new g(r114, r115, r115);
        goto L34
    L33:
        Log.i(r18.getTAG(), "should do something");
        r22 = new g(Integer.valueOf(this.f9773d), Boolean.FALSE, Boolean.TRUE);
        goto L34
    L17:
        if (r12 < r21) goto L19;
        int r116 = r10.getTop() - this.f9773d;
        if (r116 > 0) goto L27;
        if (Math.abs(r116) < android.aimedia.a.a("Resources.getSystem()", 1, 30)) goto L27;
    L26:
        r111 = true;
        goto L28
    L19:
        if (r12 >= (-50)) goto L27;
    L9:
        if (r8 >= 300) goto L13;
        View.OnClickListener r117 = r18.f6499w;
        if (r117 == null) goto L13;
        r117.onClick(r18);
        goto L13
    L5:
        r20 = android.aimedia.a.a("Resources.getSystem()", 1, 15);
        goto L7
    }

    @Override // o0.c.AbstractC0128c
    public final boolean i(View r8, int r10) {
        i.f(r8, "child");
        int r11 = this.f9771b;
        if (r11 == this.f9770a) goto L7;
        if (r10 == r11) goto L7;
        return false;
    L7:
        return true;
    }
}
