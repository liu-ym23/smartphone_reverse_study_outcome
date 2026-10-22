package com.obric.assistant.interaction.impl.window;

import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/ObricListeningRelativeLayerController$SurfaceKey;", "", "generation", "", "<init>", "(I)V", "getGeneration", "()I", "component1", "copy", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricListeningRelativeLayerController$SurfaceKey {
    private final int generation;

    public static /* synthetic */ ObricListeningRelativeLayerController$SurfaceKey copy$default(ObricListeningRelativeLayerController$SurfaceKey r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.generation;
    L6:
        return r0.copy(r1);
    }

    public final int component1() {
        return this.generation;
    }

    public final ObricListeningRelativeLayerController$SurfaceKey copy(int r2) {
        return new ObricListeningRelativeLayerController$SurfaceKey(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof ObricListeningRelativeLayerController$SurfaceKey) == true) goto L9;
        return false;
    L9:
        if (this.generation == ((ObricListeningRelativeLayerController$SurfaceKey) r4).generation) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.generation;
    }

    public String toString() {
        return "SurfaceKey(generation=" + this.generation + ')';
    }

    public final int getGeneration() {
        return this.generation;
    }

    public ObricListeningRelativeLayerController$SurfaceKey(int r1) {
        this.generation = r1;
    }
}
