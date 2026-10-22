package com.larus.dora.impl.log.g;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.content.FileProvider;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import java.io.BufferedOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.log.g.DoraGLogManager$exportLog$1", f = "DoraGLogManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraGLogManager$exportLog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: renamed from: com.larus.dora.impl.log.g.DoraGLogManager$exportLog$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.log.g.DoraGLogManager$exportLog$1$2", f = "DoraGLogManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ File $outputFile;
        int label;

        public AnonymousClass2(File r1, Continuation<? super AnonymousClass2> r2) {
            this.$outputFile = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.$outputFile, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r5);
            AppHost.Companion r6 = AppHost.a;
            Uri r0 = FileProvider.getUriForFile(r6.getApplication().getApplicationContext(), r6.getApplication().getApplicationContext().getPackageName() + ".dora.impl.log.fileprovider", this.$outputFile);
            Intent r1 = new Intent("android.intent.action.SEND");
            r1.setType("application/zip");
            r1.putExtra("android.intent.extra.STREAM", r0);
            r1.addFlags(1);
            r1.addFlags(268435456);
            Context r2 = r6.getApplication().getApplicationContext();
            Intent r7 = Intent.createChooser(r1, r6.getApplication().getString(2131903365));
            r7.addFlags(268435456);
            r2.startActivity(r7);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public DoraGLogManager$exportLog$1(Continuation<? super DoraGLogManager$exportLog$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new DoraGLogManager$exportLog$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r21) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L119;
        ResultKt.throwOnFailure(r21);
        PolarisFileWrapper r2 = new PolarisFileWrapper(DoraGLogManager.a.o());
        int r3 = 2;
        if (r2.exists() == true) goto L8;
        g49.d.b("DoraGLogManager", "srcDir not exists");
        s r0 = s.a;
        Application r4 = AppHost.a.getApplication();
        r0.getClass();
        s.b(r4, 2131904028, false);
        Pair r1 = new Pair(CollectionsKt.emptyList(), null);
    L87:
        List r5 = (List) r1.component1();
        File r6 = (File) r1.component2();
        if (r5.isEmpty() == true) goto L116;
        if (r6 == null) goto L116;
        PolarisFileWrapper r7 = new PolarisFileWrapper(StringsKt.dropLast(DoraGLogManager.a.o(), 1) + ".zip");
        ZipOutputStream r8 = new ZipOutputStream(new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r7)));
        Iterator r9 = r5.iterator();     // Catch: Throwable -> L110
    L94:
        if (r9.hasNext() == false) goto L107;
        File r10 = (File) r9.next();     // Catch: Throwable -> L110
        r8.putNextEntry(new ZipEntry(r6.toURI().relativize(r10.toURI()).getPath()));     // Catch: Throwable -> L110
        PolarisFileInputStreamWrapper r11 = new PolarisFileInputStreamWrapper(r10);     // Catch: Throwable -> L110
        ByteStreamsKt.copyTo$default(r11, r8, 0, 2, null);     // Catch: Throwable -> L100
        CloseableKt.closeFinally(r11, null);     // Catch: Throwable -> L110
        r8.closeEntry();     // Catch: Throwable -> L110
        goto L94
    L100:
        th = move-exception;
        throw th;     // Catch: Throwable -> L103
    L103:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);     // Catch: Throwable -> L110
        throw th;     // Catch: Throwable -> L110
    L107:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L110
        CloseableKt.closeFinally(r8, null);
        FilesKt.deleteRecursively(r6);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass2(r7, null), 3, null);
        return Unit.INSTANCE;
    L110:
        th = move-exception;
        throw th;     // Catch: Throwable -> L113
    L113:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);
        throw th;
    L116:
        s r13 = s.a;
        Application r14 = AppHost.a.getApplication();
        r13.getClass();
        s.b(r14, 2131904028, false);
        return Unit.INSTANCE;
    L8:
        if (r2.exists() == true) goto L10;
    L78:
        PolarisFileWrapper r15 = null;
    L79:
        if (r15 != null) goto L81;
    L86:
        g49.d.b("DoraGLogManager", "processedLogDir not exists");
        s r16 = s.a;
        Application r17 = AppHost.a.getApplication();
        r16.getClass();
        s.b(r17, 2131904028, false);
        r1 = new Pair(CollectionsKt.emptyList(), null);
        goto L87
    L81:
        if (r15.exists() == false) goto L86;
        if (r15.isDirectory() == false) goto L86;
        r1 = new Pair(SequencesKt.toList(SequencesKt.filter(FilesKt.walkTopDown(r15), new c())), r15);
        goto L87
    L10:
        if (r2.isDirectory() == false) goto L78;
        String r18 = AppHost.a.getApplication().getApplicationContext().getFilesDir() + "/DoraSDK/DoraGLogTmp/";
        r15 = new PolarisFileWrapper(r18);
        if (r15.exists() == false) goto L16;
        FilesKt.deleteRecursively(r15);
    L16:
        if (r15.mkdirs() == false) goto L78;
        if (r15.exists() == true) goto L21;
    L77:
        g49.d.b("DoraGLogManager", "Destination directory is not accessible or writable: " + r15.getAbsolutePath());
        goto L78
    L21:
        if (r15.canWrite() == false) goto L77;
        File[] r20 = r2.listFiles();
        if (r20 == null) goto L35;
        LinkedHashMap r110 = new LinkedHashMap();
        int r111 = r20.length;
        int r112 = 0;
    L26:
        if (r112 >= r111) goto L36;
        File r113 = r20[r112];
        List r114 = StringsKt.split$default(r113.getName(), new String[]{"_"}, false, 0, 6, null);
        if (r114.size() != 5) goto L30;
        String r22 = ((String) ListProtector.get(r114, 1)) + '_' + ((String) ListProtector.get(r114, r3)) + '_' + ((String) ListProtector.get(r114, 3)) + '_' + ((String) ListProtector.get(r114, 4));
    L31:
        Object r23 = r110.get(r22);
        if (r23 != null) goto L34;
        r23 = new ArrayList();
        r110.put(r22, r23);
    L34:
        ((List) r23).add(r113);
        r112 = r112 + 1;
        r3 = 2;
        goto L26
    L30:
        g49.d.b("DoraGLogManager", "parts size is not 5");
        r22 = Unit.INSTANCE;
    L36:
        if (r110 == null) goto L79;
        Iterator r24 = r110.entrySet().iterator();
    L39:
        if (r24.hasNext() == false) goto L79;
        Map.Entry r25 = (Map.Entry) r24.next();
        Object r26 = r25.getKey();
        List r27 = CollectionsKt.sortedWith((List) r25.getValue(), new i());
        PolarisFileOutputStreamWrapper r28 = new PolarisFileOutputStreamWrapper(new PolarisFileWrapper(r18, "DoraGLog_" + r26), true);
        BufferedOutputStream r115 = new BufferedOutputStream(r28);     // Catch: Throwable -> L71
        Iterator r30 = r27.iterator();     // Catch: Throwable -> L64
    L44:
        if (r30.hasNext() == false) goto L61;
        File r116 = (File) r30.next();     // Catch: Throwable -> L64
        Intrinsics.checkNotNull(r116);     // Catch: Throwable -> L64
        PolarisFileInputStreamWrapper r117 = new PolarisFileInputStreamWrapper(r116);     // Catch: Throwable -> L64
        byte[] r118 = new byte[1024];     // Catch: Throwable -> L54
    L48:
        int r119 = r117.read(r118);     // Catch: Throwable -> L54
        if (r119 <= 0) goto L51;
        r115.write(r118, 0, r119);     // Catch: Throwable -> L54
        goto L48
    L51:
        Unit r120 = Unit.INSTANCE;     // Catch: Throwable -> L54
        CloseableKt.closeFinally(r117, null);     // Catch: Throwable -> L64
        goto L44
    L54:
        th = move-exception;
        throw th;     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        CloseableKt.closeFinally(r117, th);     // Catch: Throwable -> L64
        throw th;     // Catch: Throwable -> L64
    L61:
        Unit r31 = Unit.INSTANCE;     // Catch: Throwable -> L64
        CloseableKt.closeFinally(r115, null);     // Catch: Throwable -> L71
        CloseableKt.closeFinally(r28, null);
    L64:
        th = move-exception;
        throw th;     // Catch: Throwable -> L67
    L67:
        th = move-exception;
        CloseableKt.closeFinally(r115, th);     // Catch: Throwable -> L71
        throw th;     // Catch: Throwable -> L71
    L71:
        th = move-exception;
        throw th;     // Catch: Throwable -> L74
    L74:
        th = move-exception;
        CloseableKt.closeFinally(r28, th);
        throw th;
    L35:
        r110 = null;
        goto L36
    L119:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
