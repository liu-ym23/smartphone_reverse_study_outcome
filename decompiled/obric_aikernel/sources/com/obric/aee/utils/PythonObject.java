package com.obric.aee.utils;

import androidx.annotation.Keep;
import com.bytedance.common.wschannel.WsConstants;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public final class PythonObject {
    private final JSONObject data;
    private final String type;

    public PythonObject(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
        Intrinsics.checkNotNullParameter(r11, "content");
        this.type = r10;
        this.data = new JSONObject(r11);
    }

    public final JSONObject getData() {
        return this.data;
    }

    public final String getType() {
        return this.type;
    }
}
