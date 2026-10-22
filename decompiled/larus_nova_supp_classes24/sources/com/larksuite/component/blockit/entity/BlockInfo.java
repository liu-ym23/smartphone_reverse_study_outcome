package com.larksuite.component.blockit.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class BlockInfo implements Serializable {
    public String blockID;
    public String blockTypeID;
    public String i18nPreview;
    public String i18nSummary;
    public String sourceData;
    public String sourceLink;
    public String sourceMeta;

    public BlockInfo(BlockEntity r2) {
        this.blockID = r2.getBlockID();
        this.blockTypeID = r2.getBlockTypeID();
        this.sourceLink = r2.getSourceLink();
        this.sourceMeta = r2.getSourceMeta();
        this.sourceData = r2.getSourceData();
        this.i18nPreview = r2.getPreview();
        this.i18nSummary = r2.getSummary();
    }
}
