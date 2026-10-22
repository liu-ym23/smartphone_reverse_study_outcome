package com.larus.camera.api;

import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import com.larus.camera.api.params.InputParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class IFlowCamera$a {
    public static /* synthetic */ void a(IFlowCamera r12, FragmentActivity r13, String r14, String r15, Uri r16, boolean r17, boolean r18, InputParam r19, int r20) {
        if ((r20 & 32) == 0) goto L5;
        boolean r8 = false;
    L7:
        if ((r20 & 64) == 0) goto L9;
        boolean r9 = false;
    L11:
        if ((r20 & 256) == 0) goto L13;
        InputParam r10 = null;
    L14:
        r12.e(r13, r14, r15, r16, r8, r9, r10, null);
        return;
    L13:
        r10 = r19;
        goto L14
    L9:
        r9 = r18;
        goto L11
    L5:
        r8 = r17;
        goto L7
    }
}
