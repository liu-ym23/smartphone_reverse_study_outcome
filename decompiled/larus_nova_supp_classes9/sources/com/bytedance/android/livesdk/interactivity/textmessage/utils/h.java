package com.bytedance.android.livesdk.interactivity.textmessage.utils;

import com.bytedance.android.livesdk.interactivity.api.entity.SpannableType;
import com.bytedance.android.livesdk.interactivity.api.utils.MessageStyleFormatter;
import com.bytedance.android.livesdk.interactivity.textmessage.model.i0;
import com.bytedance.android.livesdkapi.depend.live.MessageSceneType;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final int a(SpannableType r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "type");
        if (r1 == SpannableType.MESSAGE_FILTER) goto L7;
        int r3 = k.a;
        return i0.a(2131107649);
    L7:
        return MessageStyleFormatter.a(MessageStyleFormatter.StyleType.GIFT, r2).b;
    }

    @JvmStatic
    public static final int b(SpannableType r2, boolean r3, MessageSceneType r4) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r4, "mSceneType");
        if (r2 == SpannableType.MESSAGE_FILTER) goto L7;
        int r5 = k.a;
        Intrinsics.checkNotNullParameter(r4, "type");
        return i0.a(2131107646);
    L7:
        return MessageStyleFormatter.a(MessageStyleFormatter.StyleType.GIFT, r3).a;
    }
}
