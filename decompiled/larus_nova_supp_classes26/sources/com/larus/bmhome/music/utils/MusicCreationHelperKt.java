package com.larus.bmhome.music.utils;

import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class MusicCreationHelperKt {
    public static final void a(String r6, String r7, String r8) {
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new MusicCreationHelperKt$reportMusicClickAddCreation$1(r6, r7, r8, null), 3, null);
    }
}
