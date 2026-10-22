package com.obric.assistant.common.spi.toast;

import android.content.Context;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u0015\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096\u0001¨\u0006\t"}, d2 = {"Lcom/obric/assistant/common/spi/toast/ObricToastHelperDelegate;", "Lcom/obric/assistant/common/spi/toast/IToastHelper;", "<init>", "()V", "createToastHolder", NameKeys.UnloadStrategy_No_Strategy, "context", "Landroid/content/Context;", "resolveContext", "obric_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricToastHelperDelegate implements IToastHelper {
    public static final ObricToastHelperDelegate b = null;
    public final /* synthetic */ IToastHelper a;

    static {
        b = new ObricToastHelperDelegate();
    }

    @Override // com.obric.assistant.common.spi.toast.IToastHelper
    public final Object createToastHolder(Context r2) {
        return this.a.createToastHolder(r2);
    }

    @Override // com.obric.assistant.common.spi.toast.IToastHelper
    public final Context resolveContext(Context r2) {
        return this.a.resolveContext(r2);
    }

    private ObricToastHelperDelegate() {
        IToastHelper r0 = (IToastHelper) ServiceManager.get().getService(IToastHelper.class);
        if (r0 != null) goto L5;
        r0 = new DefaultToastHelper();
    L5:
        this.a = r0;
    }
}
