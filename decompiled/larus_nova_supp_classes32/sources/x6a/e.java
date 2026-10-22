package x6a;

import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.render.PlatformRendererContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface e {
    void applyRendererClipBounds(boolean r1, Rect r2);

    void applyRendererOpacity(float r1);

    void applyRendererTransform(float[] r1);

    PointF convertPointInRendererHostToScreen(PointF r1);

    i createRenderer(PlatformRendererContext r1, int r2);

    i getRenderer();

    int getRendererHostHeight();

    int getRendererHostScrollX();

    int getRendererHostScrollY();

    int getRendererHostWidth();

    View getView();

    void invalidateForRenderer();

    boolean invokeUIMethod(String r1, ReadableMap r2, Callback r3);

    void requestLayoutForRenderer();

    void setClipChildrenForRenderer(boolean r1);

    void setRenderer(i r1);

    void setWillNotDrawForRenderer(boolean r1);
}
