package com.obric.assistant.interaction.api.service;

import android.content.Intent;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/interaction/api/service/IActivityResultHelperApi;", "", "startActivityForResult", "", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "callback", "Lcom/obric/assistant/interaction/api/service/ActivityResultCallback;", "listener", "Lcom/obric/assistant/interaction/api/service/ActivityProxyListener;", "finishActivitiesExceptChatWindow", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IActivityResultHelperApi {
    void finishActivitiesExceptChatWindow();

    void startActivityForResult(Intent r1, ActivityResultCallback r2);

    void startActivityForResult(ActivityProxyListener r1);
}
