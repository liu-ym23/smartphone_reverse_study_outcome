package com.bytedance.ies.bullet.lynx.bridge;

import androidx.room.jarjarred.org.antlr.v4.analysis.LeftRecursiveRuleTransformer;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.react.bridge.ReadableMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5617a;

    public /* synthetic */ g(int r5) {
        this.f5617a = r5;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r5) {
        switch(this.f5617a) {
            case 0: goto L9;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
        if ((r5 instanceof JSONObject) == true) goto L14;
        return null;
    L14:
        return (JSONObject) r5;
    L9:
        Intrinsics.checkNotNullParameter(r5, LeftRecursiveRuleTransformer.PRECEDENCE_OPTION_NAME);
        if ((r5 instanceof ReadableMap) == true) goto L15;
        return null;
    L15:
        return com.lynx.tasm.utils.b.m((ReadableMap) r5);
    }
}
