package ia;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface f extends c, e, h, g {

    public static abstract class a extends j {
        public Integer f(Map<String, ? extends Object> r10) {
            Intrinsics.checkNotNullParameter(r10, "map");
            return null;
        }

        public abstract Dialog g(Bundle r1);

        public void h() {
        }

        public void i() {
        }

        public void j(int r1) {
        }

        public void k(float r1) {
        }

        public a() {
        }
    }

    void d(a r1);

    Dialog h(Bundle r1);

    Integer i();

    void m(boolean r1);

    void o(DialogFragment r1);

    void onDismiss(DialogInterface r1);

    void onShow(DialogInterface r1);
}
