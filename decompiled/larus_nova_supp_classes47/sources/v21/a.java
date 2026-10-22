package v21;

import com.bytedance.android.live.revenue.common.message.b;
import com.bytedance.android.livesdk.link.model.bridge.f2;
import com.bytedance.android.livesdk.link.model.c8;
import com.bytedance.android.livesdkapi.service.RevImCacheUnit;
import kotlin.jvm.internal.Intrinsics;
import yh6.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements RevImCacheUnit {
    public static final /* synthetic */ int c = 0;
    public Long a;
    public final String b;

    /* JADX INFO: renamed from: v21.a$a, reason: collision with other inner class name */
    public static final class C0332a {
    }

    static {
    }

    public final String getMessageMethod() {
        b.T.getClass();
        return b.l.a;
    }

    public a() {
        this.b = "FeedMultiLinkTimeCacheUnit";
    }

    public final String getTag() {
        return this.b;
    }

    public final void doHandle(c r3) {
        Intrinsics.checkNotNullParameter(r3, "_message");
        if ((r3 instanceof f2) == false) goto L6;
        this.a = Long.valueOf(((vh7.c) r3).castTo(c8.class).getLinkStartTime());
        return;
    }
}
