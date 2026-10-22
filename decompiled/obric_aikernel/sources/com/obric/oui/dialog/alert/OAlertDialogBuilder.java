package com.obric.oui.dialog.alert;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.RequiresApi;
import com.obric.oui.dialog.base.AbstractDialog;
import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated(message = "已废弃, 请用 com/obric/oui/dialog/v2 下面的版本")
public class OAlertDialogBuilder extends com.obric.oui.dialog.base.b<OAlertDialog> {
    private CharSequence A;
    private DialogInterface.OnClickListener B;
    private ButtonStyleController.TextColorType C;
    private boolean D;
    private com.obric.oui.dialog.alert.c E;
    private com.obric.oui.dialog.alert.c F;
    private boolean G;
    private boolean H;
    private boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private boolean f6435J;
    private View K;
    private boolean L;
    private boolean M;
    private final Context N;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private CharSequence f6436i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private CharSequence f6437j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f6438k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Drawable f6439l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f6440m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private com.obric.oui.dialog.alert.view.a f6441n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private a f6442o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Integer f6443p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Integer f6444q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f6445r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f6446s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private CharSequence f6447t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private DialogInterface.OnClickListener f6448u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ButtonStyleController.TextColorType f6449v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private CharSequence f6450w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private DialogInterface.OnClickListener f6451x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private ButtonStyleController.TextColorType f6452y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f6453z;

    public interface a {
        void a(ImageView r10);
    }

    static final class b implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function2 f6454c;

        b(Function2 r10) {
            this.f6454c = r10;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r10, int r11) {
            Function2 r12 = this.f6454c;
            Intrinsics.checkNotNullExpressionValue(r10, "dialog");
            r12.invoke(r10, Integer.valueOf(r11));
        }
    }

    static final class c implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function2 f6455c;

        c(Function2 r10) {
            this.f6455c = r10;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r10, int r11) {
            Function2 r12 = this.f6455c;
            Intrinsics.checkNotNullExpressionValue(r10, "dialog");
            r12.invoke(r10, Integer.valueOf(r11));
        }
    }

    public OAlertDialogBuilder(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10);
        this.N = r10;
        this.f6440m = "";
        this.D = true;
        super.b(false);
    }

    public static final /* synthetic */ boolean j(OAlertDialogBuilder r10) {
        return r10.f6435J;
    }

    public static final /* synthetic */ boolean k(OAlertDialogBuilder r10) {
        return r10.f6438k;
    }

    public static /* synthetic */ OAlertDialogBuilder s(OAlertDialogBuilder r10, CharSequence r11, boolean r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 2) == 0) goto L7;
        r12 = false;
    L7:
        return r10.r(r11, r12);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: title");
    }

    private final void t(CharSequence r10, Function1<? super CharSequence, Unit> r11) {
        if (TextUtils.isEmpty(r10) == true) goto L6;
        Intrinsics.checkNotNull(r10);
        r11.invoke(r10);
        return;
    }

    @Override // com.obric.oui.dialog.base.b
    public /* bridge */ /* synthetic */ AbstractDialog c() {
        return m();
    }

    public final OAlertDialogBuilder l(boolean r10) {
        this.D = r10;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @RequiresApi(30)
    public OAlertDialog m() {
        final OAlertDialog r10 = p(this.N, this.H, this.G);
        t(this.f6436i, new OAlertDialogBuilder$createDialog$1(this, r10));
        t(this.f6437j, new OAlertDialogBuilder$createDialog$2(this, r10));
        com.obric.oui.dialog.alert.c r11 = this.F;
        boolean r12 = true;
        if (r11 == null) goto L6;
        r10.S(r11);
    L34:
        r10.v(this.D);
        ButtonStyleController r13 = new ButtonStyleController(this.N, this.f6446s);
        r10.N(r13);
        com.obric.oui.dialog.alert.c r14 = this.E;
        if (r14 == null) goto L38;
        r10.M(r14);
    L38:
        if (f() == true) goto L45;
        if (this.f6446s == 2) goto L43;
        r12 = false;
    L43:
        com.obric.oui.dialog.base.b.i(this, r12, null, 2, null);
    L45:
        if (this.I == false) goto L48;
        com.obric.oui.dialog.base.b.i(this, false, null, 2, null);
    L48:
        if (this.L == false) goto L51;
        r10.i();
    L51:
        if (this.M == false) goto L53;
        r10.f();
    L53:
        r10.setOnShowListener(g());
        r10.setOnDismissListener(e());
        r10.setOnCancelListener(d());
        r13.i(this.f6450w, this.f6451x, this.f6452y, this.f6453z);
        r13.g(this.f6447t, this.f6448u, this.f6449v);
        r13.h(this.A, this.B, this.C);
        View r15 = this.K;
        if (r15 == null) goto L56;
        Intrinsics.checkNotNull(r15);
        r13.f(r15);
    L56:
        return r10;
    L6:
        if (this.f6440m.length() <= 0) goto L8;
        Object[] r16 = true;
    L9:
        if (r16 == true) goto L11;
    L13:
        Object[] r17 = false;
    L14:
        Drawable r18 = this.f6439l;
        if (r18 != null) goto L19;
        if (r17 == true) goto L19;
        if (this.f6442o == null) goto L34;
    L19:
        com.obric.oui.dialog.alert.b r19 = new com.obric.oui.dialog.alert.b(this.N, this.f6445r ? 1 : 0);
        a r20 = this.f6442o;
        if (r20 == null) goto L22;
        Intrinsics.checkNotNull(r20);
        r19.j(r20);
    L33:
        r10.S(r19);
        goto L34
    L22:
        if (r18 == null) goto L25;
        r19.f(r18);
        Integer r21 = this.f6443p;
        Integer r22 = this.f6444q;
    L24:
        r19.i(r21, r22);
        goto L33
    L25:
        r19.g(this.f6440m);
        com.obric.oui.dialog.alert.view.a r23 = this.f6441n;
        if (r23 == null) goto L28;
        r19.h(r23);
    L28:
        r21 = this.f6443p;
        if (r21 == null) goto L33;
        r22 = this.f6444q;
        if (r22 == null) goto L33;
    L11:
        if (this.f6441n == null) goto L13;
        r17 = true;
        goto L14
    L8:
        r16 = false;
        goto L9
    }

    public final OAlertDialogBuilder n(CharSequence r10) {
        this.f6437j = r10;
        return this;
    }

    public final OAlertDialogBuilder o(CharSequence r10, Function2<? super DialogInterface, ? super Integer, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "text");
        Intrinsics.checkNotNullParameter(r11, "listener");
        this.f6447t = r10;
        this.f6448u = new b(r11);
        return this;
    }

    @RequiresApi(30)
    public OAlertDialog p(Context r10, boolean r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        return new OAlertDialog(r10, r11, r12);
    }

    public final OAlertDialogBuilder q(CharSequence r10, Function2<? super DialogInterface, ? super Integer, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "text");
        Intrinsics.checkNotNullParameter(r11, "listener");
        this.f6450w = r10;
        this.f6451x = new c(r11);
        return this;
    }

    public final OAlertDialogBuilder r(CharSequence r10, boolean r11) {
        this.f6438k = r11;
        this.f6436i = r10;
        return this;
    }
}
