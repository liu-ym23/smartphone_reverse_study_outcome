package r42;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m extends i {
    public final boolean d;
    public boolean e;

    @Override // r42.i
    public final boolean a() {
        return this.b;
    }

    public m(IRoom r2) {
        super(r2);
        if (r2 == null) goto L7;
        boolean r0 = true;
        if (r2.isMergeVSRoom() != true) goto L7;
    L8:
        this.d = r0;
        return;
    L7:
        r0 = false;
        goto L8
    }

    @Override // r42.i
    public final void b(vlc.d r4, aa2.e r5) {
        Intrinsics.checkNotNullParameter(r4, "messageManager");
        Intrinsics.checkNotNullParameter(r5, "onHistoryCallBack");
        ALogger.i("HISTORY_COMMENT_TAG", "start load history comment v3...");
        if (g.c() == true) goto L5;
    L8:
        tlc.a r0 = new tlc.a(-1);
        if (this.d == false) goto L16;
        if (PublicScreenABHelper.R == false) goto L16;
        if (this.e == true) goto L16;
        r0 = new tlc.a(g.d() + 12);
        this.e = true;
    L16:
        if ((r4 instanceof vlc.e) == true) goto L18;
        vlc.d r1 = null;
    L19:
        vlc.e r2 = (vlc.e) r1;
        if (r2 == null) goto L23;
        r2.E(r0, new l(this, r5, r4));
        return;
    L23:
        return;
    L18:
        r1 = r4;
        goto L19
    L5:
        if ((!((ArrayList) this.c).isEmpty()) == false) goto L8;
        ArrayList r6 = new ArrayList(this.c);
        ((ArrayList) this.c).clear();
        r5.a(r6);
        ALogger.i("HISTORY_COMMENT_TAG", "fetch history comment " + r6.size() + " from preload v3 cache, hasMore:" + this.b);
    }
}
