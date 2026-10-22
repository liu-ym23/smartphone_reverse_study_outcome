package z10;

import a20.e;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.delegate.v3.OpenFeatureFunctionItemViewHolderV3;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import f10.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends me.drakeet.multitype.b<f, OpenFeatureFunctionItemViewHolderV3> {
    public final e b;

    public a(a20.d r1) {
        this.b = r1;
    }

    public final void b(RecyclerView.ViewHolder r7, Object r8) {
        OpenFeatureFunctionItemViewHolderV3 r9 = (OpenFeatureFunctionItemViewHolderV3) r7;
        f r11 = (f) r8;
        Intrinsics.checkNotNullParameter(r9, "holder");
        Intrinsics.checkNotNullParameter(r11, "item");
        r9.getClass();
        Intrinsics.checkNotNullParameter(r11, "item");
        r9.b.setText(r11.i(true));
        GenericDraweeHierarchy r0 = r9.a.getHierarchy();
        r0.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE);
        r9.a.setActualImageResource(((ExtendedToolbarButton.c) r11).i);
        r0.setPlaceholderImage(((ExtendedToolbarButton.c) r11).i);
        r0.setFailureImage(((ExtendedToolbarButton.c) r11).i);
        r9.a.setHierarchy(r0);
        if ((!((ExtendedToolbarButton.c) r11).p.isEmpty()) == true) goto L5;
    L10:
        float r3 = 1.0f;
        if (r11.j() == false) goto L13;
        r9.a.setAlpha(0.64f);
        r9.b.setAlpha(0.64f);
        r9.c.setAlpha(0.0f);
    L14:
        View r1 = r9.d;
        if (g20.a.a[((ExtendedToolbarButton) r11).f.ordinal()] != 1) goto L18;
        r3 = 0.5f;
    L18:
        r1.setAlpha(r3);
        if (r11.k() == false) goto L34;
        UtilityKotlinExtentionsKt.v(r9.c, true);
        String r2 = r11.h();
        if (r2 == null) goto L36;
        if (r2.length() <= 0) goto L25;
        boolean r4 = true;
    L27:
        if (r4 == true) goto L30;
        r2 = null;
    L30:
        if (r2 == null) goto L36;
        ((IBroadcastService) va1.b.a.a.a(IBroadcastService.class)).getBroadcastDotManager();
        throw null;
    L25:
        r4 = false;
    L36:
        if (v.a() == true) goto L47;
        e r5 = r9.e;
        if (r5 == null) goto L45;
        r5.b(((RecyclerView.ViewHolder) r9).itemView, r11, r9.getPosition());
    L45:
        r9.d.setOnClickListener(new g20.b(r9, r11));
        return;
    L47:
        e r6 = r9.e;     // Catch: Exception -> L41
        if (r6 == null) goto L45;
        r6.b(((RecyclerView.ViewHolder) r9).itemView, r11, r9.getPosition());     // Catch: Exception -> L41
    L41:
        LocalTestManager.a(new Class[]{wy.a.class});
        ALogger.d("bindIconViewHolder", "\"功能面板bindIconViewHolder 异常 clickCallback?.onIconLoad(itemView, item) \"");
        goto L45
    L34:
        UtilityKotlinExtentionsKt.v(r9.c, false);
        goto L36
    L13:
        r9.a.setAlpha(1.0f);
        r9.b.setAlpha(1.0f);
        r9.c.setAlpha(1.0f);
        goto L14
    L5:
        if (((CharSequence) ListProtector.get(((ExtendedToolbarButton.c) r11).p, 0)).length() <= 0) goto L7;
        boolean r12 = true;
    L8:
        if (r12 == false) goto L10;
        r9.a.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setUri(UriProtector.parse((String) ListProtector.get(((ExtendedToolbarButton.c) r11).p, 0))).build());
        goto L10
    L7:
        r12 = false;
        goto L8
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new OpenFeatureFunctionItemViewHolderV3(r3.inflate(2131567079, r4, false), this.b);
    }
}
