package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0002\n\u000bB\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/ContributeShowResponse;", "", "()V", "data", "Lcom/bytedance/android/live/liveinteract/plantform/model/ContributeShowResponse$ResponseData;", "getData$annotations", "getData", "()Lcom/bytedance/android/live/liveinteract/plantform/model/ContributeShowResponse$ResponseData;", "setData", "(Lcom/bytedance/android/live/liveinteract/plantform/model/ContributeShowResponse$ResponseData;)V", "OwnerHonorInfo", "ResponseData", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ContributeShowResponse implements vh7.h {
    private ResponseData data;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R,\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/ContributeShowResponse$OwnerHonorInfo;", "", "()V", "hitGuestHonorInfoList", "", "Lcom/bytedance/android/live/liveinteract/plantform/model/GuestHonorInfo;", "getHitGuestHonorInfoList$annotations", "getHitGuestHonorInfoList", "()Ljava/util/List;", "setHitGuestHonorInfoList", "(Ljava/util/List;)V", "totalNum", "", "getTotalNum$annotations", "getTotalNum", "()I", "setTotalNum", "(I)V", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class OwnerHonorInfo implements vh7.h {
        private List<GuestHonorInfo> hitGuestHonorInfoList;
        private int totalNum;

        public OwnerHonorInfo() {
        }

        public OwnerHonorInfo(am3.g r5) {
            long r0 = r5.c();
        L4:
            if (r5.f() == (-1)) goto L6;
            am3.h.e(r5);
            goto L4
        L6:
            r5.d(r0);
        }

        @FieldName(name = "hit_guest_honor_info_list")
        public static /* synthetic */ void getHitGuestHonorInfoList$annotations() {
        }

        @FieldName(name = "total_num")
        public static /* synthetic */ void getTotalNum$annotations() {
        }

        public final List<GuestHonorInfo> getHitGuestHonorInfoList() {
            return this.hitGuestHonorInfoList;
        }

        public final int getTotalNum() {
            return this.totalNum;
        }

        public final void setHitGuestHonorInfoList(List<GuestHonorInfo> r1) {
            this.hitGuestHonorInfoList = r1;
        }

        public final void setTotalNum(int r1) {
            this.totalNum = r1;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/ContributeShowResponse$ResponseData;", "", "()V", "ownerHonorInfo", "Lcom/bytedance/android/live/liveinteract/plantform/model/ContributeShowResponse$OwnerHonorInfo;", "getOwnerHonorInfo$annotations", "getOwnerHonorInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/ContributeShowResponse$OwnerHonorInfo;", "setOwnerHonorInfo", "(Lcom/bytedance/android/live/liveinteract/plantform/model/ContributeShowResponse$OwnerHonorInfo;)V", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class ResponseData implements vh7.h {
        private OwnerHonorInfo ownerHonorInfo;

        public ResponseData() {
        }

        public ResponseData(am3.g r5) {
            long r0 = r5.c();
        L4:
            if (r5.f() == (-1)) goto L6;
            am3.h.e(r5);
            goto L4
        L6:
            r5.d(r0);
        }

        @FieldName(name = "owner_honor_info")
        public static /* synthetic */ void getOwnerHonorInfo$annotations() {
        }

        public final OwnerHonorInfo getOwnerHonorInfo() {
            return this.ownerHonorInfo;
        }

        public final void setOwnerHonorInfo(OwnerHonorInfo r1) {
            this.ownerHonorInfo = r1;
        }
    }

    public ContributeShowResponse() {
    }

    public ContributeShowResponse(am3.g r5) {
        long r0 = r5.c();
    L4:
        if (r5.f() == (-1)) goto L6;
        am3.h.e(r5);
        goto L4
    L6:
        r5.d(r0);
    }

    @FieldName(name = "data")
    public static /* synthetic */ void getData$annotations() {
    }

    public final ResponseData getData() {
        return this.data;
    }

    public final void setData(ResponseData r1) {
        this.data = r1;
    }
}
