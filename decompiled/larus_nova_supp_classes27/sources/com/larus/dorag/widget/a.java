package com.larus.dorag.widget;

import com.larus.dorag.widget.model.DoraWidgetEntryContent;
import com.larus.utils.logger.FLogger;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a implements h49.h {
    public a() {
    }

    @Override // h49.h
    public final void a(h49.b r510) {
        Intrinsics.checkNotNullParameter(r510, "info");
        FLogger.a.i("DoraWidgetCenter", "DoraWidgetCallback: onChargeStateChanged, charge: " + r510.c);
        DoraWidgetEntryContent r1 = f79.a.b();
        if (r1 != null) goto L5;
        r1 = new DoraWidgetEntryContent(null, false, false, false, 0, 0, null, null, 0, 0, null, null, 0, null, null, null, null, 0, null, null, null, null, 4194303, null);
    L5:
        DoraWidgetEntryContent r30 = r1;
        String r2 = r510.a;
        if (r2 != null) goto L8;
        String r31 = "";
    L9:
        int[] r3 = r510.b;
        if (r3 == null) goto L14;
        Integer r4 = ArraysKt.getOrNull(r3, 0);
        if (r4 == null) goto L14;
        int r35 = r4.intValue();
    L15:
        int[] r5 = r510.b;
        if (r5 == null) goto L20;
        Integer r6 = ArraysKt.getOrNull(r5, 2);
        if (r6 == null) goto L20;
        int r36 = r6.intValue();
    L21:
        int[] r7 = r510.c;
        if (r7 == null) goto L29;
        Integer r8 = ArraysKt.getOrNull(r7, 0);
        if (r8 == null) goto L29;
        if (r8.intValue() != 1) goto L29;
        boolean r33 = true;
    L30:
        int[] r9 = r510.c;
        if (r9 == null) goto L38;
        Integer r10 = ArraysKt.getOrNull(r9, 2);
        if (r10 == null) goto L38;
        if (r10.intValue() != 1) goto L38;
        boolean r34 = true;
    L39:
        String r11 = r510.d;
        if (r11 != null) goto L42;
        String r37 = "";
    L43:
        String r12 = r510.e;
        if (r12 != null) goto L46;
        String r38 = "";
    L47:
        Integer r0 = r510.f;
        if (r0 == null) goto L50;
        int r13 = r0.intValue();
    L52:
        if (f79.a.f(DoraWidgetEntryContent.copy$default(r30, r31, true, r33, r34, r35, r36, r37, r38, r13, System.currentTimeMillis(), null, null, 0, null, null, null, null, 0, null, null, null, null, 4193280, null)) == false) goto L55;
        String r14 = f.a;
        f.a();
        return;
    L55:
        return;
    L50:
        r13 = r30.getProductId();
        goto L52
    L46:
        r38 = r12;
        goto L47
    L42:
        r37 = r11;
    L38:
        r34 = false;
    L29:
        r33 = false;
    L20:
        r36 = -1;
    L14:
        r35 = -1;
        goto L15
    L8:
        r31 = r2;
        goto L9
    }

    @Override // h49.h
    public final void b(h49.b r60) {
        Intrinsics.checkNotNullParameter(r60, "info");
        FLogger.a.i("DoraWidgetCenter", "DoraWidgetCallback: onBatteryChanged, battery: " + r60.b);
        f.b = true;
        DoraWidgetEntryContent r2 = f79.a.b();
        if (r2 != null) goto L5;
        r2 = new DoraWidgetEntryContent(null, false, false, false, 0, 0, null, null, 0, 0, null, null, 0, null, null, null, null, 0, null, null, null, null, 4194303, null);
    L5:
        DoraWidgetEntryContent r31 = r2;
        String r3 = r60.a;
        if (r3 != null) goto L8;
        String r32 = "";
    L9:
        int[] r4 = r60.b;
        if (r4 == null) goto L14;
        Integer r5 = ArraysKt.getOrNull(r4, 0);
        if (r5 == null) goto L14;
        int r36 = r5.intValue();
    L15:
        int[] r6 = r60.b;
        if (r6 == null) goto L20;
        Integer r7 = ArraysKt.getOrNull(r6, 2);
        if (r7 == null) goto L20;
        int r37 = r7.intValue();
    L21:
        int[] r8 = r60.c;
        if (r8 == null) goto L29;
        Integer r9 = ArraysKt.getOrNull(r8, 0);
        if (r9 == null) goto L29;
        if (r9.intValue() != 1) goto L29;
        boolean r34 = true;
    L30:
        int[] r10 = r60.c;
        if (r10 == null) goto L38;
        Integer r11 = ArraysKt.getOrNull(r10, 2);
        if (r11 == null) goto L38;
        if (r11.intValue() != 1) goto L38;
        boolean r35 = true;
    L39:
        String r1 = r60.d;
        if (r1 != null) goto L42;
        String r38 = "";
    L43:
        String r12 = r60.e;
        if (r12 != null) goto L46;
        String r310 = "";
    L47:
        Integer r0 = r60.f;
        if (r0 == null) goto L50;
        int r13 = r0.intValue();
    L52:
        if (f79.a.f(DoraWidgetEntryContent.copy$default(r31, r32, true, r34, r35, r36, r37, r38, r310, r13, System.currentTimeMillis(), null, null, 0, null, null, null, null, 0, null, null, null, null, 4193280, null)) == false) goto L55;
        String r14 = f.a;
        f.a();
        return;
    L55:
        return;
    L50:
        r13 = r31.getProductId();
        goto L52
    L46:
        r310 = r12;
        goto L47
    L42:
        r38 = r1;
    L38:
        r35 = false;
    L29:
        r34 = false;
    L20:
        r37 = -1;
    L14:
        r36 = -1;
        goto L15
    L8:
        r32 = r3;
        goto L9
    }

    @Override // h49.h
    public final void c(h49.b r62, int r63) {
        Intrinsics.checkNotNullParameter(r62, "info");
        if (r63 != 0) goto L5;
        FLogger.a.i("DoraWidgetCenter", "DoraWidgetCallback: onDoraLinkStateChanged, state: disconnected");
        DoraWidgetEntryContent r3 = f79.a.b();
        if (r3 == null) goto L64;
        f79.a.f(DoraWidgetEntryContent.copy$default(r3, null, false, false, false, 0, 0, null, null, 0, System.currentTimeMillis(), null, null, 0, null, null, null, null, 0, null, null, null, null, 4193789, null));
    L64:
        String r0 = f.a;
        f.a();
        return;
    L5:
        if (r63 != 2) goto L67;
        FLogger.a.i("DoraWidgetCenter", "DoraWidgetCallback: onDoraLinkStateChanged, state: connected");
        f.a = "";
        f.b = true;
        DoraWidgetEntryContent r4 = f79.a.b();
        if (r4 != null) goto L10;
        r4 = new DoraWidgetEntryContent(null, false, false, false, 0, 0, null, null, 0, 0, null, null, 0, null, null, null, null, 0, null, null, null, null, 4194303, null);
    L10:
        DoraWidgetEntryContent r33 = r4;
        String r5 = r62.a;
        if (r5 != null) goto L13;
        String r34 = "";
    L14:
        int[] r6 = r62.b;
        if (r6 == null) goto L19;
        Integer r7 = ArraysKt.getOrNull(r6, 0);
        if (r7 == null) goto L19;
        int r38 = r7.intValue();
    L20:
        int[] r8 = r62.b;
        if (r8 == null) goto L25;
        Integer r9 = ArraysKt.getOrNull(r8, 2);
        if (r9 == null) goto L25;
        int r310 = r9.intValue();
    L26:
        int[] r10 = r62.c;
        if (r10 == null) goto L34;
        Integer r11 = ArraysKt.getOrNull(r10, 0);
        if (r11 == null) goto L34;
        if (r11.intValue() != 1) goto L34;
        boolean r36 = true;
    L35:
        int[] r12 = r62.c;
        if (r12 == null) goto L43;
        Integer r13 = ArraysKt.getOrNull(r12, 2);
        if (r13 == null) goto L43;
        if (r13.intValue() != 1) goto L43;
        boolean r37 = true;
    L44:
        String r2 = r62.d;
        if (r2 != null) goto L47;
        String r40 = "";
    L48:
        String r14 = r62.e;
        if (r14 != null) goto L51;
        String r41 = "";
    L52:
        Integer r1 = r62.f;
        if (r1 == null) goto L55;
        int r15 = r1.intValue();
    L57:
        if (f79.a.f(DoraWidgetEntryContent.copy$default(r33, r34, true, r36, r37, r38, r310, r40, r41, r15, System.currentTimeMillis(), null, null, 0, null, null, null, null, 0, null, null, null, null, 4193280, null)) == false) goto L59;
        String r16 = f.a;
        f.a();
    L59:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraWidgetCenter$pullNoteUrl$1(null), 3, null);
        return;
    L55:
        r15 = r33.getProductId();
        goto L57
    L51:
        r41 = r14;
        goto L52
    L47:
        r40 = r2;
    L43:
        r37 = false;
    L34:
        r36 = false;
    L25:
        r310 = -1;
    L19:
        r38 = -1;
        goto L20
    L13:
        r34 = r5;
        goto L14
    }
}
