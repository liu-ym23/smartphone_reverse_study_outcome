package com.bytedance.android.livesdk.gift.platform.core.utils.recorder;

import com.bytedance.bdlocation.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class BaseRecorder implements g {
    public final String a;
    public final boolean b;
    public final Map<String, h> c;
    public boolean d;
    public final int e;

    @Override // com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g
    public void c() {
    L22:
        e = move-exception;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b(this.a, "flushall err:" + e.getMessage());
        return;
    L4:
        if (this.b == false) goto L6;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(this.a, "flushAll size:" + this.c.size());     // Catch: Exception -> L22
    L6:
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();     // Catch: Exception -> L22
        long r1 = System.currentTimeMillis();     // Catch: Exception -> L22
        int r4 = 0;
    L8:
        if (r0.hasNext() == false) goto L18;
        Map.Entry r5 = (Map.Entry) r0.next();     // Catch: Exception -> L22
        if (j((h) r5.getValue(), r1) == false) goto L13;
        i(r5.getKey(), (h) r5.getValue());     // Catch: Exception -> L22
        r4 = r4 + 1;     // Catch: Exception -> L22
    L15:
        r0.remove();     // Catch: Exception -> L22
        if (r4 < this.e) goto L8;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(this.a, "too many report item,ignore.remain size:" + this.c.size());     // Catch: Exception -> L22
        goto L18
    L13:
        if (this.b == false) goto L15;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a(this.a, "not report because startConsume is " + ((h) r5.getValue()).g + " && beginIgnoreReport is " + ((h) r5.getValue()).f + ": " + ((String) r5.getKey()) + ' ' + ((h) r5.getValue()));     // Catch: Exception -> L22
    L18:
        if (r4 <= 0) goto L20;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(this.a, "report " + r4 + " records");     // Catch: Exception -> L22
    L20:
        this.d = false;     // Catch: Exception -> L22
    }

    public BaseRecorder(String r4) {
        Intrinsics.checkNotNullParameter(r4, "name");
        this.a = "ActionRecorder-".concat(r4);
        ReadOnlyProperty r5 = com.bytedance.android.livesdk.gift.platform.core.h.y;
        KProperty[] r0 = com.bytedance.android.livesdk.gift.platform.core.h.a;
        this.b = ((Boolean) r5.getValue(null, r0[23])).booleanValue();
        this.c = new LinkedHashMap();
        this.e = ((Number) com.bytedance.android.livesdk.gift.platform.core.h.x.getValue(null, r0[22])).intValue();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g
    public final void e(String r4) {
        Intrinsics.checkNotNullParameter("GiftTrayMessageManager", "msgId");
        Intrinsics.checkNotNullParameter(r4, "stage");
        d("GiftTrayMessageManager", r4);
        if (this.d == true) goto L8;
        Map<String, h> r5 = this.c;
        LinkedHashMap r6 = (LinkedHashMap) r5;
        i("GiftTrayMessageManager", (h) r6.get("GiftTrayMessageManager".toString()));
        if (this.b == false) goto L7;
        String r7 = this.a;
        Map<String, h> r0 = this.c;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a(r7, "flushOnce:".concat(String.valueOf(r1.get("GiftTrayMessageManager".toString()))));
    L7:
        this.d = true;
    L8:
        h("GiftTrayMessageManager");
    }

    public final void h(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "msgId");
        this.c.remove(r2.toString());
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g
    public final void b(Object r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "msgId");
        Intrinsics.checkNotNullParameter(r5, "stage");
        d(r4, r5);
        String r6 = this.a;
        StringBuilder r0 = new StringBuilder("flushLog:");
        Map<String, h> r1 = this.c;
        LinkedHashMap r2 = (LinkedHashMap) r1;
        r0.append((h) r2.get(r4.toString()));
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a(r6, r0.toString());
        h(r4);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g
    public final void d(Object r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "msgId");
        Intrinsics.checkNotNullParameter(r3, "stage");
        g(r2, r3, BaseRecorder$stage$1.INSTANCE);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g
    public final void f(Object r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "msgId");
        Intrinsics.checkNotNullParameter(r5, "otherInfo");
        if (this.b == false) goto L5;
        String r0 = this.a;
        StringBuilder r1 = new StringBuilder("flushSilent:");
        r1.append(r5);
        r1.append(',');
        Map<String, h> r6 = this.c;
        LinkedHashMap r7 = (LinkedHashMap) r6;
        r1.append((h) r7.get(r4.toString()));
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a(r0, r1.toString());
    L5:
        h(r4);
    }

    public final void i(Object r5, h r6) {
        Intrinsics.checkNotNullParameter(r5, "msgId");
        if (this.b == false) goto L5;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(this.a, "report " + r6);
    L5:
        e.a r0 = e.d;
        String r7 = r5.toString();
        if (r6 == null) goto L9;
        String r1 = r6.toString();
        if (r1 == null) goto L9;
    L10:
        d r2 = null;
        if (r6 == null) goto L13;
        String r3 = r6.a;
    L14:
        if (r6 == null) goto L16;
        r2 = r6.d;
    L16:
        r0.getClass();
        e.a.a(r7, r1, r3, r2);
        return;
    L13:
        r3 = null;
    L9:
        r1 = BuildConfig.FLAVOR;
        goto L10
    }

    public boolean j(h r3, long r4) {
        Intrinsics.checkNotNullParameter(r3, "record");
        if (r3.f == false) goto L5;
    L7:
        return false;
    L5:
        if (r3.g == 0) goto L7;
        return true;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g
    public final void a(Object r2, String r3, final d r4) {
        Intrinsics.checkNotNullParameter(r2, "msgId");
        Intrinsics.checkNotNullParameter(r3, "stage");
        g(r2, r3, new BaseRecorder$flushReport$1(r4));
        Map<String, h> r5 = this.c;
        LinkedHashMap r6 = (LinkedHashMap) r5;
        i(r2, (h) r6.get(r2.toString()));
        h(r2);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g
    public final void g(Object r9, String r10, Function1<? super h, Unit> r11) {
        Intrinsics.checkNotNullParameter(r9, "msgId");
        Intrinsics.checkNotNullParameter(r10, "stage");
        Intrinsics.checkNotNullParameter(r11, "record");
        h r2 = new h();
        r11.invoke(r2);
        Intrinsics.checkNotNullParameter(r9, "msgId");
        Intrinsics.checkNotNullParameter(r10, "stage");
        Intrinsics.checkNotNullParameter(r2, "newRecord");
        String r13 = r9.toString();
        if (this.c.containsKey(r13) == false) goto L37;
        h r14 = (h) ((LinkedHashMap) this.c).get(r13);
        if (r14 != null) goto L7;
        return;
    L7:
        if (r14.g != 0) goto L9;
        r14.g = r2.g;
    L9:
        boolean r4 = true;
        if (r10.length() <= 0) goto L12;
        boolean r3 = true;
    L13:
        if (r3 == false) goto L16;
        ((ArrayList) r14.c).add(r10);
    L16:
        if (r2.e.length() <= 0) goto L18;
        boolean r15 = true;
    L20:
        if (r15 == false) goto L23;
        String r16 = r2.e;
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        r14.e = r16;
    L23:
        if (r14.f == true) goto L26;
        r14.f = r2.f;
    L26:
        if (r2.h.length() > 0) goto L29;
        r4 = false;
    L29:
        if (r4 == false) goto L31;
        String r17 = r14.h + ';' + r2.h;
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        r14.h = r17;
    L31:
        d r18 = r2.d;
        if (r18 == null) goto L35;
        r14.d = r18;
        String r19 = r14.h + String.valueOf(r14.d);
        Intrinsics.checkNotNullParameter(r19, "<set-?>");
        r14.h = r19;
    L35:
        if (this.b == false) goto L43;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a(this.a, "stage " + r13 + ' ' + r14);
        return;
    L43:
        return;
    L18:
        r15 = false;
        goto L20
    L12:
        r3 = false;
        goto L13
    L37:
        Map<String, h> r110 = this.c;
        ((ArrayList) r2.c).add(r10);
        if (this.b == false) goto L40;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a(this.a, "stage " + r13 + ' ' + r2);
    L40:
        Unit r111 = Unit.INSTANCE;
        r110.put(r13, r2);
    }
}
