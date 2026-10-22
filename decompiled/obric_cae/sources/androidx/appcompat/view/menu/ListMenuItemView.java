package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.widget.v0;
import com.obric.cae.R;
import j0.h0;
import j0.w;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements k.a, AbsListView.SelectionBoundsAdjuster {
    public boolean A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f752b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public RadioButton f753m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TextView f754n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CheckBox f755o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextView f756p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ImageView f757q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ImageView f758r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public LinearLayout f759s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Drawable f760t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f761u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Context f762v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f763w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Drawable f764x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f765y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public LayoutInflater f766z;

    public ListMenuItemView(Context r8, AttributeSet r10) {
        super(r8, r10);
        v0 r11 = v0.m(getContext(), r10, c.a.f3232r, R.attr.listMenuViewStyle);
        this.f760t = r11.e(5);
        this.f761u = r11.i(1, -1);
        this.f763w = r11.a(7, false);
        this.f762v = r8;
        this.f764x = r11.e(8);
        TypedArray r12 = r8.getTheme().obtainStyledAttributes(null, new int[]{android.R.attr.divider}, R.attr.dropDownListViewStyle, 0);
        this.f765y = r12.hasValue(0);
        r11.n();
        r12.recycle();
    }

    private LayoutInflater getInflater() {
        if (this.f766z != null) goto L6;
        this.f766z = LayoutInflater.from(getContext());
    L6:
        return this.f766z;
    }

    private void setSubMenuArrowVisible(boolean r8) {
        ImageView r10 = this.f757q;
        if (r10 == null) goto L9;
        if (r8 == false) goto L6;
        int r11 = 0;
    L7:
        r10.setVisibility(r11);
        return;
    L6:
        r11 = 8;
        goto L7
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public final void adjustListItemSelectionBounds(Rect r8) {
        ImageView r10 = this.f758r;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.getVisibility() != 0) goto L9;
        LinearLayout.LayoutParams r11 = (LinearLayout.LayoutParams) this.f758r.getLayoutParams();
        int r12 = r8.top;
        r8.top = ((this.f758r.getHeight() + r11.topMargin) + r11.bottomMargin) + r12;
        return;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public final void c(h r11) {
        this.f751a = r11;
        int r8 = 0;
        if (r11.isVisible() == false) goto L5;
        int r10 = 0;
    L6:
        setVisibility(r10);
        setTitle(r11.f847e);
        setCheckable(r11.isCheckable());
        f r12 = r11.f856n;
        if (r12.p() == true) goto L9;
    L14:
        boolean r13 = false;
    L15:
        r12.o();
        if (r13 == false) goto L28;
        h r14 = this.f751a;
        f r15 = r14.f856n;
        if (r15.p() == true) goto L20;
    L25:
        boolean r16 = false;
    L26:
        if (r16 == false) goto L28;
    L29:
        if (r8 != 0) goto L57;
        TextView r17 = this.f756p;
        h r18 = this.f751a;
        if (r18.f856n.o() == false) goto L33;
        char r19 = r18.f852j;
    L34:
        if (r19 != 0) goto L36;
        String r20 = "";
    L55:
        r17.setText(r20);
        goto L57
    L36:
        f r21 = r18.f856n;
        Resources r22 = r21.f815a.getResources();
        StringBuilder r23 = new StringBuilder();
        if (ViewConfiguration.get(r21.f815a).hasPermanentMenuKey() == false) goto L40;
        r23.append(r22.getString(R.string.abc_prepend_shortcut_label));
    L40:
        if (r21.o() == false) goto L42;
        int r24 = r18.f853k;
    L43:
        h.c(r24, 65536, r22.getString(R.string.abc_menu_meta_shortcut_label), r23);
        h.c(r24, 4096, r22.getString(R.string.abc_menu_ctrl_shortcut_label), r23);
        h.c(r24, 2, r22.getString(R.string.abc_menu_alt_shortcut_label), r23);
        h.c(r24, 1, r22.getString(R.string.abc_menu_shift_shortcut_label), r23);
        h.c(r24, 4, r22.getString(R.string.abc_menu_sym_shortcut_label), r23);
        h.c(r24, 8, r22.getString(R.string.abc_menu_function_shortcut_label), r23);
        if (r19 != '\b') goto L46;
        int r25 = R.string.abc_menu_delete_shortcut_label;
    L53:
        r23.append(r22.getString(r25));
    L54:
        r20 = r23.toString();
        goto L55
    L46:
        if (r19 != '\n') goto L48;
        r25 = R.string.abc_menu_enter_shortcut_label;
        goto L53
    L48:
        if (r19 == ' ') goto L50;
        r23.append(r19);
        goto L54
    L50:
        r25 = R.string.abc_menu_space_shortcut_label;
        goto L53
    L42:
        r24 = r18.f851i;
        goto L43
    L33:
        r19 = r18.f850h;
    L57:
        if (this.f756p.getVisibility() == r8) goto L59;
        this.f756p.setVisibility(r8);
    L59:
        setIcon(r11.getIcon());
        setEnabled(r11.isEnabled());
        setSubMenuArrowVisible(r11.hasSubMenu());
        setContentDescription(r11.f859q);
        return;
    L20:
        if (r15.o() == false) goto L22;
        char r26 = r14.f852j;
    L23:
        if (r26 == 0) goto L25;
        r16 = true;
        goto L26
    L22:
        r26 = r14.f850h;
    L28:
        r8 = 8;
        goto L29
    L9:
        if (r12.o() == false) goto L11;
        char r27 = r11.f852j;
    L12:
        if (r27 == 0) goto L14;
        r13 = true;
        goto L15
    L11:
        r27 = r11.f850h;
        goto L12
    L5:
        r10 = 8;
        goto L6
    }

    @Override // androidx.appcompat.view.menu.k.a
    public h getItemData() {
        return this.f751a;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        WeakHashMap<View, h0> r8 = w.f8437a;
        w.d.q(this, this.f760t);
        TextView r10 = (TextView) findViewById(R.id.title);
        this.f754n = r10;
        int r11 = this.f761u;
        if (r11 == (-1)) goto L5;
        r10.setTextAppearance(this.f762v, r11);
    L5:
        this.f756p = (TextView) findViewById(R.id.shortcut);
        ImageView r12 = (ImageView) findViewById(R.id.submenuarrow);
        this.f757q = r12;
        if (r12 == null) goto L8;
        r12.setImageDrawable(this.f764x);
    L8:
        this.f758r = (ImageView) findViewById(R.id.group_divider);
        this.f759s = (LinearLayout) findViewById(R.id.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r8, int r10) {
        if (this.f752b != null) goto L5;
    L11:
        super.onMeasure(r8, r10);
        return;
    L5:
        if (this.f763w == false) goto L11;
        ViewGroup.LayoutParams r11 = getLayoutParams();
        LinearLayout.LayoutParams r12 = (LinearLayout.LayoutParams) this.f752b.getLayoutParams();
        int r13 = r11.height;
        if (r13 <= 0) goto L11;
        if (r12.width > 0) goto L11;
        r12.width = r13;
        goto L11
    }

    public void setCheckable(boolean r8) {
        if (r8 == true) goto L9;
        if (this.f753m != null) goto L9;
        if (this.f755o != null) goto L9;
        return;
    L9:
        if ((this.f751a.f866x & 4) == 0) goto L11;
        boolean r10 = true;
    L13:
        if (r10 == false) goto L22;
        if (this.f753m != null) goto L20;
        RadioButton r11 = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, this, false);
        this.f753m = r11;
        LinearLayout r12 = this.f759s;
        if (r12 == null) goto L19;
        r12.addView(r11, -1);
        goto L20
    L19:
        addView(r11, -1);
    L20:
        CompoundButton r13 = this.f753m;
        CompoundButton r14 = this.f755o;
    L29:
        if (r8 == false) goto L37;
        r13.setChecked(this.f751a.isChecked());
        if (r13.getVisibility() == 0) goto L33;
        r13.setVisibility(0);
    L33:
        if (r14 != null) goto L35;
        return;
    L35:
        if (r14.getVisibility() == 8) goto L45;
        r14.setVisibility(8);
        return;
    L45:
        return;
    L37:
        CheckBox r15 = this.f755o;
        if (r15 == null) goto L40;
        r15.setVisibility(8);
    L40:
        RadioButton r16 = this.f753m;
        if (r16 == null) goto L47;
        r16.setVisibility(8);
        return;
    L47:
        return;
    L22:
        if (this.f755o != null) goto L27;
        CheckBox r17 = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, this, false);
        this.f755o = r17;
        LinearLayout r18 = this.f759s;
        if (r18 == null) goto L26;
        r18.addView(r17, -1);
        goto L27
    L26:
        addView(r17, -1);
    L27:
        r13 = this.f755o;
        r14 = this.f753m;
        goto L29
    L11:
        r10 = false;
        goto L13
    }

    public void setChecked(boolean r8) {
        if ((this.f751a.f866x & 4) == 0) goto L5;
        boolean r10 = true;
    L7:
        if (r10 == false) goto L16;
        if (this.f753m != null) goto L14;
        RadioButton r11 = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, this, false);
        this.f753m = r11;
        LinearLayout r12 = this.f759s;
        if (r12 == null) goto L13;
        r12.addView(r11, -1);
        goto L14
    L13:
        addView(r11, -1);
    L14:
        CompoundButton r13 = this.f753m;
    L22:
        r13.setChecked(r8);
        return;
    L16:
        if (this.f755o != null) goto L21;
        CheckBox r14 = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, this, false);
        this.f755o = r14;
        LinearLayout r15 = this.f759s;
        if (r15 == null) goto L20;
        r15.addView(r14, -1);
        goto L21
    L20:
        addView(r14, -1);
    L21:
        r13 = this.f755o;
        goto L22
    L5:
        r10 = false;
        goto L7
    }

    public void setForceShowIcon(boolean r8) {
        this.A = r8;
        this.f763w = r8;
    }

    public void setGroupDividerEnabled(boolean r8) {
        ImageView r10 = this.f758r;
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.f765y == true) goto L8;
        if (r8 == false) goto L8;
        int r11 = 0;
    L9:
        r10.setVisibility(r11);
        return;
    L8:
        r11 = 8;
        goto L9
    }

    public void setIcon(Drawable r8) {
        if (this.f751a.f856n.f833s == false) goto L5;
    L8:
        boolean r10 = true;
    L9:
        if (r10 == false) goto L11;
    L13:
        ImageView r11 = this.f752b;
        if (r11 != null) goto L19;
        if (r8 != null) goto L19;
        if (this.f763w == true) goto L19;
        return;
    L19:
        if (r11 != null) goto L24;
        ImageView r12 = (ImageView) getInflater().inflate(R.layout.abc_list_menu_item_icon, this, false);
        this.f752b = r12;
        LinearLayout r13 = this.f759s;
        if (r13 == null) goto L23;
        r13.addView(r12, 0);
        goto L24
    L23:
        addView(r12, 0);
    L24:
        if (r8 == null) goto L26;
    L29:
        ImageView r14 = this.f752b;
        if (r10 == true) goto L33;
        r8 = null;
    L33:
        r14.setImageDrawable(r8);
        if (this.f752b.getVisibility() == 0) goto L38;
        this.f752b.setVisibility(0);
        return;
    L38:
        return;
    L26:
        if (this.f763w == true) goto L29;
        this.f752b.setVisibility(8);
        return;
    L11:
        if (this.f763w == true) goto L13;
        return;
    L5:
        if (this.A == true) goto L8;
        r10 = false;
        goto L9
    }

    public void setTitle(CharSequence r8) {
        if (r8 == null) goto L7;
        this.f754n.setText(r8);
        if (this.f754n.getVisibility() == 0) goto L10;
        this.f754n.setVisibility(0);
        return;
    L10:
        return;
    L7:
        if (this.f754n.getVisibility() == 8) goto L12;
        this.f754n.setVisibility(8);
        return;
    }
}
