package defpackage;

import android.net.Uri;
import android.os.RemoteException;
import com.obric.cae.log.CaeLog;
import com.qti.extphone.Token;
import com.sdk.bwdl.StateMachine.ControlLinkSM;
import com.sdk.bwdl.Utils.BWDLLog;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b {
    public static int a(int r8, int r10, int r11, int r12) {
        return ((r8 * r10) + r11) * r12;
    }

    public static String b(String r8, Uri r10) {
        return r8 + r10;
    }

    public static String c(String r8, String r10) {
        return r8 + r10;
    }

    public static String d(String r8, String r10, String r11) {
        return r8 + r10 + r11;
    }

    public static String e(String r8, String r10, String r11, String r12) {
        return r8 + r10 + r11 + r12;
    }

    public static StringBuilder f(String r8, int r10, String r11) {
        StringBuilder r12 = new StringBuilder(r8);
        r12.append(r10);
        r12.append(r11);
        return r12;
    }

    public static StringBuilder g(String r8, int r10, String r11, Token r12, String r13) {
        StringBuilder r14 = new StringBuilder(r8);
        r14.append(r10);
        r14.append(r11);
        r14.append(r12);
        r14.append(r13);
        return r14;
    }

    public static StringBuilder h(String r8, String r10, String r11) {
        StringBuilder r12 = new StringBuilder(r8);
        r12.append(r10);
        r12.append(r11);
        return r12;
    }

    public static StringBuilder i(String r8, String r10, String r11, String r12, String r13) {
        StringBuilder r14 = new StringBuilder(r8);
        r14.append(r10);
        r14.append(r11);
        r14.append(r12);
        r14.append(r13);
        return r14;
    }

    public static void j(int r8, StringBuilder r10, String r11) {
        r10.append(ControlLinkSM.access$500(r8));
        BWDLLog.d(r11, r10.toString());
    }

    public static void k(Exception r8, StringBuilder r10, String r11) {
        r10.append(r8.getMessage());
        CaeLog.e(r11, r10.toString());
    }

    public static /* synthetic */ void l(Object r8) {
        if (r8 != null) goto L5;
        return;
    L5:
        throw new ClassCastException();
    }

    public static void m(String r8, int r10, String r11) {
        CaeLog.d(r11, r8 + r10);
    }

    public static void n(String r8, RemoteException r10, String r11) {
        CaeLog.e(r11, r8 + r10);
    }

    public static void o(String r8, String r10, String r11) {
        CaeLog.d(r11, r8 + r10);
    }

    public static void p(StringBuilder r8, int r10, String r11) {
        r8.append(r10);
        CaeLog.i(r11, r8.toString());
    }

    public static void q(StringBuilder r8, int r10, String r11, int r12, String r13) {
        r8.append(r10);
        r8.append(r11);
        r8.append(r12);
        r8.append(r13);
    }
}
