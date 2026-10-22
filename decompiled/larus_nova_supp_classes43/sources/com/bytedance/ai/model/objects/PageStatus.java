package com.bytedance.ai.model.objects;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/model/objects/PageStatus;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "STARTED", "LOADING_START", "VISIABLE", "LOADING_FINISH", "LOADING_ERROR", "INVISIABLE", "RE_CREATE", "DESTROY", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PageStatus extends Enum<PageStatus> {
    public static final PageStatus DESTROY = null;
    public static final PageStatus INVISIABLE = null;
    public static final PageStatus LOADING_ERROR = null;
    public static final PageStatus LOADING_FINISH = null;
    public static final PageStatus LOADING_START = null;
    public static final PageStatus NONE = null;
    public static final PageStatus RE_CREATE = null;
    public static final PageStatus STARTED = null;
    public static final PageStatus VISIABLE = null;
    public static final /* synthetic */ PageStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<PageStatus> getEntries() {
        return b;
    }

    static {
        PageStatus r0 = new PageStatus("NONE", 0);
        NONE = r0;
        PageStatus r1 = new PageStatus("STARTED", 1);
        STARTED = r1;
        PageStatus r10 = new PageStatus("LOADING_START", 2);
        LOADING_START = r10;
        PageStatus r11 = new PageStatus("VISIABLE", 3);
        VISIABLE = r11;
        PageStatus r12 = new PageStatus("LOADING_FINISH", 4);
        LOADING_FINISH = r12;
        PageStatus r13 = new PageStatus("LOADING_ERROR", 5);
        LOADING_ERROR = r13;
        PageStatus r14 = new PageStatus("INVISIABLE", 6);
        INVISIABLE = r14;
        PageStatus r15 = new PageStatus("RE_CREATE", 7);
        RE_CREATE = r15;
        PageStatus r16 = new PageStatus("DESTROY", 8);
        DESTROY = r16;
        PageStatus[] r17 = {r0, r1, r10, r11, r12, r13, r14, r15, r16};
        a = r17;
        b = EnumEntriesKt.enumEntries(r17);
    }

    public static PageStatus[] values() {
        return (PageStatus[]) a.clone();
    }

    public static PageStatus valueOf(String r1) {
        return (PageStatus) a.a(PageStatus.class, r1);
    }

    public PageStatus(String r1, int r10) {
        super(r1, r10);
    }
}
