package com.larus.uaigc.instruction;

import android.graphics.drawable.Drawable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.larus.bmhome.actionbar.model.g1;
import com.larus.bmhome.actionbar.model.l1;
import com.larus.bmhome.actionbar.model.w0;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.bmhome.view.resourcebar.bean.ResourceBarConfig;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.uaigc.impl.databinding.LarusEmptyResourceItemViewBinding;
import com.larus.utils.e1;
import com.larus.utils.o0;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import wa8.f1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/larus/uaigc/instruction/MultiAttachmentSelectorWidget$createCustomEmptyResourceViewHolderBuilder$1$1", "Lcom/larus/bmhome/view/resourcebar/viewholder/BaseResourceViewHolder;", "bind", "", "data", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceItemBean;", "callback", "Lcom/larus/bmhome/view/resourcebar/viewholder/BaseResourceViewHolder$Callback;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MultiAttachmentSelectorWidget$createCustomEmptyResourceViewHolderBuilder$1$1 extends BaseResourceViewHolder {
    public static final /* synthetic */ int d = 0;
    public final /* synthetic */ MultiAttachmentSelectorWidget b;
    public final /* synthetic */ LarusEmptyResourceItemViewBinding c;

    public final void T3(final ResourceItemBean r7, final lt8.a r8) {
        Intrinsics.checkNotNullParameter(r7, "data");
        boolean r0 = v19.h.a;
        boolean r1 = v19.h.b(this.b.getContext());
        y r2 = MultiAttachmentSelectorWidget.n6(this.b);
        String r3 = null;
        Integer r4 = null;
        if (r2 == null) goto L5;
        com.larus.bmhome.instruction.d r5 = r2.u;
    L6:
        if (r5 == null) goto L31;
        Integer r6 = r5.a;
        if (r6 != null) goto L10;
    L17:
        String r9 = r5.c;
        if (o0.d(r9) == false) goto L20;
        e1.x(this.c.d);
        this.c.d.setText(r9);
    L21:
        Drawable r10 = r5.b;
        if (r10 == null) goto L24;
        this.c.b.setBackground(r10);
    L24:
        Integer r11 = r5.d;
        if (r11 == null) goto L27;
        LarusEmptyResourceItemViewBinding r12 = this.c;
        AbsInstructionWidget r13 = this.b;
        r12.d.setTextColor(ContextCompat.getColor(r13.getContext(), r11.intValue()));
    L27:
        String r14 = r5.e;
        if (r14 == null) goto L30;
        this.c.a.setContentDescription(r14);
    L30:
        e1.d(this.c.a, new f0(r8, r7));
        return;
    L20:
        e1.o(this.c.d);
        goto L21
    L10:
        if (r6.intValue() == 0) goto L12;
        boolean r15 = true;
    L13:
        if (r15 == false) goto L15;
        r4 = r6;
    L15:
        if (r4 == null) goto L17;
        LarusEmptyResourceItemViewBinding r16 = this.c;
        r16.c.setImageResource(r4.intValue());
        goto L17
    L12:
        r15 = false;
        goto L13
    L31:
        w0.a r17 = MultiAttachmentSelectorWidget.o6(this.b);
        if ((r17 instanceof w0.a) == false) goto L35;
        Object r18 = r17.a.b;
    L37:
        boolean r19 = r18 instanceof l1;
        if (r19 == false) goto L40;
    L41:
        if (r19 == false) goto L50;
        if (r1 == false) goto L46;
        g1 r20 = ((l1) r18).b;
        if (r20 == null) goto L58;
        String r21 = r20.b;
    L60:
        if (o0.d(r21) == false) goto L62;
        ImageLoaderKt.u(this.c.c, r21, "biz_placeholder_image_load");
    L65:
        if (r19 == false) goto L68;
        r3 = ((l1) r18).c;
    L71:
        if (o0.d(r3) == false) goto L73;
        e1.x(this.c.d);
        this.c.d.setText(r3);
    L74:
        e1.d(this.c.a, new g0(r8, r7));
        return;
    L73:
        e1.o(this.c.d);
        goto L74
    L68:
        if ((r18 instanceof f1) == false) goto L71;
        r3 = ((f1) r18).c;
        goto L71
    L62:
        GenericDraweeHierarchy r22 = this.c.c.getHierarchy();
        if (r22 == null) goto L65;
        r22.setPlaceholderImage(2131241398);
    L58:
        r21 = null;
        goto L60
    L46:
        g1 r23 = ((l1) r18).a;
        if (r23 == null) goto L58;
        r21 = r23.b;
        goto L60
    L50:
        if ((r18 instanceof f1) == false) goto L58;
        if (r1 == false) goto L55;
        wa8.e1 r24 = ((f1) r18).b;
        if (r24 == null) goto L58;
        r21 = r24.b;
        goto L60
    L55:
        wa8.e1 r25 = ((f1) r18).a;
        if (r25 == null) goto L58;
        r21 = r25.b;
        goto L60
    L40:
        if ((r18 instanceof f1) == true) goto L41;
        return;
    L35:
        if (Intrinsics.areEqual(r17, w0.b.a) == false) goto L77;
        r18 = r7.getExt().get("key_multi_media_placeholder");
        goto L37
    L77:
        throw new NoWhenBranchMatchedException();
    L5:
        r5 = null;
        goto L6
    }

    public MultiAttachmentSelectorWidget$createCustomEmptyResourceViewHolderBuilder$1$1(ResourceBarConfig r1, MultiAttachmentSelectorWidget r2, LarusEmptyResourceItemViewBinding r3, ConstraintLayout r4) {
        this.b = r2;
        this.c = r3;
        Intrinsics.checkNotNull(r4);
        super(r1, r4);
    }
}
