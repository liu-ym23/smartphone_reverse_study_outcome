package com.ss.android.lark.keyboard.plugin.tool.photo;

import com.ss.android.lark.keyboard.keyboard2.KeyboardMenuItemKey;
import com.ss.android.lark.keyboard.plugin.tool.aa.AaStyleKBPlugin;
import com.ss.android.lark.widget.photopicker.entity.Photo;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements PhotoKBPlugin.b {
    public final PhotoKBPlugin a;

    public c(xnb.d r2) {
        Intrinsics.checkNotNullParameter(r2, "photoKBPlugin");
        this.a = r2;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.photo.PhotoKBPlugin.b
    public final void a(List<Photo> r3) {
        Intrinsics.checkNotNullParameter(r3, "photos");
        if (((AaStyleKBPlugin) this.a.n().H().i(KeyboardMenuItemKey.AaStyle, AaStyleKBPlugin.class)) != null) goto L5;
        return;
    L5:
        AaStyleKBPlugin.C();
        throw null;
    }
}
