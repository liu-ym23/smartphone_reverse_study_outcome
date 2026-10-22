package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.collection.LruCache;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.DeviceUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.auditsdk.v2.AuthorizationServiceV2;
import com.ss.android.lark.chat.base.model.GifLoadConfig;
import com.ss.android.lark.chat.base.view.vo.message.StickerContentVO;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.core.dependency.StickerDependency;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.StickerContent;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.chatbase.view.ChatImageGroup;
import com.ss.android.lark.chatbase.view.ChatImageView;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.image.entity.ListenerParams;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.image.impl.PerfLoadPicMonitor;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.cleanresource.ResourceType;
import com.ss.android.lark.widget.mark.MarkView;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class StickerContentBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<StickerContentVO>, StickerContentVO> {
    public static final /* synthetic */ int l = 0;
    public final IMMessageKeys$Blocks g;
    public final StickerDependency h;
    public final Lazy i;
    public final int j;
    public int k;

    public static final class a {
    }

    public static final class b implements com.ss.android.lark.blueprint.k<View> {
        public final View a;
        public final LKUIRoundableLayout b;
        public final ChatImageGroup c;
        public final View d;
        public final ChatImageView e;
        public final MarkView f;
        public final MarkView g;

        public final View getView() {
            return this.a;
        }

        /* JADX WARN: Type inference failed for: r3v3, types: [android.widget.ImageView, com.ss.android.lark.chatbase.view.ChatImageView] */
        public b(View r3) {
            Intrinsics.checkNotNullParameter(r3, "view");
            this.a = r3;
            this.b = r3.findViewById(2131384849);
            ChatImageGroup r0 = (ChatImageGroup) r3.findViewById(2131374931);
            this.c = r0;
            this.d = r3.findViewById(2131386031);
            TextView r4 = (TextView) r3.findViewById(2131383286);
            ?? r5 = r0.a;
            this.e = r5;
            this.f = r0.h;
            this.g = r0.i;
            r5.setVisibility(0);
            r0.b.setVisibility(8);
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ StickerContentBlock a;
        public final /* synthetic */ b b;
        public final /* synthetic */ y6b.a<StickerContentVO> c;

        public c(StickerContentBlock r1, b r2, y6b.a<StickerContentVO> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r15) {
            StickerContentBlock r16 = this.a;
            b r0 = this.b;
            y6b.a<StickerContentVO> r5 = this.c;
            r16.getClass();
            StickerContentVO r1 = r5.b();
            if (r5.isPreMessage() == false) goto L6;
            return;
        L6:
            if (com.ss.android.lark.utils.y0.d(r1.f()) == false) goto L9;
            LKUIToast.show(r16.getContext(), UIHelper.getString(2131892067));
            return;
        L9:
            if (((StickerContent) r5.b().a).resourceIsCleaned() == false) goto L15;
            y6b.b r2 = r5.a();
            if (r2 != null) goto L13;
            String r3 = BuildConfig.FLAVOR;
        L14:
            acc.a.f(r16.getContext(), new acc.d(ResourceType.STICKER, lpc.a.b(r5), acc.a.d(r3)));
            return;
        L13:
            r3 = r2.w;
            goto L14
        L15:
            ValidateResult r4 = MessagePermissionUtil.b();
            if (MessagePermissionUtil.f(r5, r16.c.getChat(), r4) == true) goto L18;
            MessagePermissionUtil.n(r16.getContext(), 2131891410, r4);
            owa.a.c().a(r4, AuthorizationServiceV2.AuthorizationType.PREVIEW_AUTHORIZATION);
            return;
        L18:
            owa.a.c().a(r4, AuthorizationServiceV2.AuthorizationType.PREVIEW_AUTHORIZATION);
            ChatCoreModule.a().getChatDependency().d(r16.c, r5);
            if (TextUtils.isEmpty((String) r1.g.getValue()) == false) goto L21;
            String r6 = r1.f();
            if (r6 == null) goto L43;
            PhotoItem.PicInfo r7 = new PhotoItem.PicInfo(r1.f(), new ArrayList(), r1.g(), r1.e(), new EncryptImage(r6));
            PhotoItem r9 = new PhotoItem().setImageKey(r1.f()).setPaths(CollectionsKt.listOf(r1.f())).setLoadModel(new EncryptImage(r6)).setMiddlePicInfo(r7).setMessageId(r5.getId());
            r9.setThumbnail(com.ss.android.lark.chat.utils.v0.h(r0.e));
            r9.setType(5);
            r9.getTranslateProperty().setTranslated(false);
            mya.v r8 = r16.c.j5().b(mya.v.class);
            if (r8 == null) goto L32;
            r8.b(r16.c, r0.e, null, r5, null, false, 3);
            return;
        L32:
            b3b.p r10 = (b3b.p) r16.i.getValue();
            if (r10 == null) goto L41;
            r10.s(r0.e, null, r9, false, false, 3, r5.J());
            return;
        L41:
            return;
        L43:
            return;
        L21:
            if (r16.c.e0() == false) goto L25;
            m2b.a r11 = r16.c;
            if ((r11 instanceof com.ss.android.lark.chat.message.menu.context.c) == false) goto L25;
            Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type com.ss.android.lark.chat.message.menu.context.IMergeForwardSceneContext");
            ((com.ss.android.lark.chat.message.menu.context.c) r11).g0();
        L25:
            StickerDependency r12 = ChatCoreModule.a().getStickerDependency();
            r16.getContext();
            r12.p0();
        }
    }

    public static final class d implements View.OnLongClickListener {
        public final /* synthetic */ com.ss.android.lark.blueprint.m<y6b.a<StickerContentVO>> a;
        public final /* synthetic */ StickerContentBlock b;
        public final /* synthetic */ y6b.a<StickerContentVO> c;

        public d(com.ss.android.lark.blueprint.m<y6b.a<StickerContentVO>> r1, StickerContentBlock r2, y6b.a<StickerContentVO> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r4) {
            e6b.b r5 = this.a;
            if ((r5 instanceof e6b.b) == false) goto L5;
            e6b.b r6 = r5;
        L7:
            if (r6 != null) goto L9;
            return false;
        L9:
            if (r6.e(this.b, this.c) != true) goto L13;
            return true;
        L13:
            return false;
        L5:
            r6 = null;
            goto L7
        }
    }

    static {
    }

    public final com.ss.android.lark.blueprint.j getKey() {
        return this.g;
    }

    public StickerContentBlock(com.ss.android.lark.blueprint.g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.g = IMMessageKeys$Blocks.STICKER_CONTENT;
        this.h = ChatCoreModule.a().getStickerDependency();
        this.i = LazyKt.lazy(new StickerContentBlock$stickerClickListener$2(this));
        this.j = UIUtils.dp2px(getContext(), 40.0f);
        this.k = UIUtils.dp2px(getContext(), 150.0f);
    }

    public static void h(b r2, int r3) {
        Pair r4 = MessagePermissionUtil.l(r2.e, r3);
        ViewGroup.LayoutParams r0 = new FrameLayout.LayoutParams(((Number) r4.getFirst()).intValue(), ((Number) r4.getSecond()).intValue());
        r2.e.setLayoutParams(r0);
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(com.ss.android.lark.blueprint.m<y6b.a<StickerContentVO>> r25, com.ss.android.lark.blueprint.q<y6b.a<StickerContentVO>> r26, y6b.a<StickerContentVO> r27) {
        Intrinsics.checkNotNullParameter(r25, "cell");
        Intrinsics.checkNotNullParameter(r26, "layout");
        Intrinsics.checkNotNullParameter(r27, Keys.API_RETURN_KEY_DATA);
        b r2 = (b) r26.c(this.g, IMMessageKeys$Slots.CONTENT, StickerContentBlock$update$blockView$1.INSTANCE);
        StickerContentVO r4 = r27.b();
        ResourceCleanScene r5 = lpc.a.b(r27);
        if (r5 != null) goto L5;
    L7:
        com.ss.android.lark.biz.im.api.message.params.w r9 = null;
        if (MessagePermissionUtil.f(r27, this.c.getChat(), null) == true) goto L11;
        h(r2, 2131891411);
    L10:
        StickerContentVO r23 = r4;
    L87:
        ViewGroup.LayoutParams r1 = r2.b.getLayoutParams();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r1;
        if (this.c.m() == false) goto L90;
    L94:
        float[] r6 = com.ss.android.lark.chat.utils.f0.a(r27, 10.0f, 2.0f);
        int r7 = 1;
        r2.b.setRadius(r6[0], r6[1], r6[2], r6[3]);
        LKUIRoundableLayout r8 = r2.b;
        StickerContentVO r10 = r23;
        Message r11 = r10.h;
        if (r11 != null) goto L97;
    L99:
        r7 = 0;
    L100:
        r8.setBorderWidth(r7);
        r3.topMargin = 0;
    L101:
        i3b.d r12 = (i3b.d) this.a.c.a(i3b.d.class);
        if (r12 == null) goto L109;
        m2b.a r13 = r12.a();
        if (r13 == null) goto L109;
        com.ss.android.lark.biz.im.api.message.params.w r14 = r13.d0(com.ss.android.lark.biz.im.api.message.params.w.class);
        if (r14 == null) goto L109;
        r2.b.setRadius(r14.a);
    L109:
        if (this.c.m() == false) goto L111;
    L118:
        r2.c.setBackgroundColor(UDColorUtils.getColor(getContext(), 2131100548));
    L119:
        r2.c.setOnClickListener(new c(this, r2, r27));
        r2.c.setOnLongClickListener(new d(r25, this, r27));
        r2.b.setLayoutParams(r3);
        b3b.p r15 = (b3b.p) this.i.getValue();
        if (r15 == null) goto L123;
        r15.C(r27.getId(), r10);
        return;
    L123:
        return;
    L111:
        if (this.c.r() == true) goto L118;
        if (this.c.q() == true) goto L118;
        if (this.c.Y() == true) goto L118;
        r2.c.setBackgroundColor(UDColorUtils.getColor(getContext(), 2131102441));
        goto L119
    L97:
        if (r11.isDing() != true) goto L99;
    L90:
        if (TextUtils.isEmpty(r27.F()) == true) goto L92;
    L93:
        r2.b.setRadius(4.0f);
        r3.topMargin = 0;
        r2.b.setBorderWidth(0.0f);
        r10 = r23;
        goto L101
    L92:
        if (r27.l() == false) goto L94;
    L11:
        i3b.d r16 = (i3b.d) this.a.c.a(i3b.d.class);
        if (r16 == null) goto L16;
        m2b.a r17 = r16.a();
        if (r17 == null) goto L16;
        r9 = (com.ss.android.lark.biz.im.api.message.params.w) r17.d0(com.ss.android.lark.biz.im.api.message.params.w.class);
    L16:
        StickerContentVO r18 = r27.b();
        int r19 = r18.g();
        int r110 = r18.e();
        String r111 = r18.f();
        int r112 = (int) DeviceUtils.getScreenDensity(getContext());
        int r113 = r19 * r112;
        int r114 = r110 * r112;
        ResourceCleanScene r115 = lpc.a.b(r27);
        if (r115 != null) goto L19;
    L21:
        boolean r116 = false;
    L22:
        if (r116 == false) goto L24;
        boolean r117 = acc.a.c(r113, r114, r2.f.getWidth());
    L25:
        r2.f.setTag(Boolean.valueOf(r117));
        Context r118 = getContext();
        if (r9 == null) goto L28;
        float r20 = r9.b;
    L29:
        int r21 = UIUtils.dp2px(r118, r20);
        this.k = r21;
        v4b.d r119 = this.e;
        if (r119 == null) goto L35;
        int r120 = r119.d;
        if (r120 <= 0) goto L35;
        if (r120 >= r21) goto L35;
        this.k = r120;
    L35:
        Context r22 = getContext();
        int r121 = this.k;
        int r122 = this.j;
        LruCache r123 = ImageUtils.a;
        if (r114 > 0) goto L38;
        r114 = r122;
    L38:
        if (r113 > 0) goto L40;
        r113 = r122;
    L40:
        int[] r24 = new int[2];
        if (r114 < r122) goto L46;
        if (r113 < r122) goto L46;
        if (r114 > r121) goto L46;
        if (r113 > r121) goto L46;
        r24[0] = r113;
        r24[1] = r114;
        r23 = r4;
    L58:
        char r28 = 0;
        char r29 = 1;
    L69:
        if (r24[r28] >= r122) goto L72;
        r24[r28] = r122;
    L72:
        if (r24[r29] >= r122) goto L74;
        r24[r29] = r122;
    L74:
        r24[r28] = UIUtils.px2dp(r22, r24[r28]);
        int r30 = UIUtils.px2dp(r22, r24[r29]);
        r24[r29] = r30;
        int r31 = r24[r28];
        Context r32 = getContext();
        AppCompatImageView r33 = r2.e;
        ViewGroup.LayoutParams r34 = r33.getLayoutParams();
        float r35 = r31;
        r34.width = UIUtils.dp2px(r32, r35);
        float r124 = r30;
        r34.height = UIUtils.dp2px(r32, r124);
        r33.setLayoutParams(r34);
        if (this.c.isSecretChat() == false) goto L78;
        Scene r36 = Scene.SecretChat;
    L84:
        ListenerParams.a r37 = new ListenerParams.a();
        r37.a(Biz.Messenger);
        r37.d(r36);
        r37.c(ListenerParams.FromType.STICKER);
        r37.a = true;
        r37.b = false;
        r37.c = r31;
        r37.d = r30;
        r37.o = r111;
        GifLoadConfig r38 = (GifLoadConfig) SettingManager.getInstance().get(GifLoadConfig.class);
        int r210 = r38.getSize();
        int r211 = r38.getWidth();
        int r212 = r38.getHeight();
        r37.h = new j0(r2, r116);
        StickerDependency r125 = this.h;
        Context r126 = getContext();
        int r39 = UIUtils.dp2px(getContext(), r35);
        int r40 = UIUtils.dp2px(getContext(), r124);
        ChatImageView r41 = r2.e;
        String r127 = (String) r18.g.getValue();
        PerfLoadPicMonitor.MonitorRequestListener r42 = new PerfLoadPicMonitor.MonitorRequestListener(r37.b());
        boolean r43 = r116;
        r125.o0(r126, r39, r40, r111, r41, r127, r42, r210, r211, r212);
        if (r43 == false) goto L87;
        acc.a.e(getContext(), r31, r30, r2.f, r2.g);
        goto L87
    L78:
        if (this.c.r() == false) goto L80;
    L83:
        r36 = Scene.Thread;
        goto L84
    L80:
        if (this.c.q() == true) goto L83;
        r36 = Scene.Chat;
    L46:
        if (r113 <= r114) goto L48;
        int r44 = r113;
    L49:
        if (r113 >= r114) goto L51;
        int r45 = r113;
    L52:
        r23 = r4;
        float r46 = r44 / r45;
        if (r46 > (r121 / r122)) goto L55;
        if (r45 > r122) goto L61;
        r121 = (int) (r122 * r46);
        int r47 = r122;
    L64:
        r28 = 0;
        if (r113 < r114) goto L67;
        r24[0] = r121;
        r29 = 1;
        r24[1] = r47;
        goto L69
    L67:
        r29 = 1;
        r24[0] = r47;
        r24[1] = r121;
        goto L69
    L61:
        if (r44 < r121) goto L63;
        r47 = (int) (r121 / r46);
        goto L64
    L63:
        r47 = 0;
        r121 = 0;
        goto L64
    L55:
        if (r113 < r114) goto L57;
        r24[0] = r121;
        r24[1] = r122;
        goto L58
    L57:
        r24[0] = r122;
        r24[1] = r121;
        goto L58
    L51:
        r45 = r114;
        goto L52
    L48:
        r44 = r114;
        goto L49
    L28:
        r20 = 150.0f;
        goto L29
    L24:
        r117 = r116;
        goto L25
    L19:
        if (r115.isUnifiedRegularDelete() == false) goto L21;
        r116 = true;
        goto L22
    L5:
        if (r5.isCSAMDelete() == false) goto L7;
        h(r2, 2131891117);
        goto L10
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m<y6b.a<StickerContentVO>> r1, com.ss.android.lark.blueprint.q<y6b.a<StickerContentVO>> r2, y6b.a<StickerContentVO> r3) {
        update2(r1, r2, r3);
    }
}
