package com.bytedance.ies.bullet.lynx.resource.forest;

import com.bytedance.forest.model.w;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/forest/model/w;", "response", "", "invoke", "(Lcom/bytedance/forest/model/w;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class ForestDynamicComponentProvider$loadResource$1 extends Lambda implements Function1<w, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f5732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ln.a f5733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f5734c;
    public final /* synthetic */ String d;

    public ForestDynamicComponentProvider$loadResource$1(String r5, ln.a r10, b r11, String r12) {
        this.f5732a = r5;
        this.f5733b = r10;
        this.f5734c = r11;
        this.d = r12;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(w r10) {
        w r5 = r10;
        Intrinsics.checkNotNullParameter(r5, "response");
        if (r5.f4442r == false) goto L8;
        ln.a r11 = this.f5733b;
        b r12 = this.f5734c;
        String r13 = this.d;
        String r14 = this.f5732a;
        a r15 = new a(r5, r11, r12, r13, r14);
        if (Intrinsics.areEqual(r14, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST) == false) goto L7;
        r15.call();
    L10:
        return Unit.INSTANCE;
    L7:
        h.f.b(r15, h.f.g);
        goto L10
    L8:
        ln.a r16 = this.f5733b;
        zm.c r17 = (zm.c) r16;
        r17.m(null, new IllegalStateException(r5.s.toString()));
        goto L10
    }
}
