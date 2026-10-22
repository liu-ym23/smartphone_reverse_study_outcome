package com.larus.sheet.operation.download;

import android.content.Context;
import android.net.Uri;
import com.larus.home.impl.sdk.b1;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class b implements Function5 {
    public final /* synthetic */ Context a;
    public final /* synthetic */ Function4 b;

    public /* synthetic */ b(Context r1, Function4 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r4, Object r5, Object r6, Object r7, Object r8) {
        Context r0 = this.a;
        Function4 r1 = this.b;
        Uri r9 = (Uri) r5;
        Throwable r10 = (Throwable) r6;
        Integer r11 = (Integer) r7;
        String r12 = (String) r8;
        String r2 = "";
        if (((Boolean) r4).booleanValue() == false) goto L27;
        if (r9 == null) goto L11;
        String r13 = com.larus.office.base.utils.b.c(r0, r9);
        if (r13 != null) goto L9;
        r13 = r9.toString();
    L9:
        r2 = r13;
    L11:
        if (StringsKt.isBlank(r2) == false) goto L33;
    L26:
        r1.invoke(Boolean.TRUE, null, r11, r2);
    L31:
        d.a = false;
        return Unit.INSTANCE;
    L33:
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L21
        IFlowSdkDepend r15 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);     // Catch: Throwable -> L21
        if (r15 == null) goto L18;
        r15.D0();     // Catch: Throwable -> L21
        boolean r16 = b1.a.b(r2);     // Catch: Throwable -> L21
        FLogger.a.i("SheetDownloader", "[runMetadataCheck] success=" + r16 + ", path=" + r2);     // Catch: Throwable -> L21
        Boolean r17 = Boolean.valueOf(r16);     // Catch: Throwable -> L21
    L19:
        Object r18 = Result.constructor-impl(r17);     // Catch: Throwable -> L21
    L23:
        Throwable r19 = Result.exceptionOrNull-impl(r18);
        if (r19 == null) goto L26;
        FLogger.a.e("SheetDownloader", "[runMetadataCheck] failed, path=" + r2, r19);
        goto L26
    L18:
        FLogger.a.i("SheetDownloader", "[runMetadataCheck] metadata check service is null, path=" + r2);     // Catch: Throwable -> L21
        r17 = Unit.INSTANCE;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    L27:
        Boolean r21 = Boolean.FALSE;
        if (r12 != null) goto L30;
        r12 = "";
    L30:
        r1.invoke(r21, r10, r11, r12);
        goto L31
    }
}
