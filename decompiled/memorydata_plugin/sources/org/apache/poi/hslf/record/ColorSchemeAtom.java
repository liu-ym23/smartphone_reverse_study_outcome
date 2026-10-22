package org.apache.poi.hslf.record;

import androidx.core.view.ViewCompat;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hslf.exceptions.HSLFException;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class ColorSchemeAtom extends RecordAtom {
    private final byte[] _header;
    private int accentAndFollowingHyperlinkColourRGB;
    private int accentAndHyperlinkColourRGB;
    private int accentColourRGB;
    private int backgroundColourRGB;
    private int fillsColourRGB;
    private int shadowsColourRGB;
    private int textAndLinesColourRGB;
    private int titleTextColourRGB;

    public ColorSchemeAtom() {
        byte[] r0 = new byte[8];
        this._header = r0;
        LittleEndian.putUShort(r0, 0, 16);
        LittleEndian.putUShort(r0, 2, 2032);
        LittleEndian.putInt(r0, 4, 32);
        this.backgroundColourRGB = ViewCompat.MEASURED_SIZE_MASK;
        this.textAndLinesColourRGB = 0;
        this.shadowsColourRGB = 8421504;
        this.titleTextColourRGB = 0;
        this.fillsColourRGB = 10079232;
        this.accentColourRGB = 13382451;
        this.accentAndHyperlinkColourRGB = 16764108;
        this.accentAndFollowingHyperlinkColourRGB = 11711154;
    }

    public ColorSchemeAtom(byte[] r2, int r3, int r4) {
        if (r4 < 40) goto L5;
    L9:
        int r5 = r3 + 8;
        this._header = Arrays.copyOfRange(r2, r3, r5);
        this.backgroundColourRGB = LittleEndian.getInt(r2, r5);
        this.textAndLinesColourRGB = LittleEndian.getInt(r2, r5 + 4);
        this.shadowsColourRGB = LittleEndian.getInt(r2, r5 + 8);
        this.titleTextColourRGB = LittleEndian.getInt(r2, r5 + 12);
        this.fillsColourRGB = LittleEndian.getInt(r2, r5 + 16);
        this.accentColourRGB = LittleEndian.getInt(r2, r5 + 20);
        this.accentAndHyperlinkColourRGB = LittleEndian.getInt(r2, r5 + 24);
        this.accentAndFollowingHyperlinkColourRGB = LittleEndian.getInt(r2, r5 + 28);
        return;
    L5:
        if ((r2.length - r3) >= 40) goto L9;
        throw new HSLFException("Not enough data to form a ColorSchemeAtom (always 40 bytes long) - found " + (r2.length - r3));
    }

    public int getAccentAndFollowingHyperlinkColourRGB() {
        return this.accentAndFollowingHyperlinkColourRGB;
    }

    public int getAccentAndHyperlinkColourRGB() {
        return this.accentAndHyperlinkColourRGB;
    }

    public int getAccentColourRGB() {
        return this.accentColourRGB;
    }

    public int getBackgroundColourRGB() {
        return this.backgroundColourRGB;
    }

    public int getFillsColourRGB() {
        return this.fillsColourRGB;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("backgroundColourRGB", new $$Lambda$kdwMntJAbz7jCPntDK0WjyRi5aY(this));
        r0.put("textAndLinesColourRGB", new $$Lambda$Xbt2fEaCUdkQZNdEjxgapN5MzvQ(this));
        r0.put("shadowsColourRGB", new $$Lambda$p3csc1pXuvrr8CA8eNjpvQbHVk(this));
        r0.put("titleTextColourRGB", new $$Lambda$gbFQ1FlyZtTLULEjZZ8yNvHmEC0(this));
        r0.put("fillsColourRGB", new $$Lambda$NQY7yb_zz2QRoRD6YnXDppynYek(this));
        r0.put("accentColourRGB", new $$Lambda$tIykKb_8KT1wdDkpwOULkikKXEI(this));
        r0.put("accentAndHyperlinkColourRGB", new $$Lambda$e9zzQQwVH2wYD67eTP2DR1Ld8o4(this));
        r0.put("accentAndFollowingHyperlinkColourRGB", new $$Lambda$xIoiWXveS12W90KmDo95JDBSg(this));
        return Collections.unmodifiableMap(r0);
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return 2032;
    }

    public int getShadowsColourRGB() {
        return this.shadowsColourRGB;
    }

    public int getTextAndLinesColourRGB() {
        return this.textAndLinesColourRGB;
    }

    public int getTitleTextColourRGB() {
        return this.titleTextColourRGB;
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r2) {
        r2.write(this._header);
        writeLittleEndian(this.backgroundColourRGB, r2);
        writeLittleEndian(this.textAndLinesColourRGB, r2);
        writeLittleEndian(this.shadowsColourRGB, r2);
        writeLittleEndian(this.titleTextColourRGB, r2);
        writeLittleEndian(this.fillsColourRGB, r2);
        writeLittleEndian(this.accentColourRGB, r2);
        writeLittleEndian(this.accentAndHyperlinkColourRGB, r2);
        writeLittleEndian(this.accentAndFollowingHyperlinkColourRGB, r2);
    }
}
