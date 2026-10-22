package com.bytedance.android.livesdk.chatroom.viewmodel;

import com.bytedance.android.livesdk.link.model.bridge.u1;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h extends i {
    public final String g;
    public final String h;
    public final u1 i;
    public ClientUIInfo j;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodel.i
    public final ClientUIInfo a() {
        return this.j;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodel.i
    public final void b(ClientUIInfo r1) {
        this.j = r1;
    }

    public h(int r12, int r13, List<Integer> r14, boolean r15, String r16, String r17, u1 r18, ClientUIInfo r19) {
        Intrinsics.checkNotNullParameter(r16, "rtcExtInfo");
        Intrinsics.checkNotNullParameter(r17, "liveCoreExtInfo");
        super(r12, r13, r14, r15, false, r19, 16);
        this.g = r16;
        this.h = r17;
        this.i = r18;
        this.j = r19;
    }
}
