package r5;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class e extends Property<Drawable, Integer> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Property<Drawable, Integer> f12680b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakHashMap<Drawable, Integer> f12681a;

    static {
        f12680b = new e();
    }

    private e() {
        super(Integer.class, "drawableAlphaCompat");
        this.f12681a = new WeakHashMap();
    }

    @Nullable
    public Integer a(@NonNull Drawable r10) {
        if (Build.VERSION.SDK_INT < 19) goto L7;
        return Integer.valueOf(r10.getAlpha());
    L7:
        if (this.f12681a.containsKey(r10) == false) goto L11;
        return this.f12681a.get(r10);
    L11:
        return 255;
    }

    public void b(@NonNull Drawable r10, @NonNull Integer r11) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        this.f12681a.put(r10, r11);
    L5:
        r10.setAlpha(r11.intValue());
    }

    @Override // android.util.Property
    @Nullable
    public /* bridge */ /* synthetic */ Integer get(@NonNull Drawable r10) {
        return a(r10);
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(@NonNull Drawable r10, @NonNull Integer r11) {
        b(r10, r11);
    }
}
