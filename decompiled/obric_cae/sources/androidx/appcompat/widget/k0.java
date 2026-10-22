package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.transition.Transition;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;

/* JADX INFO: loaded from: classes.dex */
public final class k0 extends i0 implements j0 {
    public j0 K;

    public static class a {
        public static void a(PopupWindow r8, Transition r10) {
            r8.setEnterTransition(r10);
        }

        public static void b(PopupWindow r8, Transition r10) {
            r8.setExitTransition(r10);
        }
    }

    public static class b {
        public static void a(PopupWindow r8, boolean r10) {
            r8.setTouchModal(r10);
        }
    }

    public static class c extends e0 {

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final int f1202w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public final int f1203x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public j0 f1204y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public androidx.appcompat.view.menu.h f1205z;

        public static class a {
            public static int a(Configuration r8) {
                return r8.getLayoutDirection();
            }
        }

        public c(Context r8, boolean r10) {
            super(r8, r10);
            if (1 != a.a(r8.getResources().getConfiguration())) goto L5;
            this.f1202w = 21;
            this.f1203x = 22;
            return;
        L5:
            this.f1202w = 22;
            this.f1203x = 21;
        }

        @Override // androidx.appcompat.widget.e0, android.view.View
        public final boolean onHoverEvent(MotionEvent r8) {
            if (this.f1204y == null) goto L27;
            ListAdapter r10 = getAdapter();
            if ((r10 instanceof HeaderViewListAdapter) == false) goto L7;
            HeaderViewListAdapter r11 = (HeaderViewListAdapter) r10;
            int r12 = r11.getHeadersCount();
            androidx.appcompat.view.menu.e r13 = (androidx.appcompat.view.menu.e) r11.getWrappedAdapter();
        L9:
            if (r8.getAction() == 10) goto L17;
            int r14 = pointToPosition((int) r8.getX(), (int) r8.getY());
            if (r14 == (-1)) goto L17;
            int r15 = r14 - r12;
            if (r15 < 0) goto L17;
            if (r15 >= r13.getCount()) goto L17;
            androidx.appcompat.view.menu.h r16 = r13.c(r15);
        L18:
            androidx.appcompat.view.menu.h r17 = this.f1205z;
            if (r17 == r16) goto L27;
            androidx.appcompat.view.menu.f r18 = r13.f808a;
            if (r17 == null) goto L23;
            this.f1204y.c(r18, r17);
        L23:
            this.f1205z = r16;
            if (r16 == null) goto L27;
            this.f1204y.a(r18, r16);
        L17:
            r16 = null;
            goto L18
        L7:
            r13 = (androidx.appcompat.view.menu.e) r10;
            r12 = 0;
        L27:
            return super.onHoverEvent(r8);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public final boolean onKeyDown(int r8, KeyEvent r10) {
            ListMenuItemView r11 = (ListMenuItemView) getSelectedView();
            if (r11 != null) goto L5;
        L12:
            if (r11 == null) goto L21;
            if (r8 != this.f1203x) goto L21;
            setSelection(-1);
            ListAdapter r12 = getAdapter();
            if ((r12 instanceof HeaderViewListAdapter) == false) goto L18;
            r12 = ((HeaderViewListAdapter) r12).getWrappedAdapter();
        L18:
            ((androidx.appcompat.view.menu.e) r12).f808a.d(false);
            return true;
        L21:
            return super.onKeyDown(r8, r10);
        L5:
            if (r8 != this.f1202w) goto L12;
            if (r11.isEnabled() == true) goto L9;
        L11:
            return true;
        L9:
            if (r11.getItemData().hasSubMenu() == false) goto L11;
            performItemClick(r11, getSelectedItemPosition(), getSelectedItemId());
            goto L11
        }

        public void setHoverListener(j0 r8) {
            this.f1204y = r8;
        }

        @Override // androidx.appcompat.widget.e0, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable r8) {
            super.setSelector(r8);
        }
    }

    public k0(Context r8, int r10, int r11) {
        super(r8, null, r10, r11);
    }

    @Override // androidx.appcompat.widget.j0
    public final void a(androidx.appcompat.view.menu.f r8, androidx.appcompat.view.menu.h r10) {
        j0 r11 = this.K;
        if (r11 == null) goto L6;
        r11.a(r8, r10);
        return;
    }

    @Override // androidx.appcompat.widget.j0
    public final void c(androidx.appcompat.view.menu.f r8, MenuItem r10) {
        j0 r11 = this.K;
        if (r11 == null) goto L6;
        r11.c(r8, r10);
        return;
    }

    @Override // androidx.appcompat.widget.i0
    public final e0 d(Context r8, boolean r10) {
        c r11 = new c(r8, r10);
        r11.setHoverListener(this);
        return r11;
    }
}
