package com.bytedance.android.livesdk.chatroom.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.HashMap;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static HashMap c(Room r5) {
        HashMap r0 = new HashMap();
        String r1 = "";
        if (r5 == null) goto L6;
        String r2 = r5.buildPullUrl();
        if (r2 == null) goto L6;
    L7:
        r0.put("live_url", r2);
        Long r3 = null;
        if (r5 == null) goto L22;
        User r4 = r5.getOwner();
        if (r4 == null) goto L22;
        ImageModel r6 = r4.getAvatarThumb();
        if (r6 == null) goto L22;
        List r7 = r6.getUrls();
        if (r7 == null) goto L22;
        if ((!r7.isEmpty()) == true) goto L19;
        r7 = null;
    L19:
        if (r7 == null) goto L22;
        String r8 = (String) ListProtector.get(r7, 0);
        if (r8 == null) goto L22;
    L23:
        r0.put("live_user_avatar", r8);
        if (r5 == null) goto L31;
        User r9 = r5.getOwner();
        if (r9 == null) goto L31;
        String r10 = r9.getNickName();
        if (r10 == null) goto L31;
        r1 = r10;
    L31:
        r0.put("live_user_name", r1);
        if (r5 == null) goto L34;
        r3 = Long.valueOf(r5.id);
    L34:
        r0.put("live_room_id", String.valueOf(r3));
        return r0;
    L22:
        r8 = "";
    L6:
        r2 = "";
        goto L7
    }

    @JvmStatic
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> d(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        return new com.bytedance.android.livesdk.sharedpref.e("is_first_show_fold_transform_widget_" + r3, Boolean.TRUE);
    }

    @JvmStatic
    public static final boolean e(LiveMode r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (tb1.c.a == true) goto L8;
        return false;
    L8:
        if (r2 != LiveMode.VIDEO) goto L10;
    L15:
        return true;
    L10:
        if (r2 == LiveMode.SCREEN_RECORD) goto L15;
        if (r2 == LiveMode.THIRD_PARTY) goto L15;
        if (r2 == LiveMode.AUDIO) goto L15;
        return false;
    }

    @JvmStatic
    public static final String a(String r2, String r3) {
        JSONObject r0 = new JSONObject();
        if (TextUtils.isEmpty(r2) == true) goto L6;
        r0.put("logExtra", r2);
    L6:
        if (TextUtils.isEmpty(r3) == true) goto L9;
        r0.put("creativeID", r3);
    L9:
        return r0.toString();
    }

    @JvmStatic
    public static final void b(Bundle r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "bundle");
        Intrinsics.checkNotNullParameter(r9, "extraStr");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L24
        HashMap r3 = new HashMap();     // Catch: Throwable -> L24
        JSONObject r4 = new JSONObject(r9);     // Catch: Throwable -> L24
        String r10 = r4.optString("category_detail");     // Catch: Throwable -> L24
        String r5 = r4.optString("new_filter_words");     // Catch: Throwable -> L24
        boolean r6 = true;
        if (r10.length() <= 0) goto L6;
        boolean r7 = true;
    L8:
        if (r7 == true) goto L11;
        r10 = null;
    L11:
        if (r10 == null) goto L14;
        String r11 = (String) r3.put("category_detail", r10);     // Catch: Throwable -> L24
    L14:
        if (r5.length() > 0) goto L17;
        r6 = false;
    L17:
        if (r6 == true) goto L20;
        r5 = null;
    L20:
        if (r5 == null) goto L22;
        String r12 = (String) r3.put("new_filter_words", r5);     // Catch: Throwable -> L24
    L22:
        r8.putSerializable("extra_params_live_ad_enter_room", r3);     // Catch: Throwable -> L24
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L24
        return;
    L6:
        r7 = false;
    L24:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}
