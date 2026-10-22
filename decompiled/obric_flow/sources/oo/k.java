package oo;

import android.content.Context;
import android.net.Uri;
import androidx.room.writer.DaoWriter;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f20817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20818b;

    public k(Context r5, String r10) {
        this.f20818b = r10;
        Uri r11 = Uri.parse(r10);     // Catch: Exception -> L7
        if (r11.getScheme() != null) goto L8;
        r11 = b(r5);     // Catch: Exception -> L7
    L8:
        this.f20817a = r11;
        return;
    L7:
        r11 = b(r5);
        goto L8
    }

    public final Uri a() {
        Uri r5 = this.f20817a;
        if (r5 == null) goto L6;
        return r5;
    L6:
        throw new AssertionError();
    }

    public final Uri b(Context r5) {
        if (l.f20819b == null) goto L5;
    L15:
        l r10 = l.f20819b;
        String r11 = this.f20818b;
        r10.getClass();
        if (r11 != null) goto L18;
    L36:
        int r12 = 0;
    L37:
        if (r12 <= 0) goto L40;
        return new Uri.Builder().scheme("res").path(String.valueOf(r12)).build();
    L40:
        return Uri.EMPTY;
    L18:
        if (r11.isEmpty() == true) goto L36;
        String r13 = r11.toLowerCase().replace(DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD, "_");
        r12 = Integer.parseInt(r13);     // Catch: NumberFormatException -> L23
    L23:
        monitor-enter(r10);
    L29:
        th = move-exception;
        throw th;
    L25:
        if (r10.f20820a.containsKey(r13) == false) goto L31;
        r12 = ((Integer) r10.f20820a.get(r13)).intValue();     // Catch: Throwable -> L29
    L41:
        goto L37
    L31:
        int r14 = r5.getResources().getIdentifier(r13, "drawable", r5.getPackageName());     // Catch: Throwable -> L29
        r10.f20820a.put(r13, Integer.valueOf(r14));     // Catch: Throwable -> L29
        r12 = r14;
        goto L41
    L5:
        monitor-enter(l.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (l.f20819b != null) goto L11;
        l.f20819b = new l(0);     // Catch: Throwable -> L9
    L11:
        monitor-exit(l.class);     // Catch: Throwable -> L9
        goto L15
    }
}
