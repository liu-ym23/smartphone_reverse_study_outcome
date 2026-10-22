package androidx.emoji2.viewsintegration;

import android.annotation.SuppressLint;
import android.text.Editable;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.emoji2.text.SpannableBuilder;

/* JADX INFO: loaded from: classes.dex */
final class EmojiEditableFactory extends Editable.Factory {
    private static final Object INSTANCE_LOCK = null;

    @GuardedBy("INSTANCE_LOCK")
    private static volatile Editable.Factory sInstance;

    @Nullable
    private static Class<?> sWatcherClass;

    static {
        INSTANCE_LOCK = new Object();
    }

    @SuppressLint({"PrivateApi"})
    private EmojiEditableFactory() {
        sWatcherClass = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, EmojiEditableFactory.class.getClassLoader());     // Catch: Throwable -> L5
        return;
    }

    public static Editable.Factory getInstance() {
        if (sInstance != null) goto L15;
        Object r10 = INSTANCE_LOCK;
        monitor-enter(r10);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new EmojiEditableFactory();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r10);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    @Override // android.text.Editable.Factory
    public Editable newEditable(@NonNull CharSequence r10) {
        Class<?> r11 = sWatcherClass;
        if (r11 == null) goto L7;
        return SpannableBuilder.create(r11, r10);
    L7:
        return super.newEditable(r10);
    }
}
