package com.obric.flow.cardlistpage.ui.component.topgradient;

import android.view.View;
import com.obric.common.oea.foundation.blur.BlurUtils$BlurType;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.h;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f11764b;

    public /* synthetic */ a(b r5, int r10) {
        this.f11763a = r10;
        this.f11764b = r5;
    }

    @Override // kotlinx.coroutines.flow.h
    public final Object emit(Object r5, Continuation r10) {
        switch(this.f11763a) {
            case 0: goto L10;
            default: goto L4;
        };
    L4:
        boolean r11 = ((Boolean) r5).booleanValue();
        b r12 = this.f11764b;
        if (r11 == false) goto L7;
        np.a.a(r12.d, BlurUtils$BlurType.PROGRESS_BLUR_DOWN_UP, 32.0f, new int[0]);
    L9:
        return Unit.INSTANCE;
    L7:
        np.a.a(r12.d, BlurUtils$BlurType.PROGRESS_BLUR_DOWN_UP, 0.0f, new int[0]);
        goto L9
    L10:
        boolean r13 = ((Boolean) r5).booleanValue();
        View r14 = this.f11764b.d;
        if (r13 == false) goto L13;
        int r15 = 0;
    L14:
        r14.setVisibility(r15);
        return Unit.INSTANCE;
    L13:
        r15 = 8;
        goto L14
    }
}
