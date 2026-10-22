package g20;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.api.model.InteractID;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.base.OpenFeatureIconCallbackFrom;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.AbsOpenFeatureTabListItemViewHolder;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.delegate.v3.OpenFeatureTabListItemDebugModeViewHolder;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.config.f30;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c extends f20.g<f10.f, OpenFeatureTabListItemDebugModeViewHolder> {
    public final a20.e a;
    public final OpenFeatureIconCallbackFrom b;
    public final Function1<f10.f, Unit> c;

    @Override // f20.c
    public final boolean accept(Object r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        if (((Boolean) f30.a.getValue()).booleanValue() == true) goto L5;
    L17:
        return false;
    L5:
        if ((r3 instanceof f10.f) == false) goto L17;
        f10.f r4 = (f10.f) r3;
        if (((ExtendedToolbarButton.c) r4).k != InteractID.InteractLoki.getValue()) goto L17;
        String r5 = r4.D.i().extra;
        LiveSeiUtil.i.getClass();     // Catch: Exception -> L11
        Integer r6 = Integer.valueOf(LiveSeiUtil.c(r5).optInt("version_type"));     // Catch: Exception -> L11
    L12:
        if (r6 == null) goto L17;
        if (r6.intValue() != 1) goto L17;
        return true;
    L11:
        r6 = null;
        goto L12
    }

    public c(a20.e r2, OpenFeatureIconCallbackFrom r3) {
        Intrinsics.checkNotNullParameter(r3, "callbackFrom");
        this.a = r2;
        this.b = r3;
        this.c = null;
    }

    @Override // f20.a
    public final RecyclerView.ViewHolder a(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new OpenFeatureTabListItemDebugModeViewHolder(r3.inflate(2131567068, r4, false), this.a, this.b);
    }

    @Override // f20.g
    public final void b(AbsOpenFeatureTabListItemViewHolder r2, f10.f r3) {
        OpenFeatureTabListItemDebugModeViewHolder r4 = (OpenFeatureTabListItemDebugModeViewHolder) r2;
        f10.f r5 = r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r5, "data");
        super.b(r4, r5);
        Function1<f10.f, Unit> r6 = this.c;
        if (r6 == null) goto L6;
        Unit r7 = (Unit) r6.invoke(r5);
        return;
    }

    @Override // f20.g, f20.a
    public final void d(RecyclerView.ViewHolder r2, Object r3) {
        OpenFeatureTabListItemDebugModeViewHolder r4 = (OpenFeatureTabListItemDebugModeViewHolder) r2;
        f10.f r5 = (f10.f) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r5, "data");
        super.b(r4, r5);
        Function1<f10.f, Unit> r6 = this.c;
        if (r6 == null) goto L6;
        Unit r7 = (Unit) r6.invoke(r5);
        return;
    }
}
