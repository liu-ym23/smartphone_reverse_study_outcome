package com.bytedance.ai.api;

import android.app.Activity;
import android.net.Uri;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0005H&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ai/api/AppletHealthService;", "", "registerAIBridgeMethods", "", "consumeBusinessDeepLink", "", com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY, "Landroid/app/Activity;", "uri", "Landroid/net/Uri;", "finishAfterConsume", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface AppletHealthService {
    boolean b(Activity r1, Uri r10, boolean r11);

    void c();
}
