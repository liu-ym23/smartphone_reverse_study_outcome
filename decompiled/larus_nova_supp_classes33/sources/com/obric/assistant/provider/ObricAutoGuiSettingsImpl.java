package com.obric.assistant.provider;

import android.net.Uri;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.assistant.settings.IObricAutoBlacklistSettingsNotifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/provider/ObricAutoGuiSettingsImpl;", "Lcom/obric/assistant/settings/IObricAutoBlacklistSettingsNotifier;", "<init>", "()V", "notifyAppStateChanged", "", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAutoGuiSettingsImpl implements IObricAutoBlacklistSettingsNotifier {
    public ObricAutoGuiSettingsImpl() {
    }

    @Override // com.obric.assistant.settings.IObricAutoBlacklistSettingsNotifier
    public final void a() {
        List r0 = ObricAutoAppBlacklistSettingProvider.b;
        Iterator r1 = ((ArrayList) ObricAutoAppBlacklistSettingProvider.d).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Uri r2 = (Uri) r1.next();
        IAppContext.a.getApplication().getContentResolver().notifyChange(r2, null);
        goto L4
    }
}
