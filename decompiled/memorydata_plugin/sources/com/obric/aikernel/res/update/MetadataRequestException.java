package com.obric.aikernel.res.update;

import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/aikernel/res/update/MetadataRequestException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", MemoryInfoSectionEditActivity.EXTRA_KIND, "Lcom/obric/aikernel/res/update/MetadataRequestFailureKind;", "message", "", "cause", "", "(Lcom/obric/aikernel/res/update/MetadataRequestFailureKind;Ljava/lang/String;Ljava/lang/Throwable;)V", "getKind", "()Lcom/obric/aikernel/res/update/MetadataRequestFailureKind;", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MetadataRequestException extends IllegalStateException {
    private final MetadataRequestFailureKind kind;

    public MetadataRequestException(MetadataRequestFailureKind r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, MemoryInfoSectionEditActivity.EXTRA_KIND);
        Intrinsics.checkNotNullParameter(r3, "message");
        super(r3, r4);
        this.kind = r2;
    }

    public /* synthetic */ MetadataRequestException(MetadataRequestFailureKind r1, String r2, Throwable r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, r2, r3);
    }

    public final MetadataRequestFailureKind getKind() {
        return this.kind;
    }
}
