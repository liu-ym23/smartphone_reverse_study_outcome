package com.bytedance.android.annie.bridge.method.calendar;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.method.abs.DeleteCalendarEventResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import e7.g0;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Arrays;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast", name = "deleteCalendarEvent")
public final class o extends e7.f<g0, DeleteCalendarEventResultModel> {
    public final com.bytedance.android.annie.container.fragment.q a;
    public g0 b;
    public ContentResolver c;

    public static final class a implements com.bytedance.android.annie.bridge.method.permission.b {
        public final /* synthetic */ o a;

        public a(o r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.annie.bridge.method.permission.b
        public final void onRequestPermissionsResult(int r1, String[] r10, int[] r11) {
            Intrinsics.checkNotNullParameter(r10, "permissions");
            Intrinsics.checkNotNullParameter(r11, "grantResults");
            if (com.bytedance.android.annie.bridge.method.permission.c.h(r11) == false) goto L10;
            o r12 = this.a;
            g0 r13 = r12.b;
            if (r13 != null) goto L7;
        L9:
            DeleteCalendarEventResultModel r14 = new DeleteCalendarEventResultModel();
            r14.a(DeleteCalendarEventResultModel.Code.Failed);
            r14.b("delete failed.");
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
            o r16 = this.a;
            DeleteCalendarEventResultModel r17 = new DeleteCalendarEventResultModel();
            r17.a(DeleteCalendarEventResultModel.Code.NoPermission);
            r17.b("user denied permission");
            r16.finishWithResult(r17);
        }
    }

    public static final class b {
    }

    public static final class c<V> implements Callable {
        public final /* synthetic */ g0 a;
        public final /* synthetic */ ContentResolver b;

        public c(g0 r1, ContentResolver r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // java.util.concurrent.Callable
        public final DeleteCalendarEventResultModel.Code call() {
            int r1 = com.bytedance.android.annie.bridge.method.calendar.d.a;
            g0 r10 = this.a;
            ContentResolver r11 = this.b;
            Intrinsics.checkNotNullParameter(r10, "params");
            Intrinsics.checkNotNullParameter(r11, "contentResolver");
            String[] r12 = {"_id"};
            String[] r14 = {r10.getIdentifier()};
            Uri r16 = CalendarContract.Events.CONTENT_URI;
            f06.c r17 = new f06.c();
            Object[] r13 = {r16, r12, "sync_data1=?", r14, null};
            f06.b r18 = new f06.b();
            f06.d r15 = r17.b(240004, "android/content/ContentResolver", "query", r11, r13, "android.database.Cursor", r18);
            if (r15.a == false) goto L5;
            r17.a(240004, "android/content/ContentResolver", "query", r11, r13, null, r18, false);
            Cursor r19 = (Cursor) r15.b;
        L6:
            if (r19 != null) goto L9;
            r10.getIdentifier();
            return DeleteCalendarEventResultModel.Code.Failed;
        L9:
            if (r19.moveToNext() == false) goto L14;
            long r20 = r19.getLong(0);
            com.bytedance.android.annie.bridge.method.calendar.d.a(r11, CalendarContract.Reminders.CONTENT_URI, "event_id=?", new String[]{String.valueOf(r20)});
            if (com.bytedance.android.annie.bridge.method.calendar.d.a(r11, CalendarContract.Events.CONTENT_URI, "sync_data1=?", r14) <= 0) goto L18;
            return DeleteCalendarEventResultModel.Code.Success;
        L18:
            return DeleteCalendarEventResultModel.Code.Failed;
        L14:
            r10.getIdentifier();
            return DeleteCalendarEventResultModel.Code.Failed;
        L5:
            Cursor r110 = r11.query(r16, r12, "sync_data1=?", r14, null);
            r17.a(240004, "android/content/ContentResolver", "query", r11, r13, r110, r18, true);
            r19 = r110;
            goto L6
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ o a;

        public d(o r1) {
            this.a = r1;
        }

        public final void accept(Object r10) {
            DeleteCalendarEventResultModel.Code r11 = (DeleteCalendarEventResultModel.Code) r10;
            DeleteCalendarEventResultModel.Code r0 = DeleteCalendarEventResultModel.Code.Success;
            if (r11 != r0) goto L5;
            o r12 = this.a;
            DeleteCalendarEventResultModel r1 = new DeleteCalendarEventResultModel();
            r1.a(r0);
            r1.b("delete Success");
            r12.finishWithResult(r1);
            return;
        L5:
            o r13 = this.a;
            DeleteCalendarEventResultModel r14 = new DeleteCalendarEventResultModel();
            r14.a(DeleteCalendarEventResultModel.Code.Failed);
            r14.b("delete failed.");
            r13.finishWithResult(r14);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ o a;
        public final /* synthetic */ g0 b;

        public e(o r1, g0 r10) {
            this.a = r1;
            this.b = r10;
        }

        public final void accept(Object r10) {
            o r0 = this.a;
            DeleteCalendarEventResultModel r1 = new DeleteCalendarEventResultModel();
            g0 r11 = this.b;
            r1.a(DeleteCalendarEventResultModel.Code.Failed);
            r1.b("delete calendar with unknown failure. id = " + r11.getIdentifier() + " , error msg = " + ((Throwable) r10).getMessage());
            r0.finishWithResult(r1);
        }
    }

    static {
    }

    public o(m16.b r10) {
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

    public o(com.bytedance.android.annie.container.fragment.q r10) {
        com.bytedance.android.annie.container.fragment.q r0 = this.a;
        if (r0 == null) goto L5;
        r0.registerOnRequestPermissionsCallBack(new a(this));
    L5:
        this.a = r10;
    }

    public final void invoke(Object r10, CallContext r11) {
        g0 r12 = (g0) r10;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        ContentResolver r0 = r11.getContext().getContentResolver();
        if (r0 != null) goto L5;
        DeleteCalendarEventResultModel r13 = new DeleteCalendarEventResultModel();
        r13.a(DeleteCalendarEventResultModel.Code.Failed);
        r13.b("try to obtain contentResolver, but got a null");
        finishWithResult(r13);
        return;
    L5:
        this.b = r12;
        this.c = r0;
        String[] r1 = {"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"};
        p r14 = null;
        q9.b r15 = (q9.b) Annie.getService$default(q9.b.class, null, 2, null);
        if (r15.isPermissionAllGranted(r11.getContext(), (String[]) Arrays.copyOf(r1, 2)) == false) goto L8;
        j(r12, r0);
        return;
    L8:
        int r16 = f.a;
        Activity r17 = f.a(r11.getContext());
        if (r17 == null) goto L17;
        com.bytedance.android.annie.container.fragment.q r18 = this.a;
        if (r18 != null) goto L13;
        r14 = new p(this, r12, r0);
    L13:
        r15.n(r17, r18, r14, (String[]) Arrays.copyOf(r1, 2));
        return;
    }

    public final void j(g0 r10, ContentResolver r11) {
        Single.fromCallable(new c(r10, r11)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this), new e(this, r10));
    }
}
