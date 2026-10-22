package com.bytedance.android.annie.bridge.method.calendar;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.method.abs.CreateCalendarEventResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import e7.f0;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Arrays;
import java.util.concurrent.Callable;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast", name = "createCalendarEvent")
public final class g extends e7.e<f0, CreateCalendarEventResultModel> {
    public static final /* synthetic */ int d = 0;
    public final com.bytedance.android.annie.container.fragment.q a;
    public f0 b;
    public ContentResolver c;

    public static final class a implements com.bytedance.android.annie.bridge.method.permission.b {
        public final /* synthetic */ g a;

        public a(g r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.annie.bridge.method.permission.b
        public final void onRequestPermissionsResult(int r1, String[] r10, int[] r11) {
            Intrinsics.checkNotNullParameter(r10, "permissions");
            Intrinsics.checkNotNullParameter(r11, "grantResults");
            if (com.bytedance.android.annie.bridge.method.permission.c.h(r11) == false) goto L10;
            g r12 = this.a;
            f0 r13 = r12.b;
            if (r13 != null) goto L7;
        L9:
            CreateCalendarEventResultModel r14 = new CreateCalendarEventResultModel();
            r14.a(CreateCalendarEventResultModel.Code.Failed);
            r14.b("create calendar failed!");
            r12.finishWithResult(r14);
            return;
        L7:
            if (r12.c == null) goto L9;
            Intrinsics.checkNotNull(r13);
            ContentResolver r15 = this.a.c;
            Intrinsics.checkNotNull(r15);
            r12.j(r13, r15);
            return;
        L10:
            g r16 = this.a;
            CreateCalendarEventResultModel r17 = new CreateCalendarEventResultModel();
            r17.a(CreateCalendarEventResultModel.Code.NoPermission);
            r17.b("user denied permission");
            r16.finishWithResult(r17);
        }
    }

    public static final class b {
    }

    public static final class c<V> implements Callable {
        public final /* synthetic */ g a;
        public final /* synthetic */ f0 b;
        public final /* synthetic */ ContentResolver c;

        public c(g r1, f0 r10, ContentResolver r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }

        @Override // java.util.concurrent.Callable
        public final Boolean call() {
            g r0 = this.a;
            f0 r10 = this.b;
            ContentResolver r11 = this.c;
            int r12 = g.d;
            r0.getClass();
            String[] r1 = {"sync_data1"};
            boolean r15 = false;
            String[] r14 = {r10.getIdentifier()};
            Uri r13 = CalendarContract.Events.CONTENT_URI;
            f06.c r16 = new f06.c();
            Object[] r17 = {r13, r1, "sync_data1=?", r14, null};
            f06.b r18 = new f06.b();
            f06.d r19 = r16.b(240004, "android/content/ContentResolver", "query", r11, r17, "android.database.Cursor", r18);
            if (r19.a == false) goto L5;
            r16.a(240004, "android/content/ContentResolver", "query", r11, r17, null, r18, false);
            Cursor r20 = (Cursor) r19.b;
        L6:
            if (r20 == null) goto L19;
            Cursor r21 = r20;
            if (r21.getCount() <= 0) goto L11;
            r15 = true;
        L11:
            CloseableKt.closeFinally(r21, null);
        L12:
            th = move-exception;
            throw th;     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            CloseableKt.closeFinally(r21, th);
            throw th;
        L19:
            return Boolean.valueOf(r15);
        L5:
            r20 = r11.query(r13, r1, "sync_data1=?", r14, null);
            r16.a(240004, "android/content/ContentResolver", "query", r11, r17, r20, r18, true);
            goto L6
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ g a;
        public final /* synthetic */ f0 b;
        public final /* synthetic */ ContentResolver c;

        public d(g r1, f0 r10, ContentResolver r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }

        public final void accept(Object r10) {
            Boolean r11 = (Boolean) r10;
            if (Intrinsics.areEqual(r11, Boolean.TRUE) == false) goto L6;
            g r12 = this.a;
            f0 r0 = this.b;
            ContentResolver r1 = this.c;
            r12.getClass();
            Single.fromCallable(new l(r0, r1)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new m(r12), new n(r12, r0));
            return;
        L6:
            if (Intrinsics.areEqual(r11, Boolean.FALSE) == false) goto L10;
            g r13 = this.a;
            f0 r14 = this.b;
            ContentResolver r15 = this.c;
            r13.getClass();
            Single.fromCallable(new h(r14, r15)).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new i(r13), new j(r13));
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public static final e<T> a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r10 = (Throwable) r1;
        }
    }

    static {
    }

    public g(m16.b r10) {
        Intrinsics.checkNotNullParameter(r10, "providerFactory");
        com.bytedance.android.annie.container.fragment.q r0 = this.a;
        if (r0 == null) goto L5;
        r0.registerOnRequestPermissionsCallBack(new a(this));
    L5:
        com.bytedance.android.annie.container.fragment.q r11 = (com.bytedance.android.annie.container.fragment.q) r10.c(com.bytedance.android.annie.container.fragment.q.class);
        if (r11 == null) goto L9;
        this.a = r11;
        return;
    }

    public g(com.bytedance.android.annie.container.fragment.q r10) {
        com.bytedance.android.annie.container.fragment.q r0 = this.a;
        if (r0 == null) goto L5;
        r0.registerOnRequestPermissionsCallBack(new a(this));
    L5:
        this.a = r10;
    }

    public final void invoke(Object r10, CallContext r11) {
        f0 r12 = (f0) r10;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        ContentResolver r0 = r11.getContext().getContentResolver();
        if (r0 != null) goto L5;
        CreateCalendarEventResultModel r13 = new CreateCalendarEventResultModel();
        r13.a(CreateCalendarEventResultModel.Code.Failed);
        r13.b("try to obtain contentResolver, but got a null");
        finishWithResult(r13);
        return;
    L5:
        this.b = r12;
        this.c = r0;
        String[] r1 = {"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"};
        k r14 = null;
        q9.b r15 = (q9.b) Annie.getService$default(q9.b.class, null, 2, null);
        if (r15.isPermissionAllGranted(r11.getContext(), (String[]) Arrays.copyOf(r1, 2)) == false) goto L9;
        j(r12, r0);
        return;
    L9:
        if (this.a != null) goto L11;
        r14 = new k(this, r12, r0);
    L11:
        int r16 = f.a;
        Activity r17 = f.a(r11.getContext());
        if (r17 == null) goto L17;
        r15.n(r17, this.a, r14, (String[]) Arrays.copyOf(r1, 2));
        return;
    }

    public final void j(f0 r10, ContentResolver r11) {
        Single.fromCallable(new c(this, r10, r11)).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new d(this, r10, r11), e.a);
    }
}
