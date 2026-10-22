package q0;

import android.annotation.SuppressLint;
import android.text.Editable;
import androidx.emoji2.text.o;

/* JADX INFO: loaded from: classes.dex */
public final class b extends Editable.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f10102a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile b f10103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class<?> f10104c;

    static {
        f10102a = new Object();
    }

    @SuppressLint({"PrivateApi"})
    public b() {
        f10104c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, b.class.getClassLoader());     // Catch: Throwable -> L5
        return;
    }

    @Override // android.text.Editable.Factory
    public final Editable newEditable(CharSequence r8) {
        Class<?> r10 = f10104c;
        if (r10 == null) goto L7;
        return new o(r8, r10);
    L7:
        return super.newEditable(r8);
    }
}
