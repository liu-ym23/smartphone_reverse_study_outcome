package com.ss.android.lark.integrator.security.compliance.export;

import android.app.Dialog;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKCapacity;
import com.ss.android.lark.watermark.core.IGetWaterMarkResourceCallback;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface d extends IOfficeSDKCapacity {
    void K(Dialog r1);

    void L8(Dialog r1);

    void w0(String r1, String r2, ByteString r3, IGetWaterMarkResourceCallback r4);
}
