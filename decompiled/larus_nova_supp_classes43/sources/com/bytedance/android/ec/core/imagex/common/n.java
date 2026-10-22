package com.bytedance.android.ec.core.imagex.common;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final /* synthetic */ class n {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[ImageUrlParser.Type.values().length];
        a = r0;
        r0[ImageUrlParser.Type.PROTOCOL.ordinal()] = 1;
        r0[ImageUrlParser.Type.DOMAIN.ordinal()] = 2;
        r0[ImageUrlParser.Type.FLAG.ordinal()] = 3;
        r0[ImageUrlParser.Type.URI.ordinal()] = 4;
        r0[ImageUrlParser.Type.SERVICE_ID.ordinal()] = 5;
        r0[ImageUrlParser.Type.TMPL_NAME.ordinal()] = 6;
        r0[ImageUrlParser.Type.ParamValues.ordinal()] = 7;
        r0[ImageUrlParser.Type.FORMAT.ordinal()] = 8;
    }
}
