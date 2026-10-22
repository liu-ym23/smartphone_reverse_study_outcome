package com.bytedance.android.live.liveinteract.floatwindow.onlinewindow;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/floatwindow/onlinewindow/LinkmicOnlineFloatViewAvatarAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkmicOnlineFloatViewAvatarAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public boolean a;
    public final Context b;
    public List<? extends ILinkPlayerInfoBridge> c;

    public static final class a {
    }

    static {
    }

    public final int getItemCount() {
        if (this.c.size() <= 4) goto L6;
        return 4;
    L6:
        return this.c.size();
    }

    public final int getItemViewType(int r4) {
        if (this.c.size() == 4) goto L5;
    L10:
        return 0;
    L5:
        if (this.a == false) goto L10;
        if (r4 != 2) goto L10;
        return 1;
    }

    public LinkmicOnlineFloatViewAvatarAdapter(Context r2, List<? extends ILinkPlayerInfoBridge> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "onlineUserList");
        this.b = r2;
        this.c = r3;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "viewHolder");
        ILinkPlayerInfoBridge r5 = (ILinkPlayerInfoBridge) ListProtector.get(this.c, r4);
        if ((r3 instanceof LinkmicOnlineFloatViewAvatarViewHolder) == false) goto L17;
        LinkmicOnlineFloatViewAvatarViewHolder r6 = (LinkmicOnlineFloatViewAvatarViewHolder) r3;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r5, "playerInfo");
        r6.d = r5;
        HSImageView r0 = r6.a;
        IBaseUser r7 = r5.getUser();
        Intrinsics.checkNotNull(r7);
        ImageUtil.loadRoundImage(r0, r7.getAvatarThumbKt());
        ILinkPlayerInfoBridge r8 = r6.d;
        boolean r1 = false;
        if (r8 != null) goto L7;
    L9:
        boolean r9 = false;
    L10:
        r6.U3(r9);
        ILinkPlayerInfoBridge r10 = r6.d;
        if (r10 != null) goto L13;
    L14:
        r1 = true;
    L15:
        r6.T3(r1);
        return;
    L13:
        if (r10.getSilenceStatus() == 0) goto L15;
    L7:
        if (n.h(r8) != true) goto L9;
        r9 = true;
        goto L10
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        if (r4 == 1) goto L7;
        return new LinkmicOnlineFloatViewAvatarViewHolder(LayoutInflater.from(this.b).inflate(2131566317, r3, false));
    L7:
        return new LinkmicMoreFloatViewAvatarViewHolder(LayoutInflater.from(this.b).inflate(2131566318, r3, false));
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7, List<Object> r8) {
        Intrinsics.checkNotNullParameter(r6, "holder");
        Intrinsics.checkNotNullParameter(r8, "payloads");
        if (r8.size() != 0) goto L7;
        onBindViewHolder(r6, r7);
        return;
    L7:
        if ((r6 instanceof LinkmicOnlineFloatViewAvatarViewHolder) == false) goto L35;
        Object r9 = ListProtector.get(r8, r8.size() - 1);
        if (r9 == null) goto L34;
        Bundle r10 = (Bundle) r9;
        Iterator<String> r11 = r10.keySet().iterator();
    L12:
        if (r11.hasNext() == false) goto L50;
        String r1 = r11.next();
        if (r1 == null) goto L12;
        int r2 = r1.hashCode();
        boolean r4 = false;
        if (r2 != (-2086201856)) goto L19;
        if (r1.equals("payload_key_talk_state_change") == false) goto L12;
        LinkmicOnlineFloatViewAvatarViewHolder r3 = (LinkmicOnlineFloatViewAvatarViewHolder) r6;
        if (r10.getInt("payload_key_talk_state_change") <= 0) goto L32;
        r4 = true;
    L32:
        r3.U3(r4);
        goto L12
    L19:
        if (r2 != 1913647539) goto L12;
        if (r1.equals("payload_key_mute_state_change") == false) goto L12;
        LinkmicOnlineFloatViewAvatarViewHolder r5 = (LinkmicOnlineFloatViewAvatarViewHolder) r6;
        if (r10.getInt("payload_key_mute_state_change") <= 0) goto L26;
        r4 = true;
    L26:
        r5.T3(r4);
        goto L12
    L50:
        return;
    L34:
        throw new NullPointerException("null cannot be cast to non-null type android.os.Bundle");
    }
}
