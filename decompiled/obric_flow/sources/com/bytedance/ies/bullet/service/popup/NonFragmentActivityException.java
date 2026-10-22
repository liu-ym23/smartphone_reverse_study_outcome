package com.bytedance.ies.bullet.service.popup;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ies/bullet/service/popup/NonFragmentActivityException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class NonFragmentActivityException extends Exception {
    public NonFragmentActivityException() {
        super("context must be FragmentActivity or it's child class");
    }
}
