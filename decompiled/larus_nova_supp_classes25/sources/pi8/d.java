package pi8;

import android.content.Context;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.layout.item.SearchListBox;
import com.larus.bmhome.chat.layout.item.b4;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public interface d {
    RecyclerView.ItemDecoration a();

    RecyclerView.LayoutManager b(Context r1);

    ListAdapter c(b4 r1, SearchListBox.c r2, Map r3);

    a d();
}
