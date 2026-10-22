package androidx.appcompat.app;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationManager;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.view.menu.ExpandedMenuView;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.a0;
import androidx.appcompat.widget.a1;
import androidx.appcompat.widget.b0;
import androidx.appcompat.widget.b1;
import androidx.appcompat.widget.l0;
import androidx.appcompat.widget.v0;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.aikernel.core.data.IdlErrors;
import com.obric.cae.cloud.CloudServiceConstants;
import com.obric.cae.location.database.StarLocationDbManager;
import com.obric.cae.smartNetwork.AppQoEManager.AIMediaEventSchema;
import com.obric.cae.smartNetwork.netAccel.AccelMetric;
import com.obric.cae.userAware.WifiScanStateMachine;
import com.ttnet.org.chromium.base.TimeUtils;
import j0.h0;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class AppCompatDelegateImpl extends androidx.appcompat.app.h implements androidx.appcompat.view.menu.f.a, LayoutInflater.Factory2 {

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final n.h<String, Integer> f573s0 = null;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final int[] f574t0 = null;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final boolean f575u0 = false;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final boolean f576v0 = false;
    public CharSequence A;
    public b0 B;
    public d C;
    public m D;
    public g.b E;
    public ActionBarContextView F;
    public PopupWindow G;
    public androidx.appcompat.app.k H;
    public h0 I;
    public final boolean J;
    public boolean K;
    public ViewGroup L;
    public TextView M;
    public View N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public boolean U;
    public boolean V;
    public PanelFeatureState[] W;
    public PanelFeatureState X;
    public boolean Y;
    public boolean Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f577a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f578b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public Configuration f579c0;
    public final int d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f580e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public int f581f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public boolean f582g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public k f583h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public i f584i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public boolean f585j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public int f586k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public final a f587l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public boolean f588m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public Rect f589n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public Rect f590o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public p f591p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public OnBackInvokedDispatcher f592q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public OnBackInvokedCallback f593r0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Object f594t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Context f595u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Window f596v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public h f597w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final androidx.appcompat.app.f f598x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public androidx.appcompat.app.a f599y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public g.g f600z;

    public static final class PanelFeatureState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f601a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f602b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f603c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f604d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public l f605e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View f606f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public View f607g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public androidx.appcompat.view.menu.f f608h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public androidx.appcompat.view.menu.d f609i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public g.d f610j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f611k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f612l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f613m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f614n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f615o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public Bundle f616p;

        @SuppressLint({"BanParcelableUsage"})
        public static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f617a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public boolean f618b;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public Bundle f619m;

            public class a implements Parcelable.ClassLoaderCreator<SavedState> {
                @Override // android.os.Parcelable.Creator
                public final Object createFromParcel(Parcel r8) {
                    return SavedState.t(r8, null);
                }

                @Override // android.os.Parcelable.Creator
                public final Object[] newArray(int r8) {
                    return new SavedState[r8];
                }

                @Override // android.os.Parcelable.ClassLoaderCreator
                public final SavedState createFromParcel(Parcel r8, ClassLoader r10) {
                    return SavedState.t(r8, r10);
                }
            }

            static {
                CREATOR = new a();
            }

            public SavedState() {
            }

            public static SavedState t(Parcel r8, ClassLoader r10) {
                SavedState r11 = new SavedState();
                r11.f617a = r8.readInt();
                boolean r12 = true;
                if (r8.readInt() == 1) goto L6;
                r12 = false;
            L6:
                r11.f618b = r12;
                if (r12 == false) goto L9;
                r11.f619m = r8.readBundle(r10);
            L9:
                return r11;
            }

            @Override // android.os.Parcelable
            public final int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public final void writeToParcel(Parcel r8, int r10) {
                r8.writeInt(this.f617a);
                r8.writeInt(this.f618b ? 1 : 0);
                if (this.f618b == false) goto L6;
                r8.writeBundle(this.f619m);
                return;
            }
        }

        public PanelFeatureState(int r8) {
            this.f601a = r8;
            this.f614n = false;
        }

        public final boolean a() {
            if (this.f606f != null) goto L6;
            return false;
        L6:
            if (this.f607g == null) goto L9;
            return true;
        L9:
            if (this.f609i.i().getCount() > 0) goto L11;
            return false;
        L11:
            return true;
        }
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppCompatDelegateImpl f620a;

        public a(AppCompatDelegateImpl r8) {
            this.f620a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AppCompatDelegateImpl r8 = this.f620a;
            if ((r8.f586k0 & 1) == 0) goto L6;
            r8.M(0);
        L6:
            if ((r8.f586k0 & 4096) == 0) goto L8;
            r8.M(108);
        L8:
            r8.f585j0 = false;
            r8.f586k0 = 0;
        }
    }

    public class b implements androidx.appcompat.app.b {
    }

    public interface c {
    }

    public final class d implements androidx.appcompat.view.menu.j.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppCompatDelegateImpl f621a;

        public d(AppCompatDelegateImpl r8) {
            this.f621a = r8;
        }

        @Override // androidx.appcompat.view.menu.j.a
        public final void a(androidx.appcompat.view.menu.f r8, boolean r10) {
            this.f621a.I(r8);
        }

        @Override // androidx.appcompat.view.menu.j.a
        public final boolean b(androidx.appcompat.view.menu.f r8) {
            Window.Callback r10 = this.f621a.R();
            if (r10 == null) goto L7;
            r10.onMenuOpened(108, r8);
            return true;
        L7:
            return true;
        }
    }

    public class e implements g.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g.b.a f622a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AppCompatDelegateImpl f623b;

        public class a extends t2.b {
            public final /* synthetic */ e H;

            public a(e r8) {
                this.H = r8;
            }

            @Override // j0.i0
            public final void d() {
                e r8 = this.H;
                r8.f623b.F.setVisibility(8);
                AppCompatDelegateImpl r10 = r8.f623b;
                PopupWindow r11 = r10.G;
                if (r11 == null) goto L6;
                r11.dismiss();
            L8:
                r10.F.h();
                r10.I.d(null);
                r10.I = null;
                ViewGroup r12 = r10.L;
                WeakHashMap<View, h0> r13 = j0.w.f8437a;
                j0.w.h.c(r12);
                return;
            L6:
                if ((r10.F.getParent() instanceof View) == false) goto L8;
                View r14 = (View) r10.F.getParent();
                WeakHashMap<View, h0> r15 = j0.w.f8437a;
                j0.w.h.c(r14);
                goto L8
            }
        }

        public e(AppCompatDelegateImpl r8, g.b.a r10) {
            this.f623b = r8;
            this.f622a = r10;
        }

        @Override // g.b.a
        public final boolean a(g.b r8, MenuItem r10) {
            return this.f622a.a(r8, r10);
        }

        @Override // g.b.a
        public final void b(g.b r8) {
            this.f622a.b(r8);
            AppCompatDelegateImpl r10 = this.f623b;
            if (r10.G == null) goto L6;
            r10.f596v.getDecorView().removeCallbacks(r10.H);
        L6:
            if (r10.F == null) goto L11;
            h0 r11 = r10.I;
            if (r11 == null) goto L10;
            r11.b();
        L10:
            h0 r12 = j0.w.a(r10.F);
            r12.a(0.0f);
            r10.I = r12;
            r12.d(new a(this));
        L11:
            androidx.appcompat.app.f r13 = r10.f598x;
            if (r13 == null) goto L14;
            r13.onSupportActionModeFinished(r10.E);
        L14:
            r10.E = null;
            ViewGroup r14 = r10.L;
            WeakHashMap<View, h0> r15 = j0.w.f8437a;
            j0.w.h.c(r14);
            r10.Z();
        }

        @Override // g.b.a
        public final boolean c(g.b r8, androidx.appcompat.view.menu.f r10) {
            return this.f622a.c(r8, r10);
        }

        @Override // g.b.a
        public final boolean d(g.b r8, androidx.appcompat.view.menu.f r10) {
            ViewGroup r11 = this.f623b.L;
            WeakHashMap<View, h0> r12 = j0.w.f8437a;
            j0.w.h.c(r11);
            return this.f622a.d(r8, r10);
        }
    }

    public static class f {
        public static void a(Configuration r8, Configuration r10, Configuration r11) {
            LocaleList r12 = r8.getLocales();
            LocaleList r13 = r10.getLocales();
            if (r12.equals(r13) == true) goto L6;
            r11.setLocales(r13);
            r11.locale = r10.locale;
            return;
        }

        public static f0.e b(Configuration r8) {
            return f0.e.a(r8.getLocales().toLanguageTags());
        }

        public static void c(f0.e r8) {
            LocaleList.setDefault(LocaleList.forLanguageTags(r8.f7237a.a()));
        }

        public static void d(Configuration r8, f0.e r10) {
            r8.setLocales(LocaleList.forLanguageTags(r10.f7237a.a()));
        }
    }

    public static class g {
        public static OnBackInvokedDispatcher a(Activity r8) {
            return r8.getOnBackInvokedDispatcher();
        }

        public static OnBackInvokedCallback b(Object r8, AppCompatDelegateImpl r10) {
            Objects.requireNonNull(r10);
            androidx.appcompat.app.m r11 = new androidx.appcompat.app.m(r10, 0);
            ((OnBackInvokedDispatcher) r8).registerOnBackInvokedCallback(TimeUtils.NANOSECONDS_PER_MILLISECOND, r11);
            return r11;
        }

        public static void c(Object r8, Object r10) {
            OnBackInvokedDispatcher r11 = (OnBackInvokedDispatcher) r8;
            r11.unregisterOnBackInvokedCallback((OnBackInvokedCallback) r10);
        }
    }

    public class h extends g.i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c f624b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f625m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f626n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f627o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ AppCompatDelegateImpl f628p;

        public h(AppCompatDelegateImpl r8, Window.Callback r10) {
            this.f628p = r8;
            super(r10);
        }

        public final boolean a(Window.Callback r8, KeyEvent r10) {
            this.f626n = true;     // Catch: Throwable -> L6
            boolean r11 = r8.dispatchKeyEvent(r10);     // Catch: Throwable -> L6
            this.f626n = false;
            return r11;
        L6:
            th = move-exception;
            this.f626n = false;
            throw th;
        }

        public final void b(Window.Callback r8) {
            this.f625m = true;     // Catch: Throwable -> L6
            r8.onContentChanged();     // Catch: Throwable -> L6
            this.f625m = false;
            return;
        L6:
            th = move-exception;
            this.f625m = false;
            throw th;
        }

        @Override // g.i, android.view.Window.Callback
        public final boolean dispatchKeyEvent(KeyEvent r8) {
            if (this.f626n == false) goto L7;
            return this.f7496a.dispatchKeyEvent(r8);
        L7:
            if (this.f628p.L(r8) == false) goto L9;
        L12:
            return true;
        L9:
            if (super.dispatchKeyEvent(r8) == true) goto L12;
            return false;
        }

        @Override // g.i, android.view.Window.Callback
        public final boolean dispatchKeyShortcutEvent(KeyEvent r8) {
            if (super.dispatchKeyShortcutEvent(r8) == true) goto L26;
            int r10 = r8.getKeyCode();
            AppCompatDelegateImpl r11 = this.f628p;
            r11.S();
            androidx.appcompat.app.a r12 = r11.f599y;
            if (r12 != null) goto L7;
        L9:
            PanelFeatureState r13 = r11.X;
            if (r13 == null) goto L17;
            if (r11.W(r13, r8.getKeyCode(), r8) == false) goto L17;
            PanelFeatureState r14 = r11.X;
            if (r14 == null) goto L20;
            r14.f612l = true;
        L20:
            boolean r15 = true;
        L22:
            if (r15 == false) goto L25;
            return true;
        L25:
            return false;
        L17:
            if (r11.X != null) goto L21;
            PanelFeatureState r16 = r11.Q(0);
            r11.X(r16, r8);
            boolean r17 = r11.W(r16, r8.getKeyCode(), r8);
            r16.f611k = false;
            if (r17 == true) goto L20;
        L21:
            r15 = false;
            goto L22
        L7:
            if (r12.i(r10, r8) == false) goto L9;
        L26:
            return true;
        }

        @Override // android.view.Window.Callback
        public final void onContentChanged() {
            if (this.f625m == false) goto L6;
            this.f7496a.onContentChanged();
            return;
        }

        @Override // g.i, android.view.Window.Callback
        public final boolean onCreatePanelMenu(int r8, Menu r10) {
            if (r8 != 0) goto L8;
            if ((r10 instanceof androidx.appcompat.view.menu.f) == true) goto L8;
            return false;
        L8:
            return super.onCreatePanelMenu(r8, r10);
        }

        @Override // g.i, android.view.Window.Callback
        public final View onCreatePanelView(int r8) {
            c r10 = this.f624b;
            if (r10 == null) goto L11;
            t.e r11 = (t.e) r10;
            if (r8 != 0) goto L7;
            View r12 = new View(r11.f695a.f682a.getContext());
        L8:
            if (r12 == null) goto L11;
            return r12;
        L7:
            r12 = null;
        L11:
            return super.onCreatePanelView(r8);
        }

        @Override // g.i, android.view.Window.Callback
        public final boolean onMenuOpened(int r8, Menu r10) {
            super.onMenuOpened(r8, r10);
            AppCompatDelegateImpl r11 = this.f628p;
            if (r8 != 108) goto L7;
            r11.S();
            androidx.appcompat.app.a r12 = r11.f599y;
            if (r12 == null) goto L8;
            r12.c(true);
        L8:
            return true;
        L7:
            r11.getClass();
            goto L8
        }

        @Override // g.i, android.view.Window.Callback
        public final void onPanelClosed(int r8, Menu r10) {
            if (this.f627o == false) goto L6;
            this.f7496a.onPanelClosed(r8, r10);
            return;
        L6:
            super.onPanelClosed(r8, r10);
            AppCompatDelegateImpl r11 = this.f628p;
            if (r8 != 108) goto L11;
            r11.S();
            androidx.appcompat.app.a r12 = r11.f599y;
            if (r12 == null) goto L17;
            r12.c(false);
            return;
        L17:
            return;
        L11:
            if (r8 != 0) goto L15;
            PanelFeatureState r13 = r11.Q(r8);
            if (r13.f613m == false) goto L19;
            r11.J(r13, false);
            return;
        L19:
            return;
        L15:
            r11.getClass();
        }

        @Override // g.i, android.view.Window.Callback
        public final boolean onPreparePanel(int r8, View r10, Menu r11) {
            if ((r11 instanceof androidx.appcompat.view.menu.f) == false) goto L5;
            androidx.appcompat.view.menu.f r12 = (androidx.appcompat.view.menu.f) r11;
        L7:
            if (r8 != 0) goto L11;
            if (r12 != null) goto L11;
            return false;
        L11:
            if (r12 == null) goto L13;
            r12.f839y = true;
        L13:
            c r13 = this.f624b;
            if (r13 == null) goto L20;
            t.e r14 = (t.e) r13;
            if (r8 != 0) goto L20;
            t r15 = r14.f695a;
            if (r15.f685d == true) goto L20;
            r15.f682a.f1311m = true;
            r15.f685d = true;
        L20:
            boolean r16 = super.onPreparePanel(r8, r10, r11);
            if (r12 == null) goto L23;
            r12.f839y = false;
        L23:
            return r16;
        L5:
            r12 = null;
            goto L7
        }

        @Override // g.i, android.view.Window.Callback
        public final void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> r8, Menu r10, int r11) {
            androidx.appcompat.view.menu.f r12 = this.f628p.Q(0).f608h;
            if (r12 == null) goto L5;
            super.onProvideKeyboardShortcuts(r8, r12, r11);
            return;
        L5:
            super.onProvideKeyboardShortcuts(r8, r10, r11);
        }

        @Override // android.view.Window.Callback
        public final ActionMode onWindowStartingActionMode(ActionMode.Callback r8) {
            return null;
        }

        @Override // g.i, android.view.Window.Callback
        public final ActionMode onWindowStartingActionMode(ActionMode.Callback r8, int r10) {
            AppCompatDelegateImpl r11 = this.f628p;
            if (r11.J == false) goto L12;
            if (r10 != 0) goto L12;
            g.f.a r12 = new g.f.a(r11.f595u, r8);
            g.b r13 = r11.D(r12);
            if (r13 != null) goto L13;
            return null;
        L13:
            return r12.e(r13);
        L12:
            return super.onWindowStartingActionMode(r8, r10);
        }
    }

    public class i extends j {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final PowerManager f629c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AppCompatDelegateImpl f630d;

        public i(AppCompatDelegateImpl r8, Context r10) {
            this.f630d = r8;
            super(r8);
            this.f629c = (PowerManager) r10.getApplicationContext().getSystemService("power");
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.j
        public final IntentFilter b() {
            IntentFilter r8 = new IntentFilter();
            r8.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return r8;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.j
        public final int c() {
            if (this.f629c.isPowerSaveMode() == false) goto L5;
            return 2;
        L5:
            return 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.j
        public final void d() {
            this.f630d.E(true, true);
        }
    }

    public abstract class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a f631a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AppCompatDelegateImpl f632b;

        public class a extends BroadcastReceiver {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ j f633a;

            public a(j r8) {
                this.f633a = r8;
            }

            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context r8, Intent r10) {
                this.f633a.d();
            }
        }

        public j(AppCompatDelegateImpl r8) {
            this.f632b = r8;
        }

        public final void a() {
            a r8 = this.f631a;
            if (r8 == null) goto L10;
            this.f632b.f595u.unregisterReceiver(r8);     // Catch: IllegalArgumentException -> L7
        L5:
            this.f631a = null;
            return;
        }

        public abstract IntentFilter b();

        public abstract int c();

        public abstract void d();

        public final void e() {
            a();
            IntentFilter r8 = b();
            if (r8 != null) goto L5;
            return;
        L5:
            if (r8.countActions() != 0) goto L8;
            return;
        L8:
            if (this.f631a != null) goto L10;
            this.f631a = new a(this);
        L10:
            this.f632b.f595u.registerReceiver(this.f631a, r8);
        }
    }

    public class k extends j {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final v f634c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AppCompatDelegateImpl f635d;

        public k(AppCompatDelegateImpl r8, v r10) {
            this.f635d = r8;
            super(r8);
            this.f634c = r10;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.j
        public final IntentFilter b() {
            IntentFilter r8 = new IntentFilter();
            r8.addAction("android.intent.action.TIME_SET");
            r8.addAction("android.intent.action.TIMEZONE_CHANGED");
            r8.addAction("android.intent.action.TIME_TICK");
            return r8;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.j
        public final int c() {
            v r8 = this.f634c;
            v.a r10 = r8.f703c;
            boolean r11 = false;
            if (r10.f705b <= System.currentTimeMillis()) goto L5;
            boolean r12 = true;
        L6:
            if (r12 == false) goto L8;
            boolean r13 = r10.f704a;
        L64:
            if (r13 == false) goto L71;
            return 2;
        L71:
            return 1;
        L8:
            Context r14 = r8.f701a;
            int r15 = defpackage.c.z(r14, "android.permission.ACCESS_COARSE_LOCATION");
            Location r16 = null;
            LocationManager r17 = r8.f702b;
            if (r15 == 0) goto L67;
            Location r18 = null;
        L21:
            if (defpackage.c.z(r14, "android.permission.ACCESS_FINE_LOCATION") == 0) goto L69;
        L29:
            if (r16 == null) goto L34;
            if (r18 == null) goto L34;
            if (r16.getTime() > r18.getTime()) goto L35;
        L36:
            if (r18 == null) goto L58;
            long r19 = System.currentTimeMillis();
            if (u.f696d != null) goto L40;
            u.f696d = new u();
        L40:
            u r20 = u.f696d;
            r20.a(r18.getLatitude(), r18.getLongitude(), r19 - WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS);
            r20.a(r18.getLatitude(), r18.getLongitude(), r19);
            if (r20.f699c != 1) goto L43;
            r11 = true;
        L43:
            long r110 = r20.f698b;
            long r111 = r20.f697a;
            r20.a(r18.getLatitude(), r18.getLongitude(), WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS + r19);
            long r21 = r20.f698b;
            if (r110 != (-1)) goto L46;
        L56:
            long r22 = 43200000 + r19;
        L57:
            r10.f704a = r11;
            r10.f705b = r22;
        L63:
            r13 = r11;
            goto L64
        L46:
            if (r111 == (-1)) goto L56;
            if (r19 <= r111) goto L52;
            long r23 = r21 + 0;
        L55:
            r22 = r23 + 60000;
            goto L57
        L52:
            if (r19 <= r110) goto L54;
            r23 = r111 + 0;
            goto L55
        L54:
            r23 = r110 + 0;
            goto L55
        L58:
            Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
            int r24 = Calendar.getInstance().get(11);
            if (r24 >= 6) goto L61;
        L62:
            r11 = true;
            goto L63
        L61:
            if (r24 < 22) goto L63;
        L35:
            r18 = r16;
        L34:
            if (r16 == null) goto L36;
        L69:
        L27:
            e = move-exception;
            Log.d("TwilightManager", "Failed to get last known location", e);
            goto L29
        L24:
            if (r17.isProviderEnabled(CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS) == false) goto L29;
            r16 = r17.getLastKnownLocation(CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS);     // Catch: Exception -> L27
            goto L29
        L67:
        L15:
            e = move-exception;
            Log.d("TwilightManager", "Failed to get last known location", e);
        L17:
            Location r25 = null;
        L18:
            r18 = r25;
            goto L21
        L12:
            if (r17.isProviderEnabled("network") == false) goto L17;
            r25 = r17.getLastKnownLocation("network");     // Catch: Exception -> L15
            goto L18
        L5:
            r12 = false;
            goto L6
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.j
        public final void d() {
            this.f635d.E(true, true);
        }
    }

    public class l extends ContentFrameLayout {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final /* synthetic */ AppCompatDelegateImpl f636s;

        public l(AppCompatDelegateImpl r8, g.d r10) {
            this.f636s = r8;
            super(r10, null);
        }

        @Override // android.view.ViewGroup, android.view.View
        public final boolean dispatchKeyEvent(KeyEvent r8) {
            if (this.f636s.L(r8) == false) goto L5;
        L8:
            return true;
        L5:
            if (super.dispatchKeyEvent(r8) == true) goto L8;
            return false;
        }

        @Override // android.view.ViewGroup
        public final boolean onInterceptTouchEvent(MotionEvent r8) {
            if (r8.getAction() != 0) goto L18;
            int r10 = (int) r8.getX();
            int r11 = (int) r8.getY();
            if (r10 < (-5)) goto L13;
            if (r11 < (-5)) goto L13;
            if (r10 > (getWidth() + 5)) goto L13;
            if (r11 > (getHeight() + 5)) goto L13;
            boolean r12 = false;
        L14:
            if (r12 == false) goto L18;
            AppCompatDelegateImpl r13 = this.f636s;
            r13.J(r13.Q(0), true);
            return true;
        L13:
            r12 = true;
        L18:
            return super.onInterceptTouchEvent(r8);
        }

        @Override // android.view.View
        public final void setBackgroundResource(int r8) {
            setBackgroundDrawable(d.a.a(getContext(), r8));
        }
    }

    public final class m implements androidx.appcompat.view.menu.j.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppCompatDelegateImpl f637a;

        public m(AppCompatDelegateImpl r8) {
            this.f637a = r8;
        }

        @Override // androidx.appcompat.view.menu.j.a
        public final void a(androidx.appcompat.view.menu.f r10, boolean r11) {
            androidx.appcompat.view.menu.f r8 = r10.l();
            int r12 = 0;
            if (r8 == r10) goto L5;
            boolean r13 = true;
        L6:
            if (r13 == false) goto L8;
            r10 = r8;
        L8:
            AppCompatDelegateImpl r14 = this.f637a;
            PanelFeatureState[] r15 = r14.W;
            if (r15 == null) goto L11;
            int r16 = r15.length;
        L12:
            if (r12 >= r16) goto L19;
            PanelFeatureState r17 = r15[r12];
            if (r17 == null) goto L18;
            if (r17.f608h != r10) goto L18;
        L20:
            if (r17 == null) goto L30;
            if (r13 == false) goto L23;
            r14.H(r17.f601a, r17, r8);
            r14.J(r17, true);
            return;
        L23:
            r14.J(r17, r11);
            return;
        L30:
            return;
        L18:
            r12 = r12 + 1;
            goto L12
        L19:
            r17 = null;
            goto L20
        L11:
            r16 = 0;
            goto L12
        L5:
            r13 = false;
            goto L6
        }

        @Override // androidx.appcompat.view.menu.j.a
        public final boolean b(androidx.appcompat.view.menu.f r8) {
            if (r8 != r8.l()) goto L13;
            AppCompatDelegateImpl r10 = this.f637a;
            if (r10.Q == false) goto L14;
            Window.Callback r11 = r10.R();
            if (r11 != null) goto L9;
            return true;
        L9:
            if (r10.f578b0 == true) goto L16;
            r11.onMenuOpened(108, r8);
            return true;
        L16:
            return true;
        L14:
            return true;
        L13:
            return true;
        }
    }

    static {
        f573s0 = new n.h();
        f574t0 = new int[]{R.attr.windowBackground};
        f575u0 = !"robolectric".equals(Build.FINGERPRINT);
        f576v0 = true;
    }

    public AppCompatDelegateImpl(Context r8, Window r10, androidx.appcompat.app.f r11, Object r12) {
        this.I = null;
        this.J = true;
        this.d0 = -100;
        this.f587l0 = new a(this);
        this.f595u = r8;
        this.f598x = r11;
        this.f594t = r12;
        if ((r12 instanceof Dialog) == false) goto L15;
    L4:
        if (r8 == null) goto L11;
        if ((r8 instanceof androidx.appcompat.app.e) == true) goto L7;
        if ((r8 instanceof ContextWrapper) == false) goto L11;
        r8 = ((ContextWrapper) r8).getBaseContext();
        goto L4
    L7:
        androidx.appcompat.app.e r13 = (androidx.appcompat.app.e) r8;
    L12:
        if (r13 == null) goto L15;
        this.d0 = r13.getDelegate().h();
    L11:
        r13 = null;
    L15:
        if (this.d0 != (-100)) goto L19;
        n.h<String, Integer> r14 = f573s0;
        Integer r15 = r14.getOrDefault(this.f594t.getClass().getName(), null);
        if (r15 == null) goto L19;
        this.d0 = r15.intValue();
        r14.remove(this.f594t.getClass().getName());
    L19:
        if (r10 == null) goto L21;
        F(r10);
    L21:
        androidx.appcompat.widget.j.d();
    }

    public static f0.e G(Context r8) {
        if (Build.VERSION.SDK_INT < 33) goto L5;
        return null;
    L5:
        f0.e r10 = androidx.appcompat.app.h.f650m;
        if (r10 != null) goto L8;
        return null;
    L8:
        f0.e r11 = f.b(r8.getApplicationContext().getResources().getConfiguration());
        f0.f r12 = r10.f7237a;
        if (r12.isEmpty() == false) goto L11;
        f0.e r13 = f0.e.f7236b;
    L23:
        if (r13.f7237a.isEmpty() == false) goto L26;
        return r11;
    L26:
        return r13;
    L11:
        LinkedHashSet r14 = new LinkedHashSet();
        int r15 = 0;
    L12:
        int r16 = r12.size();
        if (r15 >= (r11.f7237a.size() + r16)) goto L21;
        if (r15 >= r12.size()) goto L17;
        Locale r17 = r12.get(r15);
    L18:
        if (r17 == null) goto L20;
        r14.add(r17);
    L20:
        r15 = r15 + 1;
        goto L12
    L17:
        int r18 = r15 - r12.size();
        r17 = r11.f7237a.get(r18);
        goto L18
    L21:
        r13 = new f0.e(new f0.g(f0.e.b.a((Locale[]) r14.toArray(new Locale[r14.size()]))));
        goto L23
    }

    public static Configuration K(Context r8, int r10, f0.e r11, Configuration r12, boolean r13) {
        if (r10 != 1) goto L5;
        int r14 = 16;
    L11:
        Configuration r15 = new Configuration();
        r15.fontScale = 0.0f;
        if (r12 == null) goto L14;
        r15.setTo(r12);
    L14:
        r15.uiMode = r14 | (r15.uiMode & (-49));
        if (r11 == null) goto L17;
        f.d(r15, r11);
    L17:
        return r15;
    L5:
        if (r10 == 2) goto L9;
        if (r13 == false) goto L8;
        r14 = 0;
        goto L11
    L8:
        r14 = r8.getApplicationContext().getResources().getConfiguration().uiMode & 48;
        goto L11
    L9:
        r14 = 32;
        goto L11
    }

    @Override // androidx.appcompat.app.h
    public final void A(Toolbar r8) {
        Object r10 = this.f594t;
        if ((r10 instanceof Activity) == true) goto L5;
        return;
    L5:
        S();
        androidx.appcompat.app.a r11 = this.f599y;
        if ((r11 instanceof w) == true) goto L21;
        this.f600z = null;
        if (r11 == null) goto L10;
        r11.h();
    L10:
        this.f599y = null;
        if (r8 != null) goto L13;
        this.f597w.f624b = null;
    L18:
        l();
        return;
    L13:
        if ((r10 instanceof Activity) == false) goto L15;
        CharSequence r12 = ((Activity) r10).getTitle();
    L16:
        t r13 = new t(r8, r12, this.f597w);
        this.f599y = r13;
        h r14 = this.f597w;
        r14.f624b = r13.f684c;
        r8.setBackInvokedCallbackEnabled(true);
        goto L18
    L15:
        r12 = this.A;
        goto L16
    L21:
        throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
    }

    @Override // androidx.appcompat.app.h
    public final void B(int r8) {
        this.f580e0 = r8;
    }

    @Override // androidx.appcompat.app.h
    public final void C(CharSequence r8) {
        this.A = r8;
        b0 r10 = this.B;
        if (r10 == null) goto L5;
        r10.setWindowTitle(r8);
        return;
    L5:
        androidx.appcompat.app.a r11 = this.f599y;
        if (r11 == null) goto L8;
        r11.n(r8);
        return;
    L8:
        TextView r12 = this.M;
        if (r12 == null) goto L14;
        r12.setText(r8);
        return;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.appcompat.app.h
    public final g.b D(g.b.a r10) {
        if (r10 == null) goto L80;
        g.b r8 = this.E;
        if (r8 == null) goto L6;
        r8.c();
    L6:
        e r11 = new e(this, r10);
        S();
        androidx.appcompat.app.a r12 = this.f599y;
        androidx.appcompat.app.f r13 = this.f598x;
        if (r12 == null) goto L13;
        g.b r14 = r12.o(r11);
        this.E = r14;
        if (r14 == null) goto L13;
        if (r13 == null) goto L13;
        r13.onSupportActionModeStarted(r14);
    L13:
        if (this.E != null) goto L77;
        h0 r15 = this.I;
        if (r15 == null) goto L17;
        r15.b();
    L17:
        g.b r16 = this.E;
        if (r16 == null) goto L21;
        r16.c();
    L21:
        if (r13 != null) goto L23;
    L26:
        g.b r17 = null;
    L27:
        if (r17 == null) goto L29;
        this.E = r17;
    L72:
        g.b r18 = this.E;
        if (r18 == null) goto L76;
        if (r13 == null) goto L76;
        r13.onSupportActionModeStarted(r18);
    L76:
        Z();
        this.E = this.E;
        goto L77
    L29:
        boolean r19 = true;
        if (this.F != null) goto L48;
        boolean r20 = this.T;
        Context r21 = this.f595u;
        if (r20 == false) goto L37;
        TypedValue r22 = new TypedValue();
        Resources.Theme r23 = r21.getTheme();
        r23.resolveAttribute(com.obric.cae.R.attr.actionBarTheme, r22, true);
        if (r22.resourceId == 0) goto L36;
        Resources.Theme r24 = r21.getResources().newTheme();
        r24.setTo(r23);
        r24.applyStyle(r22.resourceId, true);
        g.d r25 = new g.d(r21, 0);
        r25.getTheme().setTo(r24);
        r21 = r25;
    L36:
        this.F = new ActionBarContextView(r21, null);
        PopupWindow r26 = new PopupWindow(r21, null, com.obric.cae.R.attr.actionModePopupWindowStyle);
        this.G = r26;
        androidx.core.widget.j.d(r26, 2);
        this.G.setContentView(this.F);
        this.G.setWidth(-1);
        r21.getTheme().resolveAttribute(com.obric.cae.R.attr.actionBarSize, r22, true);
        this.F.setContentHeight(TypedValue.complexToDimensionPixelSize(r22.data, r21.getResources().getDisplayMetrics()));
        this.G.setHeight(-2);
        this.H = new androidx.appcompat.app.k(this);
        goto L48
    L37:
        ViewStubCompat r27 = (ViewStubCompat) this.L.findViewById(com.obric.cae.R.id.action_mode_bar_stub);
        if (r27 == null) goto L48;
        S();
        androidx.appcompat.app.a r28 = this.f599y;
        if (r28 == null) goto L42;
        Context r29 = r28.e();
    L43:
        if (r29 == null) goto L46;
        r21 = r29;
    L46:
        r27.setLayoutInflater(LayoutInflater.from(r21));
        this.F = (ActionBarContextView) r27.a();
        goto L48
    L42:
        r29 = null;
    L48:
        if (this.F == null) goto L72;
        h0 r30 = this.I;
        if (r30 == null) goto L52;
        r30.b();
    L52:
        this.F.h();
        g.e r31 = new g.e(this.F.getContext(), this.F, r11);
        if (r11.c(r31, r31.f7448r) == false) goto L71;
        r31.i();
        this.F.f(r31);
        this.E = r31;
        if (this.K == false) goto L61;
        ViewGroup r32 = this.L;
        if (r32 == null) goto L61;
        WeakHashMap<View, h0> r33 = j0.w.f8437a;
        if (j0.w.g.c(r32) == false) goto L61;
    L62:
        ActionBarContextView r34 = this.F;
        if (r19 == false) goto L65;
        r34.setAlpha(0.0f);
        h0 r35 = j0.w.a(this.F);
        r35.a(1.0f);
        this.I = r35;
        r35.d(new androidx.appcompat.app.l(this));
    L69:
        if (this.G == null) goto L72;
        this.f596v.getDecorView().post(this.H);
        goto L72
    L65:
        r34.setAlpha(1.0f);
        this.F.setVisibility(0);
        if ((this.F.getParent() instanceof View) == false) goto L69;
        View r36 = (View) this.F.getParent();
        WeakHashMap<View, h0> r37 = j0.w.f8437a;
        j0.w.h.c(r36);
    L61:
        r19 = false;
        goto L62
    L71:
        this.E = null;
        goto L72
    L23:
        if (this.f578b0 == true) goto L26;
        r17 = r13.onWindowStartingSupportActionMode(r11);     // Catch: AbstractMethodError -> L81
    L77:
        Z();
        return this.E;
    L80:
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean E(boolean r14, boolean r15) {
        boolean r8 = false;
        if (this.f578b0 == false) goto L5;
        return false;
    L5:
        int r10 = this.d0;
        if (r10 != (-100)) goto L9;
        r10 = androidx.appcompat.app.h.f649b;
    L9:
        Context r11 = this.f595u;
        int r12 = T(r11, r10);
        if (Build.VERSION.SDK_INT >= 33) goto L12;
        f0.e r13 = G(r11);
    L13:
        if (r15 == true) goto L16;
        if (r13 == null) goto L16;
        r13 = f.b(r11.getResources().getConfiguration());
    L16:
        Configuration r16 = K(r11, r12, r13, null, false);
        boolean r17 = this.f582g0;
        boolean r18 = true;
        Object r19 = this.f594t;
        if (r17 == false) goto L19;
    L29:
        this.f582g0 = true;
        int r20 = this.f581f0;
    L30:
        Configuration r21 = this.f579c0;
        if (r21 != null) goto L33;
        r21 = r11.getResources().getConfiguration();
    L33:
        int r110 = r21.uiMode & 48;
        int r111 = r16.uiMode & 48;
        f0.e r22 = f.b(r21);
        if (r13 != null) goto L36;
        f0.e r112 = null;
    L37:
        if (r110 == r111) goto L39;
        int r113 = 512;
    L40:
        if (r112 == null) goto L45;
        if (r22.equals(r112) == true) goto L45;
        r113 = (r113 | 4) | 8192;
    L45:
        if (((~r20) & r113) == 0) goto L58;
        if (r14 == false) goto L58;
        if (this.Z == false) goto L58;
        if (f575u0 == true) goto L54;
        if (this.f577a0 == false) goto L58;
    L54:
        if ((r19 instanceof Activity) == false) goto L58;
        Activity r114 = (Activity) r19;
        if (r114.isChild() == true) goto L58;
        int r23 = androidx.core.app.a.f1587c;
        r114.recreate();
        boolean r115 = true;
    L59:
        if (r115 == true) goto L86;
        if (r113 == 0) goto L86;
        if ((r113 & r20) != r113) goto L64;
        boolean r116 = true;
    L65:
        Resources r24 = r11.getResources();
        Configuration r25 = new Configuration(r24.getConfiguration());
        r25.uiMode = r111 | (r24.getConfiguration().uiMode & (-49));
        if (r112 == null) goto L68;
        f.d(r25, r112);
    L68:
        r24.updateConfiguration(r25, null);
        int r26 = this.f580e0;
        if (r26 == 0) goto L71;
        r11.setTheme(r26);
        r11.getTheme().applyStyle(this.f580e0, true);
    L71:
        if (r116 == true) goto L73;
    L87:
        if (r18 == true) goto L89;
    L96:
        if (r18 == false) goto L99;
        if (r112 == null) goto L99;
        f.c(f.b(r11.getResources().getConfiguration()));
    L99:
        if (r10 != 0) goto L101;
        P(r11).e();
    L105:
        if (r10 == 3) goto L107;
        i r117 = this.f584i0;
        if (r117 == null) goto L113;
        r117.a();
    L113:
        return r18;
    L107:
        if (this.f584i0 != null) goto L109;
        this.f584i0 = new i(this, r11);
    L109:
        this.f584i0.e();
        goto L113
    L101:
        k r118 = this.f583h0;
        if (r118 == null) goto L105;
        r118.a();
        goto L105
    L89:
        if ((r19 instanceof androidx.appcompat.app.e) == false) goto L96;
        if ((r113 & 512) == 0) goto L94;
        ((androidx.appcompat.app.e) r19).onNightModeChanged(r12);
    L94:
        if ((r113 & 4) == 0) goto L96;
        ((androidx.appcompat.app.e) r19).onLocalesChanged(r13);
        goto L96
    L73:
        if ((r19 instanceof Activity) == false) goto L87;
        Activity r119 = (Activity) r19;
        if ((r119 instanceof androidx.lifecycle.m) == false) goto L82;
        if (((androidx.lifecycle.m) r119).getLifecycle().b().compareTo(androidx.lifecycle.h.b.f2159m) < 0) goto L79;
        r8 = true;
    L79:
        if (r8 == false) goto L87;
    L85:
        r119.onConfigurationChanged(r25);
        goto L87
    L82:
        if (this.f577a0 == false) goto L87;
        if (this.f578b0 == true) goto L87;
    L64:
        r116 = false;
    L86:
        r18 = r115;
    L58:
        r115 = false;
        goto L59
    L39:
        r113 = 0;
        goto L40
    L36:
        r112 = f.b(r16);
        goto L37
    L19:
        if ((r19 instanceof Activity) == false) goto L29;
        PackageManager r27 = r11.getPackageManager();
        if (r27 != null) goto L114;
        r20 = 0;
        goto L30
    L114:
        ActivityInfo r28 = r27.getActivityInfo(new ComponentName(r11, r19.getClass()), 269221888);     // Catch: PackageManager.NameNotFoundException -> L27
        if (r28 == null) goto L29;
        this.f581f0 = r28.configChanges;     // Catch: PackageManager.NameNotFoundException -> L27
    L27:
        e = move-exception;
        Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e);
        this.f581f0 = 0;
        goto L29
    L12:
        r13 = null;
        goto L13
    }

    public final void F(Window r8) {
        if (this.f596v != null) goto L27;
        Window.Callback r10 = r8.getCallback();
        if ((r10 instanceof h) == true) goto L25;
        h r11 = new h(this, r10);
        this.f597w = r11;
        r8.setCallback(r11);
        Context r12 = this.f595u;
        OnBackInvokedDispatcher r13 = null;
        v0 r14 = new v0(r12, r12.obtainStyledAttributes(null, f574t0));
        Drawable r15 = r14.f(0);
        if (r15 == null) goto L9;
        r8.setBackgroundDrawable(r15);
    L9:
        r14.n();
        this.f596v = r8;
        if (Build.VERSION.SDK_INT < 33) goto L28;
        OnBackInvokedDispatcher r16 = this.f592q0;
        if (r16 != null) goto L29;
        if (r16 == null) goto L17;
        OnBackInvokedCallback r17 = this.f593r0;
        if (r17 == null) goto L17;
        g.c(r16, r17);
        this.f593r0 = null;
    L17:
        Object r18 = this.f594t;
        if ((r18 instanceof Activity) == false) goto L22;
        Activity r19 = (Activity) r18;
        if (r19.getWindow() == null) goto L22;
        r13 = g.a(r19);
    L22:
        this.f592q0 = r13;
        Z();
        return;
    L29:
        return;
    L28:
        return;
    L25:
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    L27:
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    public final void H(int r8, PanelFeatureState r10, androidx.appcompat.view.menu.f r11) {
        if (r11 != null) goto L10;
        if (r10 != null) goto L8;
        if (r8 < 0) goto L8;
        PanelFeatureState[] r12 = this.W;
        if (r8 >= r12.length) goto L8;
        r10 = r12[r8];
    L8:
        if (r10 == null) goto L10;
        r11 = r10.f608h;
    L10:
        if (r10 == null) goto L15;
        if (r10.f613m == true) goto L15;
        return;
    L15:
        if (this.f578b0 == true) goto L22;
        h r13 = this.f597w;
        Window.Callback r14 = this.f596v.getCallback();
        r13.getClass();
        r13.f627o = true;     // Catch: Throwable -> L19
        r14.onPanelClosed(r8, r11);     // Catch: Throwable -> L19
        r13.f627o = false;
        return;
    L19:
        th = move-exception;
        r13.f627o = false;
        throw th;
    }

    public final void I(androidx.appcompat.view.menu.f r8) {
        if (this.V == false) goto L5;
        return;
    L5:
        this.V = true;
        this.B.l();
        Window.Callback r10 = R();
        if (r10 != null) goto L8;
    L10:
        this.V = false;
        return;
    L8:
        if (this.f578b0 == true) goto L10;
        r10.onPanelClosed(108, r8);
        goto L10
    }

    public final void J(PanelFeatureState r8, boolean r10) {
        if (r10 == true) goto L4;
    L11:
        WindowManager r11 = (WindowManager) this.f595u.getSystemService("window");
        if (r11 != null) goto L14;
    L20:
        r8.f611k = false;
        r8.f612l = false;
        r8.f613m = false;
        r8.f606f = null;
        r8.f614n = true;
        if (this.X != r8) goto L24;
        this.X = null;
    L24:
        if (r8.f601a != 0) goto L27;
        Z();
        return;
    L27:
        return;
    L14:
        if (r8.f613m == false) goto L20;
        l r12 = r8.f605e;
        if (r12 == null) goto L20;
        r11.removeView(r12);
        if (r10 == false) goto L20;
        H(r8.f601a, r8, null);
        goto L20
    L4:
        if (r8.f601a != 0) goto L11;
        b0 r13 = this.B;
        if (r13 == null) goto L11;
        if (r13.e() == false) goto L11;
        I(r8.f608h);
    }

    public final boolean L(KeyEvent r8) {
        Object r10 = this.f594t;
        if ((r10 instanceof j0.e) == true) goto L7;
        if ((r10 instanceof o) == true) goto L7;
    L9:
        boolean r11 = true;
        if (r8.getKeyCode() == 82) goto L12;
    L14:
        int r12 = r8.getKeyCode();
        if (r8.getAction() != 0) goto L17;
        boolean r13 = true;
    L19:
        if (r13 == false) goto L33;
        if (r12 == 4) goto L29;
        if (r12 != 82) goto L77;
        if (r8.getRepeatCount() != 0) goto L78;
        PanelFeatureState r14 = Q(0);
        if (r14.f613m == true) goto L79;
        X(r14, r8);
        return true;
    L79:
        return true;
    L78:
        return true;
    L77:
        return false;
    L29:
        if ((r8.getFlags() & 128) != 0) goto L32;
        r11 = false;
    L32:
        this.Y = r11;
        goto L77
    L33:
        if (r12 == 4) goto L74;
        if (r12 != 82) goto L77;
        if (this.E != null) goto L84;
        PanelFeatureState r15 = Q(0);
        b0 r16 = this.B;
        Context r17 = this.f595u;
        if (r16 != null) goto L42;
    L53:
        boolean r18 = r15.f613m;
        if (r18 == false) goto L56;
    L67:
        J(r15, true);
        boolean r19 = r18;
    L68:
        if (r19 == false) goto L81;
        AudioManager r20 = (AudioManager) r17.getApplicationContext().getSystemService(AIMediaEventSchema.MEDIA_TYPE_AUDIO);
        if (r20 == null) goto L72;
        r20.playSoundEffect(0);
        return true;
    L72:
        Log.w("AppCompatDelegate", "Couldn't get audio manager");
        return true;
    L81:
        return true;
    L56:
        if (r15.f612l == true) goto L67;
        if (r15.f611k == true) goto L61;
    L66:
        r19 = false;
        goto L68
    L61:
        if (r15.f615o == false) goto L63;
        r15.f611k = false;
        boolean r21 = X(r15, r8);
    L64:
        if (r21 == false) goto L66;
        V(r15, r8);
        r19 = true;
        goto L68
    L63:
        r21 = true;
        goto L64
    L42:
        if (r16.a() == false) goto L53;
        if (ViewConfiguration.get(r17).hasPermanentMenuKey() == true) goto L53;
        if (this.B.e() == false) goto L48;
        r19 = this.B.c();
        goto L68
    L48:
        if (this.f578b0 == true) goto L66;
        if (X(r15, r8) == false) goto L66;
        r19 = this.B.d();
        goto L68
    L84:
        return true;
    L74:
        if (U() == false) goto L77;
        return true;
    L17:
        r13 = false;
        goto L19
    L12:
        if (this.f597w.a(this.f596v.getCallback(), r8) == false) goto L14;
        return true;
    L7:
        if (this.f596v.getDecorView() == null) goto L9;
        WeakHashMap<View, h0> r22 = j0.w.f8437a;
        goto L9
    }

    public final void M(int r8) {
        PanelFeatureState r10 = Q(r8);
        if (r10.f608h == null) goto L8;
        Bundle r11 = new Bundle();
        r10.f608h.v(r11);
        if (r11.size() <= 0) goto L7;
        r10.f616p = r11;
    L7:
        r10.f608h.y();
        r10.f608h.clear();
    L8:
        r10.f615o = true;
        r10.f614n = true;
        if (r8 == 108) goto L12;
        if (r8 == 0) goto L12;
        return;
    L12:
        if (this.B == null) goto L16;
        PanelFeatureState r12 = Q(0);
        r12.f611k = false;
        X(r12, null);
        return;
    }

    public final void N() {
        if (this.K == true) goto L106;
        int[] r8 = c.a.f3224j;
        Context r10 = this.f595u;
        TypedArray r11 = r10.obtainStyledAttributes(r8);
        if (r11.hasValue(117) == true) goto L7;
        r11.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    L7:
        if (r11.getBoolean(126, false) == false) goto L10;
        w(1);
    L13:
        if (r11.getBoolean(118, false) == false) goto L16;
        w(109);
    L16:
        if (r11.getBoolean(IdlErrors.E_RejectInferDeviceOverheat, false) == false) goto L18;
        w(10);
    L18:
        this.T = r11.getBoolean(0, false);
        r11.recycle();
        O();
        this.f596v.getDecorView();
        LayoutInflater r12 = LayoutInflater.from(r10);
        if (this.U == true) goto L40;
        if (this.T == false) goto L24;
        ViewGroup r13 = (ViewGroup) r12.inflate(com.obric.cae.R.layout.abc_dialog_title_material, null);
        this.R = false;
        this.Q = false;
    L44:
        if (r13 == null) goto L103;
        androidx.appcompat.app.i r14 = new androidx.appcompat.app.i(this);
        WeakHashMap<View, h0> r15 = j0.w.f8437a;
        j0.w.i.u(r13, r14);
        if (this.B != null) goto L48;
        this.M = (TextView) r13.findViewById(com.obric.cae.R.id.title);
    L48:
        Method r16 = b1.f1104a;
        Method r17 = r13.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);     // Catch: Throwable -> L54 NoSuchMethodException -> L56
        if (r17.isAccessible() == true) goto L52;
        r17.setAccessible(true);     // Catch: Throwable -> L54 NoSuchMethodException -> L56
    L52:
        r17.invoke(r13, new Object[0]);     // Catch: Throwable -> L54 NoSuchMethodException -> L56
    L57:
        ContentFrameLayout r18 = (ContentFrameLayout) r13.findViewById(com.obric.cae.R.id.action_bar_activity_content);
        ViewGroup r19 = (ViewGroup) this.f596v.findViewById(R.id.content);
        if (r19 != null) goto L60;
    L65:
        this.f596v.setContentView(r13);
        r18.setAttachListener(new androidx.appcompat.app.j(this));
        this.L = r13;
        Object r20 = this.f594t;
        if ((r20 instanceof Activity) == false) goto L68;
        CharSequence r21 = ((Activity) r20).getTitle();
    L70:
        if (TextUtils.isEmpty(r21) == true) goto L80;
        b0 r22 = this.B;
        if (r22 == null) goto L74;
        r22.setWindowTitle(r21);
        goto L80
    L74:
        androidx.appcompat.app.a r23 = this.f599y;
        if (r23 == null) goto L77;
        r23.n(r21);
        goto L80
    L77:
        TextView r24 = this.M;
        if (r24 == null) goto L80;
        r24.setText(r21);
    L80:
        ContentFrameLayout r25 = (ContentFrameLayout) this.L.findViewById(R.id.content);
        View r26 = this.f596v.getDecorView();
        r25.f1002q.set(r26.getPaddingLeft(), r26.getPaddingTop(), r26.getPaddingRight(), r26.getPaddingBottom());
        WeakHashMap<View, h0> r27 = j0.w.f8437a;
        if (j0.w.g.c(r25) == false) goto L83;
        r25.requestLayout();
    L83:
        TypedArray r28 = r10.obtainStyledAttributes(r8);
        r28.getValue(124, r25.getMinWidthMajor());
        r28.getValue(125, r25.getMinWidthMinor());
        if (r28.hasValue(122) == false) goto L87;
        r28.getValue(122, r25.getFixedWidthMajor());
    L87:
        if (r28.hasValue(AccelMetric.CAE_MULTI_NET_ACCEL_EVENT_FEATURE_ID) == false) goto L90;
        r28.getValue(AccelMetric.CAE_MULTI_NET_ACCEL_EVENT_FEATURE_ID, r25.getFixedWidthMinor());
    L90:
        if (r28.hasValue(120) == false) goto L93;
        r28.getValue(120, r25.getFixedHeightMajor());
    L93:
        if (r28.hasValue(121) == false) goto L95;
        r28.getValue(121, r25.getFixedHeightMinor());
    L95:
        r28.recycle();
        r25.requestLayout();
        this.K = true;
        PanelFeatureState r29 = Q(0);
        if (this.f578b0 == false) goto L98;
        return;
    L98:
        if (r29.f608h != null) goto L111;
        this.f586k0 |= 4096;
        if (this.f585j0 == true) goto L112;
        j0.w.d.m(this.f596v.getDecorView(), this.f587l0);
        this.f585j0 = true;
        return;
    L112:
        return;
    L111:
        return;
    L68:
        r21 = this.A;
    L60:
        if (r19.getChildCount() <= 0) goto L62;
        View r30 = r19.getChildAt(0);
        r19.removeViewAt(0);
        r18.addView(r30);
        goto L60
    L62:
        r19.setId(-1);
        r18.setId(R.id.content);
        if ((r19 instanceof FrameLayout) == false) goto L65;
        ((FrameLayout) r19).setForeground(null);
        goto L65
    L54:
        e = move-exception;
        Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e);
    L56:
        Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
        goto L57
    L103:
        throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.Q + ", windowActionBarOverlay: " + this.R + ", android:windowIsFloating: " + this.T + ", windowActionModeOverlay: " + this.S + ", windowNoTitle: " + this.U + " }");
    L24:
        if (this.Q == false) goto L38;
        TypedValue r31 = new TypedValue();
        r10.getTheme().resolveAttribute(com.obric.cae.R.attr.actionBarTheme, r31, true);
        if (r31.resourceId == 0) goto L28;
        Context r32 = new g.d(r10, r31.resourceId);
    L29:
        r13 = (ViewGroup) LayoutInflater.from(r32).inflate(com.obric.cae.R.layout.abc_screen_toolbar, null);
        b0 r33 = (b0) r13.findViewById(com.obric.cae.R.id.decor_content_parent);
        this.B = r33;
        r33.setWindowCallback(R());
        if (this.R == false) goto L33;
        this.B.h(109);
    L33:
        if (this.O == false) goto L36;
        this.B.h(2);
    L36:
        if (this.P == false) goto L44;
        this.B.h(5);
        goto L44
    L28:
        r32 = r10;
        goto L29
    L38:
        r13 = null;
        goto L44
    L40:
        if (this.S == false) goto L42;
        int r34 = com.obric.cae.R.layout.abc_screen_simple_overlay_action_mode;
    L43:
        r13 = (ViewGroup) r12.inflate(r34, null);
        goto L44
    L42:
        r34 = com.obric.cae.R.layout.abc_screen_simple;
        goto L43
    L10:
        if (r11.getBoolean(117, false) == false) goto L13;
        w(108);
        goto L13
    }

    public final void O() {
        if (this.f596v != null) goto L8;
        Object r8 = this.f594t;
        if ((r8 instanceof Activity) == false) goto L8;
        F(((Activity) r8).getWindow());
    L8:
        if (this.f596v == null) goto L11;
        return;
    L11:
        throw new IllegalStateException("We have not been given a Window");
    }

    public final j P(Context r8) {
        if (this.f583h0 != null) goto L9;
        if (v.f700d != null) goto L7;
        Context r10 = r8.getApplicationContext();
        v.f700d = new v(r10, (LocationManager) r10.getSystemService(LocationMonitorConst.LOCATION));
    L7:
        this.f583h0 = new k(this, v.f700d);
    L9:
        return this.f583h0;
    }

    public final PanelFeatureState Q(int r8) {
        PanelFeatureState[] r10 = this.W;
        if (r10 != null) goto L5;
    L6:
        PanelFeatureState[] r11 = new PanelFeatureState[r8 + 1];
        if (r10 == null) goto L9;
        System.arraycopy(r10, 0, r11, 0, r10.length);
    L9:
        this.W = r11;
        r10 = r11;
    L10:
        PanelFeatureState r12 = r10[r8];
        if (r12 != null) goto L14;
        PanelFeatureState r13 = new PanelFeatureState(r8);
        r10[r8] = r13;
        return r13;
    L14:
        return r12;
    L5:
        if (r10.length > r8) goto L10;
        goto L6
    }

    public final Window.Callback R() {
        return this.f596v.getCallback();
    }

    public final void S() {
        N();
        if (this.Q == true) goto L5;
        return;
    L5:
        if (this.f599y != null) goto L20;
        Object r8 = this.f594t;
        if ((r8 instanceof Activity) == false) goto L12;
        w r10 = new w((Activity) r8, this.R);
    L10:
        this.f599y = r10;
    L14:
        androidx.appcompat.app.a r11 = this.f599y;
        if (r11 == null) goto L19;
        r11.l(this.f588m0);
        return;
    L19:
        return;
    L12:
        if ((r8 instanceof Dialog) == false) goto L14;
        r10 = new w((Dialog) r8);
        goto L10
    }

    public final int T(Context r8, int r10) {
        if (r10 == (-100)) goto L25;
        if (r10 == (-1)) goto L24;
        if (r10 == 0) goto L19;
        if (r10 == 1) goto L24;
        if (r10 == 2) goto L24;
        if (r10 != 3) goto L17;
        if (this.f584i0 != null) goto L15;
        this.f584i0 = new i(this, r8);
    L15:
        j r11 = this.f584i0;
    L23:
        return r11.c();
    L17:
        throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
    L19:
        if (((UiModeManager) r8.getApplicationContext().getSystemService("uimode")).getNightMode() != 0) goto L21;
        return -1;
    L21:
        r11 = P(r8);
    L24:
        return r10;
    L25:
        return -1;
    }

    public final boolean U() {
        boolean r8 = this.Y;
        this.Y = false;
        PanelFeatureState r10 = Q(0);
        if (r10.f613m == false) goto L7;
        if (r8 == true) goto L6;
        J(r10, true);
    L6:
        return true;
    L7:
        g.b r11 = this.E;
        if (r11 == null) goto L11;
        r11.c();
        return true;
    L11:
        S();
        androidx.appcompat.app.a r12 = this.f599y;
        if (r12 != null) goto L14;
    L16:
        return false;
    L14:
        if (r12.b() == false) goto L16;
        return true;
    }

    public final void V(PanelFeatureState r18, KeyEvent r19) {
        if (r18.f613m == false) goto L5;
        return;
    L5:
        if (this.f578b0 == true) goto L104;
        Context r8 = this.f595u;
        int r10 = r18.f601a;
        if (r10 == 0) goto L10;
    L15:
        Window.Callback r11 = R();
        if (r11 != null) goto L18;
    L21:
        WindowManager r12 = (WindowManager) r8.getSystemService("window");
        if (r12 != null) goto L25;
        return;
    L25:
        if (X(r18, r19) == true) goto L27;
        return;
    L27:
        l r13 = r18.f605e;
        if (r13 != null) goto L30;
    L39:
        if (r13 != null) goto L56;
        S();
        androidx.appcompat.app.a r14 = this.f599y;
        if (r14 == null) goto L43;
        Context r15 = r14.e();
    L44:
        if (r15 == null) goto L47;
        r8 = r15;
    L47:
        TypedValue r16 = new TypedValue();
        Resources.Theme r17 = r8.getResources().newTheme();
        r17.setTo(r8.getTheme());
        r17.resolveAttribute(com.obric.cae.R.attr.actionBarPopupTheme, r16, true);
        int r110 = r16.resourceId;
        if (r110 == 0) goto L50;
        r17.applyStyle(r110, true);
    L50:
        r17.resolveAttribute(com.obric.cae.R.attr.panelMenuListTheme, r16, true);
        int r20 = r16.resourceId;
        if (r20 != 0) goto L54;
        r20 = com.obric.cae.R.style.Theme_AppCompat_CompactMenu;
    L54:
        r17.applyStyle(r20, true);
        g.d r21 = new g.d(r8, 0);
        r21.getTheme().setTo(r17);
        r18.f610j = r21;
        TypedArray r22 = r21.obtainStyledAttributes(c.a.f3224j);
        r18.f602b = r22.getResourceId(86, 0);
        r18.f604d = r22.getResourceId(1, 0);
        r22.recycle();
        r18.f605e = new l(this, r18.f610j);
        r18.f603c = 81;
    L60:
        View r23 = r18.f607g;
        if (r23 == null) goto L64;
        r18.f606f = r23;
    L80:
        boolean r24 = true;
    L82:
        if (r24 == true) goto L84;
    L100:
        r18.f614n = true;
        return;
    L84:
        if (r18.a() == false) goto L100;
        ViewGroup.LayoutParams r25 = r18.f606f.getLayoutParams();
        if (r25 != null) goto L89;
        r25 = new ViewGroup.LayoutParams(-2, -2);
    L89:
        r18.f605e.setBackgroundResource(r18.f602b);
        ViewParent r26 = r18.f606f.getParent();
        if ((r26 instanceof ViewGroup) == false) goto L92;
        ((ViewGroup) r26).removeView(r18.f606f);
    L92:
        r18.f605e.addView(r18.f606f, r25);
        if (r18.f606f.hasFocus() == true) goto L95;
        r18.f606f.requestFocus();
    L95:
        int r111 = -2;
    L96:
        r18.f612l = false;
        WindowManager.LayoutParams r27 = new WindowManager.LayoutParams(r111, -2, 0, 0, 1002, 8519680, -3);
        r27.gravity = r18.f603c;
        r27.windowAnimations = r18.f604d;
        r12.addView(r18.f605e, r27);
        r18.f613m = true;
        if (r10 != 0) goto L102;
        Z();
        return;
    L102:
        return;
    L64:
        if (r18.f608h != null) goto L67;
    L81:
        r24 = false;
        goto L82
    L67:
        if (this.D != null) goto L69;
        this.D = new m(this);
    L69:
        m r28 = this.D;
        if (r18.f609i != null) goto L72;
        androidx.appcompat.view.menu.d r29 = new androidx.appcompat.view.menu.d(r18.f610j);
        r18.f609i = r29;
        r29.f804o = r28;
        r18.f608h.b(r29);
    L72:
        androidx.appcompat.view.menu.d r30 = r18.f609i;
        l r31 = r18.f605e;
        if (r30.f803n != null) goto L78;
        r30.f803n = (ExpandedMenuView) r30.f801b.inflate(com.obric.cae.R.layout.abc_expanded_menu_layout, r31, false);
        if (r30.f805p != null) goto L77;
        r30.f805p = new androidx.appcompat.view.menu.d.a(r30);
    L77:
        r30.f803n.setAdapter(r30.f805p);
        r30.f803n.setOnItemClickListener(r30);
    L78:
        ExpandedMenuView r32 = r30.f803n;
        r18.f606f = r32;
        if (r32 == null) goto L81;
    L43:
        r15 = null;
        goto L44
    L56:
        if (r18.f614n == false) goto L60;
        if (r13.getChildCount() <= 0) goto L60;
        r18.f605e.removeAllViews();
        goto L60
    L30:
        if (r18.f614n == true) goto L39;
        View r33 = r18.f607g;
        if (r33 == null) goto L95;
        ViewGroup.LayoutParams r34 = r33.getLayoutParams();
        if (r34 == null) goto L95;
        if (r34.width != (-1)) goto L95;
        r111 = -1;
        goto L96
    L18:
        if (r11.onMenuOpened(r10, r18.f608h) == true) goto L21;
        J(r18, true);
        return;
    L10:
        if ((r8.getResources().getConfiguration().screenLayout & 15) != 4) goto L12;
        boolean r35 = true;
    L13:
        if (r35 == false) goto L15;
        return;
    L12:
        r35 = false;
        goto L13
    }

    public final boolean W(PanelFeatureState r8, int r10, KeyEvent r11) {
        if (r11.isSystem() == false) goto L6;
        return false;
    L6:
        if (r8.f611k == false) goto L8;
    L9:
        androidx.appcompat.view.menu.f r12 = r8.f608h;
        if (r12 != null) goto L12;
        return false;
    L12:
        return r12.performShortcut(r10, r11, 1);
    L8:
        if (X(r8, r11) == true) goto L9;
        return false;
    }

    public final boolean X(PanelFeatureState r13, KeyEvent r14) {
        if (this.f578b0 == false) goto L6;
        return false;
    L6:
        if (r13.f611k == false) goto L8;
        return true;
    L8:
        PanelFeatureState r8 = this.X;
        if (r8 == null) goto L12;
        if (r8 == r13) goto L12;
        J(r8, false);
    L12:
        Window.Callback r10 = R();
        int r11 = r13.f601a;
        if (r10 == null) goto L16;
        r13.f607g = r10.onCreatePanelView(r11);
    L16:
        if (r11 == 0) goto L20;
        if (r11 == 108) goto L20;
        boolean r12 = false;
    L21:
        if (r12 == false) goto L26;
        b0 r15 = this.B;
        if (r15 == null) goto L26;
        r15.f();
    L26:
        if (r13.f607g != null) goto L102;
        if (r12 == true) goto L29;
    L30:
        androidx.appcompat.view.menu.f r16 = r13.f608h;
        if (r16 != null) goto L33;
    L34:
        if (r16 != null) goto L62;
        Context r17 = this.f595u;
        if (r11 == 0) goto L39;
        if (r11 == 108) goto L39;
    L51:
        androidx.appcompat.view.menu.f r18 = new androidx.appcompat.view.menu.f(r17);
        r18.f819e = this;
        androidx.appcompat.view.menu.f r19 = r13.f608h;
        if (r18 == r19) goto L60;
        if (r19 == null) goto L56;
        r19.t(r13.f609i);
    L56:
        r13.f608h = r18;
        androidx.appcompat.view.menu.d r20 = r13.f609i;
        if (r20 == null) goto L60;
        r18.b(r20);
    L60:
        if (r13.f608h != null) goto L62;
        return false;
    L39:
        if (this.B == null) goto L51;
        TypedValue r21 = new TypedValue();
        Resources.Theme r22 = r17.getTheme();
        r22.resolveAttribute(com.obric.cae.R.attr.actionBarTheme, r21, true);
        if (r21.resourceId == 0) goto L43;
        Resources.Theme r23 = r17.getResources().newTheme();
        r23.setTo(r22);
        r23.applyStyle(r21.resourceId, true);
        r23.resolveAttribute(com.obric.cae.R.attr.actionBarWidgetTheme, r21, true);
    L45:
        if (r21.resourceId == 0) goto L49;
        if (r23 != null) goto L48;
        r23 = r17.getResources().newTheme();
        r23.setTo(r22);
    L48:
        r23.applyStyle(r21.resourceId, true);
    L49:
        if (r23 == null) goto L51;
        g.d r24 = new g.d(r17, 0);
        r24.getTheme().setTo(r23);
        r17 = r24;
        goto L51
    L43:
        r22.resolveAttribute(com.obric.cae.R.attr.actionBarWidgetTheme, r21, true);
        r23 = null;
    L62:
        if (r12 == false) goto L69;
        b0 r25 = this.B;
        if (r25 == null) goto L69;
        if (this.C != null) goto L68;
        this.C = new d(this);
    L68:
        r25.b(r13.f608h, this.C);
    L69:
        r13.f608h.y();
        if (r10.onCreatePanelMenu(r11, r13.f608h) == true) goto L82;
        androidx.appcompat.view.menu.f r110 = r13.f608h;
        if (r110 == null) goto L77;
        if (r110 == null) goto L76;
        r110.t(r13.f609i);
    L76:
        r13.f608h = null;
    L77:
        if (r12 == false) goto L81;
        b0 r111 = this.B;
        if (r111 == null) goto L81;
        r111.b(null, this.C);
    L81:
        return false;
    L82:
        r13.f615o = false;
    L83:
        r13.f608h.y();
        Bundle r26 = r13.f616p;
        if (r26 == null) goto L87;
        r13.f608h.u(r26);
        r13.f616p = null;
    L87:
        if (r10.onPreparePanel(0, r13.f607g, r13.f608h) == true) goto L94;
        if (r12 == false) goto L92;
        b0 r112 = this.B;
        if (r112 == null) goto L92;
        r112.b(null, this.C);
    L92:
        r13.f608h.x();
        return false;
    L94:
        if (r14 == null) goto L96;
        int r113 = r14.getDeviceId();
    L98:
        if (KeyCharacterMap.load(r113).getKeyboardType() == 1) goto L100;
        boolean r114 = true;
    L101:
        r13.f608h.setQwertyMode(r114);
        r13.f608h.x();
        goto L102
    L100:
        r114 = false;
        goto L101
    L96:
        r113 = -1;
        goto L98
    L33:
        if (r13.f615o == false) goto L83;
    L29:
        if ((this.f599y instanceof t) == false) goto L30;
    L102:
        r13.f611k = true;
        r13.f612l = false;
        this.X = r13;
        return true;
    L20:
        r12 = true;
        goto L21
    }

    public final void Y() {
        if (this.K == true) goto L6;
        return;
    L6:
        throw new AndroidRuntimeException("Window feature must be requested before adding content");
    }

    public final void Z() {
        if (Build.VERSION.SDK_INT < 33) goto L22;
        boolean r8 = false;
        if (this.f592q0 != null) goto L8;
    L13:
        if (r8 == true) goto L15;
    L17:
        if (r8 == true) goto L24;
        OnBackInvokedCallback r10 = this.f593r0;
        if (r10 == null) goto L25;
        g.c(this.f592q0, r10);
        return;
    L25:
        return;
    L24:
        return;
    L15:
        if (this.f593r0 != null) goto L17;
        this.f593r0 = g.b(this.f592q0, this);
        return;
    L8:
        if (Q(0).f613m == false) goto L11;
    L12:
        r8 = true;
        goto L13
    L11:
        if (this.E == null) goto L13;
    }

    @Override // androidx.appcompat.view.menu.f.a
    public final boolean a(androidx.appcompat.view.menu.f r8, MenuItem r10) {
        Window.Callback r11 = R();
        if (r11 != null) goto L5;
    L21:
        return false;
    L5:
        if (this.f578b0 == true) goto L21;
        androidx.appcompat.view.menu.f r12 = r8.l();
        PanelFeatureState[] r13 = this.W;
        if (r13 == null) goto L9;
        int r14 = r13.length;
        int r15 = 0;
    L10:
        if (r15 >= r14) goto L17;
        PanelFeatureState r16 = r13[r15];
        if (r16 == null) goto L16;
        if (r16.f608h != r12) goto L16;
    L18:
        if (r16 == null) goto L21;
        return r11.onMenuItemSelected(r16.f601a, r10);
    L16:
        r15 = r15 + 1;
        goto L10
    L17:
        r16 = null;
        goto L18
    L9:
        r14 = 0;
        r15 = 0;
        goto L10
    }

    @Override // androidx.appcompat.view.menu.f.a
    public final void b(androidx.appcompat.view.menu.f r8) {
        b0 r10 = this.B;
        if (r10 != null) goto L5;
    L30:
        PanelFeatureState r11 = Q(0);
        r11.f614n = true;
        J(r11, false);
        V(r11, null);
        return;
    L5:
        if (r10.a() == false) goto L30;
        if (ViewConfiguration.get(this.f595u).hasPermanentMenuKey() == true) goto L9;
    L10:
        Window.Callback r12 = R();
        if (this.B.e() == false) goto L15;
        this.B.c();
        if (this.f578b0 == true) goto L32;
        r12.onPanelClosed(108, Q(0).f608h);
        return;
    L32:
        return;
    L15:
        if (r12 != null) goto L17;
        return;
    L17:
        if (this.f578b0 == false) goto L19;
        return;
    L19:
        if (this.f585j0 == true) goto L21;
    L23:
        PanelFeatureState r13 = Q(0);
        androidx.appcompat.view.menu.f r14 = r13.f608h;
        if (r14 != null) goto L26;
        return;
    L26:
        if (r13.f615o == false) goto L28;
        return;
    L28:
        if (r12.onPreparePanel(0, r13.f607g, r14) == false) goto L38;
        r12.onMenuOpened(108, r13.f608h);
        this.B.d();
        return;
    L38:
        return;
    L21:
        if ((1 & this.f586k0) == 0) goto L23;
        View r15 = this.f596v.getDecorView();
        a r16 = this.f587l0;
        r15.removeCallbacks(r16);
        r16.run();
        goto L23
    L9:
        if (this.B.g() == false) goto L30;
        goto L10
    }

    @Override // androidx.appcompat.app.h
    public final void c(View r8, ViewGroup.LayoutParams r10) {
        N();
        ((ViewGroup) this.L.findViewById(R.id.content)).addView(r8, r10);
        this.f597w.b(this.f596v.getCallback());
    }

    @Override // androidx.appcompat.app.h
    public final Context d(Context r10) {
        boolean r8 = true;
        this.Z = true;
        int r11 = this.d0;
        if (r11 != (-100)) goto L6;
        r11 = androidx.appcompat.app.h.f649b;
    L6:
        int r12 = T(r10, r11);
        boolean r13 = false;
        if (androidx.appcompat.app.h.m(r10) == true) goto L9;
    L35:
        f0.e r14 = G(r10);
        Configuration r15 = null;
        if (f576v0 == false) goto L43;
        if ((r10 instanceof ContextThemeWrapper) == false) goto L43;
        ((ContextThemeWrapper) r10).applyOverrideConfiguration(K(r10, r12, r14, null, false));     // Catch: IllegalStateException -> L127
        return r10;
    L43:
        if ((r10 instanceof g.d) == false) goto L48;
        ((g.d) r10).a(K(r10, r12, r14, null, false));     // Catch: IllegalStateException -> L128
        return r10;
    L48:
        if (f575u0 == true) goto L50;
        return r10;
    L50:
        Configuration r16 = new Configuration();
        r16.uiMode = -1;
        r16.fontScale = 0.0f;
        Configuration r17 = r10.createConfigurationContext(r16).getResources().getConfiguration();
        Configuration r18 = r10.getResources().getConfiguration();
        r17.uiMode = r18.uiMode;
        if (r17.equals(r18) == true) goto L118;
        r15 = new Configuration();
        r15.fontScale = 0.0f;
        if (r17.diff(r18) == 0) goto L118;
        float r19 = r17.fontScale;
        float r20 = r18.fontScale;
        if (r19 == r20) goto L58;
        r15.fontScale = r20;
    L58:
        int r21 = r17.mcc;
        int r22 = r18.mcc;
        if (r21 == r22) goto L61;
        r15.mcc = r22;
    L61:
        int r23 = r17.mnc;
        int r24 = r18.mnc;
        if (r23 == r24) goto L64;
        r15.mnc = r24;
    L64:
        f.a(r17, r18, r15);
        int r25 = r17.touchscreen;
        int r26 = r18.touchscreen;
        if (r25 == r26) goto L67;
        r15.touchscreen = r26;
    L67:
        int r27 = r17.keyboard;
        int r28 = r18.keyboard;
        if (r27 == r28) goto L70;
        r15.keyboard = r28;
    L70:
        int r29 = r17.keyboardHidden;
        int r30 = r18.keyboardHidden;
        if (r29 == r30) goto L73;
        r15.keyboardHidden = r30;
    L73:
        int r31 = r17.navigation;
        int r32 = r18.navigation;
        if (r31 == r32) goto L76;
        r15.navigation = r32;
    L76:
        int r33 = r17.navigationHidden;
        int r34 = r18.navigationHidden;
        if (r33 == r34) goto L79;
        r15.navigationHidden = r34;
    L79:
        int r35 = r17.orientation;
        int r36 = r18.orientation;
        if (r35 == r36) goto L82;
        r15.orientation = r36;
    L82:
        int r37 = r17.screenLayout & 15;
        int r38 = r18.screenLayout & 15;
        if (r37 == r38) goto L85;
        r15.screenLayout |= r38;
    L85:
        int r39 = r17.screenLayout & 192;
        int r40 = r18.screenLayout & 192;
        if (r39 == r40) goto L88;
        r15.screenLayout |= r40;
    L88:
        int r41 = r17.screenLayout & 48;
        int r42 = r18.screenLayout & 48;
        if (r41 == r42) goto L91;
        r15.screenLayout |= r42;
    L91:
        int r43 = r17.screenLayout & 768;
        int r44 = r18.screenLayout & 768;
        if (r43 == r44) goto L94;
        r15.screenLayout |= r44;
    L94:
        int r45 = r17.colorMode & 3;
        int r46 = r18.colorMode & 3;
        if (r45 == r46) goto L97;
        r15.colorMode |= r46;
    L97:
        int r47 = r17.colorMode & 12;
        int r48 = r18.colorMode & 12;
        if (r47 == r48) goto L100;
        r15.colorMode |= r48;
    L100:
        int r49 = r17.uiMode & 15;
        int r50 = r18.uiMode & 15;
        if (r49 == r50) goto L103;
        r15.uiMode |= r50;
    L103:
        int r51 = r17.uiMode & 48;
        int r52 = r18.uiMode & 48;
        if (r51 == r52) goto L106;
        r15.uiMode |= r52;
    L106:
        int r53 = r17.screenWidthDp;
        int r54 = r18.screenWidthDp;
        if (r53 == r54) goto L109;
        r15.screenWidthDp = r54;
    L109:
        int r55 = r17.screenHeightDp;
        int r56 = r18.screenHeightDp;
        if (r55 == r56) goto L112;
        r15.screenHeightDp = r56;
    L112:
        int r57 = r17.smallestScreenWidthDp;
        int r58 = r18.smallestScreenWidthDp;
        if (r57 == r58) goto L115;
        r15.smallestScreenWidthDp = r58;
    L115:
        int r59 = r17.densityDpi;
        int r60 = r18.densityDpi;
        if (r59 == r60) goto L118;
        r15.densityDpi = r60;
    L118:
        Configuration r61 = K(r10, r12, r14, r15, true);
        g.d r62 = new g.d(r10, com.obric.cae.R.style.Theme_AppCompat_Empty);
        r62.a(r61);
        if (r10.getTheme() != null) goto L123;
        r8 = false;
    L123:
        r13 = r8;
    L124:
        if (r13 == false) goto L126;
        z.h.a(r62.getTheme());
    L126:
        return r62;
    L9:
        if (androidx.appcompat.app.h.m(r10) == false) goto L35;
        if (f0.a.a() == true) goto L14;
        Object r63 = androidx.appcompat.app.h.f656s;
        monitor-enter(r63);
        f0.e r64 = androidx.appcompat.app.h.f650m;     // Catch: Throwable -> L32
        if (r64 != null) goto L28;
        if (androidx.appcompat.app.h.f651n != null) goto L24;
        androidx.appcompat.app.h.f651n = f0.e.a(s.b(r10));     // Catch: Throwable -> L32
    L24:
        if (androidx.appcompat.app.h.f651n.f7237a.isEmpty() == true) goto L30;
        androidx.appcompat.app.h.f650m = androidx.appcompat.app.h.f651n;     // Catch: Throwable -> L32
    L30:
        monitor-exit(r63);     // Catch: Throwable -> L32
        goto L35
    L28:
        if (r64.equals(androidx.appcompat.app.h.f651n) == true) goto L30;
        f0.e r65 = androidx.appcompat.app.h.f650m;     // Catch: Throwable -> L32
        androidx.appcompat.app.h.f651n = r65;     // Catch: Throwable -> L32
        s.a(r10, r65.f7237a.a());     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    L14:
        if (androidx.appcompat.app.h.f653p == true) goto L35;
        androidx.appcompat.app.h.f648a.execute(new androidx.appcompat.app.g(r10, 0));
        goto L35
    }

    @Override // androidx.appcompat.app.h
    public final <T extends View> T e(int r8) {
        N();
        return (T) this.f596v.findViewById(r8);
    }

    @Override // androidx.appcompat.app.h
    public final Context f() {
        return this.f595u;
    }

    @Override // androidx.appcompat.app.h
    public final b g() {
        return new b();
    }

    @Override // androidx.appcompat.app.h
    public final int h() {
        return this.d0;
    }

    @Override // androidx.appcompat.app.h
    public final MenuInflater i() {
        if (this.f600z != null) goto L10;
        S();
        androidx.appcompat.app.a r8 = this.f599y;
        if (r8 == null) goto L7;
        Context r10 = r8.e();
    L8:
        this.f600z = new g.g(r10);
        goto L10
    L7:
        r10 = this.f595u;
    L10:
        return this.f600z;
    }

    @Override // androidx.appcompat.app.h
    public final androidx.appcompat.app.a j() {
        S();
        return this.f599y;
    }

    @Override // androidx.appcompat.app.h
    public final void k() {
        LayoutInflater r8 = LayoutInflater.from(this.f595u);
        if (r8.getFactory() != null) goto L6;
        r8.setFactory2(this);
        return;
    L6:
        if ((r8.getFactory2() instanceof AppCompatDelegateImpl) == true) goto L10;
        Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        return;
    }

    @Override // androidx.appcompat.app.h
    public final void l() {
        if (this.f599y == null) goto L11;
        S();
        if (this.f599y.f() == true) goto L13;
        this.f586k0 |= 1;
        if (this.f585j0 == true) goto L12;
        View r8 = this.f596v.getDecorView();
        WeakHashMap<View, h0> r10 = j0.w.f8437a;
        j0.w.d.m(r8, this.f587l0);
        this.f585j0 = true;
        return;
    L12:
        return;
    L13:
        return;
    }

    @Override // androidx.appcompat.app.h
    public final void n(Configuration r8) {
        if (this.Q == true) goto L5;
    L9:
        androidx.appcompat.widget.j r10 = androidx.appcompat.widget.j.a();
        Context r11 = this.f595u;
        monitor-enter(r10);
        l0 r12 = r10.f1193a;     // Catch: Throwable -> L23
        monitor-enter(r12);     // Catch: Throwable -> L23
        n.e<WeakReference<Drawable.ConstantState>> r13 = r12.f1212b.get(r11);     // Catch: Throwable -> L20
        if (r13 == null) goto L16;
        r13.a();     // Catch: Throwable -> L20
    L16:
        monitor-exit(r12);     // Catch: Throwable -> L23
        monitor-exit(r10);
        this.f579c0 = new Configuration(this.f595u.getResources().getConfiguration());
        E(false, false);
        return;
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    L5:
        if (this.K == false) goto L9;
        S();
        androidx.appcompat.app.a r14 = this.f599y;
        if (r14 == null) goto L9;
        r14.g();
        goto L9
    }

    @Override // androidx.appcompat.app.h
    public final void o() {
        this.Z = true;
        E(false, true);
        O();
        Object r8 = this.f594t;
        if ((r8 instanceof Activity) == true) goto L26;
    L24:
        this.f579c0 = new Configuration(this.f595u.getResources().getConfiguration());
        this.f577a0 = true;
        return;
    L26:
        Activity r10 = (Activity) r8;     // Catch: IllegalArgumentException -> L10
        String r11 = androidx.core.app.g.b(r10, r10.getComponentName());     // Catch: PackageManager.NameNotFoundException -> L7 IllegalArgumentException -> L10
    L11:
        if (r11 == null) goto L16;
        androidx.appcompat.app.a r12 = this.f599y;
        if (r12 != null) goto L15;
        this.f588m0 = true;
        goto L16
    L15:
        r12.l(true);
    L16:
        Object r13 = androidx.appcompat.app.h.f655r;
        monitor-enter(r13);
        androidx.appcompat.app.h.v(this);     // Catch: Throwable -> L21
        androidx.appcompat.app.h.f654q.add(new WeakReference(this));     // Catch: Throwable -> L21
        monitor-exit(r13);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    L7:
        e = move-exception;
        throw new IllegalArgumentException(e);     // Catch: IllegalArgumentException -> L10
    L10:
        r11 = null;
        goto L11
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View r8, String r10, Context r11, AttributeSet r12) {
        if (this.f591p0 != null) goto L12;
        int[] r13 = c.a.f3224j;
        Context r14 = this.f595u;
        String r15 = r14.obtainStyledAttributes(r13).getString(116);
        if (r15 != null) goto L136;
        p r16 = new p();
    L11:
        this.f591p0 = r16;
        goto L12
    L136:
        this.f591p0 = (p) r14.getClassLoader().loadClass(r15).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + r15 + ". Falling back to default.", th);
        r16 = new p();
    L12:
        p r17 = this.f591p0;
        int r18 = a1.f1102a;
        r17.getClass();
        TypedArray r19 = r11.obtainStyledAttributes(r12, c.a.f3240z, 0, 0);
        byte r20 = 4;
        int r21 = r19.getResourceId(4, 0);
        if (r21 == 0) goto L15;
        Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
    L15:
        r19.recycle();
        if (r21 != 0) goto L18;
    L22:
        Context r22 = r11;
    L23:
        r10.getClass();
        switch(r10.hashCode()) {
            case -1946472170: goto L78;
            case -1455429095: goto L74;
            case -1346021293: goto L70;
            case -938935918: goto L66;
            case -937446323: goto L63;
            case -658531749: goto L59;
            case -339785223: goto L55;
            case 776382189: goto L51;
            case 799298502: goto L47;
            case 1125864064: goto L43;
            case 1413872058: goto L39;
            case 1601505219: goto L35;
            case 1666676343: goto L31;
            case 2001146706: goto L27;
            default: goto L81;
        };
    L81:
        r20 = -1;
    L82:
        View r23 = null;
        switch(r20) {
            case 0: goto L102;
            case 1: goto L101;
            case 2: goto L100;
            case 3: goto L95;
            case 4: goto L94;
            case 5: goto L93;
            case 6: goto L92;
            case 7: goto L91;
            case 8: goto L90;
            case 9: goto L89;
            case 10: goto L88;
            case 11: goto L87;
            case 12: goto L86;
            case 13: goto L85;
            default: goto L84;
        };
    L84:
        View r24 = null;
    L103:
        if (r24 != null) goto L125;
        if (r11 == r22) goto L125;
        Object[] r110 = r17.f669a;
        if (r10.equals("view") == false) goto L138;
        r10 = r12.getAttributeValue(null, StarLocationDbManager.GeofenceCallbackEntry.CLASS_NAME);
    L138:
        r110[0] = r22;     // Catch: Throwable -> L120 Exception -> L123
        r110[1] = r12;     // Catch: Throwable -> L120 Exception -> L123
        if ((-1) != r10.indexOf(46)) goto L118;
        int r25 = 0;
    L111:
        String[] r26 = p.f667d;     // Catch: Throwable -> L120 Exception -> L123
        if (r25 >= 3) goto L117;
        View r27 = r17.f(r22, r10, r26[r25]);     // Catch: Throwable -> L120 Exception -> L123
        if (r27 != null) goto L115;
        r25 = r25 + 1;
        goto L111
    L115:
        r110[0] = null;
        r110[1] = null;
        r23 = r27;
    L124:
        r24 = r23;
        goto L125
    L117:
        r110[0] = null;
        r110[1] = null;
        goto L124
    L118:
        View r28 = r17.f(r22, r10, null);     // Catch: Throwable -> L120 Exception -> L123
        r110[0] = null;
        r110[1] = null;
        r23 = r28;
    L123:
        r110[0] = null;
        r110[1] = null;
    L120:
        th = move-exception;
        r110[0] = null;
        r110[1] = null;
        throw th;
    L125:
        if (r24 == null) goto L135;
        Context r29 = r24.getContext();
        if ((r29 instanceof ContextWrapper) == false) goto L135;
        WeakHashMap<View, h0> r30 = j0.w.f8437a;
        if (j0.w.c.a(r24) == false) goto L135;
        TypedArray r31 = r29.obtainStyledAttributes(r12, p.f666c);
        String r32 = r31.getString(0);
        if (r32 == null) goto L134;
        r24.setOnClickListener(new p.a(r24, r32));
    L134:
        r31.recycle();
    L135:
        return r24;
    L85:
        r24 = r17.b(r22, r12);
    L96:
        if (r24 != null) goto L103;
        throw new IllegalStateException(r17.getClass().getName() + " asked to inflate view for <" + r10 + ">, but returned null");
    L86:
        r24 = new AppCompatEditText(r22, r12);
        goto L103
    L87:
        r24 = r17.c(r22, r12);
        goto L96
    L88:
        r24 = r17.a(r22, r12);
        goto L96
    L89:
        r24 = new AppCompatImageView(r22, r12);
        goto L103
    L90:
        r24 = new a0(r22, r12);
        goto L103
    L91:
        r24 = r17.d(r22, r12);
        goto L96
    L92:
        r24 = new AppCompatSpinner(r22, r12, com.obric.cae.R.attr.spinnerStyle);
        goto L103
    L93:
        r24 = new androidx.appcompat.widget.t(r22, r12);
        goto L103
    L94:
        r24 = new androidx.appcompat.widget.m(r22, r12);
        goto L103
    L95:
        r24 = r17.e(r22, r12);
        goto L96
    L100:
        r24 = new androidx.appcompat.widget.o(r22, r12);
        goto L103
    L101:
        r24 = new androidx.appcompat.widget.g(r22, r12);
        goto L103
    L102:
        r24 = new androidx.appcompat.widget.s(r22, r12);
        goto L103
    L27:
        if (r10.equals("Button") == false) goto L141;
        r20 = 13;
        goto L82
    L141:
        r20 = -1;
        goto L82
    L31:
        if (r10.equals("EditText") == false) goto L142;
        r20 = 12;
        goto L82
    L142:
        r20 = -1;
        goto L82
    L35:
        if (r10.equals("CheckBox") == false) goto L143;
        r20 = 11;
        goto L82
    L143:
        r20 = -1;
        goto L82
    L39:
        if (r10.equals("AutoCompleteTextView") == false) goto L144;
        r20 = 10;
        goto L82
    L144:
        r20 = -1;
        goto L82
    L43:
        if (r10.equals("ImageView") == false) goto L145;
        r20 = 9;
        goto L82
    L145:
        r20 = -1;
        goto L82
    L47:
        if (r10.equals("ToggleButton") == false) goto L146;
        r20 = 8;
        goto L82
    L146:
        r20 = -1;
        goto L82
    L51:
        if (r10.equals("RadioButton") == false) goto L147;
        r20 = 7;
        goto L82
    L147:
        r20 = -1;
        goto L82
    L55:
        if (r10.equals("Spinner") == false) goto L148;
        r20 = 6;
        goto L82
    L148:
        r20 = -1;
        goto L82
    L59:
        if (r10.equals("SeekBar") == false) goto L149;
        r20 = 5;
        goto L82
    L149:
        r20 = -1;
        goto L82
    L63:
        if (r10.equals("ImageButton") == true) goto L82;
        r20 = -1;
        goto L82
    L66:
        if (r10.equals("TextView") == false) goto L151;
        r20 = 3;
        goto L82
    L151:
        r20 = -1;
        goto L82
    L70:
        if (r10.equals("MultiAutoCompleteTextView") == false) goto L152;
        r20 = 2;
        goto L82
    L152:
        r20 = -1;
        goto L82
    L74:
        if (r10.equals("CheckedTextView") == false) goto L153;
        r20 = 1;
        goto L82
    L153:
        r20 = -1;
        goto L82
    L78:
        if (r10.equals("RatingBar") == false) goto L154;
        r20 = 0;
        goto L82
    L154:
        r20 = -1;
        goto L82
    L18:
        if ((r11 instanceof g.d) == true) goto L20;
    L21:
        r22 = new g.d(r11, r21);
        goto L23
    L20:
        if (((g.d) r11).f7438a == r21) goto L22;
        goto L21
    }

    @Override // androidx.appcompat.app.h
    public final void p() {
        if ((this.f594t instanceof Activity) == false) goto L13;
        Object r8 = androidx.appcompat.app.h.f655r;
        monitor-enter(r8);
        androidx.appcompat.app.h.v(this);     // Catch: Throwable -> L9
        monitor-exit(r8);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L13:
        if (this.f585j0 == false) goto L15;
        this.f596v.getDecorView().removeCallbacks(this.f587l0);
    L15:
        this.f578b0 = true;
        if (this.d0 == (-100)) goto L22;
        Object r10 = this.f594t;
        if ((r10 instanceof Activity) == false) goto L22;
        if (((Activity) r10).isChangingConfigurations() == false) goto L22;
        f573s0.put(this.f594t.getClass().getName(), Integer.valueOf(this.d0));
    L23:
        androidx.appcompat.app.a r11 = this.f599y;
        if (r11 == null) goto L26;
        r11.h();
    L26:
        k r12 = this.f583h0;
        if (r12 == null) goto L29;
        r12.a();
    L29:
        i r13 = this.f584i0;
        if (r13 == null) goto L35;
        r13.a();
        return;
    L35:
        return;
    L22:
        f573s0.remove(this.f594t.getClass().getName());
        goto L23
    }

    @Override // androidx.appcompat.app.h
    public final void q() {
        N();
    }

    @Override // androidx.appcompat.app.h
    public final void r() {
        S();
        androidx.appcompat.app.a r8 = this.f599y;
        if (r8 == null) goto L6;
        r8.m(true);
        return;
    }

    @Override // androidx.appcompat.app.h
    public final void s() {
    }

    @Override // androidx.appcompat.app.h
    public final void t() {
        E(true, false);
    }

    @Override // androidx.appcompat.app.h
    public final void u() {
        S();
        androidx.appcompat.app.a r8 = this.f599y;
        if (r8 == null) goto L6;
        r8.m(false);
        return;
    }

    @Override // androidx.appcompat.app.h
    public final boolean w(int r8) {
        if (r8 != 8) goto L6;
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
        r8 = 108;
    L9:
        if (this.U == false) goto L13;
        if (r8 != 108) goto L13;
        return false;
    L13:
        if (this.Q == false) goto L16;
        if (r8 != 1) goto L16;
        this.Q = false;
    L16:
        if (r8 != 1) goto L18;
        Y();
        this.U = true;
        return true;
    L18:
        if (r8 != 2) goto L20;
        Y();
        this.O = true;
        return true;
    L20:
        if (r8 != 5) goto L22;
        Y();
        this.P = true;
        return true;
    L22:
        if (r8 == 10) goto L31;
        if (r8 == 108) goto L29;
        if (r8 != 109) goto L26;
        Y();
        this.R = true;
        return true;
    L26:
        return this.f596v.requestFeature(r8);
    L29:
        Y();
        this.Q = true;
        return true;
    L31:
        Y();
        this.S = true;
        return true;
    L6:
        if (r8 != 9) goto L9;
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        r8 = 109;
        goto L9
    }

    @Override // androidx.appcompat.app.h
    public final void x(int r8) {
        N();
        ViewGroup r10 = (ViewGroup) this.L.findViewById(R.id.content);
        r10.removeAllViews();
        LayoutInflater.from(this.f595u).inflate(r8, r10);
        this.f597w.b(this.f596v.getCallback());
    }

    @Override // androidx.appcompat.app.h
    public final void y(View r8) {
        N();
        ViewGroup r10 = (ViewGroup) this.L.findViewById(R.id.content);
        r10.removeAllViews();
        r10.addView(r8);
        this.f597w.b(this.f596v.getCallback());
    }

    @Override // androidx.appcompat.app.h
    public final void z(View r8, ViewGroup.LayoutParams r10) {
        N();
        ViewGroup r11 = (ViewGroup) this.L.findViewById(R.id.content);
        r11.removeAllViews();
        r11.addView(r8, r10);
        this.f597w.b(this.f596v.getCallback());
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String r8, Context r10, AttributeSet r11) {
        return onCreateView(null, r8, r10, r11);
    }
}
