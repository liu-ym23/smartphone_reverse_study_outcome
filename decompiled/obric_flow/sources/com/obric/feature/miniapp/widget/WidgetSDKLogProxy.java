package com.obric.feature.miniapp.widget;

import ai.j0;
import android.util.Log;
import com.bytedance.ai.ex.widget.LogProxy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\f\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ-\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000e\u0010\rJ-\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000f\u0010\rJ-\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0010\u0010\rJ-\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0011\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/obric/feature/miniapp/widget/WidgetSDKLogProxy;", "Lcom/bytedance/ai/ex/widget/LogProxy;", "", "applicationInfoFlags", "<init>", "(I)V", "", "tag", "msg", "", "throwable", "", "d", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "e", "i", "v", "w", "widget-sdk-4l_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class WidgetSDKLogProxy implements LogProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11423a;

    public WidgetSDKLogProxy(int r5) {
        this.f11423a = r5;
    }

    @Override // com.bytedance.ai.ex.widget.LogProxy
    public void d(String r5, String r10, Throwable r11) {
        if (WidgetSDKLogPolicy.INSTANCE.shouldLog(this.f11423a, 3, r5) == true) goto L5;
        return;
    L5:
        String r12 = j0.C("WidgetSDK-", r5);
        WidgetSDKLogSanitizer r13 = WidgetSDKLogSanitizer.INSTANCE;
        Log.d(r12, r13.sanitizeMessage(r5, r10), r13.sanitizeThrowable(r5, r11));
    }

    @Override // com.bytedance.ai.ex.widget.LogProxy
    public void e(String r5, String r10, Throwable r11) {
        if (WidgetSDKLogPolicy.INSTANCE.shouldLog(this.f11423a, 6, r5) == true) goto L5;
        return;
    L5:
        String r12 = j0.C("WidgetSDK-", r5);
        WidgetSDKLogSanitizer r13 = WidgetSDKLogSanitizer.INSTANCE;
        Log.e(r12, r13.sanitizeMessage(r5, r10), r13.sanitizeThrowable(r5, r11));
    }

    @Override // com.bytedance.ai.ex.widget.LogProxy
    public void i(String r5, String r10, Throwable r11) {
        if (WidgetSDKLogPolicy.INSTANCE.shouldLog(this.f11423a, 4, r5) == true) goto L5;
        return;
    L5:
        String r12 = j0.C("WidgetSDK-", r5);
        WidgetSDKLogSanitizer r13 = WidgetSDKLogSanitizer.INSTANCE;
        Log.i(r12, r13.sanitizeMessage(r5, r10), r13.sanitizeThrowable(r5, r11));
    }

    @Override // com.bytedance.ai.ex.widget.LogProxy
    public void v(String r5, String r10, Throwable r11) {
        if (WidgetSDKLogPolicy.INSTANCE.shouldLog(this.f11423a, 2, r5) == true) goto L5;
        return;
    L5:
        String r12 = j0.C("WidgetSDK-", r5);
        WidgetSDKLogSanitizer r13 = WidgetSDKLogSanitizer.INSTANCE;
        Log.v(r12, r13.sanitizeMessage(r5, r10), r13.sanitizeThrowable(r5, r11));
    }

    @Override // com.bytedance.ai.ex.widget.LogProxy
    public void w(String r5, String r10, Throwable r11) {
        if (WidgetSDKLogPolicy.INSTANCE.shouldLog(this.f11423a, 5, r5) == true) goto L5;
        return;
    L5:
        String r12 = j0.C("WidgetSDK-", r5);
        WidgetSDKLogSanitizer r13 = WidgetSDKLogSanitizer.INSTANCE;
        Log.w(r12, r13.sanitizeMessage(r5, r10), r13.sanitizeThrowable(r5, r11));
    }
}
