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
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.layout.holder.helper.x2;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageContentData;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageEntity;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageItem;
import com.larus.bmhome.chat.plugin.image4.view.ImageViewWithLastMotion;
import com.larus.bmhome.databinding.LarusFlowMessageCardStickerBinding;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
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
public final class o1 extends BaseImageBox {
    public int F;
    public final LarusFlowMessageCardStickerBinding G;
    public final List<ImageViewWithLastMotion> H;

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
        return "sticker_img";
    }

    @Override // com.larus.bmhome.chat.layout.holder.image.BaseImageBox
    public TextView getRegenerateBtn() {
        return null;
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

    public o1(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8);
        View r0 = LayoutInflater.from(r8).inflate(2131562339, this, false);
        addView(r0);
        int r1 = 2131375019;
        if (((ViewStub) ViewBindings.findChildViewById(r0, 2131375019)) == null) goto L23;
        r1 = 2131386658;
        ImageViewWithLastMotion r3 = (ImageViewWithLastMotion) ViewBindings.findChildViewById(r0, 2131386658);
        if (r3 == null) goto L23;
        r1 = 2131386659;
        FrameLayout r4 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131386659);
        if (r4 == null) goto L23;
        LinearLayout r2 = (LinearLayout) r0;
        this.G = new LarusFlowMessageCardStickerBinding(r2, r3, r4);
        this.H = CollectionsKt.listOf(r3);
        ViewGroup.LayoutParams r5 = getLayoutParams();
        if (r5 == null) goto L21;
        ConstraintLayout.LayoutParams r6 = (ConstraintLayout.LayoutParams) r5;
        r6.setMarginStart(getResources().getDimensionPixelSize(2131167568));
        r6.setMarginEnd(0);
        setLayoutParams(r6);
        setMaxWidth(Math.min(getMaxWidth(), r8.getResources().getDimensionPixelSize(v19.c.b(2130971486, r8, 2131167341))));
        Resources r9 = r8.getResources();
        int r10 = RangesKt.coerceAtMost((WindowDisplayMetricsOverride.apply(r9, r9.getDisplayMetrics()).widthPixels * 128) / 390, getMaxWidth());
        ViewGroup.LayoutParams r7 = r4.getLayoutParams();
        if (r7 == null) goto L19;
        r7.width = r10;
        r7.height = r10;
        r4.setLayoutParams(r7);
        ViewGroup.LayoutParams r11 = r2.getLayoutParams();
        if (r11 == null) goto L17;
        LinearLayout.LayoutParams r12 = (LinearLayout.LayoutParams) r11;
        r12.setMarginEnd(0);
        r2.setLayoutParams(r12);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L21:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }

    public final View d(int r1) {
        return this.G.b;
    }

    @Override // com.larus.bmhome.chat.layout.holder.image.BaseImageBox, com.larus.bmhome.chat.layout.item.i
    public void setBoxType(int r1) {
        this.F = r1;
    }

    @Override // com.larus.bmhome.chat.layout.holder.image.BaseImageBox
    public final void r(ImageContentData r17, Message r18, BotModel r19, com.larus.bmhome.chat.api.q0 r20, CoroutineScope r21, Function1<? super Message, ? extends Map<String, ? extends Object>> r22) {
        Intrinsics.checkNotNullParameter(r18, "message");
        Iterator<T> r0 = getImageViewList().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        z19.j r1 = (ImageViewWithLastMotion) r0.next();
        Intrinsics.checkNotNull(r1);
        com.larus.utils.e1.x(r1);
        goto L4
    L6:
        getFailedIndexAndUrl().clear();
        if (r17 == null) goto L11;
        List<ImageItem> r2 = r17.getImageList();
        if (r2 == null) goto L11;
        List<ImageItem> r3 = CollectionsKt.take(r2, 1);
    L12:
        setOriginImageList(r3);
        List<ImageItem> r4 = getOriginImageList();
        if (r4 != null) goto L15;
        r4 = CollectionsKt.emptyList();
    L15:
        setChatDisplayImageList(r4);
        List<ImageItem> r5 = getChatDisplayImageList();
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r5.iterator();
    L17:
        if (r7.hasNext() == false) goto L21;
        Object r8 = r7.next();
        if (df8.b.c((ImageItem) r8) == false) goto L17;
        r6.add(r8);
        goto L17
    L21:
        setBigDisplayImageList(r6);
        Iterator<T> r9 = getImageViewList().iterator();
        int r10 = 0;
    L23:
        if (r9.hasNext() == false) goto L51;
        Object r11 = r9.next();
        int r12 = r10 + 1;
        if (r10 >= 0) goto L27;
        CollectionsKt.throwIndexOverflow();
    L27:
        ImageViewWithLastMotion r13 = (ImageViewWithLastMotion) r11;
        int r14 = Integer.valueOf(r10).intValue();
        List<ImageItem> r15 = getOriginImageList();
        if (r15 != null) goto L30;
    L34:
        ImageItem r16 = null;
    L35:
        if (r16 == null) goto L37;
        String r23 = df8.b.a(r16);
    L39:
        if (r23 == null) goto L41;
        Uri r24 = com.larus.image.loader.b0.a(r23, "chat.single.img", false, false, 6);
    L42:
        if (r16 == null) goto L48;
        ImageEntity r25 = r16.getImageThumb();
        if (r25 == null) goto L48;
        String r26 = r25.getUrl();
        if (r26 == null) goto L48;
        Uri r27 = com.larus.image.loader.b0.a(r26, "chat.single.img_thumb", false, false, 6);
    L49:
        Intrinsics.checkNotNull(r13);
        g0.a.a(this, r13, r27, r24, r10, false);
        r10 = r12;
    L48:
        r27 = null;
        goto L49
    L41:
        r24 = null;
        goto L42
    L37:
        r23 = null;
        goto L39
    L30:
        if (r15.size() <= r14) goto L32;
        r16 = (ImageItem) ListProtector.get(r15, r14);
    L33:
        if (r16 != null) goto L35;
    L32:
        r16 = null;
        goto L33
    L51:
        if (r20 == null) goto L53;
        com.larus.bmhome.chat.api.q0.a r110 = r20.getProvider();
    L54:
        com.larus.bmhome.chat.layout.holder.helper.b1.a(new com.larus.bmhome.chat.layout.holder.helper.o(r18, r20, r110, new x2(), null, null, null, DoraCallStateCode.DOUBAO_CMD_12), this);
        return;
    L53:
        r110 = null;
    L11:
        r3 = null;
        goto L12
    }
}
