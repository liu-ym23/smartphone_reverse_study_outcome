package com.obric.framework.inputmethod.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&R\u001b\u0010\u0004\u001a\u00020\u00058@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/obric/framework/inputmethod/api/ObricInjectTextResponseCallback;", "", "<init>", "()V", "stub", "Landroid/app/ITopActivityAssistDataReceiver;", "getStub$product_platform_release", "()Landroid/app/ITopActivityAssistDataReceiver;", "stub$delegate", "Lkotlin/Lazy;", "onResponse", "", "type", "Lcom/obric/framework/inputmethod/api/ObricInjectTextResponseType;", "viewTree", "Landroid/app/assist/AssistStructure;", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f8047a;

    public final android.app.a a() {
        return (android.app.a) ZeusTransformUtils.preCheckCast(this.f8047a.getValue(), android.app.a.class, "com.obric.memorydata.plugin");
    }
}
