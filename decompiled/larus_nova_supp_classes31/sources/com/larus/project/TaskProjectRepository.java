package com.larus.project;

import com.larus.bmhome.taskskill.service.IProjectListDataSource;
import com.larus.im.internal.jni.bean.OmniProject;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class TaskProjectRepository {
    public static final TaskProjectRepository a = null;

    static {
        a = new TaskProjectRepository();
    }

    public TaskProjectRepository() {
    }

    public final Object a(String r5, Continuation<? super Result<i>> r6) {
        if ((r6 instanceof TaskProjectRepository$getProject$1) == false) goto L7;
        TaskProjectRepository$getProject$1 r0 = (TaskProjectRepository$getProject$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
        Object r8 = ((Result) r7).unbox-impl();
    L22:
        if (Result.isSuccess-impl(r8) == false) goto L30;
        com.larus.bmhome.taskskill.service.h r9 = (com.larus.bmhome.taskskill.service.h) r8;
        if (r9 == null) goto L28;
        OmniProject r10 = r9.a;
        if (r10 == null) goto L28;
        r8 = x.a(r10);
    L28:
        r8 = null;
    L30:
        return Result.constructor-impl(r8);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        IProjectListDataSource r11 = (IProjectListDataSource) ServiceManager.get().getService(IProjectListDataSource.class);
        if (r11 != null) goto L18;
        Result.Companion r12 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("project list data source not found")));
    L18:
        r0.label = 1;
        r8 = r11.f(r5, r0);
        if (r8 != r2) goto L22;
        return r2;
    L7:
        r0 = new TaskProjectRepository$getProject$1(this, r6);
        goto L8
    }
}
