package com.obric.memorydata.task.condition;

import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/task/condition/ScreenOnCondition;", "Lcom/obric/memorydata/task/condition/AbstractScreenCondition;", "<init>", "()V", "notifyConditionChangeListener", "", "listener", "Lcom/obric/memorydata/task/condition/ConditionChangeListener;", "getUnsatisfiedReason", "", "isSatisfied", "", "Companion", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class j extends com.obric.memorydata.task.condition.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12890a = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/task/condition/ScreenOnCondition$Companion;", "", "<init>", "()V", "TAG", "", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f12890a = new a(null);
    }

    public j() {
    }

    @Override // com.obric.memorydata.task.condition.a
    public void a(d r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.memorydata.plugin");
        boolean r3 = c();
        RunLog.INSTANCE.debug("ScreenOnCondition", "screen on status => " + r3);
        if (r5 == null) goto L6;
        r5.onConditionChange(Condition.SCREEN_ON, r3);
        return;
    }

    @Override // com.obric.memorydata.task.condition.b
    public boolean c() {
        return i();
    }

    @Override // com.obric.memorydata.task.condition.b
    public String g() {
        if (c() == false) goto L7;
        return "";
    L7:
        return "ScreenOnCondition(isScreenOn=" + i() + ')';
    }
}
