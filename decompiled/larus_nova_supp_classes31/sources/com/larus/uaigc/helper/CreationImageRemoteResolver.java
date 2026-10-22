package com.larus.uaigc.helper;

import com.larus.bmhome.resource.access.ResourceInputType;
import com.larus.bmhome.resource.access.ResourceMediaType;
import com.larus.bmhome.resource.access.ResourceRemoteResolver;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0002\u0019\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u0010\u0014J\u001c\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001b"}, d2 = {"Lcom/larus/uaigc/helper/CreationImageRemoteResolver;", "Lcom/larus/bmhome/resource/access/ResourceRemoteResolver;", "<init>", "()V", "key", "", "getKey", "()Ljava/lang/String;", "supports", "", "scene", "Lcom/larus/bmhome/resource/access/ResourceAccessScene;", "resourceInputType", "Lcom/larus/bmhome/resource/access/ResourceInputType;", "mediaType", "Lcom/larus/bmhome/resource/access/ResourceMediaType;", "resolve", "Lcom/larus/bmhome/resource/access/NodeResult;", "context", "Lcom/larus/bmhome/resource/access/ResourceContext;", "(Lcom/larus/bmhome/resource/access/ResourceContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "remoteResolveAttributes", "", "state", "Lcom/larus/uaigc/helper/CreationImageRemoteResolver$CreationRemoteResolveState;", "CreationRemoteResolveState", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationImageRemoteResolver implements ResourceRemoteResolver {
    public final String a;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/uaigc/helper/CreationImageRemoteResolver$CreationRemoteResolveState;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "DIRECT", "FALLBACK", "FAILED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final enum CreationRemoteResolveState extends Enum<CreationRemoteResolveState> {
        public static final CreationRemoteResolveState DIRECT = null;
        public static final CreationRemoteResolveState FAILED = null;
        public static final CreationRemoteResolveState FALLBACK = null;
        public static final /* synthetic */ CreationRemoteResolveState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String value;

        public static EnumEntries<CreationRemoteResolveState> getEntries() {
            return b;
        }

        static {
            CreationRemoteResolveState r0 = new CreationRemoteResolveState("DIRECT", 0, "direct");
            DIRECT = r0;
            CreationRemoteResolveState r1 = new CreationRemoteResolveState("FALLBACK", 1, "fallback");
            FALLBACK = r1;
            CreationRemoteResolveState r2 = new CreationRemoteResolveState("FAILED", 2, "failed");
            FAILED = r2;
            CreationRemoteResolveState[] r4 = {r0, r1, r2};
            a = r4;
            b = EnumEntriesKt.enumEntries(r4);
        }

        public static CreationRemoteResolveState[] values() {
            return (CreationRemoteResolveState[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static CreationRemoteResolveState valueOf(String r1) {
            return (CreationRemoteResolveState) r27.a.a(CreationRemoteResolveState.class, r1);
        }

        public CreationRemoteResolveState(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a {
    }

    static {
    }

    public CreationImageRemoteResolver() {
        this.a = "creation_image_remote_resolver";
    }

    public final String getKey() {
        return this.a;
    }

    public final Object a(com.larus.bmhome.resource.access.h0 r27, Continuation<? super com.larus.bmhome.resource.access.g> r28) {
        com.larus.bmhome.resource.access.h0 r0 = r27;
        if ((r28 instanceof CreationImageRemoteResolver$resolve$1) == false) goto L7;
        CreationImageRemoteResolver$resolve$1 r4 = (CreationImageRemoteResolver$resolve$1) r28;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        Object r2 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        if (r7 == 0) goto L18;
        if (r7 != 1) goto L17;
        CreationImageRemoteResolver r1 = (CreationImageRemoteResolver) r4.L$2;
        com.larus.bmhome.resource.access.j0.c r8 = (com.larus.bmhome.resource.access.j0.c) r4.L$1;
        com.larus.bmhome.resource.access.h0 r9 = (com.larus.bmhome.resource.access.h0) r4.L$0;
        ResultKt.throwOnFailure(r2);     // Catch: Throwable -> L14
        CreationImageRemoteResolver r3 = r1;
        r0 = r9;
        Object r10 = r2;
    L29:
        com.larus.uaigc.api.s r11 = (com.larus.uaigc.api.s) ((com.larus.network.http.a) r10).b;     // Catch: Throwable -> L14
        if (r11 == null) goto L34;
        List<com.larus.uaigc.api.q> r12 = r11.a();     // Catch: Throwable -> L14
        if (r12 == null) goto L34;
        com.larus.uaigc.api.q r13 = (com.larus.uaigc.api.q) CollectionsKt.firstOrNull(r12);     // Catch: Throwable -> L14
    L35:
        if (r13 == null) goto L37;
        String r14 = r13.c();     // Catch: Throwable -> L14
    L39:
        if (r14 != null) goto L41;
    L44:
        boolean r15 = true;
    L45:
        if (r15 == true) goto L77;
        if (r13 == null) goto L48;
        boolean r16 = Intrinsics.areEqual(r13.a(), Boxing.boxBoolean(true));     // Catch: Throwable -> L14
    L49:
        if (r16 == true) goto L77;
        com.larus.bmhome.resource.access.j0.d r17 = new com.larus.bmhome.resource.access.j0.d(r14);     // Catch: Throwable -> L14
        com.larus.uaigc.api.p r18 = r13.b();     // Catch: Throwable -> L14
        if (r18 == null) goto L56;
        com.larus.uaigc.api.n r19 = r18.a();     // Catch: Throwable -> L14
        if (r19 == null) goto L56;
        com.larus.uaigc.api.m r20 = r19.a();     // Catch: Throwable -> L14
    L57:
        ResourceMediaType r110 = r0.a.c;     // Catch: Throwable -> L14
        Pair[] r111 = new Pair[3];     // Catch: Throwable -> L14
        r111[0] = TuplesKt.to("remote_url", r8.b);     // Catch: Throwable -> L14
        if (r20 == null) goto L63;
        Long r21 = r20.b();     // Catch: Throwable -> L14
        if (r21 == null) goto L63;
        String r22 = r21.toString();     // Catch: Throwable -> L14
    L64:
        String r23 = "";
        if (r22 != null) goto L67;
        r22 = "";
    L67:
        r111[1] = TuplesKt.to("width", r22);     // Catch: Throwable -> L14
        if (r20 == null) goto L72;
        Long r24 = r20.a();     // Catch: Throwable -> L14
        if (r24 == null) goto L72;
        String r25 = r24.toString();     // Catch: Throwable -> L14
    L73:
        if (r25 == null) goto L76;
        r23 = r25;
    L76:
        r111[2] = TuplesKt.to("height", r23);     // Catch: Throwable -> L14
        com.larus.bmhome.resource.access.f0 r26 = new com.larus.bmhome.resource.access.f0(r110, r17, r14, null, null, MapsKt.mapOf(r111), 24);     // Catch: Throwable -> L14
        CreationRemoteResolveState r29 = CreationRemoteResolveState.DIRECT;     // Catch: Throwable -> L14
        r3.getClass();     // Catch: Throwable -> L14
        com.larus.bmhome.resource.access.g.a r112 = new com.larus.bmhome.resource.access.g.a(new com.larus.bmhome.resource.access.i0(r17, null, null, null, null, r26, MapsKt.mapOf(TuplesKt.to("remote_resolve", r29.getValue())), 30));     // Catch: Throwable -> L14
    L82:
        Object r30 = Result.constructor-impl(r112);     // Catch: Throwable -> L14
    L87:
        Throwable r31 = Result.exceptionOrNull-impl(r30);
        if (r31 == null) goto L96;
        FLogger.a.e("CreationImageRemoteResolver", "[resolve] failed, url=" + r8.b, r31);
        return new com.larus.bmhome.resource.access.g.a(new com.larus.bmhome.resource.access.i0(null, null, null, null, null, null, MapsKt.mapOf(TuplesKt.to("remote_resolve", CreationRemoteResolveState.FAILED.getValue())), 63));
    L96:
        return r30;
    L72:
        r25 = null;
    L63:
        r22 = null;
    L56:
        r20 = null;
        goto L57
    L48:
        r16 = false;
    L77:
        FLogger r32 = FLogger.a;     // Catch: Throwable -> L14
        StringBuilder r33 = new StringBuilder("[resolve] fallback, url=");     // Catch: Throwable -> L14
        r33.append(r8.b);     // Catch: Throwable -> L14
        r33.append(", needRePush=");     // Catch: Throwable -> L14
        if (r13 == null) goto L80;
        Boolean r34 = r13.a();     // Catch: Throwable -> L14
    L81:
        r33.append(r34);     // Catch: Throwable -> L14
        r32.i("CreationImageRemoteResolver", r33.toString());     // Catch: Throwable -> L14
        CreationRemoteResolveState r35 = CreationRemoteResolveState.FALLBACK;     // Catch: Throwable -> L14
        r3.getClass();     // Catch: Throwable -> L14
        r112 = new com.larus.bmhome.resource.access.g.a(new com.larus.bmhome.resource.access.i0(null, null, null, null, null, null, MapsKt.mapOf(TuplesKt.to("remote_resolve", r35.getValue())), 63));     // Catch: Throwable -> L14
        goto L82
    L80:
        r34 = null;
        goto L81
    L41:
        if (StringsKt.isBlank(r14) == true) goto L44;
        r15 = false;
        goto L45
    L37:
        r14 = null;
    L34:
        r13 = null;
    L14:
        th = th;
        com.larus.bmhome.resource.access.j0.c r36 = r8;
    L86:
        Result.Companion r37 = Result.Companion;
        r30 = Result.constructor-impl(ResultKt.createFailure(th));
        r8 = r36;
        goto L87
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r2);
        com.larus.bmhome.resource.access.j0.c r38 = r0.c;
        if ((r38 instanceof com.larus.bmhome.resource.access.j0.c) == false) goto L21;
        r36 = r38;
    L22:
        if (r36 == null) goto L24;
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L85
        List r40 = CollectionsKt.listOf(r36.b);     // Catch: Throwable -> L85
        r4.L$0 = r0;     // Catch: Throwable -> L85
        r4.L$1 = r36;     // Catch: Throwable -> L85
        r4.L$2 = this;     // Catch: Throwable -> L85
        r4.label = 1;     // Catch: Throwable -> L85
        r10 = com.larus.uaigc.api.o.a(r40, true, r4);     // Catch: Throwable -> L85
        if (r10 != r6) goto L28;
        return r6;
    L28:
        r8 = r36;
        r3 = this;
    L85:
        th = th;
        goto L86
    L24:
        return com.larus.bmhome.resource.access.g.e.a;
    L21:
        r36 = null;
    L7:
        r4 = new CreationImageRemoteResolver$resolve$1(this, r28);
        goto L8
    }

    public final boolean b(com.larus.bmhome.resource.access.x r5, ResourceInputType r6, ResourceMediaType r7) {
        Intrinsics.checkNotNullParameter(r5, "scene");
        Intrinsics.checkNotNullParameter(r6, "resourceInputType");
        Intrinsics.checkNotNullParameter(r7, "mediaType");
        com.larus.bmhome.resource.access.x r1 = com.larus.uaigc.service.f.a;
        if (SetsKt.setOf(new com.larus.bmhome.resource.access.x[]{com.larus.uaigc.service.f.a, com.larus.uaigc.service.f.b}).contains(r5) == true) goto L5;
        return false;
    L5:
        if (r6 == ResourceInputType.REMOTE_URL) goto L7;
        return false;
    L7:
        if (r7 != ResourceMediaType.IMAGE) goto L12;
        return true;
    L12:
        return false;
    }
}
