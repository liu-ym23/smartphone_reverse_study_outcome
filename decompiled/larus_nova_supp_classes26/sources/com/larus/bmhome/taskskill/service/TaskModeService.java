package com.larus.bmhome.taskskill.service;

import androidx.lifecycle.MutableLiveData;
import com.larus.bmhome.taskskill.model.PcDevice;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\u0005H&J\u001e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH¦@¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\u0012"}, d2 = {"Lcom/larus/bmhome/taskskill/service/TaskModeService;", "", "createPcDeviceListProviderInterface", "Lcom/larus/bmhome/taskskill/service/PcDeviceListProviderInterface;", "needUpgrade", "", "device", "Lcom/larus/bmhome/taskskill/model/PcDevice;", "remoteControlEnable", "shouldUseMfaForDeviceAuthorization", "authorizeDevice", "targetDeviceId", "", "authTicket", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestEnableControlPermission", "", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface TaskModeService {
    public static final Companion a = null;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016J\u001e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/larus/bmhome/taskskill/service/TaskModeService$Companion;", "Lcom/larus/bmhome/taskskill/service/TaskModeService;", "<init>", "()V", "impl", "getImpl", "()Lcom/larus/bmhome/taskskill/service/TaskModeService;", "impl$delegate", "Lkotlin/Lazy;", "createPcDeviceListProviderInterface", "Lcom/larus/bmhome/taskskill/service/PcDeviceListProviderInterface;", "needUpgrade", "", "device", "Lcom/larus/bmhome/taskskill/model/PcDevice;", "remoteControlEnable", "shouldUseMfaForDeviceAuthorization", "authorizeDevice", "targetDeviceId", "", "authTicket", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestEnableControlPermission", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements TaskModeService {
        public static final /* synthetic */ Companion b = null;
        public static final Lazy<TaskModeService> c = null;

        public static final class a implements d {
            public a() {
            }

            @Override // com.larus.bmhome.taskskill.service.d
            public final bs8.e b() {
                return null;
            }

            @Override // com.larus.bmhome.taskskill.service.d
            public final void c(PcDevice r2) {
                Intrinsics.checkNotNullParameter(r2, "device");
            }

            @Override // com.larus.bmhome.taskskill.service.d
            public final void e() {
            }

            @Override // com.larus.bmhome.taskskill.service.d
            public final void f() {
            }

            @Override // com.larus.bmhome.taskskill.service.d
            public final MutableLiveData<bs8.e> d() {
                return new MutableLiveData();
            }

            @Override // com.larus.bmhome.taskskill.service.d
            public final Object a(Continuation<? super bs8.f> r3) {
                return new bs8.f(null, false);
            }
        }

        private Companion() {
        }

        static {
            b = new Companion();
            c = LazyKt.lazy(new v());
        }

        public static TaskModeService g() {
            return (TaskModeService) c.getValue();
        }

        @Override // com.larus.bmhome.taskskill.service.TaskModeService
        public final boolean a() {
            TaskModeService r0 = g();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.a();
        }

        @Override // com.larus.bmhome.taskskill.service.TaskModeService
        public final boolean b() {
            TaskModeService r0 = g();
            if (r0 != null) goto L7;
            return true;
        L7:
            return r0.b();
        }

        @Override // com.larus.bmhome.taskskill.service.TaskModeService
        public final d d() {
            TaskModeService r0 = g();
            if (r0 == null) goto L7;
            d r1 = r0.d();
            if (r1 == null) goto L7;
            return r1;
        L7:
            return new a();
        }

        @Override // com.larus.bmhome.taskskill.service.TaskModeService
        public final void e(String r2) {
            Intrinsics.checkNotNullParameter(r2, "targetDeviceId");
            TaskModeService r0 = g();
            if (r0 == null) goto L6;
            r0.e(r2);
            return;
        }

        @Override // com.larus.bmhome.taskskill.service.TaskModeService
        public final boolean f(PcDevice r2) {
            Intrinsics.checkNotNullParameter(r2, "device");
            TaskModeService r0 = g();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.f(r2);
        }

        @Override // com.larus.bmhome.taskskill.service.TaskModeService
        public final Object c(String r5, String r6, Continuation<? super Boolean> r7) {
            if ((r7 instanceof TaskModeService$Companion$authorizeDevice$1) == false) goto L7;
            TaskModeService$Companion$authorizeDevice$1 r0 = (TaskModeService$Companion$authorizeDevice$1) r7;
            int r1 = r0.label;
            if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
            r0.label = r1 - Integer.MIN_VALUE;
        L8:
            Object r8 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            ResultKt.throwOnFailure(r8);
        L19:
            boolean r9 = ((Boolean) r8).booleanValue();
        L22:
            return Boxing.boxBoolean(r9);
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r8);
            TaskModeService r10 = g();
            if (r10 == null) goto L20;
            r0.label = 1;
            r8 = r10.c(r5, r6, r0);
            if (r8 != r2) goto L19;
            return r2;
        L20:
            r9 = false;
        L7:
            r0 = new TaskModeService$Companion$authorizeDevice$1(this, r7);
            goto L8
        }
    }

    static {
        a = Companion.b;
    }

    boolean a();

    boolean b();

    Object c(String r1, String r2, Continuation<? super Boolean> r3);

    d d();

    void e(String r1);

    boolean f(PcDevice r1);
}
