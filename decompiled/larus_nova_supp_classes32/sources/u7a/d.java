package u7a;

import com.lynx.tasm.LynxView;
import com.lynx.tasm.behavior.LynxContext;
import i8a.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ LynxContext a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ String e;
    public final /* synthetic */ int f;
    public final /* synthetic */ int g;
    public final /* synthetic */ boolean h;

    public /* synthetic */ d(LynxContext r1, long r2, long r4, boolean r6, String r7, int r8, int r9, boolean r10) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LynxContext r0 = this.a;
        long r1 = this.b;
        long r3 = this.c;
        boolean r5 = this.d;
        String r6 = this.e;
        int r7 = this.f;
        int r8 = this.g;
        boolean r9 = this.h;
        if (r0 == null) goto L5;
        LynxView r2 = r0.getLynxView();
    L6:
        if (r2 == null) goto L13;
        i8a.d r10 = (i8a.d) n.c().a(i8a.d.class);
        if (r10 == null) goto L14;
        i8a.j.a r11 = new i8a.j.a();
        r11.a = r1;
        r11.b = r3;
        r11.c = r5;
        r11.d = r6;
        r11.e = r7;
        r11.f = r8;
        r11.g = r2;
        r11.h = r9;
        r10.reportImageInfo(new i8a.j(r11));
        return;
    L14:
        return;
    L13:
        return;
    L5:
        r2 = null;
        goto L6
    }
}
