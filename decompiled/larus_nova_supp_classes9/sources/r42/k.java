package r42;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k extends i {
    @Override // r42.i
    public final boolean a() {
        return this.b;
    }

    public k(IRoom r1) {
        super(r1);
    }

    @Override // r42.i
    public final void b(vlc.d r4, aa2.e r5) {
        Intrinsics.checkNotNullParameter(r4, "messageManager");
        Intrinsics.checkNotNullParameter(r5, "onHistoryCallBack");
        ALogger.i("HISTORY_COMMENT_TAG", "start load history comment...");
        if ((r4 instanceof vlc.e) == true) goto L5;
        vlc.d r0 = null;
    L6:
        vlc.e r1 = (vlc.e) r0;
        if (r1 == null) goto L10;
        r1.E(new tlc.a(-1), new j(this, r5, r4));
        return;
    L10:
        return;
    L5:
        r0 = r4;
        goto L6
    }
}
