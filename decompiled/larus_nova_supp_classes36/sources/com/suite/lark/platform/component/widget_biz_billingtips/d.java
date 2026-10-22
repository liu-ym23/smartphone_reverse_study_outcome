package com.suite.lark.platform.component.widget_biz_billingtips;

import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.pb.role.GetAdminPermissionInfoResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final /* synthetic */ class d implements SdkSender.IParser {
    public final /* synthetic */ ProtoAdapter a;

    public /* synthetic */ d(ProtoAdapter r1) {
        this.a = r1;
    }

    public final Object parse(byte[] r2) {
        return (GetAdminPermissionInfoResponse) this.a.decode(r2);
    }
}
