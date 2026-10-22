package com.bytedance.android.live.openplatform.impl.minigameanchor.cast;

import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.b90;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigameanchor/cast/LiveMgToolbarContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "gameContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveMgToolbarContextService extends OpenPlatformContextService {
    public final boolean a;
    public final c0 b;
    public final OpenPlatformContext c;

    public static final class a {
        public final ToolbarButton a;
        public final boolean b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L10;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public final int hashCode() {
            ToolbarButton r0 = this.a;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode();
        L6:
            int r2 = r1 * 31;
            boolean r3 = this.b;
            ?? r4 = r3;
            if (r3 == false) goto L10;
            r4 = 1;
        L10:
            return r2 + r4;
        L5:
            r1 = 0;
            goto L6
        }

        public final String toString() {
            return "ToolbarButtonConfig(button=" + this.a + ", disableInGame=" + this.b + ")";
        }

        public a(ToolbarButton r2) {
            Intrinsics.checkNotNullParameter(r2, "button");
            this.a = r2;
            this.b = true;
        }
    }

    public LiveMgToolbarContextService(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "gameContext");
        super(r2);
        this.c = r2;
        this.a = ((Boolean) b90.a.getValue()).booleanValue();
        this.b = y3.m(r2.getDataCenter());
    }

    public final void f(boolean r6) {
        if (this.a == false) goto L14;
        int r0 = zq0.b.a;
        OpenPlatformContext r1 = this.c;
        Intrinsics.checkNotNullParameter(r1, "ctx");
        Room r2 = r1.getRoom();
        if (r2 == null) goto L9;
        Map r3 = r2.getAnchorABMap();
        if (r3 == null) goto L9;
        String r4 = (String) r3.get("video_linkmic_v3");
    L11:
        if (Intrinsics.areEqual(r4, "1") == true) goto L14;
        List r5 = CollectionsKt.mutableListOf(new a[]{new a(ToolbarButton.PK)});
    L15:
        Iterator r7 = r5.iterator();
    L17:
        if (r7.hasNext() == false) goto L22;
        a r8 = (a) r7.next();
        if (r6 == true) goto L20;
        this.b.h(r8.a.extended());
        goto L17
    L20:
        this.b.l(r8.a.extended(), "游戏开启时，暂不支持该功能");
        goto L17
    L22:
        return;
    L9:
        r4 = null;
    L14:
        r5 = CollectionsKt.mutableListOf(new a[]{new a(ToolbarButton.PK), new a(ToolbarButton.INTERACTION), new a(ToolbarButton.INTERACTION_ROOM)});
        goto L15
    }
}
