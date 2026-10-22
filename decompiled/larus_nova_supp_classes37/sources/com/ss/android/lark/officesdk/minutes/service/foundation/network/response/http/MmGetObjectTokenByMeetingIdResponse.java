package com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\u0012(\b\u0002\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\u0004\b\u0006\u0010\u0007R>\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/response/http/MmGetObjectTokenByMeetingIdResponse;", "Ljava/io/Serializable;", "bizIdToTokenMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "<init>", "(Ljava/util/HashMap;)V", "getBizIdToTokenMap", "()Ljava/util/HashMap;", "setBizIdToTokenMap", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmGetObjectTokenByMeetingIdResponse implements Serializable {

    @SerializedName("biz_id_to_token")
    private HashMap<String, String> bizIdToTokenMap;

    public MmGetObjectTokenByMeetingIdResponse() {
        HashMap r0 = null;
        this(r0, 1, r0);
    }

    public final HashMap<String, String> getBizIdToTokenMap() {
        return this.bizIdToTokenMap;
    }

    public MmGetObjectTokenByMeetingIdResponse(HashMap<String, String> r1) {
        this.bizIdToTokenMap = r1;
    }

    public final void setBizIdToTokenMap(HashMap<String, String> r1) {
        this.bizIdToTokenMap = r1;
    }

    public /* synthetic */ MmGetObjectTokenByMeetingIdResponse(HashMap r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
