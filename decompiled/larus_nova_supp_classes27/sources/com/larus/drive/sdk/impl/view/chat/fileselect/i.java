package com.larus.drive.sdk.impl.view.chat.fileselect;

import com.larus.drive.sdk.impl.view.chat.fileselect.adapter.ChatRecentFileSelectAdapter;
import com.larus.platform.api.FlowDriveFileType;
import com.larus.platform.api.fileselect.IChatFileSelectionStore;
import com.larus.platform.model.OfficeAskDoubaoType;
import com.larus.platform.model.chat.UploadFilePolicy;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import yc9.l1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class i implements ChatRecentFileSelectAdapter.b {
    public final /* synthetic */ ChatFileSelectDialog a;

    public i(ChatFileSelectDialog r1) {
        this.a = r1;
    }

    @Override // com.larus.drive.sdk.impl.view.chat.fileselect.adapter.ChatRecentFileSelectAdapter.b
    public final IChatFileSelectionStore.a a(com.larus.platform.api.u r5) {
        Intrinsics.checkNotNullParameter(r5, "item");
        if (((aq9.e) this.a.l.f.getValue()).b == true) goto L5;
        this.a.getClass();
        int r0 = bq9.a.a;
        Map r1 = r5.m;
        if (r1 == null) goto L9;
        String r2 = (String) r1.get("originFileTypeString");
    L11:
        if (l1.k(r2) == false) goto L45;
        this.a.getClass();
        int r3 = r5.h;
        if (r3 != 2) goto L15;
    L32:
        OfficeAskDoubaoType r4 = OfficeAskDoubaoType.DOC;
    L33:
        if (r4 == null) goto L37;
        boolean r6 = true;
        if (z2.a.getLarkDriveConfigV2().f(r4) != true) goto L37;
    L38:
        if (r6 == false) goto L43;
        if (AccountService.a.isLogin().booleanValue() == false) goto L43;
        return null;
    L43:
        return new IChatFileSelectionStore.a.e(r5.f);
    L37:
        r6 = false;
        goto L38
    L15:
        if (r3 != 3) goto L17;
        r4 = OfficeAskDoubaoType.SHEET;
        goto L33
    L17:
        if (r3 != 8) goto L19;
        r4 = OfficeAskDoubaoType.BITABLE;
        goto L33
    L19:
        if (r3 == 22) goto L32;
        if (r3 != 30) goto L23;
        r4 = OfficeAskDoubaoType.PPT;
        goto L33
    L23:
        if (r3 != 11) goto L25;
        r4 = OfficeAskDoubaoType.MINDNOTE;
        goto L33
    L25:
        if (r3 == 12) goto L27;
        r4 = null;
        goto L33
    L27:
        r4 = OfficeAskDoubaoType.FILE;
        goto L33
    L45:
        if (UploadFilePolicy.e(StringsKt.substringAfterLast(r5.b, '.', "").toLowerCase(Locale.ROOT)) == true) goto L49;
        return new IChatFileSelectionStore.a.e(r5.f);
    L49:
        if (UploadFilePolicy.f(r5.c) == false) goto L51;
        return null;
    L51:
        return new IChatFileSelectionStore.a.a(UploadFilePolicy.d());
    L9:
        r2 = null;
        goto L11
    L5:
        return new IChatFileSelectionStore.a.d(FlowDriveFileType.IMAGE, FlowDriveFileType.FILE);
    }

    @Override // com.larus.drive.sdk.impl.view.chat.fileselect.adapter.ChatRecentFileSelectAdapter.b
    public final void b(boolean r3) {
        ChatFileSelectDialog r0 = this.a;
        if (r3 == false) goto L5;
        ChatFileSelectDialog.RecentListUiState r4 = ChatFileSelectDialog.RecentListUiState.SUCCESS;
    L6:
        int r1 = ChatFileSelectDialog.o;
        r0.T90(r4);
        return;
    L5:
        r4 = ChatFileSelectDialog.RecentListUiState.EMPTY;
        goto L6
    }

    @Override // com.larus.drive.sdk.impl.view.chat.fileselect.adapter.ChatRecentFileSelectAdapter.b
    public final void c(com.larus.platform.api.u r3, IChatFileSelectionStore.a r4) {
        Intrinsics.checkNotNullParameter(r3, "item");
        if (r4 != null) goto L5;
        return;
    L5:
        ChatFileSelectDialog r0 = this.a;
        int r1 = ChatFileSelectDialog.o;
        r0.U90(r4, r3);
    }

    @Override // com.larus.drive.sdk.impl.view.chat.fileselect.adapter.ChatRecentFileSelectAdapter.b
    public final void d(com.larus.platform.api.u r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "item");
        if (r4 == false) goto L5;
        IChatFileSelectionStore.b r5 = this.a.l.c(r3, IChatFileSelectionStore.Source.RECENT);
    L7:
        if ((r5 instanceof IChatFileSelectionStore.b.b) == false) goto L10;
        ChatFileSelectDialog r0 = this.a;
        IChatFileSelectionStore.a r6 = ((IChatFileSelectionStore.b.b) r5).a;
        int r1 = ChatFileSelectDialog.o;
        r0.U90(r6, r3);
        return;
    L10:
        return;
    L5:
        r5 = this.a.l.a(r3.a, IChatFileSelectionStore.Source.RECENT);
        goto L7
    }
}
