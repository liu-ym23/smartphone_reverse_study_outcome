package com.obric.assistant.common.spi.toast;

import android.content.Context;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"Lcom/obric/assistant/common/spi/toast/DefaultToastHelper;", "Lcom/obric/assistant/common/spi/toast/IToastHelper;", "<init>", "()V", "resolveContext", "Landroid/content/Context;", "context", "createToastHolder", NameKeys.UnloadStrategy_No_Strategy, "obric_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultToastHelper implements IToastHelper {
    public DefaultToastHelper() {
    }

    @Override // com.obric.assistant.common.spi.toast.IToastHelper
    public final Object createToastHolder(Context r1) {
        return null;
    }

    @Override // com.obric.assistant.common.spi.toast.IToastHelper
    public final Context resolveContext(Context r1) {
        return r1;
    }
}
