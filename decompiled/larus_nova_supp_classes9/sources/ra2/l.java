package ra2;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.NinePatchDrawable;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui.GroupMsgView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l implements Observer<Bitmap> {
    public final /* synthetic */ GroupMsgView a;

    public final void onComplete() {
    }

    public l(GroupMsgView r1) {
        this.a = r1;
    }

    public final void onError(Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "e");
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b("GroupMsgView image load FAILED.  That's all. exception is " + r3.getMessage());
        GroupMsgView r4 = this.a;
        r4.G = Boolean.FALSE;
        qa2.l r5 = r4.l;
        if (r5 == null) goto L6;
        r5.a();
        return;
    }

    public final void onNext(Object r5) {
        Bitmap r6 = (Bitmap) r5;
        Intrinsics.checkNotNullParameter(r6, "alterBitmap");
        Resources r0 = this.a.getResources();
        NinePatchDrawable r1 = a1.g(r6, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density / 3.0f, false, false);
        GroupMsgView r2 = this.a;
        HSImageView r3 = r2.d;
        if (r3 == null) goto L9;
        Float r4 = r2.e();
        if (r4 == null) goto L7;
        int r7 = (int) r4.floatValue();
    L8:
        q32.a.a(r3, r7);
        goto L9
    L7:
        r7 = 1;
    L9:
        if (r1 == null) goto L11;
        s1.H(this.a.d, r1);
    L12:
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.a("GroupMsgView bg image load SUCCESS.");
        GroupMsgView.a(this.a);
        return;
    L11:
        BitmapDrawable r8 = new BitmapDrawable(this.a.getResources(), r6);
        r8.setAntiAlias(true);
        s1.H(this.a.d, r8);
        goto L12
    }

    public final void onSubscribe(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
        this.a.setLoadBgDisposable(r2);
    }
}
