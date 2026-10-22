package i62;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.q0;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.o;
import com.bytedance.android.livesdk.interactivity.chatchannel.messagelist.viewholder.ChatChannelGiftViewHolder;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.r;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.w;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.x;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import com.bytedance.android.livesdkapi.message.CommonMessageData;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.Iterator;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements com.bytedance.android.livesdk.interactivity.service.messagelist.c, View.OnClickListener, View.OnLongClickListener, wb2.d.a {
    public static final yb2.a i = null;
    public final boolean a;
    public final tb2.d b;
    public final ImageModel c;
    public final long d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final com.bytedance.android.livesdk.interactivity.api.chatchannel.message.h h;

    public static final class a {
    }

    public static final class b extends me.drakeet.multitype.b<e, ChatChannelGiftViewHolder> {
        public final g52.e b;

        public b(g52.e r2) {
            Intrinsics.checkNotNullParameter(r2, "config");
            this.b = r2;
        }

        public final void b(RecyclerView.ViewHolder r6, Object r7) {
            ChatChannelGiftViewHolder r8 = (ChatChannelGiftViewHolder) r6;
            e r9 = (e) r7;
            Intrinsics.checkNotNullParameter(r8, "holder");
            Intrinsics.checkNotNullParameter(r9, "item");
            r8.getClass();
            Intrinsics.checkNotNullParameter(r9, "item");
            r8.c = r9;
            r8.d = r9;
            r8.b.setOnLongClickListener(r9);
            r8.b.setPadding(s1.f(6.0f), s1.f(5.0f), s1.f(6.0f), s1.f(5.0f));
            UtilityKotlinExtentionsKt.w(r8.a);
            ImageLoader.bindImage(r8.a, r9.c);
            TextView r0 = r8.b;
            qb2.c.b(r9.b, new k62.d(r8, r0), null, 28);
            r8.b.setBackground(s1.m(2131250204));
        }

        public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
            Intrinsics.checkNotNullParameter(r4, "inflater");
            Intrinsics.checkNotNullParameter(r5, "parent");
            ChatChannelGiftViewHolder r0 = new ChatChannelGiftViewHolder(r4.inflate(2131566387, r5, false));
            g52.e r6 = this.b;
            Intrinsics.checkNotNullParameter(r6, "textConfig");
            r0.b.setTextSize(0, r6.a);
            return r0;
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.c
    public final boolean c() {
        return false;
    }

    @Override // wb2.d.a
    public final boolean d(View r2, wb2.d r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "span");
        return false;
    }

    static {
        yb2.a r0 = w.a();
        r0.d = ColorProtector.parseColor("#FACE15");
        r0.a = ColorProtector.parseColor("#b2FFFFFF");
        i = r0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.c
    public final boolean a() {
        return this.g;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.c
    public final boolean b() {
        return this.e;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.c
    public final long getId() {
        return this.d;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.c
    public final boolean isFromFirstRequest() {
        return this.f;
    }

    public e(com.bytedance.android.livesdk.interactivity.api.chatchannel.message.h r8) {
        Intrinsics.checkNotNullParameter(r8, "message");
        this.h = r8;
        User r0 = r8.getUser();
        if (r0 == null) goto L6;
        String r1 = r0.getIdString();
        if (r1 == null) goto L6;
    L7:
        String r4 = null;
        if (q0.a(r1) == false) goto L18;
        IUserService r2 = k.f(IUserService.class);
        if (r2 == null) goto L14;
        com.bytedance.android.livesdk.user.f r3 = r2.user();
        if (r3 == null) goto L14;
        String r5 = r3.n();
    L16:
        if (Intrinsics.areEqual(r1, r5) == false) goto L18;
        boolean r6 = true;
    L19:
        this.a = r6;
        User r7 = r8.getUser();
        if (r7 == null) goto L22;
        ImageModel r9 = r7.getAvatarThumb();
    L24:
        if ((r9 instanceof ImageModel) == true) goto L26;
        r9 = null;
    L26:
        this.c = r9;
        this.d = r8.getMessageId();
        this.e = r6;
        r8.getReceiveTime();
        this.f = r8.isFromFirstRequest();
        this.g = !((BaseMessage) r8).isFirstRequest;
        CommonMessageData r10 = ((BaseMessage) r8).baseMessage;
        if (r10 == null) goto L29;
        Text r11 = r10.getDisplayText();
    L30:
        User r13 = r8.getUser();
        Text r14 = r8.G();
        if (r11 == null) goto L37;
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.a.getClass();
        x r15 = r.b;
        yb2.a r16 = i;
        Intrinsics.checkNotNullParameter(r11, "text");
        tb2.d r17 = r.a(r11, r16);
        r17.c = null;
        Iterator<T> r18 = r17.a.iterator();
    L34:
        if (r18.hasNext() == false) goto L36;
        ((tb2.c) r18.next()).setFormat(null);
        goto L34
    L36:
        Unit r19 = Unit.INSTANCE;
        r17.b = i;
    L48:
        this.b = r17;
        return;
    L37:
        if (r13 == null) goto L47;
        if (r14 == null) goto L47;
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.a.getClass();
        x r20 = r.b;
        yb2.a r21 = i;
        Intrinsics.checkNotNullParameter(r14, "text");
        tb2.d r23 = r.a(r14, r21);
        r23.c = null;
        Iterator<T> r24 = r23.a.iterator();
    L41:
        if (r24.hasNext() == false) goto L43;
        ((tb2.c) r24.next()).setFormat(null);
        goto L41
    L43:
        Unit r25 = Unit.INSTANCE;
        tb2.d r26 = new tb2.d();
        r26.b = i;
        if (this.a == false) goto L46;
        r4 = "我";
    L46:
        r26.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.h(r13, r4, true, false));
        r26.b(r23.a);
        r17 = r26;
    L47:
        r17 = new tb2.d();
        goto L48
    L29:
        r11 = null;
        goto L30
    L22:
        r9 = null;
    L14:
        r5 = null;
    L18:
        r6 = false;
    L6:
        r1 = "0";
        goto L7
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        User r2 = this.h.getUser();
        if (r2 != null) goto L5;
        return;
    L5:
        e62.d.d(r2);
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r5) {
        User r6 = this.h.getUser();
        if (r6 != null) goto L6;
        return false;
    L6:
        int r0 = e62.d.a;
        e62.d.c(r6, this.h.getMessageId(), o.a(this.h));
        return true;
    }
}
