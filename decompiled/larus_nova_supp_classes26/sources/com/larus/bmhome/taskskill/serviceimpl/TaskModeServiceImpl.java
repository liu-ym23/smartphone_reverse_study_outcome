package com.larus.bmhome.taskskill.serviceimpl;

import com.larus.bmhome.taskskill.PcDeviceListProvider;
import com.larus.bmhome.taskskill.l2;
import com.larus.bmhome.taskskill.m2;
import com.larus.bmhome.taskskill.model.PcDevice;
import com.larus.bmhome.taskskill.network.PcDeviceRepository;
import com.larus.bmhome.taskskill.service.TaskModeService;
import com.larus.bmhome.taskskill.service.d;
import com.larus.dispatcher.api.GetAllDevicesRepo;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.im.internal.jni.bean.DispatchCommand;
import com.larus.im.internal.jni.bean.DispatchCommandPayload;
import com.larus.im.internal.jni.bean.OmniDispatchCommandRequest;
import com.larus.im.internal.jni.bean.OmniDispatchCommandResponse;
import com.larus.platform.service.n0;
import com.larus.platform.service.o;
import com.larus.platform.service.p1;
import com.larus.utils.logger.FLogger;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u0014"}, d2 = {"Lcom/larus/bmhome/taskskill/serviceimpl/TaskModeServiceImpl;", "Lcom/larus/bmhome/taskskill/service/TaskModeService;", "<init>", "()V", "createPcDeviceListProviderInterface", "Lcom/larus/bmhome/taskskill/service/PcDeviceListProviderInterface;", "needUpgrade", "", "device", "Lcom/larus/bmhome/taskskill/model/PcDevice;", "authorizeDevice", "targetDeviceId", "", "authTicket", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "remoteControlEnable", "shouldUseMfaForDeviceAuthorization", "requestEnableControlPermission", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskModeServiceImpl implements TaskModeService {

    public static final class a {
    }

    public static final class b implements IIMCallback<OmniDispatchCommandResponse> {
        public final /* synthetic */ String a;

        public final boolean mustInMain() {
            return !y0.a();
        }

        public b(String r1) {
            this.a = r1;
        }

        public final void onFailure(IIMError r4) {
            Intrinsics.checkNotNullParameter(r4, "error");
            Intrinsics.checkNotNullParameter(r4, "error");
            FLogger.a.e("TaskModeServiceImpl", "[requestEnableControlPermission] failed, deviceId=" + this.a + ", code=" + r4.getCode() + ", msg=" + r4.getTips());
        }

        public final void onSuccess(Object r3) {
            Intrinsics.checkNotNullParameter((OmniDispatchCommandResponse) r3, "result");
            FLogger.a.i("TaskModeServiceImpl", "[requestEnableControlPermission] success, deviceId=" + this.a);
        }
    }

    static {
    }

    public TaskModeServiceImpl() {
    }

    @Override // com.larus.bmhome.taskskill.service.TaskModeService
    public final boolean b() {
        if (n0.a.b() == false) goto L5;
    L7:
        return false;
    L5:
        if (p1.a.i() == false) goto L7;
        return true;
    }

    @Override // com.larus.bmhome.taskskill.service.TaskModeService
    public final d d() {
        return new PcDeviceListProvider();
    }

    @Override // com.larus.bmhome.taskskill.service.TaskModeService
    public final boolean a() {
        return l2.c();
    }

    @Override // com.larus.bmhome.taskskill.service.TaskModeService
    public final void e(String r19) {
        Intrinsics.checkNotNullParameter(r19, "targetDeviceId");
        GetAllDevicesRepo r1 = GetAllDevicesRepo.a;
        Integer r2 = GetAllDevicesRepo.c(r19);
        if (r2 == null) goto L5;
        int r3 = r2.intValue();
    L6:
        com.larus.im.d.b().sendDispatchCommand(new OmniDispatchCommandRequest(r19, r3, new DispatchCommandPayload(DispatchCommand.DEVICE_ENABLE_CONTROL_REQUEST, UUID.randomUUID().toString(), null, null, o.a.getDeviceId(), null, 0, null, null, 492, null)), new b(r19));
        return;
    L5:
        r3 = 0;
        goto L6
    }

    @Override // com.larus.bmhome.taskskill.service.TaskModeService
    public final boolean f(PcDevice r2) {
        Intrinsics.checkNotNullParameter(r2, "device");
        return m2.a(r2);
    }

    @Override // com.larus.bmhome.taskskill.service.TaskModeService
    public final Object c(String r5, String r6, Continuation<? super Boolean> r7) {
        if ((r7 instanceof TaskModeServiceImpl$authorizeDevice$1) == false) goto L7;
        TaskModeServiceImpl$authorizeDevice$1 r0 = (TaskModeServiceImpl$authorizeDevice$1) r7;
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
        Object r9 = ((Result) r8).unbox-impl();
    L18:
        return Boxing.boxBoolean(Result.isSuccess-impl(r9));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        PcDeviceRepository r10 = PcDeviceRepository.a;
        r0.label = 1;
        r9 = r10.a(r5, r6, r0);
        if (r9 != r2) goto L18;
        return r2;
    L7:
        r0 = new TaskModeServiceImpl$authorizeDevice$1(this, r7);
        goto L8
    }
}
