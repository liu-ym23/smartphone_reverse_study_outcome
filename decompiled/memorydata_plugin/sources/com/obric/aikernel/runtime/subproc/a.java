package com.obric.aikernel.runtime.subproc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.runtime.AIInferRuntime;
import com.obric.aikernel.runtime.utils.d;
import com.obric.aikernel.sdk.ext.BundleExtKt;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.aikernel.sdk.response.Response;
import com.obric.aikernel.sdk.response.ResponseKt;
import com.obric.memorydata.database.entity.ChatMessage;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.i;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 '2\u00020\u0001:\u0003&'(B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u0014\u0010\u000e\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J\u001e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016J*\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\nH\u0014J#\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\f2\b\u0010\u001f\u001a\u0004\u0018\u00010\fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010 J*\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lcom/obric/aikernel/runtime/subproc/MainHost;", "Landroid/os/Binder;", "ctx", "Lcom/obric/aikernel/runtime/AIInferRuntime;", "(Lcom/obric/aikernel/runtime/AIInferRuntime;)V", "getCtx", "()Lcom/obric/aikernel/runtime/AIInferRuntime;", "aeeLog", "", "priority", "", LocationMonitorConst.TAG, "", Params.CONTENT, "aeeLogs", "logs", "", "Lcom/obric/aikernel/runtime/subproc/MainHost$AeeLogEntry;", "notePackageCorrupt", "pkg", "version", "restart", "", "onTransact", "code", "data", "Landroid/os/Parcel;", "reply", "flags", "requestPackage", "biz", "lora", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePackage", "callback", "Lcom/obric/aikernel/AIKListener;", ActivityLifecycle.NAME, "caller", "AeeLogEntry", "Companion", "Proxy", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a extends Binder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f6198a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AIInferRuntime f6199b;

    /* JADX INFO: renamed from: com.obric.aikernel.runtime.subproc.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/obric/aikernel/runtime/subproc/MainHost$AeeLogEntry;", "", "priority", "", LocationMonitorConst.TAG, "", Params.CONTENT, "(ILjava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getPriority", "()I", "getTag", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class C0277a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f6200a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f6201b;
        private final String c;

        public C0277a(int r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r4, Params.CONTENT);
            this.f6200a = r2;
            this.f6201b = r3;
            this.c = r4;
        }

        public final int a() {
            return this.f6200a;
        }

        public final String b() {
            return this.f6201b;
        }

        public final String c() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0277a.class) == true) goto L8;
            return false;
        L8:
            C0277a r6 = (C0277a) ZeusTransformUtils.preCheckCast(r5, C0277a.class, "com.obric.memorydata.plugin");
            if (this.f6200a == r6.f6200a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f6201b, r6.f6201b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.f6200a) * 31) + this.f6201b.hashCode()) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "AeeLogEntry(priority=" + this.f6200a + ", tag=" + this.f6201b + ", content=" + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/aikernel/runtime/subproc/MainHost$Companion;", "", "()V", "MAX_BATCHED_LOGS_PER_TRANSACTION", "", "TAG", "", "_aeeLog", "_aeeLogs", "_notePackageCorrupt", "_requestPackage", "_updatePackage", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u0014\u0010\u000e\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J\u001e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016J#\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ-\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Lcom/obric/aikernel/runtime/subproc/MainHost$Proxy;", "", "remote", "Landroid/os/IBinder;", "(Landroid/os/IBinder;)V", "getRemote", "()Landroid/os/IBinder;", "aeeLog", "", "priority", "", LocationMonitorConst.TAG, "", Params.CONTENT, "aeeLogs", "logs", "", "Lcom/obric/aikernel/runtime/subproc/MainHost$AeeLogEntry;", "notePackageCorrupt", "pkg", "version", "restart", "", "requestPackage", "biz", "lora", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePackage", ActivityLifecycle.NAME, "caller", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final IBinder f6202a;

        /* JADX INFO: renamed from: com.obric.aikernel.runtime.subproc.a$c$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/aikernel/runtime/subproc/MainHost$Proxy$requestPackage$callback$1", "Lcom/obric/aikernel/AIKListener$Stub;", "onResult", "", ChatMessage.TYPE_RESPONSE, "Landroid/os/Bundle;", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class BinderC0278a extends com.obric.aikernel.b.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f6203a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f6204b;
            final /* synthetic */ w<Boolean> c;

            BinderC0278a(String r3, String r4, w<Boolean> r5) {
                w<Boolean> r6 = (w) ZeusTransformUtils.wrapperContextForParams(r5, w.class, "com.obric.memorydata.plugin");
                this.f6203a = r3;
                this.f6204b = r4;
                this.c = r6;
            }

            @Override // com.obric.aikernel.b
            public void onResult(Bundle r5) {
                final Ref.BooleanRef r0 = new Ref.BooleanRef();
                if (r5 == null) goto L7;
                Response r6 = BundleExtKt.toBasicTypeResponse(r5);
                if (r6 == null) goto L7;
                ResponseKt.ok(r6, (Function3) ZeusTransformUtils.preCheckCast(new MainHost$Proxy$requestPackage$callback$1$onResult$1(r0), Function3.class, "com.obric.memorydata.plugin"));
            L7:
                d.f6216a.d("MainHost", "requestPackage " + this.f6203a + ':' + this.f6204b + " onResult " + r0.element);
                this.c.a(Boolean.valueOf(r0.element));
            }
        }

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/aikernel/runtime/subproc/MainHost$Proxy$updatePackage$callback$1", "Lcom/obric/aikernel/AIKListener$Stub;", "onResult", "", ChatMessage.TYPE_RESPONSE, "Landroid/os/Bundle;", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class b extends com.obric.aikernel.b.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ w<Unit> f6205a;

            b(w<Unit> r3) {
                this.f6205a = (w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.memorydata.plugin");
            }

            @Override // com.obric.aikernel.b
            public void onResult(Bundle r1) {
                this.f6205a.a(Unit.INSTANCE);
            }
        }

        public c(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "remote");
            this.f6202a = r4;
        }

        public final Object a(String r8, String r9, String r10, Continuation<? super Unit> r11) {
            Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
            Parcel r1 = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(r1, "obtain()");
            w r4 = y.a(null);
            b r5 = new b(r4);
            Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L8
            c r7 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
            r1.writeInterfaceToken("MainHost");     // Catch: Throwable -> L8
            r1.writeStrongBinder((IBinder) ZeusTransformUtils.preCheckCast(r5, IBinder.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L8
            r1.writeString(r8);     // Catch: Throwable -> L8
            r1.writeString(r9);     // Catch: Throwable -> L8
            r1.writeString(r10);     // Catch: Throwable -> L8
            if (r7.f6202a.transact(3, r1, null, 1) == true) goto L6;
            r4.a((Throwable) ZeusTransformUtils.preCheckCast(new RuntimeException("updatePackage not handled"), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L8
        L6:
            Object r13 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        L10:
            Throwable r14 = Result.m1424exceptionOrNullimpl(r13);
            if (r14 == null) goto L13;
            d.f6216a.g("MainHost", "_updatePackage " + ExceptionsKt.stackTraceToString(r14));
            r4.a((Throwable) ZeusTransformUtils.preCheckCast(new RuntimeException("updatePackage failed", r14), Throwable.class, "com.obric.memorydata.plugin"));
        L13:
            r1.recycle();
            Object r15 = r4.a(r12);
            if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
            return r15;
        L17:
            return Unit.INSTANCE;
        L8:
            th = move-exception;
            Result.Companion r16 = Result.Companion;
            r13 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L10
        }

        public final Object a(String r12, String r13, Continuation<? super Boolean> r14) {
            Continuation r15 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r14, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r15, MainHost$Proxy$requestPackage$1.class) == false) goto L7;
            MainHost$Proxy$requestPackage$1 r0 = (MainHost$Proxy$requestPackage$1) ZeusTransformUtils.preCheckCast(r15, MainHost$Proxy$requestPackage$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r16 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            r13 = (String) ZeusTransformUtils.preCheckCast(r0.L$1, String.class, "com.obric.memorydata.plugin");
            r12 = (String) ZeusTransformUtils.preCheckCast(r0.L$0, String.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r16);
        L28:
            boolean r11 = ((Boolean) ZeusTransformUtils.preCheckCast(r16, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
            d r1 = d.f6216a;
            StringBuilder r17 = new StringBuilder().append("requestPackage completed biz=").append(r12).append(" lora=");
            if (r13 != null) goto L31;
            r13 = "";
        L31:
            r1.e("MainHost", r17.append(r13).append(" success=").append(r11).toString());
            return r16;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r16);
            d.f6216a.d("MainHost", "requestPackage " + r12 + ':' + r13 + " start");
            Parcel r18 = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(r18, "obtain()");
            w r7 = y.a(null);
            BinderC0278a r8 = new BinderC0278a(r12, r13, r7);
            Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L20
            c r19 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
            r18.writeInterfaceToken("MainHost");     // Catch: Throwable -> L20
            r18.writeString(r12);     // Catch: Throwable -> L20
            r18.writeString(r13);     // Catch: Throwable -> L20
            r18.writeStrongBinder((IBinder) ZeusTransformUtils.preCheckCast(r8, IBinder.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L20
            if (r19.f6202a.transact(4, r18, null, 1) == true) goto L18;
            r7.a(Boxing.boxBoolean(false));     // Catch: Throwable -> L20
        L18:
            Object r110 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L20
        L22:
            Throwable r111 = Result.m1424exceptionOrNullimpl(r110);
            if (r111 == null) goto L25;
            d.f6216a.g("MainHost", "requestPackage " + ExceptionsKt.stackTraceToString(r111));
            r7.a(Boxing.boxBoolean(false));
        L25:
            r18.recycle();
            r0.L$0 = r12;
            r0.L$1 = r13;
            r0.label = 1;
            r16 = r7.a(r0);
            if (r16 != r2) goto L28;
            return r2;
        L20:
            th = move-exception;
            Result.Companion r4 = Result.Companion;
            r110 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        L7:
            r0 = new MainHost$Proxy$requestPackage$1(this, r15);
            goto L8
        }

        public final void a(int r5, String r6, String r7) {
            Intrinsics.checkNotNullParameter(r6, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r7, Params.CONTENT);
            Parcel r1 = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(r1, "obtain()");
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
            c r4 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
            r1.writeInterfaceToken("MainHost");     // Catch: Throwable -> L5
            r1.writeInt(r5);     // Catch: Throwable -> L5
            r1.writeString(r6);     // Catch: Throwable -> L5
            r1.writeString(r7);     // Catch: Throwable -> L5
            Object r8 = Result.m1421constructorimpl(Boolean.valueOf(r4.f6202a.transact(1, r1, null, 1)));     // Catch: Throwable -> L5
        L7:
            Throwable r9 = Result.m1424exceptionOrNullimpl(r8);
            if (r9 == null) goto L10;
            d.f6216a.g("MainHost", "aeeLog " + ExceptionsKt.stackTraceToString(r9));
        L10:
            r1.recycle();
            return;
        L5:
            th = move-exception;
            Result.Companion r10 = Result.Companion;
            r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L7
        }

        public final void a(String r5, String r6, boolean r7) {
            Intrinsics.checkNotNullParameter(r5, "pkg");
            Intrinsics.checkNotNullParameter(r6, "version");
            Parcel r1 = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(r1, "obtain()");
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
            c r4 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
            r1.writeInterfaceToken("MainHost");     // Catch: Throwable -> L5
            r1.writeString(r5);     // Catch: Throwable -> L5
            r1.writeString(r6);     // Catch: Throwable -> L5
            r1.writeBoolean(r7);     // Catch: Throwable -> L5
            Object r8 = Result.m1421constructorimpl(Boolean.valueOf(r4.f6202a.transact(2, r1, null, 1)));     // Catch: Throwable -> L5
        L7:
            Throwable r9 = Result.m1424exceptionOrNullimpl(r8);
            if (r9 == null) goto L10;
            d.f6216a.g("MainHost", "notePackageCorrupt " + ExceptionsKt.stackTraceToString(r9));
        L10:
            r1.recycle();
            return;
        L5:
            th = move-exception;
            Result.Companion r10 = Result.Companion;
            r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L7
        }

        public final void a(List<C0277a> r8) {
            List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r9, "logs");
            Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin"), 200), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r10.hasNext() == false) goto L18;
            List r1 = (List) ZeusTransformUtils.preCheckCast(r10.next(), List.class, "com.obric.memorydata.plugin");
            Parcel r3 = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(r3, "obtain()");
            Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L12
            c r5 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
            r3.writeInterfaceToken("MainHost");     // Catch: Throwable -> L12
            r3.writeInt(r1.size());     // Catch: Throwable -> L12
            Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L12
        L8:
            if (r2.hasNext() == false) goto L10;
            C0277a r6 = (C0277a) ZeusTransformUtils.preCheckCast(r2.next(), C0277a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
            r3.writeInt(r6.a());     // Catch: Throwable -> L12
            r3.writeString(r6.b());     // Catch: Throwable -> L12
            r3.writeString(r6.c());     // Catch: Throwable -> L12
            goto L8
        L10:
            Object r7 = Result.m1421constructorimpl(Boolean.valueOf(r5.f6202a.transact(5, r3, null, 1)));     // Catch: Throwable -> L12
        L14:
            Throwable r11 = Result.m1424exceptionOrNullimpl(r7);
            if (r11 == null) goto L17;
            d.f6216a.g("MainHost", "aeeLogs " + ExceptionsKt.stackTraceToString(r11));
        L17:
            r3.recycle();
        L12:
            th = move-exception;
            Result.Companion r12 = Result.Companion;
            r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L14
        }
    }

    static {
        f6198a = new b(null);
    }

    public a(AIInferRuntime r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super("MainHost");
        this.f6199b = r2;
    }

    public final AIInferRuntime a() {
        return this.f6199b;
    }

    public final Object a(String r12, String r13, Continuation<? super Boolean> r14) {
        Continuation r15 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r14, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r15, MainHost$requestPackage$1.class) == false) goto L7;
        MainHost$requestPackage$1 r0 = (MainHost$requestPackage$1) ZeusTransformUtils.preCheckCast(r15, MainHost$requestPackage$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        MainHost$requestPackage$1 r7 = r0;
        Object r16 = r7.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r7.label;
        boolean r10 = true;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        ResultKt.throwOnFailure(r16);
    L17:
        List r11 = (List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.memorydata.plugin");
        Object r17 = null;
        if (r11 == null) goto L26;
        Iterator r18 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L21:
        if (r18.hasNext() == false) goto L25;
        Object r19 = r18.next();
        if (((Boolean) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r19, Pair.class, "com.obric.memorydata.plugin")).getSecond(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L21;
        r17 = r19;
    L25:
        r17 = (Pair) ZeusTransformUtils.preCheckCast(r17, Pair.class, "com.obric.memorydata.plugin");
    L26:
        if (r17 != null) goto L30;
        r10 = false;
    L30:
        return Boxing.boxBoolean(r10);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        d.f6216a.d("MainHost", "requestPackage start preparePackage " + r12 + '-' + r13);
        AIInferRuntime r3 = this.f6199b;
        r7.label = 1;
        r16 = AIInferRuntime.a(r3, r12, r13, false, null, r7, 8, null);
        if (r16 != r1) goto L17;
        return r1;
    L7:
        r0 = new MainHost$requestPackage$1(this, r15);
        goto L8
    }

    public final void a(int r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r3, Params.CONTENT);
        d.f6216a.a(r1, r2, r3);
    }

    public final void a(com.obric.aikernel.b r11, String r12, String r13, String r14) {
        com.obric.aikernel.b r3 = (com.obric.aikernel.b) ZeusTransformUtils.wrapperContextForParams(r11, com.obric.aikernel.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "callback");
        Intrinsics.checkNotNullParameter(r12, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r13, "caller");
        i.a(this.f6199b.b(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new MainHost$updatePackage$1(r3, this, r12, r13, r14, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final void a(String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "pkg");
        Intrinsics.checkNotNullParameter(r3, "version");
        this.f6199b.a(r2, r3, r4);
    }

    public final void a(List<C0277a> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "logs");
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        C0277a r0 = (C0277a) ZeusTransformUtils.preCheckCast(r7.next(), C0277a.class, "com.obric.memorydata.plugin");
        a(r0.a(), r0.b(), r0.c());
        goto L4
    }

    @Override // android.os.Binder
    public boolean onTransact(int r17, Parcel r18, Parcel r19, int r20) {
        Intrinsics.checkNotNullParameter(r18, "data");
        String r3 = "";
        if (r17 != 1) goto L5;
        r18.enforceInterface("MainHost");
        int r0 = r18.readInt();
        String r4 = r18.readString();
        if (r4 != null) goto L49;
        r4 = "";
    L49:
        String r2 = r18.readString();
        if (r2 == null) goto L53;
        r3 = r2;
    L53:
        a(r0, r4, r3);
        return true;
    L5:
        if (r17 != 2) goto L7;
        r18.enforceInterface("MainHost");
        String r1 = r18.readString();
        if (r1 == null) goto L45;
        Intrinsics.checkNotNullExpressionValue(r1, "requireNotNull(data.readString())");
        String r5 = r18.readString();
        if (r5 == null) goto L43;
        Intrinsics.checkNotNullExpressionValue(r5, "requireNotNull(data.readString())");
        a(r1, r5, r18.readBoolean());
        return true;
    L43:
        throw new IllegalArgumentException("Required value was null.".toString());
    L45:
        throw new IllegalArgumentException("Required value was null.".toString());
    L7:
        if (r17 != 3) goto L9;
        r18.enforceInterface("MainHost");
        com.obric.aikernel.b r6 = com.obric.aikernel.b.a.asInterface(r18.readStrongBinder());
        Intrinsics.checkNotNullExpressionValue(r6, "asInterface(data.readStrongBinder())");
        String r7 = r18.readString();
        if (r7 == null) goto L36;
        Intrinsics.checkNotNullExpressionValue(r7, "requireNotNull(data.readString())");
        String r8 = r18.readString();
        if (r8 == null) goto L34;
        Intrinsics.checkNotNullExpressionValue(r8, "requireNotNull(data.readString())");
        a(r6, r7, r8, r18.readString());
        return true;
    L34:
        throw new IllegalArgumentException("Required value was null.".toString());
    L36:
        throw new IllegalArgumentException("Required value was null.".toString());
    L9:
        if (r17 != 4) goto L11;
        r18.enforceInterface("MainHost");
        String r9 = r18.readString();
        if (r9 == null) goto L27;
        Intrinsics.checkNotNullExpressionValue(r9, "requireNotNull(data.readString())");
        String r10 = r18.readString();
        com.obric.aikernel.b r11 = com.obric.aikernel.b.a.asInterface(r18.readStrongBinder());
        i.a(this.f6199b.b(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new MainHost$onTransact$2(this, r9, r10, r11, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return true;
    L27:
        throw new IllegalArgumentException("Required value was null.".toString());
    L11:
        if (r17 != 5) goto L58;
        r18.enforceInterface("MainHost");
        int r12 = 0;
        int r13 = RangesKt.coerceIn(r18.readInt(), 0, 200);
        ArrayList r14 = new ArrayList(r13);
    L14:
        if (r12 >= r13) goto L22;
        int r15 = r18.readInt();
        String r16 = r18.readString();
        if (r16 != null) goto L18;
        r16 = "";
    L18:
        Intrinsics.checkNotNullExpressionValue(r16, "data.readString() ?: \"\"");
        String r110 = r18.readString();
        if (r110 != null) goto L21;
        r110 = "";
    L21:
        Intrinsics.checkNotNullExpressionValue(r110, "data.readString() ?: \"\"");
        r14.add(new C0277a(r15, r16, r110));
        r12 = r12 + 1;
        goto L14
    L22:
        a((List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin"));
        return true;
    L58:
        return super.onTransact(r17, r18, r19, r20);
    }
}
