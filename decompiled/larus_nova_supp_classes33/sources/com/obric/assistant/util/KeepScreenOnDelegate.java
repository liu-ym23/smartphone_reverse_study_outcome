package com.obric.assistant.util;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class KeepScreenOnDelegate {
    public final va8.l a;
    public final Function0<Boolean> b;
    public final Function0<TextView> c;
    public final Handler d;
    public final Set<KeepScreenOnReason> e;
    public final Map<KeepScreenOnReason, Long> f;
    public volatile boolean g;
    public boolean h;
    public View i;
    public boolean j;
    public final Map<TextView, b> k;
    public final Map<View, c> l;
    public final f1 m;
    public final g1 n;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/util/KeepScreenOnDelegate$KeepScreenOnReason;", "", "<init>", "(Ljava/lang/String;I)V", "PageResumeTail", "InputTextTail", "TouchTail", "TtsPlaying", "MessageGenerating", "VoiceVisible", "SpeakerVisible", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum KeepScreenOnReason extends Enum<KeepScreenOnReason> {
        public static final KeepScreenOnReason InputTextTail = null;
        public static final KeepScreenOnReason MessageGenerating = null;
        public static final KeepScreenOnReason PageResumeTail = null;
        public static final KeepScreenOnReason SpeakerVisible = null;
        public static final KeepScreenOnReason TouchTail = null;
        public static final KeepScreenOnReason TtsPlaying = null;
        public static final KeepScreenOnReason VoiceVisible = null;
        public static final /* synthetic */ KeepScreenOnReason[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<KeepScreenOnReason> getEntries() {
            return b;
        }

        static {
            KeepScreenOnReason r0 = new KeepScreenOnReason("PageResumeTail", 0);
            PageResumeTail = r0;
            KeepScreenOnReason r1 = new KeepScreenOnReason("InputTextTail", 1);
            InputTextTail = r1;
            KeepScreenOnReason r3 = new KeepScreenOnReason("TouchTail", 2);
            TouchTail = r3;
            KeepScreenOnReason r5 = new KeepScreenOnReason("TtsPlaying", 3);
            TtsPlaying = r5;
            KeepScreenOnReason r7 = new KeepScreenOnReason("MessageGenerating", 4);
            MessageGenerating = r7;
            KeepScreenOnReason r9 = new KeepScreenOnReason("VoiceVisible", 5);
            VoiceVisible = r9;
            KeepScreenOnReason r11 = new KeepScreenOnReason("SpeakerVisible", 6);
            SpeakerVisible = r11;
            KeepScreenOnReason[] r13 = {r0, r1, r3, r5, r7, r9, r11};
            a = r13;
            b = EnumEntriesKt.enumEntries(r13);
        }

        public static KeepScreenOnReason[] values() {
            return (KeepScreenOnReason[]) a.clone();
        }

        public static KeepScreenOnReason valueOf(String r1) {
            return (KeepScreenOnReason) r27.a.a(KeepScreenOnReason.class, r1);
        }

        public KeepScreenOnReason(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final TextWatcher b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "InputWatcherRegistration(inputViewName=" + this.a + ", watcher=" + this.b + ')';
        }

        public b(String r2, l1 r3) {
            Intrinsics.checkNotNullParameter(r2, "inputViewName");
            Intrinsics.checkNotNullParameter(r3, "watcher");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c {
        public final View a;
        public final ViewTreeObserver b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "InputWatcherRescanRegistration(root=" + this.a + ", observer=" + this.b + ')';
        }

        public c(View r2, ViewTreeObserver r3) {
            Intrinsics.checkNotNullParameter(r2, "root");
            Intrinsics.checkNotNullParameter(r3, "observer");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
    }

    public final void b() {
        this.g = true;
        Iterator r0 = CollectionsKt.toList(((LinkedHashMap) this.l).keySet()).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        g((View) r0.next(), "destroy");
        goto L4
    L6:
        Iterator r1 = CollectionsKt.toList(((LinkedHashMap) this.k).keySet()).iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        f((TextView) r1.next());
        goto L8
    L10:
        this.d.removeCallbacksAndMessages(null);
        this.e.clear();
        ((LinkedHashMap) this.f).clear();
        if (this.j == false) goto L15;
        View r2 = this.i;
        if (r2 == null) goto L15;
        i(r2, false, "destroy");
    L15:
        this.i = null;
        this.j = false;
    }

    public final void e() {
        this.g = true;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        b();
        return;
    L5:
        this.d.post(new d1(this));
    }

    public final void c() {
        if (this.g == false) goto L5;
        return;
    L5:
        LinkedHashSet r0 = new LinkedHashSet();
        va8.l r1 = this.a;
        if (r1 == null) goto L10;
        ConstraintLayout r2 = r1.getRootView();
        if (r2 == null) goto L10;
        r0.add(r2);
        r0.add(r2.getRootView());
    L10:
        va8.l r3 = this.a;
        if (r3 == null) goto L15;
        ViewGroup r4 = r3.d();
        if (r4 == null) goto L15;
        r0.add(r4);
    L15:
        va8.l r5 = this.a;
        if (r5 == null) goto L20;
        FrameLayout r6 = r5.getInput();
        if (r6 == null) goto L20;
        r0.add(r6);
    L20:
        Set r7 = ((LinkedHashMap) this.l).keySet();
        ArrayList r8 = new ArrayList();
        Iterator r9 = r7.iterator();
    L22:
        if (r9.hasNext() == false) goto L26;
        Object r10 = r9.next();
        if ((!r0.contains((View) r10)) == false) goto L22;
        r8.add(r10);
        goto L22
    L26:
        Iterator r11 = CollectionsKt.toList(r8).iterator();
    L28:
        if (r11.hasNext() == false) goto L30;
        g((View) r11.next(), "rootRemoved");
        goto L28
    L30:
        Iterator r12 = r0.iterator();
    L32:
        if (r12.hasNext() == false) goto L50;
        View r13 = (View) r12.next();
        ViewTreeObserver r14 = r13.getViewTreeObserver();
        c r15 = (c) ((LinkedHashMap) this.l).get(r13);
        if (r15 == null) goto L40;
        if (r15.b != r14) goto L40;
        if (r14.isAlive() == true) goto L32;
    L40:
        if (r15 == null) goto L47;
        if (r15.b != r14) goto L44;
        String r16 = "observerNotAlive";
    L45:
        g(r13, r16);
        goto L47
    L44:
        r16 = "observerChanged";
    L47:
        if (r14.isAlive() == false) goto L48;
        r14.addOnGlobalLayoutListener(this.n);
        Map<View, c> r17 = this.l;
        Intrinsics.checkNotNull(r14);
        r17.put(r13, new c(r13, r14));
        FLogger.a.i("KeepScreenOnDelegate", "addInputWatcherRescanListenerOnMain, root = " + r13 + ", observer = " + r14);
        goto L32
    L48:
        FLogger.a.i("KeepScreenOnDelegate", "ensureInputWatcherRescanRegistrationOnMain, observer is not alive, root = " + r13);
        goto L32
    }

    public final void d() {
        if (this.g == false) goto L5;
        return;
    L5:
        LinkedHashMap r0 = new LinkedHashMap();
        a(r0, (TextView) this.c.invoke(), "input_text");
        va8.l r1 = this.a;
        TextView r3 = null;
        if (r1 == null) goto L10;
        ViewGroup r2 = r1.d();
        if (r2 == null) goto L10;
        TextView r4 = (TextView) r2.findViewById(2131375366);
    L11:
        a(r0, r4, "input_edit");
        va8.l r5 = this.a;
        if (r5 == null) goto L16;
        ConstraintLayout r6 = r5.getRootView();
        if (r6 == null) goto L16;
        TextView r7 = (TextView) r6.findViewById(2131375366);
    L17:
        a(r0, r7, "input_edit");
        va8.l r8 = this.a;
        if (r8 == null) goto L24;
        ConstraintLayout r9 = r8.getRootView();
        if (r9 == null) goto L24;
        View r10 = r9.getRootView();
        if (r10 == null) goto L24;
        r3 = (TextView) r10.findViewById(2131375366);
    L24:
        a(r0, r3, "input_edit");
        Set r11 = r0.keySet();
        Set r12 = ((LinkedHashMap) this.k).keySet();
        ArrayList r13 = new ArrayList();
        Iterator r14 = r12.iterator();
    L26:
        if (r14.hasNext() == false) goto L30;
        Object r15 = r14.next();
        if ((!r11.contains((TextView) r15)) == false) goto L26;
        r13.add(r15);
        goto L26
    L30:
        Iterator r16 = CollectionsKt.toList(r13).iterator();
    L32:
        if (r16.hasNext() == false) goto L34;
        f((TextView) r16.next());
        goto L32
    L34:
        Iterator r17 = r0.entrySet().iterator();
    L36:
        if (r17.hasNext() == false) goto L40;
        Map.Entry r18 = (Map.Entry) r17.next();
        TextView r19 = (TextView) r18.getKey();
        String r20 = (String) r18.getValue();
        if (this.k.containsKey(r19) == true) goto L36;
        l1 r21 = new l1(r20, this);
        r19.addTextChangedListener(r21);
        this.k.put(r19, new b(r20, r21));
        FLogger.a.i("KeepScreenOnDelegate", "ensureInputWatchersOnMain, watcher registered, inputViewName = " + r20 + ", inputView = " + r19);
        goto L36
    L40:
        return;
    L16:
        r7 = null;
    L10:
        r4 = null;
        goto L11
    }

    public final void j() {
        c();
        d();
        long r0 = SystemClock.uptimeMillis();
        Map<KeepScreenOnReason, Long> r2 = this.f;
        LinkedHashMap r3 = new LinkedHashMap();
        Iterator r4 = ((LinkedHashMap) r2).entrySet().iterator();
    L3:
        boolean r5 = true;
        if (r4.hasNext() == false) goto L11;
        Map.Entry r6 = (Map.Entry) r4.next();
        if (((Number) r6.getValue()).longValue() <= r0) goto L9;
        r5 = false;
    L9:
        if (r5 == false) goto L3;
        r3.put(r6.getKey(), r6.getValue());
        goto L3
    L11:
        ArrayList r7 = new ArrayList(r3.size());
        Iterator r8 = r3.entrySet().iterator();
    L13:
        if (r8.hasNext() == false) goto L15;
        r7.add((KeepScreenOnReason) ((Map.Entry) r8.next()).getKey());
        goto L13
    L15:
        Iterator r9 = r7.iterator();
    L17:
        if (r9.hasNext() == false) goto L19;
        this.f.remove((KeepScreenOnReason) r9.next());
        goto L17
    L19:
        va8.l r10 = this.a;
        if (r10 == null) goto L24;
        ConstraintLayout r11 = r10.getRootView();
        if (r11 == null) goto L24;
    L28:
        if (r11 != null) goto L30;
    L47:
        String r12 = "syncNotEligible, currentTargetView = " + r11 + ", isWindowHost = " + ((Boolean) this.b.invoke()).booleanValue() + ", pageResumed = " + this.h;
        if (this.j == false) goto L52;
        View r13 = this.i;
        if (r13 == null) goto L52;
        i(r13, false, r12);
    L52:
        this.i = null;
        this.j = false;
    L53:
        this.d.removeCallbacks(this.m);
        Long r14 = (Long) CollectionsKt.minOrNull(((LinkedHashMap) this.f).values());
        if (r14 == null) goto L64;
        this.d.postDelayed(this.m, RangesKt.coerceAtLeast(r14.longValue() - r0, 0));
        return;
    L64:
        return;
    L30:
        if (((Boolean) this.b.invoke()).booleanValue() == true) goto L32;
    L38:
        boolean r15 = false;
    L39:
        if (r15 == false) goto L47;
        ConstraintLayout r16 = this.i;
        if (r16 != r11) goto L43;
    L46:
        i(r11, true, "syncEligible");
        this.i = r11;
        this.j = true;
        goto L53
    L43:
        if (this.j == false) goto L46;
        if (r16 == null) goto L46;
        i(r16, false, "targetViewChanged, newTargetView = " + r11);
        goto L46
    L32:
        if (this.h == false) goto L38;
        if ((!this.e.isEmpty()) == false) goto L36;
    L37:
        r15 = true;
        goto L39
    L36:
        if ((!this.f.isEmpty()) == false) goto L38;
    L24:
        va8.l r17 = this.a;
        if (r17 == null) goto L27;
        r11 = r17.d();
        goto L28
    L27:
        r11 = null;
        goto L28
    }

    public final void f(TextView r5) {
        b r0 = this.k.remove(r5);
        if (r0 != null) goto L5;
        return;
    L5:
        FLogger.a.i("KeepScreenOnDelegate", "removeInputWatcherOnMain, inputViewName = " + r0.a + ", inputView = " + r5);
        r5.removeTextChangedListener(r0.b);
    }

    public final void h(final Function0<Unit> r3) {
        if (this.g == false) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L8;
        r3.invoke();
        return;
    L8:
        this.d.post(new j1(this, r3));
    }

    public final void g(View r5, String r6) {
        c r7 = this.l.remove(r5);
        if (r7 != null) goto L5;
        return;
    L5:
        ViewTreeObserver r0 = r7.b;
        if (r0.isAlive() == false) goto L8;
        r0.removeOnGlobalLayoutListener(this.n);
    L8:
        FLogger.a.i("KeepScreenOnDelegate", "removeInputWatcherRescanListenerOnMain, root = " + r7.a + ", observer = " + r0 + ", observerAlive = " + r0.isAlive() + ", reason = " + r6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v6, types: [com.obric.assistant.util.f1] */
    /* JADX WARN: Type inference failed for: r2v7, types: [com.obric.assistant.util.g1] */
    public KeepScreenOnDelegate(va8.l r2, Function0<Boolean> r3, Function0<? extends TextView> r4) {
        Intrinsics.checkNotNullParameter(r3, "isWindowHostProvider");
        Intrinsics.checkNotNullParameter(r4, "inputTextViewProvider");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = new Handler(Looper.getMainLooper());
        this.e = new LinkedHashSet();
        this.f = new LinkedHashMap();
        this.k = new LinkedHashMap();
        this.l = new LinkedHashMap();
        this.m = new f1(this);
        this.n = new g1(this);
        h(new h1(this));
    }

    public static void a(Map r1, TextView r2, String r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r1.containsKey(r2) == true) goto L9;
        r1.put(r2, r3);
        return;
    }

    public final void i(View r4, boolean r5, String r6) {
        FLogger.a.i("KeepScreenOnDelegate", "setKeepScreenOnOnMain, targetView = " + r4 + ", value = " + r5 + ", reason = " + r6 + ", activeReasons = " + this.e + ", tailReasons = " + ((LinkedHashMap) this.f).keySet());
        r4.setKeepScreenOn(r5);
    }
}
