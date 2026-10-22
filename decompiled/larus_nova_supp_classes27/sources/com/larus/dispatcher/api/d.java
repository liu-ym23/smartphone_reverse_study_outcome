package com.larus.dispatcher.api;

import bs8.g;
import com.larus.bmhome.taskskill.model.PcDevice;
import com.larus.bmhome.taskskill.model.PcDeviceUiState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PcDeviceUiState.values().length];
            r0[PcDeviceUiState.AUTHORIZED_AVAILABLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[PcDeviceUiState.UNAUTHORIZED_AVAILABLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[PcDeviceUiState.OFFLINE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[PcDeviceUiState.CONTROL_DISABLED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[PcDeviceUiState.NEED_UPGRADE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    public static final Pair<List<PcDevice>, List<PcDevice>> a(List<PcDevice> r9) {
        if (r9 != null) goto L4;
        r9 = CollectionsKt.emptyList();
    L4:
        ArrayList r0 = new ArrayList(r9.size());
        ArrayList r1 = new ArrayList();
        ArrayList r2 = new ArrayList();
        ArrayList r3 = new ArrayList();
        ArrayList r4 = new ArrayList();
        Iterator<T> r10 = r9.iterator();
    L6:
        if (r10.hasNext() == false) goto L33;
        PcDevice r5 = (PcDevice) r10.next();
        if (r5 == null) goto L10;
        PcDeviceUiState r6 = g.b(r5);
    L12:
        if (r6 != null) goto L14;
        int r7 = -1;
    L15:
        if (r7 != (-1)) goto L17;
        r4.add(r5);
        goto L6
    L17:
        if (r7 == 1) goto L31;
        if (r7 == 2) goto L31;
        if (r7 != 3) goto L23;
        r1.add(r5);
        goto L6
    L23:
        if (r7 != 4) goto L25;
        r2.add(r5);
        goto L6
    L25:
        if (r7 != 5) goto L28;
        r3.add(r5);
        goto L6
    L28:
        throw new NoWhenBranchMatchedException();
    L31:
        r0.add(r5);
        goto L6
    L14:
        r7 = a.a[r6.ordinal()];
        goto L15
    L10:
        r6 = null;
        goto L12
    L33:
        ArrayList r11 = new ArrayList(((r1.size() + r2.size()) + r3.size()) + r4.size());
        r11.addAll(r1);
        r11.addAll(r2);
        r11.addAll(r3);
        r11.addAll(r4);
        return TuplesKt.to(r0, r11);
    }

    public static final AllDeviceResponse b(AllDeviceResponse r6) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        List<PcDevice> r0 = r6.getDevices();
        List<PcDevice> r1 = null;
        if (r0 == null) goto L14;
        List<PcDevice> r2 = r0;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r4 = r2.iterator();
    L6:
        if (r4.hasNext() == false) goto L12;
        PcDevice r5 = (PcDevice) r4.next();
        if (r5 == null) goto L10;
        PcDevice r7 = PcDevice.a(r5, null, Boolean.FALSE, null, 8175);
    L11:
        r3.add(r7);
        goto L6
    L10:
        r7 = null;
        goto L11
    L12:
        r1 = r3;
    L14:
        return r6.copy(r1);
    }
}
