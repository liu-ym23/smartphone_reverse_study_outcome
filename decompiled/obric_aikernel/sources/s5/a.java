package s5;

import android.graphics.Canvas;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class a {
    public static int a(@NonNull Canvas r10, float r11, float r12, float r13, float r14, int r15) {
        if (Build.VERSION.SDK_INT <= 21) goto L7;
        return r10.saveLayerAlpha(r11, r12, r13, r14, r15);
    L7:
        return r10.saveLayerAlpha(r11, r12, r13, r14, r15, 31);
    }
}
