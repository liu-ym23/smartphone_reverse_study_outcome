package com.suite.lark.platform.component.widget_biz_setting.settingitem;

import android.app.Application;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.component.ui.button.LKUICheckBox;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.component.universe_design.udswitch.UDSwitch;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.widget.listener.OnSingleClickListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class SettingItemView extends ConstraintLayout {
    public TextView a;
    public TextView b;
    public RelativeLayout c;
    public RelativeLayout d;
    public View e;
    public View f;
    public String g;
    public String h;
    public String i;
    public int j;
    public Drawable k;
    public ColorStateList l;
    public boolean m;
    public boolean n;
    public int o;
    public int p;
    public boolean q;
    public boolean r;
    public Drawable s;
    public String t;
    public int u;
    public Drawable v;
    public f w;
    public f x;

    public static final enum ContainerType extends Enum<ContainerType> {
        public static final ContainerType CUSTOM = null;
        public static final ContainerType ICON_BTN = null;
        public static final ContainerType RADIO_BTN = null;
        public static final ContainerType SWITCH_BTN = null;
        public static final ContainerType TEXT_ICON_BTN = null;
        public static final ContainerType THROTTLE_CHECKBOX = null;
        public static final /* synthetic */ ContainerType[] a = null;
        final int type;

        static {
            ContainerType r0 = new ContainerType("ICON_BTN", 0, 0);
            ICON_BTN = r0;
            ContainerType r1 = new ContainerType("SWITCH_BTN", 1, 1);
            SWITCH_BTN = r1;
            ContainerType r3 = new ContainerType("RADIO_BTN", 2, 2);
            RADIO_BTN = r3;
            ContainerType r5 = new ContainerType("CUSTOM", 3, 3);
            CUSTOM = r5;
            ContainerType r7 = new ContainerType("TEXT_ICON_BTN", 4, 4);
            TEXT_ICON_BTN = r7;
            ContainerType r9 = new ContainerType("THROTTLE_CHECKBOX", 5, 5);
            THROTTLE_CHECKBOX = r9;
            a = new ContainerType[]{r0, r1, r3, r5, r7, r9};
        }

        public static ContainerType[] values() {
            return (ContainerType[]) a.clone();
        }

        public static ContainerType valueOf(String r1) {
            return (ContainerType) r27.a.a(ContainerType.class, r1);
        }

        public ContainerType(String r1, int r2, int r3) {
            super(r1, r2);
            this.type = r3;
        }
    }

    public static final enum Event extends Enum<Event> {
        public static final Event GetCheckBox = null;
        public static final Event GetRadioBtn = null;
        public static final Event GetSwitchBtn = null;
        public static final Event SetEnable = null;
        public static final Event SetText = null;
        public static final /* synthetic */ Event[] a = null;

        static {
            Event r0 = new Event("SetText", 0);
            SetText = r0;
            Event r1 = new Event("SetEnable", 1);
            SetEnable = r1;
            Event r3 = new Event("GetSwitchBtn", 2);
            GetSwitchBtn = r3;
            Event r5 = new Event("GetCheckBox", 3);
            GetCheckBox = r5;
            Event r7 = new Event("GetRadioBtn", 4);
            GetRadioBtn = r7;
            a = new Event[]{r0, r1, r3, r5, r7};
        }

        public static Event[] values() {
            return (Event[]) a.clone();
        }

        public static Event valueOf(String r1) {
            return (Event) r27.a.a(Event.class, r1);
        }

        public Event(String r1, int r2) {
            super(r1, r2);
        }
    }

    public class a extends OnSingleClickListener {
        public final /* synthetic */ UDSwitch a;

        public a(UDSwitch r1) {
            this.a = r1;
        }

        public final void onSingleClick(View r2) {
            UDSwitch r3 = this.a;
            r3.setChecked(!r3.isChecked());
        }
    }

    public class b extends OnSingleClickListener {
        public final /* synthetic */ UDCheckBox a;

        public b(UDCheckBox r1) {
            this.a = r1;
        }

        public final void onSingleClick(View r2) {
            UDCheckBox r3 = this.a;
            r3.setChecked(!r3.isChecked());
        }
    }

    public class c implements View.OnClickListener {
        public final /* synthetic */ LKUICheckBox a;

        public c(ThrottleCheckBox r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            LKUICheckBox r3 = this.a;
            r3.setChecked(!r3.isChecked());
        }
    }

    public static /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Event.values().length];
            a = r0;
            r0[Event.GetRadioBtn.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            a[Event.SetEnable.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            a[Event.SetText.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static class e extends Application {
        public e(Context r1) {
            attachBaseContext(r1);
        }
    }

    public interface f {
        Object a(Event r1, Object r2);
    }

    public static class g implements f {
        public final ImageView a;

        public g(ImageView r1) {
            this.a = r1;
        }

        @Override // com.suite.lark.platform.component.widget_biz_setting.settingitem.SettingItemView.f
        public final Object a(Event r2, Object r3) {
            if (r2 == Event.SetEnable) goto L5;
            return null;
        L5:
            if ((r3 instanceof Boolean) == false) goto L10;
            this.a.setEnabled(((Boolean) r3).booleanValue());
            return null;
        L10:
            return null;
        }
    }

    public static class h implements f {
        public final UDCheckBox a;

        public h(UDCheckBox r1) {
            this.a = r1;
        }

        @Override // com.suite.lark.platform.component.widget_biz_setting.settingitem.SettingItemView.f
        public final Object a(Event r2, Object r3) {
            int r4 = d.a[r2.ordinal()];
            if (r4 == 1) goto L13;
            if (r4 == 2) goto L8;
            return null;
        L8:
            if ((r3 instanceof Boolean) == false) goto L14;
            this.a.setEnabled(((Boolean) r3).booleanValue());
            return null;
        L14:
            return null;
        L13:
            return this.a;
        }
    }

    public static class i implements f {
        public final UDSwitch a;

        public i(UDSwitch r1) {
            this.a = r1;
        }

        @Override // com.suite.lark.platform.component.widget_biz_setting.settingitem.SettingItemView.f
        public final Object a(Event r2, Object r3) {
            if (r2 != Event.SetEnable) goto L8;
            if ((r3 instanceof Boolean) == false) goto L8;
            this.a.setEnabled(((Boolean) r3).booleanValue());
            return null;
        L8:
            if (r2 == Event.GetSwitchBtn) goto L10;
            return null;
        L10:
            return this.a;
        }
    }

    public static class j implements f {
        public final TextView a;
        public final ImageView b;

        public j(TextView r1, ImageView r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.suite.lark.platform.component.widget_biz_setting.settingitem.SettingItemView.f
        public final Object a(Event r2, Object r3) {
            int r4 = d.a[r2.ordinal()];
            if (r4 == 2) goto L11;
            if (r4 == 3) goto L8;
            return null;
        L8:
            if ((r3 instanceof String) == false) goto L15;
            this.a.setText((String) r3);
            return null;
        L15:
            return null;
        L11:
            if ((r3 instanceof Boolean) == false) goto L17;
            Boolean r5 = (Boolean) r3;
            this.a.setEnabled(r5.booleanValue());
            this.b.setEnabled(r5.booleanValue());
            return null;
        L17:
            return null;
        }
    }

    public static class k implements f {
        public final LKUICheckBox a;

        public k(ThrottleCheckBox r1) {
            this.a = r1;
        }

        @Override // com.suite.lark.platform.component.widget_biz_setting.settingitem.SettingItemView.f
        public final Object a(Event r2, Object r3) {
            if (r2 != Event.GetCheckBox) goto L7;
            return this.a;
        L7:
            if (r2 == Event.SetEnable) goto L9;
            return null;
        L9:
            if ((r3 instanceof Boolean) == false) goto L14;
            this.a.setEnabled(((Boolean) r3).booleanValue());
            return null;
        L14:
            return null;
        }
    }

    public LKUICheckBox getLeftCheckBox() {
        f r0 = this.w;
        if (r0 == null) goto L8;
        Object r1 = r0.a(Event.GetCheckBox, null);
        if ((r1 instanceof LKUICheckBox) == false) goto L8;
        return (LKUICheckBox) r1;
    L8:
        return null;
    }

    public UDCheckBox getLeftRadioButton() {
        f r0 = this.w;
        if (r0 == null) goto L8;
        Object r1 = r0.a(Event.GetRadioBtn, null);
        if ((r1 instanceof UDCheckBox) == false) goto L8;
        return (UDCheckBox) r1;
    L8:
        return null;
    }

    public UDSwitch getRightSwitch() {
        f r0 = this.x;
        if (r0 == null) goto L8;
        Object r1 = r0.a(Event.GetSwitchBtn, null);
        if ((r1 instanceof UDSwitch) == false) goto L8;
        return (UDSwitch) r1;
    L8:
        return null;
    }

    public SettingItemView(Context r2) {
        this(r2, null);
    }

    public void setDescription(String r2) {
        this.b.setText(r2);
        TextView r0 = this.b;
        if (TextUtils.isEmpty(r2) == false) goto L5;
        int r3 = 8;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 0;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setEnabled(boolean r4) {
        super/*android.view.ViewGroup*/.setEnabled(r4);
        TextView r0 = this.a;
        if (r0 == null) goto L5;
        r0.setEnabled(r4);
    L5:
        TextView r1 = this.b;
        if (r1 == null) goto L8;
        r1.setEnabled(r4);
    L8:
        f r2 = this.x;
        if (r2 == null) goto L11;
        r2.a(Event.SetEnable, Boolean.valueOf(r4));
    L11:
        f r3 = this.w;
        if (r3 == null) goto L15;
        r3.a(Event.SetEnable, Boolean.valueOf(r4));
        return;
    }

    public void setRightText(String r3) {
        f r0 = this.x;
        if (r0 == null) goto L6;
        r0.a(Event.SetText, r3);
        return;
    }

    public void setTitle(String r2) {
        this.a.setText(r2);
        TextView r0 = this.a;
        if (TextUtils.isEmpty(r2) == false) goto L5;
        int r3 = 8;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 0;
        goto L6
    }

    public SettingItemView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SettingItemView(Context r21, AttributeSet r22, int r23) {
        super(r21, r22, r23);
        this.q = true;
        this.r = false;
        int r5 = -1;
        int r8 = 8;
        if (r22 == null) goto L9;
        TypedArray r0 = r21.obtainStyledAttributes(r22, new int[]{2130969053, 2130969054, 2130969749, 2130972514, 2130972520, 2130972521, 2130972523, 2130972547, 2130972676, 2130973795, 2130973801, 2130973802, 2130973803, 2130973804, 2130974021, 2130974574, 2130974624, 2130974625});
        this.g = r0.getString(15);
        this.h = r0.getString(2);
        this.i = r0.getString(13);
        this.j = r0.getInteger(9, 0);
        this.k = r0.getDrawable(10);
        this.l = r0.getColorStateList(11);
        this.t = r0.getString(6);
        this.u = r0.getInteger(3, -1);
        this.v = r0.getDrawable(4);
        this.m = r0.getBoolean(17, false);
        this.o = r0.getDimensionPixelSize(16, 0);
        this.n = r0.getBoolean(1, false);
        this.p = r0.getDimensionPixelSize(0, 0);
        this.q = r0.getBoolean(7, this.q);
        this.r = r0.getBoolean(8, this.r);
        Drawable r10 = r0.getDrawable(14);
        this.s = r10;
        if (r10 != null) goto L7;
        this.s = y9c.d.e(r21, 2131238325);
    L7:
        r0.recycle();
    L9:
        if (isInEditMode() == false) goto L11;
        LarkContext.setApplication(new e(getContext().getApplicationContext()));
    L11:
        RelativeLayout r1 = new RelativeLayout(r21);
        this.d = r1;
        r1.setId(2131377756);
        ConstraintLayout.LayoutParams r2 = xbc.b.b(-2.0f, -2.0f, 16, 0, 0, 0);
        boolean r11 = this.r;
        if (r11 == false) goto L14;
        r2.topToTop = 2131386009;
    L15:
        if (r11 == true) goto L18;
        r5 = 0;
    L18:
        r2.bottomToBottom = r5;
        r2.startToStart = 0;
        r2.leftToLeft = 0;
        r2.goneLeftMargin = 0;
        addView(this.d, r2);
        TextView r3 = new TextView(r21);
        this.a = r3;
        r3.setId(2131386009);
        this.a.setTextSize(16);
        this.a.setTextColor(r21.getResources().getColorStateList(2131105831));
        TextView r4 = this.a;
        if (this.q == false) goto L21;
        int r6 = 2;
    L22:
        r4.setMaxLines(r6);
        setTitle(this.g);
        ConstraintLayout.LayoutParams r7 = xbc.b.b(0.0f, -2.0f, 16, 16, 5, 0);
        r7.goneBottomMargin = UIUtils.dp2px(r21, 16.0f);
        r7.goneEndMargin = UIUtils.dp2px(r21, 16.0f);
        r7.topToTop = 0;
        r7.bottomToTop = 2131385979;
        r7.startToEnd = 2131377756;
        r7.endToStart = 2131384568;
        r7.verticalChainStyle = 2;
        addView(this.a, r7);
        TextView r9 = new TextView(r21);
        this.b = r9;
        r9.setId(2131385979);
        this.b.setTextSize(14);
        this.b.setTextColor(y9c.d.c(r21, 2131106620));
        this.b.setMaxLines(2);
        this.b.setEllipsize(TextUtils.TruncateAt.END);
        setDescription(this.h);
        ConstraintLayout.LayoutParams r12 = xbc.b.b(0.0f, -2.0f, 0, 4, 0, 16);
        r12.topToBottom = 2131386009;
        r12.bottomToBottom = 0;
        r12.startToStart = 2131386009;
        r12.endToEnd = 2131386009;
        addView(this.b, r12);
        RelativeLayout r13 = new RelativeLayout(r21);
        this.c = r13;
        r13.setId(2131384568);
        ConstraintLayout.LayoutParams r14 = xbc.b.b(-2.0f, -2.0f, 0, 0, 16, 0);
        r14.topToTop = 0;
        r14.bottomToBottom = 0;
        r14.endToEnd = 0;
        addView(this.c, r14);
        View r15 = new View(r21);
        this.e = r15;
        r15.setId(2131389146);
        this.e.setBackgroundColor(UIUtils.getColor(r21, 2131103353));
        View r16 = this.e;
        if (this.m == false) goto L25;
        int r17 = 0;
    L26:
        r16.setVisibility(r17);
        ConstraintLayout.LayoutParams r18 = xbc.b.b(0.0f, 0.5f, this.o, 0, 0, 0);
        r18.topToTop = 0;
        r18.startToStart = 0;
        r18.endToEnd = 0;
        addView(this.e, r18);
        View r19 = new View(r21);
        this.f = r19;
        r19.setId(2131364451);
        this.f.setBackgroundColor(UIUtils.getColor(r21, 2131103353));
        View r20 = this.f;
        if (this.n == false) goto L29;
        r8 = 0;
    L29:
        r20.setVisibility(r8);
        ConstraintLayout.LayoutParams r24 = xbc.b.b(0.0f, 0.5f, this.p, 0, 0, 0);
        r24.bottomToBottom = 0;
        r24.startToStart = 0;
        r24.endToEnd = 0;
        addView(this.f, r24);
        setBackground(this.s);
        setClickable(true);
        this.w = R5(r21, this.d, this.u, this.v, this.t);
        ColorStateList r25 = this.l;
        if (r25 == null) goto L32;
        this.k.setTintList(r25);
        this.k.setTintMode(PorterDuff.Mode.SRC_ATOP);
    L32:
        this.x = R5(r21, this.c, this.j, this.k, this.i);
        return;
    L25:
        r17 = 8;
        goto L26
    L21:
        r6 = Integer.MAX_VALUE;
        goto L22
    L14:
        r2.topToTop = 0;
        r2.bottomToBottom = 0;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final f R5(Context r5, RelativeLayout r6, int r7, Drawable r8, String r9) {
        if (r7 != ContainerType.ICON_BTN.type) goto L6;
        UDCheckBox r10 = new ImageView(r5);
        r10.setImageDrawable(r8);
        r10.setScaleType(ImageView.ScaleType.FIT_XY);
        ViewGroup.LayoutParams r11 = xbc.b.d(16.0f, 16.0f);
        f r12 = new g(r10);
    L20:
        if (r10 == null) goto L25;
        if (r11 == null) goto L23;
        r6.addView(r10, r11);
    L24:
        r6.setVisibility(0);
    L26:
        return r12;
    L23:
        r6.addView(r10);
        goto L24
    L25:
        r6.setVisibility(8);
        goto L26
    L6:
        if (r7 != ContainerType.SWITCH_BTN.type) goto L9;
        UDCheckBox r13 = LayoutInflater.from(r5).inflate(2131564507, null);
        UDSwitch r14 = r13.findViewById(2131386001);
        setOnClickListener(new a(r14));
        r12 = new i(r14);
        r10 = r13;
    L18:
        r11 = null;
        goto L20
    L9:
        if (r7 != ContainerType.RADIO_BTN.type) goto L13;
        r10 = new UDCheckBox(r5);
        r10.setType(UDCheckBox.CheckBoxType.RADIO);
        r10.setPadding(0, 0, 0, 0);
        setOnClickListener(new b(r10));
        f r15 = new h(r10);
    L11:
        r12 = r15;
        goto L18
    L13:
        if (r7 != ContainerType.TEXT_ICON_BTN.type) goto L16;
        r10 = new LinearLayout(r5);
        r10.setOrientation(0);
        TextView r0 = new TextView(r5);
        r0.setText(r9);
        r0.setTextSize(14.0f);
        r0.setTextColor(y9c.d.c(r5, 2131106620));
        r10.addView(r0, xbc.b.c(-2, 16, 0, 12));
        ImageView r16 = new ImageView(r5);
        r16.setImageDrawable(r8);
        r16.setScaleType(ImageView.ScaleType.FIT_XY);
        float r17 = 16;
        LinearLayout.LayoutParams r18 = new LinearLayout.LayoutParams(xbc.b.e(r17), xbc.b.e(r17));
        r18.gravity = 16;
        r10.addView(r16, r18);
        r11 = xbc.b.d(-2.0f, -2.0f);
        r12 = new j(r0, r16);
        goto L20
    L16:
        if (r7 != ContainerType.THROTTLE_CHECKBOX.type) goto L19;
        r10 = new ThrottleCheckBox(r5);
        View.OnClickListener r19 = new c(r10);
        r10.setClickable(false);
        setOnClickListener(r19);
        r6.setOnClickListener(r19);
        r15 = new k(r10);
        goto L11
    L19:
        r11 = null;
        r10 = null;
        r12 = null;
        goto L20
    }
}
