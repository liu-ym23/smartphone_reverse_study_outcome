package com.bytedance.android.btm.impl.schema;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.inner.h;
import com.bytedance.android.btm.impl.RegisterBtmPageHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class SchemaUtils$registerPageBtmWithSchemaAsync$1 implements h {
    public final /* synthetic */ Object a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;

    @Override // com.bytedance.android.btm.api.inner.h
    public void call(String r10, String r11) {
        final String r0 = this.a.getClass().getName();
        Object r12 = this.a;
        if ((r12 instanceof View) == false) goto L11;
        Object r1 = SchemaUtils.a;
        if (SchemaUtils.c("getPageBtmWithSchemaAsyncBy", r10, "View", r12, this.b, "") == false) goto L20;
        String r13 = RegisterBtmPageHelper.a;
        View r14 = (View) this.a;
        String r15 = this.c;
        if (r15 == null) goto L9;
        r11 = r15;
    L9:
        RegisterBtmPageHelper.b(r14, r10, r11, null);
        return;
    L20:
        return;
    L11:
        if ((r12 instanceof Fragment) == false) goto L18;
        Object r16 = SchemaUtils.a;
        if (SchemaUtils.c("getPageBtmWithSchemaAsyncBy", r10, "Fragment", r12, this.b, "V2") == false) goto L22;
        String r17 = RegisterBtmPageHelper.a;
        Object r18 = this.a;
        String r19 = this.c;
        if (r19 == null) goto L17;
        r11 = r19;
    L17:
        RegisterBtmPageHelper.a(r18, r10, r11, null);
        return;
    L22:
        return;
    L18:
        ALogger.m(ALogger.d, this.d, new SchemaUtils$registerPageBtmWithSchemaAsync$1$call$1(this, r0));
    }

    public SchemaUtils$registerPageBtmWithSchemaAsync$1(Object r1, String r10, String r11, String r12) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = "SchemaUtils_registerPageBtmWithSchemaAsync";
        this.e = r12;
    }
}
