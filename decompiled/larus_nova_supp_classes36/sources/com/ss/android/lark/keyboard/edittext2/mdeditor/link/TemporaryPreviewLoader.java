package com.ss.android.lark.keyboard.edittext2.mdeditor.link;

import android.content.Context;
import com.larksuite.rucket.job.compat.f;
import com.ss.android.lark.coremdbiz.facade.bizext.props.LarkLinkExtend;
import com.ss.android.lark.coremdbiz.facade.plugins.LarkLinkPlugin;
import com.ss.android.lark.inv.export.router.InvRouter$InviteMemberNonDirectionalPage$Param$Type;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import v7b.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class TemporaryPreviewLoader implements cab.b {
    public TemporaryPreviewLoader() {
    }

    public final boolean a(final n r3) {
        Intrinsics.checkNotNullParameter(r3, InvRouter$InviteMemberNonDirectionalPage$Param$Type.LINK);
        return ((Boolean) LarkLinkExtend.f.b(new TemporaryPreviewLoader$shouldLoadLinkPreview$1(r3))).booleanValue();
    }

    public void b(Context r4, final n r5, LarkLinkPlugin.visitLink.1.1 r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, InvRouter$InviteMemberNonDirectionalPage$Param$Type.LINK);
        Intrinsics.checkNotNullParameter(r6, "callback");
        f.a(new TemporaryPreviewLoader$loadLinkPreview$1(r5)).then(Dispatchers.getMain(), new TemporaryPreviewLoader$loadLinkPreview$2(r6, r4, null)).error(Dispatchers.getMain(), new TemporaryPreviewLoader$loadLinkPreview$3(r6, null));
    }
}
