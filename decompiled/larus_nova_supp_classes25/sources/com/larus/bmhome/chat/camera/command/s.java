package com.larus.bmhome.chat.camera.command;

import com.larus.feishu.office.im.impl.base.q0;
import com.larus.platform.model.action.SuggestedAction;
import com.larus.platform.model.action.SuggestedActionData;
import com.larus.platform.model.action.SuggestedActionScene;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class s implements p {
    public static final s a = null;

    static {
        a = new s();
    }

    public s() {
    }

    @Override // com.larus.bmhome.chat.camera.command.p
    public final void G8(q0 r1) {
    }

    @Override // com.larus.bmhome.chat.camera.command.p
    public final void c(String r1, iq9.e r2) {
        Intrinsics.checkNotNullParameter(r1, "bizScene");
    }

    @Override // com.larus.bmhome.chat.camera.command.p
    public final void d(SuggestedActionData r1) {
    }

    @Override // com.larus.bmhome.chat.camera.command.p
    public final boolean d3() {
        return false;
    }

    @Override // com.larus.bmhome.chat.camera.command.p
    public final void preload(String r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
    }

    @Override // com.larus.bmhome.chat.camera.command.p
    public final List<SuggestedAction> r4(SuggestedActionScene r1, String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "bizScene");
        return CollectionsKt.emptyList();
    }

    @Override // com.larus.bmhome.chat.camera.command.p
    public final void b(SuggestedActionScene r1, String r2, boolean r3, Function1<? super List<SuggestedAction>, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "bizScene");
        Intrinsics.checkNotNullParameter(r4, "callback");
        r4.invoke(CollectionsKt.emptyList());
    }

    @Override // com.larus.bmhome.chat.camera.command.p
    public final void a(SuggestedActionScene r1, String r2, boolean r3, String r4, Function1<? super List<SuggestedAction>, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "bizScene");
        Intrinsics.checkNotNullParameter(r5, "callback");
        r5.invoke(CollectionsKt.emptyList());
    }
}
