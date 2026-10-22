package rd0;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import com.ss.android.ugc.aweme.debug.LocalTestManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
        LocalTestManager.a(new Class[]{wy.a.class});
    }

    public static final String a() {
        m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L9;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L9;
        String r2 = r1.getOwnerUserIdString();
        if (r2 == null) goto L9;
        return r2;
    L9:
        return "";
    }

    public static final String b() {
        m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L8;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L8;
        String r2 = r1.getIdStr();
        if (r2 == null) goto L8;
        return r2;
    L8:
        return "";
    }
}
