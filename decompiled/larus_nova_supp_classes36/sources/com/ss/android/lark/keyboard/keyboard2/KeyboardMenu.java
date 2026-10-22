package com.ss.android.lark.keyboard.keyboard2;

import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.larksuite.framework.utils.UIUtils;
import com.larksuite.framework.utils.g0;
import com.ss.android.lark.keyboard.editor.input.interceptor.ChatEditorMenuLayoutManager;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioKBPlugin;
import com.ss.android.lark.keyboard.widget.KBMenuContainerView;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.utils.CarUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class KeyboardMenu implements com.ss.android.lark.keyboard.keyboard2.d, com.ss.android.lark.keyboard.keyboard2.e {
    public static final /* synthetic */ int o = 0;
    public final Context a;
    public com.ss.android.lark.keyboard.b b;
    public final List<com.ss.android.lark.keyboard.keyboard2.e> c;
    public final Map<KeyboardMenuItemKey, b> d;
    public boolean e;
    public final View f;
    public final KBMenuContainerView g;
    public g h;
    public int i;
    public b j;
    public boolean k;
    public boolean l;
    public final LinkedList<Function0<Unit>> m;
    public final d n;

    public static final class a {
    }

    public static final class b {
        public final m a;
        public View b;
        public View c;
        public View d;
        public boolean e;
        public boolean f;

        public b(m r2) {
            Intrinsics.checkNotNullParameter(r2, "menuItem");
            this.a = r2;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PanelMenuItem.InitialStrategy.values().length];
            r0[PanelMenuItem.InitialStrategy.Immediate.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[PanelMenuItem.InitialStrategy.Idle.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class d implements MessageQueue.IdleHandler {
        public final /* synthetic */ KeyboardMenu a;

        public d(KeyboardMenu r1) {
            this.a = r1;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
        L3:
            if ((!this.a.m.isEmpty()) == false) goto L7;
            Function0<Unit> r0 = this.a.m.pollLast();
            if (r0 == null) goto L3;
            r0.invoke();
            goto L3
        L7:
            this.a.l = false;
            return false;
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ KeyboardMenu a;
        public final /* synthetic */ b b;

        public e(KeyboardMenu r1, b r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.v(this.b);
        }
    }

    public static final class f implements i.b {
        public final /* synthetic */ KeyboardMenu a;
        public final /* synthetic */ b b;
        public final /* synthetic */ AppCompatImageView c;

        @Override // com.ss.android.lark.keyboard.keyboard2.i.b
        public final f a() {
            this.c.setOnClickListener(null);
            return this;
        }

        @Override // com.ss.android.lark.keyboard.keyboard2.i.a
        public final void performClick() {
            this.a.v(this.b);
        }

        public f(KeyboardMenu r1, b r2, AppCompatImageView r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void d() {
        this.e = true;
        Iterator r0 = ((LinkedHashMap) this.d).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        e((b) ((Map.Entry) r0.next()).getValue());
        goto L4
    L6:
        r().z().v(this).d(new KeyboardMenu$bindToKeyboardWrapper$1(this));
        m();
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.e
    public final boolean u(m r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        return true;
    }

    public final boolean H() {
        b r0 = this.j;
        if (r0 != null) goto L6;
        return false;
    L6:
        J(r0);
        this.j = null;
        return true;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.d
    public final boolean h() {
        if (this.j != null) goto L6;
        return false;
    L6:
        return B(false);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void j() {
        this.m.clear();
        r().z().v(this).clear();
        Iterator r0 = ((LinkedHashMap) this.d).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        l((b) ((Map.Entry) r0.next()).getValue());
        goto L4
    L6:
        this.g.removeAllViews();
        this.i = 0;
        Looper.myQueue().removeIdleHandler(this.n);
        this.l = false;
        this.e = false;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.d
    public final m k() {
        b r0 = this.j;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.d
    public final void m() {
        if (this.e == true) goto L5;
        return;
    L5:
        Iterator r0 = ((LinkedHashMap) this.d).values().iterator();
    L6:
        View r3 = null;
        int r4 = 0;
        if (r0.hasNext() == false) goto L46;
        b r1 = (b) r0.next();
        List<com.ss.android.lark.keyboard.keyboard2.e> r6 = this.c;
        m r7 = r1.a;
        ArrayList r8 = (ArrayList) r6;
        Iterator r9 = r8.iterator();
    L9:
        boolean r10 = true;
        if (r9.hasNext() == false) goto L14;
        Object r11 = r9.next();
        if ((!((com.ss.android.lark.keyboard.keyboard2.e) r11).n(r7)) == false) goto L9;
    L15:
        if (r11 != null) goto L17;
        boolean r12 = true;
    L18:
        Iterator r13 = r8.iterator();
    L20:
        if (r13.hasNext() == false) goto L24;
        Object r14 = r13.next();
        if ((!((com.ss.android.lark.keyboard.keyboard2.e) r14).u(r7)) == false) goto L20;
    L25:
        if (r14 == null) goto L29;
        r10 = false;
    L29:
        if (r12 == r1.f) goto L32;
        r7.w(r12);
    L32:
        if (r10 == r1.e) goto L34;
        r7.y(r10);
    L34:
        View r15 = r1.b;
        if (r15 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("iconWrapper");
        r15 = null;
    L38:
        if (r10 == true) goto L41;
        r4 = 8;
    L41:
        r15.setVisibility(r4);
        View r2 = r1.c;
        if (r2 == null) goto L44;
        r3 = r2;
    L45:
        r3.setEnabled(r12);
        r1.f = r12;
        r1.e = r10;
        goto L6
    L44:
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        goto L45
    L24:
        r14 = null;
        goto L25
    L17:
        r12 = false;
        goto L18
    L14:
        r11 = null;
        goto L15
    L46:
        g r5 = this.h;
        Collection r16 = ((LinkedHashMap) this.d).values();
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator r18 = r16.iterator();
    L48:
        if (r18.hasNext() == false) goto L50;
        r17.add(((b) r18.next()).a);
        goto L48
    L50:
        List<m> r19 = r5.a(r17);
        Iterator<T> r20 = r19.iterator();
        int r21 = 0;
    L52:
        if (r20.hasNext() == false) goto L55;
        r21 = (r21 * 31) + ((m) r20.next()).g().hashCode();
        goto L52
    L55:
        if (r21 == this.i) goto L72;
        this.i = r21;
        this.g.removeAllViews();
        ArrayList r22 = new ArrayList();
        Iterator<T> r23 = r19.iterator();
    L58:
        if (r23.hasNext() == false) goto L68;
        m r24 = (m) r23.next();
        b r25 = (b) ((LinkedHashMap) this.d).get(r24.g());
        if (r25 == null) goto L65;
        View r26 = r25.b;
        if (r26 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("iconWrapper");
    L66:
        if (r26 == null) goto L58;
        r22.add(r26);
    L65:
        r26 = null;
        goto L66
    L68:
        Iterator r27 = r22.iterator();
    L70:
        if (r27.hasNext() == false) goto L72;
        this.g.addView((View) r27.next());
    L72:
        ArrayList r28 = new ArrayList();
        int r29 = this.g.getChildCount();
    L73:
        if (r4 >= r29) goto L78;
        View r30 = this.g.getChildAt(r4);
        if (r30.getVisibility() == 8) goto L77;
        Intrinsics.checkNotNull(r30);
        r28.add(r30);
    L77:
        r4 = r4 + 1;
        goto L73
    L78:
        View r31 = (View) CollectionsKt.firstOrNull(r28);
        if (r31 == null) goto L102;
        int r32 = UIUtils.dp2px(r31.getContext(), 9.0f);
        g0.a(r31, r32, UIUtils.dp2px(r31.getContext(), 12.0f), r32, r32);
        return;
    }

    public final com.ss.android.lark.keyboard.b r() {
        com.ss.android.lark.keyboard.b r0 = this.b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("keyboard");
        return null;
    }

    public KeyboardMenu(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        this.a = r4;
        this.c = new ArrayList();
        this.d = new LinkedHashMap();
        View r5 = LayoutInflater.from(r4).inflate(2131561733, null, false);
        r5.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f = r5;
        this.g = (KBMenuContainerView) r5.findViewById(2131379937);
        g.a.getClass();
        this.h = g.a.c;
        this.k = true;
        this.m = new LinkedList();
        this.n = new d(this);
    }

    public static void J(b r2) {
        m r0 = r2.a;
        if ((r0 instanceof o) == true) goto L6;
        Log.e("keyboard", "selectItemInner: item is not selectable item, method return.");
        return;
    L6:
        ((o) r0).A(false);
        View r1 = r2.c;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r1 = null;
    L10:
        r1.setSelected(false);
        View r3 = r2.d;
        if (r3 == null) goto L14;
        r3.setVisibility(8);
        return;
    }

    public final boolean B(boolean r2) {
        b r0 = this.j;
        if (r0 != null) goto L7;
        Log.i("keyboard", "unSelectCurrentItem: current item is empty");
        return false;
    L7:
        if (r0.d == null) goto L19;
        com.ss.android.lark.keyboard.ime.a r1 = r().z();
        if (r2 == false) goto L13;
        if (r1.z() == false) goto L13;
    L17:
        return true;
    L13:
        if (r1.a() == true) goto L17;
        if (r1.B() == true) goto L17;
        H();
        goto L17
    L19:
        return H();
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.d
    public final void C(ChatEditorMenuLayoutManager.b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.g.setMenuLayoutManager(r2);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.d
    public final void G(m r4) {
        Intrinsics.checkNotNullParameter(r4, "item");
        if (CarUtils.a() == true) goto L5;
    L9:
        b r0 = new b(r4);
        this.d.put(r4.g(), r0);
        com.ss.android.lark.keyboard.b r1 = r();
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r4.a = r1;
        if (this.e == true) goto L12;
        return;
    L12:
        e(r0);
        m();
        return;
    L5:
        if (r4.g() != KeyboardMenuItemKey.Photo) goto L9;
        if (((v28.a) ClaymoreServiceLoader.loadFirst(v28.a.class)).enableSendImage() == true) goto L9;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.d
    public final void M(com.ss.android.lark.keyboard.keyboard2.e r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        ((ArrayList) this.c).add(r2);
    }

    public final void e(final b r7) {
        final m r0 = r7.a;
        com.ss.android.lark.keyboard.b r1 = r();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r0.a = r1;
        Context r2 = this.a;
        int r3 = r0.a();
        int r4 = r0.b();
        AppCompatImageView r5 = com.ss.android.lark.keyboard.utils.h.a(r2, -1, r3);
        if (r4 == (-1)) goto L5;
        r5.setImageTintList(UIUtils.getColorStateList(r2, r4));
        r5.setImageTintMode(PorterDuff.Mode.SRC_ATOP);
    L5:
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r7.c = r5;
        Intrinsics.checkNotNull(r5);
        FrameLayout r6 = new FrameLayout(this.a);
        r6.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        r6.addView(r5);
        int r8 = UIUtils.dp2px(r5.getContext(), 9.0f);
        g0.a(r5, r8, r8, r8, r8);
        Integer r9 = r0.q();
        if (r9 == null) goto L8;
        int r10 = r9.intValue();
        r6.setTag(2131388363, UIUtils.getString(this.a, r10));
    L8:
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r7.b = r6;
        if (r0.b == true) goto L12;
        r0.b = true;
        r0.u();
    L12:
        r5.setOnClickListener(new e(this, r7));
        r0.x(new i(r5, new f(this, r7, r5)));
        if ((r0 instanceof PanelMenuItem) == false) goto L25;
        PanelMenuItem r11 = (PanelMenuItem) r0;
        PanelMenuItem.InitialStrategy r12 = r11.C();
        int r13 = c.a[r12.ordinal()];
        if (r13 != 1) goto L17;
        g(r11, r7);
        return;
    L17:
        if (r13 != 2) goto L27;
        Function0<Unit> r14 = new KeyboardMenu$createMenuItem$4(this, r0, r7);
        this.m.add(r14);
        if (this.l == true) goto L28;
        this.l = true;
        Looper.myQueue().addIdleHandler(this.n);
        return;
    L28:
        return;
    L27:
        return;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.d
    public final void f(KeyboardMenuItemKey r4) {
        Intrinsics.checkNotNullParameter(r4, TabAppInfo.IMAGE_JSON_KEY);
        b r0 = (b) ((LinkedHashMap) this.d).get(r4);
        if (r0 != null) goto L7;
        Log.w("keyboard", "clickMenuItem: could not find menu item " + r4.ordinal());
        return;
    L7:
        if (r0.e == true) goto L9;
    L13:
        Log.w("keyboard", "clickMenuItem: item is not visible or is not visible, method return.");
        return;
    L9:
        if (r0.f == false) goto L13;
        v(r0);
    }

    public final void l(b r3) {
        m r0 = r3.a;
        if (r0.b == false) goto L6;
        r0.b = false;
        r0.v();
    L6:
        View r4 = r3.d;
        if (r4 == null) goto L10;
        r().z().getPanel().removeView(r4);
        return;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.e
    public final boolean n(m r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        return this.k;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.d
    public final void q(g.a.C0152a r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.h = r2;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void setKeyboard(com.ss.android.lark.keyboard.b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    public final void v(b r3) {
        m r0 = r3.a;
        if ((r0 instanceof o) == true) goto L7;
        r0.s();
        return;
    L7:
        if (Intrinsics.areEqual(r3, this.j) == false) goto L10;
        B(true);
        return;
    L10:
        y(r3);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.d
    public final boolean w(KeyboardMenuItemKey r5) {
        Intrinsics.checkNotNullParameter(r5, TabAppInfo.IMAGE_JSON_KEY);
        b r0 = (b) ((LinkedHashMap) this.d).get(r5);
        if (r0 != null) goto L7;
        Log.w("keyboard", "selectMenuItem: could not find menu item " + r5.ordinal());
        return false;
    L7:
        if (r0.e == true) goto L9;
    L17:
        Log.w("keyboard", "selectMenuItem: item is not visible or is not visible, method return.");
        return false;
    L9:
        if (r0.f == false) goto L17;
        if (Intrinsics.areEqual(r0, this.j) == false) goto L16;
        Log.i("keyboard", "selectMenuItem: item is selected , method return");
        return false;
    L16:
        return y(r0);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.d
    public final void x(AudioKBPlugin r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        b r3 = this.d.remove(r2.j);
        if (this.e == true) goto L5;
        return;
    L5:
        if (r3 == null) goto L8;
        l(r3);
        m();
        return;
    }

    public final boolean y(final b r8) {
        Log.i("keyboard", "selectItem: info is " + r8.a.g());
        m r0 = r8.a;
        if ((r0 instanceof PanelMenuItem) == false) goto L5;
        g((PanelMenuItem) r0, r8);
    L5:
        View r1 = r8.d;
        com.ss.android.lark.keyboard.ime.a r2 = r().z();
        boolean r3 = r2.B();
        if (r1 == null) goto L17;
        Log.i("keyboard", "selectItem: current item has panel, isPanelShow " + r3);
        H();
        if (r3 == false) goto L11;
        z(r8);
        return true;
    L11:
        Log.i("keyboard", "selectItem: request show panel");
        if (r2.e() == false) goto L15;
        z(r8);
        return true;
    L15:
        Log.w("keyboard", "selectItem: request show panel failed");
        return false;
    L17:
        if (r3 == false) goto L24;
        Log.i("keyboard", "selectItem: current item has no panel, but panel is shown, request show ime.");
        if (r2.z() == true) goto L22;
        Log.w("keyboard", "show ime failed");
        return false;
    L22:
        final b r4 = this.j;
        com.ss.android.lark.keyboard.ime.c r5 = r2.v(this);
        r5.b(new KeyboardMenu$selectItem$1$1(r8, this));
        r5.d(new KeyboardMenu$selectItem$1$2(r4, this));
        return true;
    L24:
        Log.i("keyboard", "selectItem: current item has no panel, panel is not shown, select now.");
        H();
        z(r8);
        return true;
    }

    public final void z(b r3) {
        m r0 = r3.a;
        if ((r0 instanceof o) == true) goto L6;
        Log.e("keyboard", "selectItemInner: item is not selectable item, method return.");
        return;
    L6:
        ((o) r0).A(true);
        this.j = r3;
        View r1 = r3.c;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r1 = null;
    L10:
        r1.setSelected(true);
        View r4 = r3.d;
        if (r4 == null) goto L14;
        r4.setVisibility(0);
        return;
    }

    public final void g(PanelMenuItem r7, b r8) {
        com.ss.android.lark.keyboard.ime.a r0 = r().z();
        ViewGroup r1 = r0.getPanel();
        View r2 = r8.d;
        boolean r3 = true;
        if (r2 != null) goto L5;
    L10:
        View r9 = r7.G(r1);
        if (r0.B() == false) goto L13;
        r9.setVisibility(8);
    L14:
        r8.d = r9;
        if (r1.indexOfChild(r9) != (-1)) goto L18;
        r3 = false;
    L18:
        if (r3 == true) goto L21;
        r1.addView(r9);
        return;
    L21:
        return;
    L13:
        r9.setVisibility(4);
        goto L14
    L5:
        if (r1.indexOfChild(r2) == (-1)) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == false) goto L10;
        return;
    L7:
        r4 = false;
        goto L8
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.d
    public final <T extends m> T i(KeyboardMenuItemKey r3, Class<T> r4) {
        Intrinsics.checkNotNullParameter(r3, TabAppInfo.IMAGE_JSON_KEY);
        Intrinsics.checkNotNullParameter(r4, "itemClass");
        b r5 = (b) ((LinkedHashMap) this.d).get(r3);
        if (r5 == null) goto L5;
        m r6 = r5.a;
    L6:
        if (r6 != null) goto L8;
    L11:
        return null;
    L8:
        if (r4.isInstance(r6) == false) goto L11;
        return r4.cast(r6);
    L5:
        r6 = null;
        goto L6
    }
}
