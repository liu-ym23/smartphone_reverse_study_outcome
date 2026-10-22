package d82;

import android.view.View;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionButton;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionEntry;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import kotlin.jvm.internal.Intrinsics;
import s32.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements ImageRecognitionButton {
    public final e<Boolean> a;
    public final int b;
    public final int c;
    public final int d;
    public final ImageRecognitionEntry e;

    public final String getBtmToken(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        return null;
    }

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
        f.b("SimilarAnchorButton onDismiss entry=" + this.e);
    }

    public final void onShow() {
        int r0 = f.a;
        f.b("SimilarAnchorButton onShow entry=" + this.e);
    }

    public final boolean canShow() {
        Boolean r4 = null;
        boolean r5 = true;
        if (jc1.a.c() == false) goto L18;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L17;
        m r1 = r0.getRoom();
        if (r1 == null) goto L17;
        Room r2 = (Room) r1.getValue();
        if (r2 == null) goto L17;
        if (r2.isHasCommerceGoods() == true) goto L17;
        User r3 = r2.getOwner();
        if (r3 == null) goto L18;
        if (r3.isWithCommercePermission() != true) goto L18;
    L17:
        return false;
    L18:
        RoomContext r6 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r6 == null) goto L23;
        j r7 = r6.getCompactTbLoader();
        if (r7 == null) goto L23;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m r8 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m) r7.getValue();
    L25:
        if ((r8 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m) == true) goto L27;
        r8 = null;
    L27:
        if (r8 != null) goto L29;
        f.a("toolbarLoader is null");
    L36:
        return Intrinsics.areEqual(r4, Boolean.FALSE);
    L29:
        int r9 = r8.getComponentByGroupId(0);
        int r10 = r8.getComponentByGroupId(19);
        int r11 = f.a;
        f.b("commonSlotComponentId=" + r9 + " microAppSlotComponentId=" + r10);
        if (r9 != (-1)) goto L34;
        if (r10 != (-1)) goto L34;
        r5 = false;
    L34:
        r4 = Boolean.valueOf(r5);
    L23:
        r8 = null;
        goto L25
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

    public c(ImageRecognitionEntry r4) {
        Intrinsics.checkNotNullParameter(r4, "entry");
        this.e = r4;
        this.a = new e("live_reg_similar_anchor_red_dot", Boolean.FALSE);
        this.b = 1;
        this.c = 2131922049;
        int r5 = b.a[r4.ordinal()];
        if (r5 != 1) goto L5;
        int r6 = 2131251427;
    L9:
        this.d = r6;
        return;
    L5:
        if (r5 == 2) goto L7;
        r6 = 0;
        goto L9
    L7:
        r6 = 2131251077;
        goto L9
    }

    public final void onClick(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        int r3 = f.a;
        f.b("SimilarAnchorButton onClick entry=" + this.e);
        if (canShowRedDot() == false) goto L6;
        e<Boolean> r4 = this.a;
        Boolean r0 = Boolean.TRUE;
        r4.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r4, r0);
        return;
    }
}
