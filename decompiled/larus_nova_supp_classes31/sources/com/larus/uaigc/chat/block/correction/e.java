package com.larus.uaigc.chat.block.correction;

import android.content.Context;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.layout.widget.ShimmerTextView;
import com.larus.im.bean.message.CreationBlock;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.ImageData;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.ImagePlaceHolder;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.mainbot.api.IFlowMainBot;
import com.larus.utils.e1;
import java.util.List;
import kc8.y;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e extends jc8.b<a> {
    public kc8.b d;
    public final Lazy e;
    public final Lazy f;
    public yy9.c g;
    public Job h;
    public View i;

    public final String c() {
        return "CorrectionImageBlockHolder";
    }

    public final void i() {
        Job r0 = this.h;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.h = null;
        View r1 = this.i;
        if (r1 == null) goto L8;
        r1.setOnLongClickListener(null);
        r1.setLongClickable(false);
    L8:
        this.i = null;
    }

    public final ChatParam j() {
        return (ChatParam) this.f.getValue();
    }

    public e() {
        this.e = LazyKt.lazy(new b(this));
        this.f = LazyKt.lazy(new c(this));
    }

    public final jc8.d f(jc8.a r2) {
        a r3 = (a) r2;
        Intrinsics.checkNotNullParameter(r3, "blockModel");
        return jc8.e.d(r3);
    }

    public final void g(jc8.a r15) {
        a r16 = (a) r15;
        Intrinsics.checkNotNullParameter(r16, "blockModel");
        Job r0 = this.h;
        Integer r2 = null;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.h = null;
        View r1 = this.i;
        if (r1 == null) goto L8;
        r1.setOnLongClickListener(null);
        r1.setLongClickable(false);
    L8:
        this.i = null;
        this.d = jc8.c.a(this, kc8.b.class);
        yy9.c r3 = this.g;
        if (r3 == null) goto L112;
        Message r5 = r16.j();
        BlockContent r6 = ((jc8.a) r16).a.getContent();
        if (r6 == null) goto L15;
        CreationBlock r7 = r6.getCreationBlock();
        if (r7 == null) goto L15;
        List r8 = r7.creations;
    L16:
        Message r9 = r16.j();
        kc8.b r10 = jc8.c.a(this, kc8.b.class);
        if (r10 == null) goto L21;
        y r11 = r10.a;
        if (r11 == null) goto L21;
        Integer r12 = r11.j;
    L22:
        yy9.c r13 = this.g;
        if (r13 == null) goto L41;
        Context r14 = r13.getContext();
        if (r14 == null) goto L41;
        IFlowMainBot.Companion r17 = IFlowMainBot.a;
        de8.c r18 = (de8.c) this.e.getValue();
        if (r18 == null) goto L30;
        Integer r19 = r18.m();
    L31:
        if (r19 == null) goto L33;
        boolean r110 = true;
    L34:
        Boolean r111 = Boolean.valueOf(r110);
        kc8.b r112 = this.d;
        if (r112 == null) goto L39;
        y r113 = r112.a;
        if (r113 == null) goto L39;
        boolean r114 = Intrinsics.areEqual(r113.h, Boolean.TRUE);
    L40:
        int r20 = IFlowMainBot.a.b(r17, r14, r9, r12, r111, r114, ((jc8.b) this).c);
    L42:
        zy9.a r4 = new zy9.a(r5, r8, r20);
        d r21 = new d(this, r16);
        Intrinsics.checkNotNullParameter(r4, "vmData");
        zy9.c r22 = (zy9.c) r3.c.getValue();
        r22.getClass();
        Intrinsics.checkNotNullParameter(r4, "vmData");
        r22.c = r4;
        r22.b = r21;
        zy9.c r115 = (zy9.c) r3.c.getValue();
        zy9.a r23 = r115.c;
        if (r23 == null) goto L71;
        List<CreationItem> r24 = r23.b;
        if (r24 == null) goto L71;
        CreationItem r25 = (CreationItem) CollectionsKt.firstOrNull(r24);
        if (r25 == null) goto L71;
        String r26 = r25.id;
        ImageData r27 = r25.image;
        if (r27 != null) goto L52;
        m r116 = new m(0);
    L72:
        zy9.c r28 = (zy9.c) r3.c.getValue();
        zy9.b r29 = r28.a;
        if (r29 != null) goto L75;
        r29 = new zy9.b(r28);
        r28.a = r29;
    L75:
        CorrectionImageView r30 = (CorrectionImageView) r3.b.getValue();
        r30.getClass();
        Intrinsics.checkNotNullParameter(r116, "input");
        Intrinsics.checkNotNullParameter(r29, "output");
        r30.getClass();
        FrameLayout r31 = r30.b;
        if (r31 == null) goto L78;
        e1.o(r31);
    L78:
        int r32 = r116.c;
        if (r32 != 1) goto L81;
        r30.T5(r116);
    L110:
        r30.i = r116.c;
        return;
    L81:
        if (r32 != 3) goto L83;
    L85:
        ShimmerTextView r33 = r30.f;
        if (r33 == null) goto L88;
        r33.x();
    L88:
        SimpleDraweeView r34 = r30.a;
        if (r34 == null) goto L91;
        e1.o(r34);
    L91:
        FrameLayout r35 = r30.c;
        if (r35 == null) goto L94;
        e1.x(r35);
    L94:
        ConstraintLayout r36 = r30.d;
        if (r36 == null) goto L97;
        e1.o(r36);
    L97:
        ImagePlaceHolder r37 = r116.f;
        if (r37 == null) goto L110;
        Long r38 = r37.width;
        if (r38 == null) goto L102;
        Integer r39 = Integer.valueOf((int) r38.longValue());
    L103:
        Long r40 = r37.height;
        if (r40 == null) goto L106;
        r2 = Integer.valueOf((int) r40.longValue());
    L106:
        Size r41 = CorrectionImageView.R5(r39, r2, r116.g);
        FrameLayout r42 = r30.c;
        if (r42 == null) goto L110;
        r42.setLayoutParams(new ConstraintLayout.LayoutParams(r41.getWidth(), r41.getHeight()));
        goto L110
    L102:
        r39 = null;
        goto L103
    L83:
        if (r32 == 4) goto L85;
        r30.U5(r116, r29);
        goto L110
    L52:
        zy9.a r43 = r115.c;
        if (r43 == null) goto L55;
        Message r44 = r43.a;
    L56:
        Integer r45 = r27.status;
        if (r45 == null) goto L59;
        int r46 = r45.intValue();
    L60:
        ImageObj r47 = r27.imageThumbRaw;
        if (r47 != null) goto L63;
        r47 = r27.imageThumb;
    L63:
        ImageObj r48 = r47;
        ImageObj r49 = r27.imageOriRaw;
        if (r49 != null) goto L66;
        r49 = r27.imageOrigin;
    L66:
        ImageObj r117 = r49;
        ImagePlaceHolder r118 = r27.placeholder;
        zy9.a r119 = r115.c;
        if (r119 == null) goto L69;
        int r120 = r119.c;
    L70:
        r116 = new m(r44, r26, r46, r48, r117, r118, r120);
        goto L72
    L69:
        r120 = 0;
        goto L70
    L59:
        r46 = 0;
        goto L60
    L55:
        r44 = null;
    L71:
        r116 = new m(0);
    L39:
        r114 = false;
        goto L40
    L33:
        r110 = false;
        goto L34
    L30:
        r19 = null;
    L41:
        r20 = 0;
    L21:
        r12 = null;
    L15:
        r8 = null;
        goto L16
    }

    public final View h(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        yy9.c r0 = this.g;
        if (r0 != null) goto L6;
        r0 = new yy9.c(r2.getContext());
        this.g = r0;
    L6:
        return (CorrectionImageView) r0.b.getValue();
    }
}
