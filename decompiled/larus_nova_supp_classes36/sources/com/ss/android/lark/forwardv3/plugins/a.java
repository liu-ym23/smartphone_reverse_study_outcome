package com.ss.android.lark.forwardv3.plugins;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.biz.im.api.bundle.ChatType;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.ss.android.lark.forsetiutils.ForsetiFGHelpers;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import com.ss.android.lark.utils.navigation.Navigation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import nnc.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements g {
    public final Fragment a;
    public final g.b b;

    @Override // com.ss.android.lark.forwardv3.plugins.g
    public final void a() {
        List<SearchBaseInfo> r0 = this.b.a();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if ((r3 instanceof SearchChatInfo) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r5 = r1.iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        r4.add(new ForwardAtSelectContainerFragment.ForwardTarget(((SearchChatInfo) r5.next()).getId(), ChatType.GROUP));
        goto L10
    L12:
        ArrayList r6 = (ArrayList) CollectionsKt.toCollection(r4, new ArrayList());
        Context r7 = this.a.getContext();
        if (r7 == null) goto L17;
        boolean r8 = true;
        if (ForsetiConfig.a(r7) != true) goto L17;
    L18:
        final int r9 = 1911;
        if (r8 == false) goto L28;
        Context r10 = this.a.getContext();
        if (r10 == null) goto L43;
        Fragment r11 = Navigation.from(r10, this.a).getSourceFragment();
        if (r11 == null) goto L44;
        com.suite.lark.component.navroute.forseti.g r12 = com.suite.lark.component.navroute.forseti.f.b(r11);
        if (r12 == null) goto L45;
        r r13 = r.a;
        Bundle r14 = new Bundle();
        r14.putSerializable("forward_target", r6);
        Unit r15 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r14, "args");
        r12.f(new onc.e(r14), new ForwardAtDependency$startAtSelector$1$2(r9));
        return;
    L45:
        return;
    L44:
        return;
    L43:
        return;
    L28:
        if (ForsetiFGHelpers.d() == false) goto L30;
        Intent r16 = new Intent(this.a.getActivity(), ForwardAtSelectResponsiveActivity.class).addFlags(65536);
    L31:
        Intrinsics.checkNotNull(r16);
        r16.putExtra("forward_target", r6);
        this.a.startActivityForResult(r16, 1911);
        if (ForsetiFGHelpers.d() == false) goto L47;
        FragmentActivity r17 = this.a.getActivity();
        if (r17 == null) goto L48;
        r17.overridePendingTransition(0, 0);
        return;
    L48:
        return;
    L47:
        return;
    L30:
        r16 = new Intent(this.a.getActivity(), ForwardAtSelectActivity.class);
    L17:
        r8 = false;
        goto L18
    }

    public a(Fragment r2, g.b r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "dataDependency");
        this.a = r2;
        this.b = r3;
    }
}
