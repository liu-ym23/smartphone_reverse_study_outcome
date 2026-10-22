package com.larus.dora.impl.serviceimpl;

import b49.a;
import com.google.gson.Gson;
import com.larus.dora.api.model.AlbumNotify;
import com.larus.dora.impl.core.z0;
import com.larus.utils.logger.FLogger;
import h49.f;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class y extends z0 {
    public final /* synthetic */ VisionService a;

    public y(VisionService r1) {
        this.a = r1;
    }

    @Override // com.larus.dora.impl.core.z0
    public final void c(int r4, int r5, int r6, byte[] r7, int r8, byte[] r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r7, "data");
        Intrinsics.checkNotNullParameter(r9, "assData");
        FLogger r11 = FLogger.a;
        r11.i("VisionService", "VisionService onDataNotify dataId: " + r4 + ", scene: " + r5 + ", type: " + r6 + ", assId: " + r8 + ", frameLoss: " + r10);
        if (r5 != 2) goto L27;
        String r12 = new String(r7, Charsets.UTF_8);     // Catch: Exception -> L21
        r11.i("VisionService", "VisionService onDataNotify string: ".concat(r12));     // Catch: Exception -> L21
        AlbumNotify r13 = (AlbumNotify) new Gson().fromJson(r12, AlbumNotify.class);     // Catch: Exception -> L21
        if (r13 == null) goto L16;
        a r14 = r13.getCount();     // Catch: Exception -> L21
        if (r14 == null) goto L16;
        VisionService r15 = this.a;     // Catch: Exception -> L21
        Integer r0 = r14.a();     // Catch: Exception -> L21
        int r1 = 0;
        if (r0 == null) goto L11;
        int r2 = r0.intValue();     // Catch: Exception -> L21
    L12:
        Integer r16 = r14.b();     // Catch: Exception -> L21
        if (r16 == null) goto L15;
        r1 = r16.intValue();     // Catch: Exception -> L21
    L15:
        VisionService.e(r15, r2, r1);     // Catch: Exception -> L21
        goto L16
    L11:
        r2 = 0;
    L16:
        Iterator r17 = this.a.b.iterator();     // Catch: Exception -> L21
    L17:
        if (r17.hasNext() == false) goto L28;
        f r18 = (f) r17.next();     // Catch: Exception -> L21
        Intrinsics.checkNotNull(r13);     // Catch: Exception -> L21
        r18.a(r4, r5, r8, r13);     // Catch: Exception -> L21
        goto L17
    L28:
        return;
    L21:
        e = move-exception;
        FLogger.a.e("VisionService", "VisionService onDataReceive failed.", e);
        return;
    }
}
