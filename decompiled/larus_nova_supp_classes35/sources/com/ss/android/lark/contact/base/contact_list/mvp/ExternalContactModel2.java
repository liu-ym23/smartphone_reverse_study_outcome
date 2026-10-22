package com.ss.android.lark.contact.base.contact_list.mvp;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.contact.v1.PushFocusChatter;
import com.bytedance.lark.pb.contact.v2.GetExternalContactListRequest;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.mvp.BaseModel;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.chat.entity.chatter.ChatterDescription;
import com.ss.android.lark.contact.base.contact_focus.SpecialFocusPush;
import com.ss.android.lark.contact.base.service.ContactBaseService$getPartialExternalContacts$innerCallback$1;
import com.ss.android.lark.contact.base.service.a0;
import com.ss.android.lark.contact.base.service.q;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.sdk.SdkSender;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ExternalContactModel2 extends BaseModel implements l {
    public l.a a;
    public final a b;
    public final IGetDataCallback<PushFocusChatter> c;

    public class a implements q.c {
        public final /* synthetic */ ExternalContactModel2 a;

        @Override // com.ss.android.lark.contact.base.service.q.b
        public final void a() {
        }

        public a(ExternalContactModel2 r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.contact.base.service.q.c
        public final void b(com.ss.android.lark.contact.base.entity.a r3) {
            if (r3 != null) goto L4;
            return;
        L4:
            l.a r0 = this.a.a;
            if (r0 == null) goto L10;
            w8b.a r4 = ExternalContactModel2.h(r3);
            if (r4 == null) goto L11;
            UICallbackExecutor.execute(new com.ss.android.lark.contact.base.contact_list.mvp.a((ExternalContactPresenter2.b) r0, r4));
            return;
        L11:
            return;
        }
    }

    public ExternalContactModel2() {
        this.b = new a(this);
        this.c = new AnonymousClass2(this);
    }

    public final void create() {
        super.create();
        final q r0 = q.a.a;
        a r1 = this.b;
        List<q.b> r2 = r0.b;
        if (r1 == null) goto L17;
        CopyOnWriteArrayList r3 = (CopyOnWriteArrayList) r2;
        if (r3.isEmpty() == false) goto L16;
        monitor-enter(r3);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (r3.isEmpty() == false) goto L11;
        com.ss.android.lark.sdk.g.e.a.b(Command.PUSH_CONTACT, new com.ss.android.lark.contact.base.service.m(r0));     // Catch: Throwable -> L13
    L11:
        monitor-exit(r3);     // Catch: Throwable -> L13
    L16:
        r3.add(r1);
    L17:
        SpecialFocusPush r4 = (SpecialFocusPush) SpecialFocusPush.b.getValue();
        IGetDataCallback<PushFocusChatter> r5 = this.c;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "listener");
        CopyOnWriteArrayList<IGetDataCallback<PushFocusChatter>> r6 = r4.a;
        if (r5 != null) goto L21;
        return;
    L21:
        if (r6.isEmpty() == false) goto L31;
        monitor-enter(r6);
    L28:
        th = move-exception;
        throw th;
    L24:
        if (r6.isEmpty() == false) goto L26;
        com.ss.android.lark.sdk.g.e.a.b(Command.PUSH_FOCUS_CHATTER, new com.ss.android.lark.contact.base.contact_focus.c(r4));     // Catch: Throwable -> L28
    L26:
        monitor-exit(r6);     // Catch: Throwable -> L28
    L31:
        r6.add(r5);
    }

    public final void destroy() {
        super.destroy();
        q r0 = q.a.a;
        a r1 = this.b;
        List<q.b> r2 = r0.b;
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
        com.ss.android.lark.sdk.g.e.a.c(Command.PUSH_CONTACT);     // Catch: Throwable -> L16
    L14:
        monitor-exit(r2);     // Catch: Throwable -> L16
    L21:
        th = move-exception;
        throw th;
    L19:
        SpecialFocusPush r4 = (SpecialFocusPush) SpecialFocusPush.b.getValue();
        IGetDataCallback<PushFocusChatter> r5 = this.c;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "listener");
        com.ss.android.lark.sdk.f.b(r4.a, r5, com.ss.android.lark.contact.base.contact_focus.d.a);
        this.a = null;
    }

    public static w8b.a h(com.ss.android.lark.contact.base.entity.a r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        com.ss.android.lark.contact.base.entity.c r1 = r5.a;
        if (r1 != null) goto L8;
        return null;
    L8:
        w8b.a r0 = new w8b.a();
        r0.d = r1.a;
        r0.a = r1.b;
        r0.b = r1.c;
        r0.c = r1.d;
        r0.g = r1.l;
        r0.n = r1.m;
        r0.h = new ChatterDescription(r1.h, ChatterDescription.Type.DEFAULT);
        r0.f = r1.f;
        r0.e = r1.e;
        r0.i = r1.g;
        r0.j = Long.valueOf(r1.i);
        if (r5.b != 2) goto L11;
        boolean r6 = true;
    L12:
        r0.k = r6;
        r0.l = r1.j;
        r0.m = r1.k;
        return r0;
    L11:
        r6 = false;
        goto L12
    }

    @Override // com.ss.android.lark.contact.base.contact_list.mvp.l
    public final void X3(String r2, UIGetDataCallback r3) {
        ImSdkService.d().pd(r2, r3);
    }

    @Override // com.ss.android.lark.contact.base.contact_list.mvp.l
    public final void b1(Boolean r4, final UIGetDataCallback r5) {
        a0.a r0 = a0.d;
        Event r1 = Event.contact_opt_external_fetch;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "event");
        r0.c(r1, true);
        IGetDataCallback<com.ss.android.lark.contact.base.entity.b> r2 = new AnonymousClass4(this, r5);
        int r6 = com.ss.android.lark.contact.base.service.d.a;
        boolean r7 = r4.booleanValue();
        final UIGetDataCallback r8 = getCallbackManager().wrapAndAddGetDataCallback(r2);
        GetExternalContactListRequest.Builder r3 = new GetExternalContactListRequest.Builder();
        if (r7 == false) goto L5;
        r3.strategy(SyncDataStrategy.LOCAL);
    L6:
        r3.offset(0L);
        r3.limit(15000L);
        SdkSender.IParser r9 = com.ss.android.lark.contact.base.service.e.a;
        IGetDataCallback<com.ss.android.lark.contact.base.entity.b> r10 = new ContactBaseService$getPartialExternalContacts$innerCallback$1(r8);
        SdkSender.asynSendRequestNonWrap(Command.GET_EXTERNAL_CONTACT_LIST, r3, r10, r9);
        return;
    L5:
        r3.strategy(SyncDataStrategy.FORCE_SERVER);
        goto L6
    }

    @Override // com.ss.android.lark.contact.base.contact_list.mvp.l
    public final void z4(String r4, final UIGetDataCallback r5) {
        a0.a r0 = a0.d;
        Event r1 = Event.contact_opt_external_delete;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "event");
        r0.c(r1, true);
        IGetDataCallback<Boolean> r2 = new AnonymousClass3(this, r5);
        int r6 = com.ss.android.lark.contact.base.service.d.a;
        IGetDataCallback r7 = getCallbackManager().wrapAndAddCallback(r2);
        Intrinsics.checkNotNullParameter(r4, "userId");
        Intrinsics.checkNotNullParameter(r7, "callback");
        ImSdkService.d().N7(r4, r7);
    }
}
