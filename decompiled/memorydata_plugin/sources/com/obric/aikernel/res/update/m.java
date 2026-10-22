package com.obric.aikernel.res.update;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B¡\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u001a\b\u0002\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f0\u0011\u0012 \b\u0002\u0010\u0012\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f0\u0013¢\u0006\u0002\u0010\u0014J\u0006\u0010 \u001a\u00020\u000fJ\b\u0010!\u001a\u00020\fH\u0002J\b\u0010\"\u001a\u00020\u000fH\u0002J\u0010\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u0003H\u0002J\u0010\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u0003H\u0002J\b\u0010'\u001a\u00020\u000fH\u0002J\b\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020\fH\u0002JH\u0010+\u001a\u00020\u000f2\u001e\u0010,\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00190\u00180\u00112\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f0\u00112\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0019J\u0006\u0010/\u001a\u00020\u000fJ\u0006\u00100\u001a\u00020)J\b\u00101\u001a\u00020\u000fH\u0002J\b\u00102\u001a\u00020\u000fH\u0002R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R&\u0010\u0012\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00190\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R \u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/obric/aikernel/res/update/ModelPayloadInstallSession;", "", "payloadParent", "Ljava/io/File;", TypedValues.AttributesType.S_TARGET, "staging", "backup", "publishInFlight", "integritySeal", "integrityRepair", "enable", "sealVersion", "", "writeDurableMarker", "Lkotlin/Function2;", "", "syncDirectory", "Lkotlin/Function1;", "commitPayload", "Lkotlin/Function3;", "(Ljava/io/File;Ljava/io/File;Ljava/io/File;Ljava/io/File;Ljava/io/File;Ljava/io/File;Ljava/io/File;Ljava/io/File;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)V", "getBackup", "()Ljava/io/File;", "downloadedArtifactCleanup", "", "Lkotlin/Function0;", "getEnable", "getIntegritySeal", "getPayloadParent", "getPublishInFlight", "getStaging", "getTarget", "activate", "beginPublish", "cleanupBackup", "deleteMarkerDurably", "marker", "deletePathDurably", "path", "ensurePayloadParent", "isInFlightCommitted", "", "newTransactionToken", "prepareAndPublish", "stagePayload", "sealPayload", "persistMetadata", "recover", "requiresPrepare", "restoreBackupIfPresent", "rollbackUncommittedPublish", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f6140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f6141b;
    private final File c;
    private final File d;
    private final File e;
    private final File f;
    private final File g;
    private final File h;
    private final String i;
    private final Function2<File, String, Unit> j;
    private final Function1<File, Unit> k;
    private final Function3<File, File, File, Unit> l;
    private List<? extends Function0<Unit>> m;

    public m(File r3, File r4, File r5, File r6, File r7, File r8, File r9, File r10, String r11, Function2<? super File, ? super String, Unit> r12, Function1<? super File, Unit> r13, Function3<? super File, ? super File, ? super File, Unit> r14) {
        Function2<File, String, Unit> r15 = (Function2) ZeusTransformUtils.wrapperContextForParams(r12, Function2.class, "com.obric.memorydata.plugin");
        Function1<File, Unit> r16 = (Function1) ZeusTransformUtils.wrapperContextForParams(r13, Function1.class, "com.obric.memorydata.plugin");
        Function3<File, File, File, Unit> r17 = (Function3) ZeusTransformUtils.wrapperContextForParams(r14, Function3.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "payloadParent");
        Intrinsics.checkNotNullParameter(r4, TypedValues.AttributesType.S_TARGET);
        Intrinsics.checkNotNullParameter(r5, "staging");
        Intrinsics.checkNotNullParameter(r6, "backup");
        Intrinsics.checkNotNullParameter(r7, "publishInFlight");
        Intrinsics.checkNotNullParameter(r8, "integritySeal");
        Intrinsics.checkNotNullParameter(r9, "integrityRepair");
        Intrinsics.checkNotNullParameter(r10, "enable");
        Intrinsics.checkNotNullParameter(r11, "sealVersion");
        Intrinsics.checkNotNullParameter(r15, "writeDurableMarker");
        Intrinsics.checkNotNullParameter(r16, "syncDirectory");
        Intrinsics.checkNotNullParameter(r17, "commitPayload");
        this.f6140a = r3;
        this.f6141b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r15;
        this.k = r16;
        this.l = r17;
        this.m = CollectionsKt.emptyList();
    }

    public /* synthetic */ m(File r19, File r20, File r21, File r22, File r23, File r24, File r25, File r26, String r27, Function2 r28, Function1 r29, Function3 r30, int r31, DefaultConstructorMarker r32) {
        Function2 r1 = (Function2) ZeusTransformUtils.wrapperContextForParams(r28, Function2.class, "com.obric.memorydata.plugin");
        Function1 r3 = (Function1) ZeusTransformUtils.wrapperContextForParams(r29, Function1.class, "com.obric.memorydata.plugin");
        Function3 r4 = (Function3) ZeusTransformUtils.wrapperContextForParams(r30, Function3.class, "com.obric.memorydata.plugin");
        if ((r31 & 512) == 0) goto L5;
        r1 = (Function2) ZeusTransformUtils.preCheckCast(new ModelPayloadInstallSession$1(com.obric.aikernel.res.integrity.a.f6050a), Function2.class, "com.obric.memorydata.plugin");
    L5:
        Function2 r15 = r1;
        if ((r31 & 1024) == 0) goto L8;
        r3 = (Function1) ZeusTransformUtils.preCheckCast(new ModelPayloadInstallSession$2(com.obric.aikernel.res.integrity.a.f6050a), Function1.class, "com.obric.memorydata.plugin");
    L8:
        Function1 r16 = r3;
        if ((r31 & 2048) == 0) goto L11;
        r4 = (Function3) ZeusTransformUtils.preCheckCast(new ModelPayloadInstallSession$3(com.obric.aikernel.res.integrity.a.f6050a), Function3.class, "com.obric.memorydata.plugin");
    L11:
        this(r19, r20, r21, r22, r23, r24, r25, r26, r27, r15, r16, r4);
    }

    private final void a(File r3) {
        if (r3.exists() == true) goto L6;
        return;
    L6:
        if (r3.delete() == false) goto L14;
        Function1<File, Unit> r2 = this.k;
        File r0 = r3.getParentFile();
        if (r0 == null) goto L12;
        r2.invoke(r0);
        return;
    L12:
        throw new IllegalStateException("marker has no parent: " + r3);
    L14:
        throw new IllegalStateException(("cannot remove model state marker: " + r3).toString());
    }

    private final void b(File r3) {
        if (r3.exists() == true) goto L6;
        return;
    L6:
        if (FilesKt.deleteRecursively(r3) == false) goto L14;
        Function1<File, Unit> r2 = this.k;
        File r0 = r3.getParentFile();
        if (r0 == null) goto L12;
        r2.invoke(r0);
        return;
    L12:
        throw new IllegalStateException("install path has no parent: " + r3);
    L14:
        throw new IllegalStateException(("cannot remove model install path: " + r3).toString());
    }

    private final void d() {
        b(this.d);
    }

    private final String e() {
        String r0 = h();
        this.j.invoke(this.e, r0);
        a(this.h);
        a(this.f);
        a(this.g);
        return r0;
    }

    private final void f() {
        a(this.h);
        a(this.f);
        a(this.g);
        b(this.c);
        i();
    }

    private final boolean g() {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L13
        m r5 = (m) ZeusTransformUtils.preCheckCast(this, m.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        boolean r3 = true;
        if (r5.e.isFile() == true) goto L6;
    L10:
        r3 = false;
    L11:
        Object r6 = Result.m1421constructorimpl(Boolean.valueOf(r3));     // Catch: Throwable -> L13
    L16:
        if (Result.m1427isFailureimpl(r6) == false) goto L19;
        r6 = false;
    L19:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L6:
        if (r5.f.isFile() == false) goto L10;
        if (Intrinsics.areEqual(FilesKt.readText$default(r5.e, null, 1, null), FilesKt.readText$default(r5.f, null, 1, null)) == false) goto L10;
    L13:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L16
    }

    private final String h() {
        return this.i + ':' + UUID.randomUUID();
    }

    private final void i() {
        if (this.d.exists() == true) goto L5;
        return;
    L5:
        b(this.f6141b);
        if (this.d.renameTo(this.f6141b) == false) goto L10;
        this.k.invoke(this.f6140a);
        return;
    L10:
        throw new IllegalStateException(("cannot restore model backup: " + this.d).toString());
    }

    private final void j() {
        if (this.f6140a.exists() == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L12;
        return;
    L12:
        throw new IllegalArgumentException(("cannot create model payload parent: " + this.f6140a).toString());
    L5:
        if (this.f6140a.mkdirs() == true) goto L8;
        r0 = false;
        goto L9
    }

    public final void a() {
        j();
        if (this.e.exists() == false) goto L15;
        if (g() == true) goto L7;
    L12:
        f();
        return;
    L7:
        if (this.c.exists() == true) goto L12;
        a(this.e);
        if (this.h.exists() == false) goto L29;
        d();
        return;
    L29:
        return;
    L15:
        if (this.d.exists() == false) goto L21;
        if (this.f.exists() == true) goto L21;
        this.j.invoke(this.e, h());
        f();
        return;
    L21:
        if (this.c.exists() == false) goto L24;
        b(this.c);
    L24:
        if (this.h.exists() == true) goto L26;
        return;
    L26:
        if (this.f.exists() == false) goto L31;
        d();
        return;
    }

    public final void a(Function1<? super File, ? extends List<? extends Function0<Unit>>> r5, Function1<? super File, Unit> r6, Function0<Unit> r7) {
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Function0 r10 = (Function0) ZeusTransformUtils.wrapperContextForParams(r7, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "stagePayload");
        Intrinsics.checkNotNullParameter(r9, "sealPayload");
        Intrinsics.checkNotNullParameter(r10, "persistMetadata");
        a();
        b(this.c);
        if (this.c.mkdirs() == false) goto L15;
        this.k.invoke(this.f6140a);
        List<? extends Function0<Unit>> r11 = (List) ZeusTransformUtils.preCheckCast(r8.invoke(this.c), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        r9.invoke(this.c);     // Catch: Throwable -> L7
        String r12 = e();     // Catch: Throwable -> L7
        i();     // Catch: Throwable -> L7
        this.l.invoke(this.c, this.f6141b, this.d);     // Catch: Throwable -> L7
        r10.invoke();     // Catch: Throwable -> L7
        this.j.invoke(this.f, r12);     // Catch: Throwable -> L7
        a(this.e);     // Catch: Throwable -> L7
        this.m = r11;     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        b(this.c);
        if (this.e.exists() == true) goto L11;
    L13:
        throw th;
    L11:
        if (g() == true) goto L13;
        i();
        goto L13
    L15:
        throw new IllegalStateException(("cannot create model staging: " + this.c).toString());
    }

    public final boolean b() {
        return this.e.exists();
    }

    public final void c() {
        if (this.f.exists() == false) goto L19;
        if ((!this.e.exists()) == false) goto L17;
        d();
        this.j.invoke(this.h, "");
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.m, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r0.hasNext() == false) goto L14;
        Function0 r1 = (Function0) ZeusTransformUtils.preCheckCast(r0.next(), Function0.class, "com.obric.memorydata.plugin");
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L12
        Result.m1421constructorimpl(r1.invoke());     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    L14:
        this.m = CollectionsKt.emptyList();
        return;
    L17:
        throw new IllegalArgumentException(("cannot activate unfinished model publish: " + this.f6141b).toString());
    L19:
        throw new IllegalArgumentException(("cannot activate model without integrity seal: " + this.f6141b).toString());
    }
}
