package k2;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface q extends h, o, r, com.bytedance.assem.arch.service.c {
    void b(Map<String, ? extends Object> r1);

    void doRefresh();

    boolean goBack();

    void onBackPress();

    void setTitle(String r1);

    String url();
}
