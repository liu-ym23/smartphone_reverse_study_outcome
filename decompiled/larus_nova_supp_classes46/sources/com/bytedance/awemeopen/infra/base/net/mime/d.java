package com.bytedance.awemeopen.infra.base.net.mime;

import com.bytedance.awemeopen.infra.base.net.AoRequestHelper;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d extends a {
    public d(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        super(AoRequestHelper.INSTANCE.convertToBytes(r2.toString()));
    }
}
