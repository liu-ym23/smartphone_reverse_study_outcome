package k78;

import com.f.android.quality.impl.Scene;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import m58.h;
import m58.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public final String a;
    public String b;
    public e68.a c;
    public Scene d;
    public int e;
    public boolean f;

    /* JADX INFO: renamed from: k78.a$a, reason: collision with other inner class name */
    public static final class C0114a {
    }

    static {
    }

    public final void b(Map<String, ? extends Object> r7) {
        boolean r2 = true;
        if (this.a.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.f = true;
        Scene r1 = this.d;
        if (r1 == null) goto L27;
        e68.a r3 = this.c;
        if (r3 == null) goto L24;
        Map<String, Object> r4 = r3.a();
        if (r4 == null) goto L24;
        Map r5 = MapsKt.toMutableMap(r4);
        if (r5 == null) goto L24;
        if (r7 != null) goto L18;
    L21:
        if (r2 == true) goto L23;
        r5.putAll(r7);
    L23:
        r5.put("retry_time", Integer.valueOf(this.e));
    L25:
        r1.a.b();
        r1.b("fh_dev_scene_start", r5, null);
        r1.e = false;
        return;
    L18:
        if (r7.isEmpty() == true) goto L21;
        r2 = false;
    L24:
        r5 = null;
        goto L25
    L27:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void c(Map<String, ? extends Object> r6) {
        boolean r1 = false;
        if (this.a.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        if (this.f == false) goto L30;
        Scene r2 = this.d;
        if (r2 == null) goto L29;
        e68.a r3 = this.c;
        if (r3 == null) goto L25;
        Map<String, Object> r4 = r3.a();
        if (r4 == null) goto L25;
        Map r5 = MapsKt.toMutableMap(r4);
        if (r5 == null) goto L25;
        if (r6 != null) goto L20;
    L21:
        r1 = true;
    L22:
        if (r1 == true) goto L24;
        r5.putAll(r6);
    L24:
        r5.put("retry_time", Integer.valueOf(this.e));
    L26:
        r2.h(r5, 0);
        return;
    L20:
        if (r6.isEmpty() == false) goto L22;
    L25:
        r5 = null;
        goto L26
    L29:
        return;
    L30:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void a(int r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, LKBaseResponseModel.ERROR_MSG_KEY);
        if (this.a.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        if (this.f == false) goto L27;
        Scene r1 = this.d;
        if (r1 == null) goto L21;
        e68.a r2 = this.c;
        if (r2 == null) goto L19;
        Map<String, Object> r3 = r2.a();
        if (r3 == null) goto L19;
        Map r4 = MapsKt.toMutableMap(r3);
        if (r4 == null) goto L19;
        r4.put("retry_time", Integer.valueOf(this.e));
        Unit r7 = Unit.INSTANCE;
    L20:
        rt7.c.a.a(r1, r5, r6, r4);
    L19:
        r4 = null;
    L21:
        u r8 = h.l;
        if (r8 == null) goto L26;
        r8.g(this.a, Integer.valueOf(r5), r6);
        return;
    L26:
        return;
    L27:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void e(String r6, Map<String, ? extends Object> r7) {
        Intrinsics.checkNotNullParameter(r6, "step");
        boolean r1 = false;
        if (this.a.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        Scene r2 = this.d;
        if (r2 == null) goto L26;
        e68.a r3 = this.c;
        if (r3 == null) goto L23;
        Map<String, Object> r4 = r3.a();
        if (r4 == null) goto L23;
        Map r5 = MapsKt.toMutableMap(r4);
        if (r5 == null) goto L23;
        if (r7 != null) goto L18;
    L19:
        r1 = true;
    L20:
        if (r1 == true) goto L22;
        r5.putAll(r7);
    L22:
        r5.put("retry_time", Integer.valueOf(this.e));
        Unit r8 = Unit.INSTANCE;
    L24:
        r2.g(r6, r6, r5);
        return;
    L18:
        if (r7.isEmpty() == false) goto L20;
    L23:
        r5 = null;
        goto L24
    L26:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void f(String r11, Map<String, ? extends Object> r12) {
        Intrinsics.checkNotNullParameter(r11, "step");
        boolean r1 = false;
        if (this.a.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        Scene r3 = this.d;
        if (r3 == null) goto L26;
        e68.a r2 = this.c;
        if (r2 == null) goto L23;
        Map<String, Object> r4 = r2.a();
        if (r4 == null) goto L23;
        Map r5 = MapsKt.toMutableMap(r4);
        if (r5 == null) goto L23;
        if (r12 != null) goto L18;
    L19:
        r1 = true;
    L20:
        if (r1 == true) goto L22;
        r5.putAll(r12);
    L22:
        r5.put("retry_time", Integer.valueOf(this.e));
        Unit r13 = Unit.INSTANCE;
        Map r9 = r5;
    L24:
        r3.f(r11, r11, true, null, null, r9);
        return;
    L18:
        if (r12.isEmpty() == false) goto L20;
    L23:
        r9 = null;
        goto L24
    L26:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void d(String r9, int r10, String r11) {
        Intrinsics.checkNotNullParameter(r9, "step");
        Intrinsics.checkNotNullParameter(r11, LKBaseResponseModel.ERROR_MSG_KEY);
        if (this.a.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        Scene r1 = this.d;
        if (r1 == null) goto L20;
        e68.a r2 = this.c;
        if (r2 == null) goto L17;
        Map<String, Object> r3 = r2.a();
        if (r3 == null) goto L17;
        Map r4 = MapsKt.toMutableMap(r3);
        if (r4 == null) goto L17;
        r4.put("retry_time", Integer.valueOf(this.e));
        Unit r5 = Unit.INSTANCE;
    L18:
        Integer r6 = Integer.valueOf(r10);
        r1.f(r9, r9, false, r6, r11, r4);
        return;
    L17:
        r4 = null;
        goto L18
    L20:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public a(String r4, String r5, String r6, int r7, String r8) {
        Intrinsics.checkNotNullParameter(r4, "mTaskId");
        Intrinsics.checkNotNullParameter("14.92.34-alpha.1-oassistant", "mSamiSdkVersion");
        Intrinsics.checkNotNullParameter(r8, "botId");
        this.a = r4;
        this.b = r8;
        if (r6 != null) goto L5;
        r6 = "";
    L5:
        this.c = new e68.a(r6, this.b);
        Pair[] r9 = new Pair[4];
        r9[0] = TuplesKt.to("task_id", r4);
        if (r5 != null) goto L8;
        r5 = "";
    L8:
        r9[1] = TuplesKt.to("model", r5);
        r9[2] = TuplesKt.to("sami_sdk_version", "14.92.34-alpha.1-oassistant");
        r9[3] = TuplesKt.to("is_audio_message", Integer.valueOf(r7));
        Map r10 = MapsKt.mapOf(r9);
        int r11 = qt7.a.a;
        int r12 = Scene.i;
        List r13 = CollectionsKt.emptyList();
        Scene r14 = new Scene("ASR_V2", "ASR_SAMI_V2");
        r14.b.addAll(r13);
        ((ConcurrentHashMap) r14.d).putAll(r10);
        this.d = r14;
    }
}
