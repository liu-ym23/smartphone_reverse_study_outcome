package k2;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface k extends u4.a, h, o {
    void createContainer(ViewGroup r1, b r10, Activity r11, Fragment r12);

    m getContainerViewService();

    KClass<?> getRenderClass();
}
