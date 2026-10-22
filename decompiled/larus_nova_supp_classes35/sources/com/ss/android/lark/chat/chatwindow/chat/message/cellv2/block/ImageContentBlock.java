package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.integration.webp.decoder.WebpDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.DeviceUtils;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chat.base.model.GifLoadConfig;
import com.ss.android.lark.chat.base.view.vo.message.ImageContentVO;
import com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.image.ImageCellLoader;
import com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.image.ImageCellPlaceHolderCal;
import com.ss.android.lark.chat.chatwindow.chat.message.cell.image.DelayDisplayFrameLayout;
import com.ss.android.lark.chat.chatwindow.chat.view.IMCircleLoadingView;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.chat.entity.message.SendStatus;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.chat.utils.MessageImageMonitor;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.chat.utils.MessengerImageLoadController;
import com.ss.android.lark.chat.utils.ReplyInThreadUtil;
import com.ss.android.lark.chatbase.view.ChatImageGroup;
import com.ss.android.lark.chatbase.view.ChatImageView;
import com.ss.android.lark.image.api.DiskCacheStrategy;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.image.entity.ListenerParams;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.mark.MarkView;
import com.ss.android.lark.widget.transformation.WhiteBgTransformation;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import jp.wasabeef.glide.transformations.CropTransformation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ImageContentBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<ImageContentVO>, ImageContentVO> {
    public static final /* synthetic */ int i = 0;
    public final IMMessageKeys$Blocks g;
    public final Lazy h;

    public static final class a {
    }

    public static final class b implements com.ss.android.lark.blueprint.k<View>, ImageCellLoader.c {
        public final View a;
        public final LKUIRoundableLayout b;
        public final ChatImageGroup c;
        public final ChatImageView d;
        public final MarkView e;
        public final MarkView f;
        public final DelayDisplayFrameLayout g;
        public final TextView h;
        public final IMCircleLoadingView i;
        public final ChatImageGroup j;
        public final ChatImageView k;
        public final MarkView l;
        public boolean m;

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.image.ImageCellLoader.c
        public final MarkView a() {
            return this.l;
        }

        public final View getView() {
            return this.a;
        }

        public b(View r5) {
            Intrinsics.checkNotNullParameter(r5, "view");
            this.a = r5;
            this.b = r5.findViewById(2131384849);
            ChatImageGroup r0 = (ChatImageGroup) r5.findViewById(2131374931);
            this.c = r0;
            ChatImageView r1 = r0.a;
            this.d = r1;
            MarkView r2 = r0.findViewById(2131390769);
            this.e = r2;
            this.f = r0.findViewById(2131384426);
            this.g = (DelayDisplayFrameLayout) r5.findViewById(2131386031);
            this.h = (TextView) r5.findViewById(2131383286);
            this.i = r0.j;
            this.j = r0;
            this.k = r1;
            this.l = r2;
        }
    }

    static {
    }

    public final com.ss.android.lark.blueprint.j getKey() {
        return this.g;
    }

    public ImageContentBlock(com.ss.android.lark.blueprint.g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.g = IMMessageKeys$Blocks.IMAGE_CONTENT;
        this.h = LazyKt.lazy(new ImageContentBlock$loader$2(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ImageContentVO h(y6b.a r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        ImageContentVO r2 = (ImageContentVO) r1.b();
        if (r2.e() == false) goto L8;
        Object r0 = r2.g;
        if (r0 == null) goto L9;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.chat.base.view.vo.message.ImageContentVO");
        return (ImageContentVO) r0;
    L9:
        return r2;
    L8:
        return r2;
    }

    public static void i(boolean r0, b r1) {
        if (r0 == true) goto L4;
        r1.i.b();
        return;
    L4:
        if (r1.m == false) goto L6;
        return;
    L6:
        r1.i.a();
        r1.m = true;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public final void a(com.ss.android.lark.blueprint.m<y6b.a<ImageContentVO>> r2, com.ss.android.lark.blueprint.q<y6b.a<ImageContentVO>> r3) {
        Intrinsics.checkNotNullParameter(r2, "cell");
        Intrinsics.checkNotNullParameter(r3, "layout");
        com.ss.android.lark.blueprint.i.a.a(r2, r3);
        com.ss.android.lark.blueprint.k r4 = r3.f(this.g, IMMessageKeys$Slots.CONTENT);
        if ((r4 instanceof b) == false) goto L5;
        b r5 = (b) r4;
    L6:
        if (r5 == null) goto L9;
        r5.m = false;
        r5.i.b();
        return;
    L9:
        return;
    L5:
        r5 = null;
        goto L6
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(com.ss.android.lark.blueprint.m<y6b.a<ImageContentVO>> r36, com.ss.android.lark.blueprint.q<y6b.a<ImageContentVO>> r37, final y6b.a<ImageContentVO> r38) {
        Intrinsics.checkNotNullParameter(r36, "cell");
        Intrinsics.checkNotNullParameter(r37, "layout");
        Intrinsics.checkNotNullParameter(r38, Keys.API_RETURN_KEY_DATA);
        final b r2 = (b) r37.c(this.g, IMMessageKeys$Slots.CONTENT, ImageContentBlock$update$blockView$1.INSTANCE);
        ValidateIMFileResult r4 = r38.N();
        if (r4 == null) goto L5;
        IMFileResult r5 = r4.getResultType();
    L6:
        MessagePermissionUtil.ReceiveAuthorizationState r6 = MessagePermissionUtil.h(r5);
        int r7 = ((ImageCellLoader) this.h.getValue()).a(r38, this.e);
        int r8 = y9c.d.b(getContext(), 40.0f);
        i3b.d r9 = (i3b.d) this.a.c.a(i3b.d.class);
        if (r9 == null) goto L11;
        m2b.a r10 = r9.a();
        if (r10 == null) goto L11;
        com.ss.android.lark.biz.im.api.message.params.g r11 = (com.ss.android.lark.biz.im.api.message.params.g) r10.d0(com.ss.android.lark.biz.im.api.message.params.g.class);
    L13:
        if (r11 != null) goto L15;
    L17:
        boolean r12 = false;
    L18:
        if (r12 == false) goto L20;
        MarkView r13 = r2.e;
        r13.e = false;
        r13.f = true;
    L20:
        ResourceCleanScene r14 = lpc.a.b(r38);
        if (r14 != null) goto L23;
    L25:
        boolean r15 = false;
    L27:
        if (r15 == false) goto L31;
        i(false, r2);
        j(r2, r7, r8, 2131891117);
    L29:
        b r1 = r2;
        ImageContentBlock r3 = this;
    L179:
        r1.b.setOnClickListener(new n(r3, r1, r38));
        r1.b.setOnLongClickListener(new o(r36, r3, r38));
        if (r3.c.m() == true) goto L184;
        if (TextUtils.isEmpty(r38.F()) == true) goto L184;
    L185:
        r1.b.setRadius(4.0f);
        r1.b.setBorderWidth(0.0f);
    L193:
        r1.b.setBorderColor(UIHelper.getColor(2131103351));
        i3b.d r0 = (i3b.d) r3.a.c.a(i3b.d.class);
        if (r0 == null) goto L203;
        m2b.a r16 = r0.a();
        if (r16 == null) goto L203;
        com.ss.android.lark.biz.im.api.message.params.g r17 = r16.d0(com.ss.android.lark.biz.im.api.message.params.g.class);
        if (r17 == null) goto L203;
        r1.b.setRadius(r17.a);
        if (r17.b == false) goto L203;
        r1.b.setBorderColor(r17.d);
        r1.b.setBorderWidth(r17.c);
    L203:
        if (r38.isPreMessage() == true) goto L205;
    L214:
        DelayDisplayFrameLayout r18 = r1.g;
        r18.setTag(2131368775, Boolean.FALSE);
        r18.removeCallbacks(r18.a);
        r18.setVisibility(8);
        return;
    L205:
        if (r38.G() != SendStatus.SENDING) goto L214;
        ViewGroup.LayoutParams r19 = r1.g.getLayoutParams();
        ViewGroup.LayoutParams r20 = r1.c.getLayoutParams();
        r19.width = r20.width;
        r19.height = r20.height;
        r1.g.setLayoutParams(r19);
        TextView r21 = r1.h;
        StringBuilder r22 = new StringBuilder();
        r22.append((int) (((double) r38.b().o) * 0.99d));
        r22.append('%');
        r21.setText(r22.toString());
        if (r1.g.getVisibility() == 0) goto L216;
        DelayDisplayFrameLayout r23 = r1.g;
        if ((System.currentTimeMillis() - (r38.getCreateTime() * ((long) 1000))) <= 2000) goto L212;
        int r110 = 0;
    L213:
        r23.setTag(2131368775, Boolean.TRUE);
        r23.setVisibility(4);
        r23.postDelayed(r23.a, r110);
        return;
    L212:
        r110 = h7b.l.c();
        goto L213
    L216:
        return;
    L184:
        if (r38.l() == true) goto L185;
        if (ReplyInThreadUtil.b(r38) == true) goto L189;
    L192:
        float[] r24 = com.ss.android.lark.chat.utils.f0.a(r38, 10.0f, 2.0f);
        r1.b.setRadius(r24[0], r24[1], r24[2], r24[3]);
        r1.b.setBorderWidth(0.5f);
        goto L193
    L189:
        if (ChatCoreModule.a().getFeatureGatingDependency().isEnable("im.message.thread_reply_bubble_optimize") == false) goto L192;
        r1.b.setRadius(4.0f);
        r1.b.setBorderWidth(0.5f);
        goto L193
    L31:
        if (MessagePermissionUtil.g(r6) == false) goto L43;
        if (r6 != MessagePermissionUtil.ReceiveAuthorizationState.FINAL_AUTHORIZATION_STATE_DENY) goto L35;
        int r25 = 2131891244;
    L41:
        j(r2, r7, r8, r25);
        goto L29
    L35:
        if (r11 != null) goto L37;
    L39:
        boolean r26 = false;
    L40:
        i(r26, r2);
        r25 = 2131891419;
        goto L41
    L37:
        if (r11.e != true) goto L39;
        r26 = true;
        goto L40
    L43:
        if (MessagePermissionUtil.f(r38, this.c.getChat(), null) == false) goto L178;
        ImageContentVO r111 = h(r38);
        Log.d("ImageContentBlock", "image key = " + ((String) r111.h.getValue()));
        int r27 = ImageCellLoader.e;
        if (ImageCellLoader.a.b(r111) != null) goto L47;
        com.ss.android.lark.chat.utils.g.f(getContext(), r2.d);
        r2.e.setVisibility(8);
    L101:
        r1 = r2;
    L177:
        r3 = this;
        goto L179
    L47:
        IGetDataCallback<int[]> r28 = new ImageContentBlock$load$resizedSizeCallback$1(this, r2, r38);
        i3b.d r29 = (i3b.d) this.a.c.a(i3b.d.class);
        if (r29 == null) goto L56;
        m2b.a r30 = r29.a();
        if (r30 == null) goto L56;
        com.ss.android.lark.biz.im.api.message.params.g r31 = r30.d0(com.ss.android.lark.biz.im.api.message.params.g.class);
        if (r31 == null) goto L56;
        if (r31.e != true) goto L56;
        boolean r32 = true;
    L57:
        if (r32 == false) goto L59;
        m r210 = new m(this, r2);
    L60:
        ImageCellLoader r33 = (ImageCellLoader) this.h.getValue();
        v4b.d r34 = this.e;
        l r35 = new l(r111, this);
        Function0<Unit> r39 = new ImageContentBlock$load$2(this, r2);
        r33.getClass();
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r38, "item");
        Intrinsics.checkNotNullParameter(r35, "dependency");
        Intrinsics.checkNotNullParameter(r28, "resizedSizeCallback");
        Intrinsics.checkNotNullParameter(r39, "loadDefault");
        Image r112 = (Image) r111.i.getValue();
        if (r112 != null) goto L63;
        r39.invoke();
        goto L101
    L63:
        com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.image.f r113 = r33.b;
        if (r113 == null) goto L66;
        Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.image.IImageCellParamCalculator");
    L67:
        Intrinsics.checkNotNullParameter(r112, "image");
        int r40 = r112.getWidth();
        int r41 = r112.getHeight();
        float r114 = DeviceUtils.getScreenDensity(r113.a.getContext());
        int r42 = (int) (r40 * r114);
        int r43 = (int) (r41 * r114);
        int r115 = UIHelper.dp2px(240.0f);
        int r116 = r113.b;
        if (r42 != 0) goto L70;
    L76:
        boolean r44 = false;
    L77:
        Log.i("ImageCellSizeCalV2", "imageWidth:" + r42 + ", imageHeight:" + r43 + ", isLargeImage:" + r44);
        if (r44 == false) goto L80;
        int r45 = UIHelper.dp2px(150.0f);
        int r117 = (int) (((r43 * 1.0f) / r42) * r45);
        r43 = UIHelper.dp2px(240.0f);
        boolean r46 = false;
        int r118 = r45;
    L92:
        com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.image.a r119 = new com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.image.a(r45, r43, r118, r117, r44, r46);
        if (r45 == 0) goto L98;
        if (r43 == 0) goto L98;
        if (r118 == 0) goto L98;
        if (r117 == 0) goto L98;
        boolean r120 = true;
    L99:
        if (r120 == true) goto L102;
        r39.invoke();
        goto L101
    L102:
        r2.j.setLayoutParams(new FrameLayout.LayoutParams(r45, r43));
        ChatImageGroup r47 = r2.j;
        int r121 = r117;
        r47.c.setVisibility(8);
        r47.a.clearColorFilter();
        if (r44 == false) goto L105;
        r2.l.setVisibility(0);
        r2.l.setText(UIHelper.getString(2131890863));
    L105:
        if (r46 == false) goto L107;
        r2.k.setScaleType(ImageView.ScaleType.CENTER);
    L108:
        ArrayList r122 = new ArrayList();
        if (r44 == false) goto L111;
        r122.add(new CropTransformation(r45, r43, CropTransformation.CropType.TOP));
    L111:
        r122.add(new WhiteBgTransformation());
        int[] r48 = {r45, r43};
        r28.onSuccess(r48);
        ImageCellPlaceHolderCal r49 = (ImageCellPlaceHolderCal) r33.c.getValue();
        r49.getClass();
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r38, "item");
        Intrinsics.checkNotNullParameter(r48, "resizeSize");
        if (r2.k.getDrawable() != null) goto L114;
    L118:
        boolean r50 = false;
    L120:
        if (Intrinsics.areEqual(r38.getcId(), r2.k.getTag(2131365616)) == false) goto L125;
        if (r50 == false) goto L125;
        if (r38.isPreMessage() == true) goto L125;
        boolean r51 = true;
    L126:
        Drawable r123 = UIHelper.getDrawable(2131233586);
        if (r51 == false) goto L129;
        Drawable r52 = r2.k.getDrawable();
    L131:
        if (r49.b != null) goto L133;
        r49.b = com.ss.android.lark.chat.utils.g.a(r49.a.getContext(), r48[0], r48[1], 0);
    L133:
        if (r52 != null) goto L135;
        r52 = r49.b;
    L135:
        Drawable r53 = r52;
        MessageIdentity r54 = r111.n;
        if (r54 == null) goto L139;
        String r55 = r54.getMessageId();
        if (r55 == null) goto L139;
    L140:
        String r56 = r55;
        StringBuilder r57 = new StringBuilder("start image load, messageId=");
        r57.append(r56);
        r57.append(", imageKey=");
        Image r58 = ImageCellLoader.a.b(r111);
        if (r58 == null) goto L143;
        String r59 = r58.getKey();
    L144:
        r57.append(r59);
        Log.i("ImageCellLoader", r57.toString());
        ListenerParams.a r124 = new ListenerParams.a();
        r124.a(Biz.Messenger);
        r124.d(r35.a().a);
        r124.c(ListenerParams.FromType.IMAGE);
        r124.a = false;
        r124.b = false;
        r124.c = r118;
        r124.d = r121;
        r124.n = r56;
        Image r60 = ImageCellLoader.a.b(r111);
        if (r60 == null) goto L147;
        String r61 = r60.getKey();
    L148:
        r124.o = r61;
        Image r62 = ImageCellLoader.a.b(r111);
        if (r62 == null) goto L151;
        String r63 = r62.getKey();
    L152:
        Intrinsics.checkNotNullParameter(r111, "<this>");
        Image r64 = (Image) r111.i.getValue();
        if (r64 == null) goto L155;
        String r65 = r64.getKey();
    L156:
        r124.p = TextUtils.equals(r63, r65);
        Image r66 = ImageCellLoader.a.b(r111);
        if (r66 == null) goto L159;
        String r125 = r66.getKey();
    L160:
        r124.h = new ImageCellLoader.b(r33.a, r2, r119, r56, r125, r210);
        LoadParams r67 = new LoadParams();
        r67.a = r118;
        r67.b = r121;
        r67.c = r53;
        r67.d = r123;
        DiskCacheStrategy r68 = r35.a().b;
        if (r68 == DiskCacheStrategy.NONE) goto L166;
        if (r44 == false) goto L165;
        r68 = DiskCacheStrategy.SOURCE;
        goto L166
    L165:
        r68 = DiskCacheStrategy.ALL;
    L166:
        r67.h = r68;
        r67.i = r35.a().c;
        r67.j = false;
        r67.k = ((Boolean) ((ImageCellPlaceHolderCal) r33.c.getValue()).c.getValue()).booleanValue();
        if (CollectionUtils.isNotEmpty(r122) == false) goto L170;
        ((ArrayList) r67.g).addAll(r122);
    L170:
        if (z6b.a.a == false) goto L172;
        r67.m = 1;
        r67.o = 1;
        r67.n = 1;
    L173:
        r67.l = r124.b();
        if (com.ss.android.lark.chat.utils.g.d(r38) == false) goto L176;
        r1 = r2;
        com.ss.android.lark.chat.utils.g.f(r33.a.getContext(), r1.k);
        r1.l.setVisibility(8);
        goto L177
    L176:
        r1 = r2;
        com.ss.android.lark.chat.utils.g.g(r33.a.getContext(), r1.k, MessengerImageLoadController.c(MessageImageMonitor.Scene.IMAGE_MESSAGE.getValue(), ImageCellLoader.a.a(r111)), r67, ImageCellLoader.a.a(r111).getInlinePreview(), r210);
        r1.k.setTag(2131365616, r38.getcId());
        goto L177
    L172:
        GifLoadConfig r69 = (GifLoadConfig) SettingManager.getInstance().get(GifLoadConfig.class);
        int r70 = r69.component1();
        int r71 = r69.component2();
        r67.m = r69.component3();
        r67.o = r71;
        r67.n = r70;
        goto L173
    L159:
        r125 = null;
        goto L160
    L155:
        r65 = null;
        goto L156
    L151:
        r63 = null;
        goto L152
    L147:
        r61 = null;
        goto L148
    L143:
        r59 = null;
    L139:
        r55 = BuildConfig.FLAVOR;
        goto L140
    L129:
        r52 = null;
    L125:
        r51 = false;
        goto L126
    L114:
        if ((r2.k.getDrawable() instanceof GifDrawable) == true) goto L118;
        if ((r2.k.getDrawable() instanceof WebpDrawable) == true) goto L118;
        r50 = true;
        goto L120
    L107:
        r2.k.setScaleType(ImageView.ScaleType.FIT_CENTER);
    L98:
        r120 = false;
        goto L99
    L80:
        int r126 = UIHelper.dp2px(40.0f);
        int r72 = r113.b;
        if (r42 > r72) goto L85;
        if (r43 > r115) goto L85;
        if (r42 <= 0) goto L85;
        if (r43 <= 0) goto L85;
    L86:
        if (r42 >= r126) goto L88;
        r45 = r126;
        boolean r127 = true;
    L89:
        if (r43 >= r126) goto L91;
        r117 = r43;
        r43 = r126;
        r118 = r42;
        r46 = true;
        goto L92
    L91:
        r118 = r42;
        r46 = r127;
        r117 = r43;
        goto L92
    L88:
        r45 = r42;
        r127 = false;
    L85:
        int[] r73 = ImageUtils.g(r42, r43, r72, r115, 1, 1);
        r42 = r73[0];
        r43 = r73[1];
        goto L86
    L70:
        if ((r43 / r42) < 3) goto L76;
        if (r42 <= UIHelper.dp2px(200.0f)) goto L76;
        if (r116 <= UIHelper.dp2px(150.0f)) goto L76;
        r44 = true;
        goto L77
    L66:
        r113 = new com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.image.f(r33.a, r33.a(r38, r34));
        r33.b = r113;
        goto L67
    L59:
        r210 = null;
    L56:
        r32 = false;
        goto L57
    L178:
        r1 = r2;
        i(false, r1);
        r3 = this;
        r3.j(r1, r7, r8, 2131891411);
        goto L179
    L23:
        if (r14.isCSAMDelete() != true) goto L25;
        r15 = true;
        goto L27
    L15:
        if (r11.e != true) goto L17;
        r12 = true;
    L11:
        r11 = null;
        goto L13
    L5:
        r5 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m<y6b.a<ImageContentVO>> r1, com.ss.android.lark.blueprint.q<y6b.a<ImageContentVO>> r2, y6b.a<ImageContentVO> r3) {
        update2(r1, r2, r3);
    }

    public final void j(b r2, int r3, int r4, int r5) {
        Pair<Integer, Integer> r6 = MessagePermissionUtil.l(r2.d, r5);
        if (this.e == null) goto L5;
        r6 = MessagePermissionUtil.i(r6, r3, r3, r4);
    L5:
        ViewGroup.LayoutParams r7 = r2.c.getLayoutParams();
        r7.width = ((Number) r6.getFirst()).intValue();
        r7.height = ((Number) r6.getSecond()).intValue();
        r2.c.setLayoutParams(r7);
    }
}
