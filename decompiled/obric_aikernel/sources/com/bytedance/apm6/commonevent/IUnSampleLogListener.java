package com.bytedance.apm6.commonevent;

import com.bytedance.apm6.commonevent.model.CommonEvent;
import com.bytedance.apm6.commonevent.model.CommonLog;

/* JADX INFO: loaded from: classes.dex */
public interface IUnSampleLogListener {
    void onCommonEvent(CommonEvent r10);

    void onCommonLog(CommonLog r10);
}
