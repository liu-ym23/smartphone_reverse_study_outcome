package com.ss.android.lark.im.sdk.usercontainer;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.OpenApp;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.contact.customized.externalcontact.repository.NewFriendBadgeRepository;
import com.ss.android.lark.contact.customized.externalcontact.view.OfficeExternalContactViewModel;
import com.ss.android.lark.im.sdk.service.h;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b extends c0c.b implements h {
    public final /* synthetic */ h b;
    public final v c;
    public final com.ss.android.lark.passportc.convention.b<h> d;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final Map<String, ChatChatter> A2(String r2, List<String> r3) {
        Intrinsics.checkNotNullParameter(r3, "chatterIds");
        return this.b.A2(r2, r3);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final void E9(String r2, List<String> r3, IGetDataCallback<Map<String, ChatChatter>> r4) {
        Intrinsics.checkNotNullParameter(r2, "chatId");
        Intrinsics.checkNotNullParameter(r3, "chatterIds");
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.b.E9(r2, r3, r4);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final void F5(Chatter r2) {
        this.b.F5(r2);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final ChatChatter H5(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "chatterId");
        return this.b.H5(r2, r3);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final ChatChatter He(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "chatterId");
        return this.b.He(r2, r3);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final Map I3(String r2, List r3) {
        Intrinsics.checkNotNullParameter(r3, "chatterIds");
        return this.b.I3(r2, r3);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final void L2(NewFriendBadgeRepository.getBadge.1 r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.b.L2(r2);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final void N7(String r2, IGetDataCallback<Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "contactUserId");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.b.N7(r2, r3);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final void W8(OfficeExternalContactViewModel.fetchSelfCardHeader.1 r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.b.W8(r2);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final Map<String, Chatter> a0(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "chatterIds");
        return this.b.a0(r2);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final void j1(String r2, IGetDataCallback<Chatter> r3) {
        Intrinsics.checkNotNullParameter(r2, "avatarKey");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.b.j1(r2, r3);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final Map<String, Chatter> l0(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "chatterIds");
        return this.b.l0(r2);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final Chatter l7(String r2) {
        Intrinsics.checkNotNullParameter(r2, "chatterId");
        return this.b.l7(r2);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final Map<String, ChatChatter> ld(String r2, List<String> r3) {
        Intrinsics.checkNotNullParameter(r3, "chatterIds");
        return this.b.ld(r2, r3);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final void pd(String r2, IGetDataCallback<Chatter> r3) {
        Intrinsics.checkNotNullParameter(r2, "chatterId");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.b.pd(r2, r3);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final Pair<ChatChatter, OpenApp> qb(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "botId");
        return this.b.qb(r2, r3);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final Chatter ue(String r2) {
        Intrinsics.checkNotNullParameter(r2, "chatterId");
        return this.b.ue(r2);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final void v3(List<String> r2, IGetDataCallback<Map<String, Chatter>> r3) {
        Intrinsics.checkNotNullParameter(r2, "chatterIds");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.b.v3(r2, r3);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final ChatChatter x1(String r2) {
        return this.b.x1(r2);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final Chatter zb() {
        return this.b.zb();
    }

    public b(j r4, v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<h> r0 = new com.ss.android.lark.passportc.convention.b(k.b(r5.c(r1), h.class), h.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "instanceHolder");
        super(r4);
        this.b = (h) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void qf(g r2, g r3) {
        Log.i("ImSdkChatterServiceProxy", "preparing");
        v r4 = this.c;
        if (r3 == null) goto L6;
        UserSession r5 = r3.b;
        if (r5 == null) goto L6;
    L7:
        h r6 = (h) k.b(r4.c(r5), h.class);
        this.d.e(r6);
        return;
    L6:
        r5 = ContainerConstsKt.a();
        goto L7
    }
}
