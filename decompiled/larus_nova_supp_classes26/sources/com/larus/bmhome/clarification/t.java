package com.larus.bmhome.clarification;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.picture.LocalTakePictureImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class t {
    public final Fragment a;
    public final LocalTakePictureImpl b;
    public final Function0<y> c;
    public final Function0<com.larus.bmhome.chat.component.bottom.multimodal.g> d;

    public t(Fragment r2, LocalTakePictureImpl r3, s0 r4, u0 r5) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "takePictureHelper");
        Intrinsics.checkNotNullParameter(r4, "conversationProvider");
        Intrinsics.checkNotNullParameter(r5, "multimodalProvider");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
