package com.larus.uaigc.service;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.larus.platform.api.creation.UserCreation;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J<\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016¨\u0006\u0017"}, d2 = {"Lcom/larus/uaigc/service/ICreationNotifyServiceNoop;", "Lcom/larus/uaigc/service/ICreationNotifyService;", "<init>", "()V", "pushCreationNotify", "", "creation", "Lcom/larus/platform/api/creation/UserCreation;", "activity", "Landroid/app/Activity;", "shareContainer", "Landroid/view/View;", "targetActivity", "skipChannel", "", "pushCreationDoSameNotify", "notifyInfo", "Lcom/larus/uaigc/service/CreationDoSameNotifyInfo;", "enterMethod", "", "clickCallBack", "Lkotlin/Function0;", "dismissCreationNotify", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ICreationNotifyServiceNoop implements ICreationNotifyService {
    public ICreationNotifyServiceNoop() {
    }

    @Override // com.larus.uaigc.service.ICreationNotifyService
    public final void J(UserCreation r1, FragmentActivity r2, View r3, Activity r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r1, "creation");
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "shareContainer");
    }

    @Override // com.larus.uaigc.service.ICreationNotifyService
    public final void K(CreationDoSameNotifyInfo r1, Activity r2, Activity r3, String r4, Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r5, "clickCallBack");
    }

    @Override // com.larus.uaigc.service.ICreationNotifyService
    public final void y() {
    }
}
