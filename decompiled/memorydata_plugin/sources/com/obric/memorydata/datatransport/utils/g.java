package com.obric.memorydata.datatransport.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/datatransport/utils/EvaluationUtils;", "", "<init>", "()V", "TAG", "", "getTypeDesc", "type", "", "data_transport_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f9841a = null;

    static {
        f9841a = new g();
    }

    private g() {
    }

    public final String a(int r1) {
        if (r1 != 101) goto L5;
        return "短信";
    L5:
        if (r1 != 601) goto L7;
        return "便签";
    L7:
        if (r1 != 201) goto L9;
        return "联系人";
    L9:
        if (r1 != 202) goto L11;
        return "通话记录";
    L11:
        if (r1 != 301) goto L13;
        return "图像";
    L13:
        if (r1 == 302) goto L15;
        return "";
    L15:
        return "相册";
    }
}
