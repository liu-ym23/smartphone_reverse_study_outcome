package com.bytedance.android.livesdk.interactivity.api;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ServiceLookup("com.bytedance.android.livesdk.interactivity.api.QuickCommentService")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0002H&J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/IQuickCommentService;", "Lcom/bytedance/android/live/base/IService;", "Ljava/lang/Class;", "Lcom/bytedance/ies/sdk/widgets/Widget;", "getQuickCommentWidgetClass", "Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;", "roomContext", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/android/livesdk/interactivity/api/quickcomment/f;", "getQuickCommentService", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IQuickCommentService extends IService {
    com.bytedance.android.livesdk.interactivity.api.quickcomment.f getQuickCommentService(MiddlewareRoomContext r1, DataCenter r2);

    Class<? extends Widget> getQuickCommentWidgetClass();
}
