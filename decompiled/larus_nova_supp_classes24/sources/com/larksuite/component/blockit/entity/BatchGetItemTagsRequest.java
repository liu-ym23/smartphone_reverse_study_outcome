package com.larksuite.component.blockit.entity;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class BatchGetItemTagsRequest implements Serializable {
    public String context;
    public boolean fetchDeletePerm;
    public boolean fetchSubscribe;
    public boolean needTeamworkerCount;
    public List<String> uniqIds;

    public BatchGetItemTagsRequest() {
    }
}
