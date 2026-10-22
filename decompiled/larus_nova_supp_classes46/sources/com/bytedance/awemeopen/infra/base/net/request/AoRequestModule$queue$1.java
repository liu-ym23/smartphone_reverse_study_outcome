package com.bytedance.awemeopen.infra.base.net.request;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class AoRequestModule$queue$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $id;
    final /* synthetic */ b $task;

    public AoRequestModule$queue$1(b r1, int r2) {
        this.$id = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m906invoke() {
        throw null;     // Catch: Throwable -> L4
    L4:
        th = move-exception;
        a.a.remove(Integer.valueOf(this.$id));
        throw th;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m906invoke();
        return Unit.INSTANCE;
    }
}
