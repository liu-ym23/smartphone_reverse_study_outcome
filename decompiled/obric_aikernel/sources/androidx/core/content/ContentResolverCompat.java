package androidx.core.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.OperationCanceledException;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class ContentResolverCompat {

    @RequiresApi(16)
    static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        static Cursor query(ContentResolver r10, Uri r11, String[] r12, String r13, String[] r14, String r15, CancellationSignal r16) {
            return r10.query(r11, r12, r13, r14, r15, r16);
        }
    }

    private ContentResolverCompat() {
    }

    @Nullable
    public static Cursor query(@NonNull ContentResolver r10, @NonNull Uri r11, @Nullable String[] r12, @Nullable String r13, @Nullable String[] r14, @Nullable String r15, @Nullable androidx.core.os.CancellationSignal r16) {
        if (Build.VERSION.SDK_INT < 16) goto L16;
        if (r16 != null) goto L20;
        Object r17 = null;
    L9:
        return Api16Impl.query(r10, r11, r12, r13, r14, r15, (CancellationSignal) r17);
    L6:
        e = move-exception;
        if ((e instanceof OperationCanceledException) == true) goto L14;
        throw e;
    L14:
        throw new androidx.core.os.OperationCanceledException();
    L20:
        r17 = r16.getCancellationSignalObject();     // Catch: Exception -> L6
        goto L9
    L16:
        if (r16 == null) goto L19;
        r16.throwIfCanceled();
    L19:
        return r10.query(r11, r12, r13, r14, r15);
    }
}
