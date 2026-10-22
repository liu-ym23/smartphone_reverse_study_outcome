package i62;

import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.message.i5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.o;
import com.bytedance.android.livesdk.interactivity.chatchannel.messagelist.viewholder.ChatChannelChatViewHolder;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.r;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.w;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.x;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.bdlocation.BuildConfig;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends i62.a implements wb2.d.a {
    public static final yb2.a m = null;
    public final long c;
    public final long d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final String i;
    public final String j;
    public final ImageModel k;
    public final tb2.d l;

    public static final class a {
    }

    public static final class b extends i62.a.AbstractC0237a<c> {
        public b() {
        }

        @Override // i62.a.AbstractC0237a
        public final void h(ChatChannelChatViewHolder r8, i62.a r9) {
            c r10 = (c) r9;
            Intrinsics.checkNotNullParameter(r8, "holder");
            Intrinsics.checkNotNullParameter(r10, "item");
            ImageModel r0 = r10.k;
            String r1 = r10.i;
            String r2 = r10.j;
            tb2.d r3 = r10.l;
            boolean r11 = r10.a;
            r8.getClass();
            Intrinsics.checkNotNullParameter(r2, "nickName");
            Intrinsics.checkNotNullParameter(r3, "renderText");
            TextView r4 = r8.b;
            if (r4 == null) goto L5;
            r4.setText(r2);
        L5:
            r8.T3(r0, r2);
            if (ab2.a.a(r1) == false) goto L12;
            TextView r5 = r8.c;
            if (r5 == null) goto L17;
            ViewGroup.LayoutParams r6 = r5.getLayoutParams();
            if (r6 == null) goto L17;
            r6.height = s1.f(46.0f);
        L17:
            SpannableString r7 = qb2.c.c(r3, null);
            int r13 = 0;
            if (ab2.a.a(r7.toString()) == false) goto L31;
            TextView r14 = r8.c;
            if (r14 == null) goto L22;
            r14.setBackgroundResource(0);
        L22:
            TextView r15 = r8.c;
            if (r15 == null) goto L25;
            r15.setPadding(s1.f(5.0f), s1.f(5.0f), s1.f(5.0f), s1.f(5.0f));
        L25:
            TextView r16 = r8.c;
            if (r16 == null) goto L28;
            r16.setTextSize(1, 34.0f);
        L28:
            TextView r17 = r8.c;
            if (r17 == null) goto L54;
            ab2.a.e(r7, ChatChannelChatViewHolder.e);
            r17.setText(r7);
            return;
        L54:
            return;
        L31:
            if (r11 == false) goto L35;
            TextView r18 = r8.c;
            if (r18 == null) goto L38;
            r18.setBackgroundResource(2131250205);
        L38:
            TextView r19 = r8.c;
            if (r19 == null) goto L41;
            r19.setPadding(s1.f(8.0f), s1.f(4.0f), s1.f(8.0f), s1.f(4.0f));
        L41:
            TextView r20 = r8.c;
            if (r20 == null) goto L44;
            r20.setTextSize(1, 14.0f);
        L44:
            TextView r21 = r8.c;
            if (r21 == null) goto L56;
            ab2.a.e(r7, ChatChannelChatViewHolder.f);
            if (r8.d == null) goto L51;
            Object[] r23 = r7.getSpans(0, r7.length(), wb2.h.class);
            int r24 = r23.length;
        L49:
            if (r13 >= r24) goto L51;
            wb2.h r25 = (wb2.h) r23[r13];
            r25.a = r8.d;
            r13 = r13 + 1;
        L51:
            Unit r26 = Unit.INSTANCE;
            r21.setText(r7);
            return;
        L56:
            return;
        L35:
            TextView r27 = r8.c;
            if (r27 == null) goto L38;
            r27.setBackgroundResource(2131250204);
            goto L38
        L12:
            TextView r28 = r8.c;
            if (r28 == null) goto L17;
            ViewGroup.LayoutParams r29 = r28.getLayoutParams();
            if (r29 == null) goto L17;
            r29.height = -2;
            goto L17
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.c
    public final boolean c() {
        return false;
    }

    static {
        yb2.a r0 = w.a();
        r0.d = -1;
        r0.a = -1;
        m = r0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.c
    public final boolean a() {
        return this.g;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.c
    public final boolean b() {
        return this.e;
    }

    @Override // i62.a
    public final String e() {
        return this.i;
    }

    @Override // i62.a
    public final boolean f() {
        return this.h;
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
        return this.f;
    }

    public c(com.bytedance.android.livesdk.interactivity.api.chatchannel.message.d r6) {
        Intrinsics.checkNotNullParameter(r6, "message");
        super(r6.getUser());
        this.c = r6.getMessageId();
        this.d = o.a(r6);
        this.e = r6.b;
        this.f = r6.isFromFirstRequest();
        r6.getReceiveTime();
        this.g = !r6.isFromFirstRequest();
        this.h = r6.b;
        this.i = r6.getContent();
        if (this.a == false) goto L5;
        String r0 = "我";
    L10:
        this.j = r0;
        User r1 = r6.getUser();
        if (r1 == null) goto L13;
        ImageModel r2 = r1.getAvatarThumb();
    L15:
        if ((r2 instanceof ImageModel) == true) goto L17;
        r2 = null;
    L17:
        this.k = r2;
        Text r3 = r6.G();
        String r7 = r6.getContent();
        if (r3 == null) goto L33;
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.a.getClass();
        x r8 = r.b;
        yb2.a r9 = m;
        Intrinsics.checkNotNullParameter(r3, "text");
        tb2.d r10 = r.a(r3, r9);
        Iterator<T> r4 = r10.a.iterator();
    L21:
        if (r4.hasNext() == false) goto L32;
        tb2.c r5 = (tb2.c) r4.next();
        i5 r11 = r5.getUserValue();
        if (r11 == null) goto L25;
        IBaseUser r13 = r11.getUser();
    L27:
        if ((r13 instanceof User) == true) goto L29;
        r13 = null;
    L29:
        User r14 = (User) r13;
        if (r14 == null) goto L21;
        r5.setClickAction(new h62.a(r14));
        goto L21
    L25:
        r13 = null;
        goto L27
    L32:
        Unit r15 = Unit.INSTANCE;
    L36:
        this.l = r10;
        return;
    L33:
        if (r7 == null) goto L35;
        tb2.d r16 = new tb2.d();
        r16.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(r7));
        r16.b = m;
        r10 = r16;
        goto L36
    L35:
        r10 = new tb2.d();
        goto L36
    L13:
        r2 = null;
        goto L15
    L5:
        User r17 = r6.getUser();
        if (r17 == null) goto L9;
        r0 = r17.getNickName();
        if (r0 != null) goto L10;
    L9:
        r0 = BuildConfig.FLAVOR;
        goto L10
    }

    @Override // wb2.d.a
    public final boolean d(View r3, wb2.d r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "span");
        Object r5 = r4.b;
        if ((r5 instanceof h62.a) == true) goto L5;
        r5 = null;
    L5:
        h62.a r6 = (h62.a) r5;
        if (r6 != null) goto L9;
        return false;
    L9:
        int r7 = e62.d.a;
        User r8 = r6.a;
        long r0 = this.c;
        String r9 = this.i;
        if (r9 != null) goto L12;
        r9 = BuildConfig.FLAVOR;
    L12:
        e62.d.b(r8, r0, r9);
        return true;
    }
}
