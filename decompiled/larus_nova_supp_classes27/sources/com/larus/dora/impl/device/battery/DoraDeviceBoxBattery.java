package com.larus.dora.impl.device.battery;

import g49.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraDeviceBoxBattery {
    public static Job a;
    public static int b;
    public static int c;
    public static boolean d;
    public static Function1<? super Integer, Unit> e;
    public static final Lazy f = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/dora/impl/device/battery/DoraDeviceBoxBattery$From;", "", "<init>", "(Ljava/lang/String;I)V", "INIT", "CHARGE_EXCEPTION", "DISCHARGE_EXCEPTION", "LOOP_START", "LOOP", "NORMAL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum From extends Enum<From> {
        public static final From CHARGE_EXCEPTION = null;
        public static final From DISCHARGE_EXCEPTION = null;
        public static final From INIT = null;
        public static final From LOOP = null;
        public static final From LOOP_START = null;
        public static final From NORMAL = null;
        public static final /* synthetic */ From[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<From> getEntries() {
            return b;
        }

        static {
            From r0 = new From("INIT", 0);
            INIT = r0;
            From r1 = new From("CHARGE_EXCEPTION", 1);
            CHARGE_EXCEPTION = r1;
            From r3 = new From("DISCHARGE_EXCEPTION", 2);
            DISCHARGE_EXCEPTION = r3;
            From r5 = new From("LOOP_START", 3);
            LOOP_START = r5;
            From r7 = new From("LOOP", 4);
            LOOP = r7;
            From r9 = new From("NORMAL", 5);
            NORMAL = r9;
            From[] r11 = {r0, r1, r3, r5, r7, r9};
            a = r11;
            b = EnumEntriesKt.enumEntries(r11);
        }

        public static From[] values() {
            return (From[]) a.clone();
        }

        public static From valueOf(String r1) {
            return (From) a.a(From.class, r1);
        }

        public From(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static void c() {
        d = false;
        Job r0 = a;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        a = null;
    }

    static {
        b = -1;
        c = -1;
        f = LazyKt.lazy(new l());
    }

    public static void a(int r2, From r3) {
        d.d("DoraDeviceBoxBattery", "boxBatteryOptimized: inputBattery=" + b + ", previous=" + c + ", now=" + r2 + ", from=" + r3);
        c = r2;
        Function1<? super Integer, Unit> r4 = e;
        if (r4 == null) goto L6;
        r4.invoke(Integer.valueOf(r2));
        return;
    }

    public static void b(CoroutineScope r8, int r9, boolean r10, Function1 r11) {
        Intrinsics.checkNotNullParameter(r8, "scope");
        Intrinsics.checkNotNullParameter(r11, "onBoxBatteryOptimized");
        if (((Boolean) f.getValue()).booleanValue() == true) goto L6;
        r11.invoke(Integer.valueOf(r9));
        return;
    L6:
        if (r9 == 0) goto L28;
        int r0 = c;
        if (r0 == 0) goto L28;
        b = r9;
        e = r11;
        d.d("DoraDeviceBoxBattery", "optimize: inputBattery=" + r9 + ", isCharging=" + r10 + ", displayedBattery=" + r0);
        if (r0 > 0) goto L14;
        a(r9, From.INIT);
        return;
    L14:
        if (r10 == false) goto L17;
        if (r9 >= r0) goto L17;
        c();
        a(r0, From.CHARGE_EXCEPTION);
        return;
    L17:
        if (r10 == true) goto L21;
        if (r9 <= r0) goto L21;
        c();
        a(r0, From.DISCHARGE_EXCEPTION);
        return;
    L21:
        if (Math.abs(r9 - r0) <= 1) goto L26;
        a(r0, From.LOOP_START);
        if (d == false) goto L25;
        d.d("DoraDeviceBoxBattery", "startLoop: already in looping");
        return;
    L25:
        d = true;
        a = BuildersKt.launch$default(r8, Dispatchers.getMain(), null, new DoraDeviceBoxBattery$startLoop$1(null), 2, null);
        return;
    L26:
        c();
        a(r9, From.NORMAL);
        return;
    L28:
        r11.invoke(Integer.valueOf(r9));
    }
}
