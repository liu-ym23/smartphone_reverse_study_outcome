package com.bytedance.ai.model.widgets;

import cn.nubia.neopush.commons.Constant;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.model.widgets.LynxViewFloatingPage", f = "LynxViewFloatingPage.kt", i = {0, 0}, l = {431}, m = "loadTemplateBundleFromPackage", n = {"packageName", Constant.APPID}, s = {"L$0", "L$1"})
final class LynxViewFloatingPage$loadTemplateBundleFromPackage$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f2317c;
    public final /* synthetic */ LynxViewFloatingPage d;
    public int e;

    public LynxViewFloatingPage$loadTemplateBundleFromPackage$1(LynxViewFloatingPage r5, ContinuationImpl r10) {
        this.d = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.f2317c = r5;
        this.e |= Integer.MIN_VALUE;
        return LynxViewFloatingPage.i(this.d, this);
    }
}
