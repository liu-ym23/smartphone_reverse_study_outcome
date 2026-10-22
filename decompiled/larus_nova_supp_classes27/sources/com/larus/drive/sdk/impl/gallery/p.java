package com.larus.drive.sdk.impl.gallery;

import com.larus.chat.gallery.api.y;
import com.larus.chat.gallery.impl.preview.toolbar.action.k0;
import com.larus.drive.sdk.api.file.DriveFileItem;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class p implements v79.e {
    public final /* synthetic */ DriveGalleryHelper.DrivePreviewMediaSession a;
    public final /* synthetic */ Function1<y, Unit> b;

    @Override // v79.e
    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "fileToken");
        this.a.f.remove(r2);
        this.a.e.remove(r2);
        this.a.j.add(r2);
        this.a.x();
        this.b.invoke(y.b.a);
    }

    public p(DriveGalleryHelper.DrivePreviewMediaSession r1, k0 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // v79.e
    public final void b(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "fileToken");
        Intrinsics.checkNotNullParameter(r6, "newFileName");
        DriveFileItem r0 = this.a.f.get(r5);
        if (r0 != null) goto L5;
        return;
    L5:
        this.a.f.put(r5, DriveFileItem.a(r0, r6, null, null, 4094));
        this.b.invoke(new y.d(r6));
    }
}
