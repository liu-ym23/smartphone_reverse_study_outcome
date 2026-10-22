package ly7;

import android.graphics.Point;
import android.view.View;
import com.larksuite.common_selection.SelectionContainer;
import com.larksuite.common_selection.d;
import com.larksuite.common_selection.o;
import com.larksuite.common_selection.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface c extends d {
    void e(o r1, t r2);

    float getOffsetForMagnifier();

    View getView();

    Point h(float r1, float r2);

    void k(SelectionContainer r1, Point r2, float r3);
}
