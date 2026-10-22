package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class AlertController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Window f537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CharSequence f538d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RecycleListView f539e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Button f540f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Button f541g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Button f542h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public NestedScrollView f543i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f544j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Drawable f545k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ImageView f546l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f547m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TextView f548n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f549o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ListAdapter f550p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f551q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f552r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f553s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f554t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f555u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f556v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final c f557w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final a f558x;

    public static class RecycleListView extends ListView {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f559a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f560b;

        public RecycleListView(Context r8, AttributeSet r10) {
            super(r8, r10);
            TypedArray r11 = r8.obtainStyledAttributes(r10, c.a.f3234t);
            this.f560b = r11.getDimensionPixelOffset(0, -1);
            this.f559a = r11.getDimensionPixelOffset(1, -1);
        }
    }

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AlertController f561a;

        public a(AlertController r8) {
            this.f561a = r8;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r8) {
            AlertController r10 = this.f561a;
            Button r11 = r10.f540f;
            Button r12 = r10.f541g;
            Button r13 = r10.f542h;
            o r14 = r10.f536b;
            r10.f557w.obtainMessage(1, r14).sendToTarget();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f562a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LayoutInflater f563b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Drawable f564c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public CharSequence f565d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public View f566e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public DialogInterface.OnKeyListener f567f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ListAdapter f568g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public DialogInterface.OnClickListener f569h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f570i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f571j;

        public b(ContextThemeWrapper r8) {
            this.f571j = -1;
            this.f562a = r8;
            this.f563b = (LayoutInflater) r8.getSystemService("layout_inflater");
        }
    }

    public static final class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<DialogInterface> f572a;

        public c(DialogInterface r8) {
            this.f572a = new WeakReference(r8);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r8) {
            int r10 = r8.what;
            if (r10 != (-3)) goto L5;
        L12:
            ((DialogInterface.OnClickListener) r8.obj).onClick(this.f572a.get(), r8.what);
            return;
        L5:
            if (r10 == (-2)) goto L12;
            if (r10 == (-1)) goto L12;
            if (r10 != 1) goto L15;
            ((DialogInterface) r8.obj).dismiss();
            return;
        }
    }

    public static class d extends ArrayAdapter<CharSequence> {
        public d(Context r8, int r10) {
            super(r8, r10, R.id.text1, null);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public final long getItemId(int r8) {
            return r8;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public final boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context r8, o r10, Window r11) {
        this.f544j = 0;
        this.f551q = -1;
        this.f558x = new a(this);
        this.f535a = r8;
        this.f536b = r10;
        this.f537c = r11;
        this.f557w = new c(r10);
        TypedArray r12 = r8.obtainStyledAttributes(null, c.a.f3219e, com.obric.cae.R.attr.alertDialogStyle, 0);
        this.f552r = r12.getResourceId(0, 0);
        r12.getResourceId(2, 0);
        this.f553s = r12.getResourceId(4, 0);
        r12.getResourceId(5, 0);
        this.f554t = r12.getResourceId(7, 0);
        this.f555u = r12.getResourceId(3, 0);
        this.f556v = r12.getBoolean(6, true);
        r12.getDimensionPixelSize(1, 0);
        r12.recycle();
        r10.b().w(1);
    }

    public static ViewGroup a(View r8, View r10) {
        if (r8 == null) goto L4;
        if (r10 == null) goto L13;
        ViewParent r11 = r10.getParent();
        if ((r11 instanceof ViewGroup) == false) goto L13;
        ((ViewGroup) r11).removeView(r10);
    L13:
        if ((r8 instanceof ViewStub) == false) goto L16;
        r8 = ((ViewStub) r8).inflate();
    L16:
        return (ViewGroup) r8;
    L4:
        if ((r10 instanceof ViewStub) == false) goto L7;
        r10 = ((ViewStub) r10).inflate();
    L7:
        return (ViewGroup) r10;
    }
}
