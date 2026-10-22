package com.bytedance.android.live.room.navi.userinfo_p.viewmodel.base;

import com.bytedance.live.datacontext.DataContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import z91.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/viewmodel/base/BaseUiVM;", "Lcom/bytedance/live/datacontext/DataContext;", "", "Lz91/a;", "action", "", "sendAction", "reduce", "<init>", "()V", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseUiVM extends DataContext {
    public abstract void reduce(a r1);

    public BaseUiVM() {
    }

    public void sendAction(a r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        reduce(r2);
    }
}
