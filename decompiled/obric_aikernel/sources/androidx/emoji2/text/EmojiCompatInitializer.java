package androidx.emoji2.text;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.WorkerThread;
import androidx.core.os.TraceCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleInitializer;
import androidx.startup.AppInitializer;
import androidx.startup.Initializer;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public class EmojiCompatInitializer implements Initializer<Boolean> {
    private static final long STARTUP_THREAD_CREATION_DELAY_MS = 500;
    private static final String S_INITIALIZER_THREAD_NAME = "EmojiCompatInitializer";

    @RequiresApi(19)
    static class BackgroundDefaultConfig extends EmojiCompat.Config {
        protected BackgroundDefaultConfig(Context r10) {
            super(new BackgroundDefaultLoader(r10));
            setMetadataLoadStrategy(1);
        }
    }

    @RequiresApi(19)
    static class BackgroundDefaultLoader implements EmojiCompat.MetadataRepoLoader {
        private final Context mContext;

        BackgroundDefaultLoader(Context r10) {
            this.mContext = r10.getApplicationContext();
        }

        public static /* synthetic */ void a(BackgroundDefaultLoader r10, EmojiCompat.MetadataRepoLoaderCallback r11, ThreadPoolExecutor r12) {
            r10.lambda$load$0(r11, r12);
        }

        private /* synthetic */ void lambda$load$0(EmojiCompat.MetadataRepoLoaderCallback r10, ThreadPoolExecutor r11) {
            doLoad(r10, r11);
        }

        @WorkerThread
        void doLoad(@NonNull final EmojiCompat.MetadataRepoLoaderCallback r10, @NonNull final ThreadPoolExecutor r11) {
            FontRequestEmojiCompatConfig r12 = DefaultEmojiCompatConfig.create(this.mContext);     // Catch: Throwable -> L7
            if (r12 == null) goto L6;
            r12.setLoadingExecutor(r11);     // Catch: Throwable -> L7
            r12.getMetadataRepoLoader().load(new AnonymousClass1(this, r10, r11));     // Catch: Throwable -> L7
            return;
        L6:
            throw new RuntimeException("EmojiCompat font provider not available on this device.");     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            r10.onFailed(th);
            r11.shutdown();
        }

        @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoader
        public void load(@NonNull final EmojiCompat.MetadataRepoLoaderCallback r10) {
            final ThreadPoolExecutor r11 = ConcurrencyHelpers.createBackgroundPriorityExecutor(EmojiCompatInitializer.S_INITIALIZER_THREAD_NAME);
            r11.execute(new c(this, r10, r11));
        }
    }

    static class LoadEmojiCompatRunnable implements Runnable {
        LoadEmojiCompatRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TraceCompat.beginSection("EmojiCompat.EmojiCompatInitializer.run");     // Catch: Throwable -> L7
            if (EmojiCompat.isConfigured() == false) goto L5;
            EmojiCompat.get().load();     // Catch: Throwable -> L7
        L5:
            TraceCompat.endSection();
            return;
        L7:
            th = move-exception;
            TraceCompat.endSection();
            throw th;
        }
    }

    public EmojiCompatInitializer() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.startup.Initializer
    @NonNull
    public Boolean create(@NonNull Context r10) {
        if (Build.VERSION.SDK_INT < 19) goto L7;
        EmojiCompat.init(new BackgroundDefaultConfig(r10));
        delayUntilFirstResume(r10);
        return Boolean.TRUE;
    L7:
        return Boolean.FALSE;
    }

    @Override // androidx.startup.Initializer
    @NonNull
    public /* bridge */ /* synthetic */ Boolean create(@NonNull Context r10) {
        return create(r10);
    }

    @RequiresApi(19)
    void delayUntilFirstResume(@NonNull Context r10) {
        final Lifecycle r11 = ((LifecycleOwner) AppInitializer.getInstance(r10).initializeComponent(ProcessLifecycleInitializer.class)).getLifecycle();
        r11.addObserver(new AnonymousClass1(this, r11));
    }

    @Override // androidx.startup.Initializer
    @NonNull
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @RequiresApi(19)
    void loadEmojiCompatAfterDelay() {
        ConcurrencyHelpers.mainHandlerAsync().postDelayed(new LoadEmojiCompatRunnable(), STARTUP_THREAD_CREATION_DELAY_MS);
    }
}
