package cf8;

import android.content.Context;
import android.view.View;
import com.larus.bmhome.view.screenmenu.widget.MenuStyle;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public interface c {
    void a(View r1, String r2, JSONObject r3);

    boolean b(String r1, List<? extends ot8.a> r2);

    Unit c();

    Pair<String, String> d(Context r1, View r2, String r3, Long r4, float r5, float r6, List<? extends List<? extends ot8.a>> r7, @MenuStyle String r8);

    boolean e(String r1);

    String f();
}
