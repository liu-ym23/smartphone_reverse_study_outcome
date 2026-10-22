package com.ss.android.lark.officesdk.integrator.im;

import android.content.Context;
import android.util.Size;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.ccm_api.ICCMApi;
import com.ss.android.lark.chat.preview.components.ChattersPreviewComponent;
import com.ss.android.lark.export.api.UrlPreviewApi;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs.MmUploadRetryConfigSetting;
import com.ss.android.lark.utils.ApiUtils;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g implements g6b.a.a {
    public final /* synthetic */ InitChatPreviewTask a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ h c;

    public final void i() {
    }

    public final a a() {
        return new a(this.b, this.a);
    }

    public final c c() {
        return new c();
    }

    public final void clearAllUrlCache() {
        UrlPreviewApi r0 = (UrlPreviewApi) ApiUtils.getApi(UrlPreviewApi.class);
        if (r0 == null) goto L6;
        r0.clearAllUrlCache();
        return;
    }

    public final f d() {
        return new f();
    }

    public final e g() {
        return new e(this.a);
    }

    public final b getCoreDependency() {
        return new b();
    }

    public final d getLoginDependency() {
        return new d();
    }

    public final long getNtpTime() {
        return cac.b.a.a.a(MmUploadRetryConfigSetting.MAX_INTERVAL_MS);
    }

    public final void e() {
        InitChatPreviewTask.b r0 = InitChatPreviewTask.b.a;
    }

    public final h getFeatureGatingDependency() {
        return this.c;
    }

    public final void f(final List r3, final ChattersPreviewComponent.update.1.2 r4) {
        Intrinsics.checkNotNullParameter(r3, "chatterIds");
        Intrinsics.checkNotNullParameter(r4, "callback");
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new InitChatPreviewTask$initialize$dependency$1$getChattersById$1(r3, r4));
    }

    public g(InitChatPreviewTask r1, Context r2, h r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void h(LKUIRoundedImageView2 r11, String r12, int r13, int r14, String r15, String r16, String r17, Size r18) {
        Intrinsics.checkNotNullParameter(r11, "view");
        i0b.a r1 = new i0b.a(r12, r13, r14, r15, r16, r17, r18);
        ICCMApi r2 = (ICCMApi) ApiUtils.getApi(ICCMApi.class);
        if (r2 == null) goto L6;
        r2.loadDocThumbnail(r11, r1);
        return;
    }

    public final void b(Context r12, com.ss.android.lark.chat.preview.components.view.j r13, String r14, String r15, String r16, String r17, int r18, Image r19, boolean r20) {
        Intrinsics.checkNotNullParameter(r12, "context");
        IIMApi r1 = InitChatPreviewTask.j(this.a);
        if (r1 == null) goto L6;
        r1.openUrlToPlayVideo(r12, r13, r14, r15, r16, r17, r18, r19, r20);
        return;
    }
}
