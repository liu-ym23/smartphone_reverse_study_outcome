package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.chat.api.service.request.PullUrlPreviewRequest;
import com.ss.android.lark.chat.entity.preview.UrlPreViewEntries;
import com.ss.android.lark.chat.preview.entity.UrlPreviewResponse;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c1 extends c0c.b implements a2b.f {
    public final /* synthetic */ a2b.f b;
    public final com.ss.android.lark.passportc.internal.v c;
    public final com.ss.android.lark.passportc.convention.b<a2b.f> d;

    public static final class a {
    }

    static {
    }

    @Override // a2b.f
    public final void Fa(PullUrlPreviewRequest r2) {
        Intrinsics.checkNotNullParameter(r2, "request");
        this.b.Fa(r2);
    }

    @Override // a2b.f
    public final void ba(a2b.b r2, IGetDataCallback<a2b.b> r3) {
        Intrinsics.checkNotNullParameter(r2, "urlPreview");
        Intrinsics.checkNotNullParameter(r3, "uiCallback");
        this.b.ba(r2, r3);
    }

    @Override // a2b.f
    public final void getUrlInlineFromContent(String r2, IGetDataCallback<UrlInlinePreviewEntity> r3) {
        Intrinsics.checkNotNullParameter(r2, "content");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.b.getUrlInlineFromContent(r2, r3);
    }

    @Override // a2b.f
    public final void lc(List<String> r2, Map<String, ? extends Map<String, UrlCardPreviewEntity>> r3) {
        Intrinsics.checkNotNullParameter(r2, "templateIdList");
        Intrinsics.checkNotNullParameter(r3, "messagePreviewMap");
        this.b.lc(r2, r3);
    }

    @Override // a2b.f
    public final void r4(List<String> r9, List<String> r10, SyncDataStrategy r11, UrlPreViewEntries.UrlPreViewSourceType r12, List<Long> r13, UIGetDataCallback<UrlPreviewResponse> r14) {
        Intrinsics.checkNotNullParameter(r9, "sourceIdList");
        Intrinsics.checkNotNullParameter(r10, "sourceTextMD5List");
        Intrinsics.checkNotNullParameter(r11, "syncDataStrategy");
        Intrinsics.checkNotNullParameter(r12, "sourceType");
        Intrinsics.checkNotNullParameter(r14, "callback");
        this.b.r4(r9, r10, r11, r12, r13, r14);
    }

    public c1(com.ss.android.lark.passportc.api.j r4, com.ss.android.lark.passportc.internal.v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<a2b.f> r0 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r5.c(r1), a2b.f.class), a2b.f.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "instanceHolder");
        super(r4);
        this.b = (a2b.f) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void qf(f0c.g r2, f0c.g r3) {
        Log.i("PreviewServiceProxy", "preparing IPreviewService");
        com.ss.android.lark.passportc.internal.v r4 = this.c;
        if (r3 == null) goto L6;
        UserSession r5 = r3.b;
        if (r5 == null) goto L6;
    L7:
        a2b.f r6 = (a2b.f) e0c.k.b(r4.c(r5), a2b.f.class);
        this.d.e(r6);
        return;
    L6:
        r5 = ContainerConstsKt.a();
        goto L7
    }
}
