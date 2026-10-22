package com.bytedance.android.live.liveinteract.linkpanel.viewholder;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.TimeUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.linkpanel.list.o;
import com.bytedance.android.live.liveinteract.linkpanel.util.AvatarType;
import com.bytedance.android.live.liveinteract.linkpanel.util.HighScoreSongBadgeProvider;
import com.bytedance.android.live.liveinteract.linkpanel.util.l;
import com.bytedance.android.live.liveinteract.linkpanel.util.m;
import com.bytedance.android.live.liveinteract.linkpanel.util.x;
import com.bytedance.android.live.liveinteract.linkpanel.util.y;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.ListUserTag;
import com.bytedance.android.live.liveinteract.plantform.model.c0;
import com.bytedance.android.live.liveinteract.plantform.model.d0;
import com.bytedance.android.live.liveinteract.plantform.model.g0;
import com.bytedance.android.live.liveinteract.plantform.model.i;
import com.bytedance.android.live.liveinteract.plantform.model.j0;
import com.bytedance.android.live.liveinteract.plantform.model.n;
import com.bytedance.android.live.liveinteract.plantform.model.o0;
import com.bytedance.android.live.liveinteract.plantform.utils.h0;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.q;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.r;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.fc;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import py.k;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/viewholder/LinkPanelGuestViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "D", "I", "getType", "()I", "type", "a", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkPanelGuestViewHolder extends RecyclerView.ViewHolder {
    public final boolean A;
    public final IRoom B;
    public String C;
    public final int D;
    public final o E;
    public final Map<com.bytedance.android.live.liveinteract.linkpanel.util.c, View> F;
    public final int a;
    public final HSImageView b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public final ConstraintLayout f;
    public final TextView g;
    public final TextView h;
    public final LinearLayout i;
    public final TextView j;
    public final ImageView k;
    public final TextView l;
    public final ImageView m;
    public final View n;
    public final LinearLayout o;
    public final TextView p;
    public final View q;
    public final TextView r;
    public final TextView s;
    public final LinearLayout t;
    public final TextView u;
    public final TextView v;
    public final TextView w;
    public ILinkPlayerInfoBridge x;
    public String y;
    public final boolean z;

    public static final class a {
    }

    public static final class b implements q {
        public final /* synthetic */ LinkPanelGuestViewHolder a;
        public final /* synthetic */ ILinkPlayerInfoBridge b;

        public final void a(k r2) {
            Intrinsics.checkNotNullParameter(r2, "model");
            Intrinsics.checkNotNullParameter(r2, "model");
        }

        public b(LinkPanelGuestViewHolder r1, ILinkPlayerInfoBridge r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void b(SpannableString r9, q.a r10) {
            Intrinsics.checkNotNullParameter(r9, "spannable");
            Intrinsics.checkNotNullParameter(r10, "info");
            TextView r11 = this.a.e;
            c0 r0 = this.b.getEventInfo();
            if (r0 == null) goto L17;
            LinkPanelGuestViewHolder r1 = this.a;
            ILinkPlayerInfoBridge r2 = this.b;
            r1.getClass();
            Integer r3 = (Integer) b6.B.getValue();
            if (r3 != null) goto L8;
        L9:
            if (r3 != null) goto L12;
        L14:
            long r4 = 1000;
            String r5 = TimeUtils.getTimeDescription(s1.getContext(), r2.getModifyTime() * r4, tc0.c.h().Q * r4);
        L16:
            Spannable r12 = d0.a(r0, r9, r5);
        L18:
            r11.setText(r12);
            return;
        L12:
            if (r3.intValue() != 42) goto L14;
        L15:
            r5 = s1.C(2131919159, new Object[]{r2.getFuzzyFanTicket()});
            goto L16
        L8:
            if (r3.intValue() == 41) goto L15;
        L17:
            r12 = null;
            goto L18
        }
    }

    public static final class c implements q {
        public final /* synthetic */ LinkPanelGuestViewHolder a;
        public final /* synthetic */ ILinkPlayerInfoBridge b;

        public final void a(k r2) {
            Intrinsics.checkNotNullParameter(r2, "model");
            Intrinsics.checkNotNullParameter(r2, "model");
        }

        public c(LinkPanelGuestViewHolder r1, ILinkPlayerInfoBridge r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void b(SpannableString r2, q.a r3) {
            Intrinsics.checkNotNullParameter(r2, "spannable");
            Intrinsics.checkNotNullParameter(r3, "info");
            this.a.e.setText(r2);
        }
    }

    static {
    }

    public final boolean W3() {
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.x(this.B) == false) goto L11;
        cj0.a r0 = ((IInteractService) jc1.k.n(IInteractService.class)).paidLinkMicContext();
        if (r0 == null) goto L11;
        cj0.c r1 = r0.getWidget();
        if (r1 == null) goto L11;
        if (r1.isIncreasePriceOn() != true) goto L11;
        return true;
    L11:
        return false;
    }

    public final int getType() {
        return this.D;
    }

    public static com.bytedance.android.live.liveinteract.linkpanel.util.a V3(ILinkPlayerInfoBridge r5) {
        g0 r6 = r5.getMicPosTagInfo();
        if (r6 != null) goto L7;
        return HighScoreSongBadgeProvider.d;
    L7:
        if (r6.getTagType() <= 0) goto L18;
        String r7 = r6.getPositionTagName();
        if (r7 == null) goto L18;
        if (r7.length() <= 0) goto L13;
        boolean r8 = true;
    L14:
        if (r8 != true) goto L18;
        return com.bytedance.android.live.liveinteract.linkpanel.util.f.c;
    L13:
        r8 = false;
    L18:
        return HighScoreSongBadgeProvider.d;
    }

    public final void T3(final ILinkPlayerInfoBridge r30) {
        Intrinsics.checkNotNullParameter(r30, "linkPlayerInfo");
        this.x = r30;
        if (h.U().e() == false) goto L6;
        this.e.setTextSize(1, 11.0f);
    L6:
        if (this.z == true) goto L8;
    L13:
        TextView r2 = this.u;
        if (r2 == null) goto L16;
        r2.setVisibility(8);
    L16:
        final IBaseUser r3 = r30.getUser();
        if (r3 == null) goto L351;
        this.c.setText(r3.getNickName());
        ImageUtil.loadRoundImageAntiFlink(this.b, com.bytedance.android.live.liveinteract.linkpanel.util.o.h(r3, AvatarType.AVATAR_THUMB.getValue()), 0);
        ((RecyclerView.ViewHolder) this).itemView.setOnClickListener(x0.a(new LinkPanelGuestViewHolder$bindView$$inlined$let$lambda$1(r3, this, r30)));
        IRoom r5 = this.B;
        int r11 = l.a;
        if (r5 != null) goto L21;
    L73:
        boolean r6 = false;
    L74:
        if (r6 == true) goto L76;
    L88:
        this.v.setVisibility(8);
        this.o.setVisibility(0);
    L89:
        int r7 = r3.getGender();
        if (r7 == 1) goto L94;
        if (r7 == 2) goto L93;
        this.k.setVisibility(8);
    L96:
        if (r3.getGender() != 1) goto L99;
        r3.a(((RecyclerView.ViewHolder) this).itemView, r3.getNickName() + " + " + s1.B(2131917068) + ' ' + s1.B(2131917070));
    L101:
        LinearLayout r8 = this.i;
        r8.removeViews(1, r8.getChildCount() - 1);
        com.bytedance.android.live.liveinteract.linkpanel.util.a r9 = V3(r30);
        com.bytedance.android.live.liveinteract.linkpanel.util.a[] r10 = new com.bytedance.android.live.liveinteract.linkpanel.util.a[5];
        y r12 = y.c;
        r12.f(r3);
        if (r12.e() == true) goto L105;
        r12 = null;
    L105:
        r10[0] = r12;
        com.bytedance.android.live.liveinteract.linkpanel.util.e r13 = com.bytedance.android.live.liveinteract.linkpanel.util.e.c;
        r13.g(r3);
        if (r13.f() == true) goto L109;
        r13 = null;
    L109:
        r10[1] = r13;
        x r14 = x.e;
        x.a = new WeakReference(r3);
        if (r14.e() == true) goto L113;
        r14 = null;
    L113:
        r10[2] = r14;
        com.bytedance.android.live.liveinteract.linkpanel.util.d r15 = com.bytedance.android.live.liveinteract.linkpanel.util.d.c;
        r15.g(com.bytedance.android.live.liveinteract.linkpanel.util.d.e(r3, r30.getTags()));
        if (r15.f() == true) goto L117;
        r15 = null;
    L117:
        r10[3] = r15;
        if ((r9 instanceof com.bytedance.android.live.liveinteract.linkpanel.util.f) == false) goto L123;
        com.bytedance.android.live.liveinteract.linkpanel.util.f r16 = (com.bytedance.android.live.liveinteract.linkpanel.util.f) r9;
        r16.getClass();
        com.bytedance.android.live.liveinteract.linkpanel.util.f.b = new WeakReference(r30);
        boolean r17 = r16.e();
        com.bytedance.android.live.liveinteract.linkpanel.util.a r18 = r16;
        if (r17 == true) goto L128;
    L127:
        r18 = null;
    L128:
        r10[4] = r18;
        List r19 = CollectionsKt.filterNotNull(CollectionsKt.mutableListOf(r10));
        int r20 = com.bytedance.android.live.liveinteract.linkpanel.util.b.a;
        Iterator r21 = com.bytedance.android.live.liveinteract.linkpanel.util.b.d(r19, com.bytedance.android.live.liveinteract.linkpanel.util.o.u()).iterator();
    L129:
        String r22 = "";
        if (r21.hasNext() == false) goto L148;
        com.bytedance.android.live.liveinteract.linkpanel.util.a r23 = (com.bytedance.android.live.liveinteract.linkpanel.util.a) r21.next();
        View r110 = this.F.get(r23.b());
        if (r110 == null) goto L129;
        if ((r23 instanceof com.bytedance.android.live.liveinteract.linkpanel.util.e) == false) goto L144;
        py.d r111 = r3.getUserHonor();
        if (r111 == null) goto L142;
        String r112 = String.valueOf(r111.getLevel());
        if (r112 == null) goto L142;
        r22 = r112;
    L142:
        this.C = r22;
    L144:
        if ((r23 instanceof com.bytedance.android.live.liveinteract.linkpanel.util.f) == false) goto L146;
        r23.d(r110, new LinkPanelGuestViewHolder$bindView$$inlined$let$lambda$2(r3, this, r30));
    L147:
        this.i.addView(r110);
        goto L129
    L146:
        r23.d(r110, null);
        goto L147
    L148:
        this.l.setText(r30.getLocation());
        if (TextUtils.isEmpty(r30.getLocation()) == false) goto L151;
    L157:
        this.l.setVisibility(8);
        this.m.setVisibility(8);
        this.n.setVisibility(8);
    L158:
        LinearLayout r24 = this.i;
        r24.removeViews(1, r24.getChildCount() - 1);
        com.bytedance.android.live.liveinteract.linkpanel.util.a r25 = V3(r30);
        com.bytedance.android.live.liveinteract.linkpanel.util.a[] r26 = new com.bytedance.android.live.liveinteract.linkpanel.util.a[5];
        y r113 = y.c;
        r113.f(r3);
        if (r113.e() == true) goto L162;
        r113 = null;
    L162:
        r26[0] = r113;
        com.bytedance.android.live.liveinteract.linkpanel.util.e r114 = com.bytedance.android.live.liveinteract.linkpanel.util.e.c;
        r114.g(r3);
        if (r114.f() == true) goto L166;
        r114 = null;
    L166:
        r26[1] = r114;
        x r115 = x.e;
        x.a = new WeakReference(r3);
        x.b = new WeakReference(r30.getTags());
        if (r115.e() == true) goto L170;
        r115 = null;
    L170:
        r26[2] = r115;
        com.bytedance.android.live.liveinteract.linkpanel.util.d r116 = com.bytedance.android.live.liveinteract.linkpanel.util.d.c;
        r116.g(com.bytedance.android.live.liveinteract.linkpanel.util.d.e(r3, r30.getTags()));
        if (r116.f() == true) goto L174;
        r116 = null;
    L174:
        r26[3] = r116;
        if ((r25 instanceof com.bytedance.android.live.liveinteract.linkpanel.util.f) == false) goto L180;
        com.bytedance.android.live.liveinteract.linkpanel.util.f r27 = (com.bytedance.android.live.liveinteract.linkpanel.util.f) r25;
        r27.getClass();
        com.bytedance.android.live.liveinteract.linkpanel.util.f.b = new WeakReference(r30);
        boolean r117 = r27.e();
        com.bytedance.android.live.liveinteract.linkpanel.util.a r28 = r27;
        if (r117 == true) goto L185;
    L184:
        r28 = null;
    L185:
        r26[4] = r28;
        List r29 = CollectionsKt.filterNotNull(CollectionsKt.mutableListOf(r26));
        this.y = "";
        int r31 = com.bytedance.android.live.liveinteract.linkpanel.util.b.a;
        Iterator r32 = com.bytedance.android.live.liveinteract.linkpanel.util.b.d(r29, com.bytedance.android.live.liveinteract.linkpanel.util.o.u()).iterator();
    L187:
        if (r32.hasNext() == false) goto L210;
        com.bytedance.android.live.liveinteract.linkpanel.util.a r33 = (com.bytedance.android.live.liveinteract.linkpanel.util.a) r32.next();
        View r118 = this.F.get(r33.b());
        if (r118 == null) goto L187;
        if ((r33 instanceof com.bytedance.android.live.liveinteract.linkpanel.util.e) == false) goto L200;
        py.d r119 = r3.getUserHonor();
        if (r119 == null) goto L197;
        String r120 = String.valueOf(r119.getLevel());
        if (r120 == null) goto L197;
    L198:
        this.C = r120;
    L197:
        r120 = "";
    L200:
        if ((r33 instanceof com.bytedance.android.live.liveinteract.linkpanel.util.f) == false) goto L202;
        r33.d(r118, new LinkPanelGuestViewHolder$loadBadgeList$$inlined$onEach$lambda$1(this, r3));
    L203:
        this.i.addView(r118);
        if (r33.c().length() <= 0) goto L206;
        boolean r121 = true;
    L207:
        if (r121 == false) goto L187;
        this.y = this.y + r33.c() + ',';
        goto L187
    L206:
        r121 = false;
        goto L207
    L202:
        r33.d(r118, null);
        goto L203
    L210:
        if (this.y.length() <= 0) goto L212;
        boolean r34 = true;
    L213:
        if (r34 == false) goto L216;
        String r35 = this.y;
        this.y = r35.substring(0, r35.length() - 1);
    L216:
        if (this.D != 0) goto L322;
        this.e.setVisibility(0);
        if (vm2.d.I0() == false) goto L229;
        c0 r36 = r30.getEventInfo();
        if (r36 == null) goto L222;
        a5 r37 = r36.getContent();
    L223:
        if (r37 == null) goto L229;
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.a.getClass();
        r r38 = r.g;
        c0 r39 = r30.getEventInfo();
        if (r39 == null) goto L227;
        a5 r40 = r39.getContent();
    L228:
        Intrinsics.checkNotNull(r40);
        r38.d(r40, null, new com.bytedance.android.livesdk.interactivity.service.textrender.core.y(0.0f), new b(this, r30));
    L266:
        TextView r4 = this.u;
        if (r4 != null) goto L269;
    L276:
        TextView r41 = this.u;
        if (r41 == null) goto L279;
        Integer r42 = Integer.valueOf(r41.getVisibility());
    L281:
        if (r42.intValue() != 0) goto L287;
        TextView r43 = this.u;
        if (getAdapterPosition() >= this.a) goto L285;
        String r44 = String.valueOf(getAdapterPosition());
    L286:
        r43.setText(r44);
        goto L287
    L285:
        r44 = "99+";
    L287:
        TextView r45 = this.j;
        if (X3(r30) == false) goto L290;
        int r46 = 0;
    L291:
        r45.setVisibility(r46);
        if (r30.isHasApplied() == false) goto L294;
        this.j.setText(s1.B(2131919209));
        this.j.setBackgroundResource(2131249430);
        boolean r47 = false;
    L304:
        this.j.setOnClickListener(x0.a(new LinkPanelGuestViewHolder$bindView$$inlined$let$lambda$4(this, r30)));
        if (r47 == false) goto L350;
        String r210 = r3.getIdString();
        boolean r48 = this.z;
        String r211 = String.valueOf(r30.getFanTicket());
        Intrinsics.checkNotNullParameter(r30, "$this$relationship");
        if (r30.getUser() == null) goto L309;
        IBaseUser r49 = r30.getUser();
        Intrinsics.checkNotNull(r49);
        String r50 = r49.getRelationship();
    L310:
        String r212 = r50;
        String r213 = n.c(r30);
        String r51 = this.C;
        Long r214 = Long.valueOf(n.b(r30));
        String r52 = this.y;
        c0 r53 = r30.getEventInfo();
        if (r53 == null) goto L320;
        Intrinsics.checkNotNullParameter(r53, "$this$exposeName");
        int r54 = r53.getEventInfoType();
        if (r54 != 5) goto L315;
        r22 = "browse";
    L319:
        String r215 = r22;
    L321:
        m.M(r210, r48, r211, r212, r213, r51, r214, r52, r215);
        goto L350
    L315:
        if (r54 != 6) goto L319;
        r22 = "order";
        goto L319
    L320:
        r215 = null;
        goto L321
    L309:
        r50 = "null";
    L350:
        r30.setHasExposed(true);
        Unit r55 = Unit.INSTANCE;
        goto L351
    L294:
        TextView r56 = this.j;
        if (TextUtils.isEmpty(r30.getButtonText()) == true) goto L297;
        String r57 = r30.getButtonText();
    L298:
        r56.setText(r57);
        if (Intrinsics.areEqual(r30.getButtonText(), s1.B(2131919207)) == true) goto L301;
    L303:
        this.j.setBackgroundResource(2131249467);
        r47 = true;
        goto L304
    L301:
        if (this.j.getVisibility() != 8) goto L303;
        this.j.setVisibility(0);
        goto L303
    L297:
        r57 = s1.B(2131919204);
        goto L298
    L290:
        r46 = 8;
        goto L291
    L279:
        r42 = null;
        goto L281
    L269:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.L0.getValue()).booleanValue() == false) goto L271;
    L274:
        int r58 = 8;
    L275:
        r4.setVisibility(r58);
        goto L276
    L271:
        if (W3() == true) goto L274;
        r58 = 0;
        goto L275
    L227:
        r40 = null;
        goto L228
    L222:
        r37 = null;
    L229:
        Integer r59 = (Integer) b6.B.getValue();
        if (r59 != null) goto L233;
    L234:
        if (r59 != null) goto L237;
    L239:
        TextView r60 = this.e;
        long r61 = 1000;
        String r62 = TimeUtils.getTimeDescription(s1.getContext(), r30.getModifyTime() * r61, tc0.c.h().Q * r61);
        if (r30.getListUserFromType() == 4) goto L243;
        SpannableString r63 = new SpannableString(r62);
    L252:
        r60.setText(r63);
        goto L266
    L243:
        IBaseUser r65 = r30.getInvitor();
        if (r65 == null) goto L247;
        String r66 = r65.getNickName();
        if (r66 == null) goto L247;
    L249:
        if (r66.length() <= 4) goto L251;
        r66 = r66.substring(0, 3) + "...";
    L251:
        StringCompanionObject r67 = StringCompanionObject.INSTANCE;
        SpannableString r68 = new SpannableString(r62 + String.format("由%s邀请", Arrays.copyOf(new Object[]{r66}, 1)));
        r68.setSpan(new StyleSpan(1), r62.length() + 1, (r62.length() + 1) + r66.length(), 18);
        r63 = r68;
    L247:
        r66 = "";
        goto L249
    L237:
        if (r59.intValue() != 42) goto L239;
    L253:
        TextView r69 = this.e;
        String r70 = s1.C(2131919159, new Object[]{r30.getFuzzyFanTicket()});
        if (r30.getListUserFromType() == 4) goto L256;
        SpannableString r71 = new SpannableString(r70);
    L265:
        r69.setText(r71);
        goto L266
    L256:
        IBaseUser r72 = r30.getInvitor();
        if (r72 == null) goto L260;
        String r73 = r72.getNickName();
        if (r73 == null) goto L260;
    L262:
        if (r73.length() <= 4) goto L264;
        r73 = r73.substring(0, 3) + "...";
    L264:
        StringCompanionObject r74 = StringCompanionObject.INSTANCE;
        SpannableString r122 = new SpannableString(r70 + String.format(" 由%s邀请", Arrays.copyOf(new Object[]{r73}, 1)));
        r122.setSpan(new StyleSpan(1), r70.length() + 2, (r70.length() + 2) + r73.length(), 18);
        r71 = r122;
    L260:
        r73 = "";
        goto L262
    L233:
        if (r59.intValue() == 41) goto L253;
    L322:
        this.e.setVisibility(0);
        if (vm2.d.I0() == false) goto L335;
        c0 r75 = r30.getEventInfo();
        if (r75 == null) goto L327;
        a5 r76 = r75.getContent();
    L328:
        if (r76 == null) goto L335;
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.a.getClass();
        r r77 = r.g;
        c0 r78 = r30.getEventInfo();
        if (r78 == null) goto L332;
        a5 r79 = r78.getContent();
    L333:
        Intrinsics.checkNotNull(r79);
        r77.d(r79, null, new com.bytedance.android.livesdk.interactivity.service.textrender.core.y(0.0f), new c(this, r30));
    L346:
        if (r30.isHasInvited() == false) goto L348;
        this.j.setText(s1.B(2131919321));
        this.j.setBackgroundResource(2131249430);
    L349:
        this.j.setOnClickListener(x0.a(new LinkPanelGuestViewHolder$bindView$$inlined$let$lambda$6(this, r30)));
        goto L350
    L348:
        this.j.setText(s1.B(2131919316));
        this.j.setBackgroundResource(2131249467);
        goto L349
    L332:
        r79 = null;
        goto L333
    L327:
        r76 = null;
    L335:
        if (this.z == false) goto L337;
    L338:
        this.e.setVisibility(8);
        this.d.setVisibility(0);
        TextView r80 = this.d;
        i r81 = r30.getInviteListUserInfo();
        if (r81 == null) goto L343;
        String r82 = r81.getFuzzyFanTicket();
        if (r82 == null) goto L343;
    L344:
        r80.setText(r82);
    L343:
        r82 = "0";
        goto L344
    L337:
        if (this.A == false) goto L346;
    L212:
        r34 = false;
        goto L213
    L180:
        if ((r25 instanceof HighScoreSongBadgeProvider) == false) goto L184;
        HighScoreSongBadgeProvider r83 = (HighScoreSongBadgeProvider) r25;
        fc r123 = r30.getUserHighScoreSongTag();
        r83.getClass();
        HighScoreSongBadgeProvider.b = new WeakReference(r123);
        boolean r124 = r83.e();
        r28 = r83;
        if (r124 == false) goto L184;
    L151:
        if (r30.getListUserFromType() == 4) goto L157;
        this.l.setVisibility(0);
        this.m.setVisibility(0);
        if (this.D != 0) goto L156;
        this.n.setVisibility(0);
        goto L158
    L156:
        this.n.setVisibility(8);
        goto L158
    L123:
        if ((r9 instanceof HighScoreSongBadgeProvider) == false) goto L127;
        HighScoreSongBadgeProvider r84 = (HighScoreSongBadgeProvider) r9;
        fc r85 = r30.getUserHighScoreSongTag();
        r84.getClass();
        HighScoreSongBadgeProvider.b = new WeakReference(r85);
        boolean r86 = r84.e();
        r18 = r84;
        if (r86 == false) goto L127;
    L99:
        if (r3.getGender() != 2) goto L101;
        r3.a(((RecyclerView.ViewHolder) this).itemView, r3.getNickName() + ' ' + s1.B(2131917068) + ' ' + s1.B(2131917069));
        goto L101
    L93:
        this.k.setVisibility(0);
        this.k.setImageResource(2131250687);
        r3.a(this.k, s1.B(2131917068) + " + " + s1.B(2131917069));
        goto L96
    L94:
        this.k.setVisibility(0);
        this.k.setImageResource(2131250688);
        r3.a(this.k, s1.B(2131917068) + " + " + s1.B(2131917070));
        goto L96
    L76:
        if (this.D != 0) goto L88;
        o0 r87 = r30.getWaitingListUserInfo();
        if (r87 == null) goto L80;
        String r88 = r87.getApplyReason();
    L82:
        if (TextUtils.isEmpty(r88) == true) goto L88;
        this.v.setVisibility(0);
        this.o.setVisibility(8);
        TextView r89 = this.v;
        Object[] r90 = new Object[1];
        o0 r91 = r30.getWaitingListUserInfo();
        if (r91 == null) goto L86;
        String r92 = r91.getApplyReason();
    L87:
        r90[0] = r92;
        r89.setText(s1.C(2131917985, r90));
        goto L89
    L86:
        r92 = null;
        goto L87
    L80:
        r88 = null;
        goto L82
    L21:
        if (r5.isThirdParty() == true) goto L73;
        int r125 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        Boolean r126 = com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor();
        if (r126 == null) goto L26;
        boolean r127 = r126.booleanValue();
    L27:
        if (r125 != 5) goto L29;
    L60:
        if (r127 == true) goto L62;
    L64:
        boolean r93 = false;
    L65:
        if (r127 == false) goto L67;
    L69:
        boolean r94 = false;
    L70:
        if (r93 == true) goto L72;
        if (r94 == false) goto L73;
    L72:
        r6 = true;
        goto L74
    L67:
        if (((Number) vm2.d.m1.getValue(null, vm2.d.a[114(0x72, float:1.6E-43)])).intValue() != 1) goto L69;
        r94 = true;
        goto L70
    L62:
        if (((Number) vm2.d.l1.getValue(null, vm2.d.a[113(0x71, float:1.58E-43)])).intValue() != 1) goto L64;
        r93 = true;
        goto L65
    L29:
        if (r125 == 12) goto L34;
        if (r125 == 8) goto L34;
        if (r125 == 9) goto L60;
    L34:
        Map r95 = r5.getAnchorABMap();
        if (r95 == null) goto L37;
        String r96 = (String) r95.get("video_anchor_apply_reason_enable");
    L38:
        if (r127 == true) goto L40;
    L42:
        boolean r97 = false;
    L43:
        if (r127 == false) goto L45;
    L47:
        boolean r98 = false;
    L48:
        if (r97 == true) goto L50;
        if (r98 == false) goto L73;
    L50:
        if (r96 != null) goto L52;
    L55:
        boolean r99 = true;
    L56:
        if (r99 == true) goto L72;
        if (CastIntegerProtector.parseInt(r96) != 1) goto L73;
    L52:
        if (r96.length() == 0) goto L55;
        r99 = false;
        goto L56
    L45:
        if (((Number) vm2.d.n1.getValue(null, vm2.d.a[115(0x73, float:1.61E-43)])).intValue() != 1) goto L47;
        r98 = true;
        goto L48
    L40:
        if (((Number) vm2.d.k1.getValue(null, vm2.d.a[112(0x70, float:1.57E-43)])).intValue() != 1) goto L42;
        r97 = true;
        goto L43
    L37:
        r96 = null;
        goto L38
    L26:
        r127 = false;
    L351:
        List<KtvMusic> r100 = r30.getSongList();
        this.s.setText(null);
        List<KtvMusic> r101 = r100;
        if (r101 != null) goto L354;
    L357:
        boolean r102 = true;
    L358:
        if (r102 == false) goto L360;
    L375:
        String r103 = "#FE2C55";
        if (this.D != 0) goto L408;
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.B() == false) goto L408;
        if (r30.getJoinTeamFightInfo() == null) goto L408;
        j0 r104 = r30.getJoinTeamFightInfo();
        if (r104 == null) goto L386;
        if (r104.getTeamId() == 0) goto L408;
    L386:
        if (((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene() != 5) goto L388;
        boolean r105 = true;
    L389:
        if (r105 == false) goto L408;
        this.o.setVisibility(0);
        this.t.setVisibility(8);
        this.v.setVisibility(8);
        this.l.setVisibility(8);
        this.m.setVisibility(8);
        this.n.setVisibility(0);
        this.w.setVisibility(0);
        j0 r106 = r30.getJoinTeamFightInfo();
        if (r106 == null) goto L398;
        Intrinsics.checkNotNullParameter(r106, "$this$isRedTeam");
        if (((int) r106.getTeamId()) != 1) goto L395;
        boolean r107 = true;
    L396:
        if (r107 != true) goto L398;
        boolean r108 = true;
    L399:
        if (r108 == false) goto L401;
        String r109 = "#FE2C55";
    L402:
        int r128 = ColorProtector.parseColor(r109);
        SpannableStringBuilder r129 = new SpannableStringBuilder();
        r129.append(s1.B(2131922775));
        if (r108 == false) goto L405;
        int r130 = 2131922805;
    L406:
        r129.append(s1.B(r130));
        r129.setSpan(new ForegroundColorSpan(r128), 2, 4, 33);
        this.w.setText(r129);
        goto L408
    L405:
        r130 = 2131922777;
        goto L406
    L401:
        r109 = "#27A4FF";
        goto L402
    L395:
        r107 = false;
    L398:
        r108 = false;
        goto L399
    L388:
        r105 = false;
    L408:
        if (this.D != 0) goto L444;
        if (((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene() != 5) goto L412;
        boolean r131 = true;
    L413:
        if (r131 == false) goto L444;
        if (W3() == false) goto L444;
        this.o.setVisibility(8);
        this.t.setVisibility(8);
        o0 r132 = r30.getWaitingListUserInfo();
        if (r132 == null) goto L419;
        String r133 = r132.getApplyReason();
    L421:
        if (TextUtils.isEmpty(r133) == true) goto L427;
        this.h.setVisibility(8);
        this.v.setVisibility(0);
        TextView r134 = this.v;
        Object[] r135 = new Object[1];
        o0 r136 = r30.getWaitingListUserInfo();
        if (r136 == null) goto L425;
        String r137 = r136.getApplyReason();
    L426:
        r135[0] = r137;
        r134.setText(s1.C(2131917985, r135));
    L429:
        if (r30.isAddPrice() == false) goto L431;
        this.h.setText(TimeUtils.getTimeDescription(s1.getContext(), r30.getAddPriceTime(), tc0.c.h().Q * ((long) 1000)));
        goto L444
    L431:
        Integer r138 = (Integer) b6.B.getValue();
        if (r138 != null) goto L435;
    L436:
        if (r138 != null) goto L439;
    L441:
        long r139 = 1000;
        this.h.setText(TimeUtils.getTimeDescription(s1.getContext(), r30.getModifyTime() * r139, tc0.c.h().Q * r139));
        goto L444
    L439:
        if (r138.intValue() != 42) goto L441;
    L442:
        this.h.setText(s1.C(2131919159, new Object[]{r30.getFuzzyFanTicket()}));
        goto L444
    L435:
        if (r138.intValue() == 41) goto L442;
    L425:
        r137 = null;
        goto L426
    L427:
        this.h.setVisibility(0);
        this.v.setVisibility(8);
        goto L429
    L419:
        r133 = null;
        goto L421
    L412:
        r131 = false;
    L444:
        if (this.D == 0) goto L446;
    L479:
        ListUserTag r140 = r30.getTag();     // Catch: IllegalArgumentException -> L468
        if (r140 == null) goto L466;
        this.f.setVisibility(0);     // Catch: IllegalArgumentException -> L468
        String r141 = r140.getTextColor();     // Catch: IllegalArgumentException -> L468
        if (r141 == null) goto L454;
        r103 = r141;
    L454:
        Long r142 = r140.getBgRadius();     // Catch: IllegalArgumentException -> L468
        if (r142 == null) goto L457;
        float r143 = r142.longValue();     // Catch: IllegalArgumentException -> L468
    L458:
        String r144 = r140.getBgColor();     // Catch: IllegalArgumentException -> L468
        if (r144 != null) goto L461;
        r144 = "#0FFE2C55";
    L461:
        GradientDrawable r145 = new GradientDrawable();     // Catch: IllegalArgumentException -> L468
        r145.setCornerRadius(r143);     // Catch: IllegalArgumentException -> L468
        r145.setColor(Color.parseColor(r144));     // Catch: IllegalArgumentException -> L468
        this.f.setBackground(r145);     // Catch: IllegalArgumentException -> L468
        this.g.setText(r140.getContent());     // Catch: IllegalArgumentException -> L468
        TextView r146 = this.g;     // Catch: IllegalArgumentException -> L468
        Long r147 = r140.getTextSize();     // Catch: IllegalArgumentException -> L468
        if (r147 == null) goto L464;
        float r148 = r147.longValue();     // Catch: IllegalArgumentException -> L468
    L465:
        r146.setTextSize(r148);     // Catch: IllegalArgumentException -> L468
        this.g.setTextColor(Color.parseColor(r103));     // Catch: IllegalArgumentException -> L468
    L477:
        U3(this.e, r30);
        return;
    L464:
        r148 = 10.0f;
        goto L465
    L457:
        r143 = 2.0f;
        goto L458
    L466:
        this.f.setVisibility(8);     // Catch: IllegalArgumentException -> L468
    L468:
        StringBuilder r149 = new StringBuilder("Invalid color string, bgColor=");
        ListUserTag r150 = r30.getTag();
        if (r150 == null) goto L471;
        String r151 = r150.getBgColor();
    L472:
        r149.append(r151);
        r149.append(", textColor=");
        ListUserTag r152 = r30.getTag();
        if (r152 == null) goto L475;
        String r153 = r152.getTextColor();
    L476:
        r149.append(r153);
        ALogger.i("LinkPanelGuestViewHolder", r149.toString());
        goto L477
    L475:
        r153 = null;
        goto L476
    L471:
        r151 = null;
        goto L472
    L446:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.L(r30) == false) goto L479;
        this.t.setVisibility(8);
        this.v.setVisibility(8);
        this.o.setVisibility(0);
        this.h.setVisibility(8);
        this.e.setText(s1.C(2131897351, new Object[]{Long.valueOf(r30.getPaidAmount())}));
        goto L479
    L360:
        if (this.v.getVisibility() == 0) goto L375;
        this.o.setVisibility(8);
        if ((!h0.a.booleanValue()) == false) goto L364;
        this.t.setVisibility(8);
    L365:
        this.p.setMaxWidth(s1.f(120.0f));
        if (r30.getOrderedSongCount() > 1) goto L368;
        this.r.setVisibility(8);
    L371:
        this.p.setText(((KtvMusic) ListProtector.get(r100, 0)).getTitle());
        U3(this.s, r30);
        if (r30.getListUserFromType() != 2) goto L375;
        this.q.setBackground(s1.m(2131251746));
        goto L375
    L368:
        this.r.setText(s1.C(2131919483, new Object[]{Long.valueOf(r30.getOrderedSongCount())}));
        this.r.setVisibility(0);
        if (r30.getAlreadyInvited() == false) goto L371;
        this.p.setMaxWidth(s1.f(85.0f));
        goto L371
    L364:
        this.t.setVisibility(0);
        goto L365
    L354:
        if (r101.isEmpty() == true) goto L357;
        r102 = false;
        goto L358
    L8:
        if (r30.isAddPrice() == true) goto L10;
    L12:
        ((RecyclerView.ViewHolder) this).itemView.setBackgroundColor(s1.h(2131107196));
        goto L13
    L10:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.L(r30) == true) goto L12;
        ((RecyclerView.ViewHolder) this).itemView.setBackgroundColor(s1.h(2131107203));
        goto L13
    }

    public final boolean X3(ILinkPlayerInfoBridge r5) {
        IRoom r0 = this.B;
        if (r0 != null) goto L5;
    L9:
        boolean r1 = false;
    L10:
        IRoom r3 = this.B;
        if (r3 != null) goto L13;
    L17:
        boolean r4 = false;
    L18:
        if (r4 == true) goto L22;
        if (r1 == true) goto L22;
        if (r5.getApplyTypeNew() == LinkApplyType.PREPARE_APPLY.getValue()) goto L22;
        return false;
    L22:
        return true;
    L13:
        if (r3.isLiveTypeAudio() == true) goto L17;
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.t1.getValue()).booleanValue() == false) goto L17;
        r4 = true;
        goto L18
    L5:
        if (r0.isLiveTypeAudio() != true) goto L9;
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.L0.getValue()).booleanValue() == false) goto L9;
        r1 = true;
        goto L10
    }

    public static void U3(TextView r1, ILinkPlayerInfoBridge r2) {
        if (r2.getAlreadyInvited() == false) goto L6;
        r1.setText(r1.getText().toString() + " " + s1.B(2131920044));
        r1.setVisibility(0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LinkPanelGuestViewHolder(View r2, int r3, o r4, Map<com.bytedance.android.live.liveinteract.linkpanel.util.c, ? extends View> r5) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r5, "badgeTypeMap");
        super(r2);
        this.D = r3;
        this.E = r4;
        this.F = r5;
        this.a = 100;
        this.b = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131376286);
        this.c = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390975);
        this.d = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390816);
        this.e = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131391041);
        this.f = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131391049);
        this.g = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131391048);
        this.h = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390774);
        this.i = (LinearLayout) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131380597);
        this.j = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131382185);
        this.k = (ImageView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131376272);
        this.l = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390517);
        this.m = (ImageView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131376380);
        this.n = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131373607);
        this.o = (LinearLayout) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131381730);
        this.p = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131391487);
        this.q = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131376713);
        this.r = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131391488);
        this.s = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131391485);
        this.t = (LinearLayout) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131377082);
        this.u = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131391017);
        this.v = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131363194);
        this.w = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131391562);
        this.y = "";
        Boolean r6 = com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor();
        if (r6 == null) goto L5;
        boolean r7 = r6.booleanValue();
    L6:
        this.z = r7;
        this.A = jc1.k.n(IMiddlewareUserService.class).user().c();
        com.bytedance.live.datacontext.m r8 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r8 == null) goto L9;
        IRoom r9 = (IRoom) r8.getValue();
    L10:
        this.B = r9;
        this.C = "";
        return;
    L9:
        r9 = null;
        goto L10
    L5:
        r7 = false;
        goto L6
    }
}
