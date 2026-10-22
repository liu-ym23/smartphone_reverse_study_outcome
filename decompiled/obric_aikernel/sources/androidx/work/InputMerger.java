package androidx.work;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class InputMerger {
    private static final String TAG = null;

    static {
        TAG = Logger.tagWithPrefix("InputMerger");
    }

    public InputMerger() {
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static InputMerger fromClassName(@NonNull String r10) {
        return (InputMerger) Class.forName(r10).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    L4:
        e = move-exception;
        Logger.get().error(TAG, "Trouble instantiating + " + r10, e);
        return null;
    }

    @NonNull
    public abstract Data merge(@NonNull List<Data> r10);
}
