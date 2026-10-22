package com.larus.dora.impl.device.settings.gesture;

import com.bytedance.dora.device.DoraDevice;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraGGestureSettingsRepository {
    public static final DoraGGestureSettingsRepository a = null;
    public static final Set<a> b = null;
    public static List<DoraGGestureSettings> c;
    public static List<DoraGGestureSettings> d;
    public static List<DoraGGestureSettings> e;
    public static List<DoraGGestureSettings> f;
    public static String g;
    public static final MutexImpl h = null;
    public static final Lazy i = null;
    public static final AtomicReference<b> j = null;
    public static final Lazy k = null;

    public static final class a {
        public final byte a;
        public final byte b;
        public final byte c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a * 31) + this.b) * 31) + this.c;
        }

        public final String toString() {
            return "GestureConfig(role=" + this.a + ", status=" + this.b + ", gesture=" + this.c + ')';
        }

        public a(byte r1, byte r2, byte r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class b {
        public final boolean a;
        public final boolean b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r1 = 1231;
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r2 = r0 * 31;
            if (this.b == true) goto L11;
            r1 = 1237;
        L11:
            return r2 + r1;
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "HeadphoneMode(left=" + this.a + ", right=" + this.b + ')';
        }

        public b(boolean r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public c(CoroutineExceptionHandler.Key r1) {
            super(r1);
        }

        public final void handleException(CoroutineContext r2, Throwable r3) {
            g49.d.b("DoraGGestureSettingsRepository", "ioScope exception, message=" + r3.getMessage());
        }
    }

    public DoraGGestureSettingsRepository() {
    }

    public final synchronized List<DoraGGestureSettings> e() {
        monitor-enter(this);
        c();     // Catch: Throwable -> L13
        List<DoraGGestureSettings> r0 = f;     // Catch: Throwable -> L13
        if (r0 != null) goto L6;
        r0 = CollectionsKt.emptyList();     // Catch: Throwable -> L13
    L6:
        List<DoraGGestureSettings> r1 = r0;     // Catch: Throwable -> L13
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));     // Catch: Throwable -> L13
        Iterator<T> r3 = r1.iterator();     // Catch: Throwable -> L13
    L7:
        if (r3.hasNext() == false) goto L11;
        r2.add(DoraGGestureSettings.a((DoraGGestureSettings) r3.next(), (byte) 0, 15));     // Catch: Throwable -> L13
        goto L7
    L11:
        monitor-exit(this);
        return r2;
    L13:
        th = move-exception;
        throw th;
    }

    static {
        a = new DoraGGestureSettingsRepository();
        b = SetsKt.setOf(new a[]{new a((byte) 16, (byte) 4, (byte) 2), new a((byte) 16, (byte) 6, (byte) 1), new a((byte) 16, (byte) 6, (byte) 2), new a((byte) 16, (byte) 6, (byte) 3), new a((byte) 0, (byte) 6, (byte) 1), new a((byte) 0, (byte) 6, (byte) 2), new a((byte) 0, (byte) 6, (byte) 3)});
        c = CollectionsKt.emptyList();
        d = CollectionsKt.emptyList();
        e = CollectionsKt.emptyList();
        h = kotlinx.coroutines.sync.b.a();
        i = LazyKt.lazy(new n());
        j = new AtomicReference(new b(false, false));
        k = LazyKt.lazy(new o());
    }

    public static LastSwitchSide f() {
        Keva r0 = (Keva) i.getValue();
        LastSwitchSide r1 = LastSwitchSide.BUTTON;
        int r2 = r0.getInt("dora_g_key_gesture_settings_last_switch_side", r1.getValue());
        LastSwitchSide.Companion.getClass();
        LastSwitchSide r3 = (LastSwitchSide) LastSwitchSide.access$getValues$cp().get(Integer.valueOf(r2));
        if (r3 != null) goto L6;
        return r1;
    L6:
        return r3;
    }

    public final synchronized void c() {
        monitor-enter(this);
        String r0 = g();     // Catch: Throwable -> L45
        if (f == null) goto L11;
        if (Intrinsics.areEqual(g, r0) == false) goto L11;
        monitor-exit(this);
        return;
    L11:
        f = null;     // Catch: Throwable -> L45
        g = r0;     // Catch: Throwable -> L45
        String r1 = ((Keva) i.getValue()).getString(r0, "");     // Catch: Throwable -> L45
        if (r1 != null) goto L14;
        r1 = "";
    L14:
        String r3 = r1;
        if (r3.length() != 0) goto L18;
        boolean r2 = true;
    L19:
        if (r2 == false) goto L22;
        monitor-exit(this);
        return;
    L22:
        List r4 = StringsKt.split$default(r3, new String[]{";"}, false, 0, 6, null);     // Catch: Throwable -> L45
        ArrayList r5 = new ArrayList();     // Catch: Throwable -> L45
        Iterator r6 = r4.iterator();     // Catch: Throwable -> L45
    L24:
        if (r6.hasNext() == false) goto L41;
        List r7 = StringsKt.split$default((String) r6.next(), new String[]{","}, false, 0, 6, null);     // Catch: Throwable -> L45
        if (r7.size() != 4) goto L37;
        Integer r8 = StringsKt.toIntOrNull((String) ListProtector.get(r7, 0));     // Catch: Throwable -> L45
        if (r8 == null) goto L37;
        byte r9 = (byte) r8.intValue();     // Catch: Throwable -> L45
        Integer r10 = StringsKt.toIntOrNull((String) ListProtector.get(r7, 1));     // Catch: Throwable -> L45
        if (r10 == null) goto L37;
        byte r11 = (byte) r10.intValue();     // Catch: Throwable -> L45
        Integer r12 = StringsKt.toIntOrNull((String) ListProtector.get(r7, 2));     // Catch: Throwable -> L45
        if (r12 == null) goto L37;
        byte r13 = (byte) r12.intValue();     // Catch: Throwable -> L45
        Integer r14 = StringsKt.toIntOrNull((String) ListProtector.get(r7, 3));     // Catch: Throwable -> L45
        if (r14 == null) goto L37;
        DoraGGestureSettings r15 = new DoraGGestureSettings(r9, r11, r13, (byte) r14.intValue());     // Catch: Throwable -> L45
    L38:
        if (r15 == null) goto L24;
        r5.add(r15);     // Catch: Throwable -> L45
    L37:
        r15 = null;
        goto L38
    L41:
        if ((!r5.isEmpty()) == false) goto L43;
        g49.d.d("DoraGGestureSettingsRepository", "ensureGestureSettingsCacheLoaded: restoredSize=" + r5.size());     // Catch: Throwable -> L45
        l(r5, false);     // Catch: Throwable -> L45
    L43:
        monitor-exit(this);
        return;
    L18:
        r2 = false;
    L45:
        th = move-exception;
        throw th;
    }

    public static String g() {
        DoraDevice r0 = kj4.a.g().c();
        if (r0 == null) goto L6;
        String r1 = r0.mac;
        if (r1 == null) goto L6;
    L13:
        return "dora_g_key_gesture_settings_cache_".concat(r1);
    L6:
        DoraDevice r2 = DoraAdapterExtKt.h(kj4.a.g());
        if (r2 == null) goto L9;
        r1 = r2.mac;
    L10:
        if (r1 != null) goto L13;
        r1 = "";
        goto L13
    L9:
        r1 = null;
        goto L10
    }

    public static boolean j(List r8) {
        boolean r1 = false;
        if (r8.isEmpty() == false) goto L6;
        g49.d.d("DoraGGestureSettingsRepository", "shouldShowOtaTooLowToast: skip because gesture settings response is empty");
        return false;
    L6:
        List r0 = r8;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r2 = r0.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        DoraGGestureSettings r4 = (DoraGGestureSettings) r2.next();
        r3.add(new a(r4.a, r4.b, r4.c));
        goto L8
    L10:
        Set r5 = CollectionsKt.toSet(r3);
        Set<a> r6 = b;
        if ((r6 instanceof Collection) == true) goto L13;
    L15:
        Iterator<T> r7 = r6.iterator();
    L17:
        if (r7.hasNext() == false) goto L21;
        if (r5.contains((a) r7.next()) == true) goto L17;
    L22:
        g49.d.d("DoraGGestureSettingsRepository", "shouldShowOtaTooLowToast: isNewGestureConfig=" + r1 + ", rawSize=" + r8.size());
        return !r1;
    L21:
        r1 = true;
        goto L22
    L13:
        if (r6.isEmpty() == false) goto L15;
        goto L15
    }

    public static void k(LastSwitchSide r2) {
        Intrinsics.checkNotNullParameter(r2, "lastSwitchSide");
        ((Keva) i.getValue()).storeInt("dora_g_key_gesture_settings_last_switch_side", r2.getValue());
    }

    public final synchronized void b(String r4) {
        monitor-enter(this);
        if (r4 != null) goto L20;
        r4 = "";
    L20:
        f = null;     // Catch: Throwable -> L17
        g = null;     // Catch: Throwable -> L17
        if (r4.length() != 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L14;
        g49.d.e("DoraGGestureSettingsRepository", "clearCache: mac is empty, only cleared memory cache");     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L14:
        String r5 = "dora_g_key_gesture_settings_cache_".concat(r4);     // Catch: Throwable -> L17
        g49.d.d("DoraGGestureSettingsRepository", "clearCache: remove keva key=" + r5);     // Catch: Throwable -> L17
        ((Keva) i.getValue()).erase(r5);     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L9:
        r1 = false;
    L17:
        th = move-exception;
        throw th;
    }

    public final Object d(Continuation<? super Boolean> r9) {
        if ((r9 instanceof DoraGGestureSettingsRepository$fetchConfigButtonLiveAI$1) == false) goto L7;
        DoraGGestureSettingsRepository$fetchConfigButtonLiveAI$1 r0 = (DoraGGestureSettingsRepository$fetchConfigButtonLiveAI$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r10);
    L19:
        List<DoraGGestureSettings> r11 = CollectionsKt.toMutableList((Collection) r10);
        if ((!r11.isEmpty()) == false) goto L22;
        f = r11;
    L22:
        g49.d.d("DoraGOBViewModelV2", "gesture list: " + f);
        List<DoraGGestureSettings> r12 = f;
        if (r12 == null) goto L35;
        ArrayList r5 = new ArrayList();
        Iterator<T> r13 = r12.iterator();
    L26:
        if (r13.hasNext() == false) goto L36;
        Object r6 = r13.next();
        DoraGGestureSettings r7 = (DoraGGestureSettings) r6;
        if (r7.b == 4) goto L30;
    L32:
        boolean r8 = false;
    L33:
        if (r8 == false) goto L26;
        r5.add(r6);
        goto L26
    L30:
        if (r7.c != 6) goto L32;
        r8 = true;
    L36:
        if (r5 != null) goto L38;
    L41:
        boolean r14 = true;
    L42:
        if (r14 == false) goto L45;
        return null;
    L45:
        if (((DoraGGestureSettings) CollectionsKt.first(r5)).d == 33) goto L49;
        r4 = false;
    L49:
        return Boxing.boxBoolean(r4);
    L38:
        if (r5.isEmpty() == true) goto L41;
        r14 = false;
        goto L42
    L35:
        r5 = null;
        goto L36
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        if (f != null) goto L22;
        kj4.a r15 = kj4.a.g();
        r0.label = 1;
        r10 = DoraAdapterExtKt.m(r15);
        if (r10 != r2) goto L19;
        return r2;
    L7:
        r0 = new DoraGGestureSettingsRepository$fetchConfigButtonLiveAI$1(this, r9);
        goto L8
    }

    public final Object h(Continuation<? super m> r12) {
        if ((r12 instanceof DoraGGestureSettingsRepository$load$1) == false) goto L7;
        DoraGGestureSettingsRepository$load$1 r2 = (DoraGGestureSettingsRepository$load$1) r12;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r13 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        boolean r7 = true;
        if (r5 == 0) goto L20;
        if (r5 == 1) goto L19;
        if (r5 != 2) goto L18;
        kotlinx.coroutines.sync.a r6 = (kotlinx.coroutines.sync.a) r2.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L15
    L27:
        List<DoraGGestureSettings> r14 = CollectionsKt.toMutableList((Collection) r13);     // Catch: Throwable -> L15
        DoraGGestureSettingsRepository r8 = a;     // Catch: Throwable -> L15
        boolean r9 = j(r14);     // Catch: Throwable -> L15
        if ((!r14.isEmpty()) == false) goto L37;
        g49.d.d("DoraGGestureSettingsRepository", "load: fetched gestureList=" + r14);     // Catch: Throwable -> L15
        r8.l(r14, true);     // Catch: Throwable -> L15
        if (r9 == true) goto L34;
        r7 = false;
    L34:
        m r0 = new m(r14, r7);     // Catch: Throwable -> L15
        r6.unlock(null);
        return r0;
    L37:
        List<DoraGGestureSettings> r15 = r8.e();     // Catch: Throwable -> L15
        g49.d.e("DoraGGestureSettingsRepository", "load: fetched empty gesture list, fallback to cache size=" + ((ArrayList) r15).size());     // Catch: Throwable -> L15
        if (r9 == true) goto L41;
        r7 = false;
    L41:
        m r1 = new m(r15, r7);     // Catch: Throwable -> L15
        r6.unlock(null);
        return r1;
    L15:
        th = move-exception;
        th = th;
        kotlinx.coroutines.sync.a r16 = r6;
    L46:
        r16.unlock(null);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        kotlinx.coroutines.sync.a r10 = (kotlinx.coroutines.sync.a) r2.L$0;
        ResultKt.throwOnFailure(r13);
        r16 = r10;
    L49:
        kj4.a r11 = kj4.a.g();     // Catch: Throwable -> L45
        r2.L$0 = r16;     // Catch: Throwable -> L45
        r2.label = 2;     // Catch: Throwable -> L45
        Object r17 = DoraAdapterExtKt.m(r11);     // Catch: Throwable -> L45
        if (r17 != r4) goto L26;
        return r4;
    L26:
        r6 = r16;
        r13 = r17;
    L45:
        th = th;
        goto L46
    L20:
        ResultKt.throwOnFailure(r13);
        r16 = h;
        r2.L$0 = r16;
        r2.label = 1;
        if (r16.a(null, r2) != r4) goto L49;
        return r4;
    L7:
        r2 = new DoraGGestureSettingsRepository$load$1(this, r12);
        goto L8
    }

    public final synchronized void i(List<DoraGGestureSettings> r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "settingsList");     // Catch: Throwable -> L37
        c();     // Catch: Throwable -> L37
        if (r10.isEmpty() == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        List<DoraGGestureSettings> r0 = f;     // Catch: Throwable -> L37
        if (r0 != null) goto L10;
        r0 = CollectionsKt.emptyList();     // Catch: Throwable -> L37
    L10:
        List r1 = CollectionsKt.toMutableList(r0);     // Catch: Throwable -> L37
        Iterator<T> r11 = r10.iterator();     // Catch: Throwable -> L37
    L11:
        int r2 = 0;
        if (r11.hasNext() == false) goto L31;
        DoraGGestureSettings r3 = (DoraGGestureSettings) r11.next();     // Catch: Throwable -> L37
        Iterator r4 = r1.iterator();     // Catch: Throwable -> L37
        int r5 = 0;
    L15:
        if (r4.hasNext() == false) goto L27;
        DoraGGestureSettings r6 = (DoraGGestureSettings) r4.next();     // Catch: Throwable -> L37
        if (r6.a == r3.a) goto L19;
    L23:
        boolean r7 = false;
    L24:
        if (r7 == true) goto L28;
        r5 = r5 + 1;     // Catch: Throwable -> L37
    L28:
        if (r5 >= 0) goto L29;
        r1.add(r3);     // Catch: Throwable -> L37
        goto L11
    L29:
        ListProtector.set(r1, r5, r3);     // Catch: Throwable -> L37
        goto L11
    L19:
        if (r6.b != r3.b) goto L23;
        if (r6.c != r3.c) goto L23;
        r7 = true;
        goto L24
    L27:
        r5 = -1;
        goto L28
    L31:
        l(CollectionsKt.toList(r1), true);     // Catch: Throwable -> L37
        StringBuilder r8 = new StringBuilder();     // Catch: Throwable -> L37
        r8.append("mergeGestureSettings: mergedSize=");     // Catch: Throwable -> L37
        List<DoraGGestureSettings> r9 = f;     // Catch: Throwable -> L37
        if (r9 == null) goto L34;
        r2 = r9.size();     // Catch: Throwable -> L37
    L34:
        r8.append(r2);     // Catch: Throwable -> L37
        g49.d.d("DoraGGestureSettingsRepository", r8.toString());     // Catch: Throwable -> L37
        monitor-exit(this);
        return;
    L37:
        th = move-exception;
        throw th;
    }

    public static final Object a(DoraGGestureSettingsRepository r14, Continuation r15) {
        r14.getClass();
        if ((r15 instanceof DoraGGestureSettingsRepository$loadListForBuryPoint$1) == false) goto L7;
        DoraGGestureSettingsRepository$loadListForBuryPoint$1 r0 = (DoraGGestureSettingsRepository$loadListForBuryPoint$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r17 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L20;
        if (r2 == 1) goto L19;
        if (r2 != 2) goto L18;
        kotlinx.coroutines.sync.a r18 = (kotlinx.coroutines.sync.a) r0.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L15
    L27:
        List r110 = CollectionsKt.toMutableList((Collection) r16);     // Catch: Throwable -> L15
        ArrayList r3 = new ArrayList();     // Catch: Throwable -> L15
        Iterator r4 = r110.iterator();     // Catch: Throwable -> L15
    L28:
        boolean r6 = false;
        if (r4.hasNext() == false) goto L38;
        Object r5 = r4.next();     // Catch: Throwable -> L15
        DoraGGestureSettings r10 = (DoraGGestureSettings) r5;     // Catch: Throwable -> L15
        if (r10.a == 16) goto L33;
    L35:
        if (r6 == false) goto L28;
        r3.add(r5);     // Catch: Throwable -> L15
        goto L28
    L33:
        if (SetsKt.setOf(new Byte[]{Boxing.boxByte((byte) 6), Boxing.boxByte((byte) 1), Boxing.boxByte((byte) 2)}).contains(Boxing.boxByte(r10.b)) == false) goto L35;
        r6 = true;
        goto L35
    L38:
        if ((!r3.isEmpty()) == false) goto L40;
        c = r3;     // Catch: Throwable -> L15
    L40:
        ArrayList r7 = new ArrayList();     // Catch: Throwable -> L15
        Iterator r8 = r110.iterator();     // Catch: Throwable -> L15
    L42:
        if (r8.hasNext() == false) goto L52;
        Object r9 = r8.next();     // Catch: Throwable -> L15
        DoraGGestureSettings r11 = (DoraGGestureSettings) r9;     // Catch: Throwable -> L15
        if (r11.a == 0) goto L46;
    L48:
        boolean r12 = false;
    L49:
        if (r12 == false) goto L42;
        r7.add(r9);     // Catch: Throwable -> L15
        goto L42
    L46:
        if (SetsKt.setOf(new Byte[]{Boxing.boxByte((byte) 6), Boxing.boxByte((byte) 1), Boxing.boxByte((byte) 2)}).contains(Boxing.boxByte(r11.b)) == false) goto L48;
        r12 = true;
        goto L49
    L52:
        if ((!r7.isEmpty()) == false) goto L54;
        d = r7;     // Catch: Throwable -> L15
    L54:
        ArrayList r13 = new ArrayList();     // Catch: Throwable -> L15
        Iterator r111 = r110.iterator();     // Catch: Throwable -> L15
    L56:
        if (r111.hasNext() == false) goto L66;
        Object r20 = r111.next();     // Catch: Throwable -> L15
        DoraGGestureSettings r21 = (DoraGGestureSettings) r20;     // Catch: Throwable -> L15
        if (SetsKt.setOf(new Byte[]{Boxing.boxByte((byte) 16), Boxing.boxByte((byte) 16)}).contains(Boxing.boxByte(r21.a)) == true) goto L60;
    L62:
        boolean r22 = false;
    L63:
        if (r22 == false) goto L56;
        r13.add(r20);     // Catch: Throwable -> L15
        goto L56
    L60:
        if (r21.b != 4) goto L62;
        r22 = true;
        goto L63
    L66:
        if ((!r13.isEmpty()) == false) goto L68;
        e = r13;     // Catch: Throwable -> L15
    L68:
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r18.unlock(null);
        return Unit.INSTANCE;
    L15:
        th = move-exception;
        kotlinx.coroutines.sync.a r113 = r18;
        th = th;
        kotlinx.coroutines.sync.a r114 = r113;
    L73:
        r114.unlock(null);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        kotlinx.coroutines.sync.a r23 = (kotlinx.coroutines.sync.a) r0.L$0;
        ResultKt.throwOnFailure(r16);
        r114 = r23;
    L75:
        kj4.a r24 = kj4.a.g();     // Catch: Throwable -> L72
        r0.L$0 = r114;     // Catch: Throwable -> L72
        r0.label = 2;     // Catch: Throwable -> L72
        Object r25 = DoraAdapterExtKt.m(r24);     // Catch: Throwable -> L72
        if (r25 == r17) goto L95;
        r18 = r114;
        r16 = r25;
        goto L27
    L95:
        return r17;
    L72:
        th = th;
        goto L73
    L20:
        ResultKt.throwOnFailure(r16);
        r114 = h;
        r0.L$0 = r114;
        r0.label = 1;
        if (r114.a(null, r0) != r17) goto L75;
        return r17;
    L7:
        r0 = new DoraGGestureSettingsRepository$loadListForBuryPoint$1(r14, r15);
        goto L8
    }

    public static void m(boolean r4, boolean r5) {
        g49.d.d("DoraGGestureSettingsRepository", "updateHeadphoneMode: isLeft=" + r4 + ", isInHeadphoneMode=" + r5);
    L3:
        AtomicReference<b> r0 = j;
        b r1 = r0.get();
        if (r4 == false) goto L6;
        boolean r2 = r1.b;
        r1.getClass();
        b r3 = new b(r5, r2);
    L8:
        if (r0.compareAndSet(r1, r3) == true) goto L9;
        if (r0.get() == r1) goto L8;
        boolean r6 = false;
    L13:
        if (r6 == false) goto L3;
        return;
    L9:
        r6 = true;
        goto L13
    L6:
        boolean r7 = r1.a;
        r1.getClass();
        r3 = new b(r7, r5);
        goto L8
    }

    public final synchronized void l(List<DoraGGestureSettings> r11, boolean r12) {
        monitor-enter(this);
        List<DoraGGestureSettings> r0 = r11;     // Catch: Throwable -> L46
        boolean r2 = true;
        if ((r0 instanceof Collection) == true) goto L6;
    L8:
        Iterator<T> r1 = r0.iterator();     // Catch: Throwable -> L46
    L10:
        if (r1.hasNext() == false) goto L19;
        DoraGGestureSettings r3 = (DoraGGestureSettings) r1.next();     // Catch: Throwable -> L46
        if (r3.a == 16) goto L14;
    L16:
        boolean r4 = false;
    L17:
        if (r4 == false) goto L10;
        boolean r5 = true;
    L20:
        List<DoraGGestureSettings> r6 = r11;     // Catch: Throwable -> L46
        if ((r6 instanceof Collection) == true) goto L23;
    L25:
        Iterator<T> r7 = r6.iterator();     // Catch: Throwable -> L46
    L27:
        if (r7.hasNext() == false) goto L36;
        DoraGGestureSettings r8 = (DoraGGestureSettings) r7.next();     // Catch: Throwable -> L46
        if (r8.a == 0) goto L31;
    L33:
        boolean r9 = false;
    L34:
        if (r9 == false) goto L27;
    L37:
        b r10 = new b(r5, r2);     // Catch: Throwable -> L46
        j.set(r10);     // Catch: Throwable -> L46
        List<DoraGGestureSettings> r13 = r11;     // Catch: Throwable -> L46
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));     // Catch: Throwable -> L46
        Iterator<T> r15 = r13.iterator();     // Catch: Throwable -> L46
    L39:
        if (r15.hasNext() == false) goto L41;
        r14.add(DoraGGestureSettings.a((DoraGGestureSettings) r15.next(), (byte) 0, 15));     // Catch: Throwable -> L46
        goto L39
    L41:
        f = r14;     // Catch: Throwable -> L46
        g = g();     // Catch: Throwable -> L46
        if (r12 == false) goto L44;
        String r16 = CollectionsKt.joinToString$default(r11, ";", null, null, 0, null, new p(), 30, null);     // Catch: Throwable -> L46
        ((Keva) i.getValue()).storeString(g(), r16);     // Catch: Throwable -> L46
    L44:
        monitor-exit(this);
        return;
    L31:
        if (r8.d != 40) goto L33;
        r9 = true;
    L36:
        r2 = false;
        goto L37
    L23:
        if (r6.isEmpty() == false) goto L25;
    L14:
        if (r3.d != 40) goto L16;
        r4 = true;
    L19:
        r5 = false;
        goto L20
    L6:
        if (r0.isEmpty() == false) goto L8;
    L46:
        th = move-exception;
        throw th;
    }
}
