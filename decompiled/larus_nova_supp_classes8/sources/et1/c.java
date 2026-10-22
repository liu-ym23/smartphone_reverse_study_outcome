package et1;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c extends Dialog {
    public final View a;
    public final d b;

    @Override // android.app.Dialog
    public final void onStop() {
        super.onStop();
        com.bytedance.android.livesdk.f.d().f();
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        setContentView(this.a);
        com.bytedance.android.livesdk.f.d().a();
    }

    public c(Context r11, com.bytedance.android.livesdk.coupon.balancecoupon.model.c r12, f r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "data");
        Intrinsics.checkNotNullParameter(r13, "dialogCallback");
        super(r11, 2131954673);
        this.b = r13;
        Long r1 = null;
        View r14 = LayoutInflater.from(r11).inflate(2131566097, null);
        this.a = r14;
        HSImageView r0 = r14.findViewById(2131373334);
        com.bytedance.android.livesdk.coupon.refundcoupon.model.b r2 = r12.b();
        if (r2 == null) goto L5;
        String r3 = r2.a();
    L6:
        Uri r4 = UriProtector.parse(r3);
        if (r0 == null) goto L11;
        if (r4 == null) goto L11;
        r0.setImageURI(r4);
    L11:
        HSImageView r5 = r14.findViewById(2131391990);
        TextView r6 = (TextView) r14.findViewById(2131384146);
        TextView r7 = (TextView) r14.findViewById(2131384150);
        HSImageView r8 = r14.findViewById(2131368074);
        Button r9 = (Button) r14.findViewById(2131369263);
        TextView r15 = (TextView) r14.findViewById(2131384149);
        RoomContext r10 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r10 == null) goto L16;
        m r16 = r10.getRoom();
        if (r16 == null) goto L16;
        Room r17 = (Room) r16.getValue();
    L17:
        if (r17 == null) goto L23;
        User r18 = r17.getOwner();
        if (r18 == null) goto L21;
        ImageModel r19 = r18.getAvatarThumbByRoomAuth(r17.getMRoomAuthStatus());
    L22:
        ImageUtil.loadRoundImage(r5, r19);
        goto L23
    L21:
        r19 = null;
    L23:
        if (r8 == null) goto L25;
        r8.setOnClickListener(new a(this));
    L25:
        if (r9 == null) goto L27;
        r9.setOnClickListener(new b(this, r11));
    L27:
        if (r6 == null) goto L33;
        com.bytedance.android.livesdk.coupon.refundcoupon.model.b r110 = r12.b();
        if (r110 == null) goto L31;
        String r111 = r110.d();
    L32:
        r6.setText(r111);
        goto L33
    L31:
        r111 = null;
    L33:
        if (r7 == null) goto L39;
        com.bytedance.android.livesdk.coupon.refundcoupon.model.b r112 = r12.b();
        if (r112 == null) goto L37;
        String r113 = r112.b();
    L38:
        r7.setText(r113);
        goto L39
    L37:
        r113 = null;
    L39:
        if (r15 == null) goto L48;
        com.bytedance.android.livesdk.coupon.refundcoupon.model.b r114 = r12.b();
        if (r114 == null) goto L43;
        r1 = r114.c();
    L43:
        if (r1 != null) goto L45;
        String r115 = "";
    L46:
        r15.setText(r115);
        return;
    L45:
        r115 = String.valueOf(r1.longValue() / ((long) 100));
        goto L46
    L48:
        return;
    L16:
        r17 = null;
        goto L17
    L5:
        r3 = null;
        goto L6
    }
}
