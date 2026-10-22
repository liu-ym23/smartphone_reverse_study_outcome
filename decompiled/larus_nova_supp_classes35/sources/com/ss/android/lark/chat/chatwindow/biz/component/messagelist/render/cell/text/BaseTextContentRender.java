package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.text;

import android.graphics.drawable.Drawable;
import android.os.Trace;
import android.text.Layout;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.biz.im.api.message.params.o;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.TextLayoutRender;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.TextLayoutRenderExtKt;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2.TextLayoutRenderConfigs;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2.n;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.m0;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.n0;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.o0;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.p0;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.q0;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.r0;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.s0;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.text.TextClickListenerProviderV2;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.text.TextClickListenerProviderV2$getDoubleClickListener$1;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.ChatDisplayModeSetting;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.chatbase.view.TextChatView2;
import com.ss.android.lark.chatwindow.view.widget.TouchInterceptionLayout;
import com.ss.android.lark.coremd.facade.bizext.IMContextExtend;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.widget.EllipsizeFrameLayout;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import g3b.u;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.internal.Intrinsics;
import w4b.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class BaseTextContentRender {
    public final m2b.a a;
    public final y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> b;
    public final c c;
    public final b d;
    public final b3b.a e;
    public final TouchInterceptionLayout f;
    public final Lazy g;
    public final z2b.b h;

    @Target({ElementType.TYPE, ElementType.TYPE_USE})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/biz/component/messagelist/render/cell/text/BaseTextContentRender$RenderType;", BuildConfig.FLAVOR, "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.TYPE})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface RenderType {
        public static final a Companion = null;
        public static final int TEXT = 0;
        public static final int TEXT_WITH_TRANSLATION = 2;
        public static final int TRANSLATION = 1;

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
        }
    }

    public static final class a {
    }

    public interface b {
        TextClickListenerProviderV2$getDoubleClickListener$1 a(y6b.a r1, boolean r2, TextChatView2 r3);

        com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.text.a b(y6b.a r1);

        com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.text.b c(y6b.a r1, boolean r2, TextChatView2 r3);
    }

    public interface c {
        r0 a(y6b.a r1);

        q0 b(y6b.a r1);

        p0 c(y6b.a r1);

        n0 d(y6b.a r1);

        o0 e(y6b.a r1);

        m0 f(y6b.a r1);

        s0 g(y6b.a r1);
    }

    public static final class d {
    }

    static {
    }

    public abstract com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b f();

    public abstract boolean h();

    public abstract TextChatView2 i();

    public abstract Layout j(m2b.a r1);

    public final void a() {
        int r0 = TextLayoutRender.j;
        if (TextLayoutRender.c.a() == false) goto L7;
        n r1 = e();
        r1.a(r1.f.b(com.ss.android.lark.coremd.base.parse.c.a(IMContextExtend.A, BaseTextContentRender$asyncParseImpl$1.INSTANCE)));
        y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> r3 = this.b;
        Intrinsics.checkNotNullParameter(r3, "item");
        Intrinsics.checkNotNullParameter(r1, "config");
        if (c() == false) goto L11;
        Log.d("TextMessageCell2", "enableAsyncParseLayoutV2: start");
        int r2 = com.ss.android.lark.chat.chatwindow.chat.model.preload.a.a;
        com.ss.android.lark.chat.chatwindow.chat.model.preload.a.b(this.a.I8(), h(), r3, r1, this.e);
        return;
    L11:
        return;
    L7:
        y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> r4 = this.b;
        com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r5 = f();
        r5.m = true;
        Intrinsics.checkNotNullParameter(r4, "item");
        Intrinsics.checkNotNullParameter(r5, "processParams");
        if (c() == false) goto L13;
        Log.d("TextMessageCell2", "enableAsyncParseLayout: start");
        int r6 = com.ss.android.lark.chat.chatwindow.chat.model.preload.a.a;
        com.ss.android.lark.chat.chatwindow.chat.model.preload.a.a(this.a.I8(), r4, r5, this.e);
        return;
    }

    public final com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b b() {
        com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r0 = new com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b();
        if (this.a.m() == false) goto L5;
        r0.x = 19;
    L5:
        r0.p = this.b.getId();
        y6b.b r1 = this.b.a();
        if (r1 == null) goto L8;
        String r2 = r1.w;
    L9:
        r0.q = r2;
        if (this.a.Y() == false) goto L19;
        y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> r3 = this.b;
        if ((r3 instanceof y6b.c) == true) goto L14;
    L16:
        int r4 = 23;
    L17:
        r0.x = r4;
        goto L19
    L14:
        if (((y6b.c) r3).Y() == false) goto L16;
        r4 = 22;
    L19:
        if (this.a.getChat() == null) goto L23;
        Chat r5 = this.a.getChat();
        Intrinsics.checkNotNull(r5);
        String r6 = r5.getAnonymousId();
        if (r6 == null) goto L23;
        r0.l = r6;
    L23:
        boolean r7 = false;
        if (c() == false) goto L27;
        r0.m = false;
    L27:
        if (this.a.e0() == false) goto L29;
        r0.Z = true;
    L29:
        ValidateIMFileResult r8 = this.b.N();
        if (r8 == null) goto L32;
        IMFileResult r9 = r8.getResultType();
    L33:
        MessagePermissionUtil.ReceiveAuthorizationState r10 = MessagePermissionUtil.h(r9);
        ValidateResult r11 = MessagePermissionUtil.b();
        r0.h = this.a.h();
        r0.a(r11);
        r0.o = MessagePermissionUtil.f(this.b, this.a.getChat(), null);
        Intrinsics.checkNotNullParameter(r10, "receiveAuthorizationState");
        r0.B = r10;
        r0.C = this.b.N();
        com.ss.android.lark.biz.im.api.message.params.e r12 = this.a.d0(com.ss.android.lark.biz.im.api.message.params.e.class);
        if (r12 == null) goto L42;
        o r13 = r12.b;
        if (r13 == null) goto L42;
        if (this.b.h() == false) goto L40;
        int r14 = r13.a;
    L41:
        r0.t = Integer.valueOf(r14);
        goto L42
    L40:
        r14 = r13.b;
    L42:
        u r15 = (u) this.a.d0(u.class);
        if (r15 != null) goto L45;
    L48:
        boolean r16 = true;
    L49:
        r0.D = r16;
        if (r15 != null) goto L52;
    L54:
        r0.O = r7;
        r0.b0 = this.a.h();
        r0.c0 = this.a.X();
        r0.d0 = this.a.o();
        r0.e0 = this.a.isAIChat();
        r0.f0 = this.a.B8();
        return r0;
    L52:
        if (r15.c.a == false) goto L54;
        r7 = true;
        goto L54
    L45:
        if (r15.a.a == true) goto L48;
        r16 = false;
        goto L49
    L32:
        r9 = null;
        goto L33
    L8:
        r2 = null;
        goto L9
    }

    public final boolean c() {
        int r0 = com.ss.android.lark.chat.chatwindow.chat.model.preload.a.a;
        y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> r1 = this.b;
        Intrinsics.checkNotNullParameter(r1, "messageVO");
        if (r1.r() < 1000) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L8;
    L18:
        return false;
    L8:
        if (this.a.m() == true) goto L18;
        if (this.a.e0() == true) goto L18;
        if (this.a.r() == true) goto L18;
        if (this.a.q() == true) goto L18;
        if (this.a.Y() == true) goto L18;
        return true;
    L5:
        r2 = false;
        goto L6
    }

    public final n e() {
        com.ss.android.lark.biz.im.api.message.params.e r0 = this.a.d0(com.ss.android.lark.biz.im.api.message.params.e.class);
        if (r0 == null) goto L5;
        List r1 = r0.a;
    L7:
        return TextLayoutRenderConfigs.b(this.a, this.b, h(), null, r1);
    L5:
        r1 = null;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.view.ViewGroup, com.ss.android.lark.chatbase.view.TextChatView2] */
    public final void g() {
        Trace.beginSection("generate_text_content");
        Layout r0 = j(this.a);
        Trace.endSection();
        ?? r1 = i();
        m2b.a r2 = this.a;
        y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> r3 = this.b;
        if (r3.K() != Message.Status.DELETED) goto L5;
    L10:
        r1.setTextColor(v2c.a.b(r2.getContext(), 2131106620));
    L11:
        m2b.a r4 = this.a;
        y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> r5 = this.b;
        Trace.beginSection("setupContent");
        q0 r6 = this.c.b(this.b);
        if (r6 == null) goto L14;
        r1.setPhoneSpanClickListener(r6);
    L14:
        s0 r7 = this.c.g(this.b);
        if (r7 == null) goto L17;
        r1.setUrlSpanClickListener(r7);
    L17:
        n0 r8 = this.c.d(this.b);
        if (r8 == null) goto L20;
        r1.setAtSpanClickListener(r8);
    L20:
        p0 r9 = this.c.c(this.b);
        if (r9 == null) goto L23;
        r1.setMentionSpanClickListener(r9);
    L23:
        m0 r10 = this.c.f(this.b);
        if (r10 == null) goto L26;
        r1.setAbbreviationClickListener(r10);
    L26:
        r0 r11 = this.c.a(this.b);
        if (r11 == null) goto L29;
        r1.setOnShoreMoreClickListener(r11);
    L29:
        o0 r12 = this.c.e(this.b);
        if (r12 == null) goto L32;
        r1.setAtUserGroupSpanClickListener(r12);
    L32:
        u r13 = (u) r4.d0(u.class);
        r1.getLightTextView().setOnClickListener(new com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.text.b(r13, r1, this));
        r1.getLightTextView().setOnLongClickListener(new com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.text.c(r13, this, r1));
        TouchInterceptionLayout r14 = this.f;
        if (r14 == null) goto L35;
        r14.setDoubleClickListener(new com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.text.a(this));
    L35:
        com.ss.android.lark.chat.base.view.vo.message.e r15 = r5.b();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.chat.vo.ChatMessageVO<com.ss.android.lark.chat.base.view.vo.message.TextContentVO>");
        y6b.c r16 = (y6b.c) r5;
        u r17 = (u) r4.d0(u.class);
        boolean r18 = r15.q;
        EllipsizeFrameLayout.a r19 = r15.s;
        if (r4.Y() == false) goto L38;
    L41:
        Drawable r20 = v2c.a.c(r1.getContext(), 2131247396);
    L43:
        if (r16.S1 == Message.ThreadMessageType.THREAD_ROOT_MESSAGE) goto L45;
    L49:
        if (r17 != null) goto L51;
    L53:
        if (r17 == null) goto L55;
        CharSequence r21 = r17.h;
    L56:
        r1.setShowMoreTextOverride(r21);
        if (r17 == null) goto L61;
        g3b.f r22 = r17.b;
        if (r22.a == false) goto L61;
        r18 = r22.b;
        r19 = r22.c;
        r20 = v2c.a.c(r1.getContext(), 2131247396);
    L61:
        r1.R5(r0, r20, r18, r19);
        Trace.endSection();
        return;
    L55:
        r21 = null;
        goto L56
    L51:
        if (r17.g == false) goto L53;
        r20 = p3b.a.c(r1.getContext(), r16.i);
        goto L53
    L45:
        if (ChatCoreModule.a().getFeatureGatingDependency().isEnable("im.message.thread_reply_bubble_optimize") == false) goto L49;
        if (r16.b2 == ChatDisplayModeSetting.THREAD) goto L49;
        r20 = p3b.a.c(r1.getContext(), r16.i);
        goto L49
    L38:
        if (r16.d() == true) goto L41;
        r20 = p3b.a.c(r1.getContext(), r16.i);
        goto L43
    L5:
        if (r3.U() == true) goto L7;
    L9:
        r1.setTextColor(v2c.a.b(r2.getContext(), 2131106622));
        goto L11
    L7:
        if (r3.V(((d0) this.g.getValue()).a()) == false) goto L9;
        goto L9
    }

    public final Layout d(y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> r3, com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r4) {
        Intrinsics.checkNotNullParameter(r3, "messageVO");
        Intrinsics.checkNotNullParameter(r4, "processParams");
        Trace.beginSection("generate_text_content");
        Layout r5 = TextLayoutRenderExtKt.d(this.h, r3, r4, this.a.getContext());
        Trace.endSection();
        return r5;
    }

    public BaseTextContentRender(m2b.a r2, y6b.a r3, c r4, TextClickListenerProviderV2 r5, b3b.f r6, TouchInterceptionLayout r7) {
        Intrinsics.checkNotNullParameter(r2, "chatContext");
        Intrinsics.checkNotNullParameter(r3, Keys.API_RETURN_KEY_DATA);
        Intrinsics.checkNotNullParameter(r4, "spanClickListener");
        Intrinsics.checkNotNullParameter(r6, "cellCallback");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, BaseTextContentRender$mNtpService$2.INSTANCE);
        z2b.b r8 = r2.I8();
        if (r8 != null) goto L5;
        int r9 = TextLayoutRender.j;
        r8 = w2b.b.d;
    L5:
        this.h = r8;
    }
}
