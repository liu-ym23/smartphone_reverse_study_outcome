package com.larus.bmhome.chat.deepresearch.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Space;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.markdown.imagegroup.view.MarkdownSourceImageView;
import com.larus.bmhome.chat.search.LruSet;
import com.larus.chat.gallery.api.IChatGalleryService;
import com.larus.chat.gallery.api.PreviewScene;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.SearchImageInfo;
import com.larus.im.bean.message.block.Block;
import com.larus.list.expose.ExposureTrackerExtKt;
import com.larus.mainbot.impl.databinding.LarusMdImageGroupJoin2Binding;
import com.larus.mainbot.impl.databinding.LarusMdImageGroupJoin3Binding;
import com.larus.mainbot.impl.databinding.LarusMdImageGroupJoin3VerticalBinding;
import com.larus.mainbot.impl.databinding.LarusMdImageGroupJoin6Binding;
import com.larus.mainbot.impl.databinding.LarusMdImageGroupLayerBinding;
import com.larus.platform.api.f3;
import com.larus.platform.service.z2;
import com.larus.search.api.event.HybridEventParams;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import oi8.j;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class j2 extends AbsBlockView {
    public Block b;
    public Map<String, Object> c;
    public Message d;
    public BotModel e;
    public String f;
    public String g;
    public String h;
    public final Boolean i;
    public fh8.f j;
    public Size k;
    public float l;
    public LruSet<String> m;
    public int n;
    public boolean o;
    public final ValueAnimator p;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void b(Context r1, AttributeSet r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
    }

    private final int getWidgetOrder() {
        Map<String, Object> r0 = this.c;
        Integer r1 = null;
        if (r0 == null) goto L5;
        Object r2 = r0.get("message_markdown_image");
    L7:
        if ((r2 instanceof Integer) == false) goto L9;
        r1 = (Integer) r2;
    L9:
        if (r1 != null) goto L13;
        return 0;
    L13:
        return r1.intValue();
    L5:
        r2 = null;
        goto L7
    }

    public final boolean m() {
        Map<String, Object> r0 = this.c;
        Integer r1 = null;
        if (r0 == null) goto L5;
        Object r2 = r0.get("block_view_extra_position");
    L7:
        if ((r2 instanceof Integer) == false) goto L9;
        r1 = (Integer) r2;
    L9:
        if (r1 != null) goto L12;
    L14:
        return false;
    L12:
        if (r1.intValue() != 0) goto L14;
        return true;
    L5:
        r2 = null;
        goto L7
    }

    private final int getPaddingExtraHeight() {
        boolean r0 = m();
        Map<String, Object> r1 = this.c;
        Integer r2 = null;
        if (r1 == null) goto L5;
        Object r3 = r1.get("block_view_extra_position");
    L7:
        if ((r3 instanceof Integer) == false) goto L9;
        Integer r4 = (Integer) r3;
    L10:
        Map<String, Object> r5 = this.c;
        if (r5 == null) goto L13;
        Object r6 = r5.get("block_view_extra_count");
    L15:
        if ((r6 instanceof Integer) == false) goto L17;
        r2 = (Integer) r6;
    L17:
        boolean r7 = false;
        if (r2 == null) goto L20;
        int r8 = r2.intValue();
    L21:
        int r9 = r8 - 1;
        if (r4 != null) goto L25;
    L27:
        if (r0 == false) goto L30;
        setPaddingRelative(getPaddingStart(), i5.Y(), getPaddingEnd(), i5.q());
        int r10 = getPaddingTop();
        int r11 = getPaddingBottom();
    L33:
        return r10 + r11;
    L30:
        if (r7 == false) goto L32;
        setPaddingRelative(getPaddingStart(), i5.q(), getPaddingEnd(), i5.Y());
        r10 = getPaddingTop();
        r11 = getPaddingBottom();
        goto L33
    L32:
        setPaddingRelative(getPaddingStart(), i5.q(), getPaddingEnd(), i5.r0());
        r10 = getPaddingTop();
        r11 = getPaddingBottom();
        goto L33
    L25:
        if (r4.intValue() != r9) goto L27;
        r7 = true;
        goto L27
    L20:
        r8 = 0;
        goto L21
    L13:
        r6 = null;
        goto L15
    L9:
        r4 = null;
        goto L10
    L5:
        r3 = null;
        goto L7
    }

    public j2(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.i = Boolean.FALSE;
        this.k = new Size(0, 0);
        new Size(0, 0);
        ValueAnimator r4 = ValueAnimator.ofInt(new int[]{0, 1300});
        r4.setDuration(1300);
        r4.setRepeatCount(-1);
        r4.setRepeatMode(1);
        this.p = r4;
    }

    public static void f(LarusMdImageGroupJoin6Binding r4) {
        r4.d.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadii(0.0f, i5.r0(), i5.r0(), 0.0f));
        com.larus.utils.e1.o(r4.e);
        com.larus.utils.e1.o(r4.f);
        com.larus.utils.e1.o(r4.g);
    }

    public static String j(List r3) {
        SearchImageInfo r0 = (SearchImageInfo) CollectionsKt.firstOrNull(r3);
        if (r0 == null) goto L5;
        String r1 = r0.getImgCaption();
    L7:
        if (com.larus.utils.o0.d(r1) == false) goto L11;
        if (r1 == null) goto L10;
        return r1;
    L10:
        return "";
    L11:
        SearchImageInfo r4 = (SearchImageInfo) CollectionsKt.firstOrNull(r3);
        if (r4 == null) goto L19;
        String r5 = r4.getCaption();
        if (r5 != null) goto L17;
        return "";
    L17:
        return r5;
    L19:
        return "";
    L5:
        r1 = null;
        goto L7
    }

    public final void i(final Function0<Unit> r3) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L5;
        post(new i2(r3));
        return;
    L5:
        r3.invoke();
    }

    public final void l(List<SearchImageInfo> r28) {
        int r0 = r28.size();
        if (r0 != 1) goto L5;
        o(this, r28);
        return;
    L5:
        if (r0 != 2) goto L7;
        removeAllViews();
        CardView r1 = LayoutInflater.from(getContext()).inflate(2131562947, this, false);
        int r3 = 2131373613;
        if (((Space) ViewBindings.findChildViewById(r1, 2131373613)) == null) goto L78;
        r3 = 2131374997;
        SimpleDraweeView r12 = ViewBindings.findChildViewById(r1, 2131374997);
        if (r12 == null) goto L78;
        r3 = 2131374998;
        SimpleDraweeView r13 = ViewBindings.findChildViewById(r1, 2131374998);
        if (r13 == null) goto L78;
        CardView r2 = r1;
        Intrinsics.checkNotNull(new LarusMdImageGroupJoin2Binding(r2, r12, r13));
        addView(r2, new FrameLayout.LayoutParams(this.k.getWidth(), this.k.getHeight()));
        int r14 = k(this, 154);
        List r15 = CollectionsKt.listOf(new SimpleDraweeView[]{r12, r13});
        FLogger.a.e("TESTTEST", "updateJoinUI2: " + r28);
        h(this, r12, r15, r14, this.k.getHeight(), r28, 0, "double_tile");
        h(this, r13, r15, r14, this.k.getHeight(), r28, 1, "double_tile");
        SearchImageInfo r4 = (SearchImageInfo) CollectionsKt.getOrNull(r28, 0);
        SearchImageInfo r6 = (SearchImageInfo) CollectionsKt.getOrNull(r28, 1);
        n(this, r12, r4, "double_tile", r14, this.k.getHeight());
        n(this, r13, r6, "double_tile", r14, this.k.getHeight());
        return;
    L78:
        throw new NullPointerException("Missing required view with ID: ".concat(r1.getResources().getResourceName(r3)));
    L7:
        if (r28.size() < 3) goto L24;
        int r5 = 0;
    L10:
        if (r5 >= 3) goto L25;
        SearchImageInfo r7 = (SearchImageInfo) ListProtector.get(r28, r5);
        Integer r8 = r7.getWidth();
        if (r8 == null) goto L14;
        int r9 = r8.intValue();
    L15:
        Integer r10 = r7.getHeight();
        if (r10 == null) goto L18;
        int r11 = r10.intValue();
    L19:
        if (r9 == 0) goto L24;
        if (r11 == 0) goto L24;
        if (r9 > r11) goto L24;
        r5 = r5 + 1;
        goto L10
    L18:
        r11 = 0;
        goto L19
    L14:
        r9 = 0;
        goto L15
    L25:
        boolean r16 = true;
    L26:
        int r17 = 2131375000;
        if (r16 == false) goto L44;
        removeAllViews();
        CardView r18 = LayoutInflater.from(getContext()).inflate(2131562949, this, false);
        SimpleDraweeView r22 = ViewBindings.findChildViewById(r18, 2131374996);
        if (r22 == null) goto L41;
        AppCompatTextView r19 = ViewBindings.findChildViewById(r18, 2131375000);
        if (r19 == null) goto L43;
        r17 = 2131375003;
        SimpleDraweeView r23 = ViewBindings.findChildViewById(r18, 2131375003);
        if (r23 == null) goto L43;
        r17 = 2131375004;
        SimpleDraweeView r24 = ViewBindings.findChildViewById(r18, 2131375004);
        if (r24 == null) goto L43;
        CardView r20 = r18;
        Intrinsics.checkNotNull(new LarusMdImageGroupJoin3VerticalBinding(r20, r22, r19, r23, r24));
        addView(r20, new FrameLayout.LayoutParams(this.k.getWidth(), this.k.getHeight()));
        List r110 = CollectionsKt.listOf(new SimpleDraweeView[]{r22, r23, r24});
        int r111 = k(this, 102);
        h(this, r22, r110, r111, this.k.getHeight(), r28, 0, "triple_tile");
        h(this, r23, r110, r111, this.k.getHeight(), r28, 1, "triple_tile");
        h(this, r24, r110, r111, this.k.getHeight(), r28, 2, "triple_tile");
        if (r28.size() <= 3) goto L39;
        r19.setVisibility(0);
        r19.setText(getResources().getString(2131908394, new Object[]{Integer.valueOf(r28.size() - 3)}));
    L40:
        n(this, r22, (SearchImageInfo) CollectionsKt.getOrNull(r28, 0), "triple_tile", r111, this.k.getHeight());
        n(this, r23, (SearchImageInfo) CollectionsKt.getOrNull(r28, 1), "triple_tile", r111, this.k.getHeight());
        n(this, r24, (SearchImageInfo) CollectionsKt.getOrNull(r28, 2), "triple_tile", r111, this.k.getHeight());
        return;
    L39:
        r19.setVisibility(8);
    L43:
        throw new NullPointerException("Missing required view with ID: ".concat(r18.getResources().getResourceName(r17)));
    L41:
        r17 = 2131374996;
        goto L43
    L44:
        removeAllViews();
        CardView r21 = LayoutInflater.from(getContext()).inflate(2131562948, this, false);
        if (((Space) ViewBindings.findChildViewById(r21, 2131373610)) == null) goto L67;
        SimpleDraweeView r112 = ViewBindings.findChildViewById(r21, 2131374999);
        if (r112 == null) goto L66;
        AppCompatTextView r25 = ViewBindings.findChildViewById(r21, 2131375000);
        if (r25 == null) goto L69;
        r17 = 2131375001;
        SimpleDraweeView r113 = ViewBindings.findChildViewById(r21, 2131375001);
        if (r113 == null) goto L69;
        r17 = 2131375002;
        SimpleDraweeView r114 = ViewBindings.findChildViewById(r21, 2131375002);
        if (r114 == null) goto L69;
        CardView r26 = r21;
        MarkdownSourceImageView r27 = (MarkdownSourceImageView) ViewBindings.findChildViewById(r21, 2131387008);
        if (r27 == null) goto L65;
        Intrinsics.checkNotNull(new LarusMdImageGroupJoin3Binding(r26, r112, r25, r113, r114, r27));
        addView(r26, new FrameLayout.LayoutParams(this.k.getWidth(), this.k.getHeight()));
        int r115 = k(this, 221);
        List r29 = CollectionsKt.listOf(new SimpleDraweeView[]{r112, r114, r113});
        SearchImageInfo r30 = (SearchImageInfo) CollectionsKt.getOrNull(r28, 0);
        if (r30 == null) goto L59;
        String r31 = r30.getMainSiteUrl();
    L60:
        MarkdownSourceImageView.f(r27, r31, null, new HybridEventParams("message_markdown_image", "chat", "default", null, 120), 2);
        FLogger.a.e("TESTTEST", "updateJoinUI3: " + r28);
        h(this, r112, r29, r115, this.k.getHeight(), r28, 0, "triple_tile");
        int r210 = k(this, 87);
        h(this, r114, r29, r210, r210, r28, 1, "triple_tile");
        h(this, r113, r29, r210, r210, r28, 2, "triple_tile");
        if (r28.size() <= 3) goto L63;
        r25.setVisibility(0);
        r25.setText(getResources().getString(2131908394, new Object[]{Integer.valueOf(r28.size() - 3)}));
    L64:
        n(this, r112, (SearchImageInfo) CollectionsKt.getOrNull(r28, 0), "triple_tile", r115, this.k.getHeight());
        n(this, r114, (SearchImageInfo) CollectionsKt.getOrNull(r28, 1), "triple_tile", r210, r210);
        n(this, r113, (SearchImageInfo) CollectionsKt.getOrNull(r28, 2), "triple_tile", r210, r210);
        return;
    L63:
        r25.setVisibility(8);
        goto L64
    L59:
        r31 = null;
        goto L60
    L65:
        r17 = 2131387008;
    L69:
        throw new NullPointerException("Missing required view with ID: ".concat(r21.getResources().getResourceName(r17)));
    L66:
        r17 = 2131374999;
        goto L69
    L67:
        r17 = 2131373610;
    L24:
        r16 = false;
        goto L26
    }

    public final void p(List<SearchImageInfo> r22) {
        removeAllViews();
        CardView r0 = LayoutInflater.from(getContext()).inflate(2131562950, this, false);
        int r1 = 2131374990;
        SimpleDraweeView r2 = ViewBindings.findChildViewById(r0, 2131374990);
        if (r2 == null) goto L62;
        r1 = 2131374991;
        SimpleDraweeView r3 = ViewBindings.findChildViewById(r0, 2131374991);
        if (r3 == null) goto L62;
        r1 = 2131374992;
        SimpleDraweeView r4 = ViewBindings.findChildViewById(r0, 2131374992);
        if (r4 == null) goto L62;
        r1 = 2131374993;
        SimpleDraweeView r5 = ViewBindings.findChildViewById(r0, 2131374993);
        if (r5 == null) goto L62;
        r1 = 2131374994;
        SimpleDraweeView r6 = ViewBindings.findChildViewById(r0, 2131374994);
        if (r6 == null) goto L62;
        r1 = 2131374995;
        SimpleDraweeView r7 = ViewBindings.findChildViewById(r0, 2131374995);
        if (r7 == null) goto L62;
        r1 = 2131375000;
        AppCompatTextView r19 = ViewBindings.findChildViewById(r0, 2131375000);
        if (r19 == null) goto L62;
        CardView r8 = r0;
        if (((MarkdownSourceImageView) ViewBindings.findChildViewById(r0, 2131387008)) == null) goto L60;
        LarusMdImageGroupJoin6Binding r9 = new LarusMdImageGroupJoin6Binding(r8, r2, r3, r4, r5, r6, r7, r19);
        Intrinsics.checkNotNull(r9);
        addView(r8, new FrameLayout.LayoutParams(this.k.getWidth(), this.k.getHeight()));
        int r11 = this.k.getHeight();
        if (m() == false) goto L23;
        List r10 = CollectionsKt.listOf(new SimpleDraweeView[]{r2, r3, r4});
    L21:
        List r13 = r10;
    L26:
        Iterator r15 = r13.iterator();
        int r12 = 0;
    L28:
        if (r15.hasNext() == false) goto L33;
        int r16 = r12 + 1;
        SimpleDraweeView r14 = (SimpleDraweeView) r15.next();
        if (CollectionsKt.getOrNull(r22, r12) == null) goto L33;
        int r17 = r12;
        h(this, r14, r13, r11, r11, r22, r12, "multiple_card");
        com.larus.utils.e1.x(r14);
        ExposureTrackerExtKt.a(r14, new h2((SearchImageInfo) CollectionsKt.getOrNull(r22, r17), this, "multiple_card", r11, r11, r17));
        r12 = r16;
        r9 = r9;
    L33:
        LarusMdImageGroupJoin6Binding r110 = r9;
        switch(r22.size()) {
            case 1: goto L50;
            case 2: goto L49;
            case 3: goto L48;
            case 4: goto L44;
            case 5: goto L40;
            case 6: goto L37;
            default: goto L42;
        };
    L44:
        LarusMdImageGroupJoin6Binding r18 = r110;
        if (m() == false) goto L47;
        f(r18);
    L52:
        if (m() == false) goto L54;
        ViewGroup.LayoutParams r20 = r18.h.getLayoutParams();
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams r21 = (ConstraintLayout.LayoutParams) r20;
        ((ConstraintLayout.LayoutParams) r21).bottomToBottom = r18.d.getId();
        r18.h.setLayoutParams(r21);
        int r111 = 3;
    L56:
        if (r22.size() <= r111) goto L58;
        r18.h.setVisibility(0);
        r18.h.setText(getResources().getString(2131908394, new Object[]{Integer.valueOf(r22.size() - r111)}));
        return;
    L58:
        r18.h.setVisibility(8);
        return;
    L54:
        ViewGroup.LayoutParams r23 = r18.h.getLayoutParams();
        Intrinsics.checkNotNull(r23, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams r24 = (ConstraintLayout.LayoutParams) r23;
        ((ConstraintLayout.LayoutParams) r24).bottomToBottom = r18.g.getId();
        r18.h.setLayoutParams(r24);
        r111 = 6;
        goto L56
    L47:
        r18.c.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadii(0.0f, i5.r0(), 0.0f, 0.0f));
        r18.f.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadii(0.0f, 0.0f, i5.r0(), 0.0f));
        goto L52
    L48:
        r18 = r110;
        f(r18);
        goto L52
    L49:
        r18 = r110;
        r18.c.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadii(0.0f, i5.r0(), i5.r0(), 0.0f));
        com.larus.utils.e1.o(r18.e);
        com.larus.utils.e1.o(r18.f);
        com.larus.utils.e1.o(r18.g);
        goto L52
    L50:
        r18 = r110;
        r18.b.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadii(0.0f, i5.r0(), i5.r0(), 0.0f));
        com.larus.utils.e1.o(r18.e);
        com.larus.utils.e1.o(r18.f);
        com.larus.utils.e1.o(r18.g);
    L42:
        r18 = r110;
        goto L52
    L37:
        if (m() == false) goto L42;
        f(r110);
        goto L42
    L40:
        if (m() == false) goto L43;
        f(r110);
        goto L42
    L43:
        r18 = r110;
        r18.d.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadii(0.0f, i5.r0(), i5.r0(), 0.0f));
        r18.f.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadii(0.0f, 0.0f, i5.r0(), 0.0f));
        goto L52
    L23:
        if (r22.size() != 4) goto L25;
        r10 = CollectionsKt.listOf(new SimpleDraweeView[]{r2, r3, r5, r6});
        goto L21
    L25:
        r13 = CollectionsKt.listOf(new SimpleDraweeView[]{r2, r3, r4, r5, r6, r7});
        goto L26
    L60:
        r1 = 2131387008;
    L62:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }

    public static int k(j2 r0, int r1) {
        return (r1 * (r0.k.getWidth() - 2)) / 310;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [com.larus.bmhome.chat.deepresearch.view.f2] */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.bmhome.chat.deepresearch.view.e2] */
    public static void o(final j2 r10, final List r11) {
        r10.removeAllViews();
        final LarusMdImageGroupLayerBinding r0 = LarusMdImageGroupLayerBinding.a(LayoutInflater.from(r10.getContext()).inflate(2131562951, r10, false));
        Intrinsics.checkNotNull(r0);
        final List r1 = CollectionsKt.listOf(r0.b);
        final ?? r3 = new e2(r0, r10, r1, r11);
        final ?? r2 = new f2(r0, r11, r10, r3);
        r3.invoke();
        r10.i(new g2(r2, r10, r0));
        n(r10, r0.b, (SearchImageInfo) CollectionsKt.getOrNull(r11, 0), "single_card", r10.k.getWidth(), r10.k.getHeight());
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void a(Block r8, Map<String, Object> r9) {
        this.b = r8;
        this.c = r9;
        Object r1 = null;
        if (r9 == null) goto L5;
        Object r2 = r9.get("block_view_extra_message");
    L7:
        if ((r2 instanceof Message) == false) goto L9;
        Message r3 = (Message) r2;
    L10:
        this.d = r3;
        if (r9 == null) goto L13;
        Object r4 = r9.get("block_view_extra_bot_model");
    L15:
        if ((r4 instanceof BotModel) == false) goto L17;
        BotModel r5 = (BotModel) r4;
    L18:
        this.e = r5;
        if (r9 == null) goto L21;
        Object r6 = r9.get("block_view_extra_previous_page");
    L23:
        if ((r6 instanceof String) == false) goto L25;
        String r7 = (String) r6;
    L26:
        this.g = r7;
        if (r9 == null) goto L29;
        Object r10 = r9.get("block_view_extra_current_page");
    L31:
        if ((r10 instanceof String) == false) goto L33;
        String r11 = (String) r10;
    L34:
        this.f = r11;
        if (r9 == null) goto L37;
        Object r12 = r9.get("block_view_extra_mob_research_id");
    L39:
        if ((r12 instanceof String) == false) goto L41;
        String r13 = (String) r12;
    L42:
        this.h = r13;
        if (r9 == null) goto L45;
        Object r14 = r9.get("block_view_extra_card_id_cache");
    L47:
        if ((r14 instanceof LruSet) == false) goto L49;
        LruSet<String> r15 = (LruSet) r14;
    L50:
        this.m = r15;
        if (r9 == null) goto L53;
        Object r16 = r9.get("block_view_markdown_common_input");
    L55:
        if ((r16 instanceof fh8.f) == false) goto L57;
        fh8.f r17 = (fh8.f) r16;
    L58:
        this.j = r17;
        if (r9 == null) goto L61;
        Object r18 = r9.get("block_view_extra_align_start");
    L63:
        if ((r18 instanceof Boolean) == false) goto L65;
        Boolean r19 = (Boolean) r18;
    L66:
        boolean r20 = false;
        if (r19 == null) goto L69;
        boolean r21 = r19.booleanValue();
    L70:
        this.o = r21;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L141
        List<SearchImageInfo> r23 = AbsBlockView.a.c(r8);     // Catch: Throwable -> L141
        List<SearchImageInfo> r24 = r23;     // Catch: Throwable -> L141
        if (r24 != null) goto L74;
    L77:
        boolean r25 = true;
    L78:
        if (r25 == false) goto L81;
        setVisibility(8);     // Catch: Throwable -> L141
    L139:
        Object r26 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L141
    L144:
        if (Result.exceptionOrNull-impl(r26) == null) goto L149;
        setVisibility(8);
        return;
    L149:
        return;
    L81:
        if (Intrinsics.areEqual(this.f, "dr_process_detail") == false) goto L83;
        int r27 = i5.l0();     // Catch: Throwable -> L141
    L84:
        if (r9 == null) goto L86;
        r1 = r9.get("block_view_extra_max_width");     // Catch: Throwable -> L141
    L86:
        Integer r28 = (Integer) r1;     // Catch: Throwable -> L141
        if (r28 == null) goto L89;
        int r29 = r28.intValue();     // Catch: Throwable -> L141
    L90:
        int r30 = r29 - r27;     // Catch: Throwable -> L141
        if (com.larus.platform.service.e2.a.isPad() == false) goto L93;
        Resources r31 = getContext().getResources();     // Catch: Throwable -> L141
        int r32 = RangesKt.coerceAtMost(WindowDisplayMetricsOverride.apply(r31, r31.getDisplayMetrics()).widthPixels, f3.a.a());     // Catch: Throwable -> L141
    L94:
        this.n = RangesKt.coerceAtMost(r30, r32);     // Catch: Throwable -> L141
        setVisibility(0);     // Catch: Throwable -> L141
        if (Intrinsics.areEqual(this.f, "dr_process_detail") == false) goto L102;
        q(r23, this.n);     // Catch: Throwable -> L141
        if (r23 == null) goto L139;
        if (r23.size() != 1) goto L101;
        o(this, r23);     // Catch: Throwable -> L141
        goto L139
    L101:
        p(r23);     // Catch: Throwable -> L141
        goto L139
    L102:
        if (r23 == null) goto L139;
        SearchImageInfo r33 = (SearchImageInfo) CollectionsKt.firstOrNull(r23);     // Catch: Throwable -> L141
        if (r33 == null) goto L108;
        Integer r0 = r33.getWidth();     // Catch: Throwable -> L141
        if (r0 == null) goto L108;
        int r34 = r0.intValue();     // Catch: Throwable -> L141
    L109:
        if (r33 == null) goto L113;
        Integer r35 = r33.getHeight();     // Catch: Throwable -> L141
        if (r35 == null) goto L113;
        int r36 = r35.intValue();     // Catch: Throwable -> L141
    L114:
        if (r34 <= 0) goto L122;
        if (r36 <= 0) goto L122;
        if (r33 == null) goto L122;
        if (r23.size() > 1) goto L122;
        float r37 = Math.max(0.4f, Math.min(2.5f, r34 / r36));     // Catch: Throwable -> L141
    L123:
        this.l = r37;     // Catch: Throwable -> L141
        int r38 = this.n;     // Catch: Throwable -> L141
        if (r38 > 0) goto L126;
    L138:
        l(r23);     // Catch: Throwable -> L141
        goto L139
    L126:
        if (r37 <= 0.0f) goto L138;
        if (r37 <= 1.0f) goto L132;
        Size r39 = new Size(r38, (int) (r38 / r37));     // Catch: Throwable -> L141
    L137:
        this.k = r39;     // Catch: Throwable -> L141
        new Size(r38, this.k.getHeight() + getPaddingExtraHeight());     // Catch: Throwable -> L141
        goto L138
    L132:
        if (r37 != 1.0f) goto L134;
        r20 = true;
    L134:
        if (r20 == false) goto L136;
        r39 = new Size(r38, r38);     // Catch: Throwable -> L141
        goto L137
    L136:
        double r40 = ((double) r38) * 0.8d;     // Catch: Throwable -> L141
        r39 = new Size((int) (((double) r37) * r40), (int) r40);     // Catch: Throwable -> L141
    L122:
        r37 = 1.7777778f;
    L113:
        r36 = 0;
    L108:
        r34 = 0;
        goto L109
    L93:
        Resources r41 = getContext().getResources();     // Catch: Throwable -> L141
        r32 = WindowDisplayMetricsOverride.apply(r41, r41.getDisplayMetrics()).widthPixels;     // Catch: Throwable -> L141
        goto L94
    L89:
        r29 = 0;
        goto L90
    L83:
        r27 = i5.Q();     // Catch: Throwable -> L141
        goto L84
    L74:
        if (r24.isEmpty() == true) goto L77;
        r25 = false;
    L141:
        th = move-exception;
        Result.Companion r42 = Result.Companion;
        r26 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L144
    L69:
        r21 = false;
        goto L70
    L65:
        r19 = null;
        goto L66
    L61:
        r18 = null;
        goto L63
    L57:
        r17 = null;
        goto L58
    L53:
        r16 = null;
        goto L55
    L49:
        r15 = null;
        goto L50
    L45:
        r14 = null;
        goto L47
    L41:
        r13 = null;
        goto L42
    L37:
        r12 = null;
        goto L39
    L33:
        r11 = null;
        goto L34
    L29:
        r10 = null;
        goto L31
    L25:
        r7 = null;
        goto L26
    L21:
        r6 = null;
        goto L23
    L17:
        r5 = null;
        goto L18
    L13:
        r4 = null;
        goto L15
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L7
    }

    public final void q(List r4, int r5) {
        if (r5 <= 0) goto L38;
        if (r4 == null) goto L44;
        SearchImageInfo r0 = (SearchImageInfo) CollectionsKt.firstOrNull(r4);
        int r1 = 0;
        if (r0 == null) goto L10;
        Integer r2 = r0.getWidth();
        if (r2 == null) goto L10;
        int r3 = r2.intValue();
    L11:
        if (r0 == null) goto L16;
        Integer r6 = r0.getHeight();
        if (r6 == null) goto L16;
        r1 = r6.intValue();
    L16:
        if (r3 == 0) goto L20;
        if (r1 == 0) goto L20;
        this.l = r3 / r1;
    L22:
        if (m() == false) goto L28;
        if (r4.size() >= 3) goto L26;
        this.k = new Size(r5, (int) (r5 / 1.7777778f));
        return;
    L26:
        this.k = new Size(r5, (r5 - i5.j0()) / 3);
        return;
    L28:
        if (r4.size() != 1) goto L34;
        if (this.l <= 1.0f) goto L32;
        this.k = new Size(r5, (int) (r5 / this.l));
        return;
    L32:
        this.k = new Size((int) (r5 * this.l), r5);
        return;
    L34:
        if (r4.size() > 3) goto L36;
        this.k = new Size(r5, (r5 - i5.j0()) / 3);
        return;
    L36:
        this.k = new Size(r5, (((r5 - i5.j0()) / 3) * 2) + i5.N());
        return;
    L20:
        this.l = 1.7777778f;
    L10:
        r3 = 0;
        goto L11
    L44:
        return;
    }

    public static Unit e(j2 r44, SearchImageInfo r45, String r46, int r47, int r48, int r49) {
        r44.getClass();
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("mobCardShow onExpose imageItem?.cardId.toString() = ");
        String r3 = null;
        if (r45 == null) goto L5;
        Long r4 = r45.getCardId();
    L6:
        r2.append(r4);
        r1.i("custom-data-vg", r2.toString());
        int r5 = r44.getWidgetOrder();
        ri8.c r6 = ri8.c.a;
        LruSet<String> r7 = r44.m;
        if (r45 == null) goto L9;
        Long r8 = r45.getCardId();
    L10:
        String r9 = String.valueOf(r8);
        Message r10 = r44.d;
        if (r10 == null) goto L13;
        String r11 = r10.getMessageId();
    L14:
        Message r12 = r44.d;
        if (r12 == null) goto L17;
        String r13 = r12.getConversationId();
    L18:
        Message r14 = r44.d;
        if (r14 == null) goto L21;
        String r15 = r14.getReplyId();
    L22:
        String r16 = r44.f;
        String r17 = r44.g;
        BotModel r18 = r44.e;
        if (r18 == null) goto L25;
        String r19 = r18.getBotId();
    L26:
        String r110 = ri8.c.h(r47, r48);
        Message r20 = r44.d;
        if (r20 == null) goto L29;
        r3 = com.larus.bmhome.chat.bean.d.x(r20).getReqId();
    L29:
        String r21 = r3;
        Integer[] r22 = new Integer[2];
        int r23 = 0;
        if (r45 == null) goto L34;
        Integer r111 = r45.getOriginWidth();
        if (r111 == null) goto L34;
        int r112 = r111.intValue();
    L35:
        r22[0] = Integer.valueOf(r112);
        if (r45 == null) goto L40;
        Integer r113 = r45.getOriginHeight();
        if (r113 == null) goto L40;
        r23 = r113.intValue();
    L40:
        r22[1] = Integer.valueOf(r23);
        ri8.c.n(r7, r9, r11, r13, r15, r16, r17, Integer.valueOf(r5), Integer.valueOf(r49 + 1), "slideshow", "within_text", "picture", r19, r110, r46, Integer.valueOf(r5), null, r21, null, null, CollectionsKt.listOf(r22), null, r44.h, null, null, null, null, null, AbsBlockView.a.d(r44.b), null, null, null, null, null, null, null, null, null, -273874944, 63);
        return Unit.INSTANCE;
    L34:
        r112 = 0;
        goto L35
    L25:
        r19 = null;
        goto L26
    L21:
        r15 = null;
        goto L22
    L17:
        r13 = null;
        goto L18
    L13:
        r11 = null;
        goto L14
    L9:
        r8 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    public static void n(j2 r8, SimpleDraweeView r9, SearchImageInfo r10, String r11, int r12, int r13) {
        r8.getClass();
        ExposureTrackerExtKt.a(r9, new h2(r10, r8, r11, r12, r13, 0));
    }

    public static /* synthetic */ void h(j2 r11, SimpleDraweeView r12, List r13, int r14, int r15, List r16, int r17, String r18) {
        r11.g(r12, r13, r14, r15, r16, r17, r18, null, null, null);
    }

    public static Unit d(SearchImageInfo r58, j2 r59, List r60, List r61, int r62, int r63, int r64, String r65, SimpleDraweeView r66) {
        Intrinsics.checkNotNullParameter(r66, "it");
        FLogger.a.d("image-group", "onClick " + r58);
        if (r59.getContext() == null) goto L219;
        List r3 = r60;
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r4 = r3.iterator();
        int r5 = 0;
    L7:
        if (r4.hasNext() == false) goto L12;
        Object r6 = r4.next();
        int r7 = r5 + 1;
        if (r5 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        r13.add(TuplesKt.to(Integer.valueOf(r5), (View) r6));
        r5 = r7;
        goto L7
    L12:
        SearchImageInfo r8 = (SearchImageInfo) CollectionsKt.getOrNull(r61, r64);
        int r9 = r59.getWidgetOrder();
        ri8.c r10 = ri8.c.a;
        if (r8 == null) goto L17;
        Long r11 = r8.getCardId();
        if (r11 == null) goto L17;
        String r18 = r11.toString();
    L18:
        Message r12 = r59.d;
        if (r12 == null) goto L21;
        String r19 = r12.getMessageId();
    L22:
        Message r14 = r59.d;
        if (r14 == null) goto L25;
        String r20 = r14.getConversationId();
    L26:
        Message r15 = r59.d;
        if (r15 == null) goto L29;
        String r21 = r15.getReplyId();
    L30:
        String r16 = r59.f;
        String r17 = r59.g;
        BotModel r22 = r59.e;
        if (r22 == null) goto L33;
        String r29 = r22.getBotId();
    L34:
        String r30 = ri8.c.h(r62, r63);
        Message r23 = r59.d;
        if (r23 == null) goto L37;
        String r36 = com.larus.bmhome.chat.bean.d.x(r23).getReqId();
    L38:
        int r24 = r64 + 1;
        Integer[] r25 = new Integer[2];
        if (r8 == null) goto L43;
        Integer r26 = r8.getOriginWidth();
        if (r26 == null) goto L43;
        int r27 = r26.intValue();
    L44:
        r25[0] = Integer.valueOf(r27);
        if (r8 == null) goto L49;
        Integer r28 = r8.getOriginHeight();
        if (r28 == null) goto L49;
        int r31 = r28.intValue();
    L50:
        r25[1] = Integer.valueOf(r31);
        ri8.c.m(r18, r19, r20, r21, r16, r17, Integer.valueOf(r9), Integer.valueOf(r24), "slideshow", "within_text", "picture", r29, r30, r65, "open_media", null, Integer.valueOf(r9), null, r36, null, null, CollectionsKt.listOf(r25), null, r59.h, null, null, null, null, AbsBlockView.a.d(r59.b), null, null, null, null, null, null, null, null, null, -279281664, 63);
        View r110 = (View) CollectionsKt.getOrNull(r60, r64);
        if (r64 < 0) goto L121;
        Message r32 = r59.d;
        if (r32 == null) goto L121;
        String r33 = r32.getConversationId();
        if (r33 == null) goto L121;
        String r34 = r32.getMessageId();
        if (r34 == null) goto L121;
        fh8.f r0 = r59.j;
        if (r0 == null) goto L67;
        Function0<? extends Fragment> r1 = r0.m;
        if (r1 == null) goto L67;
        Fragment r35 = (Fragment) r1.invoke();
    L210:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L74
        if (r35 == null) goto L71;
        FragmentManager r37 = r35.getParentFragmentManager();     // Catch: Throwable -> L74
    L72:
        Object r38 = Result.constructor-impl(r37);     // Catch: Throwable -> L74
    L77:
        if (Result.isFailure-impl(r38) == false) goto L79;
        r38 = null;
    L79:
        FragmentManager r39 = (FragmentManager) r38;
        if (r39 != null) goto L94;
        if (r35 == null) goto L85;
        FragmentActivity r40 = r35.getActivity();
        if (r40 == null) goto L85;
        r39 = r40.getSupportFragmentManager();
    L86:
        if (r39 != null) goto L94;
        FragmentActivity r41 = r59.getContext();
        if ((r41 instanceof FragmentActivity) == false) goto L90;
        FragmentActivity r42 = r41;
    L91:
        if (r42 == null) goto L93;
        r39 = r42.getSupportFragmentManager();
        goto L94
    L93:
        FragmentManager r43 = null;
    L95:
        if (r43 == null) goto L121;
        z2 r44 = z2.a;
        int r45 = r44.getCreationDetailLayoutConfig().c();
        fh8.f r46 = r59.j;
        if (r46 == null) goto L108;
        com.larus.bmhome.chat.api.q0 r47 = r46.q;
        if (r47 == null) goto L108;
        com.larus.bmhome.chat.api.q0.a r48 = r47.getProvider();
        if (r48 == null) goto L108;
        com.larus.bmhome.chat.component.cvs.y r49 = r48.u0();
        if (r49 == null) goto L108;
        wc9.e r50 = r49.h();
        if (r50 == null) goto L108;
        Integer r51 = r50.v;
    L109:
        IChatGalleryService.Companion r111 = IChatGalleryService.a;
        if (r111.h(Intrinsics.areEqual(r59.i, Boolean.TRUE)) == false) goto L119;
        if (1 > r45) goto L114;
        if (r45 >= 7) goto L114;
        boolean r52 = true;
    L115:
        if (r52 == false) goto L119;
        String r53 = r32.getConversationId();
        r44.w3();
        if (com.larus.bmhome.utils.i.e(r53, r51) == false) goto L119;
        boolean r54 = true;
    L120:
        if (r54 == false) goto L121;
        Context r55 = r59.getContext();
        fh8.f r56 = r59.j;
        if (r56 == null) goto L125;
        com.larus.bmhome.chat.api.q0 r57 = r56.q;
    L126:
        char r210 = 7;
        char r211 = 1;
        int r112 = 10;
        IChatGalleryService.a.a(r111, r55, r43, r33, r34, r32, r57, r64, r110, PreviewScene.SEARCH_IMAGE, 768);
        boolean r113 = true;
    L127:
        if (r113 == true) goto L209;
        Context r67 = r59.getContext();
        List r68 = r61;
        ArrayList r69 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r68, r112));
        Iterator r70 = r68.iterator();
    L130:
        String r71 = "";
        if (r70.hasNext() == false) goto L164;
        SearchImageInfo r72 = (SearchImageInfo) r70.next();
        String r73 = r72.getItemId();
        if (r73 != null) goto L135;
        String r212 = "";
    L136:
        List r74 = r72.getFullSizeUrl();
        if (r74 == null) goto L140;
        String r75 = (String) CollectionsKt.firstOrNull(r74);
        if (r75 == null) goto L140;
    L141:
        if (r75 != null) goto L143;
        String r213 = "";
    L144:
        String r76 = r72.getUri();
        if (r76 != null) goto L147;
        String r214 = "";
    L148:
        String r215 = r72.getAuthorShortId();
        String r216 = r72.getSourceAppName();
        String r217 = r72.getSourceAppIcon();
        Integer r310 = r72.getSourceFrom();
        String r311 = r72.getMainSiteUrl();
        String r77 = r72.getOriginThumbUrl();
        if (r77 != null) goto L151;
    L154:
        boolean r114 = true;
    L155:
        if (r114 == true) goto L159;
        String r78 = r72.getOriginThumbUrl();
        if (r78 == null) goto L163;
    L162:
        r71 = r78;
    L163:
        r69.add(new com.larus.bmhome.bigimg.l(r212, r213, r214, r71, r215, r216, r217, r310, r311, r72.getImgCaption(), 1024));
        goto L130
    L159:
        r78 = r72.getThumbUrl();
        if (r78 != null) goto L162;
    L151:
        if (r77.length() == 0) goto L154;
        r114 = false;
        goto L155
    L147:
        r214 = r76;
        goto L148
    L143:
        r213 = r75;
    L140:
        r75 = r72.getThumbUrl();
        goto L141
    L135:
        r212 = r73;
        goto L136
    L164:
        Pair[] r79 = new Pair[12];
        r79[0] = TuplesKt.to("user_type", "bot");
        String r80 = "chat";
        r79[r211] = TuplesKt.to("enter_picture_method", "chat");
        if (Intrinsics.areEqual(r59.i, Boolean.TRUE) == false) goto L167;
        r80 = "temporary_chat";
    L167:
        r79[2] = TuplesKt.to("enter_from", r80);
        BotModel r81 = r59.e;
        if (r81 == null) goto L171;
        String r82 = r81.getBotId();
        if (r82 == null) goto L171;
    L172:
        r79[3] = TuplesKt.to("bot_id", r82);
        r79[4] = TuplesKt.to("chat_type", "default");
        String r83 = r59.g;
        if (r83 != null) goto L175;
        r83 = "";
    L175:
        r79[5] = TuplesKt.to("previous_page", r83);
        String r84 = r59.f;
        if (r84 != null) goto L178;
        r84 = "";
    L178:
        r79[6] = TuplesKt.to("current_page", r84);
        Message r85 = r59.d;
        if (r85 == null) goto L184;
        String r86 = r85.getConversationId();
        if (r86 == null) goto L184;
        r71 = r86;
    L184:
        r79[r210] = TuplesKt.to("conversation_id", r71);
        r79[8] = TuplesKt.to("rich_media_type", "mixed_picture");
        Message r87 = r59.d;
        if (r87 == null) goto L187;
        String r88 = r87.getReplyId();
    L188:
        r79[9] = TuplesKt.to("reply_id", String.valueOf(r88));
        Message r89 = r59.d;
        if (r89 == null) goto L191;
        String r90 = com.larus.bmhome.chat.bean.d.x(r89).getReqId();
    L192:
        r79[r112] = TuplesKt.to("req_id", String.valueOf(r90));
        Message r91 = r59.d;
        if (r91 == null) goto L195;
        String r92 = r91.getMessageId();
    L196:
        r79[11] = TuplesKt.to("message_id", String.valueOf(r92));
        Map r93 = MapsKt.mapOf(r79);
        ArrayList r94 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r68, r112));
        Iterator r95 = r68.iterator();
        int r96 = 0;
    L198:
        if (r95.hasNext() == false) goto L203;
        Object r97 = r95.next();
        int r115 = r96 + 1;
        if (r96 >= 0) goto L202;
        CollectionsKt.throwIndexOverflow();
    L202:
        SearchImageInfo r99 = (SearchImageInfo) r97;
        Pair[] r100 = new Pair[3];
        ri8.c r116 = ri8.c.a;
        Integer[] r117 = new Integer[2];
        r117[0] = r99.getOriginWidth();
        r117[r211] = r99.getOriginHeight();
        r100[0] = TuplesKt.to("image_resolution", ri8.c.a(CollectionsKt.listOf(r117)));
        r100[r211] = TuplesKt.to("card_id", String.valueOf(r99.getCardId()));
        r100[2] = TuplesKt.to("position", Integer.valueOf(r115));
        r94.add(MapsKt.mapOf(r100));
        r96 = r115;
        goto L198
    L203:
        uo8.k r101 = new uo8.k(r93, r94);
        HybridEventParams r118 = new HybridEventParams("message_markdown_image", "chat", "default", null, 120);
        Message r102 = r59.d;
        if (r102 == null) goto L206;
        String r103 = r102.getMessageId();
    L207:
        com.larus.bmhome.bigimg.k.c(r67, r13, r69, r64, r101, true, r118, r103, false, null, null, null, null, 15104);
        goto L209
    L206:
        r103 = null;
        goto L207
    L195:
        r92 = null;
        goto L196
    L191:
        r90 = null;
        goto L192
    L187:
        r88 = null;
    L171:
        r82 = "";
    L209:
        return Unit.INSTANCE;
    L125:
        r57 = null;
    L114:
        r52 = false;
    L119:
        r54 = false;
    L108:
        r51 = null;
        goto L109
    L90:
        r42 = null;
    L85:
        r39 = null;
    L94:
        r43 = r39;
        goto L95
    L71:
        r37 = null;
    L74:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r38 = Result.constructor-impl(ResultKt.createFailure(th));
    L67:
        r35 = null;
    L121:
        r113 = false;
        r112 = 10;
        r210 = 7;
        r211 = 1;
    L49:
        r31 = 0;
    L43:
        r27 = 0;
        goto L44
    L37:
        r36 = null;
        goto L38
    L33:
        r29 = null;
        goto L34
    L29:
        r21 = null;
        goto L30
    L25:
        r20 = null;
        goto L26
    L21:
        r19 = null;
    L17:
        r18 = null;
        goto L18
    L219:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r13v0, types: [com.larus.bmhome.chat.deepresearch.view.p1] */
    /* JADX WARN: Type inference failed for: r14v0, types: [com.larus.bmhome.chat.deepresearch.view.a2] */
    /* JADX WARN: Type inference failed for: r16v0, types: [com.larus.bmhome.chat.deepresearch.view.b2] */
    public final void g(SimpleDraweeView r20, final List<? extends View> r21, final int r22, final int r23, final List<SearchImageInfo> r24, final int r25, final String r26, final Function0<Unit> r27, final Function0<Unit> r28, final Function0<Unit> r29) {
        final SearchImageInfo r11 = (SearchImageInfo) CollectionsKt.getOrNull(r24, r25);
        if (r11 != null) goto L5;
        return;
    L5:
        final String r0 = UUID.randomUUID().toString();
        String r1 = r11.getOriginThumbUrl();
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new SearchImageBlockView$preloadImage$1(r1, null), 2, null);
        int r2 = j.a;
        String r3 = r11.getThumbUrl();
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        j.b(r20, r3, "markdown.image_group_cover_thumb", Integer.valueOf(r22), Integer.valueOf(r23), new p1(r0, r11, this, r25, r28), new a2(this, r0, r29), new b2(r0, this, r11, r25, r27), true, 512);
        com.larus.utils.e1.d(r20, new c2(r11, this, r21, r24, r22, r23, r25, r26));
        r20.setOnLongClickListener(new d2());
    }
}
