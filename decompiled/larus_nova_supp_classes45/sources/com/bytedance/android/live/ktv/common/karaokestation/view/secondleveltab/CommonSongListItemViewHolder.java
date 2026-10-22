package com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab;

import android.graphics.Rect;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.utils.x0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/ktv/common/karaokestation/view/secondleveltab/CommonSongListItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CommonSongListItemViewHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int l = 0;
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public MusicPanel i;
    public final b j;
    public final d k;

    public static final class a {
    }

    public static final class b implements ic0.a {
        public final /* synthetic */ CommonSongListItemViewHolder a;

        public b(CommonSongListItemViewHolder r1) {
            this.a = r1;
        }

        @Override // ic0.a
        public final void a(boolean r7) {
            CommonSongListItemViewHolder r0 = this.a;
            int r1 = CommonSongListItemViewHolder.l;
            r0.U3(r7);
            if (r7 == false) goto L5;
            int r2 = 2131918188;
        L6:
            f2.b(r2, 0);
            MusicPanel r3 = this.a.i;
            if (r3 == null) goto L11;
            KtvMusic r4 = r3.a;
            if (r4 == null) goto L11;
            r4.setFavorite(r7);
        L11:
            if (r7 == false) goto L16;
            CommonSongListItemViewHolder r8 = this.a;
            MusicPanel r5 = r8.i;
            if (r5 == null) goto L17;
            Rect r6 = new Rect();
            int[] r9 = new int[2];
            ((RecyclerView.ViewHolder) r8).itemView.getLocationInWindow(r9);
            View r11 = ((RecyclerView.ViewHolder) r8).itemView;
            r6.left = r9[0] + ((int) r11.findViewById(2131372175).getX());
            r6.top = r9[1] + ((int) r11.findViewById(2131372175).getY());
            r6.right = r6.left + r11.findViewById(2131372175).getWidth();
            r6.bottom = r6.top + r11.findViewById(2131372175).getHeight();
            Intrinsics.checkNotNullParameter(r6, "<set-?>");
            r5.v = r6;
            return;
        L17:
            return;
        L16:
            return;
        L5:
            r2 = 2131918360;
            goto L6
        }
    }

    static {
    }

    public final TextView T3() {
        return (TextView) this.g.getValue();
    }

    public final void U3(boolean r3) {
        View r0 = (View) this.f.getValue();
        if (r0 == null) goto L8;
        if (r3 == false) goto L6;
        int r1 = 2131252151;
    L7:
        r0.setBackgroundResource(r1);
        goto L8
    L6:
        r1 = KtvOrderSongThemeManager.a(103);
    L8:
        KtvUtilsKt.L((View) this.f.getValue(), r3);
        View r2 = (View) this.f.getValue();
        if (r2 == null) goto L15;
        if (r3 == false) goto L12;
        float r4 = 1.0f;
    L13:
        r2.setAlpha(r4);
        return;
    L12:
        r4 = 0.6f;
        goto L13
    }

    public final void V3(boolean r2) {
        if (r2 == false) goto L18;
        TextView r3 = T3();
        if (r3 == null) goto L6;
        r3.setClickable(false);
    L6:
        TextView r4 = T3();
        if (r4 == null) goto L9;
        KtvOrderSongThemeManager.c(r4, OpenPlatformBaseDebugger.ERROR_CODE_APP_ID_NOT_MATCH);
    L9:
        TextView r5 = T3();
        if (r5 == null) goto L12;
        r5.setText(s1.B(2131918626));
    L12:
        TextView r6 = T3();
        if (r6 == null) goto L15;
        r6.setTextColor(s1.h(2131107713));
    L15:
        TextView r7 = T3();
        if (r7 == null) goto L31;
        KtvOrderSongThemeManager.d(r7, 106);
        return;
    L31:
        return;
    L18:
        TextView r8 = T3();
        if (r8 == null) goto L21;
        r8.setClickable(true);
    L21:
        TextView r9 = T3();
        if (r9 == null) goto L24;
        r9.setBackgroundResource(2131249329);
    L24:
        TextView r11 = T3();
        if (r11 == null) goto L27;
        r11.setText(s1.B(2131918625));
    L27:
        TextView r12 = T3();
        if (r12 == null) goto L33;
        r12.setTextColor(s1.h(2131107712));
        return;
    }

    public CommonSongListItemViewHolder(final View r5, d r6) {
        Intrinsics.checkNotNullParameter(r5, "itemView");
        super(r5);
        this.k = r6;
        this.a = LazyKt.lazy(new CommonSongListItemViewHolder$contentContainer$2(r5));
        this.b = LazyKt.lazy(new CommonSongListItemViewHolder$musicCover$2(r5));
        this.c = LazyKt.lazy(new CommonSongListItemViewHolder$musicDuration$2(r5));
        Lazy r7 = LazyKt.lazy(new CommonSongListItemViewHolder$musicName$2(r5));
        this.d = r7;
        Lazy r0 = LazyKt.lazy(new CommonSongListItemViewHolder$musicAuthor$2(r5));
        this.e = r0;
        Lazy r1 = LazyKt.lazy(new CommonSongListItemViewHolder$favorite$2(r5));
        this.f = r1;
        this.g = LazyKt.lazy(new CommonSongListItemViewHolder$selectMusicBtn$2(r5));
        Lazy r8 = LazyKt.lazy(new CommonSongListItemViewHolder$footerView$2(r5));
        this.h = r8;
        TextView r2 = (TextView) r7.getValue();
        if (r2 == null) goto L5;
        KtvOrderSongThemeManager.d(r2, 10);
    L5:
        TextView r3 = (TextView) r0.getValue();
        if (r3 == null) goto L8;
        KtvOrderSongThemeManager.d(r3, 101);
    L8:
        TextView r9 = (TextView) r8.getValue();
        if (r9 == null) goto L11;
        KtvOrderSongThemeManager.d(r9, KtvOrderSongThemeManager.k);
    L11:
        KtvUtilsKt.b((TextView) r7.getValue());
        KtvUtilsKt.b((TextView) r0.getValue());
        View r11 = (View) r1.getValue();
        if (r11 == null) goto L14;
        r11.setOnClickListener(new com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.b(this));
    L14:
        TextView r12 = T3();
        if (r12 == null) goto L17;
        r12.setOnClickListener(x0.a(new CommonSongListItemViewHolder$bindClickListener$2(this)));
    L17:
        this.j = new b(this);
    }
}
