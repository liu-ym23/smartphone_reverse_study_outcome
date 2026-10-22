package com.bytedance.android.live.liveinteract.chatroom.chatroom.list;

import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e {
    public final LinkedList<Object> a;
    public final List<ILinkPlayerInfoBridge> b;

    /* JADX WARN: Multi-variable type inference failed */
    public e(LinkedList<Object> r2, List<? extends ILinkPlayerInfoBridge> r3) {
        Intrinsics.checkNotNullParameter(r2, "infoList");
        Intrinsics.checkNotNullParameter(r3, "aiGuestList");
        this.a = r2;
        this.b = r3;
    }
}
