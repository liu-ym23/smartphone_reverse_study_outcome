package nr;

import android.content.DialogInterface;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f20301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DialogInterface.OnClickListener f20302c;

    public /* synthetic */ c(e r5, DialogInterface.OnClickListener r10, int r11) {
        this.f20300a = r11;
        this.f20301b = r5;
        this.f20302c = r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.content.DialogInterface, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.content.DialogInterface, java.lang.Object] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        switch(this.f20300a) {
            case 0: goto L13;
            default: goto L4;
        };
    L4:
        e r10 = this.f20301b;
        Intrinsics.checkNotNullParameter(r10, "this$0");
        ?? r11 = r10.e;
        if (r11 == 0) goto L22;
        DialogInterface.OnClickListener r12 = this.f20302c;
        if (r12 == 0) goto L11;
        r12.onClick(r11, -1);
    L11:
        r10.g();
        return;
    L22:
        return;
    L13:
        e r13 = this.f20301b;
        Intrinsics.checkNotNullParameter(r13, "this$0");
        ?? r14 = r13.e;
        if (r14 == 0) goto L23;
        DialogInterface.OnClickListener r15 = this.f20302c;
        if (r15 == 0) goto L20;
        r15.onClick(r14, -2);
    L20:
        r13.g();
        return;
    }
}
