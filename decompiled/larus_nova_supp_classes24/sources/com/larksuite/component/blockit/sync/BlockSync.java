package com.larksuite.component.blockit.sync;

import com.bytedance.ee.lark.infra.foundation.log.AppBrandLogger;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SendHttpRequest;
import com.bytedance.lark.pb.sync.v1.SubscribeTopicRequest;
import com.bytedance.lark.pb.sync.v1.SubscribeTopicResponse;
import com.bytedance.lark.pb.sync.v1.SyncHeader;
import com.bytedance.lark.pb.sync.v1.UnsubscribeSyncTopicResponse;
import com.larksuite.component.blockit.entity.BlockEntity;
import com.larksuite.component.blockit.entity.BlockEntityResp;
import com.larksuite.component.blockit.entity.OpenMessageResp;
import com.larksuite.component.blockit.service.BlockitService;
import com.larksuite.component.blockit.service.g;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.sdk.SdkSender;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class BlockSync {
    public final List<String> a;
    public final ConcurrentHashMap<String, e> b;
    public int c;
    public ScheduledFuture d;
    public final HashMap<String, List<g>> e;
    public final b f;

    /* JADX INFO: renamed from: com.larksuite.component.blockit.sync.BlockSync$1, reason: invalid class name */
    class AnonymousClass1 implements IGetDataCallback<UnsubscribeSyncTopicResponse> {
        final /* synthetic */ BlockSync this$0;
        final /* synthetic */ String val$blockId;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.larksuite.framework.callback.IGetDataCallback
        public void onError(ErrorResult r3) {
            AppBrandLogger.i("BlockSync", new Object[]{"unSubscribe fail:", this.val$blockId});
        }

        public void onSuccess(UnsubscribeSyncTopicResponse r3) {
            AppBrandLogger.i("BlockSync", new Object[]{"unSubscribe success:", this.val$blockId});
        }

        @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
        public /* bridge */ /* synthetic */ void onError(ErrorResult r1) {
            onError(r1);
        }

        @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
        public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
            onSuccess((UnsubscribeSyncTopicResponse) r1);
        }

        public AnonymousClass1(BlockSync r1, String r2) {
            this.this$0 = r1;
            this.val$blockId = r2;
        }
    }

    /* JADX INFO: renamed from: com.larksuite.component.blockit.sync.BlockSync$2, reason: invalid class name */
    class AnonymousClass2 implements IGetDataCallback<BlockEntityResp> {
        final /* synthetic */ BlockSync this$0;
        final /* synthetic */ String val$blockId;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.larksuite.framework.callback.IGetDataCallback
        public void onError(ErrorResult r5) {
            BlockSync.a(this.this$0, this.val$blockId, 0L, -1L);
        }

        public void onSuccess(BlockEntityResp r7) {
            if (r7 != null) goto L4;
            long r0 = 0;
        L5:
            BlockSync.a(this.this$0, this.val$blockId, Long.valueOf(r0), -1L);
            if (r7 == null) goto L12;
            BlockEntity r8 = r7.entity;
            if (r8 == null) goto L13;
            this.this$0.f(this.val$blockId, "onResourceChange", r8.getSourceData());
            return;
        L13:
            return;
        L12:
            return;
        L4:
            r0 = r7.version;
            goto L5
        }

        @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
        public /* bridge */ /* synthetic */ void onError(ErrorResult r1) {
            onError(r1);
        }

        @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
        public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
            onSuccess((BlockEntityResp) r1);
        }

        public AnonymousClass2(BlockSync r1, String r2) {
            this.this$0 = r1;
            this.val$blockId = r2;
        }
    }

    /* JADX INFO: renamed from: com.larksuite.component.blockit.sync.BlockSync$3, reason: invalid class name */
    class AnonymousClass3 implements IGetDataCallback<OpenMessageResp> {
        final /* synthetic */ BlockSync this$0;
        final /* synthetic */ String val$blockId;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.larksuite.framework.callback.IGetDataCallback
        public void onError(ErrorResult r5) {
            BlockSync.a(this.this$0, this.val$blockId, -1L, 0L);
        }

        public void onSuccess(OpenMessageResp r6) {
            BlockSync r0 = this.this$0;
            String r1 = this.val$blockId;
            if (r6 != null) goto L5;
            long r3 = 0;
        L6:
            BlockSync.a(r0, r1, -1L, Long.valueOf(r3));
            return;
        L5:
            r3 = r6.version;
            goto L6
        }

        @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
        public /* bridge */ /* synthetic */ void onError(ErrorResult r1) {
            onError(r1);
        }

        @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
        public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
            onSuccess((OpenMessageResp) r1);
        }

        public AnonymousClass3(BlockSync r1, String r2) {
            this.this$0 = r1;
            this.val$blockId = r2;
        }
    }

    public static final class a {
        public static final /* synthetic */ int a = 0;

        static {
            new BlockSync();
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.larksuite.component.blockit.sync.b] */
    public BlockSync() {
        this.a = new CopyOnWriteArrayList();
        this.b = new ConcurrentHashMap();
        this.c = 3;
        this.e = new HashMap();
        this.f = new b(this);
        com.ss.android.lark.sdk.g r0 = com.ss.android.lark.sdk.g.e.a;
        r0.b(Command.SYNC_PUSH_MESSAGE_BLOCK, new d(this));
        r0.b(Command.SYNC_PUSH_EVENT_BLOCK, new c(this));
    }

    public final void g(final String r10) {
        BlockitService r7 = BlockitService.f.a;
        IGetDataCallback<BlockEntityResp> r0 = new AnonymousClass5(this, r10);
        z18.a r1 = BlockitService.d(r10);
        com.larksuite.component.blockit.service.b r6 = new com.larksuite.component.blockit.service.b(r10, r0);
        r7.e(r1.b(), SendHttpRequest.Method.POST, r1.a().headersMap, r1.a().get("X-BaseRequest-ID"), r1.e.getContent(), r6);
        r7.g(r10, new AnonymousClass6(this, r10));
    }

    public static void b(BlockSync r4, int r5) {
        r4.getClass();
        AppBrandLogger.i("BlockSync", new Object[]{"subscribeFail"});
        r4.c = r5;
        if (r4.d != null) goto L6;
        r4.d = CoreThreadPool.getDefault().getScheduleThreadPool().schedule(r4.f, r5, TimeUnit.SECONDS);
        return;
    }

    public final void c(final String r4, final int r5) {
        AppBrandLogger.i("BlockSync", new Object[]{"doSubscribe:", r4});
        if (((CopyOnWriteArrayList) this.a).contains(r4) == true) goto L5;
        return;
    L5:
        SubscribeTopicRequest.Builder r0 = new SubscribeTopicRequest.Builder().header(new SyncHeader.Builder().app_name("lark_block_server").token("e9971a63-1873-4248-bf60-cee84990b60c").build()).topic_id(r4);
        Command r1 = Command.SYNC_SUBSCRIBE_TOPIC;
        IGetDataCallback<SubscribeTopicResponse> r2 = new AnonymousClass4(this, r4, r5);
        final ProtoAdapter r6 = SubscribeTopicResponse.ADAPTER;
        Objects.requireNonNull(r6);
        SdkSender.asynSendRequestNonWrap(r1, r0, r2, new com.larksuite.component.blockit.sync.a(r6));
    }

    public final synchronized void f(String r1, String r2, String r3) {
        monitor-enter(this);
        List<g> r4 = this.e.get(r1);     // Catch: Throwable -> L14
        if (r4 != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        Iterator<g> r5 = r4.iterator();     // Catch: Throwable -> L14
    L9:
        if (r5.hasNext() == false) goto L12;
        r5.next().a();     // Catch: Throwable -> L14
        goto L9
    L12:
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public static void a(BlockSync r6, String r7, Long r8, Long r9) {
        e r0 = r6.b.get(r7);
        if (r0 != null) goto L6;
        return;
    L6:
        if (r8.longValue() == (-1)) goto L9;
        r0.a = r8.longValue();
    L9:
        if (r9.longValue() == (-1)) goto L12;
        r0.b = r9.longValue();
    L12:
        if (r0.a != (-1)) goto L14;
        return;
    L14:
        if (r0.b == (-1)) goto L18;
        r6.c(r7, 3);
        return;
    }

    public final void d(String r10, String r11, long r12, String r14) {
        e r0 = this.b.get(r10);
        if (r0 != null) goto L12;
        r0 = new e();
        if ("pushBlockEvent".equals(r11) == false) goto L8;
        r0.a = r12;
    L10:
        this.b.put(r10, r0);
        goto L12
    L8:
        if ("pushOpenMessage".equals(r11) == false) goto L11;
        r0.b = r12;
        goto L10
    L11:
        return;
    L12:
        e r8 = r0;
        if ("pushBlockEvent".equals(r11) == true) goto L15;
        e(r10, r14, r12, r8);
        return;
    L15:
        if (r12 > r8.a) goto L17;
        return;
    L17:
        r8.a = r12;
        f(r10, "onResourceChange", r14);
    }

    public final void e(String r4, String r5, long r6, e r8) {
    L7:
        e = move-exception;
        AppBrandLogger.e("BlockSync", new Object[]{e.getMessage()});
        return;
    L3:
        if (r6 > r8.b) goto L5;
        return;
    L5:
        r8.b = r6;     // Catch: JSONException -> L7
        JSONObject r7 = new JSONObject();     // Catch: JSONException -> L7
        r7.put("type", "customMessage");     // Catch: JSONException -> L7
        r7.put("data", r5);     // Catch: JSONException -> L7
        f(r4, "onTypedMessage", r7.toString());     // Catch: JSONException -> L7
    }
}
