package com.bytedance.ies.bullet.kit.web;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/bullet/kit/web/WebLoadError;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class WebLoadError extends Throwable {
    public WebLoadError(int r5, CharSequence r10, String r11) {
        super("WebLoadError, errorCode: " + r5 + ", desc: " + r10 + ", failingUrl: " + r11);
    }
}
