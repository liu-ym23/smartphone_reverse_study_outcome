package com.bytedance.android.livesdk.interactivity.square;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.ui.IModelListDataManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements IModelListDataManager {
    public final List<h52.c> a;
    public final PropertyOwner<IModelListDataManager.a> b;
    public final m52.e c;
    public final int d;
    public final int e;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenV2.ui.IModelListDataManager
    public final PropertyOwner a() {
        PropertyOwner<IModelListDataManager.a> r0 = this.b;
        r0.getClass();
        return r0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenV2.ui.IModelListDataManager
    public final void destroy() {
        ((ArrayList) this.a).clear();
    }

    public a() {
        this.d = 100;
        this.e = 30;
        this.a = new ArrayList();
        this.b = new PropertyOwner(new IModelListDataManager.a(IModelListDataManager.ModelChangeType.RELOAD_ALL, 0, 0, null, 30));
        this.c = new m52.e();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenV2.ui.IModelListDataManager
    public final m52.e c() {
        return this.c;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenV2.ui.IModelListDataManager
    public final List<h52.c> getMessageList() {
        return this.a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenV2.ui.IModelListDataManager
    public final void b(h52.c r8) {
        Intrinsics.checkNotNullParameter(r8, "model");
        if (((ArrayList) this.a).size() <= this.d) goto L5;
        ((ArrayList) this.a).subList(0, this.e).clear();
        IModelListDataManager.a r0 = new IModelListDataManager.a(IModelListDataManager.ModelChangeType.REMOVE_RANGE, 0, this.e, null, 18);
        this.c.onEvent(r0);
        this.b.a(r0);
    L5:
        ((ArrayList) this.a).add(r8);
        IModelListDataManager.a r1 = new IModelListDataManager.a(IModelListDataManager.ModelChangeType.INSERT_BOTTOM, ((ArrayList) this.a).size() - 1, 0, r8, 12);
        this.c.onEvent(r1);
        this.b.a(r1);
    }
}
