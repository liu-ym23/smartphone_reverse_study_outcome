package com.bytedance.gkfs.io;

import com.google.common.reflect.w;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.UByte;
import kotlin.jvm.functions.Function2;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f4869c;

    public /* synthetic */ g(int r5, Object r10, Object r11) {
        this.f4867a = r5;
        this.f4868b = r10;
        this.f4869c = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f4867a) {
            case 0: goto L34;
            default: goto L4;
        };
    L4:
        Iterator r5 = ((LinkedHashMap) this.f4868b).entrySet().iterator();
    L6:
        if (r5.hasNext() == false) goto L33;
        Map.Entry r10 = (Map.Entry) r5.next();
        c r11 = (c) r10.getKey();
        w r12 = (w) this.f4869c;
        File r13 = (File) r12.f9376b;
        n r14 = n.d;
        com.bytedance.gkfs.cdc.c r15 = ((com.bytedance.gkfs.cdc.b) r12.d).d;
        com.bytedance.gkfs.storage.e r16 = (com.bytedance.gkfs.storage.e) r10.getValue();
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L14
        if (r14.f4895a == true) goto L6;
        JSONObject r18 = new JSONObject();     // Catch: Throwable -> L14
        r18.put("source_file", r13.getAbsolutePath());     // Catch: Throwable -> L14
        r18.put("id", r11.f4858a);     // Catch: Throwable -> L14
        r18.put("stats", r14.f4897c.f4849a);     // Catch: Throwable -> L14
        Throwable r19 = r14.f4896b;     // Catch: Throwable -> L14
        if (r19 == null) goto L16;
        r18.put("error_msg", r19.getMessage() + ", cause:" + r19.getCause());     // Catch: Throwable -> L14
    L16:
        r18.put("cdc_cost", r15.d.get(r11));     // Catch: Throwable -> L14
        r18.put("cdc_total_cost", r15.e.get(r11));     // Catch: Throwable -> L14
        if (r16 == null) goto L20;
        r18.put("origin_size", r16.f4928i);     // Catch: Throwable -> L14
        r18.put("diluted_size", ((Number) r16.f4924a.getValue()).intValue());     // Catch: Throwable -> L14
        r18.put("lock_cost", r16.f);     // Catch: Throwable -> L14
        r18.put("indexing_cost", r16.e.f);     // Catch: Throwable -> L14
        r18.put("write_cost", r16.g);     // Catch: Throwable -> L14
        r18.put("total_cost", r16.f4927h);     // Catch: Throwable -> L14
    L20:
        Object r20 = Result.m124constructorimpl(r18);     // Catch: Throwable -> L14
    L24:
        if (Result.m131isSuccessimpl(r20) == false) goto L26;
        com.lynx.tasm.utils.j.g("geckosdk_gkfs_chunk_store_stats", (JSONObject) r20);
    L26:
        Throwable r21 = Result.m127exceptionOrNullimpl(r20);
        if (r21 == null) goto L30;
        r21.printStackTrace();
    L30:
        if (Result.m130isFailureimpl(r20) == false) goto L32;
        r20 = null;
    L32:
        JSONObject r22 = (JSONObject) r20;
    L14:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r20 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L24
    L33:
        return;
    L34:
        com.bytedance.gkfs.d.c(((h) this.f4868b).f4873h, "ChunkMetaDecoder", "start parallel decode, chunk count:" + ((h) this.f4868b).g + ", fetchIndex=" + ((h) this.f4868b).d, 0, 12);
        h r24 = (h) this.f4868b;
        int r25 = r24.f.length + (-44);
        int r26 = r24.g + (-1);
    L35:
        if (r26 < 0) goto L56;
        if (((h) this.f4868b).f4871b.get() == true) goto L38;
        if (r26 <= ((h) this.f4868b).d) goto L41;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L47
        byte[] r28 = ((h) this.f4868b).f;     // Catch: Throwable -> L47
        StringBuilder r29 = new StringBuilder(40);     // Catch: Throwable -> L47
        int r110 = 0;
    L43:
        if (r110 >= 40) goto L45;
        r29.append((char) (r28[r25 + r110] & UByte.MAX_VALUE));     // Catch: Throwable -> L47
        r110 = r110 + 1;     // Catch: Throwable -> L47
        goto L43
    L45:
        c r30 = new c(r29.toString());     // Catch: Throwable -> L47
        int r31 = o.a(((h) this.f4868b).f, r25 + 40);     // Catch: Throwable -> L47
        r25 = r25 - 44;     // Catch: Throwable -> L47
        Object r32 = Result.m124constructorimpl(new f(r30, ((long) r31) & 4294967295L));     // Catch: Throwable -> L47
    L50:
        if (Result.m131isSuccessimpl(r32) == false) goto L52;
        ((h) this.f4868b).f4872c.put(Integer.valueOf(r26), (f) r32);
    L52:
        Throwable r111 = Result.m127exceptionOrNullimpl(r32);
        if (r111 == null) goto L55;
        com.bytedance.gkfs.d.d(((h) this.f4868b).f4873h, "ChunkMetaDecoder", androidx.room.jarjarred.org.antlr.runtime.a.x(r111, new StringBuilder("parallel decode error, cause:")), r111, false, 20);
        ((h) this.f4868b).close();
    L55:
        ResultKt.throwOnFailure(r32);
        Function2 r33 = (Function2) this.f4869c;
        GkFSChunkReader$2 r34 = (GkFSChunkReader$2) r33;
        r34.mo2invoke(Integer.valueOf(r26), (f) r32);
        r26 = r26 - 1;
    L47:
        th = move-exception;
        Result.Companion r35 = Result.Companion;
        r32 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L50
    L41:
        com.bytedance.gkfs.d r36 = ((h) this.f4868b).f4873h;
        StringBuilder r37 = com.lynx.tasm.p.d(r26, "quit parallel decoding, paraIndex:", ", fetchIndex=");
        r37.append(((h) this.f4868b).d);
        com.bytedance.gkfs.d.c(r36, "ChunkMetaDecoder", r37.toString(), 0, 12);
        goto L56
    L38:
        com.bytedance.gkfs.d.f(((h) this.f4868b).f4873h, "ChunkMetaDecoder", "stop parallel decode cause closed, " + ((h) this.f4868b).f4872c.size() + " has been decoded.", 0, 28);
    L56:
        com.bytedance.gkfs.d.c(((h) this.f4868b).f4873h, "ChunkMetaDecoder", "parallel decode&IO finished", 0, 12);
    }
}
