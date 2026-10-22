package androidx.room;

import android.app.UiModeManager;
import android.app.UiModeManager$ContrastChangeListener;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import com.google.android.material.search.SearchBar;
import com.google.common.util.concurrent.r0;
import java.nio.file.Path;
import java.util.concurrent.Executor;
import kotlin.reflect.jvm.internal.ComputableClassValue;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class b {
    public static /* bridge */ /* synthetic */ float a(UiModeManager r5) {
        return r5.getContrast();
    }

    public static /* bridge */ /* synthetic */ Object b(r0 r5, Class r10) {
        return r5.get(r10);
    }

    public static /* bridge */ /* synthetic */ Object c(ComputableClassValue r5, Class r10) {
        return r5.get(r10);
    }

    public static /* bridge */ /* synthetic */ Path d(String r5, String[] r10) {
        return Path.of(r5, r10);
    }

    public static /* bridge */ /* synthetic */ void e(UiModeManager r5, UiModeManager$ContrastChangeListener r10) {
        r5.removeContrastChangeListener(r10);
    }

    public static /* bridge */ /* synthetic */ void f(UiModeManager r5, Executor r10, UiModeManager$ContrastChangeListener r11) {
        r5.addContrastChangeListener(r10, r11);
    }

    public static /* bridge */ /* synthetic */ void g(ViewTreeObserver r5, ViewTreeObserver.OnWindowVisibilityChangeListener r10) {
        r5.removeOnWindowVisibilityChangeListener(r10);
    }

    public static /* bridge */ /* synthetic */ void h(ViewTreeObserver r5, com.bytedance.ai.ex.widget.e r10) {
        r5.addOnWindowVisibilityChangeListener(r10);
    }

    public static /* bridge */ /* synthetic */ void i(EditText r5) {
        r5.setIsHandwritingDelegate(true);
    }

    public static /* bridge */ /* synthetic */ void j(SearchBar r5, float r10, float r11) {
        r5.setHandwritingBoundsOffsets(r10, 0.0f, r11, 0.0f);
    }

    public static /* bridge */ /* synthetic */ void k(SearchBar r5, com.google.android.material.search.g r10) {
        r5.setHandwritingDelegatorCallback(r10);
    }

    public static /* bridge */ /* synthetic */ void l(r0 r5, Class r10) {
        r5.get(r10);
    }

    public static /* bridge */ /* synthetic */ void m(ComputableClassValue r5, Class r10) {
        r5.remove(r10);
    }

    public static /* bridge */ /* synthetic */ void n(ViewTreeObserver r5, ViewTreeObserver.OnWindowVisibilityChangeListener r10) {
        r5.addOnWindowVisibilityChangeListener(r10);
    }
}
