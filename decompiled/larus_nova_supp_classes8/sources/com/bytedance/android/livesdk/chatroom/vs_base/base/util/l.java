package com.bytedance.android.livesdk.chatroom.vs_base.base.util;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.ReplayConfigSettingKeys;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VideoResolutionItem;
import com.bytedance.common.utility.NetworkUtils;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.model.VideoRef;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l {
    public static final List<a> a = null;

    public static final class a {
        public final String a;
        public final String b;
        public final int c;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L12;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (this.c == r4.c) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return ((r3 + r1) * 31) + this.c;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "VSReplayResolution(key=" + this.a + ", name=" + this.b + ", icon=" + this.c + ")";
        }

        public a(String r2, String r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r3, LiveEndPageData.TAG_NAME);
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    static {
        a = CollectionsKt.listOf(new a[]{new a("240p", "流畅 240P", 2131251859), new a("360p", "标清 360P", 2131251859), new a("480p", "标清 480P", 2131251859), new a("540p", "高清 540P", 2131251861), new a("720p", "高清 720P", 2131251861), new a("1080p", "蓝光 1080P", 2131251862), new a("1080p 50fps", "蓝光 1080P", 2131251862), new a("1080p 60fps", "蓝光 1080P", 2131251862), new a("1080p 120fps", "蓝光 1080P", 2131251862), new a("2k", "2K", 2131251862), new a("4k", "超高清 4K", 2131251855), new a("2k 50fps", "2K", 2131251862), new a("4k 50fps", "超高清 4K", 2131251855), new a("2k 60fps", "2K", 2131251862), new a("4k 60fps", "4K", 2131251855), new a("2k 120fps", "2K", 2131251862), new a("4k 120fps", "4K", 2131251855), new a("hdr", "音画增强", 2131251858)});
    }

    @JvmStatic
    public static final VideoResolutionItem b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "targetKey");
        Iterator<T> r0 = a.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(r3, ((a) r1).a) == false) goto L4;
    L9:
        a r2 = (a) r1;
        if (r2 == null) goto L13;
        String r4 = r2.b;
        if (r4 == null) goto L13;
    L15:
        return new VideoResolutionItem(r3, r4);
    L13:
        r4 = r3;
        goto L15
    L8:
        r1 = null;
        goto L9
    }

    @JvmStatic
    public static final boolean c(String r5) {
        ALogger.d("ReplayResolutionManager", "is HDR resolution:" + r5);
        if (Intrinsics.areEqual(r5, "hdr") == true) goto L18;
        Iterator<T> r1 = a.iterator();
    L5:
        String r3 = null;
        if (r1.hasNext() == false) goto L10;
        Object r2 = r1.next();
        if (Intrinsics.areEqual(((a) r2).a, "hdr") == false) goto L5;
    L11:
        a r4 = (a) r2;
        if (r4 == null) goto L15;
        r3 = r4.b;
    L15:
        if (Intrinsics.areEqual(r5, r3) == true) goto L18;
        return false;
    L10:
        r2 = null;
    L18:
        return true;
    }

    @JvmStatic
    public static final Resolution a(Resolution[] r6, Context r7) {
        if (r7 == null) goto L4;
        if (r6 == null) goto L27;
        if (r6.length != 0) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == true) goto L27;
        SettingKey<oq1.f> r1 = ReplayConfigSettingKeys.LIVE_REPLAY_DEFAULT_RESOLUTION;
        String r3 = ((oq1.f) r1.getValue()).b();
        String r2 = ((oq1.f) r1.getValue()).a();
        int r4 = ita.i.a;
        if (NetworkUtils.isWifi(r7) == true) goto L16;
        r3 = r2;
    L16:
        int r8 = r6.length;
        int r5 = 0;
    L17:
        if (r5 >= r8) goto L22;
        Resolution r9 = r6[r5];
        if (Intrinsics.areEqual(r9.toString(VideoRef.TYPE_VIDEO), r3) == true) goto L23;
        r5 = r5 + 1;
    L23:
        if (r9 == null) goto L25;
        return r9;
    L25:
        return r6[RangesKt.coerceAtLeast(r6.length - 1, 0)];
    L22:
        r9 = null;
        goto L23
    L9:
        r0 = false;
    L27:
        return Resolution.Standard;
    L4:
        return Resolution.Standard;
    }
}
