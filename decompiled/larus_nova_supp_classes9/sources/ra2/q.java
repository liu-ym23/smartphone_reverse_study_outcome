package ra2;

import android.graphics.drawable.Animatable;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui.MatchHotMsgView;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ MatchHotMsgView a;
    public final /* synthetic */ int b;

    public q(MatchHotMsgView r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFailure(String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "throwable");
        int r4 = this.b;
        if (r4 != 0) goto L6;
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b("MatchHotMsgView icon webp image load failed. exception is " + r3.getMessage());
    L8:
        pa2.a r5 = this.a.h;
        if (r5 == null) goto L12;
        r5.a();
        return;
    L12:
        return;
    L6:
        if (r4 != 1) goto L8;
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b("MatchHotMsgView bg spread webp image load failed. exception is " + r3.getMessage());
        goto L8
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        ImageInfo r4 = (ImageInfo) r2;
        Intrinsics.checkNotNullParameter(r1, "id");
        int r5 = this.b;
        if (r5 != 0) goto L5;
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.a("MatchHotMsgView icon webp image load SUCCESS.");
    L7:
        MatchHotMsgView r6 = this.a;
        r6.setImgLoadCount(r6.getImgLoadCount() + 1);
        if (this.a.getImgLoadCount() != 2) goto L13;
        pa2.a r7 = this.a.h;
        if (r7 == null) goto L14;
        r7.b();
        return;
    L14:
        return;
    L13:
        return;
    L5:
        if (r5 != 1) goto L7;
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.a("MatchHotMsgView bg spread webp image load SUCCESS.");
        goto L7
    }
}
