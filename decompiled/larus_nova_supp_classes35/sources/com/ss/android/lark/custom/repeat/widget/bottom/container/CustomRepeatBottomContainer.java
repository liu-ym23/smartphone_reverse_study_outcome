package com.ss.android.lark.custom.repeat.widget.bottom.container;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.custom.repeat.CustomRepeatParams$DayOfWeek;
import com.ss.android.lark.custom.repeat.entity.CalendarDate;
import com.ss.android.lark.custom.repeat.entity.RepeatMode;
import com.ss.android.lark.custom.repeat.widget.childview.ControlChildViewClickableLayout;
import com.ss.android.lark.custom.repeat.widget.wheelview.WheelView;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import mab.f;
import mab.g;
import oab.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class CustomRepeatBottomContainer extends FrameLayout {
    public static final /* synthetic */ int s = 0;
    public boolean a;
    public g b;
    public mab.d c;
    public f d;
    public f e;
    public String f;
    public String g;
    public e h;
    public String[] i;
    public String[] j;
    public int k;
    public int l;
    public rab.d m;

    @BindView(7439)
    ControlChildViewClickableLayout mChooseRepeatWeeksViewGroup;

    @BindView(7468)
    GridView mCustomRepeatMonthly;

    @BindView(7470)
    GridView mCustomRepeatWeekly;

    @BindView(7743)
    View mMonthlyTabContainer;

    @BindView(8092)
    WheelView mRepeatWeekNoWheelView;

    @BindView(8093)
    WheelView mRepeatWeeksWheelView;

    @BindView(7948)
    TextView mSwitchDate;

    @BindView(7949)
    TextView mSwitchWeek;
    public CustomRepeatParams$DayOfWeek n;
    public CalendarDate o;
    public nab.a p;
    public final a q;
    public final b r;

    public class a implements d {
        public final /* synthetic */ CustomRepeatBottomContainer a;

        public a(CustomRepeatBottomContainer r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.custom.repeat.widget.bottom.container.CustomRepeatBottomContainer.d
        public final String b(String r4) {
            int r0 = CastIntegerProtector.parseInt(r4) - 1;     // Catch: Exception -> L8
            if (r0 < 0) goto L11;
            String[] r1 = this.a.i;     // Catch: Exception -> L8
            if (r0 >= r1.length) goto L12;
            return r1[r0];
        L12:
            return r4;
        L11:
            return r4;
        L13:
            return r4;
        }

        @Override // com.ss.android.lark.custom.repeat.widget.bottom.container.CustomRepeatBottomContainer.d
        public final void a(boolean r1, int r2) {
            if (r1 == false) goto L4;
            this.a.h.d(r2 + 1);
            return;
        L4:
            this.a.h.g(r2 + 1);
        }
    }

    public class b implements d {
        public final /* synthetic */ CustomRepeatBottomContainer a;

        @Override // com.ss.android.lark.custom.repeat.widget.bottom.container.CustomRepeatBottomContainer.d
        public final String b(String r1) {
            return r1;
        }

        public b(CustomRepeatBottomContainer r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.custom.repeat.widget.bottom.container.CustomRepeatBottomContainer.d
        public final void a(boolean r4, int r5) {
            int r0 = c.a[this.a.n.ordinal()];
            if (r0 != 1) goto L5;
            if (r5 < 0) goto L30;
            if (r5 >= 7) goto L31;
            if (r4 == false) goto L20;
            this.a.h.c((r5 + 1) % 7);
            return;
        L20:
            this.a.h.h((r5 + 1) % 7);
            return;
        L31:
            return;
        L30:
            return;
        L5:
            if (r0 == 2) goto L11;
            if (r5 < 0) goto L22;
            if (r5 >= 7) goto L23;
            if (r4 == false) goto L10;
            this.a.h.c(r5 % 7);
            return;
        L10:
            this.a.h.h(r5 % 7);
            return;
        L23:
            return;
        L22:
            return;
        L11:
            if (r5 < 0) goto L26;
            if (r5 >= 7) goto L27;
            if (r4 == false) goto L15;
            this.a.h.c((r5 + 6) % 7);
            return;
        L15:
            this.a.h.h((r5 + 6) % 7);
            return;
        L27:
            return;
        }
    }

    public static /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CustomRepeatParams$DayOfWeek.values().length];
            a = r0;
            r0[CustomRepeatParams$DayOfWeek.MONDAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            a[CustomRepeatParams$DayOfWeek.SATURDAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public interface d {
        void a(boolean r1, int r2);

        String b(String r1);
    }

    public final void b() {
        e r0 = this.h;
        if (r0 == null) goto L6;
        r0.b(this.f);
        this.h.a(this.g);
        this.h.e(this.f + this.g);
        return;
    }

    public final void c() {
        g r0 = this.b;
        if (r0 == null) goto L9;
        int r2 = 0;
    L5:
        boolean[] r3 = r0.a;
        if (r2 >= r3.length) goto L8;
        r3[r2] = false;
        r2 = r2 + 1;
        goto L5
    L8:
        r0.notifyDataSetChanged();
    L9:
        mab.d r1 = this.c;
        if (r1 == null) goto L16;
        int r4 = 0;
    L12:
        boolean[] r5 = r1.a;
        if (r4 >= r5.length) goto L15;
        r5[r4] = false;
        r4 = r4 + 1;
        goto L12
    L15:
        r1.notifyDataSetChanged();
    L16:
        WheelView r6 = this.mRepeatWeekNoWheelView;
        if (r6 == null) goto L19;
        r6.setCurrentItem(this.k);
    L19:
        WheelView r7 = this.mRepeatWeeksWheelView;
        if (r7 == null) goto L22;
        r7.setCurrentItem(this.l);
    L22:
        this.g = this.e.b(this.l);
        this.f = this.d.b(this.k);
    }

    public final void e() {
        this.mMonthlyTabContainer.setVisibility(0);
        this.mCustomRepeatWeekly.setVisibility(8);
        if (this.a == false) goto L8;
        e r0 = this.h;
        if (r0 == null) goto L7;
        r0.i();
    L7:
        a(this.c, this.q);
        return;
    L8:
        b();
        e r1 = this.h;
        if (r1 == null) goto L11;
        r1.f();
    L11:
        a(this.c, this.q);
    }

    public final void f() {
        this.mCustomRepeatWeekly.setVisibility(0);
        this.mMonthlyTabContainer.setVisibility(8);
        a(this.b, this.r);
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this, this);
        g r0 = new g(getContext(), (int) getResources().getDimension(2131166004), this.n);
        this.b = r0;
        this.mCustomRepeatWeekly.setAdapter(r0);
        this.mCustomRepeatWeekly.setOnItemClickListener(new com.ss.android.lark.custom.repeat.widget.bottom.container.a(this));
        this.i = getContext().getResources().getStringArray(2130903051);
        this.j = getContext().getResources().getStringArray(2130903138);
        mab.d r1 = new mab.d(getContext(), (int) getResources().getDimension(2131166032));
        this.c = r1;
        this.mCustomRepeatMonthly.setAdapter(r1);
        this.mCustomRepeatMonthly.setOnItemClickListener(new com.ss.android.lark.custom.repeat.widget.bottom.container.b(this));
        this.mSwitchDate.setOnClickListener(new com.ss.android.lark.custom.repeat.widget.bottom.container.c(this));
        this.mSwitchWeek.setOnClickListener(new com.ss.android.lark.custom.repeat.widget.bottom.container.d(this));
        this.mRepeatWeekNoWheelView.setLineSpacingMultiplier(3.0f);
        this.mRepeatWeekNoWheelView.setTextColorCenter(getContext().getResources().getColor(2131106607));
        this.mRepeatWeekNoWheelView.setTextColorOut(getContext().getResources().getColor(2131106610));
        f r2 = new f(Arrays.asList(UIHelper.getStringArray(2130903134)));
        this.d = r2;
        this.mRepeatWeekNoWheelView.setAdapter(r2);
        this.mRepeatWeekNoWheelView.setOnItemSelectedListener(new rab.c(this));
        this.mRepeatWeeksWheelView.setLineSpacingMultiplier(3.0f);
        this.mRepeatWeeksWheelView.setTextColorCenter(getContext().getResources().getColor(2131106607));
        this.mRepeatWeeksWheelView.setTextColorOut(getContext().getResources().getColor(2131106610));
        f r3 = new f(Arrays.asList(UIHelper.getStringArray(2130903138)));
        this.e = r3;
        this.mRepeatWeeksWheelView.setAdapter(r3);
        this.mRepeatWeeksWheelView.setOnItemSelectedListener(new rab.a(this));
        this.mChooseRepeatWeeksViewGroup.setChildViewClickable(!this.p.d);
        this.mChooseRepeatWeeksViewGroup.setOnTouchListener(new rab.b(this));
    }

    public CustomRepeatBottomContainer(Context r1) {
        super(r1);
        this.a = true;
        this.k = 1;
        this.l = 1;
        this.n = CustomRepeatParams$DayOfWeek.SUNDAY;
        this.p = new nab.a();
        this.q = new a(this);
        this.r = new b(this);
    }

    public void setCustomRepeatData(nab.a r3) {
        this.p = r3;
        this.c.f = Boolean.valueOf(r3.d);
        this.b.i = Boolean.valueOf(r3.c);
        this.b.j = Boolean.valueOf(r3.e);
        this.mChooseRepeatWeeksViewGroup.setChildViewClickable(!this.p.d);
    }

    public void setFirstDayOfWeek(CustomRepeatParams$DayOfWeek r2) {
        this.n = r2;
        g r0 = this.b;
        r0.h = r2;
        r0.c();
        r0.d();
    }

    public void setOnCheckedListener(e r1) {
        this.h = r1;
    }

    public CustomRepeatBottomContainer(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = true;
        this.k = 1;
        this.l = 1;
        this.n = CustomRepeatParams$DayOfWeek.SUNDAY;
        this.p = new nab.a();
        this.q = new a(this);
        this.r = new b(this);
    }

    public final void a(mab.c r6, d r7) {
        if (this.h != null) goto L5;
        return;
    L5:
        int r0 = r6.getCount();
        ArrayList r1 = new ArrayList();
        int r3 = 0;
    L6:
        if (r3 >= r0) goto L12;
        if (r6.b(r3) == false) goto L10;
        r1.add(Integer.valueOf(r3));
        r7.a(true, r3);
    L11:
        r3 = r3 + 1;
        goto L6
    L10:
        r7.a(false, r3);
        goto L11
    L12:
        Collections.sort(r1);
        StringBuilder r2 = new StringBuilder();
        Iterator r4 = r1.iterator();
    L14:
        if (r4.hasNext() == false) goto L19;
        int r5 = ((Integer) r4.next()).intValue();
        if (r7 != null) goto L17;
        r2.append(r6.a(r5));
        r2.append(" ");
        goto L14
    L17:
        r2.append(r7.b(r6.a(r5)));
        r2.append(" ");
        goto L14
    L19:
        this.h.e(r2.toString());
    }

    public final void d(CalendarDate r8, RepeatMode r9) {
        this.o = r8;
        boolean r1 = false;
        if (this.b == null) goto L40;
        if (r9 != null) goto L7;
    L11:
        boolean r3 = false;
    L12:
        int r4 = r8.getWeeklyDayIndex(this.n);
        g r5 = this.b;
        r5.c = r4;
        if (this.p.e == true) goto L15;
        if (r3 == false) goto L15;
    L17:
        if (this.b == null) goto L40;
        if (r9 == null) goto L40;
        if (r9.getRepeatType() != 8) goto L40;
        if (CollectionUtils.isNotEmpty(r9.getCustomerByWeekList()) == false) goto L40;
        Iterator<Integer> r0 = r9.getCustomerByWeekList().iterator();
    L26:
        if (r0.hasNext() == false) goto L40;
        int r6 = r0.next().intValue();
        int r7 = c.a[this.n.ordinal()];
        if (r7 != 1) goto L30;
        r6 = (r6 + 6) % 7;
    L34:
        if (r6 != r4) goto L38;
        if (this.b.b(r4) == true) goto L26;
    L38:
        this.b.e(r6);
        goto L26
    L30:
        if (r7 != 2) goto L34;
        r6 = (r6 + 1) % 7;
    L15:
        r5.e(r4);
        goto L17
    L7:
        if (r9.getRepeatType() != 8) goto L11;
        if (CollectionUtils.isNotEmpty(r9.getCustomerByWeekList()) == false) goto L11;
        r3 = true;
    L40:
        if (this.c == null) goto L72;
        if (r9 != null) goto L44;
    L48:
        int r10 = r8.getMonthDay() - 1;
        mab.d r11 = this.c;
        r11.c = r10;
        if (this.p.e == true) goto L51;
        if (r1 == false) goto L51;
    L53:
        if (this.p.d == true) goto L72;
        if (this.c == null) goto L72;
        if (r9 == null) goto L72;
        if (r9.getRepeatType() != 9) goto L72;
        if (CollectionUtils.isNotEmpty(r9.getCustomerByMonthDayList()) == false) goto L72;
        Iterator<Integer> r12 = r9.getCustomerByMonthDayList().iterator();
    L64:
        if (r12.hasNext() == false) goto L72;
        int r2 = r12.next().intValue() - 1;
        if (r2 != r10) goto L70;
        if (this.c.b(r10) == true) goto L64;
    L70:
        this.c.c(r2);
    L51:
        r11.c(r10);
        goto L53
    L44:
        if (r9.getRepeatType() != 9) goto L48;
        if (CollectionUtils.isNotEmpty(r9.getCustomerByMonthDayList()) == false) goto L48;
        r1 = true;
    L72:
        if (this.mRepeatWeekNoWheelView == null) goto L75;
        int r13 = ((int) Math.ceil(r8.getMonthDay() / 7.0f)) - 1;
        this.k = r13;
        this.mRepeatWeekNoWheelView.setCurrentItem(r13);
    L75:
        if (this.mRepeatWeeksWheelView == null) goto L77;
        int r14 = r8.getWeekDay() - 1;
        this.l = r14;
        this.mRepeatWeeksWheelView.setCurrentItem(r14);
    L77:
        this.g = this.e.b(this.l);
        this.f = this.d.b(this.k);
    }
}
