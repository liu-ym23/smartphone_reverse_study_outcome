package com.larus.settings.provider.dora;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R&\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/larus/settings/provider/dora/DoraExpRespConfig;", "", "doraExpRespList", "", "", "<init>", "(Ljava/util/List;)V", "getDoraExpRespList", "()Ljava/util/List;", "setDoraExpRespList", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class DoraExpRespConfig {

    @SerializedName("dora_exp_response")
    private List<Integer> doraExpRespList;

    public DoraExpRespConfig() {
        List r0 = null;
        this(r0, 1, r0);
    }

    public final List<Integer> getDoraExpRespList() {
        return this.doraExpRespList;
    }

    public DoraExpRespConfig(List<Integer> r1) {
        this.doraExpRespList = r1;
    }

    public final void setDoraExpRespList(List<Integer> r1) {
        this.doraExpRespList = r1;
    }

    public /* synthetic */ DoraExpRespConfig(List r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = CollectionsKt.emptyList();
    L5:
        this(r1);
    }
}
