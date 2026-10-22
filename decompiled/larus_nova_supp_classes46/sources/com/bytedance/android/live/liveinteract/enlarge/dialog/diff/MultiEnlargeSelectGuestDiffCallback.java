package com.bytedance.android.live.liveinteract.enlarge.dialog.diff;

import android.os.Bundle;
import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.enlarge.dialog.viewbinder.MultiEnlargeGuestSelectViewBinder;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/enlarge/dialog/diff/MultiEnlargeSelectGuestDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiEnlargeSelectGuestDiffCallback extends DiffUtil.Callback {
    public final List<MultiEnlargeGuestSelectViewBinder.b> a;
    public final List<MultiEnlargeGuestSelectViewBinder.b> b;

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

    public MultiEnlargeSelectGuestDiffCallback(List<MultiEnlargeGuestSelectViewBinder.b> r2, List<MultiEnlargeGuestSelectViewBinder.b> r3) {
        Intrinsics.checkNotNullParameter(r2, "oldDatas");
        Intrinsics.checkNotNullParameter(r3, "newDatas");
        this.a = r2;
        this.b = r3;
    }

    public final boolean areContentsTheSame(int r2, int r3) {
        MultiEnlargeGuestSelectViewBinder.b r4 = (MultiEnlargeGuestSelectViewBinder.b) ListProtector.get(this.a, r2);
        MultiEnlargeGuestSelectViewBinder.b r5 = (MultiEnlargeGuestSelectViewBinder.b) ListProtector.get(this.b, r3);
        if (r4.a != r5.a) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean areItemsTheSame(int r2, int r3) {
        MultiEnlargeGuestSelectViewBinder.b r4 = (MultiEnlargeGuestSelectViewBinder.b) ListProtector.get(this.a, r2);
        MultiEnlargeGuestSelectViewBinder.b r5 = (MultiEnlargeGuestSelectViewBinder.b) ListProtector.get(this.b, r3);
        String r0 = null;
        if (r4 == null) goto L9;
        ILinkPlayerInfoBridge r6 = r4.b;
        if (r6 == null) goto L9;
        IBaseUser r7 = r6.getUser();
        if (r7 == null) goto L9;
        String r8 = r7.getIdString();
    L10:
        if (r5 == null) goto L17;
        ILinkPlayerInfoBridge r9 = r5.b;
        if (r9 == null) goto L17;
        IBaseUser r10 = r9.getUser();
        if (r10 == null) goto L17;
        r0 = r10.getIdString();
    L17:
        if ((!Intrinsics.areEqual(r8, r0)) == false) goto L20;
        return false;
    L20:
        return true;
    L9:
        r8 = null;
        goto L10
    }

    public final Object getChangePayload(int r2, int r3) {
        MultiEnlargeGuestSelectViewBinder.b r4 = (MultiEnlargeGuestSelectViewBinder.b) ListProtector.get(this.a, r2);
        MultiEnlargeGuestSelectViewBinder.b r5 = (MultiEnlargeGuestSelectViewBinder.b) ListProtector.get(this.b, r3);
        Bundle r0 = new Bundle();
        boolean r6 = r4.a;
        boolean r7 = r5.a;
        if (r6 == r7) goto L5;
        r0.putBoolean("payload_key_guest_selected_state_update", r7);
    L5:
        return r0;
    }
}
