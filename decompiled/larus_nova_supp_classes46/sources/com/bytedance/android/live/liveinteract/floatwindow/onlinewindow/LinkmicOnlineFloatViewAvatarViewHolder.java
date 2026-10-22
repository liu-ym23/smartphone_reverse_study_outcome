package com.bytedance.android.live.liveinteract.floatwindow.onlinewindow;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.config.KtvAudioVolumeAnimConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/floatwindow/onlinewindow/LinkmicOnlineFloatViewAvatarViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkmicOnlineFloatViewAvatarViewHolder extends RecyclerView.ViewHolder {
    public final HSImageView a;
    public final HSImageView b;
    public final HSImageView c;
    public ILinkPlayerInfoBridge d;
    public final j22.c e;

    public LinkmicOnlineFloatViewAvatarViewHolder(View r3) {
        Intrinsics.checkNotNullParameter(r3, "itemView");
        super(r3);
        this.a = r3.findViewById(2131372970);
        HSImageView r0 = r3.findViewById(2131372972);
        this.b = r0;
        this.c = r3.findViewById(2131372971);
        this.e = new j22.c(r0);
    }

    public final void T3(boolean r3) {
        ILinkPlayerInfoBridge r0 = this.d;
        if (r0 != null) goto L5;
    L8:
        if (r3 == false) goto L13;
        j22.c r4 = this.e;
        if (r4 == null) goto L12;
        r4.d = true;
    L12:
        this.c.setVisibility(0);
        return;
    L13:
        this.c.setVisibility(4);
        return;
    L5:
        if (je0.d.C(r0) == true) goto L8;
        this.c.setVisibility(4);
    }

    public final void U3(boolean r4) {
        ILinkPlayerInfoBridge r0 = this.d;
        if (r0 == null) goto L8;
        if (je0.d.C(r0) == true) goto L8;
        return;
    L8:
        if (r4 == true) goto L13;
        j22.c r5 = this.e;
        if (r5 == null) goto L33;
        r5.d = true;
        return;
    L33:
        return;
    L13:
        if (this.b.isAnimating() == true) goto L35;
        ILinkPlayerInfoBridge r6 = this.d;
        if (r6 != null) goto L17;
        return;
    L17:
        if (r6.getSilenceStatus() != 0) goto L37;
        int r1 = 0;
        this.b.setVisibility(0);
        KtvAudioVolumeAnimConfig r7 = vm2.d.a0();
        ILinkPlayerInfoBridge r2 = this.d;
        if (r2 == null) goto L23;
        IBaseUser r3 = r2.getUser();
        if (r3 == null) goto L23;
        r1 = r3.getGender();
    L23:
        if (r1 != 1) goto L26;
        String r8 = r7.maleMediaAnim;
    L29:
        j22.c r9 = this.e;
        if (r9 == null) goto L38;
        r9.d(r8);
        return;
    L38:
        return;
    L26:
        if (r1 != 2) goto L28;
        r8 = r7.femaleMediaAnim;
        goto L29
    L28:
        r8 = r7.unkownMediaAnim;
        goto L29
    L37:
        return;
    }
}
