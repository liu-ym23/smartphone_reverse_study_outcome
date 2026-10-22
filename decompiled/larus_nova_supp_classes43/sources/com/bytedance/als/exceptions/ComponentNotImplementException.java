package com.bytedance.als.exceptions;

import com.bytedance.android.ec.core.event.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/als/exceptions/ComponentNotImplementException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", a.KEY_MSG, "", "throwable", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "als_release"}, k = 1, mv = {1, 4, 1})
public final class ComponentNotImplementException extends RuntimeException {
    public ComponentNotImplementException(String r10, Throwable r11) {
        Intrinsics.checkNotNullParameter(r10, a.KEY_MSG);
        Intrinsics.checkNotNullParameter(r11, "throwable");
        super(r10, r11);
    }
}
