package com.obric.aikernel;

import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.bytedance.crash.event.EnsureReportData;
import com.obric.aikernel.middleware.api.alog.ALogManager;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.multiusr.BaseMultiUsrProvider;
import com.obric.aikernel.tob.api.IToBStrategyManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.h;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
public class AuthProvider extends BaseMultiUsrProvider {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f4381g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f4382h;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AuthProvider() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    public AuthProvider(String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "usr0Auth");
        this.f4381g = r10;
        this.f4382h = r11;
    }

    public /* synthetic */ AuthProvider(String r10, boolean r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = "com.obric.aikernel.service.auth.multiuser";
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = true;
    L8:
        this(r10, r11);
    }

    private final boolean e(Context r10) {
        int r11 = Binder.getCallingUid();
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L20
        Integer r13 = Integer.valueOf(r11);     // Catch: Throwable -> L20
        if (r13.intValue() < 0) goto L6;
        boolean r14 = true;
    L7:
        if (r14 == true) goto L10;
        r13 = null;
    L10:
        if (r13 == null) goto L14;
        r13.intValue();     // Catch: Throwable -> L20
        if (c.f4477a.a(r10) != true) goto L14;
        boolean r15 = true;
    L15:
        if (r15 == true) goto L18;
        AIKLog.INSTANCE.i("AuthService", "checkCallerAuth disallowed from " + r11);     // Catch: Throwable -> L20
        return false;
    L18:
        Object r16 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L22:
        Throwable r17 = Result.m35exceptionOrNullimpl(r16);
        if (r17 == null) goto L26;
        AIKLog.INSTANCE.i("AuthService", "checkCallerAuth from " + r11 + " error: " + r17);
        return false;
    L26:
        return true;
    L14:
        r15 = false;
        goto L15
    L6:
        r14 = false;
    L20:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r16 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L22
    }

    private final IBinder f(Context r10, Intent r11) {
        IToBStrategyManager r12 = h8.a.a();
        if (r12 == null) goto L5;
        r12.handleAIKServiceOnBind(r10, r11);
    L5:
        f r13 = f.f4481a;
        Context r14 = r10.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r14, "context.applicationContext");
        InferServiceWrapper r15 = r13.a(r14);
        BindResumeDispatcher.f4383a.a(r11);
        return r15;
    }

    @Override // com.obric.aikernel.multiusr.BaseMultiUsrProvider
    public Bundle a(String r11, String r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r11, EnsureReportData.METHOD);
        Context r14 = getContext();
        Object r10 = null;
        if (r14 != null) goto L5;
    L69:
        return null;
    L5:
        if (Intrinsics.areEqual(r11, "onBind") == false) goto L14;
        if (r13 == null) goto L8;
        Intent r15 = (Intent) r13.getParcelable("intent");
    L9:
        IBinder r16 = f(r14, r15);
        if (r16 == null) goto L69;
        Bundle r17 = new Bundle();
        r17.putBinder("binder", r16);
        return r17;
    L8:
        r15 = null;
        goto L9
    L14:
        if (Intrinsics.areEqual(r11, "getALogFiles") == false) goto L69;
        if (r13 == null) goto L18;
        long r18 = r13.getLong("start_time");
    L19:
        if (r13 == null) goto L21;
        long r19 = r13.getLong("end_time");
    L23:
        if (r18 == 0) goto L69;
        if (r19 == 0) goto L69;
        if (r18 >= r19) goto L69;
        AIKLog r110 = AIKLog.INSTANCE;
        r110.v("AuthService", "getALogFiles: " + r18 + " to " + r19);
        List<String> r111 = ALogManager.INSTANCE.getLogFiles();
        if ((!r111.isEmpty()) == true) goto L70;
        r110.i("AuthService", "getALogFiles: log dir is empty!");
        goto L69
    L70:
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L57
        Bundle r113 = new Bundle();     // Catch: Throwable -> L57
        Iterator<T> r114 = r111.iterator();     // Catch: Throwable -> L57
        if (r114.hasNext() == false) goto L56;
        Object r20 = r114.next();     // Catch: Throwable -> L57
    L34:
        if (r114.hasNext() == false) goto L46;
        String r21 = (String) r114.next();     // Catch: Throwable -> L57
        File r22 = new File((String) r20);     // Catch: Throwable -> L57
    L36:
        if (r22 == null) goto L40;
        String r23 = r22.getPath();     // Catch: Throwable -> L57
        Intrinsics.checkNotNullExpressionValue(r23, "f.path");     // Catch: Throwable -> L57
        if (StringsKt.startsWith$default(r21, r23, false, 2, null) == true) goto L40;
        r22 = r22.getParentFile();     // Catch: Throwable -> L57
    L40:
        if (r22 == null) goto L42;
        r20 = r22.getPath();     // Catch: Throwable -> L57
    L43:
        if (r20 == null) goto L44;
        Intrinsics.checkNotNullExpressionValue(r20, "f?.path ?: \"\"");     // Catch: Throwable -> L57
        goto L34
    L44:
        r20 = "";
        goto L34
    L42:
        r20 = null;
        goto L43
    L46:
        String r24 = (String) r20;     // Catch: Throwable -> L57
        AIKLog.INSTANCE.v("AuthService", "getALogFiles: root path: " + r24);     // Catch: Throwable -> L57
        ArrayList r115 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));     // Catch: Throwable -> L57
        Iterator<T> r25 = r111.iterator();     // Catch: Throwable -> L57
    L48:
        if (r25.hasNext() == false) goto L50;
        r115.add(ParcelFileDescriptor.open(new File((String) r25.next()), 268435456));     // Catch: Throwable -> L57
        goto L48
    L50:
        ArrayList<? extends Parcelable> r26 = new ArrayList(r115);     // Catch: Throwable -> L57
        r113.putParcelableArrayList("alog_files_fd", r26);     // Catch: Throwable -> L57
        ArrayList r116 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));     // Catch: Throwable -> L57
        Iterator<T> r117 = r111.iterator();     // Catch: Throwable -> L57
    L52:
        if (r117.hasNext() == false) goto L54;
        r116.add(StringsKt.removePrefix((String) r117.next(), r24));     // Catch: Throwable -> L57
        goto L52
    L54:
        r113.putStringArrayList("alog_files_relative_path", new ArrayList(r116));     // Catch: Throwable -> L57
        h.d(m0.a(z0.b()), null, null, new AuthProvider$callInternal$1$2$1$1(r26, null), 3, null);     // Catch: Throwable -> L57
        Object r118 = Result.m32constructorimpl(r113);     // Catch: Throwable -> L57
    L59:
        Throwable r119 = Result.m35exceptionOrNullimpl(r118);
        if (r119 == null) goto L63;
        AIKLog.INSTANCE.e("AuthService", "getALogFiles error: " + ExceptionsKt.stackTraceToString(r119));
    L63:
        if (Result.m38isFailureimpl(r118) == true) goto L67;
        r10 = r118;
    L67:
        return (Bundle) r10;
    L56:
        throw new UnsupportedOperationException("Empty collection can't be reduced.");     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r118 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L59
    L21:
        r19 = 0;
        goto L23
    L18:
        r18 = 0;
        goto L19
    }

    @Override // com.obric.aikernel.multiusr.BaseMultiUsrProvider
    protected String c() {
        return this.f4381g;
    }

    @Override // com.obric.aikernel.multiusr.BaseMultiUsrProvider, android.content.ContentProvider
    public Bundle call(String r10, String r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, EnsureReportData.METHOD);
        Context r13 = getContext();
        if (r13 != null) goto L5;
        return null;
    L5:
        if (d() == false) goto L10;
        if (e(r13) == true) goto L10;
        return null;
    L10:
        return super.call(r10, r11, r12);
    }

    public boolean d() {
        return this.f4382h;
    }
}
