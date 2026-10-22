package com.larus.slides.operation.download;

import android.content.Context;
import android.net.Uri;
import com.larus.home.impl.sdk.b1;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class a implements Function4 {
    public final /* synthetic */ Context a;
    public final /* synthetic */ Function3 b;

    public /* synthetic */ a(Context r1, Function3 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r5, Object r6, Object r7, Object r8) {
        Context r0 = this.a;
        Function3 r1 = this.b;
        Uri r9 = (Uri) r6;
        Integer r10 = (Integer) r7;
        String r11 = (String) r8;
        String r2 = "";
        if (((Boolean) r5).booleanValue() == false) goto L27;
        if (r9 == null) goto L11;
        String r12 = com.larus.office.base.utils.b.c(r0, r9);
        if (r12 != null) goto L9;
        r12 = r9.toString();
    L9:
        r2 = r12;
    L11:
        if (StringsKt.isBlank(r2) == false) goto L33;
    L26:
        r1.invoke(Boolean.TRUE, r10, r2);
    L31:
        c.a = false;
        return Unit.INSTANCE;
    L33:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L21
        IFlowSdkDepend r4 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);     // Catch: Throwable -> L21
        if (r4 == null) goto L18;
        r4.D0();     // Catch: Throwable -> L21
        boolean r13 = b1.a.b(r2);     // Catch: Throwable -> L21
        FLogger.a.i("SlidesDownloader", "[runMetadataCheck] success=" + r13 + ", path=" + r2);     // Catch: Throwable -> L21
        Boolean r14 = Boolean.valueOf(r13);     // Catch: Throwable -> L21
    L19:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L21
    L23:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L26;
        FLogger.a.e("SlidesDownloader", "[runMetadataCheck] failed, path=" + r2, r16);
        goto L26
    L18:
        FLogger.a.i("SlidesDownloader", "[runMetadataCheck] metadata check service is null, path=" + r2);     // Catch: Throwable -> L21
        r14 = Unit.INSTANCE;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    L27:
        Boolean r18 = Boolean.FALSE;
        if (r11 != null) goto L30;
        r11 = "";
    L30:
        r1.invoke(r18, r10, r11);
        goto L31
    }
}
