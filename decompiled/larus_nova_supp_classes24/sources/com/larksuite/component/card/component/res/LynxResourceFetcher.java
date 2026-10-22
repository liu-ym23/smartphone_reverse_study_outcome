package com.larksuite.component.card.component.res;

import android.text.TextUtils;
import androidx.collection.LruCache;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SendHttpRequest;
import com.bytedance.lark.pb.basic.v1.SendHttpResponse;
import com.larksuite.component.card.utils.k;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.utils.s;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.storage.d;
import com.ss.android.lark.storage.f;
import com.ss.android.lark.vfs.VFSPath;
import com.suite.lark.platform.component.storage.file.LarkFileStorage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okio.Okio;
import znc.i;
import znc.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class LynxResourceFetcher {
    public static final LruCache<String, byte[]> a = null;
    public static final VFSPath b = null;
    public static final m c = null;
    public static final ConcurrentHashMap<String, String> d = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/larksuite/component/card/component/res/LynxResourceFetcher$LoadError;", "", "message", "", "code", "", "<init>", "(Ljava/lang/String;I)V", "getMessage", "()Ljava/lang/String;", "getCode", "()I", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class LoadError extends Throwable {
        private final int code;
        private final String message;

        public final int getCode() {
            return this.code;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }

        public LoadError(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "message");
            super(r2);
            this.message = r2;
            this.code = r3;
        }
    }

    public static final class a {
        public static void a(String r3) {
            Intrinsics.checkNotNullParameter(r3, "key");
            Log.i("LynxResourceFetcher", "acquiring lock " + r3);
            ConcurrentHashMap<String, String> r0 = LynxResourceFetcher.d;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (r0.get(r3) != null) goto L7;
            r0.put(r3, r3 + "_lock");     // Catch: Throwable -> L10
        L7:
            Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L10
            monitor-exit(r0);
        }

        public static void b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Log.i("LynxResourceFetcher", "release lock ".concat(r2));
            ConcurrentHashMap<String, String> r0 = LynxResourceFetcher.d;
            monitor-enter(r0);
            String r3 = r0.remove(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public LynxResourceFetcher() {
    }

    static {
        a = new LruCache(2);
        VFSPath r0 = LarkFileStorage.b().b(f.d, new d(new String[]{"open_platform", "card_resources_cache"}));
        b = r0;
        m.a r1 = new m.a();
        r1.a(r0.getAbsolutePath());
        c = new m(r1);
        d = new ConcurrentHashMap();
    }

    public static byte[] a(String r8) throws IOException {
        LruCache<String, byte[]> r0 = a;
        byte[] r1 = (byte[]) r0.get(r8);
        if (r1 == null) goto L6;
        Log.i("LynxResourceFetcher", "find file in memory ".concat(r8));
        return r1;
    L6:
        String r2 = s.b(r8);
        m r3 = c;
        File r4 = r3.a(r2);
        if (r4 == null) goto L23;
        Log.i("LynxResourceFetcher", "find file in disk ".concat(r8));
        byte[] r5 = Okio.buffer(Okio.source(r4)).readByteArray();
        ComponentISettings r6 = (ComponentISettings) SettingManager.getInstance().get(ComponentISettings.class);
        if (r6 == null) goto L15;
        HashMap<String, ComponentISettings.a> r7 = r6.getComponents();
        if (r7 == null) goto L15;
        ComponentISettings.a r9 = r7.get(r8);
        if (r9 == null) goto L15;
        String r10 = r9.a();
    L17:
        if (k.b(r10) == true) goto L19;
    L21:
        Log.i("LynxResourceFetcher", "check md5 succeeded");
        r0.put(r8, r5);
        return r5;
    L19:
        if (c(r5, r10) == true) goto L21;
        Log.e("LynxResourceFetcher", "check md5 failed");
        r3.remove(r2);
        return null;
    L15:
        r10 = null;
        goto L17
    L23:
        Log.e("LynxResourceFetcher", "cant find file in disk ".concat(r8));
        return null;
    }

    public static Object b(String r7) {
        ComponentISettings r0 = (ComponentISettings) SettingManager.getInstance().get(ComponentISettings.class);
        if (r0 == null) goto L7;
        HashMap<String, ComponentISettings.a> r1 = r0.getComponents();
        if (r1 == null) goto L7;
        ComponentISettings.a r2 = r1.get(r7);
    L8:
        if (r2 == null) goto L39;
        String r3 = r2.b();
        if (k.b(r3) == false) goto L38;
        SdkSender.d r4 = SdkSender.syncSendMayError(Command.SEND_HTTP, new SendHttpRequest.Builder().method(SendHttpRequest.Method.GET).timeout(60).url(r3), com.larksuite.component.card.component.res.a.a);
        if (r4.b == null) goto L14;
        Log.e("LynxResourceFetcher", "fetchNetworkRes error: " + r4.b + ' ' + r3);
        Result.Companion r8 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new LoadError(r4.b.toString(), 101)));
    L14:
        int r5 = ((SendHttpResponse) r4.a).http_status_code.intValue();
        if (200 <= r5) goto L17;
    L19:
        boolean r6 = false;
    L20:
        if (r6 == false) goto L37;
        Log.i("LynxResourceFetcher", "fetchNetworkRes success: " + r3);
        byte[] r9 = ((SendHttpResponse) r4.a).body.toByteArray();
        if (c(r9, r2.a()) == false) goto L36;
        Log.i("LynxResourceFetcher", "download file check success ".concat(r7));
        a.put(r7, r9);
        m r10 = c;
        monitor-enter(r10);
        String r11 = s.b(r7);     // Catch: Throwable -> L27 Exception -> L29
        ByteArrayInputStream r12 = new ByteArrayInputStream(r9);     // Catch: Throwable -> L27 Exception -> L29
        Intrinsics.checkNotNullParameter(r10, "<this>");     // Catch: Throwable -> L27 Exception -> L29
        Intrinsics.checkNotNullParameter(r11, "key");     // Catch: Throwable -> L27 Exception -> L29
        Intrinsics.checkNotNullParameter(r12, "inputStream");     // Catch: Throwable -> L27 Exception -> L29
        r10.d(r11, new i(r12));     // Catch: Throwable -> L27 Exception -> L29
        r10.flush();     // Catch: Throwable -> L27 Exception -> L29
    L31:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L27
        monitor-exit(r10);
        return Result.constructor-impl(r9);
    L29:
        e = move-exception;
        Log.e("LynxResourceFetcher", "save file to disk failed " + e);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    L36:
        Log.e("LynxResourceFetcher", "download file not correct ".concat(r7));
        Result.Companion r14 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new LoadError("md5 check error " + r3, 102)));
    L37:
        Log.e("LynxResourceFetcher", "download file error " + ((SendHttpResponse) r4.a).http_status_code);
        Result.Companion r15 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new LoadError("download error " + ((SendHttpResponse) r4.a).http_status_code, 103)));
    L17:
        if (r5 >= 300) goto L19;
        r6 = true;
        goto L20
    L38:
        Log.e("LynxResourceFetcher", "settings error2");
        Result.Companion r16 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new LoadError("find  " + r7 + " url in settings error", 104)));
    L39:
        Log.e("LynxResourceFetcher", "file " + r7 + " not in settings");
        Result.Companion r17 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new LoadError("path " + r7 + " not in settings", 100)));
    L7:
        r2 = null;
        goto L8
    }

    public static boolean c(byte[] r2, String r3) {
        String r4 = s.a(r2);
        if (TextUtils.equals(r3, r4) == true) goto L5;
        Log.e("LynxResourceFetcher", "file md5 " + r4 + ", setting md5 " + r3);
        return false;
    L5:
        return true;
    }
}
