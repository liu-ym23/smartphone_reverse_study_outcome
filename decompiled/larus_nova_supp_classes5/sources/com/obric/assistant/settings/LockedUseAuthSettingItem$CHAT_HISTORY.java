package com.obric.assistant.settings;

import com.obric.assistant.ObricSettingsAuthenticationType;
import com.obric.assistant.t1;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\u00052\b\b\u0001\u0010\n\u001a\u00020\bH\u0016¨\u0006\u000b"}, d2 = {"com/obric/assistant/settings/LockedUseAuthSettingItem.CHAT_HISTORY", "Lcom/obric/assistant/settings/LockedUseAuthSettingItem;", "isEnabled", "", "saveEnabled", "", "enabled", "getAuthType", "", "saveAuthType", EffectConfiguration.KEY_TYPE, "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LockedUseAuthSettingItem$CHAT_HISTORY extends LockedUseAuthSettingItem {
    public int getAuthType() {
        return t1.a.Q1();
    }

    public boolean isEnabled() {
        if (getAuthType() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public void saveAuthType(@ObricSettingsAuthenticationType int r2) {
        t1.a.F0(r2);
    }

    public void saveEnabled(boolean r1) {
        if (r1 == false) goto L4;
        int r2 = 2;
    L5:
        saveAuthType(r2);
        return;
    L4:
        r2 = 0;
        goto L5
    }

    public LockedUseAuthSettingItem$CHAT_HISTORY(String r3, int r4) {
        super(r3, r4, "authentication_type_of_chat_history_access_on_lock_screen", null);
    }
}
