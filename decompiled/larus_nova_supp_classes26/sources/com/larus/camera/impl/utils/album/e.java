package com.larus.camera.impl.utils.album;

import com.larus.bmhome.chat.component.bottom.attachment.d1;
import com.larus.camera.api.params.BaseResultParam;
import com.larus.camera.api.params.OutputParam;
import com.larus.camera.impl.ui.viewmodel.t;
import com.larus.camera.impl.utils.CameraData;
import com.larus.platform.model.album.AlbumInputState;
import com.larus.platform.model.preview.AttachmentEditState;
import com.larus.platform.model.preview.AttachmentEditType;
import com.larus.platform.model.preview.AttachmentMediaType;
import com.larus.platform.model.preview.AttachmentSendableState;
import com.larus.platform.model.preview.AttachmentSnapshot;
import com.larus.platform.model.preview.AttachmentSource;
import com.larus.platform.model.preview.AttachmentUploadState;
import com.larus.platform.model.preview.InputDraftSnapshot;
import com.larus.platform.model.preview.ResourceRef;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e {
    public static final List<AttachmentSnapshot> b() {
        t r0 = t.a;
        List r1 = t.f();
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
        int r19 = 0;
    L4:
        if (r3.hasNext() == false) goto L80;
        Object r4 = r3.next();
        int r24 = r19 + 1;
        if (r19 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        OutputParam r5 = (OutputParam) r4;
        boolean r6 = r5.isVideo();
        String r7 = r5.getSrcAlbumUri();
        Map r8 = null;
        if (r7 != null) goto L11;
    L13:
        r7 = null;
    L14:
        String r9 = r5.getPath();
        if ((!StringsKt.isBlank(r9)) == true) goto L19;
        r9 = null;
    L19:
        if (r5.isImageMarked() == false) goto L21;
    L24:
        boolean r10 = true;
    L25:
        if (r10 == true) goto L30;
        if (r7 == null) goto L30;
        r9 = r7;
    L30:
        if (r9 == null) goto L77;
        if (r7 == null) goto L34;
        AttachmentSource r11 = AttachmentSource.LOCAL_ALBUM;
    L35:
        if (r6 == false) goto L37;
        BaseResultParam r12 = r5.getVideoParam();
    L38:
        int r13 = r12.getWidth();
        if (r6 == false) goto L41;
        BaseResultParam r14 = r5.getVideoParam();
    L42:
        ResourceRef r15 = dr9.a.c(r9, r13, r14.getHeight(), 2);
        if (r15 == null) goto L77;
        StringBuilder r16 = new StringBuilder("camera_capture:");
        t r17 = t.a;
        r16.append(t.g(r5));
        String r18 = r16.toString();
        if (r6 == false) goto L48;
        AttachmentMediaType r110 = AttachmentMediaType.VIDEO;
    L50:
        if (r6 == false) goto L52;
        BaseResultParam r111 = r5.getVideoParam();
    L53:
        Long r112 = Long.valueOf(r111.getSize());
        if (r6 == false) goto L56;
        long r20 = r5.getVideoParam().getDuration();
    L57:
        AttachmentUploadState r25 = AttachmentUploadState.NOT_UPLOADED;
        if (r10 == true) goto L60;
        AttachmentEditState r26 = null;
    L65:
        AttachmentSendableState r27 = AttachmentSendableState.NEEDS_MATERIALIZE;
        if (r7 != null) goto L68;
    L73:
        if (r8 != null) goto L75;
        Map r28 = MapsKt.emptyMap();
    L76:
        r8 = new AttachmentSnapshot(r18, r11, r110, r15, null, r15, null, null, r112, null, null, r20, r25, r26, r19, r27, r28, 1744, null);
        goto L77
    L75:
        r28 = r8;
        goto L76
    L68:
        if ((!StringsKt.isBlank(r7)) == true) goto L71;
        r7 = null;
    L71:
        if (r7 == null) goto L73;
        r8 = MapsKt.mapOf(TuplesKt.to("preview_attachment_source_media_uri", r7));
        goto L73
    L60:
        if (r5.isImageMarked() == false) goto L62;
        AttachmentEditType r21 = AttachmentEditType.MARK;
    L63:
        r26 = new AttachmentEditState(r15, r18, r21);
        goto L65
    L62:
        r21 = AttachmentEditType.CROP;
        goto L63
    L56:
        r20 = 0;
        goto L57
    L52:
        r111 = r5.getImageParam();
        goto L53
    L48:
        r110 = AttachmentMediaType.IMAGE;
        goto L50
    L41:
        r14 = r5.getImageParam();
        goto L42
    L37:
        r12 = r5.getImageParam();
        goto L38
    L34:
        r11 = AttachmentSource.CAMERA;
    L77:
        if (r8 == null) goto L79;
        r2.add(r8);
    L79:
        r19 = r24;
        goto L4
    L21:
        if (r5.isImageCropped() == true) goto L24;
        r10 = false;
        goto L25
    L11:
        if ((!StringsKt.isBlank(r7)) == false) goto L13;
    L80:
        return r2;
    }

    public static final AlbumInputState a(CameraData r31) {
        Intrinsics.checkNotNullParameter(r31, "cameraData");
        dr9.g r0 = dr9.g.a;
        InputDraftSnapshot r1 = dr9.g.d(r31.getAlbumInputSnapshotId());
        String r2 = r31.getAlbumInputSnapshotId();
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        String r5 = null;
        if (r3 == true) goto L13;
        if (r1 != null) goto L13;
        return null;
    L13:
        List<AttachmentSnapshot> r4 = b();
        if (r1 == null) goto L16;
    L19:
        if (r1 == null) goto L21;
        List r6 = r1.getAttachments();
    L22:
        if (r6 != null) goto L24;
        r6 = CollectionsKt.emptyList();
    L24:
        List r7 = r6;
        if (r7.isEmpty() == false) goto L38;
        List<String> r8 = r31.getAlbumAttachmentUris();
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r10 = r8.iterator();
        int r24 = 0;
    L28:
        if (r10.hasNext() == false) goto L37;
        Object r11 = r10.next();
        int r29 = r24 + 1;
        if (r24 >= 0) goto L32;
        CollectionsKt.throwIndexOverflow();
    L32:
        String r12 = (String) r11;
        AttachmentSource r13 = AttachmentSource.LOCAL_ALBUM;
        ResourceRef r14 = dr9.a.c(r12, 0, 0, 14);
        AttachmentMediaType r15 = AttachmentMediaType.IMAGE;
        AttachmentUploadState r23 = AttachmentUploadState.NOT_UPLOADED;
        if (r14 == null) goto L35;
        AttachmentSendableState r16 = AttachmentSendableState.NEEDS_MATERIALIZE;
    L36:
        r9.add(new AttachmentSnapshot(r12, r13, r15, r14, null, r14, null, null, null, null, null, 0, r23, null, r24, r16, null, 77776, null));
        r24 = r29;
        goto L28
    L35:
        r16 = AttachmentSendableState.NOT_SENDABLE;
        goto L36
    L37:
        r7 = r9;
    L38:
        LinkedHashSet r17 = new LinkedHashSet();
        LinkedHashSet r18 = new LinkedHashSet();
        List r19 = CollectionsKt.createListBuilder();
        Iterator r20 = CollectionsKt.plus(r7, r4).iterator();
    L40:
        if (r20.hasNext() == false) goto L60;
        AttachmentSnapshot r21 = (AttachmentSnapshot) r20.next();
        String r22 = d1.c(r21);
        if (r22 != null) goto L48;
        ResourceRef r25 = r21.effectiveRef();
        if (r25 == null) goto L46;
        r22 = r25.getUri();
        goto L48
    L46:
        r22 = null;
    L48:
        if (r17.add(r21.getStableId()) == false) goto L40;
        if (r22 != null) goto L51;
    L54:
        boolean r110 = true;
    L55:
        if (r110 == true) goto L59;
        if (r18.add(r22) == false) goto L40;
    L59:
        r19.add(AttachmentSnapshot.copy$default(r21, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, r19.size(), null, null, 114687, null));
        goto L40
    L51:
        if (StringsKt.isBlank(r22) == true) goto L54;
        r110 = false;
        goto L55
    L60:
        List r111 = CollectionsKt.build(r19);
        if (r1 == null) goto L64;
        String r26 = r1.getText();
        if (r26 == null) goto L64;
    L65:
        String r112 = r26;
        String r27 = r31.getAlbumInputSourceNodeId();
        if (StringsKt.isBlank(r27) == false) goto L72;
        if (r1 == null) goto L69;
        r5 = r1.getSourceNodeId();
    L69:
        if (r5 != null) goto L71;
        r5 = "";
    L71:
        String r113 = r5;
    L74:
        return new AlbumInputState(r112, r111, r113, r31.getAlbumInputSnapshotId(), null, 16, null);
    L72:
        r113 = r27;
    L64:
        r26 = r31.getAlbumInputText();
        goto L65
    L21:
        r6 = null;
        goto L22
    L16:
        if (((ArrayList) r4).isEmpty() == false) goto L19;
        return new AlbumInputState(r31.getAlbumInputText(), null, r31.getAlbumInputSourceNodeId(), null, r31.getAlbumAttachmentUris(), 10, null);
    L5:
        if (StringsKt.isBlank(r2) == true) goto L8;
        r3 = false;
        goto L9
    }
}
