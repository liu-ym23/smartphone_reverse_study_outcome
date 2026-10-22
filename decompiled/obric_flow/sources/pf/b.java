package pf;

import ai.j0;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.model.VideoRef;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f21331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f21332c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f21333h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public VideoModel f21334i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f21335j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f21336k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f21337l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f21338m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final a f21339n;

    public b(String r5, String r10, String r11, String r12, String r13, String r14, String r15, int r16) {
        if ((r16 & 1) == 0) goto L6;
        r5 = null;
    L6:
        if ((r16 & 2) == 0) goto L9;
        r10 = null;
    L9:
        if ((r16 & 4) == 0) goto L12;
        r11 = null;
    L12:
        if ((r16 & 8) == 0) goto L15;
        r12 = null;
    L15:
        if ((r16 & 16) == 0) goto L18;
        r13 = null;
    L18:
        if ((r16 & 32) == 0) goto L21;
        r14 = null;
    L21:
        if ((r16 & 64) == 0) goto L23;
        r15 = null;
    L23:
        this.f21330a = r5;
        this.f21331b = r10;
        this.f21332c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.f21338m = -1;
        a r17 = new a();
        r17.f21328c = -1.0f;
        r17.d = 1.0f;
        r17.e = "auto";
        r17.f = 2;
        this.f21339n = r17;
    }

    public final VideoModel a() {
        String r5 = this.f21331b;
        if (r5 == null) goto L12;
        if (this.f21333h == true) goto L12;
        VideoModel r10 = new VideoModel();
        VideoRef r11 = new VideoRef();     // Catch: JSONException -> L9
        r11.extractFields(new JSONObject(r5));     // Catch: JSONException -> L9
        r10.setVideoRef(r11);     // Catch: JSONException -> L9
    L10:
        this.f21334i = r10;
        this.f21333h = true;
    L9:
        r10 = null;
    L12:
        return this.f21334i;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r10 = (b) r5;
        String r11 = r10.f21330a;
        if (Intrinsics.areEqual(this.f21330a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f21331b, r10.f21331b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f21332c, r10.f21332c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r10.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r10.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r5 = 0;
        String r10 = this.f21330a;
        if (r10 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        String r13 = this.f21331b;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f21332c;
        if (r16 != null) goto L13;
        int r17 = 0;
    L14:
        int r18 = (r15 + r17) * 31;
        String r19 = this.d;
        if (r19 != null) goto L17;
        int r20 = 0;
    L18:
        int r21 = (r18 + r20) * 31;
        String r22 = this.e;
        if (r22 != null) goto L21;
        int r23 = 0;
    L22:
        int r24 = (r21 + r23) * 31;
        String r25 = this.f;
        if (r25 != null) goto L25;
        int r26 = 0;
    L26:
        int r27 = (r24 + r26) * 31;
        String r28 = this.g;
        if (r28 == null) goto L31;
        r5 = r28.hashCode();
    L31:
        return r27 + r5;
    L25:
        r26 = r25.hashCode();
        goto L26
    L21:
        r23 = r22.hashCode();
        goto L22
    L17:
        r20 = r19.hashCode();
        goto L18
    L13:
        r17 = r16.hashCode();
        goto L14
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r10.hashCode();
        goto L6
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("VideoItem(vid=");
        r5.append(this.f21330a);
        r5.append(", jsonModel=");
        r5.append(this.f21331b);
        r5.append(", playAuthToken=");
        r5.append(this.f21332c);
        r5.append(", playDomain=");
        r5.append(this.d);
        r5.append(", preloadTaskKey=");
        r5.append(this.e);
        r5.append(", directUrl=");
        r5.append(this.f);
        r5.append(", localUrl=");
        return j0.p(r5, this.g, ')');
    }
}
