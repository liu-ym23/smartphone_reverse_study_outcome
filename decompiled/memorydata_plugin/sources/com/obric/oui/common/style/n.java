package com.obric.oui.common.style;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0014\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"isAllSameValue", "", "", "OUI_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class n {
    public static final /* synthetic */ boolean a(float[] r0) {
        return b(r0);
    }

    private static final boolean b(float[] r6) {
        if (r6.length != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return true;
    L8:
        float r1 = r6[0];
        int r3 = r6.length;
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L19;
        if (r6[r4] != r1) goto L13;
        boolean r5 = true;
    L15:
        if ((!r5) == true) goto L22;
        r4 = r4 + 1;
        goto L9
    L22:
        return false;
    L13:
        r5 = false;
        goto L15
    L19:
        return true;
    L5:
        r0 = false;
        goto L6
    }
}
