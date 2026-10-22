package com.bytedance.android.livesdk.interactivity.api;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ServiceLookup("com.bytedance.android.livesdk.interactivity.api.HighlightService")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/IHighlightService;", "Lcom/bytedance/android/live/base/IService;", "Lo32/b;", "createHighlightContext", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IHighlightService extends IService {
    o32.b createHighlightContext();
}
