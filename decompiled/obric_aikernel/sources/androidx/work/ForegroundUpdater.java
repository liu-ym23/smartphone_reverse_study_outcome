package androidx.work;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public interface ForegroundUpdater {
    @NonNull
    c6.a<Void> setForegroundAsync(@NonNull Context r10, @NonNull UUID r11, @NonNull ForegroundInfo r12);
}
