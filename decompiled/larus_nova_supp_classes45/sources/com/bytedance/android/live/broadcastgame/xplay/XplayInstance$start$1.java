package com.bytedance.android.live.broadcastgame.xplay;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/live/broadcastgame/xplay/XplayInternalContext;", "invoke"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class XplayInstance$start$1 extends FunctionReferenceImpl implements Function0<XplayInternalContext> {
    public static final XplayInstance$start$1 INSTANCE = null;

    static {
        INSTANCE = new XplayInstance$start$1();
    }

    public XplayInstance$start$1() {
        super(0, XplayInternalContext.class, "<init>", "<init>()V", 0);
    }

    public final XplayInternalContext invoke() {
        return new XplayInternalContext();
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m433invoke() {
        return invoke();
    }
}
