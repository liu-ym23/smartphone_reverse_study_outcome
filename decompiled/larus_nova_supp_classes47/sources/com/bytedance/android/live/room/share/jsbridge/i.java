package com.bytedance.android.live.room.share.jsbridge;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.room.api.ILiveShareService;
import com.bytedance.android.live.room.api.share.model.LiveShareType;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i implements n56.c {
    public final WeakReference<Context> a;
    public final WeakReference<y6.d> b;

    public i(WeakReference<Context> r1, y6.d r2) {
        this.a = r1;
        this.b = new WeakReference(r2);
    }

    public void call(n56.f r17, JSONObject r18) throws Exception {
        JSONObject r1 = r17.d;
        if (r1 == null) goto L77;
        r1.optString("title");
        r1.optString("desc");
        r1.optString("image");
        r1.optString("url");
        String r3 = r1.optString("platform");
        String r4 = r1.optString("type");
        if (r1.optInt("half_screen") != 1) goto L8;
        boolean r5 = true;
    L9:
        WeakReference<Context> r8 = this.a;
        if (r8 != null) goto L12;
        Context r9 = null;
    L14:
        if (StringUtils.isEmpty(r3) == true) goto L73;
        if (r9 == null) goto L78;
        i81.a.C0251a r10 = new i81.a.C0251a();
        if ("live_room".equals(r4) == false) goto L56;
        JSONObject r2 = r1.optJSONObject("url_extra");
        HashMap r6 = new HashMap();
        if (r2 == null) goto L45;
        Iterator<String> r12 = r2.keys();
    L24:
        if (r12.hasNext() == false) goto L45;
        String r15 = r12.next();
        Object r7 = r2.get(r15);
        if ((r7 instanceof Boolean) == false) goto L28;
    L43:
        r6.put(r15, String.valueOf(r7));
        goto L24
    L28:
        if ((r7 instanceof Byte) == true) goto L43;
        if ((r7 instanceof Character) == true) goto L43;
        if ((r7 instanceof Double) == true) goto L43;
        if ((r7 instanceof Float) == true) goto L43;
        if ((r7 instanceof Integer) == true) goto L43;
        if ((r7 instanceof Long) == true) goto L43;
        if ((r7 instanceof Short) == true) goto L43;
        if ((r7 instanceof String) == false) goto L24;
    L45:
        Room r13 = ((IRoomService) jc1.k.f(IRoomService.class)).getCurrentRoom();
        if (r13 != null) goto L48;
    L54:
        r18.put(Constants.OperatorKey.CODE, 0);
        return;
    L48:
        if (r13.getShareUrl() == null) goto L54;
        Uri.Builder r14 = UriProtector.parse(r13.getShareUrl()).buildUpon();
        Iterator r16 = r6.entrySet().iterator();
    L51:
        if (r16.hasNext() == false) goto L53;
        Map.Entry r19 = (Map.Entry) r16.next();
        r14.appendQueryParameter((String) r19.getKey(), (String) r19.getValue());
        goto L51
    L53:
        r14.appendQueryParameter("share_ht_uid", String.valueOf(jc1.k.f(IUserService.class).user().n()));
        ILiveShareService r20 = (ILiveShareService) jc1.k.f(ILiveShareService.class);
        r10.d = ShareParams.buildUponRoom(r13).setPlatform(r3).setLogV3Params(r6).setUrl(r14.toString()).setIsHalfScreen(r5).build();
        r10.b = (Activity) r9;
        r20.share(r10.a(), "shareMethod", LiveShareType.SHARE_THIRD, null);
        r18.put(Constants.OperatorKey.CODE, 1);
        return;
    L56:
        if ("open_platform".equals(r4) == false) goto L59;
        ILiveShareService r22 = (ILiveShareService) jc1.k.f(ILiveShareService.class);
        r10.d = ShareParams.builder().setPlatform(r3).setLaunchOnly().setIsHalfScreen(r5).build();
        r10.b = (Activity) r9;
        r22.share(r10.a(), "shareMethod", LiveShareType.SHARE_THIRD, null);
        r18.put(Constants.OperatorKey.CODE, 1);
        return;
    L59:
        if (this.b.get() != null) goto L61;
        y6.e r23 = null;
    L62:
        if (r23 == null) goto L66;
        String r24 = r23.b;
        if (r24 == null) goto L66;
        Uri.Builder r25 = UriProtector.parse(r24).buildUpon();
        r25.appendQueryParameter("share_ht_uid", String.valueOf(jc1.k.f(IUserService.class).user().n()));
        ILiveShareService r26 = (ILiveShareService) jc1.k.f(ILiveShareService.class);
        r10.d = ShareParams.builder().setPlatform(r3).setTitle(r23.a).setDescription(r23.c).setImageUrl(r23.d).setUrl(r25.toString()).setIsHalfScreen(r5).build();
        r10.b = (Activity) r9;
        r26.share(r10.a(), "shareMethod", LiveShareType.SHARE_THIRD, null);
        int r27 = 1;
    L67:
        r18.put(Constants.OperatorKey.CODE, r27);
        return;
    L66:
        r27 = 0;
        goto L67
    L61:
        r23 = this.b.get().w1();
        goto L62
    L78:
        return;
    L73:
        return;
    L12:
        r9 = r8.get();
        goto L14
    L8:
        r5 = false;
        goto L9
    }
}
