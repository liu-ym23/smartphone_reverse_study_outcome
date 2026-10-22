package com.ss.android.lark.qrcode.zxing.client.result;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum ParsedResultType extends Enum<ParsedResultType> {
    public static final ParsedResultType TEXT = null;
    public static final ParsedResultType URI = null;
    public static final /* synthetic */ ParsedResultType[] a = null;

    static {
        ParsedResultType r0 = new ParsedResultType("URI", 0);
        URI = r0;
        ParsedResultType r1 = new ParsedResultType("TEXT", 1);
        TEXT = r1;
        a = new ParsedResultType[]{r0, r1};
    }

    public static ParsedResultType[] values() {
        return (ParsedResultType[]) a.clone();
    }

    public static ParsedResultType valueOf(String r1) {
        return (ParsedResultType) a.a(ParsedResultType.class, r1);
    }

    public ParsedResultType(String r1, int r2) {
        super(r1, r2);
    }
}
