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
        if (sInstance != null) goto L16;
        Object r5 = INSTANCE_LOCK;
        monitor-enter(r5);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L11;
        sInstance = new EmojiEditableFactory();     // Catch: Throwable -> L9
    L11:
        monitor-exit(r5);     // Catch: Throwable -> L9
    L16:
        return sInstance;
    }

    @Override // android.text.Editable.Factory
    public Editable newEditable(@NonNull CharSequence r5) {
        Class<?> r10 = sWatcherClass;
        if (r10 == null) goto L7;
        return SpannableBuilder.create(r10, r5);
    L7:
        return super.newEditable(r5);
    }
}
