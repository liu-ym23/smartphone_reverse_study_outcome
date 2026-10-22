package com.bytedance.android.livesdk.interactivity.chatchannel.v2.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.user.f;
import com.bytedance.android.livesdk.widget.roundcorner.RoundCornerImageView;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.SecretChatInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class ChannelTrayListViewBinder extends b<p62.a, ItemViewHolder> {
    public final a b;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/v2/view/ChannelTrayListViewBinder$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ItemViewHolder extends RecyclerView.ViewHolder {
        public final ChatChannelAvatarView a;
        public final LinearLayout b;
        public final FrameLayout c;
        public final TextView d;
        public final LinearLayout e;
        public final TextView f;
        public final ChatChannelAvatarView g;
        public final RoundCornerImageView h;
        public final String i;
        public final a j;

        public ItemViewHolder(View r2, a r3) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            Intrinsics.checkNotNullParameter(r3, "clickListener");
            super(r2);
            this.j = r3;
            this.a = (ChatChannelAvatarView) r2.findViewById(2131385830);
            this.b = (LinearLayout) r2.findViewById(2131368334);
            this.c = (FrameLayout) r2.findViewById(2131389375);
            this.d = (TextView) r2.findViewById(2131365487);
            this.e = (LinearLayout) r2.findViewById(2131389263);
            this.f = (TextView) r2.findViewById(2131389264);
            this.g = (ChatChannelAvatarView) r2.findViewById(2131391886);
            this.h = r2.findViewById(2131384095);
            IUserService r4 = k.f(IUserService.class);
            if (r4 == null) goto L7;
            f r5 = r4.user();
            if (r5 == null) goto L7;
            String r6 = r5.n();
        L8:
            this.i = r6;
            return;
        L7:
            r6 = null;
            goto L8
        }
    }

    public interface a {
        void a(p62.a r1);
    }

    public ChannelTrayListViewBinder(r62.a r2) {
        Intrinsics.checkNotNullParameter(r2, "clickListener");
        this.b = r2;
    }

    public final void b(RecyclerView.ViewHolder r8, Object r9) {
        ItemViewHolder r10 = (ItemViewHolder) r8;
        p62.a r11 = (p62.a) r9;
        Intrinsics.checkNotNullParameter(r10, "viewHolder");
        Intrinsics.checkNotNullParameter(r11, "chatChannelTrayInfo");
        boolean r0 = r11.k;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "trayInfo");
        r10.b.setImportantForAccessibility(4);
        ((RecyclerView.ViewHolder) r10).itemView.setOnClickListener(new com.bytedance.android.livesdk.interactivity.chatchannel.v2.view.a(r10, r11));
        ArrayList r1 = new ArrayList();
        StringBuilder r2 = new StringBuilder("trayInfo.channelName = ");
        r2.append(r11.f);
        r2.append("  trayInfo.channelAvatarThumb.size = ");
        List<? extends py.k> r3 = r11.g;
        ImageModel r4 = null;
        if (r3 == null) goto L5;
        Integer r5 = Integer.valueOf(r3.size());
    L6:
        r2.append(r5);
        ALogger.i("ChannelTrayListViewBinder", r2.toString());
        if (r11.a == false) goto L26;
        SecretChatInfo r6 = r11.b;
        if (r6 != null) goto L11;
    L17:
        if (r4 == null) goto L19;
        r1.add(r4);
    L40:
        if (r0 == false) goto L46;
        r10.d.setText(r11.f);
        r10.a.setAvatarData(r1);
        if (r11.a == false) goto L44;
        UtilityKotlinExtentionsKt.t(r10.e);
    L45:
        UtilityKotlinExtentionsKt.w(r10.b);
        UtilityKotlinExtentionsKt.t(r10.c);
    L50:
        TextView r13 = r10.d;
        if (r13 == null) goto L53;
        r13.requestFocus();
    L53:
        TextView r14 = r10.d;
        if (r14 == null) goto L67;
        r14.setSelected(true);
        return;
    L67:
        return;
    L44:
        UtilityKotlinExtentionsKt.w(r10.e);
        r10.f.setText(String.valueOf(r11.h));
        goto L45
    L46:
        r10.g.setAvatarData(r1);
        UtilityKotlinExtentionsKt.t(r10.b);
        UtilityKotlinExtentionsKt.w(r10.c);
        if (r11.l == false) goto L49;
        UtilityKotlinExtentionsKt.w(r10.h);
        goto L50
    L49:
        UtilityKotlinExtentionsKt.t(r10.h);
        goto L50
    L19:
        List r7 = CollectionsKt.take(r11.d, 2);
        ArrayList r15 = new ArrayList();
        Iterator r16 = r7.iterator();
    L21:
        if (r16.hasNext() == false) goto L25;
        ImageModel r17 = ((User) r16.next()).getAvatarThumb();
        if (r17 == null) goto L21;
        r15.add(r17);
        goto L21
    L25:
        r1.addAll(r15);
        goto L40
    L11:
        if (Intrinsics.areEqual(String.valueOf(r6.getOwnerUid()), r10.i) == false) goto L13;
        long r18 = r6.getGuestUid();
    L14:
        Map r19 = r6.getUserAvatarList();
        if (r19 == null) goto L17;
        r4 = (ImageModel) r19.get(Long.valueOf(r18));
        goto L17
    L13:
        r18 = r6.getOwnerUid();
        goto L14
    L26:
        List<? extends py.k> r20 = r11.g;
        if (r20 == null) goto L33;
        Intrinsics.checkNotNull(r20);
        if (r20.size() <= 0) goto L33;
        List<? extends py.k> r21 = r11.g;
        if (r21 == null) goto L40;
        r1.addAll(r21);
    L33:
        List r23 = CollectionsKt.take(r11.d, 2);
        ArrayList r24 = new ArrayList();
        Iterator r25 = r23.iterator();
    L35:
        if (r25.hasNext() == false) goto L39;
        ImageModel r26 = ((User) r25.next()).getAvatarThumb();
        if (r26 == null) goto L35;
        r24.add(r26);
        goto L35
    L39:
        r1.addAll(r24);
        goto L40
    L5:
        r5 = null;
        goto L6
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new ItemViewHolder(r3.inflate(2131565297, r4, false), this.b);
    }
}
