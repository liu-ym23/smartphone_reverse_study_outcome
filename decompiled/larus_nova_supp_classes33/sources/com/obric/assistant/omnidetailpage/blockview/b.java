package com.obric.assistant.omnidetailpage.blockview;

import android.content.Context;
import android.graphics.Rect;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.api.IVideoController;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b extends RecyclerView.Adapter<j> {
    public final Object a;
    public final com.obric.assistant.omnidetailpage.localmedia.w b;
    public final Function3<List<? extends ifa.c>, Integer, Integer, Unit> c;
    public List<? extends ifa.c> d;
    public List<c> e;
    public CoroutineScope f;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[LocalMediaDisplayMode.values().length];
            r0[LocalMediaDisplayMode.HORIZONTAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[LocalMediaDisplayMode.VERTICAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public final int getItemCount() {
        return this.d.size();
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r2) {
        j r3 = (j) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        super.onViewRecycled(r3);
        r3.b.c(r3);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r30, final int r31) {
        final j r2 = (j) r30;
        Intrinsics.checkNotNullParameter(r2, "holder");
        ifa.c r4 = (ifa.c) ListProtector.get(this.d, r31);
        c r5 = (c) CollectionsKt.getOrNull(this.e, r31);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r4, "item");
        if (r5 == null) goto L9;
        View r6 = ((RecyclerView.ViewHolder) r2).itemView;
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if (r7 == null) goto L8;
        RecyclerView.LayoutParams r8 = (RecyclerView.LayoutParams) r7;
        ((ViewGroup.MarginLayoutParams) r8).width = r5.a.getWidth();
        ((ViewGroup.MarginLayoutParams) r8).height = r5.a.getHeight();
        Rect r9 = r5.b;
        ((ViewGroup.MarginLayoutParams) r8).leftMargin = r9.left;
        ((ViewGroup.MarginLayoutParams) r8).topMargin = r9.top;
        ((ViewGroup.MarginLayoutParams) r8).rightMargin = r9.right;
        ((ViewGroup.MarginLayoutParams) r8).bottomMargin = r9.bottom;
        r6.setLayoutParams(r8);
        goto L9
    L8:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    L9:
        int r10 = 0;
        if ((r4 instanceof ifa.c.a) == false) goto L16;
        r2.b.c(r2);
        r2.j = r4;
        Job r3 = r2.m;
        if (r3 == null) goto L14;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
    L14:
        ImageLoaderKt.u(r2.e, ((ifa.c.a) r4).d, "obric_omni.operate_phone");
        r2.e.setVisibility(0);
        r2.f.setVisibility(8);
        r2.g.setVisibility(8);
        r2.h.setVisibility(8);
        r2.i.setVisibility(0);
    L77:
        ((RecyclerView.ViewHolder) r2).itemView.setOnClickListener(new com.obric.assistant.omnidetailpage.blockview.a(this, r31, r2));
        return;
    L16:
        if ((r4 instanceof ifa.c.b) == false) goto L80;
        final ifa.c.b r11 = (ifa.c.b) r4;
        ifa.c.b r12 = r2.k;
        if (r12 == null) goto L20;
        String r13 = r12.a;
    L22:
        if (Intrinsics.areEqual(r13, r11.a) == false) goto L30;
        ifa.c.b r14 = r2.k;
        if (r14 == null) goto L26;
        String r15 = r14.c;
    L28:
        if (Intrinsics.areEqual(r15, r11.c) == false) goto L30;
        boolean r16 = true;
    L31:
        if (r16 == true) goto L33;
        r2.b.c(r2);
    L33:
        r2.j = r11;
        r2.k = r11;
        r2.e.setVisibility(8);
        r2.f.setVisibility(0);
        r2.h.setVisibility(0);
        r2.i.setVisibility(0);
        if (r16 == false) goto L43;
        IVideoController r17 = r2.l;
        if (r17 != null) goto L38;
    L40:
        boolean r18 = false;
    L41:
        if (r18 == false) goto L43;
        com.obric.assistant.omnidetailpage.localmedia.w r19 = r2.b;
        Object r20 = r2.c;
        r19.getClass();
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r20, "owner");
        r19.a.add(r2);
        r19.b.put(r2, r20);
        goto L77
    L38:
        if (r17.isReleased() == true) goto L40;
        r18 = true;
    L43:
        r2.o = false;
        r2.p = false;
        Job r21 = r2.m;
        if (r21 == null) goto L46;
        Job.DefaultImpls.cancel$default(r21, null, 1, null);
    L46:
        r2.g.setImageDrawable(null);
        r2.g.setVisibility(0);
        String r22 = r11.f;
        if (r22 != null) goto L49;
    L52:
        boolean r110 = true;
    L53:
        if (r110 == true) goto L55;
        ImageLoaderKt.y(r2.g, r22, "obric_omni.operate_phone", new i(r2, r11), 4);
    L59:
        VideoPlayView r23 = r2.f;
        Integer r24 = r11.i;
        if (r24 == null) goto L62;
        int r25 = r24.intValue();
    L63:
        Integer r26 = r11.j;
        if (r26 == null) goto L66;
        r10 = r26.intValue();
    L66:
        r23.getClass();
        if (r25 == 0) goto L70;
        if (r10 == 0) goto L70;
        r23.l = r25 / r10;
    L70:
        VideoPlayView r111 = r2.f;
        String r112 = r11.f;
        String r113 = r11.e;
        Integer r27 = r11.h;
        if (r27 != null) goto L73;
        r27 = r11.j;
    L73:
        Integer r114 = r27;
        Integer r28 = r11.g;
        if (r28 != null) goto L76;
        r28 = r11.i;
    L76:
        VideoPlayView.p(r111, r112, r112, r113, r114, r28, null, null, null, 224);
        r2.T3();
        VideoPlayView.e(r2.f, r2.l, null, r11.c, null, null, null, 58);
        VideoPlayView r29 = r2.f;
        r29.d = new h(r2);
        r29.setVideoEngineCallback(new l(r2, r11));
        com.obric.assistant.omnidetailpage.localmedia.w r32 = r2.b;
        Object r33 = r2.c;
        r32.getClass();
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r33, "owner");
        r32.a.add(r2);
        r32.b.put(r2, r33);
        goto L77
    L62:
        r25 = 0;
        goto L63
    L55:
        Job r34 = r2.m;
        if (r34 == null) goto L58;
        Job.DefaultImpls.cancel$default(r34, null, 1, null);
    L58:
        r2.m = BuildersKt.launch$default(r2.d, null, null, new LocalMediaViewHolder$loadExtractedFirstFrame$1(r2, r11, null), 3, null);
        goto L59
    L49:
        if (StringsKt.isBlank(r22) == true) goto L52;
        r110 = false;
        goto L53
    L26:
        r15 = null;
    L30:
        r16 = false;
        goto L31
    L20:
        r13 = null;
        goto L22
    L80:
        throw new NoWhenBranchMatchedException();
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        Context r6 = r4.getContext();
        com.obric.assistant.omnidetailpage.localmedia.w r0 = this.b;
        Object r1 = this.a;
        CoroutineScope r2 = this.f;
        if (r2 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("scope");
        r2 = null;
    L7:
        return new j(r6, r0, r1, r2);
    }

    public b(Object r2, com.obric.assistant.omnidetailpage.localmedia.w r3, h0 r4) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        Intrinsics.checkNotNullParameter(r3, "autoPlayManager");
        Intrinsics.checkNotNullParameter(r4, "onClick");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = CollectionsKt.emptyList();
        this.e = CollectionsKt.emptyList();
    }

    public final void y2(List<? extends ifa.c> r18, int r19, LocalMediaDisplayMode r20) {
        Intrinsics.checkNotNullParameter(r18, "newItems");
        Intrinsics.checkNotNullParameter(r20, "displayMode");
        this.d = r18;
        ifa.c r3 = (ifa.c) CollectionsKt.firstOrNull(r18);
        if (r3 == null) goto L5;
        Size r4 = n0.a(r3, r19, r18.size());
    L6:
        List<? extends ifa.c> r5 = r18;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r7 = r5.iterator();
        int r8 = 0;
    L8:
        if (r7.hasNext() == false) goto L45;
        Object r9 = r7.next();
        int r10 = r8 + 1;
        if (r8 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        ifa.c r11 = (ifa.c) r9;
        int[] r12 = a.a;
        int r13 = r12[r20.ordinal()];
        if (r13 == 1) goto L18;
        if (r13 != 2) goto L17;
        Size r14 = n0.a(r11, r19, 1);
    L21:
        int r15 = r18.size();
        int r16 = r12[r20.ordinal()];
        if (r16 == 1) goto L36;
        if (r16 != 2) goto L34;
        if (r8 != 0) goto L27;
        int r17 = i5.Y();
    L29:
        if (r8 != (r15 - 1)) goto L31;
        int r21 = i5.Y();
    L32:
        Rect r110 = new Rect(0, r17, 0, r21);
    L44:
        r6.add(new c(r14, r110));
        r8 = r10;
        goto L8
    L31:
        r21 = i5.r0();
        goto L32
    L27:
        r17 = i5.r0();
        goto L29
    L34:
        throw new NoWhenBranchMatchedException();
    L36:
        if (r8 != 0) goto L38;
        int r111 = 0;
    L40:
        if (r8 != (r15 - 1)) goto L42;
        int r22 = 0;
    L43:
        r110 = new Rect(r111, 0, r22, 0);
        goto L44
    L42:
        r22 = i5.N();
        goto L43
    L38:
        r111 = i5.N();
        goto L40
    L17:
        throw new NoWhenBranchMatchedException();
    L18:
        if (r4 != null) goto L20;
        r14 = n0.a(r11, r19, r18.size());
        goto L21
    L20:
        r14 = r4;
        goto L21
    L45:
        this.e = r6;
        notifyDataSetChanged();
        return;
    L5:
        r4 = null;
        goto L6
    }
}
