package com.larus.vesdk.impl.utils;

import com.larus.platform.api.c4;
import com.larus.utils.logger.FLogger;
import com.ss.android.vesdk.VEEditor;
import com.ss.android.vesdk.VEListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class q implements VEListener.VEEditorCompileListener {
    public final /* synthetic */ c4.c a;
    public final /* synthetic */ String b;
    public final /* synthetic */ VEEditor c;
    public final /* synthetic */ String d;

    public final void onCompileDone() {
        FLogger.a.i("VideoEditProcessor", "[onCompileDone] outPath:" + this.d);
        this.a.onCompileDone();
        VideoEditProcessor.a.remove(this.b);
        VideoEditProcessor.a(this.c, 100);
    }

    public final void onCompileProgress(float r2) {
        this.a.onCompileProgress(r2);
    }

    public q(com.larus.bmhome.upload.k r1, String r2, VEEditor r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void onCompileError(int r2, int r3, float r4, String r5) {
        FLogger.a.e("VideoEditProcessor", "[onCompileError] " + r2 + ':' + r5);
        this.a.a(r2, r5);
        VideoEditProcessor.a.remove(this.b);
        VideoEditProcessor.a(this.c, 0);
    }
}
