package android.aimedia;

import android.content.res.Resources;
import android.os.Parcel;
import android.util.TypedValue;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.cae.log.CaeLog;
import com.sdk.bwdl.StateMachine.DataLinkSM;
import com.sdk.bwdl.Utils.BWDLLog;
import he.i;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import ue.o;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a {
    public static int a(String r8, int r10, float r11) {
        Resources r12 = Resources.getSystem();
        i.e(r12, r8);
        return l6.a.I0(TypedValue.applyDimension(r10, r11, r12.getDisplayMetrics()));
    }

    public static String b(RecyclerView r8, StringBuilder r10) {
        r10.append(r8.exceptionLabel());
        return r10.toString();
    }

    public static String c(String r8, int r10, String r11) {
        return r8 + r10 + r11;
    }

    public static String d(String r8, long r10) {
        return r8 + r10;
    }

    public static String e(String r8, Fragment r10, String r11) {
        return r8 + r10 + r11;
    }

    public static String f(StringBuilder r8, int r10, char r11) {
        r8.append(r10);
        r8.append(r11);
        return r8.toString();
    }

    public static String g(StringBuilder r8, int r10, int r11, String r12, char r13) {
        StringBuilder r14 = r8.replace(r10, r11, r12);
        r14.append(r13);
        return r14.toString();
    }

    public static String h(StringBuilder r8, int r10, String r11) {
        r8.append(r10);
        r8.append(r11);
        return r8.toString();
    }

    public static String i(StringBuilder r8, String r10, String r11) {
        r8.append(r10);
        r8.append(r11);
        return r8.toString();
    }

    public static StringBuilder j(String r8) {
        StringBuilder r10 = new StringBuilder();
        r10.append(r8);
        return r10;
    }

    public static StringBuilder k(String r8, String r10) {
        StringBuilder r11 = new StringBuilder();
        r11.append(r8);
        r11.append(r10);
        return r11;
    }

    public static StringBuilder l(String r8, boolean r10, String r11) {
        StringBuilder r12 = new StringBuilder(r8);
        r12.append(r10);
        r12.append(r11);
        return r12;
    }

    public static /* synthetic */ Iterator m() {
        return Arrays.asList(new o[]{new qe.a()}).iterator();
    L5:
        th = move-exception;
        throw new ServiceConfigurationError(th.getMessage(), th);
    }

    public static void n(int r8, int r10, Parcel r11, int r12) {
        r11.writeInt(r8 - r10);
        r11.setDataPosition(r12);
    }

    public static void o(DataLinkSM r8, StringBuilder r10, String r11) {
        r10.append(DataLinkSM.access$200(r8));
        BWDLLog.d(r11, r10.toString());
    }

    public static void p(String r8, int r10, String r11) {
        CaeLog.e(r11, r8 + r10);
    }

    public static void q(String r8, Exception r10, String r11) {
        CaeLog.e(r11, r8 + r10);
    }

    public static void r(StringBuilder r8, String r10, String r11) {
        r8.append(r10);
        CaeLog.i(r11, r8.toString());
    }

    public static void s(Throwable r8, StringBuilder r10, String r11) {
        r10.append(r8.getMessage());
        CaeLog.w(r11, r10.toString());
    }
}
