package androidx.core.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.OperationCanceledException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.os.CancellationSignal;

/* JADX INFO: loaded from: classes.dex */
public final class ContentResolverCompat {
    private ContentResolverCompat() {
    }

    @Nullable
    @Deprecated
    public static Cursor query(@NonNull ContentResolver r10, @NonNull Uri r11, @Nullable String[] r12, @Nullable String r13, @Nullable String[] r14, @Nullable String r15, @Nullable CancellationSignal r16) {
        if (r16 == null) goto L5;
        android.os.CancellationSignal r17 = (android.os.CancellationSignal) r16.getCancellationSignalObject();
    L7:
        return query(r10, r11, r12, r13, r14, r15, r17);
    L5:
        r17 = null;
        goto L7
    }

    @Nullable
    public static Cursor query(@NonNull ContentResolver r5, @NonNull Uri r10, @Nullable String[] r11, @Nullable String r12, @Nullable String[] r13, @Nullable String r14, @Nullable android.os.CancellationSignal r15) {
        return r5.query(r10, r11, r12, r13, r14, r15);
    L4:
        e = move-exception;
        if ((e instanceof OperationCanceledException) == true) goto L8;
        throw e;
    L8:
        throw new androidx.core.os.OperationCanceledException();
    }
}
