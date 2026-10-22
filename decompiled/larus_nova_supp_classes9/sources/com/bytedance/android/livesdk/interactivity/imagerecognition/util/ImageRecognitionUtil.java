package com.bytedance.android.livesdk.interactivity.imagerecognition.util;

import am2.n;
import am2.x;
import android.graphics.Bitmap;
import android.util.Base64;
import android.view.View;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.datacontext.m;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class ImageRecognitionUtil {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void d(final Function2 r2) {
        Intrinsics.checkNotNullParameter(r2, "cb");
        final ILivePlayerClient r0 = LivePlatformPlayerManager.f();
        if (r0 != null) goto L6;
        r2.invoke(null, "client_is_null");
        return;
    L6:
        r0.saveFrameV2(false, new ImageRecognitionUtil$saveFrameV2WithErrorInfo$1(r2, r0));
    }

    public static Pair a(Bitmap r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "bitmap");
        if (r3 != 0) goto L5;
        Bitmap.CompressFormat r0 = Bitmap.CompressFormat.PNG;
    L6:
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);
        throw th;
    L8:
        if (r2.compress(r0, r3, r1) == false) goto L10;
        byte[] r4 = r1.toByteArray();     // Catch: Throwable -> L13
    L11:
        CloseableKt.closeFinally(r1, null);
        return TuplesKt.to(r4, r0);
    L10:
        r4 = new byte[0];     // Catch: Throwable -> L13
        goto L11
    L5:
        r0 = Bitmap.CompressFormat.JPEG;
        goto L6
    }

    public static String b(Bitmap r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "bitmap");
        Pair r3 = a(r1, r2);
        if (((byte[]) r3.getFirst()).length != 0) goto L5;
        boolean r4 = true;
    L7:
        if ((!r4) == true) goto L10;
        r3 = null;
    L10:
        if (r3 != null) goto L14;
        return BuildConfig.FLAVOR;
    L14:
        return Base64.encodeToString((byte[]) r3.component1(), 2);
    L5:
        r4 = false;
        goto L7
    }

    public static String c(String r8, View r9) {
        Intrinsics.checkNotNullParameter(r8, "btmId");
        BcmParams.a r0 = BcmParams.Companion;
        HashMap r1 = new HashMap();
        HashMap r2 = new HashMap();
        Map r7 = null;
        RoomContext r3 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r3 == null) goto L7;
        m r4 = r3.getRoom();
        if (r4 == null) goto L7;
        Room r5 = (Room) r4.getValue();
    L8:
        String r6 = "0";
        if (r5 == null) goto L12;
        String r10 = String.valueOf(r5.getRoomId());
        if (r10 == null) goto L12;
    L13:
        r2.put("room_id", r10);
        if (r5 == null) goto L17;
        String r11 = r5.getOwnerUserIdString();
        if (r11 == null) goto L17;
    L18:
        r2.put("author_id", r11);
        String r13 = BuildConfig.FLAVOR;
        if (r5 == null) goto L22;
        String r14 = r5.getRequestId();
        if (r14 == null) goto L22;
    L23:
        r2.put("request_id", r14);
        o r15 = u.l().c(x.class);
        if (r15 == null) goto L26;
        r7 = r15.getMap();
    L26:
        if (r7 == null) goto L32;
        String r16 = (String) r7.get("enter_from_merge");
        if (r16 == null) goto L32;
        r13 = r16;
    L32:
        if (r7 == null) goto L37;
        String r17 = (String) r7.get("is_from_ad");
        if (r17 == null) goto L37;
        r6 = r17;
    L37:
        r2.put("chnid", r13);
        r2.put("cid", n.f().c());
        r2.put("is_from_ad", r6);
        Unit r18 = Unit.INSTANCE;
        r1.put("live_guide_search", r2);
        r0.getClass();
        return BtmSDK.INSTANCE.createJumpSourceBtmToken(r8, PageFinder.via(r9), BcmParams.a.c(r1));
    L22:
        r14 = BuildConfig.FLAVOR;
    L17:
        r11 = "0";
    L12:
        r10 = "0";
    L7:
        r5 = null;
        goto L8
    }
}
