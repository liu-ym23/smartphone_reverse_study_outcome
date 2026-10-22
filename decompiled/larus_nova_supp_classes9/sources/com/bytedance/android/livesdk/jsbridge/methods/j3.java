package com.bytedance.android.livesdk.jsbridge.methods;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livesdk.jsbridge.methods.dto.Anchor;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.annotations.SerializedName;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j3 extends com.bytedance.ies.web.jsbridge2.f<a, Object> {
    public WeakReference<Context> a;

    public static final class a {

        @SerializedName("shopping_extras")
        Anchor anchor;

        @SerializedName("video_thum_url")
        String cover;

        @SerializedName("duration")
        long duration;

        @SerializedName("end_time")
        long endTime;

        @SerializedName("fragment_id")
        String fragmentId;

        @SerializedName("promotion_id")
        String promotionId;

        @SerializedName("room_id")
        String roomId;

        @SerializedName("room_time")
        String roomTime;

        @SerializedName("shoot_way")
        String shootWay;

        @SerializedName("start_time")
        long startTime;

        @SerializedName("title")
        String title;

        @SerializedName("type")
        String type;

        @SerializedName("videoId")
        String videoId;

        @SerializedName("video_url")
        String videoUrl;

        public a() {
        }
    }

    public final void onTerminate() {
    }

    public j3() {
    }

    public final void invoke(Object r11, CallContext r13) throws Exception {
        a r14 = (a) r11;
        if (TextUtils.isEmpty(r14.type) == false) goto L5;
    L7:
        boolean r15 = false;
    L9:
        if (r15 == false) goto L15;
        IHostBusiness r16 = jc1.k.f(IHostBusiness.class);
        Context r6 = this.a.get();
        Intent r7 = new Intent();
        r7.putExtra("video_id", r14.videoId);
        r7.putExtra("video_url", r14.videoUrl);
        r7.putExtra("video_thum_url", r14.cover);
        r7.putExtra("title", r14.title);
        r7.putExtra("type", "highlight");
        r7.putExtra("room_time", r14.roomTime);
        r7.putExtra("room_id", r14.roomId);
        r7.putExtra("start_time", r14.startTime);
        r7.putExtra("end_time", r14.endTime);
        r7.putExtra("shoot_way", r14.shootWay);
        r7.putExtra("fragment_id", r14.fragmentId);
        Anchor r0 = r14.anchor;
        if (r0 != null) goto L13;
        String r1 = "{}";
    L14:
        r7.putExtra("shopping_extras", r1);
        r7.putExtra("promotion_id", r14.promotionId);
        r16.startLightPublishActivity(r6, r7, new h3());
        return;
    L13:
        r1 = GsonProtectorUtils.toJson(GsonHelper.get(), r0);
        goto L14
    L15:
        IHostBusiness r17 = jc1.k.f(IHostBusiness.class);
        Context r2 = this.a.get();
        Intent r8 = new Intent();
        r8.putExtra("live_id", r14.roomId);
        r8.putExtra("video_thum_url", r14.cover);
        r8.putExtra("title", r14.title);
        r8.putExtra("type", "live");
        r8.putExtra("duration", r14.duration);
        r8.putExtra("shoot_way", r14.shootWay);
        r8.putExtra("fragment_id", r14.fragmentId);
        r17.startLivePublishActivity(r2, r8, new i3());
        return;
    L5:
        if (r14.type.equals("highlight") == false) goto L7;
        r15 = true;
        goto L9
    }
}
