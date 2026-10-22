package com.obric.assistant.interaction.base.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/assistant/interaction/base/model/InteractionEvent$ErrorEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent;", "error", "", "errorCode", "", "<init>", "(Ljava/lang/Throwable;I)V", "getError", "()Ljava/lang/Throwable;", "getErrorCode", "()I", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InteractionEvent$ErrorEvent extends InteractionEvent {
    private final Throwable error;
    private final int errorCode;

    public final Throwable getError() {
        return this.error;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public InteractionEvent$ErrorEvent(Throwable r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "error");
        super(null);
        this.error = r2;
        this.errorCode = r3;
    }
}
