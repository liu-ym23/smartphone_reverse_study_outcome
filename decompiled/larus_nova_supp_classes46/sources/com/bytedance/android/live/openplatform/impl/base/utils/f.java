package com.bytedance.android.live.openplatform.impl.base.utils;

import android.os.SystemClock;
import com.bytedance.android.live.openplatform.api.utils.image.ImageTag;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.facebook.fresco.animation.bitmap.BitmapAnimationBackend;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f implements BitmapAnimationBackend.FrameListener {
    public long a;
    public int b;
    public int c;
    public final /* synthetic */ ImageTag d;
    public final /* synthetic */ String e;

    public final void onFrameDropped(BitmapAnimationBackend r1, int r2) {
    }

    public f(ImageTag r1, String r2) {
        this.d = r1;
        this.e = r2;
        this.a = -1;
        this.b = -1;
    }

    public final void onDrawFrameStart(BitmapAnimationBackend r1, int r2) {
        if (r2 != 0) goto L5;
        this.a = SystemClock.uptimeMillis();
        this.b = -1;
        this.c = 0;
        return;
    }

    public final void onFrameDrawn(BitmapAnimationBackend r13, int r14, int r15) {
        if (r14 != this.b) goto L6;
        this.c++;
    L6:
        if (r13 == null) goto L8;
        int r16 = r13.getFrameCount();
    L9:
        if (r16 > 0) goto L11;
    L26:
        this.b = r14;
        return;
    L11:
        if (r14 != (r16 - 1)) goto L26;
        ImageLoader r1 = ImageLoader.a;
        long r2 = this.a;
        String r3 = this.d.name();
        String r4 = this.e;
        int r5 = this.c;
        long r8 = 0;
        RoomContext r6 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r6 == null) goto L19;
        com.bytedance.live.datacontext.i r7 = r6.isAnchor();
        if (r7 == null) goto L19;
        Boolean r9 = (Boolean) r7.getValue();
        if (r9 == null) goto L19;
        boolean r10 = r9.booleanValue();
    L20:
        if (r10 == true) goto L26;
        if (r2 == (-1)) goto L25;
        r8 = SystemClock.uptimeMillis() - r2;
    L25:
        com.bytedance.android.livesdk.log.u.l().e("mp_live_audience_animatable_frame_monitor", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("_param_for_special", "micro_app"), TuplesKt.to("image_id", r3), TuplesKt.to("image_url", r4), TuplesKt.to("frame_count", String.valueOf(r16)), TuplesKt.to("drop_count", String.valueOf(r5)), TuplesKt.to("duration", String.valueOf(r8))}), new Object[]{Room.class});
    L19:
        r10 = false;
        goto L20
    L8:
        r16 = 0;
        goto L9
    }
}
