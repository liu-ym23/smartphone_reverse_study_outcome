package com.bytedance.ai.ex.widget;

import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/bytedance/ai/ex/widget/IdentityLifecycleOwner;", "Landroidx/lifecycle/LifecycleOwner;", "conversationId", "", "getConversationId", "()Ljava/lang/String;", "botId", "getBotId", "sectionId", "getSectionId", "widget-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IdentityLifecycleOwner extends LifecycleOwner {
    String getBotId();

    String getConversationId();

    String getSectionId();
}
