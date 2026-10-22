package gg;

import com.bytedance.android.ec.common.api.usertracker.PostActionType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements of.a {
    public a() {
    }

    @Override // of.a
    public final void a(String r10, PostActionType r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "action");
        Intrinsics.checkNotNullParameter(r11, "type");
        Intrinsics.checkNotNullParameter(r12, "pageId");
    }
}
