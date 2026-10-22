package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import android.net.Uri;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.resource.access.ResourceCancelReason;
import com.larus.bmhome.resource.access.ResourceInputType;
import com.larus.bmhome.resource.access.ResourceMediaType;
import com.larus.platform.model.album.AlbumSelectionMediaType;
import com.larus.uaigc.helper.CreationResourceAccessUploader;
import com.larus.uaigc.service.ICreationResourceAccessService;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class CreationAlbumPipelinePrewarmer {
    public static final /* synthetic */ int g = 0;
    public final Function3<kq9.d, String, Continuation<? super com.larus.bmhome.resource.access.b0>, Object> a;
    public final CoroutineScope b;
    public final Object c;
    public String d;
    public final Map<String, b> e;
    public final Map<String, b> f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/uaigc/createpage/component/mediaselector/imageselector/CreationAlbumPipelinePrewarmer$TaskOwner;", "", "<init>", "(Ljava/lang/String;I)V", "ALBUM_SELECTION", "ATTACHMENT", "SEND", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final enum TaskOwner extends Enum<TaskOwner> {
        public static final TaskOwner ALBUM_SELECTION = null;
        public static final TaskOwner ATTACHMENT = null;
        public static final TaskOwner SEND = null;
        public static final /* synthetic */ TaskOwner[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<TaskOwner> getEntries() {
            return b;
        }

        static {
            TaskOwner r0 = new TaskOwner("ALBUM_SELECTION", 0);
            ALBUM_SELECTION = r0;
            TaskOwner r1 = new TaskOwner("ATTACHMENT", 1);
            ATTACHMENT = r1;
            TaskOwner r3 = new TaskOwner("SEND", 2);
            SEND = r3;
            TaskOwner[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static TaskOwner[] values() {
            return (TaskOwner[]) a.clone();
        }

        public static TaskOwner valueOf(String r1) {
            return (TaskOwner) r27.a.a(TaskOwner.class, r1);
        }

        public TaskOwner(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final AlbumSelectionMediaType b;
        public final Deferred<com.larus.bmhome.resource.access.b0> c;
        public boolean d;
        public TaskOwner e;
        public Job f;

        public b() {
            throw null;
        }

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
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
            if (this.d == false) goto L5;
            int r1 = 1231;
        L6:
            int r2 = (((r0 + r1) * 31) + this.e.hashCode()) * 31;
            Job r3 = this.f;
            if (r3 != null) goto L9;
            int r4 = 0;
        L11:
            return r2 + r4;
        L9:
            r4 = r3.hashCode();
            goto L11
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "Entry(identifier=" + this.a + ", mediaType=" + this.b + ", task=" + this.c + ", selected=" + this.d + ", owner=" + this.e + ", cancelJob=" + this.f + ')';
        }

        public final String getIdentifier() {
            return this.a;
        }

        public b(String r3, AlbumSelectionMediaType r4, Deferred r5) {
            TaskOwner r0 = TaskOwner.ALBUM_SELECTION;
            Intrinsics.checkNotNullParameter(r3, "identifier");
            Intrinsics.checkNotNullParameter(r4, "mediaType");
            Intrinsics.checkNotNullParameter(r5, "task");
            Intrinsics.checkNotNullParameter(r0, "owner");
            this.a = r3;
            this.b = r4;
            this.c = r5;
            this.d = true;
            this.e = r0;
            this.f = null;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AlbumSelectionMediaType.values().length];
            r0[AlbumSelectionMediaType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[AlbumSelectionMediaType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CreationAlbumPipelinePrewarmer(Function3<? super kq9.d, ? super String, ? super Continuation<? super com.larus.bmhome.resource.access.b0>, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "submitTask");
        this.a = r2;
        this.b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        this.c = new Object();
        this.e = new LinkedHashMap();
        this.f = new LinkedHashMap();
    }

    public final void a(ResourceCancelReason r5) {
        Object r0 = this.c;
        monitor-enter(r0);
        String r1 = this.d;     // Catch: Throwable -> L12
        this.d = null;     // Catch: Throwable -> L12
        List<b> r2 = CollectionsKt.toList(((LinkedHashMap) this.e).values());     // Catch: Throwable -> L12
        ((LinkedHashMap) this.e).clear();     // Catch: Throwable -> L12
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r0);
        if (r1 == null) goto L10;
        ConcurrentHashMap<String, Function2<kq9.d, Boolean, Unit>> r4 = kq9.c.a;
        Intrinsics.checkNotNullParameter(r1, "sessionId");
        if ((!StringsKt.isBlank(r1)) == false) goto L10;
        kq9.c.a.remove(r1);
    L10:
        b(r2, r5);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final void b(List<b> r17, ResourceCancelReason r18) {
        Iterator<T> r0 = r17.iterator();
    L4:
        if (r0.hasNext() == false) goto L39;
        b r1 = (b) r0.next();
        Job r2 = r1.f;
        boolean r3 = true;
        if (r2 == null) goto L8;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L8:
        Job.DefaultImpls.cancel$default(r1.c, null, 1, null);
        ICreationResourceAccessService.Companion r4 = ICreationResourceAccessService.a;
        com.larus.bmhome.resource.access.z r5 = ICreationResourceAccessService.a.c(r4, r1.getIdentifier(), null, null, 14);
        if (r5 == null) goto L15;
        com.larus.bmhome.resource.access.a0 r8 = r5.c;
        if (r8 == null) goto L15;
        if (com.larus.bmhome.resource.access.s.b(r8) == true) goto L15;
        boolean r9 = true;
    L16:
        if (r9 == false) goto L18;
        boolean r10 = r4.a(r1.getIdentifier(), r18);
    L19:
        com.larus.bmhome.resource.access.z r6 = ICreationResourceAccessService.a.c(r4, r1.getIdentifier(), null, null, 14);
        if (r6 != null) goto L22;
        com.larus.bmhome.resource.access.z r12 = r5;
    L23:
        if (r10 == false) goto L26;
        String r7 = "cancelled";
    L25:
        String r14 = r7;
        d(r1.getIdentifier(), r1.b, r12, "cancel", r14, null);
        ResourceCenter r11 = ResourceCenter.a;
        String r13 = r1.getIdentifier();
        r11.getClass();
        ResourceCenter.a(r13);
        goto L4
    L26:
        if (r12 == null) goto L32;
        com.larus.bmhome.resource.access.a0 r15 = r12.c;
        if (r15 == null) goto L32;
        if (com.larus.bmhome.resource.access.s.b(r15) != true) goto L32;
    L33:
        if (r3 == false) goto L35;
        r7 = "terminal_kept";
        goto L25
    L35:
        if (r12 != null) goto L37;
        r7 = "no_task";
        goto L25
    L37:
        r7 = "cancel_skipped";
    L32:
        r3 = false;
        goto L33
    L22:
        r12 = r6;
        goto L23
    L18:
        r10 = false;
    L15:
        r9 = false;
        goto L16
    }

    public final String c(Uri r6, AlbumSelectionMediaType r7) {
        Intrinsics.checkNotNullParameter(r6, "uri");
        Intrinsics.checkNotNullParameter(r7, "fallbackMediaType");
        String r8 = r6.toString();
        Object r0 = this.c;
        monitor-enter(r0);
        String r2 = null;
        if (this.d == null) goto L17;
        b r1 = this.e.remove(r8);     // Catch: Throwable -> L19
        if (r1 != null) goto L11;
        r1 = new b(UUID.randomUUID().toString(), r7, CompletableDeferredKt.CompletableDeferred(null));     // Catch: Throwable -> L19
    L11:
        if (r1.d == true) goto L13;
        this.e.put(r8, r1);     // Catch: Throwable -> L19
        goto L17
    L13:
        TaskOwner r9 = TaskOwner.ATTACHMENT;     // Catch: Throwable -> L19
        Intrinsics.checkNotNullParameter(r9, "<set-?>");     // Catch: Throwable -> L19
        r1.e = r9;     // Catch: Throwable -> L19
        Job r10 = r1.f;     // Catch: Throwable -> L19
        if (r10 == null) goto L16;
        Job.DefaultImpls.cancel$default(r10, null, 1, null);     // Catch: Throwable -> L19
    L16:
        r1.f = null;     // Catch: Throwable -> L19
        this.f.put(r1.getIdentifier(), r1);     // Catch: Throwable -> L19
        r2 = r1.getIdentifier();     // Catch: Throwable -> L19
    L17:
        monitor-exit(r0);
        return r2;
    L19:
        th = move-exception;
        throw th;
    }

    public final Object e(String r12, Continuation<? super com.larus.bmhome.resource.access.b0> r13) {
        if ((r13 instanceof CreationAlbumPipelinePrewarmer$takeClaimedTask$1) == false) goto L7;
        CreationAlbumPipelinePrewarmer$takeClaimedTask$1 r0 = (CreationAlbumPipelinePrewarmer$takeClaimedTask$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        b r15 = (b) r0.L$1;
        String r5 = (String) r0.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: CancellationException -> L14 Throwable -> L119
    L28:
        com.larus.bmhome.resource.access.b0 r16 = (com.larus.bmhome.resource.access.b0) r14;     // Catch: CancellationException -> L14 Throwable -> L119
    L32:
        Object r6 = this.c;
        monitor-enter(r6);
    L112:
        th = move-exception;
        throw th;
    L35:
        if (((LinkedHashMap) this.f).get(r5) != r15) goto L37;
        this.f.remove(r5);     // Catch: Throwable -> L112
    L37:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L112
        monitor-exit(r6);
        if (r16 != null) goto L42;
        r16 = ICreationResourceAccessService.a.b(ICreationResourceAccessService.a, r5, null, null, 14);
    L42:
        if (r16 == null) goto L47;
        com.larus.bmhome.resource.access.z r8 = r16.snapshot();
        if (r8 == null) goto L47;
        com.larus.bmhome.resource.access.z r9 = r8;
    L48:
        if (r9 == null) goto L50;
        com.larus.bmhome.resource.access.a0 r10 = r9.c;
    L52:
        if ((r10 instanceof com.larus.bmhome.resource.access.a0.d) == true) goto L54;
    L58:
        r4 = false;
    L59:
        if (r4 == false) goto L61;
        d(r5, r15.b, r9, "expire", "expired", null);
    L61:
        if (r4 == false) goto L63;
        String r11 = "miss";
    L99:
        AlbumSelectionMediaType r17 = r15.b;
        if (Intrinsics.areEqual(r11, "ready") == false) goto L102;
    L105:
        String r18 = "reuse";
    L106:
        d(r5, r17, r9, "claim", r18, r11);
        if (Intrinsics.areEqual(r11, "ready") == true) goto L111;
        if (Intrinsics.areEqual(r11, "running") == true) goto L111;
        return null;
    L111:
        return r16;
    L102:
        if (Intrinsics.areEqual(r11, "running") == true) goto L105;
        r18 = "fallback";
        goto L106
    L63:
        if (r9 == null) goto L65;
        com.larus.bmhome.resource.access.a0 r19 = r9.c;
    L67:
        if ((r19 instanceof com.larus.bmhome.resource.access.a0.d) == false) goto L69;
        r11 = "ready";
        goto L99
    L69:
        if (r9 == null) goto L71;
        com.larus.bmhome.resource.access.a0 r20 = r9.c;
    L73:
        if ((r20 instanceof com.larus.bmhome.resource.access.a0.b) == true) goto L98;
        if (r9 == null) goto L76;
        com.larus.bmhome.resource.access.a0 r21 = r9.c;
    L78:
        if ((r21 instanceof com.larus.bmhome.resource.access.a0.e) == true) goto L98;
        if (r9 == null) goto L81;
        com.larus.bmhome.resource.access.a0 r22 = r9.c;
    L83:
        if ((r22 instanceof com.larus.bmhome.resource.access.a0.f) == true) goto L98;
        if (r9 == null) goto L87;
        com.larus.bmhome.resource.access.a0 r23 = r9.c;
    L89:
        if ((r23 instanceof com.larus.bmhome.resource.access.a0.c) == true) goto L97;
        if (r9 == null) goto L92;
        com.larus.bmhome.resource.access.a0 r24 = r9.c;
    L94:
        if ((r24 instanceof com.larus.bmhome.resource.access.a0.a) == true) goto L97;
        r11 = "miss";
        goto L99
    L92:
        r24 = null;
    L97:
        r11 = "failed";
        goto L99
    L87:
        r23 = null;
        goto L89
    L81:
        r22 = null;
        goto L83
    L76:
        r21 = null;
    L98:
        r11 = "running";
        goto L99
    L71:
        r20 = null;
        goto L73
    L65:
        r19 = null;
        goto L67
    L54:
        if (r9.f <= 0) goto L58;
        if ((System.currentTimeMillis() - r9.f) <= 600000) goto L58;
    L50:
        r10 = null;
    L47:
        r9 = ICreationResourceAccessService.a.c(ICreationResourceAccessService.a, r5, null, null, 14);
        goto L48
    L31:
        r16 = null;
        goto L32
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r14);
        Object r110 = this.c;
        monitor-enter(r110);
        b r25 = (b) ((LinkedHashMap) this.f).get(r12);     // Catch: Throwable -> L116
        monitor-exit(r110);
        if (r25 != null) goto L122;
        return null;
    L122:
        Deferred<com.larus.bmhome.resource.access.b0> r111 = r25.c;     // Catch: CancellationException -> L14 Throwable -> L30
        r0.L$0 = r12;     // Catch: CancellationException -> L14 Throwable -> L30
        r0.L$1 = r25;     // Catch: CancellationException -> L14 Throwable -> L30
        r0.label = 1;     // Catch: CancellationException -> L14 Throwable -> L30
        r14 = r111.await(r0);     // Catch: CancellationException -> L14 Throwable -> L30
        if (r14 != r2) goto L27;
        return r2;
    L27:
        r5 = r12;
        r15 = r25;
    L30:
        r5 = r12;
        r15 = r25;
    L116:
        th = move-exception;
        throw th;
    L14:
        e = move-exception;
        throw e;
    L7:
        r0 = new CreationAlbumPipelinePrewarmer$takeClaimedTask$1(this, r13);
        goto L8
    }

    public static void d(String r30, AlbumSelectionMediaType r31, com.larus.bmhome.resource.access.z r32, String r33, String r34, String r35) {
        CreationResourceAccessUploader r3 = CreationResourceAccessUploader.a;
        int r4 = c.a[r31.ordinal()];
        boolean r5 = true;
        if (r4 == 1) goto L8;
        if (r4 != 2) goto L7;
        ResourceMediaType r6 = ResourceMediaType.VIDEO;
    L9:
        Intrinsics.checkNotNullParameter(r30, "fileIdentifier");
        Intrinsics.checkNotNullParameter(r6, "mediaType");
        Intrinsics.checkNotNullParameter(r33, "action");
        Intrinsics.checkNotNullParameter(r34, "result");
        if (r32 == null) goto L12;
        com.larus.bmhome.resource.access.w r7 = r32.d;
    L13:
        Map r1 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("trigger", "album_select_prewarm"), TuplesKt.to("prewarm_action", r33)});
        if (r35 == null) goto L16;
        r1.put("state_at_confirm", r35);
    L16:
        int[] r8 = CreationResourceAccessUploader.b.a;
        int r9 = r8[r6.ordinal()];
        if (r9 == 1) goto L24;
        if (r9 == 2) goto L23;
        if (r9 != 3) goto L22;
        com.larus.bmhome.resource.access.x r10 = com.larus.bmhome.resource.access.x.b;
    L25:
        int r11 = r8[r6.ordinal()];
        if (r11 == 1) goto L33;
        if (r11 == 2) goto L32;
        if (r11 == 3) goto L32;
        throw new NoWhenBranchMatchedException();
    L32:
        ResourceInputType r12 = ResourceInputType.LOCAL_PATH;
    L34:
        com.larus.bmhome.resource.access.y r13 = com.larus.bmhome.resource.access.y.a;
        if (r32 == null) goto L37;
        String r0 = r32.a;
    L38:
        if (r0 != null) goto L40;
        r0 = "";
    L40:
        String r14 = r0;
        if (r7 == null) goto L46;
        com.larus.bmhome.resource.access.x r2 = r7.a;
        if (r2 == null) goto L46;
        r10 = r2;
    L46:
        if (r7 == null) goto L51;
        com.larus.bmhome.resource.access.j0 r15 = r7.b;
        if (r15 == null) goto L51;
        ResourceInputType r16 = r15.getType();
        if (r16 == null) goto L51;
    L52:
        if (r7 == null) goto L57;
        ResourceMediaType r17 = r7.c;
        if (r17 == null) goto L57;
        ResourceMediaType r18 = r17;
    L59:
        if (r35 != null) goto L61;
        Boolean r25 = null;
    L68:
        com.larus.bmhome.resource.access.t r19 = new com.larus.bmhome.resource.access.t(r14, r10, r16, r18, r30, "album_prewarm", "selection_lifecycle", 0, r34, null, null, null, null, null, null, null, r25, null, null, r1, 458240);
        Intrinsics.checkNotNullParameter(r19, "event");
        com.larus.bmhome.resource.access.u.a.getClass();
        com.larus.bmhome.resource.access.u.b(r19);
        return;
    L61:
        if (Intrinsics.areEqual(r35, "ready") == false) goto L63;
    L66:
        r25 = Boolean.valueOf(r5);
        goto L68
    L63:
        if (Intrinsics.areEqual(r35, "running") == true) goto L66;
        r5 = false;
    L57:
        r18 = r6;
    L51:
        r16 = r12;
        goto L52
    L37:
        r0 = null;
        goto L38
    L33:
        r12 = ResourceInputType.CONTENT_URI;
        goto L34
    L22:
        throw new NoWhenBranchMatchedException();
    L23:
        r10 = com.larus.uaigc.service.f.a;
        goto L25
    L24:
        r10 = com.larus.uaigc.service.f.c;
        goto L25
    L12:
        r7 = null;
        goto L13
    L7:
        throw new NoWhenBranchMatchedException();
    L8:
        r6 = ResourceMediaType.IMAGE;
        goto L9
    }
}
