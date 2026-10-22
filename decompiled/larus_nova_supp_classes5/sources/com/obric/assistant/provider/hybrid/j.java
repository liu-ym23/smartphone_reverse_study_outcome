package com.obric.assistant.provider.hybrid;

import android.os.Bundle;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.settings.ObricPersonalContextSettingApiDelegate;
import com.obric.assistant.settings.ToggleName;
import com.obric.assistant.t1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class j implements a {
    static {
    }

    public j() {
    }

    public Bundle call(String r5, Bundle r6) {
        FLogger r7 = FLogger.a;
        r7.i("MemorySettingAbility", "MemorySettingAbility call");
        Bundle r8 = new Bundle();
        r8.putBoolean("o_use_memory", t1.a.getOUseMemoryEnabled());
        r8.putBoolean("personal_info_memory", ObricPersonalContextSettingApiDelegate.b.j(ToggleName.PERSONAL_INFO_MEMORY, true));
        r7.i("MemorySettingAbility", "MemorySettingAbility result:" + r8);
        return r8;
    }
}
