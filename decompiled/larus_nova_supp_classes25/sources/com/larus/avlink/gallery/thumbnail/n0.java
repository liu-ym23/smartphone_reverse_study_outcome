package com.larus.avlink.gallery.thumbnail;

import com.google.gson.Gson;
import com.larus.avlink.api.model.DoraEvent;
import com.larus.avlink.e.DoraImageEvent;
import com.larus.avlink.e.DoraImageManager;
import com.larus.dora.api.model.FlowDoraSubBizType;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n0 implements h49.d {
    public n0() {
    }

    public final void a(int r1) {
    }

    public final void b(int r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11, int r12, int r13, int r14, long r15, int r17, int r18, int r19) {
    }

    public final void j(boolean r1, int r2, byte r3) {
    }

    /* JADX WARN: Type inference failed for: r10v0, types: [com.larus.avlink.gallery.thumbnail.m0] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.larus.avlink.gallery.thumbnail.l0] */
    public final void d(b49.g r25) {
        FLogger r0 = FLogger.a;
        StringBuilder r2 = new StringBuilder("onDataFrame scene: ");
        String r3 = null;
        if (r25 == null) goto L5;
        Integer r4 = Integer.valueOf(r25.b);
    L6:
        r2.append(r4);
        r2.append(" stage: ");
        if (r25 == null) goto L9;
        Integer r5 = Integer.valueOf(r25.a);
    L10:
        r2.append(r5);
        r2.append(" id: ");
        if (r25 == null) goto L13;
        Integer r6 = Integer.valueOf(r25.h);
    L14:
        r2.append(r6);
        r2.append(" id: ");
        if (r25 == null) goto L17;
        Integer r7 = Integer.valueOf(r25.c);
    L18:
        r2.append(r7);
        r0.i("ThumbnailManager", r2.toString());
        if (r25 != null) goto L21;
        return;
    L21:
        byte[] r1 = r25.i;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Map r8 = (Map) new Gson().fromJson(new String(r1, Charsets.UTF_8), new com.larus.avlink.gallery.b().getType());     // Catch: Exception -> L24
    L26:
        final Map r9 = r8;
        Intrinsics.checkNotNull(r9);
        boolean r10 = false;
        if (r25.b == 1) goto L29;
    L31:
        boolean r11 = false;
    L32:
        if (r11 == false) goto L60;
        final int r12 = r25.h;
        int r13 = r25.a;
        if (r13 != 1) goto L36;
        Map<String, com.larus.avlink.model.a> r14 = DoraImageManager.a;
        com.larus.avlink.model.a r15 = new com.larus.avlink.model.a(Integer.valueOf(r12), 0, 0, 2, 20, 20, Long.valueOf(System.currentTimeMillis()), null, 1073205056, 63);
        r15.c(DoraImageEvent.IMAGE_TAKE_START, true, System.currentTimeMillis());
        Intrinsics.checkNotNullParameter(r15, "model");
        DoraImageManager.a.put(String.valueOf(r15.a), r15);
        Lazy r16 = ia8.m.a;
        DoraEvent r17 = DoraEvent.OCRStart;
        r17.setExtra("imageUuid: " + r12);
        ia8.m.b(r17);
        return;
    L36:
        if (r13 != 3) goto L62;
        String r18 = new String(r25.g, Charsets.UTF_8);
        Map<String, com.larus.avlink.model.a> r19 = DoraImageManager.a;
        com.larus.avlink.model.a r20 = DoraImageManager.a(Integer.valueOf(r12));
        if (r20 == null) goto L41;
        r20.u = Long.valueOf(System.currentTimeMillis());
    L41:
        FLogger r110 = FLogger.a;
        StringBuilder r21 = new StringBuilder("onDataFrame FINISH: imageModel: ");
        r21.append(r20);
        r21.append(", mode: ");
        if (r20 == null) goto L44;
        Integer r22 = r20.n;
    L45:
        r21.append(r22);
        r110.i("ThumbnailManager", r21.toString());
        if (r20 == null) goto L48;
        f98.r r23 = new f98.r();
        r23.c(1);
        r23.a(r18);
        f98.s r24 = new f98.s();
        r24.a(String.valueOf(r12));
        r24.b(2);
        r23.d(r24);
        List r26 = CollectionsKt.listOf(r23);
        Lazy r27 = ia8.m.a;
        DoraEvent r28 = DoraEvent.OCRUploadStart;
        r28.setExtra("imageUuid: " + r12);
        ia8.m.b(r28);
        com.larus.avlink.e.m r29 = com.larus.avlink.e.m.a;
        FlowDoraSubBizType.Companion.getClass();
        com.larus.avlink.e.m.b(r12, r26, r9, FlowDoraSubBizType.a.a(), new l0(), new m0(r12, r9));
    L48:
        if (r20 != null) goto L50;
    L52:
        if (r10 == true) goto L55;
        r3 = r18;
    L55:
        Lazy r30 = ia8.m.a;
        DoraEvent r31 = DoraEvent.OCREnd;
        r31.setExtra("imageUuid: " + r12 + ", ocrData: " + r3);
        ia8.m.b(r31);
        r110.i("ThumbnailManager", "onDataFrame FINISH: ocrResult: ".concat(r18));
        return;
    L50:
        if (r20.m != 2) goto L52;
        r10 = true;
        goto L52
    L44:
        r22 = null;
        goto L45
    L62:
        return;
    L60:
        return;
    L29:
        if (Intrinsics.areEqual(r9.get("result_scene"), Double.valueOf(2.0d)) == false) goto L31;
        r11 = true;
    L24:
        e = move-exception;
        FLogger.a.e("MediaSyncExecutor", "Failed to parse JSON: " + e.getMessage(), e);
        r8 = MapsKt.emptyMap();
        goto L26
    L17:
        r7 = null;
        goto L18
    L13:
        r6 = null;
        goto L14
    L9:
        r5 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    public final void w(b49.k r2) {
        Intrinsics.checkNotNullParameter(r2, "trackInfo");
    }

    public final void c(b49.h r1, b49.d r2) {
        Intrinsics.checkNotNullParameter(r1, "doraImageInfo");
    }
}
