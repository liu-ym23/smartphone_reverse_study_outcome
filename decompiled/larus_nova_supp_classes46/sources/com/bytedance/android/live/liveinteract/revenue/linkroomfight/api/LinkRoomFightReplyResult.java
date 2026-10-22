package com.bytedance.android.live.liveinteract.revenue.linkroomfight.api;

import am3.g;
import com.bytedance.android.livesdk.multilink.base.model.w;
import com.bytedance.android.livesdkapi.depend.model.live.link.IRoomBattleProcessInfo;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkRoomFightReplyGuestInfo;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R*\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/api/LinkRoomFightReplyResult;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/multilink/base/model/w;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkRoomFightReplyGuestInfo;", "guestInfos", "Ljava/util/List;", "getGuestInfos", "()Ljava/util/List;", "setGuestInfos", "(Ljava/util/List;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/link/IRoomBattleProcessInfo;", "processStatus", "Lcom/bytedance/android/livesdkapi/depend/model/live/link/IRoomBattleProcessInfo;", "getProcessStatus", "()Lcom/bytedance/android/livesdkapi/depend/model/live/link/IRoomBattleProcessInfo;", "setProcessStatus", "(Lcom/bytedance/android/livesdkapi/depend/model/live/link/IRoomBattleProcessInfo;)V", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkRoomFightReplyResult extends FlexModelBase<w> implements w, h {

    @SerializedName("guest_infos")
    protected List<? extends LinkRoomFightReplyGuestInfo> guestInfos;

    @SerializedName("process_info")
    protected IRoomBattleProcessInfo processStatus;

    public LinkRoomFightReplyResult() {
        super(w.class);
        this.guestInfos = new ArrayList();
    }

    public List<LinkRoomFightReplyGuestInfo> getGuestInfos() {
        return this.guestInfos;
    }

    public IRoomBattleProcessInfo getProcessStatus() {
        return this.processStatus;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.livesdkapi.depend.model.live.link.IRoomBattleProcessInfo, java.lang.Object] */
    public LinkRoomFightReplyResult(g r6) {
        super(w.class);
        this.guestInfos = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L12;
        g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this.guestInfos.add(f.a(r6, LinkRoomFightReplyGuestInfo.class));
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this.processStatus = f.a(r6, IRoomBattleProcessInfo.class);
        goto L3
    L9:
        am3.h.d(r3, r6);
        goto L3
    L12:
        r6.d(r0);
        setThreadSafe(true);
        if (this.guestInfos.isEmpty() == false) goto L25;
        this.guestInfos = new ArrayList();
        return;
    }

    public void setGuestInfos(List<? extends LinkRoomFightReplyGuestInfo> r1) {
        this.guestInfos = r1;
    }

    public void setProcessStatus(IRoomBattleProcessInfo r1) {
        this.processStatus = r1;
    }
}
