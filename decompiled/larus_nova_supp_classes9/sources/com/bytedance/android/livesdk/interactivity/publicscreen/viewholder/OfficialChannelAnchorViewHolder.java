package com.bytedance.android.livesdk.interactivity.publicscreen.viewholder;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.message.j3;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.ui.MessageViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import g52.e;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import py.c;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/viewholder/OfficialChannelAnchorViewHolder;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/ui/MessageViewHolder;", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OfficialChannelAnchorViewHolder extends MessageViewHolder {
    public static final /* synthetic */ int b = 0;

    public static final class a {
        @JvmStatic
        public static TextView a(j3 r5, View r6) {
            Intrinsics.checkNotNullParameter(r5, "data");
            Intrinsics.checkNotNullParameter(r6, "itemView");
            SimpleDraweeView r0 = r6.findViewById(2131389468);
            TextView r1 = (TextView) r6.findViewById(2131362588);
            SimpleDraweeView r2 = r6.findViewById(2131363575);
            TextView r7 = (TextView) r6.findViewById(2131367794);
            IBaseUser r3 = r5.getChannelUser();
            String r4 = null;
            if (r3 == null) goto L5;
            k r8 = r3.getAvatarThumbKt();
        L6:
            ImageUtil.loadRoundImage(r0, r8);
            IBaseUser r9 = r5.getChannelUser();
            if (r9 != null) goto L9;
        L17:
            if (r1 == null) goto L22;
            IBaseUser r10 = r5.getChannelUser();
            if (r10 == null) goto L21;
            r4 = r10.getNickName();
        L21:
            r1.setText(r4);
        L22:
            if (r7 == null) goto L24;
            r7.setText(s1.C(2131920773, new Object[]{60}));
        L24:
            return r7;
        L9:
            if (r9.isEnterpriseVerify() != true) goto L17;
            IBaseUser r11 = r5.getChannelUser();
            if (r11 == null) goto L15;
            c r13 = r11.getMAuthenticationInfo();
            if (r13 == null) goto L15;
            k r14 = r13.getAuthenticationBadge();
        L16:
            ImageUtil.loadRoundImage(r2, r14);
        L15:
            r14 = null;
            goto L16
        L5:
            r8 = null;
            goto L6
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.ui.MessageViewHolder
    public final void U3(f<?> r1, int r2, e r3) {
        j3 r4 = null;
        if (r1 == null) goto L5;
        j3 r5 = r1.b;
    L7:
        if ((r5 instanceof j3) == false) goto L10;
        r4 = r5;
    L10:
        j3 r6 = r4;
        if (r6 == null) goto L14;
        a.a(r6, ((RecyclerView.ViewHolder) this).itemView);
        return;
    L14:
        return;
    L5:
        r5 = null;
        goto L7
    }
}
