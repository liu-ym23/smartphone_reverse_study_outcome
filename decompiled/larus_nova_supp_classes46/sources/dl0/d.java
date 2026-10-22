package dl0;

import android.graphics.drawable.NinePatchDrawable;
import android.widget.TextView;
import com.bytedance.android.livesdk.chatroom.utils.a3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements a3.b {
    public final /* synthetic */ TextView a;
    public final /* synthetic */ com.bytedance.android.live.profit.fansclub.b b;

    public final void onFail() {
    }

    public final void a(NinePatchDrawable r2) {
        Intrinsics.checkNotNullParameter(r2, "ninePatchDrawable");
        this.a.setText(this.b.a);
    }

    public d(TextView r1, com.bytedance.android.live.profit.fansclub.b r2) {
        this.a = r1;
        this.b = r2;
    }
}
