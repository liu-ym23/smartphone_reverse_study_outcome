package com.lark.kmp.rustclient.api.model;

import com.lark.kmp.pb.basic.v1.LarkError;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001d\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB\u0019\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/rustclient/api/model/RustClientException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "message", "", "rustError", "Lcom/lark/kmp/pb/basic/v1/LarkError;", "<init>", "(Ljava/lang/String;Lcom/lark/kmp/pb/basic/v1/LarkError;)V", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "getRustError", "()Lcom/lark/kmp/pb/basic/v1/LarkError;", "rust-client_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class RustClientException extends RuntimeException {
    private final LarkError rustError;

    public final LarkError getRustError() {
        return this.rustError;
    }

    public RustClientException(String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "cause");
        super(r2, r3);
        this.rustError = null;
    }

    public RustClientException(String r2, LarkError r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        super(r2);
        this.rustError = r3;
    }

    public /* synthetic */ RustClientException(String r1, LarkError r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }
}
