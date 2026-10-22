package rlb;

import android.graphics.Bitmap;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class a<T> implements b<T> {
    public final Class<? extends T> a;
    public Bitmap.Config b;

    @Override // rlb.b
    public T make() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        if (this.b != null) goto L7;
        return this.a.newInstance();
    L7:
        return this.a.getConstructor(new Class[]{Bitmap.Config.class}).newInstance(new Object[]{this.b});
    }

    public a(Class<? extends T> r1) {
        this.a = r1;
        this.b = null;
    }
}
