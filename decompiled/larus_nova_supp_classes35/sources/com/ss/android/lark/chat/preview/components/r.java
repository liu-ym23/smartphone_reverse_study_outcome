package com.ss.android.lark.chat.preview.components;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.dialog.UDListDialogController;
import com.ss.android.lark.chat.preview.components.view.SpinButton;
import com.ss.android.lark.export.entity.preview.Item;
import com.ss.android.lark.export.entity.preview.UrlPreviewAction;
import com.ss.android.lark.export.params.URLPreviewParams;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class r implements UDListDialogController.OnItemClickListener {
    public final /* synthetic */ List<Item> a;
    public final /* synthetic */ q b;
    public final /* synthetic */ SpinButton c;
    public final /* synthetic */ Map<String, UrlPreviewAction> d;

    public final void onItemClick(int r11) {
        String r5 = ((Item) ListProtector.get(this.a, r11)).getActionId();
        if (r5 == null) goto L32;
        q r12 = this.b;
        SpinButton r0 = this.c;
        Map<String, UrlPreviewAction> r1 = this.d;
        r6c.a r2 = ((q6c.a) r12).a;
        if ((r2 instanceof vcb.d) == false) goto L7;
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.ss.android.lark.export.dependency.UrlPreviewDependency");
        vcb.d r3 = (vcb.d) r2;
    L8:
        if (r1 == null) goto L10;
        UrlPreviewAction r4 = r1.get(r5);
    L11:
        com.ss.android.lark.chat.preview.actions.a.a(r4, r5, null, r3, null).a(1);
        if (r1 == null) goto L14;
        UrlPreviewAction r6 = r1.get(r5);
    L15:
        g6b.a.InterfaceC0223a r7 = g6b.a.a;
        if (r7 == null) goto L33;
        com.ss.android.lark.officesdk.integrator.im.a r8 = r7.a();
        if (r8 == null) goto L34;
        if (r6 == null) goto L21;
        String r9 = r6.getUrl();
    L22:
        URLPreviewParams r10 = r12.i;
        String r13 = r10.a;
        String r14 = r12.h;
        Long r15 = r10.h;
        if (r15 == null) goto L25;
        String r16 = r15.toString();
    L26:
        Long r17 = r12.i.i;
        if (r17 == null) goto L29;
        String r18 = r17.toString();
    L30:
        r8.c(r9, r13, "select_item", r14, r5, r16, r18, r12.i.e);
        return;
    L29:
        r18 = null;
        goto L30
    L25:
        r16 = null;
        goto L26
    L21:
        r9 = null;
        goto L22
    L34:
        return;
    L33:
        return;
    L14:
        r6 = null;
        goto L15
    L10:
        r4 = null;
        goto L11
    L7:
        r3 = new vcb.d(r0.getContext(), null, r12.i);
        goto L8
    }

    public r(List<Item> r1, q r2, SpinButton r3, Map<String, UrlPreviewAction> r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
