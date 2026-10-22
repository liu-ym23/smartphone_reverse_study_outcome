package yn0;

import com.bytedance.android.live.broadcastgame.api.AudienceGameContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements l81.a {
    public static final a a = null;

    public a() {
    }

    static {
        a = new a();
    }

    public final Long getCurrentGameId() {
        AudienceGameContext.Companion.getClass();
        AudienceGameContext r0 = AudienceGameContext.a.a();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.n r1 = r0.getCurrentGame();
        if (r1 == null) goto L9;
        com.bytedance.android.live.broadcastgame.api.model.r r2 = (com.bytedance.android.live.broadcastgame.api.model.r) r1.getValue();
        if (r2 == null) goto L9;
        return Long.valueOf(r2.p());
    L9:
        return null;
    }

    public final String getCurrentGameName() {
        AudienceGameContext.Companion.getClass();
        AudienceGameContext r0 = AudienceGameContext.a.a();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.n r1 = r0.getCurrentGame();
        if (r1 == null) goto L9;
        com.bytedance.android.live.broadcastgame.api.model.r r2 = (com.bytedance.android.live.broadcastgame.api.model.r) r1.getValue();
        if (r2 == null) goto L9;
        return r2.q();
    L9:
        return null;
    }
}
