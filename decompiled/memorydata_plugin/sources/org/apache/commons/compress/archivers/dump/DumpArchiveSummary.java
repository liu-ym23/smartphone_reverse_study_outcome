package org.apache.commons.compress.archivers.dump;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class DumpArchiveSummary {
    private String devname;
    private long dumpDate;
    private String hostname;
    private String label;

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (r7 != null) goto L8;
    L25:
        return false;
    L8:
        if (r7.getClass().equals(getClass()) == false) goto L25;
        DumpArchiveSummary r8 = (DumpArchiveSummary) ZeusTransformUtils.preCheckCast(r7, DumpArchiveSummary.class, "com.obric.memorydata.plugin");
        if (this.dumpDate == r8.dumpDate) goto L14;
        return false;
    L14:
        if (getHostname() == null) goto L25;
        if (getHostname().equals(r8.getHostname()) == false) goto L25;
        if (getDevname() == null) goto L24;
        if (getDevname().equals(r8.getDevname()) == false) goto L24;
        return true;
    L24:
        return false;
    }

    public String getDevname() {
        return this.devname;
    }

    public String getHostname() {
        return this.hostname;
    }

    public int hashCode() {
        String r0 = this.label;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        int r2 = (int) (((long) r1) + (this.dumpDate * 31));
        String r3 = this.hostname;
        if (r3 == null) goto L9;
        r2 = (r3.hashCode() * 31) + 17;
    L9:
        String r8 = this.devname;
        if (r8 != null) goto L12;
        return r2;
    L12:
        return (r8.hashCode() * 31) + 17;
    L5:
        r1 = 17;
        goto L6
    }
}
