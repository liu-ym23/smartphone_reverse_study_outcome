package com.bytedance.android.ec.core.imagex;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.Map;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class w0 extends BaseDataSubscriber<CloseableReference<CloseableImage>> {
    public final /* synthetic */ String a;
    public final /* synthetic */ Map b;
    public final /* synthetic */ Function2 c;

    public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r10) {
        Intrinsics.checkNotNullParameter(r10, "dataSource");
        this.c.invoke(Boolean.FALSE, null);     // Catch: Throwable -> L6
        r10.close();
        return;
    L6:
        th = move-exception;
        r10.close();
        throw th;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0042: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:16777282), block:B:20:0x0042 */
    public final void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> r10) {
        Intrinsics.checkNotNullParameter(r10, "dataSource");
        if (r10.isFinished() == true) goto L5;
        return;
    L5:
        CloseableReference r1 = null;
        CloseableReference r11 = CloseableReference.cloneOrNull((CloseableReference) r10.getResult());     // Catch: Throwable -> L21 Exception -> L23
        FirstScreenStatistic r12 = FirstScreenStatistic.S;     // Catch: Exception -> L17 Throwable -> L19
        String r13 = this.a;     // Catch: Exception -> L17 Throwable -> L19
        if (r11 == null) goto L10;
        CloseableImage r14 = (CloseableImage) r11.get();     // Catch: Exception -> L17 Throwable -> L19
    L11:
        Map r15 = this.b;     // Catch: Exception -> L17 Throwable -> L19
        r12.getClass();     // Catch: Exception -> L17 Throwable -> L19
        Bitmap r16 = FirstScreenStatistic.f(r13, r14, r15);     // Catch: Exception -> L17 Throwable -> L19
        Function2 r17 = this.c;     // Catch: Exception -> L17 Throwable -> L19
        if (r11 == null) goto L14;
        boolean r18 = true;
    L15:
        r17.invoke(Boolean.valueOf(r18), r16);     // Catch: Exception -> L17 Throwable -> L19
    L26:
        CloseableReference.closeSafely(r11);
        r10.close();
        return;
    L14:
        r18 = false;
        goto L15
    L10:
        r14 = null;
    L17:
        Exception e = e;
    L25:
        dm.a.a("FirstScreenStatistic").b("fetchBitmapByUrl failed " + e, null);     // Catch: Throwable -> L19
        FirstScreenStatistic r0 = FirstScreenStatistic.S;     // Catch: Throwable -> L19
        Map r19 = this.b;     // Catch: Throwable -> L19
        r0.getClass();     // Catch: Throwable -> L19
        FirstScreenStatistic.n("fetchBitmapByUrl", "decode image failed", e, r19);     // Catch: Throwable -> L19
        this.c.invoke(Boolean.FALSE, null);     // Catch: Throwable -> L19
        goto L26
    L19:
        th = th;
        r1 = r2;
    L28:
        CloseableReference.closeSafely(r1);
        r10.close();
        throw th;
    L23:
        e = move-exception;
        e = e;
        r11 = null;
    L21:
        th = th;
        goto L28
    }

    public w0(String r1, Map r10, Function2 r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }
}
