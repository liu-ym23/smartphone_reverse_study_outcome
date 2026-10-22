package com.ss.android.lark.message.universalcard.datachannel;

import android.os.Handler;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.openplatform.v1.SubscribeUniversalCardRequest;
import com.bytedance.lark.pb.openplatform.v1.SubscribeUniversalCardResponse;
import com.bytedance.lark.pb.openplatform.v1.UnSubscribeUniversalCardRequest;
import com.bytedance.lark.pb.openplatform.v1.UnSubscribeUniversalCardResponse;
import com.bytedance.lark.pb.openplatform.v1.UniversalCardBizParam;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.message.lynxcard.message.p;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class UniversalCardSubscriptionManager {
    public final PthreadHandlerThreadV2 a;
    public final Lazy b;
    public final LinkedBlockingQueue<Runnable> c;
    public boolean d;
    public final ConcurrentHashMap<String, b> e;

    public final class DestroyTask implements Runnable {
        public final /* synthetic */ UniversalCardSubscriptionManager a;

        public final void a() {
            Log.i("UniversalCardSubscriptionManager", "destroy task run");
            Collection<b> r0 = this.a.e.values();
            final UniversalCardSubscriptionManager r1 = this.a;
            Iterator<T> r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L9;
            final b r3 = (b) r2.next();
            Iterator<T> r4 = r3.c.entrySet().iterator();
        L7:
            if (r4.hasNext() == false) goto L4;
            final String r5 = (String) ((Map.Entry) r4.next()).getValue();
            IGetDataCallback<UnSubscribeUniversalCardResponse> r6 = new UniversalCardSubscriptionManager$DestroyTask$run$1$1$1(r1, r5, r3);
            r1.getClass();
            UnSubscribeUniversalCardRequest.Builder r7 = new UnSubscribeUniversalCardRequest.Builder().token(r5);
            SdkSender.asynSendRequestNonWrap(Command.UNSUBSCRIBE_UNIVERSAL_CARD, r7, r6, new e(r1));
            goto L7
        L9:
            this.a.e.clear();
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

        public DestroyTask(UniversalCardSubscriptionManager r1) {
            this.a = r1;
        }
    }

    public final class SubscriptionTask implements Runnable {
        public final String a;
        public final int b;
        public final String c;
        public final com.ss.android.lark.message.universalcard.datachannel.b d;
        public final /* synthetic */ UniversalCardSubscriptionManager e;

        public static final class a<T> implements SdkSender.IParser {
            public a(SubscriptionTask r1) {
            }

            public final Object parse(byte[] r2) {
                if (r2 == null) goto L6;
                SubscribeUniversalCardResponse r3 = (SubscribeUniversalCardResponse) SubscribeUniversalCardResponse.ADAPTER.decode(r2);
                if (r3 == null) goto L6;
                return r3;
            L6:
                return new SubscribeUniversalCardResponse.Builder().token("").build();
            }
        }

        public final void a() {
            Log.i("UniversalCardSubscriptionManager", UniversalCardSubscriptionManager.a(this.e, "subscribe", this.a, this.c));
            ConcurrentHashMap<String, b> r0 = this.e.e;
            String r2 = this.a;
            b r3 = r0.get(r2);
            if (r3 != null) goto L8;
            r3 = new b(this.c, this.a, new HashMap());
            b r1 = r0.putIfAbsent(r2, r3);
            if (r1 == null) goto L8;
            r3 = r1;
        L8:
            final b r4 = r3;
            if (r4.c.containsKey(this.d) == false) goto L12;
            Log.w("UniversalCardSubscriptionManager", UniversalCardSubscriptionManager.a(this.e, "subscribe duplicate subscribe, ignore", this.a, this.c));
            this.e.b();
            return;
        L12:
            UniversalCardBizParam r5 = new UniversalCardBizParam.Builder().biz_id(this.a).biz_type(Integer.valueOf(this.b)).build();
            SubscribeUniversalCardRequest.Builder r6 = new SubscribeUniversalCardRequest.Builder().card_id(this.c).biz_param(r5).need_push(Boolean.TRUE);
            Command r7 = Command.SUBSCRIBE_UNIVERSAL_CARD;
            final UniversalCardSubscriptionManager r8 = this.e;
            SdkSender.asynSendRequestNonWrap(r7, r6, new UniversalCardSubscriptionManager$SubscriptionTask$run$1(r8, this, r4), new a(this));
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

        public SubscriptionTask(UniversalCardSubscriptionManager r2, String r3, int r4, String r5, p r6) {
            Intrinsics.checkNotNullParameter(r3, "bizID");
            Intrinsics.checkNotNullParameter(r5, "universalCardID");
            Intrinsics.checkNotNullParameter(r6, "subscriber");
            this.e = r2;
            this.a = r3;
            this.b = r4;
            this.c = r5;
            this.d = r6;
        }
    }

    public final class UnSubscriptionTask implements Runnable {
        public final String a;
        public final String b;
        public final com.ss.android.lark.message.universalcard.datachannel.b c;
        public final /* synthetic */ UniversalCardSubscriptionManager d;

        public final void a() {
            Log.i("UniversalCardSubscriptionManager", UniversalCardSubscriptionManager.a(this.d, "unsubscribe", this.a, this.b));
            final b r0 = this.d.e.get(this.a);
            if (r0 != null) goto L6;
            UniversalCardSubscriptionManager r1 = this.d;
            Log.e("UniversalCardSubscriptionManager", UniversalCardSubscriptionManager.a(r1, "unsubscribe subscription not found", this.a, this.b));
            r1.b();
            return;
        L6:
            String r2 = r0.c.get(this.c);
            if (r2 != null) goto L10;
            UniversalCardSubscriptionManager r3 = this.d;
            Log.e("UniversalCardSubscriptionManager", UniversalCardSubscriptionManager.a(r3, "unsubscribe token not found", this.a, this.b));
            r3.b();
            return;
        L10:
            final UniversalCardSubscriptionManager r4 = this.d;
            IGetDataCallback<UnSubscribeUniversalCardResponse> r5 = new UniversalCardSubscriptionManager$UnSubscriptionTask$run$1(r4, this, r0);
            r4.getClass();
            UnSubscribeUniversalCardRequest.Builder r6 = new UnSubscribeUniversalCardRequest.Builder().token(r2);
            SdkSender.asynSendRequestNonWrap(Command.UNSUBSCRIBE_UNIVERSAL_CARD, r6, r5, new e(r4));
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

        public UnSubscriptionTask(UniversalCardSubscriptionManager r2, String r3, String r4, p r5) {
            Intrinsics.checkNotNullParameter(r3, "bizID");
            Intrinsics.checkNotNullParameter(r4, "universalCardID");
            Intrinsics.checkNotNullParameter(r5, "subscriber");
            this.d = r2;
            this.a = r3;
            this.b = r4;
            this.c = r5;
        }
    }

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final String b;
        public final Map<com.ss.android.lark.message.universalcard.datachannel.b, String> c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "Subscription(universalCardID=" + this.a + ", bizID=" + this.b + ", subscribers=" + this.c + ')';
        }

        public b(String r2, String r3, Map<com.ss.android.lark.message.universalcard.datachannel.b, String> r4) {
            Intrinsics.checkNotNullParameter(r2, "universalCardID");
            Intrinsics.checkNotNullParameter(r3, "bizID");
            Intrinsics.checkNotNullParameter(r4, "subscribers");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ UniversalCardSubscriptionManager a;

        public c(UniversalCardSubscriptionManager r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.c.take().run();     // Catch: Throwable -> L4
            return;
        L4:
            Log.i("UniversalCardSubscriptionManager", "runTask, destroyed");     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L10;
            return;
        L10:
            throw th;
        }
    }

    static {
    }

    public final void b() {
        ((Handler) this.b.getValue()).post(new c(this));
    }

    public UniversalCardSubscriptionManager() {
        this.a = new PthreadHandlerThreadV2("UniversalCardSubscriptionHandler");
        this.b = LazyKt.lazy(new UniversalCardSubscriptionManager$subscriptionHandler$2(this));
        this.c = new LinkedBlockingQueue();
        this.e = new ConcurrentHashMap();
        b();
    }

    public static final String a(UniversalCardSubscriptionManager r0, String r1, String r2, String r3) {
        r0.getClass();
        return r1 + " bizId=" + r2 + ", cardID=" + r3;
    }
}
