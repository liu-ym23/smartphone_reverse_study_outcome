package com.larus.bmhome.chat.camera.command;

import android.content.Intent;
import android.net.Uri;
import com.larus.bmhome.chat.component.camera.ChatCameraComponent$d;
import com.larus.platform.model.action.SuggestedAction;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class r implements d {
    public final e b;

    @Override // com.larus.bmhome.chat.camera.command.d
    public final Intent c(String r2, Uri r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "uri");
        return null;
    }

    @Override // com.larus.bmhome.chat.camera.command.d
    public final void d(boolean r1, List<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
    }

    @Override // com.larus.bmhome.chat.camera.command.d
    public final Intent e(Uri r2) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        return null;
    }

    public r(ChatCameraComponent$d r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.b = r2;
    }

    @Override // com.larus.bmhome.chat.camera.command.d
    public final void b(SuggestedAction r2) {
        this.b.b(r2);
    }
}
