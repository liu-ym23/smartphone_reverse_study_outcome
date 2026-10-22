package com.bytedance.android.btm.impl;

import com.byted.cast.sink.api.IAPI;
import com.bytedance.android.btm.impl.page.lifecycle.ResumeFilterReason;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
final class RegisterBtmPageHelper$handleFEV2Core$7 extends Lambda implements Function0<String> {
    final /* synthetic */ String $btm;
    final /* synthetic */ String $pageClassName;
    final /* synthetic */ ResumeFilterReason $reason;

    public RegisterBtmPageHelper$handleFEV2Core$7(String r1, String r10, ResumeFilterReason r11) {
        this.$pageClassName = r1;
        this.$btm = r10;
        this.$reason = r11;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m632invoke() {
        return this.$pageClassName + ',' + this.$btm + " register\nreason: " + this.$reason;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m632invoke();
    }
}
