package k5b;

import com.bytedance.lark.pb.basic.v1.File;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k extends f {
    public final RichText v;
    public final List<File> w;

    public k(RichText r1, List<File> r2) {
        this.v = r1;
        if (r2 != null) goto L5;
        r2 = Collections.emptyList();
    L5:
        this.w = r2;
    }
}
