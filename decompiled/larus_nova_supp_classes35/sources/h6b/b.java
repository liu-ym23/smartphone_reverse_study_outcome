package h6b;

import android.graphics.drawable.Drawable;
import com.ss.android.lark.export.entity.preview.ImageSet;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public final ImageSet a;
    public final Drawable b;
    public final Drawable c;
    public final int d;
    public final int e;
    public final ThemeColor f;
    public final String g;

    public static final class a {
        public ImageSet a;
        public String b;
        public Drawable c;
        public Drawable d;
        public int e;
        public int f;
        public ThemeColor g;

        public a() {
            this.c = UIHelper.getDrawable(2131255013);
            this.d = UIHelper.getDrawable(2131254898);
            this.e = 16;
            this.f = 16;
        }
    }

    public b(a r2) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        this.a = r2.a;
        this.b = r2.c;
        this.c = r2.d;
        this.d = r2.e;
        this.e = r2.f;
        this.f = r2.g;
        this.g = r2.b;
    }
}
