package com.bytedance.android.livesdk.interactivity.publicscreen.plugin;

import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.base.model.message.v0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.interactivity.api.entity.PublicScreenRichTextUtilsKt;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.s;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.x;
import com.bytedance.android.livesdk.interactivity.api.utils.MessageCommonColorUtil;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.r;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.w;
import com.bytedance.android.livesdk.w7;
import com.bytedance.android.livesdkapi.message.MessageIdentity;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class EmojiChatPublicScreenPluginV2 extends x implements l {
    public static final /* synthetic */ int d = 0;
    public final DataCenter b;
    public final o c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.x
    public final void q() {
    }

    public final void onMessage(tlc.d r18) {
        com.bytedance.android.livesdk.interactivity.api.publicscreen.l r1 = o();
        if (r1 == null) goto L95;
        e52.a r2 = r1.getTextConfig();
        if (r2 == null) goto L95;
        n42.a r3 = r2.a();
        if (r3 == null) goto L95;
        int r4 = r3.a;
        if ((r18 instanceof v0) == false) goto L93;
        v0 r0 = (v0) r18;
        IBaseUser r5 = r0.getUserInfo();
        a5 r6 = r0.getEmojiContent();
        String r7 = r0.getDefaultContent();
        if (r5 == null) goto L91;
        if (r7 == null) goto L91;
        tb2.d r8 = new tb2.d();
        r8.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(String.valueOf(8206)));
        DataCenter r9 = this.b;
        boolean r10 = false;
        r8.b(CollectionsKt.toMutableList(com.bytedance.android.livesdk.interactivity.service.textrender.utils.d.e(r5, false, false)));
        String r11 = null;
        r8.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.h(r5, null, false, a0.m(r9).c));
        MessageIdentity r13 = r0.getMessageIdentity();
        if (r13 != null) goto L17;
    L23:
        k r14 = null;
    L24:
        if (r14 == null) goto L27;
        r8.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.c(r14, ITextPieceImage.ScaleType.DEFAULT, 2131232606));
    L27:
        if (r0.isFromOtherIntercomRoom() == false) goto L29;
        int r15 = ColorProtector.parseColor("#99ffffff");
    L30:
        r8.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.e(r15, "："));
        if (r6 != null) goto L33;
        r8.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(r7));
    L78:
        if (r0.isFromOtherIntercomRoom() == false) goto L80;
        int r16 = MessageCommonColorUtil.b();
    L81:
        int r17 = MessageCommonColorUtil.a;
        r8.b = new s.a(r16, MessageCommonColorUtil.a());
        if (((Boolean) w7.a.getValue()).booleanValue() == false) goto L84;
        r8.a(PublicScreenRichTextUtilsKt.c(r0.getOrInitPublicAreaCommon(), w.a()));
    L84:
        String r19 = jc1.k.n(IMiddlewareUserService.class).user().n();
        IBaseUser r20 = r0.getUserInfo();
        if (r20 == null) goto L87;
        r11 = r20.getIdString();
    L87:
        com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel.e r21 = new com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel.e(r0, r8, Intrinsics.areEqual(r19, r11), r10);
        com.bytedance.android.livesdk.interactivity.api.publicscreen.l r23 = o();
        if (r23 == null) goto L118;
        r23.insertMessage(r21);
        return;
    L118:
        return;
    L80:
        int r24 = MessageCommonColorUtil.a;
        r16 = MessageCommonColorUtil.d();
        goto L81
    L33:
        List r25 = r6.getPieces();
        if (r25 == null) goto L41;
        Iterator r26 = r25.iterator();
    L37:
        if (r26.hasNext() == false) goto L41;
        ITextPieceImage r110 = ((c5) r26.next()).getImageValue();
        if (r110 == null) goto L37;
        r110.setExtraOpt(ITextPieceImage.ExtraOpt.OTHER);
    L41:
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.a.getClass();
        com.bytedance.android.livesdk.interactivity.service.textrender.core.x r27 = r.b;
        Intrinsics.checkNotNullParameter(r6, "text");
        tb2.d r28 = r.a(r6, null);
        Iterator<tb2.c> r29 = r28.a.iterator();
        boolean r111 = false;
    L43:
        if (r29.hasNext() == false) goto L62;
        tb2.c r112 = r29.next();
        ITextPieceImage r113 = r112.getImageValue();
        if (r113 == null) goto L43;
        if (r111 == true) goto L52;
        k r114 = r113.getImageModel();
        if (r114 == null) goto L52;
        if (r114.isAnimated() != true) goto L52;
        r111 = true;
    L52:
        int r115 = (int) (r4 * r113.getScalingRate());
        if (r113.getScalingRate() <= 0.0f) goto L56;
        r113.setScaleType(ITextPieceImage.ScaleType.FIT_Y);
        r113.setHeight(r115);
    L56:
        if (r7.length() <= 0) goto L58;
        boolean r116 = true;
    L59:
        if (r116 == false) goto L61;
        r113.setEnableTextWhenFailed(true);
        r112.setText(r7);
    L61:
        r113.setExtraOpt(ITextPieceImage.ExtraOpt.OTHER);
        goto L43
    L58:
        r116 = false;
        goto L59
    L62:
        Iterator<tb2.c> r30 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.d.e(r5, false, false).iterator();
        r10 = r111;
    L64:
        if (r30.hasNext() == false) goto L73;
        ITextPieceImage r31 = r30.next().getImageValue();
        if (r31 == null) goto L64;
        if (r10 == true) goto L64;
        k r33 = r31.getImageModel();
        if (r33 == null) goto L64;
        if (r33.isAnimated() != true) goto L64;
        r10 = true;
        goto L64
    L73:
        Iterator<tb2.c> r34 = r28.a.iterator();
    L75:
        if (r34.hasNext() == false) goto L78;
        r8.c(r34.next());
        goto L75
    L29:
        r15 = ColorProtector.parseColor("#FF8ce7ff");
        goto L30
    L17:
        if (r13.getShowIdentity() != 1) goto L19;
        boolean r117 = true;
    L20:
        if (r117 == false) goto L23;
        r14 = r13.getIdentityLabel();
        goto L24
    L19:
        r117 = false;
    L91:
        return;
    L93:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.x
    public final void p(com.bytedance.android.livesdk.interactivity.api.publicscreen.l r2) {
        Intrinsics.checkNotNullParameter(r2, "publicScreenContext");
        j r3 = this.c.getMessageManager();
        if (r3 == null) goto L5;
        r3.c(new EmojiChatPublicScreenPluginV2$onLoad$1(this));
    L5:
        com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel.f r4 = com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel.f.c;
        n(com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel.f.a, r4);
    }

    public EmojiChatPublicScreenPluginV2(DataCenter r2, o r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "roomContext");
        this.b = r2;
        this.c = r3;
    }
}
