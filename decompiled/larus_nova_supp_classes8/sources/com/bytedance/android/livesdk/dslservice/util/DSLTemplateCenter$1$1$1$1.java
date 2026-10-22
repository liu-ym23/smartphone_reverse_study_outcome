package com.bytedance.android.livesdk.dslservice.util;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class DSLTemplateCenter$1$1$1$1 extends Lambda implements Function0<String> {
    final /* synthetic */ yt1.q $key;

    public DSLTemplateCenter$1$1$1$1(yt1.q r1) {
        this.$key = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m1190invoke() {
        return "DSLReWrite: put " + this.$key.a + " date.";
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m1190invoke();
    }
}
