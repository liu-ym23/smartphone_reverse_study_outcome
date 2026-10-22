package com.bytedance.bdinstall.oaid;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
interface OaidApi {

    public static class Result {
        boolean isTrackLimit;
        String oaid;

        public Result() {
        }
    }

    String getName();

    Result getOaid(Context r1);

    boolean support(Context r1);
}
