package com.bytedance.android.live.liveinteract.linkpanel.contract;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.model.a1;
import com.bytedance.android.livesdk.chatroom.model.interact.e1;
import java.util.List;
import kotlin.Metadata;
import yf0.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/bytedance/android/live/liveinteract/linkpanel/contract/BaseTalkInviteListContract$View", "Lcom/bytedance/android/live/liveinteract/linkpanel/contract/InteractDialogFragmentBaseContract$View;", "Lyf0/b;", "<init>", "()V", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class BaseTalkInviteListContract$View extends InteractDialogFragmentBaseContract$View<b> {
    public abstract void aa0(Throwable r1);

    public abstract void ba0(IBaseUser r1, List<? extends e1> r2);

    public abstract void ca0(a1 r1);

    public BaseTalkInviteListContract$View() {
    }
}
