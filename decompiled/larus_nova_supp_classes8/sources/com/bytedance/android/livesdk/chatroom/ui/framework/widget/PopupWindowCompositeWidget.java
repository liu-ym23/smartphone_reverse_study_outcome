package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.popup.manager.LivePopupWindowManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/PopupWindowCompositeWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PopupWindowCompositeWidget extends MiddlewareRoomWidget {
    public LivePopupWindowManager a;

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        this.a = (LivePopupWindowManager) LivePopupWindowManager.d.getValue();
        if (getContext() == null) goto L8;
        LivePopupWindowManager r0 = this.a;
        if (r0 == null) goto L9;
        r0.b(getContext());
        return;
    L9:
        return;
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        LivePopupWindowManager r0 = this.a;
        if (r0 == null) goto L7;
        if (r0 == null) goto L8;
        r0.c();
        return;
    L8:
        return;
    }

    public PopupWindowCompositeWidget() {
    }
}
