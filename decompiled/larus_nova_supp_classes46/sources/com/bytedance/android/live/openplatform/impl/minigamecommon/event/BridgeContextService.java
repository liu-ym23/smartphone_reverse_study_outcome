package com.bytedance.android.live.openplatform.impl.minigamecommon.event;

import android.os.Bundle;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext;
import com.bytedance.android.livehostapi.business.depend.openplatform.IEventListener;
import com.bytedance.android.livehostapi.business.depend.openplatform.MiniAppInstance;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigamecommon/event/BridgeContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BridgeContextService extends OpenPlatformContextService {
    public final Set<String> a;

    public final void f() {
        Iterator r0 = CollectionsKt.toList(this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        String r1 = (String) r0.next();
        Intrinsics.checkNotNullParameter(r1, "event");
        this.a.remove(r1);
        OpenPlatformContext r2 = getOpenPlatformContext();
        if (r2 == null) goto L11;
        MiniAppInstance r3 = ((MiniGameContext) r2).getMiniGameInstance();
        if (r3 == null) goto L4;
        r3.unregisterEventListener(r1);
        goto L4
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext");
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService
    public final void onDestroy() {
        super.onDestroy();
        f();
    }

    public BridgeContextService(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
        this.a = new LinkedHashSet();
    }

    public final void g(String r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "command");
        OpenPlatformContext r0 = getOpenPlatformContext();
        if (r0 == null) goto L9;
        MiniAppInstance r1 = ((MiniGameContext) r0).getMiniGameInstance();
        if (r1 == null) goto L10;
        r1.executeCommand(r2, r3);
        return;
    L10:
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext");
    }

    public final void h(String r2, IEventListener r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.a.add(r2);
        OpenPlatformContext r0 = getOpenPlatformContext();
        if (r0 == null) goto L9;
        MiniAppInstance r1 = ((MiniGameContext) r0).getMiniGameInstance();
        if (r1 == null) goto L10;
        r1.registerEventListener(r2, r3);
        return;
    L10:
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext");
    }
}
