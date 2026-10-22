package org.apache.poi.hwpf.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.util.v;
import org.apache.poi.hwpf.model.types.BKFAbstractType;

/* JADX INFO: loaded from: classes7.dex */
public class BookmarksTables {
    private static final c LOG = null;
    private PlexOfCps descriptorsFirst;
    private PlexOfCps descriptorsLim;
    private List<String> names;

    static {
        LOG = b.a(BookmarksTables.class);
    }

    public BookmarksTables(byte[] r3, FileInformationBlock r4) {
        this.descriptorsFirst = new PlexOfCps(4);
        this.descriptorsLim = new PlexOfCps(0);
        this.names = new ArrayList(0);
        read(r3, r4);
    }

    private void read(byte[] r5, FileInformationBlock r6) {
        int r0 = r6.getFcSttbfbkmk();
        int r1 = r6.getLcbSttbfbkmk();
        if (r0 == 0) goto L6;
        if (r1 == 0) goto L6;
        this.names = new ArrayList(Arrays.asList(SttbUtils.readSttbfBkmk(r5, r0)));
    L6:
        int r2 = r6.getFcPlcfbkf();
        int r3 = r6.getLcbPlcfbkf();
        if (r2 == 0) goto L10;
        if (r3 == 0) goto L10;
        this.descriptorsFirst = new PlexOfCps(r5, r2, r3, BKFAbstractType.getSize());
    L10:
        int r4 = r6.getFcPlcfbkl();
        int r7 = r6.getLcbPlcfbkl();
        if (r4 == 0) goto L15;
        if (r7 == 0) goto L16;
        this.descriptorsLim = new PlexOfCps(r5, r4, r7, 0);
        return;
    L16:
        return;
    }

    public void afterDelete(int r3, int r4) {
        int r5 = -r4;
        this.descriptorsFirst.adjust(r3, r5);
        this.descriptorsLim.adjust(r3, r5);
        int r6 = 0;
    L4:
        if (r6 >= this.descriptorsFirst.length()) goto L9;
        if (this.descriptorsFirst.getProperty(r6).getStart() != this.descriptorsLim.getProperty(r6).getStart()) goto L8;
        LOG.atDebug().a("Removing bookmark #{}...", v.a(r6));
        remove(r6);
        r6 = r6 - 1;
    L8:
        r6 = r6 + 1;
        goto L4
    }

    public void remove(int r2) {
        this.descriptorsFirst.remove(r2);
        this.descriptorsLim.remove(r2);
        this.names.remove(r2);
    }
}
