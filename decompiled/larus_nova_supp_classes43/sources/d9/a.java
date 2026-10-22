package d9;

import android.os.Bundle;
import android.widget.FrameLayout;
import com.bytedance.android.annie.container.dialog.l;
import ia.f;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements b {

    /* JADX INFO: renamed from: d9.a$a, reason: collision with other inner class name */
    public static final class C0151a implements l {
        public C0151a() {
        }

        @Override // com.bytedance.android.annie.container.dialog.l
        public final void attach(FrameLayout r1, f r10, t36.f r11, boolean r12) {
            Intrinsics.checkNotNullParameter(r1, "floatView");
            Intrinsics.checkNotNullParameter(r10, "container");
            Intrinsics.checkNotNullParameter(r11, "mAnnieXLiveFragmentModel");
        }

        @Override // com.bytedance.android.annie.container.dialog.l
        public final boolean getModStatusBar() {
            return false;
        }

        @Override // com.bytedance.android.annie.container.dialog.l
        public final void handlePullStateChange(int r1) {
        }

        @Override // com.bytedance.android.annie.container.dialog.l
        public final boolean needAdapterStatusBarColor() {
            return false;
        }

        @Override // com.bytedance.android.annie.container.dialog.l
        public final void onActivityCreatedProxy(Bundle r1) {
        }

        @Override // com.bytedance.android.annie.container.dialog.l
        public final void onDestroyProxy() {
        }

        @Override // com.bytedance.android.annie.container.dialog.l
        public final void onDestroyViewProxy() {
        }

        @Override // com.bytedance.android.annie.container.dialog.l
        public final void setModStatusBar(boolean r1) {
        }
    }

    public a() {
    }

    @Override // d9.b
    public final void W() {
    }

    @Override // d9.b
    public final Integer f1(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "map");
        return null;
    }

    @Override // d9.b
    public final void p(float r1) {
    }

    @Override // d9.b
    public final l P() {
        return new C0151a();
    }
}
