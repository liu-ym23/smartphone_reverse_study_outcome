package com.qualcomm.qti.qesdkIntf;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import com.qualcomm.qti.qesdk.QesdkFactory;
import com.qualcomm.qti.qesdk.QesdkFunctionInfo;
import java.util.HashMap;
import java.util.Vector;

/* JADX INFO: loaded from: classes2.dex */
public interface IQesdk {
    static IQesdk createInstance(Context r8) {
        return QesdkFactory.getInstance(r8);
    }

    Bundle PerformSingleTask(int r8, QesdkFunctionInfo r10, Bundle r11);

    Bundle PerformSingleTaskAsync(int r8, QesdkFunctionInfo r10, Bundle r11, IQesdkCallBack r12);

    Bundle PerformTask(int r8, IQesdkFunctionType r10, Bundle r11);

    Bundle PerformTaskAsync(int r8, IQesdkFunctionType r10, Bundle r11, IQesdkCallBack r12);

    boolean checkGlobalInit();

    int deinit();

    int deinit(int r8, int r10);

    int getSessionId();

    HashMap<Pair<String, Integer>, String[]> getSupportedAPI();

    IQesdkApiInfo getSupportedApiInfo();

    Vector<String> getSupportedApinames(HashMap<Pair<String, Integer>, String[]> r8);

    String getSupportedApis();

    int init(IQesdkEventCallBack r8);

    int init(IQesdkEventCallBack r8, int r10, int r11);

    int init(String r8, int r10, int r11, IQesdkEventCallBack r12);

    int init(String r8, IQesdkEventCallBack r10);
}
