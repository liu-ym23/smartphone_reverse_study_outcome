package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.delegate.v3;

import a20.e;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.base.OpenFeatureIconCallbackFrom;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import f10.f;
import g20.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/viewholder/delegate/v3/OpenFeatureTabListItemDebugModeViewHolder;", "Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/viewholder/delegate/v3/OpenFeatureTabListItemViewHolderV3;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenFeatureTabListItemDebugModeViewHolder extends OpenFeatureTabListItemViewHolderV3 {
    public final TextView n;

    public OpenFeatureTabListItemDebugModeViewHolder(View r2, e r3, OpenFeatureIconCallbackFrom r4) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r4, "callbackFrom");
        super(r2, r3, r4);
        this.n = (TextView) r2.findViewById(2131372180);
    }

    @Override // com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.delegate.v3.OpenFeatureTabListItemViewHolderV3
    public final void U3(TextView r2, HSImageView r3, View r4, LinearLayout r5, View r6, e r7, f r8, int r9) {
        Intrinsics.checkNotNullParameter(r2, "nameView");
        Intrinsics.checkNotNullParameter(r3, "iconView");
        Intrinsics.checkNotNullParameter(r4, "actionView");
        Intrinsics.checkNotNullParameter(r5, "labelLayout");
        Intrinsics.checkNotNullParameter(r6, "itemView");
        Intrinsics.checkNotNullParameter(r8, "item");
        super.U3(r2, r3, r4, r5, r6, r7, r8, r9);
        TextView r11 = this.n;
        if (r11 == null) goto L5;
        r11.setTag("debug_button");
    L5:
        TextView r12 = this.n;
        if (r12 == null) goto L8;
        r12.setOnClickListener(new d(this, r7, r8, r9));
    L8:
        String r13 = r8.D.extra;
        if (r13 != null) goto L49;
    L16:
        String r14 = "调试";
    L18:
        if (r14.length() <= 0) goto L20;
        boolean r15 = true;
    L21:
        if (r15 == false) goto L26;
        TextView r16 = this.n;
        if (r16 == null) goto L26;
        r16.setText(r14);
    L26:
        if (r8.u == false) goto L39;
        TextView r17 = this.n;
        if (r17 == null) goto L30;
        r17.setVisibility(0);
    L30:
        TextView r18 = this.h;
        if (r18 == null) goto L33;
        r18.setAlpha(1.0f);
    L33:
        TextView r19 = this.h;
        if (r19 == null) goto L36;
        r19.setTextColor(s1.h(2131100641));
    L36:
        TextView r21 = this.h;
        if (r21 == null) goto L51;
        r21.setBackground(s1.m(2131250557));
        return;
    L51:
        return;
    L39:
        TextView r22 = this.n;
        if (r22 == null) goto L42;
        r22.setVisibility(8);
    L42:
        TextView r23 = this.h;
        if (r23 == null) goto L45;
        r23.setTextColor(s1.h(2131109391));
    L45:
        TextView r24 = this.h;
        if (r24 == null) goto L53;
        r24.setBackground(s1.m(2131250562));
        return;
    L53:
        return;
    L20:
        r15 = false;
        goto L21
    L49:
        LiveSeiUtil.i.getClass();     // Catch: Exception -> L12
        JSONObject r25 = LiveSeiUtil.c(r13).optJSONObject("debug_button");     // Catch: Exception -> L12
    L13:
        if (r25 == null) goto L16;
        r14 = r25.optString("text");
        if (r14 != null) goto L18;
    L12:
        r25 = null;
        goto L13
    }
}
