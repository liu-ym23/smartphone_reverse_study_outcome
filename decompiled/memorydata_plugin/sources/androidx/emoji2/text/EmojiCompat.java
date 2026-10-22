package androidx.emoji2.text;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.collection.ArraySet;
import androidx.core.util.Preconditions;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes.dex */
public class EmojiCompat {
    private static final Object CONFIG_LOCK = null;
    public static final String EDITOR_INFO_METAVERSION_KEY = "android.support.text.emoji.emojiCompat_metadataVersion";
    public static final String EDITOR_INFO_REPLACE_ALL_KEY = "android.support.text.emoji.emojiCompat_replaceAll";
    static final int EMOJI_COUNT_UNLIMITED = Integer.MAX_VALUE;
    public static final int EMOJI_FALLBACK = 2;
    public static final int EMOJI_SUPPORTED = 1;
    public static final int EMOJI_UNSUPPORTED = 0;
    private static final Object INSTANCE_LOCK = null;
    public static final int LOAD_STATE_DEFAULT = 3;
    public static final int LOAD_STATE_FAILED = 2;
    public static final int LOAD_STATE_LOADING = 0;
    public static final int LOAD_STATE_SUCCEEDED = 1;
    public static final int LOAD_STRATEGY_DEFAULT = 0;
    public static final int LOAD_STRATEGY_MANUAL = 1;
    private static final String NOT_INITIALIZED_ERROR_TEXT = "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.";
    public static final int REPLACE_STRATEGY_ALL = 1;
    public static final int REPLACE_STRATEGY_DEFAULT = 0;
    public static final int REPLACE_STRATEGY_NON_EXISTENT = 2;
    private static volatile boolean sHasDoneDefaultConfigLookup;
    private static volatile EmojiCompat sInstance;
    final int[] mEmojiAsDefaultStyleExceptions;
    private final int mEmojiSpanIndicatorColor;
    private final boolean mEmojiSpanIndicatorEnabled;
    private final GlyphChecker mGlyphChecker;
    private final CompatInternal mHelper;
    private final Set<InitCallback> mInitCallbacks;
    private final ReadWriteLock mInitLock;
    private volatile int mLoadState;
    private final Handler mMainHandler;
    private final int mMetadataLoadStrategy;
    final MetadataRepoLoader mMetadataLoader;
    final boolean mReplaceAll;
    final boolean mUseEmojiAsDefaultStyle;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CodepointSequenceMatchResult {
    }

    private static class CompatInternal {
        final EmojiCompat mEmojiCompat;

        CompatInternal(EmojiCompat r1) {
            this.mEmojiCompat = r1;
        }

        String getAssetSignature() {
            return "";
        }

        public int getEmojiMatch(CharSequence r1, int r2) {
            CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
            return 0;
        }

        boolean hasEmojiGlyph(CharSequence r2) {
            CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
            return false;
        }

        boolean hasEmojiGlyph(CharSequence r1, int r2) {
            CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
            return false;
        }

        void loadMetadata() {
            this.mEmojiCompat.onMetadataLoadSuccess();
        }

        CharSequence process(CharSequence r1, int r2, int r3, int r4, boolean r5) {
            return (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        }

        void updateEditorInfoAttrs(EditorInfo r1) {
        }
    }

    private static final class CompatInternal19 extends CompatInternal {
        private volatile MetadataRepo mMetadataRepo;
        private volatile EmojiProcessor mProcessor;

        CompatInternal19(EmojiCompat r1) {
            super(r1);
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        String getAssetSignature() {
            String r0 = this.mMetadataRepo.getMetadataList().sourceSha();
            if (r0 != null) goto L6;
            return "";
        L6:
            return r0;
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        public int getEmojiMatch(CharSequence r3, int r4) {
            CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            return this.mProcessor.getEmojiMatch(r5, r4);
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        boolean hasEmojiGlyph(CharSequence r3) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            if (this.mProcessor.getEmojiMatch(r4) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        boolean hasEmojiGlyph(CharSequence r3, int r4) {
            CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            if (this.mProcessor.getEmojiMatch(r5, r4) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        void loadMetadata() {
            MetadataRepoLoaderCallback r0 = new AnonymousClass1(this);     // Catch: Throwable -> L4
            this.mEmojiCompat.mMetadataLoader.load(r0);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            this.mEmojiCompat.onMetadataLoadFailed(th);
        }

        void onMetadataLoadSuccess(MetadataRepo r8) {
            if (r8 != null) goto L5;
            this.mEmojiCompat.onMetadataLoadFailed(new IllegalArgumentException("metadataRepo cannot be null"));
            return;
        L5:
            this.mMetadataRepo = r8;
            this.mProcessor = new EmojiProcessor(this.mMetadataRepo, new SpanFactory(), EmojiCompat.access$000(this.mEmojiCompat), this.mEmojiCompat.mUseEmojiAsDefaultStyle, this.mEmojiCompat.mEmojiAsDefaultStyleExceptions);
            this.mEmojiCompat.onMetadataLoadSuccess();
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        CharSequence process(CharSequence r7, int r8, int r9, int r10, boolean r11) {
            CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
            return this.mProcessor.process(r1, r8, r9, r10, r11);
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        void updateEditorInfoAttrs(EditorInfo r4) {
            r4.extras.putInt(EmojiCompat.EDITOR_INFO_METAVERSION_KEY, this.mMetadataRepo.getMetadataVersion());
            r4.extras.putBoolean(EmojiCompat.EDITOR_INFO_REPLACE_ALL_KEY, this.mEmojiCompat.mReplaceAll);
        }
    }

    public static abstract class Config {
        int[] mEmojiAsDefaultStyleExceptions;
        int mEmojiSpanIndicatorColor;
        boolean mEmojiSpanIndicatorEnabled;
        GlyphChecker mGlyphChecker;
        Set<InitCallback> mInitCallbacks;
        int mMetadataLoadStrategy;
        final MetadataRepoLoader mMetadataLoader;
        boolean mReplaceAll;
        boolean mUseEmojiAsDefaultStyle;

        public Config(MetadataRepoLoader r3) {
            MetadataRepoLoader r4 = (MetadataRepoLoader) ZeusTransformUtils.wrapperContextForParams(r3, MetadataRepoLoader.class, "com.obric.memorydata.plugin");
            this.mEmojiSpanIndicatorColor = -16711936;
            this.mMetadataLoadStrategy = 0;
            this.mGlyphChecker = new DefaultGlyphChecker();
            Preconditions.checkNotNull(r4, "metadataLoader cannot be null.");
            this.mMetadataLoader = r4;
        }

        public final MetadataRepoLoader getMetadataRepoLoader() {
            return this.mMetadataLoader;
        }

        public Config registerInitCallback(InitCallback r2) {
            Preconditions.checkNotNull(r2, "initCallback cannot be null");
            if (this.mInitCallbacks != null) goto L5;
            this.mInitCallbacks = new ArraySet();
        L5:
            this.mInitCallbacks.add(r2);
            return this;
        }

        public Config setEmojiSpanIndicatorColor(int r1) {
            this.mEmojiSpanIndicatorColor = r1;
            return this;
        }

        public Config setEmojiSpanIndicatorEnabled(boolean r1) {
            this.mEmojiSpanIndicatorEnabled = r1;
            return this;
        }

        public Config setGlyphChecker(GlyphChecker r3) {
            GlyphChecker r4 = (GlyphChecker) ZeusTransformUtils.wrapperContextForParams(r3, GlyphChecker.class, "com.obric.memorydata.plugin");
            Preconditions.checkNotNull(r4, "GlyphChecker cannot be null");
            this.mGlyphChecker = r4;
            return this;
        }

        public Config setMetadataLoadStrategy(int r1) {
            this.mMetadataLoadStrategy = r1;
            return this;
        }

        public Config setReplaceAll(boolean r1) {
            this.mReplaceAll = r1;
            return this;
        }

        public Config setUseEmojiAsDefaultStyle(boolean r2) {
            return setUseEmojiAsDefaultStyle(r2, null);
        }

        public Config setUseEmojiAsDefaultStyle(boolean r5, List<Integer> r6) {
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
            this.mUseEmojiAsDefaultStyle = r5;
            if (r5 == false) goto L10;
            if (r7 == null) goto L10;
            this.mEmojiAsDefaultStyleExceptions = new int[r7.size()];
            int r8 = 0;
            Iterator r9 = r7.iterator();
        L7:
            if (r9.hasNext() == false) goto L9;
            Integer r0 = (Integer) ZeusTransformUtils.preCheckCast(r9.next(), Integer.class, "com.obric.memorydata.plugin");
            this.mEmojiAsDefaultStyleExceptions[r8] = r0.intValue();
            r8 = r8 + 1;
            goto L7
        L9:
            Arrays.sort(this.mEmojiAsDefaultStyleExceptions);
        L11:
            return this;
        L10:
            this.mEmojiAsDefaultStyleExceptions = null;
            goto L11
        }

        public Config unregisterInitCallback(InitCallback r2) {
            Preconditions.checkNotNull(r2, "initCallback cannot be null");
            Set<InitCallback> r0 = this.mInitCallbacks;
            if (r0 == null) goto L5;
            r0.remove(r2);
        L5:
            return this;
        }
    }

    public interface GlyphChecker {
        boolean hasGlyph(CharSequence r1, int r2, int r3, int r4);
    }

    public static abstract class InitCallback {
        public InitCallback() {
        }

        public void onFailed(Throwable r1) {
        }

        public void onInitialized() {
        }
    }

    private static class ListenerDispatcher implements Runnable {
        private final List<InitCallback> mInitCallbacks;
        private final int mLoadState;
        private final Throwable mThrowable;

        ListenerDispatcher(InitCallback r4, int r5) {
            this(Arrays.asList(new InitCallback[]{(InitCallback) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(r4, "initCallback cannot be null"), InitCallback.class, "com.obric.memorydata.plugin")}), r5, null);
        }

        ListenerDispatcher(Collection<InitCallback> r3, int r4) {
            this((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"), r4, null);
        }

        ListenerDispatcher(Collection<InitCallback> r3, int r4, Throwable r5) {
            Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
            Preconditions.checkNotNull(r6, "initCallbacks cannot be null");
            this.mInitCallbacks = new ArrayList(r6);
            this.mLoadState = r4;
            this.mThrowable = r5;
        }

        @Override // java.lang.Runnable
        public void run() {
            int r0 = this.mInitCallbacks.size();
            int r3 = 0;
            if (this.mLoadState == 1) goto L6;
        L4:
            if (r3 >= r0) goto L8;
            ((InitCallback) ZeusTransformUtils.preCheckCast(this.mInitCallbacks.get(r3), InitCallback.class, "com.obric.memorydata.plugin")).onFailed(this.mThrowable);
            r3 = r3 + 1;
            goto L4
        L8:
            return;
        L6:
            if (r3 >= r0) goto L11;
            ((InitCallback) ZeusTransformUtils.preCheckCast(this.mInitCallbacks.get(r3), InitCallback.class, "com.obric.memorydata.plugin")).onInitialized();
            r3 = r3 + 1;
            goto L6
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LoadStrategy {
    }

    public interface MetadataRepoLoader {
        void load(MetadataRepoLoaderCallback r1);
    }

    public static abstract class MetadataRepoLoaderCallback {
        public MetadataRepoLoaderCallback() {
        }

        public abstract void onFailed(Throwable r1);

        public abstract void onLoaded(MetadataRepo r1);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ReplaceStrategy {
    }

    static class SpanFactory {
        SpanFactory() {
        }

        EmojiSpan createSpan(EmojiMetadata r1) {
            return new TypefaceEmojiSpan(r1);
        }
    }

    static {
        INSTANCE_LOCK = new Object();
        CONFIG_LOCK = new Object();
    }

    private EmojiCompat(Config r3) {
        this.mInitLock = new ReentrantReadWriteLock();
        this.mLoadState = 3;
        this.mReplaceAll = r3.mReplaceAll;
        this.mUseEmojiAsDefaultStyle = r3.mUseEmojiAsDefaultStyle;
        this.mEmojiAsDefaultStyleExceptions = r3.mEmojiAsDefaultStyleExceptions;
        this.mEmojiSpanIndicatorEnabled = r3.mEmojiSpanIndicatorEnabled;
        this.mEmojiSpanIndicatorColor = r3.mEmojiSpanIndicatorColor;
        this.mMetadataLoader = r3.mMetadataLoader;
        this.mMetadataLoadStrategy = r3.mMetadataLoadStrategy;
        this.mGlyphChecker = r3.mGlyphChecker;
        this.mMainHandler = new Handler(Looper.getMainLooper());
        ArraySet r0 = new ArraySet();
        this.mInitCallbacks = r0;
        if (r3.mInitCallbacks == null) goto L8;
        if (r3.mInitCallbacks.isEmpty() == true) goto L8;
        r0.addAll(r3.mInitCallbacks);
    L8:
        if (Build.VERSION.SDK_INT >= 19) goto L10;
        CompatInternal r4 = new CompatInternal(this);
    L11:
        this.mHelper = r4;
        loadMetadata();
        return;
    L10:
        r4 = new CompatInternal19(this);
        goto L11
    }

    static /* synthetic */ GlyphChecker access$000(EmojiCompat r0) {
        return r0.mGlyphChecker;
    }

    public static EmojiCompat get() {
        Object r0 = INSTANCE_LOCK;
        monitor-enter(r0);
        EmojiCompat r1 = sInstance;     // Catch: Throwable -> L11
        if (r1 == null) goto L7;
        boolean r2 = true;
    L8:
        Preconditions.checkState(r2, NOT_INITIALIZED_ERROR_TEXT);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L7:
        r2 = false;
    L11:
        th = move-exception;
        throw th;
    }

    public static boolean handleDeleteSurroundingText(InputConnection r2, Editable r3, int r4, int r5, boolean r6) {
        InputConnection r7 = (InputConnection) ZeusTransformUtils.wrapperContextForParams(r2, InputConnection.class, "com.obric.memorydata.plugin");
        Editable r8 = (Editable) ZeusTransformUtils.wrapperContextForParams(r3, Editable.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return false;
    L5:
        return EmojiProcessor.handleDeleteSurroundingText(r7, r8, r4, r5, r6);
    }

    public static boolean handleOnKeyDown(Editable r2, int r3, KeyEvent r4) {
        Editable r5 = (Editable) ZeusTransformUtils.wrapperContextForParams(r2, Editable.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return false;
    L5:
        return EmojiProcessor.handleOnKeyDown(r5, r3, r4);
    }

    public static EmojiCompat init(Context r2) {
        return init((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public static EmojiCompat init(Context r2, DefaultEmojiCompatConfig.DefaultEmojiCompatConfigFactory r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (sHasDoneDefaultConfigLookup == true) goto L5;
        if (r3 != null) goto L9;
        r3 = new DefaultEmojiCompatConfig.DefaultEmojiCompatConfigFactory(null);
    L9:
        Config r5 = r3.create(r4);
        Object r6 = CONFIG_LOCK;
        monitor-enter(r6);
    L19:
        th = move-exception;
        throw th;
    L12:
        if (sHasDoneDefaultConfigLookup == true) goto L16;
        if (r5 == null) goto L15;
        init(r5);     // Catch: Throwable -> L19
    L15:
        sHasDoneDefaultConfigLookup = true;     // Catch: Throwable -> L19
    L16:
        EmojiCompat r7 = sInstance;     // Catch: Throwable -> L19
        monitor-exit(r6);     // Catch: Throwable -> L19
        return r7;
    L5:
        return sInstance;
    }

    public static EmojiCompat init(Config r2) {
        EmojiCompat r0 = sInstance;
        if (r0 != null) goto L14;
        Object r1 = INSTANCE_LOCK;
        monitor-enter(r1);
        r0 = sInstance;     // Catch: Throwable -> L11
        if (r0 != null) goto L9;
        r0 = new EmojiCompat(r2);     // Catch: Throwable -> L11
        sInstance = r0;     // Catch: Throwable -> L11
    L9:
        monitor-exit(r1);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L14:
        return r0;
    }

    public static boolean isConfigured() {
        if (sInstance == null) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isInitialized() {
        if (getLoadState() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private void loadMetadata() {
        this.mInitLock.writeLock().lock();
    L10:
        th = move-exception;
        this.mInitLock.writeLock().unlock();
        throw th;
    L4:
        if (this.mMetadataLoadStrategy != 0) goto L6;
        this.mLoadState = 0;     // Catch: Throwable -> L10
    L6:
        this.mInitLock.writeLock().unlock();
        if (getLoadState() != 0) goto L15;
        this.mHelper.loadMetadata();
        return;
    }

    public static EmojiCompat reset(Config r2) {
        Object r0 = INSTANCE_LOCK;
        monitor-enter(r0);
        EmojiCompat r1 = new EmojiCompat(r2);     // Catch: Throwable -> L7
        sInstance = r1;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static EmojiCompat reset(EmojiCompat r1) {
        Object r0 = INSTANCE_LOCK;
        monitor-enter(r0);
        sInstance = r1;     // Catch: Throwable -> L7
        EmojiCompat r2 = sInstance;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    public static void skipDefaultConfigurationLookup(boolean r1) {
        Object r0 = CONFIG_LOCK;
        monitor-enter(r0);
        sHasDoneDefaultConfigLookup = r1;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public String getAssetSignature() {
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        return this.mHelper.getAssetSignature();
    }

    public int getEmojiMatch(CharSequence r3, int r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        Preconditions.checkNotNull(r5, "sequence cannot be null");
        return this.mHelper.getEmojiMatch(r5, r4);
    }

    public int getEmojiSpanIndicatorColor() {
        return this.mEmojiSpanIndicatorColor;
    }

    public int getLoadState() {
        this.mInitLock.readLock().lock();
        int r0 = this.mLoadState;     // Catch: Throwable -> L6
        this.mInitLock.readLock().unlock();
        return r0;
    L6:
        th = move-exception;
        this.mInitLock.readLock().unlock();
        throw th;
    }

    @Deprecated
    public boolean hasEmojiGlyph(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        Preconditions.checkNotNull(r4, "sequence cannot be null");
        return this.mHelper.hasEmojiGlyph(r4);
    }

    @Deprecated
    public boolean hasEmojiGlyph(CharSequence r3, int r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        Preconditions.checkNotNull(r5, "sequence cannot be null");
        return this.mHelper.hasEmojiGlyph(r5, r4);
    }

    public boolean isEmojiSpanIndicatorEnabled() {
        return this.mEmojiSpanIndicatorEnabled;
    }

    public void load() {
        boolean r2 = true;
        if (this.mMetadataLoadStrategy == 1) goto L6;
        r2 = false;
    L6:
        Preconditions.checkState(r2, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (isInitialized() == false) goto L9;
        return;
    L9:
        this.mInitLock.writeLock().lock();
    L17:
        th = move-exception;
        this.mInitLock.writeLock().unlock();
        throw th;
    L11:
        if (this.mLoadState != 0) goto L14;
        this.mInitLock.writeLock().unlock();
        return;
    L14:
        this.mLoadState = 0;     // Catch: Throwable -> L17
        this.mInitLock.writeLock().unlock();
        this.mHelper.loadMetadata();
    }

    void onMetadataLoadFailed(Throwable r4) {
        ArrayList r0 = new ArrayList();
        this.mInitLock.writeLock().lock();
        this.mLoadState = 2;     // Catch: Throwable -> L6
        r0.addAll(this.mInitCallbacks);     // Catch: Throwable -> L6
        this.mInitCallbacks.clear();     // Catch: Throwable -> L6
        this.mInitLock.writeLock().unlock();
        this.mMainHandler.post(new ListenerDispatcher(r0, this.mLoadState, r4));
        return;
    L6:
        th = move-exception;
        this.mInitLock.writeLock().unlock();
        throw th;
    }

    void onMetadataLoadSuccess() {
        ArrayList r0 = new ArrayList();
        this.mInitLock.writeLock().lock();
        this.mLoadState = 1;     // Catch: Throwable -> L6
        r0.addAll(this.mInitCallbacks);     // Catch: Throwable -> L6
        this.mInitCallbacks.clear();     // Catch: Throwable -> L6
        this.mInitLock.writeLock().unlock();
        this.mMainHandler.post(new ListenerDispatcher(r0, this.mLoadState));
        return;
    L6:
        th = move-exception;
        this.mInitLock.writeLock().unlock();
        throw th;
    }

    public CharSequence process(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        int r1 = 0;
    L7:
        return process(r4, 0, r1);
    L5:
        r1 = r4.length();
        goto L7
    }

    public CharSequence process(CharSequence r3, int r4, int r5) {
        return process((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"), r4, r5, Integer.MAX_VALUE);
    }

    public CharSequence process(CharSequence r7, int r8, int r9, int r10) {
        return process((CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin"), r8, r9, r10, 0);
    }

    public CharSequence process(CharSequence r7, int r8, int r9, int r10, int r11) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        Preconditions.checkArgumentNonnegative(r8, "start cannot be negative");
        Preconditions.checkArgumentNonnegative(r9, "end cannot be negative");
        Preconditions.checkArgumentNonnegative(r10, "maxEmojiCount cannot be negative");
        boolean r12 = false;
        if (r8 > r9) goto L5;
        boolean r2 = true;
    L6:
        Preconditions.checkArgument(r2, "start should be <= than end");
        if (r1 != null) goto L11;
        return null;
    L11:
        if (r8 > r1.length()) goto L13;
        boolean r3 = true;
    L14:
        Preconditions.checkArgument(r3, "start should be < than charSequence length");
        if (r9 > r1.length()) goto L17;
        boolean r4 = true;
    L18:
        Preconditions.checkArgument(r4, "end should be < than charSequence length");
        if (r1.length() == 0) goto L30;
        if (r8 == r9) goto L30;
        if (r11 != 1) goto L24;
        boolean r5 = true;
    L29:
        return this.mHelper.process(r1, r8, r9, r10, r5);
    L24:
        if (r11 == 2) goto L26;
        r12 = this.mReplaceAll;
    L26:
        r5 = r12;
    L30:
        return r1;
    L17:
        r4 = false;
        goto L18
    L13:
        r3 = false;
        goto L14
    L5:
        r2 = false;
        goto L6
    }

    public void registerInitCallback(InitCallback r4) {
        Preconditions.checkNotNull(r4, "initCallback cannot be null");
        this.mInitLock.writeLock().lock();
    L12:
        th = move-exception;
        this.mInitLock.writeLock().unlock();
        throw th;
    L4:
        if (this.mLoadState != 1) goto L6;
    L9:
        this.mMainHandler.post(new ListenerDispatcher(r4, this.mLoadState));     // Catch: Throwable -> L12
    L10:
        this.mInitLock.writeLock().unlock();
        return;
    L6:
        if (this.mLoadState == 2) goto L9;
        this.mInitCallbacks.add(r4);     // Catch: Throwable -> L12
        goto L10
    }

    public void unregisterInitCallback(InitCallback r2) {
        Preconditions.checkNotNull(r2, "initCallback cannot be null");
        this.mInitLock.writeLock().lock();
        this.mInitCallbacks.remove(r2);     // Catch: Throwable -> L6
        this.mInitLock.writeLock().unlock();
        return;
    L6:
        th = move-exception;
        this.mInitLock.writeLock().unlock();
        throw th;
    }

    public void updateEditorInfo(EditorInfo r2) {
        if (isInitialized() == false) goto L11;
        if (r2 != null) goto L7;
        return;
    L7:
        if (r2.extras != null) goto L9;
        r2.extras = new Bundle();
    L9:
        this.mHelper.updateEditorInfoAttrs(r2);
        return;
    }
}
