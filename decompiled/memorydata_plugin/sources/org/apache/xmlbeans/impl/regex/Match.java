package org.apache.xmlbeans.impl.regex;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.CharacterIterator;

/* JADX INFO: loaded from: classes7.dex */
public class Match implements Cloneable {
    int[] beginpos;
    char[] charSource;
    CharacterIterator ciSource;
    int[] endpos;
    int nofgroups;
    String strSource;

    public Match() {
        this.beginpos = null;
        this.endpos = null;
        this.nofgroups = 0;
        this.ciSource = null;
        this.strSource = null;
        this.charSource = null;
    }

    public synchronized Object clone() {
        monitor-enter(this);
        Match r0 = new Match();     // Catch: Throwable -> L18
        int r1 = this.nofgroups;     // Catch: Throwable -> L18
        if (r1 <= 0) goto L16;
        r0.setNumberOfGroups(r1);     // Catch: Throwable -> L18
        CharacterIterator r2 = this.ciSource;     // Catch: Throwable -> L18
        if (r2 == null) goto L8;
        r0.setSource(r2);     // Catch: Throwable -> L18
    L8:
        String r3 = this.strSource;     // Catch: Throwable -> L18
        if (r3 == null) goto L11;
        r0.setSource(r3);     // Catch: Throwable -> L18
    L11:
        int r4 = 0;
    L12:
        if (r4 >= this.nofgroups) goto L16;
        r0.setBeginning(r4, getBeginning(r4));     // Catch: Throwable -> L18
        r0.setEnd(r4, getEnd(r4));     // Catch: Throwable -> L18
        r4 = r4 + 1;
    L16:
        monitor-exit(this);
        return r0;
    L18:
        th = move-exception;
        throw th;
    }

    public int getBeginning(int r4) {
        int[] r0 = this.beginpos;
        if (r0 == null) goto L12;
        if (r4 < 0) goto L10;
        if (this.nofgroups <= r4) goto L10;
        return r0[r4];
    L10:
        throw new IllegalArgumentException("The parameter must be less than " + this.nofgroups + ": " + r4);
    L12:
        throw new IllegalStateException("A result is not set.");
    }

    public int getEnd(int r4) {
        int[] r0 = this.endpos;
        if (r0 == null) goto L12;
        if (r4 < 0) goto L10;
        if (this.nofgroups <= r4) goto L10;
        return r0[r4];
    L10:
        throw new IllegalArgumentException("The parameter must be less than " + this.nofgroups + ": " + r4);
    L12:
        throw new IllegalStateException("A result is not set.");
    }

    public void setBeginning(int r1, int r2) {
        this.beginpos[r1] = r2;
    }

    public void setEnd(int r1, int r2) {
        this.endpos[r1] = r2;
    }

    public void setNumberOfGroups(int r4) {
        int r0 = this.nofgroups;
        this.nofgroups = r4;
        if (r0 <= 0) goto L7;
        if (r0 < r4) goto L7;
        if ((r4 * 2) < r0) goto L7;
    L8:
        int r1 = 0;
    L9:
        if (r1 >= r4) goto L11;
        this.beginpos[r1] = -1;
        this.endpos[r1] = -1;
        r1 = r1 + 1;
        goto L9
    L11:
        return;
    L7:
        this.beginpos = new int[r4];
        this.endpos = new int[r4];
        goto L8
    }

    public void setSource(String r2) {
        this.ciSource = null;
        this.strSource = r2;
        this.charSource = null;
    }

    public void setSource(CharacterIterator r3) {
        this.ciSource = (CharacterIterator) ZeusTransformUtils.wrapperContextForParams(r3, CharacterIterator.class, "com.obric.memorydata.plugin");
        this.strSource = null;
        this.charSource = null;
    }

    public void setSource(char[] r2) {
        this.ciSource = null;
        this.strSource = null;
        this.charSource = r2;
    }
}
