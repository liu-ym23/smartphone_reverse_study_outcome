package com.bytedance.android.livesdk.gamecp.utils;

import com.bytedance.android.gamecp.host_api.model.ImageModel;
import com.bytedance.android.gamecp.host_api.model.Room;
import com.bytedance.android.gamecp.host_api.model.toolbar.ToolbarComponentData;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData;
import com.bytedance.android.livesdkapi.depend.model.live.LiveToolbarData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    static {
    }

    public static ImageModel a(com.bytedance.android.live.base.model.ImageModel r2) {
        ImageModel r0 = new ImageModel();
        if (r2 == null) goto L5;
        r0.setWidth(r2.width);
        r0.setHeight(r2.height);
        r0.setLoaded(r2.isLoaded());
        r0.setUri(r2.getUri());
        r0.setUrls(r2.getUrls());
    L5:
        return r0;
    }

    public static Room b(com.bytedance.android.livesdkapi.depend.model.live.Room r6) {
        List r0 = null;
        if (r6 != null) goto L5;
        return null;
    L5:
        Room r1 = new Room();
        r1.setId(Long.valueOf(r6.id));
        r1.setHasGamePromote(Long.valueOf(r6.getHasGamePromote()));
        r1.setIdStr(r6.getIdStr());
        r1.setMessage(r6.message);
        r1.setOwnerUserId(r6.getOwnerUserIdString());
        r1.setPrompts(r6.prompts);
        r1.setRequestId(r6.getRequestId());
        r1.setRoomId(Long.valueOf(r6.getRoomId()));
        User r2 = r6.getOwner();
        com.bytedance.android.gamecp.host_api.model.user.User r3 = new com.bytedance.android.gamecp.host_api.model.user.User();
        if (r2 == null) goto L11;
        String r4 = r2.getUserId();
        if (r4 != null) goto L10;
        r4 = "";
    L10:
        r3.setId(r4);
        r3.setIdStr(r2.getIdStr());
        r3.setAvatarLarge(a(r2.getAvatarLarge()));
        r3.setAvatarMedium(a(r2.getAvatarMedium()));
        r3.setAvatarThumb(a(r2.getAvatarThumb()));
        r3.setNickName(r2.getNickName());
    L11:
        r1.setOwner(r3);
        LiveToolbarData r7 = r6.getToolbarData();
        com.bytedance.android.gamecp.host_api.model.toolbar.LiveToolbarData r5 = new com.bytedance.android.gamecp.host_api.model.toolbar.LiveToolbarData();
        if (r7 == null) goto L24;
        List r8 = r7.getToolbarDataList();
        ArrayList r9 = new ArrayList();
        if (r8 != null) goto L16;
    L23:
        r5.setToolbarDataList(r9);
        goto L24
    L16:
        if ((!r8.isEmpty()) == false) goto L18;
        r0 = r8;
    L18:
        if (r0 == null) goto L23;
        Iterator r10 = r0.iterator();
    L21:
        if (r10.hasNext() == false) goto L23;
        IToolbarComponentData r11 = (IToolbarComponentData) r10.next();
        ToolbarComponentData r12 = new ToolbarComponentData();
        r12.setId(r11.getId());
        r12.setExtraData(r11.getExtraData());
        r9.add(r12);
    L24:
        r1.setToolbarData(r5);
        return r1;
    }
}
