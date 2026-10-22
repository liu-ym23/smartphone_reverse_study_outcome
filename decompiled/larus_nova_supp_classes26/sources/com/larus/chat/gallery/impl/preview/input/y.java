package com.larus.chat.gallery.impl.preview.input;

import com.larus.bmhome.chat.component.bottom.attachment.d1;
import com.larus.bmhome.chat.tips.GuidePriority;
import com.larus.camera.api.params.InputParam;
import com.larus.camera.api.params.InputParamExtra;
import com.larus.chat.gallery.api.PreviewMediaType;
import com.larus.chat.gallery.impl.preview.data.SourceType;
import com.larus.gallery.api.GalleryType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.model.preview.AttachmentSendableState;
import com.larus.platform.model.preview.AttachmentSnapshot;
import com.larus.platform.model.preview.AttachmentSource;
import com.larus.platform.model.preview.AttachmentUploadState;
import com.larus.platform.model.preview.InputDraftSnapshot;
import com.larus.platform.model.preview.ResourceRef;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class y {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SourceType.values().length];
            r0[SourceType.ALBUM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[SourceType.CAMERA_RESULT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r0[SourceType.ATTACHMENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[SourceType.CLOUD_DRIVE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r0[SourceType.CREATION_RECORD.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r0[SourceType.USER_SEND.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r0[SourceType.BOT_RESP.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[SourceType.CREATION_CARD.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            a = r0;
        }
    }

    static {
    }

    public y() {
    }

    public static void a(InputDraftSnapshot r2, InputParam r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "snapshot");
        Intrinsics.checkNotNullParameter(r3, "inputParam");
        Intrinsics.checkNotNullParameter(r4, "snapshotId");
        InputParamExtra r0 = r3.getExtra();
        if (r0 != null) goto L5;
        r0 = new InputParamExtra();
        r3.setExtra(r0);
    L5:
        r0.put("ALBUM_INPUT_SNAPSHOT_ID", r4);
        r0.put("ALBUM_INPUT_SOURCE_NODE_ID", r2.getSourceNodeId());
        r3.setAlbumInputText(r2.getText());
        List r5 = r2.getAttachments();
        ArrayList r6 = new ArrayList();
        Iterator r7 = r5.iterator();
    L7:
        if (r7.hasNext() == false) goto L14;
        ResourceRef r1 = ((AttachmentSnapshot) r7.next()).effectiveRef();
        if (r1 == null) goto L11;
        String r8 = r1.getUri();
    L12:
        if (r8 == null) goto L7;
        r6.add(r8);
        goto L7
    L11:
        r8 = null;
        goto L12
    L14:
        r3.setAlbumAttachmentUris(CollectionsKt.distinct(r6));
    }

    public static InputDraftSnapshot b(com.larus.chat.gallery.api.q r34, String r35, xy8.d r36, boolean r37, Set r38) {
        Intrinsics.checkNotNullParameter(r35, "fallbackText");
        Intrinsics.checkNotNullParameter(r36, "currentData");
        Intrinsics.checkNotNullParameter(r38, "excludedStableIds");
        if (r34 == null) goto L6;
        String r3 = r34.k();
        if (r3 == null) goto L6;
    L7:
        String r7 = r3;
        if (r34 == null) goto L13;
        InputDraftSnapshot r0 = r34.i(r7);
        if (r0 == null) goto L13;
        InputDraftSnapshot r4 = r0;
    L14:
        List r1 = CollectionsKt.createListBuilder();
        r1.addAll(r4.getAttachments());
        if (r37 == false) goto L174;
        Intrinsics.checkNotNullParameter(r36, "<this>");
        boolean r8 = true;
        if (r36.e != GalleryType.Video) goto L19;
        boolean r5 = true;
    L20:
        String r14 = r36.b;
        AttachmentSnapshot r6 = null;
        if (r5 == false) goto L39;
        xy8.g r9 = r36.d;
        if (r9 == null) goto L26;
        String r10 = r9.f;
        if (r10 == null) goto L26;
    L53:
        String r15 = r10;
    L54:
        if (r5 == false) goto L58;
        xy8.g r11 = r36.d;
        if (r11 == null) goto L62;
        String r12 = r11.d;
    L61:
        String r17 = r12;
    L63:
        if (r5 == false) goto L65;
        PreviewMediaType r13 = PreviewMediaType.VIDEO;
    L66:
        PreviewMediaType r16 = r13;
        if (r5 == false) goto L71;
        xy8.g r18 = r36.d;
        if (r18 == null) goto L75;
        int r19 = r18.j;
    L74:
        int r110 = r19;
    L76:
        if (r5 == false) goto L80;
        xy8.g r20 = r36.d;
        if (r20 == null) goto L84;
        int r21 = r20.k;
    L83:
        int r111 = r21;
    L85:
        xy8.g r22 = r36.d;
        if (r22 == null) goto L88;
        double r23 = r22.l;
    L89:
        com.larus.chat.gallery.api.o r24 = new com.larus.chat.gallery.api.o(r14, r15, r16, r17, r110, r111, (long) (r23 * ((double) GuidePriority.COMMERCE_CREDIT_PRIORITY)));
        if (StringsKt.isBlank(r24.b) == false) goto L93;
    L172:
        if (r6 == null) goto L174;
        r1.add(r6);
        goto L174
    L93:
        switch(a.a[r36.a.ordinal()]) {
            case 1: goto L101;
            case 2: goto L100;
            case 3: goto L99;
            case 4: goto L98;
            case 5: goto L97;
            case 6: goto L96;
            case 7: goto L96;
            case 8: goto L96;
            default: goto L95;
        };
    L96:
        AttachmentSource r25 = AttachmentSource.MESSAGE_REMOTE;
    L102:
        String r26 = r36.i;
        if (r26 != null) goto L105;
        r26 = r36.b;
    L105:
        String r112 = r26;
        xy8.f r27 = r36.l;
        if (r27 == null) goto L124;
        List<UplinkFileEntity> r28 = r27.f;
        if (r28 == null) goto L124;
        Iterator<T> r29 = r28.iterator();
    L111:
        if (r29.hasNext() == false) goto L120;
        Object r113 = r29.next();
        UplinkFileEntity r114 = (UplinkFileEntity) r113;
        String r115 = r36.l.e;
        if (r115 != null) goto L115;
    L117:
        boolean r116 = false;
    L118:
        if (r116 == false) goto L111;
    L121:
        UplinkFileEntity r117 = (UplinkFileEntity) r113;
        if (r117 == null) goto L124;
    L130:
        if (r117 == null) goto L132;
        r6 = AttachmentSnapshot.copy$default(d1.d(r117, 0, r25), r112, null, null, null, null, null, null, null, null, null, null, 0, null, null, 0, null, null, 131070, null);
        goto L172
    L132:
        xy8.b r30 = r36.c;
        if (r30 == null) goto L139;
        String r31 = r30.h;
        if (r31 == null) goto L139;
        if ((!StringsKt.isBlank(r31)) == false) goto L139;
    L140:
        xy8.g r118 = r36.d;
        if (r118 == null) goto L147;
        String r119 = r118.i;
        if (r119 == null) goto L147;
        if ((!StringsKt.isBlank(r119)) == false) goto L147;
        String r210 = r119;
    L148:
        if (r31 != null) goto L152;
        if (r210 != null) goto L152;
        r8 = false;
    L152:
        AttachmentSnapshot r120 = com.larus.chat.gallery.api.p.a(r24, r25, 0);
        ResourceRef r121 = r120.getDisplayRef();
        if (r121 == null) goto L155;
        ResourceRef r122 = ResourceRef.copy$default(r121, null, null, r31, 0, 0, 27, null);
    L156:
        ResourceRef r123 = r120.getOriginRef();
        if (r123 == null) goto L159;
        ResourceRef r124 = ResourceRef.copy$default(r123, null, null, r31, 0, 0, 27, null);
    L160:
        xy8.g r2 = r36.d;
        if (r2 == null) goto L163;
        r6 = r2.c;
    L163:
        AttachmentSnapshot r211 = r6;
        if (r8 == false) goto L166;
        AttachmentUploadState r32 = AttachmentUploadState.UPLOADED;
    L167:
        AttachmentUploadState r212 = r32;
        if (r8 == false) goto L170;
        AttachmentSendableState r33 = AttachmentSendableState.SENDABLE;
    L171:
        r6 = AttachmentSnapshot.copy$default(r120, r112, null, null, r122, null, r124, null, null, null, r210, r211, 0, r212, null, 0, r33, null, 92630, null);
        goto L172
    L170:
        r33 = r120.getSendableState();
        goto L171
    L166:
        r32 = r120.getUploadState();
        goto L167
    L159:
        r124 = null;
        goto L160
    L155:
        r122 = null;
    L147:
        r210 = null;
    L139:
        r31 = null;
        goto L140
    L115:
        if (Intrinsics.areEqual(r115, r114.getFileIdentifier()) != true) goto L117;
        r116 = true;
        goto L118
    L120:
        r113 = null;
    L124:
        xy8.f r39 = r36.l;
        if (r39 == null) goto L129;
        List<UplinkFileEntity> r40 = r39.f;
        if (r40 == null) goto L129;
        r117 = (UplinkFileEntity) CollectionsKt.singleOrNull(r40);
    L129:
        r117 = null;
        goto L130
    L97:
        r25 = AttachmentSource.PRIVATE_ALBUM;
        goto L102
    L98:
        r25 = AttachmentSource.CLOUD_DRIVE;
        goto L102
    L99:
        r25 = AttachmentSource.FILE;
        goto L102
    L100:
        r25 = AttachmentSource.CAMERA;
        goto L102
    L101:
        r25 = AttachmentSource.LOCAL_ALBUM;
        goto L102
    L95:
        throw new NoWhenBranchMatchedException();
    L88:
        r23 = 0.0d;
    L84:
        r111 = 0;
        goto L85
    L80:
        xy8.b r41 = r36.c;
        if (r41 == null) goto L84;
        r21 = r41.j;
    L75:
        r110 = 0;
        goto L76
    L71:
        xy8.b r42 = r36.c;
        if (r42 == null) goto L75;
        r19 = r42.i;
        goto L74
    L65:
        r13 = PreviewMediaType.IMAGE;
    L62:
        r17 = null;
        goto L63
    L58:
        xy8.b r43 = r36.c;
        if (r43 == null) goto L62;
        r12 = r43.b;
    L26:
        if (r9 == null) goto L28;
        r10 = r9.p;
    L29:
        if (r10 != null) goto L53;
        if (r9 == null) goto L32;
        r10 = r9.b;
    L33:
        if (r10 != null) goto L53;
        if (r9 == null) goto L36;
        String r44 = r9.d;
    L37:
        if (r44 == null) goto L51;
    L52:
        r15 = r44;
    L51:
        r44 = "";
        goto L52
    L36:
        r44 = null;
        goto L37
    L32:
        r10 = null;
        goto L33
    L28:
        r10 = null;
        goto L29
    L39:
        xy8.b r45 = r36.c;
        if (r45 == null) goto L43;
        r10 = r45.a;
        if (r10 != null) goto L53;
    L43:
        if (r45 == null) goto L45;
        r10 = r45.c;
    L46:
        if (r10 != null) goto L53;
        if (r45 == null) goto L49;
        r44 = r45.d;
    L50:
        if (r44 != null) goto L52;
    L49:
        r44 = null;
        goto L50
    L45:
        r10 = null;
        goto L46
    L19:
        r5 = false;
    L174:
        List r46 = CollectionsKt.build(r1);
        ArrayList r47 = new ArrayList();
        Iterator r48 = r46.iterator();
    L176:
        if (r48.hasNext() == false) goto L180;
        Object r49 = r48.next();
        if (r38.contains(((AttachmentSnapshot) r49).getStableId()) == true) goto L176;
        r47.add(r49);
        goto L176
    L180:
        HashSet r50 = new HashSet();
        ArrayList r51 = new ArrayList();
        Iterator r52 = r47.iterator();
    L182:
        if (r52.hasNext() == false) goto L186;
        Object r53 = r52.next();
        if (r50.add(((AttachmentSnapshot) r53).getStableId()) == false) goto L182;
        r51.add(r53);
        goto L182
    L186:
        ArrayList r54 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r51, 10));
        Iterator r55 = r51.iterator();
        int r213 = 0;
    L188:
        if (r55.hasNext() == false) goto L194;
        Object r56 = r55.next();
        int r57 = r213 + 1;
        if (r213 >= 0) goto L192;
        CollectionsKt.throwIndexOverflow();
    L192:
        r54.add(AttachmentSnapshot.copy$default((AttachmentSnapshot) r56, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, r213, null, null, 114687, null));
        r213 = r57;
        goto L188
    L194:
        return InputDraftSnapshot.copy$default(r4, r35, r54, null, 0, 12, null);
    L13:
        r4 = new InputDraftSnapshot(r35, null, r7, 0, 10, null);
    L6:
        r3 = "preview#" + r36.a.name().toLowerCase(Locale.ROOT) + '#' + r36.b;
        goto L7
    }
}
