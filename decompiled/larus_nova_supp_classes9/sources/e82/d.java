package e82;

import android.view.View;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m;
import com.bytedance.android.livesdk.interactivity.imagerecognition.util.ImageRecognitionUtil;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionButton;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionEntry;
import com.bytedance.live.datacontext.j;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import s32.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements ImageRecognitionButton {
    public final e<Boolean> a;
    public final int b;
    public final int c;
    public final int d;
    public final ImageRecognitionEntry e;

    public final boolean canShowRedDot() {
        if (this.e == ImageRecognitionEntry.LongPressPanel) goto L5;
    L7:
        return false;
    L5:
        if (((Boolean) this.a.getValue()).booleanValue() == true) goto L7;
        return true;
    }

    public final void onHide() {
        int r0 = f.a;
        f.b("SimilarGoodsButton onDismiss entry=" + this.e);
    }

    public final void onShow() {
        int r0 = f.a;
        f.b("SimilarGoodsButton onShow entry=" + this.e);
    }

    public final boolean canShow() {
        m r4 = null;
        if (jc1.a.c() == false) goto L21;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L20;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L20;
        Room r2 = (Room) r1.getValue();
        if (r2 == null) goto L20;
        if (r2.isHasCommerceGoods() == true) goto L36;
        User r3 = r2.getOwner();
        if (r3 != null) goto L16;
    L18:
        return false;
    L16:
        if (r3.isWithCommercePermission() != true) goto L18;
        return true;
    L36:
        return true;
    L20:
        return false;
    L21:
        RoomContext r5 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r5 == null) goto L26;
        j r6 = r5.getCompactTbLoader();
        if (r6 == null) goto L26;
        m r7 = (m) r6.getValue();
    L28:
        if ((r7 instanceof m) == false) goto L31;
        r4 = r7;
    L31:
        if (r4 != null) goto L35;
        f.a("toolbar loader is null");
        return false;
    L35:
        return r4.isComponentShowing(1);
    L26:
        r7 = null;
        goto L28
    }

    public final int getDescRes() {
        return this.c;
    }

    public final int getIconRes() {
        return this.d;
    }

    public final int getScene() {
        return this.b;
    }

    public d(ImageRecognitionEntry r4) {
        Intrinsics.checkNotNullParameter(r4, "entry");
        this.e = r4;
        this.a = new e("live_rec_similar_goods_red_dot", Boolean.FALSE);
        this.b = 2;
        this.c = 2131921874;
        int r5 = c.a[r4.ordinal()];
        if (r5 == 1) goto L7;
        if (r5 == 2) goto L6;
        int r6 = 0;
    L8:
        this.d = r6;
        return;
    L6:
        r6 = 2131251473;
        goto L8
    L7:
        r6 = 2131251393;
        goto L8
    }

    public final String getBtmToken(View r3) {
        Intrinsics.checkNotNullParameter(r3, "v");
        int r0 = c.b[this.e.ordinal()];
        if (r0 != 1) goto L5;
        String r1 = "a1128.b83869.c484205.d71636";
    L10:
        String r4 = ImageRecognitionUtil.c(r1, r3);
        int r2 = f.a;
        f.b("SimilarGoodsButton createBtmToken " + r4 + " entry=" + this.e);
        return r4;
    L5:
        if (r0 != 2) goto L8;
        r1 = "a1128.b3295.c79415.d596504";
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final void onClick(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        int r3 = f.a;
        f.b("SimilarGoodsButton onClick entry=" + this.e);
        if (canShowRedDot() == false) goto L6;
        e<Boolean> r4 = this.a;
        Boolean r0 = Boolean.TRUE;
        r4.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r4, r0);
        return;
    }
}
