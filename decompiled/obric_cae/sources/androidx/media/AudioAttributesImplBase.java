package androidx.media;

import defpackage.a;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
class AudioAttributesImplBase implements AudioAttributesImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2214d;

    public AudioAttributesImplBase() {
        this.f2211a = 0;
        this.f2212b = 0;
        this.f2213c = 0;
        this.f2214d = -1;
    }

    public final boolean equals(Object r11) {
        if ((r11 instanceof AudioAttributesImplBase) == true) goto L5;
        return false;
    L5:
        AudioAttributesImplBase r12 = (AudioAttributesImplBase) r11;
        if (this.f2212b != r12.f2212b) goto L38;
        int r8 = this.f2213c;
        int r10 = r12.f2213c;
        int r13 = r12.f2214d;
        if (r13 == (-1)) goto L10;
        int r14 = r13;
    L26:
        if (r14 != 6) goto L28;
        r10 = r10 | 4;
    L31:
        if (r8 == (r10 & 273)) goto L33;
        return false;
    L33:
        if (this.f2211a == r12.f2211a) goto L35;
        return false;
    L35:
        if (this.f2214d == r13) goto L37;
        return false;
    L37:
        return true;
    L28:
        if (r14 != 7) goto L31;
        r10 = r10 | 1;
        goto L31
    L10:
        int r15 = r12.f2211a;
        int r16 = AudioAttributesCompat.f2207b;
        if ((r10 & 1) != 1) goto L13;
        r14 = 7;
        goto L26
    L13:
        r14 = 4;
        if ((r10 & 4) != 4) goto L16;
        r14 = 6;
        goto L26
    L16:
        switch(r15) {
            case 2: goto L24;
            case 3: goto L22;
            case 4: goto L26;
            case 5: goto L21;
            case 6: goto L20;
            case 7: goto L21;
            case 8: goto L21;
            case 9: goto L21;
            case 10: goto L21;
            case 11: goto L19;
            case 12: goto L25;
            case 13: goto L18;
            default: goto L25;
        };
    L18:
        r14 = 1;
        goto L26
    L19:
        int r17 = 10;
    L23:
        r14 = r17;
        goto L26
    L20:
        r17 = 2;
        goto L23
    L21:
        r17 = 5;
        goto L23
    L22:
        r17 = 8;
        goto L23
    L24:
        r14 = 0;
        goto L26
    L25:
        r17 = 3;
        goto L23
    L38:
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f2212b), Integer.valueOf(this.f2213c), Integer.valueOf(this.f2211a), Integer.valueOf(this.f2214d)});
    }

    public final String toString() {
        StringBuilder r8 = new StringBuilder("AudioAttributesCompat:");
        if (this.f2214d == (-1)) goto L5;
        r8.append(" stream=");
        r8.append(this.f2214d);
        r8.append(" derived");
    L5:
        r8.append(" usage=");
        int r10 = this.f2211a;
        int r11 = AudioAttributesCompat.f2207b;
        switch(r10) {
            case 0: goto L23;
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L16;
            case 8: goto L15;
            case 9: goto L14;
            case 10: goto L13;
            case 11: goto L12;
            case 12: goto L11;
            case 13: goto L10;
            case 14: goto L9;
            case 15: goto L7;
            case 16: goto L8;
            default: goto L7;
        };
    L7:
        String r12 = a.d("unknown usage ", r10);
    L24:
        r8.append(r12);
        r8.append(" content=");
        r8.append(this.f2212b);
        r8.append(" flags=0x");
        r8.append(Integer.toHexString(this.f2213c).toUpperCase());
        return r8.toString();
    L8:
        r12 = "USAGE_ASSISTANT";
        goto L24
    L9:
        r12 = "USAGE_GAME";
        goto L24
    L10:
        r12 = "USAGE_ASSISTANCE_SONIFICATION";
        goto L24
    L11:
        r12 = "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
        goto L24
    L12:
        r12 = "USAGE_ASSISTANCE_ACCESSIBILITY";
        goto L24
    L13:
        r12 = "USAGE_NOTIFICATION_EVENT";
        goto L24
    L14:
        r12 = "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
        goto L24
    L15:
        r12 = "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
        goto L24
    L16:
        r12 = "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
        goto L24
    L17:
        r12 = "USAGE_NOTIFICATION_RINGTONE";
        goto L24
    L18:
        r12 = "USAGE_NOTIFICATION";
        goto L24
    L19:
        r12 = "USAGE_ALARM";
        goto L24
    L20:
        r12 = "USAGE_VOICE_COMMUNICATION_SIGNALLING";
        goto L24
    L21:
        r12 = "USAGE_VOICE_COMMUNICATION";
        goto L24
    L22:
        r12 = "USAGE_MEDIA";
        goto L24
    L23:
        r12 = "USAGE_UNKNOWN";
        goto L24
    }
}
