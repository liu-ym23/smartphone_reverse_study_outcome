package com.ss.android.lark.contact.customized.department;

import com.bytedance.lark.pb.contact.v1.GetDepartmentCombineChatResponse;
import com.ss.android.lark.sdk.SdkSender;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c<T> implements SdkSender.IParser {
    public static final c<T> a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public final Object parse(byte[] r2) {
        Intrinsics.checkNotNullParameter(r2, Keys.API_RETURN_KEY_DATA);
        return (GetDepartmentCombineChatResponse) GetDepartmentCombineChatResponse.ADAPTER.decode(r2);
    }
}
