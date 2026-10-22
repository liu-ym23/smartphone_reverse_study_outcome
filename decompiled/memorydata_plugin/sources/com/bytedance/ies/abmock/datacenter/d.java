package com.bytedance.ies.abmock.datacenter;

import android.util.Log;
import com.bytedance.ies.abmock.SaveConfigType;
import com.bytedance.ies.abmock.datacenter.storage.p;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile d f2673b;
    private static final Object j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Gson f2674a;
    private final Map<String, Object> c;
    private final Map<String, Long> d;
    private final Map<String, Object> e;
    private volatile com.bytedance.ies.abmock.datacenter.a.a f;
    private volatile k g;
    private boolean h;
    private boolean i;

    /* JADX INFO: renamed from: com.bytedance.ies.abmock.datacenter.d$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2676a = null;

        static {
            int[] r0 = new int[DataValueType.values().length];
            f2676a = r0;
            r0[DataValueType.INT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            f2676a[DataValueType.BOOLEAN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            f2676a[DataValueType.LONG.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            f2676a[DataValueType.FLOAT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            f2676a[DataValueType.DOUBLE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            f2676a[DataValueType.STRING.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            f2676a[DataValueType.STRING_ARRAY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            f2676a[DataValueType.OBJECT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    static {
        j = new Object();
    }

    private d() {
        this.c = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
        this.e = new ConcurrentHashMap();
        this.h = false;
        this.f2674a = new Gson();
        this.i = false;
    }

    public static d a() {
        if (f2673b != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2673b != null) goto L9;
        f2673b = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f2673b;
    }

    private com.bytedance.ies.abmock.datacenter.storage.d a(String r1, int r2, boolean r3) {
        if (b.b(r2) == false) goto L7;
        return com.bytedance.ies.abmock.datacenter.storage.g.f2718b;
    L7:
        if (b.a(r2) == false) goto L11;
        return com.bytedance.ies.abmock.datacenter.storage.c.f2709a;
    L11:
        if (com.bytedance.ies.abmock.datacenter.storage.i.f2723b.b(r1) == true) goto L13;
        if (r3 == false) goto L23;
        if (com.bytedance.ies.abmock.datacenter.storage.cdn.b.f2714b.b(r1) == false) goto L23;
        return com.bytedance.ies.abmock.datacenter.storage.cdn.b.f2714b;
    L23:
        return com.bytedance.ies.abmock.datacenter.storage.a.f2706b;
    L13:
        if (com.bytedance.ies.abmock.datacenter.b.a.f2669a.a() == false) goto L16;
        com.bytedance.ies.abmock.datacenter.b.b.f2671a.a(r1);
    L16:
        return com.bytedance.ies.abmock.datacenter.storage.i.f2723b;
    }

    private Object a(String r2, SaveConfigType.ConfigType r3) {
        return a(r2, r3, null);
    }

    private Object a(String r2, SaveConfigType.ConfigType r3, Class r4) {
        Object r0 = a(r2, r4, null);
        if (r0 == null) goto L5;
        return r0;
    L5:
        Object r1 = d(r2);
        if (r1 == null) goto L8;
        return r1;
    L8:
        return j.f2688a.a(r2, r3, r4);
    }

    private Object a(String r8, Object r9, int r10, boolean r11, boolean r12, boolean r13, Class<?> r14, DataValueType r15) {
        if (b.b(r10) == false) goto L9;
        Object r7 = a(r8, r9, com.bytedance.ies.abmock.datacenter.storage.g.f2718b, r14, r15);
        if (r7 != null) goto L7;
        return r9;
    L7:
        return r7;
    L9:
        if (b.a(r10) == false) goto L11;
        Object r16 = a(r8, r9, com.bytedance.ies.abmock.datacenter.storage.c.f2709a, r14, r15);
    L25:
        if (r16 == null) goto L29;
        r9 = r16;
    L29:
        if (r15 != DataValueType.STRING_ARRAY) goto L31;
    L32:
        if (r9 == null) goto L34;
    L36:
        a(r8, r9, r11, r12);
    L37:
        return r9;
    L34:
        if (this.i == false) goto L36;
        a(r8, j, r11, r12);
        goto L37
    L31:
        if (r15 != DataValueType.OBJECT) goto L36;
    L11:
        r16 = a(r8, r9, com.bytedance.ies.abmock.datacenter.storage.i.f2723b, r14, r15);
        if (r16 != null) goto L14;
    L16:
        if (r16 != null) goto L25;
        if (r13 == false) goto L25;
        Long r17 = (Long) ZeusTransformUtils.preCheckCast(this.d.get(r8), Long.class, "com.obric.memorydata.plugin");
        if (r17 != null) goto L22;
        r17 = Long.valueOf(com.bytedance.ies.abmock.datacenter.storage.cdn.b.f2714b.a(r8, -1));
    L22:
        if (r17.longValue() == (-1)) goto L25;
        a(r8, r17.longValue(), r11, false);
        return a(r17 + "", null, com.bytedance.ies.abmock.datacenter.storage.cdn.c.f2716b, r14, r15);
    L14:
        if (com.bytedance.ies.abmock.datacenter.b.a.f2669a.a() == false) goto L16;
        com.bytedance.ies.abmock.datacenter.b.b.f2671a.a(r8);
        goto L16
    }

    private Object a(String r2, Object r3, com.bytedance.ies.abmock.datacenter.storage.d r4, Class<?> r5, DataValueType r6) {
        com.bytedance.ies.abmock.datacenter.storage.d r1 = (com.bytedance.ies.abmock.datacenter.storage.d) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.ies.abmock.datacenter.storage.d.class, "com.obric.memorydata.plugin");
        switch(AnonymousClass2.f2676a[r6.ordinal()]) {
            case 1: goto L33;
            case 2: goto L29;
            case 3: goto L23;
            case 4: goto L18;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L10;
            case 8: goto L5;
            default: goto L4;
        };
    L4:
        return null;
    L5:
        if (r5 != null) goto L7;
        return null;
    L7:
        return r1.a(r2, r5);
    L13:
        double r7 = r1.a(r2, Double.MIN_VALUE);
        if (r7 != Double.MIN_VALUE) goto L17;
        return null;
    L17:
        return Double.valueOf(r7);
    L18:
        float r8 = r1.a(r2, Float.MIN_VALUE);
        if (r8 != Float.MIN_VALUE) goto L22;
        return null;
    L22:
        return Float.valueOf(r8);
    L23:
        long r9 = r1.a(r2, Long.MIN_VALUE);
        if (r9 != Long.MIN_VALUE) goto L27;
        return null;
    L27:
        return Long.valueOf(r9);
    L33:
        int r10 = r1.a(r2, Integer.MIN_VALUE);
        if (r10 != Integer.MIN_VALUE) goto L37;
        return null;
    L37:
        return Integer.valueOf(r10);
    L10:
        return r1.a(r2);
    L12:
        return r1.a(r2, null);
    L29:
        if (r1.b(r2) == true) goto L31;
        return null;
    L31:
        return Boolean.valueOf(r1.a(r2, ((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue()));
    }

    private void a(String r1, long r2, boolean r4, boolean r5) {
        if (r5 == false) goto L4;
        return;
    L4:
        if (r4 == false) goto L7;
        this.d.put(r1, Long.valueOf(r2));
        return;
    }

    private void a(String r2, Object r3, boolean r4) {
        a(r2, r3, r4, false);
    }

    private void a(String r2, Object r3, boolean r4, boolean r5) {
        com.bytedance.ies.abmock.datacenter.precise.c.f2698a.b(r2);
        if (r5 == false) goto L5;
        return;
    L5:
        if (r3 == null) goto L11;
        if (r4 == false) goto L8;
        Map<String, Object> r1 = this.c;
    L9:
        r1.put(r2, r3);
        return;
    L8:
        r1 = this.e;
        goto L9
    }

    private Object d(String r2) {
        Object r0 = this.c.get(r2);     // Catch: Throwable -> L11
        if (r0 == null) goto L7;
        if (r2 == null) goto L6;
        com.bytedance.ies.abmock.datacenter.precise.c.f2698a.a(r2);
    L6:
        return r0;
    L7:
        Object r1 = this.e.get(r2);     // Catch: Throwable -> L11
        if (r2 == null) goto L10;
        com.bytedance.ies.abmock.datacenter.precise.c.f2698a.a(r2);
    L10:
        return r1;
    L11:
        th = move-exception;
        if (r2 == null) goto L14;
        com.bytedance.ies.abmock.datacenter.precise.c.f2698a.a(r2);
    L14:
        throw th;
    }

    public double a(String r11, double r12, boolean r14, int r15) {
        if (b.b(r15) == true) goto L5;
        Object r4 = a(r11, SaveConfigType.ConfigType.DOUBLE);
        if (r4 == null) goto L11;
        return ((Double) ZeusTransformUtils.preCheckCast(r4, Double.class, "com.obric.memorydata.plugin")).doubleValue();
    L11:
        if (this.h == true) goto L13;
        Double r2 = Double.valueOf(a(r11, r15, false).a(r11, r12));
        a(r11, r2, r14);
        return ((Double) ZeusTransformUtils.preCheckCast(r2, Double.class, "com.obric.memorydata.plugin")).doubleValue();
    L13:
        return ((Double) ZeusTransformUtils.preCheckCast(a(r11, Double.valueOf(r12), r15, r14, false, false, null, DataValueType.DOUBLE), Double.class, "com.obric.memorydata.plugin")).doubleValue();
    L5:
        return com.bytedance.ies.abmock.datacenter.storage.g.f2718b.a(r11, r12);
    }

    public float a(String r12, float r13, boolean r14, int r15) {
        if (b.b(r15) == true) goto L5;
        Object r0 = a(r12, SaveConfigType.ConfigType.FLOAT);
        if (r0 == null) goto L11;
        return ((Float) ZeusTransformUtils.preCheckCast(r0, Float.class, "com.obric.memorydata.plugin")).floatValue();
    L11:
        if (this.h == true) goto L13;
        Float r16 = Float.valueOf(a(r12, r15, false).a(r12, r13));
        a(r12, r16, r14);
        return ((Float) ZeusTransformUtils.preCheckCast(r16, Float.class, "com.obric.memorydata.plugin")).floatValue();
    L13:
        return ((Float) ZeusTransformUtils.preCheckCast(a(r12, Float.valueOf(r13), r15, r14, false, false, null, DataValueType.FLOAT), Float.class, "com.obric.memorydata.plugin")).floatValue();
    L5:
        return com.bytedance.ies.abmock.datacenter.storage.g.f2718b.a(r12, r13);
    }

    public int a(String r12, int r13, boolean r14, int r15) {
        if (b.b(r15) == true) goto L5;
        Object r0 = a(r12, SaveConfigType.ConfigType.INT);
        if (r0 == null) goto L11;
        return ((Integer) ZeusTransformUtils.preCheckCast(r0, Integer.class, "com.obric.memorydata.plugin")).intValue();
    L11:
        if (this.h == true) goto L13;
        Integer r16 = Integer.valueOf(a(r12, r15, false).a(r12, r13));
        a(r12, r16, r14);
        return ((Integer) ZeusTransformUtils.preCheckCast(r16, Integer.class, "com.obric.memorydata.plugin")).intValue();
    L13:
        return ((Integer) ZeusTransformUtils.preCheckCast(a(r12, Integer.valueOf(r13), r15, r14, false, false, null, DataValueType.INT), Integer.class, "com.obric.memorydata.plugin")).intValue();
    L5:
        return com.bytedance.ies.abmock.datacenter.storage.g.f2718b.a(r12, r13);
    }

    public long a(String r11, long r12, boolean r14, int r15) {
        if (b.b(r15) == true) goto L5;
        Object r4 = a(r11, SaveConfigType.ConfigType.LONG);
        if (r4 == null) goto L11;
        return ((Long) ZeusTransformUtils.preCheckCast(r4, Long.class, "com.obric.memorydata.plugin")).longValue();
    L11:
        if (this.h == true) goto L13;
        Long r2 = Long.valueOf(a(r11, r15, false).a(r11, r12));
        a(r11, r2, r14);
        return ((Long) ZeusTransformUtils.preCheckCast(r2, Long.class, "com.obric.memorydata.plugin")).longValue();
    L13:
        return ((Long) ZeusTransformUtils.preCheckCast(a(r11, Long.valueOf(r12), r15, r14, false, false, null, DataValueType.LONG), Long.class, "com.obric.memorydata.plugin")).longValue();
    L5:
        return com.bytedance.ies.abmock.datacenter.storage.g.f2718b.a(r11, r12);
    }

    public JsonObject a(String r4) {
        if (p.f2737a.a(r4) == false) goto L7;
        Object r3 = p.f2737a.b(r4);
    L6:
        return (JsonObject) ZeusTransformUtils.preCheckCast(r3, JsonObject.class, "com.obric.memorydata.plugin");
    L7:
        r3 = a(r4, b.f2667a, false).a(r4, JsonObject.class);
        goto L6
    }

    public Object a(String r6, Class r7, Object r8) {
        if (this.g != null) goto L22;
        com.bytedance.ies.abmock.datacenter.event.a.a(new Throwable("mProvider is null"), "");
    L22:
    L19:
        th = move-exception;
        com.bytedance.ies.abmock.datacenter.event.a.a(new Throwable(th + ": getValueFromMock error: " + r6, th), "");
    L21:
        return r8;
    L6:
        if (this.f == null) goto L21;
        if (this.f.a() == false) goto L21;
        Object r0 = this.f.a(r6);     // Catch: Throwable -> L19
        if (r0 == null) goto L21;
        Log.d("ABMockEvent", "get value from mock, key : " + r6 + "---value : " + r0);     // Catch: Throwable -> L19
        if (r7 != null) goto L14;
        return r0;
    L14:
        if (r0.getClass().isAssignableFrom(r7) == false) goto L16;
        return r0;
    L16:
        if (ZeusTransformUtils.instanceOf(r0, JsonObject.class) == false) goto L26;
        return this.f2674a.fromJson((JsonObject) ZeusTransformUtils.preCheckCast(r0, JsonObject.class, "com.obric.memorydata.plugin"), r7);
    L26:
        return r0;
    }

    public Object a(String r12, boolean r13, boolean r14, Class r15, int r16) {
        if (b.b(r16) == true) goto L5;
        Object r2 = a(r12, SaveConfigType.ConfigType.OBJECT, r15);
        Object r3 = j;
        if (r2 == r3) goto L9;
    L12:
        if (r2 == null) goto L15;
        return r2;
    L15:
        if (this.h == true) goto L17;
        com.bytedance.ies.abmock.datacenter.storage.d r4 = a(r12, r16, true);
        if (ZeusTransformUtils.instanceOf(r4, com.bytedance.ies.abmock.datacenter.storage.cdn.b.class) == false) goto L28;
        Long r5 = (Long) ZeusTransformUtils.preCheckCast(this.d.get(r12), Long.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L23;
        r5 = Long.valueOf(r4.a(r12, -1));
    L23:
        Long r10 = r5;
        if (r10.longValue() != (-1)) goto L26;
        return null;
    L26:
        a(r12, r10.longValue(), r13, false);
        return com.bytedance.ies.abmock.datacenter.storage.cdn.c.f2716b.a(r10 + "", r15);
    L28:
        Object r6 = r4.a(r12, r15);
        if (r6 == null) goto L31;
    L33:
        a(r12, r6, r13, r14);
    L34:
        return r6;
    L31:
        if (this.i == false) goto L33;
        a(r12, r3, r13, r14);
        goto L34
    L17:
        return a(r12, null, r16, r13, r14, true, r15, DataValueType.OBJECT);
    L9:
        if (this.i == false) goto L11;
        return null;
    L11:
        c(r12);
        r2 = null;
        goto L12
    L5:
        return com.bytedance.ies.abmock.datacenter.storage.g.f2718b.a(r12, r15);
    }

    public String a(String r12, String r13, boolean r14, int r15) {
        if (b.b(r15) == true) goto L5;
        Object r0 = a(r12, SaveConfigType.ConfigType.STRING);
        if (r0 == null) goto L11;
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
    L11:
        if (this.h == true) goto L13;
        com.bytedance.ies.abmock.datacenter.storage.d r16 = a(r12, r15, true);
        if (ZeusTransformUtils.instanceOf(r16, com.bytedance.ies.abmock.datacenter.storage.cdn.b.class) == false) goto L24;
        Long r1 = (Long) ZeusTransformUtils.preCheckCast(this.d.get(r12), Long.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L20;
        r1 = Long.valueOf(r16.a(r12, -1));
    L20:
        if (r1.longValue() != (-1)) goto L22;
        return r13;
    L22:
        a(r12, r1.longValue(), r14, false);
        return (String) ZeusTransformUtils.preCheckCast(com.bytedance.ies.abmock.datacenter.storage.cdn.c.f2716b.a(r1 + "", null), String.class, "com.obric.memorydata.plugin");
    L24:
        String r17 = r16.a(r12, r13);
        a(r12, r17, r14);
        return (String) ZeusTransformUtils.preCheckCast(r17, String.class, "com.obric.memorydata.plugin");
    L13:
        return (String) ZeusTransformUtils.preCheckCast(a(r12, r13, r15, r14, false, true, null, DataValueType.STRING), String.class, "com.obric.memorydata.plugin");
    L5:
        return com.bytedance.ies.abmock.datacenter.storage.g.f2718b.a(r12, r13);
    }

    public void a(k r3, com.bytedance.ies.abmock.datacenter.a.a r4) {
        k r5 = (k) ZeusTransformUtils.wrapperContextForParams(r3, k.class, "com.obric.memorydata.plugin");
        com.bytedance.ies.abmock.datacenter.a.a r6 = (com.bytedance.ies.abmock.datacenter.a.a) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.ies.abmock.datacenter.a.a.class, "com.obric.memorydata.plugin");
        this.g = r5;
        this.f = r6;
        bolts.g.a(2000).a(new AnonymousClass1(this));
    }

    public boolean a(String r12, boolean r13, boolean r14, int r15) {
        if (b.b(r15) == true) goto L5;
        Object r0 = a(r12, SaveConfigType.ConfigType.BOOLEAN);
        if (r0 == null) goto L11;
        return ((Boolean) ZeusTransformUtils.preCheckCast(r0, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L11:
        if (this.h == true) goto L13;
        Boolean r16 = Boolean.valueOf(a(r12, r15, false).a(r12, r13));
        a(r12, r16, r14);
        return ((Boolean) ZeusTransformUtils.preCheckCast(r16, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L13:
        return ((Boolean) ZeusTransformUtils.preCheckCast(a(r12, Boolean.valueOf(r13), r15, r14, false, false, null, DataValueType.BOOLEAN), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L5:
        return com.bytedance.ies.abmock.datacenter.storage.g.f2718b.a(r12, r13);
    }

    public String[] a(String r13, boolean r14, int r15) {
        if (b.b(r15) == true) goto L5;
        Object r0 = a(r13, SaveConfigType.ConfigType.STRING_ARRAY, String[].class);
        Object r1 = j;
        if (r0 != r1) goto L13;
        if (this.i == false) goto L11;
        return null;
    L11:
        c(r13);
        r0 = null;
    L13:
        if (r0 == null) goto L17;
        return (String[]) ZeusTransformUtils.preCheckCast(r0, String[].class, "com.obric.memorydata.plugin");
    L17:
        if (this.h == true) goto L19;
        String[] r16 = a(r13, r15, false).a(r13);
        if (r16 == null) goto L23;
    L25:
        a(r13, r16, r14);
    L27:
        return (String[]) ZeusTransformUtils.preCheckCast(r16, String[].class, "com.obric.memorydata.plugin");
    L23:
        if (this.i == false) goto L25;
        a(r13, r1, r14);
        goto L27
    L19:
        return (String[]) ZeusTransformUtils.preCheckCast(a(r13, null, r15, r14, false, false, null, DataValueType.STRING_ARRAY), String[].class, "com.obric.memorydata.plugin");
    L5:
        return com.bytedance.ies.abmock.datacenter.storage.g.f2718b.a(r13);
    }

    public void b() {
        this.e.clear();
        if (this.i == false) goto L14;
        Iterator<Map.Entry<String, Object>> r0 = this.c.entrySet().iterator();
    L6:
        if (r0.hasNext() == false) goto L24;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L6;
        if (r1.getValue() != j) goto L6;
        if (r1.getKey() == null) goto L6;
        this.c.remove(r1.getKey());
        this.d.remove(r1.getKey());
        goto L6
    L24:
        return;
    }

    public boolean b(String r1) {
        return com.bytedance.ies.abmock.datacenter.storage.a.f2706b.c(r1);
    }

    public k c() {
        return this.g;
    }

    public void c(String r2) {
        if (r2 == null) goto L5;
        this.c.remove(r2);
        this.e.remove(r2);
        this.d.remove(r2);
        return;
    }
}
