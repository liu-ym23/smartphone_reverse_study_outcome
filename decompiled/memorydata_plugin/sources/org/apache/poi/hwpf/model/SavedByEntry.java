package org.apache.poi.hwpf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public final class SavedByEntry {
    private String saveLocation;
    private String userName;

    public SavedByEntry(String r1, String r2) {
        this.userName = r1;
        this.saveLocation = r2;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SavedByEntry.class) == true) goto L8;
        return false;
    L8:
        SavedByEntry r6 = (SavedByEntry) ZeusTransformUtils.preCheckCast(r5, SavedByEntry.class, "com.obric.memorydata.plugin");
        if (r6.userName.equals(this.userName) == false) goto L14;
        if (r6.saveLocation.equals(this.saveLocation) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public String getSaveLocation() {
        return this.saveLocation;
    }

    public String getUserName() {
        return this.userName;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.userName, this.saveLocation});
    }

    public String toString() {
        return "SavedByEntry[userName=" + getUserName() + ",saveLocation=" + getSaveLocation() + "]";
    }
}
