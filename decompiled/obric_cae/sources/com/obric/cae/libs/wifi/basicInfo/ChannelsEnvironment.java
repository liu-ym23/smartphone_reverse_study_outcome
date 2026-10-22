package com.obric.cae.libs.wifi.basicInfo;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import com.obric.cae.libs.utils.WifiUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ChannelsEnvironment {
    public static final int BAND_24_GHZ_END_FREQ_MHZ = 2484;
    public static final int BAND_24_GHZ_FIRST_CH_NUM = 1;
    public static final int BAND_24_GHZ_LAST_CH_NUM = 14;
    public static final int BAND_24_GHZ_START_FREQ_MHZ = 2412;
    public static final int BAND_5_GHZ_END_FREQ_MHZ = 5865;
    public static final int BAND_5_GHZ_FIRST_CH_NUM = 32;
    public static final int BAND_5_GHZ_LAST_CH_NUM = 173;
    public static final int BAND_5_GHZ_START_FREQ_MHZ = 5160;
    public static final int BAND_6_GHZ_END_FREQ_MHZ = 7105;
    public static final int BAND_6_GHZ_FIRST_CH_NUM = 1;
    public static final int BAND_6_GHZ_LAST_CH_NUM = 233;
    public static final int BAND_6_GHZ_START_FREQ_MHZ = 5945;
    public static final int UNSPECIFIED = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f5586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WifiManager f5587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<Integer, a> f5588c;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5589a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f5590b;

        public a(int r8) {
            this.f5589a = 1;
            this.f5590b = r8;
        }
    }

    public ChannelsEnvironment(Context r8, WifiManager r10) {
        this.f5586a = r8;
        this.f5587b = r10;
        this.f5588c = new HashMap();
        update();
    }

    public final void a(int r8) {
        boolean r10 = this.f5588c.containsKey(Integer.valueOf(r8));
        HashMap<Integer, a> r11 = this.f5588c;
        Integer r12 = Integer.valueOf(r8);
        if (r10 == false) goto L5;
        r11.put(r12, new a(0));
        return;
    L5:
        a r13 = r11.get(r12);
        if (r13 == null) goto L10;
        r13.f5589a++;
        return;
    }

    public final void b(int r8) {
        if (this.f5588c.containsKey(Integer.valueOf(r8)) == true) goto L5;
        this.f5588c.put(Integer.valueOf(r8), new a(1));
        return;
    L5:
        a r10 = this.f5588c.get(Integer.valueOf(r8));
        r10.f5589a++;
        r10.f5590b++;
    }

    public int getCenterChannelUsedNum(int r8, int r10) {
        int r11 = WifiUtils.convertChannelToFrequencyMhz(r8, r10);
        a r12 = this.f5588c.get(Integer.valueOf(r11));
        if (r12 != null) goto L5;
        return 0;
    L5:
        return r12.f5590b;
    }

    public int getChannelOverlapNum(int r8, int r10) {
        int r11 = WifiUtils.convertChannelToFrequencyMhz(r8, r10);
        a r12 = this.f5588c.get(Integer.valueOf(r11));
        if (r12 != null) goto L5;
        return 0;
    L5:
        return r12.f5589a;
    }

    public void update() {
        List<ScanResult> r8 = WifiUtils.getWifiScanResults(this.f5586a, this.f5587b);
        if (r8 != null) goto L5;
        return;
    L5:
        Iterator<ScanResult> r10 = r8.iterator();
    L7:
        if (r10.hasNext() == false) goto L38;
        ScanResult r11 = r10.next();
        if (WifiUtils.is24GHz(r11.frequency) == true) goto L10;
        if (WifiUtils.is6GHz(r11.frequency) == true) goto L7;
        int r12 = r11.channelWidth;
        if (r12 == 0) goto L17;
        if (r12 == 1) goto L35;
        if (r12 == 2) goto L35;
        if (r12 == 3) goto L35;
        if (r12 != 4) goto L7;
        b(r11.centerFreq0);
        b(r11.centerFreq1);
        int r13 = r11.centerFreq0 - 80;
    L29:
        if (r13 > (r11.centerFreq0 + 80)) goto L31;
        a(r13);
        r13 = r13 + 10;
        goto L29
    L31:
        int r14 = r11.centerFreq1 - 80;
    L33:
        if (r14 > (r11.centerFreq1 + 80)) goto L7;
        a(r14);
        r14 = r14 + 10;
    L35:
        b(r11.centerFreq0);
        int r15 = r11.centerFreq0;
        int r16 = r15 - 60;
        int r17 = r15 + 60;
    L36:
        if (r16 > r17) goto L7;
        a(r16);
        r16 = r16 + 10;
        goto L36
    L17:
        b(r11.frequency);
        int r18 = r11.frequency - 10;
    L11:
        a(r18);
        a(r11.frequency + 10);
        goto L7
    L10:
        b(r11.frequency);
        a(r11.frequency - 5);
        a(r11.frequency - 10);
        r18 = r11.frequency + 5;
        goto L11
    }
}
