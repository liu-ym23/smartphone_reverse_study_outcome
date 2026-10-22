package com.bytedance.lego.init.monitor;

import com.bytedance.crash.entity.EventBody;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/lego/init/monitor/Category;", "", "", EventBody.KEY_VALUE, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "CHECK_PERIOD_EXCEPTION", "ON_PERIOD_TIMEOUT", "ON_PERIOD_EXCEPTION", "INIT_TASK_IN_MAIN", "INSTANCE_CLASS_EXCEPTION", "TASK_COUNT_EXCEPTION", "RUN_TAK_EXCEPTION", "PERIOD_TIMEOUT_EXCEPTION", "TASK_TIMEOUT_EXCEPTION", "TASK_TIMEOUT_EXCEPTION_REAL", "OTHER_EXCEPTION", "initscheduler_release"}, k = 1, mv = {1, 4, 0})
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
        Category r10 = new Category("CHECK_PERIOD_EXCEPTION", 0, "check_period_exception");
        CHECK_PERIOD_EXCEPTION = r10;
        Category r11 = new Category("ON_PERIOD_TIMEOUT", 1, "on_period_timeout");
        ON_PERIOD_TIMEOUT = r11;
        Category r12 = new Category("ON_PERIOD_EXCEPTION", 2, "on_period_exception");
        ON_PERIOD_EXCEPTION = r12;
        Category r13 = new Category("INIT_TASK_IN_MAIN", 3, "init_tasks_in_main");
        INIT_TASK_IN_MAIN = r13;
        Category r14 = new Category("INSTANCE_CLASS_EXCEPTION", 4, "instance_class_exception");
        INSTANCE_CLASS_EXCEPTION = r14;
        Category r15 = new Category("TASK_COUNT_EXCEPTION", 5, "task_count_exception");
        TASK_COUNT_EXCEPTION = r15;
        Category r16 = new Category("RUN_TAK_EXCEPTION", 6, "run_task_exception");
        RUN_TAK_EXCEPTION = r16;
        Category r17 = new Category("PERIOD_TIMEOUT_EXCEPTION", 7, "period_timeout_exception");
        PERIOD_TIMEOUT_EXCEPTION = r17;
        Category r18 = new Category("TASK_TIMEOUT_EXCEPTION", 8, "task_timeout_exception");
        TASK_TIMEOUT_EXCEPTION = r18;
        Category r19 = new Category("TASK_TIMEOUT_EXCEPTION_REAL", 9, "task_timeout_exception_real");
        TASK_TIMEOUT_EXCEPTION_REAL = r19;
        Category r20 = new Category("OTHER_EXCEPTION", 10, "other_exception");
        OTHER_EXCEPTION = r20;
        $VALUES = new Category[]{r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20};
    }

    protected Category(String r10, int r11, String r12) {
        Intrinsics.checkParameterIsNotNull(r12, EventBody.KEY_VALUE);
        super(r10, r11);
        this.value = r12;
    }

    public static Category valueOf(String r10) {
        return (Category) Enum.valueOf(Category.class, r10);
    }

    public static Category[] values() {
        return (Category[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }
}
