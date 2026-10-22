package dv1;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.room.api.record.LiveRecordMonitorServiceWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.experience.record.FromType;
import com.bytedance.bpea.entry.common.DataType;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.HashSet;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b extends ContentObserver {
    public final /* synthetic */ a a;
    public final /* synthetic */ c b;

    @Override // android.database.ContentObserver
    public final void onChange(boolean r23, Uri r24) {
        String[] r0 = a.g;
        ALogger.d("ScreenRecordMonitorService", "Media content changed: " + r24);
        if (r24 == null) goto L7;
        String r1 = r24.toString();
        if (r1 == null) goto L7;
        String r2 = r1.toLowerCase();
    L8:
        if (r2 == null) goto L86;
        boolean r6 = false;
        if (StringsKt.contains$default(r2, DataType.VIDEO, false, 2, null) != true) goto L87;
        a r8 = this.a;
        c r9 = this.b;
        if (r8.b() == true) goto L82;
        ALogger.w("ScreenRecordMonitorService", "Cannot check screen recording: missing storage permission");
        return;
    L82:
        Context r3 = r8.f.get();     // Catch: Exception -> L77
        if (r3 == null) goto L18;
        ContentResolver r4 = r3.getContentResolver();     // Catch: Exception -> L77
    L20:
        if (r4 == null) goto L22;
        Cursor r14 = a.a(r4, r24, new String[]{"_data", "date_added", "_size", "_display_name"});     // Catch: Exception -> L77
    L23:
        if (r14 != null) goto L25;
        return;
    L25:
        if (r14.moveToFirst() == false) goto L90;
        int r5 = r14.getColumnIndex("_data");     // Catch: Exception -> L77
        int r11 = r14.getColumnIndex("_size");     // Catch: Exception -> L77
        int r12 = r14.getColumnIndex("date_added");     // Catch: Exception -> L77
        int r10 = r14.getColumnIndex("_display_name");     // Catch: Exception -> L77
        if (r5 == (-1)) goto L75;
        if (r12 == (-1)) goto L75;
        if (r10 == (-1)) goto L75;
        String r7 = r14.getString(r5);     // Catch: Exception -> L77
        if (r7 == null) goto L74;
        String r15 = r7.toLowerCase();     // Catch: Exception -> L77
        String r13 = r14.getString(r10);     // Catch: Exception -> L77
        if (r13 == null) goto L72;
        String r16 = r13.toLowerCase();     // Catch: Exception -> L77
        long r17 = r14.getLong(r12);     // Catch: Exception -> L77
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L38
        Object r19 = Result.constructor-impl(Long.valueOf(r14.getLong(r11)));     // Catch: Throwable -> L38
    L41:
        if (Result.isFailure-impl(r19) == false) goto L43;
        r19 = 0L;
    L43:
        long r110 = ((Number) r19).longValue();     // Catch: Exception -> L77
        if (((System.currentTimeMillis() / ((long) BubbleId.PadCast)) - r17) > 30) goto L75;
        String[] r20 = a.g;     // Catch: Exception -> L77
        int r21 = r20.length;     // Catch: Exception -> L77
        int r22 = 0;
    L46:
        if (r22 >= r21) goto L54;
        String r111 = r20[r22];     // Catch: Exception -> L77
        if (StringsKt.contains$default(r15, r111, false, 2, null) == true) goto L53;
        if (StringsKt.contains$default(r16, r111, false, 2, null) == true) goto L53;
        r22 = r22 + 1;     // Catch: Exception -> L77
    L53:
        r6 = true;
    L54:
        if (r6 == false) goto L75;
        if (r110 != 0) goto L66;
        if (FileUtils.getFileSize(r15) > 0) goto L66;
        if (((HashSet) r8.d).contains(r24.toString()) == true) goto L75;
        Intrinsics.areEqual(ThreadMethodProxy.getLooperThread(Looper.getMainLooper()), ThreadMethodProxy.currentThread());     // Catch: Exception -> L77
        r9.a(FromType.ContentResolver);     // Catch: Exception -> L77
        Set<String> r25 = r8.d;     // Catch: Exception -> L77
        String r26 = r24.toString();     // Catch: Exception -> L77
        HashSet r27 = (HashSet) r25;     // Catch: Exception -> L77
        if (r27.size() <= 200) goto L64;
        r27.clear();     // Catch: Exception -> L77
    L64:
        r27.add(r26);     // Catch: Exception -> L77
    L66:
        if (((HashSet) r8.e).contains(r24.toString()) == true) goto L75;
        Intrinsics.areEqual(ThreadMethodProxy.getLooperThread(Looper.getMainLooper()), ThreadMethodProxy.currentThread());     // Catch: Exception -> L77
        r9.b(FromType.ContentResolver, r15, ((HashSet) r8.d).contains(r24.toString()));     // Catch: Exception -> L77
        Set<String> r28 = r8.e;     // Catch: Exception -> L77
        String r29 = r24.toString();     // Catch: Exception -> L77
        HashSet r30 = (HashSet) r28;     // Catch: Exception -> L77
        if (r30.size() <= 200) goto L70;
        r30.clear();     // Catch: Exception -> L77
    L70:
        r30.add(r29);     // Catch: Exception -> L77
    L38:
        th = move-exception;
        Result.Companion r112 = Result.Companion;     // Catch: Exception -> L77
        r19 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Exception -> L77
        goto L41
    L72:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Exception -> L77
    L74:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Exception -> L77
    L75:
        r14.close();     // Catch: Exception -> L77
        return;
    L90:
        return;
    L22:
        r14 = null;
        goto L23
    L18:
        r4 = null;
    L77:
        e = move-exception;
        ALogger.e("ScreenRecordMonitorService", "Error checking screen recording: " + e.getMessage());
        return;
    L87:
        return;
    L86:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public b(a r1, LiveRecordMonitorServiceWidget.a r2, Handler r3) {
        this.a = r1;
        this.b = r2;
        super(r3);
    }
}
