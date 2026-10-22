package com.bytedance.lark.lark_bitable_android;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/lark/lark_bitable_android/UnhandledException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", com.bytedance.android.ec.core.event.a.KEY_MSG, "", "(Ljava/lang/String;)V", "lark_bitable_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class UnhandledException extends Exception {
    public UnhandledException() {
        String r0 = null;
        this(r0, 1, r0);
    }

    public UnhandledException(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_MSG);
        super(r10);
    }

    public /* synthetic */ UnhandledException(String r1, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r1 = "";
    L5:
        this(r1);
    }
}
