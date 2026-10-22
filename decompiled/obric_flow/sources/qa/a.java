package qa;

import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.utils.d;
import com.bytedance.iesgurd.core.EventSubType;
import com.lynx.tasm.utils.j;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Result;
import kotlin.ResultKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f21497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f21498c;
    public volatile File d;
    public volatile Long e;
    public volatile i4.a f;
    public final AtomicBoolean g;

    public a(String r5, String r10, String r11) {
        this.g = new AtomicBoolean(false);
        this.f21496a = r5;
        this.f21497b = r10;
        this.f21498c = r11;
    }

    public final synchronized File a(String r10) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.d == null) goto L11;
        File r11 = this.d;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r11;
    L11:
        if (this.e != null) goto L15;
        this.e = d.a(new File(this.f21497b, r10));     // Catch: Throwable -> L8
    L15:
        if (this.e != null) goto L18;
        monitor-exit(this);
        return null;
    L18:
        String r12 = this.f21497b + File.separator + this.f21498c;     // Catch: Throwable -> L8
        AtomicBoolean r5 = this.g;     // Catch: Throwable -> L8
        LinkedHashMap r13 = ra.b.f21714a;     // Catch: Throwable -> L8
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L24
        ra.a r15 = ra.b.a(r12);     // Catch: Throwable -> L24
        r15.f21713c.lock();     // Catch: Throwable -> L29
        if (r15.f21712b == false) goto L26;
        ReentrantLock r16 = r15.f21713c;     // Catch: Throwable -> L24
        boolean r17 = false;
    L28:
        r16.unlock();     // Catch: Throwable -> L24
        Object r18 = Result.m124constructorimpl(Boolean.valueOf(r17));     // Catch: Throwable -> L24
    L33:
        Boolean r19 = Boolean.FALSE;     // Catch: Throwable -> L8
        if (Result.m130isFailureimpl(r18) == false) goto L36;
        r18 = r19;
    L36:
        r5.set(((Boolean) r18).booleanValue());     // Catch: Throwable -> L8
        EventSubType r20 = EventSubType.f6611r;     // Catch: Throwable -> L8
        String r21 = this.f21496a;     // Catch: Throwable -> L8
        String r22 = this.f21498c;     // Catch: Throwable -> L8
        JSONObject r23 = new JSONObject();     // Catch: Throwable -> L8
        r23.put("sub_type", r20.f6615a);     // Catch: Throwable -> L8
        if (r21 == null) goto L39;
        r23.put("access_key", r21);     // Catch: Throwable -> L8
    L39:
        if (r22 == null) goto L41;
        r23.put("channels", r22);     // Catch: Throwable -> L8
    L41:
        r23.put("err_msg", "");     // Catch: Throwable -> L8
        j.g("geckosdk_event_message", r23);     // Catch: Throwable -> L8
        if (this.g.get() == false) goto L46;
        this.d = new File(r12, String.valueOf(this.e));     // Catch: Throwable -> L8
        File r24 = this.d;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r24;
    L46:
        monitor-exit(this);
        return null;
    L26:
        r15.f21711a++;     // Catch: Throwable -> L29
        r16 = r15.f21713c;     // Catch: Throwable -> L24
        r17 = true;
        goto L28
    L29:
        th = move-exception;
        r15.f21713c.unlock();     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L8
        r18 = Result.m124constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L8
        goto L33
    }

    public final void b() {
        if (this.f == null) goto L6;
        this.f.getClass();
    L6:
        if (this.g.compareAndSet(true, false) == false) goto L17;
        String r5 = this.f21497b + File.separator + this.f21498c;
        ra.b.c(r5);
        EventSubType r10 = EventSubType.s;
        String r11 = this.f21496a;
        String r12 = this.f21498c;
        JSONObject r13 = new JSONObject();
        r13.put("sub_type", r10.f6615a);
        if (r11 == null) goto L10;
        r13.put("access_key", r11);
    L10:
        if (r12 == null) goto L12;
        r13.put("channels", r12);
    L12:
        r13.put("err_msg", "");
        if (0 == 0) goto L15;
        r13.put("duration", 0);
    L15:
        j.g("geckosdk_event_message", r13);
        dn.a.L(r5, null);
        return;
    }

    public final void finalize() {
        super.finalize();
        GeckoLogger.a("channel loader finalize lock");
        b();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        GeckoLogger.a("finalize:", th);
    }
}
