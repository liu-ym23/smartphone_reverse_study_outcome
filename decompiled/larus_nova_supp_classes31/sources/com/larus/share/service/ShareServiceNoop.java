package com.larus.share.service;

import androidx.fragment.app.DialogFragment;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\tH\u0016J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/larus/share/service/ShareServiceNoop;", "Lcom/larus/share/service/IShareService;", "<init>", "()V", "showSlidesShareFragment", "Landroidx/fragment/app/DialogFragment;", "shareContext", "Lcom/larus/share/bean/SlideShareContext;", "showSheetShareFragment", "Lcom/larus/share/bean/SheetShareContext;", "showDriveShareFragment", "Lcom/larus/share/bean/DriveShareContext;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ShareServiceNoop implements IShareService {
    public ShareServiceNoop() {
    }

    @Override // com.larus.share.service.IShareService
    public final DialogFragment a(kw9.b r1) {
        return null;
    }

    @Override // com.larus.share.service.IShareService
    public final DialogFragment b(kw9.f r1) {
        return null;
    }

    @Override // com.larus.share.service.IShareService
    public final DialogFragment c(kw9.i r1) {
        return null;
    }
}
