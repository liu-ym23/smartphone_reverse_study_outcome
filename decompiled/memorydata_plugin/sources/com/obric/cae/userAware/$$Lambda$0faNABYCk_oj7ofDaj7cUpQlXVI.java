package com.obric.cae.userAware;

/* JADX INFO: renamed from: com.obric.cae.userAware.-$$Lambda$0faNABYCk_oj7ofDaj7cUpQlXVI, reason: invalid class name */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class $$Lambda$0faNABYCk_oj7ofDaj7cUpQlXVI implements UserAwareManager.InnerCallbackAction2 {
    public static final /* synthetic */ $$Lambda$0faNABYCk_oj7ofDaj7cUpQlXVI INSTANCE = null;

    static {
        INSTANCE = new $$Lambda$0faNABYCk_oj7ofDaj7cUpQlXVI();
    }

    private /* synthetic */ $$Lambda$0faNABYCk_oj7ofDaj7cUpQlXVI() {
    }

    @Override // com.obric.cae.userAware.UserAwareManager.InnerCallbackAction2
    public final void execute(InnerAwareInfoCallback r1, Object r2, Object r3) {
        r1.onHARStatusChanged(((Integer) r2).intValue(), ((Long) r3).longValue());
    }
}
