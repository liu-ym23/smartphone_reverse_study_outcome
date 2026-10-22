package h3;

import com.bytedance.ai.view.popup.AppletPopup;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppletPopup f17274b;

    public /* synthetic */ b(AppletPopup r5, int r10) {
        this.f17273a = r10;
        this.f17274b = r5;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        AppletPopup r5 = this.f17274b;
        switch(this.f17273a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        int r10 = AppletPopup.L;
        r5.i(true);
        return Unit.INSTANCE;
    L6:
        int r11 = AppletPopup.L;
        if (r5.getFragmentManager() == null) goto L17;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L11
        if (r5.j() == true) goto L13;
        r5.dismissAllowingStateLoss();     // Catch: Throwable -> L11
    L13:
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
    L17:
        return Unit.INSTANCE;
    }
}
