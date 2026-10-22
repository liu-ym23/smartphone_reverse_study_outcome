package com.ss.android.lark.forseti.node.piece;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b<O> implements ActivityResultCallback {
    public final /* synthetic */ ForsetiNodePiece a;
    public final /* synthetic */ Fragment b;
    public final /* synthetic */ String c;

    public b(ForsetiNodePiece r1, Fragment r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onActivityResult(Object r4) {
        ActivityResult r5 = (ActivityResult) r4;
        ForsetiNodePiece.b r0 = this.a.r.pollFirst();
        if (r0 == null) goto L7;
        int r1 = r0.b;
        this.b.onActivityResult(r1, r5.getResultCode(), r5.getData());
        ForsetiNodePiece.e(this.a, this.c);
        return;
    }
}
