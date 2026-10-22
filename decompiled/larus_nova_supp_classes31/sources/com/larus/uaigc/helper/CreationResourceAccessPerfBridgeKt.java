package com.larus.uaigc.helper;

import com.larus.bmhome.resource.access.ResourceNodeStatus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class CreationResourceAccessPerfBridgeKt {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ResourceNodeStatus.values().length];
            r0[ResourceNodeStatus.RUNNING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[ResourceNodeStatus.SKIPPED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[ResourceNodeStatus.CONTINUED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[ResourceNodeStatus.READY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[ResourceNodeStatus.FALLBACK.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[ResourceNodeStatus.FAILED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[ResourceNodeStatus.CANCELLED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            a = r0;
        }
    }

    public static /* synthetic */ Object b(com.larus.bmhome.resource.access.b0 r7, String r8, Function1 r9, Function1 r10, Continuation r11) {
        return a(r7, r8, null, null, r9, r10, r11);
    }

    public static final void c(String r5, String r6, String r7, String r8, com.larus.bmhome.resource.access.q0 r9) {
        if (Intrinsics.areEqual(r9.a, "preprocess") == true) goto L5;
        return;
    L5:
        Pair[] r0 = new Pair[2];
        String r1 = (String) r9.f.get("preprocess_file_size");
        String r2 = "";
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        r0[0] = TuplesKt.to("file_size", r1);
        String r10 = (String) r9.f.get("preprocess_file_type");
        if (r10 == null) goto L12;
        r2 = r10;
    L12:
        r0[1] = TuplesKt.to("file_type", r2);
        List r11 = CollectionsKt.listOf(r0);
        ArrayList r3 = new ArrayList();
        Iterator r12 = r11.iterator();
    L14:
        if (r12.hasNext() == false) goto L22;
        Object r4 = r12.next();
        if (((CharSequence) ((Pair) r4).getSecond()).length() <= 0) goto L18;
        boolean r13 = true;
    L19:
        if (r13 == false) goto L14;
        r3.add(r4);
        goto L14
    L18:
        r13 = false;
        goto L19
    L22:
        if (r3.isEmpty() == false) goto L24;
        return;
    L24:
        nz9.b.d(r7, r3, r8);
        nz9.b.d(r5, r3, r6);
    }

    public static final Object a(com.larus.bmhome.resource.access.b0 r9, String r10, String r11, String r12, Function1<? super com.larus.bmhome.resource.access.a0.e, Unit> r13, Function1<? super com.larus.bmhome.resource.access.a0.f, Unit> r14, Continuation<? super com.larus.bmhome.resource.access.a0> r15) {
        return CoroutineScopeKt.coroutineScope(new CreationResourceAccessPerfBridgeKt$awaitTerminalStateWithCreationPerf$4(r9, r13, r14, r10, r11, r12, null), r15);
    }
}
