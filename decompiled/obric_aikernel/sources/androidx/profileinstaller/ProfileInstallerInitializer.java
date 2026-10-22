package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.startup.Initializer;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class ProfileInstallerInitializer implements Initializer<Result> {
    private static final int DELAY_MS = 5000;

    @RequiresApi(16)
    private static class Choreographer16Impl {
        private Choreographer16Impl() {
        }

        public static /* synthetic */ void a(Runnable r10, long r11) {
            lambda$postFrameCallback$0(r10, r11);
        }

        private static /* synthetic */ void lambda$postFrameCallback$0(Runnable r10, long r11) {
            r10.run();
        }

        @DoNotInline
        public static void postFrameCallback(final Runnable r10) {
            Choreographer.getInstance().postFrameCallback(new h(r10));
        }
    }

    @RequiresApi(28)
    private static class Handler28Impl {
        private Handler28Impl() {
        }

        @DoNotInline
        public static Handler createAsync(Looper r10) {
            return Handler.createAsync(r10);
        }
    }

    public static class Result {
        public Result() {
        }
    }

    public ProfileInstallerInitializer() {
    }

    public static /* synthetic */ void a(ProfileInstallerInitializer r10, Context r11) {
        r10.lambda$delayAfterFirstFrame$0(r11);
    }

    public static /* synthetic */ void b(Context r10) {
        lambda$installAfterDelay$1(r10);
    }

    public static /* synthetic */ void c(Context r10) {
        lambda$writeInBackground$2(r10);
    }

    private /* synthetic */ void lambda$delayAfterFirstFrame$0(Context r10) {
        installAfterDelay(r10);
    }

    private static /* synthetic */ void lambda$installAfterDelay$1(Context r10) {
        writeInBackground(r10);
    }

    private static /* synthetic */ void lambda$writeInBackground$2(Context r10) {
        ProfileInstaller.writeProfile(r10);
    }

    private static void writeInBackground(@NonNull final Context r10) {
        new ThreadPoolExecutor(0, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new f(r10));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.startup.Initializer
    @NonNull
    public Result create(@NonNull Context r10) {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        delayAfterFirstFrame(r10.getApplicationContext());
        return new Result();
    L5:
        return new Result();
    }

    @Override // androidx.startup.Initializer
    @NonNull
    public /* bridge */ /* synthetic */ Result create(@NonNull Context r10) {
        return create(r10);
    }

    @RequiresApi(16)
    void delayAfterFirstFrame(@NonNull final Context r10) {
        Choreographer16Impl.postFrameCallback(new g(this, r10));
    }

    @Override // androidx.startup.Initializer
    @NonNull
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.emptyList();
    }

    void installAfterDelay(@NonNull final Context r10) {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        Handler r11 = Handler28Impl.createAsync(Looper.getMainLooper());
    L6:
        r11.postDelayed(new e(r10), new Random().nextInt(Math.max(1000, 1)) + DELAY_MS);
        return;
    L5:
        r11 = new Handler(Looper.getMainLooper());
        goto L6
    }
}
