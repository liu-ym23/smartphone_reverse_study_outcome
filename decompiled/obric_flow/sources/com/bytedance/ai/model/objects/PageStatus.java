package com.bytedance.ai.model.objects;

import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/model/objects/PageStatus;", "", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum PageStatus extends Enum<PageStatus> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PageStatus f2286a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PageStatus f2287b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final PageStatus f2288c = null;
    public static final /* synthetic */ PageStatus[] d = null;

    static {
        PageStatus r5 = new PageStatus("NONE", 0);
        PageStatus r10 = new PageStatus("STARTED", 1);
        PageStatus r11 = new PageStatus("LOADING_START", 2);
        f2286a = r11;
        PageStatus r12 = new PageStatus("VISIABLE", 3);
        PageStatus r13 = new PageStatus("LOADING_FINISH", 4);
        f2287b = r13;
        PageStatus r14 = new PageStatus("LOADING_ERROR", 5);
        f2288c = r14;
        PageStatus[] r15 = {r5, r10, r11, r12, r13, r14, new PageStatus("INVISIABLE", 6), new PageStatus("RE_CREATE", 7), new PageStatus("DESTROY", 8)};
        d = r15;
        EnumEntriesKt.enumEntries(r15);
    }

    public PageStatus(String r5, int r10) {
        super(r5, r10);
    }

    public static PageStatus valueOf(String r5) {
        return (PageStatus) Enum.valueOf(PageStatus.class, r5);
    }

    public static PageStatus[] values() {
        return (PageStatus[]) d.clone();
    }
}
