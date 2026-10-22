package com.larus.bmhome.chat.helper;

import android.app.Application;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.chat.model.repo.ConversationRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.y0;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class u implements y0 {
    public final /* synthetic */ wc9.e a;
    public final /* synthetic */ CocoSubConversationSettingMenuTrigger b;

    public static final class a implements IIMCallback<Boolean> {
        public a() {
        }

        public final boolean mustInMain() {
            return true;
        }

        public final void onFailure(IIMError r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            Intrinsics.checkNotNullParameter(r2, "error");
            int r3 = r2.getCode();
            if (r3 != 712014004) goto L5;
            t19.s r4 = t19.s.a;
            Application r0 = AppHost.a.getApplication();
            r4.getClass();
            t19.s.s(r0, 2131906272);
            return;
        L5:
            if (r3 == 0) goto L9;
            t19.s r5 = t19.s.a;
            Application r1 = AppHost.a.getApplication();
            r5.getClass();
            t19.s.s(r1, 2131905463);
            return;
        }

        public final void onSuccess(Object r2) {
            if (((Boolean) r2).booleanValue() == false) goto L5;
            byte r3 = 0;
        L7:
            if (r3 != 712014004) goto L9;
            t19.s r4 = t19.s.a;
            Application r0 = AppHost.a.getApplication();
            r4.getClass();
            t19.s.s(r0, 2131906272);
            return;
        L9:
            if (r3 == 0) goto L13;
            t19.s r5 = t19.s.a;
            Application r1 = AppHost.a.getApplication();
            r5.getClass();
            t19.s.s(r1, 2131905463);
            return;
        L13:
            return;
        L5:
            r3 = -1;
            goto L7
        }
    }

    public final void a(String r4) {
        Intrinsics.checkNotNullParameter(r4, ChatDraftItem.TYPE_TEXT);
        RepoDispatcher.a.getClass();
        ConversationRepo r0 = RepoDispatcher.f;
        String r1 = this.a.a;
        a r2 = new a();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "conversationId");
        Intrinsics.checkNotNullParameter(r4, "name");
        com.larus.im.d.d().updateConversationTitle(r1, r4, r2);
        int r5 = com.larus.bmhome.chat.trace.i0.a;
        CocoSubConversationSettingMenuTrigger r6 = this.b;
        JSONObject r7 = CocoSubConversationSettingMenuTrigger.c(this.a, r6.f);
        by7.e r3 = this.b.d;
        if ((r3 instanceof by7.e) == true) goto L6;
        r3 = null;
    L6:
        Intrinsics.checkNotNullParameter(r7, "params");
        com.larus.bmhome.chat.trace.i0.a("edit_chat_name", r7, r3);
    }

    public u(wc9.e r1, CocoSubConversationSettingMenuTrigger r2) {
        this.a = r1;
        this.b = r2;
    }
}
