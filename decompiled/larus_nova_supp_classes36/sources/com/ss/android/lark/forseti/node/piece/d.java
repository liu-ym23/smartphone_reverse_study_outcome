package com.ss.android.lark.forseti.node.piece;

import androidx.activity.result.ActivityResultCallback;
import androidx.fragment.app.Fragment;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d<O> implements ActivityResultCallback {
    public final /* synthetic */ ForsetiNodePiece a;
    public final /* synthetic */ Fragment b;
    public final /* synthetic */ String c;

    public d(ForsetiNodePiece r1, Fragment r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onActivityResult(Object r7) {
        Map r8 = (Map) r7;
        String[] r0 = (String[]) r8.keySet().toArray(new String[0]);
        ArrayList r2 = new ArrayList(r8.values());
        int[] r9 = new int[r2.size()];
        int r3 = r2.size();
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L9;
        if (((Boolean) ListProtector.get(r2, r4)).booleanValue() == false) goto L7;
        int r5 = 0;
    L8:
        r9[r4] = r5;
        r4 = r4 + 1;
        goto L3
    L7:
        r5 = -1;
        goto L8
    L9:
        ForsetiNodePiece.b r1 = this.a.r.pollFirst();
        if (r1 == null) goto L17;
        int r6 = r1.b;
        this.b.onRequestPermissionsResult(r6, r0, r9);
        ForsetiNodePiece.e(this.a, this.c);
        return;
    }
}
