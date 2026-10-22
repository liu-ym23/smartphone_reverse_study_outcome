package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder;

import a20.e;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.config.qa;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import e20.d;
import f10.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import va1.b;
import wy.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/viewholder/OpenFeatureGroupListItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenFeatureGroupListItemViewHolder extends RecyclerView.ViewHolder {
    public final HSImageView a;
    public final TextView b;
    public final View c;
    public final View d;
    public final View e;
    public final View f;
    public final e g;

    public final void T3(f r15) {
        Intrinsics.checkNotNullParameter(r15, "item");
        ViewGroup.LayoutParams r1 = this.a.getLayoutParams();
        if (((ExtendedToolbarButton.c) r15).j != 1) goto L11;
        r1.width = UtilityKotlinExtentionsKt.i(32);
        r1.height = UtilityKotlinExtentionsKt.i(32);
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == true) goto L7;
        ViewGroup.LayoutParams r2 = null;
    L9:
        if (((ViewGroup.MarginLayoutParams) r2) == null) goto L12;
        ((ViewGroup.MarginLayoutParams) r1).topMargin = UtilityKotlinExtentionsKt.i(4);
    L12:
        this.a.setLayoutParams(r1);
        TextView r3 = this.b;
        SimpleDraweeView r4 = this.a;
        View r5 = this.c;
        View r6 = this.e;
        View r7 = this.f;
        View r8 = this.d;
        View r9 = ((RecyclerView.ViewHolder) this).itemView;
        e r11 = this.g;
        int r12 = getAdapterPosition();
        Intrinsics.checkNotNullParameter(r3, "nameView");
        Intrinsics.checkNotNullParameter(r4, "iconView");
        Intrinsics.checkNotNullParameter(r5, "redDotView");
        Intrinsics.checkNotNullParameter(r6, "doingAreaView");
        Intrinsics.checkNotNullParameter(r7, "boundAreaView");
        Intrinsics.checkNotNullParameter(r8, "actionView");
        Intrinsics.checkNotNullParameter(r9, "itemView");
        Intrinsics.checkNotNullParameter(r15, "item");
        r3.setText(r15.i(true));
        GenericDraweeHierarchy r13 = r4.getHierarchy();
        r4.setActualImageResource(((ExtendedToolbarButton.c) r15).i);
        r13.setPlaceholderImage(((ExtendedToolbarButton.c) r15).i);
        r13.setFailureImage(((ExtendedToolbarButton.c) r15).i);
        r4.setHierarchy(r13);
        if ((!((ExtendedToolbarButton.c) r15).p.isEmpty()) == true) goto L15;
    L20:
        float r14 = 1.0f;
        if (r15.j() == false) goto L23;
        r4.setAlpha(0.64f);
        r3.setAlpha(0.64f);
        r5.setAlpha(0.0f);
    L25:
        if (d.a[((ExtendedToolbarButton) r15).f.ordinal()] != 1) goto L28;
        r14 = 0.5f;
    L28:
        r8.setAlpha(r14);
        if (r15.u == false) goto L32;
        UtilityKotlinExtentionsKt.v(r6, true);
        UtilityKotlinExtentionsKt.v(r5, false);
        UtilityKotlinExtentionsKt.v(r7, false);
    L51:
        if (v.a() == false) goto L56;
        if (r11 != null) goto L60;
    L58:
        r8.setOnClickListener(new e20.e(r11, r9, r15, r12));
        return;
    L60:
        r11.b(r9, r15, r12);     // Catch: Exception -> L55
    L55:
        LocalTestManager.a(new Class[]{a.class});
        ALogger.d("bindIconViewHolder", "\"功能面板bindIconViewHolder 异常 clickCallback?.onIconLoad(itemView, item) \"");
        goto L58
    L56:
        if (r11 == null) goto L58;
        r11.b(r9, r15, r12);
        goto L58
    L32:
        if (r15.v == false) goto L35;
        UtilityKotlinExtentionsKt.v(r7, true);
        UtilityKotlinExtentionsKt.v(r6, false);
        UtilityKotlinExtentionsKt.v(r5, false);
        goto L51
    L35:
        if (r15.k() == false) goto L49;
        UtilityKotlinExtentionsKt.v(r5, true);
        UtilityKotlinExtentionsKt.v(r6, false);
        UtilityKotlinExtentionsKt.v(r7, false);
        String r16 = r15.h();
        if (r16 == null) goto L51;
        if (r16.length() <= 0) goto L41;
        boolean r17 = true;
    L42:
        if (r17 == true) goto L45;
        r16 = null;
    L45:
        if (r16 == null) goto L51;
        ((IBroadcastService) b.a.a.a(IBroadcastService.class)).getBroadcastDotManager();
        throw null;
    L41:
        r17 = false;
        goto L42
    L49:
        UtilityKotlinExtentionsKt.v(r6, false);
        UtilityKotlinExtentionsKt.v(r5, false);
        UtilityKotlinExtentionsKt.v(r7, false);
        goto L51
    L23:
        r4.setAlpha(1.0f);
        r3.setAlpha(1.0f);
        r5.setAlpha(1.0f);
        goto L25
    L15:
        if (((CharSequence) ListProtector.get(((ExtendedToolbarButton.c) r15).p, 0)).length() <= 0) goto L17;
        boolean r18 = true;
    L18:
        if (r18 == false) goto L20;
        r4.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setUri(UriProtector.parse((String) ListProtector.get(((ExtendedToolbarButton.c) r15).p, 0))).build());
        goto L20
    L17:
        r18 = false;
        goto L18
    L7:
        r2 = r1;
        goto L9
    L11:
        r1.height = UtilityKotlinExtentionsKt.i(44);
        r1.width = UtilityKotlinExtentionsKt.i(44);
        goto L12
    }

    public OpenFeatureGroupListItemViewHolder(View r2, e r3) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.g = r3;
        this.a = (HSImageView) r2.findViewById(2131374718);
        TextView r4 = (TextView) r2.findViewById(2131380593);
        this.b = r4;
        this.c = r2.findViewById(2131384095);
        this.d = r2.findViewById(2131362039);
        this.e = r2.findViewById(2131369392);
        this.f = r2.findViewById(2131364174);
        if (Intrinsics.areEqual(qa.a.getValue(), Boolean.TRUE) == false) goto L6;
        ViewCompat.setAccessibilityDelegate(r4, new AnonymousClass1());
        return;
    }
}
