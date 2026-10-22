package com.bytedance.android.ec.common.impl.sku.model;

import com.bytedance.android.ec.core.event.a;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/model/SkuLimit;", "Ljava/io/Serializable;", "count", "", a.VALUE_SHOW_TOAST, "", "(JLjava/lang/String;)V", "getCount", "()J", "getToast", "()Ljava/lang/String;", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuLimit implements Serializable {
    private final long count;
    private final String toast;

    public final long getCount() {
        return this.count;
    }

    public final String getToast() {
        return this.toast;
    }

    public SkuLimit(long r1, String r10) {
        this.count = r1;
        this.toast = r10;
    }

    public /* synthetic */ SkuLimit(long r1, String r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r1, r10);
    }
}
