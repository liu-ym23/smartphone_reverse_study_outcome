package com.larus.vesdk.impl.camera;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.vesdk.impl.camera.VeCameraDiskCleaner$cleanAsync$1", f = "VeCameraDiskCleaner.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
public final class VeCameraDiskCleaner$cleanAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $dirPath;
    final /* synthetic */ String $videoPath;
    int label;

    public VeCameraDiskCleaner$cleanAsync$1(String r1, String r2, Continuation<? super VeCameraDiskCleaner$cleanAsync$1> r3) {
        this.$dirPath = r1;
        this.$videoPath = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new VeCameraDiskCleaner$cleanAsync$1(this.$dirPath, this.$videoPath, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L11:
        int r15 = VeCameraDiskCleaner.a;
        String r16 = this.$dirPath;
        int r3 = VeCameraDiskCleaner.a;
        if (r16 != null) goto L14;
    L17:
        boolean r4 = true;
    L18:
        long r5 = 0;
        if (r4 == false) goto L21;
        ArrayList r17 = new ArrayList();
    L31:
        FLogger.a.i("VeCameraDiskCleaner", "Step 1: collect old files to delete: " + r17.size());
        Iterator r6 = r17.iterator();
    L33:
        if (r6.hasNext() == false) goto L35;
        File r7 = (File) r6.next();
        int r8 = VeCameraDiskCleaner.a;
        VeCameraDiskCleaner.a(r7.getPath());
        goto L33
    L35:
        int r9 = VeCameraDiskCleaner.a;
        String r10 = this.$videoPath;
        if (r10 != null) goto L38;
    L41:
        boolean r11 = true;
    L42:
        if (r11 == false) goto L44;
        ArrayList r12 = new ArrayList();
    L48:
        FLogger.a.i("VeCameraDiskCleaner", "Step 2: collect remaining video files to delete by count: " + r12.size());
        Iterator r13 = r12.iterator();
    L50:
        if (r13.hasNext() == false) goto L52;
        File r18 = (File) r13.next();
        int r19 = VeCameraDiskCleaner.a;
        VeCameraDiskCleaner.a(r18.getPath());
        goto L50
    L52:
        int r20 = VeCameraDiskCleaner.a;
        String r21 = this.$videoPath;
        if (r21 != null) goto L55;
    L58:
        if (r2 == false) goto L60;
        ArrayList r22 = new ArrayList();
    L74:
        FLogger.a.i("VeCameraDiskCleaner", "Step 3: collect remaining video files to delete by size: " + r22.size());
        Iterator r23 = r22.iterator();
    L76:
        if (r23.hasNext() == false) goto L78;
        File r24 = (File) r23.next();
        int r25 = VeCameraDiskCleaner.a;
        VeCameraDiskCleaner.a(r24.getPath());
        goto L76
    L78:
        FLogger.a.i("VeCameraDiskCleaner", "Clean completed: " + ((r17.size() + r12.size()) + r22.size()) + " files deleted");
        return Unit.INSTANCE;
    L60:
        List r26 = CollectionsKt.sortedWith(VeCameraDiskCleaner.c(new PolarisFileWrapper(r21)), new b());
        ArrayList r27 = new ArrayList();
        Iterator r28 = r26.iterator();
    L62:
        if (r28.hasNext() == false) goto L65;
        r5 = r5 + ((File) r28.next()).length();
        goto L62
    L65:
        if (r5 <= 52428800) goto L73;
        Iterator r29 = r26.iterator();
        long r30 = r5;
    L68:
        if (r29.hasNext() == false) goto L72;
        File r31 = (File) r29.next();
        if (r30 <= 52428800) goto L72;
        r27.add(r31);
        r30 = r30 - r31.length();
    L72:
        FLogger.a.i("VeCameraDiskCleaner", "Video size exceeded: " + (r5 / 1048576) + "MB > 50MB, will delete " + r27.size() + " files");
    L73:
        r22 = r27;
        goto L74
    L55:
        if (r21.length() == 0) goto L58;
        r2 = false;
        goto L58
    L44:
        List r32 = CollectionsKt.sortedWith(VeCameraDiskCleaner.c(new PolarisFileWrapper(r10)), new a());
        ArrayList r33 = new ArrayList();
        if (r32.size() <= 20) goto L47;
        int r34 = r32.size() - 20;
        r33.addAll(CollectionsKt.take(r32, r34));
        FLogger.a.i("VeCameraDiskCleaner", "Video count exceeded: " + r32.size() + " > 20, will delete " + r34 + " oldest files");
    L47:
        r12 = r33;
        goto L48
    L38:
        if (r10.length() == 0) goto L41;
        r11 = false;
        goto L42
    L21:
        ArrayList r35 = new ArrayList();
        List r110 = VeCameraDiskCleaner.c(new PolarisFileWrapper(r16));
        FLogger r36 = FLogger.a;
        StringBuilder r37 = new StringBuilder("[collectAllFilesDateAgo] fileList:");
        ArrayList r111 = (ArrayList) r110;
        r37.append(r111.size());
        r36.i("VeCameraDiskCleaner", r37.toString());
        if (r111.isEmpty() == true) goto L30;
        Iterator r112 = r111.iterator();
    L26:
        if (r112.hasNext() == false) goto L30;
        File r38 = (File) r112.next();
        if ((Math.abs(System.currentTimeMillis() - r38.lastModified()) - ((long) (86400000 * r3))) <= 0) goto L26;
        r35.add(r38);
    L30:
        r17 = r35;
        goto L31
    L14:
        if (r16.length() == 0) goto L17;
        r4 = false;
        goto L18
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        this.label = 1;
        if (DelayKt.delay(1000, this) != r0) goto L11;
        return r0;
    }
}
