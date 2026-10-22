package com.bytedance.android.live.liveinteract.linkpanel.model;

import am3.g;
import com.bytedance.android.livesdk.multilink.base.model.m;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000b\u0010\fR(\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/model/InviteFriendsBody;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/multilink/base/model/m;", "", "", "invitedUidList", "Ljava/util/List;", "getInvitedUidList", "()Ljava/util/List;", "setInvitedUidList", "(Ljava/util/List;)V", "<init>", "()V", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InviteFriendsBody extends FlexModelBase<m> implements m, h {
    private List<Long> invitedUidList;

    public InviteFriendsBody() {
        super(m.class);
        this.invitedUidList = CollectionsKt.emptyList();
    }

    public List<Long> getInvitedUidList() {
        return this.invitedUidList;
    }

    public InviteFriendsBody(g r5) {
        super(m.class);
        this.invitedUidList = CollectionsKt.emptyList();
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L6;
        am3.h.d(decodeExtensionFields(r2, r5), r5);
        goto L3
    L6:
        r5.d(r0);
        setThreadSafe(true);
    }

    public void setInvitedUidList(List<Long> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.invitedUidList = r2;
    }
}
