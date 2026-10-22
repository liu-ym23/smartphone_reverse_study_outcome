package i2;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.ai.api.model.floating.FloatingView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a extends FloatingView {
    public final FrameLayout q;

    public a(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, 2131563320);
    }

    public a(Context r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, null, 4, 0);
        View.inflate(r10, r11, this);
        this.q = (FrameLayout) findViewById(2131373004);
    }
}
