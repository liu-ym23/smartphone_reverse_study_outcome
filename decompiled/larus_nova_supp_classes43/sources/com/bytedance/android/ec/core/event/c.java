package com.bytedance.android.ec.core.event;

import com.bytedance.android.btm.api.model.PageFinder;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface c {
    void appendEventParams(Map<String, String> r1);

    void appendEventParams(Pair<String, String>... r1);

    void bindMonitorId(Long r1);

    void clearEventParams();

    void doAnyEventAction(String r1, Map<String, ? extends Object> r10, Pair<String, ? extends Object>... r11);

    void doAnyEventActionWithBtm(String r1, PageFinder r10, String r11, Map<String, ? extends Object> r12, Pair<String, ? extends Object>... r13);

    void doEventAction(String r1, String r10, PageFinder r11, Map<String, String> r12);

    void doEventAction(String r1, String r10, PageFinder r11, Pair<String, String>... r12);

    void doEventAction(String r1, Map<String, String> r10, Pair<String, String>... r11);

    void doEventAction(String r1, Pair<String, String>... r10);

    Map<String, String> getBaseParams();

    String getBaseParamsJson();

    void initEventContext(Map<String, String> r1);

    void initEventContext(Pair<String, String>... r1);
}
