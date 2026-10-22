package com.larus.uaigc.chat.block.widget.video;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.VideoData;
import com.larus.uaigc.impl.databinding.LarusWidgetCreationBlockVideoItemBinding;
import com.larus.uaigc.impl.databinding.LarusWidgetMarkdownCreationSingleVideoBinding;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002BW\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\r0\n\u0012\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\n¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010&\u001a\u00020\u000fH\u0016J\u0010\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u000bH\u0016J\u0018\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+H\u0016J\u0018\u0010-\u001a\u00020\r2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+H\u0002J$\u0010.\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020+0/2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+H\u0002J\b\u00100\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\r0\nX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010 \u001a\u0004\b#\u0010$¨\u00061"}, d2 = {"Lcom/larus/uaigc/chat/block/widget/video/VideoItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/larus/uaigc/chat/block/widget/IItemViewBinder;", "rootBinding", "Lcom/larus/uaigc/impl/databinding/LarusWidgetCreationBlockVideoItemBinding;", "lifecycleScope", "Lkotlinx/coroutines/CoroutineScope;", "createBlockConfig", "Lcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;", "onItemClick", "Lkotlin/Function2;", "Lcom/larus/uaigc/chat/block/widget/CreationItemData;", "Lcom/larus/uaigc/bean/chat/VideoPlayParams;", "", "itemLongClickListenerBinder", "Landroid/view/View;", "<init>", "(Lcom/larus/uaigc/impl/databinding/LarusWidgetCreationBlockVideoItemBinding;Lkotlinx/coroutines/CoroutineScope;Lcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "curViewBinder", "curBindData", "Lcom/larus/uaigc/chat/block/widget/VideoItemData;", "getCurBindData", "()Lcom/larus/uaigc/chat/block/widget/VideoItemData;", "setCurBindData", "(Lcom/larus/uaigc/chat/block/widget/VideoItemData;)V", "binding", "Lcom/larus/uaigc/impl/databinding/LarusWidgetMarkdownCreationSingleVideoBinding;", "failedBinder", "Lcom/larus/uaigc/chat/block/widget/video/VideoFailedViewBinder;", "getFailedBinder", "()Lcom/larus/uaigc/chat/block/widget/video/VideoFailedViewBinder;", "failedBinder$delegate", "Lkotlin/Lazy;", "successBinder", "Lcom/larus/uaigc/chat/block/widget/video/VideoSuccessViewBinder;", "getSuccessBinder", "()Lcom/larus/uaigc/chat/block/widget/video/VideoSuccessViewBinder;", "successBinder$delegate", "getBinderView", "bindData", "data", "updateSize", "width", "", "height", "applyScaledSize", "calculateScaledSize", "Lkotlin/Pair;", "onRecycle", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class VideoItemViewHolder extends RecyclerView.ViewHolder implements cz9.g {
    public static final /* synthetic */ int j = 0;
    public final CoroutineScope a;
    public final kc8.q b;
    public final Function2<cz9.b, iy9.b, Unit> c;
    public final Function2<cz9.b, View, Unit> d;
    public cz9.g e;
    public cz9.o f;
    public final LarusWidgetMarkdownCreationSingleVideoBinding g;
    public final Lazy h;
    public final Lazy i;

    public static final class a implements b {
        public final CoroutineScope a;
        public final LarusWidgetMarkdownCreationSingleVideoBinding b;
        public final kc8.q c;
        public final Function2<cz9.b, iy9.b, Unit> d;
        public final Function2<cz9.b, View, Unit> e;

        @Override // com.larus.uaigc.chat.block.widget.video.b
        public final Function2<cz9.b, View, Unit> a() {
            return this.e;
        }

        @Override // com.larus.uaigc.chat.block.widget.video.b
        public final Function2<cz9.b, iy9.b, Unit> b() {
            return this.d;
        }

        @Override // com.larus.uaigc.chat.block.widget.video.b
        public final CoroutineScope c() {
            return this.a;
        }

        @Override // com.larus.uaigc.chat.block.widget.video.b
        public final LarusWidgetMarkdownCreationSingleVideoBinding d0() {
            return this.b;
        }

        @Override // com.larus.uaigc.chat.block.widget.video.b
        public final kc8.q g() {
            return this.c;
        }

        public a(VideoItemViewHolder r2) {
            this.a = r2.a;
            this.b = r2.g;
            this.c = r2.b;
            this.d = r2.c;
            this.e = r2.d;
        }
    }

    @Override // cz9.g
    public final View N0() {
        return this.g.a;
    }

    @Override // cz9.g
    public final void f() {
        cz9.g r0 = this.e;
        if ((r0 instanceof VideoSuccessViewBinder) == false) goto L5;
        VideoSuccessViewBinder r1 = (VideoSuccessViewBinder) r0;
    L6:
        if (r1 == null) goto L9;
        r1.f();
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // cz9.g
    public final void p2(cz9.b r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        if ((r5 instanceof cz9.o) == true) goto L5;
        return;
    L5:
        cz9.o r0 = (cz9.o) r5;
        this.f = r0;
        updateSize(r0.b, r0.c);
        CreationItem r1 = r0.d;
        cz9.g r2 = null;
        if (r1 == null) goto L10;
        VideoData r3 = r1.video;
        if (r3 == null) goto L10;
        Integer r4 = r3.status;
    L11:
        if (r4 != null) goto L14;
    L21:
        if (r4 != null) goto L24;
        return;
    L24:
        if (r4.intValue() != 4) goto L33;
        VideoFailedViewBinder r6 = (VideoFailedViewBinder) this.h.getValue();
        cz9.g r7 = this.e;
        if ((r7 instanceof VideoSuccessViewBinder) == false) goto L28;
        r2 = (VideoSuccessViewBinder) r7;
    L28:
        if (r2 == null) goto L30;
        r2.p2(r5);
    L30:
        this.e = r6;
        return;
    L33:
        return;
    L14:
        if (r4.intValue() != 3) goto L21;
        VideoSuccessViewBinder r8 = (VideoSuccessViewBinder) this.i.getValue();
        cz9.g r9 = this.e;
        if ((r9 instanceof VideoFailedViewBinder) == false) goto L18;
        r2 = (VideoFailedViewBinder) r9;
    L18:
        if (r2 == null) goto L20;
        r2.p2(r5);
    L20:
        this.e = r8;
        r8.p2(r5);
        return;
    L10:
        r4 = null;
        goto L11
    }

    public final void T3(int r10, int r11) {
        if (r10 <= 0) goto L69;
        if (r11 <= 0) goto L69;
        Object r0 = ((RecyclerView.ViewHolder) this).itemView.getParent();
        Object r2 = null;
        if ((r0 instanceof View) == false) goto L8;
        View r1 = (View) r0;
    L9:
        if (r1 == null) goto L11;
        Integer r3 = Integer.valueOf(r1.getWidth() - (r1.getPaddingLeft() + r1.getPaddingRight()));
    L12:
        if (r1 == null) goto L14;
        Integer r4 = Integer.valueOf(r1.getHeight() - (r1.getPaddingTop() + r1.getPaddingBottom()));
    L15:
        boolean r5 = false;
        Iterator r6 = CollectionsKt.listOf(new Integer[]{r3, Integer.valueOf(((RecyclerView.ViewHolder) this).itemView.getWidth()), Integer.valueOf(((RecyclerView.ViewHolder) this).itemView.getMeasuredWidth())}).iterator();
    L17:
        if (r6.hasNext() == false) goto L27;
        Object r7 = r6.next();
        Integer r8 = (Integer) r7;
        if (r8 == null) goto L21;
        int r9 = r8.intValue();
    L22:
        if (r9 <= 0) goto L24;
        boolean r12 = true;
    L25:
        if (r12 == false) goto L17;
    L28:
        Integer r13 = (Integer) r7;
        Iterator r14 = CollectionsKt.listOf(new Integer[]{r4, Integer.valueOf(((RecyclerView.ViewHolder) this).itemView.getHeight()), Integer.valueOf(((RecyclerView.ViewHolder) this).itemView.getMeasuredHeight())}).iterator();
    L30:
        if (r14.hasNext() == false) goto L40;
        Object r15 = r14.next();
        Integer r16 = (Integer) r15;
        if (r16 == null) goto L34;
        int r17 = r16.intValue();
    L35:
        if (r17 <= 0) goto L37;
        boolean r18 = true;
    L38:
        if (r18 == false) goto L30;
        r2 = r15;
        goto L40
    L37:
        r18 = false;
        goto L38
    L34:
        r17 = 0;
    L40:
        Integer r19 = (Integer) r2;
        if (r13 == null) goto L43;
        int r20 = r13.intValue();
    L44:
        if (1 > r20) goto L47;
        if (r20 >= r10) goto L47;
        boolean r21 = true;
    L48:
        float r22 = 0.0f;
        if (r21 == false) goto L54;
        if (r13 == null) goto L52;
        float r23 = r13.intValue();
    L53:
        float r24 = Math.min(1.0f, r23 / r10);
    L55:
        if (r19 == null) goto L57;
        int r25 = r19.intValue();
    L58:
        if (1 > r25) goto L61;
        if (r25 >= r11) goto L61;
        r5 = true;
    L61:
        if (r5 == false) goto L66;
        if (r19 == null) goto L64;
        r22 = r19.intValue();
    L64:
        r24 = Math.min(r24, r22 / r11);
    L66:
        if (r24 < 1.0f) goto L68;
        Pair r110 = TuplesKt.to(Integer.valueOf(r10), Integer.valueOf(r11));
    L70:
        int r111 = ((Number) r110.component1()).intValue();
        int r112 = ((Number) r110.component2()).intValue();
        View r26 = this.g.a;
        ViewGroup.LayoutParams r27 = r26.getLayoutParams();
        if (r27 == null) goto L79;
        r27.width = r111;
        r27.height = r112;
        r26.setLayoutParams(r27);
        VideoPlayView r28 = this.g.i;
        ViewGroup.LayoutParams r29 = r28.getLayoutParams();
        if (r29 == null) goto L77;
        r29.width = r111;
        r29.height = r112;
        r28.setLayoutParams(r29);
        return;
    L77:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L79:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L68:
        r110 = TuplesKt.to(Integer.valueOf(MathKt.roundToInt(r10 * r24)), Integer.valueOf(MathKt.roundToInt(r11 * r24)));
        goto L70
    L57:
        r25 = 0;
        goto L58
    L52:
        r23 = 0.0f;
        goto L53
    L54:
        r24 = 1.0f;
    L47:
        r21 = false;
        goto L48
    L43:
        r20 = 0;
        goto L44
    L24:
        r12 = false;
        goto L25
    L21:
        r9 = 0;
        goto L22
    L27:
        r7 = null;
        goto L28
    L14:
        r4 = null;
        goto L15
    L11:
        r3 = null;
        goto L12
    L8:
        r1 = null;
    L69:
        r110 = TuplesKt.to(Integer.valueOf(r10), Integer.valueOf(r11));
        goto L70
    }

    @Override // cz9.g
    public final void updateSize(final int r3, final int r4) {
        T3(r3, r4);
        ((RecyclerView.ViewHolder) this).itemView.post(new l(this, r3, r4));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VideoItemViewHolder(LarusWidgetCreationBlockVideoItemBinding r2, CoroutineScope r3, kc8.q r4, Function2<? super cz9.b, ? super iy9.b, Unit> r5, Function2<? super cz9.b, ? super View, Unit> r6) {
        Intrinsics.checkNotNullParameter(r2, "rootBinding");
        Intrinsics.checkNotNullParameter(r3, "lifecycleScope");
        Intrinsics.checkNotNullParameter(r5, "onItemClick");
        Intrinsics.checkNotNullParameter(r6, "itemLongClickListenerBinder");
        super(r2.a);
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.g = LarusWidgetMarkdownCreationSingleVideoBinding.a(r2.a);
        LazyThreadSafetyMode r7 = LazyThreadSafetyMode.NONE;
        this.h = LazyKt.lazy(r7, new m(this));
        this.i = LazyKt.lazy(r7, new n(this));
    }
}
