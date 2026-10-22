package com.bytedance.android.live.cloudgrouplive.core;

import com.bytedance.android.live.cloudgrouplive.datacontext.CloudGroupContext;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/live/cloudgrouplive/datacontext/CloudGroupContext;", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class CloudGroupLiveManager$init$pair$1 extends FunctionReferenceImpl implements Function0<CloudGroupContext> {
    public static final CloudGroupLiveManager$init$pair$1 INSTANCE = null;

    static {
        INSTANCE = new CloudGroupLiveManager$init$pair$1();
    }

    public CloudGroupLiveManager$init$pair$1() {
        super(0, CloudGroupContext.class, "<init>", "<init>()V", 0);
    }

    public final CloudGroupContext invoke() {
        return new CloudGroupContext();
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m535invoke() {
        return invoke();
    }
}
