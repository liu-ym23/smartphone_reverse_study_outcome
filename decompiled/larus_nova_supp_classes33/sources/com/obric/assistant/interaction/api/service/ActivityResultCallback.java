package com.obric.assistant.interaction.api.service;

import android.content.Intent;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/interaction/api/service/ActivityResultCallback;", "", "onSuccess", "", "data", "Landroid/content/Intent;", "onCancel", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ActivityResultCallback {
    void onCancel();

    void onSuccess(Intent r1);
}
