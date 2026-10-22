package com.bytedance.android.livesdk.dislike.preload.loader;

import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.model.user.f;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.dislike.l;
import com.bytedance.android.livesdk.dislike.n;
import com.bytedance.android.livesdk.utils.LivePanelsOptUtil;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.distribution.EXTERNAL_CONFIG_TYPE;
import com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b extends com.bytedance.android.livesdk.dislike.preload.loader.a {
    public final CompositeDisposable d;
    public List<n> e;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Boolean r2 = (Boolean) r1;
            this.a.f();
        }
    }

    @Override // com.bytedance.android.livesdk.dislike.preload.loader.a
    public final void b() {
        RxUtilKt.c(this.c.c().subscribe(new a(this)), this.d);
    }

    @Override // com.bytedance.android.livesdk.dislike.preload.loader.a
    public final void c() {
        this.d.clear();
        this.e.clear();
    }

    @Override // com.bytedance.android.livesdk.dislike.preload.loader.a
    public final List<n> d() {
        ArrayList r0 = new ArrayList();
        IRoom r1 = this.b;
        if (r1 == null) goto L7;
        IRoomAuthStatus r2 = r1.getRoomAuthStatus();
        if (r2 == null) goto L7;
        long r3 = r2.getShowShare();
    L8:
        TTLiveSDK.hostService().user().loadRecentContact(25, new c(this, r0, r3));
        return this.e;
    L7:
        r3 = 0;
        goto L8
    }

    public final void f() {
        if (((Boolean) this.c.c().d).booleanValue() == true) goto L5;
        return;
    L5:
        Fragment r0 = this.c.getFragment();
        if (r0 == null) goto L29;
        List<n> r1 = this.e;
        if (r1 == null) goto L30;
        List<n> r2 = r1;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r4 = r2.iterator();
    L10:
        f r5 = null;
        if (r4.hasNext() == false) goto L20;
        n r6 = (n) r4.next();
        if ((r6 instanceof l) == true) goto L15;
        r6 = null;
    L15:
        l r7 = (l) r6;
        if (r7 == null) goto L18;
        r5 = r7.c;
    L18:
        r3.add(r5);
        goto L10
    L20:
        if ((!r3.isEmpty()) == true) goto L23;
        r3 = null;
    L23:
        if (r3 == null) goto L31;
        LivePanelsOptUtil.c("刷新IM状态");
        TTLiveSDK.hostService().user().fetchActiveStatusList(r0, r3);
        return;
    L31:
        return;
    L30:
        return;
    }

    public b(com.bytedance.android.livesdk.dislike.preload.context.a r2) {
        Intrinsics.checkNotNullParameter(r2, "session");
        super(r2);
        this.d = new CompositeDisposable();
        this.e = new ArrayList();
    }

    public static final boolean e(b r4, String r5) {
        r4.getClass();
        RoomContext r6 = RoomContext.a.c(RoomContext.Companion, r4.a, 0, 2);
        if (r6 == null) goto L12;
        com.bytedance.live.datacontext.n r7 = r6.getExternalConfigJudger();
        if (r7 == null) goto L13;
        IExternalConfigJudger r8 = (IExternalConfigJudger) r7.getValue();
        if (r8 != null) goto L9;
        return true;
    L9:
        if (r8.disable(EXTERNAL_CONFIG_TYPE.LongPressPanel, r5) != true) goto L15;
        return false;
    L15:
        return true;
    L13:
        return true;
    L12:
        return true;
    }
}
