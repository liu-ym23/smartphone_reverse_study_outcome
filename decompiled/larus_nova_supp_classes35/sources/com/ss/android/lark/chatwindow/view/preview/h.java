package com.ss.android.lark.chatwindow.view.preview;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.lark.pb.basic.v1.MessageLink;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.chat.utils.i0;
import com.ss.android.lark.coremd.clickcompat.MomentsAppLinkPatcher;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.Url;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import com.ss.android.lark.export.entity.preview.UrlPreviewBody;
import com.ss.android.lark.export.entity.preview.UrlPreviewState;
import com.ss.android.lark.export.entity.preview.UrlPreviewTemplate;
import com.ss.android.lark.parser.internal.t;
import com.ss.android.lark.statistics.chat.ChatHitPointNew;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ UrlPreviewBinder a;
    public final /* synthetic */ PreviewHangPoint b;
    public final /* synthetic */ LKUIRoundableLayout c;

    public h(UrlPreviewBinder r1, PreviewHangPoint r2, LKUIRoundableLayout r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r19) {
        UrlPreviewBinder.c r1 = this.a.h;
        if (r1 != null) goto L5;
    L7:
        UrlCardPreviewEntity r2 = this.b.getUrlCardPreviewEntity();
        String r3 = null;
        if (r2 == null) goto L10;
        UrlPreviewBody r4 = r2.getPreviewBody();
    L11:
        if (r4 == null) goto L116;
        UrlPreviewBody r5 = r2.getPreviewBody();
        Intrinsics.checkNotNull(r5);
        String r6 = r5.getCurrentStateId();
        Map<String, UrlPreviewState> r7 = r5.getStates();
        if (r7 != null) goto L15;
    L17:
        boolean r8 = false;
    L18:
        if (r8 == false) goto L117;
        Map<String, UrlPreviewState> r9 = r5.getStates();
        Intrinsics.checkNotNull(r9);
        if (r9.get(r6) == null) goto L118;
        Map<String, UrlPreviewState> r10 = r5.getStates();
        Intrinsics.checkNotNull(r10);
        UrlPreviewState r11 = r10.get(r6);
        if (r11 == null) goto L24;
        Url r12 = r11.getCardUrl();
    L25:
        if (r12 == null) goto L35;
        String r13 = r12.getAndroidUrl();
        if (r13 != null) goto L29;
    L32:
        boolean r14 = true;
    L33:
        if (r14 == false) goto L35;
        String r15 = r12.getUrl();
    L37:
        String r16 = r15;
    L40:
        if (this.b.isMessageLink() == false) goto L52;
        Map<String, MessageLink> r17 = this.a.c.g().z();
        if (r17 == null) goto L50;
        UrlCardPreviewEntity r18 = this.b.getUrlCardPreviewEntity();
        if (r18 == null) goto L48;
        UrlInlinePreviewEntity r20 = r18.getInlineEntity();
        if (r20 == null) goto L48;
        String r21 = r20.getPreviewId();
    L49:
        MessageLink r22 = r17.get(r21);
    L51:
        com.ss.android.lark.chat.entity.message.MessageLink r23 = t.a(r22);
    L53:
        String r110 = MomentsAppLinkPatcher.a(r16);
        if (r110 != null) goto L56;
        return;
    L56:
        BrowserDependency r24 = ChatCoreModule.a().getBrowserDependency();
        UrlPreviewBinder r111 = this.a;
        Context r112 = r111.a;
        m2b.a r113 = r111.d;
        if (r113 != null) goto L59;
    L61:
        int r114 = 0;
    L62:
        Bundle r115 = i0.b(r2.getInlineEntity().getPreviewId(), r23);
        m2b.a r116 = this.a.d;
        if (r116 == null) goto L65;
        Fragment r117 = r116.R();
    L66:
        String r118 = r2.getInlineEntity().getTitle();
        if (r118 != null) goto L69;
        r118 = BuildConfig.FLAVOR;
    L69:
        r24.d(r112, r110, r114, BrowserDependency.UrlClickType.CARD, r115, r117, r118);
        HashMap<String, UrlPreviewTemplate> r25 = r5.getTemplates();
        if (r25 != null) goto L72;
    L75:
        boolean r26 = true;
    L76:
        if (r26 == true) goto L101;
        HashMap<String, UrlPreviewTemplate> r27 = r5.getTemplates();
        if (r11 == null) goto L80;
        String r119 = r11.getTemplateId();
    L82:
        if (r27.get(r119) == null) goto L101;
        HashMap<String, UrlPreviewTemplate> r28 = r5.getTemplates();
        if (r11 == null) goto L86;
        String r120 = r11.getTemplateId();
    L87:
        UrlPreviewTemplate r29 = r28.get(r120);
        if (r29 == null) goto L90;
        String r30 = r29.getRootComponentId();
    L91:
        if (r30 == null) goto L101;
        HashMap<String, UrlPreviewTemplate> r31 = r5.getTemplates();
        if (r11 == null) goto L95;
        String r32 = r11.getTemplateId();
    L96:
        UrlPreviewTemplate r33 = r31.get(r32);
        if (r33 == null) goto L99;
        String r34 = r33.getRootComponentId();
    L100:
        String r121 = r34;
    L102:
        Map r122 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("msg_id", this.a.c.g().getId()), TuplesKt.to("cid", this.a.c.g().getcId()), TuplesKt.to("msg_type", this.a.c.g().getType())});
        r122.putAll(ChatHitPointNew.a(this.a.c.g()));
        UrlInlinePreviewEntity.AppInfo r35 = r2.getInlineEntity().getAppInfo();
        String r36 = r2.getInlineEntity().getPreviewId();
        if (r35 == null) goto L107;
        Long r37 = r35.getAppId();
        if (r37 == null) goto L107;
        String r123 = r37.toString();
    L108:
        if (r35 == null) goto L112;
        Long r38 = r35.getSceneType();
        if (r38 == null) goto L112;
        r3 = r38.toString();
    L112:
        ChatHitPointNew.h(r16, r36, "open_page", r121, r123, r3, r122);
        if (r23 == null) goto L119;
        i.d(this.a.c.g().getChatId(), r23);
        return;
    L119:
        return;
    L107:
        r123 = null;
        goto L108
    L99:
        r34 = null;
        goto L100
    L95:
        r32 = null;
        goto L96
    L90:
        r30 = null;
        goto L91
    L86:
        r120 = null;
        goto L87
    L80:
        r119 = null;
    L101:
        r121 = null;
        goto L102
    L72:
        if (r25.isEmpty() == true) goto L75;
        r26 = false;
        goto L76
    L65:
        r117 = null;
        goto L66
    L59:
        if (r113.isGroup() != true) goto L61;
        r114 = 1;
    L48:
        r21 = null;
        goto L49
    L50:
        r22 = null;
        goto L51
    L52:
        r23 = null;
        goto L53
    L29:
        if (r13.length() == 0) goto L32;
        r14 = false;
    L35:
        if (r12 == null) goto L38;
        r15 = r12.getAndroidUrl();
        goto L37
    L38:
        r16 = null;
        goto L40
    L24:
        r12 = null;
        goto L25
    L118:
        return;
    L117:
        return;
    L15:
        if ((!r7.isEmpty()) != true) goto L17;
        r8 = true;
        goto L18
    L116:
        return;
    L10:
        r4 = null;
        goto L11
    L5:
        if (r1.a(this.c, this.b) == false) goto L7;
    }
}
