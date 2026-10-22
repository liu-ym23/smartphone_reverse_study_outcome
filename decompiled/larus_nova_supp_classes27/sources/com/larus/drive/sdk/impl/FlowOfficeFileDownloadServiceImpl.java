package com.larus.drive.sdk.impl;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.larus.drive.sdk.impl.view.operation.download.OfficeCardFileDownloadDialog;
import com.larus.platform.api.IFlowOfficeFileDownloadService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/larus/drive/sdk/impl/FlowOfficeFileDownloadServiceImpl;", "Lcom/larus/platform/api/IFlowOfficeFileDownloadService;", "<init>", "()V", "downloadOriginalFile", "", "fragment", "Landroidx/fragment/app/Fragment;", "fileToken", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowOfficeFileDownloadServiceImpl implements IFlowOfficeFileDownloadService {

    public static final class a {
    }

    static {
    }

    public FlowOfficeFileDownloadServiceImpl() {
    }

    public final boolean a(Fragment r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "fragment");
        Intrinsics.checkNotNullParameter(r5, "fileToken");
        if (StringsKt.isBlank(r5) == false) goto L26;
        return false;
    L26:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
        int r2 = OfficeCardFileDownloadDialog.j;     // Catch: Throwable -> L13
        Intrinsics.checkNotNullParameter(r5, "fileToken");     // Catch: Throwable -> L13
        OfficeCardFileDownloadDialog r0 = new OfficeCardFileDownloadDialog();     // Catch: Throwable -> L13
        Bundle r3 = new Bundle();     // Catch: Throwable -> L13
        r3.putString("file_token", r5);     // Catch: Throwable -> L13
        r0.setArguments(r3);     // Catch: Throwable -> L13
        FragmentManager r6 = r4.getChildFragmentManager();     // Catch: Throwable -> L13
        LandscapeRestrictionOperation r7 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Throwable -> L13
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, "OfficeCardFileDownloadDialog", r7);     // Catch: Throwable -> L13
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r6, r0, r7) == false) goto L24;
    L11:
        Object r8 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L13
    L15:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L18;
        FLogger.a.e("FlowOfficeFileDownload", "[downloadOriginalFile] Failed to show download dialog", r9);
    L18:
        Boolean r10 = Boolean.FALSE;
        if (Result.isFailure-impl(r8) == false) goto L22;
        r8 = r10;
    L22:
        return ((Boolean) r8).booleanValue();
    L24:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L23 Throwable -> L13
    L10:
        r0.show(r6, "OfficeCardFileDownloadDialog");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }
}
