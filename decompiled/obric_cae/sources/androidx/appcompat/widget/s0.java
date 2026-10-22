package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;

/* JADX INFO: loaded from: classes.dex */
public final class s0 extends ContextWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f1260a = null;

    static {
        f1260a = new Object();
    }

    public static void a(Context r8) {
        if ((r8 instanceof s0) == false) goto L5;
        return;
    L5:
        if ((r8.getResources() instanceof u0) == true) goto L9;
        r8.getResources();
        int r10 = a1.f1102a;
        return;
    }
}
