package io.noties.markwon;

import android.content.Context;
import android.text.Spanned;
import android.widget.TextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.commonmark.node.Node;

/* JADX INFO: loaded from: classes6.dex */
public abstract class g {

    public interface a {
        a a(io.noties.markwon.b.a r1);

        a a(k r1);

        a a(Iterable<? extends k> r1);

        g a();
    }

    public interface b {
        void a(TextView r1, Spanned r2, TextView.BufferType r3, Runnable r4);
    }

    public g() {
    }

    public static a a(Context r2) {
        return new h((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    }

    public abstract Spanned a(Node r1);

    public abstract Spanned a(Node r1, TextView r2, s r3);

    public abstract Spanned a(Node r1, CharSequence r2, s r3);

    public abstract Node a(String r1, boolean r2);

    public abstract void a(TextView r1, Spanned r2, v r3);
}
