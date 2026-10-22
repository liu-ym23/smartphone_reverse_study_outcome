package com.bytedance.android.live.liveinteract.floatwindow.common.listener;

import android.os.Bundle;
import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/floatwindow/common/listener/LinkmicOnlineListDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkmicOnlineListDiffCallback extends DiffUtil.Callback {
    public final List<Object> a;
    public final List<Object> b;

    public static final class a {
    }

    static {
    }

    public final int getNewListSize() {
        return this.b.size();
    }

    public final int getOldListSize() {
        return this.a.size();
    }

    public LinkmicOnlineListDiffCallback(List<? extends Object> r2, List<? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "oldDatas");
        Intrinsics.checkNotNullParameter(r3, "newDatas");
        this.a = r2;
        this.b = r3;
    }

    public final boolean areContentsTheSame(int r5, int r6) {
        Object r7 = ListProtector.get(this.a, r5);
        Object r8 = ListProtector.get(this.b, r6);
        if ((!Intrinsics.areEqual(r7.getClass(), r8.getClass())) == false) goto L6;
        return false;
    L6:
        if ((r7 instanceof ILinkPlayerInfoBridge) == true) goto L8;
    L16:
        return false;
    L8:
        if ((r8 instanceof ILinkPlayerInfoBridge) == false) goto L16;
        ILinkPlayerInfoBridge r9 = (ILinkPlayerInfoBridge) r7;
        ILinkPlayerInfoBridge r10 = (ILinkPlayerInfoBridge) r8;
        if (r9.getTalkState() == r10.getTalkState()) goto L12;
    L14:
        return false;
    L12:
        if (r9.getSilenceStatus() != r10.getSilenceStatus()) goto L14;
        return true;
    }

    public final boolean areItemsTheSame(int r4, int r5) {
        Object r6 = ListProtector.get(this.a, r4);
        Object r7 = ListProtector.get(this.b, r5);
        if ((!Intrinsics.areEqual(r6.getClass(), r7.getClass())) == false) goto L6;
        return false;
    L6:
        if ((r6 instanceof ILinkPlayerInfoBridge) == true) goto L8;
    L19:
        return true;
    L8:
        if ((r7 instanceof ILinkPlayerInfoBridge) == false) goto L19;
        IBaseUser r8 = ((ILinkPlayerInfoBridge) r6).getUser();
        String r0 = null;
        if (r8 == null) goto L12;
        String r9 = r8.getIdString();
    L13:
        IBaseUser r10 = ((ILinkPlayerInfoBridge) r7).getUser();
        if (r10 == null) goto L17;
        r0 = r10.getIdString();
    L17:
        if ((!Intrinsics.areEqual(r9, r0)) == false) goto L19;
        return false;
    L12:
        r9 = null;
        goto L13
    }

    public final Object getChangePayload(int r4, int r5) {
        Bundle r0 = new Bundle();
        Object r6 = ListProtector.get(this.a, r4);
        Object r7 = ListProtector.get(this.b, r5);
        if ((r6 instanceof ILinkPlayerInfoBridge) == true) goto L5;
    L12:
        return r0;
    L5:
        if ((r7 instanceof ILinkPlayerInfoBridge) == false) goto L12;
        ILinkPlayerInfoBridge r8 = (ILinkPlayerInfoBridge) r6;
        ILinkPlayerInfoBridge r9 = (ILinkPlayerInfoBridge) r7;
        if (r8.getTalkState() == r9.getTalkState()) goto L10;
        r0.putInt("payload_key_talk_state_change", r9.getTalkState());
    L10:
        if (r8.getSilenceStatus() == r9.getSilenceStatus()) goto L12;
        r0.putInt("payload_key_mute_state_change", r9.getSilenceStatus());
        goto L12
    }
}
