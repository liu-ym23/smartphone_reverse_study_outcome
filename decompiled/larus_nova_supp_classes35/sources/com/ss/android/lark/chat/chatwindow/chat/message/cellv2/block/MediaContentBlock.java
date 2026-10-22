package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.utils.DeviceUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chat.base.view.vo.message.MediaContentVO;
import com.ss.android.lark.chat.chatwindow.chat.view.IMCircleLoadingView;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.SendStatus;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.chat.utils.MessageImageMonitor;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.chat.utils.MessengerImageLoadController;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.image.entity.ListenerParams;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.DonutProgress;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import com.ss.android.lark.widget.mark.MarkView;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MediaContentBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<MediaContentVO>, MediaContentVO> {
    public static final /* synthetic */ int l = 0;
    public final IMMessageKeys$Blocks g;
    public final int h;
    public com.larksuite.framework.callback.c i;
    public final Lazy j;
    public boolean k;

    public static final class a {
    }

    public static final class b implements com.ss.android.lark.blueprint.k<View> {
        public final View a;
        public final ImageView b;
        public final DonutProgress c;
        public final ImageView d;
        public final ImageView e;
        public final MarkView f;
        public final View g;
        public final MarkView h;
        public final LKUIRoundableLayout i;
        public final View j;
        public final IMCircleLoadingView k;
        public boolean l;

        public final View getView() {
            return this.a;
        }

        public b(View r6) {
            Intrinsics.checkNotNullParameter(r6, "view");
            this.a = r6;
            this.b = (ImageView) r6.findViewById(2131379768);
            DonutProgress r0 = r6.findViewById(2131379830);
            this.c = r0;
            this.d = (ImageView) r6.findViewById(2131379802);
            this.e = (ImageView) r6.findViewById(2131379765);
            MarkView r1 = r6.findViewById(2131379778);
            this.f = r1;
            this.g = r6.findViewById(2131379779);
            MarkView r2 = r6.findViewById(2131384426);
            this.h = r2;
            this.i = r6.findViewById(2131379764);
            this.j = r6.findViewById(2131379769);
            this.k = (IMCircleLoadingView) r6.findViewById(2131379091);
            Context r7 = r6.getContext();
            r0.setShowText(false);
            r0.setFinishedStrokeColor(UIHelper.getColor(2131101111));
            r0.setUnfinishedStrokeColor(j08.b.c(r7, 2131103449, 0.5f));
            float r3 = UIHelper.dp2px(2.0f);
            r0.setFinishedStrokeWidth(r3);
            r0.setUnfinishedStrokeWidth(r3);
            r0.setAttributeResourceId(2131256457);
            r0.setInnerBackgroundColor(j08.b.c(r7, 2131103463, 0.5f));
            r0.setMax(100);
            r1.a = 2131256132;
            r1.b = 2131106521;
            r1.a();
            r2.a = null;
            r2.b = null;
            r2.a();
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[Message.FileDeletedStatus.values().length];
            r0[Message.FileDeletedStatus.FREED_UP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[Message.FileDeletedStatus.RECALLED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L6:
            a = r0;
            int[] r1 = new int[SendStatus.values().length];
            r1[SendStatus.SENDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r1[SendStatus.SUCCESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L21:
            r1[SendStatus.FAIL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L10:
            b = r1;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ MediaContentBlock a;
        public final /* synthetic */ int b;

        public d(MediaContentBlock r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            LKUIToast.show(this.a.getContext(), this.b);
        }
    }

    static {
    }

    public final int h() {
        if (this.c.m() == true) goto L16;
        if (this.c.Y() == true) goto L16;
        lya.a r0 = this.c.l();
        if (r0 == null) goto L12;
        Integer r1 = r0.a();
        if (r1 == null) goto L12;
        int r2 = r1.intValue();
    L14:
        return (int) (r2 * 0.6f);
    L12:
        r2 = UIHelper.getWindowWidth(getContext());
    L16:
        return (int) (((double) DeviceUtils.getScreenHeight(this.c.getContext())) * 0.6d);
    }

    public final com.ss.android.lark.blueprint.j getKey() {
        return this.g;
    }

    public MediaContentBlock(com.ss.android.lark.blueprint.g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.g = IMMessageKeys$Blocks.MEDIA_CONTENT;
        this.h = UIUtils.dp2px(getContext(), 120.0f);
        this.j = LazyKt.lazy(new MediaContentBlock$mClickListener$2(this));
    }

    public static void j(boolean r0, b r1) {
        if (r0 == true) goto L4;
        r1.k.b();
        return;
    L4:
        if (r1.l == false) goto L6;
        return;
    L6:
        r1.l = true;
        r1.k.a();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public final void a(com.ss.android.lark.blueprint.m<y6b.a<MediaContentVO>> r2, com.ss.android.lark.blueprint.q<y6b.a<MediaContentVO>> r3) {
        Intrinsics.checkNotNullParameter(r2, "cell");
        Intrinsics.checkNotNullParameter(r3, "layout");
        com.ss.android.lark.blueprint.i.a.a(r2, r3);
        com.ss.android.lark.blueprint.k r4 = r3.f(this.g, IMMessageKeys$Slots.CONTENT);
        if ((r4 instanceof b) == false) goto L5;
        b r5 = (b) r4;
    L6:
        if (r5 == null) goto L9;
        r5.l = false;
        r5.k.b();
        return;
    L9:
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final void i(b r3, int r4) {
        r3.d.setVisibility(0);
        r3.e.setVisibility(8);
        r3.c.setVisibility(8);
        r3.d.setImageResource(2131256461);
        d r0 = new d(this, r4);
        r3.b.setOnClickListener(r0);
        r3.d.setOnClickListener(r0);
    }

    public final void k(b r4, int r5) {
        ImageView r0 = r4.b;
        w4b.u r1 = MessagePermissionUtil.a;
        Intrinsics.checkNotNullParameter(r0, "imageView");
        if (r5 != 2131891419) goto L5;
        String r6 = BuildConfig.FLAVOR;
    L6:
        int r2 = com.ss.android.lark.widget.span.nopreview.a.k;
        com.ss.android.lark.widget.span.nopreview.a.a r3 = com.ss.android.lark.widget.span.nopreview.a.b.a(r0.getContext());
        Intrinsics.checkNotNullParameter(r6, "text");
        r3.g = r6;
        com.ss.android.lark.widget.span.nopreview.a r7 = r3.a();
        r0.setImageDrawable(r7);
        Pair<Integer, Integer> r8 = TuplesKt.to(Integer.valueOf(r7.b), Integer.valueOf(r7.c));
        v4b.d r9 = this.e;
        if (r9 == null) goto L21;
        if (r9 == null) goto L10;
        int r10 = r9.d;
    L11:
        if (r10 > 0) goto L20;
        lya.a r11 = this.c.l();
        if (r11 == null) goto L18;
        Integer r12 = r11.a();
        if (r12 == null) goto L18;
        int r13 = r12.intValue();
    L19:
        r10 = (int) (r13 * 0.6f);
    L18:
        r13 = UIHelper.getWindowWidth(getContext());
    L20:
        r8 = MessagePermissionUtil.i(r8, r10, h(), this.h);
        goto L21
    L10:
        r10 = 0;
    L21:
        ViewGroup.LayoutParams r14 = r4.i.getLayoutParams();
        r14.width = ((Number) r8.getFirst()).intValue();
        r14.height = ((Number) r8.getSecond()).intValue();
        r4.i.setLayoutParams(r14);
        return;
    L5:
        r6 = r0.getContext().getString(r5);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(com.ss.android.lark.blueprint.m<y6b.a<MediaContentVO>> r25, com.ss.android.lark.blueprint.q<y6b.a<MediaContentVO>> r26, y6b.a<MediaContentVO> r27) {
        Intrinsics.checkNotNullParameter(r25, "cell");
        Intrinsics.checkNotNullParameter(r26, "layout");
        Intrinsics.checkNotNullParameter(r27, Keys.API_RETURN_KEY_DATA);
        b r2 = (b) r26.c(this.g, IMMessageKeys$Slots.CONTENT, MediaContentBlock$update$blockView$1.INSTANCE);
        MediaContentVO r4 = r27.b();
        ImageSet r5 = (ImageSet) r4.f.getValue();
        Image r6 = MessengerImageLoadController.c(MessageImageMonitor.Scene.MEDIA_COVER.getValue(), r5);
        i3b.d r7 = (i3b.d) this.a.c.a(i3b.d.class);
        if (r7 == null) goto L7;
        m2b.a r8 = r7.a();
        if (r8 == null) goto L7;
        com.ss.android.lark.biz.im.api.message.params.j r14 = (com.ss.android.lark.biz.im.api.message.params.j) r8.d0(com.ss.android.lark.biz.im.api.message.params.j.class);
    L8:
        ValidateIMFileResult r9 = r27.N();
        if (r9 == null) goto L11;
        IMFileResult r10 = r9.getResultType();
    L12:
        MessagePermissionUtil.ReceiveAuthorizationState r15 = MessagePermissionUtil.h(r10);
        boolean r16 = MessagePermissionUtil.f(r27, this.c.getChat(), null);
        ResourceCleanScene r17 = lpc.a.b(r27);
        if (r17 == null) goto L18;
        if (r17.isCSAMDelete() == false) goto L18;
        j(false, r2);
        k(r2, 2131891117);
    L26:
        String r1 = "MediaContentBlock";
        ?? r13 = 0;
    L74:
        if (TextUtils.isEmpty(r27.F()) == true) goto L76;
    L79:
        r2.i.setRadius(4.0f);
        r2.i.setBorderWidth(0.0f);
    L80:
        if (r14 == null) goto L82;
        Integer r11 = r14.g;
    L83:
        if (r14 == null) goto L85;
        Integer r12 = r14.h;
    L86:
        if (r11 == null) goto L89;
        if (r12 == null) goto L89;
        r2.i.setBorderColor(r11.intValue());
        r2.i.setBorderWidth(r12.intValue());
    L90:
        int r18 = (int) r4.e();
        if (r17 != null) goto L93;
    L95:
        if (r16 == true) goto L97;
    L126:
        r2.f.setVisibility(8);
        r2.h.setVisibility(8);
    L127:
        this.i = new com.larksuite.framework.callback.c(new Handler(Looper.getMainLooper()));
        OnSingleClickListener r19 = new v(this, r2, r27);
        r2.b.setOnClickListener(r19);
        r2.d.setOnClickListener(r19);
        String r20 = r1;
        w r21 = new w(r25, this, r27);
        r2.b.setOnLongClickListener(r21);
        r2.d.setOnLongClickListener(r21);
        i3b.d r3 = (i3b.d) this.a.c.a(i3b.d.class);
        if (r3 == null) goto L134;
        m2b.a r22 = r3.a();
        if (r22 == null) goto L134;
        com.ss.android.lark.biz.im.api.message.params.j r23 = r22.d0(com.ss.android.lark.biz.im.api.message.params.j.class);
        if (r23 == null) goto L134;
        boolean r110 = r23.a;
    L135:
        MediaContentVO r24 = r27.b();
        r2.d.setVisibility(8);
        r2.e.setVisibility(8);
        r2.c.setVisibility(8);
        r2.j.setVisibility(8);
        Log.d(r20, "media key = " + ((String) r24.b.getValue()));
        ValidateIMFileResult r28 = r27.N();
        if (r28 == null) goto L138;
        IMFileResult r29 = r28.getResultType();
    L139:
        MessagePermissionUtil.ReceiveAuthorizationState r30 = MessagePermissionUtil.h(r29);
        ResourceCleanScene r31 = lpc.a.b(r27);
        if (r31 == null) goto L145;
        if (r31.isCSAMDelete() == false) goto L145;
        return;
    L145:
        if (MessagePermissionUtil.g(r30) == false) goto L148;
        return;
    L148:
        if (MessagePermissionUtil.f(r27, this.c.getChat(), null) == false) goto L186;
        if (r31 != null) goto L152;
    L154:
        Message.FileDeletedStatus r32 = r24.q;
        if (r24.p == false) goto L157;
    L169:
        int r33 = c.a[r32.ordinal()];
        if (r33 == 1) goto L178;
        if (r33 == 2) goto L177;
        w4b.j r34 = ChatCoreModule.a().getDownloadDependency();
        String r35 = r27.getId();
        String r36 = r24.n;
        Message.SourceType r37 = r24.o;
        if (r37 == null) goto L175;
        int r38 = r37.getNumber();
    L176:
        r34.c(r35, r36, r38, (String) r24.b.getValue(), null);
        return;
    L175:
        r38 = 0;
        goto L176
    L177:
        i(r2, 2131892313);
        return;
    L178:
        i(r2, 2131891433);
        return;
    L157:
        if (r32 != Message.FileDeletedStatus.NORMAL) goto L169;
        r2.d.setImageResource(2131243929);
        int r39 = c.b[r27.G().ordinal()];
        if (r39 == 1) goto L167;
        if (r39 == 2) goto L165;
        if (r39 == 3) goto L165;
        if (r110 == true) goto L168;
        r2.d.setVisibility(r13);
    L168:
        r2.c.setOnClickListener(new x(this, r2, r27));
        return;
    L165:
        if (r110 == true) goto L168;
        r2.d.setVisibility(r13);
        goto L168
    L167:
        r2.j.setVisibility(r13);
        r2.c.setVisibility(r13);
        r2.c.setProgress(((Number) r24.h.getValue()).intValue());
        goto L168
    L152:
        if (r31.isUnifiedRegularDelete() == false) goto L154;
        r2.d.setVisibility(r13);
        return;
    L186:
        return;
    L138:
        r29 = null;
    L134:
        r110 = false;
        goto L135
    L97:
        if (MessagePermissionUtil.g(r15) == true) goto L126;
        if (r17 != null) goto L100;
    L102:
        r2.f.setText(com.larksuite.framework.utils.e.g(r18));
        if (r14 == null) goto L105;
        boolean r111 = r14.d;
    L106:
        r2.f.f = r111;
        if (r111 == false) goto L111;
        Drawable r40 = r14.e;
        if (r40 == null) goto L111;
        r2.g.setBackground(r40);
        r2.g.setVisibility(r13);
    L112:
        if (r14 == null) goto L114;
        boolean r112 = r14.b;
    L115:
        if (r112 == false) goto L118;
        MarkView r41 = r2.f;
        r41.e = r13;
        r41.a = null;
        r41.b = null;
        r41.a();
    L118:
        if (r14 == null) goto L120;
        int r42 = r14.c;
    L121:
        if (r42 <= (-1)) goto L125;
        ViewGroup.LayoutParams r43 = r2.f.getLayoutParams();
        if ((r43 instanceof ViewGroup.MarginLayoutParams) == false) goto L125;
        ((ViewGroup.MarginLayoutParams) r43).setMarginEnd(r42);
        MarkView r44 = r2.f;
        r44.setLayoutParams(r44.getLayoutParams());
    L125:
        r2.f.setVisibility(r13);
        r2.h.setVisibility(8);
        goto L127
    L120:
        r42 = -1;
        goto L121
    L114:
        r112 = false;
    L111:
        r2.g.setVisibility(8);
        goto L112
    L105:
        r111 = false;
        goto L106
    L100:
        if (r17.isUnifiedRegularDelete() == false) goto L102;
        r2.h.setText(UIUtils.getString(getContext(), 2131891116));
        r2.h.setVisibility(r13);
        r2.f.setVisibility(8);
        goto L127
    L93:
        if (r17.isCSAMDelete() == false) goto L95;
        r2.f.setVisibility(8);
        r2.h.setVisibility(8);
    L89:
        r2.i.setBorderColor(UIHelper.getColor(2131103351));
        r2.i.setBorderWidth(0.5f);
        goto L90
    L85:
        r12 = null;
        goto L86
    L82:
        r11 = null;
        goto L83
    L76:
        if (r27.l() == true) goto L79;
        float[] r45 = com.ss.android.lark.chat.utils.f0.a(r27, 10.0f, 2.0f);
        r2.i.setRadius(r45[r13], r45[1], r45[2], r45[3]);
        r2.i.setBorderWidth(0.5f);
    L18:
        if (MessagePermissionUtil.g(r15) == true) goto L20;
        if (r16 == true) goto L27;
        j(false, r2);
        k(r2, 2131891414);
        goto L26
    L27:
        if (r6 == null) goto L72;
        if (r5 == null) goto L72;
        if (com.ss.android.lark.chat.utils.g.d(r27) == true) goto L72;
        Image r46 = r5.getOrigin();
        Intrinsics.checkNotNull(r46);
        int r113 = r46.getWidth();
        int r114 = r46.getHeight();
        v4b.d r47 = this.e;
        if (r47 == null) goto L34;
        int r48 = r47.d;
    L35:
        if (r48 <= 0) goto L37;
    L36:
        int r210 = r48;
        int r211 = h();
        int r49 = this.h;
        int[] r50 = ImageUtils.g(r113, r114, r210, r211, r49, r49);
        int r51 = r50[0];
        int r52 = r50[1];
        ViewGroup.LayoutParams r53 = r2.i.getLayoutParams();
        r53.width = r51;
        r53.height = r52;
        r2.i.setLayoutParams(r53);
        if (r27.h() == true) goto L47;
    L49:
        Drawable r54 = null;
    L50:
        if (r54 != null) goto L52;
        r54 = com.ss.android.lark.chat.utils.g.a(getContext(), r51, r52, 0);
    L52:
        Context r115 = getContext();
        GradientDrawable r116 = new GradientDrawable();
        r116.setShape(0);
        r116.setCornerRadius(0);
        r116.setColor(UIUtils.getColor(r115, 2131100556));
        r116.setSize(r51, r52);
        if (this.c.isSecretChat() == false) goto L56;
        Scene r117 = Scene.SecretChat;
    L59:
        ListenerParams.a r118 = new ListenerParams.a();
        r118.a(Biz.Messenger);
        r118.d(r117);
        r118.c(ListenerParams.FromType.MEDIA);
        r118.a = false;
        r118.b = false;
        r118.c = r51;
        r118.d = r52;
        r118.o = r6.getKey();
        r118.p = TextUtils.equals(r6.getKey(), r46.getKey());
        if (r14 == null) goto L65;
        if (r14.i != true) goto L65;
        boolean r55 = true;
    L66:
        if (r55 == false) goto L68;
        u r56 = new u(this, r2);
    L69:
        if (r56 == null) goto L71;
        r118.h = new t(r56);
    L71:
        ListenerParams r119 = r118.b();
        LoadParams r120 = new LoadParams();
        r120.a = r51;
        r120.b = r52;
        r120.c = r54;
        r120.d = r116;
        r120.l = r119;
        r1 = "MediaContentBlock";
        r13 = 0;
        com.ss.android.lark.chat.utils.g.g(getContext(), r2.b, r6, r120, null, r56);
        Log.i(r1, "[setUpCover]imageKey:" + r6.getKey() + " fsUnit:" + r6.getFsUnit());
        r2.b.setTag(2131365616, r27.getcId());
        goto L74
    L68:
        r56 = null;
    L65:
        r55 = false;
        goto L66
    L56:
        if (this.c.r() == false) goto L58;
        r117 = Scene.Thread;
        goto L59
    L58:
        r117 = Scene.Chat;
        goto L59
    L47:
        if (Intrinsics.areEqual(r27.getcId(), r2.b.getTag(2131365616)) == false) goto L49;
        r54 = r2.b.getDrawable();
        goto L50
    L37:
        lya.a r57 = this.c.l();
        if (r57 == null) goto L42;
        Integer r58 = r57.a();
        if (r58 == null) goto L42;
        int r59 = r58.intValue();
    L43:
        r48 = (int) (r59 * 0.6f);
    L42:
        r59 = UIHelper.getWindowWidth(getContext());
        goto L43
    L34:
        r48 = 0;
    L72:
        r1 = "MediaContentBlock";
        r13 = 0;
        j(false, r2);
        com.ss.android.lark.chat.utils.g.f(getContext(), r2.b);
        goto L74
    L20:
        if (r15 != MessagePermissionUtil.ReceiveAuthorizationState.FINAL_AUTHORIZATION_STATE_DENY) goto L22;
        int r60 = 2131891244;
    L23:
        k(r2, r60);
        goto L26
    L22:
        r60 = 2131891419;
        goto L23
    L11:
        r10 = null;
    L7:
        r14 = null;
        goto L8
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m<y6b.a<MediaContentVO>> r1, com.ss.android.lark.blueprint.q<y6b.a<MediaContentVO>> r2, y6b.a<MediaContentVO> r3) {
        update2(r1, r2, r3);
    }
}
