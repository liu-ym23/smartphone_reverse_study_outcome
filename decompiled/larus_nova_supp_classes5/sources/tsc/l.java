package tsc;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface l {

    public interface a extends l {
        List<a> children();

        m.a parent();
    }

    a a();

    Map<String, String> b();

    int end();

    boolean isBlock();

    boolean isClosed();

    String name();

    int start();
}
