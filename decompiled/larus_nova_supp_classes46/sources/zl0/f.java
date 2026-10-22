package zl0;

import com.bytedance.android.live.room.api.messagewindow.lifecycle.ICardLifecycle;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.OfficialChannelExtraInfo;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ g a;
    public final /* synthetic */ IRoom b;

    public f(g r1, IRoom r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r6) {
        ICardLifecycle.State r7 = (ICardLifecycle.State) r6;
        if (r7 != null) goto L6;
        return;
    L6:
        if (e.a[r7.ordinal()] != 1) goto L26;
        IRoom r8 = this.b;
        Long r1 = null;
        if (r8 == null) goto L13;
        OfficialChannelExtraInfo r9 = r8.getOfficialChannelExtraInfo();
        if (r9 == null) goto L13;
        Long r10 = Long.valueOf(r9.getShowListId());
    L14:
        Boolean r11 = Boolean.valueOf(mm0.b.b(r10));
        IRoom r2 = this.b;
        if (r2 == null) goto L17;
        Long r3 = Long.valueOf(r2.getId());
    L18:
        IRoom r4 = this.b;
        if (r4 == null) goto L23;
        OfficialChannelExtraInfo r5 = r4.getOfficialChannelExtraInfo();
        if (r5 == null) goto L23;
        r1 = Long.valueOf(r5.getShowListId());
    L23:
        com.bytedance.android.live.messagewindow.business.util.c.b(mm0.b.c(r11, r3, r1), this.a.d, true);
        return;
    L17:
        r3 = null;
    L13:
        r10 = null;
        goto L14
    }
}
