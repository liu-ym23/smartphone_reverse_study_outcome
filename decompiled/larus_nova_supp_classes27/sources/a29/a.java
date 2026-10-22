package a29;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.larus.common_ui.widget.concat_adapter.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public final SparseArray<b> a;
    public int b;

    /* JADX INFO: renamed from: a29.a$a, reason: collision with other inner class name */
    public class C0000a {
        public final SparseIntArray a;
        public final SparseIntArray b;
        public final b c;
        public final /* synthetic */ a d;

        public C0000a(a r2, b r3) {
            this.d = r2;
            this.a = new SparseIntArray(1);
            this.b = new SparseIntArray(1);
            this.c = r3;
        }
    }

    public a() {
        this.a = new SparseArray();
        this.b = 0;
    }
}
