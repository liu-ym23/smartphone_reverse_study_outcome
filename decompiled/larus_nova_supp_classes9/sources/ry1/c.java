package ry1;

import android.graphics.Rect;
import java.util.LinkedHashSet;
import ry1.c.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c<R extends a> {
    public final LinkedHashSet<R> a;

    public interface a {
        Rect a();
    }

    public c() {
        this.a = new LinkedHashSet();
    }
}
