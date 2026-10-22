package com.lynx.tasm.ui.image;

import com.lynx.tasm.behavior.ui.LynxBaseUI;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements com.lynx.tasm.behavior.ui.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LynxBaseUI f11040b;

    public /* synthetic */ e(LynxBaseUI r5, int r10) {
        this.f11039a = r10;
        this.f11040b = r5;
    }

    @Override // com.lynx.tasm.behavior.ui.q
    public final void a(int r5) {
        switch(this.f11039a) {
            case 0: goto L9;
            default: goto L4;
        };
    L4:
        UIImage r10 = (UIImage) this.f11040b;
        UIImage.access$702(r10, r5);
        if (UIImage.access$500(r10) == false) goto L14;
        if (r5 != 0) goto L15;
        UIImage.access$502(r10, false);
        UIImage.access$600(r10);
        return;
    L15:
        return;
    L14:
        return;
    L9:
        FlattenUIImage r11 = (FlattenUIImage) this.f11040b;
        FlattenUIImage.access$502(r11, r5);
        if (FlattenUIImage.access$600(r11) == false) goto L16;
        if (r5 != 0) goto L17;
        FlattenUIImage.access$602(r11, false);
        FlattenUIImage.access$400(r11);
        return;
    L17:
        return;
    }
}
