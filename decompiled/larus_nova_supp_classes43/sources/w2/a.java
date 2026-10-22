package w2;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.ai.applet.render.core.RenderType;
import d3.w;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface a {

    /* JADX INFO: renamed from: w2.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0209a<T extends AbstractC0209a<T, R>, R extends a> {
        public final Context a;
        public String b;
        public float c;

        public final Context getContext() {
            return this.a;
        }

        public AbstractC0209a(Context r10) {
            Intrinsics.checkNotNullParameter(r10, "context");
            this.a = r10;
            this.c = 1.0f;
        }
    }

    public static final class b {
        public static void b(a r1, Map<String, ? extends Object> r10) {
            Intrinsics.checkNotNullParameter(r10, "props");
            w2.c r0 = r1.getComposition();
            Map<String, ? extends Object> r11 = MapsKt.toMutableMap(r1.getComposition().b);
            r11.putAll(r10);
            r0.getClass();
            Intrinsics.checkNotNullParameter(r11, "<set-?>");
            r0.b = r11;
        }

        public static /* synthetic */ void a(a r1, JSONObject r10, boolean r11, int r12) {
            if ((r12 & 1) == 0) goto L6;
            r10 = new JSONObject();
        L6:
            if ((r12 & 2) == 0) goto L8;
            r11 = false;
        L8:
            r1.b(r10, r11);
        }
    }

    public interface c {
        void onTouchEvent(MotionEvent r1);
    }

    void a();

    View asView();

    void b(JSONObject r1, boolean r10);

    void c();

    boolean d();

    void destroy();

    void e(Map<String, ? extends Object> r1);

    Object f(String r1, JSONObject r10, Continuation<? super Unit> r11);

    w getBridge();

    w2.c getComposition();

    RenderType getRenderType();

    View realView();

    void setGlobalProperties(Map<String, ? extends Object> r1);

    void setOnTouchEventListener(c r1);

    void setReused(boolean r1);

    void setViewClient(w2.b r1);

    void setViewContext(Map<String, ? extends Object> r1);

    void setViewData(JSONObject r1);
}
