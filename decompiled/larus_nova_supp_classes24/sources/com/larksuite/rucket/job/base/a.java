package com.larksuite.rucket.job.base;

import com.larksuite.rucket.job.RucketJob;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface a<P extends RucketJob<?>> {
    void setNextJob(P r1);

    void setPrevJob(P r1);
}
