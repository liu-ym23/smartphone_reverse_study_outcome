package com.larus.bmhome.chat.require;

import android.content.Context;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\t\u0010\b\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001¨\u0006\u000f"}, d2 = {"Lcom/larus/bmhome/chat/require/MainBotServiceDelegate;", "Lcom/larus/bmhome/chat/require/IMainBotService;", "<init>", "()V", "getSearchSceneId", "", "isEnableDouYinSdk", "", "isEnableDouyinFeedCocoEntrance", "openMainBot", "", "context", "Landroid/content/Context;", "param", "Lcom/larus/bmhome/chat/require/IMainBotService$MainBotParam;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class MainBotServiceDelegate implements IMainBotService {
    public static final MainBotServiceDelegate b = null;
    public final /* synthetic */ IMainBotService a;

    static {
        b = new MainBotServiceDelegate();
    }

    @Override // com.larus.bmhome.chat.require.IMainBotService
    public final String a() {
        return this.a.a();
    }

    @Override // com.larus.bmhome.chat.require.IMainBotService
    public final boolean b() {
        return this.a.b();
    }

    @Override // com.larus.bmhome.chat.require.IMainBotService
    public final void c(Context r2, IMainBotService.a r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "param");
        this.a.c(r2, r3);
    }

    private MainBotServiceDelegate() {
        IMainBotService r0 = (IMainBotService) ServiceManager.get().getService(IMainBotService.class);
        if (r0 != null) goto L5;
        r0 = new MainBotServiceNoop();
    L5:
        this.a = r0;
    }
}
