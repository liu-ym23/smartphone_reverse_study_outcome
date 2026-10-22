package com.bytedance.android.live.broadcastgame.opengame.control.report;

import android.graphics.Bitmap;
import android.util.LruCache;
import com.bytedance.android.live.broadcastgame.opengame.network.GameReportApi;
import com.bytedance.android.live.broadcastgame.opengame.network.LiveOpenGameClient;
import com.bytedance.android.live.broadcastgame.opengame.network.o0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.common.utility.DigestUtils;
import com.bytedance.retrofit2.mime.MultipartTypedOutput;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedOutput;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class ReportPicUploader {
    public static LruCache<String, byte[]> a;
    public static final Lazy b = null;
    public static final HashMap<String, a> c = null;
    public static volatile String d;
    public static volatile String e;
    public static final String f = null;

    public static final class a {
        public final String a;
        public final String b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L10;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "ViolateBlackData(reason=" + this.a + ", gameCategory=" + this.b + ")";
        }

        public a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "reason");
            Intrinsics.checkNotNullParameter(r3, "gameCategory");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b<T> implements ObservableOnSubscribe {
        public final /* synthetic */ Bitmap a;

        public b(Bitmap r1) {
            this.a = r1;
        }

        public final void subscribe(ObservableEmitter<Unit> r5) {
            Intrinsics.checkNotNullParameter(r5, "it");
            ByteArrayOutputStream r6 = new ByteArrayOutputStream();
            this.a.compress(Bitmap.CompressFormat.JPEG, 80, r6);
            byte[] r7 = r6.toByteArray();
            String r0 = DigestUtils.md5Hex(r7);
            LruCache<String, byte[]> r1 = ReportPicUploader.a;
            ReportPicUploader.e = r0;
            String r2 = ReportPicUploader.f;
            ALogger.i(r2, "videoBitmapShotWhenReport before insert cache all md5 = " + ReportPicUploader.a(ReportPicUploader.d()));
            ALogger.i(r2, "videoBitmapShotWhenReport md5 = " + r0);
            ReportPicUploader.d().put(r0, r7);
            ALogger.i(r2, "videoBitmapShotWhenReport after insert cache all md5 =" + ReportPicUploader.a(ReportPicUploader.d()));
            this.a.recycle();
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ HashMap a;
        public final /* synthetic */ Map.Entry b;
        public final /* synthetic */ AtomicInteger c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;

        public c(HashMap r1, Map.Entry r2, AtomicInteger r3, String r4, String r5, String r6, String r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }

        public final void accept(Object r5) {
            this.a.put(this.b.getKey(), ((o0) r5).oid);
            this.c.getAndDecrement();
            if (this.c.get() != 0) goto L6;
            LruCache<String, byte[]> r6 = ReportPicUploader.a;
            ReportPicUploader.b(this.d, this.e, this.f, this.a, this.g);
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ AtomicInteger a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ HashMap e;
        public final /* synthetic */ String f;

        public d(AtomicInteger r1, String r2, String r3, String r4, HashMap r5, String r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }

        public final void accept(Object r5) {
            Throwable r6 = (Throwable) r5;
            this.a.getAndDecrement();
            if (this.a.get() != 0) goto L6;
            LruCache<String, byte[]> r7 = ReportPicUploader.a;
            ReportPicUploader.b(this.b, this.c, this.d, this.e, this.f);
            return;
        }
    }

    public ReportPicUploader() {
    }

    public static HashMap d() {
        return (HashMap) b.getValue();
    }

    static {
        a = new LruCache(5);
        b = LazyKt.lazy(ReportPicUploader$uploadMap$2.INSTANCE);
        c = new HashMap();
        d = "";
        e = "";
        f = "Upload";
    }

    public static final String a(Map r2) {
        StringBuilder r0 = new StringBuilder();
        Iterator r3 = r2.entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L7;
        r0.append((String) ((Map.Entry) r3.next()).getKey());
        r0.append(",");
        goto L4
    L7:
        if (r0.length() <= 0) goto L10;
        r0.deleteCharAt(r0.length() - 1);
    L10:
        return r0.toString();
    }

    public static void c(Bitmap r2) {
        Intrinsics.checkNotNullParameter(r2, "bitmap");
        d().remove(e);
        e = "";
        Observable.create(new b(r2)).subscribeOn(Schedulers.io()).subscribe();
    }

    public static void e(String r17, String r18) {
        Intrinsics.checkNotNullParameter(r17, "reportId");
        Intrinsics.checkNotNullParameter(r18, "roomId");
        HashMap r0 = new HashMap();
        r0.putAll(d());
        String r11 = d;
        String r12 = e;
        AtomicInteger r13 = new AtomicInteger(r0.size());
        HashMap r14 = new HashMap();
        Iterator r1 = r0.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry r3 = (Map.Entry) r1.next();
        TypedOutput r2 = new MultipartTypedOutput();
        r2.addPart("data", new TypedByteArray("image/jpeg", (byte[]) r3.getValue(), new String[]{System.currentTimeMillis() + ".jpg"}));
        Lazy r4 = LiveOpenGameClient.d;
        ((GameReportApi) LiveOpenGameClient.a.a().a(GameReportApi.class)).uploadImg(r2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(r14, r3, r13, r17, r11, r12, r18), new d(r13, r17, r11, r12, r14, r18));
        r1 = r1;
        goto L4
    }

    public static final void b(String r4, String r5, String r6, HashMap r7, String r8) {
        if (r7.isEmpty() == true) goto L26;
        JSONArray r0 = new JSONArray();
        JSONArray r1 = new JSONArray();
        Iterator r9 = r7.entrySet().iterator();
    L7:
        if (r9.hasNext() == false) goto L15;
        Map.Entry r2 = (Map.Entry) r9.next();
        if (Intrinsics.areEqual(r5, (String) r2.getKey()) == true) goto L10;
        if (Intrinsics.areEqual(r6, (String) r2.getKey()) == true) goto L13;
        r0.put(r2.getValue());
        goto L7
    L13:
        r1.put(r2.getValue());
        goto L7
    L10:
        r1.put(r2.getValue());
        r0.put(r2.getValue());
        goto L7
    L15:
        Lazy r11 = LiveOpenGameClient.d;
        ((GameReportApi) LiveOpenGameClient.a.a().a(GameReportApi.class)).submitReportExtraInfoRequest(r4, r0.toString(), r1.toString(), r8).subscribe(com.bytedance.android.live.broadcastgame.opengame.control.report.a.a, com.bytedance.android.live.broadcastgame.opengame.control.report.b.a);
        return;
    }
}
