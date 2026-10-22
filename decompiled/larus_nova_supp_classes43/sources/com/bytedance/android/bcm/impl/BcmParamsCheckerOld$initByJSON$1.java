package com.bytedance.android.bcm.impl;

import com.byted.cast.sink.api.IAPI;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
final class BcmParamsCheckerOld$initByJSON$1 extends Lambda implements Function0<String> {
    public static final BcmParamsCheckerOld$initByJSON$1 INSTANCE = null;

    static {
        INSTANCE = new BcmParamsCheckerOld$initByJSON$1();
    }

    public BcmParamsCheckerOld$initByJSON$1() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m488invoke() {
        StringBuilder r0 = new StringBuilder("initByJSON, length: ");
        boolean r1 = BcmParamsCheckerOld.a;
        List r10 = BcmParamsCheckerOld.d.a().a();
        if (r10 == null) goto L5;
        Integer r11 = Integer.valueOf(r10.size());
    L6:
        r0.append(r11);
        return r0.toString();
    L5:
        r11 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m488invoke();
    }
}
