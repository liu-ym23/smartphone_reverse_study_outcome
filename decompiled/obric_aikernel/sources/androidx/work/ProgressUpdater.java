package androidx.work;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public interface ProgressUpdater {
    @NonNull
    c6.a<Void> updateProgress(@NonNull Context r10, @NonNull UUID r11, @NonNull Data r12);
}
