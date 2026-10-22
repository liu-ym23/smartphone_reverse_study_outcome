package com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.base.model.user.h0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.p0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.android.livesdk.chatroom.utils.a3;
import com.bytedance.android.livesdk.gift.effect.normal.utils.BitmapTranslateUtils;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.InteractivityPlatformContext;
import com.bytedance.android.livesdk.interactivity.api.base.utils.InteractivityOpt;
import com.bytedance.android.livesdk.interactivity.common.utils.AsyncInflateUtils;
import com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.RevenueUtils;
import com.bytedance.android.livesdk.interactivity.enteranim.view.BaseEnterView;
import com.bytedance.android.livesdk.interactivity.enteranim.view.UserEnterLevelView;
import com.bytedance.android.livesdk.interactivity.service.richcontent.LiveRichContentEngine;
import com.bytedance.android.livesdk.interactivity.service.settings.LiveRoomVisionDegradeConfigHelper;
import com.bytedance.android.livesdk.interactivity.service.textrender.utils.UserDslBadgeUtils;
import com.bytedance.android.livesdk.message.model.gb;
import com.bytedance.android.livesdk.message.model.va;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.common.utility.JsonUtils;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.inflater.AsyncLayoutInflater;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import ec2.j1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g extends AnimPlayer<k32.a> {
    public static final int d = 0;
    public final boolean c;

    public class a implements p0 {
        public final /* synthetic */ HSImageView a;

        public final /* synthetic */ void a(ImageInfo r1, Animatable r2) {
        }

        public final /* synthetic */ void b(py.k r1, Exception r2) {
        }

        public final /* synthetic */ void d(ImageInfo r1) {
        }

        public final /* synthetic */ void e(py.k r1) {
        }

        public a(HSImageView r1) {
            this.a = r1;
        }

        public final void c(py.k r1, int r2, int r3, boolean r4) {
            ViewGroup.LayoutParams r5 = this.a.getLayoutParams();
            int r6 = this.a.getHeight();
            r5.height = r6;
            r5.width = (r2 * r6) / r3;
            this.a.setLayoutParams(r5);
        }
    }

    public class b implements p0 {
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ HSImageView b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ va.a d;
        public final /* synthetic */ g e;

        public final /* synthetic */ void a(ImageInfo r1, Animatable r2) {
        }

        public final /* synthetic */ void b(py.k r1, Exception r2) {
        }

        public final /* synthetic */ void d(ImageInfo r1) {
        }

        public final /* synthetic */ void e(py.k r1) {
        }

        public final void c(py.k r3, int r4, int r5, boolean r6) {
            if (this.a == null) goto L20;
            HSImageView r7 = this.b;
            if (r7 != null) goto L7;
            return;
        L7:
            if ((r7.getLayoutParams() instanceof ConstraintLayout.LayoutParams) == false) goto L22;
            ConstraintLayout.LayoutParams r8 = this.b.getLayoutParams();
            Resources r9 = this.c.getResources();
            float r10 = WindowDisplayMetricsOverride.apply(r9, r9.getDisplayMetrics()).density / 3.0f;
            ((ViewGroup.MarginLayoutParams) r8).height = (int) (r5 * r10);
            ((ViewGroup.MarginLayoutParams) r8).width = (int) (r4 * r10);
            if (this.d.getAlignment() != 1) goto L12;
            int r11 = (int) s1.e(this.d.getAlignmentOffset());
            r8.endToEnd = 2131392613;
            this.a.setPadding(0, 0, r11, 0);
            this.b.setTranslationX(r11);
        L12:
            if (this.e.c == true) goto L14;
        L18:
            this.b.setLayoutParams(r8);
            return;
        L14:
            if (this.a.getHeight() <= 0) goto L18;
            if (((ViewGroup.MarginLayoutParams) r8).height <= this.a.getHeight()) goto L18;
            ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) this.a.getLayoutParams();
            r13.bottomMargin -= (((ViewGroup.MarginLayoutParams) r8).height - this.a.getHeight()) / 2;
            this.a.setLayoutParams(r13);
            goto L18
        L22:
            return;
        }

        public b(g r1, ViewGroup r2, HSImageView r3, Context r4, va.a r5) {
            this.e = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public class c extends BaseControllerListener<ImageInfo> {
        public final /* synthetic */ HSImageView a;
        public final /* synthetic */ ViewGroup b;
        public final /* synthetic */ UserEnterLevelView c;
        public final /* synthetic */ AnimPlayer.a d;
        public final /* synthetic */ FrameLayout.LayoutParams e;

        public final void onFinalImageSet(String r4, @Nullable Object r5, @Nullable Animatable r6) {
            ImageInfo r7 = (ImageInfo) r5;
            if (r7 == null) goto L6;
            int r8 = Math.round(this.a.getWidth() / (r7.getWidth() / r7.getHeight()));
            int[] r9 = new int[2];
            this.b.getLocationOnScreen(r9);
            int r1 = r9[1];
            this.c.getLocationOnScreen(r9);
            int r10 = r9[1] - r1;
            int r0 = this.c.getHeight();
            int r2 = this.d.a - ((this.b.getHeight() - r0) - r10);
            FrameLayout.LayoutParams r11 = this.e;
            r11.height = r8;
            r11.bottomMargin = r2 - ((r8 - r0) / 2);
            this.a.setLayoutParams(r11);
            return;
        }

        public c(HSImageView r1, ViewGroup r2, UserEnterLevelView r3, AnimPlayer.a r4, FrameLayout.LayoutParams r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    public class d implements gb.b {
        public int a;
        public int b;
        public final /* synthetic */ UserEnterLevelView c;
        public final /* synthetic */ ViewGroup d;
        public final /* synthetic */ k32.a e;
        public final /* synthetic */ va.a f;
        public final /* synthetic */ ViewGroup g;
        public final /* synthetic */ com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a h;
        public final /* synthetic */ g i;

        public final void b() {
        }

        public final void onError(Throwable r1) {
        }

        public final void a() {
            this.i.e(this.d, null, this.e, this.f, this.g, this.h);
        }

        public final void d(gb.c r6) {
            int[] r1 = new int[2];
            this.c.getLocationOnScreen(r1);
            int r2 = s1.y();
            int r3 = (this.b * r2) / this.a;
            int r4 = ((r1[1] + (this.c.getHeight() / 2)) - s1.A()) - (r3 / 2);
            r6.a = r2;
            r6.b = r3;
            r6.c = 0;
            r6.d = r4;
        }

        public final void c(int r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        public d(g r1, UserEnterLevelView r2, ViewGroup r3, k32.a r4, va.a r5, ViewGroup r6, com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a r7) {
            this.i = r1;
            this.c = r2;
            this.d = r3;
            this.e = r4;
            this.f = r5;
            this.g = r6;
            this.h = r7;
        }
    }

    public class e extends s72.c {
        public final /* synthetic */ View a;
        public final /* synthetic */ ViewGroup b;
        public final /* synthetic */ View c;
        public final /* synthetic */ com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a d;
        public final /* synthetic */ k32.a e;
        public final /* synthetic */ JSONObject f;

        @Override // s72.c
        public final void a() {
            UserEnterLevelView r0 = (UserEnterLevelView) this.a.findViewById(2131392613);
            if (r0 == null) goto L6;
            r0.c();
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r5) {
            this.b.removeView(this.a);
            this.b.removeView(this.c);
            ((v72.c.a) this.d).a();
            RevenueUtils.b r6 = RevenueUtils.i;
            k32.a r0 = this.e;
            JSONObject r1 = this.f;
            r6.getClass();
            RevenueUtils.b.d(r0, "user_enter_finish", false, null, r1);
        }

        @Override // s72.c, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r1) {
            com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a r2 = this.d;
            if (r2 == null) goto L6;
            ((v72.c.a) r2).b();
            return;
        }

        public e(View r1, ViewGroup r2, View r3, com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a r4, k32.a r5, JSONObject r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    static {
        d = s1.f(157.0f);
        s1.f(12.0f);
    }

    @Override // com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.AnimPlayer
    @Nonnull
    public AnimPlayer.PlayerType getType() {
        return AnimPlayer.PlayerType.CustomEnter;
    }

    public g(InteractivityPlatformContext r1, DataCenter r2) {
        super(r1, r2);
        this.c = ((Boolean) j1.a.getValue()).booleanValue();
    }

    @Override // com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.AnimPlayer
    public final void b(@Nonnull final k32.a r11, @Nonnull final Context r13, @Nonnull final AnimPlayer.a r14, @Nonnull final ViewGroup r15, @Nonnull final com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a r16) {
        if (r11.k != null) goto L5;
        return;
    L5:
        r15.setAlpha(0.0f);
        if (InteractivityOpt.a == true) goto L8;
        d(r11, r13, r14, r15, r16, (ViewGroup) LayoutInflater.from(r13).inflate(2131567903, r15, false));
        return;
    L8:
        ((AsyncLayoutInflater) AsyncInflateUtils.a.getValue()).inflate(2131567903, r15, new com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.e(this, r11, r13, r14, r15, r16));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v2, types: [boolean, int] */
    public final void d(@Nonnull final k32.a r25, @Nonnull Context r26, @Nonnull final AnimPlayer.a r27, @Nonnull ViewGroup r28, @Nonnull com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a r29, @Nonnull ViewGroup r30) {
        ViewGroup.MarginLayoutParams r0 = (ViewGroup.MarginLayoutParams) r30.getLayoutParams();
        r0.bottomMargin = r27.a;
        if (this.c == false) goto L5;
        r0.height = -2;
        r30.setClipChildren(true);
    L5:
        r30.setLayoutParams(r0);
        va.a r15 = r25.k;
        if (r15 != null) goto L8;
        return;
    L8:
        com.bytedance.android.live.profit.dress.l r1 = yt0.c.a().getDressData(r15.getDressId(), 2, "CustomEnterAnimPlayer");
        if (r1 == null) goto L11;
        r15.setType((int) r1.getType());
        r15.setIcon(r1.b);
        r15.d((int) r1.c);
        r15.k(r1.e);
        r15.m(r1.f);
        r15.i(r1.g);
        r15.e(r1.h);
        r15.c(r1.i);
        r15.g(r1.j);
        r15.j(r1.k);
        r15.h(r1.l);
    L11:
        Spannable r2 = sb2.a.f(r15.getText(), com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.b.a(this.b)).a;
        UserEnterLevelView r5 = (UserEnterLevelView) r30.findViewById(2131392613);
        HSImageView r3 = r30.findViewById(2131392614);
        if (r15.getTextIconOverlay() != null) goto L14;
    L16:
        HSImageView r4 = r30.findViewById(2131392615);
        if (r15.getDynamicImage() != null) goto L19;
    L21:
        ?? r14 = 0;
    L22:
        HSImageView r6 = (HSImageView) r30.findViewById(2131362938);
        if (r15.getIcon() != null) goto L25;
    L27:
        List r7 = r15.f();
        if (r15.getTextIcon() == null) goto L30;
        r5.setEnableBitmap(r14);
    L30:
        py.k r8 = r15.getTextIcon();
        if (r5.a != null) goto L33;
    L160:
        r5.setOnClickListener(new f(r27, r25));
        r5.setEnableShader(r15.b());
        r5.setEnableShader(false);
        r30.setX(0.0f);
        r30.setY(0.0f);
        r28.addView(r30);
        com.bytedance.android.livesdk.utils.t.b r9 = r25.l;
        if (r9 == null) goto L167;
        StringBuilder r10 = new StringBuilder();
        r10.append(((com.bytedance.android.livesdk.utils.t.a) r9).a);
        if (r26.getResources().getConfiguration().orientation != 1) goto L165;
        String r11 = r9.portraitPath;
    L166:
        r10.append(r11);
        String r13 = r10.toString();
    L168:
        Uri r16 = new Uri.Builder().scheme("file").path(r13).build();
        if (TextUtils.isEmpty(r13) == false) goto L171;
        long r17 = r15.a();
        boolean r18 = com.bytedance.android.live.revenue.core.util.h.a;
        IAssetsManager r19 = com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class).getAssetsManager();
        RevenueUtils.i.getClass();
        Intrinsics.checkNotNullParameter(r19, "mgr");
        com.bytedance.android.live.core.resources.e r20 = r19.G1(r17);
        if (r20 != null) goto L188;
    L189:
        r20 = null;
    L190:
        if (r20 == null) goto L199;
        DataCenter r21 = this.b;
        if (r21 == null) goto L199;
        vlc.d r23 = (vlc.d) r21.get("data_message_manager", null);
        if (r23 != null) goto L196;
        return;
    L196:
        if ((r26 instanceof Activity) == false) goto L215;
        tlc.d r110 = (gb) vh7.f.c(gb.class);
        r110.setAssetId(r17);
        r110.setVideoCallback(new d(this, r5, r30, r25, r15, r28, r29));
        r23.j(r110, true);
        return;
    L215:
        return;
    L199:
        e(r30, null, r25, r15, r28, r29);
        return;
    L188:
        if (r20.getResourceType() == 4) goto L190;
    L171:
        if (r15.getCenterAnimAssetId() == 0) goto L173;
        View r24 = new HSImageView(r26);
        FrameLayout.LayoutParams r31 = new FrameLayout.LayoutParams(-1, -2, 80);
        r28.addView(r24, r31);
        r24.setController(Fresco.newDraweeControllerBuilder().setUri(r16).setAutoPlayAnimations(true).setControllerListener(new c(r24, r30, r5, r27, r31)).build());
        View r33 = r24;
    L184:
        e(r30, r33, r25, r15, r28, r29);
        return;
    L173:
        View r34 = LayoutInflater.from(r26).inflate(2131567905, r28, false);
        FrameLayout.LayoutParams r35 = new FrameLayout.LayoutParams(-1, -2);
        r35.gravity = 8388691;
        if (r26.getResources().getConfiguration().orientation != 1) goto L176;
        boolean r36 = true;
    L177:
        if (r36 == true) goto L179;
        r35.width = t6.c(r26);
    L179:
        r28.addView(r34, r35);
        ViewGroup.MarginLayoutParams r37 = (ViewGroup.MarginLayoutParams) r34.getLayoutParams();
        if (r36 == false) goto L182;
        int r38 = r27.a - d;
    L183:
        r37.bottomMargin = r38;
        r34.setLayoutParams(r37);
        HSImageView r39 = r34.findViewById(2131393136);
        FrameLayout.LayoutParams r40 = (FrameLayout.LayoutParams) r39.getLayoutParams();
        r40.height = s1.f(255.0f);
        r39.setLayoutParams(r40);
        r39.setController(Fresco.newDraweeControllerBuilder().setUri(r16).setAutoPlayAnimations(true).build());
        r33 = r34;
        goto L184
    L182:
        r38 = 0;
        goto L183
    L176:
        r36 = false;
        goto L177
    L165:
        r11 = r9.landscapePath;
        goto L166
    L167:
        r13 = null;
        goto L168
    L33:
        if (TextUtils.isEmpty(r2) == true) goto L160;
        if (r8 == null) goto L160;
        BaseEnterView r41 = r5.a;
        if (r41.f != null) goto L39;
    L159:
        r5.b = BitmapTranslateUtils.a(r5.a);
        r5.r = r5.a.getWidth();
        r5.s = r5.a.getHeight();
        r5.addView(r5.a);
        goto L160
    L39:
        if (TextUtils.isEmpty(r2) == true) goto L159;
        View r43 = r41.f;
        if (r43 == null) goto L43;
        ViewGroup.LayoutParams r44 = r43.getLayoutParams();
    L44:
        if (r44 == null) goto L46;
        r44.height = -2;
    L46:
        View r45 = r41.f;
        if (r45 == null) goto L49;
        r45.setLayoutParams(r44);
    L49:
        HSImageView r46 = r41.a;
        if (r46 == null) goto L52;
        r46.setVisibility(8);
    L52:
        NoMoreSpaceTextView r47 = r41.b;
        if (r47 == 0) goto L55;
        r47.setVisibility(r14);
    L55:
        NoMoreSpaceTextView r48 = r41.b;
        if (r48 == null) goto L58;
        ViewGroup.LayoutParams r49 = r48.getLayoutParams();
    L59:
        if (r49 == null) goto L61;
        r49.height = InteractivityOpt.a(16.0f);
    L61:
        NoMoreSpaceTextView r111 = r41.b;
        if (r111 == null) goto L64;
        r111.setLayoutParams(r49);
    L64:
        TextView r50 = r41.c;
        if (r50 == null) goto L67;
        ViewGroup.LayoutParams r51 = r50.getLayoutParams();
    L69:
        if ((r51 instanceof ViewGroup.MarginLayoutParams) == true) goto L71;
        r51 = null;
    L71:
        ViewGroup.MarginLayoutParams r53 = (ViewGroup.MarginLayoutParams) r51;
        if (r53 == null) goto L74;
        r53.rightMargin = InteractivityOpt.a(4.0f);
    L74:
        TextView r112 = r41.c;
        if (r112 == null) goto L77;
        r112.setLayoutParams(r53);
    L77:
        TextView r54 = r41.d;
        if (r54 == null) goto L80;
        r54.setVisibility(8);
    L80:
        ImageView r55 = r41.e;
        if (r55 == null) goto L83;
        r55.setVisibility(8);
    L83:
        TextView r56 = r41.c;
        if (r56 == null) goto L86;
        r56.setEllipsize(null);
    L86:
        TextView r57 = r41.c;
        if (r57 == null) goto L94;
        View r58 = r41.f;
        if (r58 == null) goto L91;
        int r59 = r58.getWidth();
    L92:
        r57.setMaxWidth(r59);
        goto L94
    L91:
        r59 = 0;
    L94:
        if (((rb2.b) LiveRoomVisionDegradeConfigHelper.a.getValue()).degradeEnterTitleFont == false) goto L114;
        TextView r60 = r41.c;
        if (r60 == null) goto L100;
        TextPaint r61 = r60.getPaint();
        if (r61 == null) goto L100;
        r61.setFakeBoldText(true);
    L100:
        int r113 = 2;
        if (r60 == null) goto L103;
        r60.setTextSize(2, 13.0f);
    L103:
        if (r60 == null) goto L105;
        r60.postInvalidate();
    L105:
        TextView r63 = r41.d;
        if (r63 == null) goto L110;
        TextPaint r64 = r63.getPaint();
        if (r64 == null) goto L110;
        r64.setFakeBoldText(true);
    L110:
        if (r63 == null) goto L112;
        r63.setTextSize(2, 13.0f);
    L112:
        if (r63 == null) goto L115;
        r63.postInvalidate();
    L115:
        TextView r65 = r41.c;
        if (r65 == null) goto L118;
        r65.setText(r2);
    L118:
        int r66 = a3.d;
        a3.a.a(r41.f, r8, new com.bytedance.android.livesdk.interactivity.enteranim.view.c(r41), 0.0f);
        List r67 = r7;
        if (r67 != null) goto L121;
    L124:
        boolean r68 = true;
    L125:
        if (r68 == true) goto L159;
        int r69 = com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.h.b;
        com.bytedance.android.livesdk.interactivity.enteranim.view.d r70 = new com.bytedance.android.livesdk.interactivity.enteranim.view.d(r41);
        int r71 = UserDslBadgeUtils.a;
        Intrinsics.checkNotNullParameter(r7, "badgeList");
        Intrinsics.checkNotNullParameter(r70, "callback");
        ArrayList r73 = new ArrayList();     // Catch: Exception -> L157
        Ref.BooleanRef r74 = new Ref.BooleanRef();     // Catch: Exception -> L157
        r74.element = false;     // Catch: Exception -> L157
        if (Lists.isEmpty(r7) == true) goto L144;
        Iterator r75 = r7.iterator();     // Catch: Exception -> L157
    L131:
        if (r75.hasNext() == false) goto L144;
        py.k r76 = (py.k) r75.next();     // Catch: Exception -> L157
        if (r76.isAnimated() == true) goto L140;
        String r77 = r76.getUri();     // Catch: Exception -> L157
        if (r77 == null) goto L139;
        Iterator r210 = r75;
        if (StringsKt.contains$default(r77, "webp", false, r113, null) != true) goto L142;
    L141:
        r74.element = true;     // Catch: Exception -> L157
        r76.setAnimated(true);     // Catch: Exception -> L157
    L142:
        r73.add(new h0(0, r76));     // Catch: Exception -> L157
        r75 = r210;
        goto L131
    L139:
        r210 = r75;
        goto L142
    L140:
        r210 = r75;
    L144:
        if ((!r73.isEmpty()) == false) goto L159;
        tb2.d r78 = new tb2.d();     // Catch: Exception -> L157
        ArrayList r79 = (ArrayList) UserDslBadgeUtils.b(r73);     // Catch: Exception -> L157
        Iterator r80 = r79.iterator();     // Catch: Exception -> L157
    L147:
        if (r80.hasNext() == false) goto L151;
        ITextPieceImage r81 = ((tb2.c) r80.next()).getImageValue();     // Catch: Exception -> L157
        if (r81 == null) goto L147;
        r81.setNeedExtraSpace(true);     // Catch: Exception -> L157
        goto L147
    L151:
        Iterator r83 = r79.iterator();     // Catch: Exception -> L157
    L153:
        if (r83.hasNext() == false) goto L155;
        r78.c((tb2.c) r83.next());     // Catch: Exception -> L157
        goto L153
    L155:
        int r84 = mb2.c.a;     // Catch: Exception -> L157
        Intrinsics.checkNotNullParameter(r78, "payload");     // Catch: Exception -> L157
        LiveRichContentEngine.a().a().c(mb2.c.c(r78, 1.0f, "normal"), new com.bytedance.android.livesdk.interactivity.service.richcontent.config.b(true, r69, false), new com.bytedance.android.livesdk.interactivity.service.textrender.utils.h(r70, r74));     // Catch: Exception -> L157
    L157:
        e = move-exception;
        ALogger.e("UserDslBadge", e);
        goto L159
    L121:
        if (r67.isEmpty() == true) goto L124;
        r68 = false;
        goto L125
    L114:
        r113 = 2;
        goto L115
    L67:
        r51 = null;
        goto L69
    L58:
        r49 = null;
        goto L59
    L43:
        r44 = null;
        goto L44
    L25:
        if (Lists.isEmpty(r15.getIcon().getUrls()) == true) goto L27;
        r6.setVisibility(r14);
        ImageLoader.bindGifImage(r6, r15.getIcon());
        goto L27
    L19:
        if (Lists.isEmpty(r15.getDynamicImage().getUrls()) == true) goto L21;
        r4.setVisibility(0);
        r14 = 0;
        ImageUtil.loadImage(r4, r15.getDynamicImage(), -1, -1, true, 0, true, new b(this, r30, r4, r26, r15));
        goto L22
    L14:
        if (Lists.isEmpty(r15.getTextIconOverlay().getUrls()) == true) goto L16;
        r3.setVisibility(0);
        ImageUtil.loadImage(r3, r15.getTextIconOverlay(), -1, -1, true, 0, new a(r3));
        goto L16
    }

    public final void e(View r15, View r16, k32.a r17, va.a r18, ViewGroup r19, com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a r20) {
        JSONObject r6 = new JSONObject();
        JsonUtils.optPut(r6, "enter_type", "8");
        JsonUtils.optPut(r6, "dress_id", r18.getDressId());
        JsonUtils.optPut(r6, "resource_id", Long.valueOf(r18.a()));
        RevenueUtils.i.getClass();
        RevenueUtils.b.d(r17, "user_enter_play", false, null, r6);
        Animator r0 = com.bytedance.android.livesdk.interactivity.enteranim.utils.a.b(r15, new e(r15, r19, r16, r20, r17, r6), -1, -1, r18.getStayTime(), c(), true);
        r0.start();
        ((v72.c.a) r20).a.i = r0;
    }
}
