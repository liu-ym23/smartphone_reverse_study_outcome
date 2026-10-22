package com.larus.bmhome.view.actionbar.edit.component;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/component/UserMessageSenderWidget;", "Lcom/larus/bmhome/view/actionbar/edit/component/TextListSelectorWidget;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "parentItemClickCallback", "Lcom/larus/bmhome/view/actionbar/edit/component/TextSelectorHolderCallback;", "getParentItemClickCallback", "()Lcom/larus/bmhome/view/actionbar/edit/component/TextSelectorHolderCallback;", "setParentItemClickCallback", "(Lcom/larus/bmhome/view/actionbar/edit/component/TextSelectorHolderCallback;)V", "instructionInputAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "bindFragment", "", "fragment", "Landroidx/fragment/app/Fragment;", "handleUserSendMsg", "item", "Lcom/larus/bmhome/actionbar/model/SingleSelectorInstructionOption;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserMessageSenderWidget extends TextListSelectorWidget {
    public r2 m;
    public com.larus.bmhome.instruction.g n;
    public ICoreInputAbility o;

    public static final class a implements r2 {
        public final /* synthetic */ UserMessageSenderWidget a;

        public a(UserMessageSenderWidget r1) {
            this.a = r1;
        }

        @Override // com.larus.bmhome.view.actionbar.edit.component.r2
        public final void a(com.larus.bmhome.actionbar.model.y1 r22, int r23) {
            Intrinsics.checkNotNullParameter(r22, "item");
            r2 r2 = this.a.getParentItemClickCallback();
            if (r2 == null) goto L5;
            r2.a(r22, r23);
        L5:
            xe8.a r3 = this.a.getFragment();
            ChatPageContext r4 = null;
            if ((r3 instanceof xe8.a) == false) goto L8;
            xe8.a r5 = r3;
        L9:
            if (r5 == null) goto L11;
            r5.m8();
        L11:
            UserMessageSenderWidget r6 = this.a;
            r6.getClass();
            String r7 = r22.c;
            if (com.larus.utils.o0.d(r7) == false) goto L35;
            String r12 = UUID.randomUUID().toString();
            com.larus.bmhome.chat.api.s r1 = ILegacyChatUiServiceDelegate.b.t8();
            if (r1 == null) goto L16;
            r1.d(r12);
        L16:
            xe8.a r8 = r6.getFragment();
            if ((r8 instanceof xe8.a) == false) goto L19;
            xe8.a r9 = r8;
        L20:
            if (r9 == null) goto L35;
            String r10 = r9.getConversationId();
            if (r10 == null) goto L35;
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new UserMessageSenderWidget$handleUserSendMsg$1$1(r10, null), 3, null);
            FLogger.a.i(r6.getTAG(), "sendTextByUserMessageSenderComponent");
            if (r7 == null) goto L35;
            com.larus.bmhome.chat.model.repo.u1 r11 = zh8.a.a.getSender();
            com.larus.bmhome.instruction.g r13 = r6.n;
            if (r13 == null) goto L28;
            Map<String, String> r14 = r13.nK(null);
        L29:
            Fragment r15 = r6.getFragment();
            if (r15 == null) goto L34;
            t1a.b r16 = s1a.a.g(r15);
            if (r16 == null) goto L34;
            r4 = (ChatPageContext) r16.a(ChatPageContext.class);
        L34:
            com.larus.bmhome.chat.model.repo.u1.a.f(r11, r7, r10, "chat_action_bar", r14, null, null, r12, false, null, "UserMessageSenderWidget#handleUserSendMsg", null, r4, null, false, 27496);
            goto L35
        L28:
            r14 = null;
            goto L29
        L19:
            r9 = null;
        L35:
            com.larus.bmhome.instruction.g r17 = this.a.n;
            if (r17 == null) goto L38;
            r17.A1();
        L38:
            ICoreInputAbility r18 = this.a.o;
            if (r18 == null) goto L42;
            ICoreInputAbility.b.a(r18, 2);
            return;
        L42:
            return;
        L8:
            r5 = null;
            goto L9
        }
    }

    public final r2 getParentItemClickCallback() {
        return this.m;
    }

    public UserMessageSenderWidget(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        setTAG("UserMessageSenderWidget");
        this.m = getItemClickCallback();
        setItemClickCallback(new a(this));
    }

    @Override // com.larus.bmhome.instruction.base.AbsInstructionWidget
    public final void R5(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
        t1a.b r3 = s1a.a.g(r2);
        this.n = r3.getAbility(com.larus.bmhome.instruction.g.class);
        this.o = r3.getAbility(ICoreInputAbility.class);
    }

    public final void setParentItemClickCallback(r2 r1) {
        this.m = r1;
    }
}
