package com.larus.bmhome.view.actionbar.segment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.actionbar.model.e0;
import com.larus.bmhome.actionbar.model.g1;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.databinding.LarusChatItemCustomActionbarNormalHolderBinding;
import com.larus.bmhome.instruction.core.model.ActionBarExecutionType;
import com.larus.bmhome.view.actionbar.BaseActionBarHolder;
import com.larus.bmhome.view.actionbar.custom.CustomActionBarNormalHolder;
import com.larus.bmhome.view.actionbar.custom.t1;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.n1;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import nda.d;
import ss8.e;
import v19.h;
import va8.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a implements e {
    public final t1a.b a;
    public final Context b;

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.segment.a$a, reason: collision with other inner class name */
    public static final class C0049a {
    }

    static {
    }

    @Override // ss8.e
    public final boolean g() {
        return false;
    }

    public final Context getContext() {
        return this.b;
    }

    @Override // ss8.e
    public final boolean h(z0 r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        return Intrinsics.areEqual(r2.b, "coco_doc_ai_edit_back");
    }

    public a(t1a.b r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "vContext");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.a = r2;
        this.b = r3;
    }

    @Override // ss8.e
    public final List b(BotModel r28, wc9.e r29) {
        Intrinsics.checkNotNullParameter(r28, "bot");
        Intrinsics.checkNotNullParameter(r29, "conversation");
        r r1 = this.a.getAbility(r.class);
        if (r1 == null) goto L5;
        String r2 = r1.WE();
    L6:
        boolean r3 = Intrinsics.areEqual(r2, "doc_ai_edit");
        IFlowSdkDepend r4 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r4 == null) goto L11;
        r4.N();
        boolean r5 = true;
        if (n1.a.z() != true) goto L11;
    L12:
        if (r3 == false) goto L20;
        if (r5 == false) goto L20;
        boolean r6 = h.a;
        if (h.b(this.b) == false) goto L17;
        int r7 = 2131240811;
    L18:
        String r8 = y0.k(UriProtector.parse("res://" + AppHost.a.getApplication().getPackageName() + '/' + r7));
        int r9 = ActionBarExecutionType.OPEN_BY_SCHEMA.getValue();
        return CollectionsKt.listOf(new z0(null, "coco_doc_ai_edit_back", new g1(null, r8, null, null, 29), new g1(null, r8, null, null, 29), "", null, Integer.valueOf(r9), null, new e0("//flow/doc_ai_edit_back", 2), null, null, null, true, null, null, -1610616927, 15));
    L17:
        r7 = 2131240812;
    L20:
        return CollectionsKt.emptyList();
    L11:
        r5 = false;
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    @Override // ss8.e
    public final boolean d(z0 r2, z0 r3) {
        Intrinsics.checkNotNullParameter(r2, "old");
        Intrinsics.checkNotNullParameter(r3, "next");
        return false;
    }

    @Override // ss8.e
    public final void e(BaseActionBarHolder r3, z0 r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "cell");
        Intrinsics.checkNotNullParameter(r4, "item");
        Intrinsics.checkNotNullParameter(r3, "cell");
        Intrinsics.checkNotNullParameter(r4, "item");
        FLogger.a.d("AiEditBackSegment", "bindActionBarItem, cell = " + r3);
        if ((r3 instanceof CustomActionBarNormalHolder) == false) goto L5;
        CustomActionBarNormalHolder r6 = (CustomActionBarNormalHolder) r3;
    L6:
        if (r6 == null) goto L9;
        int r7 = CustomActionBarNormalHolder.v;
        r6.V3(r4, null);
        return;
    L9:
        return;
    L5:
        r6 = null;
        goto L6
    }

    @Override // ss8.e
    public final BaseActionBarHolder f(ViewGroup r13, t1 r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r13, "parent");
        Intrinsics.checkNotNullParameter(r14, "defaultClickCallback");
        LarusChatItemCustomActionbarNormalHolderBinding r16 = LarusChatItemCustomActionbarNormalHolderBinding.b(LayoutInflater.from(r13.getContext()), r13);
        d.a().na(new TextView[]{r16.c, r16.d});
        return new CustomActionBarNormalHolder(r16.a, null, r14, false, false, null, null, 72);
    }
}
