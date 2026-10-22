package com.ss.android.lark.coremd.clickcompat;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import b3b.j;
import com.bytedance.lark.pb.basic.v1.ImageCropType;
import com.bytedance.lark.pb.basic.v1.ImageSetV2;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.base.view.vo.message.PostContentVO;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.ChatAnnouncement;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.chat.utils.v0;
import com.ss.android.lark.coremd.facade.bizext.props.IMImageExtend;
import com.ss.android.lark.flow.chat.page.flow.plugin.g;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.announce_opendoc.AnnounceOpenDocHitPoint;
import com.ss.android.lark.widget.photopicker.animation.activitytransition.ActivityTransitionLauncher;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import mya.s;
import v7b.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatImageClickHandler {
    public final m2b.a a;
    public final c.b b;
    public final c.a c;
    public final v4b.d d;

    public static final class a {
    }

    static {
    }

    public ChatImageClickHandler(m2b.a r2, g.b r3, c.a r4, v4b.d r5) {
        Intrinsics.checkNotNullParameter(r2, "chatContext");
        Intrinsics.checkNotNullParameter(r3, "messageProvider");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }

    public final boolean b(String r14, String r15, View r16, Map<String, ImageSetV2> r17, boolean r18) {
        Intrinsics.checkNotNullParameter(r14, "imageKey");
        Intrinsics.checkNotNullParameter(r15, "messageId");
        Intrinsics.checkNotNullParameter(r16, "view");
        y6b.a<?> r5 = this.b.getMessageById(r15);
        if (r5 != null) goto L5;
        return false;
    L5:
        Object r6 = r5.b();
        if ((r6 instanceof PostContentVO) == true) goto L8;
        return false;
    L8:
        Context r7 = this.a.getContext();
        Object r8 = r5.b();
        if ((r8 instanceof PostContentVO) == true) goto L11;
        boolean r9 = false;
    L12:
        Chat r10 = this.a.getChat();
        Integer r11 = null;
        if (r10 == null) goto L17;
        ChatAnnouncement r12 = r10.getChatAnnouncement();
        if (r12 == null) goto L17;
        String r13 = r12.getAnnounceUrl();
    L18:
        if (r13 != null) goto L21;
        r13 = BuildConfig.FLAVOR;
    L21:
        if (r9 == false) goto L30;
        if (r13.length() != 0) goto L25;
        boolean r19 = true;
    L26:
        if (r19 == true) goto L30;
        ChatCoreModule.a().getBrowserDependency().openUrl(r7, r13);
        AnnounceOpenDocHitPoint.a(this.a.getChatId());
        return true;
    L25:
        r19 = false;
    L30:
        if (CollectionUtils.isEmpty(r17) == false) goto L32;
    L69:
        ImageSetV2 r20 = null;
    L70:
        if (r20 != null) goto L73;
        return false;
    L73:
        if (v0.i(r20) == true) goto L75;
        Image r21 = null;
    L76:
        if (r21 != null) goto L78;
        return false;
    L78:
        String r1 = r5.getId();
        ImageSet r4 = v0.j(r20);
        if (r4 != null) goto L81;
        PhotoItem r22 = null;
    L82:
        if (r22 != null) goto L84;
        return false;
    L84:
        MessageIdentity r2 = r22.getMessageIdentity();
        if (r2 == null) goto L87;
        r2.setRiskObjectKeys(((PostContent) ((PostContentVO) r6).a).getRiskObjectKeys());
    L87:
        r22.getTranslateProperty().setTranslated(r18);
        r22.setThumbnail(v0.h(r16));
        Rect r23 = new Rect();
        r16.getGlobalVisibleRect(r23);
        ActivityTransitionLauncher.LocationInfo r24 = new ActivityTransitionLauncher.LocationInfo();
        Integer r3 = Integer.valueOf(r23.width());
        if (r3.intValue() <= 0) goto L90;
        boolean r110 = true;
    L91:
        if (r110 == true) goto L94;
        r3 = null;
    L94:
        if (r3 == null) goto L96;
        int r25 = r3.intValue();
    L97:
        r24.width = r25;
        Integer r26 = Integer.valueOf(r23.height());
        if (r26.intValue() <= 0) goto L100;
        boolean r111 = true;
    L101:
        if (r111 == false) goto L103;
        r11 = r26;
    L103:
        if (r11 == null) goto L105;
        int r27 = r11.intValue();
    L106:
        r24.height = r27;
        r24.left = r23.left;
        r24.top = r23.top;
        if (this.d == null) goto L112;
        s r28 = this.a.j5().b(s.class);
        if (r28 == null) goto L112;
        r28.b(this.a, r16, r23, r5, r21, r18, 2);
        return true;
    L112:
        c.a r29 = this.c;
        if (r29 != null) goto L116;
        Log.w("ChatImageClickHandler", "handleMovableImageClick: real image click handler is null");
        return false;
    L116:
        j r30 = r29.a;
        if (r30 == null) goto L120;
        r30.s(r16, r24, r22, false, r18, 2, r5.J());
        return true;
    L120:
        return false;
    L105:
        r27 = r16.getHeight();
        goto L106
    L100:
        r111 = false;
        goto L101
    L96:
        r25 = r16.getWidth();
        goto L97
    L90:
        r110 = false;
        goto L91
    L81:
        r22 = com.ss.android.lark.widget.photo.preview.utils.d.a(r4, r1);
        goto L82
    L75:
        r21 = v0.b(r20, v0.c(r20, new ImageCropType[]{ImageCropType.ORIGIN}));
        goto L76
    L32:
        if (TextUtils.isEmpty(r14) == true) goto L69;
        r20 = r17.get(r14);
        if (v0.i(r20) == true) goto L70;
        int r31 = r14.indexOf(63);
        if (r31 < 0) goto L40;
        String r32 = r14.substring(0, r31);
    L41:
        int r33 = r32.indexOf(35);
        if (r33 < 0) goto L44;
        r32 = r32.substring(0, r33);
    L44:
        int r34 = r32.lastIndexOf(47);
        if (r34 < 0) goto L50;
        if (r34 >= (r32.length() - 1)) goto L50;
        r32 = r32.substring(r34 + 1);
    L50:
        if (TextUtils.equals(r32, r14) == true) goto L54;
        ImageSetV2 r35 = r17.get(r32);
        if (v0.i(r35) == false) goto L54;
        r20 = r35;
    L54:
        Iterator<Map.Entry<String, ImageSetV2>> r36 = r17.entrySet().iterator();
    L56:
        if (r36.hasNext() == false) goto L69;
        Map.Entry<String, ImageSetV2> r37 = r36.next();
        ImageSetV2 r38 = r37.getValue();
        if (v0.i(r38) == false) goto L56;
        if (TextUtils.equals(r37.getKey(), r14) == true) goto L68;
        if (TextUtils.equals(r37.getKey(), r32) == true) goto L68;
        if (TextUtils.equals(r38.image_key, r14) == true) goto L68;
        if (TextUtils.equals(r38.image_key, r32) == false) goto L56;
    L68:
        r20 = r38;
        goto L70
    L40:
        r32 = r14;
    L17:
        r13 = null;
        goto L18
    L11:
        r9 = ((PostContentVO) r8).i();
        goto L12
    }

    public final void a(final l r12, final String r13, final View r14, final Rect r15, final Drawable r16, final pwa.a r17, final boolean r18) {
        Intrinsics.checkNotNullParameter(r12, "imageNode");
        Intrinsics.checkNotNullParameter(r13, "messageId");
        Intrinsics.checkNotNullParameter(r14, "view");
        Intrinsics.checkNotNullParameter(r15, "bounds");
        IMImageExtend.p.b(new ChatImageClickHandler$handleImageClick$1(r17, this, r13, r18, r12, r16, r15, r14));
    }
}
