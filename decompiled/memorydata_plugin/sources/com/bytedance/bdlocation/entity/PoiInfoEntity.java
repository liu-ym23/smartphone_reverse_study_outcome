package com.bytedance.bdlocation.entity;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class PoiInfoEntity implements Comparable<PoiInfoEntity> {
    public String AmapID;
    public String AwemeID;
    public float Confidence;
    public float Distance;
    public String LocationID;
    public String Name;
    public String Source;
    public String Typecode;

    public PoiInfoEntity() {
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(PoiInfoEntity r1) {
        return Float.compare(r1.Confidence, this.Confidence);
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(PoiInfoEntity r3) {
        return compareTo2((PoiInfoEntity) ZeusTransformUtils.preCheckCast(r3, PoiInfoEntity.class, "com.obric.memorydata.plugin"));
    }
}
