package com.larus.chat.gallery.api;

import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.platform.model.preview.AttachmentMediaType;
import com.larus.platform.model.preview.AttachmentSendableState;
import com.larus.platform.model.preview.AttachmentSnapshot;
import com.larus.platform.model.preview.AttachmentSource;
import com.larus.platform.model.preview.AttachmentUploadState;
import com.larus.platform.model.preview.ResourceRef;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class p {
    public static final AttachmentSnapshot a(o r23, AttachmentSource r24, int r25) {
        Intrinsics.checkNotNullParameter(r23, "<this>");
        Intrinsics.checkNotNullParameter(r24, MusicAppletPage.KEY_SOURCE);
        ResourceRef r8 = dr9.a.c(r23.b, r23.e, r23.f, 2);
        String r1 = r23.d;
        if (r1 == null) goto L5;
        ResourceRef r2 = dr9.a.c(r1, 0, 0, 14);
    L6:
        ResourceRef r7 = r2;
        String r3 = r23.a;
        if (r23.getType() != PreviewMediaType.VIDEO) goto L9;
        AttachmentMediaType r4 = AttachmentMediaType.VIDEO;
    L10:
        AttachmentMediaType r5 = r4;
        long r14 = r23.g;
        AttachmentUploadState r16 = AttachmentUploadState.NOT_UPLOADED;
        if (r8 == null) goto L13;
        AttachmentSendableState r0 = AttachmentSendableState.NEEDS_MATERIALIZE;
    L15:
        return new AttachmentSnapshot(r3, r24, r5, r8, r7, r8, null, null, null, null, null, r14, r16, null, r25, r0, null, 75712, null);
    L13:
        r0 = AttachmentSendableState.NOT_SENDABLE;
        goto L15
    L9:
        r4 = AttachmentMediaType.IMAGE;
        goto L10
    L5:
        r2 = null;
        goto L6
    }
}
