package com.bytedance.sdk.xbridge.cn.runtime.depend;

import android.content.Context;
import androidx.annotation.Keep;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.Metadata;
import ti.a;
import ti.b;
import ui.c;
import ui.d;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostMediaDependV2;", "", "Landroid/content/Context;", "context", "Lti/a;", LynxResourceModule.PARAMS_KEY, "Lui/c;", "extra", "Lui/a;", "callback", "", "startImageXUpload", "(Landroid/content/Context;Lti/a;Lui/c;Lui/a;)V", "closeImageXUpload", "()V", "Lti/b;", "Lui/d;", "Lui/b;", "startVideoUpload", "(Landroid/content/Context;Lti/b;Lui/d;Lui/b;)V", "closeVideoUpload", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public interface IHostMediaDependV2 {
    void closeImageXUpload();

    void closeVideoUpload();

    void startImageXUpload(Context r5, a r10, c r11, ui.a r12);

    void startVideoUpload(Context r5, b r10, d r11, ui.b r12);
}
