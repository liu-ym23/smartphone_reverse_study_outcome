package com.obric.assistant.interaction.impl;

import com.obric.assistant.spi.audio.CallType;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ObricRealtimeCallExtServiceImpl$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

    static {
        int[] r0 = new int[CallType.values().length];
        r0[CallType.Audio.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
    L11:
        r0[CallType.Video.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
    L15:
        r0[CallType.ScreenShare.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
    L6:
        $EnumSwitchMapping$0 = r0;
    }
}
