package com.obric.assistant.interaction.impl;

import com.obric.assistant.settings.LockedUseAuthSettingItem;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ObricShowOnLockedServiceImpl$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

    static {
        int[] r0 = new int[LockedUseAuthSettingItem.values().length];
        r0[LockedUseAuthSettingItem.CHAT_AND_ONLINE_QA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
    L19:
        r0[LockedUseAuthSettingItem.SIMPLE_COMMAND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
    L27:
        r0[LockedUseAuthSettingItem.LOCAL_APP_DATA.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
    L21:
        r0[LockedUseAuthSettingItem.GLOBAL_MEMORY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
    L23:
        r0[LockedUseAuthSettingItem.AUTO_GUI.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
    L17:
        r0[LockedUseAuthSettingItem.CHAT_HISTORY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
    L9:
        $EnumSwitchMapping$0 = r0;
    }
}
