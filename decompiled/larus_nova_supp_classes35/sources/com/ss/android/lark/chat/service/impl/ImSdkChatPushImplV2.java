package com.ss.android.lark.chat.service.impl;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.basic.v1.ExternalDisplayTimezoneSettingType;
import com.bytedance.lark.pb.basic.v1.Thread;
import com.bytedance.lark.pb.im.v1.DoubaoTyping;
import com.bytedance.lark.pb.im.v1.PushChatChatterListDepartmentName;
import com.bytedance.lark.pb.im.v1.PushChatChattersResponse;
import com.bytedance.lark.pb.im.v1.PushChatTimeTipNotify;
import com.bytedance.lark.pb.im.v1.PushDoubaoSmartReply;
import com.bytedance.lark.pb.im.v1.PushDoubaoTyping;
import com.bytedance.lark.pb.im.v1.PushOfflineUpdatedChats;
import com.bytedance.lark.pb.im.v1.PushPinReadStatusResponse;
import com.bytedance.lark.pb.im.v1.PushPreloadUpdatedChats;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.parser.internal.ModelParserMessage;
import com.ss.android.lark.passportc.dwarf.UserScope;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class ImSdkChatPushImplV2 implements m6b.s {
    public final f A;
    public final List<d0> B;
    public final Lazy C;
    public final h D;
    public final List<c0> E;
    public final Lazy F;
    public final g G;
    public final String a;
    public final com.bytedance.lark.rustclient.api.l b;
    public final CompositeDisposable c;
    public final b d;
    public final List<y> e;
    public final Lazy f;
    public final d g;
    public final List<y> h;
    public final Lazy i;
    public final i j;
    public final Lazy k;
    public final c l;
    public final List<z> m;
    public final List<x> n;
    public final List<a0> o;
    public final List<aqb.f> p;
    public final Lazy q;
    public final j r;
    public final List<aqb.e> s;
    public final Lazy t;
    public final e u;
    public final List<f0> v;
    public final Lazy w;
    public final k x;
    public final List<b0> y;
    public final Lazy z;

    public static final class a {
    }

    public static final class b implements Function1<Throwable, Unit> {
        public b() {
        }

        public final Object invoke(Object r2) {
            Throwable r3 = (Throwable) r2;
            Intrinsics.checkNotNullParameter(r3, "throwable");
            Log.e("ImSdkChatPushImplV2", r3);
            return Unit.INSTANCE;
        }
    }

    public static final class c implements Function1<PushChatChattersResponse, Unit> {
        public final /* synthetic */ ImSdkChatPushImplV2 a;

        public c(ImSdkChatPushImplV2 r1) {
            this.a = r1;
        }

        public final Object invoke(Object r6) {
            PushChatChattersResponse r7 = (PushChatChattersResponse) r6;
            Intrinsics.checkNotNullParameter(r7, "response");
            Chat r0 = com.ss.android.lark.parser.internal.h.a(r7.chat, null);     // Catch: Throwable -> L16
            Map<String, ChatChatter> r1 = com.ss.android.lark.parser.internal.j.b(r7.entity, null).a();     // Catch: Throwable -> L16
            Map r2 = ModelParserMessage.h(r7.entity);     // Catch: Throwable -> L16
            PushChatChattersResponse.Type r8 = r7.type;     // Catch: Throwable -> L16
            JSONObject r3 = new JSONObject();     // Catch: Throwable -> L16
            r3.put("chat", r0);     // Catch: Throwable -> L16
            r3.put("params_messages", r2);     // Catch: Throwable -> L16
            r3.put("params_chatters", r1);     // Catch: Throwable -> L16
            r3.put("params_push_chat_users_type", Integer.valueOf(r8.getValue()));     // Catch: Throwable -> L16
            int r9 = r8.getValue();     // Catch: Throwable -> L16
            if (r9 != PushChatChattersResponse.Type.DELETE_CHATTER.getValue()) goto L7;
            CoreThreadPool.getDefault().getUIExecutor().execute(new h0(this.a, r0, r1));     // Catch: Throwable -> L16
        L20:
        L19:
            return Unit.INSTANCE;
        L7:
            if (r9 != PushChatChattersResponse.Type.DELETE_ME.getValue()) goto L10;
            CoreThreadPool.getDefault().getUIExecutor().execute(new i0(this.a, r0));     // Catch: Throwable -> L16
            goto L20
        L10:
            if (r9 != PushChatChattersResponse.Type.ADD_CHATTER.getValue()) goto L13;
            CoreThreadPool.getDefault().getUIExecutor().execute(new j0(this.a, r0, r1));     // Catch: Throwable -> L16
            goto L20
        L13:
            if (r9 != PushChatChattersResponse.Type.UPDATE_CHATTER.getValue()) goto L20;
            CoreThreadPool.getDefault().getUIExecutor().execute(new k0(this.a, r0, r1));     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            Log.e("ImSdkChatPushImplV2", th, true);
            goto L19
        }
    }

    public static final class d implements Function1<Entity, Unit> {
        public final /* synthetic */ ImSdkChatPushImplV2 a;

        public d(ImSdkChatPushImplV2 r1) {
            this.a = r1;
        }

        public final Object invoke(Object r5) {
            Entity r6 = (Entity) r5;
            Intrinsics.checkNotNullParameter(r6, "entity");
            Map r7 = com.ss.android.lark.parser.internal.h.d(r6.chats, null, r6.mail_setting);     // Catch: Throwable -> L9
            CoreThreadPool.getDefault().getUIExecutor().execute(new l0(r7, this.a));     // Catch: Throwable -> L9
            StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L9
            HashMap r8 = (HashMap) r7;     // Catch: Throwable -> L9
            Iterator r2 = r8.keySet().iterator();     // Catch: Throwable -> L9
        L5:
            if (r2.hasNext() == false) goto L7;
            r1.append((String) r2.next());     // Catch: Throwable -> L9
            r1.append(", ");     // Catch: Throwable -> L9
            goto L5
        L7:
            Log.i("ImSdkChatPushImplV2", "PushChats success, size = " + r8.size() + ", ids: " + r1);     // Catch: Throwable -> L9
        L12:
            return Unit.INSTANCE;
        L9:
            th = move-exception;
            Log.e("ImSdkChatPushImplV2", th, true);
            goto L12
        }
    }

    public static final class e implements Function1<PushChatTimeTipNotify, Unit> {
        public final /* synthetic */ ImSdkChatPushImplV2 a;

        public e(ImSdkChatPushImplV2 r1) {
            this.a = r1;
        }

        public final Object invoke(Object r4) {
            PushChatTimeTipNotify r5 = (PushChatTimeTipNotify) r4;
            Intrinsics.checkNotNullParameter(r5, "response");
            com.ss.android.lark.chat.entity.timetip.PushChatTimeTipNotify r0 = new com.ss.android.lark.chat.entity.timetip.PushChatTimeTipNotify();     // Catch: Throwable -> L5
            String r1 = r5.chat_id;     // Catch: Throwable -> L5
            r5.status.getValue();     // Catch: Throwable -> L5
            ExternalDisplayTimezoneSettingType r6 = ExternalDisplayTimezoneSettingType.UNKNOWN;     // Catch: Throwable -> L5
            CoreThreadPool.getDefault().getUIExecutor().execute(new m0(this.a, r0));     // Catch: Throwable -> L5
        L8:
            return Unit.INSTANCE;
        L5:
            th = move-exception;
            Log.e("ImSdkChatPushImplV2", th, true);
            goto L8
        }
    }

    public static final class f implements Function1<PushChatChatterListDepartmentName, Unit> {
        public final /* synthetic */ ImSdkChatPushImplV2 a;

        public f(ImSdkChatPushImplV2 r1) {
            this.a = r1;
        }

        public final Object invoke(Object r6) {
            PushChatChatterListDepartmentName r7 = (PushChatChatterListDepartmentName) r6;
            Intrinsics.checkNotNullParameter(r7, "response");
            String r3 = r7.chat_id;     // Catch: Throwable -> L21
            boolean r4 = false;
            if (r3 != null) goto L6;
        L9:
            boolean r5 = true;
        L10:
            if (r5 == false) goto L12;
            Log.e("ImSdkChatPushImplV2", "response.chat_id is null or empty");     // Catch: Throwable -> L21
        L24:
            return Unit.INSTANCE;
        L12:
            Map r8 = r7.chatter_id_to_department_name;     // Catch: Throwable -> L21
            if (r8 != null) goto L15;
        L16:
            r4 = true;
        L17:
            if (r4 == false) goto L19;
            Log.e("ImSdkChatPushImplV2", "response.chatter_id_to_department_name is null or empty");     // Catch: Throwable -> L21
            goto L24
        L19:
            Log.i("ImSdkChatPushImplV2", "onPushDepartment chatId: " + r7.chat_id + ", departments.size: " + r7.chatter_id_to_department_name.size());     // Catch: Throwable -> L21
            CoreThreadPool.getDefault().getUIExecutor().execute(new n0(this.a, r7));     // Catch: Throwable -> L21
            goto L24
        L15:
            if (r8.isEmpty() == false) goto L17;
        L6:
            if (r3.length() == 0) goto L9;
            r5 = false;
        L21:
            th = move-exception;
            Log.e("ImSdkChatPushImplV2", th, true);
            goto L24
        }
    }

    public static final class g implements Function1<PushDoubaoSmartReply, Unit> {
        public final /* synthetic */ ImSdkChatPushImplV2 a;

        public g(ImSdkChatPushImplV2 r1) {
            this.a = r1;
        }

        public final Object invoke(Object r5) {
            PushDoubaoSmartReply r6 = (PushDoubaoSmartReply) r5;
            Intrinsics.checkNotNullParameter(r6, "response");
        L8:
            th = move-exception;
            Log.e("ImSdkChatPushImplV2", th, true);
        L11:
            return Unit.INSTANCE;
        L4:
            if (r6.doubao_smart_reply != null) goto L6;
            Log.e("ImSdkChatPushImplV2", "response.doubao_smart_reply is null");     // Catch: Throwable -> L8
        L12:
            goto L11
        L6:
            CoreThreadPool.getDefault().getUIExecutor().execute(new o0(this.a, r6));     // Catch: Throwable -> L8
            goto L12
        }
    }

    public static final class h implements Function1<PushDoubaoTyping, Unit> {
        public final /* synthetic */ ImSdkChatPushImplV2 a;

        public h(ImSdkChatPushImplV2 r1) {
            this.a = r1;
        }

        public final Object invoke(Object r5) {
            PushDoubaoTyping r6 = (PushDoubaoTyping) r5;
            Intrinsics.checkNotNullParameter(r6, "response");
            DoubaoTyping r7 = r6.doubao_typing;     // Catch: Throwable -> L8
            if (r7 != null) goto L6;
            Log.e("ImSdkChatPushImplV2", "response.doubao_typing is null or empty");     // Catch: Throwable -> L8
        L12:
        L11:
            return Unit.INSTANCE;
        L6:
            CoreThreadPool.getDefault().getUIExecutor().execute(new p0(this.a, r7));     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            Log.e("ImSdkChatPushImplV2", th, true);
            goto L11
        }
    }

    public static final class i implements Function1<PushOfflineUpdatedChats, Unit> {
        public final /* synthetic */ ImSdkChatPushImplV2 a;

        public i(ImSdkChatPushImplV2 r1) {
            this.a = r1;
        }

        public final Object invoke(Object r7) {
            PushOfflineUpdatedChats r8 = (PushOfflineUpdatedChats) r7;
            Intrinsics.checkNotNullParameter(r8, "pushOfflineUpdatedChats");
            Entity r1 = r8.entity;     // Catch: Throwable -> L29
            if (r1 != null) goto L6;
            Log.e("ImSdkChatPushImplV2", "Entity from PushOfflineUpdatedChats is null");     // Catch: Throwable -> L29
        L32:
            return Unit.INSTANCE;
        L6:
            Map r2 = com.ss.android.lark.parser.internal.h.d(r1.chats, null, r1.mail_setting);     // Catch: Throwable -> L29
            CoreThreadPool.getDefault().getUIExecutor().execute(new q0(r2, this.a));     // Catch: Throwable -> L29
            StringBuilder r3 = new StringBuilder();     // Catch: Throwable -> L29
            HashMap r4 = (HashMap) r2;     // Catch: Throwable -> L29
            Iterator r5 = r4.keySet().iterator();     // Catch: Throwable -> L29
        L8:
            if (r5.hasNext() == false) goto L10;
            r3.append((String) r5.next());     // Catch: Throwable -> L29
            r3.append(", ");     // Catch: Throwable -> L29
            goto L8
        L10:
            Log.i("ImSdkChatPushImplV2", "PushOfflineChats success, size = " + r4.size() + ", ids: " + r3);     // Catch: Throwable -> L29
            List r9 = r8.updated_items;     // Catch: Throwable -> L29
            if (CollectionUtils.isEmpty(r9) == true) goto L32;
            if (CollectionUtils.isEmpty(r1.threads) == true) goto L32;
            Iterator r10 = r9.iterator();     // Catch: Throwable -> L29
        L18:
            if (r10.hasNext() == false) goto L32;
            PushOfflineUpdatedChats.UpdatedItem r6 = (PushOfflineUpdatedChats.UpdatedItem) r10.next();     // Catch: Throwable -> L29
            if (r6 == null) goto L18;
            if (TextUtils.isEmpty(r6.item_id) == true) goto L18;
            if (r6.item_type != PushOfflineUpdatedChats.UpdatedItem.Type.THREAD) goto L18;
            ThreadTopic r11 = com.ss.android.lark.parser.internal.b0.a((Thread) r1.threads.get(r6.item_id));     // Catch: Throwable -> L29
            if (r11 == null) goto L18;
            CoreThreadPool.getDefault().getUIExecutor().execute(new r0(this.a, r11));     // Catch: Throwable -> L29
        L29:
            th = move-exception;
            Log.e("ImSdkChatPushImplV2", th, true);
            goto L32
        }
    }

    public static final class j implements Function1<PushPinReadStatusResponse, Unit> {
        public final /* synthetic */ ImSdkChatPushImplV2 a;

        public j(ImSdkChatPushImplV2 r1) {
            this.a = r1;
        }

        public final Object invoke(Object r4) {
            PushPinReadStatusResponse r5 = (PushPinReadStatusResponse) r4;
            Intrinsics.checkNotNullParameter(r5, "response");
            CoreThreadPool.getDefault().getUIExecutor().execute(new s0(this.a, r5));     // Catch: Throwable -> L5
        L8:
            return Unit.INSTANCE;
        L5:
            th = move-exception;
            Log.e("ImSdkChatPushImplV2", th, true);
            goto L8
        }
    }

    public static final class k implements Function1<PushPreloadUpdatedChats, Unit> {
        public final /* synthetic */ ImSdkChatPushImplV2 a;

        public k(ImSdkChatPushImplV2 r1) {
            this.a = r1;
        }

        public final Object invoke(Object r5) {
            PushPreloadUpdatedChats r6 = (PushPreloadUpdatedChats) r5;
            Intrinsics.checkNotNullParameter(r6, "pushPreloadUpdatedChats");
            List r7 = r6.updated_items;     // Catch: Throwable -> L20
            ArrayList r1 = new ArrayList();     // Catch: Throwable -> L20
            List r2 = r7;     // Catch: Throwable -> L20
            if (r2 != null) goto L6;
        L9:
            boolean r3 = true;
        L10:
            if (r3 == true) goto L18;
            if (r7 == null) goto L18;
            List r8 = CollectionsKt.filterNotNull(r7);     // Catch: Throwable -> L20
            if (r8 == null) goto L18;
            Iterator r9 = r8.iterator();     // Catch: Throwable -> L20
        L16:
            if (r9.hasNext() == false) goto L18;
            r1.add(((PushPreloadUpdatedChats.UpdatedItem) r9.next()).item_id);     // Catch: Throwable -> L20
        L18:
            CoreThreadPool.getDefault().getUIExecutor().execute(new t0(this.a, r1));     // Catch: Throwable -> L20
        L23:
            return Unit.INSTANCE;
        L6:
            if (r2.isEmpty() == true) goto L9;
            r3 = false;
        L20:
            th = move-exception;
            Log.e("ImSdkChatPushImplV2", th, true);
            goto L23
        }
    }

    static {
    }

    @Override // m6b.s
    public final void Cc(x r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        ((CopyOnWriteArrayList) this.n).remove(r2);
    }

    @Override // m6b.s
    public final void Ce(f0 r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (((CopyOnWriteArrayList) this.v).contains(r2) == true) goto L8;
        ((CopyOnWriteArrayList) this.v).add(r2);
        Disposable r3 = (Disposable) this.w.getValue();
        Log.i("ImSdkChatPushImplV2", "add listener to pushPreloadUpdatedChatsDisposable");
        return;
    }

    @Override // m6b.s
    public final void Gb(a0 r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        ((CopyOnWriteArrayList) this.o).remove(r2);
    }

    @Override // m6b.s
    public final void Ge(b0 r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (((CopyOnWriteArrayList) this.y).contains(r2) == true) goto L8;
        ((CopyOnWriteArrayList) this.y).add(r2);
        Disposable r3 = (Disposable) this.z.getValue();
        Log.i("ImSdkChatPushImplV2", "add listener to pushDepartmentDisposable");
        return;
    }

    @Override // m6b.s
    public final void Hc(b0 r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        ((CopyOnWriteArrayList) this.y).remove(r2);
    }

    @Override // m6b.s
    public final void Nd(com.ss.android.lark.chat.service.impl.h.f r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (((CopyOnWriteArrayList) this.E).contains(r2) == true) goto L8;
        ((CopyOnWriteArrayList) this.E).add(r2);
        Disposable r3 = (Disposable) this.F.getValue();
        Log.i("ImSdkChatPushImplV2", "add listener to pushDoubaoSmartReplyDisposable");
        return;
    }

    @Override // m6b.s
    public final void O1(x r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (((CopyOnWriteArrayList) this.n).contains(r2) == true) goto L8;
        ((CopyOnWriteArrayList) this.n).add(r2);
        Disposable r3 = (Disposable) this.k.getValue();
        Log.i("ImSdkChatPushImplV2", "add listener to pushChatChattersDisposable");
        return;
    }

    @Override // m6b.s
    public final void O5(y r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        ((CopyOnWriteArrayList) this.h).remove(r2);
    }

    @Override // m6b.s
    public final void Qa(z r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (((CopyOnWriteArrayList) this.m).contains(r2) == true) goto L8;
        ((CopyOnWriteArrayList) this.m).add(r2);
        Disposable r3 = (Disposable) this.k.getValue();
        Log.i("ImSdkChatPushImplV2", "add listener to pushChatChattersDisposable");
        return;
    }

    @Override // m6b.s
    public final void Se(aqb.f r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        ((CopyOnWriteArrayList) this.p).remove(r2);
    }

    @Override // m6b.s
    public final void V2(com.ss.android.lark.chat.service.impl.h.g r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        ((CopyOnWriteArrayList) this.B).remove(r2);
    }

    @Override // m6b.s
    public final void W6(com.ss.android.lark.chat.service.impl.h.g r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (((CopyOnWriteArrayList) this.B).contains(r2) == true) goto L8;
        ((CopyOnWriteArrayList) this.B).add(r2);
        Disposable r3 = (Disposable) this.C.getValue();
        Log.i("ImSdkChatPushImplV2", "add listener to pushDoubaoTypingDisposable");
        return;
    }

    @Override // m6b.s
    public final void Z4(z r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        ((CopyOnWriteArrayList) this.m).remove(r2);
    }

    @Override // m6b.s
    public final void b3(y r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        ((CopyOnWriteArrayList) this.e).remove(r2);
    }

    @Override // m6b.s
    public final void c1(y r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (((CopyOnWriteArrayList) this.h).contains(r2) == true) goto L8;
        ((CopyOnWriteArrayList) this.h).add(r2);
        Disposable r3 = (Disposable) this.i.getValue();
        Log.i("ImSdkChatPushImplV2", "add listener to pushOfflineChatDisposable");
        return;
    }

    @Override // m6b.s
    public final void d1(aqb.e r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        ((CopyOnWriteArrayList) this.s).remove(r2);
    }

    @Override // m6b.s
    public final void f8(aqb.e r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (((CopyOnWriteArrayList) this.s).contains(r2) == true) goto L8;
        ((CopyOnWriteArrayList) this.s).add(r2);
        Disposable r3 = (Disposable) this.t.getValue();
        Log.i("ImSdkChatPushImplV2", "add listener to pushChatTimeTipNotifyDisposable");
        return;
    }

    @Override // m6b.s
    public final void gd(aqb.f r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (((CopyOnWriteArrayList) this.p).contains(r2) == true) goto L8;
        ((CopyOnWriteArrayList) this.p).add(r2);
        Disposable r3 = (Disposable) this.q.getValue();
        Log.i("ImSdkChatPushImplV2", "add listener to pushPinReadStatusDisposable");
        return;
    }

    @Override // m6b.s
    public final void ha(a0 r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (((CopyOnWriteArrayList) this.o).contains(r2) == true) goto L8;
        ((CopyOnWriteArrayList) this.o).add(r2);
        Disposable r3 = (Disposable) this.k.getValue();
        Log.i("ImSdkChatPushImplV2", "add listener to pushChatChattersDisposable");
        return;
    }

    @Override // m6b.s
    public final void k5(com.ss.android.lark.chat.service.impl.h.f r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        ((CopyOnWriteArrayList) this.E).remove(r2);
    }

    @Override // m6b.s
    public final void ke(y r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (((CopyOnWriteArrayList) this.e).contains(r2) == true) goto L8;
        ((CopyOnWriteArrayList) this.e).add(r2);
        Disposable r3 = (Disposable) this.f.getValue();
        Log.i("ImSdkChatPushImplV2", "add listener to pushChatDisposable");
        return;
    }

    @Override // m6b.s
    public final void vd(f0 r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        ((CopyOnWriteArrayList) this.v).remove(r2);
    }

    @Inject
    public ImSdkChatPushImplV2(String r2, com.bytedance.lark.rustclient.api.l r3) {
        Intrinsics.checkNotNullParameter(r2, "currentUserId");
        Intrinsics.checkNotNullParameter(r3, "userRustClient");
        this.a = r2;
        this.b = r3;
        Log.i("ImSdkChatPushImplV2", "current user id is " + r2);
        this.c = new CompositeDisposable();
        this.d = new b();
        this.e = new CopyOnWriteArrayList();
        LazyThreadSafetyMode r4 = LazyThreadSafetyMode.SYNCHRONIZED;
        this.f = LazyKt.lazy(r4, new ImSdkChatPushImplV2$pushChatDisposable$2(this));
        this.g = new d(this);
        this.h = new CopyOnWriteArrayList();
        this.i = LazyKt.lazy(r4, new ImSdkChatPushImplV2$pushOfflineChatDisposable$2(this));
        this.j = new i(this);
        this.k = LazyKt.lazy(r4, new ImSdkChatPushImplV2$pushChatChattersDisposable$2(this));
        this.l = new c(this);
        this.m = new CopyOnWriteArrayList();
        this.n = new CopyOnWriteArrayList();
        this.o = new CopyOnWriteArrayList();
        this.p = new CopyOnWriteArrayList();
        this.q = LazyKt.lazy(r4, new ImSdkChatPushImplV2$pushPinReadStatusDisposable$2(this));
        this.r = new j(this);
        this.s = new CopyOnWriteArrayList();
        this.t = LazyKt.lazy(r4, new ImSdkChatPushImplV2$pushChatTimeTipNotifyDisposable$2(this));
        this.u = new e(this);
        this.v = new CopyOnWriteArrayList();
        this.w = LazyKt.lazy(r4, new ImSdkChatPushImplV2$pushPreloadUpdatedChatsDisposable$2(this));
        this.x = new k(this);
        this.y = new CopyOnWriteArrayList();
        this.z = LazyKt.lazy(r4, new ImSdkChatPushImplV2$pushDepartmentDisposable$2(this));
        this.A = new f(this);
        this.B = new CopyOnWriteArrayList();
        this.C = LazyKt.lazy(r4, new ImSdkChatPushImplV2$pushDoubaoTypingDisposable$2(this));
        this.D = new h(this);
        this.E = new CopyOnWriteArrayList();
        this.F = LazyKt.lazy(r4, new ImSdkChatPushImplV2$pushDoubaoSmartReplyDisposable$2(this));
        this.G = new g(this);
    }
}
