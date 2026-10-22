package com.ss.android.lark.chat.preview.components.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.load.model.GlideUrl;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.larksuite.framework.utils.n0;
import com.ss.android.lark.chat.preview.entity.component.property.VideoProperty;
import com.ss.android.lark.export.entity.preview.Border;
import com.ss.android.lark.export.entity.preview.ImageSet;
import com.ss.android.lark.export.entity.preview.Style;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.DiskCacheStrategy;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.mark.MarkView;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j extends LKUIRoundableLayout {
    public final ImageView r;
    public final ImageView s;
    public final MarkView t;
    public final ImageView u;
    public final boolean v;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final GradientDrawable getDefaultGradientDrawable() {
        GradientDrawable r0 = new GradientDrawable();
        r0.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        r0.setColors(new int[]{j08.b.b(getContext().getResources().getColor(2131100641), 0.2f), j08.b.b(getContext().getResources().getColor(2131100641), 0.01f), j08.b.b(getContext().getResources().getColor(2131100641), 0.2f)});
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, null, 6, 0);
        g6b.a.InterfaceC0223a r1 = g6b.a.a;
        if (r1 == null) goto L5;
        r1.c();
    L5:
        this.v = false;
        LayoutInflater.from(r5).inflate(2131568138, this, true);
        ImageView r6 = (ImageView) findViewById(2131376718);
        this.r = r6;
        ImageView r2 = (ImageView) findViewById(2131376720);
        this.s = r2;
        this.t = findViewById(2131391685);
        ImageView r3 = (ImageView) findViewById(2131376600);
        this.u = r3;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bg");
        r6 = null;
    L8:
        r6.setLayerType(2, null);
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("videoCover");
        r2 = null;
    L11:
        r2.setLayerType(2, null);
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("shadowImg");
        r3 = null;
    L14:
        r3.setLayerType(2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setViewCornerRadius(Style r4) {
        if (r4 == null) goto L21;
        Border r0 = r4.getBorder();
        if (r0 == null) goto L8;
        ThemeColor r1 = r0.getThemeColor();
        if (r1 == null) goto L8;
        setBorderColor(com.ss.android.lark.export.entity.preview.a.a(r1, getContext(), null));
    L8:
        Border r2 = r4.getBorder();
        float r3 = 0.0f;
        if (r2 == null) goto L13;
        Float r5 = r2.getWidth();
        if (r5 == null) goto L13;
        float r6 = r5.floatValue();
    L14:
        setBorderWidth(UIHelper.dp2px(r6));
        Border r7 = r4.getBorder();
        if (r7 == null) goto L19;
        Float r8 = r7.getCornerRadius();
        if (r8 == null) goto L19;
        r3 = r8.floatValue();
    L19:
        setRadius(r3);
        return;
    L13:
        r6 = 0.0f;
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f(String r5) {
        IRequestCreator r0 = ImageLoader.with(getContext()).load(r5);
        DiskCacheStrategy r1 = DiskCacheStrategy.RESULT;
        IRequestCreator r2 = r0.diskCacheStrategy(r1).isAsync(this.v).override(getLayoutParams().width, getLayoutParams().height);
        ImageView r3 = this.s;
        ImageView r4 = null;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("videoCover");
        r3 = null;
    L5:
        r2.into(r3);
        IRequestCreator r6 = ImageLoader.with(getContext()).load(r5).diskCacheStrategy(r1).isAsync(this.v).centerCrop().override(getLayoutParams().width, getLayoutParams().height).transform(new xkb.b());
        ImageView r7 = this.r;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bg");
    L9:
        r6.into(r4);
        return;
    L8:
        r4 = r7;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g(VideoProperty r11, Style r12) {
        Intrinsics.checkNotNullParameter(r11, "props");
        GradientDrawable r0 = getDefaultGradientDrawable();
        ImageSet r1 = r11.getCoverImage();
        boolean r2 = true;
        if (r1 == null) goto L14;
        Image r3 = r1.getOrigin();
        if (r3 == null) goto L14;
        String r4 = r3.getKey();
        if (r4 == null) goto L14;
        if (r4.length() != 0) goto L11;
        boolean r5 = true;
    L12:
        if (r5 == true) goto L14;
        boolean r6 = true;
    L15:
        View r7 = null;
        if (r6 == false) goto L37;
        ImageSet r8 = r11.getCoverImage();
        if (r8 == null) goto L96;
        Image r9 = r8.getOrigin();
        if (r9 == null) goto L96;
        if (getLayoutParams().width <= 0) goto L25;
        int r10 = getLayoutParams().width;
    L27:
        if (getLayoutParams().height <= 0) goto L29;
        int r13 = getLayoutParams().height;
    L30:
        IRequestCreator r14 = ImageLoader.with(getContext()).load(new EncryptImage(r9)).isAsync(this.v).override(r10, r13);
        ImageView r15 = this.s;
        if (r15 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("videoCover");
        r15 = null;
    L33:
        r14.into(r15);
        IRequestCreator r16 = ImageLoader.with(getContext()).load(new EncryptImage(r9)).isAsync(this.v).override(r10, r13).centerCrop().transform(new xkb.b());
        ImageView r17 = this.r;
        if (r17 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("bg");
        r17 = null;
    L36:
        r16.into(r17);
        goto L96
    L29:
        r13 = r9.getHeight();
        goto L30
    L25:
        r10 = r9.getWidth();
    L96:
        ImageView r18 = this.u;
        if (r18 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("shadowImg");
        r18 = null;
    L99:
        r18.setImageDrawable(r0);
        if (r11.getDuration() != 0) goto L106;
        View r19 = this.t;
        if (r19 != null) goto L104;
        Intrinsics.throwUninitializedPropertyAccessException("durationTv");
    L105:
        r7.setVisibility(8);
    L114:
        setViewCornerRadius(r12);
        return;
    L104:
        r7 = r19;
        goto L105
    L106:
        View r20 = this.t;
        if (r20 != null) goto L109;
        Intrinsics.throwUninitializedPropertyAccessException("durationTv");
        r20 = null;
    L109:
        r20.setVisibility(0);
        View r21 = this.t;
        if (r21 != null) goto L112;
        Intrinsics.throwUninitializedPropertyAccessException("durationTv");
    L113:
        r7.setText(com.larksuite.framework.utils.e.f((int) r11.getDuration()));
        goto L114
    L112:
        r7 = r21;
        goto L113
    L37:
        String r22 = r11.getCoverImageUrl();
        if (r22 != null) goto L40;
    L45:
        boolean r23 = false;
    L46:
        if (r23 == false) goto L89;
        String r24 = r11.getCoverImageUrl();
        String r25 = BuildConfig.FLAVOR;
        if (r24 != null) goto L50;
        r24 = BuildConfig.FLAVOR;
    L50:
        Pattern r26 = n0.a;
        if (TextUtils.isEmpty(r24) == false) goto L116;
    L52:
        String r27 = BuildConfig.FLAVOR;
    L58:
        if (r27.equals("https") == false) goto L88;
        g6b.a.InterfaceC0223a r28 = g6b.a.a;
        if (r28 == null) goto L66;
        com.ss.android.lark.officesdk.integrator.im.h r29 = r28.getFeatureGatingDependency();
        if (r29 == null) goto L66;
        if (r29.a("im.chat.session_governance") != true) goto L66;
    L67:
        if (r2 == false) goto L84;
        g6b.a.InterfaceC0223a r30 = g6b.a.a;
        if (r30 == null) goto L73;
        com.ss.android.lark.officesdk.integrator.im.d r31 = r30.getLoginDependency();
        if (r31 == null) goto L73;
        String r32 = r31.a();
    L74:
        if (r32 == null) goto L77;
        r25 = r32;
    L77:
        GlideUrl r33 = new GlideUrl(r24, new k(com.ss.android.lark.passport.auth.f.a.a((com.ss.android.lark.passport.auth.f) e0c.k.a(LarkContext.getApplication(), com.ss.android.lark.passport.auth.f.class), r25, r24)));
        IRequestCreator r34 = ImageLoader.with(getContext()).load(r33).isAsync(this.v).override(getLayoutParams().width, getLayoutParams().height);
        ImageView r35 = this.s;
        if (r35 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("videoCover");
        r35 = null;
    L80:
        r34.into(r35);
        IRequestCreator r36 = ImageLoader.with(getContext()).load(r33).isAsync(this.v).centerCrop().override(getLayoutParams().width, getLayoutParams().height).transform(new xkb.b());
        ImageView r37 = this.r;
        if (r37 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("bg");
        r37 = null;
    L83:
        r36.into(r37);
    L73:
        r32 = null;
        goto L74
    L84:
        g6b.a.InterfaceC0223a r38 = g6b.a.a;
        if (r38 == null) goto L87;
        r38.i();
    L87:
        f(r24);
    L66:
        r2 = false;
        goto L67
    L88:
        f(r24);
        goto L96
    L116:
        r27 = UriProtector.parse(r24).getScheme();     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        th.printStackTrace();
        goto L52
    L89:
        ImageView r39 = this.r;
        if (r39 != null) goto L92;
        Intrinsics.throwUninitializedPropertyAccessException("bg");
        r39 = null;
    L92:
        r39.setImageDrawable(r0);
        ImageView r40 = this.s;
        if (r40 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("videoCover");
        r40 = null;
    L95:
        r40.setImageDrawable(r0);
        goto L96
    L40:
        if (r22.length() <= 0) goto L42;
        boolean r41 = true;
    L43:
        if (r41 != true) goto L45;
        r23 = true;
        goto L46
    L42:
        r41 = false;
        goto L43
    L11:
        r5 = false;
    L14:
        r6 = false;
        goto L15
    }
}
