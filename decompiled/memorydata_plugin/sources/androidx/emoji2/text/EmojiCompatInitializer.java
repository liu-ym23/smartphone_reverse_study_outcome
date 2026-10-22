package androidx.emoji2.text;

import android.content.Context;
import android.os.Build;
import androidx.core.os.TraceCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleInitializer;
import androidx.startup.AppInitializer;
import androidx.startup.Initializer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public class EmojiCompatInitializer implements Initializer<Boolean> {
    private static final long STARTUP_THREAD_CREATION_DELAY_MS = 500;
    private static final String S_INITIALIZER_THREAD_NAME = "EmojiCompatInitializer";

    static class BackgroundDefaultConfig extends EmojiCompat.Config {
        public BackgroundDefaultConfig(Context r3) {
            super(new BackgroundDefaultLoader((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")));
            setMetadataLoadStrategy(1);
        }
    }

    static class BackgroundDefaultLoader implements EmojiCompat.MetadataRepoLoader {
        private final Context mContext;

        BackgroundDefaultLoader(Context r3) {
            this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        }

        void doLoad(final EmojiCompat.MetadataRepoLoaderCallback r3, final ThreadPoolExecutor r4) {
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

        public /* synthetic */ void lambda$load$0$EmojiCompatInitializer$BackgroundDefaultLoader(EmojiCompat.MetadataRepoLoaderCallback r1, ThreadPoolExecutor r2) {
            doLoad(r1, r2);
        }

        @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoader
        public void load(final EmojiCompat.MetadataRepoLoaderCallback r3) {
            final ThreadPoolExecutor r0 = ConcurrencyHelpers.createBackgroundPriorityExecutor(EmojiCompatInitializer.S_INITIALIZER_THREAD_NAME);
            r0.execute(new $$Lambda$EmojiCompatInitializer$BackgroundDefaultLoader$2V1iWTiAwNxOBlVvz73bbuEdzIw(this, r3, r0));
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
    public Boolean create(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 19) goto L7;
        EmojiCompat.init(new BackgroundDefaultConfig(r4));
        delayUntilFirstResume(r4);
        boolean r2 = true;
    L6:
        return Boolean.valueOf(r2);
    L7:
        r2 = false;
        goto L6
    }

    @Override // androidx.startup.Initializer
    public /* synthetic */ Boolean create(Context r3) {
        return create((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
    }

    void delayUntilFirstResume(Context r3) {
        final Lifecycle r4 = ((LifecycleOwner) ZeusTransformUtils.preCheckCast(AppInitializer.getInstance((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).initializeComponent(ProcessLifecycleInitializer.class), LifecycleOwner.class, "com.obric.memorydata.plugin")).getLifecycle();
        r4.addObserver(new AnonymousClass1(this, r4));
    }

    @Override // androidx.startup.Initializer
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    void loadEmojiCompatAfterDelay() {
        ConcurrencyHelpers.mainHandlerAsync().postDelayed(new LoadEmojiCompatRunnable(), STARTUP_THREAD_CREATION_DELAY_MS);
    }
}
