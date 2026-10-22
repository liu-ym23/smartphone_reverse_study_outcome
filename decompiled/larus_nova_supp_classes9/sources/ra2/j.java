package ra2;

import android.graphics.drawable.Animatable;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui.GroupMsgView;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ GroupMsgView a;

    public j(GroupMsgView r1) {
        this.a = r1;
    }

    public final void onFailure(String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "throwable");
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b("GroupMsgView image load FAILED. icon webp load failed. That's all. exception is " + r3.getMessage());
        GroupMsgView r4 = this.a;
        r4.G = Boolean.FALSE;
        qa2.l r5 = r4.l;
        if (r5 == null) goto L6;
        r5.a();
        return;
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        ImageInfo r4 = (ImageInfo) r2;
        Intrinsics.checkNotNullParameter(r1, "id");
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.a("GroupMsgView icon webp image load SUCCESS.");
        GroupMsgView.a(this.a);
    }
}
