package com.ss.android.lark.flow.chat.multi_select;

import android.text.TextUtils;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.utils.f0;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.biz.im.api.ChatterNameDisplayRule;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.biz.im.api.extension.message.MultiSelectContext;
import com.ss.android.lark.biz.im.api.extension.message.i;
import com.ss.android.lark.biz.im.api.extension.message.k;
import com.ss.android.lark.biz.im.api.h;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.chat.utils.m;
import com.ss.android.lark.flow.chat.page.flow.plugin.select.f;
import com.ss.android.lark.flow.forward.ForwardTools;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.im.sdk.service.p;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class AskDoubaoMultiSelectProvider implements k {

    public final class AskDoubaoMultiSelectAction implements i {
        public final MultiSelectContext a;
        public final Lazy b;

        public final int getId() {
            return 80;
        }

        public final void onClick() {
            final List<String> r0 = this.a.e();
            Log.i("AskDoubaoMultiSelect", "askDoubao select msg: " + f0.d(r0));
            IGetDataCallback<Message> r1 = new AskDoubaoMultiSelectProvider$AskDoubaoMultiSelectAction$onClick$callback$1(this, r0);
            p r2 = ImSdkService.f();
            IIMApi r3 = (IIMApi) ApiUtils.getApi(IIMApi.class);
            Chat r4 = this.a.getChat();
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.chat.Chat");
            MergeForwardContent r5 = new MergeForwardContent();
            r5.setType(r4.getType());
            if (r4.getType() != Chat.Type.P2P) goto L9;
            Chatter r6 = ImSdkService.d().zb();
            ChatterNameDisplayRule r7 = ChatterNameDisplayRule.ALIAS_NICKNAME_NAME;
            r5.setP2pCreatorName(m.b(r6, r7, false));
            if (TextUtils.equals(ChatCoreModule.a().getPassportDependency().userId(), r4.getP2pChatterId()) == false) goto L7;
            String r8 = "";
        L8:
            r5.setP2pPartnerName(r8);
        L10:
            r2.Jc(r3.getMergeForwardContentTitle(r5), r0, (IGetDataCallback) this.a.b().wrapAndAddCallback(new UIGetDataCallback(r1)));
            return;
        L7:
            r8 = ForwardTools.a(ImSdkService.d().l7(r4.getP2pChatterId()), r7);
            goto L8
        L9:
            r5.setGroupChatName(r4.getName());
            goto L10
        }

        public AskDoubaoMultiSelectAction(f r2) {
            Intrinsics.checkNotNullParameter(r2, "multiSelectContext");
            this.a = r2;
            this.b = LazyKt.lazy(AskDoubaoMultiSelectProvider$AskDoubaoMultiSelectAction$brandName$2.INSTANCE);
        }
    }

    public static final class a {
    }

    static {
    }

    public AskDoubaoMultiSelectProvider() {
    }

    public final Collection<MultiSelectContext.Page> c() {
        return CollectionsKt.listOf(MultiSelectContext.Page.CHAT_WINDOW);
    }

    public final boolean b(f r4) {
        Intrinsics.checkNotNullParameter(r4, "multiSelectContext");
        Chat r5 = r4.getChat();
        if ((r5 instanceof Chat) == true) goto L7;
        r5 = null;
    L7:
        if (r5 != null) goto L9;
        return false;
    L9:
        boolean r1 = ((com.ss.android.lark.passport.dpop.b) LarkContext.spiByDwarf(com.ss.android.lark.passport.dpop.b.class)).isDoubaoBUser();
        boolean r6 = r5.getDoubaoSetting().isDoubaoUsingEnabled();
        int r2 = h.a;
        if (r1 == true) goto L14;
        if (r6 == false) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    }

    public final i a(f r1, BaseFragment r2) {
        Intrinsics.checkNotNullParameter(r1, "multiSelectContext");
        return new AskDoubaoMultiSelectAction(r1);
    }
}
