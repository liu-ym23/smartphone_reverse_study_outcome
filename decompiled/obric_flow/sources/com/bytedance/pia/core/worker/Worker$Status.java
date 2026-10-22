package com.bytedance.pia.core.worker;

/* JADX INFO: loaded from: classes2.dex */
public final enum Worker$Status extends Enum<Worker$Status> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Worker$Status f7162a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Worker$Status f7163b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Worker$Status f7164c = null;
    public static final Worker$Status d = null;
    public static final /* synthetic */ Worker$Status[] e = null;

    static {
        Worker$Status r5 = new Worker$Status("Create", 0);
        f7162a = r5;
        Worker$Status r10 = new Worker$Status("Fetching", 1);
        f7163b = r10;
        Worker$Status r11 = new Worker$Status("Ready", 2);
        f7164c = r11;
        Worker$Status r12 = new Worker$Status("Terminate", 3);
        d = r12;
        e = new Worker$Status[]{r5, r10, r11, r12};
    }

    public Worker$Status(String r5, int r10) {
        super(r5, r10);
    }

    public static Worker$Status valueOf(String r5) {
        return (Worker$Status) Enum.valueOf(Worker$Status.class, r5);
    }

    public static Worker$Status[] values() {
        return (Worker$Status[]) e.clone();
    }
}
