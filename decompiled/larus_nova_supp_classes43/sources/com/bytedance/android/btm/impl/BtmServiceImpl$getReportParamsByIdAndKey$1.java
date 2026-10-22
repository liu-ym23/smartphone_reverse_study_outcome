package com.bytedance.android.btm.impl;

import com.byted.cast.sink.api.IAPI;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
public final class BtmServiceImpl$getReportParamsByIdAndKey$1 extends Lambda implements Function0<String> {
    final /* synthetic */ String $btmId;
    final /* synthetic */ String $key;

    public BtmServiceImpl$getReportParamsByIdAndKey$1(String r1, String r10) {
        this.$btmId = r1;
        this.$key = r10;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m622invoke() {
        return "btmId=" + this.$btmId + ", key=" + this.$key;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m622invoke();
    }
}
