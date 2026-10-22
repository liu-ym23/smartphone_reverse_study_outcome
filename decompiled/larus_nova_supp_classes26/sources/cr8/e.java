package cr8;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import androidx.core.graphics.ColorUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e extends ShapeDrawable.ShaderFactory {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;

    public e(int r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.graphics.drawable.ShapeDrawable.ShaderFactory
    public final Shader resize(int r10, int r11) {
        int r12 = ColorUtils.setAlphaComponent(this.a, 255);
        return new LinearGradient(0.0f, 0.0f, 0.0f, r11, new int[]{this.b, r12, r12}, new float[]{0.0f, 0.8f, 1.0f}, Shader.TileMode.CLAMP);
    }
}
