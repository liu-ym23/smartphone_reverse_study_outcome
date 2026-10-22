package com.bytedance.android.live.base;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0016R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR<\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u000f\u0010\u0010\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/base/b;", "", "", "enableEnter", "Z", "getEnableEnter", "()Z", "setEnableEnter", "(Z)V", "enableDelete", "a", "setEnableDelete", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "whiteIdList", "Ljava/util/ArrayList;", "getWhiteIdList", "()Ljava/util/ArrayList;", "setWhiteIdList", "(Ljava/util/ArrayList;)V", "getWhiteIdList$annotations", "()V", "<init>", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("liveroom_negative_enable_delete_room")
    private boolean enableDelete;

    @SerializedName("prestream_positive_enable_enter_room")
    private boolean enableEnter;

    @SerializedName("support_feedback_id_list")
    private ArrayList<Long> whiteIdList;

    public b() {
        this.whiteIdList = new ArrayList();
    }

    public final boolean a() {
        return this.enableDelete;
    }

    public final boolean b(long r4) {
        if (this.enableEnter == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L15;
        ArrayList<Long> r1 = this.whiteIdList;
        if (r1 == null) goto L15;
        if (r1.contains(Long.valueOf(r4)) != true) goto L15;
        return true;
    L15:
        return false;
    L5:
        if (this.enableDelete == true) goto L8;
        r0 = false;
        goto L9
    }
}
