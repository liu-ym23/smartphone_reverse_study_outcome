package com.larus.voicecall.impl.scene;

import android.app.Application;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.av_call.constant.ThemeType;
import com.larus.im.bean.bot.SceneModel;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import com.obric.aivoice.core.data.NameKeys;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BG\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\u0018\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u001dH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/larus/voicecall/impl/scene/RealtimeCallSceneAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/voicecall/impl/scene/RealtimeCallSceneHolder;", "themeType", "Lcom/larus/av_call/constant/ThemeType;", "sceneList", NameKeys.UnloadStrategy_No_Strategy, "Lcom/larus/voicecall/impl/scene/SceneDisplayItem;", "itemClick", "Lkotlin/Function1;", NameKeys.UnloadStrategy_No_Strategy, "closeClick", "Lkotlin/Function0;", "isDisplaySingle", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Lcom/larus/av_call/constant/ThemeType;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Z)V", "getThemeType", "()Lcom/larus/av_call/constant/ThemeType;", "getSceneList", "()Ljava/util/List;", "getItemClick", "()Lkotlin/jvm/functions/Function1;", "getCloseClick", "()Lkotlin/jvm/functions/Function0;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", NameKeys.UnloadStrategy_No_Strategy, "getItemCount", "onBindViewHolder", "holder", "position", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeCallSceneAdapter extends RecyclerView.Adapter<RealtimeCallSceneHolder> {
    public final ThemeType a;
    public final List<m> b;
    public final Function1<m, Unit> c;
    public final Function0<Unit> d;
    public final boolean e;

    public final int getItemCount() {
        return this.b.size();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r9, int r10) {
        RealtimeCallSceneHolder r11 = (RealtimeCallSceneHolder) r9;
        Intrinsics.checkNotNullParameter(r11, "holder");
        final m r12 = (m) ListProtector.get(this.b, r10);
        final Function0<Unit> r0 = this.d;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "item");
        Intrinsics.checkNotNullParameter(r0, "closeClick");
        SceneModel r1 = r12.a;
        Application r2 = c4a.f.a;
        View r3 = ((RecyclerView.ViewHolder) r11).itemView;
        ThemeType r4 = r11.a;
        int r5 = r12.b;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "themeType");
        if (r5 == 0) goto L5;
        int r6 = 2131239568;
    L9:
        r3.setBackgroundResource(r6);
        TextView r7 = r11.c;
        ThemeType r8 = r11.a;
        int r13 = r12.b;
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "themeType");
        if (r13 == 0) goto L12;
    L14:
        int r14 = 2131103292;
    L15:
        r7.setTextColor(c4a.f.a(r14));
        TextView r15 = r11.d;
        ThemeType r16 = r11.a;
        int r17 = r12.b;
        Intrinsics.checkNotNullParameter(r15, "<this>");
        Intrinsics.checkNotNullParameter(r16, "themeType");
        if (r17 == 0) goto L18;
    L20:
        String r18 = "#FF666666";
    L21:
        r15.setTextColor(ColorProtector.parseColor(r18));
        int r19 = r12.b;
        if (r19 != 0) goto L24;
        r11.c.setText(r1.getName());
        r11.d.setText(r1.getDesc());
        Application r20 = i88.e.a;
        SimpleDraweeView r21 = r11.e;
        ThemeType r22 = r11.a;
        String r23 = r1.getIconDefault();
        Boolean r24 = r1.getUseOriginalIcon();
        Intrinsics.checkNotNullParameter(r21, "<this>");
        Intrinsics.checkNotNullParameter(r22, "themeType");
        ImageLoaderKt.y(r21, r23, "scene_item", new i88.c(r24, r22), 4);
        r11.g.setVisibility(0);
        r11.g.setOnClickListener(null);
        r11.f.setVisibility(8);
    L31:
        e1.d(((RecyclerView.ViewHolder) r11).itemView, new c(this, r12));
        return;
    L24:
        if (r19 != 1) goto L26;
        r11.c.setText(r1.getName());
        r11.d.setText(r1.getDesc());
        r11.f.setVisibility(0);
        r11.g.setVisibility(8);
        goto L31
    L26:
        if (r19 != 2) goto L31;
        r11.c.setText(r1.getName());
        r11.d.setText(r11.b.getString(2131910492));
        e1.d(r11.g, new i(r0));
        r11.e.setImageResource(2131241912);
        r11.e.setVisibility(0);
        r11.f.setVisibility(8);
        goto L31
    L18:
        if (i88.e.o(r16) == false) goto L20;
        r18 = "#FFCCCCCC";
        goto L21
    L12:
        if (i88.e.o(r8) == false) goto L14;
        r14 = 2131103298;
        goto L15
    L5:
        if (i88.e.o(r4) == false) goto L7;
        r6 = 2131239567;
        goto L9
    L7:
        r6 = 2131239566;
        goto L9
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r12, int r13) {
        Intrinsics.checkNotNullParameter(r12, "parent");
        int r0 = 2131385146;
        if (this.e == false) goto L24;
        ThemeType r8 = this.a;
        ConstraintLayout r14 = LayoutInflater.from(r12.getContext()).inflate(2131562881, r12, false);
        if (((LinearLayout) ViewBindings.findChildViewById(r14, 2131385146)) == null) goto L23;
        if (((TextView) ViewBindings.findChildViewById(r14, 2131385151)) != null) goto L9;
        r0 = 2131385151;
        goto L23
    L9:
        if (ViewBindings.findChildViewById(r14, 2131385152) != null) goto L11;
        r0 = 2131385152;
        goto L23
    L11:
        if (((FrameLayout) ViewBindings.findChildViewById(r14, 2131385153)) != null) goto L13;
        r0 = 2131385153;
        goto L23
    L13:
        if (((ProgressBar) ViewBindings.findChildViewById(r14, 2131385154)) != null) goto L15;
        r0 = 2131385154;
        goto L23
    L15:
        if (((TextView) ViewBindings.findChildViewById(r14, 2131385164)) == null) goto L17;
        RealtimeCallSceneHolder r15 = new RealtimeCallSceneHolder(r8, r14);
    L37:
        return r15;
    L17:
        r0 = 2131385164;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r0)));
    L24:
        ThemeType r9 = this.a;
        ConstraintLayout r16 = LayoutInflater.from(r12.getContext()).inflate(2131562880, r12, false);
        if (((LinearLayout) ViewBindings.findChildViewById(r16, 2131385146)) == null) goto L44;
        if (((TextView) ViewBindings.findChildViewById(r16, 2131385151)) != null) goto L29;
        r0 = 2131385151;
        goto L44
    L29:
        if (ViewBindings.findChildViewById(r16, 2131385152) != null) goto L31;
        r0 = 2131385152;
        goto L44
    L31:
        if (((FrameLayout) ViewBindings.findChildViewById(r16, 2131385153)) != null) goto L33;
        r0 = 2131385153;
        goto L44
    L33:
        if (((ProgressBar) ViewBindings.findChildViewById(r16, 2131385154)) != null) goto L35;
        r0 = 2131385154;
        goto L44
    L35:
        if (((TextView) ViewBindings.findChildViewById(r16, 2131385164)) == null) goto L38;
        r15 = new RealtimeCallSceneHolder(r9, r16);
        goto L37
    L38:
        r0 = 2131385164;
    L44:
        throw new NullPointerException("Missing required view with ID: ".concat(r16.getResources().getResourceName(r0)));
    }

    public RealtimeCallSceneAdapter(ThemeType r2, List r3, d r4, e r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "themeType");
        Intrinsics.checkNotNullParameter(r3, "sceneList");
        Intrinsics.checkNotNullParameter(r4, "itemClick");
        Intrinsics.checkNotNullParameter(r5, "closeClick");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
