package m;

import ai.j0;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class u implements Temporal, Serializable {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String[] f19921o = null;
    public static final String[] s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String[] f19922t = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LocalDate f19923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f19924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f19925c;
    private String d;
    private int e;
    private int f;
    private int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f19926h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f19927i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f19928j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f19929k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f19930l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f19931m;

    static {
        f19921o = new String[]{"", "正", "二", "三", "四", "五", "六", "七", "八", "九", "十", "冬", "腊"};
        s = new String[]{"〇", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
        f19922t = new String[]{"小寒", "大寒", "立春", "雨水", "惊蛰", "春分", "清明", "谷雨", "立夏", "小满", "芒种", "夏至", "小暑", "大暑", "立秋", "处暑", "白露", "秋分", "寒露", "霜降", "立冬", "小雪", "大雪", "冬至"};
    }

    public LocalDate a() {
        return this.f19923a;
    }

    @Override // java.time.temporal.TemporalAccessor
    public long getLong(TemporalField r5) {
        return this.f19923a.getLong(r5);
    }

    @Override // java.time.temporal.TemporalAccessor
    public boolean isSupported(TemporalField r5) {
        return this.f19923a.isSupported(r5);
    }

    @Override // java.time.temporal.Temporal
    public Temporal plus(long r5, TemporalUnit r10) {
        return this.f19923a.plus(r5, r10);
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("LunarDate [localDate=");
        r5.append(this.f19923a);
        r5.append(",lDateCn=");
        r5.append(this.f19924b);
        r5.append(", suiCi=");
        r5.append(this.f19925c);
        r5.append(", lAnimal=");
        r5.append(this.d);
        r5.append(", lYear=");
        r5.append(this.e);
        r5.append(", lMonth=");
        r5.append(this.f);
        r5.append(", lDay=");
        r5.append(this.g);
        r5.append(", lYearCn=");
        r5.append(this.f19926h);
        r5.append(", lMonthCn=");
        r5.append(this.f19927i);
        r5.append(", lDayCn=");
        r5.append(this.f19928j);
        r5.append(", weekCn=");
        r5.append(this.f19929k);
        r5.append(", solarTerm=");
        r5.append(this.f19930l);
        r5.append(", leapMonthCn=");
        return j0.q(r5, this.f19931m, "]");
    }

    @Override // java.time.temporal.Temporal
    public long until(Temporal r5, TemporalUnit r10) {
        return this.f19923a.until(r5, r10);
    }

    @Override // java.time.temporal.Temporal
    public Temporal with(TemporalField r5, long r10) {
        return this.f19923a.with(r5, r10);
    }

    @Override // java.time.temporal.Temporal
    public boolean isSupported(TemporalUnit r5) {
        return this.f19923a.isSupported(r5);
    }
}
