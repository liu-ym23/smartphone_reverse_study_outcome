package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/GuestHonorInfo;", "", "()V", "iconList", "Lcom/bytedance/android/live/liveinteract/plantform/model/HonorIconContent;", "getIconList$annotations", "getIconList", "()Lcom/bytedance/android/live/liveinteract/plantform/model/HonorIconContent;", "setIconList", "(Lcom/bytedance/android/live/liveinteract/plantform/model/HonorIconContent;)V", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GuestHonorInfo implements vh7.h {
    private HonorIconContent iconList;

    public GuestHonorInfo() {
    }

    public GuestHonorInfo(am3.g r5) {
        long r0 = r5.c();
    L4:
        if (r5.f() == (-1)) goto L6;
        am3.h.e(r5);
        goto L4
    L6:
        r5.d(r0);
    }

    @FieldName(name = "icon_list")
    public static /* synthetic */ void getIconList$annotations() {
    }

    public final HonorIconContent getIconList() {
        return this.iconList;
    }

    public final void setIconList(HonorIconContent r1) {
        this.iconList = r1;
    }
}
