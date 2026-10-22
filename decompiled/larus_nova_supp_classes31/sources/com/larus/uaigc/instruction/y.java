package com.larus.uaigc.instruction;

import android.content.Context;
import android.net.Uri;
import androidx.lifecycle.LiveData;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.platform.model.creation.ResourceExt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class y extends up8.b implements com.larus.bmhome.instruction.k {
    public com.larus.bmhome.actionbar.model.v l;
    public MultiAttachmentSelectorWidget m;
    public int n;
    public final ArrayList<ResourceExt> o;
    public final HashMap<String, String> p;
    public final ArrayList<String> q;
    public final ArrayList<Integer> r;
    public final ArrayList<Uri> s;
    public boolean t;
    public com.larus.bmhome.instruction.d u;
    public boolean v;
    public boolean w;
    public String x;

    public final boolean a() {
        return true;
    }

    public int getType() {
        return 15;
    }

    public final void na() {
        this.v = true;
    }

    public final void oa() {
        this.w = true;
    }

    public final NestedFileContent T() {
        MultiAttachmentSelectorWidget r0 = this.m;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
        r0 = null;
    L6:
        return r0.getCurrentNestedFileContent();
    }

    public final String g() {
        Object r1 = null;
        if (this.l != null) goto L5;
        return null;
    L5:
        MultiAttachmentSelectorWidget r0 = this.m;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
        r0 = null;
    L8:
        r0.l7();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
        Object r3 = Result.constructor-impl(xt7.d.b.a(kuc.a.d(com.larus.bmhome.actionbar.model.v.Companion.serializer()), this.l));     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r3) == true) goto L18;
        r1 = r3;
    L18:
        return (String) r1;
    L11:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public final LiveData<Map<String, Object>> ja() {
        MultiAttachmentSelectorWidget r0 = this.m;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
        r0 = null;
    L5:
        LiveData<Map<String, ry9.k>> r1 = r0.getAllAttachmentLiveDataStatus();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.collections.Map<kotlin.String, kotlin.Any>>");
        return r1;
    }

    public y() {
        this.o = new ArrayList();
        this.p = new HashMap();
        this.q = new ArrayList();
        this.r = new ArrayList();
        this.s = new ArrayList();
    }

    public final AbsInstructionWidget e(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        MultiAttachmentSelectorWidget r0 = new MultiAttachmentSelectorWidget(r2);
        this.m = r0;
        return r0;
    }

    public final void ka(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "urlToUriRecord");
        this.p.clear();
        this.p.putAll(r2);
    }

    public final void la(ArrayList<ResourceExt> r2) {
        Intrinsics.checkNotNullParameter(r2, "imageUrlList");
        this.o.clear();
        this.o.addAll(r2);
    }

    public final void ma(int r1) {
        this.n = r1;
    }

    public final wa8.a0 n(String r3) {
        if (r3 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
        Object r4 = Result.constructor-impl((com.larus.bmhome.actionbar.model.v) xt7.d.b.c(com.larus.bmhome.actionbar.model.v.Companion.serializer(), r3));     // Catch: Throwable -> L13
    L15:
        Throwable r2 = Result.exceptionOrNull-impl(r4);
        if (r2 != null) goto L20;
        this.l = (com.larus.bmhome.actionbar.model.v) r4;
        return new wa8.a0(Boolean.TRUE, "");
    L20:
        return new wa8.a0(Boolean.FALSE, r2.getMessage());
    L13:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L10:
        return new wa8.a0(Boolean.FALSE, "feature selector is empty template");
    L4:
        if (r3.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public final void pa(String r2) {
        Intrinsics.checkNotNullParameter(r2, "str");
        this.x = r2;
    }

    public final void qa(com.larus.bmhome.instruction.d r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        this.u = r2;
    }

    public final void k(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "defaultStateTemplate");
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L5
        Object r5 = Result.constructor-impl((com.larus.bmhome.actionbar.model.v) xt7.d.b.c(com.larus.bmhome.actionbar.model.v.Companion.serializer(), r2));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r5) == false) goto L10;
        r5 = null;
    L10:
        com.larus.bmhome.actionbar.model.v r6 = (com.larus.bmhome.actionbar.model.v) r5;
        if (r6 != null) goto L13;
        return;
    L13:
        com.larus.bmhome.actionbar.model.v r7 = this.l;
        if (r7 == null) goto L19;
        r7.c = r6.c;
        return;
    L19:
        return;
    L5:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
