package cpc;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class a {
    public final String a;
    public String b;
    public final List<Bitmap> c;
    public boolean d;

    public abstract boolean a();

    public int b() {
        return 0;
    }

    public abstract void c();

    public final int hashCode() {
        return Objects.hash(new Object[]{this.a});
    }

    public a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
        this.a = r2;
        this.b = "";
        this.c = new ArrayList();
        this.d = true;
        new ArrayList();
    }

    public final void d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (r3 != null) goto L7;
        return false;
    L7:
        if (Intrinsics.areEqual(getClass(), r3.getClass()) == true) goto L10;
        return false;
    L10:
        return Intrinsics.areEqual(this.a, ((a) r3).a);
    }
}
