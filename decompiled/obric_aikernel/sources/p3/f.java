package p3;

import androidx.annotation.NonNull;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public class f implements ThreadFactory {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f12325c;

    public f(@NonNull String r10) {
        this.f12325c = "MemoryWidget_" + r10;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(@NonNull Runnable r10) {
        return new Thread(r10, this.f12325c);
    }
}
