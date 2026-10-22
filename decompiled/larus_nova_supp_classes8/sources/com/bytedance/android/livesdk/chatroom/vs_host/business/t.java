package com.bytedance.android.livesdk.chatroom.vs_host.business;

import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.room.api.IReportService;
import com.bytedance.android.livesdk.config.bf1;
import com.bytedance.android.livesdk.config.oc;
import com.bytedance.android.livesdk.config.pc;
import com.bytedance.android.livesdkapi.model.ReportConfig;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.UIUtils;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t implements yr1.m, com.bytedance.android.scope.o {
    public t() {
    }

    @Override // yr1.m
    public final void g() {
    }

    @Override // yr1.m
    public final void i() {
    }

    @Override // yr1.m
    public final void k() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // yr1.m
    public final boolean a() {
        ReportConfig r0 = bf1.a.getValue();
        if (r0 == null) goto L9;
        ReportConfig.PersonalCardConfig r1 = r0.personalCardConfig;
        if (r1 == null) goto L9;
        if (r1.enableAuthorization != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // yr1.m
    public final String c() {
        return oc.a.getValue();
    }

    @Override // yr1.m
    public final boolean f() {
        ReportConfig r0 = bf1.a.getValue();
        if (r0 == null) goto L9;
        ReportConfig.PersonalCardConfig r1 = r0.personalCardConfig;
        if (r1 == null) goto L9;
        if (r1.enable != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // yr1.m
    public final boolean h() {
        ReportConfig r0 = bf1.a.getValue();
        if (r0 == null) goto L5;
        ReportConfig.PersonalCardConfig r1 = r0.personalCardConfig;
    L6:
        if (r1 == null) goto L8;
        return true;
    L8:
        return false;
    L5:
        r1 = null;
        goto L6
    }

    @Override // yr1.m
    public final void j(Uri.Builder r4) {
        Intrinsics.checkNotNullParameter(r4, "builder");
        Map<String, ? extends String> r0 = pc.a.getValue();
        if (r0 == null) goto L8;
        Iterator<Map.Entry<String, ? extends String>> r1 = r0.entrySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        Map.Entry<String, ? extends String> r2 = r1.next();
        r4.appendQueryParameter(r2.getKey(), r2.getValue());
        goto L6
    L10:
        return;
    }

    @Override // yr1.m
    public final void d(HSImageView r3, TextView r4) {
        ReportConfig r0 = bf1.a.getValue();
        if (r0 == null) goto L25;
        ReportConfig.PersonalCardConfig r1 = r0.personalCardConfig;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.showIcon == false) goto L10;
        UIUtils.setViewVisibility(r3, 0);
        ImageLoader.bindImage(r3, r0.personalCardConfig.icon);
    L12:
        if (TextUtils.isEmpty(r0.personalCardConfig.text) == true) goto L15;
        UIUtils.setText(r4, r0.personalCardConfig.text);
    L15:
        if (TextUtils.isEmpty(r0.personalCardConfig.textColor) == true) goto L26;
        int r5 = Color.parseColor(r0.personalCardConfig.textColor);     // Catch: Throwable -> L20
        if (r4 == null) goto L27;
        r4.setTextColor(r5);     // Catch: Throwable -> L20
        return;
    L27:
        return;
    L20:
        th = move-exception;
        Logger.e(th.getMessage());
        return;
    L26:
        return;
    L10:
        UIUtils.setViewVisibility(r3, 8);
        goto L12
    }

    @Override // yr1.m
    public final String getRequestPage(String r2, String r3) {
        IReportService r0 = jc1.k.f(IReportService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRequestPage(r2, r3);
    }

    @Override // yr1.m
    public final String getReportType(String r2, String r3, boolean r4) {
        IReportService r0 = jc1.k.f(IReportService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getReportType(r2, r3, r4);
    }
}
