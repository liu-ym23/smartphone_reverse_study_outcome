package wk8;

import android.content.Context;
import com.larus.bmhome.chat.block.base.renderer.FileCardVMData;
import com.larus.home.impl.sdk.r1;
import com.larus.im.bean.message.block.ArtifactBlock;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import tx9.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f implements lc8.a {
    public final a a;
    public final by7.e b;

    public f(a r2, by7.e r3) {
        Intrinsics.checkNotNullParameter(r2, "blockModel");
        this.a = r2;
        this.b = r3;
    }

    public final void a(Context r9, FileCardVMData r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "data");
        BlockContent r0 = ((jc8.a) this.a).a.getContent();
        if (r0 == null) goto L18;
        ArtifactBlock r1 = r0.getDocBlock();
        if (r1 == null) goto L20;
        String r6 = h1.b(r10.getType());
        if (r6 == null) goto L14;
        String r3 = r10.k();
        String r4 = r10.c();
        Map r11 = r10.j();
        if (r11 == null) goto L12;
        String r12 = (String) r11.get("chat_id");
    L13:
        by7.e r7 = this.b;
        Intrinsics.checkNotNullParameter(r6, "contentSecType");
        h1.a("general_agent_artifact_result_card_click", r3, r4, r12, r6, r7);
        goto L14
    L12:
        r12 = null;
    L14:
        IFlowSdkDepend r13 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r13 == null) goto L19;
        r13.j();
        r1.a.a(r9, r1, this.a.j(), "markdown_artifact_file_card_click");
        return;
    L19:
        return;
    L20:
        return;
    }

    public final void b(Context r1, FileCardVMData r2) {
        lc8.a.a.a(r1, r2);
    }
}
