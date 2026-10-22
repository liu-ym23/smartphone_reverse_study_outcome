package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import com.bytedance.android.live.revlink.impl.lynxcontainer.PkLynxDataContext;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/live/revlink/impl/lynxcontainer/PkLynxDataContext;", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class MultiDynamicContextImpl$attach$1 extends FunctionReferenceImpl implements Function0<PkLynxDataContext> {
    public static final MultiDynamicContextImpl$attach$1 INSTANCE = null;

    static {
        INSTANCE = new MultiDynamicContextImpl$attach$1();
    }

    public MultiDynamicContextImpl$attach$1() {
        super(0, PkLynxDataContext.class, "<init>", "<init>()V", 0);
    }

    public final PkLynxDataContext invoke() {
        return new PkLynxDataContext();
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m659invoke() {
        return invoke();
    }
}
