package com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends me.drakeet.multitype.b<MusicPanel, CommonSongListItemViewHolder> {
    public final d b;

    public a(BaseSecondLevelTabFragment.a r1) {
        this.b = r1;
    }

    public final void b(RecyclerView.ViewHolder r12, Object r13) {
        CommonSongListItemViewHolder r14 = (CommonSongListItemViewHolder) r12;
        MusicPanel r15 = (MusicPanel) r13;
        Intrinsics.checkNotNullParameter(r14, "viewHolder");
        Intrinsics.checkNotNullParameter(r15, "data");
        r14.getClass();
        Intrinsics.checkNotNullParameter(r15, "music");
        MusicPanel r0 = r14.i;
        String r1 = null;
        if (r0 == null) goto L5;
        KtvMusic r2 = r0.a;
    L6:
        boolean r3 = Intrinsics.areEqual(r2, r15.a);
        r14.i = r15;
        if (r3 == false) goto L9;
    L74:
        View r4 = (View) r14.f.getValue();
        if (r4 == null) goto L77;
        r4.setVisibility(0);
    L77:
        r14.U3(r15.a.isFavorite());
        int r5 = r15.b;
        int r16 = r15.s;
        if (r5 == 1) goto L95;
        if (r5 != 2) goto L81;
        TextView r6 = r14.T3();
        if (r6 == null) goto L89;
        KtvOrderSongThemeManager.c(r6, OpenPlatformBaseDebugger.ERROR_CODE_APP_ID_NOT_MATCH);
    L89:
        TextView r7 = r14.T3();
        if (r7 == null) goto L92;
        r7.setTextColor(s1.h(2131107713));
    L92:
        TextView r17 = r14.T3();
        if (r17 == null) goto L100;
        r17.setText(s1.C(2131918371, new Object[]{Integer.valueOf(r16)}));
        return;
    L100:
        return;
    L81:
        if (r5 != 4) goto L83;
    L85:
        r14.V3(true);
        return;
    L83:
        if (r5 == 5) goto L85;
        return;
    L95:
        r14.V3(false);
        return;
    L9:
        if (r15.u == false) goto L19;
        d r18 = r14.k;
        if (r18 == null) goto L13;
        r18.e();
    L13:
        TextView r19 = (TextView) r14.h.getValue();
        if (r19 == null) goto L16;
        r19.setVisibility(0);
    L16:
        ConstraintLayout r110 = (ConstraintLayout) r14.a.getValue();
        if (r110 == null) goto L97;
        r110.setVisibility(8);
        return;
    L97:
        return;
    L19:
        TextView r8 = (TextView) r14.h.getValue();
        if (r8 == null) goto L22;
        r8.setVisibility(8);
    L22:
        ConstraintLayout r9 = (ConstraintLayout) r14.a.getValue();
        if (r9 == null) goto L25;
        r9.setVisibility(0);
    L25:
        TextView r11 = (TextView) r14.d.getValue();
        String r21 = "";
        if (r11 == null) goto L42;
        KtvMusic r22 = r15.a;
        if (r22 == null) goto L33;
        String r23 = r22.getMTitle();
        if (r23 == null) goto L33;
        String r24 = StringsKt.trimStart(r23).toString();
        if (r24 == null) goto L33;
    L34:
        d r25 = r14.k;
        if (r25 == null) goto L37;
        r25.b();
        String r26 = "";
    L38:
        d r27 = r14.k;
        if (r27 == null) goto L41;
        r27.a();
    L41:
        com.bytedance.android.live.ktv.common.util.a.f(r11, r24, r26, 0);
        goto L42
    L37:
        r26 = null;
    L33:
        r24 = "";
    L42:
        TextView r28 = (TextView) r14.e.getValue();
        if (r28 == null) goto L52;
        KtvMusic r29 = r15.a;
        if (r29 == null) goto L51;
        String r31 = r29.getMAuthor();
        if (r31 == null) goto L51;
        String r32 = StringsKt.trimStart(r31).toString();
        if (r32 == null) goto L51;
        r21 = r32;
    L51:
        r28.setText(r21);
    L52:
        TextView r33 = (TextView) r14.e.getValue();
        if (r33 == null) goto L55;
        r33.setVisibility(0);
    L55:
        HSImageView r34 = (HSImageView) r14.b.getValue();
        KtvMusic r35 = r15.a;
        if (r35 == null) goto L58;
        r1 = r35.getCoverUrl();
    L58:
        ImageLoader.bindImage(r34, r1, s1.f(28.0f), s1.f(28.0f));
        KtvMusic r36 = r15.a;
        if (r36 == null) goto L61;
        long r37 = r36.getMDuration();
    L63:
        if (r37 <= 0) goto L71;
        TextView r38 = (TextView) r14.c.getValue();
        if (r38 == null) goto L67;
        r38.setVisibility(0);
    L67:
        KtvMusic.a r39 = KtvMusic.Companion;
        KtvMusic r41 = r15.a;
        r39.getClass();
        long r42 = KtvMusic.a.a(r41);
        TextView r43 = (TextView) r14.c.getValue();
        if (r43 == null) goto L70;
        StringCompanionObject r44 = StringCompanionObject.INSTANCE;
        long r45 = 60;
        r43.setText(String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r42 / r45), Long.valueOf(r42 % r45)}, 2)));
    L70:
        KtvUtilsKt.M((TextView) r14.c.getValue(), r42);
        goto L74
    L71:
        TextView r46 = (TextView) r14.c.getValue();
        if (r46 == null) goto L74;
        r46.setVisibility(8);
        goto L74
    L61:
        r37 = 0;
        goto L63
    L5:
        r2 = null;
        goto L6
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new CommonSongListItemViewHolder(r4.inflate(2131566453, r5, false), this.b);
    }
}
