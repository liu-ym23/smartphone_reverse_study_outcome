package q72;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.bytedance.android.livesdk.interactivity.common.combinedtext.CombinedTextRenderView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d {
    public long a;
    public int b;
    public Drawable c;
    public boolean d;
    public CombinedTextRenderView e;
    public final com.bytedance.android.livesdk.interactivity.api.barrage.data.a f;
    public final com.bytedance.android.live.base.model.message.d g;
    public final Context h;

    public final Context getContext() {
        return this.h;
    }

    public d(com.bytedance.android.livesdk.interactivity.api.barrage.data.a r1, com.bytedance.android.live.base.model.message.d r2, Context r3) {
        this.f = r1;
        this.g = r2;
        this.h = r3;
        this.b = -1;
    }
}
