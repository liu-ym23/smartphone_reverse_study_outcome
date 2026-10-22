package al;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import android.view.View;
import com.bumptech.glide.load.engine.d0;
import com.bumptech.glide.load.resource.bitmap.v;
import com.bytedance.forest.utils.d;
import com.bytedance.ies.xelement.input.h;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.LynxTemplateRender;
import com.lynx.tasm.NativeFacade;
import com.lynx.tasm.core.JSProxy;
import com.lynx.tasm.core.LynxEngineProxy;
import com.lynx.tasm.f0;
import com.lynx.tasm.utils.g;
import com.lynx.tasm.utils.j;
import com.obric.oui.calendar.CalendarDay;
import com.obric.oui.calendar.e;
import com.obric.oui.constraintlayout.widget.R$styleable;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import lr.n;
import lr.o;
import org.threeten.bp.Period;
import org.xmlpull.v1.XmlPullParserException;
import z.f;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Callback, e, j0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f314b;

    public /* synthetic */ a(Object r5, int r10) {
        this.f314b = r5;
        this.f313a = r10;
    }

    @Override // com.obric.oui.calendar.e
    public int a(CalendarDay r5) {
        return (int) Period.between(((CalendarDay) this.f314b).f12167a.withDayOfMonth(1), r5.f12167a.withDayOfMonth(1)).toTotalMonths();
    }

    public int b(String r12) {
        monitor-enter(this);
        int r5 = this.f313a - 1;     // Catch: Throwable -> L7
        this.f313a = r5;     // Catch: Throwable -> L7
        d.b((d) this.f314b, 3, "Concurrent", "#" + r12 + ", decrement reference to:" + r5 + ", stack=" + Arrays.toString(Thread.currentThread().getStackTrace()), false, null, null, 56);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r5;
    L7:
        th = move-exception;
        throw th;
    }

    public void c(fr.b r5) {
        int r10 = this.f313a;
        Object[] r11 = (Object[]) this.f314b;
        if (r10 >= r11.length) goto L6;
        r11[r10] = r5;
        this.f313a = r10 + 1;
        return;
    }

    public int d(int r5) {
        float r10 = -1;
        SparseArray r11 = (SparseArray) this.f314b;
        int r12 = 0;
        if ((-1) != r5) goto L22;
        if (r5 != (-1)) goto L6;
        n r13 = (n) r11.valueAt(0);
    L7:
        if (r13 == null) goto L40;
    L9:
        ArrayList r14 = r13.f19775b;
        if (r12 >= r14.size()) goto L15;
        if (((o) r14.get(r12)).a(r10, r10) == true) goto L16;
        r12 = r12 + 1;
    L16:
        if ((-1) == r12) goto L41;
        if (r12 != (-1)) goto L21;
        int r15 = r13.f19776c;
    L35:
        return r15;
    L21:
        r15 = ((o) r13.f19775b.get(r12)).e;
        goto L35
    L41:
        return -1;
    L15:
        r12 = -1;
        goto L16
    L40:
        return -1;
    L6:
        r13 = (n) r11.get(-1);
        goto L7
    L22:
        n r16 = (n) r11.get(r5);
        if (r16 == null) goto L42;
    L25:
        ArrayList r17 = r16.f19775b;
        if (r12 >= r17.size()) goto L31;
        if (((o) r17.get(r12)).a(r10, r10) == true) goto L32;
        r12 = r12 + 1;
    L32:
        if (r12 != (-1)) goto L34;
        r15 = r16.f19776c;
        goto L35
    L34:
        r15 = ((o) r16.f19775b.get(r12)).e;
        goto L35
    L31:
        r12 = -1;
        goto L32
    L42:
        return -1;
    }

    @Override // j0.a
    public d0 e(d0 r5, f r10) {
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();
        ((Bitmap) r5.get()).compress((Bitmap.CompressFormat) this.f314b, this.f313a, r11);
        r5.recycle();
        return new v(r11.toByteArray());
    }

    public void f(Context r5, int r10, String r11, boolean r12, View r13) {
        if (this.f313a >= 2) goto L17;
        ps.a.a("SeekBarVibrateHelper", Intrinsics.stringPlus("vibrateIfNeeded: ", r11));
        if (r12 == false) goto L7;
        g.p(r10, r5);
    L13:
        this.f313a++;
        return;
    L7:
        if (r13 == null) goto L13;
        r13.performHapticFeedback(r10);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        ps.a.c("VibratorSmt", Intrinsics.stringPlus("performHapticFeedbackAOSP error: ", e));
        goto L13
    }

    @Override // com.obric.oui.calendar.e
    public int getCount() {
        return this.f313a;
    }

    @Override // com.obric.oui.calendar.e
    public CalendarDay getItem(int r5) {
        return CalendarDay.c(((CalendarDay) this.f314b).f12167a.plusMonths(r5));
    }

    @Override // com.lynx.react.bridge.Callback
    public void invoke(Object... r5) {
        int r10 = this.f313a;
        if (r10 < 0) goto L23;
        JavaOnlyMap r11 = new JavaOnlyMap();
        r11.putInt("code", ((Integer) r5[0]).intValue());
        if (r5.length <= 1) goto L8;
        r11.put("data", r5[1]);
    L8:
        f0 r12 = ((NativeFacade) this.f314b).f10047a;
        if (r12 == null) goto L20;
        LynxTemplateRender r13 = r12.f10842a;
        if (r13.W == true) goto L13;
        JSProxy r14 = r13.X;
        if (r14 == null) goto L22;
        r14.c(r10, r11);
        return;
    L22:
        return;
    L13:
        if (r13.Z == null) goto L21;
        ByteBuffer r15 = kn.b.b(r11);
        LynxEngineProxy r16 = r13.Z;
        r16.getClass();
        j.f(new h(r16, r10, "__Card__", r15));
        return;
    L21:
        return;
    L20:
        return;
    }

    public a(Context r12, XmlResourceParser r13) {
        this.f313a = -1;
        this.f314b = new SparseArray();
        TypedArray r5 = r12.obtainStyledAttributes(Xml.asAttributeSet(r13), R$styleable.StateSet);
        int r10 = r5.getIndexCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        int r14 = r5.getIndex(r11);
        if (r14 != R$styleable.StateSet_defaultState) goto L7;
        this.f313a = r5.getResourceId(r14, this.f313a);
    L7:
        r11 = r11 + 1;
        goto L3
    L8:
        r5.recycle();
        int r15 = r13.getEventType();     // Catch: IOException -> L20 XmlPullParserException -> L22
        n r16 = null;
    L11:
        byte r17 = 1;
        if (r15 == 1) goto L67;
        if (r15 == 2) goto L24;
        if (r15 != 3) goto L47;
        if ("StateSet".equals(r13.getName()) == false) goto L47;
        return;
    L47:
        r15 = r13.next();     // Catch: IOException -> L20 XmlPullParserException -> L22
        goto L11
    L24:
        String r18 = r13.getName();     // Catch: IOException -> L20 XmlPullParserException -> L22
        switch(r18.hashCode()) {
            case 80204913: goto L37;
            case 1301459538: goto L34;
            case 1382829617: goto L31;
            case 1901439077: goto L28;
            default: goto L39;
        };     // Catch: IOException -> L20 XmlPullParserException -> L22
    L39:
        r17 = -1;
    L40:
        if (r17 == 2) goto L46;
        if (r17 != 3) goto L47;
        o r19 = new o(r12, r13);     // Catch: IOException -> L20 XmlPullParserException -> L22
        if (r16 == null) goto L47;
        r16.f19775b.add(r19);     // Catch: IOException -> L20 XmlPullParserException -> L22
        goto L47
    L46:
        r16 = new n(r12, r13);     // Catch: IOException -> L20 XmlPullParserException -> L22
        ((SparseArray) this.f314b).put(r16.f19774a, r16);     // Catch: IOException -> L20 XmlPullParserException -> L22
        goto L47
    L28:
        if (r18.equals("Variant") == false) goto L39;
        r17 = 3;
        goto L40
    L31:
        if (r18.equals("StateSet") == false) goto L39;
    L34:
        if (r18.equals("LayoutDescription") == false) goto L39;
        r17 = 0;
        goto L40
    L37:
        if (r18.equals("State") == false) goto L39;
        r17 = 2;
        goto L40
    L67:
        return;
    L20:
        e = move-exception;
        Log.e("ConstraintLayoutStates", "Error parsing XML resource", e);
        return;
    L22:
        e = move-exception;
        Log.e("ConstraintLayoutStates", "Error parsing XML resource", e);
    }

    public a(int r5) {
        switch(r5) {
            case 7: goto L5;
            default: goto L3;
        };
    L3:
        this.f314b = new Object[256];
        return;
    L5:
        this.f314b = Bitmap.CompressFormat.JPEG;
        this.f313a = 100;
    }
}
