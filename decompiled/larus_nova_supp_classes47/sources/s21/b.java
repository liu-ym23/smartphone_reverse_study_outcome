package s21;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.impl.multianchor.ui.AnchorLinkInfoView;
import com.bytedance.android.live.revlink.impl.multianchor.utils.x;
import com.bytedance.android.live.revlink.impl.pk.ui.PkTagsContainerView;
import com.bytedance.android.live.revlink.impl.pk.ui.h;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.link.model.IBattleRivalTag;
import com.bytedance.android.livesdk.link.model.t5;
import com.bytedance.android.livesdk.widget.VHeadView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements t21.a {
    public Boolean A;
    public Boolean B;
    public Boolean C;
    public Runnable D;
    public String E;
    public long F;
    public final a G;
    public final LayoutInflater H;
    public final ViewGroup I;
    public Context a;
    public View b;
    public VHeadView c;
    public VHeadView d;
    public TextView e;
    public PkTagsContainerView f;
    public ViewGroup g;
    public ViewGroup h;
    public ImageView i;
    public TextView j;
    public AnchorLinkInfoView k;
    public Button l;
    public k m;
    public String n;
    public Integer o;
    public List<? extends IBattleRivalTag> p;
    public Integer q;
    public Integer r;
    public Long s;
    public Boolean t;
    public List<? extends t5> u;
    public Boolean v;
    public Boolean w;
    public Boolean x;
    public Map<String, Long> y;
    public String z;

    public static final class a<T> implements Observer {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        public final void onChanged(Object r18) {
            r21.a r0 = (r21.a) r18;
            if (r0 == null) goto L267;
            b r2 = this.a;
            r2.getClass();
            if ((!Intrinsics.areEqual(r0.a, r2.m)) == false) goto L13;
            k r3 = r0.a;
            VHeadView r7 = r2.c;
            if (r7 == null) goto L12;
            if (r3 != null) goto L11;
            r7.setImageResource(0);
            goto L12
        L11:
            a1.x(r7, r3, r7.getWidth(), r7.getHeight(), 2131250965);
        L12:
            r2.m = r0.a;
        L13:
            String r8 = "";
            if ((!Intrinsics.areEqual(r0.b, r2.n)) == false) goto L23;
            String r4 = r0.b;
            TextView r9 = r2.e;
            if (r9 == null) goto L21;
            if (r4 != null) goto L20;
            r4 = "";
        L20:
            r9.setText(r4);
        L21:
            r2.n = r0.b;
        L23:
            if ((!Intrinsics.areEqual(r0.c, r2.o)) == false) goto L50;
            Integer r5 = r0.c;
            if (r5 != null) goto L28;
        L35:
            if (r5 != null) goto L38;
        L45:
            VHeadView r6 = r2.d;
            if (r6 == null) goto L48;
            r6.setVisibility(8);
        L48:
            r2.o = r0.c;
            goto L50
        L38:
            if (r5.intValue() != 2) goto L45;
            VHeadView r10 = r2.d;
            if (r10 == null) goto L42;
            r10.setImageResource(2131250687);
        L42:
            VHeadView r12 = r2.d;
            if (r12 == null) goto L48;
            r12.setVisibility(0);
            goto L48
        L28:
            if (r5.intValue() != 1) goto L35;
            VHeadView r13 = r2.d;
            if (r13 == null) goto L32;
            r13.setImageResource(2131250688);
        L32:
            VHeadView r14 = r2.d;
            if (r14 == null) goto L48;
            r14.setVisibility(0);
        L50:
            if ((!Intrinsics.areEqual(r0.d, r2.p)) == false) goto L64;
            List<IBattleRivalTag> r15 = r0.d;
            if (r15 == null) goto L59;
            PkTagsContainerView r16 = r2.f;
            if (r16 == null) goto L56;
            r16.setOldTag(true);
        L56:
            PkTagsContainerView r17 = r2.f;
            if (r17 == null) goto L62;
            PkTagsContainerView.f(r17, r15, false, null, 9, "", 32);
        L62:
            r2.p = r0.d;
            goto L64
        L59:
            PkTagsContainerView r19 = r2.f;
            if (r19 == null) goto L62;
            r19.c = 0;
        L64:
            if ((!Intrinsics.areEqual(r0.e, r2.q)) == false) goto L66;
        L71:
            Integer r20 = r0.e;
            Integer r110 = r0.f;
            Long r111 = r0.g;
            Boolean r112 = r0.h;
            Context r113 = r2.a;
            if (r113 == null) goto L119;
            if (r110 == null) goto L113;
            if (r111 == null) goto L113;
            TextView r114 = r2.j;
            if (r114 == null) goto L81;
            r114.setText(r113.getResources().getString(2131917963, new Object[]{IESUIUtils.getDisplayCountChinese(r110.intValue())}));
        L81:
            if (Intrinsics.areEqual(r112, Boolean.TRUE) == false) goto L119;
            if (r20 != null) goto L86;
        L87:
            if (r20 != null) goto L90;
        L92:
            if (r20 == null) goto L119;
            if (r20.intValue() != 2) goto L119;
            b51.b r22 = b51.b.c0;
            r22.getClass();
            if (((Boolean) b51.b.t.getValue(r22, b51.b.a[18])).booleanValue() == false) goto L101;
            TextView r23 = r2.j;
            if (r23 == null) goto L104;
            r23.setText(r113.getResources().getString(2131917967, new Object[]{IESUIUtils.getDisplayCountChinese(r110.intValue()), IESUIUtils.getDisplayCountChinese(r111.longValue())}));
        L104:
            ImageView r24 = r2.i;
            if (r24 == null) goto L119;
            r24.setVisibility(8);
            goto L119
        L101:
            TextView r25 = r2.j;
            if (r25 == null) goto L104;
            r25.setText(r113.getResources().getString(2131917962, new Object[]{IESUIUtils.getDisplayCountChinese(r110.intValue())}));
            goto L104
        L90:
            if (r20.intValue() != 105) goto L92;
        L107:
            TextView r26 = r2.j;
            if (r26 == null) goto L110;
            r26.setText(r113.getResources().getString(2131917962, new Object[]{IESUIUtils.getDisplayCountChinese(r110.intValue())}));
        L110:
            ImageView r27 = r2.i;
            if (r27 == null) goto L119;
            r27.setVisibility(8);
            goto L119
        L86:
            if (r20.intValue() == 1) goto L107;
        L113:
            TextView r28 = r2.j;
            if (r28 == null) goto L116;
            r28.setText("");
        L116:
            ImageView r29 = r2.i;
            if (r29 == null) goto L119;
            r29.setVisibility(0);
        L119:
            r2.q = r0.e;
            r2.r = r0.f;
            r2.s = r0.g;
            r2.t = r0.h;
        L121:
            if ((!Intrinsics.areEqual(r0.i, r2.u)) == false) goto L123;
        L130:
            List<t5> r30 = r0.i;
            String r32 = r0.s;
            AnchorLinkInfoView r33 = r2.k;
            if (r33 == null) goto L135;
            VHeadView r34 = r33.getIvAnchorAvatar1();
            if (r34 == null) goto L135;
            int r35 = 8;
            r34.setVisibility(8);
        L136:
            AnchorLinkInfoView r36 = r2.k;
            if (r36 == null) goto L141;
            VHeadView r37 = r36.getIvAnchorAvatar2();
            if (r37 == null) goto L141;
            r37.setVisibility(r35);
        L141:
            AnchorLinkInfoView r38 = r2.k;
            if (r38 == null) goto L146;
            VHeadView r39 = r38.getIvAnchorAvatar3();
            if (r39 == null) goto L146;
            r39.setVisibility(r35);
        L146:
            if (r30 != null) goto L148;
        L186:
            AnchorLinkInfoView r40 = r2.k;
            if (r40 == null) goto L189;
            r40.setVisibility(8);
        L189:
            r2.u = r0.i;
            r2.v = r0.j;
            r2.w = r0.k;
            r2.x = r0.l;
            r2.E = r0.s;
        L191:
            if ((!Intrinsics.areEqual(r0.r, r2.D)) == false) goto L193;
        L202:
            Runnable r42 = r0.r;
            Map<String, Long> r43 = r0.m;
            String r44 = r0.n;
            Boolean r45 = r0.o;
            Boolean r46 = r0.p;
            Boolean r47 = r0.q;
            s21.a r115 = new s21.a(r2, r42);
            Button r48 = r2.l;
            if (r48 == null) goto L206;
            r48.setOnClickListener(r115);
        L206:
            if (TextUtils.isEmpty(r44) == true) goto L217;
            Button r49 = r2.l;
            if (r49 == null) goto L210;
            r49.setText(r44);
        L210:
            Button r50 = r2.l;
            if (r50 == null) goto L213;
            r50.setBackgroundResource(2131106784);
        L213:
            Button r52 = r2.l;
            if (r52 == null) goto L265;
            r52.setTextColor(ColorProtector.parseColor("#80161823"));
        L265:
            r2.D = r0.r;
            r2.y = r0.m;
            r2.z = r0.n;
            r2.A = r0.o;
            r2.B = r0.p;
            r2.C = r0.q;
            return;
        L217:
            if (r43 != null) goto L219;
        L240:
            Boolean r53 = Boolean.TRUE;
            if (Intrinsics.areEqual(r46, r53) == false) goto L251;
            Button r54 = r2.l;
            if (r54 == null) goto L245;
            r54.setBackgroundResource(2131248802);
        L245:
            Button r55 = r2.l;
            if (r55 == null) goto L248;
            r55.setText(2131914739);
        L248:
            Button r56 = r2.l;
            if (r56 == null) goto L265;
            r56.setTextColor(s1.h(2131106807));
            goto L265
        L251:
            Button r57 = r2.l;
            if (r57 == null) goto L255;
            r57.setBackgroundResource(2131249467);
        L255:
            if (Intrinsics.areEqual(r47, r53) == false) goto L259;
            Button r58 = r2.l;
            if (r58 == null) goto L262;
            r58.setText(2131914774);
        L262:
            Button r59 = r2.l;
            if (r59 == null) goto L265;
            r59.setTextColor(ColorProtector.parseColor("#ffffff"));
            goto L265
        L259:
            Button r60 = r2.l;
            if (r60 == null) goto L262;
            r60.setText(2131914776);
            goto L262
        L219:
            if (r43.containsKey(String.valueOf(7)) != true) goto L240;
            if (Intrinsics.areEqual(r45, Boolean.TRUE) == false) goto L231;
            Button r62 = r2.l;
            if (r62 == null) goto L225;
            r62.setBackgroundResource(2131248802);
        L225:
            Button r63 = r2.l;
            if (r63 == null) goto L228;
            r63.setText(2131914740);
        L228:
            Button r64 = r2.l;
            if (r64 == null) goto L265;
            r64.setTextColor(s1.h(2131106807));
            goto L265
        L231:
            Button r65 = r2.l;
            if (r65 == null) goto L234;
            r65.setBackgroundResource(2131249467);
        L234:
            Button r66 = r2.l;
            if (r66 == null) goto L237;
            r66.setText(2131914726);
        L237:
            Button r67 = r2.l;
            if (r67 == null) goto L265;
            r67.setTextColor(ColorProtector.parseColor("#ffffff"));
            goto L265
        L193:
            if ((!Intrinsics.areEqual(r0.m, r2.y)) == true) goto L202;
            if ((!Intrinsics.areEqual(r0.n, r2.z)) == true) goto L202;
            if ((!Intrinsics.areEqual(r0.o, r2.A)) == true) goto L202;
            if ((!Intrinsics.areEqual(r0.p, r2.B)) == true) goto L202;
            if ((!Intrinsics.areEqual(r0.q, r2.C)) == true) goto L202;
            return;
        L148:
            if (r30.size() == 0) goto L186;
            if (r30.size() < 1) goto L177;
            AnchorLinkInfoView r68 = r2.k;
            if (r68 == null) goto L155;
            r68.setVisibility(0);
        L155:
            AnchorLinkInfoView r69 = r2.k;
            if (r69 == null) goto L160;
            VHeadView r70 = r69.getIvAnchorAvatar1();
            if (r70 == null) goto L160;
            r70.setVisibility(0);
        L160:
            AnchorLinkInfoView r72 = r2.k;
            if (r72 == null) goto L163;
            VHeadView r73 = r72.getIvAnchorAvatar1();
        L164:
            k r74 = ((t5) ListProtector.get(r30, 0)).getAvatarThumb();
            AnchorLinkInfoView r116 = r2.k;
            if (r116 == null) goto L169;
            VHeadView r117 = r116.getIvAnchorAvatar1();
            if (r117 == null) goto L169;
            int r118 = r117.getWidth();
        L170:
            AnchorLinkInfoView r119 = r2.k;
            if (r119 == null) goto L175;
            VHeadView r120 = r119.getIvAnchorAvatar1();
            if (r120 == null) goto L175;
            int r121 = r120.getHeight();
        L176:
            a1.x(r73, r74, r118, r121, 2131250965);
            String r75 = c.a(((t5) ListProtector.get(r30, 0)).getNickName(), 10);
        L179:
            if (r30.size() <= 1) goto L181;
            com.bytedance.live.kmp.util.c r76 = com.bytedance.live.kmp.util.c.a;
            int r77 = w11.a.a;
            r8 = com.bytedance.live.kmp.util.c.a(2131914769, new Object[]{Integer.valueOf(r30.size())});
        L181:
            SpannableStringBuilder r78 = new SpannableStringBuilder(s1.C(2131914768, new Object[]{r75}) + r8 + r32);
            r78.setSpan(new ForegroundColorSpan(ColorProtector.parseColor("#161823")), 2, r75.length() + 2, 33);
            AnchorLinkInfoView r79 = r2.k;
            if (r79 == null) goto L189;
            TextView r80 = r79.getTvAnchorLinkInfo();
            if (r80 == null) goto L189;
            r80.setText(r78);
        L175:
            r121 = 0;
        L169:
            r118 = 0;
            goto L170
        L163:
            r73 = null;
            goto L164
        L177:
            r75 = "";
        L135:
            r35 = 8;
            goto L136
        L123:
            if ((!Intrinsics.areEqual(r0.j, r2.v)) == true) goto L130;
            if ((!Intrinsics.areEqual(r0.k, r2.w)) == true) goto L130;
            if ((!Intrinsics.areEqual(r0.l, r2.x)) == true) goto L130;
            if ((!Intrinsics.areEqual(r0.s, r2.E)) == false) goto L191;
        L66:
            if ((!Intrinsics.areEqual(r0.f, r2.r)) == true) goto L71;
            if ((!Intrinsics.areEqual(r0.g, r2.s)) == true) goto L71;
            if ((!Intrinsics.areEqual(r0.h, r2.t)) == false) goto L121;
        }
    }

    @Override // t21.a
    public final h.a a() {
        Context r1 = this.a;
        Intrinsics.checkNotNull(r1);
        return new h.a(r1);
    }

    @Override // t21.a
    public final void init() {
        View r0 = this.H.inflate(2131566225, this.I, false);
        this.b = r0;
        Button r1 = null;
        if (r0 == null) goto L5;
        Context r2 = r0.getContext();
    L6:
        this.a = r2;
        View r3 = this.b;
        if (r3 == null) goto L9;
        VHeadView r4 = (VHeadView) r3.findViewById(2131376019);
    L10:
        this.c = r4;
        View r5 = this.b;
        if (r5 == null) goto L13;
        VHeadView r6 = (VHeadView) r5.findViewById(2131376272);
    L14:
        this.d = r6;
        View r7 = this.b;
        if (r7 == null) goto L17;
        TextView r8 = (TextView) r7.findViewById(2131390993);
    L18:
        this.e = r8;
        View r9 = this.b;
        if (r9 == null) goto L21;
        PkTagsContainerView r10 = (PkTagsContainerView) r9.findViewById(2131388160);
    L22:
        this.f = r10;
        View r12 = this.b;
        if (r12 == null) goto L25;
        ViewGroup r13 = (ViewGroup) r12.findViewById(2131379130);
    L26:
        this.g = r13;
        View r14 = this.b;
        if (r14 == null) goto L29;
        ImageView r15 = (ImageView) r14.findViewById(2131376380);
    L29:
        View r16 = this.b;
        if (r16 == null) goto L32;
        TextView r17 = (TextView) r16.findViewById(2131390517);
    L32:
        View r18 = this.b;
        if (r18 == null) goto L35;
        ViewGroup r19 = (ViewGroup) r18.findViewById(2131363373);
    L36:
        this.h = r19;
        View r20 = this.b;
        if (r20 == null) goto L39;
        ImageView r22 = (ImageView) r20.findViewById(2131376010);
    L40:
        this.i = r22;
        View r23 = this.b;
        if (r23 == null) goto L43;
        TextView r24 = (TextView) r23.findViewById(2131390172);
    L44:
        this.j = r24;
        View r25 = this.b;
        if (r25 == null) goto L47;
        AnchorLinkInfoView r26 = (AnchorLinkInfoView) r25.findViewById(2131392543);
    L48:
        this.k = r26;
        View r27 = this.b;
        if (r27 == null) goto L51;
        r1 = (Button) r27.findViewById(2131364601);
    L51:
        this.l = r1;
        ViewGroup r28 = this.h;
        if (r28 == null) goto L54;
        r28.setVisibility(0);
    L54:
        PkTagsContainerView r29 = this.f;
        if (r29 == null) goto L57;
        r29.setVisibility(0);
    L57:
        ViewGroup r30 = this.g;
        if (r30 == null) goto L61;
        r30.setVisibility(8);
        return;
    L61:
        return;
    L47:
        r26 = null;
        goto L48
    L43:
        r24 = null;
        goto L44
    L39:
        r22 = null;
        goto L40
    L35:
        r19 = null;
        goto L36
    L25:
        r13 = null;
        goto L26
    L21:
        r10 = null;
        goto L22
    L17:
        r8 = null;
        goto L18
    L13:
        r6 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    @Override // t21.a
    public final View getView() {
        return this.b;
    }

    @Override // t21.a
    public final void b(MutableLiveData r2) {
        Intrinsics.checkNotNullParameter(r2, "uiStateLiveData");
        Intrinsics.checkNotNull(r2);
        x.e(r2, this.G);
    }

    public b(LayoutInflater r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        Intrinsics.checkNotNullParameter(r3, "parent");
        this.H = r2;
        this.I = r3;
        this.G = new a(this);
    }
}
