package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.lifecycle.l0;
import com.obric.cae.R;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentManager {
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public ArrayList<androidx.fragment.app.a> E;
    public ArrayList<Boolean> F;
    public ArrayList<Fragment> G;
    public v H;
    public final g I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<k> f1862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y f1864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList<androidx.fragment.app.a> f1865d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList<Fragment> f1866e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final s f1867f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public OnBackPressedDispatcher f1868g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f1869h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicInteger f1870i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<String, Bundle> f1871j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<String, Object> f1872k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<Fragment, HashSet<f0.d>> f1873l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final t f1874m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final CopyOnWriteArrayList<w> f1875n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f1876o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public r<?> f1877p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public o f1878q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Fragment f1879r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Fragment f1880s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final e f1881t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final f f1882u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public androidx.activity.result.d f1883v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public androidx.activity.result.d f1884w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public androidx.activity.result.d f1885x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ArrayDeque<LaunchedFragmentInfo> f1886y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f1887z;

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentManager$6, reason: invalid class name */
    class AnonymousClass6 implements androidx.lifecycle.k {
        @Override // androidx.lifecycle.k
        public final void onStateChanged(androidx.lifecycle.m r8, androidx.lifecycle.h.a r10) {
            if (r10 != androidx.lifecycle.h.a.ON_START) goto L5;
            throw null;
        L5:
            if (r10 == androidx.lifecycle.h.a.ON_DESTROY) goto L7;
            return;
        L7:
            throw null;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f1888a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1889b;

        public class a implements Parcelable.Creator<LaunchedFragmentInfo> {
            @Override // android.os.Parcelable.Creator
            public final LaunchedFragmentInfo createFromParcel(Parcel r8) {
                return new LaunchedFragmentInfo(r8);
            }

            @Override // android.os.Parcelable.Creator
            public final LaunchedFragmentInfo[] newArray(int r8) {
                return new LaunchedFragmentInfo[r8];
            }
        }

        static {
            CREATOR = new a();
        }

        public LaunchedFragmentInfo(Parcel r8) {
            this.f1888a = r8.readString();
            this.f1889b = r8.readInt();
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r8, int r10) {
            r8.writeString(this.f1888a);
            r8.writeInt(this.f1889b);
        }

        public LaunchedFragmentInfo(String r8, int r10) {
            this.f1888a = r8;
            this.f1889b = r10;
        }
    }

    public class a implements androidx.activity.result.a<ActivityResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FragmentManager f1890a;

        public a(FragmentManager r8) {
            this.f1890a = r8;
        }

        @Override // androidx.activity.result.a
        public final void a(ActivityResult r8) {
            ActivityResult r10 = r8;
            FragmentManager r11 = this.f1890a;
            LaunchedFragmentInfo r12 = r11.f1886y.pollFirst();
            if (r12 != null) goto L6;
            String r13 = "No IntentSenders were started for " + this;
        L5:
            Log.w("FragmentManager", r13);
            return;
        L6:
            y r14 = r11.f1864c;
            String r15 = r12.f1888a;
            Fragment r16 = r14.c(r15);
            if (r16 != null) goto L9;
            r13 = "Intent Sender result delivered for unknown Fragment " + r15;
            goto L5
        L9:
            r16.onActivityResult(r12.f1889b, r10.f505a, r10.f506b);
        }
    }

    public class b implements androidx.activity.result.a<Map<String, Boolean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FragmentManager f1891a;

        public b(FragmentManager r8) {
            this.f1891a = r8;
        }

        @Override // androidx.activity.result.a
        @SuppressLint({"SyntheticAccessor"})
        public final void a(Map<String, Boolean> r8) {
            Map<String, Boolean> r10 = r8;
            String[] r11 = (String[]) r10.keySet().toArray(new String[0]);
            ArrayList r12 = new ArrayList(r10.values());
            int[] r13 = new int[r12.size()];
            int r14 = 0;
        L4:
            if (r14 >= r12.size()) goto L10;
            if (((Boolean) r12.get(r14)).booleanValue() == false) goto L8;
            int r15 = 0;
        L9:
            r13[r14] = r15;
            r14 = r14 + 1;
            goto L4
        L8:
            r15 = -1;
            goto L9
        L10:
            FragmentManager r16 = this.f1891a;
            LaunchedFragmentInfo r17 = r16.f1886y.pollFirst();
            if (r17 != null) goto L14;
            String r18 = "No permissions were requested for " + this;
        L13:
            Log.w("FragmentManager", r18);
            return;
        L14:
            y r19 = r16.f1864c;
            String r20 = r17.f1888a;
            Fragment r21 = r19.c(r20);
            if (r21 != null) goto L17;
            r18 = "Permission request result delivered for unknown Fragment " + r20;
            goto L13
        L17:
            r21.onRequestPermissionsResult(r17.f1889b, r11, r13);
        }
    }

    public class c extends androidx.activity.n {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ FragmentManager f1892d;

        public c(FragmentManager r8) {
            this.f1892d = r8;
        }

        @Override // androidx.activity.n
        public final void a() {
            FragmentManager r8 = this.f1892d;
            r8.x(true);
            if (r8.f1869h.f498a == false) goto L5;
            r8.L();
            return;
        L5:
            r8.f1868g.b();
        }
    }

    public class d {
        public d(FragmentManager r8) {
        }
    }

    public class e extends q {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FragmentManager f1893b;

        public e(FragmentManager r8) {
            this.f1893b = r8;
        }
    }

    public class f implements j0 {
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FragmentManager f1894a;

        public g(FragmentManager r8) {
            this.f1894a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f1894a.x(true);
        }
    }

    public class h implements w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Fragment f1895a;

        public h(Fragment r8) {
            this.f1895a = r8;
        }

        @Override // androidx.fragment.app.w
        public final void a(Fragment r8) {
            this.f1895a.onAttachFragment(r8);
        }
    }

    public class i implements androidx.activity.result.a<ActivityResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FragmentManager f1896a;

        public i(FragmentManager r8) {
            this.f1896a = r8;
        }

        @Override // androidx.activity.result.a
        public final void a(ActivityResult r8) {
            ActivityResult r10 = r8;
            FragmentManager r11 = this.f1896a;
            LaunchedFragmentInfo r12 = r11.f1886y.pollFirst();
            if (r12 != null) goto L6;
            String r13 = "No Activities were started for result for " + this;
        L5:
            Log.w("FragmentManager", r13);
            return;
        L6:
            y r14 = r11.f1864c;
            String r15 = r12.f1888a;
            Fragment r16 = r14.c(r15);
            if (r16 != null) goto L9;
            r13 = "Activity result delivered for unknown Fragment " + r15;
            goto L5
        L9:
            r16.onActivityResult(r12.f1889b, r10.f505a, r10.f506b);
        }
    }

    public static class j extends b.a<IntentSenderRequest, ActivityResult> {
        @Override // b.a
        public final Intent a(ComponentActivity r8, Object r10) {
            IntentSenderRequest r11 = (IntentSenderRequest) r10;
            Intent r12 = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent r13 = r11.f512b;
            if (r13 == null) goto L9;
            Bundle r14 = r13.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            if (r14 == null) goto L9;
            r12.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", r14);
            r13.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            if (r13.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false) == false) goto L9;
            IntentSenderRequest.a r15 = new IntentSenderRequest.a(r11.f511a);
            int r16 = r11.f514n;
            r11 = new IntentSenderRequest(r15.f515a, null, r11.f513m, r16);
        L9:
            r12.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", r11);
            if (FragmentManager.G(2) == false) goto L12;
            Log.v("FragmentManager", "CreateIntent created the following intent: " + r12);
        L12:
            return r12;
        }

        @Override // b.a
        public final Object c(Intent r8, int r10) {
            return new ActivityResult(r8, r10);
        }
    }

    public interface k {
        boolean a(ArrayList<androidx.fragment.app.a> r8, ArrayList<Boolean> r10);
    }

    public class l implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f1897a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1898b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FragmentManager f1899c;

        public l(FragmentManager r8, int r10) {
            this.f1899c = r8;
            this.f1897a = r10;
            this.f1898b = 1;
        }

        @Override // androidx.fragment.app.FragmentManager.k
        public final boolean a(ArrayList<androidx.fragment.app.a> r8, ArrayList<Boolean> r10) {
            Fragment r11 = this.f1899c.f1880s;
            if (r11 == null) goto L11;
            if (this.f1897a >= 0) goto L11;
            if (r11.getChildFragmentManager().L() == false) goto L11;
            return false;
        L11:
            return this.f1899c.M(r8, r10, null, this.f1897a, this.f1898b);
        }
    }

    public static class m implements Fragment.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1900a;
    }

    public FragmentManager() {
        this.f1862a = new ArrayList();
        this.f1864c = new y();
        this.f1867f = new s(this);
        this.f1869h = new c(this);
        this.f1870i = new AtomicInteger();
        this.f1871j = Collections.synchronizedMap(new HashMap());
        this.f1872k = Collections.synchronizedMap(new HashMap());
        this.f1873l = Collections.synchronizedMap(new HashMap());
        new d(this);
        this.f1874m = new t(this);
        this.f1875n = new CopyOnWriteArrayList();
        this.f1876o = -1;
        this.f1881t = new e(this);
        this.f1882u = new f();
        this.f1886y = new ArrayDeque();
        this.I = new g(this);
    }

    public static boolean G(int r8) {
        if (Log.isLoggable("FragmentManager", r8) == false) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean H(Fragment r8) {
        if (r8.mHasMenu == true) goto L5;
    L6:
        Iterator r10 = r8.mChildFragmentManager.f1864c.e().iterator();
        boolean r11 = false;
    L8:
        if (r10.hasNext() == false) goto L14;
        Fragment r12 = (Fragment) r10.next();
        if (r12 == null) goto L12;
        r11 = H(r12);
    L12:
        if (r11 == false) goto L8;
        boolean r13 = true;
    L15:
        if (r13 == false) goto L18;
        return true;
    L18:
        return false;
    L14:
        r13 = false;
        goto L15
    L5:
        if (r8.mMenuVisible == false) goto L6;
        return true;
    }

    public static boolean I(Fragment r8) {
        if (r8 != null) goto L5;
        return true;
    L5:
        FragmentManager r10 = r8.mFragmentManager;
        if (r8.equals(r10.f1880s) == true) goto L8;
    L10:
        return false;
    L8:
        if (I(r10.f1879r) == false) goto L10;
        return true;
    }

    public static void W(Fragment r8) {
        if (G(2) == false) goto L6;
        Log.v("FragmentManager", "show: " + r8);
    L6:
        if (r8.mHidden == false) goto L9;
        r8.mHidden = false;
        r8.mHiddenChanged = !r8.mHiddenChanged;
        return;
    }

    public final Fragment A(String r8) {
        return this.f1864c.b(r8);
    }

    public final Fragment B(int r8) {
        y r10 = this.f1864c;
        ArrayList<Fragment> r11 = r10.f2064a;
        int r12 = r11.size();
    L3:
        r12 = r12 - 1;
        if (r12 < 0) goto L10;
        Fragment r13 = r11.get(r12);
        if (r13 == null) goto L3;
        if (r13.mFragmentId != r8) goto L3;
        return r13;
    L10:
        Iterator<x> r14 = r10.f2065b.values().iterator();
    L12:
        if (r14.hasNext() == false) goto L18;
        x r15 = r14.next();
        if (r15 == null) goto L12;
        Fragment r16 = r15.f2060c;
        if (r16.mFragmentId != r8) goto L12;
        return r16;
    L18:
        return null;
    }

    public final ViewGroup C(Fragment r8) {
        ViewGroup r10 = r8.mContainer;
        if (r10 == null) goto L6;
        return r10;
    L6:
        if (r8.mContainerId > 0) goto L9;
        return null;
    L9:
        if (this.f1878q.c() == false) goto L14;
        View r11 = this.f1878q.b(r8.mContainerId);
        if ((r11 instanceof ViewGroup) == false) goto L14;
        return (ViewGroup) r11;
    L14:
        return null;
    }

    public final q D() {
        Fragment r8 = this.f1879r;
        if (r8 == null) goto L7;
        return r8.mFragmentManager.D();
    L7:
        return this.f1881t;
    }

    public final j0 E() {
        Fragment r8 = this.f1879r;
        if (r8 == null) goto L7;
        return r8.mFragmentManager.E();
    L7:
        return this.f1882u;
    }

    public final void F(Fragment r8) {
        if (G(2) == false) goto L6;
        Log.v("FragmentManager", "hide: " + r8);
    L6:
        if (r8.mHidden == true) goto L9;
        r8.mHidden = true;
        r8.mHiddenChanged = true ^ r8.mHiddenChanged;
        V(r8);
        return;
    }

    public final void J(int r8, boolean r10) {
        if (this.f1877p == null) goto L5;
    L9:
        if (r10 == false) goto L11;
    L13:
        this.f1876o = r8;
        y r11 = this.f1864c;
        Iterator<Fragment> r12 = r11.f2064a.iterator();
    L14:
        boolean r13 = r12.hasNext();
        HashMap<String, x> r14 = r11.f2065b;
        if (r13 == false) goto L19;
        x r15 = r14.get(r12.next().mWho);
        if (r15 == null) goto L14;
        r15.k();
        goto L14
    L19:
        Iterator<x> r16 = r14.values().iterator();
    L20:
        boolean r17 = false;
        if (r16.hasNext() == false) goto L31;
        x r18 = r16.next();
        if (r18 == null) goto L20;
        r18.k();
        Fragment r19 = r18.f2060c;
        if (r19.mRemoving == true) goto L27;
    L29:
        if (r17 == false) goto L20;
        r11.h(r18);
        goto L20
    L27:
        if (r19.isInBackStack() == true) goto L29;
        r17 = true;
        goto L29
    L31:
        X();
        if (this.f1887z == false) goto L51;
        r<?> r20 = this.f1877p;
        if (r20 != null) goto L36;
        return;
    L36:
        if (this.f1876o != 7) goto L53;
        r20.g();
        this.f1887z = false;
        return;
    L53:
        return;
    L51:
        return;
    L11:
        if (r8 != this.f1876o) goto L13;
        return;
    L5:
        if (r8 == (-1)) goto L9;
        throw new IllegalStateException("No activity");
    }

    public final void K() {
        if (this.f1877p != null) goto L5;
        return;
    L5:
        this.A = false;
        this.B = false;
        this.H.f2057i = false;
        Iterator<Fragment> r8 = this.f1864c.f().iterator();
    L7:
        if (r8.hasNext() == false) goto L11;
        Fragment r10 = r8.next();
        if (r10 == null) goto L7;
        r10.noteStateNotSaved();
        goto L7
    }

    public final boolean L() {
        x(false);
        w(true);
        Fragment r8 = this.f1880s;
        if (r8 != null) goto L5;
    L7:
        boolean r10 = M(this.E, this.F, null, -1, 0);
        if (r10 == false) goto L15;
        this.f1863b = true;
        O(this.E, this.F);     // Catch: Throwable -> L12
        e();
    L12:
        th = move-exception;
        e();
        throw th;
    L15:
        Y();
        if (this.D == false) goto L18;
        this.D = false;
        X();
    L18:
        this.f1864c.f2065b.values().removeAll(Collections.singleton(null));
        return r10;
    L5:
        if (r8.getChildFragmentManager().L() == false) goto L7;
        return true;
    }

    public final boolean M(ArrayList<androidx.fragment.app.a> r8, ArrayList<Boolean> r10, String r11, int r12, int r13) {
        ArrayList<androidx.fragment.app.a> r14 = this.f1865d;
        if (r14 != null) goto L6;
        return false;
    L6:
        if (r11 != null) goto L14;
        if (r12 >= 0) goto L14;
        if ((r13 & 1) != 0) goto L14;
        int r15 = r14.size() - 1;
        if (r15 >= 0) goto L13;
        return false;
    L13:
        r8.add(this.f1865d.remove(r15));
        r10.add(Boolean.TRUE);
    L50:
        return true;
    L14:
        int r16 = -1;
        if (r11 != null) goto L17;
        if (r12 >= 0) goto L17;
    L45:
        if (r16 != (this.f1865d.size() - 1)) goto L47;
        return false;
    L47:
        int r17 = this.f1865d.size() - 1;
    L48:
        if (r17 <= r16) goto L50;
        r8.add(this.f1865d.remove(r17));
        r10.add(Boolean.TRUE);
        r17 = r17 - 1;
    L17:
        int r18 = r14.size() - 1;
    L18:
        if (r18 < 0) goto L29;
        androidx.fragment.app.a r19 = this.f1865d.get(r18);
        if (r11 != null) goto L22;
    L24:
        if (r12 < 0) goto L28;
        if (r12 == r19.f1925s) goto L29;
    L28:
        r18 = r18 - 1;
        goto L18
    L22:
        if (r11.equals(r19.f2075i) == false) goto L24;
    L29:
        if (r18 >= 0) goto L32;
        return false;
    L32:
        if ((r13 & 1) == 0) goto L43;
    L33:
        r18 = r18 - 1;
        if (r18 < 0) goto L43;
        androidx.fragment.app.a r110 = this.f1865d.get(r18);
        if (r11 == null) goto L39;
        if (r11.equals(r110.f2075i) == true) goto L33;
    L39:
        if (r12 < 0) goto L43;
        if (r12 == r110.f1925s) goto L33;
    L43:
        r16 = r18;
        goto L45
    }

    public final void N(Fragment r8) {
        if (G(2) == false) goto L5;
        Log.v("FragmentManager", "remove: " + r8 + " nesting=" + r8.mBackStackNesting);
    L5:
        boolean r10 = !r8.isInBackStack();
        if (r8.mDetached == false) goto L8;
        if (r10 == true) goto L8;
        return;
    L8:
        y r11 = this.f1864c;
        ArrayList<Fragment> r12 = r11.f2064a;
        monitor-enter(r12);
        r11.f2064a.remove(r8);     // Catch: Throwable -> L17
        monitor-exit(r12);     // Catch: Throwable -> L17
        r8.mAdded = false;
        if (H(r8) == false) goto L15;
        this.f1887z = true;
    L15:
        r8.mRemoving = true;
        V(r8);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public final void O(ArrayList<androidx.fragment.app.a> r8, ArrayList<Boolean> r10) {
        if (r8.isEmpty() == false) goto L6;
        return;
    L6:
        if (r8.size() != r10.size()) goto L27;
        int r11 = r8.size();
        int r12 = 0;
        int r13 = 0;
    L8:
        if (r12 >= r11) goto L23;
        if (r8.get(r12).f2082p == true) goto L22;
        if (r13 == r12) goto L13;
        z(r8, r10, r13, r12);
    L13:
        r13 = r12 + 1;
        if (r10.get(r12).booleanValue() == false) goto L21;
    L15:
        if (r13 >= r11) goto L21;
        if (r10.get(r13).booleanValue() == false) goto L21;
        if (r8.get(r13).f2082p == true) goto L21;
        r13 = r13 + 1;
    L21:
        z(r8, r10, r12, r13);
        r12 = r13 - 1;
    L22:
        r12 = r12 + 1;
        goto L8
    L23:
        if (r13 == r11) goto L34;
        z(r8, r10, r13, r11);
        return;
    L34:
        return;
    L27:
        throw new IllegalStateException("Internal error with the back stack records");
    }

    public final void P(Parcelable r19) {
        if (r19 != null) goto L5;
        return;
    L5:
        FragmentManagerState r8 = (FragmentManagerState) r19;
        if (r8.f1901a != null) goto L8;
        return;
    L8:
        y r10 = this.f1864c;
        r10.f2065b.clear();
        Iterator<FragmentState> r11 = r8.f1901a.iterator();
    L9:
        boolean r12 = r11.hasNext();
        t r13 = this.f1874m;
        if (r12 == false) goto L24;
        FragmentState r14 = r11.next();
        if (r14 == null) goto L9;
        Fragment r15 = this.H.f2052d.get(r14.f1910b);
        if (r15 != null) goto L16;
        x r16 = new x(this.f1874m, this.f1864c, this.f1877p.f2043b.getClassLoader(), D(), r14);
    L20:
        Fragment r17 = r16.f2060c;
        r17.mFragmentManager = this;
        if (G(2) == false) goto L23;
        Log.v("FragmentManager", "restoreSaveState: active (" + r17.mWho + "): " + r17);
    L23:
        r16.m(this.f1877p.f2043b.getClassLoader());
        r10.g(r16);
        r16.f2062e = this.f1876o;
        goto L9
    L16:
        if (G(2) == false) goto L18;
        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + r15);
    L18:
        r16 = new x(r13, r10, r15, r14);
        goto L20
    L24:
        v r18 = this.H;
        r18.getClass();
        Iterator r20 = new ArrayList(r18.f2052d.values()).iterator();
    L25:
        int r21 = 0;
        if (r20.hasNext() == false) goto L35;
        Fragment r22 = (Fragment) r20.next();
        if (r10.f2065b.get(r22.mWho) == null) goto L30;
        r21 = 1;
    L30:
        if (r21 != 0) goto L25;
        if (G(2) == false) goto L34;
        Log.v("FragmentManager", "Discarding retained Fragment " + r22 + " that was not found in the set of active Fragments " + r8.f1901a);
    L34:
        this.H.d(r22);
        r22.mFragmentManager = this;
        x r23 = new x(r13, r10, r22);
        r23.f2062e = 1;
        r23.k();
        r22.mRemoving = true;
        r23.k();
        goto L25
    L35:
        ArrayList<String> r24 = r8.f1902b;
        r10.f2064a.clear();
        if (r24 == null) goto L49;
        Iterator<String> r25 = r24.iterator();
    L39:
        if (r25.hasNext() == false) goto L49;
        String r26 = r25.next();
        Fragment r27 = r10.b(r26);
        if (r27 == null) goto L47;
        if (G(2) == false) goto L45;
        Log.v("FragmentManager", "restoreSaveState: added (" + r26 + "): " + r27);
    L45:
        r10.a(r27);
        goto L39
    L47:
        throw new IllegalStateException(defpackage.b.d("No instantiated fragment for (", r26, ")"));
    L49:
        if (r8.f1903m == null) goto L68;
        this.f1865d = new ArrayList(r8.f1903m.length);
        int r28 = 0;
    L51:
        BackStackState[] r29 = r8.f1903m;
        if (r28 >= r29.length) goto L69;
        BackStackState r30 = r29[r28];
        r30.getClass();
        androidx.fragment.app.a r31 = new androidx.fragment.app.a(this);
        int r32 = 0;
        int r110 = 0;
    L54:
        int[] r111 = r30.f1808a;
        if (r32 >= r111.length) goto L64;
        z.a r112 = new z.a();
        int r113 = r32 + 1;
        r112.f2083a = r111[r32];
        if (G(2) == false) goto L59;
        Log.v("FragmentManager", "Instantiate " + r31 + " op #" + r110 + " base fragment #" + r111[r113]);
    L59:
        String r33 = r30.f1809b.get(r110);
        if (r33 == null) goto L62;
        Fragment r34 = A(r33);
    L63:
        r112.f2084b = r34;
        r112.f2089g = androidx.lifecycle.h.b.values()[r30.f1810m[r110]];
        r112.f2090h = androidx.lifecycle.h.b.values()[r30.f1811n[r110]];
        int r35 = r113 + 1;
        int r114 = r111[r113];
        r112.f2085c = r114;
        int r115 = r35 + 1;
        int r36 = r111[r35];
        r112.f2086d = r36;
        int r116 = r115 + 1;
        int r117 = r111[r115];
        r112.f2087e = r117;
        int r118 = r111[r116];
        r112.f2088f = r118;
        r31.f2068b = r114;
        r31.f2069c = r36;
        r31.f2070d = r117;
        r31.f2071e = r118;
        r31.b(r112);
        r110 = r110 + 1;
        r32 = r116 + 1;
        goto L54
    L62:
        r34 = null;
        goto L63
    L64:
        r31.f2072f = r30.f1812o;
        r31.f2075i = r30.f1813p;
        r31.f1925s = r30.f1814q;
        r31.f2073g = true;
        r31.f2076j = r30.f1815r;
        r31.f2077k = r30.f1816s;
        r31.f2078l = r30.f1817t;
        r31.f2079m = r30.f1818u;
        r31.f2080n = r30.f1819v;
        r31.f2081o = r30.f1820w;
        r31.f2082p = r30.f1821x;
        r31.c(1);
        if (G(2) == false) goto L67;
        StringBuilder r37 = defpackage.b.f("restoreAllState: back stack #", r28, " (index ");
        r37.append(r31.f1925s);
        r37.append("): ");
        r37.append(r31);
        Log.v("FragmentManager", r37.toString());
        PrintWriter r38 = new PrintWriter(new h0());
        r31.f("  ", r38, false);
        r38.close();
    L67:
        this.f1865d.add(r31);
        r28 = r28 + 1;
    L69:
        this.f1870i.set(r8.f1904n);
        String r39 = r8.f1905o;
        if (r39 == null) goto L72;
        Fragment r40 = A(r39);
        this.f1880s = r40;
        q(r40);
    L72:
        ArrayList<String> r41 = r8.f1906p;
        if (r41 != null) goto L75;
    L77:
        this.f1886y = new ArrayDeque(r8.f1908r);
        return;
    L75:
        if (r21 >= r41.size()) goto L77;
        Bundle r42 = r8.f1907q.get(r21);
        r42.setClassLoader(this.f1877p.f2043b.getClassLoader());
        this.f1871j.put(r41.get(r21), r42);
        r21 = r21 + 1;
        goto L75
    L68:
        this.f1865d = null;
        goto L69
    }

    public final Parcelable Q() {
        Iterator r8 = f().iterator();
    L3:
        int r10 = 0;
        if (r8.hasNext() == false) goto L8;
        i0 r11 = (i0) r8.next();
        if (r11.f1977e == false) goto L3;
        r11.f1977e = false;
        r11.c();
        goto L3
    L8:
        Iterator r12 = f().iterator();
    L10:
        if (r12.hasNext() == false) goto L12;
        ((i0) r12.next()).e();
        goto L10
    L12:
        x(true);
        this.A = true;
        this.H.f2057i = true;
        y r13 = this.f1864c;
        r13.getClass();
        HashMap<String, x> r14 = r13.f2065b;
        ArrayList<FragmentState> r15 = new ArrayList(r14.size());
        Iterator<x> r16 = r14.values().iterator();
    L13:
        BackStackState[] r17 = null;
        Bundle r18 = null;
        r17 = null;
        if (r16.hasNext() == false) goto L55;
        x r19 = r16.next();
        if (r19 == null) goto L13;
        Fragment r20 = r19.f2060c;
        FragmentState r21 = new FragmentState(r20);
        if (r20.mState > (-1)) goto L20;
    L50:
        r21.f1921w = r20.mSavedFragmentState;
    L51:
        r15.add(r21);
        if (G(2) == false) goto L13;
        Log.v("FragmentManager", "Saved state of " + r20 + ": " + r21.f1921w);
        goto L13
    L20:
        if (r21.f1921w != null) goto L50;
        Bundle r22 = new Bundle();
        r20.performSaveInstanceState(r22);
        r19.f2058a.j(false);
        if (r22.isEmpty() == true) goto L26;
        r18 = r22;
    L26:
        if (r20.mView == null) goto L29;
        r19.o();
    L29:
        if (r20.mSavedViewState == null) goto L34;
        if (r18 != null) goto L32;
        r18 = new Bundle();
    L32:
        r18.putSparseParcelableArray("android:view_state", r20.mSavedViewState);
    L34:
        if (r20.mSavedViewRegistryState == null) goto L39;
        if (r18 != null) goto L37;
        r18 = new Bundle();
    L37:
        r18.putBundle("android:view_registry_state", r20.mSavedViewRegistryState);
    L39:
        if (r20.mUserVisibleHint == true) goto L43;
        if (r18 != null) goto L42;
        r18 = new Bundle();
    L42:
        r18.putBoolean("android:user_visible_hint", r20.mUserVisibleHint);
    L43:
        r21.f1921w = r18;
        if (r20.mTargetWho == null) goto L51;
        if (r18 != null) goto L47;
        r21.f1921w = new Bundle();
    L47:
        r21.f1921w.putString("android:target_state", r20.mTargetWho);
        int r23 = r20.mTargetRequestCode;
        if (r23 == 0) goto L51;
        r21.f1921w.putInt("android:target_req_state", r23);
        goto L51
    L55:
        if (r15.isEmpty() == true) goto L57;
        y r24 = this.f1864c;
        ArrayList<Fragment> r25 = r24.f2064a;
        monitor-enter(r25);
    L88:
        th = move-exception;
        throw th;
    L63:
        if (r24.f2064a.isEmpty() == false) goto L66;
        monitor-exit(r25);     // Catch: Throwable -> L88
        ArrayList<String> r26 = null;
    L73:
        ArrayList<androidx.fragment.app.a> r27 = this.f1865d;
        if (r27 == null) goto L83;
        int r28 = r27.size();
        if (r28 <= 0) goto L83;
        r17 = new BackStackState[r28];
    L78:
        if (r10 >= r28) goto L83;
        r17[r10] = new BackStackState(this.f1865d.get(r10));
        if (G(2) == false) goto L82;
        StringBuilder r29 = defpackage.b.f("saveAllState: adding back stack #", r10, ": ");
        r29.append(this.f1865d.get(r10));
        Log.v("FragmentManager", r29.toString());
    L82:
        r10 = r10 + 1;
    L83:
        FragmentManagerState r30 = new FragmentManagerState();
        r30.f1901a = r15;
        r30.f1902b = r26;
        r30.f1903m = r17;
        r30.f1904n = this.f1870i.get();
        Fragment r31 = this.f1880s;
        if (r31 == null) goto L86;
        r30.f1905o = r31.mWho;
    L86:
        r30.f1906p.addAll(this.f1871j.keySet());
        r30.f1907q.addAll(this.f1871j.values());
        r30.f1908r = new ArrayList(this.f1886y);
        return r30;
    L66:
        r26 = new ArrayList(r24.f2064a.size());     // Catch: Throwable -> L88
        Iterator<Fragment> r32 = r24.f2064a.iterator();     // Catch: Throwable -> L88
    L68:
        if (r32.hasNext() == false) goto L72;
        Fragment r33 = r32.next();     // Catch: Throwable -> L88
        r26.add(r33.mWho);     // Catch: Throwable -> L88
        if (G(2) == false) goto L68;
        Log.v("FragmentManager", "saveAllState: adding fragment (" + r33.mWho + "): " + r33);     // Catch: Throwable -> L88
        goto L68
    L72:
        monitor-exit(r25);     // Catch: Throwable -> L88
        goto L73
    L57:
        if (G(2) == false) goto L59;
        Log.v("FragmentManager", "saveAllState: no fragments!");
    L59:
        return null;
    }

    public final void R() {
        ArrayList<k> r8 = this.f1862a;
        monitor-enter(r8);
        boolean r10 = true;
        if (this.f1862a.size() == 1) goto L8;
        r10 = false;
    L8:
        if (r10 == false) goto L10;
        this.f1877p.f2044m.removeCallbacks(this.I);     // Catch: Throwable -> L14
        this.f1877p.f2044m.post(this.I);     // Catch: Throwable -> L14
        Y();     // Catch: Throwable -> L14
    L10:
        monitor-exit(r8);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public final void S(Fragment r8, boolean r10) {
        ViewGroup r11 = C(r8);
        if (r11 != null) goto L5;
        return;
    L5:
        if ((r11 instanceof FragmentContainerView) == false) goto L9;
        ((FragmentContainerView) r11).setDrawDisappearingViewsLast(!r10);
        return;
    }

    public final void T(Fragment r8, androidx.lifecycle.h.b r10) {
        if (r8.equals(A(r8.mWho)) == false) goto L11;
        if (r8.mHost != null) goto L7;
    L8:
        r8.mMaxState = r10;
        return;
    L7:
        if (r8.mFragmentManager == this) goto L8;
    L11:
        throw new IllegalArgumentException("Fragment " + r8 + " is not an active fragment of FragmentManager " + this);
    }

    public final void U(Fragment r8) {
        if (r8 != null) goto L4;
    L12:
        Fragment r10 = this.f1880s;
        this.f1880s = r8;
        q(r10);
        q(this.f1880s);
        return;
    L4:
        if (r8.equals(A(r8.mWho)) == false) goto L11;
        if (r8.mHost == null) goto L12;
        if (r8.mFragmentManager == this) goto L12;
    L11:
        throw new IllegalArgumentException("Fragment " + r8 + " is not an active fragment of FragmentManager " + this);
    }

    public final void V(Fragment r8) {
        ViewGroup r10 = C(r8);
        if (r10 == null) goto L11;
        int r11 = r8.getEnterAnim();
        int r12 = r8.getExitAnim() + r11;
        int r13 = r8.getPopEnterAnim() + r12;
        if ((r8.getPopExitAnim() + r13) > 0) goto L7;
        return;
    L7:
        if (r10.getTag(R.id.visible_removing_fragment_view_tag) != null) goto L9;
        r10.setTag(R.id.visible_removing_fragment_view_tag, r8);
    L9:
        ((Fragment) r10.getTag(R.id.visible_removing_fragment_view_tag)).setPopDirection(r8.getPopDirection());
        return;
    }

    public final void X() {
        Iterator r8 = this.f1864c.d().iterator();
    L4:
        if (r8.hasNext() == false) goto L11;
        x r10 = (x) r8.next();
        Fragment r11 = r10.f2060c;
        if (r11.mDeferStart == false) goto L4;
        if (this.f1863b == true) goto L9;
        r11.mDeferStart = false;
        r10.k();
        goto L4
    L9:
        this.D = true;
        goto L4
    }

    public final void Y() {
        ArrayList<k> r8 = this.f1862a;
        monitor-enter(r8);
        boolean r10 = true;
        if (this.f1862a.isEmpty() == true) goto L13;
        c r11 = this.f1869h;     // Catch: Throwable -> L9
        r11.f498a = true;     // Catch: Throwable -> L9
        ge.a<xd.j> r12 = r11.f500c;     // Catch: Throwable -> L9
        if (r12 == null) goto L11;
        r12.f();     // Catch: Throwable -> L9
    L11:
        monitor-exit(r8);     // Catch: Throwable -> L9
        return;
    L13:
        monitor-exit(r8);     // Catch: Throwable -> L9
        c r13 = this.f1869h;
        ArrayList<androidx.fragment.app.a> r14 = this.f1865d;
        if (r14 == null) goto L17;
        int r15 = r14.size();
    L18:
        if (r15 > 0) goto L20;
    L22:
        r10 = false;
    L23:
        r13.f498a = r10;
        ge.a<xd.j> r16 = r13.f500c;
        if (r16 == null) goto L30;
        r16.f();
        return;
    L30:
        return;
    L20:
        if (I(this.f1879r) == false) goto L22;
    L17:
        r15 = 0;
    L9:
        th = move-exception;
        throw th;
    }

    public final x a(Fragment r8) {
        if (G(2) == false) goto L5;
        Log.v("FragmentManager", "add: " + r8);
    L5:
        x r10 = g(r8);
        r8.mFragmentManager = this;
        y r11 = this.f1864c;
        r11.g(r10);
        if (r8.mDetached == true) goto L13;
        r11.a(r8);
        r8.mRemoving = false;
        if (r8.mView != null) goto L11;
        r8.mHiddenChanged = false;
    L11:
        if (H(r8) == false) goto L13;
        this.f1887z = true;
    L13:
        return r10;
    }

    public final void b(w r8) {
        this.f1875n.add(r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SyntheticAccessor"})
    public final void c(r<?> r8, o r10, Fragment r11) {
        if (this.f1877p != null) goto L45;
        this.f1877p = r8;
        this.f1878q = r10;
        this.f1879r = r11;
        if (r11 == null) goto L8;
        w r12 = new h(r11);
    L10:
        b(r12);
    L12:
        if (this.f1879r == null) goto L15;
        Y();
    L15:
        if ((r8 instanceof androidx.activity.w) == false) goto L20;
        androidx.activity.w r13 = (androidx.activity.w) r8;
        OnBackPressedDispatcher r14 = r13.getOnBackPressedDispatcher();
        this.f1868g = r14;
        androidx.lifecycle.m r15 = r13;
        if (r11 == null) goto L19;
        r15 = r11;
    L19:
        r14.a(r15, this.f1869h);
    L20:
        boolean r16 = false;
        if (r11 == null) goto L27;
        v r17 = r11.mFragmentManager.H;
        HashMap<String, v> r18 = r17.f2053e;
        v r19 = r18.get(r11.mWho);
        if (r19 != null) goto L25;
        r19 = new v(r17.f2055g);
        r18.put(r11.mWho, r19);
    L25:
        this.H = r19;
    L31:
        v r20 = this.H;
        if (this.A == false) goto L34;
    L35:
        r16 = true;
    L36:
        r20.f2057i = r16;
        this.f1864c.f2066c = r20;
        Object r21 = this.f1877p;
        if ((r21 instanceof androidx.activity.result.f) == false) goto L46;
        androidx.activity.result.e r22 = ((androidx.activity.result.f) r21).getActivityResultRegistry();
        if (r11 == null) goto L41;
        String r23 = android.aimedia.a.i(new StringBuilder(), r11.mWho, BdimCategoryConstants.SEPARATOR_COLON);
    L42:
        String r24 = defpackage.b.c("FragmentManager:", r23);
        this.f1883v = r22.d(defpackage.a.e(r24, "StartActivityForResult"), new b.c(), new i(this));
        this.f1884w = r22.d(defpackage.a.e(r24, "StartIntentSenderForResult"), new j(), new a(this));
        this.f1885x = r22.d(defpackage.a.e(r24, "RequestPermissions"), new b.b(), new b(this));
        return;
    L41:
        r23 = "";
        goto L42
    L46:
        return;
    L34:
        if (this.B == false) goto L36;
    L27:
        if ((r8 instanceof l0) == false) goto L29;
        v r25 = (v) new androidx.lifecycle.i0(((l0) r8).getViewModelStore(), v.f2051j).a(v.class);
    L30:
        this.H = r25;
        goto L31
    L29:
        r25 = new v(false);
        goto L30
    L8:
        if ((r8 instanceof w) == false) goto L12;
        r12 = (w) r8;
        goto L10
    L45:
        throw new IllegalStateException("Already attached");
    }

    public final void d(Fragment r8) {
        if (G(2) == false) goto L6;
        Log.v("FragmentManager", "attach: " + r8);
    L6:
        if (r8.mDetached == false) goto L16;
        r8.mDetached = false;
        if (r8.mAdded == true) goto L17;
        this.f1864c.a(r8);
        if (G(2) == false) goto L13;
        Log.v("FragmentManager", "add from attach: " + r8);
    L13:
        if (H(r8) == false) goto L18;
        this.f1887z = true;
        return;
    L18:
        return;
    L17:
        return;
    }

    public final void e() {
        this.f1863b = false;
        this.F.clear();
        this.E.clear();
    }

    public final HashSet f() {
        HashSet r8 = new HashSet();
        Iterator r10 = this.f1864c.d().iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        ViewGroup r11 = ((x) r10.next()).f2060c.mContainer;
        if (r11 == null) goto L4;
        r8.add(i0.g(r11, E()));
        goto L4
    L8:
        return r8;
    }

    public final x g(Fragment r8) {
        String r10 = r8.mWho;
        y r11 = this.f1864c;
        x r12 = r11.f2065b.get(r10);
        if (r12 == null) goto L5;
        return r12;
    L5:
        x r13 = new x(this.f1874m, r11, r8);
        r13.m(this.f1877p.f2043b.getClassLoader());
        r13.f2062e = this.f1876o;
        return r13;
    }

    public final void h(Fragment r8) {
        if (G(2) == false) goto L6;
        Log.v("FragmentManager", "detach: " + r8);
    L6:
        if (r8.mDetached == true) goto L23;
        r8.mDetached = true;
        if (r8.mAdded == true) goto L10;
        return;
    L10:
        if (G(2) == false) goto L12;
        Log.v("FragmentManager", "remove from detach: " + r8);
    L12:
        y r10 = this.f1864c;
        ArrayList<Fragment> r11 = r10.f2064a;
        monitor-enter(r11);
        r10.f2064a.remove(r8);     // Catch: Throwable -> L20
        monitor-exit(r11);     // Catch: Throwable -> L20
        r8.mAdded = false;
        if (H(r8) == false) goto L19;
        this.f1887z = true;
    L19:
        V(r8);
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public final void i(Configuration r8) {
        Iterator<Fragment> r10 = this.f1864c.f().iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        Fragment r11 = r10.next();
        if (r11 == null) goto L4;
        r11.performConfigurationChanged(r8);
        goto L4
    }

    public final boolean j(MenuItem r8) {
        if (this.f1876o >= 1) goto L5;
        return false;
    L5:
        Iterator<Fragment> r10 = this.f1864c.f().iterator();
    L7:
        if (r10.hasNext() == false) goto L13;
        Fragment r11 = r10.next();
        if (r11 == null) goto L7;
        if (r11.performContextItemSelected(r8) == false) goto L7;
        return true;
    L13:
        return false;
    }

    public final boolean k(Menu r8, MenuInflater r10) {
        int r11 = 0;
        if (this.f1876o >= 1) goto L5;
        return false;
    L5:
        Iterator<Fragment> r12 = this.f1864c.f().iterator();
        ArrayList<Fragment> r13 = null;
        boolean r14 = false;
    L7:
        if (r12.hasNext() == false) goto L18;
        Fragment r15 = r12.next();
        if (r15 == null) goto L7;
        if (r15.isMenuVisible() == false) goto L7;
        if (r15.performCreateOptionsMenu(r8, r10) == false) goto L7;
        if (r13 != null) goto L16;
        r13 = new ArrayList();
    L16:
        r13.add(r15);
        r14 = true;
        goto L7
    L18:
        if (this.f1866e != null) goto L20;
    L27:
        this.f1866e = r13;
        return r14;
    L20:
        if (r11 >= this.f1866e.size()) goto L27;
        Fragment r16 = this.f1866e.get(r11);
        if (r13 != null) goto L24;
    L25:
        r16.onDestroyOptionsMenu();
    L26:
        r11 = r11 + 1;
        goto L20
    L24:
        if (r13.contains(r16) == true) goto L26;
        goto L25
    }

    public final void l() {
        this.C = true;
        x(true);
        Iterator r8 = f().iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        ((i0) r8.next()).e();
        goto L4
    L6:
        t(-1);
        this.f1877p = null;
        this.f1878q = null;
        this.f1879r = null;
        if (this.f1868g == null) goto L13;
        Iterator<androidx.activity.c> r10 = this.f1869h.f499b.iterator();
    L10:
        if (r10.hasNext() == false) goto L12;
        r10.next().cancel();
        goto L10
    L12:
        this.f1868g = null;
    L13:
        androidx.activity.result.d r11 = this.f1883v;
        if (r11 == null) goto L19;
        r11.b();
        this.f1884w.b();
        this.f1885x.b();
        return;
    }

    public final void m() {
        Iterator<Fragment> r8 = this.f1864c.f().iterator();
    L4:
        if (r8.hasNext() == false) goto L8;
        Fragment r10 = r8.next();
        if (r10 == null) goto L4;
        r10.performLowMemory();
        goto L4
    }

    public final void n(boolean r8) {
        Iterator<Fragment> r10 = this.f1864c.f().iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        Fragment r11 = r10.next();
        if (r11 == null) goto L4;
        r11.performMultiWindowModeChanged(r8);
        goto L4
    }

    public final boolean o(MenuItem r8) {
        if (this.f1876o >= 1) goto L5;
        return false;
    L5:
        Iterator<Fragment> r10 = this.f1864c.f().iterator();
    L7:
        if (r10.hasNext() == false) goto L13;
        Fragment r11 = r10.next();
        if (r11 == null) goto L7;
        if (r11.performOptionsItemSelected(r8) == false) goto L7;
        return true;
    L13:
        return false;
    }

    public final void p(Menu r8) {
        if (this.f1876o >= 1) goto L5;
        return;
    L5:
        Iterator<Fragment> r10 = this.f1864c.f().iterator();
    L7:
        if (r10.hasNext() == false) goto L11;
        Fragment r11 = r10.next();
        if (r11 == null) goto L7;
        r11.performOptionsMenuClosed(r8);
        goto L7
    }

    public final void q(Fragment r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (r8.equals(A(r8.mWho)) == false) goto L8;
        r8.performPrimaryNavigationFragmentChanged();
        return;
    }

    public final void r(boolean r8) {
        Iterator<Fragment> r10 = this.f1864c.f().iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        Fragment r11 = r10.next();
        if (r11 == null) goto L4;
        r11.performPictureInPictureModeChanged(r8);
        goto L4
    }

    public final boolean s(Menu r8) {
        boolean r10 = false;
        if (this.f1876o >= 1) goto L5;
        return false;
    L5:
        Iterator<Fragment> r11 = this.f1864c.f().iterator();
    L7:
        if (r11.hasNext() == false) goto L15;
        Fragment r12 = r11.next();
        if (r12 == null) goto L7;
        if (r12.isMenuVisible() == false) goto L7;
        if (r12.performPrepareOptionsMenu(r8) == false) goto L7;
        r10 = true;
        goto L7
    L15:
        return r10;
    }

    public final void t(int r8) {
        this.f1863b = true;     // Catch: Throwable -> L16
        Iterator<x> r10 = this.f1864c.f2065b.values().iterator();     // Catch: Throwable -> L16
    L5:
        if (r10.hasNext() == false) goto L9;
        x r11 = r10.next();     // Catch: Throwable -> L16
        if (r11 == null) goto L5;
        r11.f2062e = r8;     // Catch: Throwable -> L16
        goto L5
    L9:
        J(r8, false);     // Catch: Throwable -> L16
        Iterator r12 = f().iterator();     // Catch: Throwable -> L16
    L10:
        if (r12.hasNext() == false) goto L14;
        ((i0) r12.next()).e();     // Catch: Throwable -> L16
        goto L10
    L14:
        this.f1863b = false;
        x(true);
        return;
    L16:
        th = move-exception;
        this.f1863b = false;
        throw th;
    }

    public final String toString() {
        StringBuilder r8 = new StringBuilder(128);
        r8.append("FragmentManager{");
        r8.append(Integer.toHexString(System.identityHashCode(this)));
        r8.append(" in ");
        Fragment r10 = this.f1879r;
        if (r10 == null) goto L6;
        r8.append(r10.getClass().getSimpleName());
        r8.append("{");
        Object r11 = this.f1879r;
    L5:
        r8.append(Integer.toHexString(System.identityHashCode(r11)));
        r8.append("}");
    L10:
        r8.append("}}");
        return r8.toString();
    L6:
        r<?> r12 = this.f1877p;
        if (r12 == null) goto L9;
        r8.append(r12.getClass().getSimpleName());
        r8.append("{");
        r11 = this.f1877p;
        goto L5
    L9:
        r8.append("null");
        goto L10
    }

    public final void u(String r8, FileDescriptor r10, PrintWriter r11, String[] r12) {
        String r13 = defpackage.a.e(r8, "    ");
        y r14 = this.f1864c;
        r14.getClass();
        String r15 = r8 + "    ";
        HashMap<String, x> r16 = r14.f2065b;
        if (r16.isEmpty() == true) goto L11;
        r11.print(r8);
        r11.println("Active Fragments:");
        Iterator<x> r17 = r16.values().iterator();
    L6:
        if (r17.hasNext() == false) goto L11;
        x r18 = r17.next();
        r11.print(r8);
        if (r18 != null) goto L9;
        r11.println("null");
        goto L6
    L9:
        Fragment r19 = r18.f2060c;
        r11.println(r19);
        r19.dump(r15, r10, r11, r12);
    L11:
        ArrayList<Fragment> r20 = r14.f2064a;
        int r21 = r20.size();
        int r22 = 0;
        if (r21 <= 0) goto L16;
        r11.print(r8);
        r11.println("Added Fragments:");
        int r23 = 0;
    L14:
        if (r23 >= r21) goto L16;
        Fragment r24 = r20.get(r23);
        r11.print(r8);
        r11.print("  #");
        r11.print(r23);
        r11.print(": ");
        r11.println(r24.toString());
        r23 = r23 + 1;
    L16:
        ArrayList<Fragment> r25 = this.f1866e;
        if (r25 == null) goto L23;
        int r26 = r25.size();
        if (r26 <= 0) goto L23;
        r11.print(r8);
        r11.println("Fragments Created Menus:");
        int r27 = 0;
    L21:
        if (r27 >= r26) goto L23;
        Fragment r28 = this.f1866e.get(r27);
        r11.print(r8);
        r11.print("  #");
        r11.print(r27);
        r11.print(": ");
        r11.println(r28.toString());
        r27 = r27 + 1;
    L23:
        ArrayList<androidx.fragment.app.a> r29 = this.f1865d;
        if (r29 == null) goto L30;
        int r30 = r29.size();
        if (r30 <= 0) goto L30;
        r11.print(r8);
        r11.println("Back Stack:");
        int r31 = 0;
    L28:
        if (r31 >= r30) goto L30;
        androidx.fragment.app.a r32 = this.f1865d.get(r31);
        r11.print(r8);
        r11.print("  #");
        r11.print(r31);
        r11.print(": ");
        r11.println(r32.toString());
        r32.f(r13, r11, true);
        r31 = r31 + 1;
    L30:
        r11.print(r8);
        r11.println("Back Stack Index: " + this.f1870i.get());
        ArrayList<k> r33 = this.f1862a;
        monitor-enter(r33);
        int r34 = this.f1862a.size();     // Catch: Throwable -> L45
        if (r34 <= 0) goto L37;
        r11.print(r8);     // Catch: Throwable -> L45
        r11.println("Pending Actions:");     // Catch: Throwable -> L45
    L35:
        if (r22 >= r34) goto L37;
        Object r35 = (k) this.f1862a.get(r22);     // Catch: Throwable -> L45
        r11.print(r8);     // Catch: Throwable -> L45
        r11.print("  #");     // Catch: Throwable -> L45
        r11.print(r22);     // Catch: Throwable -> L45
        r11.print(": ");     // Catch: Throwable -> L45
        r11.println(r35);     // Catch: Throwable -> L45
        r22 = r22 + 1;     // Catch: Throwable -> L45
    L37:
        monitor-exit(r33);     // Catch: Throwable -> L45
        r11.print(r8);
        r11.println("FragmentManager misc state:");
        r11.print(r8);
        r11.print("  mHost=");
        r11.println(this.f1877p);
        r11.print(r8);
        r11.print("  mContainer=");
        r11.println(this.f1878q);
        if (this.f1879r == null) goto L41;
        r11.print(r8);
        r11.print("  mParent=");
        r11.println(this.f1879r);
    L41:
        r11.print(r8);
        r11.print("  mCurState=");
        r11.print(this.f1876o);
        r11.print(" mStateSaved=");
        r11.print(this.A);
        r11.print(" mStopped=");
        r11.print(this.B);
        r11.print(" mDestroyed=");
        r11.println(this.C);
        if (this.f1887z == false) goto L60;
        r11.print(r8);
        r11.print("  mNeedMenuInvalidate=");
        r11.println(this.f1887z);
        return;
    L60:
        return;
    L45:
        th = move-exception;
        throw th;
    }

    public final void v(k r8, boolean r10) {
        if (r10 == false) goto L4;
    L22:
        ArrayList<k> r11 = this.f1862a;
        monitor-enter(r11);
    L34:
        th = move-exception;
        throw th;
    L25:
        if (this.f1877p != null) goto L31;
        if (r10 == false) goto L30;
        monitor-exit(r11);     // Catch: Throwable -> L34
        return;
    L30:
        throw new IllegalStateException("Activity has been destroyed");     // Catch: Throwable -> L34
    L31:
        this.f1862a.add(r8);     // Catch: Throwable -> L34
        R();     // Catch: Throwable -> L34
        monitor-exit(r11);     // Catch: Throwable -> L34
        return;
    L4:
        if (this.f1877p != null) goto L12;
        if (this.C == false) goto L10;
        throw new IllegalStateException("FragmentManager has been destroyed");
    L10:
        throw new IllegalStateException("FragmentManager has not been attached to a host.");
    L12:
        if (this.A == false) goto L14;
    L17:
        boolean r12 = true;
    L18:
        if (r12 == false) goto L22;
        throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    L14:
        if (this.B == true) goto L17;
        r12 = false;
        goto L18
    }

    public final void w(boolean r8) {
        if (this.f1863b == true) goto L35;
        if (this.f1877p != null) goto L13;
        if (this.C == false) goto L11;
        throw new IllegalStateException("FragmentManager has been destroyed");
    L11:
        throw new IllegalStateException("FragmentManager has not been attached to a host.");
    L13:
        if (Looper.myLooper() != this.f1877p.f2044m.getLooper()) goto L33;
        if (r8 == true) goto L28;
        if (this.A == false) goto L19;
    L22:
        boolean r10 = true;
    L23:
        if (r10 == false) goto L28;
        throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    L19:
        if (this.B == true) goto L22;
        r10 = false;
    L28:
        if (this.E != null) goto L30;
        this.E = new ArrayList();
        this.F = new ArrayList();
    L30:
        this.f1863b = false;
        return;
    L33:
        throw new IllegalStateException("Must be called from main thread of fragment host");
    L35:
        throw new IllegalStateException("FragmentManager is already executing transactions");
    }

    public final boolean x(boolean r10) {
        w(r10);
        boolean r8 = false;
    L3:
        ArrayList<androidx.fragment.app.a> r11 = this.E;
        ArrayList<Boolean> r12 = this.F;
        ArrayList<k> r13 = this.f1862a;
        monitor-enter(r13);
        if (this.f1862a.isEmpty() == false) goto L9;
        monitor-exit(r13);     // Catch: Throwable -> L26
        boolean r14 = false;
    L14:
        if (r14 == false) goto L21;
        r8 = true;
        this.f1863b = true;
        O(this.E, this.F);     // Catch: Throwable -> L18
        e();
    L18:
        th = move-exception;
        e();
        throw th;
    L21:
        Y();
        if (this.D == false) goto L24;
        this.D = false;
        X();
    L24:
        this.f1864c.f2065b.values().removeAll(Collections.singleton(null));
        return r8;
    L9:
        int r15 = this.f1862a.size();     // Catch: Throwable -> L26
        int r16 = 0;
        r14 = false;
    L10:
        if (r16 >= r15) goto L12;
        r14 = r14 | this.f1862a.get(r16).a(r11, r12);     // Catch: Throwable -> L26
        r16 = r16 + 1;     // Catch: Throwable -> L26
        goto L10
    L12:
        this.f1862a.clear();     // Catch: Throwable -> L26
        this.f1877p.f2044m.removeCallbacks(this.I);     // Catch: Throwable -> L26
        monitor-exit(r13);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }

    public final void y(androidx.fragment.app.a r8, boolean r10) {
        if (r10 == true) goto L4;
    L8:
        w(r10);
        r8.a(this.E, this.F);
        this.f1863b = true;
        O(this.E, this.F);     // Catch: Throwable -> L15
        e();
        Y();
        if (this.D == false) goto L13;
        this.D = false;
        X();
    L13:
        this.f1864c.f2065b.values().removeAll(Collections.singleton(null));
        return;
    L15:
        th = move-exception;
        e();
        throw th;
    L4:
        if (this.f1877p != null) goto L6;
        return;
    L6:
        if (this.C == false) goto L8;
    }

    public final void z(ArrayList<androidx.fragment.app.a> r21, ArrayList<Boolean> r22, int r23, int r24) {
        ArrayList<androidx.fragment.app.a> r8 = r21;
        boolean r10 = r8.get(r23).f2082p;
        ArrayList<Fragment> r11 = this.G;
        if (r11 != null) goto L5;
        this.G = new ArrayList();
    L6:
        ArrayList<Fragment> r12 = this.G;
        y r13 = this.f1864c;
        r12.addAll(r13.f());
        Fragment r14 = this.f1880s;
        int r15 = r23;
        boolean r16 = false;
    L7:
        int r17 = 1;
        if (r15 >= r24) goto L74;
        androidx.fragment.app.a r18 = r8.get(r15);
        if (r22.get(r15).booleanValue() == true) goto L52;
        ArrayList<Fragment> r19 = this.G;
        int r110 = 0;
    L12:
        ArrayList<z.a> r111 = r18.f2067a;
        if (r110 >= r111.size()) goto L51;
        z.a r20 = r111.get(r110);
        int r25 = r20.f2083a;
        if (r25 != r17) goto L17;
        int r26 = r17;
    L49:
        r19.add(r20.f2084b);
    L50:
        r110 = r110 + r26;
        r17 = r26;
        r13 = r13;
        goto L12
    L17:
        if (r25 != 2) goto L19;
        Fragment r27 = r20.f2084b;
        int r112 = r27.mContainerId;
        int r28 = r19.size() - 1;
        boolean r113 = false;
    L34:
        if (r28 < 0) goto L44;
        y r114 = r13;
        Fragment r29 = r19.get(r28);
        if (r29.mContainerId != r112) goto L43;
        if (r29 != r27) goto L39;
        r113 = true;
        goto L43
    L39:
        if (r29 != r14) goto L41;
        r111.add(r110, new z.a(r29, 9));
        r110 = r110 + 1;
        r14 = null;
    L41:
        z.a r30 = new z.a(r29, 3);
        r30.f2085c = r20.f2085c;
        r30.f2087e = r20.f2087e;
        r30.f2086d = r20.f2086d;
        r30.f2088f = r20.f2088f;
        r111.add(r110, r30);
        r19.remove(r29);
        r110 = r110 + 1;
        r14 = r14;
    L43:
        r28 = r28 - 1;
        r13 = r114;
        goto L34
    L44:
        r13 = r13;
        r26 = 1;
        if (r113 == false) goto L47;
        r111.remove(r110);
        r110 = r110 - 1;
        goto L50
    L47:
        r20.f2083a = 1;
        r19.add(r27);
        goto L50
    L19:
        if (r25 != 3) goto L21;
    L29:
        r19.remove(r20.f2084b);
        Fragment r31 = r20.f2084b;
        if (r31 != r14) goto L32;
        r111.add(r110, new z.a(r31, 9));
        r110 = r110 + 1;
        r13 = r13;
        r26 = 1;
        r14 = null;
    L32:
        r13 = r13;
        r26 = 1;
        goto L50
    L21:
        if (r25 == 6) goto L29;
        if (r25 != 7) goto L25;
        r26 = 1;
        goto L49
    L25:
        if (r25 != 8) goto L32;
        r111.add(r110, new z.a(r14, 9));
        r110 = r110 + 1;
        r14 = r20.f2084b;
        goto L32
    L51:
        y r115 = r13;
    L67:
        if (r16 == false) goto L69;
    L72:
        r16 = true;
    L73:
        r15 = r15 + 1;
        r8 = r21;
        r13 = r115;
        goto L7
    L69:
        if (r18.f2073g == true) goto L72;
        r16 = false;
        goto L73
    L52:
        r115 = r13;
        int r32 = 1;
        ArrayList<Fragment> r33 = this.G;
        ArrayList<z.a> r34 = r18.f2067a;
        int r35 = r34.size() - 1;
    L53:
        if (r35 < 0) goto L67;
        z.a r36 = r34.get(r35);
        int r116 = r36.f2083a;
        if (r116 == r32) goto L65;
        if (r116 == 3) goto L63;
        switch(r116) {
            case 6: goto L63;
            case 7: goto L65;
            case 8: goto L62;
            case 9: goto L61;
            case 10: goto L60;
            default: goto L66;
        };
    L60:
        r36.f2090h = r36.f2089g;
        goto L66
    L61:
        r14 = r36.f2084b;
        goto L66
    L62:
        r14 = null;
    L66:
        r35 = r35 - 1;
        r32 = 1;
    L63:
        r33.add(r36.f2084b);
    L65:
        r33.remove(r36.f2084b);
        goto L66
    L74:
        y r117 = r13;
        this.G.clear();
        if (r10 == false) goto L77;
    L91:
        int r37 = r23;
    L92:
        if (r37 >= r24) goto L98;
        androidx.fragment.app.a r38 = r21.get(r37);
        if (r22.get(r37).booleanValue() == false) goto L96;
        r38.c(-1);
        r38.h();
    L97:
        r37 = r37 + 1;
        goto L92
    L96:
        r38.c(1);
        r38.g();
        goto L97
    L98:
        boolean r39 = r22.get(r24 - 1).booleanValue();
        int r40 = r23;
    L99:
        if (r40 >= r24) goto L115;
        androidx.fragment.app.a r41 = r21.get(r40);
        if (r39 == false) goto L108;
        int r42 = r41.f2067a.size() - 1;
    L103:
        if (r42 < 0) goto L114;
        Fragment r43 = r41.f2067a.get(r42).f2084b;
        if (r43 == null) goto L107;
        g(r43).k();
    L107:
        r42 = r42 - 1;
    L114:
        r40 = r40 + 1;
        goto L99
    L108:
        Iterator<z.a> r44 = r41.f2067a.iterator();
    L110:
        if (r44.hasNext() == false) goto L114;
        Fragment r45 = r44.next().f2084b;
        if (r45 == null) goto L110;
        g(r45).k();
        goto L110
    L115:
        J(this.f1876o, true);
        HashSet r46 = new HashSet();
        int r47 = r23;
    L116:
        if (r47 >= r24) goto L126;
        Iterator<z.a> r48 = r21.get(r47).f2067a.iterator();
    L119:
        if (r48.hasNext() == false) goto L125;
        Fragment r49 = r48.next().f2084b;
        if (r49 == null) goto L119;
        ViewGroup r50 = r49.mContainer;
        if (r50 == null) goto L119;
        r46.add(i0.g(r50, E()));
        goto L119
    L125:
        r47 = r47 + 1;
        goto L116
    L126:
        Iterator r51 = r46.iterator();
    L128:
        if (r51.hasNext() == false) goto L130;
        i0 r52 = (i0) r51.next();
        r52.f1976d = r39;
        r52.h();
        r52.c();
        goto L128
    L130:
        int r53 = r23;
    L131:
        if (r53 >= r24) goto L139;
        androidx.fragment.app.a r54 = r21.get(r53);
        if (r22.get(r53).booleanValue() == false) goto L138;
        if (r54.f1925s < 0) goto L138;
        r54.f1925s = -1;
    L138:
        r54.getClass();
        r53 = r53 + 1;
        goto L131
    L139:
        return;
    L77:
        if (this.f1876o < 1) goto L91;
        int r55 = r23;
    L79:
        if (r55 >= r24) goto L91;
        Iterator<z.a> r56 = r21.get(r55).f2067a.iterator();
    L82:
        if (r56.hasNext() == false) goto L90;
        Fragment r57 = r56.next().f2084b;
        if (r57 != null) goto L86;
    L88:
        y r58 = r117;
    L89:
        r117 = r58;
        goto L82
    L86:
        if (r57.mFragmentManager == null) goto L88;
        r58 = r117;
        r58.g(g(r57));
        goto L89
    L90:
        r55 = r55 + 1;
        goto L79
    L5:
        r11.clear();
        goto L6
    }
}
