package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong;

import android.net.Uri;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n {
    public static final Interpolator a = null;
    public static final Interpolator b = null;

    static {
        a = PathInterpolatorCompat.create(0.48f, 0.01f, 0.52f, 0.99f);
        b = PathInterpolatorCompat.create(1.0f, 0.0f, 0.34f, 1.0f);
    }

    public static final int b(ILinkPlayerInfoBridge r3) {
        InteractiveSongContext r0 = InteractiveSongContext.Companion.getContext();
        String r1 = null;
        if (r0 == null) goto L5;
        ConcurrentHashMap<String, pf0.a> r2 = r0.getGuestListInteractiveSongInfo();
    L6:
        if (r3 == null) goto L11;
        IBaseUser r4 = r3.getUser();
        if (r4 == null) goto L11;
        r1 = r4.getIdString();
    L11:
        if (r1 != null) goto L13;
    L16:
        boolean r5 = true;
    L17:
        if (r5 == false) goto L19;
        return 0;
    L19:
        if (r2 == null) goto L24;
        pf0.a r6 = r2.get(r1);
        if (r6 != null) goto L23;
        return 0;
    L23:
        return r6.b;
    L24:
        return 0;
    L13:
        if (StringsKt.isBlank(r1) == true) goto L16;
        r5 = false;
        goto L17
    L5:
        r2 = null;
        goto L6
    }

    public static final void d(String r1) {
        Intrinsics.checkNotNullParameter(r1, "log");
        ALogger.i("RequestSongMicSeatView", r1);
    }

    public static final float a(TextView r2, String r3) {
        if (r2 != null) goto L5;
        return 0.0f;
    L5:
        int r0 = s1.f(22.0f);
        TextPaint r1 = r2.getPaint();
        if (r3 != null) goto L9;
        r3 = r2.getText().toString();
    L9:
        return r0 + r1.measureText(r3);
    }

    public static final void c(HSImageView r2, String r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$playWebpOnce");
        Intrinsics.checkNotNullParameter(r3, "url");
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        Uri r5 = UriProtector.parse(r3);
        Intrinsics.checkNotNullParameter(r2, "$this$playWebpOnce");
        Intrinsics.checkNotNullParameter(r5, "uri");
        Intrinsics.checkNotNullParameter(r2, "$this$loadWebp");
        Intrinsics.checkNotNullParameter(r5, "uri");
        r2.setController(Fresco.newDraweeControllerBuilder().setUri(r5).setAutoPlayAnimations(true).setControllerListener(new m(r4)).build());
    }
}
