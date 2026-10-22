package com.bytedance.android.livesdk.dislike.preload.loader;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.dislike.ActionsManager;
import com.bytedance.android.livesdk.dislike.n;
import com.bytedance.android.livesdk.dislike.t;
import com.bytedance.android.livesdk.utils.LivePanelsOptUtil;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import rs0.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class LPPanelOriginDataLoader extends a {
    public final String d;
    public boolean e;
    public Boolean f;
    public List<n> g;

    public final void f() {
        IBaseUser r1 = null;
        if (((Boolean) i.a.getValue()).booleanValue() == false) goto L8;
        IRoom r0 = this.b;
        if (r0 == null) goto L7;
        r1 = r0.getOwner();
    L7:
        com.bytedance.android.live.room.api.follow.b.c(r1, "DislikeOptionsBottomDialog-onViewCreated-2", this.b, new LPPanelOriginDataLoader$refresh$1(this));
        return;
    L8:
        g(e(this.e, null));
    }

    @Override // com.bytedance.android.livesdk.dislike.preload.loader.a
    public final List<n> d() {
        f();
        return this.g;
    }

    public LPPanelOriginDataLoader(com.bytedance.android.livesdk.dislike.preload.context.a r2) {
        Intrinsics.checkNotNullParameter(r2, "session");
        super(r2);
        this.d = "LPPanelOriginDataLoader";
        this.g = new ArrayList();
    }

    public final void g(List<n> r7) {
        boolean r2 = false;
        if (r7.size() != this.g.size()) goto L16;
        Iterator<T> r0 = r7.iterator();
        int r1 = 0;
    L7:
        if (r0.hasNext() == false) goto L15;
        Object r3 = r0.next();
        int r4 = r1 + 1;
        if (r1 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        n r5 = (n) ListProtector.get(this.g, r1);
        if (r5.a((n) r3) == false) goto L16;
        r1 = r4;
        goto L7
    L15:
        r2 = true;
    L16:
        if (r2 == true) goto L21;
        this.g = r7;
        LivePanelsOptUtil.c("更新长按面板数据");
        this.c.a();
        return;
    }

    public final List<n> e(boolean r6, Boolean r7) {
        final IExternalConfigJudger r1 = null;
        if (t.b() == false) goto L8;
        ALogger.i(this.d, "button area has two lines");
        ActionsManager r8 = this.c.b();
        if (r8 == null) goto L15;
        List<n> r9 = r8.w(r7);
    L16:
        RoomContext r10 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r10 == null) goto L21;
        com.bytedance.live.datacontext.n r11 = r10.getExternalConfigJudger();
        if (r11 == null) goto L21;
        r1 = (IExternalConfigJudger) r11.getValue();
    L21:
        if (r1 == null) goto L24;
        if (r9 == null) goto L24;
        CollectionsKt.removeAll(r9, new LPPanelOriginDataLoader$getOptionItems$1(r1));
    L24:
        if (r9 == null) goto L26;
        return r9;
    L26:
        return new ArrayList();
    L15:
        r9 = null;
        goto L16
    L8:
        if (t.c() == false) goto L12;
        ALogger.i(this.d, "one line with patch");
        ActionsManager r12 = this.c.b();
        if (r12 == null) goto L15;
        r9 = r12.v(r7);
        goto L16
    L12:
        ALogger.i(this.d, "keep current state");
        ActionsManager r0 = this.c.b();
        if (r0 == null) goto L15;
        r9 = r0.m(r6, r7);
        goto L16
    }
}
