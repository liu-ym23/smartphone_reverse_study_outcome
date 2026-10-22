package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.paintreference;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bot.impl.common.util.h;
import com.larus.bot.impl.databinding.LarusItemBotAvatarPaintStyleBinding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import xu8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nH\u0016J\b\u0010\u0017\u001a\u00020\nH\u0016J\u0018\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\nH\u0016J\u0014\u0010\u001a\u001a\u00020\u000e2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R7\u0010\b\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/paintreference/PaintStyleAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "dataList", "", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/paintreference/PaintStyleViewHolder$PaintStyleViewData;", "onClickItem", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "position", "", "getOnClickItem", "()Lkotlin/jvm/functions/Function1;", "setOnClickItem", "(Lkotlin/jvm/functions/Function1;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "holder", "refreshData", "data", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PaintStyleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public List<PaintStyleViewHolder.a> a;
    public Function1<? super Integer, Unit> b;

    public final int getItemCount() {
        return this.a.size();
    }

    public PaintStyleAdapter() {
        this.a = CollectionsKt.emptyList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r13, final int r14) {
        Intrinsics.checkNotNullParameter(r13, "holder");
        PaintStyleViewHolder.a r0 = (PaintStyleViewHolder.a) CollectionsKt.getOrNull(this.a, r14);
        if (r0 == null) goto L51;
        String r2 = null;
        if ((r13 instanceof PaintStyleViewHolder) == false) goto L7;
        PaintStyleViewHolder r1 = (PaintStyleViewHolder) r13;
    L8:
        if (r1 == null) goto L51;
        Intrinsics.checkNotNullParameter(r0, "data");
        SimpleDraweeView r4 = r1.a.b;
        h.b(r4, r0.a, "paint_style_view_holder", false, Integer.valueOf(r4.getLayoutParams().width), Integer.valueOf(r1.a.b.getLayoutParams().height), null, 100);
        r1.a.c.setBackgroundResource(2131243572);
        if (r0.d == false) goto L12;
        e1.x(r1.a.d);
    L13:
        LarusItemBotAvatarPaintStyleBinding r3 = r1.a;
        TextView r5 = r3.e;
        String r6 = r0.b;
        String r7 = "";
        if (r6 == null) goto L47;
        Context r8 = r3.a.getContext();
        String r9 = r0.c;
        if (r9 != null) goto L18;
        r2 = "";
    L19:
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r2, "defaultString");
        boolean r10 = false;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L34
        if (r6.length() <= 0) goto L23;
        boolean r12 = true;
    L24:
        if (r12 == false) goto L29;
        Resources r15 = r8.getResources();     // Catch: Throwable -> L34
        if (r15 == null) goto L29;
        String r16 = r15.getString(r15.getIdentifier(r6, "string", r8.getPackageName()));     // Catch: Throwable -> L34
    L53:
        Object r17 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L32
    L38:
        if (Result.exceptionOrNull-impl(r17) == null) goto L40;
        FLogger.a.i("BotEditHelper", "get string from remote starlingKey fail");
    L40:
        if (r16 != null) goto L42;
    L43:
        r10 = true;
    L44:
        if (r10 == true) goto L47;
        r2 = r16;
        goto L47
    L42:
        if (r16.length() != 0) goto L44;
    L32:
        Throwable th = th;
    L36:
        Result.Companion r18 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
    L29:
        r16 = "";
        goto L53
    L23:
        r12 = false;
    L34:
        th = move-exception;
        th = th;
        r16 = "";
        goto L36
    L18:
        r2 = r9;
    L47:
        if (r2 == null) goto L50;
        r7 = r2;
    L50:
        r5.setText(r7);
        goto L51
    L12:
        e1.o(r1.a.d);
        goto L13
    L7:
        r1 = null;
    L51:
        r13.itemView.setOnClickListener(new a(this, r14));
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "parent");
        ConstraintLayout r11 = LayoutInflater.from(r9.getContext()).inflate(2131562506, r9, false);
        int r0 = 2131374931;
        SimpleDraweeView r4 = ViewBindings.findChildViewById(r11, 2131374931);
        if (r4 == null) goto L13;
        r0 = 2131379657;
        View r5 = ViewBindings.findChildViewById(r11, 2131379657);
        if (r5 == null) goto L13;
        r0 = 2131381770;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r11, 2131381770);
        if (r6 == null) goto L13;
        r0 = 2131388772;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r11, 2131388772);
        if (r7 == null) goto L13;
        return new PaintStyleViewHolder(new LarusItemBotAvatarPaintStyleBinding(r11, r4, r5, r6, r7));
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }
}
