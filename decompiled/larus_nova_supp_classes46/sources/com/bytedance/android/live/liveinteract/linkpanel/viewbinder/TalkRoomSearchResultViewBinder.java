package com.bytedance.android.live.liveinteract.linkpanel.viewbinder;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.TimeUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.linkpanel.util.a0;
import com.bytedance.android.live.liveinteract.linkpanel.util.c;
import com.bytedance.android.live.liveinteract.linkpanel.util.d;
import com.bytedance.android.live.liveinteract.linkpanel.util.e;
import com.bytedance.android.live.liveinteract.linkpanel.util.o;
import com.bytedance.android.live.liveinteract.linkpanel.util.x;
import com.bytedance.android.live.liveinteract.linkpanel.util.y;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.c0;
import com.bytedance.android.live.liveinteract.plantform.model.n0;
import com.bytedance.android.live.liveinteract.plantform.model.u;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.f;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.r;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import zf0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class TalkRoomSearchResultViewBinder extends me.drakeet.multitype.b<b, ResultViewHolder> {
    public final String b;
    public final a c;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/viewbinder/TalkRoomSearchResultViewBinder$ResultViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class ResultViewHolder extends RecyclerView.ViewHolder {
        public final HSImageView a;
        public final LinearLayout b;
        public final TextView c;
        public final TextView d;
        public final TextView e;
        public final FrameLayout f;
        public final a g;
        public final Map<c, View> h;

        /* JADX WARN: Multi-variable type inference failed */
        public ResultViewHolder(View r2, a r3, String r4, Map<c, ? extends View> r5) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            Intrinsics.checkNotNullParameter(r3, "listener");
            Intrinsics.checkNotNullParameter(r4, "requestPage");
            Intrinsics.checkNotNullParameter(r5, "type2View");
            super(r2);
            this.g = r3;
            this.h = r5;
            this.a = r2.findViewById(2131376286);
            this.b = (LinearLayout) r2.findViewById(2131380597);
            this.c = (TextView) r2.findViewById(2131390975);
            this.d = (TextView) r2.findViewById(2131391589);
            this.e = (TextView) r2.findViewById(2131364615);
            this.f = (FrameLayout) r2.findViewById(2131392173);
        }
    }

    public interface a {
        void wJ(u r1, int r2);

        void xW(u r1, int r2);
    }

    public static final class b {
        public final u a;
        public final String b;
        public final boolean c;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L12;
            b r4 = (b) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (this.c == r4.c) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public final int hashCode() {
            u r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 == null) goto L9;
            r1 = r4.hashCode();
        L9:
            int r5 = (r3 + r1) * 31;
            boolean r6 = this.c;
            ?? r7 = r6;
            if (r6 == false) goto L13;
            r7 = 1;
        L13:
            return r5 + r7;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "ResultData(data=" + this.a + ", queryWord=" + this.b + ", isHistoryData=" + this.c + ")";
        }

        public b(u r2, String r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "data");
            Intrinsics.checkNotNullParameter(r3, "queryWord");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public TalkRoomSearchResultViewBinder(String r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "requestPage");
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.b = r2;
        this.c = r3;
    }

    public final void b(RecyclerView.ViewHolder r17, Object r18) {
        ResultViewHolder r0 = (ResultViewHolder) r17;
        b r1 = (b) r18;
        Intrinsics.checkNotNullParameter(r0, "holder");
        Intrinsics.checkNotNullParameter(r1, "item");
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "item");
        IBaseUser r2 = r1.a.getUser();
        if (r2 == null) goto L191;
        a1.v(r0.a, r2.getAvatarThumbKt(), 2131250965);
        boolean r4 = false;
        String r6 = null;
        if (r1.c == false) goto L8;
        r0.c.setText(r2.getNickName());
        UtilityKotlinExtentionsKt.t(r0.d);
    L118:
        LinearLayout r3 = r0.b;
        r3.removeViews(1, r3.getChildCount() - 1);
        com.bytedance.android.live.liveinteract.linkpanel.util.a[] r5 = new com.bytedance.android.live.liveinteract.linkpanel.util.a[4];
        y r7 = y.c;
        r7.f(r2);
        if (r7.e() == true) goto L122;
        r7 = null;
    L122:
        r5[0] = r7;
        e r8 = e.c;
        r8.g(r2);
        if (r8.f() == true) goto L126;
        r8 = null;
    L126:
        r5[1] = r8;
        x r9 = x.e;
        x.a = new WeakReference(r2);
        if (r9.e() == true) goto L130;
        r9 = null;
    L130:
        r5[2] = r9;
        d r10 = d.c;
        r10.g(d.e(r2, null));
        if (r10.f() == true) goto L134;
        r10 = null;
    L134:
        r5[3] = r10;
        List r11 = CollectionsKt.filterNotNull(CollectionsKt.mutableListOf(r5));
        int r12 = com.bytedance.android.live.liveinteract.linkpanel.util.b.a;
        Iterator r13 = com.bytedance.android.live.liveinteract.linkpanel.util.b.d(r11, o.u()).iterator();
    L136:
        if (r13.hasNext() == false) goto L142;
        com.bytedance.android.live.liveinteract.linkpanel.util.a r14 = (com.bytedance.android.live.liveinteract.linkpanel.util.a) r13.next();
        View r15 = r0.h.get(r14.b());
        if (r15 == null) goto L136;
        r14.d(r15, null);
        r0.b.addView(r15);
        goto L136
    L142:
        if (r1.a.getSearchType() != 1) goto L164;
        n0 r16 = r1.a.getWaitingInfo();
        if (r16 != null) goto L146;
    L148:
        n0 r19 = r1.a.getWaitingInfo();
        if (r19 == null) goto L151;
        String r20 = r19.getButtonText();
    L153:
        if (r2.a(r20) == false) goto L158;
        TextView r21 = r0.e;
        n0 r22 = r1.a.getWaitingInfo();
        if (r22 == null) goto L157;
        r6 = r22.getButtonText();
    L157:
        r21.setText(r6);
    L159:
        r0.e.setBackgroundResource(2131249467);
    L160:
        FrameLayout r23 = r0.f;
        n0 r24 = r1.a.getWaitingInfo();
        if (r24 == null) goto L163;
        r4 = r24.isActive();
    L163:
        UtilityKotlinExtentionsKt.z(r23, r4);
    L174:
        r0.e.setOnClickListener(new com.bytedance.android.live.liveinteract.linkpanel.viewbinder.a(r0, r1, r2));
        ((RecyclerView.ViewHolder) r0).itemView.setOnClickListener(new com.bytedance.android.live.liveinteract.linkpanel.viewbinder.b(r2));
        return;
    L158:
        r0.e.setText(s1.B(2131919204));
        goto L159
    L151:
        r20 = null;
        goto L153
    L146:
        if (r16.isHasApplied() != true) goto L148;
        r0.e.setText(s1.B(2131919209));
        r0.e.setBackgroundResource(2131249430);
        goto L160
    L164:
        ILinkPlayerInfoBridge r25 = r1.a.getInviteInfo();
        if (r25 != null) goto L167;
    L169:
        r0.e.setText(s1.B(2131919316));
        r0.e.setBackgroundResource(2131249467);
    L170:
        FrameLayout r26 = r0.f;
        ILinkPlayerInfoBridge r27 = r1.a.getInviteInfo();
        if (r27 == null) goto L173;
        r4 = r27.isActive();
    L173:
        UtilityKotlinExtentionsKt.z(r26, r4);
        goto L174
    L167:
        if (r25.isHasInvited() != true) goto L169;
        r0.e.setText(s1.B(2131919321));
        r0.e.setBackgroundResource(2131249430);
        goto L170
    L8:
        String r28 = r2.getNickName();
        String r29 = r1.b;
        SpannableStringBuilder r30 = new SpannableStringBuilder(r28);
        int r31 = 0;
        int r110 = 0;
        int r111 = 0;
        int r112 = 0;
    L10:
        if (r31 > 10) goto L23;
        if (r110 >= r29.length()) goto L23;
    L13:
        if (r31 > 10) goto L22;
        if (r110 >= r29.length()) goto L22;
        if (r111 >= r28.length()) goto L22;
        if (r29.charAt(r110) == r28.charAt(r111)) goto L20;
        r111 = r111 + 1;
        goto L13
    L20:
        int r113 = r111 + 1;
        r30.setSpan(new ForegroundColorSpan(s1.h(2131107096)), r111, r113, 18);
        r31 = r31 + 1;
        r110 = r110 + 1;
        r112 = r111;
        r111 = r113;
    L22:
        r110 = r110 + 1;
        r111 = r112;
    L23:
        r0.c.setText(r30);
        Ref.ObjectRef r32 = new Ref.ObjectRef();
        String r33 = "";
        r32.element = "";
        if (r1.a.getSearchType() != 1) goto L52;
        n0 r34 = r1.a.getWaitingInfo();
        if (r34 == null) goto L28;
        Long r35 = Long.valueOf(r34.getModifyTime());
    L29:
        int r114 = a0.a;
        m r115 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r115 == null) goto L32;
        IRoom r116 = (IRoom) r115.getValue();
    L34:
        if (a0.a(r116) == false) goto L38;
        n0 r36 = r1.a.getWaitingInfo();
        if (r36 == null) goto L48;
        String r37 = r36.getFanTicket();
    L49:
        n0 r117 = r1.a.getWaitingInfo();
        if (r117 == null) goto L79;
        c0 r118 = r117.getEventInfoFlex();
    L80:
        Integer r119 = (Integer) b6.B.getValue();
        if (r119 != null) goto L84;
    L85:
        if (r119 != null) goto L88;
    L90:
        long r120 = 0;
        if (r35 == null) goto L93;
        long r121 = r35.longValue();
    L95:
        if (r121 <= 0) goto L104;
        Context r38 = s1.getContext();
        if (r35 == null) goto L99;
        r120 = r35.longValue();
    L99:
        r32.element = TimeUtils.getTimeDescription(r38, r120 * ((long) 1000));
    L104:
        if (r118 == null) goto L106;
        a5 r39 = r118.getContent();
    L107:
        if (r39 == null) goto L112;
        a5 r40 = r118.getContent();
        if (r40 == null) goto L118;
        f.a.getClass();
        r.g.d(r40, null, new com.bytedance.android.livesdk.interactivity.service.textrender.core.y(0.0f), new n(r0, r118, r32));
        goto L118
    L112:
        if (((String) r32.element).length() <= 0) goto L114;
        boolean r41 = true;
    L115:
        if (r41 == false) goto L117;
        UtilityKotlinExtentionsKt.w(r0.d);
        r0.d.setText((String) r32.element);
        goto L118
    L117:
        UtilityKotlinExtentionsKt.t(r0.d);
        goto L118
    L114:
        r41 = false;
        goto L115
    L106:
        r39 = null;
        goto L107
    L93:
        r121 = 0;
        goto L95
    L88:
        if (r119.intValue() != 42) goto L90;
    L100:
        if (r37 == null) goto L103;
        r33 = r37;
    L103:
        r32.element = r33;
        goto L104
    L84:
        if (r119.intValue() == 41) goto L100;
    L79:
        r118 = null;
    L48:
        r37 = null;
        goto L49
    L38:
        n0 r122 = r1.a.getWaitingInfo();
        if (r122 == null) goto L41;
        String r123 = r122.getFanTicket();
    L42:
        if (r123 == null) goto L48;
        Object[] r124 = new Object[1];
        n0 r125 = r1.a.getWaitingInfo();
        if (r125 == null) goto L46;
        String r126 = r125.getFanTicket();
    L47:
        r124[0] = r126;
        r37 = s1.C(2131919159, r124);
        goto L49
    L46:
        r126 = null;
        goto L47
    L41:
        r123 = null;
        goto L42
    L32:
        r116 = null;
        goto L34
    L28:
        r35 = null;
        goto L29
    L52:
        ILinkPlayerInfoBridge r42 = r1.a.getInviteInfo();
        if (r42 == null) goto L55;
        r35 = Long.valueOf(r42.getModifyTime());
    L56:
        int r127 = a0.a;
        m r128 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r128 == null) goto L59;
        IRoom r129 = (IRoom) r128.getValue();
    L61:
        if (a0.a(r129) == false) goto L65;
        ILinkPlayerInfoBridge r43 = r1.a.getInviteInfo();
        if (r43 == null) goto L75;
        r37 = r43.getFuzzyFanTicket();
    L76:
        ILinkPlayerInfoBridge r130 = r1.a.getInviteInfo();
        if (r130 == null) goto L79;
        r118 = r130.getEventInfo();
    L75:
        r37 = null;
        goto L76
    L65:
        ILinkPlayerInfoBridge r131 = r1.a.getInviteInfo();
        if (r131 == null) goto L68;
        String r132 = r131.getFuzzyFanTicket();
    L69:
        if (r132 == null) goto L75;
        Object[] r133 = new Object[1];
        ILinkPlayerInfoBridge r134 = r1.a.getInviteInfo();
        if (r134 == null) goto L73;
        String r135 = r134.getFuzzyFanTicket();
    L74:
        r133[0] = r135;
        r37 = s1.C(2131919159, r133);
        goto L76
    L73:
        r135 = null;
        goto L74
    L68:
        r132 = null;
        goto L69
    L59:
        r129 = null;
        goto L61
    L55:
        r35 = null;
        goto L56
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r8, ViewGroup r9) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        Intrinsics.checkNotNullParameter(r9, "parent");
        View r10 = r8.inflate(2131566418, r9, false);
        List r0 = CollectionsKt.listOf(new com.bytedance.android.live.liveinteract.linkpanel.util.a[]{y.c, x.e, e.c, d.c});
        LinkedHashMap r2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r0, 10)), 16));
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        com.bytedance.android.live.liveinteract.linkpanel.util.a r3 = (com.bytedance.android.live.liveinteract.linkpanel.util.a) r1.next();
        Pair r4 = new Pair(r3.b(), r3.a(r8.getContext(), (ViewGroup) r10.findViewById(2131380597)));
        r2.put(r4.getFirst(), r4.getSecond());
        goto L4
    L7:
        return new ResultViewHolder(r10, this.c, this.b, r2);
    }
}
