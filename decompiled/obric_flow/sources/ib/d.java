package ib;

import android.content.Context;
import android.os.Message;
import android.util.Log;
import com.obric.oui.slider.TickMarkSeekBar;
import g8.f;
import kotlin.jvm.internal.Intrinsics;
import l9.r;
import obric.flow.miniappwidget.MiniAppWidgetRuntimeValidity;
import obric.flow.miniappwidget.o;
import org.threeten.bp.LocalDate;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.i;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements de.d, mi.c, g8.b, ja.b, r, i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17567a;

    public /* synthetic */ d(int r5) {
        this.f17567a = r5;
    }

    public static final String e(int r5) {
        int r10 = TickMarkSeekBar.W;
        if (r5 != 0) goto L5;
        return "DOWN";
    L5:
        if (r5 != 1) goto L7;
        return "UP";
    L7:
        if (r5 != 2) goto L9;
        return "MOVE";
    L9:
        if (r5 != 3) goto L11;
        return "CANCEL";
    L11:
        if (r5 != 5) goto L13;
        return "POINTER_DOWN";
    L13:
        if (r5 != 6) goto L22;
        return "POINTER_UP";
    L22:
        return String.valueOf(r5);
    }

    public static o f(String r10) {
        return new o(MiniAppWidgetRuntimeValidity.INVALID, null, r10, null, false);
    }

    @Override // g8.b
    public void a() {
        f.f17068a.l(f.f17070c, 1);
    }

    @Override // g8.b
    public void b() {
        f.f17068a.l(f.f17070c, 2);
    }

    @Override // l9.r
    public boolean c(Object r5, Runnable r10) {
        Message r11 = (Message) r5;
        if (r10 != null) goto L10;
        if (r11 != null) goto L6;
    L9:
        return true;
    L6:
        if (r11.getCallback() == null) goto L9;
        return false;
    L10:
        if (r11 != null) goto L12;
    L14:
        return false;
    L12:
        if (r10.equals(r11.getCallback()) == false) goto L14;
        return true;
    }

    @Override // org.threeten.bp.temporal.i
    public Object d(org.threeten.bp.temporal.d r5) {
        switch(this.f17567a) {
            case 14: goto L10;
            default: goto L4;
        };
    L4:
        ChronoField r10 = ChronoField.EPOCH_DAY;
        if (r5.isSupported(r10) == true) goto L11;
        return null;
    L11:
        return LocalDate.ofEpochDay(r5.getLong(r10));
    L10:
        return OffsetDateTime.from(r5);
    }

    public d(Integer r5) {
        this.f17567a = 5;
    }

    @Override // mi.c
    public void a(mi.a r5) {
        Intrinsics.checkNotNullParameter(r5, "reportInfo");
        Log.i("XBridge-auth", r5.toString());
    }

    @Override // ja.b
    public boolean b(Context r5) {
        return false;
    }
}
