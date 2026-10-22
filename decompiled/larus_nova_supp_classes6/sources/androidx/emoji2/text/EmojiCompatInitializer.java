package androidx.emoji2.text;

import android.content.Context;
import androidx.core.os.TraceCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleInitializer;
import androidx.startup.AppInitializer;
import androidx.startup.Initializer;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class EmojiCompatInitializer implements Initializer<Boolean> {
    private static final long STARTUP_THREAD_CREATION_DELAY_MS = 500;
    private static final String S_INITIALIZER_THREAD_NAME = "EmojiCompatInitializer";

    public static class BackgroundDefaultConfig extends EmojiCompat.Config {
        public BackgroundDefaultConfig(Context r2) {
            super(new BackgroundDefaultLoader(r2));
            setMetadataLoadStrategy(1);
        }
    }

    public static class BackgroundDefaultLoader implements EmojiCompat.MetadataRepoLoader {
        private final Context mContext;

        public static /* synthetic */ void a(BackgroundDefaultLoader r0, EmojiCompat.MetadataRepoLoaderCallback r1, ThreadPoolExecutor r2) {
            r0.lambda$load$0(r1, r2);
        }

        public BackgroundDefaultLoader(Context r1) {
            this.mContext = r1.getApplicationContext();
        }

        @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoader
        public void load(final EmojiCompat.MetadataRepoLoaderCallback r3) {
            final ThreadPoolExecutor r0 = ConcurrencyHelpers.createBackgroundPriorityExecutor(EmojiCompatInitializer.S_INITIALIZER_THREAD_NAME);
            r0.execute(new c(this, r3, r0));
        }

        private /* synthetic */ void lambda$load$0(EmojiCompat.MetadataRepoLoaderCallback r1, ThreadPoolExecutor r2) {
            doLoad(r1, r2);
        }

        public void doLoad(final EmojiCompat.MetadataRepoLoaderCallback r3, final ThreadPoolExecutor r4) {
            FontRequestEmojiCompatConfig r0 = DefaultEmojiCompatConfig.create(this.mContext);     // Catch: Throwable -> L7
            if (r0 == null) goto L6;
            r0.setLoadingExecutor(r4);     // Catch: Throwable -> L7
            r0.getMetadataRepoLoader().load(new AnonymousClass1(this, r3, r4));     // Catch: Throwable -> L7
            return;
        L6:
            throw new RuntimeException("EmojiCompat font provider not available on this device.");     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            r3.onFailed(th);
            r4.shutdown();
        }
    }

    public static class LoadEmojiCompatRunnable implements Runnable {
        public LoadEmojiCompatRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx_emoji2_text_EmojiCompatInitializer$LoadEmojiCompatRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void androidx_emoji2_text_EmojiCompatInitializer$LoadEmojiCompatRunnable__run$___twin___() {
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

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void androidx_emoji2_text_EmojiCompatInitializer$LoadEmojiCompatRunnable_com_larus_apm_impl_protector_RunnableLancet_run(LoadEmojiCompatRunnable r1) {
            r1.androidx_emoji2_text_EmojiCompatInitializer$LoadEmojiCompatRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public EmojiCompatInitializer() {
    }

    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    public void loadEmojiCompatAfterDelay() {
        ConcurrencyHelpers.mainHandlerAsync().postDelayed(new LoadEmojiCompatRunnable(), STARTUP_THREAD_CREATION_DELAY_MS);
    }

    public Boolean create(Context r2) {
        EmojiCompat.init(new BackgroundDefaultConfig(r2));
        delayUntilFirstResume(r2);
        return Boolean.TRUE;
    }

    public void delayUntilFirstResume(Context r2) {
        final Lifecycle r3 = ((LifecycleOwner) AppInitializer.getInstance(r2).initializeComponent(ProcessLifecycleInitializer.class)).getLifecycle();
        r3.addObserver(new AnonymousClass1(this, r3));
    }

    /* JADX INFO: renamed from: create, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m0create(Context r1) {
        return create(r1);
    }
}
