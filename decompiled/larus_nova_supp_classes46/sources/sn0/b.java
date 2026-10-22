package sn0;

import com.bytedance.android.live.multilink.layoutconfig.model.LayoutConfigModel;
import com.bytedance.android.live.multilink.layoutconfig.resource.producer.ProducerResStep;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements l, sn0.a {
    public sn0.a a;
    public final ProducerResStep b;
    public final n.a c;
    public final l d;

    public interface a {
        void a(LayoutConfigModel r1);

        void onFailed(Throwable r1);
    }

    /* JADX INFO: renamed from: sn0.b$b, reason: collision with other inner class name */
    public interface InterfaceC0274b {
        void onFailed();

        void onSuccess();
    }

    public b(n.a r2, l r3) {
        Intrinsics.checkNotNullParameter(r2, "createConfig");
        this.c = r2;
        this.d = r3;
        this.b = ProducerResStep.GeckoOffline;
    }

    @Override // sn0.a
    public final void c(pn0.d r6, pn0.g r7) {
        Intrinsics.checkNotNullParameter(r6, "request");
        Intrinsics.checkNotNullParameter(r7, "modifiedRequestParams");
        boolean r0 = this.c.b.d().c;
        boolean r1 = this.c.b.d().d.contains(String.valueOf(r6.g()));
        if (r0 == false) goto L9;
        if (r1 == true) goto L9;
        List<pn0.a> r2 = this.c.a;
        f r3 = new f(this, r6, r7);
        if (r2.isEmpty() == false) goto L8;
        e r4 = new e(this, r6, r7, r3);
        System.currentTimeMillis();
        this.c.b.c().a(this.c.b.a() + "entrance.json", new d(this, r6, r4));
        return;
    L8:
        e(r6, r7, r3);
        return;
    L9:
        d(r6.e(), "geckoOfflineProducer is banned by setting!!! ui_layout = " + r6.g() + ", geckoOfflineEnable = " + r0 + ", isDisableUILayout = " + r1 + ", disableUILayoutList = " + this.c.b.d().d);
        sn0.a r5 = this.a;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L12:
        r5.c(r6, r7);
    }

    public final void d(pn0.d.a r3, String r4) {
        StringBuilder r5 = r3.a;
        r5.append("\n");
        r5.append("step: " + this.b + ", content: " + r4);
    }

    @Override // sn0.l
    public final void a(pn0.d r2, pn0.g r3, sn0.a r4) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "modifiedRequestParams");
        Intrinsics.checkNotNullParameter(r4, "consumer");
        this.a = r4;
        l r5 = this.d;
        if (r5 == null) goto L6;
        r5.a(r2, r3, this);
        return;
    }

    public final void e(pn0.d r10, pn0.g r11, f r12) {
        int r0 = r10.g();
        int r1 = r11.b;
        int r13 = r11.a;
        if (r13 == 0) goto L5;
        r0 = r13;
    L5:
        Iterator<T> r14 = this.c.a.iterator();
    L6:
        boolean r3 = false;
        String r5 = null;
        if (r14.hasNext() == false) goto L22;
        Object r2 = r14.next();
        pn0.a r6 = (pn0.a) r2;
        if (r6.d() == r0) goto L11;
    L19:
        boolean r7 = false;
    L20:
        if (r7 == false) goto L6;
    L23:
        pn0.a r4 = (pn0.a) r2;
        if (r4 == null) goto L26;
        r5 = r4.b();
    L26:
        if (r5 != null) goto L28;
    L29:
        r3 = true;
    L30:
        if (r3 == false) goto L33;
        r12.onFailed(new Throwable("targetFileName is null or empty, fileName: " + r5 + ", reviewList: " + this.c.a));
        return;
    L33:
        this.c.b.c().a(this.c.b.a() + r5, new c(this, r10, r12, r5));
        return;
    L28:
        if (r5.length() != 0) goto L30;
    L11:
        if (r6.c() == 0) goto L15;
        if (r6.c() != r1) goto L19;
    L15:
        if (Intrinsics.areEqual(r6.a(), "") == false) goto L17;
    L18:
        r7 = true;
        goto L20
    L17:
        if (Intrinsics.areEqual(r6.a(), "android") == false) goto L19;
    L22:
        r2 = null;
        goto L23
    }

    @Override // sn0.a
    public final void b(pn0.d r3, pn0.g r4, LayoutConfigModel r5, ProducerResStep r6) {
        Intrinsics.checkNotNullParameter(r3, "request");
        Intrinsics.checkNotNullParameter(r4, "modifiedRequestParams");
        Intrinsics.checkNotNullParameter(r5, "layoutConfig");
        Intrinsics.checkNotNullParameter(r6, "step");
        sn0.a r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r0.b(r3, r4, r5, r6);
    }
}
