package com.larus.bmhome.utils;

import com.bytedance.keva.Keva;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/larus/bmhome/utils/LandingRedBadgeHelper;", "Lcom/larus/bmhome/utils/ILandingRedBadgeHelper;", "<init>", "()V", "chatPageResumed", "", "keva", "Lcom/bytedance/keva/Keva;", "setChatPageResumed", "", "isChatPageResumed", "setMainTabPageResumed", "isMainTabPageResumed", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LandingRedBadgeHelper implements ILandingRedBadgeHelper {
    public boolean a;
    public final Keva b;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.utils.ILandingRedBadgeHelper
    public final void c() {
        this.a = true;
    }

    @Override // com.larus.bmhome.utils.ILandingRedBadgeHelper
    public final void a() {
        this.b.storeBoolean("main_tab_page_resumed", true);
    }

    public LandingRedBadgeHelper() {
        this.b = Keva.getRepo("landing_red_badge.keva");
    }

    @Override // com.larus.bmhome.utils.ILandingRedBadgeHelper
    public final boolean b() {
        return this.a;
    }
}
