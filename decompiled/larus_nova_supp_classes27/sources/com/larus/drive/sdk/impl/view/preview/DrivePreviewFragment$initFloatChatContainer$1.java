package com.larus.drive.sdk.impl.view.preview;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class DrivePreviewFragment$initFloatChatContainer$1 extends FunctionReferenceImpl implements Function0<Bundle> {
    public DrivePreviewFragment$initFloatChatContainer$1(Object r8) {
        super(0, r8, DrivePreviewFragment.class, "getParamsBundle", "getParamsBundle()Landroid/os/Bundle;", 0);
    }

    public final Bundle invoke() {
        return com.larus.utils.f.c(new Pair[]{TuplesKt.to("conversation_id", ((DrivePreviewFragment) ((CallableReference) this).receiver).i), TuplesKt.to("argPreviousPage", "ai_space_list")});
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m368invoke() {
        return invoke();
    }
}
