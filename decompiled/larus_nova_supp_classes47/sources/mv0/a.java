package mv0;

import com.bytedance.android.live.broadcastgame.api.AudienceGameContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends qs0.a<AudienceGameContext> implements qs0.b {
    public a() {
        AudienceGameContext.Companion.getClass();
        super(AudienceGameContext.a.a());
    }

    @Override // qs0.b
    public final qs0.b.a j() {
        AudienceGameContext r0 = (AudienceGameContext) this.a;
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.n r1 = r0.getCurrentGame();
        if (r1 == null) goto L9;
        com.bytedance.android.live.broadcastgame.api.model.r r2 = (com.bytedance.android.live.broadcastgame.api.model.r) r1.getValue();
        if (r2 == null) goto L9;
        return new qs0.b.a(r2.p(), r2.q());
    L9:
        return null;
    }
}
