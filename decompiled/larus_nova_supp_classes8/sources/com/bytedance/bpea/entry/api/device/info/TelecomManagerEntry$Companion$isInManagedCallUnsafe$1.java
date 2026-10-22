package com.bytedance.bpea.entry.api.device.info;

import android.telecom.TelecomManager;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.ReplayUIStateCode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, ReplayUIStateCode.IS_FOLD_OPEN})
final class TelecomManagerEntry$Companion$isInManagedCallUnsafe$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ TelecomManager $this_isInManagedCallUnsafe;

    public TelecomManagerEntry$Companion$isInManagedCallUnsafe$1(TelecomManager r1) {
        this.$this_isInManagedCallUnsafe = r1;
        super(0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return Boolean.valueOf(m1638invoke());
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final boolean m1638invoke() {
        return this.$this_isInManagedCallUnsafe.isInManagedCall();
    }
}
