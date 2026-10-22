package dc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.obric.cae.R;
import com.obric.oui.button.OButton;
import ha.t;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OButton f7032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OButton f7033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public OButton f7034c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f7035d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f7036e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f7037f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f7038g;

    /* JADX INFO: renamed from: dc.a$a, reason: collision with other inner class name */
    public static final enum EnumC0062a extends Enum<EnumC0062a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EnumC0062a[] f7039a = null;

        static {
            f7039a = new EnumC0062a[]{new EnumC0062a("TextReverse", 0), new EnumC0062a("TextReverse2", 1), new EnumC0062a("Negative", 2)};
        }

        public EnumC0062a(String r8, int r10) {
            super(r8, r10);
        }

        public static EnumC0062a valueOf(String r8) {
            return (EnumC0062a) Enum.valueOf(EnumC0062a.class, r8);
        }

        public static EnumC0062a[] values() {
            return (EnumC0062a[]) f7039a.clone();
        }
    }

    public a(Context r8) {
        he.i.f(r8, "context");
        this.f7037f = r8;
        this.f7038g = 0;
    }

    public static void b(OButton r8, EnumC0062a r10) {
        if (r10 == null) goto L16;
        int r11 = r10.ordinal();
        if (r11 != 0) goto L6;
        int r12 = R.color.TextReverse;
    L14:
        Context r13 = r8.getContext();
        Object r14 = androidx.core.content.a.f1674a;
        r8.setTextColor(androidx.core.content.a.c.a(r13, r12));
        return;
    L6:
        if (r11 != 1) goto L8;
        r12 = R.color.TextReverse2;
        goto L14
    L8:
        if (r11 != 2) goto L11;
        r12 = R.color.Negative;
        goto L14
    L11:
        throw new t();
    }

    @Override // dc.m
    public final void a(Context r8, FrameLayout r10) {
        FrameLayout.LayoutParams r11 = new FrameLayout.LayoutParams(-1, -2);
        int r12 = this.f7038g;
        if (r12 != 0) goto L5;
        int r13 = R.layout.o_dialog_button_horizontal;
    L9:
        View r14 = LayoutInflater.from(r8).inflate(r13, r10, false);
        r10.addView(r14, r11);
        this.f7036e = r14;
        if (r14 == null) goto L12;
        r14.setVisibility(8);
    L12:
        this.f7032a = (OButton) r14.findViewById(R.id.actionPositive);
        this.f7033b = (OButton) r14.findViewById(R.id.actionNegative);
        this.f7034c = (OButton) r14.findViewById(R.id.actionNeutral);
        FrameLayout r15 = (FrameLayout) r14.findViewById(R.id.custom_container);
        return;
    L5:
        if (r12 == 1) goto L7;
        r13 = R.layout.o_dialog_button_primary;
        goto L9
    L7:
        r13 = R.layout.o_dialog_button_vertical;
        goto L9
    }

    @Override // dc.m
    public final void d(e r8) {
        he.i.f(r8, "dialog");
        this.f7035d = r8;
    }
}
