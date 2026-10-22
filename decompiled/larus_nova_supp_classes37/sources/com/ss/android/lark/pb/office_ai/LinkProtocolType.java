package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum LinkProtocolType extends Enum<LinkProtocolType> implements WireEnum {
    private static final /* synthetic */ LinkProtocolType[] $VALUES = null;
    public static final ProtoAdapter<LinkProtocolType> ADAPTER = null;
    public static final LinkProtocolType LinkProtocolType_APPLINK = null;
    public static final LinkProtocolType LinkProtocolType_DOUBAO = null;
    public static final LinkProtocolType LinkProtocolType_HTTP = null;
    public static final LinkProtocolType LinkProtocolType_HTTPS = null;
    private final int value;

    static {
        LinkProtocolType r0 = new LinkProtocolType("LinkProtocolType_APPLINK", 0, 1);
        LinkProtocolType_APPLINK = r0;
        LinkProtocolType r1 = new LinkProtocolType("LinkProtocolType_DOUBAO", 1, 2);
        LinkProtocolType_DOUBAO = r1;
        LinkProtocolType r4 = new LinkProtocolType("LinkProtocolType_HTTPS", 2, 3);
        LinkProtocolType_HTTPS = r4;
        LinkProtocolType r6 = new LinkProtocolType("LinkProtocolType_HTTP", 3, 4);
        LinkProtocolType_HTTP = r6;
        $VALUES = new LinkProtocolType[]{r0, r1, r4, r6};
        ADAPTER = ProtoAdapter.newEnumAdapter(LinkProtocolType.class);
    }

    public static LinkProtocolType[] values() {
        return (LinkProtocolType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static LinkProtocolType fromValue(int r1) {
        if (r1 == 1) goto L19;
        if (r1 == 2) goto L17;
        if (r1 == 3) goto L15;
        if (r1 == 4) goto L13;
        return null;
    L13:
        return LinkProtocolType_HTTP;
    L15:
        return LinkProtocolType_HTTPS;
    L17:
        return LinkProtocolType_DOUBAO;
    L19:
        return LinkProtocolType_APPLINK;
    }

    public static LinkProtocolType valueOf(String r1) {
        return (LinkProtocolType) a.a(LinkProtocolType.class, r1);
    }

    private LinkProtocolType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
