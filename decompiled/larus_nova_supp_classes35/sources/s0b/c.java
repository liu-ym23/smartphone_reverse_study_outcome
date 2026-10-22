package s0b;

import com.bytedance.geckox.model.UpdatePackage;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResUtils;
import com.ss.android.lark.officesdk.utils.di.j;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ UpdatePackage a;

    public c(UpdatePackage r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        j.c("CML_TAG_GeckoResManager", "applyGeckoResource failed ", (Throwable) r3);
        int r4 = com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.c.a;
        UpdatePackage r5 = this.a;
        Intrinsics.checkNotNullParameter(r5, "updatePackage");
        j.e(ChameleonResUtils.TAG, "clearGeckoResourceByChannel, channel = " + r5.getChannel());
        swb.j.h(a.b().getVfsPath().subPath(r5.getAccessKey()).subPath(r5.getChannel()));
    }
}
