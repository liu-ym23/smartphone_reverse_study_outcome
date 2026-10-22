package com.lynx.jsbridge.jsi;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface ILynxJSIObjectDescriptor {
    String getClassName();

    String[] getFields();

    String[] getLynxObjectDescriptorInfo(String r1);

    void warmUp();
}
