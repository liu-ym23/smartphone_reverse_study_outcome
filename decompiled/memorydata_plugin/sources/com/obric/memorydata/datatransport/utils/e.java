package com.obric.memorydata.datatransport.utils;

import android.content.Context;
import android.net.Uri;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crash.entity.EventBody;
import com.obric.capabilitykit.entity.app.AlbumEntity;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.AuditoryRecordingEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.MessageEntity;
import com.obric.capabilitykit.entity.app.NoteEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.capabilitykit.entity.app.PhotoFaceEntity;
import com.obric.capabilitykit.entity.app.RecordingEntity;
import com.obric.capabilitykit.entity.enums.AssetTypeEnum;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.datatransport.manager.ExportFailureReason;
import com.obric.memorydata.datatransport.manager.ExportStatisticsCategory;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 %2\u00020\u0001:\u0002$%B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0086@¢\u0006\u0002\u0010\u0013J\u0012\u0010\u0014\u001a\u00020\u0010*\u00020\u0012H\u0082@¢\u0006\u0002\u0010\u0013J6\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u0007H\u0002J\u0018\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/memorydata/datatransport/utils/EntityFileExporter;", "", "rootDir", "Ljava/io/File;", "onEvent", "Lkotlin/Function1;", "Lcom/obric/memorydata/datatransport/utils/AttachmentExportEvent;", "", "shouldContinue", "Lkotlin/Function0;", "", "<init>", "(Ljava/io/File;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "inputStreamOpener", "Lcom/obric/memorydata/datatransport/utils/AttachmentInputStreamOpener;", "exportEntity", "Lcom/obric/memorydata/datatransport/utils/EntityFileExporter$AttachmentExportResult;", "entity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "(Lcom/obric/capabilitykit/entity/app/AppEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "export", "saveFile", "uri", "Landroid/net/Uri;", "subDirName", "", "fileName", EventBody.KEY_CATEGORY, "Lcom/obric/memorydata/datatransport/manager/ExportStatisticsCategory;", "(Lcom/obric/capabilitykit/entity/app/AppEntity;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Lcom/obric/memorydata/datatransport/manager/ExportStatisticsCategory;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureCanContinue", "copyStream", "input", "Ljava/io/InputStream;", "output", "Ljava/io/OutputStream;", "AttachmentExportResult", "Companion", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f9835a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f9836b;
    private final Function1<com.obric.memorydata.datatransport.utils.a, Unit> c;
    private final Function0<Boolean> d;
    private final c e;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0086\u0002J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/datatransport/utils/EntityFileExporter$AttachmentExportResult;", "", "successCount", "", "failureCount", "<init>", "(II)V", "getSuccessCount", "()I", "getFailureCount", "plus", "other", "component1", "component2", "copy", "equals", "", "hashCode", "toString", "", "Companion", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0474a f9837a = null;
        private static final a d = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f9838b;
        private final int c;

        /* JADX INFO: renamed from: com.obric.memorydata.datatransport.utils.e$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/datatransport/utils/EntityFileExporter$AttachmentExportResult$Companion;", "", "<init>", "()V", "EMPTY", "Lcom/obric/memorydata/datatransport/utils/EntityFileExporter$AttachmentExportResult;", "getEMPTY", "()Lcom/obric/memorydata/datatransport/utils/EntityFileExporter$AttachmentExportResult;", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0474a {
            private C0474a() {
            }

            public /* synthetic */ C0474a(DefaultConstructorMarker r1) {
                this();
            }

            public final a a() {
                return a.c();
            }
        }

        static {
            DefaultConstructorMarker r1 = null;
            f9837a = new C0474a(r1);
            int r2 = 0;
            d = new a(r2, r2, 3, r1);
        }

        public a() {
            int r0 = 0;
            this(r0, r0, 3, null);
        }

        public a(int r1, int r2) {
            this.f9838b = r1;
            this.c = r2;
        }

        public /* synthetic */ a(int r2, int r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 1) == 0) goto L6;
            r2 = 0;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = 0;
        L8:
            this(r2, r3);
        }

        public static final /* synthetic */ a c() {
            return d;
        }

        public final int a() {
            return this.f9838b;
        }

        public final a a(a r4) {
            Intrinsics.checkNotNullParameter(r4, "other");
            return new a(this.f9838b + r4.f9838b, this.c + r4.c);
        }

        public final int b() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (this.f9838b == r6.f9838b) goto L12;
            return false;
        L12:
            if (this.c == r6.c) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Integer.hashCode(this.f9838b) * 31) + Integer.hashCode(this.c);
        }

        public String toString() {
            return "AttachmentExportResult(successCount=" + this.f9838b + ", failureCount=" + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\n\"\u00020\u0001H\u0002¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/datatransport/utils/EntityFileExporter$Companion;", "", "<init>", "()V", "TAG", "", TypedValues.Custom.S_STRING, "resId", "", "args", "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r1) {
            this();
        }

        private final String a(int r3, Object... r4) {
            if (r4.length != 0) goto L5;
            boolean r2 = true;
        L7:
            if (r2 == false) goto L9;
            String r5 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(r3);
        L10:
            Intrinsics.checkNotNull(r5);
            return r5;
        L9:
            r5 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(r3, Arrays.copyOf(r4, r4.length));
            goto L10
        L5:
            r2 = false;
            goto L7
        }

        public static final /* synthetic */ String a(b r0, int r1, Object... r2) {
            return r0.a(r1, r2);
        }
    }

    static {
        f9835a = new b(null);
    }

    public e(File r3, Function1<? super com.obric.memorydata.datatransport.utils.a, Unit> r4, Function0<Boolean> r5) {
        Function1<com.obric.memorydata.datatransport.utils.a, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Function0<Boolean> r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "rootDir");
        Intrinsics.checkNotNullParameter(r6, "onEvent");
        Intrinsics.checkNotNullParameter(r7, "shouldContinue");
        this.f9836b = r3;
        this.c = r6;
        this.d = r7;
        this.e = new c(null, null, 3, null);
    }

    public static final /* synthetic */ File a(e r0) {
        return r0.f9836b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v7, types: [T, com.obric.memorydata.datatransport.manager.ExportFailureReason] */
    private final Object a(AppEntity r18, Uri r19, String r20, String r21, ExportStatisticsCategory r22, Continuation<? super a> r23) {
        e r1 = this;
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r23, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, EntityFileExporter$saveFile$1.class) == false) goto L7;
        EntityFileExporter$saveFile$1 r4 = (EntityFileExporter$saveFile$1) ZeusTransformUtils.preCheckCast(r2, EntityFileExporter$saveFile$1.class, "com.obric.memorydata.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r4.label;
        int r10 = 1;
        if (r6 == 0) goto L18;
        if (r6 != 1) goto L17;
        Ref.ObjectRef r7 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r4.L$3, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        ExportStatisticsCategory r8 = (ExportStatisticsCategory) ZeusTransformUtils.preCheckCast(r4.L$2, ExportStatisticsCategory.class, "com.obric.memorydata.plugin");
        Uri r9 = (Uri) ZeusTransformUtils.preCheckCast(r4.L$1, Uri.class, "com.obric.memorydata.plugin");
        e r11 = (e) ZeusTransformUtils.preCheckCast(r4.L$0, e.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);     // Catch: Throwable -> L14
        Object r0 = r3;
        ExportStatisticsCategory r12 = r8;
        Uri r13 = r9;
        Ref.ObjectRef r14 = r7;
        r1 = r11;
    L24:
        d r15 = (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L38
        if (Intrinsics.areEqual(r15, d.b.f9834a) == false) goto L28;
        a r16 = new a(r10, 0, 2, null);     // Catch: Throwable -> L38
    L35:
        Object r17 = Result.m1421constructorimpl(r16);     // Catch: Throwable -> L38
    L43:
        Throwable r24 = Result.m1424exceptionOrNullimpl(r17);
        if (r24 == null) goto L50;
        if (ZeusTransformUtils.instanceOf(r24, CancellationException.class) == true) goto L48;
        r14.element = com.obric.memorydata.datatransport.utils.b.f9829a.a(r24);
        RunLog.INSTANCE.error("ExportData", "export attachment failed", r24);
        goto L50
    L48:
        throw r24;
    L50:
        if (Result.m1424exceptionOrNullimpl(r17) != null) goto L52;
        int r25 = 0;
    L53:
        a r26 = (a) ZeusTransformUtils.preCheckCast(r17, a.class, "com.obric.memorydata.plugin");
        Function1<com.obric.memorydata.datatransport.utils.a, Unit> r27 = r1.c;
        if (r26.a() <= 0) goto L56;
        boolean r28 = 1;
    L57:
        r27.invoke(new com.obric.memorydata.datatransport.utils.a(r12, r28, (ExportFailureReason) ZeusTransformUtils.preCheckCast(r14.element, ExportFailureReason.class, "com.obric.memorydata.plugin")));
        return r17;
    L56:
        r28 = r25;
        goto L57
    L52:
        r25 = 0;
        r17 = new a(r25, r10, r10, null);
        goto L53
    L28:
        if (ZeusTransformUtils.instanceOf(r15, d.a.class) == false) goto L37;
        Throwable r29 = ((d.a) ZeusTransformUtils.preCheckCast(r15, d.a.class, "com.obric.memorydata.plugin")).b();     // Catch: Throwable -> L38
        if (r29 == null) goto L33;
        ExportFailureReason r30 = com.obric.memorydata.datatransport.utils.b.f9829a.a(r29);     // Catch: Throwable -> L38
        T r31 = r30;
        if (r30 == null) goto L33;
    L34:
        r14.element = r31;     // Catch: Throwable -> L38
        RunLog.INSTANCE.error("ExportData", "open attachment " + r13 + " failed, privilegedStatus=" + ((d.a) ZeusTransformUtils.preCheckCast(r15, d.a.class, "com.obric.memorydata.plugin")).a(), ((d.a) ZeusTransformUtils.preCheckCast(r15, d.a.class, "com.obric.memorydata.plugin")).b());     // Catch: Throwable -> L38
        r16 = new a(0, r10, r10, null);     // Catch: Throwable -> L38
    L33:
        r31 = ExportFailureReason.OPEN_FAILED;     // Catch: Throwable -> L38
        goto L34
    L37:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L38
    L14:
        th = th;
        r14 = r7;
        r1 = r11;
        r12 = r8;
    L42:
        Result.Companion r32 = Result.Companion;
        r17 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L43
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r3);
        a();
        r14 = new Ref.ObjectRef();
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L40
        e r110 = (e) ZeusTransformUtils.preCheckCast(r1, e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L40
        c r34 = r110.e;     // Catch: Throwable -> L40
        String r35 = r18.get_packageName();     // Catch: Throwable -> L40
        String r111 = r19.toString();     // Catch: Throwable -> L40
        Intrinsics.checkNotNullExpressionValue(r111, "toString(...)");     // Catch: Throwable -> L40
        Function2<? super InputStream, ? super Continuation<? super Unit>, ? extends Object> r36 = (Function2) ZeusTransformUtils.preCheckCast(new EntityFileExporter$saveFile$2$openResult$1(r110, r20, r21, r18, null), Function2.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L40
        r4.L$0 = r1;     // Catch: Throwable -> L40
        r13 = r19;
        r4.L$1 = r13;     // Catch: Throwable -> L40
        r12 = r22;
        r4.L$2 = r12;     // Catch: Throwable -> L38
        r4.L$3 = r14;     // Catch: Throwable -> L38
        r4.label = 1;     // Catch: Throwable -> L38
        r0 = r34.a(r35, r111, r36, r4);     // Catch: Throwable -> L38
        if (r0 != r5) goto L24;
        return r5;
    L38:
        th = th;
    L40:
        th = th;
        r12 = r22;
    L7:
        r4 = new EntityFileExporter$saveFile$1(r1, r2);
        goto L8
    }

    public static final /* synthetic */ Object a(e r7, AppEntity r8, Uri r9, String r10, String r11, ExportStatisticsCategory r12, Continuation r13) {
        return r7.a(r8, r9, r10, r11, r12, (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object a(e r2, AppEntity r3, Continuation r4) {
        return r2.b(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final void a() {
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.d.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L6;
        return;
    L6:
        throw new CancellationException("data export account changed");
    }

    public static final /* synthetic */ void a(e r0, InputStream r1, OutputStream r2) {
        r0.a(r1, r2);
    }

    private final void a(InputStream r3, OutputStream r4) {
        byte[] r2 = new byte[8192];
    L3:
        int r0 = r3.read(r2);
        if (r0 == (-1)) goto L6;
        r4.write(r2, 0, r0);
        goto L3
    }

    /* JADX WARN: Type inference failed for: r0v123, types: [T, com.obric.memorydata.datatransport.utils.e$a] */
    /* JADX WARN: Type inference failed for: r0v142, types: [T, com.obric.memorydata.datatransport.utils.e$a] */
    /* JADX WARN: Type inference failed for: r0v169, types: [T, com.obric.memorydata.datatransport.utils.e$a] */
    /* JADX WARN: Type inference failed for: r0v185, types: [T, com.obric.memorydata.datatransport.utils.e$a] */
    /* JADX WARN: Type inference failed for: r0v2, types: [T, com.obric.memorydata.datatransport.utils.e$a] */
    /* JADX WARN: Type inference failed for: r1v65, types: [T, com.obric.memorydata.datatransport.utils.e$a] */
    /* JADX WARN: Type inference failed for: r1v76, types: [T, com.obric.memorydata.datatransport.utils.e$a] */
    /* JADX WARN: Type inference failed for: r1v86, types: [T, com.obric.memorydata.datatransport.utils.e$a] */
    /* JADX WARN: Type inference failed for: r1v91, types: [T, com.obric.memorydata.datatransport.utils.e$a] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x02fd -> B:42:0x02fe). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x0388 -> B:56:0x0389). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x0412 -> B:68:0x0413). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x04b4 -> B:82:0x04b5). Please report as a decompilation issue!!! */
    private final Object b(AppEntity r26, Continuation<? super a> r27) {
        e r7 = this;
        AppEntity r8 = r26;
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r27, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, EntityFileExporter$export$1.class) == false) goto L7;
        EntityFileExporter$export$1 r2 = (EntityFileExporter$export$1) ZeusTransformUtils.preCheckCast(r1, EntityFileExporter$export$1.class, "com.obric.memorydata.plugin");
        if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
        r2.label -= Integer.MIN_VALUE;
    L8:
        EntityFileExporter$export$1 r15 = r2;
        Object r3 = r15.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r15.label) {
            case 0: goto L20;
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L19;
            case 7: goto L19;
            case 8: goto L14;
            case 9: goto L19;
            case 10: goto L13;
            case 11: goto L19;
            case 12: goto L12;
            case 13: goto L19;
            default: goto L11;
        };
    L12:
        a r0 = (a) ZeusTransformUtils.preCheckCast(r15.L$2, a.class, "com.obric.memorydata.plugin");
        Ref.ObjectRef r4 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r15.L$1, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        Ref.ObjectRef r5 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r15.L$0, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
    L128:
        r4.element = r0.a((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin"));
    L29:
        Ref.ObjectRef r6 = r5;
    L140:
        return r6.element;
    L13:
        a r9 = (a) ZeusTransformUtils.preCheckCast(r15.L$4, a.class, "com.obric.memorydata.plugin");
        Ref.ObjectRef r10 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r15.L$3, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        Ref.ObjectRef r11 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r15.L$2, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        AppEntity r12 = (AppEntity) ZeusTransformUtils.preCheckCast(r15.L$1, AppEntity.class, "com.obric.memorydata.plugin");
        e r13 = (e) ZeusTransformUtils.preCheckCast(r15.L$0, e.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        r7 = r13;
        Ref.ObjectRef r16 = r11;
        AppEntity r17 = r12;
        String r18 = TypedValues.Custom.S_STRING;
        EntityFileExporter$export$1 r19 = r15;
        Object r110 = r14;
    L117:
        r10.element = r9.a((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin"));
        FileEntity r20 = ((RecordingEntity) ZeusTransformUtils.preCheckCast(r17, RecordingEntity.class, "com.obric.memorydata.plugin")).getTranscript();
        if (r20 != null) goto L119;
    L110:
        r6 = r16;
        goto L140
    L119:
        a r21 = (a) ZeusTransformUtils.preCheckCast(r16.element, a.class, "com.obric.memorydata.plugin");
        Uri r22 = r20.getContentUrl();
        String r111 = b.a(f9835a, ZeusTransformUtils.mapRes(R.string.data_transport_entity_file_recording, r18, "data_transport_entity_file_recording"), new Object[0]);
        String r112 = r20.getFileName();
        ExportStatisticsCategory r23 = ExportStatisticsCategory.RECORDING_TRANSCRIPT;
        EntityFileExporter$export$1 r24 = r19;
        r24.L$0 = r16;
        r24.L$1 = r21;
        r24.L$2 = r16;
        r24.L$3 = null;
        r24.L$4 = null;
        r24.label = 11;
        Object r25 = r110;
        r3 = r7.a(r17, r22, r111, r112, r23, r19);
        if (r3 == r25) goto L121;
    L109:
        r5 = r16;
    L28:
        r16.element = r21.a((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin"));
        goto L29
    L121:
        return r25;
    L14:
        a r28 = (a) ZeusTransformUtils.preCheckCast(r15.L$4, a.class, "com.obric.memorydata.plugin");
        Ref.ObjectRef r29 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r15.L$3, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        Ref.ObjectRef r30 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r15.L$2, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        AppEntity r31 = (AppEntity) ZeusTransformUtils.preCheckCast(r15.L$1, AppEntity.class, "com.obric.memorydata.plugin");
        e r32 = (e) ZeusTransformUtils.preCheckCast(r15.L$0, e.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        e r113 = r32;
        r16 = r30;
    L104:
        r29.element = r28.a((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin"));
        FileEntity r33 = ((AuditoryRecordingEntity) ZeusTransformUtils.preCheckCast(r31, AuditoryRecordingEntity.class, "com.obric.memorydata.plugin")).getTranscript();
        if (r33 == null) goto L110;
        r21 = (a) ZeusTransformUtils.preCheckCast(r16.element, a.class, "com.obric.memorydata.plugin");
        Uri r34 = r33.getContentUrl();
        String r114 = b.a(f9835a, ZeusTransformUtils.mapRes(R.string.data_transport_entity_file_auditory_recording, TypedValues.Custom.S_STRING, "data_transport_entity_file_auditory_recording"), new Object[0]);
        String r35 = r33.getFileName();
        ExportStatisticsCategory r36 = ExportStatisticsCategory.AUDITORY_TRANSCRIPT;
        r15.L$0 = r16;
        r15.L$1 = r21;
        r15.L$2 = r16;
        r15.L$3 = null;
        r15.L$4 = null;
        r15.label = 9;
        r3 = r113.a(r31, r34, r114, r35, r36, r15);
        if (r3 != r14) goto L109;
        return r14;
    L15:
        Ref.ObjectRef r37 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r15.L$5, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        a r38 = (a) ZeusTransformUtils.preCheckCast(r15.L$4, a.class, "com.obric.memorydata.plugin");
        Iterator r39 = (Iterator) ZeusTransformUtils.preCheckCast(r15.L$3, Iterator.class, "com.obric.memorydata.plugin");
        r6 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r15.L$2, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        AppEntity r40 = (AppEntity) ZeusTransformUtils.preCheckCast(r15.L$1, AppEntity.class, "com.obric.memorydata.plugin");
        e r41 = (e) ZeusTransformUtils.preCheckCast(r15.L$0, e.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        r8 = r40;
        r7 = r41;
    L82:
        r37.element = r38.a((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin"));
    L83:
        r37 = r6;
        if (r39.hasNext() == true) goto L74;
    L44:
        r6 = r37;
        goto L140
    L74:
        Uri r115 = (Uri) ZeusTransformUtils.preCheckCast(r39.next(), Uri.class, "com.obric.memorydata.plugin");
        r38 = (a) ZeusTransformUtils.preCheckCast(r37.element, a.class, "com.obric.memorydata.plugin");
        String r116 = b.a(f9835a, ZeusTransformUtils.mapRes(R.string.data_transport_entity_file_album, TypedValues.Custom.S_STRING, "data_transport_entity_file_album"), new Object[0]);
        String r210 = ((PhotoEntity) ZeusTransformUtils.preCheckCast(r8, PhotoEntity.class, "com.obric.memorydata.plugin")).getName();
        if (((PhotoEntity) ZeusTransformUtils.preCheckCast(r8, PhotoEntity.class, "com.obric.memorydata.plugin")).getAssetType() != AssetTypeEnum.VIDEO) goto L77;
        ExportStatisticsCategory r42 = ExportStatisticsCategory.VIDEO_ORIGINAL;
    L78:
        r15.L$0 = r7;
        r15.L$1 = r8;
        r15.L$2 = r37;
        r15.L$3 = r39;
        r15.L$4 = r38;
        r15.L$5 = r37;
        r15.label = 5;
        r3 = r7.a(r8, r115, r116, r210, r42, r15);
        if (r3 != r14) goto L81;
        return r14;
    L81:
        r6 = r37;
        goto L82
    L77:
        r42 = ExportStatisticsCategory.PHOTO_ORIGINAL;
        goto L78
    L16:
        r37 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r15.L$5, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        a r43 = (a) ZeusTransformUtils.preCheckCast(r15.L$4, a.class, "com.obric.memorydata.plugin");
        Iterator r44 = (Iterator) ZeusTransformUtils.preCheckCast(r15.L$3, Iterator.class, "com.obric.memorydata.plugin");
        Ref.ObjectRef r45 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r15.L$2, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        AppEntity r46 = (AppEntity) ZeusTransformUtils.preCheckCast(r15.L$1, AppEntity.class, "com.obric.memorydata.plugin");
        e r47 = (e) ZeusTransformUtils.preCheckCast(r15.L$0, e.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
    L68:
        r37.element = r43.a((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin"));
        r37 = r45;
    L63:
        if (r44.hasNext() == false) goto L44;
        RecordingEntity r48 = (RecordingEntity) ZeusTransformUtils.preCheckCast(r44.next(), RecordingEntity.class, "com.obric.memorydata.plugin");
        r43 = (a) ZeusTransformUtils.preCheckCast(r37.element, a.class, "com.obric.memorydata.plugin");
        Uri r117 = r48.getFile().getContentUrl();
        String r118 = b.a(f9835a, ZeusTransformUtils.mapRes(R.string.data_transport_entity_file_note_recording, TypedValues.Custom.S_STRING, "data_transport_entity_file_note_recording"), new Object[0]);
        String r211 = r48.getFile().getFileName();
        ExportStatisticsCategory r212 = ExportStatisticsCategory.NOTE_RECORDING;
        r15.L$0 = r47;
        r15.L$1 = r46;
        r15.L$2 = r37;
        r15.L$3 = r44;
        r15.L$4 = r43;
        r15.L$5 = r37;
        r15.label = 4;
        r3 = r47.a(r46, r117, r118, r211, r212, r15);
        if (r3 != r14) goto L67;
        return r14;
    L67:
        r45 = r37;
        goto L68
    L17:
        Ref.ObjectRef r49 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r15.L$5, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        a r50 = (a) ZeusTransformUtils.preCheckCast(r15.L$4, a.class, "com.obric.memorydata.plugin");
        Iterator r51 = (Iterator) ZeusTransformUtils.preCheckCast(r15.L$3, Iterator.class, "com.obric.memorydata.plugin");
        r6 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r15.L$2, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        AppEntity r52 = (AppEntity) ZeusTransformUtils.preCheckCast(r15.L$1, AppEntity.class, "com.obric.memorydata.plugin");
        e r53 = (e) ZeusTransformUtils.preCheckCast(r15.L$0, e.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        r8 = r52;
        r7 = r53;
    L56:
        r49.element = r50.a((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin"));
    L57:
        r49 = r6;
        if (r51.hasNext() == false) goto L58;
        FileEntity r54 = (FileEntity) ZeusTransformUtils.preCheckCast(r51.next(), FileEntity.class, "com.obric.memorydata.plugin");
        r50 = (a) ZeusTransformUtils.preCheckCast(r49.element, a.class, "com.obric.memorydata.plugin");
        Uri r119 = r54.getContentUrl();
        String r120 = b.a(f9835a, ZeusTransformUtils.mapRes(R.string.data_transport_entity_file_note_image, TypedValues.Custom.S_STRING, "data_transport_entity_file_note_image"), new Object[0]);
        String r213 = r54.getFileName();
        ExportStatisticsCategory r214 = ExportStatisticsCategory.NOTE_FILE;
        r15.L$0 = r7;
        r15.L$1 = r8;
        r15.L$2 = r49;
        r15.L$3 = r51;
        r15.L$4 = r50;
        r15.L$5 = r49;
        r15.label = 3;
        r3 = r7.a(r8, r119, r120, r213, r214, r15);
        if (r3 != r14) goto L55;
        return r14;
    L55:
        r6 = r49;
        goto L56
    L58:
        r6 = r49;
    L59:
        List<RecordingEntity> r55 = ((NoteEntity) ZeusTransformUtils.preCheckCast(r8, NoteEntity.class, "com.obric.memorydata.plugin")).getRecordings();
        if (r55 == null) goto L140;
        r44 = ((Iterable) ZeusTransformUtils.preCheckCast(r55, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        r37 = r6;
        r47 = r7;
        r46 = r8;
        goto L63
    L18:
        r37 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r15.L$5, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        a r56 = (a) ZeusTransformUtils.preCheckCast(r15.L$4, a.class, "com.obric.memorydata.plugin");
        Iterator r57 = (Iterator) ZeusTransformUtils.preCheckCast(r15.L$3, Iterator.class, "com.obric.memorydata.plugin");
        r6 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r15.L$2, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        AppEntity r58 = (AppEntity) ZeusTransformUtils.preCheckCast(r15.L$1, AppEntity.class, "com.obric.memorydata.plugin");
        e r59 = (e) ZeusTransformUtils.preCheckCast(r15.L$0, e.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        r8 = r58;
        r7 = r59;
    L42:
        r37.element = r56.a((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin"));
    L43:
        r37 = r6;
        if (r57.hasNext() == false) goto L44;
        FileEntity r60 = (FileEntity) ZeusTransformUtils.preCheckCast(r57.next(), FileEntity.class, "com.obric.memorydata.plugin");
        r56 = (a) ZeusTransformUtils.preCheckCast(r37.element, a.class, "com.obric.memorydata.plugin");
        Uri r121 = r60.getContentUrl();
        String r122 = b.a(f9835a, ZeusTransformUtils.mapRes(R.string.data_transport_entity_file_sms_image, TypedValues.Custom.S_STRING, "data_transport_entity_file_sms_image"), new Object[0]);
        String r215 = r60.getFileName();
        ExportStatisticsCategory r216 = ExportStatisticsCategory.MESSAGE_FILE;
        r15.L$0 = r7;
        r15.L$1 = r8;
        r15.L$2 = r37;
        r15.L$3 = r57;
        r15.L$4 = r56;
        r15.L$5 = r37;
        r15.label = 2;
        r3 = r7.a(r8, r121, r122, r215, r216, r15);
        if (r3 != r14) goto L41;
        return r14;
    L41:
        r6 = r37;
        goto L42
    L19:
        r16 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r15.L$2, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        r21 = (a) ZeusTransformUtils.preCheckCast(r15.L$1, a.class, "com.obric.memorydata.plugin");
        r5 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r15.L$0, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        goto L28
    L20:
        ResultKt.throwOnFailure(r3);
        a();
        r6 = new Ref.ObjectRef();
        r6.element = a.f9837a.a();
        if (ZeusTransformUtils.instanceOf(r8, ContactEntity.class) == false) goto L32;
        FileEntity r61 = ((ContactEntity) ZeusTransformUtils.preCheckCast(r8, ContactEntity.class, "com.obric.memorydata.plugin")).getAvatar();
        if (r61 == null) goto L30;
        a r123 = (a) ZeusTransformUtils.preCheckCast(r6.element, a.class, "com.obric.memorydata.plugin");
        Uri r62 = r61.getContentUrl();
        String r63 = b.a(f9835a, ZeusTransformUtils.mapRes(R.string.data_transport_entity_file_contact_avatar, TypedValues.Custom.S_STRING, "data_transport_entity_file_contact_avatar"), new Object[0]);
        String r64 = r61.getFileName();
        ExportStatisticsCategory r65 = ExportStatisticsCategory.CONTACT_AVATAR;
        r15.L$0 = r6;
        r15.L$1 = r123;
        r15.L$2 = r6;
        r15.label = 1;
        r3 = a(r26, r62, r63, r64, r65, r15);
        if (r3 != r14) goto L27;
        return r14;
    L27:
        r16 = r6;
        r5 = r16;
        r21 = r123;
    L30:
        Ref.ObjectRef r124 = r6;
    L138:
        r6 = r124;
        goto L140
    L32:
        if (ZeusTransformUtils.instanceOf(r8, MessageEntity.class) == false) goto L46;
        List<FileEntity> r66 = ((MessageEntity) ZeusTransformUtils.preCheckCast(r8, MessageEntity.class, "com.obric.memorydata.plugin")).getFiles();
        if (r66 == null) goto L30;
        r57 = ((Iterable) ZeusTransformUtils.preCheckCast(r66, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        goto L43
    L46:
        if (ZeusTransformUtils.instanceOf(r8, NoteEntity.class) == false) goto L70;
        List<FileEntity> r67 = ((NoteEntity) ZeusTransformUtils.preCheckCast(r8, NoteEntity.class, "com.obric.memorydata.plugin")).getFiles();
        if (r67 == null) goto L59;
        r51 = ((Iterable) ZeusTransformUtils.preCheckCast(r67, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        goto L57
    L70:
        if (ZeusTransformUtils.instanceOf(r8, PhotoEntity.class) == false) goto L85;
        r39 = ((Iterable) ZeusTransformUtils.preCheckCast(((PhotoEntity) ZeusTransformUtils.preCheckCast(r8, PhotoEntity.class, "com.obric.memorydata.plugin")).getSharedUris(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        goto L83
    L85:
        if (ZeusTransformUtils.instanceOf(r8, AlbumEntity.class) == false) goto L92;
        FileEntity r68 = ((AlbumEntity) ZeusTransformUtils.preCheckCast(r8, AlbumEntity.class, "com.obric.memorydata.plugin")).getCover();
        if (r68 == null) goto L30;
        r123 = (a) ZeusTransformUtils.preCheckCast(r6.element, a.class, "com.obric.memorydata.plugin");
        Uri r69 = r68.getContentUrl();
        String r70 = b.a(f9835a, ZeusTransformUtils.mapRes(R.string.data_transport_entity_file_album_cover, TypedValues.Custom.S_STRING, "data_transport_entity_file_album_cover"), new Object[0]);
        String r71 = r68.getFileName();
        ExportStatisticsCategory r72 = ExportStatisticsCategory.ALBUM_COVER;
        r15.L$0 = r6;
        r15.L$1 = r123;
        r15.L$2 = r6;
        r15.label = 6;
        r3 = a(r26, r69, r70, r71, r72, r15);
        if (r3 != r14) goto L27;
        return r14;
    L92:
        if (ZeusTransformUtils.instanceOf(r8, PhotoFaceEntity.class) == false) goto L99;
        FileEntity r73 = ((PhotoFaceEntity) ZeusTransformUtils.preCheckCast(r8, PhotoFaceEntity.class, "com.obric.memorydata.plugin")).getAvatar();
        if (r73 == null) goto L30;
        r123 = (a) ZeusTransformUtils.preCheckCast(r6.element, a.class, "com.obric.memorydata.plugin");
        Uri r74 = r73.getContentUrl();
        String r75 = b.a(f9835a, ZeusTransformUtils.mapRes(R.string.data_transport_entity_file_photo_face_avatar, TypedValues.Custom.S_STRING, "data_transport_entity_file_photo_face_avatar"), new Object[0]);
        String r76 = r73.getFileName();
        ExportStatisticsCategory r77 = ExportStatisticsCategory.FACE_AVATAR;
        r15.L$0 = r6;
        r15.L$1 = r123;
        r15.L$2 = r6;
        r15.label = 7;
        r3 = a(r26, r74, r75, r76, r77, r15);
        if (r3 != r14) goto L27;
        return r14;
    L99:
        if (ZeusTransformUtils.instanceOf(r8, AuditoryRecordingEntity.class) == false) goto L111;
        a r125 = (a) ZeusTransformUtils.preCheckCast(r6.element, a.class, "com.obric.memorydata.plugin");
        Uri r78 = ((AuditoryRecordingEntity) ZeusTransformUtils.preCheckCast(r8, AuditoryRecordingEntity.class, "com.obric.memorydata.plugin")).getFile().getContentUrl();
        String r79 = b.a(f9835a, ZeusTransformUtils.mapRes(R.string.data_transport_entity_file_auditory_recording, TypedValues.Custom.S_STRING, "data_transport_entity_file_auditory_recording"), new Object[0]);
        String r80 = ((AuditoryRecordingEntity) ZeusTransformUtils.preCheckCast(r8, AuditoryRecordingEntity.class, "com.obric.memorydata.plugin")).getFile().getFileName();
        ExportStatisticsCategory r126 = ExportStatisticsCategory.AUDITORY_RECORDING;
        r15.L$0 = r7;
        r15.L$1 = r8;
        r15.L$2 = r6;
        r15.L$3 = r6;
        r15.L$4 = r125;
        r15.label = 8;
        r3 = a(r26, r78, r79, r80, r126, r15);
        if (r3 != r14) goto L103;
        return r14;
    L103:
        r31 = r8;
        r28 = r125;
        r16 = r6;
        r29 = r16;
        r113 = r7;
        goto L104
    L111:
        r18 = TypedValues.Custom.S_STRING;
        r124 = r6;
        if (ZeusTransformUtils.instanceOf(r8, RecordingEntity.class) == false) goto L123;
        a r127 = (a) ZeusTransformUtils.preCheckCast(r124.element, a.class, "com.obric.memorydata.plugin");
        Uri r81 = ((RecordingEntity) ZeusTransformUtils.preCheckCast(r8, RecordingEntity.class, "com.obric.memorydata.plugin")).getFile().getContentUrl();
        String r82 = b.a(f9835a, ZeusTransformUtils.mapRes(R.string.data_transport_entity_file_recording, r18, "data_transport_entity_file_recording"), new Object[0]);
        String r83 = ((RecordingEntity) ZeusTransformUtils.preCheckCast(r8, RecordingEntity.class, "com.obric.memorydata.plugin")).getFile().getFileName();
        ExportStatisticsCategory r128 = ExportStatisticsCategory.RECORDING_FILE;
        r15.L$0 = r7;
        r15.L$1 = r8;
        r15.L$2 = r124;
        r15.L$3 = r124;
        r15.L$4 = r127;
        r15.label = 10;
        r19 = r15;
        r110 = r14;
        r3 = a(r26, r81, r82, r83, r128, r19);
        if (r3 != r110) goto L116;
        return r110;
    L116:
        r16 = r124;
        r10 = r16;
        r9 = r127;
        r17 = r8;
        goto L117
    L123:
        if (ZeusTransformUtils.instanceOf(r8, FileEntity.class) == false) goto L130;
        a r129 = (a) ZeusTransformUtils.preCheckCast(r124.element, a.class, "com.obric.memorydata.plugin");
        Uri r84 = ((FileEntity) ZeusTransformUtils.preCheckCast(r8, FileEntity.class, "com.obric.memorydata.plugin")).getContentUrl();
        String r85 = b.a(f9835a, ZeusTransformUtils.mapRes(R.string.data_transport_entity_file_document, r18, "data_transport_entity_file_document"), new Object[0]);
        String r86 = ((FileEntity) ZeusTransformUtils.preCheckCast(r8, FileEntity.class, "com.obric.memorydata.plugin")).getFileName();
        ExportStatisticsCategory r130 = ExportStatisticsCategory.DOCUMENT;
        r15.L$0 = r124;
        r15.L$1 = r124;
        r15.L$2 = r129;
        r15.label = 12;
        r3 = a(r26, r84, r85, r86, r130, r15);
        if (r3 != r14) goto L127;
        return r14;
    L127:
        r0 = r129;
        r4 = r124;
        r5 = r4;
        goto L128
    L130:
        if (ZeusTransformUtils.instanceOf(r8, MemoryEntity.class) == false) goto L137;
        FileEntity r87 = ((MemoryEntity) ZeusTransformUtils.preCheckCast(r8, MemoryEntity.class, "com.obric.memorydata.plugin")).getScreenshot();
        if (r87 == null) goto L138;
        a r131 = (a) ZeusTransformUtils.preCheckCast(r124.element, a.class, "com.obric.memorydata.plugin");
        Uri r88 = r87.getContentUrl();
        String r89 = b.a(f9835a, ZeusTransformUtils.mapRes(R.string.data_transport_entity_file_memory_screenshot, r18, "data_transport_entity_file_memory_screenshot"), new Object[0]);
        String r90 = r87.getFileName();
        ExportStatisticsCategory r91 = ExportStatisticsCategory.MEMORY_SCREENSHOT;
        r15.L$0 = r124;
        r15.L$1 = r131;
        r15.L$2 = r124;
        r15.label = 13;
        r3 = a(r26, r88, r89, r90, r91, r15);
        if (r3 != r14) goto L136;
        return r14;
    L136:
        r21 = r131;
        r16 = r124;
        goto L109
    L137:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ExportData", b.a(f9835a, ZeusTransformUtils.mapRes(R.string.data_transport_entity_file_unsupported_type, r18, "data_transport_entity_file_unsupported_type"), new Object[]{r26.getClass()}), null, 4, null);
        goto L138
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r2 = new EntityFileExporter$export$1(r7, r1);
        goto L8
    }

    public final Object a(AppEntity r6, Continuation<? super a> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, EntityFileExporter$exportEntity$1.class) == false) goto L7;
        EntityFileExporter$exportEntity$1 r0 = (EntityFileExporter$exportEntity$1) ZeusTransformUtils.preCheckCast(r8, EntityFileExporter$exportEntity$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r9);
    L19:
        a r5 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L22;
        return r5;
    L22:
        return a.f9837a.a();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        if (r6 == null) goto L22;
        r0.label = 1;
        r9 = b(r6, r0);
        if (r9 != r2) goto L19;
        return r2;
    L7:
        r0 = new EntityFileExporter$exportEntity$1(this, r8);
        goto L8
    }
}
