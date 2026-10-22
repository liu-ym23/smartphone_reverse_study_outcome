package com.larus.bmhome.chat.referenceicon;

import android.net.Uri;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.upload.h;
import com.larus.bmhome.utils.FileMimeTypeUtils;
import com.larus.bmhome.view.resourcebar.bean.Mode;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.bmhome.view.resourcebar.bean.ResourceType;
import com.larus.common_ui.icon.CommonFileIconType;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.im.bean.message.VideoExtension;
import com.larus.im.bean.message.block.LocalFileType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import yc9.l1;
import yc9.n1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c {
    public static final b a(UplinkFileEntity r8) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        boolean r1 = false;
        if (n1.d(r8) == true) goto L30;
        if (n1.e(r8) == true) goto L30;
        ResourceItemBean r9 = com.larus.bmhome.chat.c.a(r8, Mode.EDIT, 0, 0, 62);
        boolean r0 = Intrinsics.areEqual(r9.getExt().get("local_item_attachment"), "1");
        if (r0 == true) goto L10;
    L12:
        boolean r4 = false;
    L13:
        if (r4 == false) goto L15;
        int r10 = 2131240268;
    L28:
        return new b(null, Integer.valueOf(r10), 1);
    L15:
        if (r0 == false) goto L18;
        h19.b r2 = h19.b.a;
        String r11 = r9.getFileSuffixes();
        r2.getClass();
        r10 = h19.b.a(h19.b.d(r11));
        goto L28
    L18:
        if (r9.getResourceType() != ResourceType.AUDIO) goto L20;
        h19.b r12 = h19.b.a;
        CommonFileIconType r3 = CommonFileIconType.AUDIO;
        r12.getClass();
        r10 = h19.b.a(r3);
        goto L28
    L20:
        HashMap r5 = FileMimeTypeUtils.a;
        String r6 = r9.getMimeType();
        String r7 = r9.getFileSuffixes();
        Object r13 = r9.getExt().get("ext_is_bitable_app");
        if ((r13 instanceof Boolean) == false) goto L23;
        Boolean r14 = (Boolean) r13;
    L24:
        if (r14 == null) goto L26;
        r1 = r14.booleanValue();
    L26:
        r10 = FileMimeTypeUtils.b(r6, r7, r1);
        goto L28
    L23:
        r14 = null;
        goto L24
    L10:
        if (Intrinsics.areEqual(r9.getExt().get("local_item_file_type"), String.valueOf(LocalFileType.LocalFileTypeDirectory.getValue())) == false) goto L12;
        r4 = true;
    L30:
        if (n1.d(r8) == false) goto L32;
        Image r15 = l1.c(r8);
    L40:
        if (r15 == null) goto L43;
        String r16 = r15.localResPath;
        if (r16 == null) goto L43;
    L61:
        if (r16 != null) goto L63;
    L73:
        String r17 = null;
    L75:
        if (n1.e(r8) == false) goto L95;
        String[] r18 = new String[3];
        if (r15 == null) goto L81;
        ImageObj r19 = r15.imageThumb;
        if (r19 == null) goto L81;
        String r20 = r19.url;
    L82:
        r18[0] = r20;
        if (r15 == null) goto L87;
        ImageObj r21 = r15.previewImage;
        if (r21 == null) goto L87;
        String r22 = r21.url;
    L88:
        r18[1] = r22;
        if (r15 == null) goto L93;
        ImageObj r23 = r15.imageOri;
        if (r23 == null) goto L93;
        String r24 = r23.url;
    L94:
        r18[2] = r24;
        List r25 = CollectionsKt.listOf(r18);
    L114:
        if (r15 == null) goto L142;
        String r26 = r15.key;
        if (r26 == null) goto L142;
        if (n1.e(r8) == false) goto L140;
        List r27 = r25;
        if ((r27 instanceof Collection) == true) goto L122;
    L124:
        Iterator r28 = r27.iterator();
    L126:
        if (r28.hasNext() == false) goto L137;
        String r29 = (String) r28.next();
        if (r29 != null) goto L130;
    L133:
        boolean r30 = true;
    L135:
        if ((!r30) == false) goto L126;
        boolean r31 = false;
    L138:
        if (r31 == false) goto L140;
        r1 = true;
        goto L140
    L130:
        if (StringsKt.isBlank(r29) == true) goto L133;
        r30 = false;
    L137:
        r31 = true;
        goto L138
    L122:
        if (r27.isEmpty() == false) goto L124;
    L140:
        if (r1 == false) goto L142;
    L143:
        List r32 = CollectionsKt.createListBuilder();
        r32.add(r17);
        r32.add(r26);
        r32.addAll(r25);
        List r33 = CollectionsKt.filterNotNull(CollectionsKt.build(r32));
        ArrayList r34 = new ArrayList();
        Iterator r35 = r33.iterator();
    L145:
        if (r35.hasNext() == false) goto L150;
        Object r36 = r35.next();
        if ((!StringsKt.isBlank((String) r36)) == false) goto L145;
        r34.add(r36);
        goto L145
    L150:
        return new b(CollectionsKt.distinct(r34), null, 2);
    L142:
        r26 = null;
    L93:
        r24 = null;
    L87:
        r22 = null;
    L81:
        r20 = null;
        goto L82
    L95:
        String[] r37 = new String[3];
        if (r15 == null) goto L100;
        ImageObj r38 = r15.imageThumb;
        if (r38 == null) goto L100;
        String r39 = r38.url;
    L101:
        r37[0] = r39;
        if (r15 == null) goto L106;
        ImageObj r40 = r15.imageOri;
        if (r40 == null) goto L106;
        String r41 = r40.url;
    L107:
        r37[1] = r41;
        if (r15 == null) goto L112;
        ImageObj r42 = r15.previewImage;
        if (r42 == null) goto L112;
        String r43 = r42.url;
    L113:
        r37[2] = r43;
        r25 = CollectionsKt.listOf(r37);
    L112:
        r43 = null;
    L106:
        r41 = null;
    L100:
        r39 = null;
        goto L101
    L63:
        if ((!StringsKt.isBlank(r16)) == true) goto L65;
    L67:
        boolean r44 = false;
    L68:
        if (r44 == true) goto L71;
        r16 = null;
    L71:
        if (r16 == null) goto L73;
        r17 = Uri.fromFile(new PolarisFileWrapper(r16)).toString();
        goto L75
    L65:
        if (new PolarisFileWrapper(r16).exists() == false) goto L67;
        r44 = true;
    L43:
        String r45 = r8.getFileIdentifier();
        if (r45 != null) goto L46;
    L60:
        r16 = null;
        goto L61
    L46:
        if (n1.e(r8) == true) goto L48;
    L50:
        boolean r46 = false;
    L51:
        if (r46 == true) goto L54;
        r45 = null;
    L54:
        if (r45 == null) goto L60;
        mr9.e r47 = h.a.query(r45);
        if (r47 == null) goto L60;
        Image r48 = r47.a;
        if (r48 == null) goto L60;
        r16 = r48.localResPath;
        goto L61
    L48:
        if ((!StringsKt.isBlank(r45)) == false) goto L50;
        r46 = true;
        goto L51
    L32:
        UplinkEntityContent r49 = r8.getUplinkEntityContent();
        if (r49 == null) goto L39;
        UplinkFileInfo r50 = r49.getUplinkFileInfo();
        if (r50 == null) goto L39;
        VideoExtension r51 = r50.getVideo();
        if (r51 == null) goto L39;
        r15 = r51.getCover();
    L39:
        r15 = null;
        goto L40
    }
}
