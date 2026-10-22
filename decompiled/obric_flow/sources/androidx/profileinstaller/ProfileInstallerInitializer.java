package androidx.profileinstaller;

import android.content.Context;
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
    public static class Choreographer16Impl {
        private Choreographer16Impl() {
        }

        public static /* synthetic */ void a(long r5, Runnable r10) {
            lambda$postFrameCallback$0(r10, r5);
        }

        private static /* synthetic */ void lambda$postFrameCallback$0(Runnable r5, long r10) {
            r5.run();
        }

        @DoNotInline
        public static void postFrameCallback(final Runnable r5) {
            Choreographer.getInstance().postFrameCallback(new d(r5));
        }
    }

    @RequiresApi(28)
    public static class Handler28Impl {
        private Handler28Impl() {
        }

        @DoNotInline
        public static Handler createAsync(Looper r5) {
            return Handler.createAsync(r5);
        }
    }

    public static class Result {
        public Result() {
        }
    }

    public ProfileInstallerInitializer() {
    }

    public static /* synthetic */ void a(ProfileInstallerInitializer r5, Context r10) {
        r5.lambda$delayAfterFirstFrame$0(r10);
    }

    public static /* synthetic */ void b(Context r5) {
        lambda$writeInBackground$2(r5);
    }

    public static /* synthetic */ void c(Context r5) {
        lambda$installAfterDelay$1(r5);
    }

    private /* synthetic */ void lambda$delayAfterFirstFrame$0(Context r5) {
        installAfterDelay(r5);
    }

    private static /* synthetic */ void lambda$installAfterDelay$1(Context r5) {
        writeInBackground(r5);
    }

    private static /* synthetic */ void lambda$writeInBackground$2(Context r5) {
        ProfileInstaller.writeProfile(r5);
    }

    private static void writeInBackground(@NonNull Context r10) {
        new ThreadPoolExecutor(0, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new c(r10, 1));
    }

    @Override // androidx.startup.Initializer
    @NonNull
    public /* bridge */ /* synthetic */ Result create(@NonNull Context r5) {
        return create(r5);
    }

    @RequiresApi(16)
    public void delayAfterFirstFrame(@NonNull Context r5) {
        Choreographer16Impl.postFrameCallback(new a2.b(3, this, r5));
    }

    @Override // androidx.startup.Initializer
    @NonNull
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.emptyList();
    }

    public void installAfterDelay(@NonNull Context r5) {
        Handler28Impl.createAsync(Looper.getMainLooper()).postDelayed(new c(r5, 0), new Random().nextInt(Math.max(1000, 1)) + DELAY_MS);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.startup.Initializer
    @NonNull
    public Result create(@NonNull Context r5) {
        delayAfterFirstFrame(r5.getApplicationContext());
        return new Result();
    }
}
