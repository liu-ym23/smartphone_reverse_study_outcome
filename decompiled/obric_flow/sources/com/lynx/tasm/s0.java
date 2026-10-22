package com.lynx.tasm;

import android.text.TextUtils;
import com.lynx.tasm.behavior.LynxContext;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class s0 extends fo.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f10953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f10954b;

    public s0(NativeFacade r5, String r10) {
        this.f10954b = r10;
        this.f10953a = new WeakReference(r5);
    }

    @Override // fo.g
    public final void a(com.bytedance.salamander.anniex.b0 r5) {
        if (com.lynx.tasm.utils.j.j() == true) goto L6;
        ab.b r10 = new ab.b(26, this, false, r5);
        com.lynx.tasm.utils.j.a().post(r10);
        return;
    L6:
        b(r5);
    }

    public final void b(com.bytedance.salamander.anniex.b0 r10) {
        NativeFacade r5 = (NativeFacade) this.f10953a.get();
        if (r5 == null) goto L12;
        Object r11 = r10.d;
        if (TextUtils.isEmpty((CharSequence) r11) == false) goto L10;
        LynxContext r12 = (LynxContext) r5.d.get();
        if (r12 == null) goto L10;
        LynxError r13 = new LynxError(30400, "empty i18n resource return", "", "error");
        r12.f(this.f10954b, "I18nResource", r13);
        LynxTemplateRender r14 = r5.f10047a.f10842a;
        LynxTemplateRender.j(r14.f10024f0, r14.f10022d0, this.f10954b, "", -1);
        return;
    L10:
        f0 r15 = r5.f10047a;
        int r16 = r10.f7246b;
        LynxTemplateRender r17 = r15.f10842a;
        long r18 = r17.f10024f0;
        long r19 = r17.f10022d0;
        String r20 = this.f10954b;
        LynxTemplateRender.j(r18, r19, r20, (String) r11, r16);
        return;
    }
}
