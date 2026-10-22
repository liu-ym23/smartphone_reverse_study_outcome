package i62;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.message.p;
import com.bytedance.android.livesdk.interactivity.chatchannel.messagelist.viewholder.ChatChannelSystemViewHolder;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.r;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.w;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.x;
import com.bytedance.android.livesdk.utils.w2;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import com.bytedance.android.livesdkapi.message.CommonMessageData;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i implements com.bytedance.android.livesdk.interactivity.service.messagelist.c {
    public static final yb2.a f = null;
    public final long a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final tb2.d e;

    public static final class a {
    }

    public static final class b extends me.drakeet.multitype.b<i, ChatChannelSystemViewHolder> {
        public b() {
        }

        public final void b(RecyclerView.ViewHolder r3, Object r4) {
            ChatChannelSystemViewHolder r5 = (ChatChannelSystemViewHolder) r3;
            i r6 = (i) r4;
            Intrinsics.checkNotNullParameter(r5, "holder");
            Intrinsics.checkNotNullParameter(r6, "item");
            tb2.d r7 = r6.e;
            r5.getClass();
            Intrinsics.checkNotNullParameter(r7, "renderText");
            qb2.c.b(r7, new k62.e(r5), null, 28);
        }

        public final RecyclerView.ViewHolder d(LayoutInflater r7, ViewGroup r8) {
            Intrinsics.checkNotNullParameter(r7, "inflater");
            Intrinsics.checkNotNullParameter(r8, "parent");
            ChatChannelSystemViewHolder.b.getClass();
            Intrinsics.checkNotNullParameter(r7, "inflater");
            Intrinsics.checkNotNullParameter(r8, "parent");
            NoMoreSpaceTextView r0 = new NoMoreSpaceTextView(r8.getContext());
            r0.setId(2131367794);
            r0.setMinimumHeight((int) s1.b(24.0f));
            r0.setGravity(16);
            r0.setTypeface(Typeface.DEFAULT_BOLD);
            r0.setTextSize(0, w2.a(14.0f));
            r0.setLineSpacing(s1.e(3.0f), r0.getLineSpacingMultiplier());
            r0.setBackgroundResource(2131250204);
            r0.setPadding(s1.f(12.0f), s1.f(5.0f), s1.f(12.0f), s1.f(5.0f));
            r0.setTextIsSelectable(false);
            r0.setTextAlignment(5);
            if (o62.d.a.booleanValue() == false) goto L5;
            r0.setShadowLayer(o62.d.c, 0.0f, 0.0f, o62.d.b);
        L5:
            RelativeLayout r1 = new RelativeLayout(r8.getContext());
            r1.setId(2131377403);
            r1.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -2));
            r1.addView(r0);
            return new ChatChannelSystemViewHolder(r1);
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.c
    public final boolean b() {
        return false;
    }

    static {
        yb2.a r0 = w.a();
        r0.d = ColorProtector.parseColor("#E689DCFB");
        r0.a = ColorProtector.parseColor("#E689DCFB");
        f = r0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.c
    public final boolean a() {
        return this.d;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.c
    public final boolean c() {
        return this.b;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.c
    public final long getId() {
        return this.a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.c
    public final boolean isFromFirstRequest() {
        return this.c;
    }

    public i(p r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        this.a = r3.getMessageId();
        this.b = r3.b;
        this.c = r3.isFromFirstRequest();
        r3.getReceiveTime();
        this.d = !r3.isFromFirstRequest();
        CommonMessageData r4 = ((BaseMessage) r3).baseMessage;
        if (r4 == null) goto L7;
        Text r5 = r4.getDisplayText();
        if (r5 == null) goto L7;
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.a.getClass();
        x r0 = r.b;
        yb2.a r1 = f;
        Intrinsics.checkNotNullParameter(r5, "text");
        tb2.d r6 = r.a(r5, r1);
    L8:
        r6.b = f;
        this.e = r6;
        return;
    L7:
        r6 = new tb2.d();
        r6.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(BuildConfig.FLAVOR));
        goto L8
    }
}
