package com.larus.bmhome.chat.layout.holder.image;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageContentData;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageEntity;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageItem;
import com.larus.bmhome.chat.layout.holder.progressloading.ISketchLoadingController;
import com.larus.bmhome.chat.layout.holder.progressloading.ImageLoadingDrawPartType;
import com.larus.bmhome.chat.layout.holder.progressloading.SketchLoadingController;
import com.larus.bmhome.chat.plugin.image4.view.ImageViewWithLastMotion;
import com.larus.bmhome.databinding.LarusImage4CardBinding;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.kmp.chat.TemplateInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k0 extends BaseImageBox {
    public static final int J = 0;
    public static final Lazy<Boolean> K = null;
    public final String F;
    public final LarusImage4CardBinding G;
    public final List<ImageViewWithLastMotion> H;
    public final List<SketchLoadingController> I;

    public static final class a {
    }

    @Override // com.larus.bmhome.bigimg.e
    public final void b(int r1, zo8.a r2) {
    }

    @Override // com.larus.bmhome.chat.layout.holder.image.BaseImageBox
    public ViewGroup getImageParentScrollView() {
        return null;
    }

    static {
        J = i5.y0(2131167548);
        K = LazyKt.lazy(new j0());
    }

    @Override // com.larus.bmhome.chat.layout.holder.image.BaseImageBox
    public TextView getRegenerateBtn() {
        return this.G.c;
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

    @Override // com.larus.bmhome.chat.layout.holder.image.BaseImageBox
    public List<ImageViewWithLastMotion> getImageViewList() {
        return this.H;
    }

    @Override // com.larus.bmhome.chat.layout.holder.image.BaseImageBox
    public String getLogTag() {
        return this.F;
    }

    public k0(Context r25) {
        Intrinsics.checkNotNullParameter(r25, "context");
        super(r25);
        this.F = "img_4";
        View r1 = LayoutInflater.from(r25).inflate(2131562454, this, false);
        addView(r1);
        int r3 = 2131374939;
        GridLayout r8 = (GridLayout) ViewBindings.findChildViewById(r1, 2131374939);
        if (r8 == null) goto L29;
        r3 = 2131375116;
        ImageViewWithLastMotion r5 = (ImageViewWithLastMotion) ViewBindings.findChildViewById(r1, 2131375116);
        if (r5 == null) goto L29;
        r3 = 2131375117;
        ViewStub r15 = (ViewStub) ViewBindings.findChildViewById(r1, 2131375117);
        if (r15 == null) goto L29;
        r3 = 2131375118;
        ImageViewWithLastMotion r18 = (ImageViewWithLastMotion) ViewBindings.findChildViewById(r1, 2131375118);
        if (r18 == null) goto L29;
        r3 = 2131375119;
        ViewStub r14 = (ViewStub) ViewBindings.findChildViewById(r1, 2131375119);
        if (r14 == null) goto L29;
        r3 = 2131375120;
        ImageViewWithLastMotion r19 = (ImageViewWithLastMotion) ViewBindings.findChildViewById(r1, 2131375120);
        if (r19 == null) goto L29;
        r3 = 2131375121;
        ViewStub r13 = (ViewStub) ViewBindings.findChildViewById(r1, 2131375121);
        if (r13 == null) goto L29;
        r3 = 2131375122;
        ImageViewWithLastMotion r20 = (ImageViewWithLastMotion) ViewBindings.findChildViewById(r1, 2131375122);
        if (r20 == null) goto L29;
        r3 = 2131375123;
        ViewStub r12 = (ViewStub) ViewBindings.findChildViewById(r1, 2131375123);
        if (r12 == null) goto L29;
        r3 = 2131384158;
        TextView r17 = (TextView) ViewBindings.findChildViewById(r1, 2131384158);
        if (r17 == null) goto L29;
        this.G = new LarusImage4CardBinding((LinearLayout) r1, r8, r5, r15, r18, r14, r19, r13, r20, r12, r17);
        this.H = CollectionsKt.listOf(new ImageViewWithLastMotion[]{r5, r18, r19, r20});
        this.I = CollectionsKt.listOf(new SketchLoadingController[]{new SketchLoadingController(r15), new SketchLoadingController(r14), new SketchLoadingController(r13), new SketchLoadingController(r12)});
        setMaxWidth(Math.min(getMaxWidth(), r25.getResources().getDimensionPixelSize(2131167341)));
        ViewGroup.LayoutParams r2 = getLayoutParams();
        if (r2 == null) goto L27;
        ConstraintLayout.LayoutParams r4 = (ConstraintLayout.LayoutParams) r2;
        r4.setMarginStart(getResources().getDimensionPixelSize(2131167568));
        r4.setMarginEnd(0);
        setLayoutParams(r4);
        return;
    L27:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(r1.getResources().getResourceName(r3)));
    }

    public final void B(ImageContentData r6) {
        int r0 = getMaxWidth();
        int r1 = getMaxWidth();
        if (((Boolean) K.getValue()).booleanValue() == false) goto L27;
        int r2 = getMaxWidth();
        int r3 = J;
        int r4 = (int) (((r2 - r3) * 1.3333334f) + r3);
        if (r6 == null) goto L22;
        List<ImageItem> r7 = r6.getImageList();
        if (r7 == null) goto L22;
        ImageItem r8 = (ImageItem) CollectionsKt.getOrNull(r7, 0);
        if (r8 == null) goto L22;
        ImageEntity r9 = r8.getImageOrigin();
        if (r9 == null) goto L22;
        if (r9.getHeight() <= 0) goto L22;
        if (r9.getWidth() <= 0) goto L22;
        float r5 = r9.getHeight() / r9.getWidth();
        if (r5 <= 1.7777778f) goto L20;
        r5 = 1.7777778f;
    L20:
        if (r5 >= 0.5625f) goto L24;
        r5 = 0.5625f;
    L24:
        if (r5 > 1.3333334f) goto L26;
        r0 = getMaxWidth();
        r1 = (int) (((getMaxWidth() - r3) * r5) + r3);
        goto L27
    L26:
        int r10 = (int) (((r4 - r3) / r5) + r3);
        r1 = r4;
        r0 = r10;
    L22:
        r5 = 1.0f;
    L27:
        GridLayout r11 = this.G.b;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        if (r12 == null) goto L32;
        LinearLayout.LayoutParams r13 = (LinearLayout.LayoutParams) r12;
        r13.width = r0;
        r13.height = r1;
        r11.setLayoutParams(r13);
        int r14 = J;
        setImageSizeOption(new ResizeOptions((r0 - r14) >> 1, (r1 - r14) >> 1));
        return;
    L32:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }

    public final View d(int r2) {
        int r3 = z(r2);
        if (r3 >= 0) goto L5;
        return null;
    L5:
        if (r3 < getImageViewList().size()) goto L8;
        return null;
    L8:
        return (View) ListProtector.get(getImageViewList(), r3);
    }

    @Override // com.larus.bmhome.chat.layout.item.k
    public final void o(int r3) {
        super.o(r3);
        Iterator<T> r0 = this.I.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((SketchLoadingController) r0.next()).setProgress(r3);
        goto L4
    }

    @Override // com.larus.bmhome.chat.layout.holder.image.BaseImageBox, com.larus.bmhome.chat.layout.item.k
    public final void n(Message r10, boolean r11) {
        super.n(r10, r11);
        B(ImageHolderDispatcher.a(r10));
        Iterator<T> r12 = getImageViewList().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        z19.j r13 = (ImageViewWithLastMotion) r12.next();
        Intrinsics.checkNotNull(r13);
        com.larus.utils.e1.o(r13);
        goto L4
    L6:
        Iterator<T> r14 = this.I.iterator();
        int r0 = 0;
    L8:
        if (r14.hasNext() == false) goto L35;
        Object r1 = r14.next();
        int r2 = r0 + 1;
        if (r0 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        SketchLoadingController r3 = (SketchLoadingController) r1;
        if (r0 == 0) goto L21;
        if (r0 == 1) goto L20;
        if (r0 == 2) goto L19;
        if (r0 == 3) goto L18;
        ImageLoadingDrawPartType r6 = ImageLoadingDrawPartType.LEFT_TOP_PART;
    L22:
        ISketchLoadingController.a.b(r3, true, r6, 0, 4);
        Integer r7 = getCurrentLoadingProgress();
        if (r7 == null) goto L25;
        r3.setProgress(r7.intValue());
    L25:
        if (r0 == 0) goto L33;
        if (r0 == 1) goto L32;
        if (r0 == 2) goto L31;
        if (r0 != 3) goto L34;
        SketchLoadingController.e(r3, 0.0f, 0.0f, i5.r0(), 0.0f, 11);
    L34:
        r0 = r2;
        goto L8
    L31:
        SketchLoadingController.e(r3, 0.0f, 0.0f, 0.0f, i5.r0(), 7);
        goto L34
    L32:
        SketchLoadingController.e(r3, 0.0f, i5.r0(), 0.0f, 0.0f, 13);
        goto L34
    L33:
        SketchLoadingController.e(r3, i5.r0(), 0.0f, 0.0f, 0.0f, 14);
        goto L34
    L18:
        r6 = ImageLoadingDrawPartType.RIGHT_BOTTOM_PART;
        goto L22
    L19:
        r6 = ImageLoadingDrawPartType.LEFT_BOTTOM_PART;
        goto L22
    L20:
        r6 = ImageLoadingDrawPartType.RIGHT_TOP_PART;
        goto L22
    L21:
        r6 = ImageLoadingDrawPartType.LEFT_TOP_PART;
        goto L22
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r17v0, types: [com.larus.bmhome.chat.layout.holder.image.BaseImageBox, com.larus.bmhome.chat.layout.holder.image.g0, com.larus.bmhome.chat.layout.holder.image.k0] */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v4 */
    @Override // com.larus.bmhome.chat.layout.holder.image.BaseImageBox
    public final void r(ImageContentData r18, Message r19, BotModel r20, com.larus.bmhome.chat.api.q0 r21, CoroutineScope r22, Function1<? super Message, ? extends Map<String, ? extends Object>> r23) {
        Intrinsics.checkNotNullParameter(r19, "message");
        Iterator r0 = this.I.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((SketchLoadingController) r0.next()).hide();
        goto L4
    L6:
        Iterator r1 = getImageViewList().iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        z19.j r2 = (ImageViewWithLastMotion) r1.next();
        Intrinsics.checkNotNull(r2);
        com.larus.utils.e1.x(r2);
        goto L8
    L10:
        B(r18);
        getFailedIndexAndUrl().clear();
        if (r18 == null) goto L15;
        List<ImageItem> r3 = r18.getImageList();
        if (r3 == null) goto L15;
        List r4 = CollectionsKt.take(r3, 4);
    L16:
        setOriginImageList(r4);
        List<ImageItem> r5 = getOriginImageList();
        if (r5 == null) goto L24;
        ?? r6 = new ArrayList();
        Iterator r7 = r5.iterator();
    L20:
        if (r7.hasNext() == false) goto L25;
        String r8 = df8.b.a((ImageItem) r7.next());
        if (r8 == null) goto L20;
        r6.add(r8);
    L25:
        ?? r13 = r6;
        List<ImageItem> r9 = getOriginImageList();
        if (r9 != null) goto L28;
        r9 = CollectionsKt.emptyList();
    L28:
        setChatDisplayImageList(r9);
        List<ImageItem> r10 = getChatDisplayImageList();
        ArrayList r11 = new ArrayList();
        Iterator r12 = r10.iterator();
    L30:
        if (r12.hasNext() == false) goto L34;
        Object r14 = r12.next();
        if (df8.b.c((ImageItem) r14) == false) goto L30;
        r11.add(r14);
        goto L30
    L34:
        setBigDisplayImageList(r11);
        Iterator r15 = getImageViewList().iterator();
        int r16 = 0;
    L36:
        if (r15.hasNext() == false) goto L71;
        Object r17 = r15.next();
        int r110 = r16 + 1;
        if (r16 >= 0) goto L40;
        CollectionsKt.throwIndexOverflow();
    L40:
        ImageViewWithLastMotion r24 = (ImageViewWithLastMotion) r17;
        int r25 = Integer.valueOf(r16).intValue();
        List<ImageItem> r26 = getOriginImageList();
        if (r26 != null) goto L43;
    L49:
        ImageItem r27 = null;
    L50:
        TemplateInfo.TemplateInfo r28 = (TemplateInfo.TemplateInfo) getGetTemplateByIndex().invoke(Integer.valueOf(r16));
        if (r27 == null) goto L53;
        String r29 = df8.b.a(r27);
    L55:
        if (r29 == null) goto L57;
        Uri r30 = com.larus.image.loader.b0.a(r29, "chat.4box", false, false, 6);
    L58:
        if (r27 == null) goto L62;
        String r31 = df8.b.b(r27);
        if (r31 == null) goto L62;
        Uri r32 = com.larus.image.loader.b0.a(r31, "chat.4box_thumb", false, false, 6);
    L63:
        Intrinsics.checkNotNull(r24);
        g0.a.a(this, r24, r32, r30, r16, false);
        int r111 = Math.max(0, CollectionsKt.indexOf(r13, r29));
        if (r27 == null) goto L69;
        ImageEntity r33 = r27.getImageOrigin();
        if (r33 == null) goto L69;
        String r34 = r33.getUrl();
        if (r34 == null) goto L69;
    L70:
        e(r24, r27, r28, r29, r34, r111, r20, r21, r22, r23);
        r16 = r110;
    L69:
        r34 = "";
    L62:
        r32 = null;
        goto L63
    L57:
        r30 = null;
        goto L58
    L53:
        r29 = null;
        goto L55
    L43:
        if (r26.size() <= r25) goto L45;
        ImageItem r35 = (ImageItem) ListProtector.get(r26, r25);
    L46:
        if (r35 == null) goto L49;
        r27 = r35;
        goto L50
    L45:
        r35 = null;
        goto L46
    L71:
        return;
    L24:
        r6 = CollectionsKt.emptyList();
    L15:
        r4 = null;
        goto L16
    }
}
