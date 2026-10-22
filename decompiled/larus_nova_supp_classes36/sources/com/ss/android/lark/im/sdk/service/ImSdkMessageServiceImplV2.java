package com.ss.android.lark.im.sdk.service;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Channel;
import com.bytedance.lark.pb.basic.v1.ChannelDataIncompleteStrategy;
import com.bytedance.lark.pb.basic.v1.ChannelDataScene;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.basic.v1.File;
import com.bytedance.lark.pb.basic.v1.LarkError;
import com.bytedance.lark.pb.basic.v1.QuasiMessage;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.basic.v1.Thread;
import com.bytedance.lark.pb.im.v1.DeleteEphemeralMessageRequest;
import com.bytedance.lark.pb.im.v1.DeleteEphemeralMessageResponse;
import com.bytedance.lark.pb.im.v1.DeleteMessagesRequest;
import com.bytedance.lark.pb.im.v1.DeleteMessagesResponse;
import com.bytedance.lark.pb.im.v1.DeleteQuasiMessageRequest;
import com.bytedance.lark.pb.im.v1.DeleteQuasiMessageResponse;
import com.bytedance.lark.pb.im.v1.GetChatMessagesRequest;
import com.bytedance.lark.pb.im.v1.GetChatMessagesResponse;
import com.bytedance.lark.pb.im.v1.GetMessageIdsByPositionRequest;
import com.bytedance.lark.pb.im.v1.GetMessageIdsByPositionResponse;
import com.bytedance.lark.pb.im.v1.GetMessagesByPositionsRequest;
import com.bytedance.lark.pb.im.v1.GetMessagesByPositionsResponse;
import com.bytedance.lark.pb.im.v1.GetQuasiMergeForwardMessageRequest;
import com.bytedance.lark.pb.im.v1.GetQuasiMergeForwardMessageResponse;
import com.bytedance.lark.pb.im.v1.GetUnreadDoubaoReplyMessagesRequest;
import com.bytedance.lark.pb.im.v1.GetUnreadElevatorJumpMessagesResponse;
import com.bytedance.lark.pb.im.v1.MGetMessagesRequest;
import com.bytedance.lark.pb.im.v1.MGetMessagesResponse;
import com.bytedance.lark.pb.im.v1.RecallGroupMessageRequest;
import com.bytedance.lark.pb.im.v1.RecallGroupMessageResponse;
import com.bytedance.lark.pb.im.v1.RecallMessageRequest;
import com.bytedance.lark.pb.im.v1.RecallMessageResponse;
import com.bytedance.lark.pb.im.v1.UpdateLocalSystemMessageVisibilityRequest;
import com.bytedance.lark.pb.im.v1.UpdateLocalSystemMessageVisibilityResponse;
import com.bytedance.lark.pb.im.v1.UpdateMessagesMeReadRequest;
import com.bytedance.lark.pb.im.v1.UpdateMessagesMeReadResponse;
import com.bytedance.lark.pb.im.v1.UpdateQuasiMessageRequest;
import com.bytedance.lark.pb.im.v1.UpdateQuasiMessageResponse;
import com.bytedance.lark.pb.media.v1.UploadFilesRequest;
import com.bytedance.lark.pb.media.v1.UploadFilesResponse;
import com.bytedance.lark.pb.settings.v1.SetDataDisplayWeightRequest;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.biz.im.api.p0;
import com.ss.android.lark.biz.im.api.t0;
import com.ss.android.lark.chat.api.service.impl.ChatService;
import com.ss.android.lark.chat.core.model.MessageFetchScene;
import com.ss.android.lark.chat.core.model.entity.ChatMessageResponse;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageFoldDetail;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.chat.entity.message.SendStatus;
import com.ss.android.lark.chat.service.impl.MonitorMessageSendCallback;
import com.ss.android.lark.chat.service.impl.RecallInterceptCallback;
import com.ss.android.lark.chat.service.impl.z0;
import com.ss.android.lark.chat.utils.n0;
import com.ss.android.lark.flow.chat.page.flow.plugin.select.FlowMessageSelectPlugin$pullFollowingMessages$1;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import com.ss.android.lark.im.sdk.utils.ImSdkMessageUtils;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.mergeforward.ParseMergeForwardDataUtils$wrapCallback$1;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.parser.internal.ModelParserMessage;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.rustinfrabridge.capacity_insufficient.CapacityCallback;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import com.ss.android.lark.videosend.checker.raw.VideoPreCheckRawService;
import com.ss.android.lark.videosend.tools.CompressPathManager;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@UserScope
public final class ImSdkMessageServiceImplV2 implements p {
    public final com.ss.android.lark.im.sdk.message.f a;
    public final com.ss.android.lark.im.sdk.message.b b;
    public final com.bytedance.lark.rustclient.api.l c;
    public final CopyOnWriteArrayList<com.ss.android.lark.im.sdk.service.d> d;
    public final Lazy e;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SendStatus.values().length];
            r0[SendStatus.SENDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[SendStatus.FAIL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ String a;

        public c(String r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            p6b.d.a.a.a(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d<T, R> implements Function {
        public final /* synthetic */ ImSdkMessageServiceImplV2 a;
        public final /* synthetic */ List<String> b;

        public d(ImSdkMessageServiceImplV2 r1, List<String> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r4) {
            Intrinsics.checkNotNullParameter((com.bytedance.lark.rustclient.api.x) r4, "it");
            Map<String, Message> r5 = this.a.a(this.b);
            Iterator<T> r0 = r5.values().iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((Message) r0.next()).setRemoved(true);
            goto L4
        L6:
            return r5;
        }
    }

    public static final class e<T, R> implements Function {
        public final /* synthetic */ com.ss.android.lark.im.sdk.service.b a;

        public e(com.ss.android.lark.im.sdk.service.b r1) {
            this.a = r1;
        }

        public final Object apply(Object r10) {
            com.bytedance.lark.rustclient.api.x r11 = (com.bytedance.lark.rustclient.api.x) r10;
            Intrinsics.checkNotNullParameter(r11, "it");
            com.ss.android.lark.im.sdk.service.b r0 = this.a;
            String r1 = r0.a;
            GetUnreadElevatorJumpMessagesResponse r12 = (GetUnreadElevatorJumpMessagesResponse) r11.c;
            boolean r2 = r0.c;
            okb.h r3 = ModelParserMessage.a;
            ArrayList r4 = new ArrayList();
            if (r12 == null) goto L32;
            Entity r5 = r12.entity;
            if (r5 == null) goto L32;
            if (r5.messages == null) goto L32;
            com.ss.android.lark.chat.entity.chatter.a r6 = com.ss.android.lark.parser.internal.j.b(r5, r1);
            Iterator r7 = r12.ordered_message_ids.iterator();
        L11:
            if (r7.hasNext() == false) goto L31;
            long r8 = ((Long) r7.next()).longValue();
            com.bytedance.lark.pb.basic.v1.Message r9 = (com.bytedance.lark.pb.basic.v1.Message) r12.entity.messages.get(String.valueOf(r8));
            if (r9 == null) goto L11;
            if (TextUtils.equals(r1, r9.chat_id) == false) goto L11;
            Message r13 = ModelParserMessage.c(r12.entity, r9.id);
            if (r13 == null) goto L11;
            if (r2 == false) goto L30;
            Map r14 = r12.entity.threads;
            if (r14 == null) goto L30;
            if (r14.get(r13.getId()) == null) goto L30;
            Thread r15 = (Thread) r12.entity.threads.get(r13.getId());
            if (r13.getPosition() == r15.position.intValue()) goto L28;
            r13.setPosition(r15.position.intValue());
        L28:
            if (r13.getBadgeCount() == r15.badge_count.intValue()) goto L30;
            r13.setBadgeCount(r15.badge_count.intValue());
        L30:
            r4.add(new MessageInfo(r13, r6.b(r1, r13.getFromId())));
            goto L11
        L31:
            Collections.sort(r4);
        L32:
            return r4;
        }
    }

    public static final class f<T> implements ObservableOnSubscribe {
        public static final f<T> a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final void subscribe(ObservableEmitter<Map<String, Message>> r2) {
            Intrinsics.checkNotNullParameter(r2, "emitter");
            r2.onNext(MapsKt.emptyMap());
            r2.onComplete();
        }
    }

    public static final class g<T, R> implements Function {
        public final /* synthetic */ List<String> a;

        public g(List<String> r1) {
            this.a = r1;
        }

        public final Object apply(Object r5) {
            com.bytedance.lark.rustclient.api.x r6 = (com.bytedance.lark.rustclient.api.x) r5;
            Intrinsics.checkNotNullParameter(r6, "it");
            MGetMessagesResponse r7 = (MGetMessagesResponse) r6.c;
            HashMap r0 = new HashMap();
            if (r7 == null) goto L5;
            Entity r1 = r7.entity;
        L6:
            if (r1 == null) goto L16;
            Entity r8 = r7.entity;
            if (r8.messages == null) goto L16;
            Map r9 = ModelParserMessage.h(r8);
            Iterator<String> r2 = this.a.iterator();
        L11:
            if (r2.hasNext() == false) goto L16;
            LinkedHashMap r3 = (LinkedHashMap) r9;
            Message r4 = (Message) r3.get(r2.next());
            if (r4 == null) goto L11;
            Message r10 = (Message) r0.put(r4.getId(), r4);
        L16:
            return MapsKt.toMap(r0);
        L5:
            r1 = null;
            goto L6
        }
    }

    public static final class h implements Runnable {
        public final /* synthetic */ List<String> a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ImSdkMessageServiceImplV2 c;
        public final /* synthetic */ IGetDataCallback<Message> d;

        public static final class a<T, R> implements Function {
            public static final a<T, R> a = null;

            static {
                a = new a();
            }

            public a() {
            }

            public final Object apply(Object r6) {
                com.bytedance.lark.rustclient.api.x r7 = (com.bytedance.lark.rustclient.api.x) r6;
                Intrinsics.checkNotNullParameter(r7, "it");
                Entity r8 = ((GetQuasiMergeForwardMessageResponse) r7.c).entity;
                if (r8 != null) goto L5;
                return null;
            L5:
                if (r8.messages.keySet().contains("0") == false) goto L8;
                com.bytedance.lark.pb.basic.v1.Message r0 = (com.bytedance.lark.pb.basic.v1.Message) r8.messages.get("0");
            L31:
                return ModelParserMessage.f(r8, r0);
            L8:
                if (r8.messages.values().size() <= 1) goto L22;
                Iterator<T> r1 = r8.messages.values().iterator();
            L11:
                if (r1.hasNext() == false) goto L21;
                com.bytedance.lark.pb.basic.v1.Message r2 = (com.bytedance.lark.pb.basic.v1.Message) r1.next();
                if (r2.type == com.bytedance.lark.pb.basic.v1.Message.Type.MERGE_FORWARD) goto L15;
            L17:
                boolean r3 = false;
            L18:
                if (r3 == false) goto L11;
                r0 = r2;
                goto L31
            L15:
                if (r2.thread_message_type != com.bytedance.lark.pb.basic.v1.Message.ThreadMessageType.UNKNOWN_THREAD_MESSAGE) goto L17;
                r3 = true;
                goto L18
            L21:
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            L22:
                r0 = (com.bytedance.lark.pb.basic.v1.Message) CollectionsKt.first(r8.messages.values());
                goto L31
            }
        }

        public h(List<String> r1, String r2, ImSdkMessageServiceImplV2 r3, IGetDataCallback<Message> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            GetQuasiMergeForwardMessageRequest.Builder r3 = new GetQuasiMergeForwardMessageRequest.Builder().message_ids(this.a);
            if (qyb.a.a(this.b) == false) goto L5;
            r3.quasi_title(this.b);
        L5:
            Intrinsics.checkNotNull(r3);
            com.bytedance.lark.rustclient.api.d r0 = new com.bytedance.lark.rustclient.api.d(r3, GetQuasiMergeForwardMessageResponse.ADAPTER, Command.GET_QUASI_MERGE_FORWARD_MESSAGE, null, null, null, null, 248);
            com.ss.android.lark.im.sdk.utils.e.a(com.bytedance.lark.rustclient.api.t.b(this.c.c.h(r0).a()).map(a.a), this.d);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class i implements Runnable {
        public final /* synthetic */ Message a;
        public final /* synthetic */ MessageFoldDetail b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ ImSdkMessageServiceImplV2 d;

        public i(Message r1, MessageFoldDetail r2, boolean r3, ImSdkMessageServiceImplV2 r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            ArrayList r0 = new ArrayList();
            ArrayList r1 = new ArrayList();
            int r2 = this.a.getPosition();
            int r3 = this.a.getBadgeCount();
            if (this.a.getType() != Message.Type.AUDIO) goto L8;
            if (this.a.getMeReadType() >= 2) goto L10;
            r0.add(this.a.getId());
            this.a.setMeReadType(2);
        L10:
            MessageFoldDetail r4 = this.b;
            if (r4 == null) goto L18;
            Long r5 = StringsKt.toLongOrNull(r4.getFoldId());
            if (r5 == null) goto L15;
            long r7 = r5.longValue();
        L16:
            r1.add(Long.valueOf(r7));
            r2 = (int) RangesKt.coerceAtLeast(r4.getLastMessagePosition(), r2);
            r3 = (int) RangesKt.coerceAtLeast(r4.getLastMessageBadgeCount(), r3);
            goto L18
        L15:
            r7 = 0;
        L18:
            if ((!r0.isEmpty()) == false) goto L20;
        L21:
            Log.i("ImSdkMessageServiceImplV2", "readMessage maxPos: " + r2 + "  maxBadgeCount: " + r3 + " ids:" + r0);
            z.a r6 = new z.a();
            r6.a(this.a.getChannel());
            r6.b(r0);
            Intrinsics.checkNotNullParameter(r1, "foldIds");
            r6.c = r1;
            r6.d = r2;
            r6.e = r3;
            r6.g = this.c;
            this.d.yb(new z(r6));
            return;
        L20:
            if ((!r1.isEmpty()) == true) goto L21;
            return;
        L8:
            if (this.a.getMeReadType() >= 1) goto L10;
            r0.add(this.a.getId());
            this.a.setMeReadType(1);
            goto L10
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class j implements Runnable {
        public final /* synthetic */ ImSdkMessageServiceImplV2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ List<String> c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ IGetDataCallback<String> e;

        public static final class a extends MonitorMessageSendCallback {
            public final /* synthetic */ IGetDataCallback<String> r;
            public final /* synthetic */ ImSdkMessageServiceImplV2 s;

            public final /* bridge */ /* synthetic */ void g(Object r1) {
                u((o6b.b) r1);
            }

            public final void u(o6b.b r3) {
                Intrinsics.checkNotNullParameter(r3, "response");
                super.u(r3);
                IGetDataCallback<String> r0 = this.r;
                if (r0 == null) goto L5;
                r0.onSuccess(r3.b);
            L5:
                Iterator<com.ss.android.lark.im.sdk.service.d> r4 = this.s.d.iterator();
            L7:
                if (r4.hasNext() == false) goto L9;
                com.ss.android.lark.im.sdk.service.d r1 = r4.next();
                Message.Type r2 = Message.Type.UNKNOWN;
                r1.onSendSuccess();
                goto L7
            }

            public a(IGetDataCallback<String> r1, ImSdkMessageServiceImplV2 r2) {
                this.r = r1;
                this.s = r2;
            }

            public final void a(ErrorResult r2, Message r3) {
                Intrinsics.checkNotNullParameter(r2, "errorResult");
                Intrinsics.checkNotNullParameter(r3, "preMessage");
                super.a(r2, r3);
                IGetDataCallback<String> r4 = this.r;
                if (r4 == null) goto L5;
                r4.onError(r2);
            L5:
                Iterator<com.ss.android.lark.im.sdk.service.d> r5 = this.s.d.iterator();
            L7:
                if (r5.hasNext() == false) goto L9;
                com.ss.android.lark.im.sdk.service.d r6 = r5.next();
                Message.Type r0 = Message.Type.UNKNOWN;
                r6.onSendFailed();
                goto L7
            }
        }

        public j(ImSdkMessageServiceImplV2 r1, String r2, List<String> r3, boolean r4, IGetDataCallback<String> r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void a() {
            ImSdkMessageServiceImplV2 r0 = this.a;
            String r1 = this.b;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r1, "chatId");
            ChatService r2 = ChatService.c.a;
            if (r2.getLocalChat(r1) != null) goto L16;
        L6:
            int r3 = 0;
        L7:
            a r4 = new a(this.e, this.a);
            ((MonitorMessageSendCallback) r4).h = 14;
            CopyOnWriteArrayList<com.ss.android.lark.im.sdk.service.d> r5 = this.a.d;
            List<String> r6 = this.c;
            Iterator<com.ss.android.lark.im.sdk.service.d> r7 = r5.iterator();
        L9:
            if (r7.hasNext() == false) goto L13;
            com.ss.android.lark.im.sdk.service.d r8 = r7.next();
            int r9 = r6.size();
            int r10 = 0;
        L11:
            if (r10 >= r9) goto L9;
            Message.Type r11 = Message.Type.UNKNOWN;
            r8.a();
            r10 = r10 + 1;
            goto L11
        L13:
            e2b.h r12 = new e2b.h(this.b, this.c);
            r12.g = r3;
            r12.c = this.d;
            r12.j = r4;
            Biz r13 = Biz.Messenger;
            r12.i = Scene.Share;
            ImSdkService.f().P0().execute(new e2b.b(r12));
            return;
        L16:
            r3 = r2.h(r1);     // Catch: Throwable -> L15
            goto L7
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class k extends MonitorMessageSendCallback {
        public final /* synthetic */ IGetDataCallback<String> r;
        public final /* synthetic */ ImSdkMessageServiceImplV2 s;
        public final /* synthetic */ MessageParams<?, ?> t;

        public final /* bridge */ /* synthetic */ void g(Object r1) {
            u((o6b.b) r1);
        }

        public final void u(o6b.b r4) {
            Intrinsics.checkNotNullParameter(r4, "response");
            super.u(r4);
            IGetDataCallback<String> r0 = this.r;
            if (r0 == null) goto L5;
            r0.onSuccess(r4.b);
        L5:
            CopyOnWriteArrayList<com.ss.android.lark.im.sdk.service.d> r5 = this.s.d;
            MessageParams<?, ?> r1 = this.t;
            Iterator<com.ss.android.lark.im.sdk.service.d> r6 = r5.iterator();
        L7:
            if (r6.hasNext() == false) goto L9;
            com.ss.android.lark.im.sdk.service.d r2 = r6.next();
            Message.Type r3 = r1.e;
            r2.onSendSuccess();
            goto L7
        }

        public final void a(ErrorResult r3, Message r4) {
            Intrinsics.checkNotNullParameter(r3, "errorResult");
            Intrinsics.checkNotNullParameter(r4, INotificationHitPoint.NoticeType.MESSAGE);
            super.a(r3, r4);
            IGetDataCallback<String> r5 = this.r;
            if (r5 == null) goto L5;
            r5.onError(r3);
        L5:
            CopyOnWriteArrayList<com.ss.android.lark.im.sdk.service.d> r6 = this.s.d;
            MessageParams<?, ?> r7 = this.t;
            Iterator<com.ss.android.lark.im.sdk.service.d> r8 = r6.iterator();
        L7:
            if (r8.hasNext() == false) goto L9;
            com.ss.android.lark.im.sdk.service.d r0 = r8.next();
            Message.Type r1 = r7.e;
            r0.onSendFailed();
            goto L7
        }

        public k(IGetDataCallback<String> r1, ImSdkMessageServiceImplV2 r2, MessageParams<?, ?> r3, String r4) {
            this.r = r1;
            this.s = r2;
            this.t = r3;
            if (TextUtils.isEmpty(r4) == true) goto L6;
            ((MonitorMessageSendCallback) this).c = r4;
            return;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final Executor P0() {
        return (Executor) this.e.getValue();
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void Q5(String r11) {
        Intrinsics.checkNotNullParameter(r11, "cId");
        DeleteQuasiMessageRequest.Builder r2 = new DeleteQuasiMessageRequest.Builder().cid(r11);
        Intrinsics.checkNotNull(r2);
        com.bytedance.lark.rustclient.api.d r12 = new com.bytedance.lark.rustclient.api.d(r2, DeleteQuasiMessageResponse.ADAPTER, Command.DELETE_QUASI_MESSAGE, null, null, null, null, 248);
        com.bytedance.lark.rustclient.api.c r13 = this.c.h(r12).execute();
        if ((r13 instanceof com.bytedance.lark.rustclient.api.c) == false) goto L13;
        LarkError r14 = r13.c.b;
        if (r14 == null) goto L10;
        LarkError.ErrorDetails r15 = r14.details;
        if (r15 == null) goto L10;
        String r16 = r15.debug_message;
        if (r16 == null) goto L10;
    L11:
        Log.e("ImSdkMessageServiceImplV2", r16);
        return;
    L10:
        r16 = "error";
        goto L11
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final Map<String, MessageInfo> W5(final List<String> r11) {
        Intrinsics.checkNotNullParameter(r11, "messageIds");
        if (r11.isEmpty() == true) goto L5;
        MGetMessagesRequest.Builder r2 = new MGetMessagesRequest.Builder().message_ids(r11);
        Intrinsics.checkNotNull(r2);
        com.bytedance.lark.rustclient.api.d r0 = new com.bytedance.lark.rustclient.api.d(r2, MGetMessagesResponse.ADAPTER, Command.MGET_MESSAGES, null, null, null, null, 248);
        com.bytedance.lark.rustclient.api.x r12 = com.bytedance.lark.rustclient.api.t.e(this.c.h(r0).execute(), new ImSdkMessageServiceImplV2$getLocalMessageInfos$rustResponse$1(r11));
        if ((r12 instanceof com.bytedance.lark.rustclient.api.x) == false) goto L10;
        return (Map) r12.c;
    L10:
        if ((r12 instanceof com.bytedance.lark.rustclient.api.c) == false) goto L21;
        LarkError r13 = ((com.bytedance.lark.rustclient.api.c) r12).c.b;
        if (r13 == null) goto L17;
        LarkError.ErrorDetails r14 = r13.details;
        if (r14 == null) goto L17;
        String r15 = r14.debug_message;
        if (r15 == null) goto L17;
    L18:
        Log.e("ImSdkMessageServiceImplV2", r15);
        return MapsKt.emptyMap();
    L17:
        r15 = "error";
        goto L18
    L21:
        throw new NoWhenBranchMatchedException();
    L5:
        return MapsKt.emptyMap();
    }

    public final Map<String, Message> a(final List<String> r11) {
        Intrinsics.checkNotNullParameter(r11, "ids");
        if (r11.isEmpty() == true) goto L21;
        MGetMessagesRequest.Builder r2 = new MGetMessagesRequest.Builder().message_ids(r11);
        Intrinsics.checkNotNull(r2);
        com.bytedance.lark.rustclient.api.d r0 = new com.bytedance.lark.rustclient.api.d(r2, MGetMessagesResponse.ADAPTER, Command.MGET_MESSAGES, null, null, null, null, 248);
        com.bytedance.lark.rustclient.api.x r12 = com.bytedance.lark.rustclient.api.t.e(this.c.h(r0).execute(), new ImSdkMessageServiceImplV2$innerSyncGetMessages$rustResponse$1(r11));
        if ((r12 instanceof com.bytedance.lark.rustclient.api.x) == false) goto L9;
        return (Map) r12.c;
    L9:
        if ((r12 instanceof com.bytedance.lark.rustclient.api.c) == false) goto L20;
        LarkError r13 = ((com.bytedance.lark.rustclient.api.c) r12).c.b;
        if (r13 == null) goto L16;
        LarkError.ErrorDetails r14 = r13.details;
        if (r14 == null) goto L16;
        String r15 = r14.debug_message;
        if (r15 == null) goto L16;
    L17:
        Log.e("ImSdkMessageServiceImplV2", r15);
        return MapsKt.emptyMap();
    L16:
        r15 = "error";
        goto L17
    L20:
        throw new NoWhenBranchMatchedException();
    L21:
        return MapsKt.emptyMap();
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void ac(String r13) {
        Intrinsics.checkNotNullParameter(r13, "messageId");
        Long r0 = StringsKt.toLongOrNull(r13);
        boolean r1 = false;
        if (r0 != null) goto L5;
    L10:
        String r2 = "error";
        if (r1 == false) goto L24;
        UpdateLocalSystemMessageVisibilityRequest.Builder r4 = new UpdateLocalSystemMessageVisibilityRequest.Builder().local_message_id(r13).visible(Boolean.FALSE);
        Intrinsics.checkNotNull(r4);
        com.bytedance.lark.rustclient.api.d r14 = new com.bytedance.lark.rustclient.api.d(r4, UpdateLocalSystemMessageVisibilityResponse.ADAPTER, Command.UPDATE_LOCAL_SYSTEM_MESSAGE_VISIBILITY, null, null, null, null, 248);
        com.bytedance.lark.rustclient.api.c r15 = this.c.h(r14).execute();
        if ((r15 instanceof com.bytedance.lark.rustclient.api.c) == false) goto L36;
        LarkError r16 = r15.c.b;
        if (r16 == null) goto L22;
        LarkError.ErrorDetails r17 = r16.details;
        if (r17 == null) goto L22;
        String r18 = r17.debug_message;
        if (r18 == null) goto L22;
        r2 = r18;
    L22:
        Log.e("ImSdkMessageServiceImplV2", r2);
        return;
    L36:
        return;
    L24:
        DeleteEphemeralMessageRequest.Builder r5 = new DeleteEphemeralMessageRequest.Builder().message_id(r13);
        Intrinsics.checkNotNull(r5);
        com.bytedance.lark.rustclient.api.d r19 = new com.bytedance.lark.rustclient.api.d(r5, DeleteEphemeralMessageResponse.ADAPTER, Command.DELETE_EPHEMERAL_MESSAGE, null, null, null, null, 248);
        com.bytedance.lark.rustclient.api.c r110 = this.c.h(r19).execute();
        if ((r110 instanceof com.bytedance.lark.rustclient.api.c) == false) goto L37;
        LarkError r111 = r110.c.b;
        if (r111 == null) goto L34;
        LarkError.ErrorDetails r112 = r111.details;
        if (r112 == null) goto L34;
        String r113 = r112.debug_message;
        if (r113 == null) goto L34;
        r2 = r113;
    L34:
        Log.e("ImSdkMessageServiceImplV2", r2);
        return;
    L37:
        return;
    L5:
        if (r0.longValue() >= 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 != true) goto L10;
        r1 = true;
        goto L10
    L7:
        r3 = false;
        goto L8
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final Map<String, Message> ie(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "ids");
        Object r3 = b(r2, SyncDataStrategy.FORCE_SERVER).blockingFirst();     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r3);     // Catch: Throwable -> L5
        return (Map) r3;
    L5:
        th = move-exception;
        Log.e("ImSdkMessageServiceImplV2", String.valueOf(th));
        return MapsKt.emptyMap();
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void j6(a0 r19) {
        Intrinsics.checkNotNullParameter(r19, "param");
        if (r19.a.isEmpty() == true) goto L5;
    L8:
        String r4 = "";
        if (r19.e == false) goto L20;
        Message r2 = r19.f;
        if (r2 != null) goto L14;
        Log.e("ImSdkMessageServiceImplV2", "clearBadgeOnly, but clearBadgeMessage is null");
        return;
    L14:
        Log.i("ImSdkMessageServiceImplV2", "clearBadgeOnly send sdk message ids is empty, max position " + r19.b(r2));
        z.a r3 = new z.a();
        r3.a(r2.getChannel());
        r3.b(CollectionsKt.emptyList());
        r3.d = r19.b(r2);
        r3.e = r19.a(r2);
        String r5 = r19.c;
        if (r5 == null) goto L18;
        r4 = r5;
    L18:
        Intrinsics.checkNotNullParameter(r4, "threadId");
        r3.f = r4;
        r3.g = r19.d;
        yb(new z(r3));
        com.ss.android.lark.im.sdk.statistics.b.d(CollectionsKt.emptyList(), ImSdkProxy.e().getCurrentUserId());
        return;
    L20:
        ArrayList r6 = new ArrayList();
        ArrayList r7 = new ArrayList();
        HashSet r8 = new HashSet();
        Iterator<MessageInfo> r9 = r19.a.iterator();
        int r10 = Target.SIZE_ORIGINAL;
        int r11 = Target.SIZE_ORIGINAL;
    L22:
        if (r9.hasNext() == false) goto L45;
        MessageInfo r12 = r9.next();
        Message r14 = r12.getMessage();
        r10 = RangesKt.coerceAtLeast(r19.b(r14), r10);
        r11 = RangesKt.coerceAtLeast(r19.a(r14), r11);
        if (r14.isPreMessage() == true) goto L35;
        Lazy r15 = ImSdkMessageUtils.a;
        Intrinsics.checkNotNullParameter(r14, INotificationHitPoint.NoticeType.MESSAGE);
        if (r14.getType() == Message.Type.AUDIO) goto L28;
        boolean r13 = true;
    L29:
        if (r13 == false) goto L35;
        if (r14.isFromMe() == true) goto L35;
        if (r14.getMeReadType() > 0) goto L35;
        r6.add(r14.getId());
        r7.add(r14);
    L36:
        MessageFoldDetail r16 = r12.getMessageFoldDetail();
        if (r16 == null) goto L22;
        Long r17 = StringsKt.toLongOrNull(r16.getFoldId());
        if (r17 != null) goto L41;
    L43:
        r10 = (int) RangesKt.coerceAtLeast(r10, r16.getLastMessagePosition());
        r11 = (int) RangesKt.coerceAtLeast(r11, r16.getLastMessageBadgeCount());
        goto L22
    L41:
        if (r17.longValue() == 0) goto L43;
        r8.add(r17);
        goto L43
    L28:
        r13 = false;
    L35:
        Log.i("ImSdkMessageServiceImplV2", "readMessage but message is invalid:" + r14);
        goto L36
    L45:
        if ((!r6.isEmpty()) == false) goto L47;
    L52:
        Log.i("ImSdkMessageServiceImplV2", "readMessage maxPos: " + r10 + "  maxBadgeCount: " + r11 + " ids:" + r6 + " foldIds: " + r8);
        Message r18 = ((MessageInfo) ListProtector.get(r19.a, 0)).getMessage();
        z.a r20 = new z.a();
        r20.a(r18.getChannel());
        r20.b(r6);
        ArrayList r21 = new ArrayList(r8);
        Intrinsics.checkNotNullParameter(r21, "foldIds");
        r20.c = r21;
        r20.d = r10;
        r20.e = r11;
        String r22 = r19.c;
        if (r22 == null) goto L56;
        r4 = r22;
    L56:
        Intrinsics.checkNotNullParameter(r4, "threadId");
        r20.f = r4;
        r20.g = r19.d;
        yb(new z(r20));
        com.ss.android.lark.im.sdk.statistics.b.d(new ArrayList(r7), ImSdkProxy.e().getCurrentUserId());
        return;
    L47:
        if (r10 > r19.b) goto L52;
        if ((!r8.isEmpty()) == true) goto L52;
        Log.i("ImSdkMessageServiceImplV2", "needRedMessageIds is empty, maxPosition:" + r10 + ", lastReadPosition:" + r19.b);
        return;
    L5:
        if (r19.e == true) goto L8;
        Log.i("ImSdkMessageServiceImplV2", "readMessage, messages is empty");
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void mb(String r11) {
        Intrinsics.checkNotNullParameter(r11, "cId");
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new c(r11));
        UploadFilesRequest.Builder r2 = new UploadFilesRequest.Builder().action(UploadFilesRequest.Action.CANCEL).cids(CollectionsKt.listOf(r11)).type(File.EntityType.MESSAGE);
        Intrinsics.checkNotNull(r2);
        com.bytedance.lark.rustclient.api.d r12 = new com.bytedance.lark.rustclient.api.d(r2, UploadFilesResponse.ADAPTER, Command.UPLOAD_FILES, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.a(com.bytedance.lark.rustclient.api.t.b(this.c.h(r12).a()), new CapacityCallback());
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final MessageInfo p(String r13) {
        Intrinsics.checkNotNullParameter(r13, "messageId");
        List r0 = CollectionsKt.listOf(r13);
        SyncDataStrategy r1 = SyncDataStrategy.TRY_LOCAL;
        if (r0.isEmpty() == false) goto L5;
        Observable r2 = Observable.create(s.a);
    L11:
        return (MessageInfo) ((Map) r2.blockingFirst()).get(r13);
    L8:
        th = move-exception;
        Log.e("ImSdkMessageServiceImplV2", String.valueOf(th));
        return null;
    L5:
        MGetMessagesRequest.Builder r4 = new MGetMessagesRequest.Builder().message_ids(r0).sync_data_strategy(r1);
        Intrinsics.checkNotNull(r4);
        com.bytedance.lark.rustclient.api.d r3 = new com.bytedance.lark.rustclient.api.d(r4, MGetMessagesResponse.ADAPTER, Command.MGET_MESSAGES, null, null, null, null, 248);
        r2 = com.bytedance.lark.rustclient.api.t.b(this.c.h(r3).a()).map(new t(r0));
        goto L11
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final Map<String, Message> ta(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "ids");
        Object r3 = b(r2, SyncDataStrategy.TRY_LOCAL).blockingFirst();     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r3);     // Catch: Throwable -> L5
        return (Map) r3;
    L5:
        th = move-exception;
        Log.e("ImSdkMessageServiceImplV2", String.valueOf(th));
        return MapsKt.emptyMap();
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final ChatMessageResponse x2(final com.ss.android.lark.im.sdk.service.a r16) {
        Intrinsics.checkNotNullParameter(r16, "param");
        m6b.v r1 = m6b.v.a.a;
        if (r1.a == false) goto L5;
        boolean r2 = true;
        ChatMessageResponse r4 = null;
    L11:
        if (r16.a.length() != 0) goto L13;
        boolean r3 = true;
    L14:
        if (r3 == true) goto L16;
        GetChatMessagesRequest.Builder r7 = new GetChatMessagesRequest.Builder().chat_id(r16.a).scene(ChannelDataScene.fromValue(r16.b.getNumber())).count(Integer.valueOf(r16.d)).redundancy_count(Integer.valueOf(r16.e)).position(Integer.valueOf(r16.c)).preload_count(Integer.valueOf(r16.f)).need_response(Boolean.valueOf(r16.g)).strategy(ChannelDataIncompleteStrategy.fromValue(r16.h.getNumber()));
        m6b.v.a.a.getClass();
        if (r16.b != MessageFetchScene.FIRST_SCREEN) goto L20;
        boolean r5 = true;
    L22:
        if (r5 == false) goto L24;
        int r6 = m6b.v.a();
        Log.i("ImSdkMessageServiceImplV2", "set display weight, max weight=" + r6);
        r7.weights_for_filter(Integer.valueOf(r6));
    L24:
        String r8 = r16.i;
        if (r8 != null) goto L27;
    L30:
        if (r2 == true) goto L36;
        String r9 = r16.i;
        if (r9 == null) goto L35;
    L37:
        Intrinsics.checkNotNull(r7);
        com.bytedance.lark.rustclient.api.x r0 = com.bytedance.lark.rustclient.api.t.e(this.c.h(new com.bytedance.lark.rustclient.api.d(r7, GetChatMessagesResponse.ADAPTER, Command.GET_CHAT_MESSAGES, r9, new com.ss.android.lark.sdk.h(), null, null, 208)).execute(), new ImSdkMessageServiceImplV2$getChatMessages$rustResponse$1(r16));
        if ((r0 instanceof com.bytedance.lark.rustclient.api.x) == false) goto L41;
        return (ChatMessageResponse) r0.c;
    L41:
        if ((r0 instanceof com.bytedance.lark.rustclient.api.c) == false) goto L52;
        LarkError r10 = ((com.bytedance.lark.rustclient.api.c) r0).c.b;
        if (r10 == null) goto L48;
        LarkError.ErrorDetails r11 = r10.details;
        if (r11 == null) goto L48;
        String r12 = r11.debug_message;
        if (r12 == null) goto L48;
    L49:
        Log.e("ImSdkMessageServiceImplV2", r12);
        return r4;
    L48:
        r12 = "error";
        goto L49
    L52:
        throw new NoWhenBranchMatchedException();
    L35:
        throw new IllegalStateException("Required value was null.".toString());
    L36:
        r9 = com.ss.android.lark.sdk.a.a();
        Intrinsics.checkNotNull(r9);
        goto L37
    L27:
        if (r8.length() == 0) goto L30;
        r2 = false;
        goto L30
    L20:
        r5 = false;
        goto L22
    L16:
        return new ChatMessageResponse();
    L13:
        r3 = false;
        goto L14
    L5:
        SetDataDisplayWeightRequest.Builder r13 = new SetDataDisplayWeightRequest.Builder();
        HashMap r14 = new HashMap(3);
        Integer r15 = Integer.valueOf(SetDataDisplayWeightRequest.DataType.CHAT_MESSAGE.getValue());
        int r17 = UIHelper.dp2px(0.0f);
        SetDataDisplayWeightRequest.DisplayWeight.Builder r18 = new SetDataDisplayWeightRequest.DisplayWeight.Builder();
        HashMap r19 = new HashMap();
        Iterator r110 = ((HashMap) r1.b).entrySet().iterator();
    L7:
        if (r110.hasNext() == false) goto L9;
        Map.Entry r111 = (Map.Entry) r110.next();
        r19.put((Integer) r111.getKey(), Double.valueOf(((Double) r111.getValue()).doubleValue() + ((double) r17)));
        goto L7
    L9:
        r18.type2weights(r19);
        HashMap r20 = new HashMap();
        r20.put(Integer.valueOf(com.bytedance.lark.pb.basic.v1.Message.Type.TEXT.getValue()), Double.valueOf(6.0d));
        r20.put(Integer.valueOf(com.bytedance.lark.pb.basic.v1.Message.Type.POST.getValue()), Double.valueOf(6.0d));
        r18.type2max_weights(r20);
        r14.put(r15, r18.build());
        r13.data_display_weights(r14);
        r4 = null;
        SdkSender.asynSendRequestNonWrap(Command.SET_DATA_DISPLAY_WEIGHT, r13, null, null);
        r2 = true;
        r1.a = true;
        goto L11
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void yb(z r12) {
        Intrinsics.checkNotNullParameter(r12, "params");
        List<String> r0 = r12.b;
        if (r12.g == false) goto L5;
        r0 = CollectionsKt.emptyList();
    L5:
        UpdateMessagesMeReadRequest.Builder r3 = new UpdateMessagesMeReadRequest.Builder().channel(com.ss.android.lark.parser.internal.g.b(r12.a)).message_ids(r0);
        boolean r1 = false;
        if (TextUtils.isEmpty(r12.f) == true) goto L8;
        r3.thread_id(r12.f).thread_max_position(Integer.valueOf(r12.d)).thread_max_position_badge_count(Integer.valueOf(r12.e)).max_position(0).max_position_badge_count(0);
    L9:
        List<Long> r2 = r12.c;
        if (r2 != null) goto L12;
    L13:
        r1 = true;
    L14:
        if (r1 == false) goto L16;
        r3.fold_ids(CollectionsKt.emptyList());
    L17:
        Intrinsics.checkNotNull(r3);
        com.bytedance.lark.rustclient.api.d r4 = new com.bytedance.lark.rustclient.api.d(r3, UpdateMessagesMeReadResponse.ADAPTER, Command.UPDATE_MESSAGES_ME_READ, null, null, null, null, 248);
        Observable r13 = com.bytedance.lark.rustclient.api.t.b(this.c.h(r4).a()).map(new v(r12));
        Intrinsics.checkNotNull(r13);
        final IGetDataCallback r5 = null;
        com.ss.android.lark.im.sdk.utils.e.a(r13, new ImSdkMessageServiceImplV2$readMessageForChannel$1(r5));
        return;
    L16:
        r3.fold_ids(r12.c);
        goto L17
    L12:
        if (r2.isEmpty() == false) goto L14;
    L8:
        r3.max_position(Integer.valueOf(r12.d)).max_position_badge_count(Integer.valueOf(r12.e));
        goto L9
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final Message za(String r2) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        return a(CollectionsKt.listOf(r2)).get(r2);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void Fe(List<String> r2, IGetDataCallback<Map<String, Message>> r3) {
        Intrinsics.checkNotNullParameter(r2, "ids");
        Intrinsics.checkNotNullParameter(r3, "callback");
        com.ss.android.lark.im.sdk.utils.e.a(b(r2, SyncDataStrategy.TRY_LOCAL), r3);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.ss.android.lark.im.sdk.service.ImSdkMessageServiceImplV2$resendMessage$reSendMessageCallback$1, java.lang.Object] */
    @Override // com.ss.android.lark.im.sdk.service.p
    public final void X3(final Message r7, final IGetDataCallback<String> r8) {
        Intrinsics.checkNotNullParameter(r7, INotificationHitPoint.NoticeType.MESSAGE);
        Intrinsics.checkNotNullParameter(r8, "callback");
        Log.i("ImSdkMessageServiceImplV2", "resendMessage with Message");
        ?? r2 = new ImSdkMessageServiceImplV2$resendMessage$reSendMessageCallback$1(r8, this, r7);
        Iterator<com.ss.android.lark.im.sdk.service.d> r9 = this.d.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        com.ss.android.lark.im.sdk.service.d r3 = r9.next();
        r7.getType();
        r3.a();
        goto L4
    L6:
        com.ss.android.lark.im.sdk.message.b r10 = this.b;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r7, INotificationHitPoint.NoticeType.MESSAGE);
        Intrinsics.checkNotNullParameter(r2, "callback");
        String r0 = r7.getcId();
        Message.Type r1 = r7.getType();
        int r4 = com.ss.android.lark.im.sdk.a.a;
        com.ss.android.lark.im.sdk.a.b(r10.e, "resendMessage in chat: " + r7.getChatId() + ", cId is " + r0 + ", message type is " + r1);
        com.ss.android.lark.im.sdk.message.resend.h r5 = new com.ss.android.lark.im.sdk.message.resend.h(r7, r2);
        com.ss.android.lark.im.sdk.message.resend.i r11 = (com.ss.android.lark.im.sdk.message.resend.i) ((Map) r10.c.getValue()).get(r1);
        if (r11 != null) goto L9;
        com.ss.android.lark.im.sdk.a.b(r10.e, "use common message resend pipeline for message type: " + r1);
        r11 = (com.ss.android.lark.im.sdk.message.resend.i) r10.d.getValue();
    L9:
        com.ss.android.lark.im.sdk.a.b(r10.e, "submit runnable to messageSendExecutor, cId is " + r0);
        ImSdkService.f().P0().execute(new com.ss.android.lark.im.sdk.message.a(r10, r0, r11, r5));
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void Z8(List r2, ParseMergeForwardDataUtils$wrapCallback$1 r3) {
        Intrinsics.checkNotNullParameter(r2, "messages");
        Intrinsics.checkNotNullParameter(r3, "callback");
        RxScheduledExecutor.justInIO(new u(r2, this, r3));
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void a7(p0 r5, MonitorMessageSendCallback r6) {
        Intrinsics.checkNotNullParameter(r5, "messageParams");
        Log.i("ImSdkMessageServiceImplV2", "sendLocalPreMessage");
        com.ss.android.lark.im.sdk.message.f r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "messageParams");
        int r0 = com.ss.android.lark.im.sdk.a.a;
        com.ss.android.lark.im.sdk.a.b(r1.p, "sendLocalPreMessage in chat: " + ((MessageParams) r5).c + ", message type is " + ((MessageParams) r5).e);
        if (r6 != null) goto L5;
        r6 = new MonitorMessageSendCallback();
    L5:
        com.ss.android.lark.im.sdk.message.send.k r2 = new com.ss.android.lark.im.sdk.message.send.k(r5, r6);
        com.ss.android.lark.im.sdk.a.b(r1.p, "submit runnable to messageSendExecutor, cId is " + ((MessageParams) r5).d);
        ImSdkService.f().P0().execute(new com.ss.android.lark.im.sdk.message.d(r1, r5, r2));
    }

    public final Observable<Map<String, Message>> b(List<String> r11, SyncDataStrategy r12) {
        if (r11.isEmpty() == true) goto L5;
        MGetMessagesRequest.Builder r2 = new MGetMessagesRequest.Builder().message_ids(r11).sync_data_strategy(r12);
        Intrinsics.checkNotNull(r2);
        com.bytedance.lark.rustclient.api.d r13 = new com.bytedance.lark.rustclient.api.d(r2, MGetMessagesResponse.ADAPTER, Command.MGET_MESSAGES, null, null, null, null, 248);
        return com.bytedance.lark.rustclient.api.t.b(this.c.h(r13).a()).map(new g(r11));
    L5:
        return Observable.create(f.a);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void e8(com.ss.android.lark.im.sdk.service.b r14, IGetDataCallback<List<MessageInfo>> r15) {
        Intrinsics.checkNotNullParameter(r14, "param");
        Intrinsics.checkNotNullParameter(r15, "callback");
        GetUnreadDoubaoReplyMessagesRequest.Builder r0 = new GetUnreadDoubaoReplyMessagesRequest.Builder();
        Long r1 = StringsKt.toLongOrNull(r14.a);
        long r2 = 0;
        if (r1 == null) goto L5;
        long r4 = r1.longValue();
    L6:
        GetUnreadDoubaoReplyMessagesRequest.Builder r5 = r0.chat_id(Long.valueOf(r4));
        String r3 = r14.b;
        if (r3 != null) goto L9;
    L12:
        boolean r6 = true;
    L13:
        if (r6 == true) goto L18;
        Long r7 = StringsKt.toLongOrNull(r3);
        if (r7 == null) goto L17;
        r2 = r7.longValue();
    L17:
        r5.thread_id(Long.valueOf(r2));
    L18:
        Intrinsics.checkNotNull(r5);
        com.ss.android.lark.im.sdk.utils.e.a(com.bytedance.lark.rustclient.api.t.b(this.c.h(new com.bytedance.lark.rustclient.api.d(r5, GetUnreadElevatorJumpMessagesResponse.ADAPTER, Command.GET_UNREAD_ELEVATOR_JUMP_MESSAGES, null, null, null, null, 248)).a()).map(new e(r14)), r15);
        return;
    L9:
        if (r3.length() == 0) goto L12;
        r6 = false;
        goto L13
    L5:
        r4 = 0;
        goto L6
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void f1(String r10, SendStatus r11) {
        Intrinsics.checkNotNullParameter(r10, "cId");
        Intrinsics.checkNotNullParameter(r11, "sendStatus");
        Log.i("ImSdkMessageServiceImplV2", "updatePreMessageSendStatus");
        int r1 = b.a[r11.ordinal()];
        if (r1 != 1) goto L5;
        QuasiMessage.Status r12 = QuasiMessage.Status.PENDING;
    L10:
        UpdateQuasiMessageRequest.Builder r2 = new UpdateQuasiMessageRequest.Builder().cid(r10).status(r12);
        Intrinsics.checkNotNull(r2);
        this.c.h(new com.bytedance.lark.rustclient.api.d(r2, UpdateQuasiMessageResponse.ADAPTER, Command.UPDATE_QUASI_MESSAGE, null, null, null, null, 248)).execute();
        return;
    L5:
        if (r1 == 2) goto L8;
        Log.e("ImSdkMessageServiceImplV2", "can't set quasiMessage with other status, status: " + r11.name());
        return;
    L8:
        r12 = QuasiMessage.Status.FAILED;
        goto L10
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final ChatMessageResponse fd(final String r11, final List<Integer> r12) {
        Intrinsics.checkNotNullParameter(r11, "chatId");
        Intrinsics.checkNotNullParameter(r12, "positions");
        GetMessagesByPositionsRequest.Builder r2 = new GetMessagesByPositionsRequest.Builder().channel(new Channel.Builder().id(r11).type(Channel.Type.CHAT).build()).positions(r12);
        Intrinsics.checkNotNull(r2);
        com.bytedance.lark.rustclient.api.d r0 = new com.bytedance.lark.rustclient.api.d(r2, GetMessagesByPositionsResponse.ADAPTER, Command.GET_MESSAGES_BY_POSITIONS, null, null, null, null, 248);
        com.bytedance.lark.rustclient.api.x r13 = com.bytedance.lark.rustclient.api.t.e(this.c.h(r0).execute(), new ImSdkMessageServiceImplV2$getMessagesByPositions$rustResponse$1(r12, r11));
        if ((r13 instanceof com.bytedance.lark.rustclient.api.x) == false) goto L6;
        return (ChatMessageResponse) r13.c;
    L6:
        if ((r13 instanceof com.bytedance.lark.rustclient.api.c) == false) goto L17;
        LarkError r14 = ((com.bytedance.lark.rustclient.api.c) r13).c.b;
        if (r14 == null) goto L13;
        LarkError.ErrorDetails r15 = r14.details;
        if (r15 == null) goto L13;
        String r16 = r15.debug_message;
        if (r16 == null) goto L13;
    L14:
        Log.e("ImSdkMessageServiceImplV2", r16);
        return new ChatMessageResponse(CollectionsKt.emptyList(), CollectionsKt.emptyList());
    L13:
        r16 = "error";
        goto L14
    L17:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void ib(MessageParams r14, MonitorMessageSendCallback r15) {
        Intrinsics.checkNotNullParameter(r14, "messageParams");
        Intrinsics.checkNotNullParameter(r15, "callback");
        Log.i("ImSdkMessageServiceImplV2", "sendMessage with MonitorMessageSendCallback");
        boolean r0 = n0.a;
        boolean r1 = false;
        if ((r14 instanceof t0) == false) goto L22;
        t0 r2 = (t0) r14;
        java.io.File r3 = r2.D;
        if (r3 == null) goto L8;
        String r4 = r3.getPath();
        if (r4 == null) goto L8;
    L9:
        String r5 = r2.F;
        if (r5 != null) goto L12;
    L15:
        boolean r6 = true;
    L16:
        if (r6 == false) goto L19;
        r2.F = CompressPathManager.generateCommonCompressFilePath(r4);
    L19:
        if (VideoPreCheckRawService.b(r4, CompressPathManager.isOriginMode(r2.F)) == false) goto L21;
        r2.F = r4;
    L21:
        Log.i("MessageUtils", "onBeforeSendMessage, compressPath:" + r2.F);
        z0.i(r2.F);
        goto L22
    L12:
        if (r5.length() == 0) goto L15;
        r6 = false;
    L8:
        r4 = "";
    L22:
        Iterator<com.ss.android.lark.im.sdk.service.d> r7 = this.d.iterator();
    L24:
        if (r7.hasNext() == false) goto L26;
        com.ss.android.lark.im.sdk.service.d r8 = r7.next();
        Message.Type r9 = r14.e;
        r8.a();
        goto L24
    L26:
        r15.p(new w(r15, this, r14));
        com.ss.android.lark.im.sdk.message.f r10 = this.a;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r14, "messageParams");
        int r11 = com.ss.android.lark.im.sdk.a.a;
        com.ss.android.lark.im.sdk.a.b(r10.p, "sendMessage in chat: " + r14.c + ", message type is " + r14.e);
        com.ss.android.lark.im.sdk.message.send.k r12 = new com.ss.android.lark.im.sdk.message.send.k(r14, r15);
        Long r13 = r14.w;
        if (r13 == null) goto L39;
        long r16 = r13.longValue();
        Object r17 = com.ss.android.lark.im.sdk.message.send.m.a;
        monitor-enter(r17);
        Map<Long, com.ss.android.lark.im.sdk.message.send.m.a> r18 = com.ss.android.lark.im.sdk.message.send.m.b;     // Catch: Throwable -> L36
        Long r19 = Long.valueOf(r16);     // Catch: Throwable -> L36
        LinkedHashMap r20 = (LinkedHashMap) r18;     // Catch: Throwable -> L36
        Object r21 = r20.get(r19);     // Catch: Throwable -> L36
        if (r21 != null) goto L33;
        r21 = new com.ss.android.lark.im.sdk.message.send.m.a(null);     // Catch: Throwable -> L36
        r20.put(r19, r21);     // Catch: Throwable -> L36
    L33:
        com.ss.android.lark.im.sdk.message.send.m.a r22 = (com.ss.android.lark.im.sdk.message.send.m.a) r21;     // Catch: Throwable -> L36
        long r23 = r22.a;     // Catch: Throwable -> L36
        r22.a = 1 + r23;     // Catch: Throwable -> L36
        monitor-exit(r17);
        r12.e = Long.valueOf(r23);
    L36:
        th = move-exception;
        throw th;
    L39:
        Message.Type r24 = r14.e;
        com.ss.android.lark.im.sdk.message.send.l r25 = (com.ss.android.lark.im.sdk.message.send.l) ((Map) r10.h.getValue()).get(r24);
        if (r25 != null) goto L43;
        com.ss.android.lark.im.sdk.a.b(r10.p, "use common message send pipeline for message type: " + r24);
        r25 = (com.ss.android.lark.im.sdk.message.send.l) r10.k.getValue();
    L43:
        if (r14.e != Message.Type.MEDIA) goto L50;
        if ((r14 instanceof t0) == false) goto L50;
        if (((t0) r14).L != true) goto L50;
        Log.i(r10.p, "filterStep, hit media, skipMediaCompressStep");
        r25 = (com.ss.android.lark.im.sdk.message.send.l) r10.i.getValue();
    L54:
        com.ss.android.lark.im.sdk.message.send.l r26 = r25;
        String r27 = r14.l;
        if (r27 != null) goto L57;
    L58:
        r1 = true;
    L59:
        if (r1 == false) goto L61;
        r15.v(null, null, r24);
    L61:
        com.ss.android.lark.im.sdk.a.b(r10.p, "submit runnable to messageSendExecutor, cId is " + r14.d);
        ImSdkService.f().P0().execute(new com.ss.android.lark.im.sdk.message.e(r10, r14, r15, r26, r12));
        return;
    L57:
        if (r27.length() != 0) goto L59;
    L50:
        if ((r14 instanceof com.ss.android.lark.biz.im.api.l) == false) goto L54;
        if (((com.ss.android.lark.biz.im.api.l) r14).K == null) goto L54;
        Log.i(r10.p, "filterStep, hit doubao remote file");
        r25 = (com.ss.android.lark.im.sdk.message.send.l) r10.j.getValue();
        goto L54
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void k7(List<String> r11, IGetDataCallback<Map<String, Message>> r12) {
        Intrinsics.checkNotNullParameter(r11, "ids");
        Intrinsics.checkNotNullParameter(r12, "callback");
        DeleteMessagesRequest.Builder r2 = new DeleteMessagesRequest.Builder().ids(r11);
        Intrinsics.checkNotNull(r2);
        com.bytedance.lark.rustclient.api.d r0 = new com.bytedance.lark.rustclient.api.d(r2, DeleteMessagesResponse.ADAPTER, Command.DELETE_MESSAGES, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.a(com.bytedance.lark.rustclient.api.t.b(this.c.h(r0).a()).map(new d(this, r11)), r12);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void l9(final Message.b r6, final IGetDataCallback<String> r7) {
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r7, "callback");
        Log.i("ImSdkMessageServiceImplV2", "callSdkSendMessage");
        Iterator<com.ss.android.lark.im.sdk.service.d> r2 = this.d.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r2.next().a();
        goto L4
    L6:
        IGetDataCallback<String> r3 = new ImSdkMessageServiceImplV2$callSdkSendMessage$wrapperCallback$1(r7, this, r6);
        com.ss.android.lark.im.sdk.message.f r8 = this.a;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r3, "callback");
        int r0 = com.ss.android.lark.im.sdk.a.a;
        com.ss.android.lark.im.sdk.a.b(r8.p, "callSdkSendMessage");
        r8.s.b(r6, r3);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void p2(final Message.b r6, final IGetDataCallback<String> r7) {
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r7, "callback");
        Log.i("ImSdkMessageServiceImplV2", "resendMessage with SendMessageParams");
        Iterator<com.ss.android.lark.im.sdk.service.d> r2 = this.d.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r2.next().a();
        goto L4
    L6:
        IGetDataCallback<String> r3 = new ImSdkMessageServiceImplV2$resendMessage$wrapperCallback$1(r7, this, r6);
        com.ss.android.lark.im.sdk.message.b r8 = this.b;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r3, "callback");
        int r0 = com.ss.android.lark.im.sdk.a.a;
        com.ss.android.lark.im.sdk.a.b(r8.e, "resendMessage with SendMessageParams");
        r8.f.d(r6, r3);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void sendMessage(MessageParams<?, ?> r4, IGetDataCallback<String> r5) {
        Intrinsics.checkNotNullParameter(r4, "messageParams");
        Log.i("ImSdkMessageServiceImplV2", "sendMessage with original callback");
        Iterator<com.ss.android.lark.im.sdk.service.d> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        com.ss.android.lark.im.sdk.service.d r1 = r0.next();
        Message.Type r2 = r4.e;
        r1.a();
        goto L4
    L6:
        ib(r4, new k(r5, this, r4, r4.l));
    }

    @Inject
    public ImSdkMessageServiceImplV2(com.ss.android.lark.im.sdk.message.f r2, com.ss.android.lark.im.sdk.message.b r3, com.bytedance.lark.rustclient.api.l r4) {
        Intrinsics.checkNotNullParameter(r2, "sendMessagePipelines");
        Intrinsics.checkNotNullParameter(r3, "resendMessagePipelines");
        Intrinsics.checkNotNullParameter(r4, "rustClient");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = new CopyOnWriteArrayList();
        Log.i("ImSdkMessageServiceImplV2", "init");
        this.e = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, ImSdkMessageServiceImplV2$messageExecutor$2.INSTANCE);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void B8(final String r10, boolean r11, RecallInterceptCallback r12) {
        Intrinsics.checkNotNullParameter(r10, "messageId");
        Intrinsics.checkNotNullParameter(r12, "callback");
        if (r11 == false) goto L5;
        RecallMessageRequest.Builder r1 = new RecallMessageRequest.Builder().id(r10);
        Intrinsics.checkNotNull(r1);
        com.bytedance.lark.rustclient.api.d r13 = new com.bytedance.lark.rustclient.api.d(r1, RecallMessageResponse.ADAPTER, Command.RECALL_MESSAGE, null, null, null, null, 248);
        com.bytedance.lark.rustclient.api.t.h(this.c.h(r13).a(), ImSdkMessageServiceImplV2$recallMessage$1.INSTANCE, r12);
        return;
    L5:
        RecallGroupMessageRequest.Builder r2 = new RecallGroupMessageRequest.Builder().id(r10);
        Intrinsics.checkNotNull(r2);
        com.bytedance.lark.rustclient.api.d r14 = new com.bytedance.lark.rustclient.api.d(r2, RecallGroupMessageResponse.ADAPTER, Command.RECALL_GROUP_MESSAGE, null, null, null, null, 248);
        com.bytedance.lark.rustclient.api.t.h(this.c.h(r14).a(), new ImSdkMessageServiceImplV2$recallMessage$2(r10), r12);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void Jc(String r2, List<String> r3, IGetDataCallback<Message> r4) {
        Intrinsics.checkNotNullParameter(r3, "ids");
        Intrinsics.checkNotNullParameter(r4, "callback");
        RxScheduledExecutor.justInIO(new h(r3, r2, this, r4));
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void W2(String r10, int r11, FlowMessageSelectPlugin$pullFollowingMessages$1 r12) {
        Intrinsics.checkNotNullParameter(r10, "chatId");
        Intrinsics.checkNotNullParameter(r12, "callback");
        GetMessageIdsByPositionRequest.Builder r1 = new GetMessageIdsByPositionRequest.Builder().chat_id(r10).start_position(Integer.valueOf(r11));
        r1.count(100);
        Intrinsics.checkNotNull(r1);
        com.bytedance.lark.rustclient.api.d r13 = new com.bytedance.lark.rustclient.api.d(r1, GetMessageIdsByPositionResponse.ADAPTER, Command.GET_MESSAGE_IDS_BY_POSITION, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.a(com.bytedance.lark.rustclient.api.t.b(this.c.h(r13).a()).map(q.a), r12);
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void m5(Message r2, boolean r3, MessageFoldDetail r4) {
        Intrinsics.checkNotNullParameter(r2, INotificationHitPoint.NoticeType.MESSAGE);
        RxScheduledExecutor.justInIO(new i(r2, r4, r3, this));
    }

    @Override // com.ss.android.lark.im.sdk.service.p
    public final void sendImages(String r9, List<String> r10, boolean r11, IGetDataCallback<String> r12) {
        Intrinsics.checkNotNullParameter(r9, "chatId");
        Intrinsics.checkNotNullParameter(r10, "imagePaths");
        Log.i("ImSdkMessageServiceImplV2", "sendImages");
        if (r10.isEmpty() == false) goto L9;
        Exception r13 = new Exception("unknown error");
        ErrorResult r14 = new ErrorResult(0);
        ErrorResult.access$002(r14, -1);
        ErrorResult.access$102(r14, -9999);
        ErrorResult.access$202(r14, 0);
        ErrorResult.access$302(r14, r13);
        ErrorResult.access$402(r14, "");
        ErrorResult.access$502(r14, "image list is empty");
        ErrorResult.access$602(r14, "");
        ErrorResult.access$702(r14, "");
        ErrorResult.access$802(r14, 0);
        ErrorResult.access$902(r14, null);
        ErrorResult.access$1002(r14, null);
        ErrorResult.access$1102(r14, null);
        if (r12 == null) goto L7;
        r12.onError(r14);
    L7:
        Log.e("ImSdkMessageServiceImplV2", "sendImages, but imagePaths is empty");
        return;
    L9:
        Log.i("ImSdkMessageServiceImplV2", "sendImages, imagePaths's size is " + r10.size());
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new j(this, r9, r10, r11, r12));
    }
}
