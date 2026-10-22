package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.startup.Initializer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class ProfileInstallerInitializer implements Initializer<Result> {
    private static final int DELAY_MS = 5000;

    private static class Choreographer16Impl {
        private Choreographer16Impl() {
        }

        static /* synthetic */ void lambda$postFrameCallback$0(Runnable r0, long r1) {
            ((Runnable) ZeusTransformUtils.wrapperContextForParams(r0, Runnable.class, "com.obric.memorydata.plugin")).run();
        }

        public static void postFrameCallback(Runnable r2) {
            final Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin");
            Choreographer.getInstance().postFrameCallback(new $$Lambda$ProfileInstallerInitializer$Choreographer16Impl$DSwPKNQiVu4DdgIKQZrSpqkWMA(r3));
        }
    }

    private static class Handler28Impl {
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

    static /* synthetic */ void lambda$installAfterDelay$1(Context r2) {
        writeInBackground((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ void lambda$writeInBackground$2(Context r2) {
        ProfileInstaller.writeProfile((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    }

    private static void writeInBackground(Context r8) {
        final Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        new ThreadPoolExecutor(0, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new $$Lambda$ProfileInstallerInitializer$nvFqT5BztGBMvszW9GUTUoI9rw(r9));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.startup.Initializer
    public Result create(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 24) goto L5;
        delayAfterFirstFrame((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        return new Result();
    L5:
        return new Result();
    }

    @Override // androidx.startup.Initializer
    public /* synthetic */ Result create(Context r3) {
        return create((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
    }

    void delayAfterFirstFrame(Context r3) {
        final Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Choreographer16Impl.postFrameCallback(new $$Lambda$ProfileInstallerInitializer$QGpANLTF0YGY0pXfe2eje4OKwkc(this, r4));
    }

    @Override // androidx.startup.Initializer
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.emptyList();
    }

    void installAfterDelay(Context r5) {
        final Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 28) goto L5;
        Handler r6 = Handler28Impl.createAsync(Looper.getMainLooper());
    L6:
        r6.postDelayed(new $$Lambda$ProfileInstallerInitializer$nkOIpN4NfyreWbcXjHv0xCvwgTY(r4), new Random().nextInt(Math.max(1000, 1)) + 5000);
        return;
    L5:
        r6 = new Handler(Looper.getMainLooper());
        goto L6
    }

    public /* synthetic */ void lambda$delayAfterFirstFrame$0$ProfileInstallerInitializer(Context r3) {
        installAfterDelay((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
    }
}
