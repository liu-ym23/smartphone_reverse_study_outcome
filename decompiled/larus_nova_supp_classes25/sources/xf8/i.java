package xf8;

import com.larus.im.bean.message.Message;
import com.larus.ivykit.plugin.TemplateInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i extends xc8.b {
    public final Message e;
    public final TemplateInfo f;

    @Override // xc8.b
    public final int d() {
        return this.f.getGravity();
    }

    public i(Message r2, TemplateInfo r3) {
        Intrinsics.checkNotNullParameter(r2, "lynxMessage");
        Intrinsics.checkNotNullParameter(r3, "templateInfo");
        super(r2);
        this.e = r2;
        this.f = r3;
    }
}
