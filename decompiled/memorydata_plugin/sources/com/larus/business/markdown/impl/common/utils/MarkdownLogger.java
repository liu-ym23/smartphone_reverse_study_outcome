package com.larus.business.markdown.impl.common.utils;

import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.larus.business.markdown.api.depend.f;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/larus/business/markdown/impl/common/utils/MarkdownLogger;", "Lcom/larus/business/markdown/api/depend/IMarkdownLogger;", "()V", "d", "", LocationMonitorConst.TAG, "", NotificationCompat.CATEGORY_MESSAGE, "e", "tr", "", "i", BaseSwitches.V, "w", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MarkdownLogger implements f {
    public MarkdownLogger() {
    }

    @Override // com.larus.business.markdown.api.depend.f
    public void d(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
        f r0 = com.larus.business.markdown.api.a.f5138a.b();
        if (r0 == null) goto L6;
        r0.d(r1, r2);
        return;
    }

    @Override // com.larus.business.markdown.api.depend.f
    public void e(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
        f r0 = com.larus.business.markdown.api.a.f5138a.b();
        if (r0 == null) goto L6;
        r0.e(r1, r2);
        return;
    }

    @Override // com.larus.business.markdown.api.depend.f
    public void e(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
        f r0 = com.larus.business.markdown.api.a.f5138a.b();
        if (r0 == null) goto L6;
        r0.e(r1, r2, r3);
        return;
    }

    @Override // com.larus.business.markdown.api.depend.f
    public void i(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
        f r0 = com.larus.business.markdown.api.a.f5138a.b();
        if (r0 == null) goto L6;
        r0.i(r1, r2);
        return;
    }

    @Override // com.larus.business.markdown.api.depend.f
    public void v(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
        f r0 = com.larus.business.markdown.api.a.f5138a.b();
        if (r0 == null) goto L6;
        r0.v(r1, r2);
        return;
    }

    @Override // com.larus.business.markdown.api.depend.f
    public void w(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
        f r0 = com.larus.business.markdown.api.a.f5138a.b();
        if (r0 == null) goto L6;
        r0.w(r1, r2);
        return;
    }

    @Override // com.larus.business.markdown.api.depend.f
    public void w(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
        f r0 = com.larus.business.markdown.api.a.f5138a.b();
        if (r0 == null) goto L6;
        r0.w(r1, r2, r3);
        return;
    }

    @Override // com.larus.business.markdown.api.depend.f
    public void w(String r1, Throwable r2) {
        Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
        f r0 = com.larus.business.markdown.api.a.f5138a.b();
        if (r0 == null) goto L6;
        r0.w(r1, r2);
        return;
    }
}
