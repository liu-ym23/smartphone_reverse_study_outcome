package com.bytedance.android.live.liveinteract.chatroom.chatroom.list;

import com.bytedance.android.live.liveinteract.chatroom.chatroom.interact.contract.InteractDialogFragmentBaseContract$View;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/bytedance/android/live/liveinteract/chatroom/chatroom/list/BaseTalkApplyListContract$View", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/interact/contract/InteractDialogFragmentBaseContract$View;", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/list/a;", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class BaseTalkApplyListContract$View extends InteractDialogFragmentBaseContract$View<a> {
    public abstract void S90(boolean r1);

    public abstract void T90(boolean r1);

    public abstract void U90(Throwable r1);

    public abstract void V90(List<? extends ILinkPlayerInfoBridge> r1, long r2, boolean r4, String r5, String r6, boolean r7, int r8, boolean r9, boolean r10);

    public abstract void W90(Throwable r1);

    public abstract void X90();

    public BaseTalkApplyListContract$View() {
    }
}
