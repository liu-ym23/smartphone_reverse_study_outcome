package androidx.startup;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface Initializer<T> {
    @NonNull
    T create(@NonNull Context r5);

    @NonNull
    List<Class<? extends Initializer<?>>> dependencies();
}
