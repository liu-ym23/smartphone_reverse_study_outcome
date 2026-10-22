package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.android.livesdk.chatroom.ui.RedDotView;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.RedDotHelper;
import com.bytedance.android.livesdk.config.xe1;
import com.bytedance.android.livesdk.reddot.RedDotDelegate;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/LandscapeTopMoreAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/LandscapeTopMoreHolder;", "Lcom/bytedance/android/livesdk/utils/z1;", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeTopMoreAdapter extends RecyclerView.Adapter<LandscapeTopMoreHolder> implements com.bytedance.android.livesdk.utils.z1 {
    public boolean a;
    public final TreeSet<RedDotDelegate> b;
    public final x3 c;
    public int d;
    public int e;
    public boolean f;
    public final Context g;
    public final DataCenter h;
    public List<? extends ExtendedToolbarButton> i;
    public final int j;
    public final Function1<ExtendedToolbarButton, Unit> k;
    public final /* synthetic */ com.bytedance.android.livesdk.utils.z1 l;

    public static final class a {
    }

    static {
    }

    public final void V1(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
        this.l.V1(r2);
    }

    public final int getItemCount() {
        return this.i.size();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r7, int r8) {
        LandscapeTopMoreHolder r9 = (LandscapeTopMoreHolder) r7;
        Intrinsics.checkNotNullParameter(r9, "holder");
        final ExtendedToolbarButton r10 = (ExtendedToolbarButton) ListProtector.get(this.i, r8);
        boolean r0 = b4.c.a.d(r10, this.c);
        View r1 = (View) ((HashMap) this.c.c).get(r10);
        if (r1 == null) goto L5;
        this.c.C(r10, r1);
    L5:
        Map<ExtendedToolbarButton, View> r2 = this.c.c;
        HashMap r3 = (HashMap) r2;
        r3.put(r10, ((RecyclerView.ViewHolder) r9).itemView);
        if (c4.a(this.a) == false) goto L12;
        RedDotDelegate r4 = r10.c;
        if (r4 == null) goto L12;
        Intrinsics.checkNotNullParameter(r4, "dotDelegate");
        Object r5 = r9.b;
        if ((r5 instanceof RedDotView) == false) goto L12;
        int r6 = RedDotView.d;
        ((RedDotView) r5).n(r4, null);
    L12:
        Intrinsics.checkNotNullParameter(r10, "button");
        TextView r11 = r9.a;
        r10.getClass();
        boolean r12 = r10 instanceof ExtendedToolbarButton.b;
        if (r12 == false) goto L20;
        IMiddlewareHostApp r13 = jc1.k.f(IMiddlewareHostApp.class);
        if (r13 == null) goto L18;
        String r14 = r13.replaceBrand(((ExtendedToolbarButton.b) r10).i.getTitleId());
        if (r14 == null) goto L18;
    L22:
        r11.setText(r14);
        int r15 = 8;
        if (xe1.a.getValue().booleanValue() == false) goto L32;
        Object r16 = r9.b;
        if ((r16 instanceof RedDotView) == false) goto L32;
        if (((RedDotView) r16).getRedDot() == null) goto L32;
        UtilityKotlinExtentionsKt.t(r9.b);
        RedDotView r17 = (RedDotView) r9.b;
        if (r17.j() == false) goto L31;
        r15 = 0;
    L31:
        r17.setVisibility(r15);
    L36:
        if (r12 == false) goto L39;
        r9.c.setBackgroundResource(((ExtendedToolbarButton.b) r10).i.getDrawableFolded());
    L61:
        this.c.D(r10, ((RecyclerView.ViewHolder) r9).itemView);
        Function1<View, Unit> r18 = new AnonymousClass3(this, r10);
        Intrinsics.checkNotNullParameter(r18, "onClickButton");
        ((RecyclerView.ViewHolder) r9).itemView.setOnClickListener(new e0(r18));
        return;
    L39:
        if ((r10 instanceof ExtendedToolbarButton.c) == false) goto L61;
        ExtendedToolbarButton.c r19 = (ExtendedToolbarButton.c) r10;
        r9.c.setBackgroundResource(r19.i);
        if (r19.p.isEmpty() == true) goto L44;
        r9.f.V1(com.bytedance.android.livesdk.utils.g3.a((String) ListProtector.get(r19.p, 0)).toMaybe().observeOn(AndroidSchedulers.mainThread()).subscribe(new f0(r9), g0.a));
    L44:
        String r20 = r19.l;
        if (r20.length() != 0) goto L47;
        boolean r21 = true;
    L48:
        if (r21 == false) goto L52;
        TextView r22 = r9.d;
        if (r22 == null) goto L61;
        UtilityKotlinExtentionsKt.t(r22);
        goto L61
    L52:
        TextView r23 = r9.d;
        if (r23 == null) goto L56;
        UtilityKotlinExtentionsKt.w(r23);
    L56:
        if (r20.length() <= 4) goto L58;
        r20 = r20.substring(0, 4);
    L58:
        TextView r24 = r9.d;
        if (r24 == null) goto L61;
        r24.setText(r20);
        goto L61
    L47:
        r21 = false;
    L32:
        ImageView r25 = r9.b;
        if (r0 == false) goto L35;
        r15 = 0;
    L35:
        r25.setVisibility(r15);
    L18:
        r14 = com.bytedance.android.live.core.utils.s1.B(((ExtendedToolbarButton.b) r10).i.getTitleId());
        goto L22
    L20:
        if ((r10 instanceof ExtendedToolbarButton.c) == false) goto L64;
        r14 = ((ExtendedToolbarButton.c) r10).q;
        goto L22
    L64:
        throw new NoWhenBranchMatchedException();
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        int r6 = this.j;
        if (r6 != 0) goto L6;
        r6 = 2131567736;
    L6:
        LandscapeTopMoreHolder r0 = new LandscapeTopMoreHolder(LayoutInflater.from(this.g).inflate(r6, r4, false), this.g, this);
        if (this.f == false) goto L14;
        int r7 = this.d;
        int r8 = this.e;
        ViewGroup.LayoutParams r1 = r0.c.getLayoutParams();
        r1.width = UtilityKotlinExtentionsKt.i(r7);
        r1.height = UtilityKotlinExtentionsKt.i(r8);
        r0.c.setLayoutParams(r1);
        TextView r9 = r0.d;
        if (r9 == null) goto L11;
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
    L12:
        if (r10 == null) goto L14;
        r10.width = UtilityKotlinExtentionsKt.i(r7);
        goto L14
    L11:
        r10 = null;
    L14:
        return r0;
    }

    public /* synthetic */ LandscapeTopMoreAdapter(Context r9, DataCenter r10, List r11, int r12, int r13, Function1 r14) {
        this(r9, r10, r11, r12, r13, new com.bytedance.android.livesdk.utils.m1(), r14);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LandscapeTopMoreAdapter(Context r2, DataCenter r3, List<? extends ExtendedToolbarButton> r4, int r5, int r6, com.bytedance.android.livesdk.utils.z1 r7, Function1<? super ExtendedToolbarButton, Unit> r8) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "buttonList");
        Intrinsics.checkNotNullParameter(r7, "disposer");
        Intrinsics.checkNotNullParameter(r8, "onClickListener");
        this.l = r7;
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.j = r6;
        this.k = r8;
        this.a = true;
        TreeSet<RedDotDelegate> r9 = new TreeSet();
        this.b = r9;
        if (r5 == 1) goto L9;
        c0 r10 = y3.i(r3);
        if (r10 == null) goto L8;
        x3 r11 = (x3) r10;
    L11:
        this.c = r11;
        this.d = 38;
        this.e = 38;
        if (c4.a(this.a) == false) goto L17;
        r9.clear();
        RedDotHelper.b(this.i, this.c, this.b);
        return;
    L17:
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarManager");
    L9:
        r11 = y3.f(r3);
        if (r11 != null) goto L11;
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarManager");
    }
}
