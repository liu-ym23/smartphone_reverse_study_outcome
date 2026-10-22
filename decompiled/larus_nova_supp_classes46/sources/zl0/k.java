package zl0;

import com.bytedance.android.live.room.api.messagewindow.lifecycle.ICardLifecycle;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.OfficialChannelExtraInfo;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ l a;
    public final /* synthetic */ IRoom b;

    public k(l r1, IRoom r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r7) {
        ICardLifecycle.State r8 = (ICardLifecycle.State) r7;
        if (r8 != null) goto L6;
        return;
    L6:
        if (j.a[r8.ordinal()] != 1) goto L30;
        IRoom r9 = this.b;
        Long r1 = null;
        if (r9 == null) goto L11;
        String r10 = r9.getOwnerUserIdString();
    L12:
        IRoom r2 = this.b;
        if (r2 == null) goto L17;
        OfficialChannelExtraInfo r3 = r2.getOfficialChannelExtraInfo();
        if (r3 == null) goto L17;
        Long r4 = Long.valueOf(r3.getShowListId());
    L18:
        Boolean r5 = Boolean.valueOf(mm0.b.b(r4));
        IRoom r6 = this.b;
        if (r6 == null) goto L21;
        Long r11 = Long.valueOf(r6.getId());
    L22:
        IRoom r12 = this.b;
        if (r12 == null) goto L27;
        OfficialChannelExtraInfo r13 = r12.getOfficialChannelExtraInfo();
        if (r13 == null) goto L27;
        r1 = Long.valueOf(r13.getShowListId());
    L27:
        com.bytedance.android.live.messagewindow.business.util.c.c(r10, mm0.b.c(r5, r11, r1), this.a.d, true);
        return;
    L21:
        r11 = null;
    L17:
        r4 = null;
        goto L18
    L11:
        r10 = null;
        goto L12
    }
}
