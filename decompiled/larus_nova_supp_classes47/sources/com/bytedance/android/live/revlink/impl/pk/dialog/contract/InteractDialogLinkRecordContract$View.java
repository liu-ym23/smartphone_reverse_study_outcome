package com.bytedance.android.live.revlink.impl.pk.dialog.contract;

import com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View;
import com.bytedance.android.livesdk.link.model.p5;
import com.bytedance.android.livesdk.link.model.v4;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.Metadata;
import x31.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/bytedance/android/live/revlink/impl/pk/dialog/contract/InteractDialogLinkRecordContract$View", "Lcom/bytedance/android/live/revlink/impl/control/dialog/RevInteractDialogFragmentBaseContract$View;", "Lx31/c;", "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class InteractDialogLinkRecordContract$View extends RevInteractDialogFragmentBaseContract$View<c> {
    public abstract void ba0(Throwable r1);

    public abstract void ca0(IRoom r1, v4 r2);

    public abstract void da0(Throwable r1);

    public abstract void ea0(p5 r1, String r2);

    public InteractDialogLinkRecordContract$View() {
    }
}
