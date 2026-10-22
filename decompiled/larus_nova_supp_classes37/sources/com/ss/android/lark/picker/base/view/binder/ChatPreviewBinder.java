package com.ss.android.lark.picker.base.view.binder;

import android.content.Context;
import com.bytedance.i18n.claymore.PluginServiceLoader;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y1b.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/ChatPreviewBinder;", "Lcom/ss/android/lark/picker/base/view/binder/IChatPreviewBinder;", "<init>", "()V", "isEnableChatPreview", "", "()Z", "setEnableChatPreview", "(Z)V", "scene", "", "getScene", "()Ljava/lang/String;", "setScene", "(Ljava/lang/String;)V", "startPreview", "", "context", "Landroid/content/Context;", "data", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class ChatPreviewBinder implements IChatPreviewBinder {
    private boolean isEnableChatPreview;
    private String scene;

    public ChatPreviewBinder() {
        this.scene = "";
    }

    @Override // com.ss.android.lark.picker.base.view.binder.IChatPreviewBinder
    public String getScene() {
        return this.scene;
    }

    @Override // com.ss.android.lark.picker.base.view.binder.IChatPreviewBinder
    public boolean isEnableChatPreview() {
        return this.isEnableChatPreview;
    }

    @Override // com.ss.android.lark.picker.base.view.binder.IChatPreviewBinder
    public void setEnableChatPreview(boolean r1) {
        this.isEnableChatPreview = r1;
    }

    @Override // com.ss.android.lark.picker.base.view.binder.IChatPreviewBinder
    public void setScene(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.scene = r2;
    }

    @Override // com.ss.android.lark.picker.base.view.binder.IChatPreviewBinder
    public void startPreview(Context r2, SearchBaseInfo r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "data");
        a r4 = (a) PluginServiceLoader.loadFirstOrNull(a.class);
        if (r4 == null) goto L6;
        v3c.a.a(r3);
        getScene();
        r4.a();
        return;
    }
}
