package com.larus.bmhome.chat.layout.holder.image;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageContentData;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageEntity;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageItem;
import com.larus.bmhome.chat.layout.holder.progressloading.ISketchLoadingController;
import com.larus.bmhome.chat.layout.holder.progressloading.SketchLoadingController;
import com.larus.bmhome.chat.plugin.image4.view.ImageViewWithLastMotion;
import com.larus.bmhome.databinding.LarusFlowMessageCardSingleImageBinding;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.kmp.chat.TemplateInfo;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n1 extends BaseImageBox {
    public int F;
    public final LarusFlowMessageCardSingleImageBinding G;
    public final List<ImageViewWithLastMotion> H;
    public final SketchLoadingController I;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.bigimg.e
    public final void b(int r1, zo8.a r2) {
    }

    @Override // com.larus.bmhome.chat.layout.holder.image.BaseImageBox
    public ViewGroup getImageParentScrollView() {
        return null;
    }

    @Override // com.larus.bmhome.chat.layout.holder.image.BaseImageBox
    public String getLogTag() {
        return "single_img";
    }

    @Override // com.larus.bmhome.chat.layout.holder.image.BaseImageBox
    public TextView getRegenerateBtn() {
        return this.G.b;
    }

    @Override // com.larus.bmhome.chat.layout.holder.image.BaseImageBox
    public final void x() {
        Iterator<T> r0 = getFailedIndexAndUrl().entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) r0.next();
        g0.a.a(this, (SimpleDraweeView) ListProtector.get(getImageViewList(), ((Number) r1.getKey()).intValue()), ((df8.c) r1.getValue()).a, ((df8.c) r1.getValue()).b, ((Number) r1.getKey()).intValue(), true);
        goto L4
    L6:
        getFailedIndexAndUrl().clear();
    }

    @Override // com.larus.bmhome.chat.layout.holder.image.BaseImageBox, com.larus.bmhome.chat.layout.item.i
    public int getBoxType() {
        return this.F;
    }

    @Override // com.larus.bmhome.chat.layout.holder.image.BaseImageBox
    public List<ImageViewWithLastMotion> getImageViewList() {
        return this.H;
    }

    public n1(Context r13) {
        Intrinsics.checkNotNullParameter(r13, "context");
        super(r13);
        this.F = -1;
        View r0 = LayoutInflater.from(r13).inflate(2131562338, this, false);
        addView(r0);
        int r1 = 2131375019;
        ViewStub r3 = (ViewStub) ViewBindings.findChildViewById(r0, 2131375019);
        if (r3 == null) goto L25;
        r1 = 2131384158;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r0, 2131384158);
        if (r7 == null) goto L25;
        r1 = 2131386658;
        ImageViewWithLastMotion r10 = (ImageViewWithLastMotion) ViewBindings.findChildViewById(r0, 2131386658);
        if (r10 == null) goto L25;
        r1 = 2131386659;
        FrameLayout r11 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131386659);
        if (r11 == null) goto L25;
        LinearLayout r2 = (LinearLayout) r0;
        this.G = new LarusFlowMessageCardSingleImageBinding(r2, r3, r7, r10, r11);
        this.H = CollectionsKt.listOf(r10);
        this.I = new SketchLoadingController(r3);
        ViewGroup.LayoutParams r4 = getLayoutParams();
        if (r4 == null) goto L23;
        ConstraintLayout.LayoutParams r5 = (ConstraintLayout.LayoutParams) r4;
        r5.setMarginStart(getResources().getDimensionPixelSize(2131167568));
        r5.setMarginEnd(0);
        setLayoutParams(r5);
        setMaxWidth(Math.min(getMaxWidth(), r13.getResources().getDimensionPixelSize(v19.c.b(2130971486, r13, 2131167341))));
        Resources r14 = r13.getResources();
        int r15 = RangesKt.coerceAtMost((WindowDisplayMetricsOverride.apply(r14, r14.getDisplayMetrics()).widthPixels * 286) / 390, getMaxWidth());
        ViewGroup.LayoutParams r6 = r11.getLayoutParams();
        if (r6 == null) goto L21;
        r6.width = r15;
        r6.height = r15;
        r11.setLayoutParams(r6);
        ViewGroup.LayoutParams r16 = r2.getLayoutParams();
        if (r16 == null) goto L19;
        LinearLayout.LayoutParams r17 = (LinearLayout.LayoutParams) r16;
        r17.setMarginStart(getResources().getDimensionPixelSize(2131167568));
        r17.setMarginEnd(0);
        r2.setLayoutParams(r17);
        return;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L23:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }

    public final View d(int r1) {
        return this.G.c;
    }

    @Override // com.larus.bmhome.chat.layout.item.k
    public final void o(int r2) {
        super.o(r2);
        Integer r3 = getCurrentLoadingProgress();
        if (r3 == null) goto L6;
        int r4 = r3.intValue();
        this.I.setProgress(r4);
        return;
    }

    @Override // com.larus.bmhome.chat.layout.holder.image.BaseImageBox, com.larus.bmhome.chat.layout.item.i
    public void setBoxType(int r1) {
        this.F = r1;
    }

    @Override // com.larus.bmhome.chat.layout.holder.image.BaseImageBox, com.larus.bmhome.chat.layout.item.k
    public final void n(Message r3, boolean r4) {
        super.n(r3, r4);
        com.larus.utils.e1.o(this.G.c);
        ISketchLoadingController.a.b(this.I, false, null, 0, 7);
        Integer r5 = getCurrentLoadingProgress();
        if (r5 == null) goto L6;
        int r6 = r5.intValue();
        this.I.setProgress(r6);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r17v0, types: [com.larus.bmhome.chat.layout.holder.image.BaseImageBox, com.larus.bmhome.chat.layout.holder.image.g0, com.larus.bmhome.chat.layout.holder.image.n1] */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v3 */
    @Override // com.larus.bmhome.chat.layout.holder.image.BaseImageBox
    public final void r(ImageContentData r18, Message r19, BotModel r20, com.larus.bmhome.chat.api.q0 r21, CoroutineScope r22, Function1<? super Message, ? extends Map<String, ? extends Object>> r23) {
        Intrinsics.checkNotNullParameter(r19, "message");
        this.I.hide();
        Iterator r0 = getImageViewList().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        z19.j r1 = (ImageViewWithLastMotion) r0.next();
        Intrinsics.checkNotNull(r1);
        com.larus.utils.e1.x(r1);
        goto L4
    L6:
        getFailedIndexAndUrl().clear();
        if (r18 == null) goto L11;
        List<ImageItem> r2 = r18.getImageList();
        if (r2 == null) goto L11;
        List r3 = CollectionsKt.take(r2, 1);
    L12:
        setOriginImageList(r3);
        List<ImageItem> r4 = getOriginImageList();
        if (r4 == null) goto L20;
        ?? r5 = new ArrayList();
        Iterator r6 = r4.iterator();
    L16:
        if (r6.hasNext() == false) goto L21;
        String r7 = df8.b.a((ImageItem) r6.next());
        if (r7 == null) goto L16;
        r5.add(r7);
    L21:
        ?? r13 = r5;
        List<ImageItem> r8 = getOriginImageList();
        if (r8 != null) goto L24;
        r8 = CollectionsKt.emptyList();
    L24:
        setChatDisplayImageList(r8);
        List<ImageItem> r9 = getChatDisplayImageList();
        ArrayList r10 = new ArrayList();
        Iterator r11 = r9.iterator();
    L26:
        if (r11.hasNext() == false) goto L30;
        Object r12 = r11.next();
        if (df8.b.c((ImageItem) r12) == false) goto L26;
        r10.add(r12);
        goto L26
    L30:
        setBigDisplayImageList(r10);
        Iterator r14 = getImageViewList().iterator();
        int r15 = 0;
    L32:
        if (r14.hasNext() == false) goto L69;
        Object r16 = r14.next();
        int r17 = r15 + 1;
        if (r15 >= 0) goto L36;
        CollectionsKt.throwIndexOverflow();
    L36:
        ImageViewWithLastMotion r24 = (ImageViewWithLastMotion) r16;
        int r25 = Integer.valueOf(r15).intValue();
        List<ImageItem> r26 = getOriginImageList();
        if (r26 != null) goto L39;
    L45:
        ImageItem r27 = null;
    L46:
        TemplateInfo.TemplateInfo r28 = (TemplateInfo.TemplateInfo) getGetTemplateByIndex().invoke(Integer.valueOf(r15));
        if (r27 == null) goto L49;
        String r29 = df8.b.a(r27);
    L51:
        if (r29 == null) goto L53;
        Uri r30 = com.larus.image.loader.b0.a(r29, "chat.single.img", false, false, 6);
    L54:
        if (r27 == null) goto L60;
        ImageEntity r31 = r27.getImageThumb();
        if (r31 == null) goto L60;
        String r32 = r31.getUrl();
        if (r32 == null) goto L60;
        Uri r33 = com.larus.image.loader.b0.a(r32, "chat.single.img_thumb", false, false, 6);
    L61:
        Intrinsics.checkNotNull(r24);
        g0.a.a(this, r24, r33, r30, r15, false);
        int r110 = Math.max(0, CollectionsKt.indexOf(r13, r29));
        if (r27 == null) goto L67;
        ImageEntity r34 = r27.getImageOrigin();
        if (r34 == null) goto L67;
        String r35 = r34.getUrl();
        if (r35 == null) goto L67;
    L68:
        e(r24, r27, r28, r29, r35, r110, r20, r21, r22, r23);
        r15 = r17;
    L67:
        r35 = "";
    L60:
        r33 = null;
        goto L61
    L53:
        r30 = null;
        goto L54
    L49:
        r29 = null;
        goto L51
    L39:
        if (r26.size() <= r25) goto L41;
        ImageItem r36 = (ImageItem) ListProtector.get(r26, r25);
    L42:
        if (r36 == null) goto L45;
        r27 = r36;
        goto L46
    L41:
        r36 = null;
        goto L42
    L69:
        return;
    L20:
        r5 = CollectionsKt.emptyList();
    L11:
        r3 = null;
        goto L12
    }
}
