package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.bytedance.android.live.base.model.data.activityemoji.ActivityEmojiGroup;
import com.bytedance.android.live.base.model.data.activityemoji.EffectiveActivityEmojiGroup;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.interactivity.api.IExpressionService;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentFlowContext;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentInputConfig;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.android.livesdk.interactivity.comment.newinput.LivePortraitInputDialogV3;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputPanelSectionContainer;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import com.bytedance.android.livesdk.interactivity.service.emoji.recent.EmojiLocalRecentManager;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class x implements com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k<com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j, z62.d> {
    public final InputSectionType a;
    public com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g b;
    public final a c;
    public boolean d;
    public View e;
    public boolean f;

    public static final class a implements z62.d {
        public final /* synthetic */ x a;

        public a(x r1) {
            this.a = r1;
        }

        @Override // z62.d
        public final void a(EditText r4) {
            KeyEvent r0 = new KeyEvent(0, 67);
            if (r4 == null) goto L6;
            r4.dispatchKeyEvent(r0);
            return;
        }

        @Override // z62.d
        public final void b(BaseEmoji r6, String r7, EditText r8) {
            if (r8 != null) goto L4;
            return;
        L4:
            if (r6 != null) goto L6;
            return;
        L6:
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r0 = this.a.b;
            if (r0 == null) goto L10;
            r0.e();
        L10:
            if (TextUtils.isEmpty(r6.getDescription()) == false) goto L12;
            return;
        L12:
            int r1 = r8.getSelectionStart();
            Editable r9 = r8.getText();
            String r2 = r6.getDescription();
            int r3 = LivePortraitInputDialogV3.L;
            r9.insert(r1, ab2.a.f(r2, LivePortraitInputDialogV3.a.a()));
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r10 = this.a.b;
            if (r10 == null) goto L21;
            com.bytedance.android.livesdk.interactivity.comment.newinput.c r11 = r10.V();
            if (r11 == null) goto L21;
            com.bytedance.android.livesdk.interactivity.comment.newinput.a r13 = r11.g;
            if (r13 == null) goto L21;
            if (r13.q != true) goto L21;
            String r14 = "live_emoji";
        L22:
            int r4 = com.bytedance.android.livesdk.interactivity.comment.utils.a.a;
            Intrinsics.checkNotNullParameter(r14, "pattern");
            Intrinsics.checkNotNullParameter(r7, "emojiType");
            HashMap r5 = new HashMap();
            r5.put("emoji_send_entrance_pattern", r14);
            String r15 = r6.getDescription();
            String r16 = BuildConfig.FLAVOR;
            if (r15 != null) goto L25;
            r15 = BuildConfig.FLAVOR;
        L25:
            r5.put("emoji_name", r15);
            String r17 = r6.getDescription();
            if (r17 == null) goto L29;
            r16 = r17;
        L29:
            r5.put("emoji_content", r16);
            r5.put("tab", r7);
            if (Intrinsics.areEqual("quick", r7) == false) goto L32;
            r5.put("emoji_type", "quick_emoji");
        L33:
            IMiddlewareUserService r18 = jc1.k.f(IMiddlewareUserService.class);
            com.bytedance.android.livesdk.interactivity.service.emoji.recent.b r19 = null;
            if (r18 == null) goto L38;
            com.bytedance.android.livesdk.user.e r20 = r18.user();
            if (r20 == null) goto L38;
            IBaseUser r21 = r20.b();
        L39:
            int r23 = -1;
            if (r21 == null) goto L42;
            int r24 = r21.getGender();
        L43:
            if (r21 == null) goto L45;
            r23 = r21.getAgeRange();
        L45:
            r5.put("user_gender", String.valueOf(r24));
            r5.put("user_age", String.valueOf(r23));
            r5.put("user_group_id", fb2.e.a(r21));
            com.bytedance.android.livesdk.sharedpref.e<com.bytedance.android.livesdk.interactivity.service.emoji.recent.c> r25 = EmojiLocalRecentManager.a;
            String r26 = r6.getDescription();
            Intrinsics.checkNotNullParameter(r26, "desc");
            EmojiLocalRecentManager.c();
            LinkedHashMap<String, com.bytedance.android.livesdk.interactivity.service.emoji.recent.b> r27 = EmojiLocalRecentManager.e;
            if (r27 == null) goto L48;
            r19 = r27.get(r26);
        L48:
            if (r19 == null) goto L50;
            long r28 = r19.d();
        L51:
            r5.put("recent_7d_cnt", String.valueOf(r28));
            r5.put("rank_score", String.valueOf(r6.recommendScore));
            r5.put("event_page", "emoji_panel");
            com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_emoji_click", r5, new Object[]{am2.x.class, IRoom.class});
            return;
        L50:
            r28 = 0;
            goto L51
        L42:
            r24 = -1;
        L38:
            r21 = null;
            goto L39
        L32:
            r5.put("emoji_type", "tab_emoji");
        L21:
            r14 = "comment_keyboard_emoji";
            goto L22
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void a() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j c() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void f() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void g(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void e() {
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = InputPanelSectionContainer.m;
        int r2 = InputPanelSectionContainer.m;
        if (r0.W() == 0) goto L8;
        r2 = r0.W();
    L8:
        View r3 = this.e;
        if (r3 == null) goto L12;
        com.bytedance.android.live.core.utils.a1.k(r3, r2);
    L12:
        if (this.f == true) goto L14;
        return;
    L14:
        if (r0.d0() == false) goto L22;
        EffectiveActivityEmojiGroup r4 = com.bytedance.android.livesdk.interactivity.api.q.c();
        if (r4 == null) goto L23;
        ActivityEmojiGroup r5 = r4.getEmojiGroup();
        if (r5 == null) goto L24;
        long r6 = r5.getId();
        int r7 = com.bytedance.android.livesdk.interactivity.comment.utils.a.a;
        HashMap r8 = new HashMap();
        r8.put("emoticons_id", String.valueOf(r6));
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_activity_emoji_group_show", r8, new Object[]{am2.x.class, IRoom.class});
        return;
    L24:
        return;
    L23:
        return;
    }

    public x() {
        this.a = InputSectionType.EMOJI;
        this.c = new a(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final InputSectionType b() {
        return this.a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final View h(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r15) {
        Intrinsics.checkNotNullParameter(r15, "panelBridge");
        this.b = r15;
        if (this.d == true) goto L68;
        if (jc1.k.f(IMiddleWareHostContext.class) == null) goto L68;
        Context r0 = jc1.k.n(IMiddleWareHostContext.class).context();
        if (r0 == null) goto L68;
        int r1 = InputPanelSectionContainer.m;
        if (PadConfigUtils.a() == true) goto L14;
        boolean r4 = r15.n0();
    L18:
        CommentFlowContext r2 = r15.S();
        String r11 = null;
        if (r2 == null) goto L23;
        CommentInputConfig r3 = r2.d;
        if (r3 == null) goto L23;
        CommentInputConfig.State r5 = r3.b;
    L24:
        CommentInputConfig.State r6 = CommentInputConfig.State.ForceOpen;
        if (r5 != r6) goto L28;
        boolean r7 = true;
    L35:
        boolean r8 = r15.d0();
        Lazy r9 = PublicScreenABHelper.a;
        IRoomContextService r10 = jc1.k.f(IRoomContextService.class);
        if (r10 == null) goto L42;
        com.bytedance.android.livesdk.chatroom.o r13 = IRoomContextService.a.a(r10, null, 0, 3);
        if (r13 == null) goto L42;
        com.bytedance.live.datacontext.m r14 = r13.getRoom();
        if (r14 == null) goto L42;
        IRoom r16 = (IRoom) r14.getValue();
    L44:
        if (PublicScreenABHelper.b(r16) == false) goto L56;
        CommentFlowContext r17 = r15.S();
        if (r17 == null) goto L51;
        CommentInputConfig r18 = r17.d;
        if (r18 == null) goto L51;
        CommentInputConfig.State r19 = r18.x;
    L52:
        if (r19 != r6) goto L55;
    L57:
        boolean r20 = true;
    L58:
        com.bytedance.android.livesdk.interactivity.api.expression.a r21 = new com.bytedance.android.livesdk.interactivity.api.expression.a(r4, r7, r8, r20, r15.g0(), new y(this, r15, r0));
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r110 = r15.V();
        if (r110 == null) goto L63;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r111 = r110.g;
        if (r111 == null) goto L63;
        r11 = r111.r;
    L63:
        r21.a = r11;
        this.e = ((IExpressionService) jc1.k.n(IExpressionService.class)).createExpressionPanelV3(r0, r21);
        ViewGroup.LayoutParams r112 = new ViewGroup.LayoutParams(-1, r1);
        View r23 = this.e;
        if (r23 == null) goto L66;
        r23.setLayoutParams(r112);
    L66:
        this.d = true;
        goto L68
    L55:
        if (r19 != CommentInputConfig.State.ForeClose) goto L57;
    L51:
        r19 = null;
    L56:
        r20 = false;
    L42:
        r16 = null;
        goto L44
    L28:
        if (r5 != CommentInputConfig.State.ForeClose) goto L31;
        r7 = false;
        goto L35
    L31:
        if (r15.V() == null) goto L33;
        boolean r24 = true;
    L34:
        r7 = r24;
        goto L35
    L33:
        r24 = false;
    L23:
        r5 = null;
        goto L24
    L14:
        if (e5.n() == true) goto L16;
        r4 = true;
        goto L18
    L16:
        r4 = false;
    L68:
        return this.e;
    }
}
