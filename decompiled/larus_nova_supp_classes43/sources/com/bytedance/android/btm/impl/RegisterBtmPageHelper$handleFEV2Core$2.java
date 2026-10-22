package com.bytedance.android.btm.impl;

import com.byted.cast.sink.api.IAPI;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
final class RegisterBtmPageHelper$handleFEV2Core$2 extends Lambda implements Function0<String> {
    public static final RegisterBtmPageHelper$handleFEV2Core$2 INSTANCE = null;

    static {
        INSTANCE = new RegisterBtmPageHelper$handleFEV2Core$2();
    }

    public RegisterBtmPageHelper$handleFEV2Core$2() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m629invoke() {
        return "pageBtm is null or empty";
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m629invoke();
    }
}
