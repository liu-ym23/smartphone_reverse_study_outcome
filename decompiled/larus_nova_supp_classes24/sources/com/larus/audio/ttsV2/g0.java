package com.larus.audio.ttsV2;

import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.larus.audio.e1;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.IVoiceCallService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class g0 implements e1 {
    public static final g0 a = null;
    public static final Map<String, Map<Integer, a>> b = null;
    public static boolean c;

    public static final class a {
        public final LiveData<Boolean> a;
        public final LifecycleOwner b;
        public final LifecycleObserver c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "CachingLive(living=" + this.a + ", owner=" + this.b + ", observer=" + this.c + ')';
        }

        public a(LiveData r2, LifecycleOwner r3, TtsInterrupter$initInterruptParams$cachingLive$1 r4) {
            Intrinsics.checkNotNullParameter(r2, "living");
            Intrinsics.checkNotNullParameter(r3, "owner");
            Intrinsics.checkNotNullParameter(r4, "observer");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Lifecycle.State.values().length];
            r0[Lifecycle.State.DESTROYED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[Lifecycle.State.INITIALIZED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[Lifecycle.State.CREATED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[Lifecycle.State.STARTED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[Lifecycle.State.RESUMED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    public static final class c implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public c(f0 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    public g0() {
    }

    static {
        a = new g0();
        b = new LinkedHashMap();
    }

    @Override // com.larus.audio.e1
    public final boolean d() {
        return c;
    }

    public static boolean e(String r7) {
        a r0 = f(r7);
        if (r0 == null) goto L29;
        IVoiceCallService r8 = (IVoiceCallService) ServiceManager.get().getService(IVoiceCallService.class);
        if (r8 == null) goto L7;
        boolean r9 = r8.e();
    L8:
        i1<com.larus.audio.ttsV2.a> r3 = TtsGuideDelegate.b.f();
        if (r3 == null) goto L11;
        com.larus.audio.ttsV2.a r4 = (com.larus.audio.ttsV2.a) r3.getValue();
    L12:
        FLogger.a.i("TtsInterrupter", "isTtsAllow ttsLivingData_" + r0.hashCode() + ", living_" + r0.a.hashCode() + ':' + r0.a.getValue() + ",isInRealtimeCall:" + r9 + ", earphoneState: " + r4);
        if (r4 != null) goto L15;
    L17:
        boolean r5 = false;
    L18:
        if (r5 == false) goto L20;
        boolean r6 = r4.b;
    L21:
        if (r6 == false) goto L34;
        g0 r10 = a;
        LifecycleOwner r1 = r0.b;
        r10.getClass();
        if (AppHost.a.a().isAppBackground() == false) goto L25;
        boolean r2 = ITtsBackgroundPlayControlService.a.b();
    L26:
        if (r2 == false) goto L35;
        if (r9 == true) goto L36;
        return true;
    L36:
        return false;
    L35:
        return false;
    L25:
        Lazy r11 = t58.b.a;
        r2 = t58.b.a(r1.getLifecycle());
        goto L26
    L34:
        return false;
    L20:
        r6 = Intrinsics.areEqual(r0.a.getValue(), Boolean.TRUE);
        goto L21
    L15:
        if (r4.a != true) goto L17;
        r5 = true;
        goto L18
    L11:
        r4 = null;
        goto L12
    L7:
        r9 = false;
        goto L8
    L29:
        FLogger r12 = FLogger.a;
        if (r7 != null) goto L32;
        r7 = "";
    L32:
        r12.i("TtsInterrupter", "isTtsAllow: missing ttsLivingData for cvsId=".concat(r7));
        return false;
    }

    public static a f(String r5) {
        if (r5 != null) goto L4;
        r5 = "";
    L4:
        Map r6 = (Map) ((LinkedHashMap) b).get(r5);
        if (r6 != null) goto L8;
        return null;
    L8:
        if (r6.isEmpty() == false) goto L10;
        return null;
    L10:
        Iterator r7 = r6.values().iterator();
        if (r7.hasNext() == true) goto L13;
        Object r1 = null;
    L22:
        a r2 = (a) r1;
        if (r2 != null) goto L26;
        return null;
    L26:
        if (r2.b.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) goto L28;
        boolean r8 = true;
    L29:
        if (r8 == true) goto L31;
        return null;
    L31:
        return r2;
    L28:
        r8 = false;
        goto L29
    L13:
        r1 = r7.next();
        if (r7.hasNext() == false) goto L22;
        int r3 = g(((a) r1).b.getLifecycle().getCurrentState());
    L17:
        Object r4 = r7.next();
        int r9 = g(((a) r4).b.getLifecycle().getCurrentState());
        if (r3 >= r9) goto L21;
        r1 = r4;
        r3 = r9;
    L21:
        if (r7.hasNext() == true) goto L17;
        goto L22
    }

    public static final int g(Lifecycle.State r3) {
        int r4 = b.a[r3.ordinal()];
        if (r4 != 1) goto L5;
        return -1;
    L5:
        if (r4 != 2) goto L7;
        return 0;
    L7:
        if (r4 != 3) goto L9;
        return 1;
    L9:
        if (r4 != 4) goto L11;
        return 2;
    L11:
        if (r4 != 5) goto L14;
        return 3;
    L14:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.larus.audio.e1
    public final void a(boolean r1) {
        c = r1;
    }

    @Override // com.larus.audio.e1
    public final boolean c(String r4) {
        Intrinsics.checkNotNullParameter(r4, "cvsId");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L6;
        return false;
    L6:
        if (AppHost.a.a().isAppBackground() == false) goto L8;
        return false;
    L8:
        a r0 = f(r4);
        if (r0 == null) goto L21;
        LifecycleOwner r1 = r0.b;
        if (r1 != null) goto L14;
        return false;
    L14:
        if (r1.getLifecycle().getCurrentState() == Lifecycle.State.RESUMED) goto L16;
        return false;
    L16:
        if (c == false) goto L18;
        return false;
    L18:
        if (e(r4) == false) goto L24;
        return true;
    L24:
        return false;
    L21:
        return false;
    }

    /* JADX WARN: Type inference failed for: r7v2, types: [com.larus.audio.ttsV2.f0] */
    @Override // com.larus.audio.e1
    public final void b(LifecycleOwner r5, MutableLiveData r6, Fragment r7, String r8) {
        Intrinsics.checkNotNullParameter(r5, "owner");
        Intrinsics.checkNotNullParameter(r6, "ttsSwitch");
        Intrinsics.checkNotNullParameter(r7, "fragment");
        Intrinsics.checkNotNullParameter(r8, "cvsId");
        FLogger.a.i("TtsInterrupter", "initInterruptParams ".concat(r8));
        if (r8.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        c = false;
        int r1 = System.identityHashCode(r5);
        LinkedHashMap r2 = (LinkedHashMap) b;
        Map r3 = (Map) r2.get(r8);
        if (r3 == null) goto L13;
        a r4 = (a) r3.get(Integer.valueOf(r1));
        if (r4 == null) goto L13;
        r4.a.removeObservers(r5);
        r5.getLifecycle().removeObserver(r4.c);
    L13:
        final a r9 = new a(Transformations.distinctUntilChanged(r6), r5, new TtsInterrupter$initInterruptParams$cachingLive$1(r7, r8));
        r5.getLifecycle().addObserver(r9.c);
        r9.a.observe(r5, new c(new f0(r9)));
        Object r10 = r2.get(r8);
        if (r10 != null) goto L16;
        r10 = new LinkedHashMap();
        r2.put(r8, r10);
    L16:
        ((Map) r10).put(Integer.valueOf(r1), r9);
        return;
    L5:
        r0 = false;
        goto L6
    }
}
