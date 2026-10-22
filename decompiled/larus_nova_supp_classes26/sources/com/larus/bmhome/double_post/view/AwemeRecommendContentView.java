package com.larus.bmhome.double_post.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.markdown.videogroup.VideoGroupV2Widget;
import com.larus.bmhome.video.AuthorInfo;
import com.larus.bmhome.video.CardRatioStrategy;
import com.larus.bmhome.video.Content;
import com.larus.bmhome.video.ContentCover;
import com.larus.bmhome.video.ContentDescription;
import com.larus.bmhome.video.InteractInfo;
import com.larus.bmhome.video.InteractionStatistic;
import com.larus.bmhome.video.InteractionStatus;
import com.larus.bmhome.video.ItemType;
import com.larus.bmhome.view.RoundAvatarImageView;
import com.larus.chat.common.databinding.LarusCardAwemeAuthorInfoBinding;
import com.larus.chat.common.databinding.LarusCardAwemeRecommendContentBinding;
import com.larus.common_ui.venus.ShapeConstraintLayout;
import com.larus.im.bean.conversation.IconImage;
import com.larus.im.bean.message.ImageObj;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import com.larus.utils.o0;
import ip8.e;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kp8.b;
import kp8.c;
import kp8.f;
import rh8.j;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 *2\u00020\u0001:\u0001*B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0012\u0010\u001a\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0018\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u0016H\u0002J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010!\u001a\u00020\u0016H\u0002J\b\u0010\"\u001a\u00020\u0016H\u0002J\"\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0002J\u0012\u0010)\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0003R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/larus/bmhome/double_post/view/AwemeRecommendContentView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "viewBinding", "Lcom/larus/chat/common/databinding/LarusCardAwemeRecommendContentBinding;", "data", "Lcom/larus/bmhome/video/Content;", "clickX", "", "clickY", "screenPos", "", "init", "", "bindData", "dependency", "Lcom/larus/bmhome/double_post/adapter/IAwemeRecommendAdapterDependency;", "setupMainView", "setupCover", "coverWidth", "isMixedWithText", "", "setupPlayerIcon", "setupDescription", "setupAuthorInfo", "setupInteraction", "setupLikedStatus", "isLiked", "likedCount", "", "formattedLikedCount", "", "setupListeners", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AwemeRecommendContentView extends FrameLayout {
    public static final /* synthetic */ int f = 0;
    public LarusCardAwemeRecommendContentBinding a;
    public Content b;
    public float c;
    public float d;
    public final int[] e;

    public static final class a {
        public static String a(Content r2) {
            if (r2 == null) goto L4;
            Integer r3 = r2.getItemType();
        L5:
            int r0 = ItemType.VIDEO.getValue();
            if (r3 != null) goto L9;
        L11:
            int r1 = ItemType.ARTICLE.getValue();
            if (r3 != null) goto L15;
        L17:
            return "";
        L15:
            if (r3.intValue() != r1) goto L17;
            return "aweme_recommend_card_cover_post";
        L9:
            if (r3.intValue() != r0) goto L11;
            return "aweme_recommend_card_cover_video";
        L4:
            r3 = null;
            goto L5
        }

        public static ImageObj b(ContentCover r2) {
            if (r2 == null) goto L8;
            IconImage r0 = r2.getSelectedCover();
            if (r0 == null) goto L8;
            ImageObj r1 = r0.imageOri;
            if (r1 == null) goto L8;
            return r1;
        L8:
            if (r2 == null) goto L12;
            IconImage r3 = r2.getOriginCover();
            if (r3 == null) goto L12;
            ImageObj r4 = r3.imageOri;
        L13:
            if (r4 != null) goto L19;
            if (r2 == null) goto L21;
            IconImage r5 = r2.getDynamicCover();
            if (r5 != null) goto L23;
            return null;
        L23:
            return r5.imageOri;
        L21:
            return null;
        L19:
            return r4;
        L12:
            r4 = null;
            goto L13
        }
    }

    static {
    }

    public AwemeRecommendContentView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.e = new int[2];
        b(r2);
    }

    private final void setupDescription(boolean r9) {
        Content r0 = this.b;
        if (r0 == null) goto L60;
        ContentDescription r1 = r0.getContentDescription();
        if (r1 != null) goto L7;
        return;
    L7:
        if (o0.d(r1.getTitle()) == false) goto L10;
        String r2 = r1.getTitle();
    L13:
        LarusCardAwemeRecommendContentBinding r3 = this.a;
        if (r3 == null) goto L62;
        AppCompatTextView r4 = r3.g;
        if (r4 == null) goto L63;
        Content r5 = this.b;
        Integer r6 = null;
        if (r5 == null) goto L22;
        CardRatioStrategy r7 = r5.getRatioStrategy();
        if (r7 == null) goto L22;
        Integer r8 = Integer.valueOf(r7.getValue());
    L23:
        CardRatioStrategy r10 = CardRatioStrategy.FixRatio;
        int r11 = r10.getValue();
        int r12 = -2;
        if (r8 == null) goto L40;
        if (r8.intValue() != r11) goto L40;
        e1.x(r4);
        ViewGroup.LayoutParams r13 = r4.getLayoutParams();
        if (r13 == null) goto L38;
        Lazy r14 = f.a;
        Integer r15 = Integer.valueOf(r10.getValue());
        int r16 = r10.getValue();
        if (r15 != null) goto L34;
    L36:
        r13.height = r12;
        r4.setLayoutParams(r13);
        r4.setText(r2);
        return;
    L34:
        if (r15.intValue() != r16) goto L36;
        r12 = i5.Z();
        goto L36
    L38:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L40:
        if (o0.d(r2) == true) goto L44;
        if (r9 == true) goto L44;
        e1.o(r4);
        return;
    L44:
        e1.x(r4);
        ViewGroup.LayoutParams r17 = r4.getLayoutParams();
        if (r17 == null) goto L59;
        Lazy r18 = f.a;
        Content r19 = this.b;
        if (r19 == null) goto L51;
        CardRatioStrategy r20 = r19.getRatioStrategy();
        if (r20 == null) goto L51;
        r6 = Integer.valueOf(r20.getValue());
    L51:
        int r21 = r10.getValue();
        if (r6 != null) goto L55;
    L57:
        r17.height = r12;
        r4.setLayoutParams(r17);
        r4.setText(r2);
        return;
    L55:
        if (r6.intValue() != r21) goto L57;
        r12 = i5.Z();
        goto L57
    L59:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L22:
        r8 = null;
        goto L23
    L63:
        return;
    L62:
        return;
    L10:
        if (o0.d(r1.getDescription()) == false) goto L12;
        r2 = r1.getDescription();
        goto L13
    L12:
        r2 = "";
        goto L13
    }

    private final void setupListeners(ip8.f r4) {
        final LarusCardAwemeRecommendContentBinding r0 = this.a;
        if (r0 == null) goto L10;
        if (r4 == null) goto L8;
        final e r5 = r4.e();
        if (r5 == null) goto L8;
        e1.d(r0.a, new kp8.a(this, r5));
        r0.a.setOnLongClickListener(new b(this, r5));
    L8:
        r0.a.setOnTouchListener(new c(r0, this));
        return;
    }

    private final void setupMainView(ip8.f r6) {
        if (r6 == null) goto L7;
        boolean r2 = true;
        if (r6.b() != true) goto L7;
    L8:
        if (r2 == false) goto L17;
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(r6.d(), -1);
        if (r6.a() == false) goto L12;
        r1.leftMargin = i5.j0();
        r1.rightMargin = i5.j0();
        r1.topMargin = i5.j0();
        r1.bottomMargin = i5.j0();
    L12:
        setLayoutParams(r1);
        LarusCardAwemeRecommendContentBinding r7 = this.a;
        if (r7 == null) goto L36;
        ShapeConstraintLayout r8 = r7.f;
        if (r8 == null) goto L37;
        ShapeConstraintLayout.U5(r8, ContextCompat.getColor(getContext(), v19.c.b(2130970534, getContext(), 2131102545)), 0, 0, 510);
        return;
    L37:
        return;
    L36:
        return;
    L17:
        if (r6 == null) goto L19;
        r6.c();
    L19:
        Lazy r9 = com.larus.bmhome.video.b.a;
        int r10 = com.larus.bmhome.video.b.b(false);
        LarusCardAwemeRecommendContentBinding r3 = this.a;
        ViewGroup.MarginLayoutParams r4 = null;
        if (r3 == null) goto L24;
        ShapeConstraintLayout r5 = r3.f;
        if (r5 == null) goto L24;
        ViewGroup.LayoutParams r11 = r5.getLayoutParams();
    L26:
        if ((r11 instanceof ViewGroup.MarginLayoutParams) == false) goto L28;
        r4 = (ViewGroup.MarginLayoutParams) r11;
    L28:
        if (r4 == null) goto L30;
        r4.leftMargin = r10;
        r4.topMargin = r10;
        r4.rightMargin = r10;
        r4.bottomMargin = r10;
    L30:
        LarusCardAwemeRecommendContentBinding r12 = this.a;
        if (r12 == null) goto L39;
        ShapeConstraintLayout r13 = r12.e;
        if (r13 == null) goto L40;
        ShapeConstraintLayout.U5(r13, 0, 0, com.larus.bmhome.video.b.c(false), 255);
        return;
    L40:
        return;
    L39:
        return;
    L24:
        r11 = null;
    L7:
        r2 = false;
        goto L8
    }

    public final void b(Context r10) {
        LayoutInflater.from(r10).inflate(2131561864, this);
        int r11 = 2131363579;
        View r0 = ViewBindings.findChildViewById(this, 2131363579);
        if (r0 == null) goto L17;
        LarusCardAwemeAuthorInfoBinding r3 = LarusCardAwemeAuthorInfoBinding.a(r0);
        r11 = 2131368133;
        SimpleDraweeView r4 = ViewBindings.findChildViewById(this, 2131368133);
        if (r4 == null) goto L17;
        r11 = 2131382468;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(this, 2131382468);
        if (r5 == null) goto L17;
        r11 = 2131386031;
        ShapeConstraintLayout r6 = ViewBindings.findChildViewById(this, 2131386031);
        if (r6 == null) goto L17;
        r11 = 2131386046;
        ShapeConstraintLayout r7 = ViewBindings.findChildViewById(this, 2131386046);
        if (r7 == null) goto L17;
        r11 = 2131388772;
        AppCompatTextView r8 = ViewBindings.findChildViewById(this, 2131388772);
        if (r8 == null) goto L17;
        this.a = new LarusCardAwemeRecommendContentBinding(this, r3, r4, r5, r6, r7, r8);
        return;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r11)));
    }

    public AwemeRecommendContentView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3);
        this.e = new int[2];
        b(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v9 */
    public final void a(Content r10, j r11) {
        this.b = r10;
        setupMainView(r11);
        int r12 = VideoGroupV2Widget.i;
        Content r0 = this.b;
        boolean r2 = false;
        String r3 = null;
        if (r0 == null) goto L43;
        ContentCover r1 = r0.getCover();
        if (r1 == null) goto L43;
        LarusCardAwemeRecommendContentBinding r4 = this.a;
        if (r4 == null) goto L43;
        SimpleDraweeView r5 = r4.c;
        if (r5 == null) goto L43;
        r5.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadii(i5.Y(), i5.Y(), 0.0f, 0.0f));
        ImageObj r6 = a.b(r1);
        e1.x(r5);
        Lazy r7 = f.a;
        if (r6 == null) goto L13;
        int r8 = r6.width;
    L14:
        if (r6 == null) goto L16;
        int r9 = r6.height;
    L17:
        Content r13 = this.b;
        if (r13 == null) goto L22;
        CardRatioStrategy r14 = r13.getRatioStrategy();
        if (r14 == null) goto L22;
        Integer r15 = Integer.valueOf(r14.getValue());
    L24:
        if (r12 > 0) goto L26;
        Pair r16 = new Pair(0, 0);
    L38:
        int r17 = ((Number) r16.component1()).intValue();
        int r18 = ((Number) r16.component2()).intValue();
        ViewGroup.LayoutParams r19 = r5.getLayoutParams();
        r19.height = r18;
        r19.width = r17;
        r5.setLayoutParams(r19);
        if (r6 == null) goto L41;
        String r110 = r6.url;
    L42:
        ImageLoaderKt.u(r5, r110, a.a(this.b));
        goto L43
    L41:
        r110 = null;
        goto L42
    L26:
        if (r15 == null) goto L28;
        ?? r20 = r15.intValue();
    L29:
        if (r8 <= 0) goto L31;
        if (r9 <= 0) goto L31;
    L33:
        if (r20 == 0) goto L37;
        if (r20 == 1) goto L36;
        r16 = f.a(r12, r8, r9);
        goto L38
    L36:
        r16 = new Pair(Integer.valueOf(r12), Integer.valueOf((int) (r12 * ((Number) f.b.getValue()).floatValue())));
        goto L38
    L37:
        r16 = f.a(r12, r8, r9);
    L31:
        if (r20 != 0) goto L33;
        r16 = new Pair(0, 0);
        goto L38
    L28:
        r20 = ((Boolean) f.a.getValue()).booleanValue();
    L22:
        r15 = null;
        goto L24
    L16:
        r9 = 0;
        goto L17
    L13:
        r8 = 0;
    L43:
        LarusCardAwemeRecommendContentBinding r111 = this.a;
        if (r111 == null) goto L59;
        ImageView r112 = r111.d;
        if (r112 == null) goto L59;
        Content r21 = this.b;
        if (r21 == null) goto L55;
        Integer r22 = r21.getItemType();
        int r23 = ItemType.VIDEO.getValue();
        if (r22 == null) goto L55;
        if (r22.intValue() != r23) goto L55;
        boolean r24 = true;
    L56:
        if (r24 == false) goto L58;
        e1.x(r112);
        goto L59
    L58:
        e1.o(r112);
    L55:
        r24 = false;
    L59:
        setupDescription(true);
        Content r113 = this.b;
        if (r113 == null) goto L74;
        AuthorInfo r114 = r113.getAuthorInfo();
        if (r114 == null) goto L74;
        LarusCardAwemeRecommendContentBinding r25 = this.a;
        if (r25 == null) goto L74;
        LarusCardAwemeAuthorInfoBinding r26 = r25.b;
        if (r26 == null) goto L74;
        RoundAvatarImageView r27 = r26.b;
        IconImage r28 = r114.getAvatar();
        if (r28 == null) goto L72;
        ImageObj r29 = r28.imageThumb;
        if (r29 == null) goto L72;
        String r30 = r29.url;
    L73:
        ImageLoaderKt.u(r27, r30, "aweme_recommend_card_avatar");
        r26.e.setText(r114.getNickName());
    L72:
        r30 = null;
    L74:
        Content r115 = this.b;
        if (r115 == null) goto L92;
        InteractInfo r116 = r115.getInteractInfo();
        if (r116 == null) goto L92;
        InteractionStatus r31 = r116.getStatus();
        if (r31 == null) goto L81;
        r2 = r31.isLiked();
    L81:
        InteractionStatistic r32 = r116.getStatistic();
        if (r32 == null) goto L84;
        r32.getLikedCount();
    L84:
        InteractionStatistic r117 = r116.getStatistic();
        if (r117 == null) goto L87;
        r3 = r117.getFormattedLikedCount();
    L87:
        LarusCardAwemeRecommendContentBinding r118 = this.a;
        if (r118 == null) goto L92;
        LarusCardAwemeAuthorInfoBinding r119 = r118.b;
        if (r119 == null) goto L92;
        r119.d.setSelected(r2);
        r119.c.setText(r3);
    L92:
        setupListeners(r11);
    }

    public AwemeRecommendContentView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3, r4);
        this.e = new int[2];
        b(r2);
    }
}
