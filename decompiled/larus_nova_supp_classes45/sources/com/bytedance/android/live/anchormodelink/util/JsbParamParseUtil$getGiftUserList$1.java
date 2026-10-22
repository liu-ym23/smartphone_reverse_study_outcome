package com.bytedance.android.live.anchormodelink.util;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"sanitizeUrl", "", "raw", "invoke"}, k = 3, mv = {1, 5, 1})
public final class JsbParamParseUtil$getGiftUserList$1 extends Lambda implements Function1<String, String> {
    public static final JsbParamParseUtil$getGiftUserList$1 INSTANCE = null;

    static {
        INSTANCE = new JsbParamParseUtil$getGiftUserList$1();
    }

    public JsbParamParseUtil$getGiftUserList$1() {
        super(1);
    }

    public final String invoke(String r7) {
        if (r7 != null) goto L5;
        return null;
    L5:
        String r8 = StringsKt.replace$default(r7, "`", "", false, 4, null);
        if (r8 == null) goto L10;
        return StringsKt.trim(r8).toString();
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((String) r1);
    }
}
