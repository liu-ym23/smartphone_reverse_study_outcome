package com.larus.uaigc.chat.block.create;

import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.ImageData;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import com.larus.uaigc.service.ICreationMetadataService;
import org.json.JSONObject;
import tx9.b2;
import tx9.c2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class q {
    public static final boolean a(wc9.e r4) {
        if (r4 == null) goto L10;
        Integer r2 = r4.j;
        if (r2 == null) goto L10;
        if (r2.intValue() != 2) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L13;
    L14:
        return true;
    L13:
        if (ic8.n.q(r4) == true) goto L14;
        return false;
    L10:
        r3 = false;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final ImageInfo c(CreationItem r5) {
        ImageData r0 = r5.image;
        if (r0 != null) goto L6;
        return null;
    L6:
        CreationNoWatermarkManager r1 = CreationNoWatermarkManager.a;
        String r2 = r0.imageUri;
        if (r2 != null) goto L9;
        r2 = r0.key;
    L9:
        ImageInfo r3 = (ImageInfo) r1.U(r2, bz9.a.j(r0, r5.genDetail), true).a;
        if (r3 == null) goto L12;
        return r3;
    L12:
        return bz9.a.j(r0, r5.genDetail);
    }

    public static final String d(CreationItem r6, ImageInfo r7) {
        String r0 = null;
        if (r7 == null) goto L7;
        Image r1 = r7.c;
        if (r1 == null) goto L7;
        String r2 = bz9.a.b(r1);
    L8:
        String r3 = "";
        if (r2 != null) goto L11;
        r2 = "";
    L11:
        boolean r4 = true;
        if (r2.length() != 0) goto L14;
        boolean r5 = true;
    L15:
        if (r5 == false) goto L25;
        if (r7 == null) goto L20;
        Image r8 = r7.b;
        if (r8 == null) goto L20;
        String r9 = bz9.a.b(r8);
    L21:
        if (r9 != null) goto L23;
        r2 = "";
        goto L25
    L23:
        r2 = r9;
    L20:
        r9 = null;
    L25:
        if (r2.length() == 0) goto L28;
        r4 = false;
    L28:
        if (r4 == false) goto L37;
        ImageData r10 = r6.image;
        if (r10 == null) goto L32;
        r0 = bz9.a.c(r10);
    L32:
        if (r0 == null) goto L36;
        r3 = r0;
    L36:
        return r3;
    L37:
        return r2;
    L14:
        r5 = false;
    L7:
        r2 = null;
        goto L8
    }

    public static final JSONObject b(Message r3, CreationItem r4, int r5, boolean r6, boolean r7, JSONObject r8) {
        JSONObject r0 = new JSONObject();
        r0.putOpt("position", Integer.valueOf(r5 + 1));
        r0.putOpt("creation_task_id", r4.id);
        if (r7 == false) goto L5;
        b2.c(r0);
    L5:
        c2.a(r0, r8);
        if (r6 == false) goto L12;
        UserCreationFromIM r9 = ICreationMetadataService.a.I(r3, r4.id, String.valueOf(r5));
        if (r9 == null) goto L10;
        String r10 = r9.getCreationId();
    L11:
        r0.putOpt("creation_id", r10);
        goto L12
    L10:
        r10 = null;
    L12:
        return r0;
    }
}
