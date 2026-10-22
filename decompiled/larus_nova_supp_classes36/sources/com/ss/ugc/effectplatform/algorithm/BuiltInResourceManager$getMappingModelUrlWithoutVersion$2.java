package com.ss.ugc.effectplatform.algorithm;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "path", "", "invoke"}, k = 3, mv = {1, 1, 16})
final class BuiltInResourceManager$getMappingModelUrlWithoutVersion$2 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ Ref.ObjectRef $lookupPath;
    final /* synthetic */ String $nameStr;
    final /* synthetic */ d this$0;

    public BuiltInResourceManager$getMappingModelUrlWithoutVersion$2(d r1, String r2, Ref.ObjectRef r3) {
        this.this$0 = r1;
        this.$nameStr = r2;
        this.$lookupPath = r3;
        super(1);
    }

    public final void invoke(String r3) {
        this.this$0.c.put(this.$nameStr, r3);
        this.$lookupPath.element = r3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((String) r1);
        return Unit.INSTANCE;
    }
}
