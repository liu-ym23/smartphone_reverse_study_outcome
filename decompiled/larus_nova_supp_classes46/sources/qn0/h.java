package qn0;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.multilink.layoutconfig.model.LayoutConfigModel;
import com.bytedance.android.live.multilink.layoutconfig.resource.producer.ProducerResStep;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import sn0.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h implements l, sn0.a {
    public sn0.a a;
    public final ProducerResStep b;
    public final k.b c;
    public final l d;

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"qn0/h$a", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/android/live/multilink/layoutconfig/model/LayoutConfigModel;", "lib-layoutconfig_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class a extends TypeToken<LayoutConfigModel> {
        public a() {
        }
    }

    public final String g(String r5) throws Exception {
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

    public h(k.b r2, l r3) {
        Intrinsics.checkNotNullParameter(r2, "createConfig");
        this.c = r2;
        this.d = r3;
        this.b = ProducerResStep.LocalAssets;
    }

    @Override // sn0.a
    public final void c(pn0.d r9, pn0.g r10) {
        Intrinsics.checkNotNullParameter(r9, "request");
        Intrinsics.checkNotNullParameter(r10, "modifiedRequestParams");
        if (this.c.c.d().e == true) goto L5;
        d(r9.e(), "localAssetsProducer is banned by setting!!!");
        sn0.a r0 = this.a;
        if (r0 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L47:
        r0.c(r9, r10);
        return;
    L5:
        if (this.c.a.isEmpty() == true) goto L49;
        f(r9, r10);
        return;
    L49:
        String r3 = this.c.c.b() + "offset/entrance.json";     // Catch: Throwable -> L39
        d(r9.e(), "loadOffsetEntranceFile, path: " + r3);     // Catch: Throwable -> L39
        pn0.h r1 = (pn0.h) GsonHelper.get().fromJson(g(r3), new i().getType());     // Catch: Throwable -> L39
        HashMap<String, String> r4 = null;
        if (r1 == null) goto L10;
        HashMap<String, HashMap<String, String>> r5 = r1.b();     // Catch: Throwable -> L39
    L11:
        if (r1 == null) goto L13;
        r4 = r1.a();     // Catch: Throwable -> L39
    L13:
        boolean r2 = true;
        if (r5 != null) goto L16;
    L19:
        boolean r6 = true;
    L21:
        if (r6 == true) goto L23;
        this.c.a.clear();     // Catch: Throwable -> L39
        this.c.a.putAll(r5);     // Catch: Throwable -> L39
        d(r9.e(), "LocalAssetsResProducer loadEntranceList success.");     // Catch: Throwable -> L39
        f(r9, r10);     // Catch: Throwable -> L39
    L27:
        if (r4 != null) goto L29;
    L32:
        if (r2 == true) goto L34;
        this.c.b.clear();     // Catch: Throwable -> L39
        this.c.b.putAll(r4);     // Catch: Throwable -> L39
        d(r9.e(), "LocalAssetsResProducer loadEntranceList success.");     // Catch: Throwable -> L39
        f(r9, r10);     // Catch: Throwable -> L39
        return;
    L34:
        new Throwable("offsetUIFeatureMap is null or empty!");     // Catch: Throwable -> L39
        d(r9.e(), "LocalAssetsResProducer loadEntranceList failure.");     // Catch: Throwable -> L39
        sn0.a r7 = this.a;     // Catch: Throwable -> L39
        if (r7 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");     // Catch: Throwable -> L39
    L37:
        r7.c(r9, r10);     // Catch: Throwable -> L39
        return;
    L29:
        if (r4.isEmpty() == true) goto L32;
        r2 = false;
        goto L32
    L23:
        new Throwable("offsetConfigMap is null or empty!");     // Catch: Throwable -> L39
        d(r9.e(), "LocalAssetsResProducer loadEntranceList failure.");     // Catch: Throwable -> L39
        sn0.a r8 = this.a;     // Catch: Throwable -> L39
        if (r8 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");     // Catch: Throwable -> L39
    L26:
        r8.c(r9, r10);     // Catch: Throwable -> L39
        goto L27
    L16:
        if (r5.isEmpty() == true) goto L19;
        r6 = false;
        goto L21
    L10:
        r5 = null;
    L39:
        d(r9.e(), "LocalAssetsResProducer loadEntranceList failure.");
        sn0.a r11 = this.a;
        if (r11 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L42:
        r11.c(r9, r10);
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

    public final void f(pn0.d r9, pn0.g r10) {
        int r0 = r9.g();
        int r1 = r10.a;
        if (r1 == 0) goto L5;
        r0 = r1;
    L5:
        List<Integer> r2 = r9.f();
        d(r9.e(), "loadGeckoOffsetLayoutLayoutConfigByUIFeature uiFeatures(from server data): " + r2);
        Map<Integer, List<Integer>> r3 = r10.c;
        boolean r4 = false;
        if (r3 != null) goto L8;
    L11:
        boolean r5 = true;
    L12:
        if (r5 == true) goto L19;
        ArrayList r6 = new ArrayList();
        List<Integer> r7 = r10.c.get(Integer.valueOf(r0));
        if (r2 == null) goto L16;
        r6.addAll(r2);
    L16:
        if (r7 == null) goto L18;
        r6.addAll(r7);
    L18:
        d(r9.e(), "loadGeckoOffsetLayoutLayoutConfigByUIFeature offsetUIFeatureList(from client inject data): " + r7);
        r2 = CollectionsKt.sorted(r6);
    L19:
        String r8 = e(r2, String.valueOf(r0));
        if (r8 != null) goto L32;
        ArrayList r11 = new ArrayList();
        if (r2 == null) goto L31;
        Iterator r12 = r2.iterator();
    L25:
        if (r12.hasNext() == false) goto L31;
        String r13 = this.c.b.get(String.valueOf(((Number) r12.next()).intValue()));
        if (r13 == null) goto L25;
        int r14 = CastIntegerProtector.parseInt(r13);
        if (r11.contains(Integer.valueOf(r14)) == true) goto L25;
        r11.add(Integer.valueOf(r14));
    L31:
        CollectionsKt.sort(r11);
        r2 = r11;
        r8 = e(r11, String.valueOf(r0));
    L32:
        if (r8 != null) goto L34;
        r8 = e(r2, "common");
    L34:
        if (r8 != null) goto L36;
        String r15 = "";
    L37:
        d(r9.e(), "get assets fileName: " + r15 + ", with request[ui_layout = " + r9.g() + ", orientation = " + r9.b() + ']');
        if (r15 != null) goto L40;
    L41:
        r4 = true;
    L43:
        if (r4 == false) goto L60;
        sn0.a r16 = this.a;
        if (r16 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L47:
        r16.c(r9, r10);
        return;
    L60:
        LayoutConfigModel r17 = (LayoutConfigModel) GsonHelper.get().fromJson(g(r15), new a().getType());     // Catch: Throwable -> L54
        d(r9.e(), "parse local assets file success.");     // Catch: Throwable -> L54
        sn0.a r18 = this.a;     // Catch: Throwable -> L54
        if (r18 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");     // Catch: Throwable -> L54
    L52:
        r18.b(r9, r10, r17, this.b);     // Catch: Throwable -> L54
        return;
    L54:
        th = move-exception;
        d(r9.e(), "parse local assets file failed, throwable = " + th);
        sn0.a r19 = this.a;
        if (r19 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L58:
        r19.c(r9, r10);
        return;
    L40:
        if (r15.length() != 0) goto L43;
    L36:
        r15 = this.c.c.b() + "offset/" + r8;
        goto L37
    L8:
        if (r3.isEmpty() == true) goto L11;
        r5 = false;
        goto L12
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
        Intrinsics.checkNotNullParameter(r5, "layoutConfigModel");
        Intrinsics.checkNotNullParameter(r6, "step");
        sn0.a r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r0.b(r3, r4, r5, r6);
    }
}
