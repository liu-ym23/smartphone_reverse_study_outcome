package qn0;

import com.bytedance.android.live.multilink.layoutconfig.model.LayoutConfigModel;
import com.bytedance.android.live.multilink.layoutconfig.resource.producer.ProducerResStep;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import sn0.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements l, sn0.a {
    public sn0.a a;
    public final ProducerResStep b;
    public final k.a c;
    public final l d;

    /* JADX INFO: renamed from: qn0.a$a, reason: collision with other inner class name */
    public interface InterfaceC0260a {
        void a(LayoutConfigModel r1);

        void onFailed(Throwable r1);
    }

    public interface b {
        void onFailed();

        void onSuccess();
    }

    public a(k.a r2, l r3) {
        Intrinsics.checkNotNullParameter(r2, "createConfig");
        this.c = r2;
        this.d = r3;
        this.b = ProducerResStep.GeckoOffline;
    }

    @Override // sn0.a
    public final void c(pn0.d r6, pn0.g r7) {
        Intrinsics.checkNotNullParameter(r6, "request");
        Intrinsics.checkNotNullParameter(r7, "modifiedRequestParams");
        boolean r0 = this.c.c.d().c;
        boolean r1 = this.c.c.d().d.contains(String.valueOf(r6.g()));
        if (r0 == false) goto L9;
        if (r1 == true) goto L9;
        HashMap<String, HashMap<String, String>> r2 = this.c.a;
        c r3 = new c(this, r6, r7);
        if (r2.isEmpty() == false) goto L8;
        qn0.b r4 = new qn0.b(this, r6, r7, r3);
        this.c.c.c().a(this.c.c.a() + "offset/entrance.json", new d(this, r6, r4));
        return;
    L8:
        f(r6, r7, r3);
        return;
    L9:
        d(r6.e(), "geckoOfflineProducer is banned by setting!!! ui_layout = " + r6.g() + ", geckoOfflineEnable = " + r0 + ", isDisableUILayout = " + r1 + ", disableUILayoutList = " + this.c.c.d().d);
        sn0.a r5 = this.a;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L12:
        r5.c(r6, r7);
    }

    public final void d(pn0.d.a r3, String r4) {
        StringBuilder r5 = r3.a;
        r5.append("\n");
        r5.append("OffsetLayoutConfig step: " + this.b + ", content: " + r4);
    }

    public final String e(List<Integer> r10, String r11) {
        if (r10 == null) goto L5;
        String r12 = CollectionsKt.joinToString$default(r10, "_", null, null, 0, null, null, 62, null);
        if (r12 == null) goto L5;
    L6:
        HashMap<String, String> r13 = this.c.a.get(r11);
        if (r13 != null) goto L11;
        return null;
    L11:
        return r13.get(r12);
    L5:
        r12 = "";
        goto L6
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

    public final void f(pn0.d r8, pn0.g r9, c r10) {
        int r0 = r8.g();
        int r1 = r9.a;
        if (r1 == 0) goto L5;
        r0 = r1;
    L5:
        List<Integer> r2 = r8.f();
        d(r8.e(), "loadGeckoOffsetLayoutLayoutConfigByUIFeature uiFeatures(from server data): " + r2);
        Map<Integer, List<Integer>> r3 = r9.c;
        boolean r4 = true;
        if (r3 != null) goto L8;
    L11:
        boolean r5 = true;
    L12:
        if (r5 == true) goto L19;
        ArrayList r6 = new ArrayList();
        List<Integer> r11 = r9.c.get(Integer.valueOf(r0));
        if (r2 == null) goto L16;
        r6.addAll(r2);
    L16:
        if (r11 == null) goto L18;
        r6.addAll(r11);
    L18:
        d(r8.e(), "loadGeckoOffsetLayoutLayoutConfigByUIFeature offsetUIFeatureList(from client inject data): " + r11);
        r2 = CollectionsKt.sorted(r6);
    L19:
        Ref.ObjectRef r12 = new Ref.ObjectRef();
        String r7 = e(r2, String.valueOf(r0));
        r12.element = r7;
        if (r7 != null) goto L33;
        ArrayList r13 = new ArrayList();
        if (r2 == null) goto L31;
        Iterator r14 = r2.iterator();
    L25:
        if (r14.hasNext() == false) goto L31;
        String r15 = this.c.b.get(String.valueOf(((Number) r14.next()).intValue()));
        if (r15 == null) goto L25;
        int r16 = CastIntegerProtector.parseInt(r15);
        if (r13.contains(Integer.valueOf(r16)) == true) goto L25;
        r13.add(Integer.valueOf(r16));
    L31:
        CollectionsKt.sort(r13);
        r12.element = e(r13, String.valueOf(r0));
        r2 = r13;
    L33:
        if (((String) r12.element) != null) goto L35;
        r12.element = e(r2, "common");
    L35:
        String r17 = (String) r12.element;
        if (r17 != null) goto L38;
    L41:
        if (r4 == false) goto L44;
        r10.onFailed(new Throwable("targetFileName is null or empty, fileName: " + ((String) r12.element)));
        return;
    L44:
        this.c.c.c().a(this.c.c.a() + "offset/" + ((String) r12.element), new e(this, r8, r10, r12));
        return;
    L38:
        if (r17.length() == 0) goto L41;
        r4 = false;
        goto L41
    L8:
        if (r3.isEmpty() == true) goto L11;
        r5 = false;
        goto L12
    }

    @Override // sn0.a
    public final void b(pn0.d r3, pn0.g r4, LayoutConfigModel r5, ProducerResStep r6) {
        Intrinsics.checkNotNullParameter(r3, "request");
        Intrinsics.checkNotNullParameter(r4, "modifiedRequestParams");
        Intrinsics.checkNotNullParameter(r5, "layoutConfigModel");
        Intrinsics.checkNotNullParameter(r6, "step");
        sn0.a r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r0.b(r3, r4, r5, r6);
    }
}
