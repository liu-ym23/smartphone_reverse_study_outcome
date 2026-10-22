package com.larus.bot.impl.feature.edit.feature.bgimage;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import com.larus.photopicker.api.PhotoPicker;
import com.larus.platform.model.album.AlbumSettingConfig;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class h implements Function0 {
    public final /* synthetic */ BotBgImageEditView a;

    public /* synthetic */ h(BotBgImageEditView r1) {
        this.a = r1;
    }

    public final Object invoke() {
        BotBgImageEditView r0 = this.a;
        PhotoPicker r1 = (PhotoPicker) ServiceManager.get().getService(PhotoPicker.class);
        if (r1 == null) goto L7;
        boolean r2 = true;
        if (r1.x() != true) goto L7;
    L8:
        if (r2 == false) goto L12;
        PhotoPicker r3 = (PhotoPicker) ServiceManager.get().getService(PhotoPicker.class);
        if (r3 == null) goto L16;
        Context r4 = r0.b.a.getContext();
        ActivityResultLauncher<Intent> r5 = r0.h;
        AlbumSettingConfig.Companion.getClass();
        r3.h(r4, r5, AlbumSettingConfig.b.a());
    L16:
        return Unit.INSTANCE;
    L12:
        ActivityResultLauncher<String> r6 = r0.g;
        if (r6 == null) goto L16;
        v19.b.a(r6, "image/*");
    L7:
        r2 = false;
        goto L8
    }
}
