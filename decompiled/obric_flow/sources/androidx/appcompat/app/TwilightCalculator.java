package androidx.appcompat.app;

/* JADX INFO: loaded from: classes.dex */
class TwilightCalculator {
    private static final float ALTIDUTE_CORRECTION_CIVIL_TWILIGHT = -0.10471976f;
    private static final float C1 = 0.0334196f;
    private static final float C2 = 3.49066E-4f;
    private static final float C3 = 5.236E-6f;
    public static final int DAY = 0;
    private static final float DEGREES_TO_RADIANS = 0.017453292f;
    private static final float J0 = 9.0E-4f;
    public static final int NIGHT = 1;
    private static final float OBLIQUITY = 0.4092797f;
    private static final long UTC_2000 = 946728000000L;
    private static TwilightCalculator sInstance;
    public int state;
    public long sunrise;
    public long sunset;

    public TwilightCalculator() {
    }

    public static TwilightCalculator getInstance() {
        if (sInstance != null) goto L6;
        sInstance = new TwilightCalculator();
    L6:
        return sInstance;
    }

    public void calculateTwilight(long r16, double r18, double r20) {
        float r5 = (r16 - UTC_2000) / 8.64E7f;
        float r10 = (0.01720197f * r5) + 6.24006f;
        double r11 = r10;
        double r12 = (((Math.sin(r10 * 3.0f) * 5.236000106378924E-6d) + ((Math.sin(2.0f * r10) * 3.4906598739326E-4d) + ((Math.sin(r11) * 0.03341960161924362d) + r11))) + 1.796593063d) + 3.141592653589793d;
        double r13 = (-r20) / 360.0d;
        double r14 = (Math.sin(2.0d * r12) * (-0.0069d)) + ((Math.sin(r11) * 0.0053d) + (((double) (Math.round(((double) (r5 - J0)) - r13) + J0)) + r13));
        double r15 = Math.asin(Math.sin(0.4092797040939331d) * Math.sin(r12));
        double r17 = 0.01745329238474369d * r18;
        double r19 = (Math.sin(-0.10471975803375244d) - (Math.sin(r15) * Math.sin(r17))) / (Math.cos(r15) * Math.cos(r17));
        if (r19 < 1.0d) goto L7;
        this.state = 1;
        this.sunset = -1;
        this.sunrise = -1;
        return;
    L7:
        if (r19 > (-1.0d)) goto L10;
        this.state = 0;
        this.sunset = -1;
        this.sunrise = -1;
        return;
    L10:
        double r21 = (float) (Math.acos(r19) / 6.283185307179586d);
        this.sunset = Math.round((r14 + r21) * 8.64E7d) + UTC_2000;
        long r22 = Math.round((r14 - r21) * 8.64E7d) + UTC_2000;
        this.sunrise = r22;
        if (r22 < r16) goto L13;
    L15:
        this.state = 1;
        return;
    L13:
        if (this.sunset <= r16) goto L15;
        this.state = 0;
    }
}
