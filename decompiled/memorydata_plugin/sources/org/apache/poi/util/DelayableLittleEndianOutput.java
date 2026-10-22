package org.apache.poi.util;

/* JADX INFO: loaded from: classes7.dex */
public interface DelayableLittleEndianOutput extends LittleEndianOutput {
    LittleEndianOutput createDelayedOutput(int r1);
}
