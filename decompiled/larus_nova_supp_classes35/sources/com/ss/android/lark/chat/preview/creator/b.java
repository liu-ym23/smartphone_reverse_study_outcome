package com.ss.android.lark.chat.preview.creator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.preview.entity.component.property.ChattersPreviewProperty;
import com.ss.android.lark.chat.preview.memberlist.MemberListActivity;
import com.ss.android.lark.export.entity.preview.ChatterPreviewChatterInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import vcb.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b extends com.ss.android.lark.chat.preview.actions.b {
    public final /* synthetic */ a i;
    public final /* synthetic */ ChattersPreviewProperty j;
    public final /* synthetic */ String k;

    @Override // com.ss.android.lark.chat.preview.actions.b
    public final void a(int r10) {
        if ((this.i.b.get() instanceof Activity) == false) goto L53;
        int r11 = com.ss.android.lark.chat.preview.memberlist.a.a;
        Context r12 = this.i.b.get();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type android.app.Activity");
        Activity r13 = (Activity) r12;
        List<ChatterPreviewChatterInfo> r0 = this.j.getChatterInfoList();
        ChattersPreviewProperty.ChattersMode r1 = this.j.getChattersMode();
        String r2 = this.f.a;
        String r3 = this.k;
        String r4 = this.j.getTitle();
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r1, "chattersMode");
        Intrinsics.checkNotNullParameter(r3, "componentId");
        Bundle r5 = new Bundle();
        boolean r7 = false;
        if (com.ss.android.lark.chat.preview.memberlist.a.C0112a.a[r1.ordinal()] != 1) goto L22;
        List<ChatterPreviewChatterInfo> r6 = r0;
        if (r6 != null) goto L9;
    L12:
        boolean r8 = true;
    L13:
        if (r8 == true) goto L54;
        ArrayList r9 = new ArrayList();
        Iterator<T> r14 = r0.iterator();
    L17:
        if (r14.hasNext() == false) goto L21;
        String r15 = ((ChatterPreviewChatterInfo) r14.next()).getChatterId();
        if (r15 == null) goto L17;
        r9.add(r15);
        goto L17
    L21:
        r5.putStringArrayList("chatter_id_list", new ArrayList(r9));
    L36:
        r5.putInt("chatters_mode", r1.getValue());
        if (r4 != null) goto L39;
    L44:
        if (r7 == false) goto L46;
        r4 = UIUtils.getString(r13, 2131890882);
    L46:
        r5.putString("title", r4);
        Intent r16 = new Intent(r13, MemberListActivity.class);
        r16.putExtras(r5);
        r13.startActivity(r16);
        return;
    L39:
        if (r4.length() != 0) goto L41;
        boolean r17 = true;
    L42:
        if (r17 != true) goto L44;
        r7 = true;
        goto L44
    L41:
        r17 = false;
        goto L42
    L54:
        return;
    L9:
        if (r6.isEmpty() == true) goto L12;
        r8 = false;
        goto L13
    L22:
        if (r2 != null) goto L24;
    L27:
        boolean r18 = true;
    L28:
        if (r18 == true) goto L30;
    L35:
        r5.putString("preview_id", r2);
        r5.putString("component_id", r3);
        goto L36
    L30:
        if (r3.length() != 0) goto L32;
        boolean r19 = true;
    L33:
        if (r19 == false) goto L35;
        return;
    L32:
        r19 = false;
        goto L33
    L24:
        if (r2.length() == 0) goto L27;
        r18 = false;
        goto L28
    }

    public b(a r7, ChattersPreviewProperty r8, String r9, d r10) {
        this.i = r7;
        this.j = r8;
        this.k = r9;
        super(null, null, null, r10, null);
    }
}
