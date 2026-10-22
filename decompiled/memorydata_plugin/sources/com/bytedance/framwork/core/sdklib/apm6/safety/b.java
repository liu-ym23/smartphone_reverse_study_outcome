package com.bytedance.framwork.core.sdklib.apm6.safety;

/* JADX INFO: loaded from: classes2.dex */
public class b extends c.a {

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f2616a = null;

        static {
            f2616a = new b();
        }

        static /* synthetic */ b a() {
            return f2616a;
        }
    }

    public b() {
    }

    public static b a() {
        return a.a();
    }

    @Override // com.bytedance.framwork.core.sdklib.apm6.safety.c.a, com.bytedance.apm6.util.log.ILogger
    public void e(String r1, String r2) {
        super.e(r1, r2);
        com.bytedance.framwork.core.sdklib.apm6.safety.a.a(r1, r2, null);
    }

    @Override // com.bytedance.framwork.core.sdklib.apm6.safety.c.a, com.bytedance.apm6.util.log.ILogger
    public void e(String r1, String r2, Throwable r3) {
        super.e(r1, r2, r3);
        com.bytedance.framwork.core.sdklib.apm6.safety.a.a(r1, r2, r3);
    }

    @Override // com.bytedance.framwork.core.sdklib.apm6.safety.c.a, com.bytedance.apm6.util.log.ILogger
    public void wtf(String r1, String r2) {
        super.wtf(r1, r2);
        com.bytedance.framwork.core.sdklib.apm6.safety.a.a(r1, r2, null);
    }

    @Override // com.bytedance.framwork.core.sdklib.apm6.safety.c.a, com.bytedance.apm6.util.log.ILogger
    public void wtf(String r1, String r2, Throwable r3) {
        super.wtf(r1, r2, r3);
        com.bytedance.framwork.core.sdklib.apm6.safety.a.a(r1, r2, r3);
    }
}
