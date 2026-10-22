package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.basic.v1.MessageSource;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.basic.v1.TranslateUrlPreviewContext;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.api.service.ITranslateService;
import com.ss.android.lark.chat.entity.translate.TranslateLanguageSetting;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g2 extends c0c.b implements ITranslateService {
    public final /* synthetic */ ITranslateService b;
    public final com.ss.android.lark.passportc.internal.v c;
    public final com.ss.android.lark.passportc.convention.b<ITranslateService> d;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.chat.api.service.ITranslateService
    public final void L4(String r2, IGetDataCallback<Boolean> r3) {
        this.b.L4(r2, r3);
    }

    @Override // com.ss.android.lark.chat.api.service.ITranslateService
    public final void W4(boolean r2, Map<String, TranslateUrlPreviewContext> r3, Map<String, Map<String, PreviewHangPoint>> r4, IGetDataCallback<Map<String, Map<String, PreviewHangPoint>>> r5) {
        this.b.W4(r2, r3, r4, r5);
    }

    @Override // com.ss.android.lark.chat.api.service.ITranslateService
    public final void cb(boolean r2, IGetDataCallback<Boolean> r3) {
        this.b.cb(r2, r3);
    }

    @Override // com.ss.android.lark.chat.api.service.ITranslateService
    public final void jf(List<String> r11, ITranslateService.TranslateTriggerType r12, String r13, List<MessageSource> r14, String r15, Map<String, Integer> r16, boolean r17, IGetDataCallback<fcb.a> r18) {
        this.b.jf(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    @Override // com.ss.android.lark.chat.api.service.ITranslateService
    public final void s9(SyncDataStrategy r2, IGetDataCallback<TranslateLanguageSetting> r3) {
        this.b.s9(r2, r3);
    }

    @Override // com.ss.android.lark.chat.api.service.ITranslateService
    public final void getTranslateLanguages(IGetDataCallback r2) {
        s9(SyncDataStrategy.FORCE_SERVER, r2);
    }

    public g2(com.ss.android.lark.passportc.api.j r4, com.ss.android.lark.passportc.internal.v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<ITranslateService> r0 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r5.c(r1), ITranslateService.class), ITranslateService.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "instanceHolder");
        super(r4);
        this.b = (ITranslateService) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void qf(f0c.g r2, f0c.g r3) {
        Log.i("TranslateServiceProxy", "preparing ITranslateService");
        com.ss.android.lark.passportc.internal.v r4 = this.c;
        if (r3 == null) goto L6;
        UserSession r5 = r3.b;
        if (r5 == null) goto L6;
    L7:
        ITranslateService r6 = (ITranslateService) e0c.k.b(r4.c(r5), ITranslateService.class);
        this.d.e(r6);
        return;
    L6:
        r5 = ContainerConstsKt.a();
        goto L7
    }
}
