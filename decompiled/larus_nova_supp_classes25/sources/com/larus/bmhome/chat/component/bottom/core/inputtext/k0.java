package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.net.Uri;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.block.AttachmentItem;
import com.larus.im.bean.message.block.AttachmentType;
import com.larus.im.bean.message.block.UploadFile;
import com.larus.im.bean.message.block.UploadImage;
import com.larus.im.bean.message.block.UploadLarkDoc;
import com.larus.im.bean.message.block.UploadMedia;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k0 {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[InputReferenceType.values().length];
            r0[InputReferenceType.CONTACT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[InputReferenceType.GROUP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[InputReferenceType.SKILL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final String a(d0 r2) {
        if (r2.getType() == InputReferenceType.CONTACT) goto L9;
        if (r2.getType() == InputReferenceType.GROUP) goto L9;
        return r2.b;
    L9:
        return "@" + r2.b;
    }

    public static final com.larus.bmhome.chat.component.bottom.core.inputtext.a b(UplinkFileEntity r5) {
        AttachmentItem r0 = ic8.h.a(r5);
        String r1 = yc9.l1.h(r5);
        Integer r2 = null;
        if (r1 != null) goto L5;
    L9:
        r1 = yc9.l1.g(r5);
        if (r1 != null) goto L12;
    L14:
        r1 = null;
    L15:
        if (r0 == null) goto L17;
        Integer r6 = Integer.valueOf(r0.getType());
    L18:
        int r3 = AttachmentType.AttachmentTypeImage.getValue();
        if (r6 != null) goto L22;
    L34:
        int r4 = AttachmentType.AttachmentTypeVideo.getValue();
        if (r6 != null) goto L38;
    L49:
        int r7 = AttachmentType.AttachmentTypeFile.getValue();
        if (r6 != null) goto L53;
    L64:
        int r8 = AttachmentType.AttachmentTypeLarkDoc.getValue();
        if (r6 != null) goto L68;
    L79:
        r1 = null;
    L81:
        if (r0 == null) goto L84;
        r2 = Integer.valueOf(r0.getType());
    L84:
        return new com.larus.bmhome.chat.component.bottom.core.inputtext.a(r1, r2);
    L68:
        if (r6.intValue() != r8) goto L79;
        UploadLarkDoc r9 = r0.getLarkDoc();
        if (r9 == null) goto L81;
        String r10 = r9.getToken();
        if (r10 == null) goto L81;
        if ((!StringsKt.isBlank(r10)) == true) goto L77;
        r10 = null;
    L77:
        if (r10 == null) goto L81;
    L33:
        r1 = r10;
        goto L81
    L53:
        if (r6.intValue() != r7) goto L64;
        UploadFile r11 = r0.getFile();
        if (r11 == null) goto L81;
        r10 = r11.getUri();
        if (r10 == null) goto L81;
        if ((!StringsKt.isBlank(r10)) == true) goto L62;
        r10 = null;
    L62:
        if (r10 != null) goto L33;
    L38:
        if (r6.intValue() != r4) goto L49;
        UploadMedia r12 = r0.getMedia();
        if (r12 == null) goto L81;
        r10 = r12.getResourceUri();
        if (r10 == null) goto L81;
        if ((!StringsKt.isBlank(r10)) == true) goto L47;
        r10 = null;
    L47:
        if (r10 != null) goto L33;
    L22:
        if (r6.intValue() != r3) goto L34;
        UploadImage r13 = r0.getImage();
        if (r13 == null) goto L81;
        r10 = r13.getUri();
        if (r10 == null) goto L81;
        if ((!StringsKt.isBlank(r10)) == true) goto L31;
        r10 = null;
    L31:
        if (r10 != null) goto L33;
    L17:
        r6 = null;
        goto L18
    L12:
        if ((!StringsKt.isBlank(r1)) == false) goto L14;
    L5:
        if ((!StringsKt.isBlank(r1)) == true) goto L8;
        r1 = null;
    L8:
        if (r1 != null) goto L15;
        goto L9
    }

    public static final Integer c(InputReferenceType r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        int r2 = a.a[r1.ordinal()];
        if (r2 != 1) goto L5;
    L10:
        return null;
    L5:
        if (r2 == 2) goto L10;
        if (r2 == 3) goto L13;
        return 2131241523;
    L13:
        return 2131242112;
    }

    public static final d0 d(id8.f r19) {
        Intrinsics.checkNotNullParameter(r19, "<this>");
        UplinkFileEntity r1 = id8.d.c(r19);
        com.larus.bmhome.chat.component.bottom.core.inputtext.a r2 = b(r1);
        Integer r3 = r1.getUpLinkStatus();
        int r4 = UpLinkState.SUCCESS.getValue();
        boolean r5 = false;
        if (r3 != null) goto L6;
    L8:
        boolean r6 = false;
    L9:
        String r7 = null;
        if (r6 == false) goto L12;
        com.larus.bmhome.chat.component.bottom.core.inputtext.a r8 = r2;
    L13:
        if (r8 == null) goto L17;
        String r9 = r8.a();
        if (r9 == null) goto L17;
    L40:
        String r11 = r9;
    L42:
        id8.c r10 = r19.b;
        if (r10 == null) goto L54;
        id8.g r12 = r10.a;
        if (r12 == null) goto L54;
        String r13 = r12.a;
        if (r13 == null) goto L54;
        if ((!StringsKt.isBlank(r13)) == true) goto L52;
        r13 = null;
    L52:
        if (r13 == null) goto L54;
    L63:
        String r14 = r13;
    L65:
        String r0 = r19.c;
        String r15 = "";
        if (r0 != null) goto L69;
        r0 = "";
    L69:
        if (StringsKt.isBlank(r0) == false) goto L74;
        if (r11 == null) goto L73;
        r15 = r11;
    L73:
        String r16 = r15;
    L76:
        return new d0(r16, r14, InputReferenceType.ATTACHMENT, r11, null, null, null, com.larus.bmhome.chat.referenceicon.c.a(r1), null, null, 880);
    L74:
        r16 = r0;
    L54:
        Uri r17 = r19.i;
        if (r17 == null) goto L61;
        String r18 = r17.getLastPathSegment();
        if (r18 == null) goto L61;
        if ((!StringsKt.isBlank(r18)) == false) goto L61;
        r7 = r18;
    L61:
        if (r7 != null) goto L64;
        r13 = AppHost.a.getApplication().getString(2131906688);
        goto L63
    L64:
        r14 = r7;
    L17:
        String r20 = r19.c;
        if (r20 != null) goto L20;
    L41:
        r11 = null;
        goto L42
    L20:
        if ((!StringsKt.isBlank(r20)) == true) goto L23;
        r20 = null;
    L23:
        if (r20 == null) goto L41;
        Integer r21 = r2.getType();
        if (r21 != null) goto L27;
    L39:
        r9 = null;
        goto L40
    L27:
        if (r21.intValue() <= 0) goto L29;
        r5 = true;
    L29:
        if (r5 == true) goto L32;
        r21 = null;
    L32:
        if (r21 == null) goto L39;
        int r22 = r21.intValue();
        if ((!StringsKt.isBlank(r20)) == true) goto L37;
        r20 = null;
    L37:
        if (r20 == null) goto L39;
        r9 = new Uri.Builder().scheme("attachment").authority(r20).appendQueryParameter("type", String.valueOf(r22)).build().toString();
        goto L40
    L12:
        r8 = null;
        goto L13
    L6:
        if (r3.intValue() != r4) goto L8;
        r6 = true;
        goto L9
    }
}
