package qsb;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.ss.android.lark.utils.UIHelper;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public Bitmap e;
    public final CopyOnWriteArrayList<String> f;
    public int g;
    public final boolean h;
    public int i;
    public int j;

    public final int a() {
        if (this.j != (-1)) goto L13;
        if (this.e != null) goto L7;
        b();
    L7:
        Bitmap r0 = this.e;
        if (r0 != null) goto L11;
        return 32;
    L11:
        this.j = UIHelper.px2dp(r0.getHeight());
    L13:
        return this.j;
    }

    public final Bitmap b() {
        if (this.e != null) goto L15;
        int r0 = this.g;
        if (r0 > 0) goto L8;
        return null;
    L8:
        Drawable r1 = UIHelper.getDrawable(r0);
        if ((r1 instanceof BitmapDrawable) == false) goto L12;
        this.e = ((BitmapDrawable) r1).getBitmap();
    L12:
        if (this.e != null) goto L15;
        this.g = -1;
    L15:
        return this.e;
    }

    public final int c() {
        if (this.i != (-1)) goto L13;
        if (this.e != null) goto L7;
        b();
    L7:
        Bitmap r0 = this.e;
        if (r0 != null) goto L11;
        return 32;
    L11:
        this.i = UIHelper.px2dp(r0.getWidth());
    L13:
        return this.i;
    }

    public a(String r2, String r3, String r4, String r5, int r6, Boolean r7) {
        this.f = new CopyOnWriteArrayList();
        this.i = -1;
        this.j = -1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.g = r6;
        this.h = r7.booleanValue();
    }

    public a(String r2, String r3, String r4, String r5, Bitmap r6, Boolean r7) {
        this.f = new CopyOnWriteArrayList();
        this.i = -1;
        this.j = -1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.h = r7.booleanValue();
    }
}
