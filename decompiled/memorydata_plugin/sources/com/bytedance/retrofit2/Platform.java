package com.bytedance.retrofit2;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
class Platform {
    private static final Platform PLATFORM = null;
    private static final boolean SQUARE_RETROFIT_EXISTS = false;

    static class Android extends Platform {

        static class MainThreadExecutor implements Executor {
            private final Handler handler;

            MainThreadExecutor() {
                this.handler = new Handler(Looper.getMainLooper());
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable r3) {
                Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
                this.handler.post(r4);
            }
        }

        Android() {
        }

        @Override // com.bytedance.retrofit2.Platform
        List<? extends CallAdapter.Factory> defaultCallAdapterFactories(Executor r2) {
            Executor r1 = (Executor) ZeusTransformUtils.wrapperContextForParams(r2, Executor.class, "com.obric.memorydata.plugin");
            if (r1 == null) goto L7;
            return Collections.singletonList(new ExecutorCallAdapterFactory(r1));
        L7:
            throw new AssertionError();
        }

        @Override // com.bytedance.retrofit2.Platform
        int defaultCallAdapterFactoriesSize() {
            return 1;
        }

        @Override // com.bytedance.retrofit2.Platform
        public Executor defaultCallbackExecutor() {
            return new MainThreadExecutor();
        }

        @Override // com.bytedance.retrofit2.Platform
        List<? extends Converter.Factory> defaultConverterFactories() {
            return Collections.emptyList();
        }

        @Override // com.bytedance.retrofit2.Platform
        int defaultConverterFactoriesSize() {
            return 0;
        }

        @Override // com.bytedance.retrofit2.Platform
        boolean isDefaultMethod(Method r2) {
            if (Build.VERSION.SDK_INT >= 24) goto L7;
            return false;
        L7:
            return r2.isDefault();
        }
    }

    static {
        PLATFORM = findPlatform();
        SQUARE_RETROFIT_EXISTS = findSquareRetrofit();
    }

    Platform() {
    }

    private static Platform findPlatform() {
        ZeusTransformUtils.forName("android.os.Build", "com.obric.memorydata.plugin");     // Catch: ClassNotFoundException -> L8
        if (Build.VERSION.SDK_INT == 0) goto L7;
        return new Android();
    L7:
        return new Platform();
    }

    private static boolean findSquareRetrofit() {
        new retrofit2.Retrofit.Builder();     // Catch: NoClassDefFoundError -> L5
        return true;
    L5:
        return false;
    }

    static Platform get() {
        return PLATFORM;
    }

    static boolean squareRetrofitExists() {
        return SQUARE_RETROFIT_EXISTS;
    }

    List<? extends CallAdapter.Factory> defaultCallAdapterFactories(Executor r2) {
        Executor r1 = (Executor) ZeusTransformUtils.wrapperContextForParams(r2, Executor.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L7;
        return Collections.singletonList(new ExecutorCallAdapterFactory(r1));
    L7:
        return Collections.singletonList(DefaultCallAdapterFactory.INSTANCE);
    }

    int defaultCallAdapterFactoriesSize() {
        return 1;
    }

    public Executor defaultCallbackExecutor() {
        return null;
    }

    List<? extends Converter.Factory> defaultConverterFactories() {
        return Collections.emptyList();
    }

    int defaultConverterFactoriesSize() {
        return 0;
    }

    Object invokeDefaultMethod(Method r1, Class<?> r2, Object r3, Object... r4) {
        throw new UnsupportedOperationException();
    }

    boolean isDefaultMethod(Method r1) {
        return false;
    }
}
