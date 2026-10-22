package com.bytedance.lego.init.monitor;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/lego/init/monitor/Category;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CHECK_PERIOD_EXCEPTION", "ON_PERIOD_TIMEOUT", "ON_PERIOD_EXCEPTION", "INIT_TASK_IN_MAIN", "INSTANCE_CLASS_EXCEPTION", "TASK_COUNT_EXCEPTION", "RUN_TAK_EXCEPTION", "PERIOD_TIMEOUT_EXCEPTION", "TASK_TIMEOUT_EXCEPTION", "TASK_TIMEOUT_EXCEPTION_REAL", "OTHER_EXCEPTION", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
public final enum Category extends Enum<Category> {
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Category[] f6755a = null;
    private final String value;

    static {
        Category r5 = new Category("CHECK_PERIOD_EXCEPTION", 0, "check_period_exception");
        CHECK_PERIOD_EXCEPTION = r5;
        Category r10 = new Category("ON_PERIOD_TIMEOUT", 1, "on_period_timeout");
        ON_PERIOD_TIMEOUT = r10;
        Category r11 = new Category("ON_PERIOD_EXCEPTION", 2, "on_period_exception");
        ON_PERIOD_EXCEPTION = r11;
        Category r12 = new Category("INIT_TASK_IN_MAIN", 3, "init_tasks_in_main");
        INIT_TASK_IN_MAIN = r12;
        Category r13 = new Category("INSTANCE_CLASS_EXCEPTION", 4, "instance_class_exception");
        INSTANCE_CLASS_EXCEPTION = r13;
        Category r14 = new Category("TASK_COUNT_EXCEPTION", 5, "task_count_exception");
        TASK_COUNT_EXCEPTION = r14;
        Category r15 = new Category("RUN_TAK_EXCEPTION", 6, "run_task_exception");
        RUN_TAK_EXCEPTION = r15;
        Category r16 = new Category("PERIOD_TIMEOUT_EXCEPTION", 7, "period_timeout_exception");
        PERIOD_TIMEOUT_EXCEPTION = r16;
        Category r17 = new Category("TASK_TIMEOUT_EXCEPTION", 8, "task_timeout_exception");
        TASK_TIMEOUT_EXCEPTION = r17;
        Category r18 = new Category("TASK_TIMEOUT_EXCEPTION_REAL", 9, "task_timeout_exception_real");
        TASK_TIMEOUT_EXCEPTION_REAL = r18;
        Category r19 = new Category("OTHER_EXCEPTION", 10, "other_exception");
        OTHER_EXCEPTION = r19;
        f6755a = new Category[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19};
    }

    public Category(String r5, int r10, String r11) {
        super(r5, r10);
        this.value = r11;
    }

    public static Category valueOf(String r5) {
        return (Category) Enum.valueOf(Category.class, r5);
    }

    public static Category[] values() {
        return (Category[]) f6755a.clone();
    }

    public final String getValue() {
        return this.value;
    }
}
