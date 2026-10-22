package com.larus.canvas.feature.component.logic.canvasGenerator;

import com.larus.canvas.service.bean.CanvasBlock;
import com.larus.canvas.service.bean.CanvasGenerateData;
import com.larus.canvas.service.bean.CanvasImageBlock;
import com.larus.canvas.service.bean.CanvasInfo;
import com.larus.canvas.service.bean.CostTime;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c implements ny8.d<ny8.i> {
    public final /* synthetic */ String a;
    public final /* synthetic */ ny8.c b;
    public final /* synthetic */ List<CanvasBlock> c;

    @Override // ny8.d
    public final void a(ny8.b r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.i("CanvasGenerator", "getCanvasBlockInfo onFailure, localId = " + this.a + ", error = " + r4);
        this.b.b(this.c);
    }

    @Override // ny8.d
    public final void onSuccess(ny8.i r30) {
        ny8.i r1 = r30;
        Intrinsics.checkNotNullParameter(r1, "result");
        FLogger.a.i("CanvasGenerator", "getCanvasBlockInfo onSuccess, localId = " + this.a);
        ny8.c r2 = this.b;
        List<CanvasBlock> r3 = (List) r1.a.getValue();
        if (r3 == null) goto L56;
        List<CanvasBlock> r4 = this.c;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r4 == null) goto L57;
        ArrayList r5 = new ArrayList();
        Iterator r6 = r3.iterator();
    L9:
        if (r6.hasNext() == false) goto L55;
        CanvasBlock r7 = (CanvasBlock) r6.next();
        Iterator<T> r8 = r4.iterator();
    L12:
        if (r8.hasNext() == false) goto L16;
        Object r9 = r8.next();
        if (Intrinsics.areEqual(((CanvasBlock) r9).blockId, r7.blockId) == false) goto L12;
    L17:
        CanvasBlock r10 = (CanvasBlock) r9;
        CanvasImageBlock r11 = r7.content;
        if (r11 == null) goto L48;
        CanvasInfo r12 = r11.canvasInfo;
        if (r12 != null) goto L22;
        CanvasInfo r13 = null;
    L32:
        CanvasImageBlock r14 = r7.content;
        if (r14 == null) goto L46;
        CanvasGenerateData r15 = r14.generateData;
        if (r15 == null) goto L46;
        if (r10 == null) goto L44;
        CanvasImageBlock r16 = r10.content;
        if (r16 == null) goto L44;
        CanvasGenerateData r17 = r16.generateData;
        if (r17 == null) goto L44;
        String r18 = r17.modelName;
        if (r18 == null) goto L44;
    L45:
        CanvasGenerateData r19 = CanvasGenerateData.copy$default(r15, null, r18, null, null, null, 29, null);
    L47:
        CanvasImageBlock r110 = CanvasImageBlock.copy$default(r11, r13, null, null, r19, null, 22, null);
    L50:
        if (r10 == null) goto L53;
        String r20 = r10.logId;
        if (r20 == null) goto L53;
    L54:
        r5.add(CanvasBlock.copy$default(r7, null, null, r110, false, r20, 11, null));
    L53:
        r20 = r7.logId;
    L44:
        r18 = r15.modelName;
    L46:
        r19 = null;
        goto L47
    L22:
        if (r10 == null) goto L29;
        CanvasImageBlock r21 = r10.content;
        if (r21 == null) goto L29;
        CanvasInfo r22 = r21.canvasInfo;
        if (r22 == null) goto L29;
        CostTime r23 = r22.costTime;
        if (r23 == null) goto L29;
    L30:
        r13 = CanvasInfo.copy$default(r12, null, null, null, null, null, null, null, null, null, r23, null, null, null, null, null, 32255, null);
    L29:
        r23 = r12.costTime;
        goto L30
    L48:
        r110 = null;
        goto L50
    L16:
        r9 = null;
        goto L17
    L55:
        r3 = r5;
    L57:
        r2.b(r3);
        return;
    L56:
        r3 = this.c;
        goto L57
    }

    public c(String r1, ny8.c r2, List<CanvasBlock> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
