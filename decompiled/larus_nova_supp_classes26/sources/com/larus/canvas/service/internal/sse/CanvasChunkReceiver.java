package com.larus.canvas.service.internal.sse;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.canvas.service.bean.CanvasBlock;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import tx9.n0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class CanvasChunkReceiver implements e {
    public final ny8.c a;
    public final CoroutineScope b;
    public final String c;
    public List<CanvasBlock> d;
    public final Type e;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/larus/canvas/service/internal/sse/CanvasChunkReceiver$blockListType$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/larus/canvas/service/bean/CanvasBlock;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends TypeToken<List<? extends CanvasBlock>> {
        public a() {
        }
    }

    @Override // com.larus.canvas.service.internal.sse.e
    public final void a(f r19) {
        Intrinsics.checkNotNullParameter(r19, "data");
        int r2 = r19.a;
        if (r2 != 0) goto L5;
        BuildersKt.launch$default(this.b, null, null, new CanvasChunkReceiver$end$1(this, r19, null), 3, null);
        return;
    L5:
        if (r2 == 2) goto L7;
        FLogger.a.i(this.c, "error: " + r19 + "  logid = " + r19.b);
        BuildersKt.launch$default(this.b, null, null, new CanvasChunkReceiver$end$3(this, r19, null), 3, null);
        return;
    L7:
        BuildersKt.launch$default(this.b, null, null, new CanvasChunkReceiver$end$2(this, null), 3, null);
    }

    @Override // com.larus.canvas.service.internal.sse.e
    public final void b(b r10) {
        Intrinsics.checkNotNullParameter(r10, "chunkPackage");
        String r11 = r10.c;
        if (r11.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        FLogger.a.i(this.c, "rawContent is null");
        return;
    L9:
        Gson r1 = n0.a;
        com.larus.canvas.service.internal.sse.a r12 = (com.larus.canvas.service.internal.sse.a) GsonProtectorUtils.fromJson(r1, r11, com.larus.canvas.service.internal.sse.a.class);
        if (r12 == null) goto L12;
        String r3 = r12.content;
    L14:
        if (o0.d(r3) == true) goto L48;
        FLogger.a.i(this.c, "model content is null or empty");
        return;
    L48:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L17
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L17
        Object r13 = Result.constructor-impl((List) r1.fromJson(r12.content, this.e));     // Catch: Throwable -> L17
    L20:
        if (Result.isFailure-impl(r13) == false) goto L22;
        r13 = null;
    L22:
        List r14 = (List) r13;
        if (r14 != null) goto L25;
        r14 = CollectionsKt.emptyList();
    L25:
        FLogger r2 = FLogger.a;
        r2.i(this.c, "onReceive model list = " + r14);
        List r15 = r14;
        if ((true ^ r15.isEmpty()) == false) goto L45;
        List r5 = CollectionsKt.toMutableList(this.d);
        List r16 = CollectionsKt.toMutableList(r15);
        ArrayList r6 = new ArrayList();
        Iterator r7 = r5.iterator();
    L29:
        if (r7.hasNext() == false) goto L44;
        CanvasBlock r8 = (CanvasBlock) r7.next();
        Iterator r9 = r16.iterator();
    L32:
        if (r9.hasNext() == false) goto L36;
        Object r17 = r9.next();
        if (Intrinsics.areEqual(r8.blockId, ((CanvasBlock) r17).blockId) == false) goto L32;
    L37:
        CanvasBlock r18 = (CanvasBlock) r17;
        if (r18 != null) goto L39;
        r6.add(r8);
        goto L29
    L39:
        r16.remove(r18);
        if (Intrinsics.areEqual(r8.blockType, r18.blockType) == true) goto L42;
        FLogger.a.e(this.c, "current block type != new block type block id = " + r8.blockId + "  current type = " + r8.blockType + "  new type = " + r18.blockType);
    L42:
        r6.add(r18);
        goto L29
    L36:
        r17 = null;
        goto L37
    L44:
        r6.addAll(r16);
        this.d = r6;
        BuildersKt.launch$default(this.b, null, null, new CanvasChunkReceiver$dispatch$1(this, CollectionsKt.toList(r6), null), 3, null);
        return;
    L45:
        r2.i(this.c, "blocks is empty");
        return;
    L17:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L12:
        r3 = null;
        goto L14
    L5:
        r0 = false;
        goto L6
    }

    public CanvasChunkReceiver(List<CanvasBlock> r2, ny8.c r3, CoroutineScope r4) {
        Intrinsics.checkNotNullParameter(r2, "originBlocks");
        Intrinsics.checkNotNullParameter(r3, "callback");
        Intrinsics.checkNotNullParameter(r4, "mainScope");
        this.a = r3;
        this.b = r4;
        this.c = "CanvasChunkReceiver";
        this.d = CollectionsKt.toMutableList(r2);
        this.e = new a().getType();
    }
}
