package androidx.work;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
public abstract class InputMergerFactory {
    public InputMergerFactory() {
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static InputMergerFactory getDefaultInputMergerFactory() {
        return new AnonymousClass1();
    }

    @Nullable
    public abstract InputMerger createInputMerger(@NonNull String r10);

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final InputMerger createInputMergerWithDefaultFallback(@NonNull String r10) {
        InputMerger r11 = createInputMerger(r10);
        if (r11 == null) goto L5;
        return r11;
    L5:
        return InputMerger.fromClassName(r10);
    }
}
