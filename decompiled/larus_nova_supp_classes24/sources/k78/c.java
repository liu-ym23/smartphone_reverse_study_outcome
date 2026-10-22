package k78;

import com.f.android.quality.impl.Scene;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c {
    public final String a;
    public final String b;
    public final f68.a c;
    public Scene d;
    public boolean e;

    public final void b(Map<String, ? extends Object> r7) {
        boolean r2 = true;
        if (this.a.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.e = true;
        f68.a r1 = this.c;
        if (r1 == null) goto L26;
        Scene r3 = this.d;
        if (r3 == null) goto L27;
        Map<String, Object> r4 = r1.a();
        if (r4 == null) goto L23;
        Map r5 = MapsKt.toMutableMap(r4);
        if (r5 == null) goto L23;
        if (r7 != null) goto L18;
    L21:
        if (r2 == true) goto L24;
        r5.putAll(r7);
    L24:
        r3.a.b();
        r3.b("fh_dev_scene_start", r5, null);
        r3.e = false;
        return;
    L18:
        if (r7.isEmpty() == true) goto L21;
        r2 = false;
    L23:
        r5 = null;
        goto L24
    L27:
        return;
    L26:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void c(Map<String, ? extends Object> r6) {
        boolean r1 = true;
        if (this.a.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        if (this.e == false) goto L31;
        this.e = false;
        f68.a r2 = this.c;
        if (r2 == null) goto L29;
        Scene r3 = this.d;
        if (r3 == null) goto L30;
        Map<String, Object> r4 = r2.a();
        if (r4 == null) goto L25;
        Map r5 = MapsKt.toMutableMap(r4);
        if (r5 == null) goto L25;
        if (r6 != null) goto L20;
    L23:
        if (r1 == true) goto L26;
        r5.putAll(r6);
    L26:
        r3.h(r5, 0);
        return;
    L20:
        if (r6.isEmpty() == true) goto L23;
        r1 = false;
    L25:
        r5 = null;
        goto L26
    L30:
        return;
    L29:
        return;
    L31:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void a(String r6, Map<String, ? extends Object> r7) {
        Intrinsics.checkNotNullParameter(r6, "event");
        boolean r1 = false;
        if (this.a.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        Scene r2 = this.d;
        if (r2 == null) goto L26;
        f68.a r3 = this.c;
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
        Unit r8 = Unit.INSTANCE;
    L24:
        r2.c(r6, r5);
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

    public final void d(String r7, Map<String, ? extends Object> r8) {
        Intrinsics.checkNotNullParameter(r7, "step");
        boolean r1 = false;
        if (this.a.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        Scene r2 = this.d;
        if (r2 == null) goto L26;
        f68.a r3 = this.c;
        if (r3 == null) goto L23;
        Map<String, Object> r4 = r3.a();
        if (r4 == null) goto L23;
        Map r5 = MapsKt.toMutableMap(r4);
        if (r5 == null) goto L23;
        if (r8 != null) goto L18;
    L19:
        r1 = true;
    L20:
        if (r1 == true) goto L22;
        r5.putAll(r8);
    L22:
        Unit r9 = Unit.INSTANCE;
    L24:
        r2.g(r7, null, r5);
        return;
    L18:
        if (r8.isEmpty() == false) goto L20;
    L23:
        r5 = null;
        goto L24
    L26:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void e(String r11, Map<String, ? extends Object> r12) {
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
        f68.a r2 = this.c;
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
        Unit r13 = Unit.INSTANCE;
        Map r9 = r5;
    L24:
        r3.f(r11, null, true, null, null, r9);
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

    public c(String r2, String r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r2, "mTaskId");
        Intrinsics.checkNotNullParameter(r3, "mSpeaker");
        Intrinsics.checkNotNullParameter(r4, "mModelName");
        Intrinsics.checkNotNullParameter(r6, "botId");
        this.a = r2;
        this.b = r5;
        this.c = new f68.a(r2, r3, r4, r6);
        int r7 = qt7.a.a;
        Map r8 = MapsKt.emptyMap();
        int r9 = Scene.i;
        List r10 = CollectionsKt.emptyList();
        Scene r11 = new Scene("TTS_V2", "TTS_SAMI_V2");
        r11.b.addAll(r10);
        ((ConcurrentHashMap) r11.d).putAll(r8);
        this.d = r11;
    }
}
