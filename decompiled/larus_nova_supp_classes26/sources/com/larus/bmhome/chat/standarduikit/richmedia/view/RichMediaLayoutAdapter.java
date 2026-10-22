package com.larus.bmhome.chat.standarduikit.richmedia.view;

import android.content.res.ColorStateList;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.drawable.ScalingUtils;
import com.larus.bmhome.chat.markdown.imagegroup.view.MarkdownSourceImageView;
import com.larus.bmhome.chat.monitor.IMessageImageLoaderService;
import com.larus.bmhome.chat.monitor.MessageImageLoader;
import com.larus.bmhome.chat.monitor.MessageImageType;
import com.larus.bmhome.chat.standarduikit.richmedia.view.viewholder.RichMediaItemViewHolder;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.list.expose.ExposureTrackerExtKt;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.utils.e1;
import fn8.a;
import fn8.c0;
import fn8.d;
import fn8.d0;
import fn8.e;
import fn8.n;
import fn8.o;
import fn8.p;
import fn8.q;
import fn8.r;
import fn8.s;
import fn8.t;
import fn8.u;
import fn8.w;
import fn8.x;
import fn8.y;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u000eH\u0016J\u001e\u0010\u0019\u001a\u00020\u00102\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/richmedia/view/RichMediaLayoutAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/bmhome/chat/standarduikit/richmedia/view/viewholder/RichMediaItemViewHolder;", "<init>", "()V", "items", "", "Lcom/larus/bmhome/chat/standarduikit/richmedia/view/RichMediaItemViewConfig;", "output", "Lcom/larus/bmhome/chat/standarduikit/richmedia/view/RichMediaLayoutViewOutput;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "onViewRecycled", "onViewAttachedToWindow", "checkVisibleItemExposure", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getItemCount", "submit", "newItems", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RichMediaLayoutAdapter extends RecyclerView.Adapter<RichMediaItemViewHolder> {
    public List<x> a;
    public c0 b;

    public final int getItemCount() {
        return this.a.size();
    }

    public RichMediaLayoutAdapter() {
        this.a = CollectionsKt.emptyList();
    }

    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r3) {
        final RichMediaItemViewHolder r4 = (RichMediaItemViewHolder) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        super.onViewAttachedToWindow(r4);
        ((RecyclerView.ViewHolder) r4).itemView.post(new y(r4));
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r5) {
        RichMediaItemViewHolder r6 = (RichMediaItemViewHolder) r5;
        Intrinsics.checkNotNullParameter(r6, "holder");
        w r0 = r6.a;
        r0.j = null;
        r0.k = null;
        ExposureTrackerExtKt.c(r0);
        ExposeXTrackerExtKt.e(r0);
        r0.d(true);
        r0.i = null;
        r0.h = null;
        r0.setOnClickListener(null);
        r0.setOnLongClickListener(null);
        r0.a.setController(null);
        MarkdownSourceImageView r2 = r0.c;
        if (r2 == null) goto L5;
        r2.setController(null);
        r2.setOnClickListener(null);
        r2.setVisibility(8);
    L5:
        AppCompatImageView r3 = r0.d;
        if (r3 == null) goto L8;
        r3.setVisibility(8);
    L8:
        AppCompatTextView r4 = r0.e;
        if (r4 == null) goto L11;
        r4.setText(null);
        r4.setVisibility(8);
    L11:
        LinearLayout r1 = r0.f;
        if (r1 == null) goto L14;
        r1.removeAllViews();
        r1.setVisibility(8);
    L14:
        LinearLayout r7 = r0.g;
        if (r7 == null) goto L17;
        r7.removeAllViews();
        r7.setVisibility(8);
    L17:
        r0.setLayoutParams(new RecyclerView.LayoutParams(0, 0));
        super.onViewRecycled(r6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v11, types: [fn8.s] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void onBindViewHolder(RecyclerView.ViewHolder r28, int r29) {
        RichMediaItemViewHolder r1 = (RichMediaItemViewHolder) r28;
        Intrinsics.checkNotNullParameter(r1, "holder");
        final c0 r2 = this.b;
        if (r2 == 0) goto L120;
        final x r10 = (x) ListProtector.get(this.a, r29);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r10, "config");
        Intrinsics.checkNotNullParameter(r2, "output");
        final w r3 = r1.a;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r10, "config");
        Intrinsics.checkNotNullParameter(r2, "output");
        r3.d(!r10.l);
        r3.h = r10.a;
        r3.i = r2;
        r3.setLayoutParams(new RecyclerView.LayoutParams(r10.g.getWidth(), r10.g.getHeight()));
        if (r10.f.length() != 0) goto L8;
        boolean r4 = true;
    L10:
        if (r4 == false) goto L12;
        r3.a.setController(null);
    L17:
        d0 r5 = r10.i;
        String r15 = r10.d;
        int r8 = 8;
        if (r5 != null) goto L22;
        MarkdownSourceImageView r6 = r3.c;
        if (r6 == null) goto L31;
        r6.setController(null);
        r6.setOnClickListener(null);
        r6.setVisibility(8);
    L31:
        String r7 = r10.j;
        if (r7 != null) goto L36;
        AppCompatTextView r9 = r3.e;
        if (r9 == null) goto L40;
        r9.setText(null);
        r9.setVisibility(8);
    L40:
        LinearLayout r11 = r3.f;
        if (r11 == null) goto L43;
        r11.removeAllViews();
        r11.setVisibility(8);
    L43:
        LinearLayout r12 = r3.g;
        if (r12 == null) goto L46;
        r12.removeAllViews();
        r12.setVisibility(8);
    L46:
        Iterator<T> r16 = r10.k.iterator();
    L48:
        if (r16.hasNext() == false) goto L81;
        final a r13 = (a) r16.next();
        if (r13.b != RichMediaOverlayAlignment.START) goto L54;
        LinearLayout r14 = r3.f;
        if (r14 != null) goto L57;
        r14 = new LinearLayout(r3.getContext());
        r14.setOrientation(0);
        r14.setGravity(16);
        r14.setVisibility(r8);
        r3.f = r14;
        r3.addView(r14, w.b(8388611));
    L57:
        Object r17 = r14;
        final String r18 = r10.a;
        if (r13.d == null) goto L64;
        final AppCompatTextView r19 = new AppCompatTextView(r3.getContext());
        Integer r20 = r13.d;
        if (r20 == null) goto L62;
        r19.setText(r20.intValue());
    L62:
        r19.setTextColor(-1);
        r19.setTextSize(12.0f);
        r19.setGravity(17);
        r19.setBackground(w.a());
        r19.setPadding(i5.c(), 0, i5.c(), 0);
        e1.d(r19, new u(r2, r18, r13, r19));
        final a r21 = r13;
    L74:
        if (r21.d == null) goto L76;
        int r22 = -2;
    L77:
        LinearLayout.LayoutParams r23 = new LinearLayout.LayoutParams(r22, i5.O());
        if (r17.getChildCount() <= 0) goto L80;
        r23.setMarginStart(i5.Y());
    L80:
        Unit r24 = Unit.INSTANCE;
        r17.addView(r19, r23);
        r8 = 8;
        goto L48
    L76:
        r22 = i5.O();
        goto L77
    L64:
        if (r13.e == false) goto L69;
        final AppCompatTextView r25 = new FrameLayout(r3.getContext());
        r25.setBackground(w.a());
        final AppCompatImageView r26 = new AppCompatImageView(r25.getContext());
        Integer r27 = r13.c;
        if (r27 == null) goto L68;
        r26.setImageResource(r27.intValue());
    L68:
        r26.setColorFilter(-1);
        r26.setScaleType(ImageView.ScaleType.CENTER);
        r26.setPadding(i5.n0(), i5.n0(), i5.n0(), i5.n0());
        final ProgressBar r110 = new ProgressBar(r25.getContext());
        r110.setVisibility(r8);
        r110.setIndeterminateTintList(ColorStateList.valueOf(-1));
        r110.setPadding(i5.n0(), i5.n0(), i5.n0(), i5.n0());
        r25.addView(r26, new FrameLayout.LayoutParams(i5.O(), i5.O()));
        r25.addView(r110, new FrameLayout.LayoutParams(i5.O(), i5.O()));
        e1.d(r25, new n(r110, r26, r2, r18, r13, r25));
        r19 = r25;
        r21 = r13;
        goto L74
    L69:
        r19 = new AppCompatImageView(r3.getContext());
        r21 = r13;
        Integer r30 = r21.c;
        if (r30 == null) goto L72;
        r19.setImageResource(r30.intValue());
    L72:
        r19.setColorFilter(-1);
        r19.setScaleType(ImageView.ScaleType.CENTER);
        r19.setBackground(w.a());
        r19.setPadding(i5.n0(), i5.n0(), i5.n0(), i5.n0());
        e1.d(r19, new t(r2, r18, r21, r19));
        goto L74
    L54:
        r14 = r3.g;
        if (r14 != null) goto L57;
        r14 = new LinearLayout(r3.getContext());
        r14.setOrientation(0);
        r14.setGravity(16);
        r14.setVisibility(r8);
        r3.g = r14;
        r3.addView(r14, w.b(8388613));
        goto L57
    L81:
        LinearLayout r31 = r3.f;
        if (r31 != null) goto L84;
    L88:
        LinearLayout r32 = r3.g;
        if (r32 == null) goto L96;
        if (r32.getChildCount() <= 0) goto L93;
        int r33 = 0;
    L94:
        r32.setVisibility(r33);
        goto L96
    L93:
        r33 = 8;
    L96:
        if (r10.e != RichMediaKind.VIDEO) goto L98;
        boolean r34 = true;
    L99:
        r3.c(r34);
        if (r10.l == true) goto L102;
        r3.a.setVisibility(0);
    L106:
        e1.d(r3, new d(r2, r10, r3));
        r2.f(r10.a, r3, r10.g);
        ExposureTrackerExtKt.c(r3);
        ExposeXTrackerExtKt.e(r3);
        r3.k = null;
        o r35 = new o(r3, r10, r2);
        r3.j = r35;
        if (r10.n == false) goto L110;
        r3.k = new e(r3, r10, r2);
    L110:
        r35.invoke();
        e r36 = r3.k;
        if (r36 == null) goto L119;
        r36.invoke();
        return;
    L119:
        return;
    L102:
        VideoPlayView r37 = r3.b;
        if (r37 != null) goto L105;
        r37 = new VideoPlayView(r3.getContext(), null, 6, 0);
        r3.b = r37;
        r3.addView(r37, 1, new FrameLayout.LayoutParams(-1, -1));
    L105:
        e1.d(r37, new p(r2, r10, r3));
        r37.setOnLongClickListener(new q(r3));
        r2.i(r10.a, r37, new r(r3, r10, r37), new s(r3, r10));
        goto L106
    L98:
        r34 = false;
        goto L99
    L84:
        if (r31.getChildCount() <= 0) goto L86;
        int r38 = 0;
    L87:
        r31.setVisibility(r38);
        goto L88
    L86:
        r38 = 8;
        goto L87
    L36:
        AppCompatTextView r39 = r3.e;
        if (r39 != null) goto L39;
        r39 = new AppCompatTextView(r3.getContext());
        r39.setTextColor(-1);
        r39.setTextSize(14.0f);
        r39.setMaxLines(1);
        r39.setEllipsize(TextUtils.TruncateAt.END);
        r39.setIncludeFontPadding(false);
        r3.e = r39;
        FrameLayout.LayoutParams r40 = new FrameLayout.LayoutParams(-1, -2, 8388691);
        r40.setMarginStart(i5.c());
        r40.setMarginEnd(i5.c());
        r40.bottomMargin = i5.c();
        Unit r41 = Unit.INSTANCE;
        r3.addView(r39, r40);
    L39:
        r39.setText(r7);
        r39.setVisibility(0);
        goto L40
    L22:
        MarkdownSourceImageView r42 = r3.c;
        if (r42 != null) goto L25;
        r42 = new MarkdownSourceImageView(r3.getContext());
        r42.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
        r3.c = r42;
        r3.addView(r42, w.e(RichMediaOverlayAlignment.START));
    L25:
        r42.setController(null);
        r42.setOnClickListener(null);
        r42.setLayoutParams(w.e(r5.a()));
        if ((r5 instanceof d0.b) == false) goto L29;
        MarkdownSourceImageView.f(r42, ((d0.b) r5).a, null, null, 6);
        goto L31
    L29:
        if ((r5 instanceof d0.a) == false) goto L115;
        r42.setVisibility(0);
        IMessageImageLoaderService.a.b(MessageImageLoader.a, r15, MessageImageType.IMAGE, r42, ((d0.a) r5).a, "markdown.media_source_icon", Integer.valueOf(i5.q()), Integer.valueOf(i5.q()), null, null, null, false, 1920);
        goto L31
    L115:
        throw new NoWhenBranchMatchedException();
    L12:
        MessageImageLoader r111 = MessageImageLoader.a;
        String r112 = r10.d;
        if (r10.e != RichMediaKind.VIDEO) goto L15;
        MessageImageType r43 = MessageImageType.VIDEO;
    L16:
        IMessageImageLoaderService.a.b(r111, r112, r43, r3.a, r10.f, r10.h, Integer.valueOf(r10.g.getWidth()), Integer.valueOf(r10.g.getHeight()), null, null, null, r10.m, 896);
        goto L17
    L15:
        r43 = MessageImageType.IMAGE;
        goto L16
    L8:
        r4 = false;
        goto L10
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        int r0 = RichMediaItemViewHolder.b;
        Intrinsics.checkNotNullParameter(r2, "parent");
        return new RichMediaItemViewHolder(new w(r2.getContext()));
    }
}
