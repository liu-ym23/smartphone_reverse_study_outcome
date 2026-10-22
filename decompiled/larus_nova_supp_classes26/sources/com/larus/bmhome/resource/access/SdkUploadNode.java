package com.larus.bmhome.resource.access;

import com.larus.bmhome.rc.FlowResourceScene;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.upload.ResourceUploader;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.platform.model.upload.ResourceUploadInstantInfo;
import com.larus.platform.model.upload.UploadDataType;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class SdkUploadNode implements l0 {
    public static final CoroutineScope d = null;
    public final ResourcePhase a;
    public final List<String> b;
    public final boolean c;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/larus/bmhome/resource/access/SdkUploadNode$ResourceAccessErrorException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "error", "Lcom/larus/bmhome/resource/access/ResourceAccessError;", "<init>", "(Lcom/larus/bmhome/resource/access/ResourceAccessError;)V", "getError", "()Lcom/larus/bmhome/resource/access/ResourceAccessError;", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ResourceAccessErrorException extends RuntimeException {
        private final r error;

        public final r getError() {
            return this.error;
        }

        public ResourceAccessErrorException(r r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            super(r2.c);
            this.error = r2;
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ResourceMediaType.values().length];
            r0[ResourceMediaType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ResourceMediaType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ResourceMediaType.FILE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class c implements Function1<Throwable, Unit> {
        public final /* synthetic */ AtomicBoolean a;
        public final /* synthetic */ String b;

        public c(AtomicBoolean r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object invoke(Object r3) {
            Throwable r4 = (Throwable) r3;
            this.a.compareAndSet(false, true);
            FLogger.a.i("SdkUploadNode", "[awaitUpload] cancelled, fileIdentifier=" + this.b);
            ResourceUploader r5 = ResourceUploader.a;
            ResourceUploader.c(this.b);
            return Unit.INSTANCE;
        }
    }

    public static final class d implements Function1<mr9.l, Unit> {
        public final /* synthetic */ kotlinx.coroutines.i<f0> a;
        public final /* synthetic */ AtomicBoolean b;
        public final /* synthetic */ w c;
        public final /* synthetic */ j0 d;
        public final /* synthetic */ SdkUploadNode e;

        public d(kotlinx.coroutines.j r1, AtomicBoolean r2, w r3, j0 r4, SdkUploadNode r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final Object invoke(Object r11) {
            mr9.l r5 = (mr9.l) r11;
            Intrinsics.checkNotNullParameter(r5, "result");
            kotlinx.coroutines.i<f0> r12 = this.a;
            AtomicBoolean r0 = this.b;
            w r1 = this.c;
            j0 r2 = this.d;
            SdkUploadNode r3 = this.e;
            if (r12.isActive() == false) goto L18;
            boolean r4 = false;
            if (r0.compareAndSet(false, true) == false) goto L18;
            Result.Companion r6 = Result.Companion;
            ResourceMediaType r7 = r1.c;
            String r8 = r5.a;
            String r9 = r5.c;
            r3.getClass();
            if (r5.f == true) goto L15;
            ResourceUploadInstantInfo r10 = r5.g;
            if (r10 == null) goto L12;
            r4 = Intrinsics.areEqual(r10.getPreQueryHit(), Boolean.TRUE);
        L12:
            if (r4 == true) goto L15;
            String r13 = "sdk_upload";
        L16:
            r12.resumeWith(Result.constructor-impl(new f0(r7, r2, r8, r9, r5, MapsKt.mapOf(TuplesKt.to("sdk_route", r13)))));
        L15:
            r13 = "instant_upload";
        L18:
            return Unit.INSTANCE;
        }
    }

    public static final class e implements Function1<mr9.k, Unit> {
        public final /* synthetic */ h0 a;

        public e(h0 r1) {
            this.a = r1;
        }

        public final Object invoke(Object r5) {
            mr9.k r6 = (mr9.k) r5;
            Intrinsics.checkNotNullParameter(r6, "progress");
            c0 r0 = this.a.b;
            Long r7 = r6.a;
            if (r7 == null) goto L5;
            long r2 = r7.longValue();
        L6:
            r0.update(new a0.f(r2));
            return Unit.INSTANCE;
        L5:
            r2 = 0;
            goto L6
        }
    }

    public static final class f implements Function1<ResourceUploadError, Unit> {
        public final /* synthetic */ kotlinx.coroutines.i<f0> a;
        public final /* synthetic */ AtomicBoolean b;
        public final /* synthetic */ SdkUploadNode c;

        public f(kotlinx.coroutines.j r1, AtomicBoolean r2, SdkUploadNode r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final Object invoke(Object r7) {
            ResourceUploadError r8 = (ResourceUploadError) r7;
            Intrinsics.checkNotNullParameter(r8, "error");
            kotlinx.coroutines.i<f0> r0 = this.a;
            AtomicBoolean r1 = this.b;
            SdkUploadNode r2 = this.c;
            if (r0.isActive() == false) goto L9;
            if (r1.compareAndSet(false, true) == false) goto L9;
            Result.Companion r3 = Result.Companion;
            r2.getClass();
            StateFlowImpl r4 = s.a;
            Intrinsics.checkNotNullParameter(r8, "<this>");
            Intrinsics.checkNotNullParameter("sdk_upload", "stage");
            r0.resumeWith(Result.constructor-impl(ResultKt.createFailure(new ResourceAccessErrorException(new r("sdk_upload", r8.getCode(), r8.getMsg(), r8)))));
        L9:
            return Unit.INSTANCE;
        }
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final String getKey() {
        return "sdk_upload";
    }

    static {
        d = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    public SdkUploadNode() {
        this.a = ResourcePhase.UPLOAD;
        this.b = CollectionsKt.listOf("preprocess");
        this.c = true;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final ResourcePhase d() {
        return this.a;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final List<String> f() {
        return this.b;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final ResourceNodeCompletionMode g() {
        return ResourceNodeCompletionMode.BLOCKING;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final boolean h() {
        return this.c;
    }

    public static String b(j0 r1) {
        if ((r1 instanceof j0.b) == false) goto L6;
        return ((j0.b) r1).b;
    L6:
        if ((r1 instanceof j0.a) == false) goto L9;
        return ((j0.a) r1).b;
    L9:
        if ((r1 instanceof j0.c) == false) goto L11;
    L15:
        return null;
    L11:
        if ((r1 instanceof j0.d) == true) goto L15;
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final boolean e(h0 r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        if (SetsKt.setOf(new ResourceMediaType[]{ResourceMediaType.IMAGE, ResourceMediaType.VIDEO, ResourceMediaType.FILE}).contains(r6.a.c) == false) goto L14;
        String r7 = b(r6.c);
        if (r7 != null) goto L7;
    L10:
        boolean r8 = true;
    L11:
        if (r8 == true) goto L15;
        return true;
    L15:
        return false;
    L7:
        if (r7.length() == 0) goto L10;
        r8 = false;
        goto L11
    L14:
        return false;
    }

    public final Object a(h0 r36, Continuation<? super f0> r37) {
        kotlinx.coroutines.j r8 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r37), 1);
        r8.C();
        w r9 = r36.a;
        j0 r10 = r36.c;
        String r15 = r9.d.a;
        String r12 = b(r10);
        if (r12 != null) goto L5;
    L8:
        boolean r0 = true;
    L10:
        if (r0 == false) goto L110;
        Result.Companion r1 = Result.Companion;
        r8.resumeWith(Result.constructor-impl(ResultKt.createFailure(new ResourceAccessErrorException(new r("sdk_upload", "unsupported_source", "resourceInput " + r10.getType() + " cannot upload by local sdk", null)))));
        kotlinx.coroutines.j r7 = r8;
    L106:
        Object r2 = r7.B();
        if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L109;
        DebugProbesKt.probeCoroutineSuspended(r37);
    L109:
        return r2;
    L110:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L27
        Set r4 = ServiceManager.get().getServices(ResourceUploadSceneResolver.class, true);     // Catch: Throwable -> L27
        if (r4 != null) goto L15;
        r4 = SetsKt.emptySet();     // Catch: Throwable -> L27
    L15:
        ArrayList r5 = new ArrayList();     // Catch: Throwable -> L27
        Iterator r6 = r4.iterator();     // Catch: Throwable -> L27
    L17:
        if (r6.hasNext() == false) goto L21;
        Object r11 = r6.next();     // Catch: Throwable -> L27
        if (((ResourceUploadSceneResolver) r11).b(r36) == false) goto L17;
        r5.add(r11);     // Catch: Throwable -> L27
        goto L17
    L21:
        ResourceUploadSceneResolver r13 = (ResourceUploadSceneResolver) CollectionsKt.maxWithOrNull(r5, new b1(new a1()));     // Catch: Throwable -> L27
        if (r13 == null) goto L24;
        FlowResourceScene r14 = r13.a(r36);     // Catch: Throwable -> L27
    L25:
        Object r16 = Result.constructor-impl(r14);     // Catch: Throwable -> L27
    L29:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L33;
        FLogger.a.e("SdkUploadNode", "[resolveFlowResourceScene] failed, scene=" + r36.a.a, r17);
    L33:
        if (Result.isFailure-impl(r16) == false) goto L35;
        r16 = null;
    L35:
        FlowResourceScene r18 = (FlowResourceScene) r16;
        if (r18 == null) goto L38;
        ResourceCenter.a.getClass();
        ResourceCenter.k(r15, r18);
    L38:
        AtomicBoolean r19 = new AtomicBoolean(false);
        String r110 = r9.d.b;
        int r20 = b.a[r9.c.ordinal()];
        if (r20 != 1) goto L41;
        UploadDataType r21 = UploadDataType.IMAGE;
    L49:
        UploadDataType r111 = r21;
        d r112 = new d(r8, r19, r9, r10, this);
        e r22 = new e(r36);
        f r23 = new f(r8, r19, this);
        boolean r24 = r10 instanceof j0.a;
        String r25 = r36.g;
        g0 r26 = r9.d;
        boolean r27 = r26.f;
        CountDownLatch r28 = r26.g;
        mr9.h r29 = r36.f;
        boolean r113 = r10 instanceof j0.b;
        if (r113 == false) goto L52;
        String r114 = r15;
        String r115 = ((j0.b) r10).c;
    L55:
        String r210 = r115;
    L64:
        if (r113 == false) goto L66;
        Boolean r116 = ((j0.b) r10).d;
    L68:
        Boolean r211 = r116;
    L77:
        if (r113 == false) goto L79;
        mr9.c r117 = ((j0.b) r10).f;
    L88:
        if (r117 != null) goto L90;
        r117 = r36.d;
    L90:
        mr9.c r212 = r117;
        String r30 = r9.d.d;
        if (r113 == false) goto L93;
        Long r118 = ((j0.b) r10).e;
    L102:
        if (r118 != null) goto L104;
        Long r31 = r36.e;
    L105:
        String r32 = r114;
        mr9.j r33 = new mr9.j(r12, r110, r111, r112, r22, r23, r24, null, null, r25, r32, r27, r28, r29, r210, r211, r212, r30, r31, null, 1049472);
        r7 = r8;
        r7.i(new c(r19, r32));
        BuildersKt.launch$default(d, null, null, new SdkUploadNode$awaitUpload$2$3(r7, r19, r33, this, null), 3, null);
        goto L106
    L104:
        r31 = r118;
        goto L105
    L93:
        if (r24 == false) goto L95;
    L101:
        r118 = null;
        goto L102
    L95:
        if ((r10 instanceof j0.c) == true) goto L101;
        if ((r10 instanceof j0.d) == true) goto L101;
        throw new NoWhenBranchMatchedException();
    L79:
        if (r24 == false) goto L81;
    L87:
        r117 = null;
        goto L88
    L81:
        if ((r10 instanceof j0.c) == true) goto L87;
        if ((r10 instanceof j0.d) == true) goto L87;
        throw new NoWhenBranchMatchedException();
    L66:
        if (r24 == false) goto L70;
        r116 = Boolean.TRUE;
        goto L68
    L70:
        if ((r10 instanceof j0.c) == false) goto L72;
    L76:
        r211 = null;
        goto L77
    L72:
        if ((r10 instanceof j0.d) == true) goto L76;
        throw new NoWhenBranchMatchedException();
    L52:
        r114 = r15;
        if (r24 == false) goto L57;
        r115 = ((j0.a) r10).b;
        goto L55
    L57:
        if ((r10 instanceof j0.c) == false) goto L59;
    L63:
        r210 = null;
        goto L64
    L59:
        if ((r10 instanceof j0.d) == true) goto L63;
        throw new NoWhenBranchMatchedException();
    L41:
        if (r20 != 2) goto L43;
        r21 = UploadDataType.VIDEO;
        goto L49
    L43:
        if (r20 != 3) goto L46;
        r21 = UploadDataType.FILE;
        goto L49
    L46:
        throw new NoWhenBranchMatchedException();
    L24:
        r14 = null;
    L27:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    L5:
        if (r12.length() == 0) goto L8;
        r0 = false;
        goto L10
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final Object c(h0 r5, Continuation<? super g> r6) {
        if ((r6 instanceof SdkUploadNode$execute$1) == false) goto L7;
        SdkUploadNode$execute$1 r0 = (SdkUploadNode$execute$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L19;
        if (r3 != 1) goto L18;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L13 ResourceAccessErrorException -> L15
    L23:
    L34:
        return new g.d((f0) r7);
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ResultKt.throwOnFailure(r7);
        r0.label = 1;     // Catch: Throwable -> L13 ResourceAccessErrorException -> L15
        r7 = a(r5, r0);     // Catch: Throwable -> L13 ResourceAccessErrorException -> L15
        if (r7 != r2) goto L23;
        return r2;
    L15:
        e = move-exception;
        g.b r8 = new g.b(e.getError());
    L31:
        return r8;
    L13:
        th = move-exception;
        String r4 = th.getMessage();
        if (r4 != null) goto L28;
        r4 = "";
    L28:
        r8 = new g.b(new r("sdk_upload", "upload_exception", r4, th));
    L7:
        r0 = new SdkUploadNode$execute$1(this, r6);
        goto L8
    }
}
