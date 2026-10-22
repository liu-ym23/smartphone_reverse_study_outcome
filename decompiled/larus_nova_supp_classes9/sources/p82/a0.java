package p82;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.message.u3;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.comment.event.OpenInputSource;
import com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.enums.PanelItemSymbol;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a0 extends a {
    public com.bytedance.android.live.base.model.message.t e;
    public final String f;
    public final String g;
    public final DataCenter h;
    public final RoomContext i;

    @Override // p82.a
    public final int e() {
        return 2131567234;
    }

    public static boolean f(com.bytedance.android.live.base.model.message.t r1) {
        if (r1 == null) goto L8;
        String r2 = r1.getMessageMethod();
        if (r2 == null) goto L8;
        if (r2.equals("WebcastSecretChatMessage") != true) goto L8;
        return true;
    L8:
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final boolean b(com.bytedance.android.livesdk.interactivity.api.entity.l r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        if (com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.c.b == true) goto L5;
        return false;
    L5:
        this.e = r6.b;
        User r7 = (User) this.i.getUser().getValue();
        com.bytedance.android.live.base.model.message.t r0 = this.e;
        if ((r0 instanceof u3) == true) goto L8;
        r0 = null;
    L8:
        u3 r1 = (u3) r0;
        if (r1 == null) goto L11;
        IBaseUser r2 = r1.getUserInMessage();
    L13:
        if ((r2 instanceof User) == true) goto L15;
        IBaseUser r3 = null;
    L17:
        if (com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.c.d((User) r3) == false) goto L19;
    L48:
        return false;
    L19:
        if (com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.c.d(r7) == true) goto L48;
        com.bytedance.android.live.base.model.message.t r8 = this.e;
        IMiddlewareUserService r4 = jc1.k.f(IMiddlewareUserService.class);
        if (r4 == null) goto L28;
        com.bytedance.android.livesdk.user.e r5 = r4.user();
        if (r5 == null) goto L28;
        IBaseUser r9 = r5.b();
        if (r9 == null) goto L28;
        String r10 = r9.getUserId();
    L30:
        if ((r8 instanceof u3) == true) goto L32;
        r8 = null;
    L32:
        u3 r11 = (u3) r8;
        if (r11 == null) goto L37;
        IBaseUser r13 = r11.getUserInMessage();
        if (r13 == null) goto L37;
        String r14 = r13.getUserId();
    L39:
        if (StringsKt.equals$default(r10, r14, false, 2, null) == false) goto L42;
        return false;
    L42:
        if (f(this.e) == false) goto L45;
        return true;
    L45:
        if (com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.c.b(this.h, r2) == true) goto L47;
        return false;
    L47:
        return true;
    L37:
        r14 = null;
    L28:
        r10 = null;
        goto L30
    L15:
        r3 = r2;
        goto L17
    L11:
        r2 = null;
        goto L13
    }

    @Override // p82.a, com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final void onClick(View r5) {
        super.onClick(r5);
        IMiddlewareUserService r6 = jc1.k.f(IMiddlewareUserService.class);
        String r0 = BuildConfig.FLAVOR;
        if (r6 == null) goto L10;
        com.bytedance.android.livesdk.user.e r7 = r6.user();
        if (r7 == null) goto L10;
        IBaseUser r8 = r7.b();
        if (r8 == null) goto L10;
        String r9 = r8.getUserId();
        if (r9 == null) goto L10;
    L11:
        com.bytedance.android.live.base.model.message.t r1 = this.e;
        Long r3 = null;
        if ((r1 instanceof u3) == true) goto L14;
        r1 = null;
    L14:
        u3 r2 = (u3) r1;
        if (r2 == null) goto L43;
        IBaseUser r4 = r2.getUserInMessage();
        if (r4 == null) goto L45;
        String r10 = r4.getUserId();
        if (r10 == null) goto L24;
        r0 = r10;
    L24:
        if (com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.a.b(r9, r0) == false) goto L30;
        com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.e r11 = this.c;
        if (r11 == null) goto L42;
        r11.dismissDialog();
        return;
    L42:
        return;
    L30:
        if (f(this.e) == false) goto L32;
        OpenInputSource r13 = OpenInputSource.ReplySecretChat;
    L34:
        if (f(this.e) == false) goto L38;
        com.bytedance.android.live.base.model.message.t r14 = this.e;
        if (r14 == null) goto L38;
        r3 = Long.valueOf(r14.getMessageId());
    L38:
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.a.d(r4, r13, r3, 2);
        com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.e r15 = this.c;
        if (r15 == null) goto L44;
        r15.dismissDialog();
        return;
    L44:
        return;
    L32:
        r13 = OpenInputSource.SecretChat;
        goto L34
    L45:
        return;
    L43:
        return;
    L10:
        r9 = BuildConfig.FLAVOR;
        goto L11
    }

    public a0(DataCenter r2, RoomContext r3) {
        Intrinsics.checkNotNullParameter(r3, "roomContext");
        super(PanelItemSymbol.SECRET_CHAT);
        this.h = r2;
        this.i = r3;
        this.f = s1.B(2131921792);
        this.g = s1.B(2131921791);
    }

    @Override // p82.a, com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final void c(com.bytedance.android.livesdk.interactivity.api.entity.l r2, com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.e r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r3, "bridge");
        super.c(r2, r3);
        View r4 = getView(r2.getContext());
        if (r4 == null) goto L12;
        TextView r5 = (TextView) r4.findViewById(2131388500);
        if (r5 != null) goto L7;
        return;
    L7:
        if (f(r2.b) == false) goto L9;
        String r6 = this.g;
    L10:
        r5.setText(r6);
        return;
    L9:
        r6 = this.f;
        goto L10
    }
}
