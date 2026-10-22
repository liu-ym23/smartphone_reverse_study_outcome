package com.bytedance.android.accessibilityLib_Core.config.base;

import com.bytedance.android.accessibilityLib_Core.base.AccessiblityScope;
import com.bytedance.android.accessibilityLib_Core.config.bean.ViewVirtualNode;
import com.bytedance.android.ec.core.event.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0017J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\f\u0010\u0010\u001a\u00020\u0007*\u00020\u0003H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/accessibilityLib_Core/config/base/IBaseConfig;", "", "virtualNode", "Lcom/bytedance/android/accessibilityLib_Core/config/bean/ViewVirtualNode;", "getVirtualNode", "()Lcom/bytedance/android/accessibilityLib_Core/config/bean/ViewVirtualNode;", "build", "", "enableLargeTouchArea", "", "getScope", "Lcom/bytedance/android/accessibilityLib_Core/base/AccessiblityScope;", "layoutRoot", "", a.KEY_SHOPPING_GUIDE_NAME, "", "config", "accessibilityLib_Core_release"}, k = 1, mv = {1, 4, 1})
public interface IBaseConfig {
    void build();

    void config(ViewVirtualNode r1);

    boolean enableLargeTouchArea();

    AccessiblityScope getScope();

    ViewVirtualNode getVirtualNode();

    int layoutRoot();

    String name();
}
