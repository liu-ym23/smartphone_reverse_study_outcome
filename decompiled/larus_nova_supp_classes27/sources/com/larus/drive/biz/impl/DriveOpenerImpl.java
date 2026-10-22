package com.larus.drive.biz.impl;

import android.content.Context;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.drive.sdk.api.IDriveSdkService;
import com.larus.drive.sdk.api.IDriveSdkServiceV2;
import com.larus.office.base.preview.IOfficePreviewOpener;
import com.larus.office.base.preview.b;
import com.larus.office.base.utils.f;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\fH\u0002¨\u0006\u0011"}, d2 = {"Lcom/larus/drive/biz/impl/DriveOpenerImpl;", "Lcom/larus/office/base/preview/IOfficePreviewOpener;", "<init>", "()V", "supportedPreviewTypes", "", "", "open", "", "request", "Lcom/larus/office/base/preview/OfficePreviewOpenRequest;", "buildDefaultFileUrl", "", "token", "isWikiUrl", "url", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveOpenerImpl implements IOfficePreviewOpener {

    public static final class a {
    }

    static {
    }

    public DriveOpenerImpl() {
    }

    public final Set<Integer> b() {
        return SetsKt.setOf(new Integer[]{12, 16});
    }

    public final boolean a(b r10) {
        Intrinsics.checkNotNullParameter(r10, "request");
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("open enter: token=");
        int r2 = f.a;
        r1.append(f.b(r10.c));
        r1.append(", enterMethod=");
        r1.append(r10.d);
        r1.append(", page=");
        r1.append(r10.e);
        r1.append(", restDocsSize=");
        r1.append(r10.f.size());
        r0.i("DriveOpenerImpl", r1.toString());
        String r3 = r10.i;
        if (r3 != null) goto L5;
    L9:
        r3 = "https://feishu.doubao.com/file/" + r10.c;
    L38:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L12
        Object r5 = Result.constructor-impl(Boolean.valueOf(Intrinsics.areEqual(CollectionsKt.firstOrNull(UriProtector.parse(r3).getPathSegments()), "wiki")));     // Catch: Throwable -> L12
    L14:
        Boolean r6 = Boolean.FALSE;
        if (Result.isFailure-impl(r5) == false) goto L17;
        r5 = r6;
    L17:
        boolean r7 = ((Boolean) r5).booleanValue();
        IDriveSdkServiceV2 r8 = (IDriveSdkServiceV2) ServiceManager.get().getService(IDriveSdkServiceV2.class);
        if (r8 == null) goto L25;
        Context r9 = r10.getContext();
        String r11 = r10.d;
        if (r11 != null) goto L23;
        r11 = "url_jump";
    L23:
        if (r8.a(r9, r3, r11) != true) goto L25;
        boolean r12 = true;
    L26:
        if (r12 == false) goto L29;
        FLogger r13 = FLogger.a;
        StringBuilder r14 = new StringBuilder("open by miniapp success: isWiki=");
        r14.append(r7);
        r14.append(", token=");
        int r15 = f.a;
        r14.append(f.b(r10.c));
        r13.i("DriveOpenerImpl", r14.toString());
        return true;
    L29:
        if (r7 == false) goto L32;
        FLogger.a.i("DriveOpenerImpl", "open wiki by miniapp failed, fallback to outer url handling");
        return false;
    L32:
        IDriveSdkService r16 = (IDriveSdkService) ServiceManager.get().getService(IDriveSdkService.class);
        if (r16 != null) goto L36;
        FLogger.a.e("DriveOpenerImpl", "open: IDriveSdkService not available");
        return false;
    L36:
        r16.H(r10.c, null, null);
        return true;
    L25:
        r12 = false;
    L12:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L5:
        if ((!StringsKt.isBlank(r3)) == true) goto L8;
        r3 = null;
    L8:
        if (r3 != null) goto L38;
        goto L9
    }
}
