package com.ss.android.lark.pb.videochat;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum ShareScreenConfirm extends Enum<ShareScreenConfirm> implements WireEnum {
    private static final /* synthetic */ ShareScreenConfirm[] $VALUES = null;
    public static final ProtoAdapter<ShareScreenConfirm> ADAPTER = null;
    public static final ShareScreenConfirm ShareScreenConfirm_ALWAYS = null;
    public static final ShareScreenConfirm ShareScreenConfirm_CROSS_TENANT_ONLY = null;
    public static final ShareScreenConfirm ShareScreenConfirm_NONE = null;
    private final int value;

    static {
        ShareScreenConfirm r0 = new ShareScreenConfirm("ShareScreenConfirm_NONE", 0, 0);
        ShareScreenConfirm_NONE = r0;
        ShareScreenConfirm r1 = new ShareScreenConfirm("ShareScreenConfirm_CROSS_TENANT_ONLY", 1, 1);
        ShareScreenConfirm_CROSS_TENANT_ONLY = r1;
        ShareScreenConfirm r3 = new ShareScreenConfirm("ShareScreenConfirm_ALWAYS", 2, 2);
        ShareScreenConfirm_ALWAYS = r3;
        $VALUES = new ShareScreenConfirm[]{r0, r1, r3};
        ADAPTER = ProtoAdapter.newEnumAdapter(ShareScreenConfirm.class);
    }

    public static ShareScreenConfirm[] values() {
        return (ShareScreenConfirm[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ShareScreenConfirm fromValue(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return ShareScreenConfirm_ALWAYS;
    L12:
        return ShareScreenConfirm_CROSS_TENANT_ONLY;
    L14:
        return ShareScreenConfirm_NONE;
    }

    public static ShareScreenConfirm valueOf(String r1) {
        return (ShareScreenConfirm) a.a(ShareScreenConfirm.class, r1);
    }

    private ShareScreenConfirm(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
