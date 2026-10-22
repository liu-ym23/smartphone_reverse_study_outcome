package yj0;

import com.bytedance.android.live.liveinteract.chatroom.chatroom.list.BaseTalkApplyListContract$View;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f extends com.bytedance.android.live.liveinteract.chatroom.chatroom.list.b {
    public final IRoom i;

    public f(IRoom r2, BaseTalkApplyListContract$View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super(r2, r3);
        this.i = r2;
    }
}
