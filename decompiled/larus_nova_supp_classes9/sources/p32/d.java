package p32;

import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface d {
    boolean b(HighlightItem r1);

    boolean canShow();

    void f(b r1);

    String getId();

    int getPriority();

    void h(c r1);

    boolean j();

    void l(b r1);

    void onDestroy();
}
