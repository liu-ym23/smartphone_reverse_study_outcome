package i62;

import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.platform.depend.im.IMEmoji;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.ChatChannelUtils;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.o;
import com.bytedance.android.livesdk.interactivity.chatchannel.messagelist.viewholder.ChatChannelChatViewHolder;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f extends i62.a {
    public static final int n = 0;
    public final long c;
    public final long d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final String h;
    public final boolean i;
    public final tb2.d j;
    public final ImageModel k;
    public final String l;
    public final com.bytedance.android.livesdk.interactivity.api.chatchannel.message.i m;

    public static final class a {
    }

    public static final class b extends i62.a.AbstractC0237a<f> {
        public b() {
        }

        @Override // i62.a.AbstractC0237a
        public final void h(ChatChannelChatViewHolder r6, i62.a r7) {
            f r8 = (f) r7;
            Intrinsics.checkNotNullParameter(r6, "holder");
            Intrinsics.checkNotNullParameter(r8, "item");
            ImageModel r0 = r8.k;
            String r1 = r8.l;
            tb2.d r9 = r8.j;
            r6.getClass();
            Intrinsics.checkNotNullParameter(r1, "nickName");
            Intrinsics.checkNotNullParameter(r9, "renderText");
            TextView r2 = r6.b;
            if (r2 == null) goto L5;
            r2.setText(r1);
        L5:
            r6.T3(r0, r1);
            TextView r3 = r6.c;
            if (r3 == null) goto L10;
            ViewGroup.LayoutParams r4 = r3.getLayoutParams();
            if (r4 == null) goto L10;
            r4.height = s1.f(46.0f);
        L10:
            TextView r5 = r6.c;
            if (r5 == null) goto L13;
            r5.setBackgroundResource(0);
        L13:
            TextView r10 = r6.c;
            if (r10 == null) goto L16;
            r10.setPadding(s1.f(5.0f), s1.f(5.0f), s1.f(5.0f), s1.f(5.0f));
        L16:
            TextView r11 = r6.c;
            if (r11 == null) goto L19;
            r11.setTextSize(1, 34.0f);
        L19:
            qb2.c.b(r9, new k62.b(r6), null, 28);
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.c
    public final boolean c() {
        return false;
    }

    static {
        n = UtilityKotlinExtentionsKt.i(36);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.c
    public final boolean a() {
        return this.f;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.c
    public final boolean b() {
        return this.e;
    }

    @Override // i62.a
    public final String e() {
        return this.h;
    }

    @Override // i62.a
    public final boolean f() {
        return this.i;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.c
    public final long getChannelId() {
        return this.d;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.c
    public final long getId() {
        return this.c;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.c
    public final boolean isFromFirstRequest() {
        return this.g;
    }

    public f(com.bytedance.android.livesdk.interactivity.api.chatchannel.message.i r7) {
        Intrinsics.checkNotNullParameter(r7, "message");
        super(r7.user);
        this.m = r7;
        this.c = r7.getMessageId();
        this.d = o.a(r7);
        this.e = r7.b;
        r7.getReceiveTime();
        this.f = !r7.isFromFirstRequest();
        this.g = r7.isFromFirstRequest();
        this.h = r7.displayName;
        this.i = r7.b;
        User r0 = r7.user;
        tb2.d r1 = null;
        if (r0 == null) goto L5;
        ImageModel r2 = r0.getAvatarThumb();
    L7:
        if ((r2 instanceof ImageModel) == true) goto L9;
        r2 = null;
    L9:
        this.k = r2;
        String r3 = r7.displayName;
        String r4 = r7.defaultContent;
        if (r3 == null) goto L20;
        s22.e r5 = ChatChannelUtils.b(RoomContext.a.c(RoomContext.Companion, null, 0, 3));
        if (r5 == null) goto L22;
        s22.b r6 = r5.getEmojiManager();
        if (r6 == null) goto L22;
        IMEmoji r8 = r6.a(r3);
        if (r8 == null) goto L22;
        k r9 = r8.getStaticUrl();
        if (r9 == null) goto L22;
        r1 = new tb2.d();
        int r10 = n;
        r1.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.b("0.0", r9, r10, r10));
    L22:
        if (r1 != null) goto L24;
        r1 = new tb2.d();
    L24:
        this.j = r1;
        if (this.a == false) goto L27;
        String r11 = "我";
    L32:
        this.l = r11;
        return;
    L27:
        User r13 = r7.user;
        if (r13 == null) goto L31;
        r11 = r13.getNickName();
        if (r11 != null) goto L32;
    L31:
        r11 = "未知用户";
        goto L32
    L20:
        if (r4 == null) goto L22;
        r1 = new tb2.d();
        r1.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(r4));
        goto L22
    L5:
        r2 = null;
        goto L7
    }
}
