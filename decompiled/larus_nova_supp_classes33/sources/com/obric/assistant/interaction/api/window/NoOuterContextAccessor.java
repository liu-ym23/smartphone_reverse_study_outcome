package com.obric.assistant.interaction.api.window;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/interaction/api/window/NoOuterContextAccessor;", "Lcom/obric/assistant/interaction/api/window/OuterContextAccessor;", "<init>", "()V", "getOuter", "Landroid/content/Context;", "ctx", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class NoOuterContextAccessor implements OuterContextAccessor {
    public static final NoOuterContextAccessor INSTANCE = null;

    static {
        INSTANCE = new NoOuterContextAccessor();
    }

    private NoOuterContextAccessor() {
    }

    @Override // com.obric.assistant.interaction.api.window.OuterContextAccessor
    public Context getOuter(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        return null;
    }
}
