package com.obric.assistant.view.actionbar.custom;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import aq8.e;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.view.actionbar.BaseActionBarHolder;
import com.larus.bmhome.view.actionbar.custom.t1;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;
import com.larus.common_ui.widget.roundlayout.RoundFrameLayout;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import com.obric.assistant.impl.databinding.ObricItemCustomActionbarNormalHolderBinding;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qha.a;
import qha.b;
import qha.c;
import v19.h;
import wa8.u1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u000f\u001a\u00020\u00102\u000e\u0010\b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nH\u0004J(\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0010H\u0016J\b\u0010\u001a\u001a\u00020\u0010H\u0002J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\u0012\u0010\u001c\u001a\u00020\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/assistant/view/actionbar/custom/ObricActionBarSegmentCell;", "Lcom/larus/bmhome/view/actionbar/BaseActionBarHolder;", "binding", "Lcom/obric/assistant/impl/databinding/ObricItemCustomActionbarNormalHolderBinding;", "defaultClickCallback", "Lcom/larus/bmhome/view/actionbar/custom/CustomActionBarHolderCallback;", "isImmerse", "", "extraData", "Lcom/larus/bmhome/instruction/core/model/InstructionExtraData;", "Lcom/larus/bmhome/instruction/InstructionExtraData;", "<init>", "(Lcom/obric/assistant/impl/databinding/ObricItemCustomActionbarNormalHolderBinding;Lcom/larus/bmhome/view/actionbar/custom/CustomActionBarHolderCallback;ZLcom/larus/bmhome/instruction/core/model/InstructionExtraData;)V", "getBinding", "()Lcom/obric/assistant/impl/databinding/ObricItemCustomActionbarNormalHolderBinding;", "updateExtraData", "", "bind", "name", "", MemorySourceLinkType.URL, "item", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "position", "", "onViewRecycle", "clearTransientPressState", "renderRedDotInfo", "applyRedDotTextStyle", "redDotTextInfo", "Lcom/larus/bmhome/actionbar/model/RedDotTextStyleInfo;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ObricActionBarSegmentCell extends BaseActionBarHolder {
    public static final /* synthetic */ int e = 0;
    public final ObricItemCustomActionbarNormalHolderBinding a;
    public final t1 b;
    public final boolean c;
    public final e d;

    public final void V3() {
        RoundConstraintLayout r0 = W3().a;
        r0.setPressed(false);
        r0.setHovered(false);
        r0.refreshDrawableState();
        r0.jumpDrawablesToCurrentState();
    }

    public final void T3() {
        V3();
    }

    public ObricItemCustomActionbarNormalHolderBinding W3() {
        return this.a;
    }

    public ObricActionBarSegmentCell(ObricItemCustomActionbarNormalHolderBinding r2, t1 r3, boolean r4, e r5) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        Intrinsics.checkNotNullParameter(r3, "defaultClickCallback");
        super(r2.a);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }

    /* JADX WARN: Type inference failed for: r4v12, types: [qha.b] */
    public void U3(String r4, String r5, final z0 r6, final int r7) {
        Intrinsics.checkNotNullParameter(r4, "name");
        Intrinsics.checkNotNullParameter(r5, MemorySourceLinkType.URL);
        Intrinsics.checkNotNullParameter(r6, "item");
        V3();
        GradientDrawable r2 = null;
        ImageLoaderKt.u(W3().c, r5, null);
        W3().d.setText(r4);
        e1.d(W3().a, new a(this, r6, r7));
        if (this.c == false) goto L13;
        RoundConstraintLayout r8 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r8 instanceof RoundConstraintLayout) == false) goto L7;
        RoundConstraintLayout r9 = r8;
    L8:
        if (r9 == null) goto L12;
        c29.a r10 = r9.getDelegate();
        if (r10 == null) goto L12;
        int r11 = ContextCompat.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), 2131106535);
        r10.a(r11);
        r10.b(r11);
        r10.g(ContextCompat.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), 2131106536));
    L12:
        W3().d.setTextColor(ContextCompat.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), 2131106521));
    L33:
        final ?? r12 = new b(this);
        if (W3().d.getWidth() != 0) goto L36;
    L39:
        W3().d.post(new c(r12));
    L40:
        W3().c.setColorFilter(ColorProtector.parseColor("#FF000000"));
        this.b.d(((RecyclerView.ViewHolder) this).itemView, W3().c, W3().d, r6);
        Intrinsics.checkNotNullParameter(r6, "item");
        W3().b.setVisibility(8);
        if (r6.y == true) goto L43;
        W3().e.setVisibility(8);
        return;
    L43:
        u1 r13 = r6.z;
        if (r13 == null) goto L46;
        String r14 = r13.a;
    L48:
        if (r14 != null) goto L50;
    L53:
        boolean r15 = true;
    L54:
        if (r15 == false) goto L56;
        W3().e.setVisibility(8);
        W3().b.setVisibility(0);
        return;
    L56:
        W3().e.setVisibility(0);
        TextView r16 = W3().e;
        if (r13 == null) goto L59;
        String r17 = r13.a;
    L60:
        if (r17 != null) goto L62;
        r17 = "";
    L62:
        r16.setText(r17);
        TextView r18 = W3().e;
        if (r13 == null) goto L65;
        int r19 = r13.b;
    L66:
        r18.setTextColor(r19);
        Drawable r20 = W3().e.getBackground();
        if (r20 == null) goto L69;
        Drawable r21 = r20.mutate();
    L71:
        if ((r21 instanceof GradientDrawable) == false) goto L73;
        r2 = (GradientDrawable) r21;
    L73:
        if (r2 == null) goto L81;
        if (r13 == null) goto L76;
        int r22 = r13.c;
    L77:
        r2.setColor(r22);
        return;
    L76:
        r22 = ContextCompat.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), v19.c.b(2130973611, ((RecyclerView.ViewHolder) this).itemView.getContext(), 2131105590));
        goto L77
    L81:
        return;
    L69:
        r21 = null;
        goto L71
    L65:
        r19 = ContextCompat.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), v19.c.b(2130972123, ((RecyclerView.ViewHolder) this).itemView.getContext(), 2131103203));
        goto L66
    L59:
        r17 = null;
        goto L60
    L50:
        if (r14.length() == 0) goto L53;
        r15 = false;
        goto L54
    L46:
        r14 = null;
        goto L48
    L36:
        if (W3().d.getHeight() == 0) goto L39;
        r12.invoke();
        goto L40
    L7:
        r9 = null;
        goto L8
    L13:
        boolean r23 = h.a;
        if (h.b(((RecyclerView.ViewHolder) this).itemView.getContext()) == false) goto L16;
        int r24 = 2131102564;
    L17:
        RoundConstraintLayout r25 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r25 instanceof RoundConstraintLayout) == false) goto L20;
        RoundConstraintLayout r26 = r25;
    L21:
        if (r26 == null) goto L25;
        c29.a r27 = r26.getDelegate();
        if (r27 == null) goto L25;
        r27.a(ContextCompat.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), r24));
    L25:
        RoundFrameLayout r28 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r28 instanceof RoundFrameLayout) == false) goto L28;
        RoundFrameLayout r29 = r28;
    L29:
        if (r29 == null) goto L33;
        c29.a r30 = r29.getDelegate();
        if (r30 == null) goto L33;
        r30.a(ContextCompat.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), r24));
        goto L33
    L28:
        r29 = null;
        goto L29
    L20:
        r26 = null;
        goto L21
    L16:
        r24 = 2131102563;
        goto L17
    }
}
