package com.bytedance.forest.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/forest/model/Status;", "", "forest_release"}, k = 1, mv = {1, 4, 0})
public final enum Status extends Enum<Status> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Status f4356a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Status f4357b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Status f4358c = null;
    public static final Status d = null;
    public static final /* synthetic */ Status[] e = null;

    static {
        Status r5 = new Status("PENDING", 0);
        f4356a = r5;
        Status r10 = new Status("FETCHING", 1);
        f4357b = r10;
        Status r11 = new Status("FINISHED", 2);
        f4358c = r11;
        Status r12 = new Status("CANCELED", 3);
        d = r12;
        e = new Status[]{r5, r10, r11, r12};
    }

    public Status(String r5, int r10) {
        super(r5, r10);
    }

    public static Status valueOf(String r5) {
        return (Status) Enum.valueOf(Status.class, r5);
    }

    public static Status[] values() {
        return (Status[]) e.clone();
    }
}
