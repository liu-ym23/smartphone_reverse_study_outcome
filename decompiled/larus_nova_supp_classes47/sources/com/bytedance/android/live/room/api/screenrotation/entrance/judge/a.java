package com.bytedance.android.live.room.api.screenrotation.entrance.judge;

import com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService;
import com.bytedance.android.live.room.api.screenrotation.entrance.IRotateEntrance;
import com.bytedance.android.live.room.api.screenrotation.entrance.b;
import com.bytedance.android.live.room.api.screenrotation.rotate.d;
import io.reactivex.disposables.CompositeDisposable;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class a implements com.bytedance.android.live.room.api.screenrotation.entrance.a {
    public d a;
    public final b b;
    public final CompositeDisposable c;

    public void d(d r2) {
        Intrinsics.checkNotNullParameter(r2, "session");
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.entrance.a
    public void onUnload() {
        this.c.clear();
    }

    public a() {
        this.b = ((IScreenRotateService) k.n(IScreenRotateService.class)).entranceVisibleNotify();
        this.c = new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.entrance.a
    public boolean a(IRotateEntrance r2) {
        Intrinsics.checkNotNullParameter(r2, "entrance");
        Intrinsics.checkNotNullParameter(r2, "entrance");
        return true;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.entrance.a
    public final void b(d r2) {
        Intrinsics.checkNotNullParameter(r2, "session");
        this.a = r2;
        d(r2);
    }
}
