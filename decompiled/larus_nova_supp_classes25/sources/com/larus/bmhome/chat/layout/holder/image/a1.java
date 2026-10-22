package com.larus.bmhome.chat.layout.holder.image;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageContentData;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageEntity;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageItem;
import com.larus.bmhome.chat.list.cell.generate_image.GenerateImageCell;
import com.larus.bmhome.chat.list.cell.generate_image.GenerateImageScrollCell$a;
import com.larus.bmhome.chat.view.share.ConversationShareMessageListAdapter;
import com.larus.bmhome.databinding.LarusImageScrollCardBinding;
import com.larus.common_ui.view.ImageCardNestedScrollableHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.f3;
import com.larus.platform.kmp.chat.TemplateInfo;
import com.larus.platform.service.e2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import v19.i5;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a1 extends BaseImageBox {
    public static final Lazy<Boolean> P = null;
    public final b F;
    public ImageContentData G;
    public Message H;
    public ResizeOptions I;
    public final String J;
    public final LarusImageScrollCardBinding K;
    public final ImageScrollAdapter L;
    public final LinearLayoutManager M;
    public final Lazy N;
    public int O;

    public static final class a {
    }

    public interface b {
        BotModel a();

        com.larus.bmhome.chat.list.cell.generate_image.s b();

        ConversationShareMessageListAdapter c();
    }

    public static /* synthetic */ void getMaxWidth$annotations() {
    }

    static {
        P = LazyKt.lazy(new r0());
    }

    private final int getContainerWidth() {
        return ((Number) this.N.getValue()).intValue();
    }

    public final int B() {
        if (((Boolean) P.getValue()).booleanValue() == false) goto L7;
        e2 r0 = e2.a;
        if (r0.g() == r0.f()) goto L7;
        return (int) (f3.a.a() / 3.3f);
    L7:
        Message r1 = this.H;
        if (r1 == null) goto L12;
        boolean r2 = true;
        if (com.larus.bmhome.chat.bean.d.y(r1) != true) goto L12;
    L13:
        if (r2 == false) goto L16;
        Resources r3 = getContext().getResources();
        return RangesKt.coerceAtMost((WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).widthPixels * DoraCallStateCode.DORA_OB_USER_END) / 390, i5.a0());
    L16:
        return i5.a0();
    L12:
        r2 = false;
        goto L13
    }

    public final void C() {
        FLogger.a.i("ImageScrollBox", hashCode() + " resetView");
        this.M.scrollToPosition(0);
    }

    public final void D() {
        ImageCardNestedScrollableHost r0 = this.K.c;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L7;
        r1.width = getMaxWidth();
        r1.height = B();
        r0.setLayoutParams(r1);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @Override // com.larus.bmhome.chat.layout.holder.image.BaseImageBox
    public ViewGroup getImageParentScrollView() {
        return this.K.b;
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public int getMaxWidth() {
        if (((Boolean) P.getValue()).booleanValue() == false) goto L6;
        e2 r0 = e2.a;
        return f3.a.a();
    L6:
        return com.larus.utils.i.d(getContext());
    }

    @Override // com.larus.bmhome.chat.layout.holder.image.BaseImageBox
    public TextView getRegenerateBtn() {
        return this.K.d;
    }

    @Override // com.larus.bmhome.chat.layout.holder.image.BaseImageBox
    public List<ImageView> getImageViewList() {
        return CollectionsKt.emptyList();
    }

    @Override // com.larus.bmhome.chat.layout.holder.image.BaseImageBox
    public final void x() {
        if (getFailedIndexAndUrl().isEmpty() == false) goto L5;
        return;
    L5:
        this.L.i = true;
        Iterator<T> r0 = getFailedIndexAndUrl().entrySet().iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        Map.Entry r1 = (Map.Entry) r0.next();
        this.L.notifyItemChanged(((Number) r1.getKey()).intValue());
        goto L7
    L9:
        getFailedIndexAndUrl().clear();
    }

    @Override // com.larus.bmhome.chat.layout.holder.image.BaseImageBox, com.larus.bmhome.chat.layout.item.i
    public int getBoxType() {
        return this.O;
    }

    @Override // com.larus.bmhome.chat.layout.holder.image.BaseImageBox
    public ResizeOptions getImageSizeOption() {
        return this.I;
    }

    public final LinearLayoutManager getLayoutManager() {
        return this.M;
    }

    @Override // com.larus.bmhome.chat.layout.holder.image.BaseImageBox
    public String getLogTag() {
        return this.J;
    }

    public final void E(ImageContentData r11) {
        if (r11 == null) goto L82;
        List<ImageItem> r0 = r11.getImageList();
        if (r0 == null) goto L89;
        int r1 = 0;
        ImageItem r2 = (ImageItem) CollectionsKt.getOrNull(r0, 0);
        if (r2 == null) goto L90;
        ImageEntity r3 = r2.getImageOrigin();
        if (r3 != null) goto L10;
        return;
    L10:
        if (r3.getHeight() > 0) goto L12;
        return;
    L12:
        if (r3.getWidth() <= 0) goto L93;
        float r4 = r3.getHeight() / r3.getWidth();
        if (r4 <= 1.7777778f) goto L17;
        r4 = 1.7777778f;
    L17:
        if (r4 >= 0.5625f) goto L19;
        r4 = 0.5625f;
    L19:
        int r5 = B();
        List<ImageItem> r12 = r11.getImageList();
        if (r12 == null) goto L22;
        int r13 = r12.size();
    L23:
        boolean r6 = true;
        if (((Boolean) P.getValue()).booleanValue() == false) goto L28;
        e2 r7 = e2.a;
        if (r7.g() == r7.f()) goto L28;
        int r14 = (int) (f3.a.a() / 3.3f);
    L39:
        Message r8 = this.H;
        if (r8 != null) goto L42;
    L44:
        r6 = false;
    L45:
        if (r6 == false) goto L51;
        if (Math.abs(r4 - 1.7777778f) < 0.01f) goto L55;
        r14 = (int) (r5 / r4);
    L57:
        if (this.K.c.getHeight() != r5) goto L83;
    L77:
        ImageCardNestedScrollableHost r9 = this.K.c;
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
        if (r10 == null) goto L81;
        r10.height = r5;
        r9.setLayoutParams(r10);
        setImageSizeOption(new ResizeOptions(r14, r5));
        return;
    L81:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L83:
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L75
        int r16 = this.M.getChildCount();     // Catch: Throwable -> L75
    L59:
        if (r1 >= r16) goto L73;
        View r17 = this.M.getChildAt(r1);     // Catch: Throwable -> L75
        if (r17 == null) goto L72;
        RecyclerView.ViewHolder r18 = this.K.b.getChildViewHolder(r17);     // Catch: Throwable -> L75
        if ((r18 instanceof ScrollImageViewHolder) == false) goto L65;
        ScrollImageViewHolder r19 = (ScrollImageViewHolder) r18;     // Catch: Throwable -> L75
    L66:
        if (r19 == null) goto L72;
        ConstraintLayout r20 = r19.a.a;     // Catch: Throwable -> L75
        ViewGroup.LayoutParams r21 = r20.getLayoutParams();     // Catch: Throwable -> L75
        if (r21 == null) goto L71;
        RecyclerView.LayoutParams r22 = (RecyclerView.LayoutParams) r21;     // Catch: Throwable -> L75
        ((ViewGroup.MarginLayoutParams) r22).width = r14;     // Catch: Throwable -> L75
        ((ViewGroup.MarginLayoutParams) r22).height = r5;     // Catch: Throwable -> L75
        r20.setLayoutParams(r22);     // Catch: Throwable -> L75
        goto L72
    L71:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");     // Catch: Throwable -> L75
    L65:
        r19 = null;
    L72:
        r1 = r1 + 1;     // Catch: Throwable -> L75
        goto L59
    L73:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L75
    L75:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L55:
        r5 = (int) (r14 * r4);
        goto L57
    L51:
        if (r4 <= 1.0f) goto L55;
        int r24 = (int) (r5 / r4);
        if (r24 >= r14) goto L55;
        r14 = r24;
        goto L57
    L42:
        if (com.larus.bmhome.chat.bean.d.y(r8) != true) goto L44;
    L28:
        Message r25 = this.H;
        if (r25 != null) goto L31;
    L33:
        boolean r26 = false;
    L34:
        if (r26 == false) goto L36;
        Resources r110 = getContext().getResources();
        r14 = RangesKt.coerceAtMost((WindowDisplayMetricsOverride.apply(r110, r110.getDisplayMetrics()).widthPixels * DoraCallStateCode.DORA_OB_USER_END) / 390, i5.a0());
        goto L39
    L36:
        if (r13 <= 1) goto L38;
        r14 = RangesKt.coerceAtMost((int) (((double) getContainerWidth()) * 0.8d), i5.a0());
        goto L39
    L38:
        r14 = RangesKt.coerceAtMost(getContainerWidth(), i5.a0());
        goto L39
    L31:
        if (com.larus.bmhome.chat.bean.d.y(r25) != true) goto L33;
        r26 = true;
        goto L34
    L22:
        r13 = 0;
        goto L23
    L93:
        return;
    L90:
        return;
    L89:
        return;
    }

    public final View d(int r2) {
        return this.M.findViewByPosition(z(r2));
    }

    @Override // com.larus.bmhome.chat.layout.item.k
    public final void o(int r6) {
        super.o(r6);
        int r0 = this.M.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        FLogger.a.d("ImageScrollBox", "onLoadingProgressUpdate " + r1 + "  " + r6);
        View r2 = this.M.getChildAt(r1);
        if (r2 == null) goto L9;
        TextView r3 = (TextView) r2.findViewById(2131373629);
        if (r3 == null) goto L9;
        StringBuilder r4 = new StringBuilder();
        r4.append(r6);
        r4.append('%');
        r3.setText(r4.toString());
    L9:
        r1 = r1 + 1;
        goto L3
    }

    @Override // com.larus.bmhome.chat.layout.item.i, android.view.View
    public final void onConfigurationChanged(Configuration r4) {
        super.onConfigurationChanged(r4);
        e2 r0 = e2.a;
        Context r1 = getContext();
        if ((r1 instanceof Activity) == false) goto L5;
        Activity r2 = (Activity) r1;
    L7:
        if (r0.a(r2, r4) == false) goto L10;
        D();
        return;
    L10:
        return;
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.larus.bmhome.chat.layout.holder.image.BaseImageBox, com.larus.bmhome.chat.layout.item.i
    public void setBoxType(int r1) {
        this.O = r1;
    }

    @Override // com.larus.bmhome.chat.layout.holder.image.BaseImageBox
    public void setImageSizeOption(ResizeOptions r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.I = r2;
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public void setMaxWidth(int r3) {
        FLogger.a.i(getLogTag(), "override max width");
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [com.larus.bmhome.chat.layout.holder.image.t0] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.larus.bmhome.chat.layout.holder.image.u0] */
    public a1(final Context r18, GenerateImageScrollCell$a r19) {
        Intrinsics.checkNotNullParameter(r18, "context");
        super(r18);
        this.F = r19;
        this.I = new ResizeOptions(i5.P(), i5.P());
        this.J = "ImageScrollBox";
        View r1 = LayoutInflater.from(r18).inflate(2131562456, this, false);
        addView(r1);
        int r2 = 2131375049;
        RecyclerView r11 = ViewBindings.findChildViewById(r1, 2131375049);
        if (r11 == null) goto L14;
        r2 = 2131375050;
        ImageCardNestedScrollableHost r3 = ViewBindings.findChildViewById(r1, 2131375050);
        if (r3 == null) goto L14;
        r2 = 2131384158;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r1, 2131384158);
        if (r4 == null) goto L14;
        this.K = new LarusImageScrollCardBinding((LinearLayout) r1, r11, r3, r4);
        Function1 r5 = ((GenerateImageCell) r19.a).y;
        if (r5 != null) goto L11;
        r5 = new s0();
    L11:
        ImageScrollAdapter r12 = new ImageScrollAdapter(this, this, r5, r19.a(), r19.d(), new t0(this), new u0(this));
        this.L = r12;
        LinearLayoutManager r0 = new LinearLayoutManager(r18, 0, false);
        this.M = r0;
        this.N = LazyKt.lazy(new v0(r18));
        r11.addItemDecoration(new ImageScrollBox$1$1());
        r11.setLayoutManager(r0);
        r11.setAdapter(r12);
        r11.setItemAnimator(null);
        D();
        y6.f(r11, new w0(this), new x0(this), 0.0f, new y0(this), 57);
        this.O = -1;
        return;
    L14:
        throw new NullPointerException("Missing required view with ID: ".concat(r1.getResources().getResourceName(r2)));
    }

    @Override // com.larus.bmhome.bigimg.e
    public final void b(int r1, zo8.a r2) {
        this.K.b.scrollToPosition(z(r1));
    }

    @Override // com.larus.bmhome.chat.layout.holder.image.BaseImageBox, com.larus.bmhome.chat.layout.item.k
    public final void n(Message r9, boolean r10) {
        super.n(r9, r10);
        if (r9 != null) goto L5;
        return;
    L5:
        ImageContentData r11 = ImageHolderDispatcher.a(r9);
        this.G = r11;
        List<ImageItem> r0 = null;
        if (r11 == null) goto L8;
        List<ImageItem> r12 = r11.getImageList();
    L9:
        List<ImageItem> r13 = r12;
        if (r13 != null) goto L12;
    L15:
        boolean r14 = true;
    L17:
        if (r14 == false) goto L20;
        FLogger.a.e("ImageScrollBox", "bindSketchLoadingData imageList isNullOrEmpty ");
        return;
    L20:
        Message r15 = this.H;
        if (r15 == null) goto L23;
        String r16 = r15.getMessageId();
    L25:
        if (Intrinsics.areEqual(r16, r9.getMessageId()) == true) goto L27;
        C();
    L27:
        this.H = r9;
        ImageContentData r17 = this.G;
        if (r17 == null) goto L30;
        r0 = r17.getImageList();
    L30:
        setOriginImageList(r0);
        List<ImageItem> r18 = getOriginImageList();
        if (r18 != null) goto L33;
        r18 = CollectionsKt.emptyList();
    L33:
        setChatDisplayImageList(r18);
        setBigDisplayImageList(getChatDisplayImageList());
        this.L.i = false;
        E(this.G);
        this.L.i = false;
        FLogger.a.i("ImageScrollBox", "refreshLoadingViews " + getCurrentLoadingProgress());
        ArrayList r19 = new ArrayList();
        ImageContentData r1 = this.G;
        if (r1 == null) goto L41;
        List<ImageItem> r2 = r1.getImageList();
        if (r2 == null) goto L41;
        Iterator<T> r3 = r2.iterator();
    L39:
        if (r3.hasNext() == false) goto L41;
        r19.add(new m0(r9, (ImageItem) r3.next(), null, true, null));
    L41:
        this.L.y2(r19);
        return;
    L23:
        r16 = null;
        goto L25
    L12:
        if (r13.isEmpty() == true) goto L15;
        r14 = false;
        goto L17
    L8:
        r12 = null;
        goto L9
    }

    @Override // com.larus.bmhome.chat.layout.holder.image.BaseImageBox
    public final void r(ImageContentData r7, Message r8, BotModel r9, com.larus.bmhome.chat.api.q0 r10, CoroutineScope r11, Function1<? super Message, ? extends Map<String, ? extends Object>> r12) {
        Intrinsics.checkNotNullParameter(r8, "message");
        Message r13 = this.H;
        ArrayList r14 = null;
        if (r13 == null) goto L5;
        String r15 = r13.getMessageId();
    L6:
        boolean r16 = Intrinsics.areEqual(r15, r8.getMessageId());
        Lazy r17 = com.larus.bmhome.chat.layout.holder.progressloading.h.a;
        Message r18 = this.H;
        int r19 = 0;
        if (r18 != null) goto L10;
    L14:
        boolean r110 = false;
    L16:
        FLogger r0 = FLogger.a;
        r0.i("ImageScrollBox", "bindImages msgId: " + r8.getMessageId() + "  isMsgIdSame " + r16 + " isLoadingMatch " + r110 + ' ');
        Message r1 = this.H;
        if (r1 != null) goto L19;
    L21:
        boolean r2 = false;
    L22:
        if (r2 == false) goto L25;
        if (r110 == true) goto L27;
        C();
    L27:
        this.H = r8;
        this.G = r7;
        if (r7 == null) goto L30;
        List<ImageItem> r20 = r7.getImageList();
    L31:
        List<ImageItem> r21 = r20;
        if (r21 != null) goto L34;
    L37:
        boolean r22 = true;
    L38:
        if (r22 == false) goto L41;
        r0.e("ImageScrollBox", "bindImages imageList isNullOrEmpty ");
        return;
    L41:
        E(r7);
        getFailedIndexAndUrl().clear();
        if (r7 == null) goto L51;
        List<ImageItem> r23 = r7.getImageList();
        if (r23 == null) goto L51;
        r14 = new ArrayList();
        Iterator<T> r24 = r23.iterator();
    L47:
        if (r24.hasNext() == false) goto L51;
        Object r111 = r24.next();
        if ((!((ImageItem) r111).isLoading()) == false) goto L47;
        r14.add(r111);
    L51:
        setOriginImageList(r14);
        List<ImageItem> r25 = getOriginImageList();
        if (r25 != null) goto L54;
        r25 = CollectionsKt.emptyList();
    L54:
        setChatDisplayImageList(r25);
        List<ImageItem> r26 = getChatDisplayImageList();
        ArrayList r112 = new ArrayList();
        Iterator<T> r27 = r26.iterator();
    L56:
        if (r27.hasNext() == false) goto L60;
        Object r113 = r27.next();
        if (df8.b.c((ImageItem) r113) == false) goto L56;
        r112.add(r113);
        goto L56
    L60:
        setBigDisplayImageList(r112);
        this.L.i = false;
        ArrayList r28 = new ArrayList();
        if (r7 == null) goto L71;
        List<ImageItem> r29 = r7.getImageList();
        if (r29 == null) goto L71;
        Iterator<T> r30 = r29.iterator();
    L66:
        if (r30.hasNext() == false) goto L71;
        Object r114 = r30.next();
        int r115 = r19 + 1;
        if (r19 >= 0) goto L70;
        CollectionsKt.throwIndexOverflow();
    L70:
        ImageItem r3 = (ImageItem) r114;
        r28.add(new m0(r8, r3, (TemplateInfo.TemplateInfo) getGetTemplateByIndex().invoke(Integer.valueOf(r19)), r3.isLoading(), r3.getTaskId()));
        r19 = r115;
    L71:
        this.L.y2(r28);
        return;
    L34:
        if (r21.isEmpty() == true) goto L37;
        r22 = false;
        goto L38
    L30:
        r20 = null;
        goto L31
    L25:
        if (r16 == true) goto L27;
        C();
        goto L27
    L19:
        if (com.larus.im.bean.message.a.r0(r1) != true) goto L21;
        r2 = true;
        goto L22
    L10:
        if (com.larus.im.bean.message.a.r0(r18) == false) goto L12;
    L15:
        FLogger.a.i("ProgressLoadingHolderDispatcher", "areItemsTheSame " + com.larus.bmhome.chat.layout.holder.progressloading.h.b(r18) + "   " + com.larus.bmhome.chat.layout.holder.progressloading.h.b(r8));
        r110 = Intrinsics.areEqual(com.larus.bmhome.chat.layout.holder.progressloading.h.b(r18), com.larus.bmhome.chat.layout.holder.progressloading.h.b(r8));
        goto L16
    L12:
        if (com.larus.im.bean.message.a.r0(r8) == false) goto L14;
    L5:
        r15 = null;
        goto L6
    }
}
