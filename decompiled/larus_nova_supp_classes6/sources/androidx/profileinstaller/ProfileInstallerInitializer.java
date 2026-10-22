package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.startup.Initializer;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class ProfileInstallerInitializer implements Initializer<Result> {
    private static final int DELAY_MS = 5000;

    public static class Handler28Impl {
        private Handler28Impl() {
        }

        public static Handler createAsync(Looper r0) {
            return Handler.createAsync(r0);
        }
    }

    public static class Result {
        public Result() {
        }
    }

    public ProfileInstallerInitializer() {
    }

    public static /* synthetic */ void a(ProfileInstallerInitializer r0, Context r1, long r2) {
        r0.lambda$create$0(r1, r2);
    }

    public static /* synthetic */ void b(Context r0) {
        lambda$installAfterDelay$1(r0);
    }

    public static /* synthetic */ void c(Context r0) {
        lambda$writeInBackground$2(r0);
    }

    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.emptyList();
    }

    private static /* synthetic */ void lambda$installAfterDelay$1(Context r0) {
        writeInBackground(r0);
    }

    private static /* synthetic */ void lambda$writeInBackground$2(Context r0) {
        ProfileInstaller.writeProfile(r0);
    }

    private static void writeInBackground(final Context r9) {
        new PThreadPoolExecutor(0, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("ProfileInstallerInitializer")).execute(new f(r9));
    }

    public Result create(Context r3) {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        final Context r4 = r3.getApplicationContext();
        Choreographer.getInstance().postFrameCallback(new g(this, r4));
        return new Result();
    L5:
        return new Result();
    }

    public void installAfterDelay(final Context r6) {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        Handler r0 = Handler28Impl.createAsync(Looper.getMainLooper());
    L6:
        r0.postDelayed(new e(r6), new Random().nextInt(Math.max(1000, 1)) + DELAY_MS);
        return;
    L5:
        r0 = new Handler(Looper.getMainLooper());
        goto L6
    }

    /* JADX INFO: renamed from: create, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m2create(Context r1) {
        return create(r1);
    }

    private /* synthetic */ void lambda$create$0(Context r1, long r2) {
        installAfterDelay(r1);
    }
}
