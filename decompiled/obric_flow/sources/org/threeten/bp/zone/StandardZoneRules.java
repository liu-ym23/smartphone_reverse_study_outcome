package org.threeten.bp.zone;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.threeten.bp.Duration;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneOffset;

/* JADX INFO: loaded from: classes3.dex */
final class StandardZoneRules extends d implements Serializable {
    private static final long serialVersionUID = 3044319355680032515L;
    private final ZoneOffsetTransitionRule[] lastRules;
    private final ConcurrentMap<Integer, ZoneOffsetTransition[]> lastRulesCache;
    private final long[] savingsInstantTransitions;
    private final LocalDateTime[] savingsLocalTransitions;
    private final ZoneOffset[] standardOffsets;
    private final long[] standardTransitions;
    private final ZoneOffset[] wallOffsets;

    public StandardZoneRules(ZoneOffset r5, ZoneOffset r10, List<ZoneOffsetTransition> r11, List<ZoneOffsetTransition> r12, List<ZoneOffsetTransitionRule> r13) {
        this.lastRulesCache = new ConcurrentHashMap();
        this.standardTransitions = new long[r11.size()];
        ZoneOffset[] r14 = new ZoneOffset[r11.size() + 1];
        this.standardOffsets = r14;
        int r15 = 0;
        r14[0] = r5;
        int r16 = 0;
    L4:
        if (r16 >= r11.size()) goto L6;
        this.standardTransitions[r16] = r11.get(r16).toEpochSecond();
        int r17 = r16 + 1;
        this.standardOffsets[r17] = r11.get(r16).getOffsetAfter();
        r16 = r17;
        goto L4
    L6:
        ArrayList r18 = new ArrayList();
        ArrayList r19 = new ArrayList();
        r19.add(r10);
        Iterator<ZoneOffsetTransition> r20 = r12.iterator();
    L8:
        if (r20.hasNext() == false) goto L14;
        ZoneOffsetTransition r21 = r20.next();
        if (r21.isGap() == false) goto L12;
        r18.add(r21.getDateTimeBefore());
        r18.add(r21.getDateTimeAfter());
    L13:
        r19.add(r21.getOffsetAfter());
        goto L8
    L12:
        r18.add(r21.getDateTimeAfter());
        r18.add(r21.getDateTimeBefore());
        goto L13
    L14:
        this.savingsLocalTransitions = (LocalDateTime[]) r18.toArray(new LocalDateTime[r18.size()]);
        this.wallOffsets = (ZoneOffset[]) r19.toArray(new ZoneOffset[r19.size()]);
        this.savingsInstantTransitions = new long[r12.size()];
    L16:
        if (r15 >= r12.size()) goto L19;
        this.savingsInstantTransitions[r15] = r12.get(r15).getInstant().getEpochSecond();
        r15 = r15 + 1;
        goto L16
    L19:
        if (r13.size() > 15) goto L23;
        this.lastRules = (ZoneOffsetTransitionRule[]) r13.toArray(new ZoneOffsetTransitionRule[r13.size()]);
        return;
    L23:
        throw new IllegalArgumentException("Too many transition rules");
    }

    public static int b(long r5, ZoneOffset r10) {
        return LocalDate.ofEpochDay(jm.c.l(r5 + ((long) r10.getTotalSeconds()), 86400)).getYear();
    }

    public static StandardZoneRules readExternal(DataInput r10) throws IOException, ClassNotFoundException {
        int r5 = r10.readInt();
        long[] r11 = new long[r5];
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r13 >= r5) goto L5;
        r11[r13] = Ser.readEpochSec(r10);
        r13 = r13 + 1;
        goto L3
    L5:
        int r14 = r5 + 1;
        ZoneOffset[] r15 = new ZoneOffset[r14];
        int r16 = 0;
    L6:
        if (r16 >= r14) goto L8;
        r15[r16] = Ser.readOffset(r10);
        r16 = r16 + 1;
        goto L6
    L8:
        int r17 = r10.readInt();
        long[] r18 = new long[r17];
        int r19 = 0;
    L9:
        if (r19 >= r17) goto L11;
        r18[r19] = Ser.readEpochSec(r10);
        r19 = r19 + 1;
        goto L9
    L11:
        int r20 = r17 + 1;
        ZoneOffset[] r21 = new ZoneOffset[r20];
        int r22 = 0;
    L12:
        if (r22 >= r20) goto L14;
        r21[r22] = Ser.readOffset(r10);
        r22 = r22 + 1;
        goto L12
    L14:
        int r23 = r10.readByte();
        ZoneOffsetTransitionRule[] r24 = new ZoneOffsetTransitionRule[r23];
    L15:
        if (r12 >= r23) goto L18;
        r24[r12] = ZoneOffsetTransitionRule.readExternal(r10);
        r12 = r12 + 1;
        goto L15
    L18:
        return new StandardZoneRules(r11, r15, r18, r21, r24);
    }

    private Object writeReplace() {
        return new Ser((byte) 1, this);
    }

    public final ZoneOffsetTransition[] a(int r10) {
        Integer r5 = Integer.valueOf(r10);
        ZoneOffsetTransition[] r11 = this.lastRulesCache.get(r5);
        if (r11 == null) goto L5;
        return r11;
    L5:
        ZoneOffsetTransitionRule[] r12 = this.lastRules;
        ZoneOffsetTransition[] r13 = new ZoneOffsetTransition[r12.length];
        int r14 = 0;
    L7:
        if (r14 >= r12.length) goto L10;
        r13[r14] = r12[r14].createTransition(r10);
        r14 = r14 + 1;
        goto L7
    L10:
        if (r10 >= 2100) goto L12;
        this.lastRulesCache.putIfAbsent(r5, r13);
    L12:
        return r13;
    }

    public final Object c(LocalDateTime r10) {
        int r5 = 0;
        if (this.lastRules.length <= 0) goto L31;
        LocalDateTime[] r11 = this.savingsLocalTransitions;
        if (r10.isAfter(r11[r11.length - 1]) == false) goto L31;
        ZoneOffsetTransition[] r12 = a(r10.getYear());
        int r13 = r12.length;
        ZoneOffset r14 = null;
    L7:
        if (r5 >= r13) goto L30;
        ZoneOffsetTransition r15 = r12[r5];
        LocalDateTime r16 = r15.getDateTimeBefore();
        if (r15.isGap() == false) goto L18;
        if (r10.isBefore(r16) == false) goto L14;
        ZoneOffset r17 = r15.getOffsetBefore();
    L24:
        if ((r17 instanceof ZoneOffsetTransition) == true) goto L29;
        if (r17.equals(r15.getOffsetBefore()) == true) goto L29;
        r5 = r5 + 1;
        r14 = r17;
    L29:
        return r17;
    L14:
        if (r10.isBefore(r15.getDateTimeAfter()) == false) goto L16;
    L15:
        r17 = r15;
        goto L24
    L16:
        r17 = r15.getOffsetAfter();
        goto L24
    L18:
        if (r10.isBefore(r16) == true) goto L21;
        r17 = r15.getOffsetAfter();
        goto L24
    L21:
        if (r10.isBefore(r15.getDateTimeAfter()) == false) goto L15;
        r17 = r15.getOffsetBefore();
        goto L24
    L30:
        return r14;
    L31:
        int r18 = Arrays.binarySearch(this.savingsLocalTransitions, r10);
        if (r18 == (-1)) goto L34;
        if (r18 >= 0) goto L37;
        r18 = (-r18) - 2;
    L43:
        if ((r18 & 1) != 0) goto L51;
        LocalDateTime[] r19 = this.savingsLocalTransitions;
        LocalDateTime r20 = r19[r18];
        LocalDateTime r21 = r19[r18 + 1];
        ZoneOffset[] r22 = this.wallOffsets;
        int r23 = r18 / 2;
        ZoneOffset r24 = r22[r23];
        ZoneOffset r25 = r22[r23 + 1];
        if (r25.getTotalSeconds() <= r24.getTotalSeconds()) goto L49;
        return new ZoneOffsetTransition(r20, r24, r25);
    L49:
        return new ZoneOffsetTransition(r21, r24, r25);
    L51:
        return this.wallOffsets[(r18 / 2) + 1];
    L37:
        Object[] r26 = this.savingsLocalTransitions;
        if (r18 >= (r26.length - 1)) goto L43;
        int r27 = r18 + 1;
        if (r26[r18].equals(r26[r27]) == false) goto L43;
        r18 = r27;
        goto L43
    L34:
        return this.wallOffsets[0];
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof StandardZoneRules) == false) goto L21;
        StandardZoneRules r10 = (StandardZoneRules) r5;
        if (Arrays.equals(this.standardTransitions, r10.standardTransitions) == false) goto L19;
        if (Arrays.equals(this.standardOffsets, r10.standardOffsets) == false) goto L19;
        if (Arrays.equals(this.savingsInstantTransitions, r10.savingsInstantTransitions) == false) goto L19;
        if (Arrays.equals(this.wallOffsets, r10.wallOffsets) == false) goto L19;
        if (Arrays.equals(this.lastRules, r10.lastRules) == false) goto L19;
        return true;
    L19:
        return false;
    L21:
        if ((r5 instanceof ZoneRules$Fixed) == true) goto L23;
        return false;
    L23:
        if (isFixedOffset() == false) goto L28;
        Instant r11 = Instant.EPOCH;
        if (getOffset(r11).equals(((ZoneRules$Fixed) r5).getOffset(r11)) == false) goto L28;
        return true;
    L28:
        return false;
    }

    public Duration getDaylightSavings(Instant r5) {
        return Duration.ofSeconds(getOffset(r5).getTotalSeconds() - getStandardOffset(r5).getTotalSeconds());
    }

    @Override // org.threeten.bp.zone.d
    public ZoneOffset getOffset(Instant r10) {
        long r5 = r10.getEpochSecond();
        if (this.lastRules.length <= 0) goto L16;
        long[] r11 = this.savingsInstantTransitions;
        if (r5 <= r11[r11.length - 1]) goto L16;
        ZoneOffset[] r12 = this.wallOffsets;
        ZoneOffsetTransition[] r13 = a(b(r5, r12[r12.length - 1]));
        ZoneOffsetTransition r14 = null;
        int r15 = 0;
    L8:
        if (r15 >= r13.length) goto L15;
        r14 = r13[r15];
        if (r5 < r14.toEpochSecond()) goto L12;
        r15 = r15 + 1;
        goto L8
    L12:
        return r14.getOffsetBefore();
    L15:
        return r14.getOffsetAfter();
    L16:
        int r16 = Arrays.binarySearch(this.savingsInstantTransitions, r5);
        if (r16 >= 0) goto L20;
        r16 = (-r16) - 2;
    L20:
        return this.wallOffsets[r16 + 1];
    }

    public ZoneOffset getStandardOffset(Instant r5) {
        int r10 = Arrays.binarySearch(this.standardTransitions, r5.getEpochSecond());
        if (r10 >= 0) goto L6;
        r10 = (-r10) - 2;
    L6:
        return this.standardOffsets[r10 + 1];
    }

    @Override // org.threeten.bp.zone.d
    public ZoneOffsetTransition getTransition(LocalDateTime r5) {
        Object r10 = c(r5);
        if ((r10 instanceof ZoneOffsetTransition) == true) goto L7;
        return null;
    L7:
        return (ZoneOffsetTransition) r10;
    }

    public List<ZoneOffsetTransitionRule> getTransitionRules() {
        return Collections.unmodifiableList(Arrays.asList(this.lastRules));
    }

    public List<ZoneOffsetTransition> getTransitions() {
        ArrayList r5 = new ArrayList();
        int r10 = 0;
    L3:
        long[] r11 = this.savingsInstantTransitions;
        if (r10 >= r11.length) goto L7;
        long r12 = r11[r10];
        ZoneOffset[] r13 = this.wallOffsets;
        ZoneOffset r14 = r13[r10];
        r10 = r10 + 1;
        r5.add(new ZoneOffsetTransition(r12, r14, r13[r10]));
        goto L3
    L7:
        return Collections.unmodifiableList(r5);
    }

    @Override // org.threeten.bp.zone.d
    public List<ZoneOffset> getValidOffsets(LocalDateTime r5) {
        Object r10 = c(r5);
        if ((r10 instanceof ZoneOffsetTransition) == false) goto L7;
        return ((ZoneOffsetTransition) r10).getValidOffsets();
    L7:
        return Collections.singletonList((ZoneOffset) r10);
    }

    public int hashCode() {
        int r5 = ((Arrays.hashCode(this.standardTransitions) ^ Arrays.hashCode(this.standardOffsets)) ^ Arrays.hashCode(this.savingsInstantTransitions)) ^ Arrays.hashCode(this.wallOffsets);
        return Arrays.hashCode(this.lastRules) ^ r5;
    }

    @Override // org.threeten.bp.zone.d
    public boolean isDaylightSavings(Instant r5) {
        return !getStandardOffset(r5).equals(getOffset(r5));
    }

    @Override // org.threeten.bp.zone.d
    public boolean isFixedOffset() {
        if (this.savingsInstantTransitions.length != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.threeten.bp.zone.d
    public boolean isValidOffset(LocalDateTime r5, ZoneOffset r10) {
        return getValidOffsets(r5).contains(r10);
    }

    public ZoneOffsetTransition nextTransition(Instant r11) {
        if (this.savingsInstantTransitions.length != 0) goto L5;
        return null;
    L5:
        long r5 = r11.getEpochSecond();
        long[] r12 = this.savingsInstantTransitions;
        if (r5 >= r12[r12.length - 1]) goto L8;
        int r13 = Arrays.binarySearch(r12, r5);
        if (r13 >= 0) goto L24;
        int r14 = (-r13) - 1;
    L25:
        long r10 = this.savingsInstantTransitions[r14];
        ZoneOffset[] r15 = this.wallOffsets;
        return new ZoneOffsetTransition(r10, r15[r14], r15[r14 + 1]);
    L24:
        r14 = r13 + 1;
        goto L25
    L8:
        if (this.lastRules.length != 0) goto L10;
        return null;
    L10:
        ZoneOffset[] r16 = this.wallOffsets;
        int r17 = b(r5, r16[r16.length - 1]);
        ZoneOffsetTransition[] r18 = a(r17);
        int r19 = r18.length;
        int r20 = 0;
    L11:
        if (r20 >= r19) goto L17;
        ZoneOffsetTransition r21 = r18[r20];
        if (r5 < r21.toEpochSecond()) goto L14;
        r20 = r20 + 1;
        goto L11
    L14:
        return r21;
    L17:
        if (r17 < 999999999) goto L19;
        return null;
    L19:
        return a(r17 + 1)[0];
    }

    public ZoneOffsetTransition previousTransition(Instant r11) {
        if (this.savingsInstantTransitions.length != 0) goto L5;
        return null;
    L5:
        long r5 = r11.getEpochSecond();
        if (r11.getNano() > 0) goto L8;
    L10:
        long[] r12 = this.savingsInstantTransitions;
        long r10 = r12[r12.length - 1];
        if (this.lastRules.length > 0) goto L13;
    L25:
        int r13 = Arrays.binarySearch(this.savingsInstantTransitions, r5);
        if (r13 >= 0) goto L28;
        r13 = (-r13) - 1;
    L28:
        if (r13 > 0) goto L30;
        return null;
    L30:
        int r14 = r13 - 1;
        long r15 = this.savingsInstantTransitions[r14];
        ZoneOffset[] r16 = this.wallOffsets;
        return new ZoneOffsetTransition(r15, r16[r14], r16[r13]);
    L13:
        if (r5 <= r10) goto L25;
        ZoneOffset[] r17 = this.wallOffsets;
        ZoneOffset r18 = r17[r17.length - 1];
        int r19 = b(r5, r18);
        ZoneOffsetTransition[] r20 = a(r19);
        int r21 = r20.length - 1;
    L15:
        if (r21 < 0) goto L21;
        if (r5 > r20[r21].toEpochSecond()) goto L19;
        r21 = r21 - 1;
        goto L15
    L19:
        return r20[r21];
    L21:
        int r22 = r19 - 1;
        if (r22 <= b(r10, r18)) goto L25;
        ZoneOffsetTransition[] r110 = a(r22);
        return r110[r110.length - 1];
    L8:
        if (r5 >= Long.MAX_VALUE) goto L10;
        r5 = r5 + 1;
        goto L10
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("StandardZoneRules[currentStandardOffset=");
        ZoneOffset[] r10 = this.standardOffsets;
        r5.append(r10[r10.length - 1]);
        r5.append("]");
        return r5.toString();
    }

    public void writeExternal(DataOutput r10) throws IOException {
        r10.writeInt(this.standardTransitions.length);
        long[] r5 = this.standardTransitions;
        int r11 = r5.length;
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L5;
        Ser.writeEpochSec(r5[r13], r10);
        r13 = r13 + 1;
        goto L3
    L5:
        ZoneOffset[] r14 = this.standardOffsets;
        int r15 = r14.length;
        int r16 = 0;
    L6:
        if (r16 >= r15) goto L8;
        Ser.writeOffset(r14[r16], r10);
        r16 = r16 + 1;
        goto L6
    L8:
        r10.writeInt(this.savingsInstantTransitions.length);
        long[] r17 = this.savingsInstantTransitions;
        int r18 = r17.length;
        int r19 = 0;
    L9:
        if (r19 >= r18) goto L11;
        Ser.writeEpochSec(r17[r19], r10);
        r19 = r19 + 1;
        goto L9
    L11:
        ZoneOffset[] r20 = this.wallOffsets;
        int r21 = r20.length;
        int r22 = 0;
    L12:
        if (r22 >= r21) goto L14;
        Ser.writeOffset(r20[r22], r10);
        r22 = r22 + 1;
        goto L12
    L14:
        r10.writeByte(this.lastRules.length);
        ZoneOffsetTransitionRule[] r23 = this.lastRules;
        int r24 = r23.length;
    L15:
        if (r12 >= r24) goto L17;
        r23[r12].writeExternal(r10);
        r12 = r12 + 1;
        goto L15
    }

    public ZoneOffset getOffset(LocalDateTime r5) {
        Object r10 = c(r5);
        if ((r10 instanceof ZoneOffsetTransition) == false) goto L7;
        return ((ZoneOffsetTransition) r10).getOffsetBefore();
    L7:
        return (ZoneOffset) r10;
    }

    public StandardZoneRules(long[] r10, ZoneOffset[] r11, long[] r12, ZoneOffset[] r13, ZoneOffsetTransitionRule[] r14) {
        this.lastRulesCache = new ConcurrentHashMap();
        this.standardTransitions = r10;
        this.standardOffsets = r11;
        this.savingsInstantTransitions = r12;
        this.wallOffsets = r13;
        this.lastRules = r14;
        ArrayList r15 = new ArrayList();
        int r16 = 0;
    L4:
        if (r16 >= r12.length) goto L10;
        ZoneOffset r17 = r13[r16];
        int r5 = r16 + 1;
        ZoneOffset r18 = r13[r5];
        ZoneOffsetTransition r19 = new ZoneOffsetTransition(r12[r16], r17, r18);
        if (r19.isGap() == false) goto L8;
        r15.add(r19.getDateTimeBefore());
        r15.add(r19.getDateTimeAfter());
    L9:
        r16 = r5;
        goto L4
    L8:
        r15.add(r19.getDateTimeAfter());
        r15.add(r19.getDateTimeBefore());
        goto L9
    L10:
        this.savingsLocalTransitions = (LocalDateTime[]) r15.toArray(new LocalDateTime[r15.size()]);
    }
}
