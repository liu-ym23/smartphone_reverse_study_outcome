package com.obric.memorydata.markdown.custom;

import android.app.Activity;
import android.content.Context;
import com.obric.memorydata.utils.ba;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a%\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"showMenu", "Lcom/obric/memorydata/markdown/custom/OMenuDialog;", "Landroid/content/Context;", "block", "Lkotlin/Function1;", "Lcom/obric/memorydata/markdown/custom/MenuBuilder;", "", "Lkotlin/ExtensionFunctionType;", "markdown_lite_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class g {
    public static final h a(Context r3, Function1<? super f, Unit> r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "block");
        Activity r0 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ba.b(r5), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.isFinishing() == false) goto L7;
        return null;
    L7:
        if (r0.isDestroyed() == true) goto L14;
        f r1 = new f(r5);
        r6.invoke(r1);
        return r1.a();
    L14:
        return null;
    }
}
