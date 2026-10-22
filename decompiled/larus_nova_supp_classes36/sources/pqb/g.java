package pqb;

import android.content.Intent;
import android.os.Bundle;
import com.ss.alog.middleware.ALogService;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g extends ALogService {
    public static final a a = null;

    public static final class a {
        public a() {
        }
    }

    static {
        a = new a();
    }

    public final void bundle(int r1, String r2, Bundle r3) {
    }

    public final void changeLevel(int r1) {
    }

    public final void destroy() {
    }

    public final void flush() {
    }

    public final void forceLogSharding() {
    }

    public final void header(int r1, String r2, String r3) {
    }

    public final void init() {
    }

    public final void init(String r1) {
    }

    public final void intent(int r1, String r2, Intent r3) {
    }

    public final void json(int r1, String r2, String r3) {
    }

    public final void release() {
    }

    public final void statcktrace(int r1, String r2, StackTraceElement[] r3) {
    }

    public final void thread(int r1, String r2, Thread r3) {
    }

    public final void throwable(int r1, String r2, Throwable r3) {
    }

    public g() {
    }

    public static final /* synthetic */ ALogService a() {
        return ALogService.sInstance;
    }

    public final void d(String r1, String r2) {
        Log.d(r1, r2);
    }

    public final void e(String r1, String r2) {
        Log.e(r1, r2);
    }

    public final void i(String r1, String r2) {
        Log.i(r1, r2);
    }

    public final void v(String r1, String r2) {
        Log.v(r1, r2);
    }

    public final void w(String r1, String r2) {
        Log.w(r1, r2);
    }

    public final void e(String r1, Throwable r2) {
        Log.e(r1, r2);
    }

    public final void w(String r1, Throwable r2) {
        Log.w(r1, r2);
    }

    public final void e(String r1, String r2, Throwable r3) {
        Log.e(r1, r2, r3);
    }

    public final void w(String r1, String r2, Throwable r3) {
        Log.w(r1, r2, r3);
    }
}
