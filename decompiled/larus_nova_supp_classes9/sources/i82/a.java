package i82;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.OverScrollRecyclerView;
import com.bytedance.android.livesdk.chatroom.msgboard.VSMsgBoardDress;
import com.bytedance.android.livesdk.chatroom.ui.t9;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.adapter.CustomSmoothScroller;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.adapter.VSMsgBoardBadgeViewHolder;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends f<VSMsgBoardDress, VSMsgBoardBadgeViewHolder> {
    public String c;
    public boolean d;
    public final d e;
    public final k82.a f;
    public final OverScrollRecyclerView g;

    /* JADX INFO: renamed from: i82.a$a, reason: collision with other inner class name */
    public static final class C0239a {
    }

    static {
    }

    public final void b(RecyclerView.ViewHolder r5, Object r6) {
        VSMsgBoardBadgeViewHolder r7 = (VSMsgBoardBadgeViewHolder) r5;
        VSMsgBoardDress r8 = (VSMsgBoardDress) r6;
        Intrinsics.checkNotNullParameter(r7, "holder");
        Intrinsics.checkNotNullParameter(r8, "itemData");
        if (((me.drakeet.multitype.b) this).a.getItemCount() != 0) goto L5;
        return;
    L5:
        if (r7.getAdapterPosition() == (-1)) goto L19;
        View r1 = ((RecyclerView.ViewHolder) r7).itemView;
        Intrinsics.checkNotNullParameter(r1, "view");
        Intrinsics.checkNotNullParameter(r8, "itemData");
        r1.post(new e(this, r8, r1));
        UtilityKotlinExtentionsKt.z(r7.a, !r8.isFree());
        a1.o(r7.b, r8.getDressImage(), ImageView.ScaleType.CENTER_CROP);
        TextView r0 = r7.c;
        if (TextUtils.isEmpty(r8.getDressName()) == true) goto L10;
        String r2 = r8.getDressName();
    L11:
        r0.setText(r2);
        boolean r3 = String.valueOf(r8.getDressId()).equals(this.c);
        if (r3 == true) goto L14;
    L16:
        UtilityKotlinExtentionsKt.z(r7.d, r3);
        ((RecyclerView.ViewHolder) r7).itemView.setOnTouchListener(new c(this, r3, r8, r7));
        ((RecyclerView.ViewHolder) r7).itemView.getWidth();
        return;
    L14:
        if (this.d == true) goto L16;
        ((RecyclerView.ViewHolder) r7).itemView.post(new b(this, r7, r8));
        this.d = true;
        goto L16
    L10:
        r2 = "默认";
        goto L11
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        int r0 = n82.c.a;
        k82.a r1 = this.f;
        Boolean r2 = null;
        if (r1 == null) goto L7;
        t9 r3 = r1.s();
        if (r3 == null) goto L7;
        DataCenter r6 = r3.l;
    L8:
        k82.a r7 = this.f;
        if (r7 == null) goto L13;
        t9 r8 = r7.s();
        if (r8 == null) goto L13;
        r2 = Boolean.valueOf(r8.p);
    L13:
        String r9 = n82.c.g(r6, r2);
        this.c = r9;
        if (TextUtils.isEmpty(r9) == false) goto L17;
        this.c = String.valueOf(0);
    L17:
        return new VSMsgBoardBadgeViewHolder(r4.inflate(2131567429, r5, false));
    L7:
        r6 = null;
        goto L8
    }

    @Override // i82.f
    public final void i(View r7, VSMsgBoardDress r8) {
        Intrinsics.checkNotNullParameter(r7, "itemView");
        Intrinsics.checkNotNullParameter(r8, "itemData");
        int r9 = l82.a.a;
        int r10 = n82.c.a;
        String r11 = String.valueOf(r8.getDressId());
        k82.a r0 = this.f;
        Map<String, String> r1 = null;
        if (r0 == null) goto L7;
        t9 r2 = r0.s();
        if (r2 == null) goto L7;
        DataCenter r3 = r2.l;
    L8:
        boolean r13 = n82.c.a(r11, r3);
        boolean r4 = true;
        if (r8.getPaidType() != 1) goto L12;
        r4 = false;
    L12:
        k82.a r5 = this.f;
        if (r5 == null) goto L15;
        r1 = r5.o();
        r1.put("vs_medal_id", String.valueOf(r8.getDressId()));
        Unit r14 = Unit.INSTANCE;
    L15:
        l82.a.d(r13, false, r4, r1);
        return;
    L7:
        r3 = null;
        goto L8
    }

    public a(d r2, h82.b r3, OverScrollRecyclerView r4) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.c = BuildConfig.FLAVOR;
    }

    public static final void j(a r3, long r4, VSMsgBoardBadgeViewHolder r6, VSMsgBoardDress r7) {
        if (((me.drakeet.multitype.b) r3).a.getItemCount() != 0) goto L5;
        return;
    L5:
        if (r6.getAdapterPosition() == (-1)) goto L38;
        int r8 = r3.h(r7);
        if (r8 >= 0) goto L10;
        return;
    L10:
        if (r8 >= ((me.drakeet.multitype.b) r3).a.getItemCount()) goto L39;
        View r9 = ((RecyclerView.ViewHolder) r6).itemView;
        Rect r0 = new Rect();
        r9.getGlobalVisibleRect(r0);
        OverScrollRecyclerView r10 = r3.g;
        if (r10 == null) goto L15;
        int r11 = r10.getWidth();
    L16:
        OverScrollRecyclerView r2 = r3.g;
        if (r2 == null) goto L19;
        int r5 = r2.getHeight();
    L21:
        if (r0.contains(0, 0, r11, r5) == true) goto L35;
        OverScrollRecyclerView r13 = r3.g;
        if (r13 == null) goto L36;
        RecyclerView.LayoutManager r14 = r13.getLayoutManager();
        if (r14 == null) goto L40;
        if (r8 >= 0) goto L29;
        return;
    L29:
        if (r8 >= ((me.drakeet.multitype.b) r3).a.getItemCount()) goto L41;
        CustomSmoothScroller r1 = new CustomSmoothScroller(r3.g.getContext());
        r1.a = r4;
        r1.setTargetPosition(r8);
        r14.startSmoothScroll(r1);
        return;
    L41:
        return;
    L40:
        return;
    L36:
        return;
    L35:
        return;
    L19:
        r5 = 0;
        goto L21
    L15:
        r11 = 0;
        goto L16
    L39:
        return;
    }
}
