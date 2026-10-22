package com.ss.android.lark.integrator.ccm.im;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@AppConfig(key = "preload_doc_chat_types")
public class PreloadDocConfig implements NonProguard {
    public static final int GROUP = 2;
    public static final int P2P = 1;
    public static final int SPACE_LIST = 9999;
    public static final int THREAD_DETAIL = 4;
    public static final int TOPIC_GROUP = 3;
    public List<Integer> supportTypes;

    public PreloadDocConfig() {
        ArrayList r0 = new ArrayList();
        this.supportTypes = r0;
        r0.add(1);
        this.supportTypes.add(2);
        this.supportTypes.add(Integer.valueOf(SPACE_LIST));
    }
}
