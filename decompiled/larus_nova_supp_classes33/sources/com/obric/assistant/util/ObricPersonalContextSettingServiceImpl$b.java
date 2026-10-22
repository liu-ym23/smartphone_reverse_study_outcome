package com.obric.assistant.util;

import com.obric.assistant.permission.IObricPermissionService$Companion;
import com.obric.assistant.settings.ToggleName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public /* synthetic */ class ObricPersonalContextSettingServiceImpl$b {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[ToggleName.values().length];
        r0[ToggleName.AI_DIARY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
    L23:
        r0[ToggleName.COLLECTION_MEMORY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
    L33:
        r0[ToggleName.PERSONAL_INFO_MEMORY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
    L25:
        r0[ToggleName.SCREEN_MEMORY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
    L27:
        r0[ToggleName.HEARING_MEMORY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
    L9:
        a = r0;
        int[] r1 = new int[IObricPermissionService$Companion.ObricPermissionStatus.values().length];
        r1[IObricPermissionService$Companion.ObricPermissionStatus.GRANTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
    L21:
        r1[IObricPermissionService$Companion.ObricPermissionStatus.LIMITED_GRANTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
    L12:
        b = r1;
    }
}
