package pcb;

import android.R;
import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Handler;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import androidx.core.view.ViewCompat;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.ss.android.lark.edit.keyboard.producer.BaseKeyboardHeightProducer;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.utils.LarkContext;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import rcb.e;
import rcb.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements pcb.a {
    public final Activity a;
    public final com.ss.android.lark.edit.keyboard.producer.b b;
    public final qcb.a c;
    public int d;
    public int e;
    public BaseKeyboardHeightProducer.b f;
    public final CopyOnWriteArrayList<ocb.a> g;
    public final CopyOnWriteArrayList<ocb.a> h;
    public final d i;
    public final ViewOnAttachStateChangeListenerC0276b j;
    public final View k;

    public static final class a implements com.ss.android.lark.edit.keyboard.producer.b.InterfaceC0195b {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.edit.keyboard.producer.b.InterfaceC0195b
        public final void a(BaseKeyboardHeightProducer.b r7) {
            Intrinsics.checkNotNullParameter(r7, "keyboard");
            b r1 = this.a;
            r1.getClass();
            Intrinsics.checkNotNullParameter(r7, "keyboard");
            r1.f = r7;
            int r2 = r7.a;
            e.a(r1.i, 60);
            Log.i("InsetsBseKBH#Provider", "keyboard height provider notify: " + r2 + ", " + r1.e);
            Iterator<ocb.a> r3 = r1.h.iterator();
        L4:
            if (r3.hasNext() == false) goto L9;
            ocb.a r4 = r3.next();
            if (r4 == null) goto L4;
            r4.onKeyboardHeightChanged(r1, r2, r1.e);
            goto L4
        L9:
            if (r7.d == false) goto L26;
            int r8 = r1.e;
            if (r8 != 2) goto L13;
            int r5 = 200;
        L14:
            if (r2 <= r5) goto L27;
            r1.c.getClass();
            com.ss.android.lark.storage.a r6 = qcb.b.a;
            com.ss.android.lark.storage.kv.repo.a r0 = LarkKVStorage.f(qcb.b.a, "keyboard", new n6c.b(LarkContext.getApplication().getSharedPreferences("keyboard", 0)));
            if (r8 != 2) goto L18;
            String r9 = "landscape_kh";
        L19:
            Log.d("InsetsBaseKBH#Saver", "saveKeyboardHeight to sp (" + r9 + " : " + r2 + ')');
            r0.putInt(r9, r2);
            return;
        L18:
            r9 = "portrait_kh";
            goto L19
        L27:
            return;
        L13:
            r5 = 250;
            goto L14
        }
    }

    /* JADX INFO: renamed from: pcb.b$b, reason: collision with other inner class name */
    public static final class ViewOnAttachStateChangeListenerC0276b implements View.OnAttachStateChangeListener {
        public final /* synthetic */ b a;

        public ViewOnAttachStateChangeListenerC0276b(b r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            Log.d("InsetsBseKBH#Provider", "onViewAttachedToWindow");
            this.a.b.c();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r6) {
            Intrinsics.checkNotNullParameter(r6, "v");
            Log.d("InsetsBseKBH#Provider", "onViewDetachedFromWindow");
            b r0 = this.a;
            d r1 = r0.i;
            Handler r2 = e.a;
            r2.removeCallbacks(r1);
            com.ss.android.lark.edit.keyboard.producer.b r3 = r0.b;
            r3.getClass();
            Log.i("InsetsKBH#Producer", "close");
            r2.removeCallbacks(r3.n);
            r2.removeCallbacks(r3.o);
            ViewGroup r4 = r3.b;
            if (r4 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("mPopupView");
            r4 = null;
        L6:
            ViewCompat.setOnApplyWindowInsetsListener(r4.getRootView(), null);
            PopupWindow r5 = r3.a();
            PopupWindowLancet.handleDismissBeforeOrigin(r5);
            r5.dismiss();
            Activity r7 = r3.a;
            SparseArray<pcb.a.AbstractC0275a> r8 = ocb.b.a;
            Log.i("InsetsBseKBH#Provider", "remove cache " + r7.getClass().getName() + r7.hashCode() + " from keyboardHeightProviders");
            ocb.b.b.remove(r7.hashCode());
            r0.f = null;
            r0.g.clear();
            r0.h.clear();
            r0.k.removeOnAttachStateChangeListener(r0.j);
        }
    }

    public static final class c {
    }

    public static final class d implements Runnable {
        public final /* synthetic */ b a;

        public d(b r1) {
            this.a = r1;
        }

        public final void a() {
            if (this.a.getActivity().isDestroyed() == false) goto L5;
        L18:
            Log.i("InsetsBseKBH#Provider", "mNotifyKHChangedTask err = activity isDestroyed or isFinishing");
            return;
        L5:
            if (this.a.getActivity().isFinishing() == true) goto L18;
            BaseKeyboardHeightProducer.b r0 = this.a.f;
            if (r0 == null) goto L10;
            int r1 = r0.a;
        L11:
            Log.i("InsetsBseKBH#Provider", "mNotifyKHChangedTask run imeHeight = " + r1);
            b r2 = this.a;
            r2.getClass();
            Log.i("InsetsBseKBH#Provider", "keyboard height provider notify: " + r1 + ", " + r2.e);
            Iterator<ocb.a> r3 = r2.g.iterator();
        L13:
            if (r3.hasNext() == false) goto L17;
            ocb.a r4 = r3.next();
            if (r4 == null) goto L13;
            r4.onKeyboardHeightChanged(r2, r1, r2.e);
            goto L13
        L17:
            return;
        L10:
            r1 = 0;
            goto L11
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // pcb.a
    public final int getKeyboardTop() {
        com.ss.android.lark.edit.keyboard.producer.b r0 = this.b;
        r0.getClass();
        Rect r1 = new Rect();
        ViewGroup r2 = r0.b;
        if (r2 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mPopupView");
        r2 = null;
    L6:
        r2.getWindowVisibleDisplayFrame(r1);
        return r1.bottom;
    }

    @Override // pcb.a
    public final int getVisibleKeyboardHeight() {
        BaseKeyboardHeightProducer.b r0 = this.f;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.a;
    }

    @Override // pcb.a
    public final boolean isKeyboardShowing() {
        BaseKeyboardHeightProducer.b r0 = this.f;
        if (r0 == null) goto L10;
        if (r0 == null) goto L6;
        int r1 = r0.a;
    L7:
        if (r1 <= 0) goto L11;
        return true;
    L11:
        return false;
    L6:
        r1 = 0;
        goto L7
    L10:
        return false;
    }

    @Override // pcb.a
    public final int keyBoardRawHeight() {
        return keyBoardRawHeightWithOrientation(this.e);
    }

    @Override // pcb.a
    public final void restart() {
        com.ss.android.lark.edit.keyboard.producer.b r0 = this.b;
        if (r0.e.isAttachedToWindow() == true) goto L6;
        return;
    L6:
        if (r0.a().isShowing() == true) goto L9;
        r0.c();
        return;
    }

    public final Activity getActivity() {
        return this.a;
    }

    public b(Activity r9) {
        Intrinsics.checkNotNullParameter(r9, "activity");
        this.a = r9;
        qcb.a r0 = new qcb.a(r9);
        this.c = r0;
        this.e = 1;
        this.g = new CopyOnWriteArrayList();
        this.h = new CopyOnWriteArrayList();
        this.i = new d(this);
        this.d = rcb.a.a(r9);
        Intrinsics.checkNotNullParameter(r9, "mActivity");
        View r2 = r9.findViewById(R.id.content);
        this.k = r2;
        com.ss.android.lark.edit.keyboard.producer.b r3 = new com.ss.android.lark.edit.keyboard.producer.b(r9, r2, new a(this));
        this.b = r3;
        Activity r4 = r3.a;
        Intrinsics.checkNotNullParameter(r4, "context");
        LinearLayout r5 = new LinearLayout(r4);
        r5.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        r5.setOrientation(1);
        r5.setBackgroundColor(r4.getResources().getColor(R.color.transparent));
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r3.b = r5;
        Configuration r1 = f.a;
        Configuration r6 = r3.a.getResources().getConfiguration();
        Log.i("WindowModeUtils", "newConfiguration: " + r6);
        f.a = r6;
        if (r3.e.isAttachedToWindow() == false) goto L5;
        r3.c();
    L5:
        r0.b = this.d;
        this.e = r9.getResources().getConfiguration().orientation;
        ViewOnAttachStateChangeListenerC0276b r10 = new ViewOnAttachStateChangeListenerC0276b(this);
        this.j = r10;
        r2.addOnAttachStateChangeListener(r10);
    }

    @Override // pcb.a
    public final void a(ocb.a r2) {
        this.g.remove(r2);
    }

    @Override // pcb.a
    public final void b(ocb.a r2) {
        this.h.remove(r2);
    }

    @Override // pcb.a
    public final void c(ocb.a r2) {
        if (this.g.contains(r2) == true) goto L6;
        this.g.add(r2);
        return;
    }

    @Override // pcb.a
    public final void d(ocb.a r2) {
        if (this.h.contains(r2) == true) goto L6;
        this.h.add(r2);
        return;
    }

    @Override // pcb.a
    public final int keyBoardRawHeightWithOrientation(int r11) {
        qcb.a r0 = this.c;
        r0.getClass();
        com.ss.android.lark.storage.a r1 = qcb.b.a;
        com.ss.android.lark.storage.kv.repo.a r2 = LarkKVStorage.f(qcb.b.a, "keyboard", new n6c.b(LarkContext.getApplication().getSharedPreferences("keyboard", 0)));
        if (r11 != 2) goto L5;
        String r12 = "landscape_kh";
    L6:
        int r3 = r2.getInt(r12, 0);
        Log.i("InsetsBaseKBH#Saver", "loadKeyboardHeight from sp (" + r12 + " : " + r3 + ')');
        double r6 = (double) r0.b;
        if (r3 >= ((int) (0.2d * r6))) goto L10;
        r3 = (int) (r6 * 0.25d);
        Log.i("InsetsBaseKBH#Saver", "loadKeyboardHeight from cal : (" + r12 + " : " + r3 + ')');
    L10:
        if (r3 <= 1) goto L12;
        return r3;
    L12:
        if (f.b() == true) goto L14;
        return r3;
    L14:
        return (int) (((double) this.d) * 0.3d);
    L5:
        r12 = "portrait_kh";
        goto L6
    }

    @Override // pcb.a
    public final void setDelayedDuration(Long r2) {
        this.b.d = r2;
    }

    @Override // pcb.a
    public final void onConfigurationChanged(Configuration r5, boolean r6) {
        com.ss.android.lark.edit.keyboard.producer.b r0 = this.b;
        r0.getClass();
        Log.i("BaseBaseKBH#Producer", "configurationChanged : ");
        Configuration r1 = f.a;
        Log.i("WindowModeUtils", "newConfiguration: " + r5);
        f.a = r5;
        r0.j = r6;
        int r7 = 1;
        r0.i = true;
        e.a(r0.n, 1000);
        if (r0.e.isAttachedToWindow() == true) goto L6;
    L8:
        int r2 = rcb.a.a(this.a);
        this.d = r2;
        this.c.b = r2;
        if (r5 == null) goto L11;
        r7 = r5.orientation;
    L11:
        this.e = r7;
        return;
    L6:
        if (r0.a().isShowing() == true) goto L8;
        r0.c();
        goto L8
    }
}
