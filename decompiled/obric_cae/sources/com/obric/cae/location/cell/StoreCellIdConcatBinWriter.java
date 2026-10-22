package com.obric.cae.location.cell;

/* JADX INFO: loaded from: classes.dex */
public final class StoreCellIdConcatBinWriter {
    private StoreCellIdConcatBinWriter() {
    }

    public static String buildIdLine(String r8, String r10, String r11, long r12, long r13) {
        String r14 = "";
        if (r8 != null) goto L5;
        String r15 = "";
    L6:
        if (r10 != null) goto L8;
        String r16 = "";
    L9:
        if (r11 == null) goto L13;
        r14 = r11.trim();
    L13:
        return r15 + "-" + r16 + "-" + r14 + "-" + r12 + "-" + r13;
    L8:
        r16 = r10.trim();
        goto L9
    L5:
        r15 = r8.trim();
        goto L6
    }
}
