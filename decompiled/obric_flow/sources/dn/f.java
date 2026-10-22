package dn;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import com.bytedance.common.wschannel.WsConstants;
import com.lynx.animax.i;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.TraceController;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.g0;
import com.lynx.tasm.behavior.ui.o;
import com.lynx.tasm.behavior.w0;
import com.lynx.tasm.image.AutoSizeImage;
import com.lynx.tasm.resourceprovider.LynxResourceRequest$LynxResourceType;
import com.lynx.tasm.resourceprovider.media.OptionalBool;
import com.lynx.tasm.service.ILynxImageService;
import com.lynx.tasm.u0;
import com.lynx.tasm.ui.image.h;
import com.lynx.tasm.utils.ColorUtils;
import com.lynx.tasm.utils.j;
import g8.g;
import java.util.ArrayList;
import java.util.Map;
import jg.k;
import ko.r;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: loaded from: classes2.dex */
public class f implements Drawable.Callback {
    public int A;
    public int B;
    public int C;
    public boolean D;
    public xn.e E;
    public xn.e F;
    public float G;
    public float H;
    public float I;
    public float J;
    public float[] K;
    public RectF L;
    public int M;
    public int N;
    public ShadowNode O;
    public boolean P;
    public LynxBaseUI Q;
    public g0 R;
    public final boolean S;
    public final wn.d T;
    public final boolean U;
    public boolean V;
    public boolean W;
    public boolean X;
    public boolean Y;
    public boolean Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f16675a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public OptionalBool f16676a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LynxContext f16677b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public OptionalBool f16678b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f16679c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public PorterDuffColorFilter f16680c0;
    public String d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public xn.e f16681d0;
    public String e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public com.lynx.tasm.behavior.ui.utils.a f16682e0;
    public boolean f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public boolean f16683f0;
    public boolean g;
    public final com.lynx.animax.player.b g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f16684h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final k6.a f16685h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f16686i;
    public final uj.a i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public wn.e f16687j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public wn.e f16688k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f16689l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f16690m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public wn.f f16691n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f16692o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f16693p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Bitmap.Config f16694q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f16695r;
    public String s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f16696t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f16697u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f16698v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f16699w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f16700x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f16701y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f16702z;

    public f(LynxContext r5) {
        this.f16675a = 0;
        this.f16691n = wn.g.f22893h;
        boolean r10 = true;
        this.f16695r = true;
        this.f16697u = true;
        this.L = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.O = null;
        boolean r11 = false;
        this.U = false;
        OptionalBool r12 = OptionalBool.f10952c;
        this.f16676a0 = r12;
        this.f16678b0 = r12;
        this.f16680c0 = null;
        this.f16681d0 = null;
        this.f16683f0 = false;
        this.g0 = new com.lynx.animax.player.b(new k(this, 7));
        this.f16685h0 = new k6.a(this);
        this.i0 = new uj.a();
        this.f16677b = r5;
        r5.getClass();
        this.f16679c = new g(7);
        this.T = new wn.d(r5);
        if (r5.E == null) goto L5;
    L6:
        r11 = true;
    L7:
        this.S = r11;
        u0 r13 = r5.K;
        if (r13 == null) goto L10;
        r10 = r13.g;
    L10:
        this.U = r10;
        return;
    L5:
        if (r5.d == null) goto L7;
        goto L6
    }

    public final xn.e a(int r10, int r11, String r12) {
        if (TextUtils.isEmpty(r12) == false) goto L6;
        return null;
    L6:
        xn.f r5 = new xn.f();
        boolean r13 = true;
        r5.f23192i = true;
        r5.f23188a = r12;
        r5.f23189b = r10;
        r5.f23190c = r11;
        LynxContext r14 = this.f16677b;
        r14.getClass();
        r5.f23191h = this.f16695r;
        if (this.D == false) goto L9;
    L11:
        r13 = false;
    L12:
        r5.f23192i = r13;
        r5.g = this.f16697u;
        r5.e = this.f16686i;
        r5.f23193j = this.f16684h;
        Bitmap.Config r15 = this.f16694q;
        if (r15 == null) goto L15;
        r5.d = r15;
    L15:
        r14.getClass();
        r14.getClass();
        if (TextUtils.isEmpty(this.f16692o) == true) goto L21;
        float r16 = com.lynx.tasm.utils.k.c(this.f16692o, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, r14.f10152u);
        if (r16 <= 0.0f) goto L21;
        xn.b r17 = new xn.b((int) r16);
        ArrayList r18 = new ArrayList();
        r18.add(r17);
        r5.f = r18;
    L21:
        return new xn.e(r5);
    L9:
        if (this.f16693p == true) goto L11;
        goto L11
    }

    public void b(int r5, int r10) {
        if (this.Y == false) goto L12;
        LynxContext r11 = this.f16677b;
        if (r11 == null) goto L13;
        LynxBaseUI r12 = this.Q;
        if (r12 != null) goto L9;
        return;
    L9:
        if (this.f16696t == true) goto L15;
        i r13 = new i(r12.getSign(), "load");
        r13.a("height", Integer.valueOf(r10));
        r13.a("width", Integer.valueOf(r5));
        r11.g.b(r13);
        return;
    L15:
        return;
    L13:
        return;
    }

    public final void c(int r10, int r11, int r12, int r13, int r14, int r15) {
        if (r10 > 0) goto L5;
        if (r11 > 0) goto L5;
        return;
    L5:
        int r5 = this.f16702z;
        if (r10 == r5) goto L8;
    L9:
        if (r10 <= r5) goto L11;
    L12:
        this.f16675a |= 2048;
    L13:
        this.f16702z = r10;
        this.A = r11;
        this.f16675a |= 512;
    L15:
        if (this.f16699w == r14) goto L17;
    L24:
        this.f16699w = r14;
        this.f16700x = r13;
        this.f16698v = r12;
        this.f16701y = r15;
        this.f16675a |= 512;
        return;
    L17:
        if (this.f16700x != r13) goto L24;
        if (this.f16701y != r15) goto L24;
        if (this.f16698v != r12) goto L24;
        return;
    L11:
        if (r11 <= this.A) goto L13;
    L8:
        if (r11 == this.A) goto L15;
        goto L9
    }

    public final void d(Canvas r5) {
        this.g0.d();
        r5.save();
        com.lynx.tasm.behavior.ui.utils.a r10 = this.f16682e0;
        if (r10 == null) goto L7;
        Path r11 = r10.f10737c;
        if (r11 == null) goto L7;
        r5.clipPath(r11);
    L7:
        wn.e r12 = this.f16688k;
        if (r12 == null) goto L10;
        r12.draw(r5);
    L10:
        wn.e r13 = this.f16687j;
        if (r13 == null) goto L13;
        r13.draw(r5);
    L13:
        r5.restore();
    }

    public final void e(RectF r10) {
        this.L = r10;
        float r5 = r10.top;
        float r11 = r10.bottom;
        float r12 = r10.left;
        float r13 = r10.right;
        if (this.I == r5) goto L6;
        this.I = r5;
        this.f16675a |= RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
    L6:
        if (this.G == r12) goto L9;
        this.G = r12;
        this.f16675a |= RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
    L9:
        if (this.H == r13) goto L12;
        this.H = r13;
        this.f16675a |= RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
    L12:
        if (this.J == r11) goto L15;
        this.J = r11;
        this.f16675a |= RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
        return;
    }

    public final void f(Drawable r5) {
        Rect r10 = new Rect(0, 0, this.f16702z, this.A);
        r10.left = (int) ((r10.left + this.G) + this.f16698v);
        r10.top = (int) ((r10.top + this.I) + this.f16699w);
        r10.right = (int) ((r10.right - this.H) - this.f16700x);
        r10.bottom = (int) ((r10.bottom - this.J) - this.f16701y);
        if (r5 == null) goto L6;
        r5.setBounds(r10);
        return;
    }

    public final void g(ReadableMap r14) {
        if (TraceController.g == false) goto L5;
        TraceEvent.c("LynxImageManager.updatePropertiesInterval");
    L5:
        ReadableMapKeySetIterator r5 = r14.keySetIterator();
    L7:
        if (r5.hasNextKey() == false) goto L160;
        String r10 = r5.nextKey();
        r10.getClass();
        LynxContext r11 = this.f16677b;
        byte r12 = -1;
        switch(r10.hashCode()) {
            case -1937917490: goto L100;
            case -1492006372: goto L96;
            case -1338903714: goto L92;
            case -1138223116: goto L88;
            case -629825370: goto L84;
            case -320982203: goto L80;
            case -256430480: goto L76;
            case 114148: goto L72;
            case 3357091: goto L68;
            case 108305470: goto L64;
            case 207594941: goto L60;
            case 313009824: goto L56;
            case 516005201: goto L52;
            case 598246771: goto L48;
            case 681292984: goto L44;
            case 1198809474: goto L40;
            case 1439562083: goto L36;
            case 1515751784: goto L32;
            case 1615092063: goto L28;
            case 1739487650: goto L24;
            case 1860054545: goto L20;
            case 1998893929: goto L16;
            case 2141225912: goto L12;
            default: goto L103;
        };
    L103:
        switch(r12) {
            case 0: goto L157;
            case 1: goto L156;
            case 2: goto L155;
            case 3: goto L143;
            case 4: goto L142;
            case 5: goto L141;
            case 6: goto L140;
            case 7: goto L137;
            case 8: goto L136;
            case 9: goto L133;
            case 10: goto L132;
            case 11: goto L131;
            case 12: goto L128;
            case 13: goto L125;
            case 14: goto L122;
            case 15: goto L121;
            case 16: goto L120;
            case 17: goto L117;
            case 18: goto L114;
            case 19: goto L113;
            case 20: goto L107;
            case 21: goto L106;
            case 22: goto L105;
            default: goto L7;
        };
    L105:
        this.f16696t = r14.getBoolean(r10, false);
        goto L7
    L106:
        this.f16686i = r14.getBoolean(r10, false);
        goto L7
    L107:
        String r13 = r14.getString(r10);
        if (TextUtils.equals(r13, this.s) == true) goto L7;
        this.s = r13;
        if (ColorUtils.a(r13) == false) goto L112;
        this.f16680c0 = new PorterDuffColorFilter(ColorUtils.b(this.s), PorterDuff.Mode.SRC_IN);
    L112:
        this.f16675a |= 128;
        goto L7
    L113:
        this.g = r14.getBoolean(r10, false);
        goto L7
    L114:
        boolean r15 = r14.getBoolean(r10, false);
        if (r15 == this.f16693p) goto L7;
        this.f16693p = r15;
        this.f16675a |= 64;
        goto L7
    L117:
        String r16 = r14.getString(r10);
        if (TextUtils.equals(r16, this.f16689l) == true) goto L7;
        this.f16689l = r16;
        this.f16675a |= 8;
        goto L7
    L120:
        this.f16695r = r14.getBoolean(r10, true);
        goto L7
    L121:
        r14.getBoolean(r10, false);
        goto L7
    L122:
        String r17 = r14.getString(r10);
        if (TextUtils.equals(r17, this.f16692o) == true) goto L7;
        this.f16692o = r17;
        this.f16675a |= 32;
        goto L7
    L125:
        String r18 = r14.getString(r10);
        if (TextUtils.equals(r18, this.e) == true) goto L7;
        this.e = r18;
        this.f16675a |= 4;
        goto L7
    L128:
        String r19 = r14.getString(r10);
        if (TextUtils.equals(r19, this.f16689l) == true) goto L7;
        this.f16689l = r19;
        this.f16675a |= 8;
        goto L7
    L131:
        com.bytedance.apm.util.a.f(r14.getDynamic(r10));
        goto L7
    L132:
        this.C = (int) com.lynx.tasm.utils.k.c(r14.getString(r10), 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, r11.f10152u);
        goto L7
    L133:
        boolean r20 = r14.getBoolean(r10, false);
        if (this.f16697u == r20) goto L7;
        this.f16697u = r20;
        this.f16675a |= 256;
        goto L7
    L136:
        i(r14.getString(r10));
        goto L7
    L137:
        String r21 = r14.getString(r10);
        if (TextUtils.equals(r21, this.d) == true) goto L7;
        this.d = r21;
        this.f16675a |= 2;
        goto L7
    L140:
        this.B = (int) com.lynx.tasm.utils.k.c(r14.getString(r10), 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, r11.f10152u);
        goto L7
    L141:
        this.D = r14.getBoolean(r10, false);
        goto L7
    L142:
        r14.getInt(r10, 0);
        goto L7
    L143:
        String r22 = r14.getString(r10);
        if (r22 == null) goto L154;
        if (r22.equalsIgnoreCase("") == true) goto L154;
        if (r22.equalsIgnoreCase("RGB_565") == true) goto L150;
        if (r22.equalsIgnoreCase("ARGB_8888") == false) goto L7;
        this.f16694q = Bitmap.Config.ARGB_8888;
        goto L7
    L150:
        this.f16694q = Bitmap.Config.RGB_565;
    L154:
        this.f16694q = null;
        goto L7
    L155:
        this.f = r14.getBoolean(r10, false);
        goto L7
    L156:
        this.f16684h = r14.getBoolean(r10, false);
        goto L7
    L157:
        String r23 = r14.getString(r10);
        if (TextUtils.equals(r23, this.f16690m) == true) goto L7;
        this.f16690m = r23;
        this.f16675a |= 8;
        goto L7
    L12:
        if (r10.equals("extra-load-info") == false) goto L103;
        r12 = 22;
        goto L103
    L16:
        if (r10.equals("enable-custom-gif-decoder") == false) goto L103;
        r12 = 21;
        goto L103
    L20:
        if (r10.equals("tint-color") == false) goto L103;
        r12 = 20;
        goto L103
    L24:
        if (r10.equals("defer-src-invalidation") == false) goto L103;
        r12 = 19;
        goto L103
    L28:
        if (r10.equals("auto-size") == false) goto L103;
        r12 = 18;
        goto L103
    L32:
        if (r10.equals("capInsets") == false) goto L103;
        r12 = 17;
        goto L103
    L36:
        if (r10.equals("autoplay") == false) goto L103;
        r12 = 16;
        goto L103
    L40:
        if (r10.equals("disable-default-placeholder") == false) goto L103;
        r12 = 15;
        goto L103
    L44:
        if (r10.equals("blur-radius") == false) goto L103;
        r12 = 14;
        goto L103
    L48:
        if (r10.equals("placeholder") == false) goto L103;
        r12 = 13;
        goto L103
    L52:
        if (r10.equals("cap-insets") == false) goto L103;
        r12 = 12;
        goto L103
    L56:
        if (r10.equals("local-cache") == false) goto L103;
        r12 = 11;
        goto L103
    L60:
        if (r10.equals("prefetch-height") == false) goto L103;
        r12 = 10;
        goto L103
    L64:
        if (r10.equals("async-request") == false) goto L103;
        r12 = 9;
        goto L103
    L68:
        if (r10.equals("mode") == false) goto L103;
        r12 = 8;
        goto L103
    L72:
        if (r10.equals("src") == false) goto L103;
        r12 = 7;
        goto L103
    L76:
        if (r10.equals("prefetch-width") == false) goto L103;
        r12 = 6;
        goto L103
    L80:
        if (r10.equals("disable-default-resize") == false) goto L103;
        r12 = 5;
        goto L103
    L84:
        if (r10.equals("loop-count") == false) goto L103;
        r12 = 4;
        goto L103
    L88:
        if (r10.equals("image-config") == false) goto L103;
        r12 = 3;
        goto L103
    L92:
        if (r10.equals("skip-redirection") == false) goto L103;
        r12 = 2;
        goto L103
    L96:
        if (r10.equals("enable-resource-hint") == false) goto L103;
        r12 = 1;
        goto L103
    L100:
        if (r10.equals("cap-insets-scale") == false) goto L103;
        r12 = 0;
        goto L103
    L160:
        r();
        TraceEvent.a(0, "LynxImageManager.updatePropertiesInterval");
    }

    public void h(LynxError r10, int r11, int r12) {
        LynxContext r5 = this.f16677b;
        if (r5 == null) goto L18;
        LynxBaseUI r13 = this.Q;
        if (r13 == null) goto L19;
        r10.b("node_index", Integer.toString(r13.getNodeIndex()));
        if (this.Z == false) goto L16;
        i r14 = new i(this.Q.getSign(), "error");
        StringBuilder r15 = new StringBuilder();
        String r16 = "";
        String r17 = r10.f9993h;
        if (r17 != null) goto L11;
        r17 = "";
    L11:
        r15.append(r17);
        r15.append(": ");
        String r18 = r10.f10000o;
        if (r18 == null) goto L15;
        r16 = r18;
    L15:
        r15.append(r16);
        r14.a("errMsg", r15.toString());
        r14.a("lynx_categorized_code", Integer.valueOf(r11));
        r14.a(WsConstants.ERROR_CODE, Integer.valueOf(r12));
        r5.g.b(r14);
    L16:
        r10.b("image_categorized_code", String.valueOf(r11));
        r5.f(this.d, "image", r10);
        return;
    L19:
        return;
    }

    public final void i(String r5) {
        if ("aspectFit".equals(r5) == false) goto L6;
        wn.g r10 = wn.g.g;
    L13:
        if (r10.equals(this.f16691n) == true) goto L16;
        this.f16691n = r10;
        this.f16675a |= 16;
        return;
    L16:
        return;
    L6:
        if ("aspectFill".equals(r5) == false) goto L9;
        r10 = wn.g.f;
        goto L13
    L9:
        if ("center".equals(r5) == false) goto L11;
        r10 = wn.g.e;
        goto L13
    L11:
        r10 = wn.g.f22893h;
        goto L13
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r5) {
        j.f(new h(this, 10));
    }

    public final void j(Map r5) {
        if (r5 == null) goto L21;
        this.V = false;
        this.W = false;
        this.X = false;
        this.Y = false;
        this.Z = false;
        if (r5.containsKey("startplay") == false) goto L8;
        this.V = true;
    L8:
        if (r5.containsKey("currentloopcomplete") == false) goto L11;
        this.W = true;
    L11:
        if (r5.containsKey("finalloopcomplete") == false) goto L14;
        this.X = true;
    L14:
        if (r5.containsKey("load") == false) goto L17;
        this.Y = true;
    L17:
        if (r5.containsKey("error") == false) goto L20;
        this.Z = true;
        return;
    L20:
        return;
    }

    public final void k(xn.e r5) {
        if (r5 == null) goto L5;
        g r10 = this.f16679c;
        r10.getClass();
        ((ILynxImageService) r10.f17073b).releaseImage(r5);
        return;
    }

    public final boolean l(long r5) {
        if ((this.f16675a & r5) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    public final void m() {
        k(this.E);
        k(this.F);
        o(this.f16687j);
        o(this.f16688k);
        this.E = null;
        this.F = null;
        wn.e r5 = this.f16687j;
        if (r5 == null) goto L5;
        r5.b();
        this.f16687j = null;
    L5:
        wn.e r10 = this.f16688k;
        if (r10 == null) goto L9;
        r10.b();
        this.f16688k = null;
        return;
    }

    public void n() {
        LynxBaseUI r5 = this.Q;
        if (r5 == null) goto L5;
        r5.invalidateMeaningfulPaintingArea();
    L5:
        g0 r10 = this.R;
        if (r10 == null) goto L11;
        KeyEvent.Callback r11 = r10.f10476b;
        if ((r11 instanceof o) == false) goto L11;
        ((o) r11).invalidateMeaningfulPaintingArea();
    L11:
        if (j.j() == false) goto L24;
        LynxBaseUI r12 = this.Q;
        if (r12 == null) goto L16;
        r12.invalidate();
    L16:
        g0 r13 = this.R;
        if (r13 == null) goto L23;
        View r14 = r13.f10476b;
        if (r14 == null) goto L25;
        r14.invalidate();
        return;
    L25:
        return;
    L23:
        return;
    }

    public final void o(Drawable r5) {
        if (r5 == null) goto L5;
        Drawable r10 = r5.getCurrent();
        g r11 = this.f16679c;
        r11.getClass();
        ((ILynxImageService) r11.f17073b).releaseAnimDrawable(r10);
        return;
    }

    public final void p() {
        if (this.M != 0) goto L5;
        return;
    L5:
        if (this.N != 0) goto L7;
        return;
    L7:
        if (this.f16693p == false) goto L26;
        LynxBaseUI r5 = this.Q;
        if (r5 != null) goto L12;
        return;
    L12:
        if (this.O != null) goto L18;
        LynxContext r10 = r5.getLynxContext();
        int r11 = this.Q.getSign();
        w0 r12 = (w0) r10.f10151t.get();
        if (r12 == null) goto L16;
        ShadowNode r13 = (ShadowNode) ((SparseArray) r12.g.f10812a).get(r11);
    L17:
        this.O = r13;
        goto L18
    L16:
        r13 = null;
    L18:
        ShadowNode r14 = this.O;
        if ((r14 instanceof AutoSizeImage) == true) goto L22;
        this.P = true;
        return;
    L22:
        boolean r15 = this.f16693p;
        ((AutoSizeImage) r14).s(this.M, this.N, this.Q.getWidth(), this.Q.getHeight(), r15);
        return;
    }

    public final void q() {
        if (l(2048) == false) goto L12;
        if (this.D == false) goto L7;
    L10:
        this.f16675a &= -2049;
        goto L12
    L7:
        if (this.f16693p == true) goto L10;
        if (this.f16684h == true) goto L10;
    L12:
        if (l(16) == false) goto L17;
        if (this.f16687j == null) goto L17;
        this.f16687j = new wn.e(this.f16687j.f, this.f16691n);
    L17:
        if (l(8) == false) goto L22;
        wn.e r5 = this.f16687j;
        if (r5 == null) goto L22;
        String r10 = this.f16689l;
        String r11 = this.f16690m;
        r5.g = r10;
        r5.f22889h = r11;
    L22:
        if (l(128) == false) goto L26;
        wn.e r12 = this.f16687j;
        if (r12 == null) goto L26;
        r12.setColorFilter(this.f16680c0);
    L26:
        boolean r13 = true;
        if (l(4) == false) goto L54;
        k(this.F);
        o(this.f16688k);
        wn.e r14 = this.f16688k;
        if (r14 == null) goto L31;
        r14.b();
        this.f16688k = null;
    L31:
        this.F = null;
        if (TraceController.g == false) goto L34;
        TraceEvent.c("LynxImageManager.updatePlaceholderSource");
    L34:
        int r15 = this.f16702z;
        if (r15 <= 0) goto L39;
        int r16 = this.A;
        if (r16 <= 0) goto L39;
    L43:
        boolean r17 = true;
    L45:
        if (r17 == true) goto L47;
    L52:
        TraceEvent.a(0, "LynxImageManager.updatePlaceholderSource");
        goto L54
    L47:
        if (this.f16687j != null) goto L52;
        xn.e r18 = a(r15, r16, this.e);
        if (r18 == null) goto L52;
        this.F = r18;
        g r19 = this.f16679c;
        r19.getClass();
        TraceEvent.c("LynxImageServiceProxy.fetchImage");
        ((ILynxImageService) r19.f17073b).fetchImage(r18, this.f16685h0, null, this.f16677b);
        TraceEvent.a(0, "LynxImageServiceProxy.fetchImage");
    L39:
        r15 = this.B;
        if (r15 <= 0) goto L44;
        r16 = this.C;
        if (r16 > 0) goto L43;
    L44:
        r15 = 0;
        r16 = 0;
        r17 = false;
    L54:
        if (l(2) == true) goto L60;
        if (l(32) == true) goto L60;
        if (l(2048) == true) goto L60;
    L87:
        if (l(512) == false) goto L89;
    L92:
        f(this.f16687j);
        f(this.f16688k);
        float[] r20 = this.K;
        if (r20 != null) goto L95;
    L101:
        if (this.P == false) goto L105;
        this.P = false;
        if (this.f16693p == false) goto L105;
        p();
    L105:
        this.f16675a = 0;
        return;
    L95:
        if (r20.length <= 0) goto L101;
        if (this.f16682e0 != null) goto L99;
        this.f16682e0 = new com.lynx.tasm.behavior.ui.utils.a();
    L99:
        this.f16682e0.b(new Rect(this.f16698v, this.f16699w, this.f16702z - this.f16700x, this.A - this.f16701y), this.K, this.L, 1.0f, false);
        goto L101
    L89:
        if (l(RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) == true) goto L92;
        if (l(4096) == false) goto L101;
    L60:
        if (this.g == true) goto L65;
        k(this.E);
        o(this.f16687j);
        wn.e r21 = this.f16687j;
        if (r21 == null) goto L64;
        r21.b();
        this.f16687j = null;
    L64:
        this.E = null;
        this.M = 0;
        this.N = 0;
    L67:
        if (TraceController.g == false) goto L69;
        TraceEvent.c("LynxImageManager.updateImageSource");
    L69:
        int r22 = this.f16702z;
        if (r22 <= 0) goto L74;
        int r23 = this.A;
        if (r23 <= 0) goto L74;
    L83:
        if (r13 == false) goto L85;
        LynxEnv.runJavaTaskOnConcurrentLoop(new e(this, r22, r23), 0);
    L85:
        TraceEvent.a(0, "LynxImageManager.updateImageSource");
    L74:
        r22 = this.B;
        if (r22 <= 0) goto L80;
        r23 = this.C;
        if (r23 > 0) goto L83;
    L80:
        if (this.f16693p == true) goto L82;
        r22 = 0;
        r23 = 0;
        r13 = false;
        goto L83
    L82:
        r22 = 0;
        r23 = 0;
        goto L83
    L65:
        this.f16681d0 = this.E;
        goto L67
    }

    public final void r() {
        if (this.f == false) goto L6;
        return;
    L6:
        if (this.U == false) goto L47;
        boolean r5 = l(2);
        boolean r10 = l(4);
        g r11 = this.f16679c;
        r r12 = null;
        wn.d r13 = this.T;
        if (r5 == false) goto L17;
        String r14 = this.d;
        r11.getClass();
        if (((ILynxImageService) r11.f17073b).canParseUrl(r14) == false) goto L13;
        this.f16676a0 = OptionalBool.f10951b;
    L15:
        if (this.f16676a0 == OptionalBool.f10951b) goto L17;
        r r15 = new r(8, this.d, LynxResourceRequest$LynxResourceType.f10942a);
    L18:
        if (r10 == false) goto L27;
        String r16 = this.e;
        r11.getClass();
        if (((ILynxImageService) r11.f17073b).canParseUrl(r16) == false) goto L22;
        this.f16678b0 = OptionalBool.f10951b;
    L24:
        if (this.f16678b0 == OptionalBool.f10951b) goto L27;
        r12 = new r(8, this.e, LynxResourceRequest$LynxResourceType.f10942a);
        goto L27
    L22:
        this.f16678b0 = r13.b(this.e);
    L27:
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) goto L29;
    L39:
        if (r15 == null) goto L41;
        this.d = r13.d(r15);
    L41:
        if (r12 == null) goto L45;
        this.e = r13.d(r12);
        return;
    L45:
        return;
    L29:
        if (this.S == false) goto L39;
        if (r15 != null) goto L33;
        if (r12 != null) goto L33;
        return;
    L33:
        if (r15 == null) goto L35;
        this.f16675a &= -3;
    L35:
        if (r12 == null) goto L37;
        this.f16675a &= -5;
    L37:
        mn.h.i().execute(new androidx.room.f(this, 4, r12, r15));
        return;
    L13:
        this.f16676a0 = r13.b(this.d);
    L17:
        r15 = null;
        goto L18
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable r5, Runnable r10, long r11) {
        j.a().postAtTime(r10, r5, r11);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable r5, Runnable r10) {
        j.a().removeCallbacks(r10, r5);
    }
}
