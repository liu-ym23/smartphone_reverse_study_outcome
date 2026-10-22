package com.larus.bmhome.bot.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.ContextCompat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.databinding.LarusShareGeneralBotBinding;
import com.larus.bmhome.databinding.LarusShareImmerseBotBinding;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotIconImage;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.BotStatistic;
import com.larus.im.bean.bot.ShareInfo;
import com.larus.im.bean.conversation.IconImage;
import com.larus.im.bean.message.ImageObj;
import com.larus.platform.api.IFlowChatThemeConfigProvider;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ShareBotBitmapGenerator {
    public static final /* synthetic */ int g = 0;
    public final Context a;
    public final boolean b;
    public Bitmap c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;

    public static final class a {
    }

    public static final class b implements com.larus.bmhome.bot.share.a {
        public final /* synthetic */ ShareBotBitmapGenerator a;

        @Override // com.larus.bmhome.bot.share.a
        public final TextView a() {
            return this.a.d().e;
        }

        @Override // com.larus.bmhome.bot.share.a
        public final TextView b() {
            return this.a.d().b;
        }

        @Override // com.larus.bmhome.bot.share.a
        public final TextView c() {
            return this.a.d().f;
        }

        @Override // com.larus.bmhome.bot.share.a
        public final ImageView d() {
            return (ImageView) this.a.d().g.findViewById(2131373149);
        }

        @Override // com.larus.bmhome.bot.share.a
        public final View e() {
            return this.a.d().h;
        }

        @Override // com.larus.bmhome.bot.share.a
        public final AppCompatImageView f() {
            return this.a.d().i;
        }

        @Override // com.larus.bmhome.bot.share.a
        public final LinearLayoutCompat g() {
            return this.a.d().c;
        }

        @Override // com.larus.bmhome.bot.share.a
        public final ImageView h() {
            return (ImageView) this.a.d().g.findViewById(2131373140);
        }

        @Override // com.larus.bmhome.bot.share.a
        public final ImageView i() {
            return (ImageView) this.a.d().g.findViewById(2131373145);
        }

        @Override // com.larus.bmhome.bot.share.a
        public final TextView j() {
            return (TextView) this.a.d().g.findViewById(2131373154);
        }

        @Override // com.larus.bmhome.bot.share.a
        public final TextView k() {
            return this.a.d().d;
        }

        @Override // com.larus.bmhome.bot.share.a
        public final TextView l() {
            return (TextView) this.a.d().g.findViewById(2131373152);
        }

        @Override // com.larus.bmhome.bot.share.a
        public final View m() {
            return this.a.d().g.findViewById(2131373146);
        }

        public b(ShareBotBitmapGenerator r1) {
            this.a = r1;
        }
    }

    public static final class c implements com.larus.bmhome.bot.share.a {
        public final /* synthetic */ ShareBotBitmapGenerator a;

        @Override // com.larus.bmhome.bot.share.a
        public final TextView a() {
            return this.a.c().f;
        }

        @Override // com.larus.bmhome.bot.share.a
        public final TextView b() {
            return this.a.c().c;
        }

        @Override // com.larus.bmhome.bot.share.a
        public final TextView c() {
            return this.a.c().g;
        }

        @Override // com.larus.bmhome.bot.share.a
        public final ImageView d() {
            return (ImageView) this.a.c().h.findViewById(2131373149);
        }

        @Override // com.larus.bmhome.bot.share.a
        public final View e() {
            return this.a.c().i;
        }

        @Override // com.larus.bmhome.bot.share.a
        public final AppCompatImageView f() {
            return this.a.c().j;
        }

        @Override // com.larus.bmhome.bot.share.a
        public final LinearLayoutCompat g() {
            return this.a.c().d;
        }

        @Override // com.larus.bmhome.bot.share.a
        public final ImageView h() {
            return (ImageView) this.a.c().h.findViewById(2131373140);
        }

        @Override // com.larus.bmhome.bot.share.a
        public final ImageView i() {
            return (ImageView) this.a.c().h.findViewById(2131373145);
        }

        @Override // com.larus.bmhome.bot.share.a
        public final TextView j() {
            return (TextView) this.a.c().h.findViewById(2131373154);
        }

        @Override // com.larus.bmhome.bot.share.a
        public final TextView k() {
            return this.a.c().e;
        }

        @Override // com.larus.bmhome.bot.share.a
        public final TextView l() {
            return (TextView) this.a.c().h.findViewById(2131373152);
        }

        @Override // com.larus.bmhome.bot.share.a
        public final View m() {
            return this.a.c().h.findViewById(2131373146);
        }

        public c(ShareBotBitmapGenerator r1) {
            this.a = r1;
        }
    }

    static {
    }

    public final LarusShareGeneralBotBinding c() {
        return (LarusShareGeneralBotBinding) this.d.getValue();
    }

    public final LarusShareImmerseBotBinding d() {
        return (LarusShareImmerseBotBinding) this.e.getValue();
    }

    public final Context getContext() {
        return this.a;
    }

    public ShareBotBitmapGenerator(Context r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = r3;
        this.d = LazyKt.lazy(new com.larus.bmhome.bot.share.c(this));
        this.e = LazyKt.lazy(new d(this));
        this.f = LazyKt.lazy(new e(this));
    }

    public final Object a(wc9.e r6, BotModel r7, Continuation<? super Bitmap> r8) {
        if ((r8 instanceof ShareBotBitmapGenerator$generateShareBotBitmap$1) == false) goto L7;
        ShareBotBitmapGenerator$generateShareBotBitmap$1 r0 = (ShareBotBitmapGenerator$generateShareBotBitmap$1) r8;
        int r2 = r0.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r0.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        ResultKt.throwOnFailure(r9);
    L17:
        View r10 = (View) r9;
        int r11 = View.MeasureSpec.makeMeasureSpec(1080, 1073741824);
        if (this.b == false) goto L20;
        int r12 = View.MeasureSpec.makeMeasureSpec(1920, 1073741824);
    L21:
        r10.measure(r11, r12);
        r10.layout(0, 0, r10.getMeasuredWidth(), r10.getMeasuredHeight());
        FLogger.a.i("ShareBotBitmapGenerator", "width " + r10.getWidth() + "  height " + r10.getHeight());
        Bitmap r13 = Bitmap.createBitmap(r10.getWidth(), r10.getHeight(), Bitmap.Config.ARGB_8888);
        r10.draw(new Canvas(r13));
        return r13;
    L20:
        r12 = View.MeasureSpec.makeMeasureSpec(com.larus.utils.i.c(this.a), Integer.MIN_VALUE);
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        r0.label = 1;
        r9 = b(r6, r7, r0);
        if (r9 != r3) goto L17;
        return r3;
    L7:
        r0 = new ShareBotBitmapGenerator$generateShareBotBitmap$1(this, r8);
        goto L8
    }

    public final Object b(final wc9.e r20, BotModel r21, Continuation<? super View> r22) {
        if ((r22 instanceof ShareBotBitmapGenerator$generateView$1) == false) goto L7;
        ShareBotBitmapGenerator$generateView$1 r4 = (ShareBotBitmapGenerator$generateView$1) r22;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        if (r7 == 0) goto L16;
        if (r7 == 1) goto L15;
        if (r7 != 2) goto L14;
        ResultKt.throwOnFailure(r3);
    L163:
        Bitmap r8 = (Bitmap) r3;
        if (r8 == null) goto L168;
        c().b.setImageBitmap(r8);
    L168:
        return c().a;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        BotModel r1 = (BotModel) r4.L$0;
        ResultKt.throwOnFailure(r3);
    L108:
        Bitmap r9 = (Bitmap) r3;
        ImmerseBgBitmapImageView r2 = d().j;
        String r10 = r1.getBgImgColor();
        if (r10 != null) goto L111;
    L114:
        boolean r11 = true;
    L115:
        if (r11 == false) goto L169;
    L120:
        Integer r12 = null;
    L121:
        ImmerseBgBitmapImageView.a(r2, r9, r12);
        TextView r13 = ((com.larus.bmhome.bot.share.a) this.f.getValue()).j();
        if (r13 == null) goto L124;
        r13.setTextColor(ContextCompat.getColor(this.a, 2131103298));
    L124:
        TextView r14 = ((com.larus.bmhome.bot.share.a) this.f.getValue()).l();
        if (r14 == null) goto L128;
        r14.setTextColor(ContextCompat.getColor(this.a, 2131103298));
    L128:
        return d().a;
    L169:
        r12 = Integer.valueOf(Color.parseColor(r10));     // Catch: IllegalArgumentException -> L119
    L119:
        FLogger.a.e("ShareBotBitmapGenerator", "bgPickedColor is not formatted");
        goto L120
    L111:
        if (r10.length() == 0) goto L114;
        r11 = false;
        goto L115
    L16:
        ResultKt.throwOnFailure(r3);
        final com.larus.bmhome.bot.share.a r15 = (com.larus.bmhome.bot.share.a) this.f.getValue();
        TextView r16 = r15.a();
        String r17 = "";
        if (r21 == null) goto L21;
        String r18 = r21.getName();
        if (r18 == null) goto L21;
    L22:
        r16.setText(r18);
        TextView r19 = r15.l();
        if (r19 == null) goto L26;
        r19.setText(this.a.getString(2131907061));
    L26:
        if (FeatureKitDelegate.b.R().b() == false) goto L37;
        String r23 = r21.getBio();
        if (r23 != null) goto L30;
    L33:
        boolean r24 = true;
    L34:
        if (r24 == true) goto L37;
        e1.x(r15.k());
        r15.k().setText(ShareServiceDelegate.b.n(this.a, r21));
    L38:
        if (r21 == null) goto L42;
        ShareInfo r25 = r21.getShareInfo();
        if (r25 == null) goto L42;
        String r26 = r25.getQrCodeUrl();
    L43:
        if (r26 != null) goto L45;
    L48:
        boolean r110 = true;
    L49:
        if (r110 == false) goto L52;
        r26 = AppHost.a.f();
    L52:
        String r111 = r26;
        LinkedHashMap r27 = new LinkedHashMap();
        r27.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        r27.put(EncodeHintType.MARGIN, Boxing.boxInt(1));
        z2 r112 = z2.a;
        if (r112.u0().a() == false) goto L55;
        FLogger.a.i("ShareBotBitmapGenerator", "disable QRCode share");
    L63:
        Integer r28 = r21.getBotType();
        if (r28 != null) goto L67;
    L69:
        BotCreatorInfo r29 = r21.getBotCreatorInfo();
        if (r29 == null) goto L72;
        String r30 = r29.getName();
    L74:
        if (o0.d(r30) == false) goto L80;
        Context r31 = this.a;
        String r32 = r21.getBotFeatureLabel();
        BotCreatorInfo r33 = r21.getBotCreatorInfo();
        if (r33 == null) goto L78;
        String r34 = r33.getName();
    L79:
        String r35 = com.larus.bmhome.utils.i.a(r31, r32, r34);
        e1.x(r15.c());
        r15.c().setText(r35);
    L81:
        BotStatistic r36 = r21.getBotStatic();
        if (r36 == null) goto L84;
        String r37 = r36.getDisplayHeatScore();
    L86:
        if (o0.d(r37) == false) goto L93;
        BotStatistic r38 = r21.getBotStatic();
        if (r38 == null) goto L91;
        String r39 = r38.getDisplayHeatScore();
        if (r39 == null) goto L91;
    L92:
        e1.x(r15.f());
        e1.x(r15.b());
        r15.b().setText(r39);
    L95:
        if (e1.r(r15.f()) == true) goto L97;
    L99:
        IFlowChatThemeConfigProvider r40 = (IFlowChatThemeConfigProvider) ServiceManager.get().getService(IFlowChatThemeConfigProvider.class);
        if (r40 == null) goto L103;
        Boxing.boxBoolean(r40.e(new com.larus.bmhome.bot.share.b(r15, r20), AdaptThemeFeatureKey.CHAT_SHARE_BOT_IMAGE_FOOTER_AVATAR_AND_TITLE));
    L103:
        if (this.b == false) goto L129;
        CoroutineDispatcher r41 = Dispatchers.getIO();
        ShareBotBitmapGenerator$generateView$immersiveBgBitmap$1 r42 = new ShareBotBitmapGenerator$generateView$immersiveBgBitmap$1(r21, null);
        r4.L$0 = r21;
        r4.label = 1;
        r3 = BuildersKt.withContext(r41, r42, r4);
        if (r3 != r6) goto L107;
        return r6;
    L107:
        r1 = r21;
        goto L108
    L129:
        BotIconImage r43 = r21.getIconImage();
        if (r43 == null) goto L132;
        String r44 = r43.getTinyUrl();
    L134:
        if (o0.d(r44) == false) goto L138;
        BotIconImage r45 = r21.getIconImage();
        if (r45 == null) goto L147;
        String r46 = r45.getTinyUrl();
    L149:
        if (o0.d(r46) == false) goto L166;
        if (r20 == null) goto L156;
        IconImage r47 = r20.b;
        if (r47 == null) goto L156;
        ImageObj r48 = r47.imageOri;
        if (r48 == null) goto L156;
        String r49 = r48.url;
    L157:
        if (r49 == null) goto L160;
        r17 = r49;
    L160:
        CoroutineDispatcher r50 = Dispatchers.getIO();
        ShareBotBitmapGenerator$generateView$avatarBitmap$1 r51 = new ShareBotBitmapGenerator$generateView$avatarBitmap$1(r17, null);
        r4.label = 2;
        r3 = BuildersKt.withContext(r50, r51, r4);
        if (r3 != r6) goto L163;
        return r6;
    L156:
        r49 = null;
        goto L157
    L166:
        FLogger.a.w("ShareBotBitmapGenerator", "botModel.iconImage?.tinyUrl is null or empty");
    L147:
        r46 = null;
        goto L149
    L138:
        BotIconImage r52 = r21.getIconImage();
        if (r52 == null) goto L141;
        String r53 = r52.getOriginUrl();
    L143:
        if (o0.d(r53) == false) goto L147;
        BotIconImage r54 = r21.getIconImage();
        if (r54 == null) goto L147;
        r46 = r54.getOriginUrl();
        goto L149
    L141:
        r53 = null;
        goto L143
    L132:
        r44 = null;
        goto L134
    L97:
        if (e1.r(r15.c()) == false) goto L99;
        e1.o(r15.g());
    L91:
        r39 = "0";
        goto L92
    L93:
        e1.o(r15.f());
        e1.o(r15.b());
        e1.o(r15.e());
        goto L95
    L84:
        r37 = null;
        goto L86
    L78:
        r34 = null;
        goto L79
    L80:
        e1.o(r15.c());
        e1.o(r15.e());
        goto L81
    L72:
        r30 = null;
        goto L74
    L67:
        if (r28.intValue() != 1) goto L69;
        e1.o(r15.g());
        goto L99
    L55:
        if (this.b == true) goto L59;
        int r113 = i5.d0();
        int r114 = i5.d0();
        Context r55 = this.a;
        Bitmap r56 = o19.a.a(r111, r113, r114, ContextCompat.getColor(r55, v19.c.b(2130972079, r55, 2131103136)), r27, r112.shareQrCodeUseCustomStyle());
        this.c = r56;
        if (r56 == null) goto L63;
        r15.d().setImageBitmap(r56);
        goto L63
    L59:
        Bitmap r57 = o19.a.a(r111, i5.d0(), i5.d0(), -1, r27, r112.shareQrCodeUseCustomStyle());
        this.c = r57;
        if (r57 == null) goto L63;
        r15.d().setImageBitmap(this.c);
        goto L63
    L45:
        if (r26.length() == 0) goto L48;
        r110 = false;
    L42:
        r26 = null;
        goto L43
    L30:
        if (StringsKt.isBlank(r23) == true) goto L33;
        r24 = false;
    L37:
        e1.o(r15.k());
    L21:
        r18 = "";
    L7:
        r4 = new ShareBotBitmapGenerator$generateView$1(this, r22);
        goto L8
    }
}
