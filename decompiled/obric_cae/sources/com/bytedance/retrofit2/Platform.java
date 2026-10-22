package com.bytedance.retrofit2;

import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
class Platform {
    private static final Platform PLATFORM = null;
    private static final boolean SQUARE_RETROFIT_EXISTS = false;

    public static class Android extends Platform {

        public static class MainThreadExecutor implements Executor {
            private final Handler handler;

            public MainThreadExecutor() {
                this.handler = new Handler(Looper.getMainLooper());
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable r8) {
                this.handler.post(r8);
            }
        }

        public Android() {
        }

        @Override // com.bytedance.retrofit2.Platform
        public CallAdapter.Factory defaultCallAdapterFactory(Executor r8) {
            return new ExecutorCallAdapterFactory(r8);
        }

        @Override // com.bytedance.retrofit2.Platform
        public Executor defaultCallbackExecutor() {
            return new MainThreadExecutor();
        }
    }

    public static class IOS extends Platform {

        public static class MainThreadExecutor implements Executor {
            private static Method addOperation;
            private static Object queue;

            static {
                Class<?> r8 = Class.forName("org.robovm.apple.foundation.NSOperationQueue");     // Catch: Exception -> L4
                queue = r8.getDeclaredMethod("getMainQueue", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L4
                addOperation = r8.getDeclaredMethod("addOperation", new Class[]{Runnable.class});     // Catch: Exception -> L4
                return;
            L4:
                e = move-exception;
                throw new AssertionError(e);
            }

            public MainThreadExecutor() {
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable r8) {
                addOperation.invoke(queue, new Object[]{r8});     // Catch: InvocationTargetException -> L4 Throwable -> L15
                return;
            L15:
                e = move-exception;
                throw new AssertionError(e);
            L4:
                e = move-exception;
                Throwable r10 = e.getCause();
                if ((r10 instanceof RuntimeException) == true) goto L14;
                if ((r10 instanceof Error) == false) goto L12;
                throw ((Error) r10);
            L12:
                throw new RuntimeException(r10);
            L14:
                throw ((RuntimeException) r10);
            }
        }

        public IOS() {
        }

        @Override // com.bytedance.retrofit2.Platform
        public CallAdapter.Factory defaultCallAdapterFactory(Executor r8) {
            return new ExecutorCallAdapterFactory(r8);
        }

        @Override // com.bytedance.retrofit2.Platform
        public Executor defaultCallbackExecutor() {
            return new MainThreadExecutor();
        }
    }

    static {
        PLATFORM = findPlatform();
        SQUARE_RETROFIT_EXISTS = findSquareRetrofit();
    }

    public Platform() {
    }

    private static Platform findPlatform() {
        Class.forName("android.os.Build");     // Catch: ClassNotFoundException -> L4
        return new Android();
    L4:
        Class.forName("org.robovm.apple.foundation.NSObject");     // Catch: ClassNotFoundException -> L6
        return new IOS();
    L7:
        return new Platform();
    }

    private static boolean findSquareRetrofit() {
        new retrofit2.Retrofit.Builder();     // Catch: NoClassDefFoundError -> L5
        return true;
    L5:
        return false;
    }

    public static Platform get() {
        return PLATFORM;
    }

    public static boolean squareRetrofitExists() {
        return SQUARE_RETROFIT_EXISTS;
    }

    public CallAdapter.Factory defaultCallAdapterFactory(Executor r8) {
        if (r8 == null) goto L6;
        return new ExecutorCallAdapterFactory(r8);
    L6:
        return DefaultCallAdapterFactory.INSTANCE;
    }

    public Executor defaultCallbackExecutor() {
        return null;
    }

    public Object invokeDefaultMethod(Method r8, Class<?> r10, Object r11, Object... r12) {
        throw new UnsupportedOperationException();
    }

    public boolean isDefaultMethod(Method r8) {
        return false;
    }
}
