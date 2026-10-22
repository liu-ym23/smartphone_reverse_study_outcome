package com.larksuite.framework.launch.task;

import android.content.Context;
import com.ss.android.lark.framework.assembly.logger.InitMoltenLogTask;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class AbstractLaunchTask<T> implements ILaunchTask<T> {
    public List<Class<? extends ILaunchTask>> a;
    public final Period b;

    @Override // com.larksuite.framework.launch.task.ILaunchTask
    public void a(Context r1) {
    }

    @Override // com.larksuite.framework.launch.task.ILaunchTask
    public int c() {
        return 0;
    }

    @Override // com.larksuite.framework.launch.task.ILaunchTask
    public boolean g() {
        return this instanceof InitMoltenLogTask;
    }

    public List<Class<? extends ILaunchTask>> i() {
        return null;
    }

    @Override // com.larksuite.framework.launch.task.ILaunchTask
    public final List<Class<? extends ILaunchTask>> e() {
        if (this.a != null) goto L6;
        this.a = i();
    L6:
        return this.a;
    }

    public AbstractLaunchTask() {
        this.b = Period.APP_ONATTACHBASECONTEXT_BEGIN;
        Period r0 = Period.APP_ONCREATE_END;
        TaskAttribute$BoostStage r1 = TaskAttribute$BoostStage.UNKNOWN;
    }

    @Override // com.larksuite.framework.launch.task.ILaunchTask
    public String f() {
        return getClass().getSimpleName();
    }

    @Override // com.larksuite.framework.launch.task.ILaunchTask
    public final Period d() {
        return this.b;
    }

    public final AbstractLaunchTask h(Class r2) {
        if (this.a != null) goto L7;
        List<Class<? extends ILaunchTask>> r0 = i();
        this.a = r0;
        if (r0 != null) goto L7;
        this.a = new ArrayList();
    L7:
        this.a.add(r2);
        return this;
    }
}
