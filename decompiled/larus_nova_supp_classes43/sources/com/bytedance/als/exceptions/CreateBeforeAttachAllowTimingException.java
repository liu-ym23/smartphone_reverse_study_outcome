package com.bytedance.als.exceptions;

import com.bytedance.android.ec.core.event.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/als/exceptions/CreateBeforeAttachAllowTimingException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", a.KEY_MSG, "", "(Ljava/lang/String;)V", "als_release"}, k = 1, mv = {1, 4, 1})
public final class CreateBeforeAttachAllowTimingException extends RuntimeException {
    public CreateBeforeAttachAllowTimingException(String r10) {
        Intrinsics.checkNotNullParameter(r10, a.KEY_MSG);
        super(r10);
    }
}
