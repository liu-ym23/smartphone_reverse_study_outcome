package com.bytedance.ies.argus.strategy.provider.client;

import ai.j0;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import com.lynx.tasm.utils.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/ies/argus/strategy/b;", ST.IMPLICIT_ARG_NAME, "", "invoke", "(Lcom/bytedance/ies/argus/strategy/b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@SourceDebugExtension({"SMAP\nWebLoadStrategyProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebLoadStrategyProvider.kt\ncom/bytedance/ies/argus/strategy/provider/client/WebLoadStrategyProvider$calculate$1$1$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,155:1\n1#2:156\n*E\n"})
final class WebLoadStrategyProvider$calculate$1$1$1 extends Lambda implements Function1<com.bytedance.ies.argus.strategy.b, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f5152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ies.argus.strategy.b f5153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f5154c;

    public WebLoadStrategyProvider$calculate$1$1$1(g r5, com.bytedance.ies.argus.strategy.b r10, String r11) {
        this.f5152a = r5;
        this.f5154c = r11;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(com.bytedance.ies.argus.strategy.b r5) {
        j0.A(r5);
        String r10 = this.f5152a.h();
        if (r10 == null) goto L5;
        String r11 = k.j(r10, "?targetUrl=", this.f5154c);
    L6:
        r11.getClass();
        throw null;
    L5:
        r11 = null;
        goto L6
    }
}
