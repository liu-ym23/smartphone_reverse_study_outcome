package com.larksuite.framework.callback;

import com.larksuite.framework.callback.Entity.ErrorResult;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface IPagingFetchDataCallback<Data> extends ICallback {
    boolean needContinueLoad();

    void onBeginFetchData();

    void onDataLoadFailed(ErrorResult r1);

    void onDataLoaded(Data r1);

    void onEndFetchData();
}
