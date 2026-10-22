package i82;

import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.annie.util.p;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.OverScrollRecyclerView;
import com.bytedance.android.livesdk.chatroom.msgboard.VSMsgBoardDress;
import com.bytedance.android.livesdk.chatroom.ui.LiveRoundImageView;
import com.bytedance.android.livesdk.chatroom.ui.t9;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.adapter.CustomSmoothScroller;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.adapter.VSMsgBoardSkinViewHolder;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.ugc.effectplatform.util.r;
import fq1.s;
import fq1.t;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g extends f<VSMsgBoardDress, VSMsgBoardSkinViewHolder> {
    public String c;
    public boolean d;
    public final RecyclerView e;
    public final com.bytedance.android.livesdk.chatroom.msgboard.a f;
    public final k82.a g;
    public final i h;

    public static final class a {
    }

    static {
    }

    public final void b(RecyclerView.ViewHolder r9, Object r10) {
        VSMsgBoardSkinViewHolder r11 = (VSMsgBoardSkinViewHolder) r9;
        VSMsgBoardDress r13 = (VSMsgBoardDress) r10;
        Intrinsics.checkNotNullParameter(r11, "holder");
        Intrinsics.checkNotNullParameter(r13, "itemData");
        View r1 = ((RecyclerView.ViewHolder) r11).itemView;
        Intrinsics.checkNotNullParameter(r1, "view");
        Intrinsics.checkNotNullParameter(r13, "itemData");
        r1.post(new e(this, r13, r1));
        UtilityKotlinExtentionsKt.z(r11.a, !r13.isFree());
        a1.o(r11.b, r13.getDressImage(), ImageView.ScaleType.CENTER_CROP);
        LiveRoundImageView r0 = r11.c;
        s r2 = t.a();
        if (r2 == null) goto L5;
        k r3 = r2.h();
    L6:
        a1.y(r0, r3, 2131253346, n82.c.k("1F161823", -1), p.a.a(1.5f));
        TextView r4 = r11.d;
        String r5 = t.a().i();
        if (r5 != null) goto L9;
        r5 = "昵称";
    L9:
        r4.setText(r5);
        LiveRoundImageView r6 = r11.c;
        boolean r7 = false;
        if (r6 != null) goto L12;
    L16:
        TextView r8 = r11.d;
        if (r8 != null) goto L19;
    L22:
        TextView r14 = r11.e;
        int r15 = r.a;
        if (r.b(r13.getDressName()) == true) goto L25;
        String r16 = r13.getDressName();
    L26:
        r14.setText(r16);
        boolean r17 = String.valueOf(r13.getDressId()).equals(this.c);
        if (r17 == true) goto L29;
    L31:
        UtilityKotlinExtentionsKt.z(r11.f, r17);
        ((RecyclerView.ViewHolder) r11).itemView.setOnTouchListener(new h(this, r17, r13, r11));
        ((RecyclerView.ViewHolder) r11).itemView.getWidth();
        return;
    L29:
        if (this.d == true) goto L31;
        j(10, r11, r13);
        this.d = true;
        goto L31
    L25:
        r16 = "默认";
        goto L26
    L19:
        if (r13.getDressId() <= 0) goto L21;
        r7 = true;
    L21:
        UtilityKotlinExtentionsKt.z(r8, r7);
        goto L22
    L12:
        if (r13.getDressId() <= 0) goto L14;
        boolean r18 = true;
    L15:
        UtilityKotlinExtentionsKt.z(r6, r18);
        goto L16
    L14:
        r18 = false;
        goto L15
    L5:
        r3 = null;
        goto L6
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        int r0 = n82.c.a;
        k82.a r1 = this.g;
        Boolean r2 = null;
        if (r1 == null) goto L7;
        t9 r3 = r1.s();
        if (r3 == null) goto L7;
        DataCenter r6 = r3.l;
    L8:
        k82.a r7 = this.g;
        if (r7 == null) goto L13;
        t9 r8 = r7.s();
        if (r8 == null) goto L13;
        r2 = Boolean.valueOf(r8.p);
    L13:
        String r9 = n82.c.h(r6, r2);
        this.c = r9;
        if (r.b(r9) == false) goto L17;
        this.c = String.valueOf(0);
    L17:
        return new VSMsgBoardSkinViewHolder(r4.inflate(2131567434, r5, false));
    L7:
        r6 = null;
        goto L8
    }

    @Override // i82.f
    public final void i(View r6, VSMsgBoardDress r7) {
        Intrinsics.checkNotNullParameter(r6, "itemView");
        Intrinsics.checkNotNullParameter(r7, "itemData");
        int r8 = l82.a.a;
        int r9 = n82.c.a;
        String r10 = String.valueOf(r7.getDressId());
        k82.a r0 = this.g;
        Map<String, String> r1 = null;
        if (r0 == null) goto L7;
        t9 r2 = r0.s();
        if (r2 == null) goto L7;
        DataCenter r3 = r2.l;
    L8:
        boolean r11 = n82.c.a(r10, r3);
        if (r7.getPaidType() == 1) goto L11;
        boolean r4 = true;
    L12:
        k82.a r5 = this.g;
        if (r5 == null) goto L15;
        r1 = r5.o();
        r1.put("vs_skin_id", String.valueOf(r7.getDressId()));
        Unit r13 = Unit.INSTANCE;
    L15:
        l82.a.d(r11, true, r4, r1);
        return;
    L11:
        r4 = false;
    L7:
        r3 = null;
        goto L8
    }

    public final void j(long r4, VSMsgBoardSkinViewHolder r6, VSMsgBoardDress r7) {
        View r8 = ((RecyclerView.ViewHolder) r6).itemView;
        Rect r0 = new Rect();
        r8.getGlobalVisibleRect(r0);
        RecyclerView r9 = this.e;
        if (r9 == null) goto L5;
        int r10 = r9.getWidth();
    L6:
        RecyclerView r2 = this.e;
        if (r2 == null) goto L9;
        int r3 = r2.getHeight();
    L11:
        if (r0.contains(0, 0, r10, r3) == true) goto L19;
        int r11 = h(r7);
        RecyclerView r13 = this.e;
        if (r13 == null) goto L20;
        RecyclerView.LayoutManager r14 = r13.getLayoutManager();
        if (r14 == null) goto L21;
        CustomSmoothScroller r1 = new CustomSmoothScroller(this.e.getContext());
        r1.a = r4;
        r1.setTargetPosition(r11);
        r14.startSmoothScroll(r1);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L9:
        r3 = 0;
        goto L11
    L5:
        r10 = 0;
        goto L6
    }

    public g(OverScrollRecyclerView r1, com.bytedance.android.livesdk.chatroom.msgboard.a r2, h82.b r3, i r4) {
        this.e = r1;
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.c = BuildConfig.FLAVOR;
    }
}
