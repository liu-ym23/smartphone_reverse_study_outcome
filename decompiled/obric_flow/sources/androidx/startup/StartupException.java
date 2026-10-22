package androidx.startup;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class StartupException extends RuntimeException {
    public StartupException(@NonNull String r5) {
        super(r5);
    }

    public StartupException(@NonNull Throwable r5) {
        super(r5);
    }

    public StartupException(@NonNull String r5, @NonNull Throwable r10) {
        super(r5, r10);
    }
}
