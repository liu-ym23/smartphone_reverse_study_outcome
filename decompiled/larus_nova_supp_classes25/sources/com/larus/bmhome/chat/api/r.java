package com.larus.bmhome.chat.api;

import com.bytedance.ai.widget.view.WidgetBoxView;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public interface r {
    WidgetBoxView a();

    int getBoxType();

    void sendEvent(String r1, Map<String, ? extends Object> r2);

    void updateData(String r1);
}
