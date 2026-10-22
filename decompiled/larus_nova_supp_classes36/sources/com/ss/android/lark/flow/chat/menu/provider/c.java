package com.ss.android.lark.flow.chat.menu.provider;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.supervisor.token.Token;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.ss.android.lark.auditsdk.v2.AuthorizationServiceV2;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.biz.officesdk.im.message.menu.IDoubaoTextSelectService;
import com.ss.android.lark.chat.chatwindow.chat.menu.handler.u;
import com.ss.android.lark.chat.chatwindow.chat.menu.handler.v;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.message.menu.provider.ChatCopyActionProvider;
import com.ss.android.lark.chat.utils.y0;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.utils.LarkContext;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c extends ChatCopyActionProvider {

    public static final class a implements yya.i {
        public final yya.i a;
        public final yya.a b;

        public final boolean c() {
            return false;
        }

        public final Integer e() {
            return null;
        }

        public final boolean f() {
            return false;
        }

        public final s5c.d g() {
            return null;
        }

        public final boolean isEnable() {
            return true;
        }

        public final void onHide() {
        }

        public final void onShow() {
        }

        public final Map<String, Object> R4() {
            return this.a.R4();
        }

        public final boolean isVisible() {
            return this.a.isVisible();
        }

        public MessageActionType getType() {
            return MessageActionType.COPY;
        }

        public final void d(com.ss.android.lark.chat.message.menu.c r2) {
            Intrinsics.checkNotNullParameter(r2, "actionControl");
        }

        public final Drawable getIcon(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            return UDIconUtils.getIconDrawable(r3, 2131235458, UDColorUtils.getColor(r3, 2131100799));
        }

        public final String getLabel(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return this.a.getLabel(r2);
        }

        public final View getView(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return null;
        }

        public a(ChatCopyActionProvider.b r2, yya.a r3) {
            Intrinsics.checkNotNullParameter(r2, "superAction");
            Intrinsics.checkNotNullParameter(r3, "actionContext");
            this.a = r2;
            this.b = r3;
        }

        public final void b(View r12, boolean r13) {
            Intrinsics.checkNotNullParameter(r12, "view");
            if (r13 == true) goto L5;
            return;
        L5:
            Message.Type r0 = this.b.l();
            if (y0.a(this.b.getChat()) == true) goto L8;
            y0.f(this.b.getContext());
        L11:
            boolean r1 = false;
        L13:
            if (r1 == true) goto L16;
            return;
        L16:
            if (r0 != Message.Type.DOUBAO) goto L32;
            IDoubaoTextSelectService r14 = OfficeSDKManager.getHostUserService(((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).d(), IDoubaoTextSelectService.class);
            y6b.a r15 = this.b.m();
            CharSequence r2 = null;
            if ((r15 instanceof y6b.a) == false) goto L20;
            y6b.a r16 = r15;
        L21:
            if (r16 == null) goto L29;
            yya.a r3 = this.b;
            if (r3.c == false) goto L26;
            if (r14 == null) goto L29;
            CharSequence r17 = r14.O0(r16, r3.a);
        L28:
            r2 = r17;
            goto L29
        L26:
            if (r14 == null) goto L29;
            r17 = r14.G1(r16, r3.a);
        L29:
            if (r2 == null) goto L34;
            Context r18 = this.b.getContext();
            b7b.b.a(r18, r2, new Token("LARK-PSDA-messenger-android-copy-textmessage"), new u(new v(r18)));
            return;
        L34:
            return;
        L20:
            r16 = null;
            goto L21
        L32:
            this.a.b(r12, r13);
            return;
        L8:
            w4b.a r4 = ChatCoreModule.a().getAuditDependency();
            ValidateResult r5 = r4.d();
            r4.a(r5, AuthorizationServiceV2.AuthorizationType.PREVIEW_AUTHORIZATION);
            if (r4.isAuthorizationPassed(r5) == true) goto L12;
            AuthorizationServiceV2 r6 = r4.g();
            Context r7 = this.b.getContext();
            Intrinsics.checkNotNull(r5);
            com.ss.android.lark.auditsdk.v2.d.a.a(r6, r7, r5, null, null, 2131892718, r4.g().e(), null, 412);
            goto L11
        L12:
            r1 = r4.g().h();
            goto L13
        }
    }

    public final List<PageType> b() {
        return CollectionsKt.plus((List) ((ChatCopyActionProvider) this).a.getValue(), PageType.THREAD_WINDOW);
    }

    public c() {
        ((ChatCopyActionProvider) this).b.add(Message.Type.DOUBAO);
    }

    public final yya.i c(yya.a r3) {
        Intrinsics.checkNotNullParameter(r3, "actionContext");
        Intrinsics.checkNotNullParameter(r3, "actionContext");
        return new a(new ChatCopyActionProvider.b(this, r3), r3);
    }
}
