package com.ss.android.lark.movable.utils;

import android.app.Application;
import com.bytedance.lark.lark_markdown_render_android.MovableDocumentInfo;
import com.google.gson.Gson;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.movable.utils.TypewriterRecorder$onRender$1", f = "TypewriterRecorder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class TypewriterRecorder$onRender$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ byte[] $attachData;
    final /* synthetic */ MovableDocumentInfo $documentInfo;
    final /* synthetic */ List<Pair<Integer, byte[]>> $islandResults;
    final /* synthetic */ byte[] $islandsData;
    final /* synthetic */ String $recordId;
    final /* synthetic */ byte[] $textData;
    int label;

    public TypewriterRecorder$onRender$1(String r1, MovableDocumentInfo r2, byte[] r3, byte[] r4, byte[] r5, List<Pair<Integer, byte[]>> r6, Continuation<? super TypewriterRecorder$onRender$1> r7) {
        this.$recordId = r1;
        this.$documentInfo = r2;
        this.$textData = r3;
        this.$attachData = r4;
        this.$islandsData = r5;
        this.$islandResults = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new TypewriterRecorder$onRender$1(this.$recordId, this.$documentInfo, this.$textData, this.$attachData, this.$islandsData, this.$islandResults, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r26) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L51;
        ResultKt.throwOnFailure(r26);
        VFSFiles r0 = VFSFiles.b;
        Gson r2 = f.a;
        LarkAppContext.Companion.getClass();
        Application r3 = LarkAppContext.access$getInstance$cp().getContext();
        File r4 = r3.getExternalFilesDir(null);
        if (r4 != null) goto L7;
        r4 = r3.getFilesDir();
    L7:
        Intrinsics.checkNotNull(r4);
        VFSFile r5 = r0.D(r4, "typewriter_records");
        if (r5.exists() == true) goto L10;
        r5.mkdirs();
    L10:
        VFSFile r1 = r0.D(r5, this.$recordId);
        if (r1.exists() == true) goto L13;
        r1.mkdirs();
        f.d.put(this.$recordId, Boxing.boxInt(0));
    L13:
        Integer r6 = (Integer) ((LinkedHashMap) f.d).get(this.$recordId);
        if (r6 == null) goto L16;
        int r7 = r6.intValue();
    L17:
        String r8 = this.$recordId;
        MovableDocumentInfo r9 = this.$documentInfo;
        byte[] r10 = this.$textData;
        byte[] r11 = this.$attachData;
        byte[] r12 = this.$islandsData;
        List<Pair<Integer, byte[]>> r13 = this.$islandResults;
        long r14 = System.currentTimeMillis();
        Map<String, Long> r15 = f.b;
        Long r16 = (Long) ((LinkedHashMap) r15).get(r8);
        long r17 = 0;
        if (r16 == null) goto L20;
        long r18 = r16.longValue();
    L21:
        if (r7 == 0) goto L24;
        r17 = r14 - r18;
    L24:
        long r19 = r17;
        r15.put(r8, Long.valueOf(r14));
        ArrayList r20 = new ArrayList();
        Iterator<T> r110 = r13.iterator();
    L25:
        boolean r111 = true;
        if (r110.hasNext() == false) goto L33;
        Object r112 = r110.next();
        if (((Pair) r112).getSecond() != null) goto L31;
        r111 = false;
    L31:
        if (r111 == false) goto L25;
        r20.add(r112);
        goto L25
    L33:
        int r21 = r9.getDocumentId-pVg5ArA();
        int r22 = r9.getDocumentVersion-pVg5ArA();
        float r23 = r9.getWidth();
        float r24 = r9.getHeight();
        ArrayList r25 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r20, 10));
        Iterator r27 = r20.iterator();
    L35:
        if (r27.hasNext() == false) goto L37;
        r25.add(Integer.valueOf(((Number) ((Pair) r27.next()).getFirst()).intValue()));
        goto L35
    L37:
        f.a r28 = new f.a(r19, r21, r22, r23, r24, r25);
        VFSFiles r29 = VFSFiles.b;     // Catch: Exception -> L46
        VFSFile r30 = r29.D(r1, "frame_" + r7);     // Catch: Exception -> L46
        if (r30.exists() == true) goto L41;
        r30.mkdirs();     // Catch: Exception -> L46
    L41:
        FilesKt.writeText$default(r29.D(r30, "meta.json"), f.a.toJson(r28), null, 2, null);     // Catch: Exception -> L46
        r29.D(r30, "text.bin").writeBytes(r10);     // Catch: Exception -> L46
        r29.D(r30, "attach.bin").writeBytes(r11);     // Catch: Exception -> L46
        r29.D(r30, "islands.bin").writeBytes(r12);     // Catch: Exception -> L46
        Iterator r31 = r20.iterator();     // Catch: Exception -> L46
    L42:
        if (r31.hasNext() == false) goto L48;
        Pair r32 = (Pair) r31.next();     // Catch: Exception -> L46
        int r33 = ((Number) r32.component1()).intValue();     // Catch: Exception -> L46
        VFSFiles.b.D(r30, "island_" + r33 + ".bin").writeBytes((byte[]) r32.component2());     // Catch: Exception -> L46
    L48:
        f.d.put(this.$recordId, Boxing.boxInt(r7 + 1));
        return Unit.INSTANCE;
    L46:
        e = move-exception;
        Log.e("TypewriterRecorder", "Failed to record frame: " + e.getMessage());
        goto L48
    L20:
        r18 = 0;
        goto L21
    L16:
        r7 = 0;
        goto L17
    L51:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
