package xka;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.provider.CalendarContract;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a implements vka.b<Unit> {
    public static final /* synthetic */ int i = 0;
    public final long a;
    public final String b;
    public final String c;
    public final Integer d;
    public final Integer e;
    public final Integer f;
    public final String g;
    public final String h;

    /* JADX INFO: renamed from: xka.a$a, reason: collision with other inner class name */
    public static final class C0075a {
    }

    static {
    }

    @Override // vka.b
    public final Object execute() {
        Intrinsics.checkNotNullParameter(vka.f.a, "context");
        ContentValues r1 = new ContentValues();
        r1.put("event_id", Long.valueOf(this.a));
        r1.put("attendeeName", this.b);
        r1.put("attendeeEmail", this.c);
        r1.put("attendeeRelationship", this.d);
        r1.put("attendeeType", this.e);
        r1.put("attendeeStatus", this.f);
        r1.put("attendeeIdentity", this.g);
        r1.put("attendeeIdNamespace", this.h);
        ContentResolver r2 = vka.f.d();
        Uri r3 = CalendarContract.Attendees.CONTENT_URI;
        ArrayList r12 = new ArrayList();
        Object[] r13 = {r3, r1};
        f06.b r15 = new f06.b();
        g06.a r4 = (g06.a) ApiHookConfig.b.get(240017);
        if (r4 == null) goto L5;
        f06.a[] r5 = r4.i;
    L6:
        f06.a[] r11 = r5;
        int r10 = r11.length;
        int r9 = 0;
    L8:
        if (r9 >= r10) goto L15;
        f06.a r8 = r11[r9];
        int r19 = r9;
        int r20 = r10;
        f06.a[] r21 = r11;
        f06.d r6 = r8.preInvoke(240017, "android/content/ContentResolver", "insert", r2, r13, "android.net.Uri", r15);     // Catch: Exception -> L22
        if (r6.a == true) goto L17;
        r12.add(r8);     // Catch: Exception -> L22
    L17:
        if (r6.a == false) goto L19;
        Uri r7 = (Uri) r6.b;
    L21:
        return Unit.INSTANCE;
    L19:
        r2.insert(r3, r1);
    L14:
        r9 = r19 + 1;
        r10 = r20;
        r11 = r21;
        goto L8
    L15:
        r6 = new f06.d(false, null);
        goto L17
    L5:
        r5 = ApiHookConfig.d;
        goto L6
    }

    public a(long r1, String r3, String r4, Integer r5, Integer r6, Integer r7, String r8, String r9) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
