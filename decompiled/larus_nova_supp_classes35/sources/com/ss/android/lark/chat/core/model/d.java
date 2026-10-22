package com.ss.android.lark.chat.core.model;

import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface d<T> extends List<T> {

    public interface a<T extends d> {
    }

    void acquireReadAccess();

    void addOnListUpdateCallback(a<? extends d<T>> r1);

    void releaseReadAccess();

    void removeOnListUpdateCallback(a<? extends d<T>> r1);
}
