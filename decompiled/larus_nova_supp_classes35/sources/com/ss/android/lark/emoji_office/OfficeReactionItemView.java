package com.ss.android.lark.emoji_office;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 32\u00020\u0001:\u000234B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010#J\u0010\u0010*\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010%J\b\u0010+\u001a\u00020(H\u0002J\u0010\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020.H\u0007J\u0010\u0010/\u001a\u00020(2\u0006\u00100\u001a\u00020\u0018H\u0002J\u0010\u00101\u001a\u00020(2\u0006\u00102\u001a\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R-\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0015\u001a\u0004\b\u001f\u0010 R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/ss/android/lark/emoji_office/OfficeReactionItemView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", BuildConfig.FLAVOR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "emojiIcon", "Landroid/widget/ImageView;", "avatarContainer", "Landroid/widget/FrameLayout;", "remainingCountText", "Landroid/widget/TextView;", "avatarViewPool", BuildConfig.FLAVOR, "getAvatarViewPool", "()Ljava/util/List;", "avatarViewPool$delegate", "Lkotlin/Lazy;", "requestBitmapListeners", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lcom/larksuite/framework/callback/IGetDataCallback;", BuildConfig.FLAVOR, "getRequestBitmapListeners", "()Ljava/util/Map;", "requestBitmapListeners$delegate", "avatarSize", "getAvatarSize", "()I", "avatarSize$delegate", "onReactionClickListener", "Lcom/ss/android/lark/emoji_office/OnReactionClickListener;", "onImageLoadedListener", "Lcom/ss/android/lark/emoji_office/OfficeReactionItemView$OnImageLoadedListener;", "currentReactionKey", "setOnReactionClickListener", BuildConfig.FLAVOR, "listener", "setOnImageLoadedListener", "initView", "setData", "model", "Lcom/ss/android/lark/reaction/widget/flowlayout/bean/ReactionFlowLayoutViewModel;", "updateEmojiIconSize", "reactionKey", "ensureAvatarViews", "requiredCount", "Companion", "OnImageLoadedListener", "lark-emoji-office_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeReactionItemView extends LinearLayout {
    public static final /* synthetic */ int h = 0;
    public ImageView a;
    public FrameLayout b;
    public TextView c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public String g;

    public static final class a {
    }

    public interface b {
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ OfficeReactionItemView a;

        public c(OfficeReactionItemView r1, String r2) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            OfficeReactionItemView r3 = this.a;
            int r0 = OfficeReactionItemView.h;
            r3.getClass();
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ OfficeReactionItemView a;

        public d(OfficeReactionItemView r1, int r2, String r3, String r4) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            OfficeReactionItemView r3 = this.a;
            int r0 = OfficeReactionItemView.h;
            r3.getClass();
        }
    }

    static {
    }

    public OfficeReactionItemView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public OfficeReactionItemView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void setOnImageLoadedListener(b r1) {
    }

    public final void setOnReactionClickListener(com.ss.android.lark.emoji_office.b r1) {
    }

    private final int getAvatarSize() {
        return ((Number) this.f.getValue()).intValue();
    }

    private final List<ImageView> getAvatarViewPool() {
        return (List) this.d.getValue();
    }

    private final Map<String, IGetDataCallback<Boolean>> getRequestBitmapListeners() {
        return (Map) this.e.getValue();
    }

    public static final /* synthetic */ Map a(OfficeReactionItemView r0) {
        return r0.getRequestBitmapListeners();
    }

    public final void b(String r4) {
        int r0 = UIHelper.dp2px(20.0f);
        qsb.a r5 = qsb.b.a().Yd(r4);
        if (r5 != null) goto L5;
    L7:
        int r6 = r0;
    L8:
        ImageView r1 = this.a;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("emojiIcon");
        r1 = null;
    L11:
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if (r2 == null) goto L16;
        LinearLayout.LayoutParams r3 = (LinearLayout.LayoutParams) r2;
        r3.width = r6;
        r3.height = r0;
        r1.setLayoutParams(r3);
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L5:
        if (r5.a() <= 0) goto L7;
        r6 = (int) ((r0 * r5.c()) / r5.a());
        goto L8
    }

    public final void setData(q2c.c r17) {
        Intrinsics.checkNotNullParameter(r17, "model");
        getRequestBitmapListeners().clear();
        final String r2 = r17.a;
        this.g = r2;
        ImageView r3 = this.a;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("emojiIcon");
        r3 = null;
    L5:
        r3.setOnClickListener(new c(this, r2));
        Intrinsics.checkNotNull(r2);
        b(r2);
        Bitmap r4 = qsb.b.a().v1(r2);
        if (r4 == null) goto L14;
        ImageView r9 = this.a;
        if (r9 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("emojiIcon");
        r9 = null;
    L10:
        r9.setScaleType(ImageView.ScaleType.FIT_CENTER);
        ImageView r10 = this.a;
        if (r10 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("emojiIcon");
        r10 = null;
    L13:
        r10.setImageBitmap(r4);
    L21:
        List r5 = r17.c;
        List r6 = r5;
        if (r6 != null) goto L24;
    L27:
        boolean r7 = true;
    L29:
        if (r7 == false) goto L42;
        Iterator<T> r1 = getAvatarViewPool().iterator();
    L32:
        if (r1.hasNext() == false) goto L34;
        ImageView r8 = (ImageView) r1.next();
        r8.setVisibility(8);
        r8.setImageDrawable(null);
        goto L32
    L34:
        TextView r11 = this.c;
        if (r11 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("remainingCountText");
        r11 = null;
    L37:
        r11.setVisibility(8);
        FrameLayout r12 = this.b;
        if (r12 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("avatarContainer");
        r12 = null;
    L40:
        r12.setOnClickListener(null);
        return;
    L42:
        int r13 = r5.size();
        int r14 = Math.min(r13, 5);
        if (r13 != 1) goto L45;
        String r15 = ((q2c.d) ListProtector.get(r5, 0)).a;
    L46:
        FrameLayout r16 = this.b;
        if (r16 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("avatarContainer");
        r16 = null;
    L49:
        r16.setOnClickListener(new d(this, r13, r15, r2));
        int r18 = Math.min(r14, 5);
    L51:
        if (getAvatarViewPool().size() >= r18) goto L69;
        int r19 = getAvatarViewPool().size();
        Log.i("OfficeReactionItemView", "host[" + hashCode() + "] create avatarView index=" + r19);
        ImageView r110 = new ImageView(getContext());
        r110.setScaleType(ImageView.ScaleType.CENTER_CROP);
        r110.setPadding(UIHelper.dp2px(2.0f), UIHelper.dp2px(2.0f), UIHelper.dp2px(2.0f), UIHelper.dp2px(2.0f));
        GradientDrawable r20 = new GradientDrawable();
        r20.setShape(1);
        r20.setColor(ContextCompat.getColor(r110.getContext(), 2131102026));
        r110.setBackground(r20);
        FrameLayout.LayoutParams r21 = new FrameLayout.LayoutParams(UIHelper.dp2px(24.0f), UIHelper.dp2px(24.0f));
        r21.leftMargin = UIHelper.dp2px(r19 * 12.0f);
        r21.gravity = 16;
        r110.setLayoutParams(r21);
        r110.setClickable(false);
        r110.setVisibility(8);
        getAvatarViewPool().add(r110);
        FrameLayout r22 = this.b;
        if (r22 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("avatarContainer");
        r22 = null;
    L55:
        TextView r23 = this.c;
        if (r23 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("remainingCountText");
        r23 = null;
    L58:
        int r24 = r22.indexOfChild(r23);
        if (r24 >= 0) goto L65;
        FrameLayout r25 = this.b;
        if (r25 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("avatarContainer");
        r25 = null;
    L64:
        r24 = r25.getChildCount();
    L65:
        FrameLayout r26 = this.b;
        if (r26 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("avatarContainer");
        r26 = null;
    L68:
        r26.addView(r110, r24);
        goto L51
    L69:
        Iterator<T> r27 = getAvatarViewPool().iterator();
        int r28 = 0;
    L71:
        if (r27.hasNext() == false) goto L85;
        Object r29 = r27.next();
        int r30 = r28 + 1;
        if (r28 >= 0) goto L75;
        CollectionsKt.throwIndexOverflow();
    L75:
        ImageView r31 = (ImageView) r29;
        r31.setImageDrawable(null);
        r31.setClickable(false);
        if (r28 < r14) goto L78;
        r31.setVisibility(8);
    L81:
        r28 = r30;
        goto L71
    L78:
        q2c.d r111 = (q2c.d) ListProtector.get(r5, r28);
        r31.setVisibility(0);
        ViewGroup.LayoutParams r32 = r31.getLayoutParams();
        if (r32 == null) goto L83;
        FrameLayout.LayoutParams r33 = (FrameLayout.LayoutParams) r32;
        r33.leftMargin = UIHelper.dp2px(r28 * 12.0f);
        r31.setLayoutParams(r33);
        ImageLoader.with(getContext()).load(AvatarImage.Builder.obtain(r111.c, r111.a, getAvatarSize(), getAvatarSize()).build()).override(getAvatarSize(), getAvatarSize()).transform(new CropCircleTransformation()).into(r31);
        goto L81
    L83:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L85:
        if (r13 <= 5) goto L98;
        int r34 = r17.b - 4;
        if (r34 > 99) goto L89;
        String r35 = "+" + r34;
    L90:
        TextView r36 = this.c;
        if (r36 != null) goto L93;
        Intrinsics.throwUninitializedPropertyAccessException("remainingCountText");
        r36 = null;
    L93:
        r36.setVisibility(0);
        TextView r37 = this.c;
        if (r37 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("remainingCountText");
        TextView r38 = null;
    L97:
        r38.setText(r35);
    L103:
        measure(0, 0);
        return;
    L96:
        r38 = r37;
        goto L97
    L89:
        r35 = "99+";
        goto L90
    L98:
        TextView r39 = this.c;
        if (r39 != null) goto L101;
        Intrinsics.throwUninitializedPropertyAccessException("remainingCountText");
        TextView r40 = null;
    L102:
        r40.setVisibility(8);
        goto L103
    L101:
        r40 = r39;
        goto L102
    L45:
        r15 = null;
        goto L46
    L24:
        if (r6.isEmpty() == true) goto L27;
        r7 = false;
        goto L29
    L14:
        int r41 = UIHelper.dp2px(20.0f);
        GradientDrawable r42 = new GradientDrawable();
        r42.setShape(0);
        r42.setCornerRadius(r41 / 2.0f);
        r42.setColor(ContextCompat.getColor(getContext(), 2131108731));
        ImageView r43 = this.a;
        if (r43 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("emojiIcon");
        r43 = null;
    L17:
        r43.setScaleType(ImageView.ScaleType.FIT_XY);
        ImageView r44 = this.a;
        if (r44 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("emojiIcon");
        r44 = null;
    L20:
        r44.setImageDrawable(r42);
        Log.i("OfficeReactionItemView", "requestBitmap start for reactionKey: " + r2);
        IGetDataCallback<Boolean> r45 = new OfficeReactionItemView$setData$callback$1(r2, this);
        getRequestBitmapListeners().put(r2, r45);
        qsb.b.a().ge(r2, false, null, r45);
        goto L21
    }

    public OfficeReactionItemView(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        this.d = LazyKt.lazy(OfficeReactionItemView$avatarViewPool$2.INSTANCE);
        this.e = LazyKt.lazy(OfficeReactionItemView$requestBitmapListeners$2.INSTANCE);
        this.f = LazyKt.lazy(OfficeReactionItemView$avatarSize$2.INSTANCE);
        setOrientation(0);
        setGravity(16);
        GradientDrawable r8 = new GradientDrawable();
        r8.setShape(0);
        r8.setCornerRadius(UIHelper.dp2px(100.0f));
        r8.setColor(ContextCompat.getColor(getContext(), 2131102026));
        setBackground(r8);
        setPadding(UIHelper.dp2px(8.0f), 0, UIHelper.dp2px(6.0f), 0);
        ImageView r9 = new ImageView(getContext());
        this.a = r9;
        r9.setLayoutParams(new LinearLayout.LayoutParams(-2, UIHelper.dp2px(20.0f)));
        View r10 = this.a;
        TextView r11 = null;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("emojiIcon");
        r10 = null;
    L5:
        addView(r10);
        FrameLayout r12 = new FrameLayout(getContext());
        this.b = r12;
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(-2, UIHelper.dp2px(24.0f));
        r1.leftMargin = UIHelper.dp2px(6.0f);
        r12.setLayoutParams(r1);
        View r13 = this.b;
        if (r13 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("avatarContainer");
        r13 = null;
    L8:
        addView(r13);
        TextView r14 = new TextView(getContext());
        r14.setTextColor(ContextCompat.getColor(r14.getContext(), 2131106521));
        r14.setTextSize(7.0f);
        r14.setGravity(17);
        r14.setVisibility(8);
        r14.setTypeface(r14.getTypeface(), 1);
        GradientDrawable r2 = new GradientDrawable();
        r2.setShape(1);
        r2.setColor(ColorProtector.parseColor("#4D000000"));
        r14.setBackground(r2);
        FrameLayout.LayoutParams r3 = new FrameLayout.LayoutParams(UIHelper.dp2px(20.0f), UIHelper.dp2px(20.0f));
        r3.gravity = 8388629;
        r3.rightMargin = UIHelper.dp2px(2.0f);
        r14.setLayoutParams(r3);
        this.c = r14;
        FrameLayout r15 = this.b;
        if (r15 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("avatarContainer");
        r15 = null;
    L11:
        TextView r16 = this.c;
        if (r16 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("remainingCountText");
    L15:
        r15.addView(r11);
        return;
    L14:
        r11 = r16;
        goto L15
    }

    public /* synthetic */ OfficeReactionItemView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
