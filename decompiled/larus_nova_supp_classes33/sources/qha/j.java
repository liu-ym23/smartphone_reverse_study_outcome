package qha;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.actionbar.model.g1;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.instruction.core.model.ActionBarDisplayType;
import com.larus.bmhome.instruction.core.model.ActionBarExecutionType;
import com.larus.bmhome.view.actionbar.BaseActionBarHolder;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.GradientTextView;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;
import com.larus.im.bean.bot.BotModel;
import com.larus.utils.e1;
import com.larus.utils.y0;
import com.obric.assistant.actionbar.service.ObricActionBarTrackServiceExtDelegate;
import com.obric.assistant.common.spi.IObricUIService;
import com.obric.assistant.impl.databinding.ObricItemCustomActionbarNormalHolderBinding;
import com.obric.assistant.impl.databinding.ObricItemPhoneOperationActionbarHolderBinding;
import com.obric.assistant.impl.databinding.ObricItemPhoneOperationActionbarSkillHolderBinding;
import com.obric.assistant.t1;
import com.obric.assistant.view.actionbar.custom.ObricActionBarSegmentCell;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class j extends e {
    public final t1a.b d;
    public final Context e;
    public final String f;

    public static final class a {
    }

    static {
    }

    @Override // qha.e
    public final String k() {
        return "obric_quick_instruction";
    }

    @Override // qha.e
    public final long p() {
        return -626;
    }

    @Override // qha.e
    public final int q() {
        return 2131911924;
    }

    @Override // qha.e
    public final int r() {
        return 2131244357;
    }

    @Override // qha.e
    public final int m() {
        return ActionBarExecutionType.OBRIC_ACTION.getValue();
    }

    public final z0 u() {
        m r0 = new m(this.d, getContext());
        return t(this, -626, "obric_quick_instruction", getContext().getString(2131911924), 2131244357, r0.o(), null, 32);
    }

    @Override // qha.e
    public final List a() {
        if (com.obric.assistant.task.skill.f.d() == true) goto L6;
        com.obric.assistant.task.skill.f.e = SetsKt.emptySet();
    L6:
        return CollectionsKt.emptyList();
    }

    @Override // qha.e
    public Context getContext() {
        return this.e;
    }

    @Override // qha.e
    public final String l() {
        return this.f;
    }

    public static Map s(String r3) {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("KEY_FILE_OR_WEB_ADDRESS", ""), TuplesKt.to("item_type", r3)});
    }

    public static boolean v(z0 r3) {
        if (com.obric.assistant.special_input.j.b() == false) goto L5;
        String r0 = "obric_omni_all_skills";
    L7:
        if (Intrinsics.areEqual(r3.b, "obric_quick_instruction") == false) goto L9;
    L12:
        return true;
    L9:
        if (Intrinsics.areEqual(r3.b, r0) == true) goto L12;
        return false;
    L5:
        r0 = "obric_all_instruction";
        goto L7
    }

    @Override // qha.e
    public final boolean h(z0 r3) {
        Intrinsics.checkNotNullParameter(r3, "item");
        if (Intrinsics.areEqual(r3.b, "obric_quick_instruction") == false) goto L5;
    L12:
        return true;
    L5:
        if (Intrinsics.areEqual(r3.b, "obric_all_instruction") == true) goto L12;
        if (Intrinsics.areEqual(r3.b, "obric_omni_all_skills") == true) goto L12;
        int r0 = com.obric.assistant.task.skill.d.a;
        if (com.obric.assistant.task.skill.d.a(r3.b) == true) goto L12;
        return false;
    }

    public j(t1a.b r3, Context r4) {
        Intrinsics.checkNotNullParameter(r3, "vContext");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter("", "address");
        super(r3, r4, "");
        this.d = r3;
        this.e = r4;
        this.f = "";
    }

    @Override // qha.e
    public final List b(BotModel r22, wc9.e r23) {
        Intrinsics.checkNotNullParameter(r22, "bot");
        Intrinsics.checkNotNullParameter(r23, "conversation");
        if (com.obric.assistant.task.skill.f.d() == true) goto L6;
        com.obric.assistant.task.skill.f.e = SetsKt.emptySet();
        return CollectionsKt.emptyList();
    L6:
        boolean r11 = true;
        if (com.obric.assistant.special_input.j.b() == true) goto L17;
        com.obric.assistant.task.skill.f.e = SetsKt.emptySet();
        List r0 = CollectionsKt.listOf(new z0[]{u(), t(this, -628, "obric_all_instruction", getContext().getString(2131911925), 2131244370, null, null, 48)});
        if (com.obric.assistant.task.skill.f.f() == false) goto L93;
        ObricActionBarTrackServiceExtDelegate r1 = ObricActionBarTrackServiceExtDelegate.b;
        ArrayList r3 = new ArrayList();
        Iterator r2 = r0.iterator();
    L12:
        if (r2.hasNext() == false) goto L16;
        Object r4 = r2.next();
        if (v((z0) r4) == false) goto L12;
        r3.add(r4);
        goto L12
    L16:
        r1.j(r3, 0);
    L93:
        return r0;
    L17:
        paa.c r5 = this.d.getAbility(paa.c.class);
        Set r13 = null;
        if (r5 == null) goto L20;
        List r6 = r5.bJ();
    L21:
        if (r6 != null) goto L23;
        r6 = CollectionsKt.emptyList();
    L23:
        List r7 = r6;
        Iterator r8 = r7.iterator();
    L25:
        if (r8.hasNext() == false) goto L29;
        Object r9 = r8.next();
        if (Intrinsics.areEqual(((paa.e) r9).a, "all_skills") == false) goto L25;
    L30:
        paa.e r10 = (paa.e) r9;
        if (r10 != null) goto L33;
        r10 = new paa.e("all_skills", getContext().getString(2131912611), null, 60);
    L33:
        paa.e r15 = r10;
        ArrayList r12 = new ArrayList();
        Iterator r14 = r7.iterator();
    L35:
        if (r14.hasNext() == false) goto L39;
        Object r16 = r14.next();
        if (Intrinsics.areEqual(((paa.e) r16).a, "all_skills") == true) goto L35;
        r12.add(r16);
        goto L35
    L39:
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator r18 = r12.iterator();
    L41:
        if (r18.hasNext() == false) goto L68;
        paa.e r19 = (paa.e) r18.next();
        String r20 = r19.a;
        Intrinsics.checkNotNullParameter(r20, "skillId");
        long r21 = (-10000) - (((long) r20.hashCode()) & 2147483647L);
        int r24 = com.obric.assistant.task.skill.d.a;
        String r25 = r19.a;
        Intrinsics.checkNotNullParameter(r25, "skillId");
        String r26 = "obric_phone_operation_skill_" + r25;
        String r27 = r19.b;
        Map r28 = MapsKt.toMutableMap(s("skill"));
        r28.put("skill_id", r19.a);
        r28.put("skill_name", r19.b);
        paa.c r29 = this.d.getAbility(paa.c.class);
        if (r29 == null) goto L47;
        List r30 = r29.AM();
        if (r30 == null) goto L47;
        Set r31 = CollectionsKt.toSet(r30);
    L48:
        if (r31 != null) goto L50;
        r31 = SetsKt.emptySet();
    L50:
        r28.put("selected", String.valueOf(r31.contains(r19.a)));
        String r32 = r19.c;
        if (r32 == null) goto L58;
        boolean r33 = StringsKt.isBlank(r32) ^ r11;
        Object r34 = r32;
        if (r33 == true) goto L56;
        r34 = r13;
    L56:
        if (r34 == null) goto L58;
        String r35 = (String) r28.put("cover_url", r34);
    L58:
        Long r36 = r19.d;
        if (r36 == null) goto L61;
        String r37 = (String) r28.put("last_used_at", String.valueOf(r36.longValue()));
    L61:
        Long r38 = r19.e;
        if (r38 == null) goto L64;
        String r39 = (String) r28.put("created_at", String.valueOf(r38.longValue()));
    L64:
        Long r40 = r19.f;
        if (r40 == null) goto L67;
        r28.put("last_updated_at", String.valueOf(r40.longValue()));
    L67:
        Unit r41 = Unit.INSTANCE;
        ArrayList r110 = r17;
        r110.add(t(this, r21, r26, r27, null, null, r28, 24));
        r17 = r110;
        r11 = true;
        r13 = null;
    L47:
        r31 = r13;
        goto L48
    L68:
        ArrayList r111 = r17;
        CopyOnWriteArraySet<com.obric.assistant.task.skill.f.a> r42 = com.obric.assistant.task.skill.f.a;
        ArrayList r43 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator r44 = r111.iterator();
    L70:
        if (r44.hasNext() == false) goto L72;
        r43.add(String.valueOf(((z0) r44.next()).a));
        goto L70
    L72:
        Intrinsics.checkNotNullParameter(r43, "itemIds");
        com.obric.assistant.task.skill.f.e = CollectionsKt.toSet(r43);
        List r112 = CollectionsKt.createListBuilder(r111.size() + 2);
        r112.add(u());
        String r45 = r15.b;
        Map r46 = MapsKt.toMutableMap(s("all_skills"));
        if (com.obric.assistant.special_input.j.b() == false) goto L80;
        t1 r47 = t1.a;
        if (r47.c0() == false) goto L80;
        if (r47.G0() == true) goto L80;
        if (System.currentTimeMillis() >= r47.Z0()) goto L80;
        boolean r113 = true;
    L84:
        r46.put("show_new_tag", String.valueOf(r113));
        Unit r48 = Unit.INSTANCE;
        r112.add(t(this, -627, "obric_omni_all_skills", r45, 2131242814, null, r46, 16));
        r112.addAll(r111);
        r0 = CollectionsKt.build(r112);
        if (com.obric.assistant.task.skill.f.f() == false) goto L93;
        ObricActionBarTrackServiceExtDelegate r49 = ObricActionBarTrackServiceExtDelegate.b;
        ArrayList r50 = new ArrayList();
        Iterator r51 = r0.iterator();
    L88:
        if (r51.hasNext() == false) goto L92;
        Object r52 = r51.next();
        if (v((z0) r52) == false) goto L88;
        r50.add(r52);
        goto L88
    L92:
        r49.j(r50, 0);
    L80:
        r113 = false;
        goto L84
    L29:
        r9 = null;
        goto L30
    L20:
        r6 = null;
        goto L21
    }

    @Override // qha.e
    public final boolean d(z0 r3, z0 r4) {
        Intrinsics.checkNotNullParameter(r3, "old");
        Intrinsics.checkNotNullParameter(r4, "next");
        if (Intrinsics.areEqual(r3.e, r4.e) == true) goto L5;
    L17:
        return false;
    L5:
        if (Intrinsics.areEqual(r3.b, r4.b) == false) goto L17;
        if (Intrinsics.areEqual(r3.a, r4.a) == false) goto L17;
        if (Intrinsics.areEqual(r3.c, r4.c) == false) goto L17;
        if (Intrinsics.areEqual(r3.d, r4.d) == false) goto L17;
        if (Intrinsics.areEqual(r3.q, r4.q) == false) goto L17;
        if (Intrinsics.areEqual(r3.H, r4.H) == false) goto L17;
        return true;
    }

    @Override // qha.e
    public final void e(BaseActionBarHolder r18, final z0 r19, final int r20) {
        Intrinsics.checkNotNullParameter(r18, "cell");
        Intrinsics.checkNotNullParameter(r19, "item");
        String r5 = null;
        if ((r18 instanceof i) == false) goto L5;
        i r0 = (i) r18;
    L6:
        if (r0 == null) goto L104;
        Intrinsics.checkNotNullParameter(r19, "item");
        Map r4 = r19.H;
        if (r4 == null) goto L10;
        String r6 = (String) r4.get("item_type");
    L11:
        String r12 = "";
        if (Intrinsics.areEqual(r6, "all_skills") == false) goto L14;
    L37:
        final l r7 = r0.g;
        if (r7 != null) goto L50;
        RoundConstraintLayout r8 = r0.b.inflate(2131564026, r0.a.b, false);
        RoundConstraintLayout r9 = r8;
        int r13 = 2131386820;
        AppCompatImageView r14 = ViewBindings.findChildViewById(r8, 2131386820);
        if (r14 == null) goto L103;
        r13 = 2131386821;
        GradientTextView r15 = ViewBindings.findChildViewById(r8, 2131386821);
        if (r15 == null) goto L103;
        TextView r16 = (TextView) ViewBindings.findChildViewById(r8, 2131386822);
        if (r16 == null) goto L101;
        ObricItemPhoneOperationActionbarSkillHolderBinding r10 = new ObricItemPhoneOperationActionbarSkillHolderBinding(r9, r14, r15, r16);
        IObricUIService r11 = (IObricUIService) ServiceManager.get().getService(IObricUIService.class);
        if (r11 == null) goto L49;
        r11.na(new TextView[]{r15, r16});
    L49:
        l r17 = new l(r10, r0.c, r0.d);
        r0.h = r10;
        r0.g = r17;
        r7 = r17;
        goto L50
    L101:
        r13 = 2131386822;
    L103:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r13)));
    L50:
        ObricItemPhoneOperationActionbarSkillHolderBinding r21 = r0.h;
        if (r21 == null) goto L53;
        RoundConstraintLayout r22 = r21.a;
    L54:
        r0.U3(r22);
        Intrinsics.checkNotNullParameter(r19, "item");
        e1.d(r7.a.a, new k(r7, r19, r20));
        Map r1 = r19.H;
        if (r1 == null) goto L57;
        String r2 = (String) r1.get("item_type");
    L59:
        if (Intrinsics.areEqual(r2, "all_skills") == false) goto L76;
        RoundConstraintLayout r3 = r7.a.a;
        r3.setPaddingRelative(r3.getContext().getResources().getDimensionPixelSize(v19.c.b(2130971163, r7.a.a.getContext(), 2131166696)), r7.a.a.getPaddingTop(), r7.a.a.getContext().getResources().getDimensionPixelSize(v19.c.b(2130971546, r7.a.a.getContext(), 2131167462)), r7.a.a.getPaddingBottom());
        r7.a.b.setVisibility(0);
        r7.U3(true);
        GradientTextView r23 = r7.a.c;
        String r24 = r19.e;
        if (r24 == null) goto L64;
        r12 = r24;
    L64:
        r23.setText(r12);
        r7.a.c.getPaint().setShader(null);
        GradientTextView r25 = r7.a.c;
        Context r26 = ((RecyclerView.ViewHolder) r7).itemView.getContext();
        if (r7.c == false) goto L67;
        int r27 = 2131106521;
    L68:
        r25.setTextColor(ContextCompat.getColor(r26, r27));
        r7.a.c.invalidate();
        Map r28 = r19.H;
        if (r28 == null) goto L72;
        r5 = (String) r28.get("show_new_tag");
    L72:
        if (Boolean.parseBoolean(r5) == false) goto L74;
        r7.a.d.setVisibility(0);
        r7.a.d.setText(((RecyclerView.ViewHolder) r7).itemView.getContext().getString(2131911901));
    L75:
        com.larus.bmhome.view.actionbar.custom.t1 r29 = r7.b;
        ObricItemPhoneOperationActionbarSkillHolderBinding r30 = r7.a;
        r29.d(r30.a, r30.b, r30.c, r19);
        return;
    L74:
        r7.a.d.setVisibility(8);
        goto L75
    L67:
        r27 = v19.c.b(2130972079, ((RecyclerView.ViewHolder) r7).itemView.getContext(), 2131103136);
        goto L68
    L76:
        RoundConstraintLayout r31 = r7.a.a;
        r31.setPaddingRelative(r31.getContext().getResources().getDimensionPixelSize(v19.c.b(2130971139, r7.a.a.getContext(), 2131166648)), r7.a.a.getPaddingTop(), r7.a.a.getContext().getResources().getDimensionPixelSize(v19.c.b(2130971163, r7.a.a.getContext(), 2131166696)), r7.a.a.getPaddingBottom());
        r7.a.b.setVisibility(8);
        r7.U3(false);
        GradientTextView r32 = r7.a.c;
        StringBuilder r33 = new StringBuilder("@ ");
        String r34 = r19.e;
        if (r34 != null) goto L80;
        r34 = "";
    L80:
        if (r34.length() != 0) goto L82;
        boolean r35 = true;
    L83:
        if (r35 == true) goto L100;
        int r36 = 0;
        int r37 = 0;
    L87:
        if (r36 >= r34.length()) goto L97;
        int r110 = r34.codePointAt(r36);
        if (r110 > 127) goto L91;
        int r111 = 1;
    L92:
        r37 = r37 + r111;
        if (r37 > 20) goto L97;
        r36 = r36 + Character.charCount(r110);
        goto L87
    L91:
        r111 = 2;
    L97:
        if (r36 != r34.length()) goto L99;
        r12 = r34;
        goto L100
    L99:
        r12 = r34.substring(0, r36);
    L100:
        r33.append(r12);
        r32.setText(r33.toString());
        r7.a.c.getPaint().setShader(null);
        r7.a.d.setVisibility(8);
        com.larus.bmhome.view.actionbar.custom.t1 r38 = r7.b;
        ObricItemPhoneOperationActionbarSkillHolderBinding r39 = r7.a;
        r38.d(r39.a, r39.b, r39.c, r19);
        r7.a.c.invalidate();
        return;
    L82:
        r35 = false;
        goto L83
    L57:
        r2 = null;
        goto L59
    L53:
        r22 = null;
        goto L54
    L14:
        if (Intrinsics.areEqual(r6, "skill") == true) goto L37;
        ObricActionBarSegmentCell r40 = r0.e;
        if (r40 != null) goto L23;
        ObricItemCustomActionbarNormalHolderBinding r41 = ObricItemCustomActionbarNormalHolderBinding.a(r0.b, r0.a.b);
        IObricUIService r42 = (IObricUIService) ServiceManager.get().getService(IObricUIService.class);
        if (r42 == null) goto L22;
        r42.na(new TextView[]{r41.d, r41.e});
    L22:
        ObricActionBarSegmentCell r43 = new ObricActionBarSegmentCell(r41, r0.c, r0.d, null);
        r0.f = r41;
        r0.e = r43;
        r40 = r43;
    L23:
        ObricItemCustomActionbarNormalHolderBinding r44 = r0.f;
        if (r44 == null) goto L26;
        RoundConstraintLayout r45 = r44.a;
    L27:
        r0.U3(r45);
        String r46 = r19.e;
        if (r46 != null) goto L30;
        r46 = "";
    L30:
        g1 r47 = r19.c;
        if (r47 == null) goto L33;
        r5 = r47.b;
    L33:
        if (r5 == null) goto L36;
        r12 = r5;
    L36:
        r40.U3(r46, r12, r19, r20);
        return;
    L26:
        r45 = null;
        goto L27
    L10:
        r6 = null;
        goto L11
    L104:
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Override // qha.e
    public final BaseActionBarHolder f(ViewGroup r4, com.larus.bmhome.view.actionbar.custom.t1 r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "defaultClickCallback");
        View r7 = LayoutInflater.from(r4.getContext()).inflate(2131564025, r4, false);
        if (r7 == null) goto L7;
        FrameLayout r8 = (FrameLayout) r7;
        return new i(new ObricItemPhoneOperationActionbarHolderBinding(r8, r8), r5, r6);
    L7:
        throw new NullPointerException("rootView");
    }

    public static z0 t(j r22, long r23, String r25, String r26, Integer r27, com.larus.bmhome.actionbar.model.r r28, Map r29, int r30) {
        g1 r1 = null;
        if ((r30 & 8) == 0) goto L5;
        Integer r0 = null;
    L7:
        if ((r30 & 16) == 0) goto L9;
        com.larus.bmhome.actionbar.model.r r14 = null;
    L11:
        if ((r30 & 32) == 0) goto L13;
        r22.getClass();
        Map r17 = s("quick_instruction");
    L14:
        r22.getClass();
        String r2 = "";
        if (r0 == null) goto L19;
        String r3 = y0.k(UriProtector.parse("res://" + AppHost.a.getApplication().getPackageName() + '/' + r0.intValue()));
        if (r3 != null) goto L20;
        r3 = "";
    L20:
        if (r3 == null) goto L23;
        r2 = r3;
    L23:
        int r10 = ActionBarDisplayType.NORMAL.getValue();
        int r11 = ActionBarExecutionType.OBRIC_ACTION.getValue();
        if (r0 == null) goto L26;
        r0.intValue();
        g1 r21 = new g1(null, r2, null, null, 29);
    L27:
        if (r0 == null) goto L30;
        r0.intValue();
        r1 = new g1(null, r2, null, null, 29);
    L30:
        return new z0(Long.valueOf(r23), r25, r21, r1, r26, Integer.valueOf(r10), Integer.valueOf(r11), null, null, null, r14, null, true, r17, null, 536805248, 13);
    L26:
        r21 = null;
        goto L27
    L19:
        r3 = null;
        goto L20
    L13:
        r17 = r29;
        goto L14
    L9:
        r14 = r28;
        goto L11
    L5:
        r0 = r27;
        goto L7
    }
}
