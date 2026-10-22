package e91;

import android.graphics.Bitmap;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements IHostFrescoHelper.GetBitmapCallBack {
    public final /* synthetic */ f a;
    public final /* synthetic */ ImageView b;

    public final void fail(IHostFrescoHelper.BitmapDataSource r2) {
        this.a.a = false;
    }

    public final void onNewResultImpl(Bitmap r6) {
        Intrinsics.checkNotNullParameter(r6, "bitmap");
        this.a.a = false;
        if (r6.isRecycled() == false) goto L5;
        return;
    L5:
        ImageView r0 = this.b;
        if (r0 == null) goto L8;
        ViewParent r1 = r0.getParent();
    L9:
        if (r1 == null) goto L20;
        f r2 = this.a;
        ImageView r3 = this.b;
        r2.getClass();
        if (r6.getHeight() > 0) goto L13;
    L18:
        this.b.setImageBitmap(r6.copy(Bitmap.Config.ARGB_8888, false));
        this.a.b.onShow();
        return;
    L13:
        if (r6.getWidth() <= 0) goto L18;
        int r4 = UtilityKotlinExtentionsKt.i(8);
        int r5 = (r6.getWidth() / r6.getHeight()) * r4;
        if (r3 == null) goto L18;
        LinearLayout.LayoutParams r7 = new LinearLayout.LayoutParams(r5, r4);
        r7.gravity = 16;
        Unit r8 = Unit.INSTANCE;
        r3.setLayoutParams(r7);
        goto L18
    L20:
        return;
    L8:
        r1 = null;
        goto L9
    }

    public e(f r1, ImageView r2) {
        this.a = r1;
        this.b = r2;
    }
}
