package com.obric.aikernel.service;

import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.service.res.PythonRuntimeService;
import com.obric.aikernel.service.session.ClientSessionService;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.h;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class ServiceFactoryImpl implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<Integer, b> f5437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, Integer> f5438c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
    }

    public ServiceFactoryImpl() {
        AppContext r10 = AppContext.INSTANCE;
        if (r10.testStubApp() == false) goto L5;
        Map<Integer, b> r11 = MapsKt.emptyMap();
    L6:
        this.f5437b = r11;
        Collection<b> r12 = r11.values();
        LinkedHashMap r13 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r12, 10)), 16));
        Iterator<T> r14 = r12.iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        b r15 = (b) r14.next();
        Pair r16 = new Pair(r15.name(), Integer.valueOf(r15.b()));
        r13.put(r16.getFirst(), r16.getSecond());
        goto L8
    L10:
        this.f5438c = r13;
        return;
    L5:
        PythonRuntimeService r17 = new PythonRuntimeService(r10.getContext());
        ClientSessionService r18 = new ClientSessionService();
        r11 = MapsKt.mapOf(new Pair[]{new Pair(Integer.valueOf(r17.b()), r17), new Pair(Integer.valueOf(r18.b()), r18)});
        goto L6
    }

    @Override // com.obric.aikernel.service.c
    public boolean a(RequestParams r10) {
        Intrinsics.checkNotNullParameter(r10, "requestParams");
        b r11 = this.f5437b.get(Integer.valueOf(r10.getTargetComponent()));
        if (r11 != null) goto L6;
        return false;
    L6:
        h.d(m0.a(z0.b()), null, null, new ServiceFactoryImpl$handleEvent$1(r11, r10, null), 3, null);
        return true;
    }

    @Override // com.obric.aikernel.service.c
    public void b(FileDescriptor r10, PrintWriter r11, String[] r12) {
        Intrinsics.checkNotNullParameter(r10, "fd");
        Intrinsics.checkNotNullParameter(r11, "fout");
        String r13 = null;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L23
        Map<Integer, b> r15 = this.f5437b;     // Catch: Throwable -> L23
        Map<String, Integer> r16 = this.f5438c;     // Catch: Throwable -> L23
        if (r12 == null) goto L6;
        String r17 = (String) ArraysKt.firstOrNull(r12);     // Catch: Throwable -> L23
    L7:
        b r18 = r15.get(r16.get(r17));     // Catch: Throwable -> L23
        if (r18 == null) goto L14;
        if (r12 == null) goto L12;
        List<String> r19 = ArraysKt.takeLast(r12, r12.length - 1);     // Catch: Throwable -> L23
        if (r19 == null) goto L12;
    L13:
        r18.c(r10, r11, r19);     // Catch: Throwable -> L23
        Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L23
    L15:
        if (r20 != null) goto L21;
        StringBuilder r21 = new StringBuilder();     // Catch: Throwable -> L23
        r21.append("ServiceFactory ");     // Catch: Throwable -> L23
        if (r12 == null) goto L19;
        String r22 = (String) ArraysKt.firstOrNull(r12);     // Catch: Throwable -> L23
    L20:
        r21.append(r22);     // Catch: Throwable -> L23
        r21.append(" not impl");     // Catch: Throwable -> L23
        r11.println(r21.toString());     // Catch: Throwable -> L23
        goto L21
    L19:
        r22 = null;
    L21:
        Object r23 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L25:
        Throwable r24 = Result.m35exceptionOrNullimpl(r23);
        if (r24 == null) goto L34;
        StringBuilder r25 = new StringBuilder();
        r25.append("ServiceFactory dump ");
        if (r12 == null) goto L30;
        r13 = (String) ArraysKt.firstOrNull(r12);
    L30:
        r25.append(r13);
        r25.append(" failed: ");
        r25.append(ExceptionsKt.stackTraceToString(r24));
        r11.println(r25.toString());
        return;
    L34:
        return;
    L12:
        r19 = CollectionsKt.emptyList();     // Catch: Throwable -> L23
        goto L13
    L14:
        r20 = null;
        goto L15
    L6:
        r17 = null;
    L23:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r23 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L25
    }

    @Override // com.obric.aikernel.service.c
    public ClientSessionService c() {
        b r10 = this.f5437b.get(2);
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.obric.aikernel.service.session.ClientSessionService");
        return (ClientSessionService) r10;
    }

    @Override // com.obric.aikernel.service.c
    public PythonRuntimeService d() {
        b r10 = this.f5437b.get(1);
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.obric.aikernel.service.res.PythonRuntimeService");
        return (PythonRuntimeService) r10;
    }
}
