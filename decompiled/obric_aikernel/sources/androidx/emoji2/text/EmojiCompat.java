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
import androidx.annotation.AnyThread;
import androidx.annotation.CheckResult;
import androidx.annotation.ColorInt;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArraySet;
import androidx.core.util.Preconditions;
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
@AnyThread
public class EmojiCompat {
    private static final Object CONFIG_LOCK = null;
    public static final String EDITOR_INFO_METAVERSION_KEY = "android.support.text.emoji.emojiCompat_metadataVersion";
    public static final String EDITOR_INFO_REPLACE_ALL_KEY = "android.support.text.emoji.emojiCompat_replaceAll";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
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

    @GuardedBy("CONFIG_LOCK")
    private static volatile boolean sHasDoneDefaultConfigLookup;

    @Nullable
    @GuardedBy("INSTANCE_LOCK")
    private static volatile EmojiCompat sInstance;

    @Nullable
    final int[] mEmojiAsDefaultStyleExceptions;
    private final int mEmojiSpanIndicatorColor;
    private final boolean mEmojiSpanIndicatorEnabled;
    private final GlyphChecker mGlyphChecker;

    @NonNull
    private final CompatInternal mHelper;

    @NonNull
    @GuardedBy("mInitLock")
    private final Set<InitCallback> mInitCallbacks;

    @NonNull
    private final ReadWriteLock mInitLock;

    @GuardedBy("mInitLock")
    private volatile int mLoadState;

    @NonNull
    private final Handler mMainHandler;
    private final int mMetadataLoadStrategy;

    @NonNull
    final MetadataRepoLoader mMetadataLoader;
    final boolean mReplaceAll;
    final boolean mUseEmojiAsDefaultStyle;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface CodepointSequenceMatchResult {
    }

    private static class CompatInternal {
        final EmojiCompat mEmojiCompat;

        CompatInternal(EmojiCompat r10) {
            this.mEmojiCompat = r10;
        }

        String getAssetSignature() {
            return "";
        }

        public int getEmojiMatch(CharSequence r10, int r11) {
            return 0;
        }

        boolean hasEmojiGlyph(@NonNull CharSequence r10) {
            return false;
        }

        boolean hasEmojiGlyph(@NonNull CharSequence r10, int r11) {
            return false;
        }

        void loadMetadata() {
            this.mEmojiCompat.onMetadataLoadSuccess();
        }

        CharSequence process(@NonNull CharSequence r10, @IntRange(from = 0) int r11, @IntRange(from = 0) int r12, @IntRange(from = 0) int r13, boolean r14) {
            return r10;
        }

        void updateEditorInfoAttrs(@NonNull EditorInfo r10) {
        }
    }

    @RequiresApi(19)
    private static final class CompatInternal19 extends CompatInternal {
        private volatile MetadataRepo mMetadataRepo;
        private volatile EmojiProcessor mProcessor;

        CompatInternal19(EmojiCompat r10) {
            super(r10);
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        String getAssetSignature() {
            String r10 = this.mMetadataRepo.getMetadataList().sourceSha();
            if (r10 != null) goto L6;
            return "";
        L6:
            return r10;
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        public int getEmojiMatch(CharSequence r10, int r11) {
            return this.mProcessor.getEmojiMatch(r10, r11);
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        boolean hasEmojiGlyph(@NonNull CharSequence r10) {
            if (this.mProcessor.getEmojiMatch(r10) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        boolean hasEmojiGlyph(@NonNull CharSequence r10, int r11) {
            if (this.mProcessor.getEmojiMatch(r10, r11) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        void loadMetadata() {
            MetadataRepoLoaderCallback r10 = new AnonymousClass1(this);     // Catch: Throwable -> L4
            this.mEmojiCompat.mMetadataLoader.load(r10);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            this.mEmojiCompat.onMetadataLoadFailed(th);
        }

        void onMetadataLoadSuccess(@NonNull MetadataRepo r10) {
            if (r10 != null) goto L5;
            this.mEmojiCompat.onMetadataLoadFailed(new IllegalArgumentException("metadataRepo cannot be null"));
            return;
        L5:
            this.mMetadataRepo = r10;
            MetadataRepo r11 = this.mMetadataRepo;
            SpanFactory r12 = new SpanFactory();
            GlyphChecker r13 = EmojiCompat.access$000(this.mEmojiCompat);
            EmojiCompat r14 = this.mEmojiCompat;
            this.mProcessor = new EmojiProcessor(r11, r12, r13, r14.mUseEmojiAsDefaultStyle, r14.mEmojiAsDefaultStyleExceptions);
            this.mEmojiCompat.onMetadataLoadSuccess();
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        CharSequence process(@NonNull CharSequence r10, int r11, int r12, int r13, boolean r14) {
            return this.mProcessor.process(r10, r11, r12, r13, r14);
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        void updateEditorInfoAttrs(@NonNull EditorInfo r10) {
            r10.extras.putInt(EmojiCompat.EDITOR_INFO_METAVERSION_KEY, this.mMetadataRepo.getMetadataVersion());
            r10.extras.putBoolean(EmojiCompat.EDITOR_INFO_REPLACE_ALL_KEY, this.mEmojiCompat.mReplaceAll);
        }
    }

    public static abstract class Config {

        @Nullable
        int[] mEmojiAsDefaultStyleExceptions;
        int mEmojiSpanIndicatorColor;
        boolean mEmojiSpanIndicatorEnabled;

        @NonNull
        GlyphChecker mGlyphChecker;

        @Nullable
        Set<InitCallback> mInitCallbacks;
        int mMetadataLoadStrategy;

        @NonNull
        final MetadataRepoLoader mMetadataLoader;
        boolean mReplaceAll;
        boolean mUseEmojiAsDefaultStyle;

        protected Config(@NonNull MetadataRepoLoader r10) {
            this.mEmojiSpanIndicatorColor = -16711936;
            this.mMetadataLoadStrategy = 0;
            this.mGlyphChecker = new DefaultGlyphChecker();
            Preconditions.checkNotNull(r10, "metadataLoader cannot be null.");
            this.mMetadataLoader = r10;
        }

        @NonNull
        protected final MetadataRepoLoader getMetadataRepoLoader() {
            return this.mMetadataLoader;
        }

        @NonNull
        public Config registerInitCallback(@NonNull InitCallback r10) {
            Preconditions.checkNotNull(r10, "initCallback cannot be null");
            if (this.mInitCallbacks != null) goto L5;
            this.mInitCallbacks = new ArraySet();
        L5:
            this.mInitCallbacks.add(r10);
            return this;
        }

        @NonNull
        public Config setEmojiSpanIndicatorColor(@ColorInt int r10) {
            this.mEmojiSpanIndicatorColor = r10;
            return this;
        }

        @NonNull
        public Config setEmojiSpanIndicatorEnabled(boolean r10) {
            this.mEmojiSpanIndicatorEnabled = r10;
            return this;
        }

        @NonNull
        public Config setGlyphChecker(@NonNull GlyphChecker r10) {
            Preconditions.checkNotNull(r10, "GlyphChecker cannot be null");
            this.mGlyphChecker = r10;
            return this;
        }

        @NonNull
        public Config setMetadataLoadStrategy(int r10) {
            this.mMetadataLoadStrategy = r10;
            return this;
        }

        @NonNull
        public Config setReplaceAll(boolean r10) {
            this.mReplaceAll = r10;
            return this;
        }

        @NonNull
        public Config setUseEmojiAsDefaultStyle(boolean r10) {
            return setUseEmojiAsDefaultStyle(r10, null);
        }

        @NonNull
        public Config setUseEmojiAsDefaultStyle(boolean r10, @Nullable List<Integer> r11) {
            this.mUseEmojiAsDefaultStyle = r10;
            if (r10 == false) goto L10;
            if (r11 == null) goto L10;
            this.mEmojiAsDefaultStyleExceptions = new int[r11.size()];
            int r12 = 0;
            Iterator<Integer> r13 = r11.iterator();
        L7:
            if (r13.hasNext() == false) goto L9;
            Integer r14 = r13.next();
            this.mEmojiAsDefaultStyleExceptions[r12] = r14.intValue();
            r12 = r12 + 1;
            goto L7
        L9:
            Arrays.sort(this.mEmojiAsDefaultStyleExceptions);
        L11:
            return this;
        L10:
            this.mEmojiAsDefaultStyleExceptions = null;
            goto L11
        }

        @NonNull
        public Config unregisterInitCallback(@NonNull InitCallback r10) {
            Preconditions.checkNotNull(r10, "initCallback cannot be null");
            Set<InitCallback> r11 = this.mInitCallbacks;
            if (r11 == null) goto L5;
            r11.remove(r10);
        L5:
            return this;
        }
    }

    public interface GlyphChecker {
        boolean hasGlyph(@NonNull CharSequence r10, @IntRange(from = 0) int r11, @IntRange(from = 0) int r12, @IntRange(from = 0) int r13);
    }

    public static abstract class InitCallback {
        public InitCallback() {
        }

        public void onFailed(@Nullable Throwable r10) {
        }

        public void onInitialized() {
        }
    }

    private static class ListenerDispatcher implements Runnable {
        private final List<InitCallback> mInitCallbacks;
        private final int mLoadState;
        private final Throwable mThrowable;

        ListenerDispatcher(@NonNull InitCallback r10, int r11) {
            this(Arrays.asList(new InitCallback[]{(InitCallback) Preconditions.checkNotNull(r10, "initCallback cannot be null")}), r11, null);
        }

        ListenerDispatcher(@NonNull Collection<InitCallback> r10, int r11) {
            this(r10, r11, null);
        }

        ListenerDispatcher(@NonNull Collection<InitCallback> r10, int r11, @Nullable Throwable r12) {
            Preconditions.checkNotNull(r10, "initCallbacks cannot be null");
            this.mInitCallbacks = new ArrayList(r10);
            this.mLoadState = r11;
            this.mThrowable = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            int r10 = this.mInitCallbacks.size();
            int r11 = 0;
            if (this.mLoadState == 1) goto L6;
        L4:
            if (r11 >= r10) goto L8;
            this.mInitCallbacks.get(r11).onFailed(this.mThrowable);
            r11 = r11 + 1;
            goto L4
        L8:
            return;
        L6:
            if (r11 >= r10) goto L11;
            this.mInitCallbacks.get(r11).onInitialized();
            r11 = r11 + 1;
            goto L6
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface LoadStrategy {
    }

    public interface MetadataRepoLoader {
        void load(@NonNull MetadataRepoLoaderCallback r10);
    }

    public static abstract class MetadataRepoLoaderCallback {
        public MetadataRepoLoaderCallback() {
        }

        public abstract void onFailed(@Nullable Throwable r10);

        public abstract void onLoaded(@NonNull MetadataRepo r10);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface ReplaceStrategy {
    }

    @RequiresApi(19)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    static class SpanFactory {
        SpanFactory() {
        }

        EmojiSpan createSpan(@NonNull EmojiMetadata r10) {
            return new TypefaceEmojiSpan(r10);
        }
    }

    static {
        INSTANCE_LOCK = new Object();
        CONFIG_LOCK = new Object();
    }

    private EmojiCompat(@NonNull Config r10) {
        this.mInitLock = new ReentrantReadWriteLock();
        this.mLoadState = 3;
        this.mReplaceAll = r10.mReplaceAll;
        this.mUseEmojiAsDefaultStyle = r10.mUseEmojiAsDefaultStyle;
        this.mEmojiAsDefaultStyleExceptions = r10.mEmojiAsDefaultStyleExceptions;
        this.mEmojiSpanIndicatorEnabled = r10.mEmojiSpanIndicatorEnabled;
        this.mEmojiSpanIndicatorColor = r10.mEmojiSpanIndicatorColor;
        this.mMetadataLoader = r10.mMetadataLoader;
        this.mMetadataLoadStrategy = r10.mMetadataLoadStrategy;
        this.mGlyphChecker = r10.mGlyphChecker;
        this.mMainHandler = new Handler(Looper.getMainLooper());
        ArraySet r11 = new ArraySet();
        this.mInitCallbacks = r11;
        Set<InitCallback> r12 = r10.mInitCallbacks;
        if (r12 == null) goto L8;
        if (r12.isEmpty() == true) goto L8;
        r11.addAll(r10.mInitCallbacks);
    L8:
        if (Build.VERSION.SDK_INT >= 19) goto L10;
        CompatInternal r13 = new CompatInternal(this);
    L11:
        this.mHelper = r13;
        loadMetadata();
        return;
    L10:
        r13 = new CompatInternal19(this);
        goto L11
    }

    static /* synthetic */ GlyphChecker access$000(EmojiCompat r10) {
        return r10.mGlyphChecker;
    }

    @NonNull
    public static EmojiCompat get() {
        Object r10 = INSTANCE_LOCK;
        monitor-enter(r10);
        EmojiCompat r11 = sInstance;     // Catch: Throwable -> L11
        if (r11 == null) goto L7;
        boolean r12 = true;
    L8:
        Preconditions.checkState(r12, NOT_INITIALIZED_ERROR_TEXT);     // Catch: Throwable -> L11
        monitor-exit(r10);     // Catch: Throwable -> L11
        return r11;
    L7:
        r12 = false;
    L11:
        th = move-exception;
        throw th;
    }

    public static boolean handleDeleteSurroundingText(@NonNull InputConnection r10, @NonNull Editable r11, @IntRange(from = 0) int r12, @IntRange(from = 0) int r13, boolean r14) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return false;
    L5:
        return EmojiProcessor.handleDeleteSurroundingText(r10, r11, r12, r13, r14);
    }

    public static boolean handleOnKeyDown(@NonNull Editable r10, int r11, @NonNull KeyEvent r12) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return false;
    L5:
        return EmojiProcessor.handleOnKeyDown(r10, r11, r12);
    }

    @Nullable
    public static EmojiCompat init(@NonNull Context r10) {
        return init(r10, null);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static EmojiCompat init(@NonNull Context r10, @Nullable DefaultEmojiCompatConfig.DefaultEmojiCompatConfigFactory r11) {
        if (sHasDoneDefaultConfigLookup == true) goto L5;
        if (r11 != null) goto L9;
        r11 = new DefaultEmojiCompatConfig.DefaultEmojiCompatConfigFactory(null);
    L9:
        Config r12 = r11.create(r10);
        Object r13 = CONFIG_LOCK;
        monitor-enter(r13);
    L19:
        th = move-exception;
        throw th;
    L12:
        if (sHasDoneDefaultConfigLookup == true) goto L16;
        if (r12 == null) goto L15;
        init(r12);     // Catch: Throwable -> L19
    L15:
        sHasDoneDefaultConfigLookup = true;     // Catch: Throwable -> L19
    L16:
        EmojiCompat r14 = sInstance;     // Catch: Throwable -> L19
        monitor-exit(r13);     // Catch: Throwable -> L19
        return r14;
    L5:
        return sInstance;
    }

    @NonNull
    public static EmojiCompat init(@NonNull Config r10) {
        EmojiCompat r11 = sInstance;
        if (r11 != null) goto L14;
        Object r12 = INSTANCE_LOCK;
        monitor-enter(r12);
        r11 = sInstance;     // Catch: Throwable -> L11
        if (r11 != null) goto L9;
        r11 = new EmojiCompat(r10);     // Catch: Throwable -> L11
        sInstance = r11;     // Catch: Throwable -> L11
    L9:
        monitor-exit(r12);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L14:
        return r11;
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

    @NonNull
    public static EmojiCompat reset(@NonNull Config r10) {
        Object r11 = INSTANCE_LOCK;
        monitor-enter(r11);
        EmojiCompat r12 = new EmojiCompat(r10);     // Catch: Throwable -> L7
        sInstance = r12;     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.TESTS})
    public static EmojiCompat reset(@Nullable EmojiCompat r10) {
        Object r11 = INSTANCE_LOCK;
        monitor-enter(r11);
        sInstance = r10;     // Catch: Throwable -> L7
        EmojiCompat r12 = sInstance;     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public static void skipDefaultConfigurationLookup(boolean r10) {
        Object r11 = CONFIG_LOCK;
        monitor-enter(r11);
        sHasDoneDefaultConfigLookup = r10;     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @NonNull
    public String getAssetSignature() {
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        return this.mHelper.getAssetSignature();
    }

    public int getEmojiMatch(@NonNull CharSequence r10, @IntRange(from = 0) int r11) {
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        Preconditions.checkNotNull(r10, "sequence cannot be null");
        return this.mHelper.getEmojiMatch(r10, r11);
    }

    @ColorInt
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getEmojiSpanIndicatorColor() {
        return this.mEmojiSpanIndicatorColor;
    }

    public int getLoadState() {
        this.mInitLock.readLock().lock();
        int r10 = this.mLoadState;     // Catch: Throwable -> L6
        this.mInitLock.readLock().unlock();
        return r10;
    L6:
        th = move-exception;
        this.mInitLock.readLock().unlock();
        throw th;
    }

    @Deprecated
    public boolean hasEmojiGlyph(@NonNull CharSequence r10) {
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        Preconditions.checkNotNull(r10, "sequence cannot be null");
        return this.mHelper.hasEmojiGlyph(r10);
    }

    @Deprecated
    public boolean hasEmojiGlyph(@NonNull CharSequence r10, @IntRange(from = 0) int r11) {
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        Preconditions.checkNotNull(r10, "sequence cannot be null");
        return this.mHelper.hasEmojiGlyph(r10, r11);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isEmojiSpanIndicatorEnabled() {
        return this.mEmojiSpanIndicatorEnabled;
    }

    public void load() {
        boolean r10 = true;
        if (this.mMetadataLoadStrategy == 1) goto L6;
        r10 = false;
    L6:
        Preconditions.checkState(r10, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
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

    void onMetadataLoadFailed(@Nullable Throwable r10) {
        ArrayList r11 = new ArrayList();
        this.mInitLock.writeLock().lock();
        this.mLoadState = 2;     // Catch: Throwable -> L6
        r11.addAll(this.mInitCallbacks);     // Catch: Throwable -> L6
        this.mInitCallbacks.clear();     // Catch: Throwable -> L6
        this.mInitLock.writeLock().unlock();
        this.mMainHandler.post(new ListenerDispatcher(r11, this.mLoadState, r10));
        return;
    L6:
        th = move-exception;
        this.mInitLock.writeLock().unlock();
        throw th;
    }

    void onMetadataLoadSuccess() {
        ArrayList r10 = new ArrayList();
        this.mInitLock.writeLock().lock();
        this.mLoadState = 1;     // Catch: Throwable -> L6
        r10.addAll(this.mInitCallbacks);     // Catch: Throwable -> L6
        this.mInitCallbacks.clear();     // Catch: Throwable -> L6
        this.mInitLock.writeLock().unlock();
        this.mMainHandler.post(new ListenerDispatcher(r10, this.mLoadState));
        return;
    L6:
        th = move-exception;
        this.mInitLock.writeLock().unlock();
        throw th;
    }

    @Nullable
    @CheckResult
    public CharSequence process(@Nullable CharSequence r10) {
        if (r10 != null) goto L5;
        int r11 = 0;
    L7:
        return process(r10, 0, r11);
    L5:
        r11 = r10.length();
        goto L7
    }

    @Nullable
    @CheckResult
    public CharSequence process(@Nullable CharSequence r10, @IntRange(from = 0) int r11, @IntRange(from = 0) int r12) {
        return process(r10, r11, r12, Integer.MAX_VALUE);
    }

    @Nullable
    @CheckResult
    public CharSequence process(@Nullable CharSequence r10, @IntRange(from = 0) int r11, @IntRange(from = 0) int r12, @IntRange(from = 0) int r13) {
        return process(r10, r11, r12, r13, 0);
    }

    @Nullable
    @CheckResult
    public CharSequence process(@Nullable CharSequence r10, @IntRange(from = 0) int r11, @IntRange(from = 0) int r12, @IntRange(from = 0) int r13, int r14) {
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        Preconditions.checkArgumentNonnegative(r11, "start cannot be negative");
        Preconditions.checkArgumentNonnegative(r12, "end cannot be negative");
        Preconditions.checkArgumentNonnegative(r13, "maxEmojiCount cannot be negative");
        boolean r15 = false;
        if (r11 > r12) goto L5;
        boolean r16 = true;
    L6:
        Preconditions.checkArgument(r16, "start should be <= than end");
        if (r10 != null) goto L11;
        return null;
    L11:
        if (r11 > r10.length()) goto L13;
        boolean r17 = true;
    L14:
        Preconditions.checkArgument(r17, "start should be < than charSequence length");
        if (r12 > r10.length()) goto L17;
        boolean r18 = true;
    L18:
        Preconditions.checkArgument(r18, "end should be < than charSequence length");
        if (r10.length() == 0) goto L30;
        if (r11 == r12) goto L30;
        if (r14 != 1) goto L24;
        boolean r19 = true;
    L29:
        return this.mHelper.process(r10, r11, r12, r13, r19);
    L24:
        if (r14 == 2) goto L26;
        r15 = this.mReplaceAll;
    L26:
        r19 = r15;
    L30:
        return r10;
    L17:
        r18 = false;
        goto L18
    L13:
        r17 = false;
        goto L14
    L5:
        r16 = false;
        goto L6
    }

    public void registerInitCallback(@NonNull InitCallback r10) {
        Preconditions.checkNotNull(r10, "initCallback cannot be null");
        this.mInitLock.writeLock().lock();
    L12:
        th = move-exception;
        this.mInitLock.writeLock().unlock();
        throw th;
    L4:
        if (this.mLoadState != 1) goto L6;
    L9:
        this.mMainHandler.post(new ListenerDispatcher(r10, this.mLoadState));     // Catch: Throwable -> L12
    L10:
        this.mInitLock.writeLock().unlock();
        return;
    L6:
        if (this.mLoadState == 2) goto L9;
        this.mInitCallbacks.add(r10);     // Catch: Throwable -> L12
        goto L10
    }

    public void unregisterInitCallback(@NonNull InitCallback r10) {
        Preconditions.checkNotNull(r10, "initCallback cannot be null");
        this.mInitLock.writeLock().lock();
        this.mInitCallbacks.remove(r10);     // Catch: Throwable -> L6
        this.mInitLock.writeLock().unlock();
        return;
    L6:
        th = move-exception;
        this.mInitLock.writeLock().unlock();
        throw th;
    }

    public void updateEditorInfo(@NonNull EditorInfo r10) {
        if (isInitialized() == false) goto L11;
        if (r10 != null) goto L7;
        return;
    L7:
        if (r10.extras != null) goto L9;
        r10.extras = new Bundle();
    L9:
        this.mHelper.updateEditorInfoAttrs(r10);
        return;
    }
}
