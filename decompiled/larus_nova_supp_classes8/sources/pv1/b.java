package pv1;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.feed.l;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public final HSImageView a;
    public final TextView b;
    public final TextView c;
    public final Context d;
    public com.bytedance.android.live.base.model.banner.a e;
    public final String f;
    public final l g;
    public int h;

    public b(View r5, Context r6, String r7, l r8) {
        HSImageView r0 = r5.findViewById(2131374931);
        this.a = r0;
        this.b = (TextView) r5.findViewById(2131388367);
        this.c = (TextView) r5.findViewById(2131389622);
        r0.setOnClickListener(new w0(new a(this), 500));
        r3.a(r0, s1.B(2131916568));
        this.d = r6;
        this.f = r7;
        this.g = r8;
    }
}
