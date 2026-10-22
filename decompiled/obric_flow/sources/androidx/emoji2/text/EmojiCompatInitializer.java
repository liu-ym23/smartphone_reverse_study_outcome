package androidx.emoji2.text;

import android.content.Context;
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
    public static class BackgroundDefaultConfig extends EmojiCompat.Config {
        public BackgroundDefaultConfig(Context r5) {
            super(new BackgroundDefaultLoader(r5));
            setMetadataLoadStrategy(1);
        }
    }

    @RequiresApi(19)
    public static class BackgroundDefaultLoader implements EmojiCompat.MetadataRepoLoader {
        private final Context mContext;

        public BackgroundDefaultLoader(Context r5) {
            this.mContext = r5.getApplicationContext();
        }

        public static /* synthetic */ void a(BackgroundDefaultLoader r5, EmojiCompat.MetadataRepoLoaderCallback r10, ThreadPoolExecutor r11) {
            r5.lambda$load$0(r10, r11);
        }

        private /* synthetic */ void lambda$load$0(EmojiCompat.MetadataRepoLoaderCallback r5, ThreadPoolExecutor r10) {
            doLoad(r5, r10);
        }

        @WorkerThread
        public void doLoad(@NonNull final EmojiCompat.MetadataRepoLoaderCallback r5, @NonNull final ThreadPoolExecutor r10) {
            FontRequestEmojiCompatConfig r11 = DefaultEmojiCompatConfig.create(this.mContext);     // Catch: Throwable -> L5
            if (r11 == null) goto L8;
            r11.setLoadingExecutor(r10);     // Catch: Throwable -> L5
            r11.getMetadataRepoLoader().load(new AnonymousClass1(this, r5, r10));     // Catch: Throwable -> L5
            return;
        L8:
            throw new RuntimeException("EmojiCompat font provider not available on this device.");     // Catch: Throwable -> L5
        L5:
            th = move-exception;
            r5.onFailed(th);
            r10.shutdown();
        }

        @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoader
        public void load(@NonNull final EmojiCompat.MetadataRepoLoaderCallback r5) {
            final ThreadPoolExecutor r10 = ConcurrencyHelpers.createBackgroundPriorityExecutor(EmojiCompatInitializer.S_INITIALIZER_THREAD_NAME);
            r10.execute(new c(this, r5, r10));
        }
    }

    public static class LoadEmojiCompatRunnable implements Runnable {
        public LoadEmojiCompatRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TraceCompat.beginSection("EmojiCompat.EmojiCompatInitializer.run");     // Catch: Throwable -> L6
            if (EmojiCompat.isConfigured() == false) goto L8;
            EmojiCompat.get().load();     // Catch: Throwable -> L6
        L8:
            TraceCompat.endSection();
            return;
        L6:
            th = move-exception;
            TraceCompat.endSection();
            throw th;
        }
    }

    public EmojiCompatInitializer() {
    }

    @Override // androidx.startup.Initializer
    @NonNull
    public /* bridge */ /* synthetic */ Boolean create(@NonNull Context r5) {
        return create(r5);
    }

    @RequiresApi(19)
    public void delayUntilFirstResume(@NonNull Context r5) {
        final Lifecycle r10 = ((LifecycleOwner) AppInitializer.getInstance(r5).initializeComponent(ProcessLifecycleInitializer.class)).getLifecycle();
        r10.addObserver(new AnonymousClass1(this, r10));
    }

    @Override // androidx.startup.Initializer
    @NonNull
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @RequiresApi(19)
    public void loadEmojiCompatAfterDelay() {
        ConcurrencyHelpers.mainHandlerAsync().postDelayed(new LoadEmojiCompatRunnable(), STARTUP_THREAD_CREATION_DELAY_MS);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.startup.Initializer
    @NonNull
    public Boolean create(@NonNull Context r5) {
        EmojiCompat.init(new BackgroundDefaultConfig(r5));
        delayUntilFirstResume(r5);
        return Boolean.TRUE;
    }
}
