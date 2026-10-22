package tf0;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class e {
    public int a;
    public int b;
    public IVoiceLiveTheme c;
    public int d;
    public int e;
    public int f;
    public List<Integer> g;
    public IRoom h;
    public HashMap<String, d> i;
    public boolean j;

    public e() {
        this.g = CollectionsKt.emptyList();
        this.i = new HashMap(4);
        this.j = true;
    }
}
