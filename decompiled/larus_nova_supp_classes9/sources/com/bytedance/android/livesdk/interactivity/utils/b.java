package com.bytedance.android.livesdk.interactivity.utils;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.bytedance.android.live.base.model.message.o1;
import com.bytedance.android.live.base.model.message.p0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.z;
import com.bytedance.android.livesdk.interactivity.service.monitor.EventName;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static final int c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$toColorInt");
        return Color.parseColor("#" + r2);
    L5:
        return -1;
    }

    public static final boolean d(com.bytedance.android.livesdk.interactivity.api.publicscreen.d r5) {
        if ((r5 instanceof z) == true) goto L5;
        r5 = null;
    L5:
        z r6 = (z) r5;
        if (r6 == null) goto L13;
        long r1 = r6.a.getChatSource();
        if (r1 != 9) goto L10;
    L11:
        return true;
    L10:
        if (r1 == 10) goto L11;
        return false;
    L13:
        return false;
    }

    public static final void a(tc2.j r5, long r6) {
        Intrinsics.checkNotNullParameter(r5, "selfSendInfo");
        long r0 = r5.d;
        if (r0 <= 0) goto L15;
        long r2 = r5.b;
        if (r2 <= r0) goto L16;
        long r1 = r5.e;
        if (r1 > r2) goto L9;
        return;
    L9:
        if (r6 > r1) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(r5.f, "--default--") == true) goto L19;
        com.bytedance.android.livesdk.interactivity.api.monitorV2.a.d(EventName.ChatSendToShowDelay, MapsKt.mapOf(new Pair[]{TuplesKt.to("send_to_show_cost_time", String.valueOf(r6 - r5.d)), TuplesKt.to("api_success_to_show_cost_time", String.valueOf(r6 - r5.e)), TuplesKt.to("api_network_cost_time", String.valueOf(r5.e - r5.b)), TuplesKt.to("show_area", "danmaku"), TuplesKt.to("message_type", r5.f)}));
        return;
    L19:
        return;
    L16:
        return;
    }

    public static final CharSequence b(com.bytedance.android.livesdk.interactivity.api.publicscreen.d r4, float r5) {
        Intrinsics.checkNotNullParameter(r4, "$this$getTalentTextContent");
        Intrinsics.checkNotNullParameter(r4, "$this$getTextContent");
        CharSequence r0 = r4.getChatContent();
        if ((r4 instanceof p0) == false) goto L5;
        r0 = ((p0) r4).getRenderSpan();
    L5:
        SpannableString r6 = ab2.a.f(r0, r5);
        boolean r1 = r4.a();
        String r2 = BuildConfig.FLAVOR;
        if (r1 == false) goto L18;
        IBaseUser r7 = r4.getUserInfo();
        if (r7 == null) goto L14;
        String r8 = r7.getNickName();
        if (r8 == null) goto L14;
        r2 = r8;
    L14:
        if (r2.length() < 12) goto L17;
        r2 = r2.subSequence(0, 6) + "..." + r2.subSequence(r2.length() - 5, r2.length());
    L17:
        return new SpannableStringBuilder(r2).append(": ").append(r6);
    L18:
        o1 r3 = r4.getLandscapeAreaCommon();
        if (r3 != null) goto L21;
    L30:
        return r6;
    L21:
        if (r3.isShowNickName() != true) goto L30;
        IBaseUser r9 = r4.getUserInfo();
        if (r9 == null) goto L29;
        String r10 = r9.getNickName();
        if (r10 == null) goto L29;
        r2 = r10;
    L29:
        return new SpannableStringBuilder(r2).append(": ").append(r6);
    }
}
