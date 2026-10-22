package com.larksuite.component.blockit.entity;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class MGetBlockRequest implements Serializable {
    public List<String> blockIDs;
    public String locale;
    public String tenantID;
    public String userID;

    public MGetBlockRequest() {
    }
}
