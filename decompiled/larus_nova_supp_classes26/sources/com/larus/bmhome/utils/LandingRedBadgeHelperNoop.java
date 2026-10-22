package com.larus.bmhome.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/utils/LandingRedBadgeHelperNoop;", "Lcom/larus/bmhome/utils/ILandingRedBadgeHelper;", "<init>", "()V", "chatPageResumed", "", "mainTabPageResumed", "setChatPageResumed", "", "isChatPageResumed", "setMainTabPageResumed", "isMainTabPageResumed", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LandingRedBadgeHelperNoop implements ILandingRedBadgeHelper {
    public boolean a;

    public LandingRedBadgeHelperNoop() {
    }

    @Override // com.larus.bmhome.utils.ILandingRedBadgeHelper
    public final void a() {
    }

    @Override // com.larus.bmhome.utils.ILandingRedBadgeHelper
    public final void c() {
        this.a = true;
    }

    @Override // com.larus.bmhome.utils.ILandingRedBadgeHelper
    public final boolean b() {
        return this.a;
    }
}
