package com.bytedance.ies.abmock;

import com.bytedance.ies.abmock.datacenter.k;
import com.bytedance.ies.abmock.datacenter.storage.j;
import com.google.gson.JsonObject;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class ABManager {
    private static volatile boolean enableInstanceOpt;
    private static volatile ABManager sInstance;
    private String TAG;
    private final Map<String, Object> mABCaches;
    private final com.bytedance.ies.abmock.datacenter.c mABValueProvider;

    /* JADX INFO: renamed from: com.bytedance.ies.abmock.ABManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final ABManager f2653a = null;

        static {
            f2653a = new ABManager(null);
        }
    }

    private ABManager() {
        this.TAG = "ABManager";
        this.mABCaches = new ConcurrentHashMap();
        this.mABValueProvider = new com.bytedance.ies.abmock.datacenter.a();
    }

    /* synthetic */ ABManager(AnonymousClass1 r1) {
        this();
    }

    private com.bytedance.ies.abmock.a getABConfigInterceptor() {
        return ConfigurationManager.a().e();
    }

    private String getABKey(Class r2) {
        com.bytedance.ies.abmock.a.a r1 = (com.bytedance.ies.abmock.a.a) ZeusTransformUtils.preCheckCast(r2.getAnnotation(com.bytedance.ies.abmock.a.a.class), com.bytedance.ies.abmock.a.a.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
        return null;
    L5:
        return r1.a();
    }

    private int getABType(Class r2) {
        com.bytedance.ies.abmock.a.a r1 = (com.bytedance.ies.abmock.a.a) ZeusTransformUtils.preCheckCast(r2.getAnnotation(com.bytedance.ies.abmock.a.a.class), com.bytedance.ies.abmock.a.a.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L9;
        if (r1.d() == false) goto L9;
        return com.bytedance.ies.abmock.datacenter.b.f2668b;
    L9:
        return com.bytedance.ies.abmock.datacenter.b.f2667a;
    }

    private <T> T getCustomTypeDefaultValue(Class r8) {
        Field[] r7 = r8.getDeclaredFields();
        if (r7 == null) goto L22;
        int r9 = r7.length;
        int r0 = 0;
        Field r2 = null;
    L5:
        if (r0 >= r9) goto L13;
        Field r3 = r7[r0];
        com.bytedance.ies.abmock.a.c r4 = (com.bytedance.ies.abmock.a.c) ZeusTransformUtils.preCheckCast(r3.getAnnotation(com.bytedance.ies.abmock.a.c.class), com.bytedance.ies.abmock.a.c.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L12;
        if (r4.a() == true) goto L10;
        r2 = r3;
        goto L12
    L10:
        r2 = r3;
    L12:
        r0 = r0 + 1;
    L13:
        if (r2 == null) goto L20;
        r2.setAccessible(true);
        return (T) r2.get(null);
    L17:
        e = move-exception;
        e.printStackTrace();
        throw new RuntimeException(e.getMessage());
    L20:
        return null;
    L22:
        throw new RuntimeException("GetCustomTypeDefaultValue method, get defaultField failed");
    }

    public static ABManager getInstance() {
        if (enableInstanceOpt == false) goto L7;
        return getInstanceV2();
    L7:
        return getInstanceV1();
    }

    private static ABManager getInstanceV1() {
        if (sInstance != null) goto L15;
        monitor-enter(ABManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new ABManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ABManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private static ABManager getInstanceV2() {
        return a.f2653a;
    }

    private Object getValueFromMockOrCache(boolean r2, String r3, boolean r4) {
        if (r4 == false) goto L14;
        k r5 = ConfigurationManager.a().d();
        if (r5 == null) goto L14;
        if (r5.b() == null) goto L14;
        if (r5.b().a() == false) goto L14;
        if (r5.a() == false) goto L14;
        Object r6 = r5.b().a(r3);
        if (r6 == null) goto L14;
        return r6;
    L14:
        if (r2 == false) goto L18;
        Object r1 = this.mABCaches.get(r3);
        if (r1 == null) goto L20;
        return r1;
    L20:
        return null;
    L18:
        return null;
    }

    private Object getValueOfClientExperiment(String r5) {
        return ZeusTransformUtils.forName("com.bytedance.ies.abmock.ClientExpManager", "com.obric.memorydata.plugin").getDeclaredMethod(r5, new Class[0]).invoke(null, new Object[0]);
    L5:
        th = move-exception;
        com.bytedance.ies.abmock.datacenter.event.a.a(th, this.TAG);
        return null;
    }

    private boolean isClientExperiment(Class r2) {
        com.bytedance.ies.abmock.a.a r1 = (com.bytedance.ies.abmock.a.a) ZeusTransformUtils.preCheckCast(r2.getAnnotation(com.bytedance.ies.abmock.a.a.class), com.bytedance.ies.abmock.a.a.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
        return false;
    L5:
        return r1.b();
    }

    private boolean isNeedCache(Class r1) {
        if (r1.getAnnotation(com.bytedance.ies.abmock.a.d.class) != null) goto L5;
        return true;
    L5:
        return false;
    }

    static /* synthetic */ Object lambda$getValue$10(String r0, Object r1, Boolean r2, Integer r3, Integer r4, Class r5) {
        return b.a().a(r0, r2.booleanValue(), r3.intValue());
    }

    private void saveInCache(String r1, boolean r2, Object r3) {
        if (r2 == false) goto L6;
        if (r3 == null) goto L7;
        this.mABCaches.put(r1, r3);
        return;
    L7:
        return;
    }

    public static void setEnableInstanceOpt(boolean r0) {
        enableInstanceOpt = r0;
    }

    public void emptyMethod(Class r1) {
    }

    public Map<String, Object> getABCaches() {
        return this.mABCaches;
    }

    com.bytedance.ies.abmock.datacenter.c getABValueProvider() {
        return this.mABValueProvider;
    }

    public boolean getBooleanValue(Class r4) {
        String r0 = getABKey(r4);
        if (com.bytedance.ies.abmock.datacenter.b.c(getABType(r4)) == false) goto L11;
        if (getABConfigInterceptor() == null) goto L11;
        Boolean r1 = getABConfigInterceptor().b(r0, isNeedCache(r4));
        if (r1 == null) goto L11;
        return r1.booleanValue();
    L11:
        if (isClientExperiment(r4) == false) goto L15;
        return ((Boolean) ZeusTransformUtils.preCheckCast(getValueForClientExp(r0, isNeedCache(r4)), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L15:
        return b.a().b(r4);
    }

    public boolean getBooleanValue(Class r3, String r4) {
        String r5 = getABKey(r3) + "$$$" + r4;     // Catch: Throwable -> L10
        if (com.bytedance.ies.abmock.datacenter.b.c(getABType(r3)) == true) goto L5;
        return false;
    L5:
        if (getABConfigInterceptor() == null) goto L17;
        Boolean r6 = getABConfigInterceptor().b(r5, isNeedCache(r3));     // Catch: Throwable -> L10
        if (r6 == null) goto L18;
        return r6.booleanValue();
    L18:
        return false;
    L17:
        return false;
    L10:
        th = move-exception;
        com.bytedance.ies.abmock.datacenter.event.a.a(th, this.TAG);
        return false;
    }

    @Deprecated
    public boolean getBooleanValue(boolean r7, String r8, int r9, boolean r10) {
        return getBooleanValue(r7, r8, r9, r10, com.bytedance.ies.abmock.datacenter.b.f2667a);
    }

    @Deprecated
    public boolean getBooleanValue(boolean r9, String r10, int r11, boolean r12, int r13) {
        Boolean r8 = (Boolean) ZeusTransformUtils.preCheckCast(com.bytedance.ies.abmock.datacenter.event.a.a().a(r10, Boolean.valueOf(r12), r9, r13, r11, null, new $$Lambda$ABManager$ZOrDaV4178AUQTUFkWDorZfEjNU(this)), Boolean.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L6;
        return r12;
    L6:
        return r8.booleanValue();
    }

    @Deprecated
    public boolean getBooleanValue(boolean r9, String r10, boolean r11) {
        Boolean r8 = (Boolean) ZeusTransformUtils.preCheckCast(com.bytedance.ies.abmock.datacenter.event.a.a().a(r10, Boolean.valueOf(r11), r9, 0, 0, null, new $$Lambda$ABManager$JvL_prlh_rqPg9WuKQk6VRvPyYU(this)), Boolean.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L6;
        return r11;
    L6:
        return r8.booleanValue();
    }

    @Deprecated
    public <T> T getClientExpInner(boolean r2, String r3, T r4) {
        T r0 = (T) getValueFromMockOrCache(r2, r3, true);
        if (r0 == null) goto L5;
        return r0;
    L5:
        saveInCache(r3, r2, r4);
        return r4;
    }

    public double getDoubleValue(Class r3) {
        String r0 = getABKey(r3);
        if (com.bytedance.ies.abmock.datacenter.b.c(getABType(r3)) == false) goto L11;
        if (getABConfigInterceptor() == null) goto L11;
        Double r2 = getABConfigInterceptor().d(r0, isNeedCache(r3));
        if (r2 == null) goto L11;
        return r2.doubleValue();
    L11:
        return b.a().d(r3);
    }

    @Deprecated
    public double getDoubleValue(boolean r8, String r9, int r10, double r11) {
        return getDoubleValue(r8, r9, r10, r11, com.bytedance.ies.abmock.datacenter.b.f2667a);
    }

    @Deprecated
    public double getDoubleValue(boolean r9, String r10, int r11, double r12, int r14) {
        Double r8 = (Double) ZeusTransformUtils.preCheckCast(com.bytedance.ies.abmock.datacenter.event.a.a().a(r10, Double.valueOf(r12), r9, r14, r11, null, new $$Lambda$ABManager$ub27rJuof2aF9xRQ5qu0JRSuaFk(this)), Double.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L6;
        return r12;
    L6:
        return r8.doubleValue();
    }

    public float getFloatValue(Class r3) {
        String r0 = getABKey(r3);
        if (com.bytedance.ies.abmock.datacenter.b.c(getABType(r3)) == false) goto L11;
        if (getABConfigInterceptor() == null) goto L11;
        Float r2 = getABConfigInterceptor().e(r0, isNeedCache(r3));
        if (r2 == null) goto L11;
        return r2.floatValue();
    L11:
        return b.a().e(r3);
    }

    @Deprecated
    public float getFloatValue(boolean r7, String r8, int r9, float r10) {
        return getFloatValue(r7, r8, r9, r10, com.bytedance.ies.abmock.datacenter.b.f2667a);
    }

    @Deprecated
    public float getFloatValue(boolean r9, String r10, int r11, float r12, int r13) {
        Float r8 = (Float) ZeusTransformUtils.preCheckCast(com.bytedance.ies.abmock.datacenter.event.a.a().a(r10, Float.valueOf(r12), r9, r13, r11, null, new $$Lambda$ABManager$68xyjbaoQc3pZCGoWZWoKPGMf40(this)), Float.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L6;
        return r12;
    L6:
        return r8.floatValue();
    }

    public int getIntValue(Class r4) {
        String r0 = getABKey(r4);
        if (com.bytedance.ies.abmock.datacenter.b.c(getABType(r4)) == false) goto L11;
        if (getABConfigInterceptor() == null) goto L11;
        Integer r1 = getABConfigInterceptor().a(r0, isNeedCache(r4));
        if (r1 == null) goto L11;
        return r1.intValue();
    L11:
        if (isClientExperiment(r4) == false) goto L15;
        return ((Integer) ZeusTransformUtils.preCheckCast(getValueForClientExp(r0, isNeedCache(r4)), Integer.class, "com.obric.memorydata.plugin")).intValue();
    L15:
        return b.a().a(r4);
    }

    @Deprecated
    public int getIntValue(boolean r9, String r10, int r11) {
        Integer r8 = (Integer) ZeusTransformUtils.preCheckCast(com.bytedance.ies.abmock.datacenter.event.a.a().a(r10, Integer.valueOf(r11), r9, 0, 0, null, new $$Lambda$ABManager$Y5ov77iJF0_83v0rJY9hhZntJds(this)), Integer.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L6;
        return r11;
    L6:
        return r8.intValue();
    }

    @Deprecated
    public int getIntValue(boolean r7, String r8, int r9, int r10) {
        return getIntValue(r7, r8, r9, r10, com.bytedance.ies.abmock.datacenter.b.f2667a);
    }

    @Deprecated
    public int getIntValue(boolean r9, String r10, int r11, int r12, int r13) {
        Integer r8 = (Integer) ZeusTransformUtils.preCheckCast(com.bytedance.ies.abmock.datacenter.event.a.a().a(r10, Integer.valueOf(r12), r9, r13, r11, null, new $$Lambda$ABManager$U2FfzFGkCWtBAKNExbmx4kf96bo(this)), Integer.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L6;
        return r12;
    L6:
        return r8.intValue();
    }

    public long getLongValue(Class r3) {
        String r0 = getABKey(r3);
        if (com.bytedance.ies.abmock.datacenter.b.c(getABType(r3)) == false) goto L11;
        if (getABConfigInterceptor() == null) goto L11;
        Long r2 = getABConfigInterceptor().f(r0, isNeedCache(r3));
        if (r2 == null) goto L11;
        return r2.longValue();
    L11:
        return b.a().f(r3);
    }

    @Deprecated
    public long getLongValue(boolean r8, String r9, int r10, long r11) {
        return getLongValue(r8, r9, r10, r11, com.bytedance.ies.abmock.datacenter.b.f2667a);
    }

    @Deprecated
    public long getLongValue(boolean r9, String r10, int r11, long r12, int r14) {
        Long r8 = (Long) ZeusTransformUtils.preCheckCast(com.bytedance.ies.abmock.datacenter.event.a.a().a(r10, Long.valueOf(r12), r9, r14, r11, null, new $$Lambda$ABManager$jNYM2lgsk61f3UMvMKLEo4WfOqA(this)), Long.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L6;
        return r12;
    L6:
        return r8.longValue();
    }

    public String getStringValue(Class r4) {
        String r0 = getABKey(r4);
        if (com.bytedance.ies.abmock.datacenter.b.c(getABType(r4)) == false) goto L10;
        if (getABConfigInterceptor() == null) goto L10;
        String r1 = getABConfigInterceptor().c(r0, isNeedCache(r4));
        if (r1 == null) goto L10;
        return r1;
    L10:
        if (isClientExperiment(r4) == false) goto L14;
        return (String) ZeusTransformUtils.preCheckCast(getValueForClientExp(r0, isNeedCache(r4)), String.class, "com.obric.memorydata.plugin");
    L14:
        return b.a().c(r4);
    }

    @Deprecated
    public String getStringValue(boolean r7, String r8, int r9, String r10) {
        return getStringValue(r7, r8, r9, r10, com.bytedance.ies.abmock.datacenter.b.f2667a);
    }

    @Deprecated
    public String getStringValue(boolean r9, String r10, int r11, String r12, int r13) {
        String r8 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.ies.abmock.datacenter.event.a.a().a(r10, r12, r9, r13, r11, null, new $$Lambda$ABManager$sgaCXUfmUaDnd76dTcoWXwCIs(this)), String.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L6;
        return r12;
    L6:
        return r8;
    }

    @Deprecated
    public String getStringValue(boolean r9, String r10, String r11) {
        String r8 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.ies.abmock.datacenter.event.a.a().a(r10, r11, r9, 0, 0, null, new $$Lambda$ABManager$mQG3wM5CEDbdAgEP5yC8tOEDZc(this)), String.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L6;
        return r11;
    L6:
        return r8;
    }

    @Deprecated
    public <T> T getValue(Class r1) {
        return (T) b.a().g(r1);
    }

    @Deprecated
    public <T> T getValue(boolean r2, String r3, int r4) {
        return (T) getValue(r2, r3, r4, com.bytedance.ies.abmock.datacenter.b.f2667a);
    }

    @Deprecated
    public <T> T getValue(boolean r9, String r10, int r11, int r12) {
        return (T) com.bytedance.ies.abmock.datacenter.event.a.a().a(r10, null, r9, r12, r11, null, $$Lambda$ABManager$39YkRcwSqlN1PlXLeIzNiMleih0.INSTANCE);
    }

    @Deprecated
    public <T> T getValue(boolean r7, String r8, int r9, Class r10) {
        return (T) getValue(r7, r8, r9, r10, com.bytedance.ies.abmock.datacenter.b.f2667a);
    }

    @Deprecated
    public <T> T getValue(boolean r1, String r2, int r3, Class r4, int r5) {
        return (T) b.a().a(r2, r1, r4, r5);
    }

    @Deprecated
    public <T> T getValueForClientExp(String r2, boolean r3) {
        T r0 = (T) getValueFromMockOrCache(r3, r2, true);
        if (r0 == null) goto L5;
        return r0;
    L5:
        T r1 = (T) getValueOfClientExperiment(r2);
        if (r1 == null) goto L8;
        saveInCache(r2, r3, r1);
    L8:
        return r1;
    }

    public <T> T getValueSafely(Class r5) {
        String r0 = getABKey(r5);     // Catch: Throwable -> L15
        if (com.bytedance.ies.abmock.datacenter.b.c(getABType(r5)) == true) goto L5;
    L9:
        T r1 = (T) getValue(r5);
        if (r1 == null) goto L12;
        return r1;
    L12:
        if (com.bytedance.ies.abmock.datacenter.d.a().b(r0) == false) goto L21;
        return (T) getCustomTypeDefaultValue(r5);
    L21:
        return r1;
    L5:
        if (getABConfigInterceptor() == null) goto L9;
        T r2 = (T) getABConfigInterceptor().a(r0, getCustomTypeDefaultValue(r5), isNeedCache(r5));
        if (r2 == null) goto L9;
        return r2;
    L15:
        th = move-exception;
        com.bytedance.ies.abmock.datacenter.event.a.a(th, this.TAG);
        return (T) getCustomTypeDefaultValue(r5);
    }

    @Deprecated
    public <T> T getValueSafely(boolean r8, String r9, int r10, Class r11, Object r12) {
        return (T) getValueSafely(r8, r9, r10, r11, r12, com.bytedance.ies.abmock.datacenter.b.f2667a);
    }

    @Deprecated
    public <T> T getValueSafely(boolean r9, String r10, int r11, Class r12, T r13, int r14) {
        return (T) com.bytedance.ies.abmock.datacenter.event.a.a().a(r10, r13, r9, r14, r11, r12, new $$Lambda$ABManager$sClxIOXcI6hv8MLy7YSEa3oqCOc(this));
    }

    @Deprecated
    public <T> T getValueSafely(boolean r7, String r8, int r9, Object r10) {
        return (T) getValueSafely(r7, r8, r9, r10, com.bytedance.ies.abmock.datacenter.b.f2667a);
    }

    @Deprecated
    public <T> T getValueSafely(boolean r9, String r10, int r11, T r12, int r13) {
        return (T) com.bytedance.ies.abmock.datacenter.event.a.a().a(r10, r12, r9, r13, r11, null, new $$Lambda$ABManager$p7_b_syFiZCFWVkYEp4VF5VdqxE(this));
    }

    public /* synthetic */ Boolean lambda$getBooleanValue$0$ABManager(String r1, Boolean r2, Boolean r3, Integer r4, Integer r5, Class r6) {
        if (com.bytedance.ies.abmock.datacenter.b.c(r4.intValue()) == false) goto L10;
        if (getABConfigInterceptor() == null) goto L10;
        Boolean r0 = getABConfigInterceptor().b(r1, r3.booleanValue());
        if (r0 == null) goto L10;
        return r0;
    L10:
        return Boolean.valueOf(b.a().a(r1, r2.booleanValue(), r3.booleanValue(), r4.intValue()));
    }

    public /* synthetic */ Boolean lambda$getBooleanValue$7$ABManager(String r1, Boolean r2, Boolean r3, Integer r4, Integer r5, Class r6) {
        return (Boolean) ZeusTransformUtils.preCheckCast(getClientExpInner(r3.booleanValue(), r1, r2), Boolean.class, "com.obric.memorydata.plugin");
    }

    public /* synthetic */ Double lambda$getDoubleValue$5$ABManager(String r7, Double r8, Boolean r9, Integer r10, Integer r11, Class r12) {
        if (com.bytedance.ies.abmock.datacenter.b.c(r10.intValue()) == false) goto L10;
        if (getABConfigInterceptor() == null) goto L10;
        Double r6 = getABConfigInterceptor().d(r7, r9.booleanValue());
        if (r6 == null) goto L10;
        return r6;
    L10:
        return Double.valueOf(b.a().a(r7, r8.doubleValue(), r9.booleanValue(), r10.intValue()));
    }

    public /* synthetic */ Float lambda$getFloatValue$4$ABManager(String r1, Float r2, Boolean r3, Integer r4, Integer r5, Class r6) {
        if (com.bytedance.ies.abmock.datacenter.b.c(r4.intValue()) == false) goto L10;
        if (getABConfigInterceptor() == null) goto L10;
        Float r0 = getABConfigInterceptor().e(r1, r3.booleanValue());
        if (r0 == null) goto L10;
        return r0;
    L10:
        return Float.valueOf(b.a().a(r1, r2.floatValue(), r3.booleanValue(), r4.intValue()));
    }

    public /* synthetic */ Integer lambda$getIntValue$1$ABManager(String r1, Integer r2, Boolean r3, Integer r4, Integer r5, Class r6) {
        if (com.bytedance.ies.abmock.datacenter.b.c(r4.intValue()) == false) goto L10;
        if (getABConfigInterceptor() == null) goto L10;
        Integer r0 = getABConfigInterceptor().a(r1, r3.booleanValue());
        if (r0 == null) goto L10;
        return r0;
    L10:
        return Integer.valueOf(b.a().a(r1, r2.intValue(), r3.booleanValue(), r4.intValue()));
    }

    public /* synthetic */ Integer lambda$getIntValue$6$ABManager(String r1, Integer r2, Boolean r3, Integer r4, Integer r5, Class r6) {
        return (Integer) ZeusTransformUtils.preCheckCast(getClientExpInner(r3.booleanValue(), r1, r2), Integer.class, "com.obric.memorydata.plugin");
    }

    public /* synthetic */ Long lambda$getLongValue$3$ABManager(String r7, Long r8, Boolean r9, Integer r10, Integer r11, Class r12) {
        if (com.bytedance.ies.abmock.datacenter.b.c(r10.intValue()) == false) goto L10;
        if (getABConfigInterceptor() == null) goto L10;
        Long r6 = getABConfigInterceptor().f(r7, r9.booleanValue());
        if (r6 == null) goto L10;
        return r6;
    L10:
        return Long.valueOf(b.a().a(r7, r8.longValue(), r9.booleanValue(), r10.intValue()));
    }

    public /* synthetic */ String lambda$getStringValue$2$ABManager(String r1, String r2, Boolean r3, Integer r4, Integer r5, Class r6) {
        if (com.bytedance.ies.abmock.datacenter.b.c(r4.intValue()) == false) goto L10;
        if (getABConfigInterceptor() == null) goto L10;
        String r0 = getABConfigInterceptor().c(r1, r3.booleanValue());
        if (r0 == null) goto L10;
        return r0;
    L10:
        return b.a().a(r1, r2, r3.booleanValue(), r4.intValue());
    }

    public /* synthetic */ String lambda$getStringValue$8$ABManager(String r1, String r2, Boolean r3, Integer r4, Integer r5, Class r6) {
        return (String) ZeusTransformUtils.preCheckCast(getClientExpInner(r3.booleanValue(), r1, r2), String.class, "com.obric.memorydata.plugin");
    }

    public /* synthetic */ Object lambda$getValueSafely$11$ABManager(String r2, Object r3, Boolean r4, Integer r5, Integer r6, Class r7) {
        if (com.bytedance.ies.abmock.datacenter.b.c(r5.intValue()) == true) goto L5;
    L9:
        Object r1 = getValue(r4.booleanValue(), r2, r6.intValue(), r5.intValue());
        if (r1 != null) goto L15;
        if (com.bytedance.ies.abmock.datacenter.d.a().b(r2) == false) goto L15;
        return r3;
    L15:
        return r1;
    L5:
        if (getABConfigInterceptor() == null) goto L9;
        Object r8 = getABConfigInterceptor().a(r2, r3, r4.booleanValue());
        if (r8 == null) goto L9;
        return r8;
    }

    public /* synthetic */ Object lambda$getValueSafely$9$ABManager(String r8, Object r9, Boolean r10, Integer r11, Integer r12, Class r13) {
        if (com.bytedance.ies.abmock.datacenter.b.c(r11.intValue()) == true) goto L5;
    L9:
        Object r7 = getValue(r10.booleanValue(), r8, r12.intValue(), r13, r11.intValue());
        if (r7 != null) goto L15;
        if (com.bytedance.ies.abmock.datacenter.d.a().b(r8) == false) goto L15;
        return r9;
    L15:
        return r7;
    L5:
        if (getABConfigInterceptor() == null) goto L9;
        Object r0 = getABConfigInterceptor().a(r8, r9, r10.booleanValue());
        if (r0 == null) goto L9;
        return r0;
    }

    public void removeCacheForKey(String r1) {
        if (r1 == null) goto L5;
        this.mABCaches.remove(r1);
        return;
    }

    @Deprecated
    public boolean saveABValue(JsonObject r1) {
        com.bytedance.ies.abmock.datacenter.d.a().b();
        j.a(r1);
        return true;
    }
}
