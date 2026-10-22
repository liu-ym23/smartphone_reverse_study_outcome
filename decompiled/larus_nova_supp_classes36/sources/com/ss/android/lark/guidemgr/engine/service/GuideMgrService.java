package com.ss.android.lark.guidemgr.engine.service;

import android.os.SystemClock;
import androidx.core.util.Pair;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.onboarding.v1.PostUserConsumingGuideRequest;
import com.bytedance.lark.pb.onboarding.v1.PostUserConsumingGuideResponse;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class GuideMgrService {

    /* JADX INFO: renamed from: com.ss.android.lark.guidemgr.engine.service.GuideMgrService$1, reason: invalid class name */
    class AnonymousClass1 implements IGetDataCallback<List<Pair<xjb.a, List<xjb.b>>>> {
        final /* synthetic */ GuideMgrService this$0;
        final /* synthetic */ IGetDataCallback val$callback;
        final /* synthetic */ akb.d.a val$netPoint;
        final /* synthetic */ long val$startTime;

        public void onError(ErrorResult r5) {
            Log.w("GuideMgrService", "fetchProductGuideList error");
            long r0 = SystemClock.uptimeMillis() - this.val$startTime;
            int r2 = akb.a.a;
            if (r5 == null) goto L5;
            String r3 = r5.toString();
        L6:
            akb.a.a(false, r0, r3);
            this.val$netPoint.b(r5.getErrorCode(), r5.getDebugMsg());
            IGetDataCallback r1 = this.val$callback;
            if (r1 == null) goto L9;
            r1.onError(r5);
        L9:
            akb.c.a.a.getClass();
            akb.c.a(r5);
            return;
        L5:
            r3 = null;
            goto L6
        }

        public void onSuccess(List<Pair<xjb.a, List<xjb.b>>> r5) {
            Log.i("GuideMgrService", "fetchProductGuideList onSuccess");
            akb.a.a(true, SystemClock.uptimeMillis() - this.val$startTime, null);
            this.val$netPoint.a();
            IGetDataCallback r0 = this.val$callback;
            if (r0 == null) goto L6;
            r0.onSuccess(r5);
            return;
        }

        public /* bridge */ /* synthetic */ void onError(Object r1) {
            onError((ErrorResult) r1);
        }

        public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
            onSuccess((List) r1);
        }

        public AnonymousClass1(GuideMgrService r1, long r2, akb.d.a r4, IGetDataCallback r5) {
            this.this$0 = r1;
            this.val$startTime = r2;
            this.val$netPoint = r4;
            this.val$callback = r5;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.guidemgr.engine.service.GuideMgrService$2, reason: invalid class name */
    class AnonymousClass2 implements IGetDataCallback<List<Pair<xjb.a, List<xjb.b>>>> {
        final /* synthetic */ GuideMgrService this$0;
        final /* synthetic */ IGetDataCallback val$callback;
        final /* synthetic */ a val$ccmListRef;
        final /* synthetic */ a val$ugListRef;

        public static /* synthetic */ void a(AnonymousClass2 r0, a r1, List r2, a r3, IGetDataCallback r4) {
            r0.lambda$onSuccess$0(r1, r2, r3, r4);
        }

        public void onError(ErrorResult r2) {
            IGetDataCallback r0 = this.val$callback;
            if (r0 == null) goto L6;
            r0.onError(r2);
            return;
        }

        public void onSuccess(final List<Pair<xjb.a, List<xjb.b>>> r9) {
            Executor r0 = CoreThreadPool.getDefault().getUIExecutor();
            final a r3 = this.val$ugListRef;
            final a r5 = this.val$ccmListRef;
            final IGetDataCallback r6 = this.val$callback;
            r0.execute(new c(this, r3, r9, r5, r6));
        }

        public /* bridge */ /* synthetic */ void onError(Object r1) {
            onError((ErrorResult) r1);
        }

        public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
            onSuccess((List) r1);
        }

        public AnonymousClass2(GuideMgrService r1, a r2, a r3, IGetDataCallback r4) {
            this.this$0 = r1;
            this.val$ugListRef = r2;
            this.val$ccmListRef = r3;
            this.val$callback = r4;
        }

        private /* synthetic */ void lambda$onSuccess$0(a r2, List r3, a r4, IGetDataCallback r5) {
            r2.a = true;
            r2.b = r3;
            GuideMgrService.a(this.this$0, r2, r4, r5);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.guidemgr.engine.service.GuideMgrService$3, reason: invalid class name */
    class AnonymousClass3 implements IGetDataCallback<List<Pair<xjb.a, List<xjb.b>>>> {
        final /* synthetic */ GuideMgrService this$0;
        final /* synthetic */ IGetDataCallback val$callback;
        final /* synthetic */ a val$ccmListRef;
        final /* synthetic */ a val$ugListRef;

        public static /* synthetic */ void a(AnonymousClass3 r0, a r1, List r2, a r3, IGetDataCallback r4) {
            r0.lambda$onSuccess$0(r1, r2, r3, r4);
        }

        public static /* synthetic */ void b(AnonymousClass3 r0, a r1, a r2, IGetDataCallback r3) {
            r0.lambda$onError$1(r1, r2, r3);
        }

        public void onError(ErrorResult r5) {
            Executor r6 = CoreThreadPool.getDefault().getUIExecutor();
            final a r0 = this.val$ccmListRef;
            final a r1 = this.val$ugListRef;
            final IGetDataCallback r2 = this.val$callback;
            r6.execute(new d(this, r0, r1, r2));
        }

        public void onSuccess(final List<Pair<xjb.a, List<xjb.b>>> r9) {
            Executor r0 = CoreThreadPool.getDefault().getUIExecutor();
            final a r3 = this.val$ccmListRef;
            final a r5 = this.val$ugListRef;
            final IGetDataCallback r6 = this.val$callback;
            r0.execute(new e(this, r3, r9, r5, r6));
        }

        public /* bridge */ /* synthetic */ void onError(Object r1) {
            onError((ErrorResult) r1);
        }

        public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
            onSuccess((List) r1);
        }

        private /* synthetic */ void lambda$onError$1(a r2, a r3, IGetDataCallback r4) {
            r2.a = true;
            GuideMgrService.a(this.this$0, r3, r2, r4);
        }

        public AnonymousClass3(GuideMgrService r1, a r2, a r3, IGetDataCallback r4) {
            this.this$0 = r1;
            this.val$ccmListRef = r2;
            this.val$ugListRef = r3;
            this.val$callback = r4;
        }

        private /* synthetic */ void lambda$onSuccess$0(a r2, List r3, a r4, IGetDataCallback r5) {
            r2.a = true;
            r2.b = r3;
            GuideMgrService.a(this.this$0, r4, r2, r5);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.guidemgr.engine.service.GuideMgrService$4, reason: invalid class name */
    class AnonymousClass4 implements IGetDataCallback<List<Pair<xjb.a, List<xjb.b>>>> {
        final /* synthetic */ GuideMgrService this$0;
        final /* synthetic */ IGetDataCallback val$callback;
        final /* synthetic */ akb.d.a val$netPoint;
        final /* synthetic */ long val$startTime;

        public void onError(ErrorResult r5) {
            Log.e("GuideMgrService", "fetchUGProductGuideList error", r5);
            long r0 = SystemClock.uptimeMillis() - this.val$startTime;
            int r2 = akb.a.a;
            if (r5 == null) goto L5;
            String r3 = r5.toString();
        L6:
            akb.a.a(false, r0, r3);
            this.val$netPoint.b(r5.getErrorCode(), r5.getDebugMsg());
            IGetDataCallback r1 = this.val$callback;
            if (r1 == null) goto L9;
            r1.onError(r5);
        L9:
            akb.c.a.a.getClass();
            akb.c.a(r5);
            return;
        L5:
            r3 = null;
            goto L6
        }

        public void onSuccess(List<Pair<xjb.a, List<xjb.b>>> r5) {
            Log.i("GuideMgrService", "fetchUGProductGuideList onSuccess, data: ".concat(yjb.a.a(r5)));
            akb.a.a(true, SystemClock.uptimeMillis() - this.val$startTime, null);
            this.val$netPoint.a();
            IGetDataCallback r0 = this.val$callback;
            if (r0 == null) goto L6;
            r0.onSuccess(r5);
            return;
        }

        public /* bridge */ /* synthetic */ void onError(Object r1) {
            onError((ErrorResult) r1);
        }

        public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
            onSuccess((List) r1);
        }

        public AnonymousClass4(GuideMgrService r1, long r2, akb.d.a r4, IGetDataCallback r5) {
            this.this$0 = r1;
            this.val$startTime = r2;
            this.val$netPoint = r4;
            this.val$callback = r5;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.guidemgr.engine.service.GuideMgrService$5, reason: invalid class name */
    class AnonymousClass5 implements IGetDataCallback<List<Pair<xjb.a, List<xjb.b>>>> {
        final /* synthetic */ GuideMgrService this$0;
        final /* synthetic */ IGetDataCallback val$callback;

        public void onError(ErrorResult r3) {
            Log.e("GuideMgrService", "fetchCCMProductGuideList error", r3);
            IGetDataCallback r0 = this.val$callback;
            if (r0 == null) goto L6;
            r0.onError(r3);
            return;
        }

        public void onSuccess(List<Pair<xjb.a, List<xjb.b>>> r3) {
            Log.i("GuideMgrService", "fetchCCMProductGuideList onSuccess, data: ".concat(yjb.a.a(r3)));
            IGetDataCallback r0 = this.val$callback;
            if (r0 == null) goto L6;
            r0.onSuccess(r3);
            return;
        }

        public /* bridge */ /* synthetic */ void onError(Object r1) {
            onError((ErrorResult) r1);
        }

        public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
            onSuccess((List) r1);
        }

        public AnonymousClass5(GuideMgrService r1, IGetDataCallback r2) {
            this.this$0 = r1;
            this.val$callback = r2;
        }
    }

    public static class a {
        public volatile boolean a;
        public volatile List<Pair<xjb.a, List<xjb.b>>> b;
    }

    public static class b {
        public static final GuideMgrService a = null;

        static {
            a = new GuideMgrService();
        }
    }

    public GuideMgrService() {
    }

    public final void b(List<String> r12, final IGetDataCallback<Object> r13) {
        if (((ArrayList) r12).isEmpty() == true) goto L20;
        StringBuilder r0 = new StringBuilder();
        ArrayList r1 = new ArrayList(r12);     // Catch: Exception -> L14
        int r2 = r1.size();     // Catch: Exception -> L14
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L12;
        r0.append((String) ListProtector.get(r1, r3));     // Catch: Exception -> L14
        if (r3 >= (r2 - 1)) goto L11;
        r0.append(",");     // Catch: Exception -> L14
    L11:
        r3 = r3 + 1;
    L12:
        final String r8 = r0.toString();
        final long r6 = SystemClock.uptimeMillis();
        akb.b r4 = akb.b.a;
        r4.getClass();
        final akb.d.a r9 = new akb.d.a(Event.ug_post_user_consuming_guide, r4);
        r9.c();
        IGetDataCallback<Object> r5 = new AnonymousClass6(this, r6, r8, r9, r13);
        Command r14 = Command.POST_USER_CONSUMING_GUIDE_REQUEST;
        PostUserConsumingGuideRequest.Builder r15 = new PostUserConsumingGuideRequest.Builder().keys(r12);
        final ProtoAdapter r7 = PostUserConsumingGuideResponse.ADAPTER;
        Objects.requireNonNull(r7);
        SdkSender.asynSendRequestNonWrap(r14, r15, r5, new com.ss.android.lark.guidemgr.engine.service.b(r7));
        return;
    }

    public static void a(GuideMgrService r1, final a r2, final a r3, final IGetDataCallback r4) {
        r1.getClass();
        if (r2.a == true) goto L5;
        return;
    L5:
        if (r3.a == false) goto L9;
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new com.ss.android.lark.guidemgr.engine.service.a(r2, r3, r4));
        return;
    }
}
