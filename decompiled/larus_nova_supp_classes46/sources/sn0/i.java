package sn0;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.multilink.layoutconfig.model.LayoutConfigModel;
import com.bytedance.android.live.multilink.layoutconfig.resource.producer.ProducerResStep;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i implements l, sn0.a {
    public sn0.a a;
    public final ProducerResStep b;
    public final n.b c;
    public final l d;

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"sn0/i$a", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel;", "lib-layoutconfig_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class a extends TypeToken<LayoutConfigModel> {
        public a() {
        }
    }

    public final String f(String r5) throws Exception {
        StringBuilder r0 = new StringBuilder();
        BufferedReader r2 = new BufferedReader(new InputStreamReader(s1.getContext().getAssets().open(r5), "utf-8"));
    L3:
        String r6 = r2.readLine();
        if (r6 == null) goto L6;
        r0.append(r6);
        goto L3
    L6:
        r2.close();
        return r0.toString();
    }

    public i(n.b r2, l r3) {
        Intrinsics.checkNotNullParameter(r2, "createConfig");
        this.c = r2;
        this.d = r3;
        this.b = ProducerResStep.LocalAssets;
    }

    @Override // sn0.a
    public final void c(pn0.d r7, pn0.g r8) {
        Intrinsics.checkNotNullParameter(r7, "request");
        Intrinsics.checkNotNullParameter(r8, "modifiedRequestParams");
        if (this.c.b.d().e == true) goto L5;
        d(r7.e(), "localAssetsProducer is banned by setting!!!");
        sn0.a r0 = this.a;
        if (r0 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L29:
        r0.c(r7, r8);
        return;
    L5:
        if (this.c.a.isEmpty() == true) goto L31;
        e(r7, r8);
        return;
    L31:
        String r3 = this.c.b.b() + "entrance.json";     // Catch: Throwable -> L21
        d(r7.e(), "loadEntranceFile, path: " + r3);     // Catch: Throwable -> L21
        List r2 = (List) GsonHelper.get().fromJson(f(r3), new j().getType());     // Catch: Throwable -> L21
        List r4 = r2;     // Catch: Throwable -> L21
        if (r4 != null) goto L10;
    L13:
        boolean r5 = true;
    L14:
        if (r5 == true) goto L16;
        this.c.a.clear();     // Catch: Throwable -> L21
        this.c.a.addAll(r2);     // Catch: Throwable -> L21
        d(r7.e(), "LocalAssetsResProducer loadEntranceList success.");     // Catch: Throwable -> L21
        e(r7, r8);     // Catch: Throwable -> L21
        return;
    L16:
        new Throwable("entranceList is null or empty!");     // Catch: Throwable -> L21
        d(r7.e(), "LocalAssetsResProducer loadEntranceList failure.");     // Catch: Throwable -> L21
        sn0.a r6 = this.a;     // Catch: Throwable -> L21
        if (r6 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");     // Catch: Throwable -> L21
    L19:
        r6.c(r7, r8);     // Catch: Throwable -> L21
        return;
    L10:
        if (r4.isEmpty() == true) goto L13;
        r5 = false;
    L21:
        d(r7.e(), "LocalAssetsResProducer loadEntranceList failure.");
        sn0.a r1 = this.a;
        if (r1 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L24:
        r1.c(r7, r8);
    }

    public final void d(pn0.d.a r3, String r4) {
        StringBuilder r5 = r3.a;
        r5.append("\n");
        r5.append("step: " + this.b + ", content: " + r4);
    }

    public final void e(pn0.d r10, pn0.g r11) {
        int r0 = r10.g();
        int r1 = r11.b;
        int r2 = r11.a;
        if (r2 == 0) goto L5;
        r0 = r2;
    L5:
        Iterator<T> r3 = this.c.a.iterator();
    L6:
        boolean r4 = true;
        String r6 = null;
        if (r3.hasNext() == false) goto L18;
        Object r5 = r3.next();
        pn0.a r7 = (pn0.a) r5;
        if (r7.d() == r0) goto L11;
    L15:
        boolean r8 = false;
    L16:
        if (r8 == false) goto L6;
    L19:
        pn0.a r9 = (pn0.a) r5;
        if (r9 == null) goto L22;
        r6 = r9.b();
    L22:
        if (r6 != null) goto L24;
        String r12 = "";
    L25:
        d(r10.e(), "get assets fileName: " + r12 + ", with request[ui_layout = " + r10.g() + ", orientation = " + r10.b() + ']');
        if (r12 == null) goto L32;
        if (r12.length() == 0) goto L32;
        r4 = false;
    L32:
        if (r4 == false) goto L49;
        sn0.a r13 = this.a;
        if (r13 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L36:
        r13.c(r10, r11);
        return;
    L49:
        LayoutConfigModel r14 = (LayoutConfigModel) GsonHelper.get().fromJson(f(r12), new a().getType());     // Catch: Throwable -> L43
        d(r10.e(), "parse local assets file success.");     // Catch: Throwable -> L43
        sn0.a r15 = this.a;     // Catch: Throwable -> L43
        if (r15 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");     // Catch: Throwable -> L43
    L41:
        r15.b(r10, r11, r14, this.b);     // Catch: Throwable -> L43
        return;
    L43:
        th = move-exception;
        d(r10.e(), "parse local assets file failed, throwable = " + th);
        sn0.a r16 = this.a;
        if (r16 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L47:
        r16.c(r10, r11);
        return;
    L24:
        r12 = this.c.b.b() + r6;
        goto L25
    L11:
        if (r7.c() != 0) goto L13;
    L14:
        r8 = true;
        goto L16
    L13:
        if (r7.c() != r1) goto L15;
    L18:
        r5 = null;
        goto L19
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
