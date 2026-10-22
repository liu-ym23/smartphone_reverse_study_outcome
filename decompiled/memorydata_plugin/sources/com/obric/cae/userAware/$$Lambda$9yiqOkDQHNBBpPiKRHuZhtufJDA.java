package com.obric.cae.userAware;

/* JADX INFO: renamed from: com.obric.cae.userAware.-$$Lambda$9yiqOkDQHNBBpPiKRHuZhtufJDA, reason: invalid class name */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class $$Lambda$9yiqOkDQHNBBpPiKRHuZhtufJDA implements UserAwareManager.InnerCallbackAction {
    public static final /* synthetic */ $$Lambda$9yiqOkDQHNBBpPiKRHuZhtufJDA INSTANCE = null;

    static {
        INSTANCE = new $$Lambda$9yiqOkDQHNBBpPiKRHuZhtufJDA();
    }

    private /* synthetic */ $$Lambda$9yiqOkDQHNBBpPiKRHuZhtufJDA() {
    }

    @Override // com.obric.cae.userAware.UserAwareManager.InnerCallbackAction
    public final void execute(InnerAwareInfoCallback r1, Object r2) {
        r1.onRecordNearbyStatus(((Boolean) r2).booleanValue());
    }
}
