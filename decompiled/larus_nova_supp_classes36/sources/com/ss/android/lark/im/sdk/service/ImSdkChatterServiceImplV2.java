package com.ss.android.lark.im.sdk.service;

import android.os.Looper;
import com.alibaba.fastjson.JSON;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.contact.v1.MGetChattersRequest;
import com.bytedance.lark.pb.contact.v1.MGetChattersResponse;
import com.bytedance.lark.pb.contact.v1.UpdateChatterRequest;
import com.bytedance.lark.pb.contact.v1.UpdateChatterResponse;
import com.bytedance.lark.pb.im.v1.DeleteContactRequest;
import com.bytedance.lark.pb.im.v1.DeleteContactResponse;
import com.bytedance.lark.pb.im.v1.GetChatApplicationBadgeRequest;
import com.bytedance.lark.pb.im.v1.GetChatApplicationBadgeResponse;
import com.bytedance.lark.pb.im.v1.GetChatChattersByIdsRequest;
import com.bytedance.lark.pb.im.v1.GetChatChattersByIdsResponse;
import com.google.gson.Gson;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.biz.im.api.OpenApp;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.utils.z0;
import com.ss.android.lark.contact.customized.externalcontact.repository.NewFriendBadgeRepository;
import com.ss.android.lark.contact.customized.externalcontact.view.OfficeExternalContactViewModel;
import com.ss.android.lark.im.sdk.ImSdk;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.utils.rxjava.LarkRxSchedulers;
import com.ss.android.lark.utils.rxjava.ReportErrorConsumer;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@UserScope
public final class ImSdkChatterServiceImplV2 implements com.ss.android.lark.im.sdk.service.h {
    public static final /* synthetic */ int c = 0;
    public final com.bytedance.lark.rustclient.api.l a;
    public Chatter b;

    public static final class a {
        public a() {
        }

        public static final ErrorResult a(String r4) {
            int r0 = ImSdkChatterServiceImplV2.c;
            Exception r1 = new Exception("unknown error");
            ErrorResult r2 = new ErrorResult(0);
            ErrorResult.access$002(r2, -1);
            ErrorResult.access$102(r2, -9999);
            ErrorResult.access$202(r2, 0);
            ErrorResult.access$302(r2, r1);
            ErrorResult.access$402(r2, "");
            ErrorResult.access$502(r2, r4);
            ErrorResult.access$602(r2, "");
            ErrorResult.access$702(r2, "");
            ErrorResult.access$802(r2, 0);
            ErrorResult.access$902(r2, null);
            ErrorResult.access$1002(r2, null);
            ErrorResult.access$1102(r2, null);
            return r2;
        }
    }

    public static final class b<T, R> implements Function {
        public static final b<T, R> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object apply(Object r2) {
            com.bytedance.lark.rustclient.api.x r3 = (com.bytedance.lark.rustclient.api.x) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return (DeleteContactResponse) r3.c;
        }
    }

    public static final class c<T, R> implements Function {
        public final /* synthetic */ String a;

        public c(String r1) {
            this.a = r1;
        }

        public final Object apply(Object r2) {
            com.bytedance.lark.rustclient.api.x r3 = (com.bytedance.lark.rustclient.api.x) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return com.ss.android.lark.parser.internal.j.b(((GetChatChattersByIdsResponse) r3.c).entity, this.a).c();
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ IGetDataCallback<Chatter> b;

        public d(String r1, IGetDataCallback<Chatter> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            Chatter r3 = (Chatter) ((Map) r2).get(this.a);
            if (ImSdkProxy.e().a() == true) goto L7;
            if (r3 != null) goto L7;
            IGetDataCallback<Chatter> r4 = this.b;
            int r0 = ImSdkChatterServiceImplV2.c;
            r4.onError(a.a("Can't find target chatter!"));
            return;
        L7:
            this.b.onSuccess(r3);
        }
    }

    public static final class e extends ReportErrorConsumer {
        public final /* synthetic */ IGetDataCallback<Chatter> a;

        public e(IGetDataCallback<Chatter> r1) {
            this.a = r1;
        }

        public final void error(Throwable r3) {
            Intrinsics.checkNotNullParameter(r3, "throwable");
            IGetDataCallback<Chatter> r0 = this.a;
            int r1 = ImSdkChatterServiceImplV2.c;
            r0.onError(a.a(r3.getMessage()));
        }
    }

    public static final class f<T, R> implements Function {
        public static final f<T, R> a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final Object apply(Object r2) {
            com.bytedance.lark.rustclient.api.x r3 = (com.bytedance.lark.rustclient.api.x) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return new HashMap(com.ss.android.lark.parser.internal.j.b(((MGetChattersResponse) r3.c).entity, null).a);
        }
    }

    public static final class g<T, R> implements Function {
        public static final g<T, R> a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final Object apply(Object r2) {
            com.bytedance.lark.rustclient.api.x r3 = (com.bytedance.lark.rustclient.api.x) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            if (((UpdateChatterResponse) r3.c).message.length() != 0) goto L5;
            boolean r4 = true;
        L7:
            return Boolean.valueOf(r4);
        L5:
            r4 = false;
            goto L7
        }
    }

    public static final class h<T, R> implements Function {
        public final /* synthetic */ ImSdkChatterServiceImplV2 a;

        public h(ImSdkChatterServiceImplV2 r1) {
            this.a = r1;
        }

        public final Object apply(Object r3) {
            Intrinsics.checkNotNullParameter((Boolean) r3, "it");
            String r4 = ImSdkProxy.e().getCurrentUserId();
            return this.a.b(CollectionsKt.listOf(r4)).map(new n(r4));
        }
    }

    static {
        new a();
    }

    public static Chatter c() {
        String r0 = ((okb.g) ImSdkProxy.h.getValue()).a().getString();
        Chatter r1 = (Chatter) com.ss.android.lark.utils.z.a(r0, Chatter.class);
        if (r1 != null) goto L5;
        Log.e("ImSdkChatterServiceImplV2", "loadChatter, parseJson failed, data is:" + r0);
    L5:
        return r1;
    }

    public final Chatter a() {
        Log.i("ImSdkChatterServiceImplV2", "getLoginUser");
        if (com.larksuite.framework.utils.z.e(ImSdk.a.getContext()) == false) goto L5;
        Chatter r0 = this.b;
        if (r0 == null) goto L9;
        return r0;
    L9:
        Chatter r1 = c();
        this.b = r1;
        return r1;
    L5:
        return c();
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final Chatter zb() {
        Log.i("ImSdkChatterServiceImplV2", "getLocalLoginChatter");
        String r0 = ImSdkProxy.e().getCurrentUserId();
        if (r0.length() != 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L9;
        Log.e("ImSdkChatterServiceImplV2", "getLocalLoginChatter, userId is null");
        return null;
    L9:
        Chatter r1 = l7(r0);
        if (r1 == null) goto L13;
        return r1;
    L13:
        return a();
    L5:
        r2 = false;
        goto L6
    }

    @Inject
    public ImSdkChatterServiceImplV2(com.bytedance.lark.rustclient.api.l r2) {
        Intrinsics.checkNotNullParameter(r2, "rustClient");
        this.a = r2;
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final void F5(Chatter r2) {
        Gson r0 = com.ss.android.lark.utils.z.a;
        if (r2 != null) goto L11;
    L7:
        String r3 = "{}";
    L8:
        ((okb.g) ImSdkProxy.h.getValue()).a().b(r3);
        return;
    L11:
        r3 = JSON.toJSONString(r2);     // Catch: Throwable -> L10
        goto L8
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final void L2(NewFriendBadgeRepository.getBadge.1 r11) {
        Intrinsics.checkNotNullParameter(r11, "callback");
        com.bytedance.lark.rustclient.api.d r0 = new com.bytedance.lark.rustclient.api.d(new GetChatApplicationBadgeRequest.Builder(), GetChatApplicationBadgeResponse.ADAPTER, Command.GET_CHAT_APPLICATION_BADGE, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.a(com.bytedance.lark.rustclient.api.t.b(this.a.h(r0).a()).map(i.a), r11);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final void W8(OfficeExternalContactViewModel.fetchSelfCardHeader.1 r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        RxScheduledExecutor.execInIO(new j(this), new k(r3));
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final Map<String, Chatter> a0(List<String> r10) {
        Intrinsics.checkNotNullParameter(r10, "chatterIds");
        z0.a();
        if (r10.isEmpty() == true) goto L5;
        MGetChattersRequest.Builder r1 = new MGetChattersRequest.Builder();
        r1.chatter_ids(r10);
        com.bytedance.lark.rustclient.api.x r11 = this.a.h(new com.bytedance.lark.rustclient.api.d(r1, MGetChattersResponse.ADAPTER, Command.MGET_CHATTERS, null, null, null, null, 248)).execute();
        Intrinsics.checkNotNullParameter(r11, "<this>");
        HashMap r2 = null;
        if ((r11 instanceof com.bytedance.lark.rustclient.api.x) == false) goto L9;
        Object r12 = r11.c;
    L10:
        MGetChattersResponse r13 = (MGetChattersResponse) r12;
        if (r13 == null) goto L13;
        r2 = new HashMap(com.ss.android.lark.parser.internal.j.b(r13.entity, null).a);
    L13:
        if (r2 == null) goto L15;
        return r2;
    L15:
        return MapsKt.emptyMap();
    L9:
        r12 = null;
        goto L10
    L5:
        return MapsKt.emptyMap();
    }

    public final Observable<Map<String, Chatter>> b(List<String> r10) {
        if (CollectionUtils.isEmpty(r10) == true) goto L5;
        MGetChattersRequest.Builder r1 = new MGetChattersRequest.Builder();
        r1.chatter_ids(r10);
        r1.is_from_server(Boolean.TRUE);
        com.bytedance.lark.rustclient.api.d r11 = new com.bytedance.lark.rustclient.api.d(r1, MGetChattersResponse.ADAPTER, Command.MGET_CHATTERS, null, null, null, null, 248);
        return com.bytedance.lark.rustclient.api.t.b(this.a.h(r11).a()).map(f.a);
    L5:
        return Observable.just(MapsKt.emptyMap());
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final Map<String, Chatter> l0(List<String> r14) {
        Intrinsics.checkNotNullParameter(r14, "chatterIds");
        if (r14.isEmpty() == true) goto L5;
        List<String> r15 = CollectionsKt.toList(r14);
        Map<String, Chatter> r1 = a0(r15);
        List<String> r16 = CollectionsKt.minus(r15, r1.keySet());
        if (r16.isEmpty() == false) goto L9;
        return r1;
    L9:
        Intrinsics.checkNotNullParameter(r16, "chatterIds");
        z0.a();
        if (r16.isEmpty() == false) goto L12;
        Map r17 = MapsKt.emptyMap();
    L28:
        return MapsKt.plus(r1, r17);
    L12:
        Observable<Map<String, Chatter>> r0 = b(r16);
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L15
        Object r3 = Result.constructor-impl((Map) r0.blockingFirst());     // Catch: Throwable -> L15
    L18:
        if (Result.isFailure-impl(r3) == false) goto L21;
        Log.e("ImSdkChatterServiceImplV2", "getNetChatters failed, chatters:" + CollectionsKt.joinToString$default(r16, null, null, null, 0, null, null, 63, null), Result.exceptionOrNull-impl(r3));
    L21:
        if (Result.isFailure-impl(r3) == false) goto L23;
        r3 = null;
    L23:
        Map r4 = (Map) r3;
        if (r4 != null) goto L26;
        r17 = MapsKt.emptyMap();
        goto L28
    L26:
        r17 = r4;
    L15:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    L5:
        return MapsKt.emptyMap();
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final Chatter l7(String r2) {
        Intrinsics.checkNotNullParameter(r2, "chatterId");
        if (r2.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return null;
    L9:
        return a0(CollectionsKt.listOf(r2)).get(r2);
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final Chatter ue(String r2) {
        Intrinsics.checkNotNullParameter(r2, "chatterId");
        if (r2.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return null;
    L10:
        return l0(CollectionsKt.listOf(r2)).get(r2);
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final ChatChatter x1(String r5) {
        Log.i("ImSdkChatterServiceImplV2", "getLoginChatChatter chatId:" + r5);
        String r0 = ImSdkProxy.e().getCurrentUserId();
        if (r0.length() != 0) goto L5;
        boolean r2 = true;
    L6:
        Object r3 = null;
        if (r2 == false) goto L10;
        Log.i("ImSdkChatterServiceImplV2", "getLoginChatChatter userId empty");
        return null;
    L10:
        ChatChatter r6 = H5(r5, r0);
        if (r6 == null) goto L13;
        return r6;
    L13:
        Chatter r7 = a();
        if (r7 != null) goto L30;
        Log.e("ImSdkChatterServiceImplV2", "getLoginChatChatter null getLoginUser");
        return null;
    L30:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L19
        Object r8 = Result.constructor-impl(new ChatChatter(r7));     // Catch: Throwable -> L19
    L22:
        if (Result.isFailure-impl(r8) == false) goto L25;
        Log.e("ImSdkChatterServiceImplV2", "getLoginChatChatter failed", Result.exceptionOrNull-impl(r8));
    L25:
        if (Result.isFailure-impl(r8) == true) goto L29;
        r3 = r8;
    L29:
        return (ChatChatter) r3;
    L19:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    L5:
        r2 = false;
        goto L6
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final Map<String, ChatChatter> A2(String r2, List<String> r3) {
        Intrinsics.checkNotNullParameter(r3, "chatterIds");
        return I3(r2, r3);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final ChatChatter H5(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "chatterId");
        if (r3.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return null;
    L9:
        return A2(r2, CollectionsKt.listOf(r3)).get(r3);
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final ChatChatter He(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "chatterId");
        z0.a();
        if (r6.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return null;
    L9:
        if (r5 != null) goto L11;
        r5 = "";
    L11:
        List<String> r1 = CollectionsKt.listOf(r6);
        Intrinsics.checkNotNullParameter(r5, "chatId");
        Intrinsics.checkNotNullParameter(r1, "chatterIds");
        List r2 = CollectionsKt.toList(r1);
        if (r2.isEmpty() == false) goto L14;
        Map r7 = MapsKt.emptyMap();
    L19:
        return (ChatChatter) r7.get(r6);
    L14:
        Intrinsics.checkNotNullParameter(r2, "chatterIds");
        Map r3 = I3(r5, r2);
        if (CollectionsKt.minus(r2, r3.keySet()).isEmpty() == false) goto L17;
        r7 = r3;
        goto L19
    L17:
        r7 = MapsKt.plus(r3, ld(r5, r1));
        goto L19
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final Map I3(final String r10, List r11) {
        Intrinsics.checkNotNullParameter(r11, "chatterIds");
        z0.a();
        if (r11.isEmpty() == true) goto L5;
        GetChatChattersByIdsRequest.Builder r1 = new GetChatChattersByIdsRequest.Builder();
        r1.chat_id(r10);
        r1.chatter_ids(r11);
        com.bytedance.lark.rustclient.api.d r12 = new com.bytedance.lark.rustclient.api.d(r1, GetChatChattersByIdsResponse.ADAPTER, Command.GET_CHAT_CHATTERS_BY_IDS, null, null, null, null, 248);
        com.bytedance.lark.rustclient.api.x r13 = com.bytedance.lark.rustclient.api.t.e(this.a.h(r12).execute(), new ImSdkChatterServiceImplV2$getLocalChatChatters$resp$2(r10));
        Intrinsics.checkNotNullParameter(r13, "<this>");
        if ((r13 instanceof com.bytedance.lark.rustclient.api.x) == false) goto L9;
        Object r14 = r13.c;
    L10:
        Map r15 = (Map) r14;
        if (r15 == null) goto L13;
        return r15;
    L13:
        return MapsKt.emptyMap();
    L9:
        r14 = null;
        goto L10
    L5:
        return MapsKt.emptyMap();
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final void N7(String r11, final IGetDataCallback<Boolean> r12) {
        Intrinsics.checkNotNullParameter(r11, "contactUserId");
        Intrinsics.checkNotNullParameter(r12, "callback");
        DeleteContactRequest.Builder r2 = new DeleteContactRequest.Builder().user_id(r11);
        Intrinsics.checkNotNull(r2);
        com.bytedance.lark.rustclient.api.d r13 = new com.bytedance.lark.rustclient.api.d(r2, DeleteContactResponse.ADAPTER, Command.DELETE_CONTACT, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.a(com.bytedance.lark.rustclient.api.t.b(this.a.h(r13).a()).map(b.a), new ImSdkChatterServiceImplV2$deleteExternalContact$2(r12));
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final void j1(String r11, IGetDataCallback<Chatter> r12) {
        Intrinsics.checkNotNullParameter(r11, "avatarKey");
        Intrinsics.checkNotNullParameter(r12, "callback");
        UpdateChatterRequest.Builder r2 = new UpdateChatterRequest.Builder().icon_key(r11);
        Intrinsics.checkNotNull(r2);
        com.bytedance.lark.rustclient.api.d r13 = new com.bytedance.lark.rustclient.api.d(r2, UpdateChatterResponse.ADAPTER, Command.UPDATE_CHATTER, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.a(com.bytedance.lark.rustclient.api.t.b(this.a.h(r13).a()).map(g.a).flatMap(new h(this)), r12);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final Map<String, ChatChatter> ld(String r12, List<String> r13) {
        Intrinsics.checkNotNullParameter(r13, "chatterIds");
        z0.a();
        List<String> r1 = r13;
        if (CollectionsKt.toList(r1).isEmpty() == true) goto L5;
        GetChatChattersByIdsRequest.Builder r3 = new GetChatChattersByIdsRequest.Builder();
        r3.chat_id(r12);
        r3.chatter_ids(r13);
        r3.strategy(SyncDataStrategy.FORCE_SERVER);
        Observable r14 = com.bytedance.lark.rustclient.api.t.b(this.a.h(new com.bytedance.lark.rustclient.api.d(r3, GetChatChattersByIdsResponse.ADAPTER, Command.GET_CHAT_CHATTERS_BY_IDS, null, null, null, null, 248)).a()).map(new m(r12));
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        Object r15 = Result.constructor-impl((Map) r14.blockingFirst());     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r15) == false) goto L15;
        Log.e("ImSdkChatterServiceImplV2", "getNetChatChatters failed, chatId:" + r12 + ",chatters:" + CollectionsKt.joinToString$default(r1, null, null, null, 0, null, null, 63, null), Result.exceptionOrNull-impl(r15));
    L15:
        if (Result.isFailure-impl(r15) == false) goto L17;
        r15 = null;
    L17:
        Map<String, ChatChatter> r16 = (Map) r15;
        if (r16 == null) goto L20;
        return r16;
    L20:
        return MapsKt.emptyMap();
    L9:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    L5:
        return MapsKt.emptyMap();
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final void pd(String r4, IGetDataCallback<Chatter> r5) {
        Intrinsics.checkNotNullParameter(r4, "chatterId");
        Intrinsics.checkNotNullParameter(r5, "callback");
        if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        Scheduler r1 = LarkRxSchedulers.mainThread();
        Intrinsics.checkNotNull(r1);
    L9:
        final List r2 = CollectionsKt.toList(CollectionsKt.listOf(r4));
        Observable.create(new ImSdkChatterServiceImplV2$getChattersObservable$1(this, r2)).subscribeOn(LarkRxSchedulers.io()).observeOn(r1).subscribe(new d(r4, r5), new e(r5));
        return;
    L8:
        r1 = LarkRxSchedulers.io();
        Intrinsics.checkNotNull(r1);
        goto L9
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final Pair<ChatChatter, OpenApp> qb(String r13, String r14) {
        Intrinsics.checkNotNullParameter(r14, "botId");
        z0.a();
        List r0 = CollectionsKt.mutableListOf(new String[]{r14});
        GetChatChattersByIdsRequest.Builder r2 = new GetChatChattersByIdsRequest.Builder();
        r2.chat_id(r13);
        r2.chatter_ids(r0);
        r2.strategy(SyncDataStrategy.FORCE_SERVER);
        Observable r1 = com.bytedance.lark.rustclient.api.t.b(this.a.h(new com.bytedance.lark.rustclient.api.d(r2, GetChatChattersByIdsResponse.ADAPTER, Command.GET_CHAT_CHATTERS_BY_IDS, null, null, null, null, 248)).a()).map(new l(r13));
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L5
        Object r4 = Result.constructor-impl((Map) r1.blockingFirst());     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r4) == false) goto L11;
        Log.e("ImSdkChatterServiceImplV2", "getNetChatChattersAndOpenApp failed, chatId:" + r13 + ",chatters:" + CollectionsKt.joinToString$default(r0, null, null, null, 0, null, null, 63, null), Result.exceptionOrNull-impl(r4));
    L11:
        if (Result.isFailure-impl(r4) == false) goto L13;
        r4 = null;
    L13:
        Map r5 = (Map) r4;
        if (r5 != null) goto L17;
        r5 = MapsKt.emptyMap();
    L17:
        return (Pair) r5.get(r14);
    L5:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final void v3(List<String> r2, IGetDataCallback<Map<String, Chatter>> r3) {
        Intrinsics.checkNotNullParameter(r2, "chatterIds");
        Intrinsics.checkNotNullParameter(r3, "callback");
        com.ss.android.lark.im.sdk.utils.e.a(b(r2), r3);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final void E9(String r11, List<String> r12, IGetDataCallback<Map<String, ChatChatter>> r13) {
        Intrinsics.checkNotNullParameter(r11, "chatId");
        Intrinsics.checkNotNullParameter(r12, "chatterIds");
        Intrinsics.checkNotNullParameter(r13, "callback");
        GetChatChattersByIdsRequest.Builder r2 = new GetChatChattersByIdsRequest.Builder();
        r2.chat_id(r11).chatter_ids(r12);
        com.bytedance.lark.rustclient.api.d r14 = new com.bytedance.lark.rustclient.api.d(r2, GetChatChattersByIdsResponse.ADAPTER, Command.GET_CHAT_CHATTERS_BY_IDS, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.a(com.bytedance.lark.rustclient.api.t.b(this.a.h(r14).a()).map(new c(r11)), r13);
    }
}
