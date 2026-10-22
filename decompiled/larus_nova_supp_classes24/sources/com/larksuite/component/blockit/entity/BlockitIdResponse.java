package com.larksuite.component.blockit.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class BlockitIdResponse implements Serializable {
    public int code;
    public Data data;
    public String msg;

    public class Data implements Serializable {
        public String BlockID;
        final /* synthetic */ BlockitIdResponse this$0;

        public Data(BlockitIdResponse r1) {
            this.this$0 = r1;
        }
    }

    public BlockitIdResponse() {
    }
}
