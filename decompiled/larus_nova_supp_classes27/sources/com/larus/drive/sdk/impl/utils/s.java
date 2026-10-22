package com.larus.drive.sdk.impl.utils;

import android.app.Application;
import com.larus.bmhome.share.ShareScene;
import com.larus.common.apphost.AppHost;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s implements v79.b<Boolean> {
    public final /* synthetic */ DriveFileItem a;
    public final /* synthetic */ kw9.c b;

    @Override // v79.b
    public final void onFailure(String r3) {
        Intrinsics.checkNotNullParameter(r3, "error");
        FLogger.a.i("MorePanelHelper", "[shareDriveFile] refresh file permission error;");
        t19.s r4 = t19.s.a;
        Application r0 = AppHost.a.getApplication();
        r4.getClass();
        t19.s.s(r0, 2131899179);
    }

    @Override // v79.b
    public final void onSuccess(Boolean r84) {
        boolean r1 = r84.booleanValue();
        FLogger.a.i("MorePanelHelper", "[shareDriveFile] refresh file permission success; isPublic=" + r1);
        Lazy r2 = MorePanelHelper.a;
        e89.c r3 = MorePanelHelper.c();
        DriveFileItem r4 = this.a;
        String r15 = r4.b;
        int r14 = r4.d;
        ShareScene r13 = ShareScene.DRIVE;
        String r8 = this.b.a;
        String r5 = r4.a;
        int r6 = n.a;
        r3.k(r4, new kw9.d(r15, r14, r13, new com.larus.bmhome.share.panel.h(null, null, null, r8, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r15, r5, n.e(r4.j), n.d(this.a), null, null, null, null, null, null, null, null, false, null, null, null, null, -17, -503316481, 1023)));
    }

    public s(DriveFileItem r1, kw9.c r2) {
        this.a = r1;
        this.b = r2;
    }
}
