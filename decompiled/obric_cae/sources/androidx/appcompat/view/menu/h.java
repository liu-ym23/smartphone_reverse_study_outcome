package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug;
import android.widget.LinearLayout;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class h implements c0.b {
    public j0.b A;
    public MenuItem.OnActionExpandListener B;
    public boolean C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f846d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f847e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CharSequence f848f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Intent f849g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public char f850h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f851i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public char f852j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f853k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Drawable f854l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f855m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final f f856n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public m f857o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f858p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public CharSequence f859q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public CharSequence f860r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ColorStateList f861s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public PorterDuff.Mode f862t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f863u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f864v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f865w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f866x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f867y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public View f868z;

    public class a implements j0.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f869a;

        public a(h r8) {
            this.f869a = r8;
        }
    }

    public h(f r8, int r10, int r11, int r12, int r13, CharSequence r14, int r15) {
        this.f851i = 4096;
        this.f853k = 4096;
        this.f855m = 0;
        this.f861s = null;
        this.f862t = null;
        this.f863u = false;
        this.f864v = false;
        this.f865w = false;
        this.f866x = 16;
        this.C = false;
        this.f856n = r8;
        this.f843a = r11;
        this.f844b = r10;
        this.f845c = r12;
        this.f846d = r13;
        this.f847e = r14;
        this.f867y = r15;
    }

    public static void c(int r8, int r10, String r11, StringBuilder r12) {
        if ((r8 & r10) != r10) goto L6;
        r12.append(r11);
        return;
    }

    @Override // c0.b
    public final c0.b a(j0.b r8) {
        j0.b r10 = this.A;
        if (r10 == null) goto L5;
        r10.f8373a = null;
    L5:
        this.f868z = null;
        this.A = r8;
        this.f856n.q(true);
        j0.b r11 = this.A;
        if (r11 == null) goto L8;
        r11.h(new a(this));
    L8:
        return this;
    }

    @Override // c0.b
    public final j0.b b() {
        return this.A;
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        if ((this.f867y & 8) != 0) goto L6;
        return false;
    L6:
        if (this.f868z != null) goto L9;
        return true;
    L9:
        MenuItem.OnActionExpandListener r8 = this.B;
        if (r8 == null) goto L16;
        if (r8.onMenuItemActionCollapse(this) == true) goto L16;
        return false;
    L16:
        return this.f856n.e(this);
    }

    public final Drawable d(Drawable r8) {
        if (r8 != null) goto L4;
    L16:
        return r8;
    L4:
        if (this.f865w == false) goto L16;
        if (this.f863u == false) goto L8;
    L9:
        r8 = r8.mutate();
        if (this.f863u == false) goto L13;
        b0.a.b.h(r8, this.f861s);
    L13:
        if (this.f864v == false) goto L15;
        b0.a.b.i(r8, this.f862t);
    L15:
        this.f865w = false;
        goto L16
    L8:
        if (this.f864v == false) goto L16;
        goto L9
    }

    public final boolean e() {
        if ((this.f867y & 8) != 0) goto L5;
        return false;
    L5:
        if (this.f868z != null) goto L10;
        j0.b r8 = this.A;
        if (r8 == null) goto L10;
        this.f868z = r8.d(this);
    L10:
        if (this.f868z == null) goto L14;
        return true;
    L14:
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        if (e() == true) goto L5;
        return false;
    L5:
        MenuItem.OnActionExpandListener r8 = this.B;
        if (r8 == null) goto L12;
        if (r8.onMenuItemActionExpand(this) == true) goto L12;
        return false;
    L12:
        return this.f856n.g(this);
    }

    public final void f(boolean r8) {
        if (r8 == false) goto L4;
        int r10 = this.f866x | 32;
    L5:
        this.f866x = r10;
        return;
    L4:
        r10 = this.f866x & (-33);
        goto L5
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        View r8 = this.f868z;
        if (r8 == null) goto L5;
        return r8;
    L5:
        j0.b r10 = this.A;
        if (r10 == null) goto L9;
        View r11 = r10.d(this);
        this.f868z = r11;
        return r11;
    L9:
        return null;
    }

    @Override // c0.b, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f853k;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f852j;
    }

    @Override // c0.b, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f859q;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return this.f844b;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        Drawable r8 = this.f854l;
        if (r8 != null) goto L5;
        int r10 = this.f855m;
        if (r10 == 0) goto L10;
        Drawable r11 = d.a.a(this.f856n.f815a, r10);
        this.f855m = 0;
        this.f854l = r11;
        return d(r11);
    L10:
        return null;
    L5:
        return d(r8);
    }

    @Override // c0.b, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f861s;
    }

    @Override // c0.b, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f862t;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f849g;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public final int getItemId() {
        return this.f843a;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // c0.b, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.f851i;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f850h;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return this.f845c;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return this.f857o;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public final CharSequence getTitle() {
        return this.f847e;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence r8 = this.f848f;
        if (r8 == null) goto L6;
        return r8;
    L6:
        return this.f847e;
    }

    @Override // c0.b, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f860r;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        if (this.f857o == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return this.C;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        if ((this.f866x & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        if ((this.f866x & 2) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        if ((this.f866x & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        j0.b r8 = this.A;
        if (r8 == null) goto L14;
        if (r8.g() == false) goto L14;
        if ((this.f866x & 8) != 0) goto L12;
        if (this.A.b() == false) goto L12;
        return true;
    L12:
        return false;
    L14:
        if ((this.f866x & 8) != 0) goto L17;
        return true;
    L17:
        return false;
    }

    public final boolean requiresActionButton() {
        if ((this.f867y & 2) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean requiresOverflow() {
        if (requiresActionButton() == false) goto L5;
        return false;
    L5:
        if ((this.f867y & 1) != 1) goto L7;
        boolean r8 = true;
    L8:
        if (r8 == false) goto L10;
        return false;
    L10:
        return true;
    L7:
        r8 = false;
        goto L8
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider r8) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int r8) {
        f r10 = this.f856n;
        Context r11 = r10.f815a;
        View r12 = LayoutInflater.from(r11).inflate(r8, new LinearLayout(r11), false);
        this.f868z = r12;
        this.A = null;
        if (r12 != null) goto L5;
    L9:
        r10.f825k = true;
        r10.q(true);
        return this;
    L5:
        if (r12.getId() != (-1)) goto L9;
        int r13 = this.f843a;
        if (r13 <= 0) goto L9;
        r12.setId(r13);
        goto L9
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char r8) {
        if (this.f852j != r8) goto L5;
        return this;
    L5:
        this.f852j = Character.toLowerCase(r8);
        this.f856n.q(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean r8) {
        int r10 = this.f866x;
        int r11 = r8 ? 1 : 0;
        int r12 = r11 | (r10 & (-2));
        this.f866x = r12;
        if (r10 == r12) goto L5;
        this.f856n.q(false);
    L5:
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean r10) {
        int r8 = this.f866x;
        int r11 = r8 & 4;
        f r12 = this.f856n;
        int r13 = 2;
        if (r11 == 0) goto L29;
        r12.getClass();
        ArrayList<h> r14 = r12.f820f;
        int r15 = r14.size();
        r12.y();
        int r16 = 0;
    L5:
        if (r16 >= r15) goto L28;
        h r17 = r14.get(r16);
        if (r17.f844b != this.f844b) goto L27;
        boolean r18 = true;
        if ((r17.f866x & 4) == 0) goto L11;
        boolean r19 = true;
    L12:
        if (r19 == false) goto L27;
        if (r17.isCheckable() == false) goto L27;
        if (r17 == this) goto L20;
        r18 = false;
    L20:
        int r20 = r17.f866x;
        int r21 = r20 & (-3);
        if (r18 == false) goto L23;
        int r22 = 2;
    L24:
        int r23 = r22 | r21;
        r17.f866x = r23;
        if (r20 == r23) goto L27;
        r17.f856n.q(false);
        goto L27
    L23:
        r22 = 0;
        goto L24
    L11:
        r19 = false;
    L27:
        r16 = r16 + 1;
        goto L5
    L28:
        r12.x();
    L36:
        return this;
    L29:
        int r24 = r8 & (-3);
        if (r10 == true) goto L33;
        r13 = 0;
    L33:
        int r110 = r13 | r24;
        this.f866x = r110;
        if (r8 == r110) goto L36;
        r12.q(false);
        goto L36
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence r8) {
        setContentDescription(r8);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean r8) {
        if (r8 == false) goto L4;
        int r10 = this.f866x | 16;
    L5:
        this.f866x = r10;
        this.f856n.q(false);
        return this;
    L4:
        r10 = this.f866x & (-17);
        goto L5
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int r8) {
        this.f854l = null;
        this.f855m = r8;
        this.f865w = true;
        this.f856n.q(false);
        return this;
    }

    @Override // c0.b, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList r8) {
        this.f861s = r8;
        this.f863u = true;
        this.f865w = true;
        this.f856n.q(false);
        return this;
    }

    @Override // c0.b, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode r8) {
        this.f862t = r8;
        this.f864v = true;
        this.f865w = true;
        this.f856n.q(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent r8) {
        this.f849g = r8;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char r8) {
        if (this.f850h != r8) goto L5;
        return this;
    L5:
        this.f850h = r8;
        this.f856n.q(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener r8) {
        this.B = r8;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener r8) {
        this.f858p = r8;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char r8, char r10) {
        this.f850h = r8;
        this.f852j = Character.toLowerCase(r10);
        this.f856n.q(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int r8) {
        int r10 = r8 & 3;
        if (r10 == 0) goto L10;
        if (r10 == 1) goto L10;
        if (r10 == 2) goto L10;
        throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    L10:
        this.f867y = r8;
        f r11 = this.f856n;
        r11.f825k = true;
        r11.q(true);
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int r8) {
        setShowAsAction(r8);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int r8) {
        setTitle(this.f856n.f815a.getString(r8));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence r8) {
        this.f848f = r8;
        this.f856n.q(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence r8) {
        setTooltipText(r8);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean r8) {
        int r10 = this.f866x;
        int r11 = r10 & (-9);
        boolean r12 = false;
        if (r8 == false) goto L5;
        int r13 = 0;
    L6:
        int r14 = r13 | r11;
        this.f866x = r14;
        if (r10 == r14) goto L9;
        r12 = true;
    L9:
        if (r12 == false) goto L11;
        f r15 = this.f856n;
        r15.f822h = true;
        r15.q(true);
    L11:
        return this;
    L5:
        r13 = 8;
        goto L6
    }

    public final String toString() {
        CharSequence r8 = this.f847e;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.toString();
    }

    @Override // c0.b, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char r8, int r10) {
        if (this.f852j == r8) goto L5;
    L7:
        this.f852j = Character.toLowerCase(r8);
        this.f853k = KeyEvent.normalizeMetaState(r10);
        this.f856n.q(false);
        return this;
    L5:
        if (this.f853k != r10) goto L7;
        return this;
    }

    @Override // c0.b, android.view.MenuItem
    public final c0.b setContentDescription(CharSequence r8) {
        this.f859q = r8;
        this.f856n.q(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable r8) {
        this.f855m = 0;
        this.f854l = r8;
        this.f865w = true;
        this.f856n.q(false);
        return this;
    }

    @Override // c0.b, android.view.MenuItem
    public final MenuItem setNumericShortcut(char r8, int r10) {
        if (this.f850h == r8) goto L5;
    L7:
        this.f850h = r8;
        this.f851i = KeyEvent.normalizeMetaState(r10);
        this.f856n.q(false);
        return this;
    L5:
        if (this.f851i != r10) goto L7;
        return this;
    }

    @Override // c0.b, android.view.MenuItem
    public final MenuItem setShortcut(char r8, char r10, int r11, int r12) {
        this.f850h = r8;
        this.f851i = KeyEvent.normalizeMetaState(r11);
        this.f852j = Character.toLowerCase(r10);
        this.f853k = KeyEvent.normalizeMetaState(r12);
        this.f856n.q(false);
        return this;
    }

    @Override // c0.b, android.view.MenuItem
    public final c0.b setTooltipText(CharSequence r8) {
        this.f860r = r8;
        this.f856n.q(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence r8) {
        this.f847e = r8;
        this.f856n.q(false);
        m r10 = this.f857o;
        if (r10 == null) goto L5;
        r10.setHeaderTitle(r8);
    L5:
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View r8) {
        this.f868z = r8;
        this.A = null;
        if (r8 != null) goto L5;
    L9:
        f r10 = this.f856n;
        r10.f825k = true;
        r10.q(true);
        return this;
    L5:
        if (r8.getId() != (-1)) goto L9;
        int r11 = this.f843a;
        if (r11 <= 0) goto L9;
        r8.setId(r11);
        goto L9
    }
}
