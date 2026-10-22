package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder;

import a20.e;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import e20.g;
import f10.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import va1.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/viewholder/OpenFeatureTabListItemViewHolder;", "Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/viewholder/AbsOpenFeatureTabListItemViewHolder;", "Lf10/f;", "a", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenFeatureTabListItemViewHolder extends AbsOpenFeatureTabListItemViewHolder<f> {
    public final TextView a;
    public final TextView b;
    public final HSImageView c;
    public final View d;
    public final View e;
    public final View f;
    public final View g;
    public final e h;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.AbsOpenFeatureTabListItemViewHolder
    public final void T3(f r14) {
        f r15 = r14;
        Intrinsics.checkNotNullParameter(r15, "item");
        TextView r0 = this.b;
        if (r0 == null) goto L5;
        r0.setText(r15.C);
    L5:
        TextView r1 = this.a;
        SimpleDraweeView r2 = this.c;
        View r3 = this.d;
        View r4 = this.f;
        View r5 = this.g;
        View r6 = this.e;
        View r7 = ((RecyclerView.ViewHolder) this).itemView;
        e r8 = this.h;
        int r9 = getAdapterPosition();
        r1.setText(r15.i(false));
        GenericDraweeHierarchy r11 = r2.getHierarchy();
        r2.setActualImageResource(((ExtendedToolbarButton.c) r15).i);
        r11.setPlaceholderImage(((ExtendedToolbarButton.c) r15).i);
        r11.setFailureImage(((ExtendedToolbarButton.c) r15).i);
        r2.setHierarchy(r11);
        if ((!((ExtendedToolbarButton.c) r15).p.isEmpty()) == true) goto L8;
    L13:
        float r12 = 1.0f;
        if (r15.j() == false) goto L16;
        r2.setAlpha(0.64f);
        r1.setAlpha(0.64f);
        r3.setAlpha(0.0f);
    L18:
        if (e20.f.a[((ExtendedToolbarButton) r15).f.ordinal()] != 1) goto L21;
        r12 = 0.5f;
    L21:
        r6.setAlpha(r12);
        if (r15.u == false) goto L25;
        UtilityKotlinExtentionsKt.v(r4, true);
        UtilityKotlinExtentionsKt.v(r3, false);
        UtilityKotlinExtentionsKt.v(r5, false);
    L45:
        if (v.a() == false) goto L50;
        if (r8 != null) goto L54;
    L52:
        r6.setOnClickListener(new g(r8, r7, r15, r9));
        return;
    L54:
        r8.b(r7, r15, r9);     // Catch: Exception -> L49
    L49:
        LocalTestManager.a(new Class[]{wy.a.class});
        ALogger.d("bindIconViewHolder", "\"功能面板bindIconViewHolder 异常 clickCallback?.onIconLoad(itemView, item) \"");
        goto L52
    L50:
        if (r8 == null) goto L52;
        r8.b(r7, r15, r9);
        goto L52
    L25:
        if (r15.v == false) goto L28;
        UtilityKotlinExtentionsKt.v(r5, true);
        UtilityKotlinExtentionsKt.v(r4, false);
        UtilityKotlinExtentionsKt.v(r3, false);
        goto L45
    L28:
        if (r15.k() == false) goto L43;
        UtilityKotlinExtentionsKt.v(r3, true);
        UtilityKotlinExtentionsKt.v(r4, false);
        UtilityKotlinExtentionsKt.v(r5, false);
        String r13 = r15.h();
        if (r13 == null) goto L45;
        if (r13.length() <= 0) goto L34;
        boolean r16 = true;
    L36:
        if (r16 == true) goto L39;
        r13 = null;
    L39:
        if (r13 == null) goto L45;
        ((IBroadcastService) b.a.a.a(IBroadcastService.class)).getBroadcastDotManager();
        throw null;
    L34:
        r16 = false;
        goto L36
    L43:
        UtilityKotlinExtentionsKt.v(r4, false);
        UtilityKotlinExtentionsKt.v(r3, false);
        UtilityKotlinExtentionsKt.v(r5, false);
        goto L45
    L16:
        r2.setAlpha(1.0f);
        r1.setAlpha(1.0f);
        r3.setAlpha(1.0f);
        goto L18
    L8:
        if (((CharSequence) ListProtector.get(((ExtendedToolbarButton.c) r15).p, 0)).length() <= 0) goto L10;
        boolean r17 = true;
    L11:
        if (r17 == false) goto L13;
        r2.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setUri(UriProtector.parse((String) ListProtector.get(((ExtendedToolbarButton.c) r15).p, 0))).build());
        goto L13
    L10:
        r17 = false;
        goto L11
    }

    public OpenFeatureTabListItemViewHolder(View r2, e r3) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.h = r3;
        this.a = (TextView) r2.findViewById(2131391745);
        this.b = (TextView) r2.findViewById(2131391746);
        this.c = (HSImageView) r2.findViewById(2131374757);
        this.d = r2.findViewById(2131384095);
        this.e = r2.findViewById(2131362039);
        this.f = r2.findViewById(2131369392);
        this.g = r2.findViewById(2131364174);
    }
}
