package com.obric.assistant.common.spi.toast;

import android.content.Context;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/common/spi/toast/IToastHelper;", NameKeys.UnloadStrategy_No_Strategy, "resolveContext", "Landroid/content/Context;", "context", "createToastHolder", "obric_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IToastHelper {
    Object createToastHolder(Context r1);

    Context resolveContext(Context r1);
}
