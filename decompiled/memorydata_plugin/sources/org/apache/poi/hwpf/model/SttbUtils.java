package org.apache.poi.hwpf.model;

/* JADX INFO: loaded from: classes7.dex */
class SttbUtils {
    static String[] readSttbSavedBy(byte[] r2, int r3) {
        return new Sttb(2, r2, r3).getData();
    }

    static String[] readSttbfBkmk(byte[] r2, int r3) {
        return new Sttb(2, r2, r3).getData();
    }

    static String[] readSttbfRMark(byte[] r2, int r3) {
        return new Sttb(2, r2, r3).getData();
    }
}
