package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.adapter.v3;

import a20.e;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.api.model.InteractEntranceCell;
import com.bytedance.android.live.broadcastgame.api.model.InteractID;
import com.bytedance.android.live.broadcastgame.api.model.r;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import d20.a;
import f10.f;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import z10.b;
import z10.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/adapter/v3/OpenFeatureRecentUsedGroupListAdapterV3;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/adapter/v3/OpenFeatureRecentUseItemViewHolderV3;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenFeatureRecentUsedGroupListAdapterV3 extends RecyclerView.Adapter<OpenFeatureRecentUseItemViewHolderV3> {
    public List<f> a;
    public final e b;

    public final int getItemCount() {
        return this.a.size();
    }

    public OpenFeatureRecentUsedGroupListAdapterV3(List<f> r2, e r3) {
        Intrinsics.checkNotNullParameter(r2, "itemList");
        this.a = r2;
        this.b = r3;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r13, int r14) {
        OpenFeatureRecentUseItemViewHolderV3 r15 = (OpenFeatureRecentUseItemViewHolderV3) r13;
        Intrinsics.checkNotNullParameter(r15, "holder");
        f r16 = (f) ListProtector.get(this.a, r14);
        r15.getClass();
        Intrinsics.checkNotNullParameter(r16, "item");
        TextView r0 = r15.b;
        SimpleDraweeView r1 = r15.a;
        TextView r2 = r15.d;
        View r3 = r15.e;
        View r4 = r15.f;
        View r5 = r15.c;
        View r6 = ((RecyclerView.ViewHolder) r15).itemView;
        e r7 = r15.g;
        int r17 = r15.getAdapterPosition();
        r0.setText(r16.i(true));
        GenericDraweeHierarchy r9 = r1.getHierarchy();
        r1.setActualImageResource(((ExtendedToolbarButton.c) r16).i);
        r9.setPlaceholderImage(((ExtendedToolbarButton.c) r16).i);
        r9.setFailureImage(((ExtendedToolbarButton.c) r16).i);
        r1.setHierarchy(r9);
        if ((!((ExtendedToolbarButton.c) r16).p.isEmpty()) == true) goto L5;
    L10:
        float r11 = 1.0f;
        if (r16.j() == false) goto L13;
        r1.setAlpha(0.64f);
        r0.setAlpha(0.64f);
    L15:
        if (b.a[((ExtendedToolbarButton) r16).f.ordinal()] != 1) goto L18;
        r11 = 0.5f;
    L18:
        r5.setAlpha(r11);
        if (r16.u == false) goto L22;
        UtilityKotlinExtentionsKt.v(r3, true);
        UtilityKotlinExtentionsKt.v(r4, false);
        UtilityKotlinExtentionsKt.v(r2, false);
    L26:
        if (r2.getVisibility() != 0) goto L32;
        String r8 = r16.D.iconLabel;
        if (r2.a(r8) == false) goto L30;
        r2.setText(r8);
        goto L32
    L30:
        UtilityKotlinExtentionsKt.v(r2, false);
    L32:
        if (v.a() == false) goto L37;
        if (r7 != null) goto L46;
    L39:
        r5.setOnClickListener(new c(r7, r16, r6, r17));
        int r18 = a.a;
        r r19 = r16.D.e();
        if (r19 == null) goto L43;
        String r110 = r19.b();
        if (r110 == null) goto L43;
    L44:
        String r12 = r110;
        InteractEntranceCell r111 = r16.D;
        String r21 = r111.title;
        InteractID.a r22 = InteractID.Companion;
        int r112 = r111.interactType;
        r22.getClass();
        InteractID r23 = InteractID.a.b(r112);
        InteractEntranceCell r24 = r16.D;
        a.c(r12, r21, r23, "use_recently", r24.groupType, r24.d, r24);
        return;
    L43:
        r110 = "";
        goto L44
    L46:
        r7.b(r6, r16, r17);     // Catch: Exception -> L36
    L36:
        LocalTestManager.a(new Class[]{wy.a.class});
        ALogger.d("bindIconViewHolder", "\"功能面板bindIconViewHolder 异常 clickCallback?.onIconLoad(itemView, item) \"");
        goto L39
    L37:
        if (r7 == null) goto L39;
        r7.b(r6, r16, r17);
        goto L39
    L22:
        if (r16.v == false) goto L24;
        UtilityKotlinExtentionsKt.v(r4, true);
        UtilityKotlinExtentionsKt.v(r3, false);
        UtilityKotlinExtentionsKt.v(r2, false);
        goto L26
    L24:
        UtilityKotlinExtentionsKt.v(r3, false);
        UtilityKotlinExtentionsKt.v(r4, false);
        UtilityKotlinExtentionsKt.v(r2, true);
        goto L26
    L13:
        r1.setAlpha(1.0f);
        r0.setAlpha(1.0f);
        goto L15
    L5:
        if (((CharSequence) ListProtector.get(((ExtendedToolbarButton.c) r16).p, 0)).length() <= 0) goto L7;
        boolean r25 = true;
    L8:
        if (r25 == false) goto L10;
        r1.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setUri(UriProtector.parse((String) ListProtector.get(((ExtendedToolbarButton.c) r16).p, 0))).build());
        goto L10
    L7:
        r25 = false;
        goto L8
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        return new OpenFeatureRecentUseItemViewHolderV3(LayoutInflater.from(r3.getContext()).inflate(2131567080, r3, false), this.b);
    }
}
