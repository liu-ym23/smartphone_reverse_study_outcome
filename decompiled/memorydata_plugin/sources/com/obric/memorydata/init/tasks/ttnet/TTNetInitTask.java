package com.obric.memorydata.init.tasks.ttnet;

import android.app.Application;
import android.content.Context;
import com.bytedance.lego.init.model.IInitTask;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.ttnet.TTNetInitHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/init/tasks/ttnet/TTNetInitTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "<init>", "()V", "run", "", "Companion", "init_task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TTNetInitTask extends IInitTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9928a = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/init/tasks/ttnet/TTNetInitTask$Companion;", "", "<init>", "()V", "TAG", "", "init_task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f9928a = new a(null);
    }

    public TTNetInitTask() {
    }

    @Override // java.lang.Runnable
    public void run() {
        new TTNetInitHelper().initTTNet((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"));
    }
}
