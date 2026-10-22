package com.bytedance.retrofit2;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: classes.dex */
class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final q f2615a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f2616b = false;

    static class a extends q {

        /* JADX INFO: renamed from: com.bytedance.retrofit2.q$a$a, reason: collision with other inner class name */
        static class ExecutorC0071a implements Executor {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final Handler f2617c;

            ExecutorC0071a() {
                this.f2617c = new Handler(Looper.getMainLooper());
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable r10) {
                this.f2617c.post(r10);
            }
        }

        a() {
        }

        @Override // com.bytedance.retrofit2.q
        List<? extends c.a> a(Executor r10) {
            if (r10 == null) goto L6;
            return Collections.singletonList(new j(r10));
        L6:
            throw new AssertionError();
        }

        @Override // com.bytedance.retrofit2.q
        public Executor b() {
            return new ExecutorC0071a();
        }

        @Override // com.bytedance.retrofit2.q
        List<? extends f.a> c() {
            return Collections.emptyList();
        }

        @Override // com.bytedance.retrofit2.q
        int d() {
            return 0;
        }

        @Override // com.bytedance.retrofit2.q
        boolean i(Method r10) {
            if (Build.VERSION.SDK_INT >= 24) goto L7;
            return false;
        L7:
            return r10.isDefault();
        }
    }

    static {
        f2615a = e();
        f2616b = f();
    }

    q() {
    }

    private static q e() {
        Class.forName("android.os.Build");     // Catch: ClassNotFoundException -> L8
        if (Build.VERSION.SDK_INT == 0) goto L7;
        return new a();
    L7:
        return new q();
    }

    private static boolean f() {
        new Retrofit.Builder();     // Catch: NoClassDefFoundError -> L5
        return true;
    L5:
        return false;
    }

    static q g() {
        return f2615a;
    }

    static boolean j() {
        return f2616b;
    }

    List<? extends c.a> a(Executor r10) {
        if (r10 == null) goto L6;
        Object r11 = new j(r10);
    L5:
        return Collections.singletonList(r11);
    L6:
        r11 = g.f2509a;
        goto L5
    }

    public Executor b() {
        return null;
    }

    List<? extends f.a> c() {
        return Collections.emptyList();
    }

    int d() {
        return 0;
    }

    Object h(Method r10, Class<?> r11, Object r12, Object... r13) {
        throw new UnsupportedOperationException();
    }

    boolean i(Method r10) {
        return false;
    }
}
