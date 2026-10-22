package com.obric.memorydata.init.tasks;

import android.content.Context;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.lego.init.model.IInitTask;
import com.obric.memorydata.intelligence.b.f;
import com.obric.memorydata.intelligence.datalearning.profile.task.DeleteHomeCompanyProfileTask;
import com.obric.memorydata.intelligence.task.RecalculateUserProfileTask;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.TaskRegister;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0002¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/init/tasks/IntelligenceInitTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "<init>", "()V", "run", "", CommonConsts.APM_INNER_EVENT_COST_INIT, "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class IntelligenceInitTask extends IInitTask {
    public IntelligenceInitTask() {
    }

    private final void a() {
        RunLog.INSTANCE.debug("IntelligenceInitTask", CommonConsts.APM_INNER_EVENT_COST_INIT);
        ThreadPoolContainer.Companion.execute($$Lambda$IntelligenceInitTask$p_U0jHcM2RrXIps5MLMnXP2z9I0.INSTANCE);
    }

    private static final void b() {
        com.obric.memorydata.intelligence.b.e.f9945a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        new f().a();
        com.obric.memorydata.intelligence.b.a.f9936a.c();
        com.obric.memorydata.intelligence.datalearning.profile.a.f9953a.b();
        com.obric.memorydata.intelligence.a.a.f9929a.a();
    }

    public static /* synthetic */ void lambda$p_U0jHcM2RrXIps5MLMnXP2z9I0() {
        b();
    }

    @Override // java.lang.Runnable
    public void run() {
        RunLog.INSTANCE.debug("IntelligenceInitTask", "IntelligenceInitTask run");
        TaskRegister.f12863a.a("RecalculateUserProfileTask", RecalculateUserProfileTask.class);
        TaskRegister.f12863a.a("DeleteHomeCompanyProfileTask", DeleteHomeCompanyProfileTask.class);
        a();
    }
}
