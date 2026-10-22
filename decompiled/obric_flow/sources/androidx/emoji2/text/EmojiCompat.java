package androidx.emoji2.text;

import android.content.Context;
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

    public static class CompatInternal {
        final EmojiCompat mEmojiCompat;

        public CompatInternal(EmojiCompat r5) {
            this.mEmojiCompat = r5;
        }

        public String getAssetSignature() {
            return "";
        }

        public int getEmojiMatch(CharSequence r5, int r10) {
            return 0;
        }

        public boolean hasEmojiGlyph(@NonNull CharSequence r5) {
            return false;
        }

        public void loadMetadata() {
            this.mEmojiCompat.onMetadataLoadSuccess();
        }

        public CharSequence process(@NonNull CharSequence r5, @IntRange(from = 0) int r10, @IntRange(from = 0) int r11, @IntRange(from = 0) int r12, boolean r13) {
            return r5;
        }

        public void updateEditorInfoAttrs(@NonNull EditorInfo r5) {
        }

        public boolean hasEmojiGlyph(@NonNull CharSequence r5, int r10) {
            return false;
        }
    }

    @RequiresApi(19)
    public static final class CompatInternal19 extends CompatInternal {
        private volatile MetadataRepo mMetadataRepo;
        private volatile EmojiProcessor mProcessor;

        public CompatInternal19(EmojiCompat r5) {
            super(r5);
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        public String getAssetSignature() {
            String r5 = this.mMetadataRepo.getMetadataList().sourceSha();
            if (r5 != null) goto L6;
            return "";
        L6:
            return r5;
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        public int getEmojiMatch(CharSequence r5, int r10) {
            return this.mProcessor.getEmojiMatch(r5, r10);
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        public boolean hasEmojiGlyph(@NonNull CharSequence r5) {
            if (this.mProcessor.getEmojiMatch(r5) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        public void loadMetadata() {
            MetadataRepoLoaderCallback r5 = new AnonymousClass1(this);     // Catch: Throwable -> L4
            this.mEmojiCompat.mMetadataLoader.load(r5);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            this.mEmojiCompat.onMetadataLoadFailed(th);
        }

        public void onMetadataLoadSuccess(@NonNull MetadataRepo r10) {
            if (r10 != null) goto L5;
            this.mEmojiCompat.onMetadataLoadFailed(new IllegalArgumentException("metadataRepo cannot be null"));
            return;
        L5:
            this.mMetadataRepo = r10;
            MetadataRepo r5 = this.mMetadataRepo;
            SpanFactory r11 = new SpanFactory();
            GlyphChecker r12 = EmojiCompat.access$000(this.mEmojiCompat);
            EmojiCompat r13 = this.mEmojiCompat;
            this.mProcessor = new EmojiProcessor(r5, r11, r12, r13.mUseEmojiAsDefaultStyle, r13.mEmojiAsDefaultStyleExceptions);
            this.mEmojiCompat.onMetadataLoadSuccess();
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        public CharSequence process(@NonNull CharSequence r10, int r11, int r12, int r13, boolean r14) {
            return this.mProcessor.process(r10, r11, r12, r13, r14);
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        public void updateEditorInfoAttrs(@NonNull EditorInfo r5) {
            r5.extras.putInt(EmojiCompat.EDITOR_INFO_METAVERSION_KEY, this.mMetadataRepo.getMetadataVersion());
            r5.extras.putBoolean(EmojiCompat.EDITOR_INFO_REPLACE_ALL_KEY, this.mEmojiCompat.mReplaceAll);
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        public boolean hasEmojiGlyph(@NonNull CharSequence r5, int r10) {
            if (this.mProcessor.getEmojiMatch(r5, r10) == 1) goto L7;
            return false;
        L7:
            return true;
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

        public Config(@NonNull MetadataRepoLoader r5) {
            this.mEmojiSpanIndicatorColor = -16711936;
            this.mMetadataLoadStrategy = 0;
            this.mGlyphChecker = new DefaultGlyphChecker();
            Preconditions.checkNotNull(r5, "metadataLoader cannot be null.");
            this.mMetadataLoader = r5;
        }

        @NonNull
        public final MetadataRepoLoader getMetadataRepoLoader() {
            return this.mMetadataLoader;
        }

        @NonNull
        public Config registerInitCallback(@NonNull InitCallback r5) {
            Preconditions.checkNotNull(r5, "initCallback cannot be null");
            if (this.mInitCallbacks != null) goto L5;
            this.mInitCallbacks = new ArraySet();
        L5:
            this.mInitCallbacks.add(r5);
            return this;
        }

        @NonNull
        public Config setEmojiSpanIndicatorColor(@ColorInt int r5) {
            this.mEmojiSpanIndicatorColor = r5;
            return this;
        }

        @NonNull
        public Config setEmojiSpanIndicatorEnabled(boolean r5) {
            this.mEmojiSpanIndicatorEnabled = r5;
            return this;
        }

        @NonNull
        public Config setGlyphChecker(@NonNull GlyphChecker r5) {
            Preconditions.checkNotNull(r5, "GlyphChecker cannot be null");
            this.mGlyphChecker = r5;
            return this;
        }

        @NonNull
        public Config setMetadataLoadStrategy(int r5) {
            this.mMetadataLoadStrategy = r5;
            return this;
        }

        @NonNull
        public Config setReplaceAll(boolean r5) {
            this.mReplaceAll = r5;
            return this;
        }

        @NonNull
        public Config setUseEmojiAsDefaultStyle(boolean r5) {
            return setUseEmojiAsDefaultStyle(r5, null);
        }

        @NonNull
        public Config unregisterInitCallback(@NonNull InitCallback r5) {
            Preconditions.checkNotNull(r5, "initCallback cannot be null");
            Set<InitCallback> r10 = this.mInitCallbacks;
            if (r10 == null) goto L5;
            r10.remove(r5);
        L5:
            return this;
        }

        @NonNull
        public Config setUseEmojiAsDefaultStyle(boolean r5, @Nullable List<Integer> r10) {
            this.mUseEmojiAsDefaultStyle = r5;
            if (r5 == false) goto L10;
            if (r10 == null) goto L10;
            this.mEmojiAsDefaultStyleExceptions = new int[r10.size()];
            Iterator<Integer> r11 = r10.iterator();
            int r12 = 0;
        L7:
            if (r11.hasNext() == false) goto L9;
            Integer r13 = r11.next();
            this.mEmojiAsDefaultStyleExceptions[r12] = r13.intValue();
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
    }

    public interface GlyphChecker {
        boolean hasGlyph(@NonNull CharSequence r5, @IntRange(from = 0) int r10, @IntRange(from = 0) int r11, @IntRange(from = 0) int r12);
    }

    public static abstract class InitCallback {
        public InitCallback() {
        }

        public void onFailed(@Nullable Throwable r5) {
        }

        public void onInitialized() {
        }
    }

    public static class ListenerDispatcher implements Runnable {
        private final List<InitCallback> mInitCallbacks;
        private final int mLoadState;
        private final Throwable mThrowable;

        public ListenerDispatcher(@NonNull InitCallback r5, int r10) {
            this(Arrays.asList(new InitCallback[]{(InitCallback) Preconditions.checkNotNull(r5, "initCallback cannot be null")}), r10, null);
        }

        @Override // java.lang.Runnable
        public void run() {
            int r5 = this.mInitCallbacks.size();
            int r10 = 0;
            if (this.mLoadState == 1) goto L6;
        L4:
            if (r10 >= r5) goto L8;
            this.mInitCallbacks.get(r10).onFailed(this.mThrowable);
            r10 = r10 + 1;
            goto L4
        L8:
            return;
        L6:
            if (r10 >= r5) goto L11;
            this.mInitCallbacks.get(r10).onInitialized();
            r10 = r10 + 1;
            goto L6
        }

        public ListenerDispatcher(@NonNull Collection<InitCallback> r5, int r10) {
            this(r5, r10, null);
        }

        public ListenerDispatcher(@NonNull Collection<InitCallback> r5, int r10, @Nullable Throwable r11) {
            Preconditions.checkNotNull(r5, "initCallbacks cannot be null");
            this.mInitCallbacks = new ArrayList(r5);
            this.mLoadState = r10;
            this.mThrowable = r11;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface LoadStrategy {
    }

    public interface MetadataRepoLoader {
        void load(@NonNull MetadataRepoLoaderCallback r5);
    }

    public static abstract class MetadataRepoLoaderCallback {
        public MetadataRepoLoaderCallback() {
        }

        public abstract void onFailed(@Nullable Throwable r5);

        public abstract void onLoaded(@NonNull MetadataRepo r5);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface ReplaceStrategy {
    }

    @RequiresApi(19)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class SpanFactory {
        public SpanFactory() {
        }

        public EmojiSpan createSpan(@NonNull EmojiMetadata r5) {
            return new TypefaceEmojiSpan(r5);
        }
    }

    static {
        INSTANCE_LOCK = new Object();
        CONFIG_LOCK = new Object();
    }

    private EmojiCompat(@NonNull Config r5) {
        this.mInitLock = new ReentrantReadWriteLock();
        this.mLoadState = 3;
        this.mReplaceAll = r5.mReplaceAll;
        this.mUseEmojiAsDefaultStyle = r5.mUseEmojiAsDefaultStyle;
        this.mEmojiAsDefaultStyleExceptions = r5.mEmojiAsDefaultStyleExceptions;
        this.mEmojiSpanIndicatorEnabled = r5.mEmojiSpanIndicatorEnabled;
        this.mEmojiSpanIndicatorColor = r5.mEmojiSpanIndicatorColor;
        this.mMetadataLoader = r5.mMetadataLoader;
        this.mMetadataLoadStrategy = r5.mMetadataLoadStrategy;
        this.mGlyphChecker = r5.mGlyphChecker;
        this.mMainHandler = new Handler(Looper.getMainLooper());
        ArraySet r10 = new ArraySet();
        this.mInitCallbacks = r10;
        Set<InitCallback> r11 = r5.mInitCallbacks;
        if (r11 != null) goto L5;
    L7:
        this.mHelper = new CompatInternal19(this);
        loadMetadata();
        return;
    L5:
        if (r11.isEmpty() == true) goto L7;
        r10.addAll(r5.mInitCallbacks);
        goto L7
    }

    public static /* synthetic */ GlyphChecker access$000(EmojiCompat r5) {
        return r5.mGlyphChecker;
    }

    @NonNull
    public static EmojiCompat get() {
        Object r5 = INSTANCE_LOCK;
        monitor-enter(r5);
        EmojiCompat r10 = sInstance;     // Catch: Throwable -> L11
        if (r10 == null) goto L7;
        boolean r11 = true;
    L8:
        Preconditions.checkState(r11, NOT_INITIALIZED_ERROR_TEXT);     // Catch: Throwable -> L11
        monitor-exit(r5);     // Catch: Throwable -> L11
        return r10;
    L7:
        r11 = false;
    L11:
        th = move-exception;
        throw th;
    }

    public static boolean handleDeleteSurroundingText(@NonNull InputConnection r5, @NonNull Editable r10, @IntRange(from = 0) int r11, @IntRange(from = 0) int r12, boolean r13) {
        return EmojiProcessor.handleDeleteSurroundingText(r5, r10, r11, r12, r13);
    }

    public static boolean handleOnKeyDown(@NonNull Editable r5, int r10, @NonNull KeyEvent r11) {
        return EmojiProcessor.handleOnKeyDown(r5, r10, r11);
    }

    @Nullable
    public static EmojiCompat init(@NonNull Context r5) {
        return init(r5, null);
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
    L7:
        th = move-exception;
        this.mInitLock.writeLock().unlock();
        throw th;
    L4:
        if (this.mMetadataLoadStrategy != 0) goto L9;
        this.mLoadState = 0;     // Catch: Throwable -> L7
    L9:
        this.mInitLock.writeLock().unlock();
        if (getLoadState() != 0) goto L17;
        this.mHelper.loadMetadata();
        return;
    }

    @NonNull
    public static EmojiCompat reset(@NonNull Config r5) {
        Object r10 = INSTANCE_LOCK;
        monitor-enter(r10);
        EmojiCompat r11 = new EmojiCompat(r5);     // Catch: Throwable -> L7
        sInstance = r11;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public static void skipDefaultConfigurationLookup(boolean r5) {
        Object r10 = CONFIG_LOCK;
        monitor-enter(r10);
        sHasDoneDefaultConfigLookup = r5;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
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

    public int getEmojiMatch(@NonNull CharSequence r5, @IntRange(from = 0) int r10) {
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        Preconditions.checkNotNull(r5, "sequence cannot be null");
        return this.mHelper.getEmojiMatch(r5, r10);
    }

    @ColorInt
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getEmojiSpanIndicatorColor() {
        return this.mEmojiSpanIndicatorColor;
    }

    public int getLoadState() {
        this.mInitLock.readLock().lock();
        int r5 = this.mLoadState;     // Catch: Throwable -> L6
        this.mInitLock.readLock().unlock();
        return r5;
    L6:
        th = move-exception;
        this.mInitLock.readLock().unlock();
        throw th;
    }

    @Deprecated
    public boolean hasEmojiGlyph(@NonNull CharSequence r5) {
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        Preconditions.checkNotNull(r5, "sequence cannot be null");
        return this.mHelper.hasEmojiGlyph(r5);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isEmojiSpanIndicatorEnabled() {
        return this.mEmojiSpanIndicatorEnabled;
    }

    public void load() {
        boolean r5 = true;
        if (this.mMetadataLoadStrategy == 1) goto L6;
        r5 = false;
    L6:
        Preconditions.checkState(r5, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
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

    public void onMetadataLoadFailed(@Nullable Throwable r5) {
        ArrayList r10 = new ArrayList();
        this.mInitLock.writeLock().lock();
        this.mLoadState = 2;     // Catch: Throwable -> L6
        r10.addAll(this.mInitCallbacks);     // Catch: Throwable -> L6
        this.mInitCallbacks.clear();     // Catch: Throwable -> L6
        this.mInitLock.writeLock().unlock();
        this.mMainHandler.post(new ListenerDispatcher(r10, this.mLoadState, r5));
        return;
    L6:
        th = move-exception;
        this.mInitLock.writeLock().unlock();
        throw th;
    }

    public void onMetadataLoadSuccess() {
        ArrayList r5 = new ArrayList();
        this.mInitLock.writeLock().lock();
        this.mLoadState = 1;     // Catch: Throwable -> L6
        r5.addAll(this.mInitCallbacks);     // Catch: Throwable -> L6
        this.mInitCallbacks.clear();     // Catch: Throwable -> L6
        this.mInitLock.writeLock().unlock();
        this.mMainHandler.post(new ListenerDispatcher(r5, this.mLoadState));
        return;
    L6:
        th = move-exception;
        this.mInitLock.writeLock().unlock();
        throw th;
    }

    @Nullable
    @CheckResult
    public CharSequence process(@Nullable CharSequence r5) {
        if (r5 != null) goto L5;
        int r10 = 0;
    L7:
        return process(r5, 0, r10);
    L5:
        r10 = r5.length();
        goto L7
    }

    public void registerInitCallback(@NonNull InitCallback r5) {
        Preconditions.checkNotNull(r5, "initCallback cannot be null");
        this.mInitLock.writeLock().lock();
    L9:
        th = move-exception;
        this.mInitLock.writeLock().unlock();
        throw th;
    L4:
        if (this.mLoadState != 1) goto L6;
    L11:
        this.mMainHandler.post(new ListenerDispatcher(r5, this.mLoadState));     // Catch: Throwable -> L9
    L12:
        this.mInitLock.writeLock().unlock();
        return;
    L6:
        if (this.mLoadState == 2) goto L11;
        this.mInitCallbacks.add(r5);     // Catch: Throwable -> L9
        goto L12
    }

    public void unregisterInitCallback(@NonNull InitCallback r5) {
        Preconditions.checkNotNull(r5, "initCallback cannot be null");
        this.mInitLock.writeLock().lock();
        this.mInitCallbacks.remove(r5);     // Catch: Throwable -> L6
        this.mInitLock.writeLock().unlock();
        return;
    L6:
        th = move-exception;
        this.mInitLock.writeLock().unlock();
        throw th;
    }

    public void updateEditorInfo(@NonNull EditorInfo r5) {
        if (isInitialized() == false) goto L11;
        if (r5 != null) goto L7;
        return;
    L7:
        if (r5.extras != null) goto L9;
        r5.extras = new Bundle();
    L9:
        this.mHelper.updateEditorInfoAttrs(r5);
        return;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static EmojiCompat init(@NonNull Context r5, @Nullable DefaultEmojiCompatConfig.DefaultEmojiCompatConfigFactory r10) {
        if (sHasDoneDefaultConfigLookup == true) goto L5;
        if (r10 != null) goto L9;
        r10 = new DefaultEmojiCompatConfig.DefaultEmojiCompatConfigFactory(null);
    L9:
        Config r11 = r10.create(r5);
        Object r12 = CONFIG_LOCK;
        monitor-enter(r12);
    L15:
        th = move-exception;
        throw th;
    L12:
        if (sHasDoneDefaultConfigLookup == true) goto L18;
        if (r11 == null) goto L17;
        init(r11);     // Catch: Throwable -> L15
    L17:
        sHasDoneDefaultConfigLookup = true;     // Catch: Throwable -> L15
    L18:
        EmojiCompat r13 = sInstance;     // Catch: Throwable -> L15
        monitor-exit(r12);     // Catch: Throwable -> L15
        return r13;
    L5:
        return sInstance;
    }

    @Nullable
    @CheckResult
    public CharSequence process(@Nullable CharSequence r5, @IntRange(from = 0) int r10, @IntRange(from = 0) int r11) {
        return process(r5, r10, r11, Integer.MAX_VALUE);
    }

    @Deprecated
    public boolean hasEmojiGlyph(@NonNull CharSequence r5, @IntRange(from = 0) int r10) {
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        Preconditions.checkNotNull(r5, "sequence cannot be null");
        return this.mHelper.hasEmojiGlyph(r5, r10);
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
        boolean r5 = false;
        if (r11 > r12) goto L5;
        boolean r15 = true;
    L6:
        Preconditions.checkArgument(r15, "start should be <= than end");
        if (r10 != null) goto L11;
        return null;
    L11:
        if (r11 > r10.length()) goto L13;
        boolean r16 = true;
    L14:
        Preconditions.checkArgument(r16, "start should be < than charSequence length");
        if (r12 > r10.length()) goto L17;
        boolean r17 = true;
    L18:
        Preconditions.checkArgument(r17, "end should be < than charSequence length");
        if (r10.length() == 0) goto L30;
        if (r11 == r12) goto L30;
        if (r14 != 1) goto L24;
        boolean r18 = true;
    L29:
        return this.mHelper.process(r10, r11, r12, r13, r18);
    L24:
        if (r14 == 2) goto L26;
        r5 = this.mReplaceAll;
    L26:
        r18 = r5;
    L30:
        return r10;
    L17:
        r17 = false;
        goto L18
    L13:
        r16 = false;
        goto L14
    L5:
        r15 = false;
        goto L6
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.TESTS})
    public static EmojiCompat reset(@Nullable EmojiCompat r5) {
        Object r10 = INSTANCE_LOCK;
        monitor-enter(r10);
        sInstance = r5;     // Catch: Throwable -> L7
        EmojiCompat r11 = sInstance;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @NonNull
    public static EmojiCompat init(@NonNull Config r5) {
        EmojiCompat r10 = sInstance;
        if (r10 != null) goto L15;
        Object r11 = INSTANCE_LOCK;
        monitor-enter(r11);
        r10 = sInstance;     // Catch: Throwable -> L9
        if (r10 != null) goto L11;
        r10 = new EmojiCompat(r5);     // Catch: Throwable -> L9
        sInstance = r10;     // Catch: Throwable -> L9
    L11:
        monitor-exit(r11);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L15:
        return r10;
    }
}
