package com.larus.aweme.impl;

import com.larus.aweme.api.video.service.IAwemeVideoFeedService;
import com.larus.bmhome.auth.DouyinFeedAbConf;
import com.larus.bmhome.auth.DouyinFeedEntrance;
import com.larus.bmhome.auth.ILaunchCacheService;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\u0012R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/aweme/impl/AwemeVideoFeed;", "Lcom/larus/aweme/api/video/service/IAwemeVideoFeedService;", "<init>", "()V", "cacheData", "Lcom/larus/bmhome/auth/DouyinFeedAbConf;", "updateDataCache", "", "isEnableDouyinFeedCocoEntrance", "", "isEnableDouyinFeedBotEntrance", "isEnableDouyinFeedBottomTabEntrance", "isEnableDouYinSdk", "getSearchSceneId", "", "getSceneId", "getPushEntranceType", "", "()Ljava/lang/Integer;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class AwemeVideoFeed implements IAwemeVideoFeedService {
    public DouyinFeedAbConf a;

    @Override // com.larus.aweme.api.video.service.IAwemeVideoFeedService
    public final boolean b() {
        return true;
    }

    @Override // com.larus.aweme.api.video.service.IAwemeVideoFeedService
    public final String a() {
        DouyinFeedAbConf r0 = this.a;
        if (r0 == null) goto L6;
        String r1 = r0.d();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // com.larus.aweme.api.video.service.IAwemeVideoFeedService
    public final void c() {
        ILaunchCacheService r0 = (ILaunchCacheService) ServiceManager.get().getService(ILaunchCacheService.class);
        if (r0 == null) goto L9;
        LaunchInfo r1 = r0.c();
        if (r1 == null) goto L9;
        DouyinFeedAbConf r2 = r1.f0();
        if (r2 == null) goto L9;
        DouyinFeedAbConf r3 = DouyinFeedAbConf.a(r2);
    L10:
        this.a = r3;
        return;
    L9:
        r3 = null;
        goto L10
    }

    @Override // com.larus.aweme.api.video.service.IAwemeVideoFeedService
    public final boolean d() {
        DouyinFeedAbConf r0 = this.a;
        if (r0 == null) goto L15;
        List r1 = r0.b();
        if (r1 == null) goto L16;
        List r2 = r1;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r4 = r2.iterator();
    L8:
        if (r4.hasNext() == false) goto L11;
        r3.add(Integer.valueOf(((DouyinFeedEntrance) r4.next()).a()));
        goto L8
    L11:
        if (r3.contains(2) != true) goto L17;
        return true;
    L17:
        return false;
    L16:
        return false;
    L15:
        return false;
    }

    @Override // com.larus.aweme.api.video.service.IAwemeVideoFeedService
    public final boolean e() {
        DouyinFeedAbConf r0 = this.a;
        if (r0 == null) goto L15;
        List r1 = r0.b();
        if (r1 == null) goto L16;
        List r2 = r1;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r4 = r2.iterator();
    L8:
        if (r4.hasNext() == false) goto L11;
        r3.add(Integer.valueOf(((DouyinFeedEntrance) r4.next()).a()));
        goto L8
    L11:
        if (r3.contains(1) != true) goto L17;
        return true;
    L17:
        return false;
    L16:
        return false;
    L15:
        return false;
    }

    @Override // com.larus.aweme.api.video.service.IAwemeVideoFeedService
    public final boolean f() {
        DouyinFeedAbConf r0 = this.a;
        if (r0 == null) goto L15;
        List r1 = r0.b();
        if (r1 == null) goto L16;
        List r2 = r1;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r4 = r2.iterator();
    L8:
        if (r4.hasNext() == false) goto L11;
        r3.add(Integer.valueOf(((DouyinFeedEntrance) r4.next()).a()));
        goto L8
    L11:
        if (r3.contains(3) != true) goto L17;
        return true;
    L17:
        return false;
    L16:
        return false;
    L15:
        return false;
    }

    @Override // com.larus.aweme.api.video.service.IAwemeVideoFeedService
    public final String getSceneId() {
        DouyinFeedAbConf r0 = this.a;
        if (r0 == null) goto L7;
        DouyinFeedEntrance r1 = r0.c();
        if (r1 == null) goto L7;
        return r1.b();
    L7:
        return null;
    }

    public AwemeVideoFeed() {
        ILaunchCacheService r0 = (ILaunchCacheService) ServiceManager.get().getService(ILaunchCacheService.class);
        if (r0 == null) goto L9;
        LaunchInfo r1 = r0.c();
        if (r1 == null) goto L9;
        DouyinFeedAbConf r2 = r1.f0();
        if (r2 == null) goto L9;
        DouyinFeedAbConf r3 = DouyinFeedAbConf.a(r2);
    L10:
        this.a = r3;
        return;
    L9:
        r3 = null;
        goto L10
    }
}
