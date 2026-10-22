package com.bytedance.android.live.revlink.impl.pk.flexactivity;

import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.link.model.IBattleUserInfo;
import com.bytedance.android.livesdk.link.model.k0;
import com.bytedance.android.livesdk.link.model.k7;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.badger.collect.impl.constants.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends me.drakeet.multitype.b<C0171a, ActPkRecordViewHolder> {

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.pk.flexactivity.a$a, reason: collision with other inner class name */
    public static final class C0171a {
        public final k7 a;

        public C0171a(k7 r1) {
            this.a = r1;
        }
    }

    public a() {
    }

    public final void b(RecyclerView.ViewHolder r10, Object r12) {
        ActPkRecordViewHolder r13 = (ActPkRecordViewHolder) r10;
        C0171a r14 = (C0171a) r12;
        Intrinsics.checkNotNullParameter(r13, "holder");
        Intrinsics.checkNotNullParameter(r14, "item");
        r13.getClass();
        Intrinsics.checkNotNullParameter(r14, Constants.Keys.DATA);
        k7 r0 = r14.a;
        Integer r3 = null;
        if (r0 == null) goto L13;
        Long r1 = Long.valueOf(r0.getBattleStartTime());
        if (r1.longValue() <= 0) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == true) goto L11;
        r1 = null;
    L11:
        if (r1 == null) goto L13;
        long r5 = r1.longValue();
        ((TextView) ((RecyclerView.ViewHolder) r13).itemView.findViewById(2131364013)).setText(new SimpleDateFormat("MM月dd日 HH:mm").format(new Date(r5 * ((long) WebcastRedirectException.UNKNOWN))));
        goto L13
    L7:
        r4 = false;
    L13:
        Object[] r6 = new Object[1];
        k7 r7 = r14.a;
        if (r7 == null) goto L20;
        IBattleUserInfo r8 = r7.getUserInfo();
        if (r8 == null) goto L20;
        k0 r9 = r8.getUserInfo();
        if (r9 == null) goto L20;
        String r15 = r9.getNickName();
    L21:
        r6[0] = r15;
        SpannableString r2 = new SpannableString(s1.C(2131916667, r6));
        r2.setSpan(new StyleSpan(1), 1, r2.length() - 3, 33);
        ((TextView) ((RecyclerView.ViewHolder) r13).itemView.findViewById(2131380610)).setText(r2);
        TextView r16 = (TextView) ((RecyclerView.ViewHolder) r13).itemView.findViewById(2131380575);
        k7 r17 = r14.a;
        if (r17 == null) goto L24;
        String r18 = r17.getMyScoreText();
    L25:
        r16.setText(r18);
        TextView r19 = (TextView) ((RecyclerView.ViewHolder) r13).itemView.findViewById(2131381576);
        k7 r20 = r14.a;
        if (r20 == null) goto L28;
        String r22 = r20.getOppositeScoreText();
    L29:
        r19.setText(r22);
        ImageView r23 = (ImageView) ((RecyclerView.ViewHolder) r13).itemView.findViewById(2131381574);
        k7 r24 = r14.a;
        if (r24 == null) goto L36;
        IBattleUserInfo r25 = r24.getUserInfo();
        if (r25 == null) goto L36;
        k0 r26 = r25.getUserInfo();
        if (r26 == null) goto L36;
        k r27 = r26.getAvatarThumb();
    L37:
        a1.v(r23, r27, 2131250965);
        yz0.k r28 = (yz0.k) f.d(j.C0.a(), yz0.k.class);
        if (r28 == null) goto L44;
        IRoom r29 = r28.getRoom();
        if (r29 == null) goto L44;
        IBaseUser r30 = r29.getOwner();
        if (r30 == null) goto L44;
        k r32 = r30.getAvatarThumbKt();
    L45:
        a1.v((ImageView) ((RecyclerView.ViewHolder) r13).itemView.findViewById(2131380563), r32, 2131250965);
        k7 r110 = r14.a;
        if (r110 == null) goto L49;
        r3 = Integer.valueOf(r110.getResultType());
    L49:
        if (r3 == null) goto L55;
        if (r3.intValue() != 1) goto L55;
        ((ImageView) ((RecyclerView.ViewHolder) r13).itemView.findViewById(2131380574)).setBackgroundResource(2131251960);
        ((TextView) ((RecyclerView.ViewHolder) r13).itemView.findViewById(2131384454)).setBackground(s1.m(2131251964));
        ((TextView) ((RecyclerView.ViewHolder) r13).itemView.findViewById(2131384454)).setText(s1.B(2131917725));
        return;
    L55:
        if (r3 != null) goto L58;
    L60:
        ((ImageView) ((RecyclerView.ViewHolder) r13).itemView.findViewById(2131380574)).setBackgroundResource(2131251959);
        ((TextView) ((RecyclerView.ViewHolder) r13).itemView.findViewById(2131384454)).setBackground(s1.m(2131251963));
        ((TextView) ((RecyclerView.ViewHolder) r13).itemView.findViewById(2131384454)).setText(s1.B(2131917721));
        return;
    L58:
        if (r3.intValue() != 2) goto L60;
        ((ImageView) ((RecyclerView.ViewHolder) r13).itemView.findViewById(2131380574)).setBackgroundResource(2131251959);
        ((TextView) ((RecyclerView.ViewHolder) r13).itemView.findViewById(2131384454)).setBackground(s1.m(2131251963));
        ((TextView) ((RecyclerView.ViewHolder) r13).itemView.findViewById(2131384454)).setText(s1.B(2131917723));
        return;
    L44:
        r32 = null;
    L36:
        r27 = null;
        goto L37
    L28:
        r22 = null;
        goto L29
    L24:
        r18 = null;
    L20:
        r15 = null;
        goto L21
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new ActPkRecordViewHolder(r4.inflate(2131566202, r5, false));
    }
}
