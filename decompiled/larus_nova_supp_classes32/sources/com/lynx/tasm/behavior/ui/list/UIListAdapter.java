package com.lynx.tasm.behavior.ui.list;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.view.UIComponent;
import com.lynx.tasm.g;
import com.lynx.tasm.l;
import com.lynx.tasm.utils.UIThreadUtils;
import com.lynx.tasm.utils.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class UIListAdapter extends RecyclerView.Adapter<ListViewHolder> {
    public final b A;
    public final ArrayList<HashMap<Integer, Integer>> B;
    public final HashMap<String, Integer> C;
    public final HashMap<String, Integer> a;
    public final HashMap<Long, ListViewHolder> b;
    public final UIList c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public JavaOnlyArray h;
    public JavaOnlyArray i;
    public JavaOnlyArray j;
    public JavaOnlyArray k;
    public JavaOnlyArray l;
    public JavaOnlyArray m;
    public JavaOnlyArray n;
    public JavaOnlyArray o;
    public JavaOnlyArray p;
    public final d q;
    public int r;
    public final e7a.a s;
    public JavaOnlyArray t;
    public HashMap<String, Integer> u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public final a z;

    public class a implements Runnable {
        public final /* synthetic */ UIListAdapter a;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.q.a();     // Catch: Throwable -> L4 IllegalStateException -> L6
        L13:
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        L17:
            return;
        L6:
            e = move-exception;
            LLog.e("UIList", "operationDispatcher.dispatch() leads to the IllegalStateException : " + e.getMessage());     // Catch: Throwable -> L4
            goto L13
        }

        public a(UIListAdapter r1) {
            this.a = r1;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ UIListAdapter a;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.notifyDataSetChanged();     // Catch: Throwable -> L4 IllegalStateException -> L6
        L13:
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        L17:
            return;
        L6:
            e = move-exception;
            LLog.e("UIList", "notifyDataSetChanged leads to the IllegalStateException : " + e.getMessage());     // Catch: Throwable -> L4
            goto L13
        }

        public b(UIListAdapter r1) {
            this.a = r1;
        }
    }

    public class c implements UIComponent.b {
        public final /* synthetic */ UIListAdapter a;

        public c(UIListAdapter r1) {
            this.a = r1;
        }

        @Override // com.lynx.tasm.behavior.ui.view.UIComponent.b
        public final void a(UIComponent r2) {
            if (r2 != null) goto L4;
            return;
        L4:
            if (r2.b == null) goto L8;
            this.a.O2(r2);
            return;
        }
    }

    public final class d {
        public ReadableArray a;
        public ReadableArray b;
        public ReadableArray c;
        public ReadableArray d;
        public ReadableArray e;
        public ReadableArray f;
        public final /* synthetic */ UIListAdapter g;

        public final void a() {
            int r1 = 0;
            if (this.c == null) goto L9;
            int r0 = 0;
        L6:
            if (r0 >= this.c.size()) goto L9;
            this.g.notifyItemChanged(this.c.getInt(r0), Integer.valueOf(this.d.getInt(r0)));
            r0 = r0 + 1;
        L9:
            if (this.e == null) goto L14;
            int r2 = 0;
        L12:
            if (r2 >= this.e.size()) goto L14;
            this.g.notifyItemMoved(this.e.getInt(r2), this.f.getInt(r2));
            r2 = r2 + 1;
        L14:
            ReadableArray r3 = this.b;
            if (r3 == null) goto L20;
            int r4 = r3.size() - 1;
        L17:
            if (r4 < 0) goto L20;
            this.g.notifyItemRemoved(this.b.getInt(r4));
            r4 = r4 - 1;
        L20:
            if (this.a != null) goto L22;
            return;
        L22:
            if (r1 >= this.a.size()) goto L29;
            this.g.notifyItemInserted(this.a.getInt(r1));
            r1 = r1 + 1;
            goto L22
        }

        public d(UIListAdapter r1) {
            this.g = r1;
        }

        public static boolean b(ReadableArray r0) {
            if (r0 != null) goto L4;
            return false;
        L4:
            if (r0.size() <= 0) goto L9;
            return true;
        L9:
            return false;
        }

        public void update(ReadableMap r2) {
            this.a = r2.getArray("insertions");
            this.b = r2.getArray("removals");
            this.c = r2.getArray("updateFrom");
            this.d = r2.getArray("updateTo");
            this.e = r2.getArray("moveFrom");
            this.f = r2.getArray("moveTo");
            if (b(this.a) == false) goto L5;
        L14:
            this.g.e = false;
            return;
        L5:
            if (b(this.b) == true) goto L14;
            if (b(this.c) == true) goto L14;
            if (b(this.d) == true) goto L14;
            if (b(this.e) == true) goto L14;
            if (b(this.f) == true) goto L14;
        }
    }

    public final boolean L2() {
        if (this.d == false) goto L11;
        UIList r0 = this.c;
        if (r0 == null) goto L11;
        if (r0.getView() == 0) goto L11;
        if (((RecyclerView) this.c.getView()).isComputingLayout() == false) goto L11;
        return true;
    L11:
        return false;
    }

    public final int getItemCount() {
        JavaOnlyArray r0 = this.h;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public final long z2() {
        long r0 = ((long) this.c.getSign()) << 32;
        int r2 = this.r;
        this.r = r2 + 1;
        return r0 + ((long) r2);
    }

    public final int A2(int r4) {
        int r0 = 0;
    L4:
        if (r0 >= this.i.size()) goto L10;
        Integer r1 = (Integer) this.i.get(r0);
        if (r1.intValue() >= r4) goto L8;
        r0 = r0 + 1;
        goto L4
    L8:
        return r1.intValue();
    L10:
        return -1;
    }

    public final int B2(int r4) {
        int r0 = this.i.size() - 1;
    L3:
        if (r0 < 0) goto L9;
        Integer r1 = (Integer) this.i.get(r0);
        if (r1.intValue() <= r4) goto L7;
        r0 = r0 - 1;
        goto L3
    L7:
        return r1.intValue();
    L9:
        return -1;
    }

    public final int C2(int r5) {
        int r0 = 0;
    L4:
        if (r0 >= this.i.size()) goto L12;
        Integer r1 = (Integer) this.i.get(r0);
        if (r1.intValue() < r5) goto L11;
        int r2 = r1.intValue();
        if (this.k.contains(Integer.valueOf(r2)) == false) goto L11;
        return r1.intValue();
    L11:
        r0 = r0 + 1;
        goto L4
    L12:
        return -1;
    }

    public final int D2(int r6) {
        int r0 = this.i.size() - 1;
    L3:
        if (r0 < 0) goto L11;
        Integer r2 = (Integer) this.i.get(r0);
        if (r2.intValue() > r6) goto L10;
        if (this.j.contains(Integer.valueOf(r2.intValue())) == false) goto L10;
        return r2.intValue();
    L10:
        r0 = r0 - 1;
        goto L3
    L11:
        return -1;
    }

    public final boolean E2(UIComponent r6) {
        UIList r0 = this.c;
        if (r0 == null) goto L20;
        RecyclerView r1 = r0.V();
        if (r1 == null) goto L20;
        int r2 = 0;
    L8:
        if (r2 >= r1.getChildCount()) goto L20;
        View r3 = r1.getChildAt(r2);
        if ((r3 instanceof ListViewHolder.b) == false) goto L19;
        UIComponent r4 = ((ListViewHolder.b) r3).b;
        if (r4 == null) goto L19;
        String r5 = r4.b;
        if (r5 == null) goto L19;
        if (r5.equals(r6.b) == false) goto L19;
        return true;
    L19:
        r2 = r2 + 1;
    L20:
        return false;
    }

    public final boolean F2(int r2) {
        return this.i.contains(Integer.valueOf(r2));
    }

    public final void H2(ListViewHolder r5) {
        UIComponent r0 = r5.a.b;
        if (r0 == null) goto L22;
        r5.T3();
        if (this.c.P == null) goto L18;
        if (E2(r0) == true) goto L15;
        com.lynx.tasm.behavior.ui.list.a r1 = this.c.P;
        if (r1 != null) goto L11;
    L13:
        boolean r2 = false;
    L14:
        if (r2 == false) goto L18;
    L11:
        if (r1.b(r0.b) == false) goto L13;
        r2 = true;
    L15:
        LLog.i("UIList", "when recycling the child asynchronously,if the view of the component is used, you cannot recycle the component. the itemKey is :" + r0.b + " position:" + r5.getAdapterPosition());
        return;
    L18:
        if (this.g == false) goto L20;
        UIList r3 = this.c;
        ((l) r3.a).f(r3.getSign(), r0.getSign());
        r5.a.a = 0;
        return;
    L20:
        this.c.N(r0);
        return;
    }

    public final void I2(UIComponent r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (this.c.P == null) goto L17;
        if (E2(r3) == true) goto L14;
        com.lynx.tasm.behavior.ui.list.a r0 = this.c.P;
        if (r0 != null) goto L10;
    L12:
        boolean r1 = false;
    L13:
        if (r1 == false) goto L17;
    L10:
        if (r0.b(r3.b) == false) goto L12;
        r1 = true;
    L14:
        LLog.i("UIList", "recycleHolderComponent the component is used. itemKey :" + r3.b);
        return;
    L17:
        if (this.g == false) goto L19;
        UIList r2 = this.c;
        ((l) r2.a).f(r2.getSign(), r3.getSign());
        return;
    L19:
        this.c.N(r3);
    }

    public final void M2(JavaOnlyMap r8) {
        JavaOnlyArray r0 = this.h;
        int r2 = 0;
        if (r0 != null) goto L5;
    L9:
        boolean r1 = false;
    L10:
        if (r8 != null) goto L12;
        return;
    L12:
        if (r8.isEmpty() == true) goto L72;
        ReadableArray r3 = r8.getArray("itemkeys");
        if ((r3 instanceof JavaOnlyArray) == false) goto L17;
        this.t = (JavaOnlyArray) r3;
    L17:
        this.u = new HashMap();
        int r4 = 0;
    L19:
        if (r4 >= this.t.size()) goto L21;
        this.u.put(this.t.getString(r4), Integer.valueOf(r4));
        r4 = r4 + 1;
        goto L19
    L21:
        ReadableArray r5 = r8.getArray("fullspan");
        if ((r5 instanceof JavaOnlyArray) == false) goto L24;
        this.i = (JavaOnlyArray) r5;
    L24:
        ReadableArray r6 = r8.getArray("viewTypes");
        if ((r6 instanceof JavaOnlyArray) == false) goto L27;
        this.h = (JavaOnlyArray) r6;
    L27:
        ReadableArray r7 = r8.getArray("stickyTop");
        if ((r7 instanceof JavaOnlyArray) == false) goto L30;
        this.j = (JavaOnlyArray) r7;
    L30:
        ReadableArray r9 = r8.getArray("stickyBottom");
        if ((r9 instanceof JavaOnlyArray) == false) goto L33;
        this.k = (JavaOnlyArray) r9;
    L33:
        ReadableArray r10 = r8.getArray("estimatedHeight");
        if ((r10 instanceof JavaOnlyArray) == false) goto L36;
        this.l = (JavaOnlyArray) r10;
    L36:
        ReadableArray r11 = r8.getArray("estimatedHeightPx");
        if ((r11 instanceof JavaOnlyArray) == false) goto L39;
        this.m = (JavaOnlyArray) r11;
    L39:
        boolean r12 = r8.getBoolean("diffable");
        this.d = r8.getBoolean("newarch");
    L41:
        if (r2 >= this.h.size()) goto L46;
        String r13 = this.h.getString(r2);
        if (this.a.containsKey(r13) == true) goto L45;
        HashMap<String, Integer> r14 = this.a;
        r14.put(r13, Integer.valueOf(r14.size()));
    L45:
        r2 = r2 + 1;
        goto L41
    L46:
        if (r1 == true) goto L59;
        if (r12 == false) goto L59;
        if (this.e == false) goto L59;
        ReadableMap r15 = r8.getMap("diffResult");
        if (r15 != null) goto L53;
    L55:
        this.q.update(r15);
        if (L2() == false) goto L58;
        UIThreadUtils.runOnUiThread(this.z);
        return;
    L58:
        this.z.run();
        return;
    L53:
        if (r15.size() <= 0) goto L55;
        this.y = true;
    L59:
        this.y = true;
        this.C.clear();
        if (L2() == false) goto L62;
        UIThreadUtils.runOnUiThread(this.A);
        return;
    L62:
        this.A.run();
        return;
    L72:
        return;
    L5:
        if (this.i == null) goto L9;
        if (r0.size() != this.i.size()) goto L9;
        r1 = true;
        goto L10
    }

    public final void O2(UIComponent r3) {
        if (this.c.O == false) goto L14;
        if (r3 != null) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r3.b) == false) goto L9;
        return;
    L9:
        if (this.c.x == false) goto L11;
        int r0 = r3.getHeight();
    L12:
        int r1 = UIList.L0;
        this.C.put(r3.b, Integer.valueOf(r0));
        return;
    L11:
        r0 = r3.getWidth();
        goto L12
    }

    public final long getItemId(int r3) {
        if (hasStableIds() == true) goto L5;
        return -1;
    L5:
        return r3;
    }

    public final int getItemViewType(int r3) {
        Integer r4 = this.a.get(this.h.getString(r3));
        if (r4 != null) goto L7;
        return 0;
    L7:
        return r4.intValue();
    }

    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r7) {
        ListViewHolder r8 = (ListViewHolder) r7;
        if (r8.a.b != null) goto L13;
        if (this.g == false) goto L9;
        if (this.b.containsValue(r8) == true) goto L13;
    L9:
        if (this.d == false) goto L11;
        y2(r8, r8.getAdapterPosition());
        goto L13
    L11:
        G2(r8, r8.getAdapterPosition());
    L13:
        if (this.g == true) goto L16;
        this.s.c(r8);
    L16:
        if (this.d == false) goto L22;
        ListViewHolder.b r0 = r8.a;
        if (r0.b == null) goto L22;
        if (this.v == false) goto L22;
        UIComponent r1 = r0.b;
        r1.onListCellAppear(r1.b, this.c);
    L22:
        int r2 = r8.getAdapterPosition();
        int r3 = getItemCount() - r8.getAdapterPosition();
        boolean r4 = true;
        int r5 = r3 - 1;
        int r6 = 0;
        if (r5 != 0) goto L25;
    L30:
        if (r4 == true) goto L36;
        ListViewHolder.b r9 = r8.a;
        UIList r10 = this.c;
        if (r10.R == false) goto L34;
        int r11 = 0;
    L35:
        r9.g = r11;
    L37:
        StaggeredGridLayoutManager.LayoutParams r12 = (RecyclerView.LayoutParams) ((RecyclerView.ViewHolder) r8).itemView.getLayoutParams();
        if ((r12 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L41;
        r12.setFullSpan(F2(r2));
    L41:
        if (this.B.isEmpty() == true) goto L87;
        UIComponent r13 = r8.a.b;
        if (r13 != null) goto L46;
        int r14 = 0;
    L48:
        if ((((RecyclerView) this.c.getView()).getLayoutManager() instanceof ListLayoutManager.ListLinearLayoutManager) == false) goto L51;
        ((HashMap) ListProtector.get(this.B, 0)).put(Integer.valueOf(r2), Integer.valueOf(r14));
        return;
    L51:
        if ((((RecyclerView) this.c.getView()).getLayoutManager() instanceof ListLayoutManager.b) == false) goto L65;
        StaggeredGridLayoutManager.LayoutParams r15 = ((RecyclerView.ViewHolder) r8).itemView.getLayoutParams();
        if (F2(r2) == false) goto L58;
    L55:
        if (r6 >= this.B.size()) goto L88;
        ((HashMap) ListProtector.get(this.B, r6)).put(Integer.valueOf(r2), Integer.valueOf(r14));
        r6 = r6 + 1;
        goto L55
    L88:
        return;
    L58:
        if (r6 >= this.B.size()) goto L89;
        if (r15.getSpanIndex() != r6) goto L62;
        ((HashMap) ListProtector.get(this.B, r6)).put(Integer.valueOf(r2), Integer.valueOf(r14));
    L63:
        r6 = r6 + 1;
        goto L58
    L62:
        ((HashMap) ListProtector.get(this.B, r6)).remove(Integer.valueOf(r2));
        goto L63
    L89:
        return;
    L65:
        if ((((RecyclerView) this.c.getView()).getLayoutManager() instanceof GridLayoutManager) == false) goto L86;
        GridLayoutManager r16 = ((RecyclerView) this.c.getView()).getLayoutManager();
        int r17 = r16.getSpanSizeLookup().getSpanIndex(r2, r16.getSpanCount());
        if (F2(r2) == false) goto L72;
    L69:
        if (r6 >= this.B.size()) goto L90;
        ((HashMap) ListProtector.get(this.B, r6)).put(Integer.valueOf(r2), Integer.valueOf(r14));
        r6 = r6 + 1;
        goto L69
    L90:
        return;
    L72:
        if (r6 >= this.B.size()) goto L91;
        if (r17 != r6) goto L75;
        ((HashMap) ListProtector.get(this.B, r6)).put(Integer.valueOf(r2), Integer.valueOf(r14));
    L76:
        r6 = r6 + 1;
        goto L72
    L75:
        ((HashMap) ListProtector.get(this.B, r6)).remove(Integer.valueOf(r2));
        goto L76
    L91:
        return;
    L86:
        return;
    L46:
        r14 = r13.getHeight();
        goto L48
    L87:
        return;
    L34:
        r11 = r10.e;
        goto L35
    L36:
        r8.a.g = 0;
        goto L37
    L25:
        if (r5 < this.c.d) goto L27;
    L29:
        r4 = false;
        goto L30
    L27:
        if (A2(r2) != (-1)) goto L29;
        goto L29
    }

    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r5) {
        ListViewHolder r6 = (ListViewHolder) r5;
        this.s.a(r6);
        if (this.d == false) goto L17;
        UIComponent r0 = r6.a.b;
        if (r0 == null) goto L14;
        if (this.w == false) goto L14;
        JavaOnlyArray r1 = this.t;
        if (r1 != null) goto L11;
        boolean r2 = false;
    L12:
        UIComponent r3 = r6.a.b;
        r3.onListCellDisAppear(r3.b, this.c, r2);
        goto L14
    L11:
        r2 = r1.contains(r0.b);
    L14:
        if (this.g == true) goto L18;
        H2(r6);
        return;
    L18:
        return;
    }

    public UIListAdapter(UIList r2, e7a.a r3) {
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = false;
        this.r = 0;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = new a(this);
        this.A = new b(this);
        this.B = new ArrayList();
        this.C = new HashMap();
        this.a = new HashMap();
        this.b = new HashMap();
        this.q = new d(this);
        this.c = r2;
        this.s = r3;
    }

    public final void G2(ListViewHolder r8, int r9) {
        if (r8 == null) goto L8;
        ListViewHolder.b r0 = r8.a;
        if (r0 == null) goto L8;
        if (r0.h != null) goto L8;
        r0.h = new com.lynx.tasm.behavior.ui.list.c(this);
    L8:
        int r1 = UIList.L0;
        if (this.d == false) goto L12;
        y2(r8, r9);
        return;
    L12:
        long r5 = z2();
        this.b.put(Long.valueOf(r5), r8);
        ListViewHolder.b r2 = r8.a;
        UIComponent r3 = r2.b;
        if (r3 != null) goto L18;
        UIList r4 = this.c;
        ((l) r4.a).h(r4.getSign(), r9, r5);
        LynxUI r6 = (LynxUI) r4.b;
        r4.b = null;
        UIComponent r7 = (UIComponent) r6;
        if (r7 == null) goto L17;
        r8.U3(r7);
        this.s.d(r8);
    L19:
        JavaOnlyArray r10 = this.m;
        if (r10 != null) goto L22;
    L26:
        JavaOnlyArray r11 = this.l;
        if (r11 != null) goto L29;
        return;
    L29:
        if (r11.size() <= r9) goto L35;
        int r12 = this.l.getInt(r9);
        if (r12 <= 0) goto L36;
        r8.a.d = r12;
        return;
    L36:
        return;
    L35:
        return;
    L22:
        if (r10.size() <= r9) goto L26;
        int r13 = (int) i.b(this.m.getInt(r9), 0.0f);
        if (r13 <= 0) goto L26;
        r8.a.d = r13;
        goto L26
    L17:
        LLog.i("UIList", "Adapter onBindViewHolder " + r9 + "child null");
        goto L19
    L18:
        r2.a = 1;
        UIList r14 = this.c;
        g r15 = r14.a;
        ((l) r15).i(r14.getSign(), r3.getSign(), r9, r5);
        goto L19
    }

    public final void J2(ListViewHolder r3, int r4) {
        JavaOnlyArray r0 = this.m;
        if (r0 != null) goto L5;
    L7:
        JavaOnlyArray r1 = this.l;
        if (r1 != null) goto L10;
        return;
    L10:
        if (r1.size() <= r4) goto L14;
        K2(r3, this.l.getInt(r4));
        return;
    L14:
        return;
    L5:
        if (r0.size() <= r4) goto L7;
        K2(r3, (int) i.b(this.m.getInt(r4), 0.0f));
        goto L7
    }

    public final void K2(ListViewHolder r2, int r3) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (this.c.x == false) goto L8;
        if (r3 <= 0) goto L11;
        r2.a.d = r3;
        return;
    L11:
        return;
    L8:
        if (r3 <= 0) goto L13;
        r2.a.e = r3;
        return;
    }

    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        G2((ListViewHolder) r1, r2);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        int r5 = UIList.L0;
        ViewGroup.LayoutParams r6 = new ViewGroup.LayoutParams(-1, -2);
        ListViewHolder.b r0 = new ListViewHolder.b(r3.getContext());
        r0.setLayoutParams(r6);
        r0.f = this.f;
        r0.i = ((RecyclerView) this.c.getView()).getLayoutDirection();
        return new ListViewHolder(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v37, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r1v16, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r5v3, types: [android.view.View] */
    public final void y2(ListViewHolder r10, int r11) {
        int r0 = UIList.L0;
        com.lynx.tasm.behavior.ui.list.a r1 = this.c.P;
        boolean r2 = false;
        if (r1 == null) goto L25;
        String r3 = this.t.getString(r11);
        if (TextUtils.isEmpty(r3) == true) goto L25;
        int r4 = 0;
    L9:
        if (r4 >= r1.c.size()) goto L16;
        UIComponent r5 = (UIComponent) ListProtector.get(r1.c, r4);
        if (r5 == null) goto L15;
        if (r3.equals(r5.b) == false) goto L15;
        r1.c.remove(r5);
    L27:
        if (r5 != null) goto L66;
        long r6 = z2();
        int r7 = UIList.L0;
        this.b.put(Long.valueOf(r6), r10);
        if (this.g == false) goto L50;
        int r8 = this.c.T;
        if (r8 == 1) goto L39;
        if (r8 != 0) goto L40;
        UIComponent r9 = r10.a.b;
        if (r9 == null) goto L40;
        if (TextUtils.isEmpty(r9.b) == true) goto L40;
        if (r10.a.b.b.equals(this.t.getString(r11)) == false) goto L39;
    L40:
        r10.b = r6;
        UIList r12 = this.c;
        g r13 = r12.a;
        l r14 = (l) r13;
        r14.d(r12.getSign(), r11, r6);
        StaggeredGridLayoutManager.LayoutParams r15 = ((RecyclerView.ViewHolder) r10).itemView.getLayoutParams();
        if ((r15 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L43;
        r15.setFullSpan(F2(r11));
    L43:
        String r16 = (String) this.t.get(r11);
        r10.a.a = 0;
        if (this.c.O == true) goto L46;
    L48:
        J2(r10, r11);
        return;
    L46:
        if (this.C.containsKey(r16) == false) goto L48;
        K2(r10, this.C.get(r16).intValue());
        return;
    L39:
        r10.T3();
        goto L40
    L50:
        r5 = this.c.M(r11, r6, this.x);
        if (r5 != null) goto L55;
        this.b.remove(Long.valueOf(r6));
        return;
    L55:
        if (this.c.L == true) goto L61;
        if (ViewCompat.isAttachedToWindow(r5.getView()) == false) goto L61;
        this.b.remove(Long.valueOf(r6));
        return;
    L61:
        if (r5 != r10.a.b) goto L63;
    L107:
        UIList r17 = this.c;
        if (r17.O == true) goto L110;
    L112:
        StaggeredGridLayoutManager.LayoutParams r18 = ((RecyclerView.ViewHolder) r10).itemView.getLayoutParams();
        if ((r18 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L115;
        r18.setFullSpan(F2(r11));
    L115:
        UIList r19 = this.c;
        if (r19.O == true) goto L118;
    L133:
        J2(r10, r11);
        return;
    L118:
        if (r19.X() == false) goto L133;
        UIComponent r20 = r10.a.b;
        if (r20 == null) goto L133;
        if (this.C.containsKey(r20.b) == false) goto L133;
        int r21 = this.C.get(r20.b).intValue();
        if (this.c.x == false) goto L129;
        if (r21 == r20.getHeight()) goto L129;
        r20.setHeight(r21);
    L129:
        if (this.c.x == true) goto L133;
        if (r21 == r20.getWidth()) goto L133;
        r20.setWidth(r21);
        goto L133
    L110:
        if (r17.X() == false) goto L112;
        r5.a = new c(this);
        goto L112
    L63:
        if (((com.lynx.tasm.behavior.ui.view.a) r5.getView()).getParent() == null) goto L65;
        ((ViewGroup) ((com.lynx.tasm.behavior.ui.view.a) r5.getView()).getParent()).removeView(r5.getView());
    L65:
        H2(r10);
        r10.U3(r5);
        this.s.d(r10);
        goto L107
    L66:
        int r22 = UIList.L0;
        ListViewHolder.b r23 = r10.a;
        r23.a = 2;
        if (r5 != r23.b) goto L69;
        ((RecyclerView.ViewHolder) r10).itemView.requestLayout();
    L75:
        com.lynx.tasm.behavior.ui.list.a r24 = this.c.P;
        if (r24 == null) goto L107;
        UIList r25 = r24.a;
        if (r25 == null) goto L107;
        UIListAdapter r26 = r25.c;
        if (r26 == null) goto L107;
        if (r26.t == null) goto L107;
        int r27 = r25.T();
        int r28 = r24.a.U();
        if (r10.a.b == null) goto L107;
        if (r27 != (-1)) goto L88;
    L96:
        if (r28 == (-1)) goto L107;
        if (r10.getAdapterPosition() < r28) goto L107;
        if (r24.d(r24.b + r28) == false) goto L107;
        JavaOnlyArray r29 = r26.t;
        if (r29 == null) goto L105;
        r2 = true;
    L105:
        if (((true ^ r24.b(r29.getString(r24.b + r28))) & r2) == false) goto L107;
        r24.e(r28 + r24.b);
        goto L107
    L88:
        if (r10.getAdapterPosition() >= r27) goto L96;
        if (r24.d(r27 - r24.b) == false) goto L107;
        JavaOnlyArray r30 = r26.t;
        if (r30 == null) goto L107;
        if (r24.b(r30.getString(r27 - r24.b)) == true) goto L107;
        r24.e(r27 - r24.b);
        goto L107
    L69:
        if (r5.getView() != 0) goto L71;
    L73:
        H2(r10);
        r10.a.a = 2;
        r10.U3(r5);
        r5.requestLayout();
        ((RecyclerView.ViewHolder) r10).itemView.forceLayout();
        this.s.d(r10);
        goto L75
    L71:
        if (((com.lynx.tasm.behavior.ui.view.a) r5.getView()).getParent() == null) goto L73;
        ((ViewGroup) ((com.lynx.tasm.behavior.ui.view.a) r5.getView()).getParent()).removeView(r5.getView());
    L15:
        r4 = r4 + 1;
        goto L9
    L16:
        int r31 = 0;
    L18:
        if (r31 >= r1.d.size()) goto L25;
        r5 = (UIComponent) ListProtector.get(r1.d, r31);
        if (r5 == null) goto L24;
        if (r3.equals(r5.b) == false) goto L24;
        r1.d.remove(r5);
    L24:
        r31 = r31 + 1;
    L25:
        r5 = null;
        goto L27
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r9, int r10, List r11) {
        ListViewHolder r12 = (ListViewHolder) r9;
        if (r12 == null) goto L10;
        ListViewHolder.b r0 = r12.a;
        if (r0 == null) goto L10;
        if (r0.h != null) goto L10;
        r0.h = new com.lynx.tasm.behavior.ui.list.c(this);
    L10:
        if (this.d == false) goto L17;
        if (r11.isEmpty() == true) goto L15;
        r10 = ((Integer) ListProtector.get(r11, r11.size() - 1)).intValue();
    L15:
        y2(r12, Integer.valueOf(r10).intValue());
        return;
    L17:
        if (r11.isEmpty() == false) goto L20;
        G2(r12, r10);
        return;
    L20:
        if (r12.a.b == null) goto L26;
        long r6 = z2();
        Integer r13 = (Integer) ListProtector.get(r11, r11.size() - 1);
        this.b.put(Long.valueOf(r6), r12);
        this.s.a(r12);
        ListViewHolder.b r1 = r12.a;
        r1.a = 1;
        UIList r2 = this.c;
        UIComponent r3 = r1.b;
        int r5 = r13.intValue();
        g r14 = r2.a;
        l r4 = (l) r14;
        r4.i(r2.getSign(), r3.getSign(), r5, r6);
        this.s.c(r12);
        J2(r12, r10);
        return;
    }
}
