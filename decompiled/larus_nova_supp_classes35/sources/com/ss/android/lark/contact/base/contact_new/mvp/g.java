package com.ss.android.lark.contact.base.contact_new.mvp;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.im.v1.UpdateChatApplicationMeReadRequest;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.mvp.BaseModel;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.v1.space.DocTabPayload;
import com.ss.android.lark.contact.base.dto.ChatApplication;
import com.ss.android.lark.contact.base.service.n;
import com.ss.android.lark.contact.base.service.q;
import com.ss.android.lark.contact.base.utils.InvApmUtils;
import com.ss.android.lark.sdk.SdkSender;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g extends BaseModel implements com.ss.android.lark.contact.base.contact_new.mvp.a {
    public boolean a;
    public String b;
    public final List<ChatApplication> c;
    public com.ss.android.lark.contact.base.contact_new.mvp.a.InterfaceC0166a d;
    public final a e;

    public class a implements f9b.a {
        public final /* synthetic */ g a;

        public a(g r1) {
            this.a = r1;
        }

        @Override // f9b.a
        public final void a(List<ChatApplication> r2) {
            if (CollectionUtils.isEmpty(r2) == false) goto L5;
            return;
        L5:
            com.ss.android.lark.contact.base.contact_new.mvp.a.InterfaceC0166a r0 = this.a.d;
            if (r0 == null) goto L9;
            r0.a(r2);
            return;
        }
    }

    @Override // com.ss.android.lark.contact.base.contact_new.mvp.a
    public final void L4() {
        int r0 = com.ss.android.lark.contact.base.service.d.a;
        UpdateChatApplicationMeReadRequest.Builder r1 = new UpdateChatApplicationMeReadRequest.Builder().read_all_applications(Boolean.TRUE);
        SdkSender.asynSendRequestNonWrap(Command.UPDATE_CHAT_APPLICATION_ME_READ, r1, null, new com.ss.android.lark.contact.base.service.j());
    }

    public g() {
        this.a = true;
        this.b = DocTabPayload.DocType.UNKNOWN;
        this.c = new ArrayList();
        this.e = new a(this);
    }

    public final void create() {
        super.create();
        q r0 = q.a.a;
        a r1 = this.e;
        com.ss.android.lark.sdk.f.a(r0.a, r1, new n(r0));
    }

    public final void destroy() {
        super.destroy();
        q r0 = q.a.a;
        a r1 = this.e;
        List<f9b.a> r2 = r0.a;
        if (r1 == null) goto L19;
        monitor-enter(r2);
        CopyOnWriteArrayList r3 = (CopyOnWriteArrayList) r2;     // Catch: Throwable -> L21
        r3.remove(r1);     // Catch: Throwable -> L21
        monitor-exit(r2);     // Catch: Throwable -> L21
        if (r3.isEmpty() == false) goto L19;
        monitor-enter(r2);
    L16:
        th = move-exception;
        throw th;
    L12:
        if (r3.isEmpty() == false) goto L14;
        com.ss.android.lark.sdk.g.e.a.c(Command.PUSH_CHAT_APPLICATIONS);     // Catch: Throwable -> L16
    L14:
        monitor-exit(r2);     // Catch: Throwable -> L16
    L21:
        th = move-exception;
        throw th;
    L19:
        this.d = null;
    }

    @Override // com.ss.android.lark.contact.base.contact_new.mvp.a
    public final boolean isHasMore() {
        return this.a;
    }

    @Override // com.ss.android.lark.contact.base.contact_new.mvp.a
    public final String x1() {
        return this.b;
    }

    @Override // com.ss.android.lark.contact.base.contact_new.mvp.a
    public final void X1(NewContactPresenter.a r1) {
        this.d = r1;
    }

    @Override // com.ss.android.lark.contact.base.contact_new.mvp.a
    public final void e4(final UIGetDataCallback r4) {
        InvApmUtils.g("contact_opt_contact_applications_fetch_timing_ms");
        int r0 = com.ss.android.lark.contact.base.service.d.a;
        com.ss.android.lark.contact.base.service.d.c(this.b, false, false, getCallbackManager().wrapAndAddCallback(new NewContactModel$2(this, r4)));
    }

    @Override // com.ss.android.lark.contact.base.contact_new.mvp.a
    public final void a4(final String r3, final UIGetDataCallback r4) {
        int r0 = com.ss.android.lark.contact.base.service.d.a;
        IGetDataCallback r5 = getCallbackManager().wrapAndAddCallback(new NewContactModel$3(this, r3, r4));
        com.ss.android.lark.contact.base.service.d.d(r3, ChatApplication.Status.DELETED, Boolean.FALSE, r5);
    }
}
