package com.larus.aweme.api.video.service;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0096\u0001¢\u0006\u0002\u0010\u0006J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096\u0001J\t\u0010\t\u001a\u00020\bH\u0096\u0001J\t\u0010\n\u001a\u00020\u000bH\u0096\u0001J\t\u0010\f\u001a\u00020\u000bH\u0096\u0001J\t\u0010\r\u001a\u00020\u000bH\u0097\u0001J\t\u0010\u000e\u001a\u00020\u000bH\u0096\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u0096\u0001¨\u0006\u0011"}, d2 = {"Lcom/larus/aweme/api/video/service/AwemeVideoFeedDelegate;", "Lcom/larus/aweme/api/video/service/IAwemeVideoFeedService;", "<init>", "()V", "getPushEntranceType", "", "()Ljava/lang/Integer;", "getSceneId", "", "getSearchSceneId", "isEnableDouYinSdk", "", "isEnableDouyinFeedBotEntrance", "isEnableDouyinFeedBottomTabEntrance", "isEnableDouyinFeedCocoEntrance", "updateDataCache", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class AwemeVideoFeedDelegate implements IAwemeVideoFeedService {
    public static final AwemeVideoFeedDelegate b = null;
    public final /* synthetic */ IAwemeVideoFeedService a;

    static {
        b = new AwemeVideoFeedDelegate();
    }

    @Override // com.larus.aweme.api.video.service.IAwemeVideoFeedService
    public final String a() {
        return this.a.a();
    }

    @Override // com.larus.aweme.api.video.service.IAwemeVideoFeedService
    public final boolean b() {
        return this.a.b();
    }

    @Override // com.larus.aweme.api.video.service.IAwemeVideoFeedService
    public final void c() {
        this.a.c();
    }

    @Override // com.larus.aweme.api.video.service.IAwemeVideoFeedService
    public final boolean d() {
        return this.a.d();
    }

    @Override // com.larus.aweme.api.video.service.IAwemeVideoFeedService
    public final boolean e() {
        return this.a.e();
    }

    @Override // com.larus.aweme.api.video.service.IAwemeVideoFeedService
    @Deprecated(message = "tab style not use user/launch to config, use tabbar/config api", replaceWith = @ReplaceWith(expression = "BottomTabConfigManager", imports = {}))
    public final boolean f() {
        return this.a.f();
    }

    @Override // com.larus.aweme.api.video.service.IAwemeVideoFeedService
    public final String getSceneId() {
        return this.a.getSceneId();
    }

    private AwemeVideoFeedDelegate() {
        Object r0 = ServiceManager.get().getService(IAwemeVideoFeedService.class);
        Intrinsics.checkNotNull(r0);
        this.a = (IAwemeVideoFeedService) r0;
    }
}
