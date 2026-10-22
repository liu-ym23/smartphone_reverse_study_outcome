package vq8;

import com.larus.bmhome.legacy.ChatLegacyCloudTestComponent;
import com.larus.ui.arch.modulizer.di.ContainerFilter;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p1a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class h implements Function1 {
    public /* synthetic */ h() {
    }

    public final Object invoke(Object r2) {
        b r3 = (b) r2;
        Intrinsics.checkNotNullParameter(r3, "$this$component");
        r3.g(new i());
        r3.g(new j());
        r3.e(ContainerFilter.DEFAULT);
        r3.e(ContainerFilter.O);
        r3.e(ContainerFilter.MINOR_MODE);
        r3.e(ContainerFilter.DOUYIN);
        r3.e(ContainerFilter.READONLY_FORWARD_DETAIL);
        return new ChatLegacyCloudTestComponent();
    }
}
