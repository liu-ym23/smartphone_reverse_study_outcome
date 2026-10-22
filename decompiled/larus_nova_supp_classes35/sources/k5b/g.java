package k5b;

import com.bytedance.lark.pb.basic.v1.File;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g extends f {
    public final String v;
    public final RichText w;
    public final boolean x;
    public final List<File> y;

    public g(String r1, RichText r2, boolean r3, List<File> r4) {
        this.v = r1;
        this.w = r2;
        this.x = r3;
        if (r4 != null) goto L5;
        r4 = Collections.emptyList();
    L5:
        this.y = r4;
    }
}
