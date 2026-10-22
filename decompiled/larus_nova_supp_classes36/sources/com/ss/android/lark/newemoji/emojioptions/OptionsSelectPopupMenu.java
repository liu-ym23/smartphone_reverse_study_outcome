package com.ss.android.lark.newemoji.emojioptions;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import z5c.i3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class OptionsSelectPopupMenu<T> implements i {
    public static final Handler x = null;
    public final Context a;
    public final d<T> b;
    public T c;
    public final View d;
    public Function0<? extends IBinder> e;
    public boolean f;
    public boolean g;
    public View h;
    public boolean i;
    public boolean j;
    public int k;
    public float l;
    public float m;
    public final int n;
    public final Map<T, IntRange> o;
    public final Function0<Unit> p;
    public Function2<? super T, ? super SelectWay, Unit> q;
    public final Lazy r;
    public final Map<T, View> s;
    public final com.ss.android.lark.newemoji.emojioptions.b t;
    public final UDShadowLayout u;
    public final OptionsSelectPopupMenu<T>.e v;
    public final WindowManager w;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/newemoji/emojioptions/OptionsSelectPopupMenu$SelectWay;", "", "value", "Lcom/ss/android/lark/statistics/extensions/IParam;", "<init>", "(Ljava/lang/String;ILcom/ss/android/lark/statistics/extensions/IParam;)V", "getValue", "()Lcom/ss/android/lark/statistics/extensions/IParam;", "SLIDE", "CLICK", "lark-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum SelectWay extends Enum<SelectWay> {
        public static final SelectWay CLICK = null;
        public static final SelectWay SLIDE = null;
        public static final /* synthetic */ SelectWay[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final s5c.d value;

        public static EnumEntries<SelectWay> getEntries() {
            return b;
        }

        static {
            SelectWay r0 = new SelectWay("SLIDE", 0, i3.c);
            SLIDE = r0;
            SelectWay r1 = new SelectWay("CLICK", 1, i3.d);
            CLICK = r1;
            SelectWay[] r2 = {r0, r1};
            a = r2;
            b = EnumEntriesKt.enumEntries(r2);
        }

        public static SelectWay[] values() {
            return (SelectWay[]) a.clone();
        }

        public final s5c.d getValue() {
            return this.value;
        }

        public static SelectWay valueOf(String r1) {
            return (SelectWay) r27.a.a(SelectWay.class, r1);
        }

        public SelectWay(String r1, int r2, s5c.a r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a {
    }

    public interface b {
    }

    public interface c<T> {
    }

    public interface d<T> {
        View a(T r1);
    }

    public final class e extends FrameLayout {
        public final /* synthetic */ OptionsSelectPopupMenu<T> a;

        @Override // android.view.ViewGroup, android.view.View
        public final boolean dispatchKeyEvent(KeyEvent r5) {
            boolean r0 = false;
            if (r5 != null) goto L5;
        L7:
            if (r0 == false) goto L15;
            if (r5.getAction() != 1) goto L15;
            OptionsSelectPopupMenu<T> r1 = this.a;
            if (r1.i == false) goto L15;
            r1.d(true);
            return true;
        L15:
            return super.dispatchKeyEvent(r5);
        L5:
            if (r5.getKeyCode() != 4) goto L7;
            r0 = true;
            goto L7
        }

        @Override // android.view.View
        public final boolean onTouchEvent(MotionEvent r5) {
            Intrinsics.checkNotNull(r5);
            int r0 = (int) r5.getX();
            int r1 = (int) r5.getY();
            if (r5.getAction() != 0) goto L12;
            if (r0 >= 0) goto L6;
        L10:
            this.a.d(true);
            return true;
        L6:
            if (r0 >= getWidth()) goto L10;
            if (r1 < 0) goto L10;
            if (r1 >= getHeight()) goto L10;
        L12:
            if (r5.getAction() != 4) goto L15;
            this.a.d(true);
            return true;
        L15:
            return super.onTouchEvent(r5);
        }

        public e(OptionsSelectPopupMenu r2, Context r3, UDShadowLayout r4) {
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r4, "child");
            this.a = r2;
            super(r3);
            addView(r4, -2, -2);
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ OptionsSelectPopupMenu<T> a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;

        public f(OptionsSelectPopupMenu<T> r1, int r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.f(this.b, this.c);     // Catch: Throwable -> L4
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
        x = new Handler(Looper.getMainLooper());
    }

    public final void e() {
        Iterator<Map.Entry<T, View>> r0 = this.s.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().getValue().setSelected(false);
        goto L4
    L6:
        View r1 = this.s.get(this.c);
        if (r1 == null) goto L11;
        r1.setSelected(true);
        return;
    }

    @Override // com.ss.android.lark.newemoji.emojioptions.i
    public final Context a() {
        return this.a;
    }

    public final int b(int r1) {
        return MathKt.roundToInt(c(r1));
    }

    public final float c(int r1) {
        return i.a.a(this, r1);
    }

    public final void d(boolean r3) {
        if (this.i == true) goto L5;
        return;
    L5:
        this.w.removeView(this.v);
        this.i = false;
        this.p.invoke();
        if (r3 == false) goto L8;
        return;
    L8:
        if (this.j == false) goto L10;
        SelectWay r4 = SelectWay.SLIDE;
    L11:
        this.q.invoke(this.c, r4);
        return;
    L10:
        r4 = SelectWay.CLICK;
        goto L11
    }

    public final void f(int r4, int r5) {
        if (this.g == false) goto L5;
        int r0 = 2;
    L6:
        WindowManager.LayoutParams r1 = new WindowManager.LayoutParams(r0);
        r1.width = -2;
        r1.height = -2;
        r1.flags = (r1.flags | 262144) | 32;
        r1.format = -3;
        r1.x = r4;
        if (this.g == false) goto L9;
        int r2 = r5 - ((Number) this.r.getValue()).intValue();
    L10:
        r1.y = r2;
        r1.gravity = 51;
        if ((this.a instanceof Activity) == true) goto L24;
        Log.i("OptionsPopupMenu", "showAtLocation: current context is not activity, trying to get window token");
        r1.token = (IBinder) this.e.invoke();
    L24:
    L21:
        e = move-exception;
        Log.e("OptionsPopupMenu", "showAtLocation: " + e.getMessage());
        return;
    L14:
        if (this.v.isAttachedToWindow() == false) goto L19;
        this.w.removeViewImmediate(this.v);     // Catch: Exception -> L21
        View r3 = this.h;     // Catch: Exception -> L21
        if (r3 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("targetView");     // Catch: Exception -> L21
        r3 = null;
    L18:
        r3.post(new f(this, r4, r5));     // Catch: Exception -> L21
        return;
    L19:
        WindowManager r6 = this.w;     // Catch: Exception -> L21
        OptionsSelectPopupMenu<T>.e r7 = this.v;     // Catch: Exception -> L21
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r7, r1);     // Catch: Exception -> L21
        r6.addView(r7, r1);     // Catch: Exception -> L21
        return;
    L9:
        r2 = r5;
        goto L10
    L5:
        r0 = AudioViewModel.ASR_SESSION_IDLE;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OptionsSelectPopupMenu(Context r5, com.ss.android.lark.newemoji.emojioptions.a r6, Object r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "optionAdapter");
        this.a = r5;
        this.b = r6;
        this.c = r7;
        this.d = null;
        this.e = OptionsSelectPopupMenu$windowTokenProvider$1.INSTANCE;
        this.n = ViewConfiguration.get(r5).getScaledTouchSlop();
        this.o = new LinkedHashMap();
        this.p = OptionsSelectPopupMenu$onCloseHandler$1.INSTANCE;
        this.q = OptionsSelectPopupMenu$onSelectHandler$1.INSTANCE;
        this.r = LazyKt.lazy(LazyThreadSafetyMode.NONE, new OptionsSelectPopupMenu$statusBarHeight$2(this));
        Collection<String> r8 = r6.b;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r10 = r8.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        T r11 = r10.next();
        View r1 = this.b.a(r11);
        FrameLayout r2 = new FrameLayout(this.a);
        r2.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r2.setBackgroundResource(2131232139);
        int r0 = b(4);
        r2.setPadding(r0, r0, r0, r0);
        r2.addView(r1);
        r2.setOnClickListener(new h(this, r11));
        r9.add(TuplesKt.to(r11, r2));
        goto L4
    L6:
        Map<T, View> r12 = MapsKt.toMap(r9);
        this.s = r12;
        com.ss.android.lark.newemoji.emojioptions.b r13 = new com.ss.android.lark.newemoji.emojioptions.b(this.a);
        r13.setOrientation(0);
        int r14 = MathKt.roundToInt(i.a.a(r13, 6));
        r13.setPadding(r14, r14, r14, r14);
        Iterator<Map.Entry<T, View>> r15 = r12.entrySet().iterator();
    L8:
        if (r15.hasNext() == false) goto L10;
        r13.addView(r15.next().getValue());
        goto L8
    L10:
        this.t = r13;
        UDShadowLayout r16 = new UDShadowLayout(this.a);
        r16.c(2131953882);
        r16.addView(r13, new UDShadowLayout.LayoutParams(-2, -2));
        this.u = r16;
        OptionsSelectPopupMenu<T>.e r17 = new e(this, this.a, r16);
        this.v = r17;
        Object r18 = this.a.getSystemService("window");
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager r19 = (WindowManager) r18;
        this.w = r19;
        e();
        int r3 = View.MeasureSpec.makeMeasureSpec(1073741823, Target.SIZE_ORIGINAL);
        r16.measure(r3, r3);
        this.k = r19.getDefaultDisplay().getOrientation();
        r17.addOnLayoutChangeListener(new com.ss.android.lark.newemoji.emojioptions.d(this));
        Resources r20 = this.a.getResources();
        int r21 = WindowDisplayMetricsOverride.apply(r20, r20.getDisplayMetrics()).widthPixels;
    }
}
