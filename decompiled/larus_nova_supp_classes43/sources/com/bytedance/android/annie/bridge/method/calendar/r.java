package com.bytedance.android.annie.bridge.method.calendar;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.CalendarContract;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.method.abs.ReadCalendarEventResultModel;
import com.bytedance.android.annie.log.LogLevel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import e7.q0;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "readCalendarEvent")
public final class r extends e7.s<q0, ReadCalendarEventResultModel> {
    public final com.bytedance.android.annie.container.fragment.q a;
    public q0 b;
    public ContentResolver c;

    public static final class a implements com.bytedance.android.annie.bridge.method.permission.b {
        public final /* synthetic */ r a;

        public a(r r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.annie.bridge.method.permission.b
        public final void onRequestPermissionsResult(int r1, String[] r10, int[] r11) {
            Intrinsics.checkNotNullParameter(r10, "permissions");
            Intrinsics.checkNotNullParameter(r11, "grantResults");
            if (com.bytedance.android.annie.bridge.method.permission.c.h(r11) == false) goto L10;
            r r12 = this.a;
            q0 r13 = r12.b;
            if (r13 != null) goto L7;
        L9:
            ReadCalendarEventResultModel r14 = new ReadCalendarEventResultModel();
            r14.b(ReadCalendarEventResultModel.Code.Failed);
            r14.e("read calendar failed");
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
            r r16 = this.a;
            ReadCalendarEventResultModel r17 = new ReadCalendarEventResultModel();
            r17.b(ReadCalendarEventResultModel.Code.NoPermission);
            r17.e("user denied permission");
            r16.finishWithResult(r17);
        }
    }

    public static final class b {
    }

    public static final class c<V> implements Callable {
        public final /* synthetic */ q0 a;
        public final /* synthetic */ ContentResolver b;

        public c(q0 r1, ContentResolver r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // java.util.concurrent.Callable
        public final ReadCalendarEventResultModel call() {
            int r0 = com.bytedance.android.annie.bridge.method.calendar.c.a;
            q0 r1 = this.a;
            ContentResolver r10 = this.b;
            Intrinsics.checkNotNullParameter(r1, "param");
            Intrinsics.checkNotNullParameter(r10, "contentResolver");
            ReadCalendarEventResultModel r11 = null;
            if (r1.getIdentifier() == null) goto L34;
            Cursor r12 = com.bytedance.android.annie.bridge.method.calendar.c.a(r10, CalendarContract.Events.CONTENT_URI, new String[]{"_id", "sync_data1", "dtstart", "dtend", "title", "description", "eventLocation", "sync_data3", "lastDate"}, "sync_data1=?", new String[]{r1.getIdentifier()});
            if (r12 == null) goto L33;
            Cursor r13 = r12;
            Cursor r14 = r13;     // Catch: Throwable -> L28
            if (r14.getCount() > 0) goto L13;
            r1.getIdentifier();     // Catch: Throwable -> L28
            CloseableKt.closeFinally(r13, null);
            goto L34
        L13:
            if (r14.moveToNext() == false) goto L26;
            ReadCalendarEventResultModel r15 = new ReadCalendarEventResultModel();     // Catch: Throwable -> L28
            r15.b(ReadCalendarEventResultModel.Code.Success);     // Catch: Throwable -> L28
            r15.e("read success");     // Catch: Throwable -> L28
            Integer r16 = com.bytedance.android.annie.bridge.method.calendar.c.b(r14.getLong(0), r10);     // Catch: Throwable -> L28
            if (r16 == null) goto L17;
            r15.a(Integer.valueOf(r16.intValue() * 60000));     // Catch: Throwable -> L28
        L17:
            r15.g(Long.valueOf(r14.getLong(2)));     // Catch: Throwable -> L28
            long r17 = r14.getLong(3);     // Catch: Throwable -> L28
            long r18 = r14.getLong(8);     // Catch: Throwable -> L28
            if (r17 == 0) goto L21;
        L24:
            r15.c(Long.valueOf(r17));     // Catch: Throwable -> L28
            r15.h(r14.getString(4));     // Catch: Throwable -> L28
            r15.f(r14.getString(5));     // Catch: Throwable -> L28
            r15.d(r14.getString(6));     // Catch: Throwable -> L28
            r15.i(r14.getString(7));     // Catch: Throwable -> L28
        L27:
            CloseableKt.closeFinally(r13, null);
            r11 = r15;
            goto L34
        L21:
            if (r18 == 0) goto L23;
            r17 = r18;
            goto L24
        L23:
            r17 = 0;
            goto L24
        L26:
            r15 = null;
        L28:
            th = move-exception;
            throw th;     // Catch: Throwable -> L30
        L30:
            th = move-exception;
            CloseableKt.closeFinally(r13, th);
            throw th;
        L33:
            b8.a r19 = b8.a.a;
            b8.a.a(new b8.b("[ReportALogMethod]", LogLevel.ERROR, null, "read calendar but meet an error. Please check.", 4), true);
        L34:
            if (r11 != null) goto L40;
            ReadCalendarEventResultModel r20 = new ReadCalendarEventResultModel();
            r20.b(ReadCalendarEventResultModel.Code.Failed);
            r20.e("read calendar but got a null.");
            return r20;
        L40:
            return r11;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ r a;

        public d(r r1) {
            this.a = r1;
        }

        public final void accept(Object r10) {
            r r0 = this.a;
            r0.finishWithResult((ReadCalendarEventResultModel) r10);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ r a;

        public e(r r1) {
            this.a = r1;
        }

        public final void accept(Object r10) {
            r r0 = this.a;
            ReadCalendarEventResultModel r1 = new ReadCalendarEventResultModel();
            r1.b(ReadCalendarEventResultModel.Code.Failed);
            r1.e("read calendar with a failure operation. error msg = " + ((Throwable) r10).getMessage());
            r0.finishWithResult(r1);
        }
    }

    static {
    }

    public r(m16.b r10) {
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

    public r(com.bytedance.android.annie.container.fragment.q r10) {
        com.bytedance.android.annie.container.fragment.q r0 = this.a;
        if (r0 == null) goto L5;
        r0.registerOnRequestPermissionsCallBack(new a(this));
    L5:
        this.a = r10;
    }

    public final void invoke(Object r10, CallContext r11) {
        q0 r12 = (q0) r10;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        ContentResolver r0 = r11.getContext().getContentResolver();
        if (r0 != null) goto L5;
        ReadCalendarEventResultModel r13 = new ReadCalendarEventResultModel();
        r13.b(ReadCalendarEventResultModel.Code.Failed);
        r13.e("try to obtain contentResolver, but got a null");
        finishWithResult(r13);
        return;
    L5:
        this.b = r12;
        this.c = r0;
        s r14 = null;
        q9.b r1 = (q9.b) Annie.getService$default(q9.b.class, null, 2, null);
        if (r1.isPermissionAllGranted(r11.getContext(), new String[]{"android.permission.READ_CALENDAR"}) == false) goto L8;
        j(r12, r0);
        return;
    L8:
        int r15 = f.a;
        Activity r16 = f.a(r11.getContext());
        if (r16 == null) goto L17;
        com.bytedance.android.annie.container.fragment.q r17 = this.a;
        if (r17 != null) goto L13;
        r14 = new s(this, r12, r0);
    L13:
        r1.n(r16, r17, r14, new String[]{"android.permission.READ_CALENDAR"});
        return;
    }

    public final void j(q0 r10, ContentResolver r11) {
        Single.fromCallable(new c(r10, r11)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this), new e(this));
    }
}
