package com.bytedance.bpea.entry.api.device.info;

import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.ReplayUIStateCode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, ReplayUIStateCode.IS_FOLD_OPEN})
final class CookiesManagerEntry$Companion$setCookieUnsafe$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ValueCallback $callback;
    final /* synthetic */ CookieManager $this_setCookieUnsafe;
    final /* synthetic */ String $url;
    final /* synthetic */ String $value;

    public CookiesManagerEntry$Companion$setCookieUnsafe$2(CookieManager r1, String r2, String r3, ValueCallback r4) {
        this.$this_setCookieUnsafe = r1;
        this.$url = r2;
        this.$value = r3;
        this.$callback = r4;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1610invoke() {
        this.$this_setCookieUnsafe.setCookie(this.$url, this.$value, this.$callback);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1610invoke();
        return Unit.INSTANCE;
    }
}
