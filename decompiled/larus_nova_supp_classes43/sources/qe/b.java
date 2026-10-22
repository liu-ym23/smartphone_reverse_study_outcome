package qe;

import android.view.View;
import com.bytedance.android.livesdkapi.jsb.IExternalLiveAnnieComponent;
import com.bytedance.ies.web.jsbridge2.g;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements pd.b {
    public final IExternalLiveAnnieComponent a;

    @Override // pd.b
    public final void updateGlobalProps(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "map");
    }

    @Override // pd.b
    public final View getHybridView() {
        View r0 = this.a.getHybridView();
        if (r0 != null) goto L5;
        Object r1 = "null";
    L6:
        r1.toString();
        return r0;
    L5:
        r1 = r0;
        goto L6
    }

    @Override // pd.b
    public final void release() {
        this.a.release();
    }

    public b(IExternalLiveAnnieComponent r10) {
        Intrinsics.checkNotNullParameter(r10, "component");
        this.a = r10;
    }

    @Override // pd.b
    public final void updateData(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        this.a.updateData(r10);
    }

    @Override // pd.b
    public final void load(String r10, Map<String, ? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        this.a.load(r10, r11);
    }

    @Override // pd.b
    public final void registerMethod(String r10, com.bytedance.ies.web.jsbridge2.f.b r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "provider");
        this.a.registerMethod(r10, r11);
    }

    @Override // pd.b
    public final <T> void sendJsEvent(String r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "event");
        Intrinsics.checkNotNullParameter(r11, "params");
        this.a.sendJsEvent(r10, r11);
    }

    @Override // pd.b
    public final <P, R> void registerMethod(String r10, g<P, R> r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "method");
        this.a.registerMethod(r10, r11);
    }
}
