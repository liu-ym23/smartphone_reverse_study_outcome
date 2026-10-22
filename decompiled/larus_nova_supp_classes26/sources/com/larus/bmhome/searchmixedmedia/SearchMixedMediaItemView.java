package com.larus.bmhome.searchmixedmedia;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.monitor.IMessageImageLoaderService;
import com.larus.bmhome.chat.monitor.MessageImageLoader;
import com.larus.bmhome.chat.monitor.MessageImageType;
import com.larus.bmhome.video.ItemType;
import com.larus.bmhome.video.b;
import com.larus.bmhome.view.RoundAvatarImageView;
import com.larus.chat.common.databinding.LarusCardAwemeAuthorInfoBinding;
import com.larus.chat.common.databinding.LarusItemSearchMixedMediaCardBinding;
import com.larus.common_ui.venus.ShapeConstraintLayout;
import com.larus.platform.service.g;
import com.larus.utils.e1;
import com.larus.utils.y0;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import pr8.c;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u0019\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0017J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0016J \u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020\u000bJ\u0012\u0010*\u001a\u00020$2\b\b\u0002\u0010)\u001a\u00020\u000bH\u0002J\u0018\u0010+\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010,\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020\u000bH\u0002J\u0018\u0010/\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u00100\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u00101\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u00102\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J!\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u000106H\u0002¢\u0006\u0002\u00108R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u0011\u0010\u001f\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u00069"}, d2 = {"Lcom/larus/bmhome/searchmixedmedia/SearchMixedMediaItemView;", "Landroid/widget/FrameLayout;", "Lcom/larus/bmhome/view/textview/api/selector/IGestureTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "downListener", "Lkotlin/Function0;", "", "getDownListener", "()Lkotlin/jvm/functions/Function0;", "setDownListener", "(Lkotlin/jvm/functions/Function0;)V", "clickX", "", "getClickX", "()F", "setClickX", "(F)V", "clickY", "getClickY", "setClickY", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "asTextView", "", "getContainer", "binding", "Lcom/larus/chat/common/databinding/LarusItemSearchMixedMediaCardBinding;", "getBinding", "()Lcom/larus/chat/common/databinding/LarusItemSearchMixedMediaCardBinding;", "bind", "", "item", "Lcom/larus/bmhome/searchmixedmedia/SearchMixedMediaCardInput;", "ratioMode", "Lcom/larus/bmhome/searchmixedmedia/RatioMode;", "needShadow", "setupMainView", "applyCoverRatio", "loadCoverImage", "configPlayIcon", "isVideo", "bindDescription", "bindAvatar", "bindUserName", "bindLike", "buildDynamicRatio", "", "coverWidth", "", "coverHeight", "(Ljava/lang/Integer;Ljava/lang/Integer;)Ljava/lang/String;", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchMixedMediaItemView extends FrameLayout implements st8.a {
    public static final /* synthetic */ int e = 0;
    public Function0<Boolean> a;
    public float b;
    public float c;
    public final LarusItemSearchMixedMediaCardBinding d;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RatioMode.values().length];
            r0[RatioMode.FIXED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[RatioMode.DYNAMIC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    @Override // st8.a
    public final View l5() {
        return null;
    }

    public FrameLayout getContainer() {
        ViewParent r0 = getParent();
        if (r0 != null) goto L6;
        return null;
    L6:
        if ((r0 instanceof FrameLayout) == false) goto L8;
        FrameLayout r2 = (FrameLayout) r0;
    L9:
        if (r2 != null) goto L12;
        g.a.ensureNotReachHere(new IllegalStateException("this view must use FrameLayout as parent. current parent is " + r0), "");
        return null;
    L12:
        return r2;
    L8:
        r2 = null;
        goto L9
    }

    public final LarusItemSearchMixedMediaCardBinding getBinding() {
        return this.d;
    }

    @Override // st8.a
    public float getClickX() {
        return this.b;
    }

    @Override // st8.a
    public float getClickY() {
        return this.c;
    }

    public Function0<Boolean> getDownListener() {
        return this.a;
    }

    public SearchMixedMediaItemView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    private final void setupMainView(boolean r5) {
        Lazy r0 = b.a;
        int r1 = b.b(false);
        ViewGroup.LayoutParams r2 = this.d.f.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
    L6:
        if (r3 == null) goto L8;
        r3.leftMargin = r1;
        r3.topMargin = r1;
        r3.rightMargin = r1;
        r3.bottomMargin = r1 + i5.b();
    L8:
        ShapeConstraintLayout r4 = this.d.e;
        int r6 = b.c(false);
        if (r5 == false) goto L11;
        int r7 = getContext().getResources().getColor(2131102555);
    L12:
        ShapeConstraintLayout.U5(r4, 0, r7, r6, 127);
        return;
    L11:
        r7 = -1;
        goto L12
    L5:
        r3 = null;
        goto L6
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r4) {
        boolean r0 = false;
        if (r4 != null) goto L6;
        return false;
    L6:
        if (r4.getAction() != 0) goto L9;
        setClickX(r4.getX());
        setClickY(r4.getY());
    L9:
        if (r4.getAction() != 0) goto L18;
        Function0<Boolean> r1 = getDownListener();
        if (r1 != null) goto L13;
    L15:
        if (r0 == false) goto L18;
        return true;
    L13:
        if (((Boolean) r1.invoke()).booleanValue() != true) goto L15;
        r0 = true;
    L18:
        return super.onTouchEvent(r4);
    }

    public void setClickX(float r1) {
        this.b = r1;
    }

    public void setClickY(float r1) {
        this.c = r1;
    }

    public void setDownListener(Function0<Boolean> r1) {
        this.a = r1;
    }

    public SearchMixedMediaItemView(Context r9, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10);
        LayoutInflater.from(r9).inflate(2131562653, this);
        int r11 = 2131363579;
        View r12 = ViewBindings.findChildViewById(this, 2131363579);
        if (r12 == null) goto L17;
        LarusCardAwemeAuthorInfoBinding r2 = LarusCardAwemeAuthorInfoBinding.a(r12);
        r11 = 2131368133;
        SimpleDraweeView r3 = ViewBindings.findChildViewById(this, 2131368133);
        if (r3 == null) goto L17;
        r11 = 2131382468;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(this, 2131382468);
        if (r4 == null) goto L17;
        r11 = 2131386031;
        ShapeConstraintLayout r5 = ViewBindings.findChildViewById(this, 2131386031);
        if (r5 == null) goto L17;
        r11 = 2131386046;
        ShapeConstraintLayout r6 = ViewBindings.findChildViewById(this, 2131386046);
        if (r6 == null) goto L17;
        r11 = 2131388772;
        AppCompatTextView r7 = ViewBindings.findChildViewById(this, 2131388772);
        if (r7 == null) goto L17;
        this.d = new LarusItemSearchMixedMediaCardBinding(this, r2, r3, r4, r5, r6, r7);
        return;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r11)));
    }

    public final void a(c r22, RatioMode r23, boolean r24) {
        Intrinsics.checkNotNullParameter(r22, "item");
        Intrinsics.checkNotNullParameter(r23, "ratioMode");
        setupMainView(r24);
        ViewGroup.LayoutParams r3 = this.d.c.getLayoutParams();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams r4 = (ConstraintLayout.LayoutParams) r3;
        int r5 = a.a[r23.ordinal()];
        if (r5 == 1) goto L16;
        if (r5 != 2) goto L15;
        Integer r6 = r22.c;
        Integer r7 = r22.d;
        if (r6 == null) goto L8;
        int r8 = r6.intValue();
    L9:
        int r9 = RangesKt.coerceAtLeast(r8, 1);
        if (r7 == null) goto L12;
        int r10 = r7.intValue();
    L13:
        String r11 = ((int) (RangesKt.coerceIn(((double) r9) / ((double) RangesKt.coerceAtLeast(r10, 1)), 0.75d, 1.3333333333333333d) * 1000.0d)) + ":1000";
    L17:
        ((ConstraintLayout.LayoutParams) r4).dimensionRatio = r11;
        this.d.c.setLayoutParams(r4);
        String r12 = r22.b;
        SimpleDraweeView r13 = this.d.c;
        r13.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadii(i5.r0(), i5.r0(), 0.0f, 0.0f));
        if (r12 == null) goto L48;
        Intrinsics.checkNotNull(r13);
        e1.x(r13);
        Integer r14 = r22.e;
        int r15 = ItemType.VIDEO.getValue();
        if (r14 != null) goto L23;
    L25:
        int r16 = ItemType.ARTICLE.getValue();
        if (r14 != null) goto L29;
    L32:
        String r17 = "";
    L33:
        Integer r18 = r22.e;
        int r19 = ItemType.ARTICLE.getValue();
        if (r18 != null) goto L37;
    L39:
        MessageImageType r20 = MessageImageType.VIDEO;
    L40:
        MessageImageType r21 = r20;
        MessageImageLoader r25 = MessageImageLoader.a;
        String r26 = r22.n;
        Uri r110 = y0.j(r12);
        if (r110 == null) goto L46;
        Uri r111 = y0.g(r110, "biz_tag", null);
        if (r111 == null) goto L46;
        String r112 = r111.toString();
        if (r112 == null) goto L46;
    L47:
        IMessageImageLoaderService.a.b(r25, r26, r21, r13, r112, r17, null, null, null, null, null, false, 2016);
    L49:
        Integer r27 = r22.e;
        int r28 = ItemType.VIDEO.getValue();
        if (r27 != null) goto L53;
    L55:
        boolean r29 = false;
    L56:
        if (r29 == false) goto L58;
        e1.x(this.d.d);
    L59:
        AppCompatTextView r30 = this.d.g;
        String r31 = r22.f;
        if (r31 != null) goto L63;
        r31 = "";
    L63:
        r30.setText(r31);
        if (r23 != RatioMode.FIXED) goto L66;
        this.d.g.setMaxLines(2);
        this.d.g.setMinLines(2);
    L67:
        String r2 = r22.g;
        if (r2 == null) goto L79;
        MessageImageLoader r32 = MessageImageLoader.a;
        String r33 = r22.n;
        MessageImageType r34 = MessageImageType.IMAGE;
        RoundAvatarImageView r113 = this.d.b.b;
        Uri r35 = y0.j(r2);
        if (r35 == null) goto L77;
        Uri r36 = y0.g(r35, "biz_tag", null);
        if (r36 == null) goto L77;
        String r37 = r36.toString();
        if (r37 == null) goto L77;
        String r114 = r37;
    L78:
        IMessageImageLoaderService.a.b(r32, r33, r34, r113, r114, r22.m + ".aweme_recommend_card_avatar", null, null, null, null, null, false, 2016);
    L77:
        r114 = r2;
    L79:
        AppCompatTextView r38 = this.d.b.e;
        String r39 = r22.h;
        if (r39 != null) goto L83;
        r39 = "";
    L83:
        r38.setText(r39);
        this.d.b.d.setSelected(Intrinsics.areEqual(r22.i, Boolean.TRUE));
        AppCompatTextView r40 = this.d.b.c;
        String r1 = r22.j;
        if (r1 != null) goto L87;
        r1 = "";
    L87:
        r40.setText(r1);
        return;
    L66:
        this.d.g.setMaxLines(2);
        this.d.g.setMinLines(0);
        goto L67
    L58:
        e1.o(this.d.d);
        goto L59
    L53:
        if (r27.intValue() != r28) goto L55;
        r29 = true;
    L46:
        r112 = r12;
        goto L47
    L37:
        if (r18.intValue() != r19) goto L39;
        r20 = MessageImageType.IMAGE;
        goto L40
    L29:
        if (r14.intValue() != r16) goto L32;
        String r41 = r22.m + ".aweme_recommend_card_cover_post";
    L31:
        r17 = r41;
        goto L33
    L23:
        if (r14.intValue() != r15) goto L25;
        r41 = r22.m + ".aweme_recommend_card_cover_video";
        goto L31
    L48:
        Intrinsics.checkNotNull(r13);
        e1.o(r13);
        goto L49
    L12:
        r10 = 1;
        goto L13
    L8:
        r8 = 1;
        goto L9
    L15:
        throw new NoWhenBranchMatchedException();
    L16:
        r11 = "1:1.15";
        goto L17
    }
}
