package com.larus.drive.biz.impl.file;

import android.os.Handler;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.keva.Keva;
import com.larus.drive.biz.api.model.DriveUploadStatus;
import com.larus.drive.biz.impl.sdk.DriveSdkService;
import com.larus.utils.logger.FLogger;
import hq9.c2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class t {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final MutableLiveData f = null;
    public static final AtomicBoolean g = null;
    public static final Lazy h = null;
    public static boolean i;

    public static final class a implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public a(r r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    public t() {
    }

    static {
        Lazy r0 = LazyKt.lazy(new j());
        a = r0;
        b = LazyKt.lazy(new k());
        c = LazyKt.lazy(new l());
        d = LazyKt.lazy(new m());
        e = LazyKt.lazy(new n());
        f = f();
        g = new AtomicBoolean(false);
        ((Handler) r0.getValue()).post(new o());
        h = LazyKt.lazy(new p());
    }

    public static Keva c() {
        return (Keva) c.getValue();
    }

    public static CopyOnWriteArrayList d() {
        return (CopyOnWriteArrayList) h.getValue();
    }

    public static List e() {
        return (List) d.getValue();
    }

    public static MutableLiveData f() {
        return (MutableLiveData) e.getValue();
    }

    public static void b() {
        Map r0 = (Map) f().getValue();
        if (r0 == null) goto L11;
        Collection r1 = r0.values();
        if (r1 == null) goto L11;
        Collection r2 = r1;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r4 = r2.iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        r3.add(((com.larus.drive.biz.api.model.a) r4.next()).b);
        goto L8
    L10:
        DriveSdkService.a.S(r3);
    L11:
        Map r5 = (Map) f().getValue();
        if (r5 == null) goto L14;
        r5.clear();
    L14:
        f().postValue(f().getValue());
        g((Map) f().getValue());
        c().clear();
        e().clear();
        c().storeStringArray("drive_upload_order_keys", new String[0]);
    }

    public static boolean i() {
        Map r0 = (Map) f().getValue();
        if (r0 == null) goto L5;
        int r1 = r0.size();
    L7:
        if (r1 < ((c2) b.getValue()).j()) goto L10;
        return true;
    L10:
        return false;
    L5:
        r1 = 0;
        goto L7
    }

    public static final void a(com.larus.drive.biz.api.model.a r2) {
        if (k(r2, false) == true) goto L9;
        Map r0 = (Map) f().getValue();
        if (r0 == null) goto L7;
        com.larus.drive.biz.api.model.a r3 = (com.larus.drive.biz.api.model.a) r0.put(r2.a, r2);
    L7:
        f().postValue(f().getValue());
        g((Map) f().getValue());
        return;
    }

    public static void g(Map r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.isEmpty() == true) goto L27;
        Collection r5 = r4.values();
        if ((r5 instanceof Collection) == true) goto L9;
    L11:
        Iterator r6 = r5.iterator();
    L13:
        if (r6.hasNext() == false) goto L20;
        if (((com.larus.drive.biz.api.model.a) r6.next()).f == DriveUploadStatus.FINISH) goto L17;
        boolean r0 = true;
    L18:
        if (r0 == false) goto L13;
        boolean r7 = false;
    L21:
        if (r7 == false) goto L27;
        if (i == false) goto L25;
        return;
    L25:
        i = true;
        ((Handler) a.getValue()).postDelayed(new q(), 3000);
        return;
    L17:
        r0 = false;
    L20:
        r7 = true;
        goto L21
    L9:
        if (r5.isEmpty() == false) goto L11;
    L27:
        if (i == false) goto L36;
        i = false;
        ((Handler) a.getValue()).removeCallbacksAndMessages(null);
        return;
    }

    public static boolean h(int r2) {
        Map r0 = (Map) f().getValue();
        if (r0 == null) goto L5;
        int r1 = r0.size();
    L7:
        if ((r1 + r2) > ((c2) b.getValue()).j()) goto L10;
        return true;
    L10:
        return false;
    L5:
        r1 = 0;
        goto L7
    }

    public static void j(com.larus.drive.biz.api.model.a r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "item");
        DriveUploadStatus r1 = DriveUploadStatus.UNSTARTED;
        List r0 = CollectionsKt.mutableListOf(new DriveUploadStatus[]{DriveUploadStatus.UPLOADING, r1});
        if (r7 == true) goto L6;
        r0.add(DriveUploadStatus.FAILED);
    L6:
        if (r0.contains(r6.f) == true) goto L8;
        return;
    L8:
        String r8 = DriveSdkService.a.I(r6.b, new s());
        FLogger.a.i("DriveUploadManager", "resumeUpload itemId = " + r6.a + ", taskId = " + r6.b + ", newTaskId = " + r8);
        if (r8 != null) goto L11;
    L14:
        boolean r2 = true;
    L15:
        if (r2 == true) goto L17;
        com.larus.drive.biz.api.model.a r9 = r6.a();
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r9.b = r8;
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r9.f = r1;
        k(r9, false);
        return;
    L17:
        k(r6, true);
        return;
    L11:
        if (StringsKt.isBlank(r8) == true) goto L14;
        r2 = false;
        goto L15
    }

    public static boolean k(com.larus.drive.biz.api.model.a r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "item");
        Map r0 = (Map) f().getValue();
        DriveUploadStatus r1 = null;
        if (r0 == null) goto L5;
        com.larus.drive.biz.api.model.a r2 = (com.larus.drive.biz.api.model.a) r0.get(r9.a);
    L6:
        if (r2 == null) goto L9;
        r1 = r2.f;
    L9:
        if (r1 != r9.f) goto L15;
        if (r10 == true) goto L15;
        if (Intrinsics.areEqual(r2.b, r9.b) == false) goto L15;
        return false;
    L15:
        if (r10 == false) goto L25;
        if (r2 == null) goto L47;
        c().erase(r9.a);
        Map r11 = (Map) f().getValue();
        if (r11 == null) goto L21;
        com.larus.drive.biz.api.model.a r12 = (com.larus.drive.biz.api.model.a) r11.remove(r9.a);
    L21:
        if (e().remove(r9.a) == false) goto L23;
        c().storeStringArray("drive_upload_order_keys", (String[]) e().toArray(new String[0]));
    L23:
        f().getValue();
        f().postValue(f().getValue());
        g((Map) f().getValue());
        DriveSdkService.a.S(CollectionsKt.listOf(r9.b));
        return true;
    L47:
        return false;
    L25:
        Keva r13 = c();
        String r4 = r9.a;
        JSONObject r5 = new JSONObject();
        r5.put("item_id", r9.a);
        r5.put("task_id", r9.b);
        r5.put("file_name", r9.c);
        r5.put("file_type", r9.d.getValue());
        r5.put("parent_drive_token", r9.e);
        r5.put("status", r9.f.getValue());
        Integer r6 = r9.g;
        if (r6 == null) goto L28;
        r5.put("error_tip_res_id", r6.intValue());
    L28:
        Long r7 = r9.h;
        if (r7 == null) goto L31;
        r5.put("bytes_total", r7.longValue());
    L31:
        Long r8 = r9.i;
        if (r8 == null) goto L34;
        r5.put("bytes_transferred", r8.longValue());
    L34:
        r5.put("event_params", r9.j);
        r13.storeString(r4, r5.toString());
        if (r2 != null) goto L37;
        boolean r14 = true;
    L38:
        Map r3 = (Map) f().getValue();
        if (r3 == null) goto L41;
        com.larus.drive.biz.api.model.a r15 = (com.larus.drive.biz.api.model.a) r3.put(r9.a, r9);
    L41:
        if (r14 == true) goto L43;
    L45:
        f().postValue(f().getValue());
        g((Map) f().getValue());
        return true;
    L43:
        if (e().contains(r9.a) == true) goto L45;
        e().add(r9.a);
        c().storeStringArray("drive_upload_order_keys", (String[]) e().toArray(new String[0]));
        goto L45
    L37:
        r14 = false;
        goto L38
    L5:
        r2 = null;
        goto L6
    }
}
