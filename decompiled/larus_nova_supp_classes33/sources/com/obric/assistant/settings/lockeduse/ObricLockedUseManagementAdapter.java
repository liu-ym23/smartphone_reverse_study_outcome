package com.obric.assistant.settings.lockeduse;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.text.OTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004\u001c\u001d\u001e\u001fB5\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0011H\u0016J\u0018\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0017J\u001c\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u001a2\u0006\u0010\u001b\u001a\u00020\tH\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/assistant/settings/lockeduse/ObricLockedUseManagementAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/obric/assistant/settings/lockeduse/ObricLockedUseRow;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onSwitchChanged", "Lkotlin/Function1;", "", "onItemSwitchChanged", "Lkotlin/Function2;", "", "", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "lastDisabledToastTime", "", "", "getItemViewType", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "itemIndex", "Lkotlin/Pair;", "id", "Companion", "SectionTitleViewHolder", "HintViewHolder", "CardViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricLockedUseManagementAdapter extends ListAdapter<l, RecyclerView.ViewHolder> {
    public static final ObricLockedUseManagementAdapter$Companion$diff$1 d = null;
    public final Function1<Boolean, Boolean> a;
    public final Function2<String, Boolean, Unit> b;
    public final Map<String, Long> c;

    public final class a extends RecyclerView.ViewHolder {
        public final OCardListItem a;
        public final /* synthetic */ ObricLockedUseManagementAdapter b;

        public final void T3(CompoundButton.OnCheckedChangeListener r3) {
            OSwitch r0 = this.a.getEndSwitch();
            if (r0 == null) goto L5;
            r0.setOnCheckedChangeListener(null);
        L5:
            if (r0 == null) goto L7;
            r0.setChecked(false);
        L7:
            if (r0 == null) goto L9;
            r0.setOnCheckedChangeListener(r3);
        L9:
            OCardListItem r4 = this.a;
            final ObricLockedUseManagementAdapter r1 = this.b;
            r4.post(new g(this, r1));
        }

        public a(ObricLockedUseManagementAdapter r2, OCardListItem r3) {
            Intrinsics.checkNotNullParameter(r3, "item");
            this.b = r2;
            super(r3);
            this.a = r3;
        }
    }

    public static final class b {
    }

    public static final class c extends RecyclerView.ViewHolder {
        public final OTextView a;

        public c(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.a = r2.findViewById(2131374378);
        }
    }

    public static final class d extends RecyclerView.ViewHolder {
        public final OTextView a;

        public d(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.a = r2.findViewById(2131381239);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.obric.assistant.settings.lockeduse.ObricLockedUseManagementAdapter$Companion$diff$1] */
    static {
        d = new ObricLockedUseManagementAdapter$Companion$diff$1();
    }

    public final int getItemViewType(int r2) {
        l r3 = (l) getItem(r2);
        if ((r3 instanceof l.d) == false) goto L6;
        return 1;
    L6:
        if ((r3 instanceof l.c) == false) goto L9;
        return 2;
    L9:
        if ((r3 instanceof l.b) == false) goto L12;
        return 3;
    L12:
        if ((r3 instanceof l.a) == false) goto L16;
        return 4;
    L16:
        throw new NoWhenBranchMatchedException();
    }

    public ObricLockedUseManagementAdapter(h r2, i r3) {
        Intrinsics.checkNotNullParameter(r2, "onSwitchChanged");
        Intrinsics.checkNotNullParameter(r3, "onItemSwitchChanged");
        super(d);
        this.a = r2;
        this.b = r3;
        this.c = new LinkedHashMap();
    }

    /* JADX WARN: Type inference failed for: r1v9, types: [com.obric.assistant.settings.lockeduse.a] */
    public final void onBindViewHolder(RecyclerView.ViewHolder r11, int r12) {
        Intrinsics.checkNotNullParameter(r11, "holder");
        l r13 = (l) getItem(r12);
        int r3 = 1;
        c r5 = null;
        d r6 = null;
        if ((r13 instanceof l.d) == false) goto L36;
        if ((r11 instanceof a) == false) goto L7;
        final a r14 = (a) r11;
    L8:
        if (r14 == null) goto L119;
        final l.d r15 = (l.d) r13;
        Intrinsics.checkNotNullParameter(r15, "row");
        r14.a.setCardType(0);
        r14.a.p(false);
        r14.a.setAlpha(1.0f);
        r14.a.setEnabled(true);
        OCardListItem r0 = r14.a;
        r0.setTitle(r0.getContext().getString(r15.a));
        r14.a.s(true);
        OCardListItem r1 = r14.a;
        r1.setSubTitle(r1.getContext().getString(r15.b));
        r14.a.q(true);
        r14.a.getSubTitleView().setMaxLines(5);
        if (r15.d == false) goto L12;
        r14.a.setDefaultCustomEndView(1);
    L13:
        r14.a.m(true);
        r14.a.r(false);
        OCardListItem.h(r14.a, 0);
        OSwitch r2 = r14.a.getEndSwitch();
        final ?? r4 = new com.obric.assistant.settings.lockeduse.a(r15, r14);
        if (r15.d == true) goto L27;
        View r7 = r14.a.getCustomEndView();
        if ((r7 instanceof ViewGroup) == false) goto L18;
        ViewGroup r8 = (ViewGroup) r7;
    L19:
        if (r8 == null) goto L26;
        OSwitch r9 = r8.findViewById(2131369124);
        if (r9 == null) goto L23;
        r9.setOnCheckedChangeListener(null);
        r9.setEnabled(false);
        r9.setChecked(r15.c);
    L23:
        View r16 = r8.findViewById(2131369125);
        if (r16 == null) goto L26;
        r16.setOnClickListener(new f(r14, r4));
    L26:
        r14.a.getTitleView().setAlpha(0.3f);
        r14.a.getSubTitleView().setAlpha(0.3f);
        r14.a.setOnContentClickListener(null);
        return;
    L18:
        r8 = null;
        goto L19
    L27:
        if (r2 == null) goto L29;
        r2.setOnCheckedChangeListener(null);
    L29:
        if (r2 == null) goto L31;
        r2.setChecked(r15.c);
    L31:
        r14.a.getTitleView().setAlpha(1.0f);
        r14.a.getSubTitleView().setAlpha(1.0f);
        final Ref.ObjectRef r17 = new Ref.ObjectRef();
        final ObricLockedUseManagementAdapter r10 = r14.b;
        CompoundButton.OnCheckedChangeListener r18 = new com.obric.assistant.settings.lockeduse.b(r10, r17);
        r17.element = r18;
        if (r2 == null) goto L34;
        r2.setOnCheckedChangeListener(r18);
    L34:
        r14.a.setOnContentClickListener(null);
        return;
    L12:
        r14.a.setCustomEndView(2131561650);
        goto L13
    L119:
        return;
    L7:
        r14 = null;
        goto L8
    L36:
        if ((r13 instanceof l.b) == false) goto L96;
        if ((r11 instanceof a) == false) goto L40;
        final a r19 = (a) r11;
    L41:
        if (r19 == null) goto L122;
        final l.b r110 = (l.b) r13;
        String r20 = r110.a;
        List r21 = getCurrentList();
        ArrayList r22 = new ArrayList();
        Iterator r23 = r21.iterator();
    L44:
        if (r23.hasNext() == false) goto L48;
        Object r24 = r23.next();
        if ((r24 instanceof l.b) == false) goto L44;
        r22.add(r24);
        goto L44
    L48:
        Iterator r25 = r22.iterator();
        int r26 = 0;
    L50:
        if (r25.hasNext() == false) goto L55;
        if (Intrinsics.areEqual(((l.b) r25.next()).a, r20) == true) goto L56;
        r26 = r26 + 1;
    L56:
        Integer r27 = Integer.valueOf(r26);
        if (r27.intValue() < 0) goto L59;
        boolean r28 = true;
    L60:
        if (r28 == true) goto L63;
        r27 = null;
    L63:
        if (r27 == null) goto L65;
        int r29 = r27.intValue();
    L66:
        Pair r30 = TuplesKt.to(Integer.valueOf(r29), Integer.valueOf(r22.size()));
        Intrinsics.checkNotNullParameter(r110, "row");
        Intrinsics.checkNotNullParameter(r30, "idxAndCount");
        r19.a.setCardType(0);
        r19.a.p(false);
        OCardListItem r31 = r19.a;
        r31.setTitle(r31.getContext().getString(r110.b));
        r19.a.s(true);
        Integer r32 = r110.c;
        if (r32 == null) goto L69;
        String r33 = r19.a.getContext().getString(r32.intValue());
    L70:
        if (r33 != null) goto L72;
        r33 = "";
    L72:
        r19.a.setSubTitle(r33);
        OCardListItem r34 = r19.a;
        if (r33.length() <= 0) goto L75;
        boolean r35 = true;
    L76:
        r34.q(r35);
        r19.a.getSubTitleView().setMaxLines(5);
        r19.a.setDefaultCustomEndView(1);
        r19.a.m(true);
        r19.a.r(false);
        final Ref.ObjectRef r36 = new Ref.ObjectRef();
        final ObricLockedUseManagementAdapter r37 = r19.b;
        r36.element = new com.obric.assistant.settings.lockeduse.c(r19, r110, r36, r37);
        OSwitch r38 = r19.a.getEndSwitch();
        if (r38 == null) goto L79;
        r38.setOnCheckedChangeListener(null);
    L79:
        OSwitch r39 = r19.a.getEndSwitch();
        if (r39 == null) goto L82;
        r39.setChecked(r110.d);
    L82:
        OSwitch r111 = r19.a.getEndSwitch();
        if (r111 == null) goto L85;
        r111.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) r36.element);
    L85:
        int r112 = ((Number) r30.component1()).intValue();
        int r40 = ((Number) r30.component2()).intValue();
        OCardListItem r41 = r19.a;
        if (r40 != 1) goto L88;
        r3 = 0;
    L94:
        OCardListItem.h(r41, r3);
        r19.a.setOnContentClickListener(null);
        r19.a.getTitleView().requestLayout();
        r19.a.getSubTitleView().requestLayout();
        r19.a.getTitleContainer().requestLayout();
        r19.a.requestLayout();
        return;
    L88:
        if (r112 == 0) goto L94;
        if (r112 != (r40 - 1)) goto L93;
        r3 = 3;
        goto L94
    L93:
        r3 = 2;
        goto L94
    L75:
        r35 = false;
        goto L76
    L69:
        r33 = null;
        goto L70
    L65:
        r29 = 0;
        goto L66
    L59:
        r28 = false;
        goto L60
    L55:
        r26 = -1;
        goto L56
    L122:
        return;
    L40:
        r19 = null;
        goto L41
    L96:
        if ((r13 instanceof l.c) == false) goto L103;
        if ((r11 instanceof d) == false) goto L100;
        r6 = (d) r11;
    L100:
        if (r6 == null) goto L124;
        l.c r113 = (l.c) r13;
        Intrinsics.checkNotNullParameter(r113, "row");
        r6.a.setText(r113.a);
        return;
    L124:
        return;
    L103:
        if ((r13 instanceof l.a) == false) goto L111;
        if ((r11 instanceof c) == false) goto L107;
        r5 = (c) r11;
    L107:
        if (r5 == null) goto L126;
        l.a r114 = (l.a) r13;
        Intrinsics.checkNotNullParameter(r114, "row");
        r5.a.setText(r114.a);
        return;
    L126:
        return;
    L111:
        throw new NoWhenBranchMatchedException();
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "parent");
        LayoutInflater r0 = LayoutInflater.from(r6.getContext());
        if (r7 != 1) goto L5;
        OCardListItem r8 = r0.inflate(2131561647, r6, false);
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.obric.oui.lisitem.OCardListItem");
        RecyclerView.ViewHolder r9 = new a(this, r8);
    L16:
        return r9;
    L5:
        if (r7 != 2) goto L7;
        r9 = new d(r0.inflate(2131561642, r6, false));
        goto L16
    L7:
        if (r7 != 3) goto L9;
        OCardListItem r10 = r0.inflate(2131561647, r6, false);
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.obric.oui.lisitem.OCardListItem");
        r9 = new a(this, r10);
        goto L16
    L9:
        if (r7 == 4) goto L11;
        final View r11 = new View(r6.getContext());
        return new AnonymousClass1(r11);
    L11:
        r9 = new c(r0.inflate(2131561641, r6, false));
        goto L16
    }
}
