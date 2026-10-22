package com.ss.android.lark.chameleon;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vv4.a;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0016J \u0010\u0012\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u0013j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0014`\u0015H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/chameleon/AbsChameleonService;", "Lcom/bytedance/ee/bear/browser/BaseWebService;", "<init>", "()V", "chameleonContext", "Lcom/ss/android/lark/chameleon/IChameleonHandlerContext;", "getChameleonContext", "()Lcom/ss/android/lark/chameleon/IChameleonHandlerContext;", "setChameleonContext", "(Lcom/ss/android/lark/chameleon/IChameleonHandlerContext;)V", "onAttachToWeb", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "web", "Lcom/bytedance/ee/bear/browser/Web;", "onDetachFromWeb", "onAttach", "context", "onDetach", "getBridgeHandlers", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/chameleon/AbsChameleonHandler;", "Lkotlin/collections/ArrayList;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsChameleonService extends a {
    private IChameleonHandlerContext chameleonContext;

    public void onDetach(IChameleonHandlerContext r1) {
    }

    public ArrayList<AbsChameleonHandler<?>> getBridgeHandlers() {
        return new ArrayList();
    }

    public AbsChameleonService() {
    }

    public final IChameleonHandlerContext getChameleonContext() {
        return this.chameleonContext;
    }

    public void onAttach(IChameleonHandlerContext r4) {
        if (getWeb() == null) goto L8;
        Iterator<AbsChameleonHandler<?>> r0 = getBridgeHandlers().iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        AbsChameleonHandler<?> r1 = r0.next();
        super.bindBridgeHandlerAutoUnbind(r1.getName(), r1);
        r1.setContext(r4);
        goto L6
    L10:
        return;
    }

    public void onAttachToWeb(k r2) {
        Intrinsics.checkNotNullParameter(r2, "web");
        super.onAttachToWeb(r2);
        if ((r2 instanceof IChameleonHandlerContext) == false) goto L5;
        IChameleonHandlerContext r3 = (IChameleonHandlerContext) r2;
    L6:
        this.chameleonContext = r3;
        onAttach(r3);
        return;
    L5:
        r3 = null;
        goto L6
    }

    public void onDetachFromWeb(k r2) {
        super.onDetachFromWeb(r2);
        if ((r2 instanceof IChameleonHandlerContext) == false) goto L5;
        IChameleonHandlerContext r3 = (IChameleonHandlerContext) r2;
    L6:
        onDetach(r3);
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void setChameleonContext(IChameleonHandlerContext r1) {
        this.chameleonContext = r1;
    }
}
