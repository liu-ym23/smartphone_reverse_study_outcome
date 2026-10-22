package com.lynx.tasm.behavior.ui.list;

import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.ui.view.UIComponent;
import com.lynx.tasm.g;
import com.lynx.tasm.l;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public final UIList a;
    public final int b;
    public final ArrayList<UIComponent> c;
    public final ArrayList<UIComponent> d;
    public final C0053a e;

    /* JADX INFO: renamed from: com.lynx.tasm.behavior.ui.list.a$a, reason: collision with other inner class name */
    public class C0053a extends RecyclerView.OnScrollListener {
        public final /* synthetic */ a a;

        public C0053a(a r1) {
            this.a = r1;
        }

        public final void onScrollStateChanged(RecyclerView r4, int r5) {
            super.onScrollStateChanged(r4, r5);
            if (r4 == null) goto L19;
            UIList r0 = this.a.a;
            if (r0 != null) goto L7;
            return;
        L7:
            if (r0.c == null) goto L26;
            if (r5 != 0) goto L25;
            int r6 = 0;
        L12:
            if (r6 >= r4.getChildCount()) goto L27;
            View r1 = r4.getChildAt(r6);
            if ((r1 instanceof ListViewHolder.b) == false) goto L18;
            ListViewHolder.b r2 = (ListViewHolder.b) r1;
            if (r2.b != null) goto L18;
            LLog.i("UIList", "the scroll state of recyclerView is idle, the component is null. position is :" + r2.c);
            this.a.a.c.notifyItemChanged(r2.c);
        L18:
            r6 = r6 + 1;
            goto L12
        L27:
            return;
        L25:
            return;
        L26:
            return;
        }
    }

    public final void c() {
        UIList r0 = this.a;
        if (r0 == null) goto L35;
        UIListAdapter r1 = r0.c;
        if (r1 == null) goto L44;
        JavaOnlyArray r2 = r1.t;
        HashMap<String, Integer> r3 = r1.u;
        if (r2 == null) goto L43;
        if (r3 == null) goto L45;
        int r4 = r0.T();
        int r5 = this.a.U();
        this.d.clear();
        this.c.clear();
        int r6 = 1;
    L13:
        if (r6 > this.b) goto L46;
        if (r4 == (-1)) goto L25;
        int r7 = r4 - r6;
        if (r7 < 0) goto L25;
        if (r7 >= r2.size()) goto L25;
        if (b(r2.getString(r7)) == true) goto L25;
        long r8 = this.a.c.z2();
        if (d(r7) == false) goto L25;
        UIList r9 = this.a;
        g r10 = r9.a;
        l r11 = (l) r10;
        r11.d(r9.getSign(), r7, r8);
    L25:
        if (r5 == (-1)) goto L34;
        int r12 = r5 + r6;
        if (r12 >= r2.size()) goto L34;
        if (r12 < 0) goto L34;
        if (b(r2.getString(r12)) == true) goto L34;
        long r13 = this.a.c.z2();
        if (d(r12) == false) goto L34;
        UIList r14 = this.a;
        g r15 = r14.a;
        l r16 = (l) r15;
        r16.d(r14.getSign(), r12, r13);
    L34:
        r6 = r6 + 1;
        goto L13
    L46:
        return;
    L45:
        return;
    L43:
        return;
    L44:
        return;
    }

    public final boolean b(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return false;
    L5:
        int r0 = 0;
    L7:
        if (r0 >= this.c.size()) goto L14;
        UIComponent r2 = (UIComponent) ListProtector.get(this.c, r0);
        if (r2 == null) goto L13;
        if (r5.equals(r2.b) == false) goto L13;
        return true;
    L13:
        r0 = r0 + 1;
        goto L7
    L14:
        int r1 = 0;
    L16:
        if (r1 >= this.d.size()) goto L23;
        UIComponent r3 = (UIComponent) ListProtector.get(this.d, r1);
        if (r3 == null) goto L22;
        if (r5.equals(r3.b) == false) goto L22;
        return true;
    L22:
        r1 = r1 + 1;
        goto L16
    L23:
        return false;
    }

    public final boolean d(int r4) {
        UIList r0 = this.a;
        if (r0 == null) goto L16;
        UIListAdapter r1 = r0.c;
        if (r1 == null) goto L16;
        JavaOnlyArray r2 = r1.t;
        if (r2 == null) goto L16;
        int r3 = r2.size() - 1;
        if (r4 < 0) goto L13;
        if (r4 > r3) goto L13;
        boolean r5 = true;
    L14:
        if (r5 == false) goto L16;
        return true;
    L13:
        r5 = false;
    L16:
        return false;
    }

    public final void e(int r5) {
        UIList r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.c != null) goto L7;
        return;
    L7:
        if (d(r5) == false) goto L13;
        long r1 = this.a.c.z2();
        UIList r2 = this.a;
        g r3 = r2.a;
        l r4 = (l) r3;
        r4.d(r2.getSign(), r5, r1);
        return;
    }

    public a(UIList r2, int r3) {
        this.b = 0;
        this.c = new ArrayList();
        this.d = new ArrayList();
        C0053a r0 = new C0053a(this);
        this.e = r0;
        this.a = r2;
        this.b = r3;
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.getView() == 0) goto L9;
        ((RecyclerView) r2.getView()).addOnScrollListener(r0);
        return;
    }

    public final void a(UIComponent r3, boolean r4) {
        if (this.b <= 0) goto L21;
        if (r3 != null) goto L7;
        return;
    L7:
        if (r4 == false) goto L15;
        if (this.c.size() <= this.b) goto L13;
        UIComponent r5 = (UIComponent) ListProtector.remove(this.c, 0);
        if (r5 == null) goto L13;
        this.a.c.I2(r5);
    L13:
        this.c.add(r3);
        return;
    L15:
        if (this.d.size() <= this.b) goto L19;
        UIComponent r6 = (UIComponent) ListProtector.remove(this.d, 0);
        if (r6 == null) goto L19;
        this.a.c.I2(r6);
    L19:
        this.d.add(r3);
        return;
    }
}
