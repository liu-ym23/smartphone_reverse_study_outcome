package i62;

import android.text.TextUtils;
import android.widget.TextView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.o;
import com.bytedance.android.livesdk.interactivity.chatchannel.messagelist.viewholder.ChatChannelChatViewHolder;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.r;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.w;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.x;
import com.bytedance.android.livesdkapi.message.Text;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d extends i62.a {
    public static final int m = 0;
    public static final yb2.a n = null;
    public final long c;
    public final long d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final String h;
    public final boolean i;
    public final String j;
    public final ImageModel k;
    public final tb2.d l;

    public static final class a {
    }

    public static final class b extends i62.a.AbstractC0237a<d> {
        public b() {
        }

        @Override // i62.a.AbstractC0237a
        public final void h(ChatChannelChatViewHolder r6, i62.a r7) {
            d r8 = (d) r7;
            Intrinsics.checkNotNullParameter(r6, "holder");
            Intrinsics.checkNotNullParameter(r8, "item");
            ImageModel r0 = r8.k;
            String r1 = r8.j;
            tb2.d r9 = r8.l;
            r6.getClass();
            Intrinsics.checkNotNullParameter(r1, "nickName");
            Intrinsics.checkNotNullParameter(r9, "renderText");
            TextView r2 = r6.b;
            if (r2 == null) goto L5;
            r2.setText(r1);
        L5:
            r6.T3(r0, r1);
            TextView r3 = r6.c;
            if (r3 == null) goto L8;
            r3.setBackgroundResource(0);
        L8:
            TextView r4 = r6.c;
            if (r4 == null) goto L11;
            r4.setPadding(s1.f(0.0f), s1.f(0.0f), s1.f(0.0f), s1.f(0.0f));
        L11:
            TextView r5 = r6.c;
            if (r5 == null) goto L14;
            r5.setTextSize(1, 14.0f);
        L14:
            qb2.c.b(r9, new k62.a(r6), null, 28);
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.c
    public final boolean c() {
        return false;
    }

    static {
        m = s1.f(30.0f);
        yb2.a r0 = w.a();
        r0.d = -1;
        r0.a = -1;
        n = r0;
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

    public d(com.bytedance.android.livesdk.interactivity.api.chatchannel.message.g r7) {
        Intrinsics.checkNotNullParameter(r7, "message");
        super(r7.getUser());
        this.c = r7.getMessageId();
        this.d = o.a(r7);
        this.e = r7.b;
        r7.getReceiveTime();
        this.f = !r7.isFromFirstRequest();
        this.g = r7.isFromFirstRequest();
        this.h = r7.getDefaultContent();
        this.i = r7.b;
        if (this.a == false) goto L5;
        String r0 = "我";
    L10:
        this.j = r0;
        User r1 = r7.getUser();
        ImageModel r2 = null;
        if (r1 == null) goto L13;
        ImageModel r3 = r1.getAvatarThumb();
    L15:
        if ((r3 instanceof ImageModel) == false) goto L18;
        r2 = r3;
    L18:
        this.k = r2;
        if (r7.getEmojiContent() == null) goto L34;
        Text r4 = r7.getEmojiContent();
        if (r4 == null) goto L32;
        String r8 = r7.getDefaultContent();
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.a.getClass();
        x r5 = r.b;
        yb2.a r6 = n;
        Intrinsics.checkNotNullParameter(r4, "text");
        tb2.d r9 = r.a(r4, r6);
        Iterator<tb2.c> r10 = r9.a.iterator();
    L24:
        if (r10.hasNext() == false) goto L40;
        tb2.c r11 = r10.next();
        ITextPieceImage r13 = r11.getImageValue();
        if (r13 == null) goto L24;
        r13.setScaleType(ITextPieceImage.ScaleType.FIT_Y);
        r13.setHeight(m);
        if (r8 == null) goto L24;
        if (TextUtils.isEmpty(r8) == true) goto L24;
        r13.setEnableTextWhenFailed(true);
        r11.setText(r8);
    L40:
        this.l = r9;
        return;
    L32:
        r9 = new tb2.d();
        goto L40
    L34:
        if (r7.getDefaultContent() == null) goto L39;
        String r14 = r7.getDefaultContent();
        if (r14 == null) goto L38;
        r9 = new tb2.d();
        r9.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(r14));
        r9.b = n;
        goto L40
    L38:
        r9 = new tb2.d();
        goto L40
    L39:
        r9 = new tb2.d();
        goto L40
    L13:
        r3 = null;
        goto L15
    L5:
        User r15 = r7.getUser();
        if (r15 == null) goto L9;
        r0 = r15.getNickName();
        if (r0 != null) goto L10;
    L9:
        r0 = "未知";
        goto L10
    }
}
