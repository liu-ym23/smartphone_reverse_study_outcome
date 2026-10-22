package com.bytedance.android.live.livepkaudience.dialog;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l extends com.bytedance.android.live.livepkaudience.base.x {
    public final /* synthetic */ PkAudienceListApplyDialogFragment a;
    public final /* synthetic */ LinkPlayerInfo b;

    @Override // com.bytedance.android.live.livepkaudience.base.x, com.bytedance.android.live.livepkaudience.base.g
    public final void onPermitSuccess(String r6) {
        Intrinsics.checkNotNullParameter(r6, "uid");
        PkAudienceListApplyDialogFragment r7 = this.a;
        IBaseUser r1 = this.b.getUser();
        if (r1 == null) goto L6;
        String r2 = r1.getIdString();
        if (r2 == null) goto L6;
    L7:
        r7.getClass();
        Intrinsics.checkNotNullParameter(r2, "uid");
        int r0 = r7.h.size();
        int r3 = 0;
    L8:
        if (r3 >= r0) goto L19;
        Object r4 = r7.h.get(r3);
        if ((r4 instanceof LinkPlayerInfo) == false) goto L18;
        IBaseUser r5 = ((LinkPlayerInfo) r4).getUser();
        if (r5 == null) goto L14;
        String r8 = r5.getIdString();
    L16:
        if (Intrinsics.areEqual(r8, r2) == false) goto L18;
    L20:
        if (r3 >= 0) goto L22;
        return;
    L22:
        if (r3 >= r7.h.size()) goto L37;
        Object r9 = r7.h.get(r3);
        if ((r9 instanceof LinkPlayerInfo) == false) goto L27;
        ((LinkPlayerInfo) r9).isHasApplied = true;
    L27:
        MultiTypeAdapter r10 = r7.t;
        if (r10 == null) goto L36;
        r10.notifyItemChanged(r3);
        return;
    L36:
        return;
    L37:
        return;
    L14:
        r8 = null;
    L18:
        r3 = r3 + 1;
        goto L8
    L19:
        r3 = -1;
    L6:
        r2 = "0";
        goto L7
    }

    public l(PkAudienceListApplyDialogFragment r1, LinkPlayerInfo r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.android.live.livepkaudience.base.x, com.bytedance.android.live.livepkaudience.base.g
    public final void l(String r1, Throwable r2) {
        Intrinsics.checkNotNullParameter(r1, "uid");
        this.b.isHasApplied = false;
    }
}
