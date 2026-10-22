package xc0;

import com.bytedance.android.live.liveinteract.videotalk.emoji.model.o;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements b {
    public static final a b = null;

    /* JADX INFO: renamed from: xc0.a$a, reason: collision with other inner class name */
    public static final class C0291a {
    }

    public a() {
    }

    @Override // xc0.b
    public final o a(com.bytedance.android.live.liveinteract.animation.e r1, com.bytedance.android.live.liveinteract.videotalk.emoji.model.c r2, o r3, ArrayList<String> r4) {
        Intrinsics.checkNotNullParameter(r2, "giftInfo");
        Intrinsics.checkNotNullParameter(r3, "positionInfo");
        Intrinsics.checkNotNullParameter(r4, "onlineList");
        return r3;
    }

    static {
        b = new a();
    }
}
