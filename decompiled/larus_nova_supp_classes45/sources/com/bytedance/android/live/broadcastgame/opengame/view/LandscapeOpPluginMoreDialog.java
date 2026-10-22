package com.bytedance.android.live.broadcastgame.opengame.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.t8;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/view/LandscapeOpPluginMoreDialog;", "Lcom/bytedance/android/live/broadcastgame/opengame/view/OPPluginMoreDialog;", "LandSpaceOPMoreDialogAdapter", "a", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeOpPluginMoreDialog extends OPPluginMoreDialog {
    public final PluginContext J;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/view/LandscapeOpPluginMoreDialog$LandSpaceOPMoreDialogAdapter;", "Lcom/bytedance/android/live/broadcastgame/opengame/view/OPMoreDialogAdapter;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class LandSpaceOPMoreDialogAdapter extends OPMoreDialogAdapter {
        public LandSpaceOPMoreDialogAdapter(OPPluginMoreDialog r2, List<n> r3) {
            Intrinsics.checkNotNullParameter(r2, "dialog");
            Intrinsics.checkNotNullParameter(r3, "items");
            super(r2, r3);
        }

        @Override // com.bytedance.android.live.broadcastgame.opengame.view.OPMoreDialogAdapter
        public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
            y2((OPMoreDialogViewHolder) r1, r2);
        }

        @Override // com.bytedance.android.live.broadcastgame.opengame.view.OPMoreDialogAdapter
        public final void y2(OPMoreDialogViewHolder r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "holder");
            super.y2(r4, r5);
            if (((n) ListProtector.get(this.b, r5)).a != 8) goto L5;
            r4.a.setTextColor(ColorProtector.parseColor("#F7B500"));
            r4.b.setColorFilter(ColorProtector.parseColor("#F7B500"));
            r4.b.setBackground(null);
            return;
        L5:
            r4.a.setTextColor(-1);
            r4.b.setColorFilter(-1);
            r4.b.setBackground(null);
        }
    }

    public static final class a extends RecyclerView.ItemDecoration {
        public a() {
        }

        public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
            Intrinsics.checkNotNullParameter(r2, "outRect");
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "parent");
            Intrinsics.checkNotNullParameter(r5, "state");
            r2.top = s1.f(20.0f);
        }
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.view.OPPluginMoreDialog
    public final int getLayoutId() {
        return 2131567108;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.view.OPPluginMoreDialog
    public final void Z0() {
        RecyclerView r0 = findViewById(2131364751);
        if (r0 == null) goto L6;
        OPMoreDialogAdapter r1 = W0(this, OPPluginMoreDialog.Y0(this, false, 1));
        this.C = r1;
        r0.setAdapter(r1);
        r0.setLayoutManager(new GridLayoutManager(r0.getContext(), 4));
        r0.addItemDecoration(new a());
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.broadcastgame.opengame.view.OPPluginMoreDialog
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        Window r3 = getWindow();
        if (r3 == null) goto L5;
        r3.setGravity(5);
    L5:
        Window r4 = getWindow();
        if (r4 == null) goto L10;
        WindowManager.LayoutParams r5 = r4.getAttributes();
        if (r5 == null) goto L10;
        r5.width = s1.f(395.0f);
    L10:
        View r6 = findViewById(2131367728);
        if (r6 == null) goto L17;
        Context r0 = this.J.i();
        if (r0 == null) goto L16;
        a1.k(r6, s1.s((Activity) r0));
        goto L17
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L17:
        t8.d(getWindow());
    }

    public final void onWindowFocusChanged(boolean r7) {
        super/*com.bytedance.android.livesdk.widget.LiveStandardSheetDialog*/.onWindowFocusChanged(r7);
        if (r7 == false) goto L6;
        UtilityKotlinExtentionsKt.s(100, false, false, new AnonymousClass1(this), 6);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.view.OPPluginMoreDialog
    public final OPMoreDialogAdapter W0(OPPluginMoreDialog r2, List<n> r3) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        Intrinsics.checkNotNullParameter(r3, "items");
        return new LandSpaceOPMoreDialogAdapter(r2, r3);
    }

    public LandscapeOpPluginMoreDialog(Context r2, PluginContext r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "pluginContext");
        super(r2, r3, r4, true);
        this.J = r3;
    }
}
