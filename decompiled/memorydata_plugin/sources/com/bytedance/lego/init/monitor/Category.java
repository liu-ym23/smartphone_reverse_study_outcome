package com.bytedance.lego.init.monitor;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/lego/init/monitor/Category;", "", EventBody.KEY_VALUE, "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CHECK_PERIOD_EXCEPTION", "ON_PERIOD_TIMEOUT", "ON_PERIOD_EXCEPTION", "INIT_TASK_IN_MAIN", "INSTANCE_CLASS_EXCEPTION", "TASK_COUNT_EXCEPTION", "RUN_TAK_EXCEPTION", "PERIOD_TIMEOUT_EXCEPTION", "TASK_TIMEOUT_EXCEPTION", "TASK_TIMEOUT_EXCEPTION_REAL", "OTHER_EXCEPTION", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
public final enum Category extends Enum<Category> {
    private static final /* synthetic */ Category[] $VALUES = null;
    public static final Category CHECK_PERIOD_EXCEPTION = null;
    public static final Category INIT_TASK_IN_MAIN = null;
    public static final Category INSTANCE_CLASS_EXCEPTION = null;
    public static final Category ON_PERIOD_EXCEPTION = null;
    public static final Category ON_PERIOD_TIMEOUT = null;
    public static final Category OTHER_EXCEPTION = null;
    public static final Category PERIOD_TIMEOUT_EXCEPTION = null;
    public static final Category RUN_TAK_EXCEPTION = null;
    public static final Category TASK_COUNT_EXCEPTION = null;
    public static final Category TASK_TIMEOUT_EXCEPTION = null;
    public static final Category TASK_TIMEOUT_EXCEPTION_REAL = null;
    private final String value;

    static {
        Category r1 = new Category("CHECK_PERIOD_EXCEPTION", 0, "check_period_exception");
        CHECK_PERIOD_EXCEPTION = r1;
        Category r2 = new Category("ON_PERIOD_TIMEOUT", 1, "on_period_timeout");
        ON_PERIOD_TIMEOUT = r2;
        Category r3 = new Category("ON_PERIOD_EXCEPTION", 2, "on_period_exception");
        ON_PERIOD_EXCEPTION = r3;
        Category r4 = new Category("INIT_TASK_IN_MAIN", 3, "init_tasks_in_main");
        INIT_TASK_IN_MAIN = r4;
        Category r5 = new Category("INSTANCE_CLASS_EXCEPTION", 4, "instance_class_exception");
        INSTANCE_CLASS_EXCEPTION = r5;
        Category r6 = new Category("TASK_COUNT_EXCEPTION", 5, "task_count_exception");
        TASK_COUNT_EXCEPTION = r6;
        Category r7 = new Category("RUN_TAK_EXCEPTION", 6, "run_task_exception");
        RUN_TAK_EXCEPTION = r7;
        Category r8 = new Category("PERIOD_TIMEOUT_EXCEPTION", 7, "period_timeout_exception");
        PERIOD_TIMEOUT_EXCEPTION = r8;
        Category r9 = new Category("TASK_TIMEOUT_EXCEPTION", 8, "task_timeout_exception");
        TASK_TIMEOUT_EXCEPTION = r9;
        Category r10 = new Category("TASK_TIMEOUT_EXCEPTION_REAL", 9, "task_timeout_exception_real");
        TASK_TIMEOUT_EXCEPTION_REAL = r10;
        Category r11 = new Category("OTHER_EXCEPTION", 10, "other_exception");
        OTHER_EXCEPTION = r11;
        $VALUES = new Category[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11};
    }

    public Category(String r2, int r3, String r4) {
        Intrinsics.checkParameterIsNotNull(r4, EventBody.KEY_VALUE);
        super(r2, r3);
        this.value = r4;
    }

    public static Category valueOf(String r2) {
        return (Category) ZeusTransformUtils.preCheckCast(Enum.valueOf(Category.class, r2), Category.class, "com.obric.memorydata.plugin");
    }

    public static Category[] values() {
        return (Category[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Category[].class, "com.obric.memorydata.plugin");
    }

    public final String getValue() {
        return this.value;
    }
}
