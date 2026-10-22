package oe;

import android.util.Log;
import com.bytedance.ies.xelement.LynxScrollView;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.r;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxScrollView f20553a;

    public i(LynxScrollView r5) {
        this.f20553a = r5;
    }

    public final void a() {
        Log.d("Django", "onScrollToEnd");
        LynxScrollView r5 = this.f20553a;
        if (r5.f6365b == false) goto L10;
        LynxContext r10 = r5.getLynxContext();
        if (r10 == null) goto L11;
        r r11 = r10.g;
        if (r11 == null) goto L12;
        r11.b(new on.b(r5.getSign(), "scrolltobounce"));
        return;
    L12:
        return;
    L11:
        return;
    }
}
