package g1;

import android.view.View;
import com.bytedance.ai.applet.render.core.RenderType;
import java.util.Map;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import m1.i;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface b {
    View a();

    Object a(String r5, JSONObject r10, ContinuationImpl r11);

    void a(JSONObject r5);

    void b();

    void c();

    View d();

    void destroy();

    boolean e();

    i getBridge();

    d getComposition();

    RenderType getRenderType();

    void setGlobalProperties(Map r5);

    void setOnTouchEventListener(a r5);

    void setReused(boolean r5);

    void setViewClient(c r5);

    void setViewContext(Map r5);

    void setViewData(JSONObject r5);
}
