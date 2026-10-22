package awb;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b implements Runnable {
    public final /* synthetic */ c a;

    public b(c r1) {
        this.a = r1;
    }

    public final void a() {
        c r0 = this.a;
        CharSequence r1 = r0.a.getText();
        boolean r2 = false;
        if (r1 == null) goto L16;
        int r3 = r1.length();
        int r4 = r0.a.getSelectionStart();
        int r5 = r0.a.getSelectionEnd();
        if (r4 < 0) goto L16;
        if (r5 < 0) goto L16;
        int r6 = Math.max(0, Math.min(r4, r5));
        int r7 = Math.max(0, Math.max(r4, r5));
        if (r6 == r7) goto L16;
        if (r6 < 0) goto L16;
        if (r7 < 0) goto L16;
        if (r7 > r3) goto L16;
        String r8 = r1.subSequence(r6, r7).toString();
    L18:
        if (r8.length() != 0) goto L20;
        r2 = true;
    L20:
        if (r2 == false) goto L23;
        return;
    L23:
        if (Intrinsics.areEqual(r8, this.a.d) == true) goto L25;
    L26:
        c r9 = this.a;
        r9.d = r8;
        r9.e = System.currentTimeMillis();
        Function1<String, Unit> r10 = this.a.b.b;
        if (r10 == null) goto L31;
        r10.invoke(r8);
        return;
    L31:
        return;
    L25:
        if ((System.currentTimeMillis() - this.a.e) > 1000) goto L26;
        return;
    L16:
        r8 = "";
        goto L18
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
