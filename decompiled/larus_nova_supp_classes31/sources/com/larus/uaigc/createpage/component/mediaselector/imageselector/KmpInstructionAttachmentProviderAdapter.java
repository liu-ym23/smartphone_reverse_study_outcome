package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import androidx.lifecycle.FlowLiveDataConversions;
import com.larus.bmhome.actionbar.model.MediaAttachment;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class KmpInstructionAttachmentProviderAdapter implements dq8.f {
    public final ry9.h a;
    public final KmpInstructionAttachmentProviderAdapter$special$$inlined$map$1 b;

    public final List<MediaAttachment> a() {
        return this.a.DX();
    }

    public final Flow<Unit> b() {
        return this.b;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.uaigc.createpage.component.mediaselector.imageselector.KmpInstructionAttachmentProviderAdapter$special$$inlined$map$1] */
    public KmpInstructionAttachmentProviderAdapter(ry9.h r2) {
        Intrinsics.checkNotNullParameter(r2, "ability");
        this.a = r2;
        final Flow r3 = FlowLiveDataConversions.asFlow(r2.ja());
        this.b = new KmpInstructionAttachmentProviderAdapter$special$$inlined$map$1(r3);
    }
}
