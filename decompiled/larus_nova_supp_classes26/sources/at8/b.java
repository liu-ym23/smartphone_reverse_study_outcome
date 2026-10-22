package at8;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b extends FrameLayout {
    public final TextView a;
    public final int b;
    public final int c;

    public b(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.b = ContextCompat.getColor(r3, v19.c.b(2130972123, r3, 2131103203));
        this.c = ContextCompat.getColor(r3, v19.c.b(2130972079, r3, 2131103136));
        FrameLayout.inflate(r3, 2131562463, this);
        this.a = (TextView) findViewById(2131390605);
    }
}
