package com.bytedance.android.live.lynx;

import com.bytedance.android.live.base.IService;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/lynx/ILynxModuleService;", "Lcom/bytedance/android/live/base/IService;", "", "Lcom/lynx/tasm/behavior/a;", "getBehaviorList", "()Ljava/util/List;", "behaviorList", "getLynxPullRefreshView", "()Lcom/lynx/tasm/behavior/a;", "lynxPullRefreshView", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILynxModuleService extends IService {
    List<com.lynx.tasm.behavior.a> getBehaviorList();

    com.lynx.tasm.behavior.a getLynxPullRefreshView();
}
