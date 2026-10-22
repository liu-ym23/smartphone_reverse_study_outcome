package com.bytedance.android.livesdk.interactivity.barrage.utils.shoot;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.cache.LruCache;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.interactivity.zdanmaku.widget.LandscapeDanmakuPresenterV2;
import com.bytedance.android.livesdkapi.depend.model.live.vs.BusinessConfigure;
import com.bytedance.android.livesdkapi.depend.model.live.vs.BusinessResourceConfigure;
import com.bytedance.bdlocation.BuildConfig;
import j40.f4;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends r22.a<BusinessConfigure> {
    public LinkedList<BusinessConfigure> c;
    public MutableLiveData<Boolean> d;
    public final b e;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.a$a, reason: collision with other inner class name */
    public static final class C0102a {
    }

    static {
    }

    @Override // r22.a
    public final Queue<BusinessConfigure> h() {
        LinkedList<BusinessConfigure> r0 = this.c;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return new LinkedList();
    }

    @Override // r22.a
    public final BusinessConfigure j() {
        LinkedList<BusinessConfigure> r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.pollFirst();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void l() {
        LinkedList<BusinessConfigure> r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isEmpty() == false) goto L8;
        return;
    L8:
        if (this.b.a() == false) goto L35;
        LinkedList<BusinessConfigure> r1 = this.c;
        Long r2 = null;
        if (r1 == null) goto L12;
        BusinessConfigure r3 = r1.pollFirst();
    L13:
        if (r3 == null) goto L36;
        this.b.b((T) r3);
        IMiddlewareUserService r4 = (IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class);
        if (r4 == null) goto L19;
        com.bytedance.android.livesdk.user.e r5 = r4.user();
        if (r5 == null) goto L19;
        String r6 = r5.n();
    L20:
        BusinessResourceConfigure r7 = r3.resourceConfig;
        if (r7 == null) goto L23;
        Long r8 = Long.valueOf(r7.resourceId);
    L24:
        if (r8 == null) goto L32;
        LruCache r9 = (LruCache) f4.u.getValue();
        StringBuilder r10 = new StringBuilder();
        if (r6 != null) goto L28;
        r6 = BuildConfig.FLAVOR;
    L28:
        r10.append(r6);
        r10.append("_");
        BusinessResourceConfigure r11 = r3.resourceConfig;
        if (r11 == null) goto L31;
        r2 = Long.valueOf(r11.resourceId);
    L31:
        r10.append(String.valueOf(r2));
        r9.put(r10.toString(), 1);
    L32:
        l();
        return;
    L23:
        r8 = null;
    L19:
        r6 = null;
        goto L20
    L36:
        return;
    L12:
        r3 = null;
        goto L13
    }

    public a(LandscapeDanmakuPresenterV2.b r2) {
        Intrinsics.checkNotNullParameter(r2, "danmakuReceiver");
        super(r2);
        this.e = new b(this);
    }

    @Override // r22.a
    public final void e(BusinessConfigure r2) {
        BusinessConfigure r3 = r2;
        Intrinsics.checkNotNullParameter(r3, "danmaku");
        LinkedList<BusinessConfigure> r0 = this.c;
        if (r0 == null) goto L6;
        r0.addLast(r3);
        return;
    }
}
