package s21;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
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
public final class e implements t21.a {
    public Runnable A;
    public String B;
    public long C;
    public final a D;
    public final LayoutInflater E;
    public final ViewGroup F;
    public Context a;
    public View b;
    public VHeadView c;
    public VHeadView d;
    public TextView e;
    public PkTagsContainerView f;
    public ViewGroup g;
    public TextView h;
    public TextView i;
    public TextView j;
    public Button k;
    public k l;
    public String m;
    public Integer n;
    public List<? extends IBattleRivalTag> o;
    public Integer p;
    public Integer q;
    public Long r;
    public List<? extends t5> s;
    public Boolean t;
    public Boolean u;
    public Boolean v;
    public Map<String, Long> w;
    public String x;
    public Boolean y;
    public Boolean z;

    public static final class a<T> implements Observer {
        public final /* synthetic */ e a;

        public a(e r1) {
            this.a = r1;
        }

        public final void onChanged(Object r15) {
            r21.a r16 = (r21.a) r15;
            if (r16 == null) goto L213;
            e r0 = this.a;
            r0.getClass();
            if ((!Intrinsics.areEqual(r16.a, r0.l)) == false) goto L13;
            k r1 = r16.a;
            VHeadView r4 = r0.c;
            if (r4 == null) goto L12;
            if (r1 != null) goto L11;
            r4.setImageResource(0);
            goto L12
        L11:
            a1.x(r4, r1, r4.getWidth(), r4.getHeight(), 2131250965);
        L12:
            r0.l = r16.a;
        L13:
            String r5 = "";
            if ((!Intrinsics.areEqual(r16.b, r0.m)) == false) goto L23;
            String r2 = r16.b;
            TextView r6 = r0.e;
            if (r6 == null) goto L21;
            if (r2 != null) goto L20;
            r2 = "";
        L20:
            r6.setText(r2);
        L21:
            r0.m = r16.b;
        L23:
            if ((!Intrinsics.areEqual(r16.c, r0.n)) == false) goto L50;
            Integer r3 = r16.c;
            if (r3 != null) goto L28;
        L35:
            if (r3 != null) goto L38;
        L45:
            VHeadView r7 = r0.d;
            if (r7 == null) goto L48;
            r7.setVisibility(8);
        L48:
            r0.n = r16.c;
            goto L50
        L38:
            if (r3.intValue() != 2) goto L45;
            VHeadView r8 = r0.d;
            if (r8 == null) goto L42;
            r8.setImageResource(2131250687);
        L42:
            VHeadView r9 = r0.d;
            if (r9 == null) goto L48;
            r9.setVisibility(0);
            goto L48
        L28:
            if (r3.intValue() != 1) goto L35;
            VHeadView r10 = r0.d;
            if (r10 == null) goto L32;
            r10.setImageResource(2131250688);
        L32:
            VHeadView r12 = r0.d;
            if (r12 == null) goto L48;
            r12.setVisibility(0);
        L50:
            if ((!Intrinsics.areEqual(r16.d, r0.o)) == false) goto L64;
            List<IBattleRivalTag> r13 = r16.d;
            if (r13 == null) goto L59;
            PkTagsContainerView r14 = r0.f;
            if (r14 == null) goto L56;
            r14.setOldTag(true);
        L56:
            PkTagsContainerView r17 = r0.f;
            if (r17 == null) goto L62;
            PkTagsContainerView.f(r17, r13, false, null, 9, "", 32);
        L62:
            r0.o = r16.d;
            goto L64
        L59:
            PkTagsContainerView r18 = r0.f;
            if (r18 == null) goto L62;
            r18.c = 0;
        L64:
            if ((!Intrinsics.areEqual(r16.e, r0.p)) == false) goto L66;
        L69:
            Integer r19 = r16.e;
            Integer r20 = r16.f;
            Context r22 = r0.a;
            if (r22 == null) goto L92;
            if (r20 != null) goto L77;
            TextView r23 = r0.h;
            if (r23 == null) goto L92;
            r23.setText("");
            goto L92
        L77:
            if (r19 != null) goto L80;
        L81:
            if (r19 != null) goto L84;
        L86:
            TextView r24 = r0.h;
            if (r24 == null) goto L92;
            r24.setText(r22.getResources().getString(2131917962, new Object[]{IESUIUtils.getDisplayCountChinese(r20.intValue())}));
            goto L92
        L84:
            if (r19.intValue() != 105) goto L86;
        L89:
            TextView r25 = r0.h;
            if (r25 == null) goto L92;
            r25.setText(r22.getResources().getString(2131917962, new Object[]{IESUIUtils.getDisplayCountChinese(r20.intValue())}));
            goto L92
        L80:
            if (r19.intValue() == 1) goto L89;
        L92:
            r0.p = r16.e;
            r0.q = r16.f;
            r0.r = r16.g;
        L94:
            if ((!Intrinsics.areEqual(r16.i, r0.s)) == false) goto L96;
        L103:
            List<t5> r26 = r16.i;
            String r27 = r16.s;
            if ((s1.y() - UtilityKotlinExtentionsKt.i(180)) <= UtilityKotlinExtentionsKt.i(230)) goto L106;
            boolean r28 = true;
        L107:
            List<t5> r29 = r26;
            if (r29 != null) goto L110;
        L113:
            boolean r30 = true;
        L114:
            if (r30 == false) goto L122;
            TextView r32 = r0.i;
            if (r32 == null) goto L118;
            r32.setVisibility(8);
        L118:
            TextView r33 = r0.j;
            if (r33 == null) goto L142;
            r33.setVisibility(8);
        L142:
            r0.s = r16.i;
            r0.t = r16.j;
            r0.u = r16.k;
            r0.v = r16.l;
            r0.B = r16.s;
        L144:
            if ((!Intrinsics.areEqual(r16.r, r0.A)) == false) goto L146;
        L153:
            Runnable r34 = r16.r;
            Map<String, Long> r35 = r16.m;
            String r36 = r16.n;
            Boolean r37 = r16.o;
            Boolean r38 = r16.p;
            d r39 = new d(r0, r34);
            Button r40 = r0.k;
            if (r40 == null) goto L157;
            r40.setOnClickListener(r39);
        L157:
            if (TextUtils.isEmpty(r36) == true) goto L168;
            Button r42 = r0.k;
            if (r42 == null) goto L161;
            r42.setText(r36);
        L161:
            Button r43 = r0.k;
            if (r43 == null) goto L164;
            r43.setBackgroundResource(2131106784);
        L164:
            Button r44 = r0.k;
            if (r44 == null) goto L211;
            r44.setTextColor(ColorProtector.parseColor("#80161823"));
        L211:
            r0.A = r16.r;
            r0.w = r16.m;
            r0.x = r16.n;
            r0.y = r16.o;
            r0.z = r16.p;
            return;
        L168:
            if (r35 == null) goto L192;
            if (r35.containsKey(String.valueOf(7)) != true) goto L192;
            if (Intrinsics.areEqual(r37, Boolean.TRUE) == false) goto L182;
            Button r45 = r0.k;
            if (r45 == null) goto L176;
            r45.setBackgroundResource(2131248802);
        L176:
            Button r46 = r0.k;
            if (r46 == null) goto L179;
            r46.setText(2131914740);
        L179:
            Button r47 = r0.k;
            if (r47 == null) goto L211;
            r47.setTextColor(s1.h(2131106807));
            goto L211
        L182:
            Button r48 = r0.k;
            if (r48 == null) goto L185;
            r48.setBackgroundResource(2131249467);
        L185:
            Button r49 = r0.k;
            if (r49 == null) goto L188;
            r49.setText(2131914727);
        L188:
            Button r50 = r0.k;
            if (r50 == null) goto L211;
            r50.setTextColor(ColorProtector.parseColor("#ffffff"));
        L192:
            if (Intrinsics.areEqual(r38, Boolean.TRUE) == false) goto L202;
            Button r52 = r0.k;
            if (r52 == null) goto L196;
            r52.setBackgroundResource(2131248802);
        L196:
            Button r53 = r0.k;
            if (r53 == null) goto L199;
            r53.setText(2131914739);
        L199:
            Button r54 = r0.k;
            if (r54 == null) goto L211;
            r54.setTextColor(s1.h(2131106807));
            goto L211
        L202:
            Button r55 = r0.k;
            if (r55 == null) goto L205;
            r55.setBackgroundResource(2131249467);
        L205:
            Button r56 = r0.k;
            if (r56 == null) goto L208;
            r56.setText(2131914777);
        L208:
            Button r57 = r0.k;
            if (r57 == null) goto L211;
            r57.setTextColor(ColorProtector.parseColor("#ffffff"));
            goto L211
        L146:
            if ((!Intrinsics.areEqual(r16.m, r0.w)) == true) goto L153;
            if ((!Intrinsics.areEqual(r16.n, r0.x)) == true) goto L153;
            if ((!Intrinsics.areEqual(r16.o, r0.y)) == true) goto L153;
            if ((!Intrinsics.areEqual(r16.p, r0.z)) == true) goto L153;
            return;
        L122:
            if (r26.size() < 1) goto L135;
            if (r28 == false) goto L125;
            int r58 = 10;
        L126:
            TextView r59 = r0.i;
            if (r59 == null) goto L129;
            r59.setVisibility(0);
        L129:
            TextView r60 = r0.j;
            if (r60 == null) goto L132;
            r60.setVisibility(0);
        L132:
            String r62 = ((t5) ListProtector.get(r26, 0)).getNickName();
            if (r62.length() <= r58) goto L137;
            r62 = r62.substring(0, r58 - 1) + "...";
        L137:
            if (r26.size() <= 1) goto L139;
            com.bytedance.live.kmp.util.c r63 = com.bytedance.live.kmp.util.c.a;
            int r64 = w11.a.a;
            r5 = com.bytedance.live.kmp.util.c.a(2131914769, new Object[]{Integer.valueOf(r26.size())});
        L139:
            SpannableStringBuilder r65 = new SpannableStringBuilder(s1.C(2131914768, new Object[]{r62}) + r5 + r27);
            r65.setSpan(new ForegroundColorSpan(ColorProtector.parseColor("#161823")), 2, r62.length() + 2, 33);
            TextView r66 = r0.j;
            if (r66 == null) goto L142;
            r66.setText(r65);
            goto L142
        L125:
            r58 = 6;
            goto L126
        L135:
            r62 = "";
            goto L137
        L110:
            if (r29.isEmpty() == true) goto L113;
            r30 = false;
            goto L114
        L106:
            r28 = false;
            goto L107
        L96:
            if ((!Intrinsics.areEqual(r16.j, r0.t)) == true) goto L103;
            if ((!Intrinsics.areEqual(r16.k, r0.u)) == true) goto L103;
            if ((!Intrinsics.areEqual(r16.l, r0.v)) == true) goto L103;
            if ((!Intrinsics.areEqual(r16.s, r0.B)) == false) goto L144;
        L66:
            if ((!Intrinsics.areEqual(r16.f, r0.q)) == true) goto L69;
            if ((!Intrinsics.areEqual(r16.g, r0.r)) == false) goto L94;
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
        View r0 = this.E.inflate(2131566231, this.F, false);
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
        ViewGroup r13 = (ViewGroup) r12.findViewById(2131363373);
    L26:
        this.g = r13;
        View r14 = this.b;
        if (r14 == null) goto L29;
        TextView r15 = (TextView) r14.findViewById(2131390172);
    L30:
        this.h = r15;
        View r16 = this.b;
        if (r16 == null) goto L33;
        TextView r17 = (TextView) r16.findViewById(2131392544);
    L34:
        this.i = r17;
        View r18 = this.b;
        if (r18 == null) goto L37;
        TextView r19 = (TextView) r18.findViewById(2131392543);
    L38:
        this.j = r19;
        View r20 = this.b;
        if (r20 == null) goto L41;
        r1 = (Button) r20.findViewById(2131364601);
    L41:
        this.k = r1;
        ViewGroup r22 = this.g;
        if (r22 == null) goto L44;
        r22.setVisibility(0);
    L44:
        PkTagsContainerView r23 = this.f;
        if (r23 == null) goto L48;
        r23.setVisibility(0);
        return;
    L48:
        return;
    L37:
        r19 = null;
        goto L38
    L33:
        r17 = null;
        goto L34
    L29:
        r15 = null;
        goto L30
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
        a r0 = this.D;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r2);
        x.e(r2, r0);
        return;
    }

    public e(LayoutInflater r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        Intrinsics.checkNotNullParameter(r3, "parent");
        this.E = r2;
        this.F = r3;
        this.D = new a(this);
    }
}
