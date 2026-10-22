package com.ss.android.lark.flow.chat.multi_select;

import android.content.Context;
import com.larksuite.framework.utils.ICUUtils;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.biz.im.api.extension.message.MultiSelectContext;
import com.ss.android.lark.biz.im.api.extension.message.i;
import com.ss.android.lark.biz.im.api.extension.message.k;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.utils.y0;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.ss.android.lark.flow.chat.FlowChatModule;
import com.ss.android.lark.flow.chat.page.flow.plugin.select.f;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements k {

    public static final class a {
    }

    public final class b implements i {
        public final MultiSelectContext a;
        public final Lazy b;

        public final int getId() {
            return 20;
        }

        public final void onClick() {
            Chat r0 = this.a.getChat();
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.chat.Chat");
            if (y0.c(r0) == true) goto L6;
            y0.g(this.a.getContext());
            return;
        L6:
            Map r1 = this.a.d();
            boolean r3 = false;
            if (r1.isEmpty() == true) goto L18;
            Iterator r2 = r1.entrySet().iterator();
        L11:
            if (r2.hasNext() == false) goto L18;
            Message.Type r4 = (Message.Type) ((Map.Entry) r2.next()).getValue();
            if (Message.Type.DOUBAO != r4) goto L15;
            boolean r5 = true;
        L16:
            if (r5 == false) goto L11;
            boolean r6 = true;
        L19:
            if (r6 == false) goto L22;
            ICUUtils.FormatArgsBuilder r7 = new ICUUtils.FormatArgsBuilder();
            r7.b("brandName", (String) this.b.getValue());
            List r8 = r7.a;
            String r9 = ICUUtils.icuFormat(UIHelper.getString(2131890163), r8);
            Context r10 = this.a.getContext();
            Intrinsics.checkNotNull(r9);
            FlowToast.d(r10, r9);
            return;
        L22:
            List r11 = this.a.e();
            r11.size();
            Map r12 = this.a.d();
            if (r12.isEmpty() == true) goto L34;
            Iterator r13 = r12.entrySet().iterator();
        L27:
            if (r13.hasNext() == false) goto L34;
            Message.Type r14 = (Message.Type) ((Map.Entry) r13.next()).getValue();
            if (Message.Type.AUDIO != r14) goto L31;
            boolean r15 = true;
        L32:
            if (r15 == false) goto L27;
            r3 = true;
            goto L34
        L31:
            r15 = false;
        L34:
            if (r3 == false) goto L36;
            FlowToast.c(this.a.getContext(), 2131890957);
        L36:
            this.a.a();
            ArrayList r16 = new ArrayList();
            r16.addAll(r11);
            int r17 = FlowChatModule.d;
            FlowChatModule.a.a().a().getForwardDependency().b(this.a.getContext(), r0, r16, new ContentListenerImpl());
            return;
        L15:
            r5 = false;
        L18:
            r6 = false;
            goto L19
        }

        public b(f r1, BaseFragment r2) {
            Intrinsics.checkNotNullParameter(r1, "multiSelectContext");
            this.a = r1;
            this.b = LazyKt.lazy(OneByOneForwardMultiSelectProvider$OneByOneForwardMultiSelectAction$brandName$2.INSTANCE);
        }
    }

    static {
    }

    public d() {
    }

    public final boolean b(f r2) {
        Intrinsics.checkNotNullParameter(r2, "multiSelectContext");
        return true;
    }

    public final Collection<MultiSelectContext.Page> c() {
        return CollectionsKt.listOf(MultiSelectContext.Page.CHAT_WINDOW);
    }

    public final i a(f r2, BaseFragment r3) {
        Intrinsics.checkNotNullParameter(r2, "multiSelectContext");
        return new b(r2, r3);
    }
}
