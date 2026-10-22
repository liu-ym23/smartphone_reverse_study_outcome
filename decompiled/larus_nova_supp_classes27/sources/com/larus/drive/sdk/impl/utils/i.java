package com.larus.drive.sdk.impl.utils;

import android.content.Context;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceEventSource;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceItem;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class i implements Function1 {
    public final /* synthetic */ DriveFileType a;
    public final /* synthetic */ Function1 b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Context d;
    public final /* synthetic */ OfficeSpaceEventSource e;
    public final /* synthetic */ Function1 f;

    public /* synthetic */ i(DriveFileType r1, com.larus.drive.biz.impl.utils.j r2, String r3, Context r4, OfficeSpaceEventSource r5, com.larus.drive.biz.impl.utils.i r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public final Object invoke(Object r11) {
        DriveFileType r0 = this.a;
        Function1 r1 = this.b;
        String r2 = this.c;
        Context r3 = this.d;
        OfficeSpaceEventSource r4 = this.e;
        Function1 r5 = this.f;
        DriveFileItem r12 = (DriveFileItem) r11;
        if (r12 != null) goto L8;
        FLogger.a.i("DrivePreviewHelper", "create blank office file success but file is null, type=" + r0);
        if (r1 == null) goto L32;
        r1.invoke("empty_file");
    L32:
        return Unit.INSTANCE;
    L8:
        FLogger r7 = FLogger.a;
        r7.i("DrivePreviewHelper", "create office file success, type=" + r0 + ", token=" + r12.b + ", parent=" + r2);
        k.a.getClass();
        OfficeSpaceItem r6 = k.k(r12);
        if (r4 == null) goto L11;
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r6, "item");
        Intrinsics.checkNotNullParameter(r4, "source");
        boolean r8 = k.f(r3, r6, r4.getTab().name());
    L25:
        if (r8 == false) goto L28;
        if (r5 == null) goto L31;
        r5.invoke(r12);
    L31:
        return Unit.INSTANCE;
    L28:
        if (r1 == null) goto L31;
        r1.invoke("open_failed");
        goto L31
    L11:
        DriveFileType r9 = r12.j;
        if (r9 != DriveFileType.AI_DOC) goto L14;
    L21:
        boolean r10 = true;
    L22:
        if (r10 == false) goto L24;
        r8 = k.f(r3, r6, null);
        goto L25
    L24:
        r7.i("DrivePreviewHelper", "skip created office file because type is unsupported, type=" + r12.j);
        r8 = false;
        goto L25
    L14:
        if (r9 == DriveFileType.AI_SLIDES) goto L21;
        if (r9 == DriveFileType.AI_SHEET) goto L21;
        if (r9 == DriveFileType.BITABLE) goto L21;
        r10 = false;
        goto L22
    }
}
