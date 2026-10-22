package com.bytedance.sdk.xbridge.cn.runtime.depend;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Keep;
import cj.d;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJC\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00052\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostPermissionDepend;", "", "Landroid/content/Context;", "context", "", "", "permission", "", "isPermissionAllGranted", "(Landroid/content/Context;[Ljava/lang/String;)Z", "Landroid/app/Activity;", "activity", "Lcj/d;", "bridgeContext", "bridgeName", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/OnPermissionCallback;", "callback", "", "requestPermission", "(Landroid/app/Activity;Lcj/d;Ljava/lang/String;[Ljava/lang/String;Lcom/bytedance/sdk/xbridge/cn/runtime/depend/OnPermissionCallback;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public interface IHostPermissionDepend {
    boolean isPermissionAllGranted(Context r5, String... r10);

    void requestPermission(Activity r5, d r10, String r11, String[] r12, OnPermissionCallback r13);
}
