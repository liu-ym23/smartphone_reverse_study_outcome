package com.bytedance.android.accessibilityLib_Core.config.base;

import com.bytedance.android.accessibilityLib_Core.config.bean.ViewVirtualNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/accessibilityLib_Core/config/bean/ViewVirtualNode;", "invoke"}, k = 3, mv = {1, 4, 1})
final class AbstractBaseConfig$customView$config$1$virtualNode$2 extends Lambda implements Function0<ViewVirtualNode> {
    public static final AbstractBaseConfig$customView$config$1$virtualNode$2 INSTANCE = null;

    static {
        INSTANCE = new AbstractBaseConfig$customView$config$1$virtualNode$2();
    }

    public AbstractBaseConfig$customView$config$1$virtualNode$2() {
        super(0);
    }

    public final ViewVirtualNode invoke() {
        return new ViewVirtualNode();
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m58invoke() {
        return invoke();
    }
}
