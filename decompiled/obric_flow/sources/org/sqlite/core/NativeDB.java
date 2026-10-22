package org.sqlite.core;

import bv.d;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import org.sqlite.BusyHandler;
import org.sqlite.Function;
import org.sqlite.ProgressHandler;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeDB extends d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f21056h;

    static {
        if ("The Android Project".equals(System.getProperty("java.vm.vendor")) == false) goto L5;
        System.loadLibrary("sqlitejdbc");
        f21056h = true;
        return;
    L5:
        f21056h = false;
    }

    public static byte[] o(String r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        return r5.getBytes(StandardCharsets.UTF_8);
    }

    public static String p(ByteBuffer r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        byte[] r10 = new byte[r5.remaining()];
        r5.get(r10);
        return new String(r10, StandardCharsets.UTF_8);
    }

    public native synchronized void _close() throws SQLException;

    public native synchronized int _exec_utf8(byte[] r5) throws SQLException;

    public native synchronized void _open_utf8(byte[] r5, int r10) throws SQLException;

    @Override // bv.d
    public final synchronized String a(int r5, long r10) {
        monitor-enter(this);
        String r11 = p(column_name_utf8(r10, r5));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r11;
    L6:
        th = move-exception;
        throw th;
    }

    public native synchronized int backup(byte[] r5, byte[] r10, DB$ProgressObserver r11) throws SQLException;

    @Override // bv.d
    public native synchronized int bind_blob(long r5, int r10, byte[] r11);

    @Override // bv.d
    public native synchronized int bind_double(long r5, int r10, double r11);

    @Override // bv.d
    public native synchronized int bind_int(long r5, int r10, int r11);

    @Override // bv.d
    public native synchronized int bind_long(long r5, int r10, long r11);

    @Override // bv.d
    public native synchronized int bind_null(long r5, int r10);

    @Override // bv.d
    public native synchronized int bind_parameter_count(long r5);

    public native synchronized int bind_text_utf8(long r5, int r10, byte[] r11);

    public native synchronized void busy_handler(BusyHandler r5);

    public native synchronized void busy_timeout(int r5);

    @Override // bv.d
    public native synchronized int changes();

    public native synchronized int clear_bindings(long r5);

    public native synchronized void clear_progress_handler() throws SQLException;

    public native synchronized byte[] column_blob(long r5, int r10);

    @Override // bv.d
    public native synchronized int column_count(long r5);

    public native synchronized ByteBuffer column_decltype_utf8(long r5, int r10);

    public native synchronized double column_double(long r5, int r10);

    public native synchronized int column_int(long r5, int r10);

    public native synchronized long column_long(long r5, int r10);

    public native synchronized boolean[][] column_metadata(long r5);

    public native synchronized ByteBuffer column_name_utf8(long r5, int r10);

    public native synchronized ByteBuffer column_table_name_utf8(long r5, int r10);

    public native synchronized ByteBuffer column_text_utf8(long r5, int r10);

    public native synchronized int column_type(long r5, int r10);

    public native synchronized int create_function_utf8(byte[] r5, Function r10, int r11, int r12);

    public native synchronized int destroy_function_utf8(byte[] r5, int r10);

    public native synchronized int enable_load_extension(boolean r5);

    public native synchronized ByteBuffer errmsg_utf8();

    @Override // bv.d
    public native synchronized int finalize(long r5);

    public native synchronized void free_functions();

    public native void interrupt();

    @Override // bv.d
    public final synchronized long k(String r5) {
        monitor-enter(this);
        long r10 = prepare_utf8(o(r5));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public native ByteBuffer libversion_utf8();

    public native synchronized int limit(int r5, int r10) throws SQLException;

    public final synchronized String n(int r5, long r10) {
        monitor-enter(this);
        String r11 = p(column_text_utf8(r10, r5));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r11;
    L6:
        th = move-exception;
        throw th;
    }

    public native synchronized long prepare_utf8(byte[] r5) throws SQLException;

    public native synchronized void register_progress_handler(int r5, ProgressHandler r10) throws SQLException;

    @Override // bv.d
    public native synchronized int reset(long r5);

    public native synchronized int restore(byte[] r5, byte[] r10, DB$ProgressObserver r11) throws SQLException;

    public native synchronized void result_blob(long r5, byte[] r10);

    public native synchronized void result_double(long r5, double r10);

    public native synchronized void result_error_utf8(long r5, byte[] r10);

    public native synchronized void result_int(long r5, int r10);

    public native synchronized void result_long(long r5, long r10);

    public native synchronized void result_null(long r5);

    public native synchronized void result_text_utf8(long r5, byte[] r10);

    public native synchronized void set_commit_listener(boolean r5);

    public native synchronized void set_update_listener(boolean r5);

    public native synchronized int shared_cache(boolean r5);

    @Override // bv.d
    public native synchronized int step(long r5);

    public native synchronized int total_changes();

    public native synchronized byte[] value_blob(Function r5, int r10);

    public native synchronized double value_double(Function r5, int r10);

    public native synchronized int value_int(Function r5, int r10);

    public native synchronized long value_long(Function r5, int r10);

    public native synchronized ByteBuffer value_text_utf8(Function r5, int r10);

    public native synchronized int value_type(Function r5, int r10);
}
