package com.obric.livecard.api;

import android.app.Application;
import android.content.Context;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.livecard.api.island.IslandApi;
import com.obric.livecard.api.island.IslandHideApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013J\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u0003H&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/obric/livecard/api/ILiveCard;", "", "context", "Landroid/app/Application;", "getContext", "()Landroid/app/Application;", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "getPackageName", "()Ljava/lang/String;", "getIslandHideApi", "Lcom/obric/livecard/api/island/IslandHideApi;", "getIslandService", "Lcom/obric/livecard/api/island/IslandApi;", "getVersion", "", "Landroid/content/Context;", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "Companion", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface ILiveCard {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/livecard/api/ILiveCard$Companion;", "", "()V", "inst", "Lcom/obric/livecard/api/ILiveCard;", "getInst", "()Lcom/obric/livecard/api/ILiveCard;", "instance", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static volatile ILiveCard instance;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }

        public final ILiveCard getInst() {
            ILiveCard r0 = instance;
            if (r0 != null) goto L13;
            monitor-enter(this);
            r0 = instance;     // Catch: Throwable -> L10
            if (r0 != null) goto L8;
            LiveCard r1 = LiveCard.INSTANCE;     // Catch: Throwable -> L10
            instance = (ILiveCard) ZeusTransformUtils.preCheckCast(r1, ILiveCard.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            r0 = (ILiveCard) ZeusTransformUtils.preCheckCast(r1, ILiveCard.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
        L10:
            th = move-exception;
            throw th;
        L13:
            return r0;
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ IslandHideApi getIslandHideApi$default(ILiveCard r2, Application r3, int r4, Object r5) {
            ILiveCard r6 = (ILiveCard) ZeusTransformUtils.wrapperContextForParams(r2, ILiveCard.class, "com.obric.memorydata.plugin");
            Application r7 = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.memorydata.plugin");
            if (r5 != null) goto L10;
            if ((r4 & 1) == 0) goto L8;
            r7 = null;
        L8:
            return r6.getIslandHideApi(r7);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getIslandHideApi");
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    Application getContext();

    IslandHideApi getIslandHideApi(Application r1);

    IslandApi getIslandService();

    String getPackageName();

    int getVersion(Context r1);

    void init(Application r1);
}
