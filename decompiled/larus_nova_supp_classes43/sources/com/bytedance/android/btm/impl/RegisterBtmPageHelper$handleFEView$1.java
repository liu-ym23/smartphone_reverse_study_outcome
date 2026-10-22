package com.bytedance.android.btm.impl;

import com.byted.cast.sink.api.IAPI;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
final class RegisterBtmPageHelper$handleFEView$1 extends Lambda implements Function0<String> {
    final /* synthetic */ String $btm;
    final /* synthetic */ String $sourceBtmToken;
    final /* synthetic */ String $viewClassName;

    public RegisterBtmPageHelper$handleFEView$1(String r1, String r10, String r11) {
        this.$btm = r1;
        this.$sourceBtmToken = r10;
        this.$viewClassName = r11;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m633invoke() {
        return "btm: " + this.$btm + ", sourceBtmToken: " + this.$sourceBtmToken + ", view: " + this.$viewClassName;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m633invoke();
    }
}
