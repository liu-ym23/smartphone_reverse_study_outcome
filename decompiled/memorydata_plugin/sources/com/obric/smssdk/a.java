package com.obric.smssdk;

import android.database.Cursor;
import com.obric.a.a.f;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010!\u001a\u00020\u00062\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\"\u001a\u0004\u0018\u00010#J\"\u0010!\u001a\u00020\u00062\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020\u0006R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u0011\u0010\u0013\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\bR\u0011\u0010\u0015\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\bR\u0011\u0010\u0017\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\bR\u0011\u0010\u0019\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\bR\u0011\u0010\u001b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\bR\u0011\u0010\u001d\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\bR\u0011\u0010\u001f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b \u0010\b¨\u0006%"}, d2 = {"Lcom/obric/smssdk/SmsMmsColumnsMap;", "", "cursor", "Landroid/database/Cursor;", "(Landroid/database/Cursor;)V", "columnMmsContentType", "", "getColumnMmsContentType", "()I", "columnMmsDate", "getColumnMmsDate", "columnMmsMessageBox", "getColumnMmsMessageBox", "columnMmsMessageType", "getColumnMmsMessageType", "columnMmsTextOnly", "getColumnMmsTextOnly", "columnMsgId", "getColumnMsgId", "columnMsgType", "getColumnMsgType", "columnSmsAddress", "getColumnSmsAddress", "columnSmsBody", "getColumnSmsBody", "columnSmsDate", "getColumnSmsDate", "columnSmsDateSent", "getColumnSmsDateSent", "columnSmsType", "getColumnSmsType", "columnThreadId", "getColumnThreadId", "getColumnIndex", "columnName", "", "defaultIndex", "contactsdk_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f14974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f14975b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;
    private final int h;
    private final int i;
    private final int j;
    private final int k;
    private final int l;
    private final int m;

    public a(Cursor r4) {
        Cursor r5 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r4, Cursor.class, "com.obric.memorydata.plugin");
        this.f14974a = a(r5, "transport_type", -1);
        this.f14975b = a(r5, "thread_id", -1);
        this.c = a(r5, "_id", -1);
        this.d = a(r5, MemoryKeyInfoEntity.KEY_ADDRESS, -1);
        this.e = a(r5, "body", -1);
        this.f = a(r5, "date", -1);
        this.g = a(r5, "date_sent", -1);
        this.h = a(r5, "type", -1);
        this.i = a(r5, "date", -1);
        this.j = a(r5, "m_type", -1);
        this.k = a(r5, "msg_box", -1);
        this.l = a(r5, "text_only", -1);
        this.m = a(r5, "ct_t", -1);
    }

    public final int a() {
        return this.f14974a;
    }

    public final int a(Cursor r7, String r8, int r9) {
        Cursor r6 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r7, Cursor.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L13;
        return r6.getColumnIndexOrThrow(r8);
    L6:
        e = move-exception;
        String r2 = e.getMessage();
        if (r2 == null) goto L14;
        f.a(f.f5867a, "colsMap", r2, null, 4, null);
        return r9;
    L14:
        return r9;
    L13:
        return r9;
    }

    public final int b() {
        return this.f14975b;
    }

    public final int c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    public final int e() {
        return this.e;
    }

    public final int f() {
        return this.f;
    }

    public final int g() {
        return this.h;
    }

    public final int h() {
        return this.i;
    }

    public final int i() {
        return this.j;
    }

    public final int j() {
        return this.k;
    }
}
