package com.bytedance.sdk.xbridge.cn.runtime.depend;

import androidx.annotation.Keep;
import cj.d;
import gj.b;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ'\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostCalendarDepend;", "", "Lcj/d;", "bridgeContext", "Lgj/b;", "event", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostCalendarEventCallback;", "callback", "", "insertOrUpdate", "(Lcj/d;Lgj/b;Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostCalendarEventCallback;)V", "", "eventId", "deleteEvent", "(Lcj/d;Ljava/lang/String;Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostCalendarEventCallback;)V", "readEvent", "(Lcj/d;Ljava/lang/String;)Lgj/b;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public interface IHostCalendarDepend {
    void deleteEvent(d r5, String r10, IHostCalendarEventCallback r11);

    void insertOrUpdate(d r5, b r10, IHostCalendarEventCallback r11);

    b readEvent(d r5, String r10);
}
