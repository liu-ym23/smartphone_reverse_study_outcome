package com.ss.android.socialbase.downloader.model;

import ai.j0;
import android.content.Context;
import android.database.sqlite.SQLiteStatement;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.constants.AsyncHandleStatus;
import com.ss.android.socialbase.downloader.constants.ByteInvalidRetryStatus;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.service.IDownloadIdGeneratorService;
import com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadDirUtils;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.socialbase.downloader.utils.LruCache;
import dn.a;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadInfo implements Parcelable {
    public static final Parcelable.Creator<DownloadInfo> CREATOR = null;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    public static boolean f15804e1 = false;
    public String A;
    public int A0;
    public String B;
    public String B0;
    public String C;
    public String C0;
    public AtomicLong D;
    public String D0;
    public boolean E;
    public String E0;
    public String F;
    public long F0;
    public int G;
    public boolean G0;
    public AsyncHandleStatus H;
    public int H0;
    public boolean I;
    public long I0;
    public boolean J;
    public int J0;
    public final boolean K;
    public long K0;
    public boolean L;
    public long L0;
    public String M;
    public boolean M0;
    public int N;
    public String N0;
    public boolean O;
    public boolean O0;
    public String P;
    public String P0;
    public int[] Q;
    public BaseException Q0;
    public final boolean R;
    public JSONObject R0;
    public final boolean S;
    public JSONObject S0;
    public final boolean T;
    public JSONObject T0;
    public boolean U;
    public String U0;
    public Boolean V;
    public int V0;
    public final int W;
    public boolean W0;
    public long X;
    public final long X0;
    public long Y;
    public final boolean Y0;
    public long Z;
    public final List Z0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f15805a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f15806a0;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public HashMap f15807a1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f15808b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final String f15809b0;
    public final boolean b1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f15810c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f15811c0;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    public final boolean f15812c1;
    public String d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public int f15813d0;
    public Boolean d1;
    public String e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f15814e0;
    public String f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public AtomicLong f15815f0;
    public boolean g;
    public AtomicLong g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f15816h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public long f15817h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList f15818i;
    public long i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f15819j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public AtomicInteger f15820j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String[] f15821k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f15822k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int[] f15823l;
    public boolean l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f15824m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public long f15825m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f15826n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public long f15827n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f15828o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public long f15829o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f15830p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f15831p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f15832q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public boolean f15833q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f15834r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public long f15835r0;
    public ArrayList s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public long f15836s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f15837t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public int f15838t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f15839u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public boolean f15840u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f15841v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public final boolean f15842v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f15843w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public boolean f15844w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ArrayList f15845x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public ArrayList f15846x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ArrayList f15847y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public ByteInvalidRetryStatus f15848y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f15849z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public final EnqueueType f15850z0;

    public static class Builder {
        public int A;
        public boolean B;
        public boolean C;
        public boolean D;
        public long E;
        public boolean F;
        public boolean G;
        public boolean H;
        public List I;
        public boolean J;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f15851a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f15852b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f15853c;
        public String d;
        public String e;
        public boolean f;
        public String g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public ArrayList f15854h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f15855i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f15856j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f15857k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f15858l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f15859m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public String f15860n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f15861o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public long f15862p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f15863q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f15864r;
        public String s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public String f15865t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public boolean f15866u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public String f15867v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f15868w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public boolean f15869x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public JSONObject f15870y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public String f15871z;

        public Builder() {
            this.f15864r = true;
        }
    }

    public static class RawBuilder extends Builder {
        public int K;
        public int L;
        public int M;
        public long N;
        public long O;
        public long P;
        public int Q;
        public boolean R;
        public boolean S;
        public long T;
        public long U;
        public int V;
        public String W;
        public long X;
        public String Y;
        public String Z;

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        public long f15872a0;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        public long f15873b0;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        public long f15874c0;

        /* JADX INFO: renamed from: d0, reason: collision with root package name */
        public boolean f15875d0;

        /* JADX INFO: renamed from: e0, reason: collision with root package name */
        public String f15876e0;

        /* JADX INFO: renamed from: f0, reason: collision with root package name */
        public String f15877f0;

        public RawBuilder() {
        }
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public DownloadInfo() {
        this.E = true;
        this.H = AsyncHandleStatus.f15263a;
        this.L = true;
        this.O = true;
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = null;
        this.W = -1;
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
        this.f15806a0 = false;
        this.f15814e0 = 1;
        this.f15822k0 = true;
        this.l0 = true;
        this.f15848y0 = ByteInvalidRetryStatus.f15266a;
        this.f15850z0 = EnqueueType.f15277a;
        this.d1 = null;
    }

    public final boolean A() {
        if (this.f15831p0 == false) goto L5;
        this.f15811c0++;
    L5:
        ArrayList r5 = this.s;
        if (r5 != null) goto L8;
    L19:
        return false;
    L8:
        if (r5.size() == 0) goto L19;
        if (this.f15811c0 < 0) goto L19;
    L13:
        if (this.f15811c0 >= this.s.size()) goto L19;
        if (TextUtils.isEmpty((String) this.s.get(this.f15811c0)) == false) goto L16;
        this.f15811c0++;
        goto L13
    L16:
        this.f15831p0 = true;
        return true;
    }

    public final void B() {
        if (this.T0 == null) goto L14;
        return;
    L14:
    L10:
        this.T0 = new JSONObject();
    L11:
        this.U0 = null;
        return;
    L6:
        if (TextUtils.isEmpty(this.U0) == true) goto L8;
        this.T0 = new JSONObject(this.U0);     // Catch: Throwable -> L10
    L13:
        goto L11
    L8:
        this.T0 = new JSONObject();     // Catch: Throwable -> L10
        goto L13
    }

    public final void C() {
        if (this.S0 == null) goto L10;
        Context r5 = ((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).e();
        if (r5 == null) goto L9;
        r5.getSharedPreferences("sp_download_info", 0).edit().putString(Integer.toString(l()), this.S0.toString()).apply();
        return;
    L9:
        return;
    }

    public final void a(SQLiteStatement r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.f15838t0 = 0;
        r10.clearBindings();
        int r5 = this.f15838t0 + 1;
        this.f15838t0 = r5;
        r10.bindLong(r5, this.f15805a);
        int r11 = this.f15838t0 + 1;
        this.f15838t0 = r11;
        String r12 = this.d;
        String r13 = "";
        if (r12 != null) goto L7;
        r12 = "";
    L7:
        r10.bindString(r11, r12);
        int r14 = this.f15838t0 + 1;
        this.f15838t0 = r14;
        String r15 = this.e;
        if (r15 != null) goto L10;
        r15 = "";
    L10:
        r10.bindString(r14, r15);
        int r16 = this.f15838t0 + 1;
        this.f15838t0 = r16;
        String r17 = this.f;
        if (r17 != null) goto L13;
        r17 = "";
    L13:
        r10.bindString(r16, r17);
        int r18 = this.f15838t0 + 1;
        this.f15838t0 = r18;
        String r19 = this.f15808b;
        if (r19 != null) goto L16;
        r19 = "";
    L16:
        r10.bindString(r18, r19);
        int r20 = this.f15838t0 + 1;
        this.f15838t0 = r20;
        r10.bindLong(r20, this.f15814e0);
        int r21 = this.f15838t0 + 1;
        this.f15838t0 = r21;
        r10.bindLong(r21, o());
        int r22 = this.f15838t0 + 1;
        this.f15838t0 = r22;
        r10.bindLong(r22, i());
        int r23 = this.f15838t0 + 1;
        this.f15838t0 = r23;
        r10.bindLong(r23, this.f15817h0);
        int r24 = this.f15838t0 + 1;
        this.f15838t0 = r24;
        String r25 = this.F;
        if (r25 != null) goto L19;
        r25 = "";
    L19:
        r10.bindString(r24, r25);
        int r26 = this.f15838t0 + 1;
        this.f15838t0 = r26;
        long r27 = 1;
        long r28 = 0;
        if (this.g == false) goto L22;
        long r29 = 1;
    L23:
        r10.bindLong(r26, r29);
        int r30 = this.f15838t0 + 1;
        this.f15838t0 = r30;
        if (this.f15828o == false) goto L26;
        long r31 = 1;
    L27:
        r10.bindLong(r30, r31);
        int r32 = this.f15838t0 + 1;
        this.f15838t0 = r32;
        r10.bindLong(r32, this.f15824m);
        int r33 = this.f15838t0 + 1;
        this.f15838t0 = r33;
        String r34 = this.f15816h;
        if (r34 != null) goto L30;
        r34 = "";
    L30:
        r10.bindString(r33, r34);
        int r35 = this.f15838t0 + 1;
        this.f15838t0 = r35;
        String r36 = this.f15839u;
        if (r36 != null) goto L33;
        r36 = "";
    L33:
        r10.bindString(r35, r36);
        int r37 = this.f15838t0 + 1;
        this.f15838t0 = r37;
        String r38 = this.f15810c;
        if (r38 != null) goto L36;
        r38 = "";
    L36:
        r10.bindString(r37, r38);
        int r39 = this.f15838t0 + 1;
        this.f15838t0 = r39;
        if (this.f15837t == false) goto L39;
        long r40 = 1;
    L40:
        r10.bindLong(r39, r40);
        int r41 = this.f15838t0 + 1;
        this.f15838t0 = r41;
        r10.bindLong(r41, this.f15813d0);
        int r42 = this.f15838t0 + 1;
        this.f15838t0 = r42;
        if (this.f15822k0 == false) goto L43;
        long r43 = 1;
    L44:
        r10.bindLong(r42, r43);
        int r44 = this.f15838t0 + 1;
        this.f15838t0 = r44;
        if (this.l0 == false) goto L47;
        long r45 = 1;
    L48:
        r10.bindLong(r44, r45);
        int r46 = this.f15838t0 + 1;
        this.f15838t0 = r46;
        if (this.f15841v == false) goto L51;
        long r47 = 1;
    L52:
        r10.bindLong(r46, r47);
        int r48 = this.f15838t0 + 1;
        this.f15838t0 = r48;
        r10.bindLong(r48, this.f15825m0);
        int r49 = this.f15838t0 + 1;
        this.f15838t0 = r49;
        String r50 = this.B;
        if (r50 != null) goto L55;
        r50 = "";
    L55:
        r10.bindString(r49, r50);
        int r51 = this.f15838t0 + 1;
        this.f15838t0 = r51;
        String r52 = this.C;
        if (r52 != null) goto L58;
        r52 = "";
    L58:
        r10.bindString(r51, r52);
        int r53 = this.f15838t0 + 1;
        this.f15838t0 = r53;
        r10.bindLong(r53, 0);
        int r54 = this.f15838t0 + 1;
        this.f15838t0 = r54;
        r10.bindLong(r54, this.G);
        int r55 = this.f15838t0 + 1;
        this.f15838t0 = r55;
        r10.bindLong(r55, 0);
        int r56 = this.f15838t0 + 1;
        this.f15838t0 = r56;
        if (this.E == false) goto L61;
        long r57 = 1;
    L62:
        r10.bindLong(r56, r57);
        int r58 = this.f15838t0 + 1;
        this.f15838t0 = r58;
        r10.bindLong(r58, 0);
        int r59 = this.f15838t0 + 1;
        this.f15838t0 = r59;
        r10.bindString(r59, "");
        int r60 = this.f15838t0 + 1;
        this.f15838t0 = r60;
        r10.bindLong(r60, 0);
        int r61 = this.f15838t0 + 1;
        this.f15838t0 = r61;
        if (this.P0 != null) goto L65;
        this.P0 = DownloadUtils.a(this.s);
    L65:
        r10.bindString(r61, this.P0);
        int r62 = this.f15838t0 + 1;
        this.f15838t0 = r62;
        r10.bindLong(r62, this.f15826n);
        int r63 = this.f15838t0 + 1;
        this.f15838t0 = r63;
        r10.bindLong(r63, this.f15827n0);
        int r64 = this.f15838t0 + 1;
        this.f15838t0 = r64;
        r10.bindLong(r64, 0);
        int r65 = this.f15838t0 + 1;
        this.f15838t0 = r65;
        if (this.J == false) goto L68;
        long r66 = 1;
    L69:
        r10.bindLong(r65, r66);
        int r67 = this.f15838t0 + 1;
        this.f15838t0 = r67;
        r10.bindString(r67, j());
        int r68 = this.f15838t0 + 1;
        this.f15838t0 = r68;
        String r69 = this.M;
        if (r69 != null) goto L72;
        r69 = "";
    L72:
        r10.bindString(r68, r69);
        int r70 = this.f15838t0 + 1;
        this.f15838t0 = r70;
        r10.bindLong(r70, this.H0);
        int r71 = this.f15838t0 + 1;
        this.f15838t0 = r71;
        r10.bindString(r71, "");
        int r72 = this.f15838t0 + 1;
        this.f15838t0 = r72;
        r10.bindLong(r72, this.X);
        int r73 = this.f15838t0 + 1;
        this.f15838t0 = r73;
        r10.bindLong(r73, this.Y);
        int r74 = this.f15838t0 + 1;
        this.f15838t0 = r74;
        r10.bindLong(r74, this.Z);
        int r75 = this.f15838t0 + 1;
        this.f15838t0 = r75;
        if (this.f15806a0 == true) goto L76;
        r27 = 0;
    L76:
        r10.bindLong(r75, r27);
        int r76 = this.f15838t0 + 1;
        this.f15838t0 = r76;
        r10.bindLong(r76, this.f15843w);
        int r77 = this.f15838t0 + 1;
        this.f15838t0 = r77;
        if (this.f15849z != null) goto L79;
        this.f15849z = DownloadUtils.a(this.f15845x);
    L79:
        r10.bindString(r77, this.f15849z);
        int r78 = this.f15838t0 + 1;
        this.f15838t0 = r78;
        if (this.A != null) goto L82;
        this.A = DownloadUtils.a(this.f15847y);
    L82:
        r10.bindString(r78, this.A);
        int r79 = this.f15838t0 + 1;
        this.f15838t0 = r79;
        AtomicLong r80 = this.g0;
        if (r80 == null) goto L85;
        r28 = r80.get();
    L85:
        r10.bindLong(r79, r28);
        int r81 = this.f15838t0 + 1;
        this.f15838t0 = r81;
        r10.bindLong(r81, this.f15829o0);
        int r82 = this.f15838t0 + 1;
        this.f15838t0 = r82;
        String r83 = this.P;
        if (r83 == null) goto L89;
        r13 = r83;
    L89:
        r10.bindString(r82, r13);
        return;
    L68:
        r66 = 0;
        goto L69
    L61:
        r57 = 0;
        goto L62
    L51:
        r47 = 0;
        goto L52
    L47:
        r45 = 0;
        goto L48
    L43:
        r43 = 0;
        goto L44
    L39:
        r40 = 0;
        goto L40
    L26:
        r31 = 0;
        goto L27
    L22:
        r29 = 0;
        goto L23
    }

    public final void b(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        if (o() == (-3)) goto L33;
        this.P0 = r10;
        char[] r5 = DownloadUtils.f16142a;
        ArrayList r11 = null;
        if (TextUtils.isEmpty(r10) == false) goto L27;
    L25:
        this.s = r11;
        return;
    L27:
        JSONArray r12 = new JSONArray(r10);     // Catch: Exception -> L20
        if (r12.length() <= 0) goto L25;
        ArrayList r13 = new ArrayList();     // Catch: Exception -> L20
        int r14 = 0;
    L15:
        if (r14 >= r12.length()) goto L23;
        String r15 = r12.optString(r14);     // Catch: Exception -> L20
        if (TextUtils.isEmpty(r15) == true) goto L22;
        r13.add(r15);     // Catch: Exception -> L20
    L22:
        r14 = r14 + 1;
        goto L15
    L23:
        r11 = r13;
    L20:
        e = move-exception;
        e.printStackTrace();
        goto L25
    }

    public final void c(long r5) {
        if (r5 <= i()) goto L6;
        b(r5);
        return;
    }

    public final void d() {
        if (this.T0 != null) goto L19;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L6:
        if (this.T0 == null) goto L21;
    L15:
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L21:
    L12:
        this.T0 = new JSONObject();     // Catch: Throwable -> L13
        goto L15
    L8:
        if (TextUtils.isEmpty(this.U0) == true) goto L10;
        this.T0 = new JSONObject(this.U0);     // Catch: Throwable -> L12
        this.U0 = null;     // Catch: Throwable -> L12
    L20:
    L10:
        this.T0 = new JSONObject();     // Catch: Throwable -> L12
        goto L20
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final void e() {
        if (this.S0 != null) goto L18;
        Context r5 = ((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).e();
        if (r5 == null) goto L13;
        String r10 = r5.getSharedPreferences("sp_download_info", 0).getString(Long.toString(l()), "");
        if (TextUtils.isEmpty(r10) == true) goto L13;
        this.S0 = new JSONObject(r10);     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
    L13:
        if (this.S0 != null) goto L19;
        this.S0 = new JSONObject();
        return;
    L19:
        return;
    }

    public final void f() {
        b(0);
        a(0);
        this.f15817h0 = 0;
        this.f15814e0 = 1;
        this.f15825m0 = 0;
        this.f15836s0 = 0;
        this.f15827n0 = 0;
        this.f15829o0 = 0;
        this.G = 0;
        this.f15822k0 = true;
        this.l0 = true;
        this.f15831p0 = false;
        this.f15833q0 = false;
        this.F = null;
        this.Q0 = null;
    }

    public final long g() {
        e();
        return this.S0.optLong("cache-control/expired_time", -1);
    L8:
        return -1;
    }

    public final String h() {
        String r5 = this.d;
        if (o() != 8) goto L13;
        ArrayList r10 = this.f15846x0;
        if (r10 == null) goto L13;
        if (r10.isEmpty() == true) goto L13;
        if (this.f15831p0 == true) goto L13;
        return (String) this.f15846x0.get(0);
    L13:
        if (this.f15831p0 == false) goto L26;
        ArrayList r11 = this.s;
        if (r11 == null) goto L26;
        if (r11.size() <= 0) goto L26;
        int r12 = this.f15811c0;
        if (r12 < 0) goto L26;
        if (r12 >= this.s.size()) goto L26;
        String r13 = (String) this.s.get(this.f15811c0);
        if (TextUtils.isEmpty(r13) == true) goto L35;
        return r13;
    L35:
        return r5;
    L26:
        if (TextUtils.isEmpty(this.d) == true) goto L35;
        if (this.d.startsWith(IIvyAIPackageResourceService.SCHEMA) == false) goto L35;
        if (this.f15841v == false) goto L35;
        if (this.f15833q0 == false) goto L35;
        return this.d.replaceFirst(IIvyAIPackageResourceService.SCHEMA, "http");
    }

    public final long i() {
        AtomicLong r5 = this.f15815f0;
        if (r5 != null) goto L5;
        return 0;
    L5:
        return r5.get();
    }

    public final String j() {
        String r5 = this.U0;
        if (r5 == null) goto L5;
        return r5;
    L5:
        d();
        JSONObject r10 = this.T0;
        monitor-enter(r10);
        String r11 = this.T0.toString();     // Catch: Throwable -> L10
        this.U0 = r11;     // Catch: Throwable -> L10
        monitor-exit(r10);     // Catch: Throwable -> L10
        return r11;
    L10:
        th = move-exception;
        throw th;
    }

    public final long k() {
        d();
        return this.T0.optLong("end_offset", -1);
    }

    public final int l() {
        if (this.f15805a != 0) goto L6;
        this.f15805a = ((IDownloadIdGeneratorService) DownloadServiceManager.a(IDownloadIdGeneratorService.class)).a(this);
    L6:
        return this.f15805a;
    }

    public final String m() {
        e();
        return this.S0.optString("last-modified", null);
    L5:
        return null;
    }

    public final int n() {
        AtomicInteger r5 = this.f15820j0;
        if (r5 != null) goto L5;
        return 0;
    L5:
        return r5.get();
    }

    public final int o() {
        AtomicInteger r5 = this.f15820j0;
        if (r5 == null) goto L8;
        int r10 = r5.get();
        if (r10 != (-5)) goto L10;
        return -2;
    L10:
        return r10;
    L8:
        return 0;
    }

    public final String p() {
        String r5 = this.f15808b;
        char[] r10 = DownloadUtils.f16142a;
        if (TextUtils.isEmpty(r5) == false) goto L7;
        return null;
    L7:
        return j0.j(r5, ".tp");
    }

    public final String q() {
        String r5 = this.e;
        String r10 = this.f;
        char[] r11 = DownloadUtils.f16142a;
        if (TextUtils.isEmpty(r5) == false) goto L9;
        if (TextUtils.isEmpty(r10) == false) goto L9;
        return null;
    L9:
        if (TextUtils.isEmpty(r10) == true) goto L11;
        return r10;
    L11:
        return r5;
    }

    public final boolean r() {
        if (this.d1 != null) goto L11;
        if (TextUtils.isEmpty(this.f15816h) == false) goto L12;
        this.d1 = Boolean.FALSE;
        goto L11
    L12:
        this.d1 = Boolean.valueOf(new JSONObject(this.f15816h).optBoolean("auto_install_without_notification", false));     // Catch: JSONException -> L8
    L8:
        this.d1 = Boolean.FALSE;
    L11:
        return this.d1.booleanValue();
    }

    public final boolean s() {
        int r5 = o();
        if (r5 != 4) goto L5;
    L20:
        return true;
    L5:
        if (r5 == 3) goto L20;
        if (r5 == (-1)) goto L20;
        if (r5 == 5) goto L20;
        if (r5 == 8) goto L20;
        if (r5 == 1) goto L16;
        if (r5 == 2) goto L16;
        return false;
    L16:
        if (i() > 0) goto L20;
        return false;
    }

    public final boolean t() {
        if (TextUtils.isEmpty(this.d) == false) goto L5;
        return true;
    L5:
        if (TextUtils.isEmpty(this.f15808b) == false) goto L7;
        return true;
    L7:
        if (TextUtils.isEmpty(this.e) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("DownloadInfo{id=");
        r5.append(this.f15805a);
        r5.append(", name='");
        r5.append(this.f15808b);
        r5.append("', title='");
        r5.append(this.f15810c);
        r5.append("', url='");
        r5.append(this.d);
        r5.append("', savePath='");
        return j0.q(r5, this.e, "'}");
    }

    public final boolean u() {
        if (t() == false) goto L5;
        return false;
    L5:
        File r5 = new File(q(), p());
        boolean r10 = r5.exists();
        boolean r11 = r5.isDirectory();
        if (Logger.a(this) == false) goto L8;
        Logger.a("DownloadInfo", l(), this.P, "isFileDataValid", "Temp file:" + r5 + "IsExists:" + r10 + " isDirectory: " + r11, false);
    L8:
        if (r10 == false) goto L30;
        if (r11 == true) goto L30;
        long r12 = r5.length();
        long r13 = i();
        if (r13 <= 0) goto L28;
        long r14 = this.f15817h0;
        if (r14 <= 0) goto L28;
        if (this.f15814e0 <= 0) goto L28;
        if (r12 < r13) goto L28;
        if (r12 > r14) goto L28;
        if (Logger.a(this) == false) goto L31;
        StringBuilder r15 = a.K(r12, "Valid, FileLength+", " curBytes:");
        r15.append(r13);
        Logger.a("DownloadInfo", l(), this.P, "isFileDataValid", r15.toString(), false);
        return true;
    L31:
        return true;
    L28:
        if (Logger.a(this) == false) goto L30;
        StringBuilder r16 = a.K(r13, "Invalid, Cur = ", ",totalBytes =");
        r16.append(this.f15817h0);
        kotlin.collections.a.o(r16, ",fileLength=", r12, ", chunkCount:");
        r16.append(this.f15814e0);
        Logger.a("DownloadInfo", l(), this.P, "isFileDataValid", r16.toString(), false);
    L30:
        return false;
    }

    public final boolean v() {
        if (t() == false) goto L5;
        return false;
    L5:
        File r5 = new File(q(), p());
        boolean r10 = r5.exists();
        if (r10 == false) goto L8;
        boolean r11 = r5.isDirectory();
        if (r11 == true) goto L14;
        long r12 = i();
        if (r12 <= 0) goto L39;
        if (this.f15817h0 <= 0) goto L39;
        if (this.f15814e0 <= 0) goto L39;
        long r13 = r5.length();
        if (r13 < r12) goto L35;
        if (r13 > this.f15817h0) goto L35;
        if (Logger.a(this) == false) goto L42;
        StringBuilder r14 = a.K(r13, "Valid, FileLength+", " curBytes:");
        r14.append(r12);
        Logger.a("DownloadInfo", l(), this.P, "isFileDataValid", r14.toString(), false);
        return true;
    L42:
        return true;
    L35:
        if (Logger.a(this) == false) goto L37;
        StringBuilder r15 = a.K(r12, "Invalid, Cur = ", ",totalBytes =");
        r15.append(this.f15817h0);
        kotlin.collections.a.o(r15, ",fileLength=", r13, ", chunkCount:");
        r15.append(this.f15814e0);
        Logger.a("DownloadInfo", l(), this.P, "isFileDataValid", r15.toString(), false);
    L37:
        return false;
    L39:
        if (Logger.a(this) == false) goto L41;
        StringBuilder r16 = a.K(r12, "Invalid, Cur = ", ",totalBytes =");
        r16.append(this.f15817h0);
        r16.append(", chunkCount:");
        r16.append(this.f15814e0);
        Logger.a("DownloadInfo", l(), this.P, "isFileDataValid", r16.toString(), false);
    L41:
        return false;
    L14:
        if (Logger.a(this) == false) goto L16;
        Logger.a("DownloadInfo", l(), this.P, "isFileDataValid", "Temp file:" + r5 + "IsDirectory:" + r11, false);
    L16:
        return false;
    L8:
        if (Logger.a(this) == false) goto L10;
        Logger.a("DownloadInfo", l(), this.P, "isFileDataValid", "Temp file:" + r5 + "IsExists:" + r10, false);
    L10:
        return false;
    }

    public final boolean w() {
        if (this.f15822k0 == true) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(q()) == false) goto L8;
    L12:
        return false;
    L8:
        if (TextUtils.isEmpty(p()) == true) goto L12;
        return !new File(q(), p()).exists();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r10) {
        r5.writeInt(this.f15805a);
        r5.writeString(this.f15808b);
        r5.writeString(this.f15810c);
        r5.writeString(this.d);
        r5.writeString(this.e);
        r5.writeString(this.f);
        r5.writeByte(this.g ? 1 : 0);
        r5.writeString(this.f15816h);
        r5.writeTypedList(this.f15818i);
        r5.writeInt(this.f15819j);
        r5.writeStringArray(this.f15821k);
        r5.writeIntArray(this.f15823l);
        r5.writeInt(this.f15824m);
        r5.writeInt(this.f15826n);
        r5.writeByte(this.f15828o ? 1 : 0);
        r5.writeByte(this.f15830p ? 1 : 0);
        r5.writeInt(this.f15832q);
        r5.writeInt(this.f15834r);
        r5.writeStringList(this.s);
        r5.writeByte(this.f15837t ? 1 : 0);
        r5.writeString(this.f15839u);
        r5.writeByte(this.f15841v ? 1 : 0);
        r5.writeString(this.B);
        r5.writeString(this.C);
        r5.writeByte(this.E ? 1 : 0);
        r5.writeString(this.F);
        r5.writeInt(this.G);
        r5.writeString(this.f15809b0);
        r5.writeInt(this.f15811c0);
        r5.writeInt(this.f15813d0);
        r5.writeInt(this.f15814e0);
        r5.writeLong(i());
        AtomicLong r11 = this.g0;
        if (r11 == null) goto L5;
        long r12 = r11.get();
    L6:
        r5.writeLong(r12);
        r5.writeLong(this.f15817h0);
        r5.writeInt(n());
        r5.writeLong(this.f15825m0);
        r5.writeLong(this.f15827n0);
        r5.writeLong(this.f15829o0);
        r5.writeByte(this.f15831p0 ? 1 : 0);
        r5.writeByte(this.f15833q0 ? 1 : 0);
        r5.writeByte(this.f15840u0 ? 1 : 0);
        r5.writeByte(this.f15842v0 ? 1 : 0);
        r5.writeByte(this.f15844w0 ? 1 : 0);
        r5.writeStringList(this.f15846x0);
        r5.writeByte(this.J ? 1 : 0);
        r5.writeInt(this.f15850z0.ordinal());
        r5.writeInt(this.A0);
        r5.writeString(this.B0);
        r5.writeByte(this.G0 ? 1 : 0);
        r5.writeByte(this.O0 ? 1 : 0);
        r5.writeParcelable(this.Q0, r10);
        r5.writeString(j());
        r5.writeByte(this.L ? 1 : 0);
        r5.writeString(this.M);
        r5.writeInt(this.H0);
        r5.writeByte(this.R ? 1 : 0);
        r5.writeByte(this.T ? 1 : 0);
        r5.writeByte(this.U ? 1 : 0);
        r5.writeByte(this.S ? 1 : 0);
        r5.writeLong(this.i0);
        r5.writeInt(this.W);
        r5.writeStringList(this.Z0);
        r5.writeMap(this.f15807a1);
        r5.writeLong(this.X);
        r5.writeLong(this.Y);
        r5.writeLong(this.Z);
        r5.writeByte(this.f15806a0 ? 1 : 0);
        r5.writeByte(this.M0 ? 1 : 0);
        r5.writeLong(this.f15843w);
        r5.writeStringList(this.f15845x);
        r5.writeStringList(this.f15847y);
        r5.writeString(this.N0);
        r5.writeByte(this.b1 ? 1 : 0);
        r5.writeByte(this.f15812c1 ? 1 : 0);
        r5.writeLong(this.K0);
        r5.writeString(this.C0);
        r5.writeString(this.D0);
        r5.writeString(this.E0);
        r5.writeLong(this.L0);
        r5.writeByte(this.K ? 1 : 0);
        r5.writeString(this.P);
        return;
    L5:
        r12 = 0;
        goto L6
    }

    public final boolean x() {
        e();
        int r5 = this.S0.optInt("pause_reserve_on_wifi", 0);     // Catch: Exception -> L5
    L7:
        if ((r5 & 2) <= 0) goto L12;
        return true;
    L12:
        return false;
    L5:
        r5 = 0;
        goto L7
    }

    public final void y() {
        if (f15804e1 == true) goto L5;
    L7:
        B();
        int r5 = 0;
        this.O = this.T0.optBoolean("need_sdk_monitor", false);
        this.P = this.T0.optString("monitor_scene", "");
        JSONArray r10 = this.T0.optJSONArray("extra_monitor_status");
        if (r10 != null) goto L10;
        return;
    L10:
        if (r10.length() <= 0) goto L17;
        this.Q = new int[r10.length()];
    L13:
        if (r5 >= r10.length()) goto L19;
        this.Q[r5] = r10.optInt(r5);
        r5 = r5 + 1;
        goto L13
    L19:
        return;
    L17:
        return;
    L5:
        if (TextUtils.isEmpty(this.P) == true) goto L7;
    }

    public final void z() {
        b(0);
        a(0);
        this.f15817h0 = 0;
        this.f15814e0 = 1;
        this.f15825m0 = 0;
        this.f15836s0 = 0;
        this.f15827n0 = 0;
        this.f15829o0 = 0;
    }

    public final boolean c() {
        if (o() == 8) goto L13;
        AsyncHandleStatus r5 = this.H;
        if (r5 != AsyncHandleStatus.f15264b) goto L7;
        return true;
    L7:
        if (r5 != AsyncHandleStatus.f15265c) goto L9;
        return true;
    L9:
        if (this.f15848y0 == ByteInvalidRetryStatus.f15267b) goto L17;
        return false;
    L17:
        return true;
    L13:
        return true;
    }

    public final void b(String r5, Object r10) {
        this.T0.put(r5, r10);     // Catch: Exception -> L4
        return;
    }

    public final void b(long r5) {
        AtomicLong r10 = this.f15815f0;
        if (r10 == null) goto L6;
        r10.set(r5);
        return;
    L6:
        this.f15815f0 = new AtomicLong(r5);
    }

    public final boolean b() {
        boolean r5 = this.f15840u0;
        if (r5 == false) goto L5;
    L6:
        if (r5 == true) goto L8;
        return false;
    L8:
        if (this.f15842v0 == false) goto L10;
        return true;
    L10:
        if (this.f15844w0 == false) goto L17;
        return true;
    L17:
        return false;
    L5:
        if (this.f15837t == false) goto L6;
        return true;
    }

    public final void b(int r5) {
        if (this.f15831p0 == false) goto L5;
        int r10 = this.f15826n;
    L6:
        int r11 = r10 - r5;
        this.G = r11;
        if (r11 >= 0) goto L10;
        this.G = 0;
        return;
    L10:
        return;
    L5:
        r10 = this.f15824m;
        goto L6
    }

    public DownloadInfo(Builder r12) {
        this.E = true;
        this.H = AsyncHandleStatus.f15263a;
        this.L = true;
        this.O = true;
        int r5 = 0;
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = null;
        this.W = -1;
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
        this.f15806a0 = false;
        this.f15814e0 = 1;
        this.f15822k0 = true;
        this.l0 = true;
        this.f15848y0 = ByteInvalidRetryStatus.f15266a;
        this.f15850z0 = EnqueueType.f15277a;
        this.d1 = null;
        if (r12 == null) goto L120;
        this.f15820j0 = new AtomicInteger(0);
        this.f15815f0 = new AtomicLong(0);
        this.P = r12.f15871z;
        this.b1 = r12.J;
        this.f15808b = r12.f15851a;
        this.d = r12.f15853c;
        String r10 = r12.d;
        if (TextUtils.isEmpty(r10) == true) goto L109;
    L18:
        this.e = r10;
        this.f15812c1 = false;
        if (r12.J == false) goto L21;
        this.f = DownloadDirUtils.b();
        return;
    L21:
        this.g0 = new AtomicLong(0);
        this.f = r12.e;
        B();
        b("task_key", null);
        if (TextUtils.isEmpty(this.f) == false) goto L34;
        if (DownloadDirUtils.a(r10) == true) goto L34;
        Downloader.b(((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).e()).getClass();
        if (TextUtils.isEmpty(null) == true) goto L31;
        File r11 = new File(null);
        if (DownloadDirUtils.b(r11) == false) goto L31;
    L32:
        this.f = DownloadDirUtils.a(r11);
    L31:
        r11 = null;
    L34:
        if (r12.G == true) goto L36;
    L52:
        this.f15816h = r12.g;
        this.g = r12.f;
        this.f15818i = r12.f15854h;
        this.f15819j = r12.f15855i;
        this.f15824m = r12.f15856j;
        this.f15826n = r12.f15857k;
        this.f15828o = r12.f15858l;
        this.f15821k = null;
        this.f15823l = null;
        this.f15830p = true;
        this.f15832q = 0;
        this.f15834r = 0;
        this.s = null;
        this.f15837t = r12.f15859m;
        this.f15839u = r12.f15860n;
        this.f15841v = r12.f15861o;
        this.f15840u0 = false;
        this.f15842v0 = r12.f15863q;
        this.E = r12.f15864r;
        this.B = r12.s;
        this.C = r12.f15865t;
        this.J = r12.f15866u;
        this.K = false;
        this.f15850z0 = EnqueueType.f15277a;
        this.I = false;
        this.O0 = r12.f15869x;
        this.M = r12.f15867v;
        this.I0 = 0;
        this.J0 = 0;
        this.f15810c = r12.f15852b;
        JSONObject r13 = r12.f15870y;
        if (r13 == null) goto L87;
        int r14 = l();
        JSONObject r15 = DownloadSetting.a(r13, r12.f15871z);
        if (r15 != null) goto L57;
    L86:
        b("download_setting", r13.toString());
        goto L87
    L57:
        if (r15 == ((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).c()) goto L86;
        if (DownloadSetting.f16106k == true) goto L86;
        LruCache r16 = DownloadSetting.e;
        monitor-enter(r16);
        DownloadSetting r17 = DownloadSetting.f16107l;     // Catch: Throwable -> L68
        if (r17 != null) goto L66;
    L70:
        Iterator r18 = r16.values().iterator();     // Catch: Throwable -> L68
    L72:
        if (r18.hasNext() == false) goto L76;
        DownloadSetting r19 = (DownloadSetting) r18.next();     // Catch: Throwable -> L68
        if (r19.f16108a != r15) goto L72;
        r19.d = r14;     // Catch: Throwable -> L68
    L77:
        if (r19 != null) goto L79;
        r17 = new DownloadSetting(r15);     // Catch: Throwable -> L68
        r17.d = r14;     // Catch: Throwable -> L68
    L80:
        DownloadSetting.f16107l = r17;     // Catch: Throwable -> L68
    L81:
        DownloadSetting.e.put(Integer.valueOf(r14), r17);     // Catch: Throwable -> L68
        monitor-exit(r16);     // Catch: Throwable -> L68
        goto L86
    L79:
        r17 = r19;
        goto L80
    L76:
        r19 = null;
        goto L77
    L66:
        if (r17.f16108a != r15) goto L70;
        r17.d = r14;     // Catch: Throwable -> L68
    L68:
        th = move-exception;
        throw th;
    L87:
        b("dbjson_key_expect_file_length", 0L);
        b("executor_group", Integer.valueOf(r12.A));
        b("auto_install", 1);
        this.O = true;
        this.Q = null;
        this.R = r12.B;
        this.S = r12.C;
        this.T = r12.D;
        this.X0 = r12.E;
        this.Y0 = r12.F;
        boolean r20 = r12.H;
        this.V = Boolean.valueOf(r20);
        if (r20 == false) goto L90;
    L91:
        this.W = 0;
    L92:
        this.Z0 = r12.I;
        this.f15845x = null;
        this.f15847y = null;
        this.f15843w = r12.f15862p;
        b("ignore_intercept", Integer.valueOf(r12.H ? 1 : 0));
        b("start_offset", 0L);
        b("end_offset", -1L);
        if (f15804e1 == true) goto L121;
        b("need_sdk_monitor", Boolean.valueOf(this.O));
        b("monitor_scene", this.P);
        JSONArray r110 = new JSONArray();     // Catch: Throwable -> L103
        int[] r21 = this.Q;     // Catch: Throwable -> L103
        if (r21 != null) goto L99;
    L105:
        b("extra_monitor_status", r110);     // Catch: Throwable -> L103
        return;
    L99:
        if (r21.length <= 0) goto L105;
    L100:
        int[] r22 = this.Q;     // Catch: Throwable -> L103
        if (r5 >= r22.length) goto L105;
        r110.put(r22[r5]);     // Catch: Throwable -> L103
        r5 = r5 + 1;     // Catch: Throwable -> L103
    L103:
        th = move-exception;
        th.printStackTrace();
        return;
    L121:
        return;
    L90:
        if (((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).f() != null) goto L92;
    L36:
        if (((IDownloadProcessDispatcherService) DownloadServiceManager.a(IDownloadProcessDispatcherService.class)).a(l()) != null) goto L52;
        String r23 = this.e;
        String r24 = this.d;
        char[] r25 = DownloadUtils.f16142a;
        if (TextUtils.isEmpty(r23) == true) goto L44;
        String r26 = DownloadUtils.c(r24);
        if (TextUtils.isEmpty(r26) == true) goto L44;
        if (r23.contains(r26) == true) goto L44;
        r23 = new File(r23, r26).getAbsolutePath();
    L44:
        this.e = r23;
        String r27 = this.f;
        String r28 = this.d;
        if (TextUtils.isEmpty(r27) == true) goto L51;
        String r29 = DownloadUtils.c(r28);
        if (TextUtils.isEmpty(r29) == true) goto L51;
        if (r27.contains(r29) == true) goto L51;
        r27 = new File(r27, r29).getAbsolutePath();
    L51:
        this.f = r27;
        goto L52
    L109:
        String r30 = DownloadDirUtils.f16126b;     // Catch: Throwable -> L16
        Downloader.b(((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).e()).getClass();     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(null) == true) goto L13;
        File r31 = new File(null);     // Catch: Throwable -> L16
        if (DownloadDirUtils.b(r31) == false) goto L13;
    L14:
        r10 = DownloadDirUtils.a(r31);     // Catch: Throwable -> L16
    L13:
        r31 = null;
    L16:
        th = move-exception;
        th.printStackTrace();
        goto L18
    }

    public final void a(String r5, Object r10) {
        d();
        JSONObject r11 = this.T0;
        monitor-enter(r11);
        this.T0.put(r5, r10);     // Catch: Throwable -> L6 Exception -> L14
    L6:
        th = move-exception;
        throw th;
    L9:
        this.U0 = null;     // Catch: Throwable -> L6
        monitor-exit(r11);     // Catch: Throwable -> L6
    }

    public final void a(boolean r10) {
        long r5 = System.nanoTime();
        long r11 = this.f15836s0;
        if (r11 > 0) goto L7;
        if (r10 == false) goto L19;
        this.f15836s0 = r5;
        return;
    L19:
        return;
    L7:
        long r12 = r5 - r11;
        if (r10 == false) goto L10;
        this.f15836s0 = r5;
    L12:
        if (r12 <= 0) goto L20;
        this.f15827n0 += r12;
        if (this.b1 == false) goto L16;
        return;
    L16:
        if (AppStatusManager.b().c() != 0) goto L22;
        this.f15829o0 += r12;
        return;
    L22:
        return;
    L20:
        return;
    L10:
        this.f15836s0 = 0;
        goto L12
    }

    public final void a(long r5) {
        AtomicLong r10 = this.g0;
        if (r10 == null) goto L6;
        r10.set(r5);
        return;
    L6:
        this.g0 = new AtomicLong(r5);
    }

    public final void a(String r5) {
        b(0);
        a(0);
        this.f15817h0 = 0;
        this.F = r5;
        this.f15814e0 = 1;
        e();
        this.S0.put("last-modified", null);     // Catch: Exception -> L6
        C();     // Catch: Exception -> L6
    L4:
        this.f15825m0 = 0;
        this.f15836s0 = 0;
        this.f15827n0 = 0;
        this.f15829o0 = 0;
    }

    public final void a(int r5) {
        AtomicInteger r10 = this.f15820j0;
        if (r10 == null) goto L6;
        r10.set(r5);
        return;
    L6:
        this.f15820j0 = new AtomicInteger(r5);
    }

    public final boolean a() {
        if (o() != (-3)) goto L5;
        return false;
    L5:
        if (this.H != AsyncHandleStatus.f15264b) goto L10;
        return true;
    L10:
        return false;
    }

    public final void a(DownloadInfo r5, boolean r10) {
        this.f15814e0 = r5.f15814e0;
        this.f15817h0 = r5.f15817h0;
        b(r5.i());
        AtomicLong r11 = r5.g0;
        if (r11 == null) goto L5;
        long r12 = r11.get();
    L6:
        a(r12);
        this.f15827n0 = r5.f15827n0;
        this.f15829o0 = r5.f15829o0;
        if (r5.c() == false) goto L9;
    L11:
        this.G = r5.G;
    L12:
        this.F = r5.F;
        this.f15839u = r5.f15839u;
        if (r10 == false) goto L15;
        a(r5.o());
    L15:
        this.f15822k0 = r5.f15822k0;
        this.l0 = r5.l0;
        this.X = r5.X;
        this.Y = r5.Y;
        this.Z = r5.Z;
        this.f15806a0 = r5.f15806a0;
        JSONObject r13 = r5.T0;
        if (r13 == null) goto L50;
        d();
        JSONObject r14 = this.T0;
        monitor-enter(r14);
        Iterator<String> r15 = r13.keys();     // Catch: Throwable -> L29 Exception -> L38
    L22:
        if (r15.hasNext() == false) goto L32;
        String r16 = r15.next();     // Catch: Throwable -> L29 Exception -> L38
        Object r17 = r13.opt(r16);     // Catch: Throwable -> L29 Exception -> L38
        if (this.T0.has(r16) == true) goto L22;
        if (r17 == null) goto L22;
        this.T0.put(r16, r17);     // Catch: Throwable -> L29 Exception -> L38
    L29:
        th = move-exception;
        throw th;
    L32:
        this.U0 = null;     // Catch: Throwable -> L29
        monitor-exit(r14);     // Catch: Throwable -> L29
        y();
        return;
    L50:
        return;
    L9:
        if (c() == true) goto L11;
        this.G = 0;
        this.G0 = false;
        this.f15831p0 = false;
        this.f15811c0 = 0;
        this.f15833q0 = false;
        goto L12
    L5:
        r12 = 0;
        goto L6
    }

    public DownloadInfo(RawBuilder r10) {
        this.E = true;
        this.H = AsyncHandleStatus.f15263a;
        this.L = true;
        this.O = true;
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = null;
        this.W = -1;
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
        this.f15806a0 = false;
        this.f15822k0 = true;
        this.l0 = true;
        this.f15848y0 = ByteInvalidRetryStatus.f15266a;
        this.f15850z0 = EnqueueType.f15277a;
        this.d1 = null;
        this.f15805a = r10.K;
        this.f15808b = r10.f15851a;
        this.f15810c = r10.f15852b;
        this.d = r10.f15853c;
        this.e = r10.d;
        this.f = r10.e;
        this.f15814e0 = r10.L;
        a(r10.M);
        b(r10.N);
        a(r10.O);
        this.f15817h0 = r10.P;
        this.F = r10.Z;
        this.g = r10.f;
        this.f15828o = r10.f15858l;
        this.f15824m = r10.f15856j;
        this.f15816h = r10.g;
        this.f15839u = r10.f15860n;
        this.f15837t = r10.f15859m;
        this.f15813d0 = r10.Q;
        this.f15822k0 = r10.R;
        this.l0 = r10.S;
        this.f15841v = r10.f15861o;
        this.f15825m0 = r10.T;
        this.B = r10.s;
        this.C = r10.f15865t;
        this.G = r10.V;
        this.E = r10.f15864r;
        this.P0 = r10.W;
        this.f15826n = r10.f15857k;
        this.f15827n0 = r10.X;
        this.f15829o0 = r10.U;
        this.J = r10.f15866u;
        this.K = false;
        this.U0 = r10.Y;
        this.M = r10.f15867v;
        this.H0 = r10.f15868w;
        this.X = r10.f15872a0;
        this.Y = r10.f15873b0;
        this.Z = r10.f15874c0;
        this.f15806a0 = r10.f15875d0;
        this.f15849z = r10.f15876e0;
        this.A = r10.f15877f0;
        this.f15843w = r10.f15862p;
        this.P = r10.f15871z;
        y();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    public DownloadInfo(Parcel r10) {
        boolean r5 = true;
        this.E = true;
        this.H = AsyncHandleStatus.f15263a;
        this.L = true;
        this.O = true;
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = null;
        this.W = -1;
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
        this.f15806a0 = false;
        this.f15814e0 = 1;
        this.f15822k0 = true;
        this.l0 = true;
        this.f15848y0 = ByteInvalidRetryStatus.f15266a;
        EnqueueType r11 = EnqueueType.f15277a;
        this.f15850z0 = r11;
        this.d1 = null;
        this.f15805a = r10.readInt();
        this.f15808b = r10.readString();
        this.f15810c = r10.readString();
        this.d = r10.readString();
        this.e = r10.readString();
        this.f = r10.readString();
        if (r10.readByte() == 0) goto L5;
        boolean r12 = true;
    L6:
        this.g = r12;
        this.f15816h = r10.readString();
        this.f15818i = r10.createTypedArrayList(HttpHeader.CREATOR);
        this.f15819j = r10.readInt();
        this.f15821k = r10.createStringArray();
        this.f15823l = r10.createIntArray();
        this.f15824m = r10.readInt();
        this.f15826n = r10.readInt();
        if (r10.readByte() == 0) goto L9;
        boolean r13 = true;
    L10:
        this.f15828o = r13;
        if (r10.readByte() == 0) goto L13;
        boolean r14 = true;
    L14:
        this.f15830p = r14;
        this.f15832q = r10.readInt();
        this.f15834r = r10.readInt();
        this.s = r10.createStringArrayList();
        if (r10.readByte() == 0) goto L17;
        boolean r15 = true;
    L18:
        this.f15837t = r15;
        this.f15839u = r10.readString();
        if (r10.readByte() == 0) goto L21;
        boolean r16 = true;
    L22:
        this.f15841v = r16;
        this.B = r10.readString();
        this.C = r10.readString();
        if (r10.readByte() == 0) goto L25;
        boolean r17 = true;
    L26:
        this.E = r17;
        this.F = r10.readString();
        this.G = r10.readInt();
        this.f15809b0 = r10.readString();
        this.f15811c0 = r10.readInt();
        this.f15813d0 = r10.readInt();
        this.f15814e0 = r10.readInt();
        b(r10.readLong());
        a(r10.readLong());
        this.f15817h0 = r10.readLong();
        a(r10.readInt());
        this.f15825m0 = r10.readLong();
        this.f15827n0 = r10.readLong();
        this.f15829o0 = r10.readLong();
        if (r10.readByte() == 0) goto L29;
        boolean r18 = true;
    L30:
        this.f15831p0 = r18;
        if (r10.readByte() == 0) goto L33;
        boolean r19 = true;
    L34:
        this.f15833q0 = r19;
        if (r10.readByte() == 0) goto L37;
        boolean r20 = true;
    L38:
        this.f15840u0 = r20;
        if (r10.readByte() == 0) goto L41;
        boolean r21 = true;
    L42:
        this.f15842v0 = r21;
        if (r10.readByte() == 0) goto L45;
        boolean r22 = true;
    L46:
        this.f15844w0 = r22;
        this.f15846x0 = r10.createStringArrayList();
        if (r10.readByte() == 0) goto L49;
        boolean r23 = true;
    L50:
        this.J = r23;
        int r24 = r10.readInt();
        EnqueueType r25 = EnqueueType.f15278b;
        if (r24 != 1) goto L53;
        this.f15850z0 = r25;
    L63:
        this.A0 = r10.readInt();
        this.B0 = r10.readString();
        if (r10.readByte() == 0) goto L66;
        boolean r26 = true;
    L67:
        this.G0 = r26;
        if (r10.readByte() == 0) goto L70;
        boolean r27 = true;
    L71:
        this.O0 = r27;
        this.Q0 = (BaseException) r10.readParcelable(BaseException.class.getClassLoader());
        this.U0 = r10.readString();
        if (r10.readByte() == 0) goto L74;
        boolean r28 = true;
    L75:
        this.L = r28;
        this.M = r10.readString();
        this.H0 = r10.readInt();
        if (r10.readByte() == 0) goto L78;
        boolean r29 = true;
    L79:
        this.R = r29;
        if (r10.readByte() == 0) goto L82;
        boolean r30 = true;
    L83:
        this.T = r30;
        if (r10.readByte() == 0) goto L86;
        boolean r31 = true;
    L87:
        this.U = r31;
        if (r10.readByte() == 0) goto L90;
        boolean r32 = true;
    L91:
        this.S = r32;
        this.i0 = r10.readLong();
        this.W = r10.readInt();
        this.Z0 = r10.createStringArrayList();
        this.f15807a1 = r10.readHashMap(getClass().getClassLoader());
        this.X = r10.readLong();
        this.Y = r10.readLong();
        this.Z = r10.readLong();
        if (r10.readByte() == 0) goto L94;
        boolean r33 = true;
    L95:
        this.f15806a0 = r33;
        if (r10.readByte() == 0) goto L98;
        boolean r34 = true;
    L99:
        this.M0 = r34;
        this.f15843w = r10.readLong();
        this.f15845x = r10.createStringArrayList();
        this.f15847y = r10.createStringArrayList();
        this.N0 = r10.readString();
        if (r10.readByte() == 0) goto L102;
        boolean r35 = true;
    L103:
        this.b1 = r35;
        if (r10.readByte() == 0) goto L106;
        boolean r36 = true;
    L107:
        this.f15812c1 = r36;
        this.K0 = r10.readLong();
        this.C0 = r10.readString();
        this.D0 = r10.readString();
        this.E0 = r10.readString();
        this.L0 = r10.readLong();
        if (r10.readByte() != 0) goto L111;
        r5 = false;
    L111:
        this.K = r5;
        this.P = r10.readString();
        y();
        return;
    L106:
        r36 = false;
        goto L107
    L102:
        r35 = false;
        goto L103
    L98:
        r34 = false;
        goto L99
    L94:
        r33 = false;
        goto L95
    L90:
        r32 = false;
        goto L91
    L86:
        r31 = false;
        goto L87
    L82:
        r30 = false;
        goto L83
    L78:
        r29 = false;
        goto L79
    L74:
        r28 = false;
        goto L75
    L70:
        r27 = false;
        goto L71
    L66:
        r26 = false;
        goto L67
    L53:
        EnqueueType r37 = EnqueueType.f15279c;
        if (r24 != 2) goto L56;
        this.f15850z0 = r37;
        goto L63
    L56:
        EnqueueType r38 = EnqueueType.d;
        if (r24 != 3) goto L59;
        this.f15850z0 = r38;
        goto L63
    L59:
        EnqueueType r39 = EnqueueType.e;
        if (r24 != 4) goto L62;
        this.f15850z0 = r39;
        goto L63
    L62:
        this.f15850z0 = r11;
        goto L63
    L49:
        r23 = false;
        goto L50
    L45:
        r22 = false;
        goto L46
    L41:
        r21 = false;
        goto L42
    L37:
        r20 = false;
        goto L38
    L33:
        r19 = false;
        goto L34
    L29:
        r18 = false;
        goto L30
    L25:
        r17 = false;
        goto L26
    L21:
        r16 = false;
        goto L22
    L17:
        r15 = false;
        goto L18
    L13:
        r14 = false;
        goto L14
    L9:
        r13 = false;
        goto L10
    L5:
        r12 = false;
        goto L6
    }
}
