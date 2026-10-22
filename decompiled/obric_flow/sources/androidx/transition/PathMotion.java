package androidx.transition;

import android.content.Context;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public abstract class PathMotion {
    public PathMotion() {
    }

    @NonNull
    public abstract Path getPath(float r5, float r10, float r11, float r12);

    public PathMotion(@NonNull Context r5, @NonNull AttributeSet r10) {
    }
}
