package fob;

import android.text.Spannable;
import com.ss.android.lark.widget.richtext.RichTextElement;
import hob.b;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface d<I extends hob.b> {
    c<Spannable, List<f.b<I>>> a(eob.a r1);

    c<RichTextElement.AnchorProperty, I> b(eob.a r1);

    b<I> c(eob.a r1, I r2);

    Class<I> getType();
}
