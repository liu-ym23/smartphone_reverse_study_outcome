package com.bytedance.android.livesdk.interactivity.api.publicscreen.utils;

import com.bytedance.android.live.base.model.message.i4;
import com.bytedance.android.live.base.model.message.u3;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.interactivity.api.comment.data.IntercomChangeSyncData;
import com.bytedance.android.livesdk.interactivity.api.comment.data.IntercomSyncDataModel;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.bytedance.bdlocation.BuildConfig;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    public static boolean b() {
        IntercomSyncDataModel r0 = com.bytedance.android.livesdk.interactivity.api.q.h();
        if (r0 == null) goto L11;
        dc2.c<IntercomChangeSyncData> r1 = r0.getIntercomStatus();
        if (r1 == null) goto L11;
        IntercomChangeSyncData r2 = r1.c();
        if (r2 == null) goto L11;
        if (r2.isInIntercom() != true) goto L11;
        return true;
    L11:
        return false;
    }

    static {
    }

    public static Map a(com.bytedance.android.live.base.model.message.t r4) {
        if ((r4 instanceof u3) == true) goto L5;
        com.bytedance.android.live.base.model.message.t r0 = null;
    L6:
        u3 r1 = (u3) r0;
        String r2 = BuildConfig.FLAVOR;
        if (r1 == null) goto L12;
        IBaseUser r3 = r1.getUserInMessage();
        if (r3 == null) goto L12;
        String r5 = r3.getUserId();
        if (r5 == null) goto L12;
    L13:
        boolean r6 = r4 instanceof i4;
        if (r6 == false) goto L16;
        r2 = "private_chat";
    L16:
        if (r6 == false) goto L18;
        String r7 = "reply";
    L20:
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("comment_user_id", r5), TuplesKt.to("msg_type", r2), TuplesKt.to("event_user_type", r7)});
    L18:
        r7 = "create";
    L12:
        r5 = BuildConfig.FLAVOR;
        goto L13
    L5:
        r0 = r4;
        goto L6
    }

    public static void c(String r3, String r4, String r5, Map r6) {
        Intrinsics.checkNotNullParameter(r3, "commentId");
        Intrinsics.checkNotNullParameter(r4, "function_level");
        Intrinsics.checkNotNullParameter(r5, "function_list");
        Intrinsics.checkNotNullParameter(r6, "extra");
        HashMap r2 = new HashMap();
        r2.putAll(r6);
        r2.put("comment_id", r3);
        if (b() == false) goto L5;
        String r7 = "1";
    L6:
        r2.put("is_comment_connected", r7);
        r2.put("function_level", r4);
        r2.put("function_list", r5);
        IMiddlewareLiveService r8 = jc1.k.f(IMiddlewareLiveService.class);
        if (r8 == null) goto L12;
        ILiveOntologyInfoManager r9 = r8.getLiveOntologyRecord();
        if (r9 == null) goto L12;
        String r10 = r9.getEnterFromMerge();
        if (r10 == null) goto L12;
    L13:
        r2.put("drawer_page", r10);
        j0.l().sendLog("livesdk_live_message_function_show", r2, new Object[]{new am2.x(), IRoom.class});
        return;
    L12:
        r10 = BuildConfig.FLAVOR;
        goto L13
    L5:
        r7 = "0";
        goto L6
    }
}
